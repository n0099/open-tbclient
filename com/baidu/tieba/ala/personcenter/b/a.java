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
    private TbPageContext cfl;
    private g dEq;
    private int dRq;
    private NoNetworkView dwI;
    private AlaPersonCenterModel exA;
    private b exB;
    private c exC;
    private BdTypeListView exD;
    private ImageView exE;
    private TextView exF;
    private boolean exG;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean dRp = true;
    private boolean dCz = false;
    private CustomMessageListener exH = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.exA != null) {
                a.this.exA.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.dRq = 0;
        this.exG = false;
        this.cfl = tbPageContext;
        this.exG = z;
        this.dRq = (int) this.cfl.getResources().getDimension(R.dimen.ds400);
        this.exA = new AlaPersonCenterModel(tbPageContext);
        this.exA.a(this);
        dn(tbPageContext.getPageActivity());
    }

    private void aJn() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.cfl.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.cfl.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.cfl.getResources().getString(R.string.recommend_pb_no_net_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.dCz) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.dCz = true;
    }

    private void aJo() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.dCz = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void dn(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.exG) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.cfl.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.exE = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.exG) {
            this.exF = this.mNavigationBar.setCenterTextTitle(this.cfl.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cfl.getResources().getString(R.string.forum));
            this.exF = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.exD = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.exD.setItemsCanFocus(true);
        this.exD.setVisibility(8);
        this.exC = new c(this.cfl, this.exD);
        if (this.exG) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dEq = new g(this.cfl.getPageActivity());
        this.dEq.attachView(this.mRootView, false);
        this.exD.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.aMv();
                a.this.aMw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMv() {
        if (Build.VERSION.SDK_INT >= 11 && this.exD.getChildAt(0) != null) {
            int dimension = (int) this.cfl.getResources().getDimension(R.dimen.ds98);
            int i = this.dRq - (-this.exD.getChildAt(0).getTop());
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
            if (this.exD.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMw() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.dRp) {
                    this.dRp = true;
                }
            } else if (this.dRp) {
                this.dRp = false;
            }
            a(alpha, this.dRp ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.dCz) {
            am.setNavbarIconSrc(this.exE, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.exF, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.exE, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.exF, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.exF.setAlpha(f);
        this.exE.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cfl, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.exE, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.exD.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.exD.setDividerHeight(this.cfl.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.exD.getAdapter() instanceof e) {
            this.exD.getAdapter().notifyDataSetChanged();
            if (this.dEq != null) {
                this.dEq.onChangeSkinType();
            }
            this.dwI.onChangeSkinType(this.cfl, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cfl.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cfl.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cfl.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cfl.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void d(String str, String str2, String str3, boolean z) {
        this.exA.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.exA.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void b(Object obj, int i) {
        if (obj != null) {
            aJo();
            if ((obj instanceof b) && i == 1) {
                this.exB = (b) obj;
                this.exB.setIsHost(this.mIsHost);
                this.dEq.dettachView(this.mRootView);
                this.exD.setVisibility(0);
                aXD();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.dEq != null) {
            this.dEq.dettachView(this.mRootView);
        }
        this.exD.setVisibility(0);
        if (this.exD != null && v.isEmpty(this.exD.getData())) {
            aJn();
        }
    }

    public void onDestory() {
        if (this.dEq != null) {
            this.dEq.release();
            this.dEq.dettachView(this.mRootView);
        }
        if (this.exA != null) {
            this.exA.destory();
        }
    }

    public void aXD() {
        ArrayList arrayList;
        if (this.exB != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                d dVar = new d();
                dVar.a(this.exB);
                arrayList.add(dVar);
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.exB);
                arrayList.add(hVar);
                i iVar = new i();
                iVar.a(this.exB);
                arrayList.add(iVar);
                f fVar = new f();
                fVar.a(this.exB);
                arrayList.add(fVar);
                j jVar = new j();
                jVar.a(this.exB);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.exB);
                arrayList.add(eVar);
                com.baidu.tieba.ala.personcenter.c.c cVar = new com.baidu.tieba.ala.personcenter.c.c();
                cVar.a(this.exB);
                arrayList.add(cVar);
            } else {
                arrayList = new ArrayList(4);
                d dVar2 = new d();
                dVar2.a(this.exB);
                arrayList.add(dVar2);
            }
            this.exC.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (!this.exG) {
            this.exF = this.mNavigationBar.setCenterTextTitle(this.cfl.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cfl.getResources().getString(R.string.forum));
        this.exF = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }
}
