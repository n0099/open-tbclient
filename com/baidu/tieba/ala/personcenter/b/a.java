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
    private TbPageContext duG;
    private NoNetworkView ePl;
    private g eYb;
    private AlaPersonCenterModel fZl;
    private c fZm;
    private com.baidu.tieba.ala.personcenter.a.c fZn;
    private BdTypeListView fZo;
    private ImageView fZp;
    private TextView fZq;
    private boolean fZr;
    private int fqj;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean fqi = true;
    private boolean eVX = false;
    private boolean fZs = false;
    private CustomMessageListener fZt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.fZl != null) {
                a.this.fZl.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.fqj = 0;
        this.fZr = false;
        this.duG = tbPageContext;
        this.fZr = z;
        this.fqj = (int) this.duG.getResources().getDimension(R.dimen.ds400);
        this.fZl = new AlaPersonCenterModel(tbPageContext);
        this.fZl.a(this);
        ey(tbPageContext.getPageActivity());
    }

    private void bls() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.duG.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.duG.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.duG.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.eVX) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.eVX = true;
    }

    private void blt() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.eVX = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void ey(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.fZr) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.duG.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.fZp = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.fZr) {
            this.fZq = this.mNavigationBar.setCenterTextTitle(this.duG.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.duG.getResources().getString(R.string.forum));
            this.fZq = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.ePl = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.fZo = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.fZo.setItemsCanFocus(true);
        this.fZo.setVisibility(8);
        this.fZn = new com.baidu.tieba.ala.personcenter.a.c(this.duG, this.fZo, this);
        this.fZn.ld(this.fZr);
        if (this.fZr) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eYb = new g(this.duG.getPageActivity());
        this.eYb.attachView(this.mRootView, false);
        this.fZo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bqa();
                a.this.bqb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqa() {
        if (Build.VERSION.SDK_INT >= 11 && this.fZo.getChildAt(0) != null) {
            int dimension = (int) this.duG.getResources().getDimension(R.dimen.ds98);
            int i = this.fqj - (-this.fZo.getChildAt(0).getTop());
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
            if (this.fZo.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqb() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.fqi) {
                    this.fqi = true;
                }
            } else if (this.fqi) {
                this.fqi = false;
            }
            a(alpha, this.fqi ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.eVX) {
            am.setNavbarIconSrc(this.fZp, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.fZq, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.fZp, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.fZq, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.fZq.setAlpha(f);
        this.fZp.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.duG, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.fZp, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.fZo.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.fZo.setDividerHeight(this.duG.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.fZo.getAdapter() instanceof e) {
            this.fZo.getAdapter().notifyDataSetChanged();
            if (this.eYb != null) {
                this.eYb.onChangeSkinType();
            }
            this.ePl.onChangeSkinType(this.duG, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.duG.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.duG.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.duG.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.duG.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.fZl.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.fZl.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            blt();
            if ((obj instanceof c) && i == 1) {
                this.fZm = (c) obj;
                this.fZm.setIsHost(this.mIsHost);
                this.eYb.dettachView(this.mRootView);
                this.fZo.setVisibility(0);
                bBT();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.eYb != null) {
            this.eYb.dettachView(this.mRootView);
        }
        this.fZo.setVisibility(0);
        if (this.fZo != null && v.isEmpty(this.fZo.getData())) {
            bls();
        }
    }

    public void onDestory() {
        if (this.eYb != null) {
            this.eYb.release();
            this.eYb.dettachView(this.mRootView);
        }
        if (this.fZl != null) {
            this.fZl.destory();
        }
    }

    public void bBT() {
        ArrayList arrayList;
        if (this.fZm != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.fZm);
                arrayList.add(eVar);
                l lVar = new l();
                lVar.a(this.fZm);
                arrayList.add(lVar);
                i iVar = new i();
                iVar.a(this.fZm);
                arrayList.add(iVar);
                j jVar = new j();
                jVar.a(this.fZm);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.fZm);
                arrayList.add(gVar);
                k kVar = new k();
                kVar.a(this.fZm);
                arrayList.add(kVar);
                f fVar = new f();
                fVar.a(this.fZm);
                arrayList.add(fVar);
                d dVar = new d();
                dVar.a(this.fZm);
                arrayList.add(dVar);
                n nVar = new n();
                nVar.a(this.fZm);
                arrayList.add(nVar);
                m mVar = new m();
                mVar.a(this.fZm);
                arrayList.add(mVar);
            } else {
                arrayList = new ArrayList(4);
                com.baidu.tieba.ala.personcenter.c.e eVar2 = new com.baidu.tieba.ala.personcenter.c.e();
                eVar2.a(this.fZm);
                arrayList.add(eVar2);
            }
            this.fZn.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.fZn != null) {
            this.fZn.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.fZn != null) {
            this.fZn.setForumName(str);
        }
        if (!this.fZr) {
            this.fZq = this.mNavigationBar.setCenterTextTitle(this.duG.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.duG.getResources().getString(R.string.forum));
        this.fZq = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void Bl(String str) {
        if (this.fZn != null) {
            this.fZn.Bl(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void rh(int i) {
        if (i == 1) {
            this.fZs = true;
        }
    }

    public void onResume() {
        if (this.fZs) {
            this.fZs = false;
            loadData();
        }
    }
}
