package com.baidu.tieba.ala.personcenter.b;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.a.c;
import com.baidu.tieba.ala.personcenter.c.b;
import com.baidu.tieba.ala.personcenter.c.d;
import com.baidu.tieba.ala.personcenter.c.f;
import com.baidu.tieba.ala.personcenter.c.i;
import com.baidu.tieba.ala.personcenter.c.j;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext ceu;
    private g dDz;
    private int dQz;
    private NoNetworkView dvR;
    private AlaPersonCenterModel ewI;
    private b ewJ;
    private c ewK;
    private BdTypeListView ewL;
    private ImageView ewM;
    private TextView ewN;
    private boolean ewO;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean dQy = true;
    private boolean dBI = false;
    private CustomMessageListener ewP = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ewI != null) {
                a.this.ewI.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.dQz = 0;
        this.ewO = false;
        this.ceu = tbPageContext;
        this.ewO = z;
        this.dQz = (int) this.ceu.getResources().getDimension(R.dimen.ds400);
        this.ewI = new AlaPersonCenterModel(tbPageContext);
        this.ewI.a(this);
        dn(tbPageContext.getPageActivity());
    }

    private void aJl() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.ceu.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.ceu.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.ceu.getResources().getString(R.string.recommend_pb_no_net_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.dBI) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.dBI = true;
    }

    private void aJm() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.dBI = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void dn(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.ewO) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.ceu.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.ewM = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.ewO) {
            this.ewN = this.mNavigationBar.setCenterTextTitle(this.ceu.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.ceu.getResources().getString(R.string.forum));
            this.ewN = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.ewL = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.ewL.setItemsCanFocus(true);
        this.ewL.setVisibility(8);
        this.ewK = new c(this.ceu, this.ewL);
        if (this.ewO) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dDz = new g(this.ceu.getPageActivity());
        this.dDz.attachView(this.mRootView, false);
        this.ewL.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.aMt();
                a.this.aMu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMt() {
        if (Build.VERSION.SDK_INT >= 11 && this.ewL.getChildAt(0) != null) {
            int dimension = (int) this.ceu.getResources().getDimension(R.dimen.ds98);
            int i = this.dQz - (-this.ewL.getChildAt(0).getTop());
            if (i < dimension) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= dimension && i <= dimension * 2) {
                float f = 1.0f - (((i - dimension) * 1.0f) / dimension);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > dimension * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.ewL.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMu() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.dQy) {
                    this.dQy = true;
                }
            } else if (this.dQy) {
                this.dQy = false;
            }
            a(alpha, this.dQy ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.dBI) {
            am.setNavbarIconSrc(this.ewM, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.ewN, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.ewM, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.ewN, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.ewN.setAlpha(f);
        this.ewM.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.ceu, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.ewM, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.ewL.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.ewL.setDividerHeight(this.ceu.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.ewL.getAdapter() instanceof e) {
            this.ewL.getAdapter().notifyDataSetChanged();
            if (this.dDz != null) {
                this.dDz.onChangeSkinType();
            }
            this.dvR.onChangeSkinType(this.ceu, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.ceu.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.ceu.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.ceu.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.ceu.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void d(String str, String str2, String str3, boolean z) {
        this.ewI.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.ewI.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void b(Object obj, int i) {
        if (obj != null) {
            aJm();
            if ((obj instanceof b) && i == 1) {
                this.ewJ = (b) obj;
                this.ewJ.setIsHost(this.mIsHost);
                this.dDz.dettachView(this.mRootView);
                this.ewL.setVisibility(0);
                aXB();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.dDz != null) {
            this.dDz.dettachView(this.mRootView);
        }
        this.ewL.setVisibility(0);
        if (this.ewL != null && v.isEmpty(this.ewL.getData())) {
            aJl();
        }
    }

    public void onDestory() {
        if (this.dDz != null) {
            this.dDz.release();
            this.dDz.dettachView(this.mRootView);
        }
        if (this.ewI != null) {
            this.ewI.destory();
        }
    }

    public void aXB() {
        ArrayList arrayList;
        if (this.ewJ != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                d dVar = new d();
                dVar.a(this.ewJ);
                arrayList.add(dVar);
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.ewJ);
                arrayList.add(hVar);
                i iVar = new i();
                iVar.a(this.ewJ);
                arrayList.add(iVar);
                f fVar = new f();
                fVar.a(this.ewJ);
                arrayList.add(fVar);
                j jVar = new j();
                jVar.a(this.ewJ);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.ewJ);
                arrayList.add(eVar);
                com.baidu.tieba.ala.personcenter.c.c cVar = new com.baidu.tieba.ala.personcenter.c.c();
                cVar.a(this.ewJ);
                arrayList.add(cVar);
            } else {
                arrayList = new ArrayList(4);
                d dVar2 = new d();
                dVar2.a(this.ewJ);
                arrayList.add(dVar2);
            }
            this.ewK.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (!this.ewO) {
            this.ewN = this.mNavigationBar.setCenterTextTitle(this.ceu.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.ceu.getResources().getString(R.string.forum));
        this.ewN = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }
}
