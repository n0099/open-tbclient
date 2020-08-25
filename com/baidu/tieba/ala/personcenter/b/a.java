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
import com.baidu.adp.widget.ListView.f;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.c;
import com.baidu.tieba.ala.personcenter.c.d;
import com.baidu.tieba.ala.personcenter.c.e;
import com.baidu.tieba.ala.personcenter.c.i;
import com.baidu.tieba.ala.personcenter.c.j;
import com.baidu.tieba.ala.personcenter.c.k;
import com.baidu.tieba.ala.personcenter.c.l;
import com.baidu.tieba.ala.personcenter.c.m;
import com.baidu.tieba.ala.personcenter.c.n;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext efn;
    private NoNetworkView fDV;
    private g fMN;
    private AlaPersonCenterModel gTk;
    private c gTl;
    private com.baidu.tieba.ala.personcenter.a.c gTm;
    private BdTypeListView gTn;
    private ImageView gTo;
    private TextView gTp;
    private boolean gTq;
    private int ggU;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean ggT = true;
    private boolean fKJ = false;
    private boolean gTr = false;
    private CustomMessageListener gTs = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gTk != null) {
                a.this.gTk.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.ggU = 0;
        this.gTq = false;
        this.efn = tbPageContext;
        this.gTq = z;
        this.ggU = (int) this.efn.getResources().getDimension(R.dimen.ds400);
        this.gTk = new AlaPersonCenterModel(tbPageContext);
        this.gTk.a(this);
        eQ(tbPageContext.getPageActivity());
    }

    private void bFV() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.efn.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.efn.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.efn.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.fKJ) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fKJ = true;
    }

    private void bFW() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.fKJ = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eQ(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.gTq) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.efn.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.gTo = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.gTq) {
            this.gTp = this.mNavigationBar.setCenterTextTitle(this.efn.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.efn.getResources().getString(R.string.forum));
            this.gTp = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.fDV = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.gTn = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.gTn.setItemsCanFocus(true);
        this.gTn.setVisibility(8);
        this.gTm = new com.baidu.tieba.ala.personcenter.a.c(this.efn, this.gTn, this);
        this.gTm.kA(this.gTq);
        if (this.gTq) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fMN = new g(this.efn.getPageActivity());
        this.fMN.attachView(this.mRootView, false);
        this.gTn.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bLx();
                a.this.bLy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLx() {
        if (Build.VERSION.SDK_INT >= 11 && this.gTn.getChildAt(0) != null) {
            int dimension = (int) this.efn.getResources().getDimension(R.dimen.ds98);
            int i = this.ggU - (-this.gTn.getChildAt(0).getTop());
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
            if (this.gTn.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.ggT) {
                    this.ggT = true;
                }
            } else if (this.ggT) {
                this.ggT = false;
            }
            a(alpha, this.ggT ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.fKJ) {
            ap.setNavbarIconSrc(this.gTo, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.gTp, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.gTo, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.gTp, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.gTp.setAlpha(f);
        this.gTo.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.efn, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        ap.setNavbarIconSrc(this.gTo, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.gTn.setDivider(ap.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.gTn.setDividerHeight(this.efn.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.gTn.getAdapter() instanceof f) {
            this.gTn.getAdapter().notifyDataSetChanged();
            if (this.fMN != null) {
                this.fMN.onChangeSkinType();
            }
            this.fDV.onChangeSkinType(this.efn, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.efn.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.efn.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.efn.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.efn.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.gTk.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.gTk.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            bFW();
            if ((obj instanceof c) && i == 1) {
                this.gTl = (c) obj;
                this.gTl.setIsHost(this.mIsHost);
                this.fMN.dettachView(this.mRootView);
                this.gTn.setVisibility(0);
                bYA();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.fMN != null) {
            this.fMN.dettachView(this.mRootView);
        }
        this.gTn.setVisibility(0);
        if (this.gTn != null && y.isEmpty(this.gTn.getData())) {
            bFV();
        }
    }

    public void onDestory() {
        if (this.fMN != null) {
            this.fMN.release();
            this.fMN.dettachView(this.mRootView);
        }
        if (this.gTk != null) {
            this.gTk.destory();
        }
    }

    public void bYA() {
        ArrayList arrayList;
        if (this.gTl != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                e eVar = new e();
                eVar.a(this.gTl);
                arrayList.add(eVar);
                l lVar = new l();
                lVar.a(this.gTl);
                arrayList.add(lVar);
                i iVar = new i();
                iVar.a(this.gTl);
                arrayList.add(iVar);
                j jVar = new j();
                jVar.a(this.gTl);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.gTl);
                arrayList.add(gVar);
                k kVar = new k();
                kVar.a(this.gTl);
                arrayList.add(kVar);
                com.baidu.tieba.ala.personcenter.c.f fVar = new com.baidu.tieba.ala.personcenter.c.f();
                fVar.a(this.gTl);
                arrayList.add(fVar);
                d dVar = new d();
                dVar.a(this.gTl);
                arrayList.add(dVar);
                n nVar = new n();
                nVar.a(this.gTl);
                arrayList.add(nVar);
                m mVar = new m();
                mVar.a(this.gTl);
                arrayList.add(mVar);
            } else {
                arrayList = new ArrayList(4);
                e eVar2 = new e();
                eVar2.a(this.gTl);
                arrayList.add(eVar2);
            }
            this.gTm.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.gTm != null) {
            this.gTm.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.gTm != null) {
            this.gTm.setForumName(str);
        }
        if (!this.gTq) {
            this.gTp = this.mNavigationBar.setCenterTextTitle(this.efn.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.efn.getResources().getString(R.string.forum));
        this.gTp = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void GI(String str) {
        if (this.gTm != null) {
            this.gTm.GI(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void uQ(int i) {
        if (i == 1) {
            this.gTr = true;
        }
    }

    public void onResume() {
        if (this.gTr) {
            this.gTr = false;
            loadData();
        }
    }
}
