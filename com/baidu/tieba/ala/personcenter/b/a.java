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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private TbPageContext eXu;
    private NoNetworkView gCe;
    private g gLj;
    private c hZA;
    private d hZB;
    private BdTypeListView hZC;
    private ImageView hZD;
    private TextView hZE;
    private AlaPersonCenterModel hZz;
    private int hkN;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean hkM = true;
    private boolean gJf = false;
    private boolean hZF = false;
    private CustomMessageListener hZG = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hZz != null) {
                a.this.hZz.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.hkN = 0;
        this.isInFrs = false;
        this.eXu = tbPageContext;
        this.isInFrs = z;
        this.hkN = (int) this.eXu.getResources().getDimension(R.dimen.ds400);
        this.hZz = new AlaPersonCenterModel(tbPageContext);
        this.hZz.a(this);
        gc(tbPageContext.getPageActivity());
    }

    private void bUH() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.eXu.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.eXu.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.eXu.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.gJf) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gJf = true;
    }

    private void Zi() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.gJf = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void gc(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.isInFrs) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.eXu.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.hZD = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.hZE = this.mNavigationBar.setCenterTextTitle(this.eXu.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eXu.getResources().getString(R.string.forum));
            this.hZE = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.hZC = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.hZC.setItemsCanFocus(true);
        this.hZC.setVisibility(8);
        this.hZB = new d(this.eXu, this.hZC, this);
        this.hZB.mw(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gLj = new g(this.eXu.getPageActivity());
        this.gLj.attachView(this.mRootView, false);
        this.hZC.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.cbd();
                a.this.cbe();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbd() {
        if (Build.VERSION.SDK_INT >= 11 && this.hZC.getChildAt(0) != null) {
            int dimension = (int) this.eXu.getResources().getDimension(R.dimen.ds98);
            int i = this.hkN - (-this.hZC.getChildAt(0).getTop());
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
            if (this.hZC.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbe() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.hkM) {
                    this.hkM = true;
                }
            } else if (this.hkM) {
                this.hkM = false;
            }
            b(alpha, this.hkM ? false : true);
        }
    }

    protected void b(float f, boolean z) {
        if (z || this.gJf) {
            ao.setNavbarIconSrc(this.hZD, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ao.setNavbarTitleColor(this.hZE, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            ao.setNavbarIconSrc(this.hZD, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ao.setNavbarTitleColor(this.hZE, R.color.CAM_X0101, R.color.CAM_X0101);
        }
        this.hZE.setAlpha(f);
        this.hZD.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eXu, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ao.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
        ao.setNavbarIconSrc(this.hZD, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.hZC.setDivider(ao.getDrawable(i, R.color.CAM_X0204));
        this.hZC.setDividerHeight(this.eXu.getResources().getDimensionPixelSize(R.dimen.ds2));
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.hZC.getAdapter() instanceof e) {
            this.hZC.getAdapter().notifyDataSetChanged();
            if (this.gLj != null) {
                this.gLj.onChangeSkinType();
            }
            this.gCe.onChangeSkinType(this.eXu, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eXu.getResources().getColor(R.color.CAM_X0207_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eXu.getResources().getColor(R.color.CAM_X0201_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eXu.getResources().getColor(R.color.CAM_X0207));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eXu.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.hZz.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.hZz.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void d(Object obj, int i) {
        if (obj != null) {
            Zi();
            if ((obj instanceof c) && i == 1) {
                this.hZA = (c) obj;
                this.hZA.setIsHost(this.mIsHost);
                this.gLj.dettachView(this.mRootView);
                this.hZC.setVisibility(0);
                cpF();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.gLj != null) {
            this.gLj.dettachView(this.mRootView);
        }
        this.hZC.setVisibility(0);
        if (this.hZC != null && x.isEmpty(this.hZC.getData())) {
            bUH();
        }
    }

    public void onDestory() {
        if (this.gLj != null) {
            this.gLj.release();
            this.gLj.dettachView(this.mRootView);
        }
        if (this.hZz != null) {
            this.hZz.destory();
        }
    }

    public void cpF() {
        ArrayList arrayList;
        if (this.hZA != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                f fVar = new f();
                fVar.a(this.hZA);
                arrayList.add(fVar);
                m mVar = new m();
                mVar.a(this.hZA);
                arrayList.add(mVar);
                j jVar = new j();
                jVar.a(this.hZA);
                arrayList.add(jVar);
                k kVar = new k();
                kVar.a(this.hZA);
                arrayList.add(kVar);
                if (this.hZA.hZP != null) {
                    com.baidu.tieba.ala.personcenter.c.d dVar = new com.baidu.tieba.ala.personcenter.c.d();
                    dVar.a(this.hZA);
                    arrayList.add(dVar);
                }
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.hZA);
                arrayList.add(hVar);
                l lVar = new l();
                lVar.a(this.hZA);
                arrayList.add(lVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.hZA);
                arrayList.add(gVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.hZA);
                arrayList.add(eVar);
                o oVar = new o();
                oVar.a(this.hZA);
                arrayList.add(oVar);
                n nVar = new n();
                nVar.a(this.hZA);
                arrayList.add(nVar);
            } else {
                arrayList = new ArrayList(4);
                f fVar2 = new f();
                fVar2.a(this.hZA);
                arrayList.add(fVar2);
            }
            this.hZB.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.hZB != null) {
            this.hZB.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.hZB != null) {
            this.hZB.setForumName(str);
        }
        if (!this.isInFrs) {
            this.hZE = this.mNavigationBar.setCenterTextTitle(this.eXu.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eXu.getResources().getString(R.string.forum));
        this.hZE = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void IU(String str) {
        if (this.hZB != null) {
            this.hZB.IU(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void xM(int i) {
        if (i == 1) {
            this.hZF = true;
        }
    }

    public void onResume() {
        if (this.hZF) {
            this.hZF = false;
            loadData();
        }
    }
}
