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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes3.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext dPv;
    private int fPC;
    private NoNetworkView fns;
    private g fwo;
    private AlaPersonCenterModel gBl;
    private c gBm;
    private com.baidu.tieba.ala.personcenter.a.c gBn;
    private BdTypeListView gBo;
    private ImageView gBp;
    private TextView gBq;
    private boolean gBr;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean fPB = true;
    private boolean fuk = false;
    private boolean gBs = false;
    private CustomMessageListener gBt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.gBl != null) {
                a.this.gBl.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.fPC = 0;
        this.gBr = false;
        this.dPv = tbPageContext;
        this.gBr = z;
        this.fPC = (int) this.dPv.getResources().getDimension(R.dimen.ds400);
        this.gBl = new AlaPersonCenterModel(tbPageContext);
        this.gBl.a(this);
        eC(tbPageContext.getPageActivity());
    }

    private void btM() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.dPv.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.dPv.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.dPv.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.fuk) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fuk = true;
    }

    private void btN() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.fuk = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void eC(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.gBr) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.dPv.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.gBp = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.gBr) {
            this.gBq = this.mNavigationBar.setCenterTextTitle(this.dPv.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.dPv.getResources().getString(R.string.forum));
            this.gBq = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.fns = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.gBo = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.gBo.setItemsCanFocus(true);
        this.gBo.setVisibility(8);
        this.gBn = new com.baidu.tieba.ala.personcenter.a.c(this.dPv, this.gBo, this);
        this.gBn.jy(this.gBr);
        if (this.gBr) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.fwo = new g(this.dPv.getPageActivity());
        this.fwo.attachView(this.mRootView, false);
        this.gBo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.byO();
                a.this.byP();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byO() {
        if (Build.VERSION.SDK_INT >= 11 && this.gBo.getChildAt(0) != null) {
            int dimension = (int) this.dPv.getResources().getDimension(R.dimen.ds98);
            int i = this.fPC - (-this.gBo.getChildAt(0).getTop());
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
            if (this.gBo.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byP() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.fPB) {
                    this.fPB = true;
                }
            } else if (this.fPB) {
                this.fPB = false;
            }
            a(alpha, this.fPB ? false : true);
        }
    }

    protected void a(float f, boolean z) {
        if (z || this.fuk) {
            an.setNavbarIconSrc(this.gBp, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            an.setNavbarTitleColor(this.gBq, R.color.cp_cont_b, R.color.s_navbar_title_color);
        } else {
            an.setNavbarIconSrc(this.gBp, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            an.setNavbarTitleColor(this.gBq, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        this.gBq.setAlpha(f);
        this.gBp.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.dPv, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        an.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.cp_cont_a, R.color.cp_cont_a);
        an.setNavbarIconSrc(this.gBp, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.gBo.setDivider(an.getDrawable(i, (int) R.color.cp_bg_line_c));
        this.gBo.setDividerHeight(this.dPv.getResources().getDimensionPixelSize(R.dimen.ds2));
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.gBo.getAdapter() instanceof f) {
            this.gBo.getAdapter().notifyDataSetChanged();
            if (this.fwo != null) {
                this.fwo.onChangeSkinType();
            }
            this.fns.onChangeSkinType(this.dPv, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.dPv.getResources().getColor(R.color.cp_bg_line_h_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.dPv.getResources().getColor(R.color.cp_bg_line_d_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.dPv.getResources().getColor(R.color.cp_bg_line_h));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.dPv.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public void f(String str, String str2, String str3, boolean z) {
        this.gBl.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.gBl.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            btN();
            if ((obj instanceof c) && i == 1) {
                this.gBm = (c) obj;
                this.gBm.setIsHost(this.mIsHost);
                this.fwo.dettachView(this.mRootView);
                this.gBo.setVisibility(0);
                bLr();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.fwo != null) {
            this.fwo.dettachView(this.mRootView);
        }
        this.gBo.setVisibility(0);
        if (this.gBo != null && w.isEmpty(this.gBo.getData())) {
            btM();
        }
    }

    public void onDestory() {
        if (this.fwo != null) {
            this.fwo.release();
            this.fwo.dettachView(this.mRootView);
        }
        if (this.gBl != null) {
            this.gBl.destory();
        }
    }

    public void bLr() {
        ArrayList arrayList;
        if (this.gBm != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                e eVar = new e();
                eVar.a(this.gBm);
                arrayList.add(eVar);
                l lVar = new l();
                lVar.a(this.gBm);
                arrayList.add(lVar);
                i iVar = new i();
                iVar.a(this.gBm);
                arrayList.add(iVar);
                j jVar = new j();
                jVar.a(this.gBm);
                arrayList.add(jVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.gBm);
                arrayList.add(gVar);
                k kVar = new k();
                kVar.a(this.gBm);
                arrayList.add(kVar);
                com.baidu.tieba.ala.personcenter.c.f fVar = new com.baidu.tieba.ala.personcenter.c.f();
                fVar.a(this.gBm);
                arrayList.add(fVar);
                d dVar = new d();
                dVar.a(this.gBm);
                arrayList.add(dVar);
                n nVar = new n();
                nVar.a(this.gBm);
                arrayList.add(nVar);
                m mVar = new m();
                mVar.a(this.gBm);
                arrayList.add(mVar);
            } else {
                arrayList = new ArrayList(4);
                e eVar2 = new e();
                eVar2.a(this.gBm);
                arrayList.add(eVar2);
            }
            this.gBn.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.gBn != null) {
            this.gBn.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.gBn != null) {
            this.gBn.setForumName(str);
        }
        if (!this.gBr) {
            this.gBq = this.mNavigationBar.setCenterTextTitle(this.dPv.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.dPv.getResources().getString(R.string.forum));
        this.gBq = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void Dy(String str) {
        if (this.gBn != null) {
            this.gBn.Dy(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void sk(int i) {
        if (i == 1) {
            this.gBs = true;
        }
    }

    public void onResume() {
        if (this.gBs) {
            this.gBs = false;
            loadData();
        }
    }
}
