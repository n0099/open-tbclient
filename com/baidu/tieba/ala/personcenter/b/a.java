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
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext cVi;
    private int eLu;
    private NoNetworkView elv;
    private g euk;
    private AlaPersonCenterModel fui;
    private b fuj;
    private c fuk;
    private BdTypeListView ful;
    private ImageView fum;
    private TextView fun;
    private boolean fuo;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean eLt = true;
    private boolean esf = false;
    private boolean fup = false;
    private CustomMessageListener fuq = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.fui != null) {
                a.this.fui.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.eLu = 0;
        this.fuo = false;
        this.cVi = tbPageContext;
        this.fuo = z;
        this.eLu = (int) this.cVi.getResources().getDimension(R.dimen.ds400);
        this.fui = new AlaPersonCenterModel(tbPageContext);
        this.fui.a(this);
        eJ(tbPageContext.getPageActivity());
    }

    private void bcx() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.cVi.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.cVi.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.cVi.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.esf) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.esf = true;
    }

    private void bcy() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.esf = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eJ(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.fuo) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.cVi.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.fum = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.fuo) {
            this.fun = this.mNavigationBar.setCenterTextTitle(this.cVi.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cVi.getResources().getString(R.string.forum));
            this.fun = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.elv = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.ful = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.ful.setItemsCanFocus(true);
        this.ful.setVisibility(8);
        this.fuk = new c(this.cVi, this.ful, this);
        if (this.fuo) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.euk = new g(this.cVi.getPageActivity());
        this.euk.attachView(this.mRootView, false);
        this.ful.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bgE();
                a.this.bgF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgE() {
        if (Build.VERSION.SDK_INT >= 11 && this.ful.getChildAt(0) != null) {
            int dimension = (int) this.cVi.getResources().getDimension(R.dimen.ds98);
            int i = this.eLu - (-this.ful.getChildAt(0).getTop());
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
            if (this.ful.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgF() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.eLt) {
                    this.eLt = true;
                }
            } else if (this.eLt) {
                this.eLt = false;
            }
            a(alpha, this.eLt ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.esf) {
            am.setNavbarIconSrc(this.fum, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.fun, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.fum, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.fun, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.fun.setAlpha(f);
        this.fum.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cVi, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.fum, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.ful.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.ful.setDividerHeight(this.cVi.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.ful.getAdapter() instanceof e) {
            this.ful.getAdapter().notifyDataSetChanged();
            if (this.euk != null) {
                this.euk.onChangeSkinType();
            }
            this.elv.onChangeSkinType(this.cVi, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cVi.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cVi.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cVi.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cVi.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.fui.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.fui.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void b(Object obj, int i) {
        if (obj != null) {
            bcy();
            if ((obj instanceof b) && i == 1) {
                this.fuj = (b) obj;
                this.fuj.setIsHost(this.mIsHost);
                this.euk.dettachView(this.mRootView);
                this.ful.setVisibility(0);
                bsh();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.euk != null) {
            this.euk.dettachView(this.mRootView);
        }
        this.ful.setVisibility(0);
        if (this.ful != null && v.isEmpty(this.ful.getData())) {
            bcx();
        }
    }

    public void onDestory() {
        if (this.euk != null) {
            this.euk.release();
            this.euk.dettachView(this.mRootView);
        }
        if (this.fui != null) {
            this.fui.destory();
        }
    }

    public void bsh() {
        ArrayList arrayList;
        if (this.fuj != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                d dVar = new d();
                dVar.a(this.fuj);
                arrayList.add(dVar);
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.fuj);
                arrayList.add(hVar);
                i iVar = new i();
                iVar.a(this.fuj);
                arrayList.add(iVar);
                f fVar = new f();
                fVar.a(this.fuj);
                arrayList.add(fVar);
                j jVar = new j();
                jVar.a(this.fuj);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.fuj);
                arrayList.add(eVar);
                com.baidu.tieba.ala.personcenter.c.c cVar = new com.baidu.tieba.ala.personcenter.c.c();
                cVar.a(this.fuj);
                arrayList.add(cVar);
                k kVar = new k();
                kVar.a(this.fuj);
                arrayList.add(kVar);
            } else {
                arrayList = new ArrayList(4);
                d dVar2 = new d();
                dVar2.a(this.fuj);
                arrayList.add(dVar2);
            }
            this.fuk.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (!this.fuo) {
            this.fun = this.mNavigationBar.setCenterTextTitle(this.cVi.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cVi.getResources().getString(R.string.forum));
        this.fun = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void qM(int i) {
        if (i == 1) {
            this.fup = true;
        }
    }

    public void onResume() {
        if (this.fup) {
            this.fup = false;
            loadData();
        }
    }
}
