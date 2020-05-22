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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.c;
import com.baidu.tieba.ala.personcenter.c.d;
import com.baidu.tieba.ala.personcenter.c.f;
import com.baidu.tieba.ala.personcenter.c.i;
import com.baidu.tieba.ala.personcenter.c.j;
import com.baidu.tieba.ala.personcenter.c.k;
import com.baidu.tieba.ala.personcenter.c.l;
import com.baidu.tieba.ala.personcenter.c.m;
import com.baidu.tieba.ala.personcenter.c.n;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext dIF;
    private int fEi;
    private NoNetworkView fbX;
    private g fkQ;
    private AlaPersonCenterModel gok;
    private c gol;
    private com.baidu.tieba.ala.personcenter.a.c gom;
    private BdTypeListView gon;
    private ImageView goo;
    private TextView gop;
    private boolean goq;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean fEh = true;
    private boolean fiM = false;
    private boolean gor = false;
    private CustomMessageListener gos = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gok != null) {
                a.this.gok.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.fEi = 0;
        this.goq = false;
        this.dIF = tbPageContext;
        this.goq = z;
        this.fEi = (int) this.dIF.getResources().getDimension(R.dimen.ds400);
        this.gok = new AlaPersonCenterModel(tbPageContext);
        this.gok.a(this);
        eB(tbPageContext.getPageActivity());
    }

    private void bqN() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.dIF.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.dIF.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.fiM) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fiM = true;
    }

    private void bqO() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.fiM = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eB(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.goq) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.dIF.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.goo = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.goq) {
            this.gop = this.mNavigationBar.setCenterTextTitle(this.dIF.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.dIF.getResources().getString(R.string.forum));
            this.gop = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.fbX = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.gon = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.gon.setItemsCanFocus(true);
        this.gon.setVisibility(8);
        this.gom = new com.baidu.tieba.ala.personcenter.a.c(this.dIF, this.gon, this);
        this.gom.jl(this.goq);
        if (this.goq) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fkQ = new g(this.dIF.getPageActivity());
        this.fkQ.attachView(this.mRootView, false);
        this.gon.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bvR();
                a.this.bvS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvR() {
        if (Build.VERSION.SDK_INT >= 11 && this.gon.getChildAt(0) != null) {
            int dimension = (int) this.dIF.getResources().getDimension(R.dimen.ds98);
            int i = this.fEi - (-this.gon.getChildAt(0).getTop());
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
            if (this.gon.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvS() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.fEh) {
                    this.fEh = true;
                }
            } else if (this.fEh) {
                this.fEh = false;
            }
            a(alpha, this.fEh ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.fiM) {
            am.setNavbarIconSrc(this.goo, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.gop, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.goo, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.gop, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.gop.setAlpha(f);
        this.goo.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dIF, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.goo, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.gon.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.gon.setDividerHeight(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.gon.getAdapter() instanceof e) {
            this.gon.getAdapter().notifyDataSetChanged();
            if (this.fkQ != null) {
                this.fkQ.onChangeSkinType();
            }
            this.fbX.onChangeSkinType(this.dIF, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.dIF.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.dIF.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.dIF.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.dIF.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.gok.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.gok.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            bqO();
            if ((obj instanceof c) && i == 1) {
                this.gol = (c) obj;
                this.gol.setIsHost(this.mIsHost);
                this.fkQ.dettachView(this.mRootView);
                this.gon.setVisibility(0);
                bIk();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this.mRootView);
        }
        this.gon.setVisibility(0);
        if (this.gon != null && v.isEmpty(this.gon.getData())) {
            bqN();
        }
    }

    public void onDestory() {
        if (this.fkQ != null) {
            this.fkQ.release();
            this.fkQ.dettachView(this.mRootView);
        }
        if (this.gok != null) {
            this.gok.destory();
        }
    }

    public void bIk() {
        ArrayList arrayList;
        if (this.gol != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.gol);
                arrayList.add(eVar);
                l lVar = new l();
                lVar.a(this.gol);
                arrayList.add(lVar);
                i iVar = new i();
                iVar.a(this.gol);
                arrayList.add(iVar);
                j jVar = new j();
                jVar.a(this.gol);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.gol);
                arrayList.add(gVar);
                k kVar = new k();
                kVar.a(this.gol);
                arrayList.add(kVar);
                f fVar = new f();
                fVar.a(this.gol);
                arrayList.add(fVar);
                d dVar = new d();
                dVar.a(this.gol);
                arrayList.add(dVar);
                n nVar = new n();
                nVar.a(this.gol);
                arrayList.add(nVar);
                m mVar = new m();
                mVar.a(this.gol);
                arrayList.add(mVar);
            } else {
                arrayList = new ArrayList(4);
                com.baidu.tieba.ala.personcenter.c.e eVar2 = new com.baidu.tieba.ala.personcenter.c.e();
                eVar2.a(this.gol);
                arrayList.add(eVar2);
            }
            this.gom.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.gom != null) {
            this.gom.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.gom != null) {
            this.gom.setForumName(str);
        }
        if (!this.goq) {
            this.gop = this.mNavigationBar.setCenterTextTitle(this.dIF.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.dIF.getResources().getString(R.string.forum));
        this.gop = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void CX(String str) {
        if (this.gom != null) {
            this.gom.CX(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void rK(int i) {
        if (i == 1) {
            this.gor = true;
        }
    }

    public void onResume() {
        if (this.gor) {
            this.gor = false;
            loadData();
        }
    }
}
