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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.a.d;
import com.baidu.tieba.ala.personcenter.c.c;
import com.baidu.tieba.ala.personcenter.c.f;
import com.baidu.tieba.ala.personcenter.c.j;
import com.baidu.tieba.ala.personcenter.c.k;
import com.baidu.tieba.ala.personcenter.c.l;
import com.baidu.tieba.ala.personcenter.c.m;
import com.baidu.tieba.ala.personcenter.c.n;
import com.baidu.tieba.ala.personcenter.c.o;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext eUY;
    private NoNetworkView gAv;
    private g gJB;
    private AlaPersonCenterModel hZB;
    private c hZC;
    private d hZD;
    private BdTypeListView hZE;
    private ImageView hZF;
    private TextView hZG;
    private int hkK;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean hkJ = true;
    private boolean gHx = false;
    private boolean hZH = false;
    private CustomMessageListener hZI = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hZB != null) {
                a.this.hZB.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.hkK = 0;
        this.isInFrs = false;
        this.eUY = tbPageContext;
        this.isInFrs = z;
        this.hkK = (int) this.eUY.getResources().getDimension(R.dimen.ds400);
        this.hZB = new AlaPersonCenterModel(tbPageContext);
        this.hZB.a(this);
        gb(tbPageContext.getPageActivity());
    }

    private void bRB() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.eUY.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.eUY.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.gHx) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gHx = true;
    }

    private void WZ() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.gHx = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void gb(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.isInFrs) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.eUY.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.hZF = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.hZG = this.mNavigationBar.setCenterTextTitle(this.eUY.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eUY.getResources().getString(R.string.forum));
            this.hZG = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.gAv = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.hZE = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.hZE.setItemsCanFocus(true);
        this.hZE.setVisibility(8);
        this.hZD = new d(this.eUY, this.hZE, this);
        this.hZD.mw(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gJB = new g(this.eUY.getPageActivity());
        this.gJB.attachView(this.mRootView, false);
        this.hZE.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bYt();
                a.this.bYu();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYt() {
        if (Build.VERSION.SDK_INT >= 11 && this.hZE.getChildAt(0) != null) {
            int dimension = (int) this.eUY.getResources().getDimension(R.dimen.ds98);
            int i = this.hkK - (-this.hZE.getChildAt(0).getTop());
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
            if (this.hZE.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYu() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.hkJ) {
                    this.hkJ = true;
                }
            } else if (this.hkJ) {
                this.hkJ = false;
            }
            b(alpha, this.hkJ ? false : true);
        }
    }

    protected void b(float f, boolean z) {
        if (z || this.gHx) {
            ap.setNavbarIconSrc(this.hZF, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.hZG, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.hZF, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.hZG, R.color.CAM_X0101, R.color.CAM_X0101);
        }
        this.hZG.setAlpha(f);
        this.hZF.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eUY, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
        ap.setNavbarIconSrc(this.hZF, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.hZE.setDivider(ap.getDrawable(i, R.color.CAM_X0204));
        this.hZE.setDividerHeight(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.hZE.getAdapter() instanceof e) {
            this.hZE.getAdapter().notifyDataSetChanged();
            if (this.gJB != null) {
                this.gJB.onChangeSkinType();
            }
            this.gAv.onChangeSkinType(this.eUY, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eUY.getResources().getColor(R.color.CAM_X0207_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eUY.getResources().getColor(R.color.CAM_X0201_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eUY.getResources().getColor(R.color.CAM_X0207));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eUY.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.hZB.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.hZB.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void d(Object obj, int i) {
        if (obj != null) {
            WZ();
            if ((obj instanceof c) && i == 1) {
                this.hZC = (c) obj;
                this.hZC.setIsHost(this.mIsHost);
                this.gJB.dettachView(this.mRootView);
                this.hZE.setVisibility(0);
                cmT();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.gJB != null) {
            this.gJB.dettachView(this.mRootView);
        }
        this.hZE.setVisibility(0);
        if (this.hZE != null && y.isEmpty(this.hZE.getData())) {
            bRB();
        }
    }

    public void onDestory() {
        if (this.gJB != null) {
            this.gJB.release();
            this.gJB.dettachView(this.mRootView);
        }
        if (this.hZB != null) {
            this.hZB.destory();
        }
    }

    public void cmT() {
        ArrayList arrayList;
        if (this.hZC != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                f fVar = new f();
                fVar.a(this.hZC);
                arrayList.add(fVar);
                m mVar = new m();
                mVar.a(this.hZC);
                arrayList.add(mVar);
                j jVar = new j();
                jVar.a(this.hZC);
                arrayList.add(jVar);
                k kVar = new k();
                kVar.a(this.hZC);
                arrayList.add(kVar);
                if (this.hZC.hZR != null) {
                    com.baidu.tieba.ala.personcenter.c.d dVar = new com.baidu.tieba.ala.personcenter.c.d();
                    dVar.a(this.hZC);
                    arrayList.add(dVar);
                }
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.hZC);
                arrayList.add(hVar);
                l lVar = new l();
                lVar.a(this.hZC);
                arrayList.add(lVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.hZC);
                arrayList.add(gVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.hZC);
                arrayList.add(eVar);
                o oVar = new o();
                oVar.a(this.hZC);
                arrayList.add(oVar);
                n nVar = new n();
                nVar.a(this.hZC);
                arrayList.add(nVar);
            } else {
                arrayList = new ArrayList(4);
                f fVar2 = new f();
                fVar2.a(this.hZC);
                arrayList.add(fVar2);
            }
            this.hZD.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.hZD != null) {
            this.hZD.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.hZD != null) {
            this.hZD.setForumName(str);
        }
        if (!this.isInFrs) {
            this.hZG = this.mNavigationBar.setCenterTextTitle(this.eUY.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eUY.getResources().getString(R.string.forum));
        this.hZG = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void In(String str) {
        if (this.hZD != null) {
            this.hZD.In(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void wr(int i) {
        if (i == 1) {
            this.hZH = true;
        }
    }

    public void onResume() {
        if (this.hZH) {
            this.hZH = false;
            loadData();
        }
    }
}
