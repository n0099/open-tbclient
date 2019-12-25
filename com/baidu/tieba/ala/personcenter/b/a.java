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
    private TbPageContext cQU;
    private int eGc;
    private NoNetworkView egT;
    private g eoy;
    private AlaPersonCenterModel foi;
    private b foj;
    private c fok;
    private BdTypeListView fol;
    private ImageView fom;
    private TextView fon;
    private boolean foo;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean eGb = true;
    private boolean emG = false;
    private boolean fop = false;
    private CustomMessageListener foq = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.foi != null) {
                a.this.foi.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.eGc = 0;
        this.foo = false;
        this.cQU = tbPageContext;
        this.foo = z;
        this.eGc = (int) this.cQU.getResources().getDimension(R.dimen.ds400);
        this.foi = new AlaPersonCenterModel(tbPageContext);
        this.foi.a(this);
        eG(tbPageContext.getPageActivity());
    }

    private void aZJ() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.cQU.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.cQU.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.cQU.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.emG) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.emG = true;
    }

    private void aZK() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.emG = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eG(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.foo) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.cQU.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.fom = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.foo) {
            this.fon = this.mNavigationBar.setCenterTextTitle(this.cQU.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cQU.getResources().getString(R.string.forum));
            this.fon = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.egT = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.fol = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.fol.setItemsCanFocus(true);
        this.fol.setVisibility(8);
        this.fok = new c(this.cQU, this.fol, this);
        if (this.foo) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eoy = new g(this.cQU.getPageActivity());
        this.eoy.attachView(this.mRootView, false);
        this.fol.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bdW();
                a.this.bdX();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdW() {
        if (Build.VERSION.SDK_INT >= 11 && this.fol.getChildAt(0) != null) {
            int dimension = (int) this.cQU.getResources().getDimension(R.dimen.ds98);
            int i = this.eGc - (-this.fol.getChildAt(0).getTop());
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
            if (this.fol.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdX() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.eGb) {
                    this.eGb = true;
                }
            } else if (this.eGb) {
                this.eGb = false;
            }
            a(alpha, this.eGb ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.emG) {
            am.setNavbarIconSrc(this.fom, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            am.setNavbarTitleColor(this.fon, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            am.setNavbarIconSrc(this.fom, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            am.setNavbarTitleColor(this.fon, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.fon.setAlpha(f);
        this.fom.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cQU, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        am.setNavbarIconSrc(this.fom, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.fol.setDivider(am.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.fol.setDividerHeight(this.cQU.getResources().getDimensionPixelSize(R.dimen.ds2));
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.fol.getAdapter() instanceof e) {
            this.fol.getAdapter().notifyDataSetChanged();
            if (this.eoy != null) {
                this.eoy.onChangeSkinType();
            }
            this.egT.onChangeSkinType(this.cQU, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cQU.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cQU.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.cQU.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.cQU.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.foi.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.foi.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void b(Object obj, int i) {
        if (obj != null) {
            aZK();
            if ((obj instanceof b) && i == 1) {
                this.foj = (b) obj;
                this.foj.setIsHost(this.mIsHost);
                this.eoy.dettachView(this.mRootView);
                this.fol.setVisibility(0);
                bpz();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.eoy != null) {
            this.eoy.dettachView(this.mRootView);
        }
        this.fol.setVisibility(0);
        if (this.fol != null && v.isEmpty(this.fol.getData())) {
            aZJ();
        }
    }

    public void onDestory() {
        if (this.eoy != null) {
            this.eoy.release();
            this.eoy.dettachView(this.mRootView);
        }
        if (this.foi != null) {
            this.foi.destory();
        }
    }

    public void bpz() {
        ArrayList arrayList;
        if (this.foj != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                d dVar = new d();
                dVar.a(this.foj);
                arrayList.add(dVar);
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.foj);
                arrayList.add(hVar);
                i iVar = new i();
                iVar.a(this.foj);
                arrayList.add(iVar);
                f fVar = new f();
                fVar.a(this.foj);
                arrayList.add(fVar);
                j jVar = new j();
                jVar.a(this.foj);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.foj);
                arrayList.add(eVar);
                com.baidu.tieba.ala.personcenter.c.c cVar = new com.baidu.tieba.ala.personcenter.c.c();
                cVar.a(this.foj);
                arrayList.add(cVar);
                k kVar = new k();
                kVar.a(this.foj);
                arrayList.add(kVar);
            } else {
                arrayList = new ArrayList(4);
                d dVar2 = new d();
                dVar2.a(this.foj);
                arrayList.add(dVar2);
            }
            this.fok.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (!this.foo) {
            this.fon = this.mNavigationBar.setCenterTextTitle(this.cQU.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.cQU.getResources().getString(R.string.forum));
        this.fon = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void qA(int i) {
        if (i == 1) {
            this.fop = true;
        }
    }

    public void onResume() {
        if (this.fop) {
            this.fop = false;
            loadData();
        }
    }
}
