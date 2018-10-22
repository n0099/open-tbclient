package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.a.d;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.concern.b;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import tbclient.Userlike.DataRes;
/* loaded from: classes6.dex */
public class ConcernPageView extends FrameLayout {
    private f bFV;
    private PbListView bJY;
    private View dCl;
    private BdTypeListView ehE;
    private com.baidu.tieba.homepage.concern.a ehT;
    private a ehU;
    private b ehV;
    private ConcernNotLoginLayout ehW;
    private boolean ehX;
    private b.a ehY;
    private View.OnClickListener ehZ;
    private CustomMessageListener eia;
    private int mHeaderViewHeight;
    private NoDataView mNoDataView;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes6.dex */
    public interface a {
        void E(boolean z, boolean z2);

        void oD(String str);

        void onPullToRefresh();
    }

    public void completePullRefresh() {
        if (this.ehE != null) {
            this.ehE.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ehT != null) {
            this.ehT.setPageUniqueId(bdUniqueId);
        }
        if (this.ehV != null) {
            this.ehV.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.eia != null) {
            this.eia.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.eia);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.ehX = false;
        this.mSkinType = 3;
        this.ehY = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIO() {
                if (ConcernPageView.this.ehU == null) {
                    if (ConcernPageView.this.ehW != null) {
                        ConcernPageView.this.ehW.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.C(false, false);
                    return;
                }
                boolean aIL = ConcernPageView.this.aIL();
                ConcernPageView.this.ZI();
                if (aIL) {
                    ConcernPageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                ConcernPageView.this.ehU.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void oC(String str) {
                if (ConcernPageView.this.ehU != null) {
                    ConcernPageView.this.ehU.oD(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.C(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.ehV != null) {
                        ConcernPageView.this.hw(ConcernPageView.this.ehV.hasMore());
                    }
                    if (j.kX()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.ehE.setVisibility(8);
                if (ConcernPageView.this.ehW != null) {
                    ConcernPageView.this.ehW.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void D(boolean z, boolean z2) {
                if (ConcernPageView.this.ehV != null) {
                    ConcernPageView.this.hw(ConcernPageView.this.ehV.hasMore());
                }
                ConcernPageView.this.ehE.setVisibility(0);
                ConcernPageView.this.C(z, z2);
                ConcernPageView.this.ZI();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIP() {
                ConcernPageView.this.C(true, false);
                ConcernPageView.this.ZI();
                if (v.J(ConcernPageView.this.ehE.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.ehZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.YL();
            }
        };
        this.eia = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ehX = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ehX = false;
        this.mSkinType = 3;
        this.ehY = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIO() {
                if (ConcernPageView.this.ehU == null) {
                    if (ConcernPageView.this.ehW != null) {
                        ConcernPageView.this.ehW.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.C(false, false);
                    return;
                }
                boolean aIL = ConcernPageView.this.aIL();
                ConcernPageView.this.ZI();
                if (aIL) {
                    ConcernPageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                ConcernPageView.this.ehU.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void oC(String str) {
                if (ConcernPageView.this.ehU != null) {
                    ConcernPageView.this.ehU.oD(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.C(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.ehV != null) {
                        ConcernPageView.this.hw(ConcernPageView.this.ehV.hasMore());
                    }
                    if (j.kX()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.ehE.setVisibility(8);
                if (ConcernPageView.this.ehW != null) {
                    ConcernPageView.this.ehW.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void D(boolean z, boolean z2) {
                if (ConcernPageView.this.ehV != null) {
                    ConcernPageView.this.hw(ConcernPageView.this.ehV.hasMore());
                }
                ConcernPageView.this.ehE.setVisibility(0);
                ConcernPageView.this.C(z, z2);
                ConcernPageView.this.ZI();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIP() {
                ConcernPageView.this.C(true, false);
                ConcernPageView.this.ZI();
                if (v.J(ConcernPageView.this.ehE.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.ehZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.YL();
            }
        };
        this.eia = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ehX = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ehX = false;
        this.mSkinType = 3;
        this.ehY = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIO() {
                if (ConcernPageView.this.ehU == null) {
                    if (ConcernPageView.this.ehW != null) {
                        ConcernPageView.this.ehW.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.C(false, false);
                    return;
                }
                boolean aIL = ConcernPageView.this.aIL();
                ConcernPageView.this.ZI();
                if (aIL) {
                    ConcernPageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                ConcernPageView.this.ehU.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void oC(String str) {
                if (ConcernPageView.this.ehU != null) {
                    ConcernPageView.this.ehU.oD(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.C(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.ehV != null) {
                        ConcernPageView.this.hw(ConcernPageView.this.ehV.hasMore());
                    }
                    if (j.kX()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.ehE.setVisibility(8);
                if (ConcernPageView.this.ehW != null) {
                    ConcernPageView.this.ehW.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void D(boolean z, boolean z2) {
                if (ConcernPageView.this.ehV != null) {
                    ConcernPageView.this.hw(ConcernPageView.this.ehV.hasMore());
                }
                ConcernPageView.this.ehE.setVisibility(0);
                ConcernPageView.this.C(z, z2);
                ConcernPageView.this.ZI();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIP() {
                ConcernPageView.this.C(true, false);
                ConcernPageView.this.ZI();
                if (v.J(ConcernPageView.this.ehE.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.ehZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.YL();
            }
        };
        this.eia = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ehX = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ehE = new BdTypeListView(context);
        this.ehE.setDividerHeight(0);
        this.ehE.setSelector(17170445);
        this.bJY = new PbListView(context);
        this.bJY.getView();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.setHeight(l.h(context, e.C0175e.tbds182));
        this.bJY.DL();
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.dU(e.d.cp_cont_e);
        this.bJY.setOnClickListener(this.ehZ);
        this.ehE.setNextPage(this.bJY);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new k(this.pageContext);
        this.ehE.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dCl = BdListViewHelper.a(context, this.ehE, BdListViewHelper.HeadType.DEFAULT);
        }
        this.ehT = new com.baidu.tieba.homepage.concern.a(context, this.ehE);
        this.ehV = new b(this.pageContext, this.ehE, this.ehT);
        addView(this.ehE);
        this.ehE.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dCl != null && this.dCl.getLayoutParams() != null) {
            this.dCl.getLayoutParams().height = i;
            this.dCl.setLayoutParams(this.dCl.getLayoutParams());
        }
        this.mHeaderViewHeight = i;
    }

    public void aDQ() {
        this.ehV.a(this.ehY);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.Ux().jp("page_concern");
                    ConcernPageView.this.ehV.update();
                }
            }
        });
        this.ehE.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.YL();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(boolean z) {
        if (this.bJY != null) {
            if (z) {
                this.bJY.DR();
                this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bJY.dY(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.ehU = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bJY != null) {
            this.bJY.DP();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ehV.a(z, dataRes, 0, null);
    }

    public void aIJ() {
        if (!TbadkCoreApplication.isLogin()) {
            aIM();
        } else if (this.ehV != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
            this.ehV.update();
        }
    }

    public void aIK() {
        if (!TbadkCoreApplication.isLogin()) {
            aIM();
        } else if (this.ehV != null) {
            this.ehV.aIQ();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.ehV != null) {
            this.ehV.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ehW != null) {
                this.ehW.onChangeSkinType(i);
            }
            if (this.bFV != null) {
                this.bFV.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dW(i);
            }
            if (this.bJY != null) {
                this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bJY.dW(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_b);
            }
            this.ehT.onChangeSkinType(i);
            al.j(this, e.d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void af(String str, int i) {
        if (this.bJY != null) {
            this.bJY.DP();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ehV.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.ehV != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.ehV.update();
                    }
                }
            });
        }
        this.refreshView.fB(getContext().getResources().getDimensionPixelSize(e.C0175e.ds280));
        this.refreshView.hU(str);
        this.refreshView.c(view, z);
        this.refreshView.My();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZI() {
        if (this.refreshView != null) {
            this.refreshView.ad(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, boolean z2) {
        if (this.bFV != null) {
            this.bFV.ad(this);
            this.bFV = null;
            this.ehE.setNextPage(this.bJY);
        }
        if (this.ehU != null) {
            this.ehU.E(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aIL() {
        if (this.refreshView != null) {
            return this.refreshView.Mq();
        }
        return false;
    }

    private void aIM() {
        if (this.ehW == null) {
            this.ehW = new ConcernNotLoginLayout(getContext());
            this.ehW.onChangeSkinType(this.mSkinType);
        }
        if (this.ehW.getParent() == null) {
            this.ehE.setVisibility(8);
            this.ehW.setVisibility(0);
            addView(this.ehW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bFV == null) {
            if (i < 0) {
                this.bFV = new f(getContext());
            } else {
                this.bFV = new f(getContext(), i);
            }
            this.bFV.onChangeSkinType();
        }
        this.bFV.c(this, z);
        this.ehE.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.tbds160) + this.mHeaderViewHeight;
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0175e.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(e.C0175e.ds320), dimensionPixelSize2), NoDataViewFactory.d.F(e.j.no_context_text, getResources().getDimensionPixelSize(e.C0175e.tbds50)), null);
            this.mNoDataView.setSubTitleTextSize(l.h(getContext(), e.C0175e.fontsize42));
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_b);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.bringToFront();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.ehV != null) {
            this.ehV.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.ehV != null) {
            this.ehV.gs(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ehV != null) {
            this.ehV.hx(z);
        }
    }

    public void reload() {
        if (this.ehE != null) {
            if (this.ehX && this.ehE.getFirstVisiblePosition() != 0) {
                this.ehX = false;
                return;
            }
            this.ehE.setSelection(0);
            if (this.ehE.isRefreshDone()) {
                this.ehE.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.ehV.a((b.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.ehE.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.ehE.setRecyclerListener(null);
    }

    public void aIN() {
        if (this.ehV != null) {
            this.ehV.gs(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YL() {
        if (this.bJY != null && !this.bJY.DU()) {
            this.bJY.DO();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ehV.YL();
    }
}
