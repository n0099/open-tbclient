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
    private TbPageContext ehG;
    private NoNetworkView fHl;
    private g fQf;
    private AlaPersonCenterModel gWW;
    private c gWX;
    private com.baidu.tieba.ala.personcenter.a.c gWY;
    private BdTypeListView gWZ;
    private ImageView gXa;
    private TextView gXb;
    private int gkj;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean gki = true;
    private boolean fOb = false;
    private boolean gXc = false;
    private CustomMessageListener gXd = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gWW != null) {
                a.this.gWW.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.gkj = 0;
        this.isInFrs = false;
        this.ehG = tbPageContext;
        this.isInFrs = z;
        this.gkj = (int) this.ehG.getResources().getDimension(R.dimen.ds400);
        this.gWW = new AlaPersonCenterModel(tbPageContext);
        this.gWW.a(this);
        eW(tbPageContext.getPageActivity());
    }

    private void bHm() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.ehG.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.ehG.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.ehG.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.fOb) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fOb = true;
    }

    private void bHn() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.fOb = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eW(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.isInFrs) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.ehG.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.gXa = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.gXb = this.mNavigationBar.setCenterTextTitle(this.ehG.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.ehG.getResources().getString(R.string.forum));
            this.gXb = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.fHl = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.gWZ = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.gWZ.setItemsCanFocus(true);
        this.gWZ.setVisibility(8);
        this.gWY = new com.baidu.tieba.ala.personcenter.a.c(this.ehG, this.gWZ, this);
        this.gWY.kE(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fQf = new g(this.ehG.getPageActivity());
        this.fQf.attachView(this.mRootView, false);
        this.gWZ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bMI();
                a.this.bMJ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMI() {
        if (Build.VERSION.SDK_INT >= 11 && this.gWZ.getChildAt(0) != null) {
            int dimension = (int) this.ehG.getResources().getDimension(R.dimen.ds98);
            int i = this.gkj - (-this.gWZ.getChildAt(0).getTop());
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
            if (this.gWZ.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMJ() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.gki) {
                    this.gki = true;
                }
            } else if (this.gki) {
                this.gki = false;
            }
            a(alpha, this.gki ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.fOb) {
            ap.setNavbarIconSrc(this.gXa, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.gXb, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.gXa, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.gXb, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.gXb.setAlpha(f);
        this.gXa.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.ehG, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        ap.setNavbarIconSrc(this.gXa, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.gWZ.setDivider(ap.getDrawable(i, R.color.cp_bg_line_c));
        this.gWZ.setDividerHeight(this.ehG.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.gWZ.getAdapter() instanceof f) {
            this.gWZ.getAdapter().notifyDataSetChanged();
            if (this.fQf != null) {
                this.fQf.onChangeSkinType();
            }
            this.fHl.onChangeSkinType(this.ehG, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.ehG.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.ehG.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.ehG.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.ehG.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.gWW.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.gWW.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            bHn();
            if ((obj instanceof c) && i == 1) {
                this.gWX = (c) obj;
                this.gWX.setIsHost(this.mIsHost);
                this.fQf.dettachView(this.mRootView);
                this.gWZ.setVisibility(0);
                cax();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.fQf != null) {
            this.fQf.dettachView(this.mRootView);
        }
        this.gWZ.setVisibility(0);
        if (this.gWZ != null && y.isEmpty(this.gWZ.getData())) {
            bHm();
        }
    }

    public void onDestory() {
        if (this.fQf != null) {
            this.fQf.release();
            this.fQf.dettachView(this.mRootView);
        }
        if (this.gWW != null) {
            this.gWW.destory();
        }
    }

    public void cax() {
        ArrayList arrayList;
        if (this.gWX != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                e eVar = new e();
                eVar.a(this.gWX);
                arrayList.add(eVar);
                l lVar = new l();
                lVar.a(this.gWX);
                arrayList.add(lVar);
                i iVar = new i();
                iVar.a(this.gWX);
                arrayList.add(iVar);
                j jVar = new j();
                jVar.a(this.gWX);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.gWX);
                arrayList.add(gVar);
                k kVar = new k();
                kVar.a(this.gWX);
                arrayList.add(kVar);
                com.baidu.tieba.ala.personcenter.c.f fVar = new com.baidu.tieba.ala.personcenter.c.f();
                fVar.a(this.gWX);
                arrayList.add(fVar);
                d dVar = new d();
                dVar.a(this.gWX);
                arrayList.add(dVar);
                n nVar = new n();
                nVar.a(this.gWX);
                arrayList.add(nVar);
                m mVar = new m();
                mVar.a(this.gWX);
                arrayList.add(mVar);
            } else {
                arrayList = new ArrayList(4);
                e eVar2 = new e();
                eVar2.a(this.gWX);
                arrayList.add(eVar2);
            }
            this.gWY.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.gWY != null) {
            this.gWY.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.gWY != null) {
            this.gWY.setForumName(str);
        }
        if (!this.isInFrs) {
            this.gXb = this.mNavigationBar.setCenterTextTitle(this.ehG.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.ehG.getResources().getString(R.string.forum));
        this.gXb = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void Hc(String str) {
        if (this.gWY != null) {
            this.gWY.Hc(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void vj(int i) {
        if (i == 1) {
            this.gXc = true;
        }
    }

    public void onResume() {
        if (this.gXc) {
            this.gXc = false;
            loadData();
        }
    }
}
