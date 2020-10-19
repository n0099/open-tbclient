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
    private TbPageContext etO;
    private NoNetworkView fTu;
    private g gcx;
    private int gyC;
    private AlaPersonCenterModel hlV;
    private c hlW;
    private d hlX;
    private BdTypeListView hlY;
    private ImageView hlZ;
    private TextView hma;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean gyB = true;
    private boolean gat = false;
    private boolean hmb = false;
    private CustomMessageListener hmc = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hlV != null) {
                a.this.hlV.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.gyC = 0;
        this.isInFrs = false;
        this.etO = tbPageContext;
        this.isInFrs = z;
        this.gyC = (int) this.etO.getResources().getDimension(R.dimen.ds400);
        this.hlV = new AlaPersonCenterModel(tbPageContext);
        this.hlV.a(this);
        fd(tbPageContext.getPageActivity());
    }

    private void bJY() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.etO.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.etO.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.etO.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.gat) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gat = true;
    }

    private void SK() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.gat = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void fd(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.isInFrs) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.etO.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.hlZ = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.hma = this.mNavigationBar.setCenterTextTitle(this.etO.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.etO.getResources().getString(R.string.forum));
            this.hma = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.fTu = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.hlY = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.hlY.setItemsCanFocus(true);
        this.hlY.setVisibility(8);
        this.hlX = new d(this.etO, this.hlY, this);
        this.hlX.lc(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gcx = new g(this.etO.getPageActivity());
        this.gcx.attachView(this.mRootView, false);
        this.hlY.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bPZ();
                a.this.bQa();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPZ() {
        if (Build.VERSION.SDK_INT >= 11 && this.hlY.getChildAt(0) != null) {
            int dimension = (int) this.etO.getResources().getDimension(R.dimen.ds98);
            int i = this.gyC - (-this.hlY.getChildAt(0).getTop());
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
            if (this.hlY.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQa() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.gyB) {
                    this.gyB = true;
                }
            } else if (this.gyB) {
                this.gyB = false;
            }
            a(alpha, this.gyB ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.gat) {
            ap.setNavbarIconSrc(this.hlZ, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.hma, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.hlZ, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.hma, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.hma.setAlpha(f);
        this.hlZ.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.etO, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        ap.setNavbarIconSrc(this.hlZ, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.hlY.setDivider(ap.getDrawable(i, R.color.cp_bg_line_c));
        this.hlY.setDividerHeight(this.etO.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.hlY.getAdapter() instanceof f) {
            this.hlY.getAdapter().notifyDataSetChanged();
            if (this.gcx != null) {
                this.gcx.onChangeSkinType();
            }
            this.fTu.onChangeSkinType(this.etO, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.etO.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.etO.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.etO.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.etO.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.hlV.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.hlV.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            SK();
            if ((obj instanceof c) && i == 1) {
                this.hlW = (c) obj;
                this.hlW.setIsHost(this.mIsHost);
                this.gcx.dettachView(this.mRootView);
                this.hlY.setVisibility(0);
                cdV();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.gcx != null) {
            this.gcx.dettachView(this.mRootView);
        }
        this.hlY.setVisibility(0);
        if (this.hlY != null && y.isEmpty(this.hlY.getData())) {
            bJY();
        }
    }

    public void onDestory() {
        if (this.gcx != null) {
            this.gcx.release();
            this.gcx.dettachView(this.mRootView);
        }
        if (this.hlV != null) {
            this.hlV.destory();
        }
    }

    public void cdV() {
        ArrayList arrayList;
        if (this.hlW != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                com.baidu.tieba.ala.personcenter.c.f fVar = new com.baidu.tieba.ala.personcenter.c.f();
                fVar.a(this.hlW);
                arrayList.add(fVar);
                m mVar = new m();
                mVar.a(this.hlW);
                arrayList.add(mVar);
                j jVar = new j();
                jVar.a(this.hlW);
                arrayList.add(jVar);
                k kVar = new k();
                kVar.a(this.hlW);
                arrayList.add(kVar);
                if (this.hlW.hml != null) {
                    com.baidu.tieba.ala.personcenter.c.d dVar = new com.baidu.tieba.ala.personcenter.c.d();
                    dVar.a(this.hlW);
                    arrayList.add(dVar);
                }
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.hlW);
                arrayList.add(hVar);
                l lVar = new l();
                lVar.a(this.hlW);
                arrayList.add(lVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.hlW);
                arrayList.add(gVar);
                e eVar = new e();
                eVar.a(this.hlW);
                arrayList.add(eVar);
                o oVar = new o();
                oVar.a(this.hlW);
                arrayList.add(oVar);
                n nVar = new n();
                nVar.a(this.hlW);
                arrayList.add(nVar);
            } else {
                arrayList = new ArrayList(4);
                com.baidu.tieba.ala.personcenter.c.f fVar2 = new com.baidu.tieba.ala.personcenter.c.f();
                fVar2.a(this.hlW);
                arrayList.add(fVar2);
            }
            this.hlX.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.hlX != null) {
            this.hlX.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.hlX != null) {
            this.hlX.setForumName(str);
        }
        if (!this.isInFrs) {
            this.hma = this.mNavigationBar.setCenterTextTitle(this.etO.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.etO.getResources().getString(R.string.forum));
        this.hma = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void HQ(String str) {
        if (this.hlX != null) {
            this.hlX.HQ(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void vP(int i) {
        if (i == 1) {
            this.hmb = true;
        }
    }

    public void onResume() {
        if (this.hmb) {
            this.hmb = false;
            loadData();
        }
    }
}
