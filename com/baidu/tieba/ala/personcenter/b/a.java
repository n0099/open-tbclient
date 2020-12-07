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
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.a.d;
import com.baidu.tieba.ala.personcenter.c.c;
import com.baidu.tieba.ala.personcenter.c.e;
import com.baidu.tieba.ala.personcenter.c.j;
import com.baidu.tieba.ala.personcenter.c.k;
import com.baidu.tieba.ala.personcenter.c.l;
import com.baidu.tieba.ala.personcenter.c.m;
import com.baidu.tieba.ala.personcenter.c.n;
import com.baidu.tieba.ala.personcenter.c.o;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext eNx;
    private g gAe;
    private int gYW;
    private NoNetworkView grd;
    private AlaPersonCenterModel hNb;
    private c hNc;
    private d hNd;
    private BdTypeListView hNe;
    private ImageView hNf;
    private TextView hNg;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean gYV = true;
    private boolean gya = false;
    private boolean hNh = false;
    private CustomMessageListener hNi = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hNb != null) {
                a.this.hNb.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.gYW = 0;
        this.isInFrs = false;
        this.eNx = tbPageContext;
        this.isInFrs = z;
        this.gYW = (int) this.eNx.getResources().getDimension(R.dimen.ds400);
        this.hNb = new AlaPersonCenterModel(tbPageContext);
        this.hNb.a(this);
        fK(tbPageContext.getPageActivity());
    }

    private void bSe() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.eNx.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.eNx.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.gya) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gya = true;
    }

    private void Yb() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.gya = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void fK(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.isInFrs) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.eNx.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.hNf = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.hNg = this.mNavigationBar.setCenterTextTitle(this.eNx.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eNx.getResources().getString(R.string.forum));
            this.hNg = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.grd = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.hNe = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.hNe.setItemsCanFocus(true);
        this.hNe.setVisibility(8);
        this.hNd = new d(this.eNx, this.hNe, this);
        this.hNd.lZ(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gAe = new g(this.eNx.getPageActivity());
        this.gAe.attachView(this.mRootView, false);
        this.hNe.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bYx();
                a.this.bYy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYx() {
        if (Build.VERSION.SDK_INT >= 11 && this.hNe.getChildAt(0) != null) {
            int dimension = (int) this.eNx.getResources().getDimension(R.dimen.ds98);
            int i = this.gYW - (-this.hNe.getChildAt(0).getTop());
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
            if (this.hNe.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYy() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.gYV) {
                    this.gYV = true;
                }
            } else if (this.gYV) {
                this.gYV = false;
            }
            a(alpha, this.gYV ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.gya) {
            ap.setNavbarIconSrc(this.hNf, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.hNg, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.hNf, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.hNg, R.color.CAM_X0101, R.color.CAM_X0101);
        }
        this.hNg.setAlpha(f);
        this.hNf.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eNx, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
        ap.setNavbarIconSrc(this.hNf, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.hNe.setDivider(ap.getDrawable(i, R.color.CAM_X0204));
        this.hNe.setDividerHeight(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.hNe.getAdapter() instanceof f) {
            this.hNe.getAdapter().notifyDataSetChanged();
            if (this.gAe != null) {
                this.gAe.onChangeSkinType();
            }
            this.grd.onChangeSkinType(this.eNx, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eNx.getResources().getColor(R.color.CAM_X0207_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eNx.getResources().getColor(R.color.CAM_X0201_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eNx.getResources().getColor(R.color.CAM_X0207));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eNx.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.hNb.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.hNb.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            Yb();
            if ((obj instanceof c) && i == 1) {
                this.hNc = (c) obj;
                this.hNc.setIsHost(this.mIsHost);
                this.gAe.dettachView(this.mRootView);
                this.hNe.setVisibility(0);
                cmM();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.gAe != null) {
            this.gAe.dettachView(this.mRootView);
        }
        this.hNe.setVisibility(0);
        if (this.hNe != null && y.isEmpty(this.hNe.getData())) {
            bSe();
        }
    }

    public void onDestory() {
        if (this.gAe != null) {
            this.gAe.release();
            this.gAe.dettachView(this.mRootView);
        }
        if (this.hNb != null) {
            this.hNb.destory();
        }
    }

    public void cmM() {
        ArrayList arrayList;
        if (this.hNc != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                com.baidu.tieba.ala.personcenter.c.f fVar = new com.baidu.tieba.ala.personcenter.c.f();
                fVar.a(this.hNc);
                arrayList.add(fVar);
                m mVar = new m();
                mVar.a(this.hNc);
                arrayList.add(mVar);
                j jVar = new j();
                jVar.a(this.hNc);
                arrayList.add(jVar);
                k kVar = new k();
                kVar.a(this.hNc);
                arrayList.add(kVar);
                if (this.hNc.hNr != null) {
                    com.baidu.tieba.ala.personcenter.c.d dVar = new com.baidu.tieba.ala.personcenter.c.d();
                    dVar.a(this.hNc);
                    arrayList.add(dVar);
                }
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.hNc);
                arrayList.add(hVar);
                l lVar = new l();
                lVar.a(this.hNc);
                arrayList.add(lVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.hNc);
                arrayList.add(gVar);
                e eVar = new e();
                eVar.a(this.hNc);
                arrayList.add(eVar);
                o oVar = new o();
                oVar.a(this.hNc);
                arrayList.add(oVar);
                n nVar = new n();
                nVar.a(this.hNc);
                arrayList.add(nVar);
            } else {
                arrayList = new ArrayList(4);
                com.baidu.tieba.ala.personcenter.c.f fVar2 = new com.baidu.tieba.ala.personcenter.c.f();
                fVar2.a(this.hNc);
                arrayList.add(fVar2);
            }
            this.hNd.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.hNd != null) {
            this.hNd.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.hNd != null) {
            this.hNd.setForumName(str);
        }
        if (!this.isInFrs) {
            this.hNg = this.mNavigationBar.setCenterTextTitle(this.eNx.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eNx.getResources().getString(R.string.forum));
        this.hNg = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void IW(String str) {
        if (this.hNd != null) {
            this.hNd.IW(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void xz(int i) {
        if (i == 1) {
            this.hNh = true;
        }
    }

    public void onResume() {
        if (this.hNh) {
            this.hNh = false;
            loadData();
        }
    }
}
