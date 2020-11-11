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
    private TbPageContext eIc;
    private int gQc;
    private NoNetworkView gjn;
    private g gso;
    private AlaPersonCenterModel hDN;
    private c hDO;
    private d hDP;
    private BdTypeListView hDQ;
    private ImageView hDR;
    private TextView hDS;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean gQb = true;
    private boolean gqk = false;
    private boolean hDT = false;
    private CustomMessageListener hDU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hDN != null) {
                a.this.hDN.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.gQc = 0;
        this.isInFrs = false;
        this.eIc = tbPageContext;
        this.isInFrs = z;
        this.gQc = (int) this.eIc.getResources().getDimension(R.dimen.ds400);
        this.hDN = new AlaPersonCenterModel(tbPageContext);
        this.hDN.a(this);
        fe(tbPageContext.getPageActivity());
    }

    private void bPa() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.eIc.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.eIc.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.eIc.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.gqk) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gqk = true;
    }

    private void Wk() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.gqk = false;
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
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.eIc.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.hDR = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.hDS = this.mNavigationBar.setCenterTextTitle(this.eIc.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eIc.getResources().getString(R.string.forum));
            this.hDS = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.gjn = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.hDQ = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.hDQ.setItemsCanFocus(true);
        this.hDQ.setVisibility(8);
        this.hDP = new d(this.eIc, this.hDQ, this);
        this.hDP.lD(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gso = new g(this.eIc.getPageActivity());
        this.gso.attachView(this.mRootView, false);
        this.hDQ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bVv();
                a.this.bVw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVv() {
        if (Build.VERSION.SDK_INT >= 11 && this.hDQ.getChildAt(0) != null) {
            int dimension = (int) this.eIc.getResources().getDimension(R.dimen.ds98);
            int i = this.gQc - (-this.hDQ.getChildAt(0).getTop());
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
            if (this.hDQ.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVw() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.gQb) {
                    this.gQb = true;
                }
            } else if (this.gQb) {
                this.gQb = false;
            }
            a(alpha, this.gQb ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.gqk) {
            ap.setNavbarIconSrc(this.hDR, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.hDS, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.hDR, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.hDS, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.hDS.setAlpha(f);
        this.hDR.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eIc, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        ap.setNavbarIconSrc(this.hDR, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.hDQ.setDivider(ap.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.hDQ.setDividerHeight(this.eIc.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.hDQ.getAdapter() instanceof f) {
            this.hDQ.getAdapter().notifyDataSetChanged();
            if (this.gso != null) {
                this.gso.onChangeSkinType();
            }
            this.gjn.onChangeSkinType(this.eIc, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eIc.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eIc.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eIc.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eIc.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.hDN.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.hDN.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            Wk();
            if ((obj instanceof c) && i == 1) {
                this.hDO = (c) obj;
                this.hDO.setIsHost(this.mIsHost);
                this.gso.dettachView(this.mRootView);
                this.hDQ.setVisibility(0);
                cjz();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.gso != null) {
            this.gso.dettachView(this.mRootView);
        }
        this.hDQ.setVisibility(0);
        if (this.hDQ != null && y.isEmpty(this.hDQ.getData())) {
            bPa();
        }
    }

    public void onDestory() {
        if (this.gso != null) {
            this.gso.release();
            this.gso.dettachView(this.mRootView);
        }
        if (this.hDN != null) {
            this.hDN.destory();
        }
    }

    public void cjz() {
        ArrayList arrayList;
        if (this.hDO != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                com.baidu.tieba.ala.personcenter.c.f fVar = new com.baidu.tieba.ala.personcenter.c.f();
                fVar.a(this.hDO);
                arrayList.add(fVar);
                m mVar = new m();
                mVar.a(this.hDO);
                arrayList.add(mVar);
                j jVar = new j();
                jVar.a(this.hDO);
                arrayList.add(jVar);
                k kVar = new k();
                kVar.a(this.hDO);
                arrayList.add(kVar);
                if (this.hDO.hEd != null) {
                    com.baidu.tieba.ala.personcenter.c.d dVar = new com.baidu.tieba.ala.personcenter.c.d();
                    dVar.a(this.hDO);
                    arrayList.add(dVar);
                }
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.hDO);
                arrayList.add(hVar);
                l lVar = new l();
                lVar.a(this.hDO);
                arrayList.add(lVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.hDO);
                arrayList.add(gVar);
                e eVar = new e();
                eVar.a(this.hDO);
                arrayList.add(eVar);
                o oVar = new o();
                oVar.a(this.hDO);
                arrayList.add(oVar);
                n nVar = new n();
                nVar.a(this.hDO);
                arrayList.add(nVar);
            } else {
                arrayList = new ArrayList(4);
                com.baidu.tieba.ala.personcenter.c.f fVar2 = new com.baidu.tieba.ala.personcenter.c.f();
                fVar2.a(this.hDO);
                arrayList.add(fVar2);
            }
            this.hDP.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.hDP != null) {
            this.hDP.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.hDP != null) {
            this.hDP.setForumName(str);
        }
        if (!this.isInFrs) {
            this.hDS = this.mNavigationBar.setCenterTextTitle(this.eIc.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eIc.getResources().getString(R.string.forum));
        this.hDS = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void IG(String str) {
        if (this.hDP != null) {
            this.hDP.IG(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void ww(int i) {
        if (i == 1) {
            this.hDT = true;
        }
    }

    public void onResume() {
        if (this.hDT) {
            this.hDT = false;
            loadData();
        }
    }
}
