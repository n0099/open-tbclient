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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private TbPageContext eSJ;
    private g gGD;
    private NoNetworkView gxx;
    private AlaPersonCenterModel hUS;
    private c hUT;
    private d hUU;
    private BdTypeListView hUV;
    private ImageView hUW;
    private TextView hUX;
    private int hgg;
    private boolean isInFrs;
    private String mForumId;
    private String mForumName;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    private h mRefreshView;
    private View mRootView;
    private boolean hgf = true;
    private boolean gEz = false;
    private boolean hUY = false;
    private CustomMessageListener hUZ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_LIVE_USER_AUTHENT_UPLOAD_FINISH) { // from class: com.baidu.tieba.ala.personcenter.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.hUS != null) {
                a.this.hUS.loadData();
            }
        }
    };

    public a(TbPageContext tbPageContext, boolean z) {
        this.hgg = 0;
        this.isInFrs = false;
        this.eSJ = tbPageContext;
        this.isInFrs = z;
        this.hgg = (int) this.eSJ.getResources().getDimension(R.dimen.ds400);
        this.hUS = new AlaPersonCenterModel(tbPageContext);
        this.hUS.a(this);
        ga(tbPageContext.getPageActivity());
    }

    private void bQQ() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.eSJ.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.loadData();
                }
            });
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.setLayoutMargin(this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds340));
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.eSJ.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.onChangeSkinType();
        if (!this.gEz) {
            ((ViewGroup) this.mRootView).addView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gEz = true;
    }

    private void Vq() {
        if (this.mRefreshView != null && this.mRefreshView.getAttachedView().getParent() != null) {
            ((ViewGroup) this.mRefreshView.getAttachedView().getParent()).removeView(this.mRefreshView.getAttachedView());
        }
        this.gEz = false;
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
                    customResponsedMessage.setmOrginalMessage(new CustomMessage((int) CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE, a.this.eSJ.getUniqueId()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            });
        }
        this.hUW = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.showBottomLine(false);
        if (!this.isInFrs) {
            this.hUX = this.mNavigationBar.setCenterTextTitle(this.eSJ.getString(R.string.ala_live));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eSJ.getResources().getString(R.string.forum));
            this.hUX = this.mNavigationBar.setCenterTextTitle(sb.toString());
        }
        this.gxx = (NoNetworkView) this.mRootView.findViewById(R.id.ala_person_center_no_network_view);
        this.hUV = (BdTypeListView) this.mRootView.findViewById(R.id.ala_person_center_listview);
        this.hUV.setItemsCanFocus(true);
        this.hUV.setVisibility(8);
        this.hUU = new d(this.eSJ, this.hUV, this);
        this.hUU.ms(this.isInFrs);
        if (this.isInFrs) {
            this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.gGD = new g(this.eSJ.getPageActivity());
        this.gGD.attachView(this.mRootView, false);
        this.hUV.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.personcenter.b.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                a.this.bXm();
                a.this.bXn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXm() {
        if (Build.VERSION.SDK_INT >= 11 && this.hUV.getChildAt(0) != null) {
            int dimension = (int) this.eSJ.getResources().getDimension(R.dimen.ds98);
            int i = this.hgg - (-this.hUV.getChildAt(0).getTop());
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
            if (this.hUV.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXn() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                alpha = 1.0f - alpha;
                if (!this.hgf) {
                    this.hgf = true;
                }
            } else if (this.hgf) {
                this.hgf = false;
            }
            b(alpha, this.hgf ? false : true);
        }
    }

    protected void b(float f, boolean z) {
        if (z || this.gEz) {
            ao.setNavbarIconSrc(this.hUW, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            ao.setNavbarTitleColor(this.hUX, R.color.CAM_X0105, R.color.s_navbar_title_color);
        } else {
            ao.setNavbarIconSrc(this.hUW, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
            ao.setNavbarTitleColor(this.hUX, R.color.CAM_X0101, R.color.CAM_X0101);
        }
        this.hUX.setAlpha(f);
        this.hUW.setAlpha(f);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eSJ, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ao.setNavbarTitleColor(this.mNavigationBar.mTextTitle, R.color.CAM_X0101, R.color.CAM_X0101);
        ao.setNavbarIconSrc(this.hUW, R.drawable.selector_topbar_return_white, R.drawable.selector_topbar_return_white_1);
        this.hUV.setDivider(ao.getDrawable(i, R.color.CAM_X0204));
        this.hUV.setDividerHeight(this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds2));
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        if (this.hUV.getAdapter() instanceof e) {
            this.hUV.getAdapter().notifyDataSetChanged();
            if (this.gGD != null) {
                this.gGD.onChangeSkinType();
            }
            this.gxx.onChangeSkinType(this.eSJ, i);
            if (i == 1) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eSJ.getResources().getColor(R.color.CAM_X0207_1));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eSJ.getResources().getColor(R.color.CAM_X0201_1));
            } else if (i == 0) {
                this.mNavigationBar.getBarBgView().setBackgroundColor(this.eSJ.getResources().getColor(R.color.CAM_X0207));
                this.mNavigationBar.getTopCoverBgView().setBackgroundColor(this.eSJ.getResources().getColor(R.color.CAM_X0201));
            }
        }
    }

    public void h(String str, String str2, String str3, boolean z) {
        this.hUS.setUid(str);
        this.mIsHost = z;
    }

    public void loadData() {
        this.hUS.loadData();
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void d(Object obj, int i) {
        if (obj != null) {
            Vq();
            if ((obj instanceof c) && i == 1) {
                this.hUT = (c) obj;
                this.hUT.setIsHost(this.mIsHost);
                this.gGD.dettachView(this.mRootView);
                this.hUV.setVisibility(0);
                clO();
            }
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.model.a
    public void c(int i, String str, Object obj) {
        if (this.gGD != null) {
            this.gGD.dettachView(this.mRootView);
        }
        this.hUV.setVisibility(0);
        if (this.hUV != null && x.isEmpty(this.hUV.getData())) {
            bQQ();
        }
    }

    public void onDestory() {
        if (this.gGD != null) {
            this.gGD.release();
            this.gGD.dettachView(this.mRootView);
        }
        if (this.hUS != null) {
            this.hUS.destory();
        }
    }

    public void clO() {
        ArrayList arrayList;
        if (this.hUT != null) {
            if (this.mIsHost) {
                arrayList = new ArrayList(10);
                f fVar = new f();
                fVar.a(this.hUT);
                arrayList.add(fVar);
                m mVar = new m();
                mVar.a(this.hUT);
                arrayList.add(mVar);
                j jVar = new j();
                jVar.a(this.hUT);
                arrayList.add(jVar);
                k kVar = new k();
                kVar.a(this.hUT);
                arrayList.add(kVar);
                if (this.hUT.hVi != null) {
                    com.baidu.tieba.ala.personcenter.c.d dVar = new com.baidu.tieba.ala.personcenter.c.d();
                    dVar.a(this.hUT);
                    arrayList.add(dVar);
                }
                com.baidu.tieba.ala.personcenter.c.h hVar = new com.baidu.tieba.ala.personcenter.c.h();
                hVar.a(this.hUT);
                arrayList.add(hVar);
                l lVar = new l();
                lVar.a(this.hUT);
                arrayList.add(lVar);
                com.baidu.tieba.ala.personcenter.c.g gVar = new com.baidu.tieba.ala.personcenter.c.g();
                gVar.a(this.hUT);
                arrayList.add(gVar);
                com.baidu.tieba.ala.personcenter.c.e eVar = new com.baidu.tieba.ala.personcenter.c.e();
                eVar.a(this.hUT);
                arrayList.add(eVar);
                o oVar = new o();
                oVar.a(this.hUT);
                arrayList.add(oVar);
                n nVar = new n();
                nVar.a(this.hUT);
                arrayList.add(nVar);
            } else {
                arrayList = new ArrayList(4);
                f fVar2 = new f();
                fVar2.a(this.hUT);
                arrayList.add(fVar2);
            }
            this.hUU.setData(arrayList);
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
        if (this.hUU != null) {
            this.hUU.setForumId(str);
        }
    }

    public void setForumName(String str) {
        this.mForumName = str;
        if (this.hUU != null) {
            this.hUU.setForumName(str);
        }
        if (!this.isInFrs) {
            this.hUX = this.mNavigationBar.setCenterTextTitle(this.eSJ.getString(R.string.ala_live));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.mForumName, 5, true, true) + this.eSJ.getResources().getString(R.string.forum));
        this.hUX = this.mNavigationBar.setCenterTextTitle(sb.toString());
    }

    public void HI(String str) {
        if (this.hUU != null) {
            this.hUU.HI(str);
        }
    }

    @Override // com.baidu.tieba.ala.personcenter.d.a
    public void wg(int i) {
        if (i == 1) {
            this.hUY = true;
        }
    }

    public void onResume() {
        if (this.hUY) {
            this.hUY = false;
            loadData();
        }
    }
}
