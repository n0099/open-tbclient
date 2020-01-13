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
import com.baidu.tieba.ala.personcenter.a.c;
import com.baidu.tieba.ala.personcenter.c.b;
import com.baidu.tieba.ala.personcenter.c.d;
import com.baidu.tieba.ala.personcenter.c.f;
import com.baidu.tieba.ala.personcenter.c.i;
import com.baidu.tieba.ala.personcenter.c.j;
import com.baidu.tieba.ala.personcenter.c.k;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext cRe;
    private int eHm;
    private NoNetworkView ehd;
    private g epL;
    private AlaPersonCenterModel frr;
    private b frt;
    private c fru;
    private BdTypeListView frv;
    private ImageView frw;
    private TextView frx;
    private boolean fry;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean eHl = true;
    private boolean enF = false;
    private boolean frz = false;
    private CustomMessageListener frA = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.frr != null) {
                a.this.frr.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.eHm = 0;
        this.fry = false;
        this.cRe = tbPageContext;
        this.fry = z;
        this.eHm = (int) this.cRe.getResources().getDimension(R.dimen.ds400);
        this.frr = new AlaPersonCenterModel(tbPageContext);
        this.frr.a(this);
        eG(tbPageContext.getPageActivity());
    }

    private void bae() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.cRe.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.cRe.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.cRe.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.enF) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.enF = true;
    }

    private void baf() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.enF = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eG(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.fry) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.cRe.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.frw = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.fry) {
            this.frx = this.mNavigationBar.setCenterTextTitle(this.cRe.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cRe.getResources().getString(R.string.forum));
            this.frx = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.ehd = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.frv = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.frv.setItemsCanFocus(true);
        this.frv.setVisibility(8);
        this.fru = new c(this.cRe, this.frv, this);
        if (this.fry) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.epL = new g(this.cRe.getPageActivity());
        this.epL.attachView(this.mRootView, false);
        this.frv.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.ber();
                a.this.bes();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ber() {
        if (Build.VERSION.SDK_INT >= 11 && this.frv.getChildAt(0) != null) {
            int dimension = (int) this.cRe.getResources().getDimension(R.dimen.ds98);
            int i = this.eHm - (-this.frv.getChildAt(0).getTop());
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
            if (this.frv.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bes() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.eHl) {
                    this.eHl = true;
                }
            } else if (this.eHl) {
                this.eHl = false;
            }
            a(alpha, this.eHl ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.enF) {
            am.setNavbarIconSrc(this.frw, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.frx, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.frw, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.frx, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.frx.setAlpha(f);
        this.frw.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cRe, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.frw, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.frv.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.frv.setDividerHeight(this.cRe.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.frv.getAdapter() instanceof e) {
            this.frv.getAdapter().notifyDataSetChanged();
            if (this.epL != null) {
                this.epL.onChangeSkinType();
            }
            this.ehd.onChangeSkinType(this.cRe, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cRe.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cRe.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cRe.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cRe.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.frr.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.frr.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void b(Object obj, int i) {
        if (obj != null) {
            baf();
            if ((obj instanceof b) && i == 1) {
                this.frt = (b) obj;
                this.frt.setIsHost(this.mIsHost);
                this.epL.dettachView(this.mRootView);
                this.frv.setVisibility(0);
                bqA();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.epL != null) {
            this.epL.dettachView(this.mRootView);
        }
        this.frv.setVisibility(0);
        if (this.frv != null && v.isEmpty(this.frv.getData())) {
            bae();
        }
    }

    public void onDestory() {
        if (this.epL != null) {
            this.epL.release();
            this.epL.dettachView(this.mRootView);
        }
        if (this.frr != null) {
            this.frr.destory();
        }
    }

    public void bqA() {
        ArrayList arrayList;
        if (this.frt != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                d dVar = new d();
                dVar.a(this.frt);
                arrayList.add(dVar);
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.frt);
                arrayList.add(hVar);
                i iVar = new i();
                iVar.a(this.frt);
                arrayList.add(iVar);
                f fVar = new f();
                fVar.a(this.frt);
                arrayList.add(fVar);
                j jVar = new j();
                jVar.a(this.frt);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.frt);
                arrayList.add(eVar);
                com.baidu.tieba.ala.personcenter.c.c cVar = new com.baidu.tieba.ala.personcenter.c.c();
                cVar.a(this.frt);
                arrayList.add(cVar);
                k kVar = new k();
                kVar.a(this.frt);
                arrayList.add(kVar);
            } else {
                arrayList = new ArrayList(4);
                d dVar2 = new d();
                dVar2.a(this.frt);
                arrayList.add(dVar2);
            }
            this.fru.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (!this.fry) {
            this.frx = this.mNavigationBar.setCenterTextTitle(this.cRe.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cRe.getResources().getString(R.string.forum));
        this.frx = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void qF(int i) {
        if (i == 1) {
            this.frz = true;
        }
    }

    public void onResume() {
        if (this.frz) {
            this.frz = false;
            loadData();
        }
    }
}
