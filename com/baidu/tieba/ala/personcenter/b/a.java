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
    private g gAg;
    private int gYY;
    private NoNetworkView grf;
    private AlaPersonCenterModel hNd;
    private c hNe;
    private d hNf;
    private BdTypeListView hNg;
    private ImageView hNh;
    private TextView hNi;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean gYX = true;
    private boolean gyc = false;
    private boolean hNj = false;
    private CustomMessageListener hNk = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hNd != null) {
                a.this.hNd.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.gYY = 0;
        this.isInFrs = false;
        this.eNx = tbPageContext;
        this.isInFrs = z;
        this.gYY = (int) this.eNx.getResources().getDimension(R.dimen.ds400);
        this.hNd = new AlaPersonCenterModel(tbPageContext);
        this.hNd.a(this);
        fK(tbPageContext.getPageActivity());
    }

    private void bSf() {
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
        if (!this.gyc) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gyc = true;
    }

    private void Yb() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.gyc = false;
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
        this.hNh = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.hNi = this.mNavigationBar.setCenterTextTitle(this.eNx.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eNx.getResources().getString(R.string.forum));
            this.hNi = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.grf = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.hNg = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.hNg.setItemsCanFocus(true);
        this.hNg.setVisibility(8);
        this.hNf = new d(this.eNx, this.hNg, this);
        this.hNf.lZ(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gAg = new g(this.eNx.getPageActivity());
        this.gAg.attachView(this.mRootView, false);
        this.hNg.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bYy();
                a.this.bYz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYy() {
        if (Build.VERSION.SDK_INT >= 11 && this.hNg.getChildAt(0) != null) {
            int dimension = (int) this.eNx.getResources().getDimension(R.dimen.ds98);
            int i = this.gYY - (-this.hNg.getChildAt(0).getTop());
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
            if (this.hNg.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYz() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.gYX) {
                    this.gYX = true;
                }
            } else if (this.gYX) {
                this.gYX = false;
            }
            a(alpha, this.gYX ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.gyc) {
            ap.setNavbarIconSrc(this.hNh, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.hNi, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.hNh, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.hNi, R.color.CAM_X0101, R.color.CAM_X0101);
        }
        this.hNi.setAlpha(f);
        this.hNh.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eNx, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
        ap.setNavbarIconSrc(this.hNh, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.hNg.setDivider(ap.getDrawable(i, (int) R.color.CAM_X0204));
        this.hNg.setDividerHeight(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.hNg.getAdapter() instanceof f) {
            this.hNg.getAdapter().notifyDataSetChanged();
            if (this.gAg != null) {
                this.gAg.onChangeSkinType();
            }
            this.grf.onChangeSkinType(this.eNx, i);
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
        this.hNd.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.hNd.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            Yb();
            if ((obj instanceof c) && i == 1) {
                this.hNe = (c) obj;
                this.hNe.setIsHost(this.mIsHost);
                this.gAg.dettachView(this.mRootView);
                this.hNg.setVisibility(0);
                cmN();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.gAg != null) {
            this.gAg.dettachView(this.mRootView);
        }
        this.hNg.setVisibility(0);
        if (this.hNg != null && y.isEmpty(this.hNg.getData())) {
            bSf();
        }
    }

    public void onDestory() {
        if (this.gAg != null) {
            this.gAg.release();
            this.gAg.dettachView(this.mRootView);
        }
        if (this.hNd != null) {
            this.hNd.destory();
        }
    }

    public void cmN() {
        ArrayList arrayList;
        if (this.hNe != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                com.baidu.tieba.ala.personcenter.c.f fVar = new com.baidu.tieba.ala.personcenter.c.f();
                fVar.a(this.hNe);
                arrayList.add(fVar);
                m mVar = new m();
                mVar.a(this.hNe);
                arrayList.add(mVar);
                j jVar = new j();
                jVar.a(this.hNe);
                arrayList.add(jVar);
                k kVar = new k();
                kVar.a(this.hNe);
                arrayList.add(kVar);
                if (this.hNe.hNt != null) {
                    com.baidu.tieba.ala.personcenter.c.d dVar = new com.baidu.tieba.ala.personcenter.c.d();
                    dVar.a(this.hNe);
                    arrayList.add(dVar);
                }
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.hNe);
                arrayList.add(hVar);
                l lVar = new l();
                lVar.a(this.hNe);
                arrayList.add(lVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.hNe);
                arrayList.add(gVar);
                e eVar = new e();
                eVar.a(this.hNe);
                arrayList.add(eVar);
                o oVar = new o();
                oVar.a(this.hNe);
                arrayList.add(oVar);
                n nVar = new n();
                nVar.a(this.hNe);
                arrayList.add(nVar);
            } else {
                arrayList = new ArrayList(4);
                com.baidu.tieba.ala.personcenter.c.f fVar2 = new com.baidu.tieba.ala.personcenter.c.f();
                fVar2.a(this.hNe);
                arrayList.add(fVar2);
            }
            this.hNf.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.hNf != null) {
            this.hNf.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.hNf != null) {
            this.hNf.setForumName(str);
        }
        if (!this.isInFrs) {
            this.hNi = this.mNavigationBar.setCenterTextTitle(this.eNx.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eNx.getResources().getString(R.string.forum));
        this.hNi = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void IW(String str) {
        if (this.hNf != null) {
            this.hNf.IW(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void xz(int i) {
        if (i == 1) {
            this.hNj = true;
        }
    }

    public void onResume() {
        if (this.hNj) {
            this.hNj = false;
            loadData();
        }
    }
}
