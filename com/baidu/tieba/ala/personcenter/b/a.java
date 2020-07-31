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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private TbPageContext dVN;
    private g fBv;
    private int fUV;
    private NoNetworkView fsB;
    private AlaPersonCenterModel gGI;
    private c gGJ;
    private com.baidu.tieba.ala.personcenter.a.c gGK;
    private BdTypeListView gGL;
    private ImageView gGM;
    private TextView gGN;
    private boolean gGO;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean fUU = true;
    private boolean fzr = false;
    private boolean gGP = false;
    private CustomMessageListener gGQ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gGI != null) {
                a.this.gGI.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.fUV = 0;
        this.gGO = false;
        this.dVN = tbPageContext;
        this.gGO = z;
        this.fUV = (int) this.dVN.getResources().getDimension(R.dimen.ds400);
        this.gGI = new AlaPersonCenterModel(tbPageContext);
        this.gGI.a(this);
        eG(tbPageContext.getPageActivity());
    }

    private void bwW() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.dVN.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.dVN.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.fzr) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fzr = true;
    }

    private void bwX() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.fzr = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eG(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.gGO) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.dVN.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.gGM = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.gGO) {
            this.gGN = this.mNavigationBar.setCenterTextTitle(this.dVN.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.dVN.getResources().getString(R.string.forum));
            this.gGN = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.fsB = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.gGL = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.gGL.setItemsCanFocus(true);
        this.gGL.setVisibility(8);
        this.gGK = new com.baidu.tieba.ala.personcenter.a.c(this.dVN, this.gGL, this);
        this.gGK.kc(this.gGO);
        if (this.gGO) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fBv = new g(this.dVN.getPageActivity());
        this.fBv.attachView(this.mRootView, false);
        this.gGL.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bCd();
                a.this.bCe();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCd() {
        if (Build.VERSION.SDK_INT >= 11 && this.gGL.getChildAt(0) != null) {
            int dimension = (int) this.dVN.getResources().getDimension(R.dimen.ds98);
            int i = this.fUV - (-this.gGL.getChildAt(0).getTop());
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
            if (this.gGL.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCe() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.fUU) {
                    this.fUU = true;
                }
            } else if (this.fUU) {
                this.fUU = false;
            }
            a(alpha, this.fUU ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.fzr) {
            ao.setNavbarIconSrc(this.gGM, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ao.setNavbarTitleColor(this.gGN, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            ao.setNavbarIconSrc(this.gGM, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ao.setNavbarTitleColor(this.gGN, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.gGN.setAlpha(f);
        this.gGM.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dVN, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ao.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        ao.setNavbarIconSrc(this.gGM, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.gGL.setDivider(ao.getDrawable(i, R.color.cp_bg_line_c));
        this.gGL.setDividerHeight(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds2));
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.gGL.getAdapter() instanceof f) {
            this.gGL.getAdapter().notifyDataSetChanged();
            if (this.fBv != null) {
                this.fBv.onChangeSkinType();
            }
            this.fsB.onChangeSkinType(this.dVN, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.dVN.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.dVN.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.dVN.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.dVN.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.gGI.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.gGI.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            bwX();
            if ((obj instanceof c) && i == 1) {
                this.gGJ = (c) obj;
                this.gGJ.setIsHost(this.mIsHost);
                this.fBv.dettachView(this.mRootView);
                this.gGL.setVisibility(0);
                bOA();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.fBv != null) {
            this.fBv.dettachView(this.mRootView);
        }
        this.gGL.setVisibility(0);
        if (this.gGL != null && x.isEmpty(this.gGL.getData())) {
            bwW();
        }
    }

    public void onDestory() {
        if (this.fBv != null) {
            this.fBv.release();
            this.fBv.dettachView(this.mRootView);
        }
        if (this.gGI != null) {
            this.gGI.destory();
        }
    }

    public void bOA() {
        ArrayList arrayList;
        if (this.gGJ != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                e eVar = new e();
                eVar.a(this.gGJ);
                arrayList.add(eVar);
                l lVar = new l();
                lVar.a(this.gGJ);
                arrayList.add(lVar);
                i iVar = new i();
                iVar.a(this.gGJ);
                arrayList.add(iVar);
                j jVar = new j();
                jVar.a(this.gGJ);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.gGJ);
                arrayList.add(gVar);
                k kVar = new k();
                kVar.a(this.gGJ);
                arrayList.add(kVar);
                com.baidu.tieba.ala.personcenter.c.f fVar = new com.baidu.tieba.ala.personcenter.c.f();
                fVar.a(this.gGJ);
                arrayList.add(fVar);
                d dVar = new d();
                dVar.a(this.gGJ);
                arrayList.add(dVar);
                n nVar = new n();
                nVar.a(this.gGJ);
                arrayList.add(nVar);
                m mVar = new m();
                mVar.a(this.gGJ);
                arrayList.add(mVar);
            } else {
                arrayList = new ArrayList(4);
                e eVar2 = new e();
                eVar2.a(this.gGJ);
                arrayList.add(eVar2);
            }
            this.gGK.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.gGK != null) {
            this.gGK.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.gGK != null) {
            this.gGK.setForumName(str);
        }
        if (!this.gGO) {
            this.gGN = this.mNavigationBar.setCenterTextTitle(this.dVN.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.dVN.getResources().getString(R.string.forum));
        this.gGN = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void Ej(String str) {
        if (this.gGK != null) {
            this.gGK.Ej(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void sC(int i) {
        if (i == 1) {
            this.gGP = true;
        }
    }

    public void onResume() {
        if (this.gGP) {
            this.gGP = false;
            loadData();
        }
    }
}
