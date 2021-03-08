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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.a.d;
import com.baidu.tieba.ala.personcenter.c.c;
import com.baidu.tieba.ala.personcenter.c.f;
import com.baidu.tieba.ala.personcenter.c.j;
import com.baidu.tieba.ala.personcenter.c.k;
import com.baidu.tieba.ala.personcenter.c.l;
import com.baidu.tieba.ala.personcenter.c.m;
import com.baidu.tieba.ala.personcenter.c.n;
import com.baidu.tieba.ala.personcenter.c.o;
import com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a implements com.baidu.tieba.ala.personcenter.d.a, com.baidu.tieba.ala.personcenter.model.a {
    private TbPageContext eWx;
    private NoNetworkView gCe;
    private g gLk;
    private int hmt;
    private AlaPersonCenterModel ibk;
    private c ibl;
    private d ibm;
    private BdTypeListView ibn;
    private ImageView ibo;
    private TextView ibp;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean hms = true;
    private boolean gJg = false;
    private boolean ibq = false;
    private CustomMessageListener ibr = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.ibk != null) {
                a.this.ibk.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.hmt = 0;
        this.isInFrs = false;
        this.eWx = tbPageContext;
        this.isInFrs = z;
        this.hmt = (int) this.eWx.getResources().getDimension(R.dimen.ds400);
        this.ibk = new AlaPersonCenterModel(tbPageContext);
        this.ibk.a(this);
        ga(tbPageContext.getPageActivity());
    }

    private void bRH() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.eWx.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.eWx.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.eWx.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.gJg) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gJg = true;
    }

    private void Xc() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.gJg = false;
    }

    public View getView() {
        return this.mRootView;
    }

    private void ga(Context context) {
        this.mRootView = View.inflate(context, R.layout.ala_person_center_layout, null);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_person_center_navigation_bar);
        View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.isInFrs) {
            addSystemImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM);
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.eWx.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.ibo = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.ibp = this.mNavigationBar.setCenterTextTitle(this.eWx.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eWx.getResources().getString(R.string.forum));
            this.ibp = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.ibn = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.ibn.setItemsCanFocus(true);
        this.ibn.setVisibility(8);
        this.ibm = new d(this.eWx, this.ibn, this);
        this.ibm.mw(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gLk = new g(this.eWx.getPageActivity());
        this.gLk.attachView(this.mRootView, false);
        this.ibn.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bYz();
                a.this.bYA();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYz() {
        if (Build.VERSION.SDK_INT >= 11 && this.ibn.getChildAt(0) != null) {
            int dimension = (int) this.eWx.getResources().getDimension(R.dimen.ds98);
            int i = this.hmt - (-this.ibn.getChildAt(0).getTop());
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
            if (this.ibn.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYA() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.hms) {
                    this.hms = true;
                }
            } else if (this.hms) {
                this.hms = false;
            }
            b(alpha, this.hms ? false : true);
        }
    }

    protected void b(float f, boolean z) {
        if (z || this.gJg) {
            ap.setNavbarIconSrc(this.ibo, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ap.setNavbarTitleColor(this.ibp, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            ap.setNavbarIconSrc(this.ibo, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ap.setNavbarTitleColor(this.ibp, R.color.CAM_X0101, R.color.CAM_X0101);
        }
        this.ibp.setAlpha(f);
        this.ibo.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eWx, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ap.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
        ap.setNavbarIconSrc(this.ibo, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.ibn.setDivider(ap.getDrawable(i, R.color.CAM_X0204));
        this.ibn.setDividerHeight(this.eWx.getResources().getDimensionPixelSize(R.dimen.ds2));
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.ibn.getAdapter() instanceof e) {
            this.ibn.getAdapter().notifyDataSetChanged();
            if (this.gLk != null) {
                this.gLk.onChangeSkinType();
            }
            this.gCe.onChangeSkinType(this.eWx, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eWx.getResources().getColor(R.color.CAM_X0207_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eWx.getResources().getColor(R.color.CAM_X0201_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eWx.getResources().getColor(R.color.CAM_X0207));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eWx.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.ibk.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.ibk.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(Object obj, int i) {
        if (obj != null) {
            Xc();
            if ((obj instanceof c) && i == 1) {
                this.ibl = (c) obj;
                this.ibl.setIsHost(this.mIsHost);
                this.gLk.dettachView(this.mRootView);
                this.ibn.setVisibility(0);
                cmZ();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.gLk != null) {
            this.gLk.dettachView(this.mRootView);
        }
        this.ibn.setVisibility(0);
        if (this.ibn != null && y.isEmpty(this.ibn.getData())) {
            bRH();
        }
    }

    public void onDestory() {
        if (this.gLk != null) {
            this.gLk.release();
            this.gLk.dettachView(this.mRootView);
        }
        if (this.ibk != null) {
            this.ibk.destory();
        }
    }

    public void cmZ() {
        ArrayList arrayList;
        if (this.ibl != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                f fVar = new f();
                fVar.a(this.ibl);
                arrayList.add(fVar);
                m mVar = new m();
                mVar.a(this.ibl);
                arrayList.add(mVar);
                j jVar = new j();
                jVar.a(this.ibl);
                arrayList.add(jVar);
                k kVar = new k();
                kVar.a(this.ibl);
                arrayList.add(kVar);
                if (this.ibl.ibA != null) {
                    com.baidu.tieba.ala.personcenter.c.d dVar = new com.baidu.tieba.ala.personcenter.c.d();
                    dVar.a(this.ibl);
                    arrayList.add(dVar);
                }
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.ibl);
                arrayList.add(hVar);
                l lVar = new l();
                lVar.a(this.ibl);
                arrayList.add(lVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.ibl);
                arrayList.add(gVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.ibl);
                arrayList.add(eVar);
                o oVar = new o();
                oVar.a(this.ibl);
                arrayList.add(oVar);
                n nVar = new n();
                nVar.a(this.ibl);
                arrayList.add(nVar);
            } else {
                arrayList = new ArrayList(4);
                f fVar2 = new f();
                fVar2.a(this.ibl);
                arrayList.add(fVar2);
            }
            this.ibm.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.ibm != null) {
            this.ibm.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.ibm != null) {
            this.ibm.setForumName(str);
        }
        if (!this.isInFrs) {
            this.ibp = this.mNavigationBar.setCenterTextTitle(this.eWx.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eWx.getResources().getString(R.string.forum));
        this.ibp = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void Iw(String str) {
        if (this.ibm != null) {
            this.ibm.Iw(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void ws(int i) {
        if (i == 1) {
            this.ibq = true;
        }
    }

    public void onResume() {
        if (this.ibq) {
            this.ibq = false;
            loadData();
        }
    }
}
