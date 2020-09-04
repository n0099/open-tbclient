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
    private TbPageContext efr;
    private NoNetworkView fDZ;
    private g fMR;
    private AlaPersonCenterModel gTo;
    private c gTp;
    private com.baidu.tieba.ala.personcenter.a.c gTq;
    private BdTypeListView gTr;
    private ImageView gTs;
    private TextView gTt;
    private boolean gTu;
    private int ggY;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean ggX = true;
    private boolean fKN = false;
    private boolean gTv = false;
    private CustomMessageListener gTw = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gTo != null) {
                a.this.gTo.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.ggY = 0;
        this.gTu = false;
        this.efr = tbPageContext;
        this.gTu = z;
        this.ggY = (int) this.efr.getResources().getDimension(R.dimen.ds400);
        this.gTo = new AlaPersonCenterModel(tbPageContext);
        this.gTo.a(this);
        eQ(tbPageContext.getPageActivity());
    }

    private void bFW() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.efr.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.efr.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.efr.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.fKN) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fKN = true;
    }

    private void bFX() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.fKN = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eQ(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.gTu) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.efr.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.gTs = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.gTu) {
            this.gTt = this.mNavigationBar.setCenterTextTitle(this.efr.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.efr.getResources().getString(R.string.forum));
            this.gTt = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.fDZ = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.gTr = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.gTr.setItemsCanFocus(true);
        this.gTr.setVisibility(8);
        this.gTq = new com.baidu.tieba.ala.personcenter.a.c(this.efr, this.gTr, this);
        this.gTq.kC(this.gTu);
        if (this.gTu) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fMR = new g(this.efr.getPageActivity());
        this.fMR.attachView(this.mRootView, false);
        this.gTr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bLy();
                a.this.bLz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        if (Build.VERSION.SDK_INT >= 11 && this.gTr.getChildAt(0) != null) {
            int dimension = (int) this.efr.getResources().getDimension(R.dimen.ds98);
            int i = this.ggY - (-this.gTr.getChildAt(0).getTop());
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
            if (this.gTr.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLz() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.ggX) {
                    this.ggX = true;
                }
            } else if (this.ggX) {
                this.ggX = false;
            }
            a(alpha, this.ggX ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.fKN) {
            ap.setNavbarIconSrc(this.gTs, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.gTt, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.gTs, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.gTt, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.gTt.setAlpha(f);
        this.gTs.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.efr, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        ap.setNavbarIconSrc(this.gTs, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.gTr.setDivider(ap.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.gTr.setDividerHeight(this.efr.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.gTr.getAdapter() instanceof f) {
            this.gTr.getAdapter().notifyDataSetChanged();
            if (this.fMR != null) {
                this.fMR.onChangeSkinType();
            }
            this.fDZ.onChangeSkinType(this.efr, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.efr.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.efr.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.efr.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.efr.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.gTo.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.gTo.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            bFX();
            if ((obj instanceof c) && i == 1) {
                this.gTp = (c) obj;
                this.gTp.setIsHost(this.mIsHost);
                this.fMR.dettachView(this.mRootView);
                this.gTr.setVisibility(0);
                bYB();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.fMR != null) {
            this.fMR.dettachView(this.mRootView);
        }
        this.gTr.setVisibility(0);
        if (this.gTr != null && y.isEmpty(this.gTr.getData())) {
            bFW();
        }
    }

    public void onDestory() {
        if (this.fMR != null) {
            this.fMR.release();
            this.fMR.dettachView(this.mRootView);
        }
        if (this.gTo != null) {
            this.gTo.destory();
        }
    }

    public void bYB() {
        ArrayList arrayList;
        if (this.gTp != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                e eVar = new e();
                eVar.a(this.gTp);
                arrayList.add(eVar);
                l lVar = new l();
                lVar.a(this.gTp);
                arrayList.add(lVar);
                i iVar = new i();
                iVar.a(this.gTp);
                arrayList.add(iVar);
                j jVar = new j();
                jVar.a(this.gTp);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.gTp);
                arrayList.add(gVar);
                k kVar = new k();
                kVar.a(this.gTp);
                arrayList.add(kVar);
                com.baidu.tieba.ala.personcenter.c.f fVar = new com.baidu.tieba.ala.personcenter.c.f();
                fVar.a(this.gTp);
                arrayList.add(fVar);
                d dVar = new d();
                dVar.a(this.gTp);
                arrayList.add(dVar);
                n nVar = new n();
                nVar.a(this.gTp);
                arrayList.add(nVar);
                m mVar = new m();
                mVar.a(this.gTp);
                arrayList.add(mVar);
            } else {
                arrayList = new ArrayList(4);
                e eVar2 = new e();
                eVar2.a(this.gTp);
                arrayList.add(eVar2);
            }
            this.gTq.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.gTq != null) {
            this.gTq.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.gTq != null) {
            this.gTq.setForumName(str);
        }
        if (!this.gTu) {
            this.gTt = this.mNavigationBar.setCenterTextTitle(this.efr.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.efr.getResources().getString(R.string.forum));
        this.gTt = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void GJ(String str) {
        if (this.gTq != null) {
            this.gTq.GJ(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void uQ(int i) {
        if (i == 1) {
            this.gTv = true;
        }
    }

    public void onResume() {
        if (this.gTv) {
            this.gTv = false;
            loadData();
        }
    }
}
