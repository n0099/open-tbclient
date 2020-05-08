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
    private TbPageContext duK;
    private NoNetworkView ePq;
    private g eYg;
    private AlaPersonCenterModel fZq;
    private c fZr;
    private com.baidu.tieba.ala.personcenter.a.c fZs;
    private BdTypeListView fZt;
    private ImageView fZu;
    private TextView fZv;
    private boolean fZw;
    private int fqo;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean fqn = true;
    private boolean eWc = false;
    private boolean fZx = false;
    private CustomMessageListener fZy = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.fZq != null) {
                a.this.fZq.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.fqo = 0;
        this.fZw = false;
        this.duK = tbPageContext;
        this.fZw = z;
        this.fqo = (int) this.duK.getResources().getDimension(R.dimen.ds400);
        this.fZq = new AlaPersonCenterModel(tbPageContext);
        this.fZq.a(this);
        em(tbPageContext.getPageActivity());
    }

    private void blq() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.duK.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.duK.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.duK.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.eWc) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.eWc = true;
    }

    private void blr() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.eWc = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void em(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.fZw) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.duK.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.fZu = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.fZw) {
            this.fZv = this.mNavigationBar.setCenterTextTitle(this.duK.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.duK.getResources().getString(R.string.forum));
            this.fZv = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.ePq = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.fZt = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.fZt.setItemsCanFocus(true);
        this.fZt.setVisibility(8);
        this.fZs = new com.baidu.tieba.ala.personcenter.a.c(this.duK, this.fZt, this);
        this.fZs.ld(this.fZw);
        if (this.fZw) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eYg = new g(this.duK.getPageActivity());
        this.eYg.attachView(this.mRootView, false);
        this.fZt.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bpY();
                a.this.bpZ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpY() {
        if (Build.VERSION.SDK_INT >= 11 && this.fZt.getChildAt(0) != null) {
            int dimension = (int) this.duK.getResources().getDimension(R.dimen.ds98);
            int i = this.fqo - (-this.fZt.getChildAt(0).getTop());
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
            if (this.fZt.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpZ() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.fqn) {
                    this.fqn = true;
                }
            } else if (this.fqn) {
                this.fqn = false;
            }
            a(alpha, this.fqn ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.eWc) {
            am.setNavbarIconSrc(this.fZu, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.fZv, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.fZu, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.fZv, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.fZv.setAlpha(f);
        this.fZu.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.duK, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.fZu, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.fZt.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.fZt.setDividerHeight(this.duK.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.fZt.getAdapter() instanceof e) {
            this.fZt.getAdapter().notifyDataSetChanged();
            if (this.eYg != null) {
                this.eYg.onChangeSkinType();
            }
            this.ePq.onChangeSkinType(this.duK, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.duK.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.duK.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.duK.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.duK.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.fZq.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.fZq.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            blr();
            if ((obj instanceof c) && i == 1) {
                this.fZr = (c) obj;
                this.fZr.setIsHost(this.mIsHost);
                this.eYg.dettachView(this.mRootView);
                this.fZt.setVisibility(0);
                bBR();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.eYg != null) {
            this.eYg.dettachView(this.mRootView);
        }
        this.fZt.setVisibility(0);
        if (this.fZt != null && v.isEmpty(this.fZt.getData())) {
            blq();
        }
    }

    public void onDestory() {
        if (this.eYg != null) {
            this.eYg.release();
            this.eYg.dettachView(this.mRootView);
        }
        if (this.fZq != null) {
            this.fZq.destory();
        }
    }

    public void bBR() {
        ArrayList arrayList;
        if (this.fZr != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.fZr);
                arrayList.add(eVar);
                l lVar = new l();
                lVar.a(this.fZr);
                arrayList.add(lVar);
                i iVar = new i();
                iVar.a(this.fZr);
                arrayList.add(iVar);
                j jVar = new j();
                jVar.a(this.fZr);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.fZr);
                arrayList.add(gVar);
                k kVar = new k();
                kVar.a(this.fZr);
                arrayList.add(kVar);
                f fVar = new f();
                fVar.a(this.fZr);
                arrayList.add(fVar);
                d dVar = new d();
                dVar.a(this.fZr);
                arrayList.add(dVar);
                n nVar = new n();
                nVar.a(this.fZr);
                arrayList.add(nVar);
                m mVar = new m();
                mVar.a(this.fZr);
                arrayList.add(mVar);
            } else {
                arrayList = new ArrayList(4);
                com.baidu.tieba.ala.personcenter.c.e eVar2 = new com.baidu.tieba.ala.personcenter.c.e();
                eVar2.a(this.fZr);
                arrayList.add(eVar2);
            }
            this.fZs.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.fZs != null) {
            this.fZs.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.fZs != null) {
            this.fZs.setForumName(str);
        }
        if (!this.fZw) {
            this.fZv = this.mNavigationBar.setCenterTextTitle(this.duK.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.duK.getResources().getString(R.string.forum));
        this.fZv = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void Bo(String str) {
        if (this.fZs != null) {
            this.fZs.Bo(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void rh(int i) {
        if (i == 1) {
            this.fZx = true;
        }
    }

    public void onResume() {
        if (this.fZx) {
            this.fZx = false;
            loadData();
        }
    }
}
