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
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext eGu;
    private int gPJ;
    private NoNetworkView giU;
    private g grV;
    private AlaPersonCenterModel hDu;
    private c hDv;
    private d hDw;
    private BdTypeListView hDx;
    private ImageView hDy;
    private TextView hDz;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean gPI = true;
    private boolean gpR = false;
    private boolean hDA = false;
    private CustomMessageListener hDB = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hDu != null) {
                a.this.hDu.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.gPJ = 0;
        this.isInFrs = false;
        this.eGu = tbPageContext;
        this.isInFrs = z;
        this.gPJ = (int) this.eGu.getResources().getDimension(R.dimen.ds400);
        this.hDu = new AlaPersonCenterModel(tbPageContext);
        this.hDu.a(this);
        fe(tbPageContext.getPageActivity());
    }

    private void bOt() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.eGu.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.eGu.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.eGu.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.gpR) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gpR = true;
    }

    private void VB() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.gpR = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void fe(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.isInFrs) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.eGu.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.hDy = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.hDz = this.mNavigationBar.setCenterTextTitle(this.eGu.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eGu.getResources().getString(R.string.forum));
            this.hDz = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.giU = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.hDx = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.hDx.setItemsCanFocus(true);
        this.hDx.setVisibility(8);
        this.hDw = new d(this.eGu, this.hDx, this);
        this.hDw.lE(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.grV = new g(this.eGu.getPageActivity());
        this.grV.attachView(this.mRootView, false);
        this.hDx.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bUO();
                a.this.bUP();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUO() {
        if (Build.VERSION.SDK_INT >= 11 && this.hDx.getChildAt(0) != null) {
            int dimension = (int) this.eGu.getResources().getDimension(R.dimen.ds98);
            int i = this.gPJ - (-this.hDx.getChildAt(0).getTop());
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
            if (this.hDx.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUP() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.gPI) {
                    this.gPI = true;
                }
            } else if (this.gPI) {
                this.gPI = false;
            }
            a(alpha, this.gPI ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.gpR) {
            ap.setNavbarIconSrc(this.hDy, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.hDz, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.hDy, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.hDz, R.color.CAM_X0101, R.color.CAM_X0101);
        }
        this.hDz.setAlpha(f);
        this.hDy.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eGu, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
        ap.setNavbarIconSrc(this.hDy, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.hDx.setDivider(ap.getDrawable(i, R.color.CAM_X0204));
        this.hDx.setDividerHeight(this.eGu.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.hDx.getAdapter() instanceof f) {
            this.hDx.getAdapter().notifyDataSetChanged();
            if (this.grV != null) {
                this.grV.onChangeSkinType();
            }
            this.giU.onChangeSkinType(this.eGu, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eGu.getResources().getColor(R.color.CAM_X0207_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eGu.getResources().getColor(R.color.CAM_X0201_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eGu.getResources().getColor(R.color.CAM_X0207));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eGu.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.hDu.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.hDu.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            VB();
            if ((obj instanceof c) && i == 1) {
                this.hDv = (c) obj;
                this.hDv.setIsHost(this.mIsHost);
                this.grV.dettachView(this.mRootView);
                this.hDx.setVisibility(0);
                ciS();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.grV != null) {
            this.grV.dettachView(this.mRootView);
        }
        this.hDx.setVisibility(0);
        if (this.hDx != null && y.isEmpty(this.hDx.getData())) {
            bOt();
        }
    }

    public void onDestory() {
        if (this.grV != null) {
            this.grV.release();
            this.grV.dettachView(this.mRootView);
        }
        if (this.hDu != null) {
            this.hDu.destory();
        }
    }

    public void ciS() {
        ArrayList arrayList;
        if (this.hDv != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                com.baidu.tieba.ala.personcenter.c.f fVar = new com.baidu.tieba.ala.personcenter.c.f();
                fVar.a(this.hDv);
                arrayList.add(fVar);
                m mVar = new m();
                mVar.a(this.hDv);
                arrayList.add(mVar);
                j jVar = new j();
                jVar.a(this.hDv);
                arrayList.add(jVar);
                k kVar = new k();
                kVar.a(this.hDv);
                arrayList.add(kVar);
                if (this.hDv.hDK != null) {
                    com.baidu.tieba.ala.personcenter.c.d dVar = new com.baidu.tieba.ala.personcenter.c.d();
                    dVar.a(this.hDv);
                    arrayList.add(dVar);
                }
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.hDv);
                arrayList.add(hVar);
                l lVar = new l();
                lVar.a(this.hDv);
                arrayList.add(lVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.hDv);
                arrayList.add(gVar);
                e eVar = new e();
                eVar.a(this.hDv);
                arrayList.add(eVar);
                o oVar = new o();
                oVar.a(this.hDv);
                arrayList.add(oVar);
                n nVar = new n();
                nVar.a(this.hDv);
                arrayList.add(nVar);
            } else {
                arrayList = new ArrayList(4);
                com.baidu.tieba.ala.personcenter.c.f fVar2 = new com.baidu.tieba.ala.personcenter.c.f();
                fVar2.a(this.hDv);
                arrayList.add(fVar2);
            }
            this.hDw.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.hDw != null) {
            this.hDw.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.hDw != null) {
            this.hDw.setForumName(str);
        }
        if (!this.isInFrs) {
            this.hDz = this.mNavigationBar.setCenterTextTitle(this.eGu.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eGu.getResources().getString(R.string.forum));
        this.hDz = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void Ih(String str) {
        if (this.hDw != null) {
            this.hDw.Ih(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void wU(int i) {
        if (i == 1) {
            this.hDA = true;
        }
    }

    public void onResume() {
        if (this.hDA) {
            this.hDA = false;
            loadData();
        }
    }
}
