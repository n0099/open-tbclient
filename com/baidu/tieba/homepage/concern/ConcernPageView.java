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
    private BdTypeListView ehD;
    private com.baidu.tieba.homepage.concern.a ehS;
    private a ehT;
    private b ehU;
    private ConcernNotLoginLayout ehV;
    private boolean ehW;
    private b.a ehX;
    private View.OnClickListener ehY;
    private CustomMessageListener ehZ;
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
        if (this.ehD != null) {
            this.ehD.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ehS != null) {
            this.ehS.setPageUniqueId(bdUniqueId);
        }
        if (this.ehU != null) {
            this.ehU.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.ehZ != null) {
            this.ehZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ehZ);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.ehW = false;
        this.mSkinType = 3;
        this.ehX = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIO() {
                if (ConcernPageView.this.ehT == null) {
                    if (ConcernPageView.this.ehV != null) {
                        ConcernPageView.this.ehV.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.C(false, false);
                    return;
                }
                boolean aIL = ConcernPageView.this.aIL();
                ConcernPageView.this.ZH();
                if (aIL) {
                    ConcernPageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                ConcernPageView.this.ehT.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void oC(String str) {
                if (ConcernPageView.this.ehT != null) {
                    ConcernPageView.this.ehT.oD(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.C(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.ehU != null) {
                        ConcernPageView.this.hw(ConcernPageView.this.ehU.hasMore());
                    }
                    if (j.kX()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.ehD.setVisibility(8);
                if (ConcernPageView.this.ehV != null) {
                    ConcernPageView.this.ehV.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void D(boolean z, boolean z2) {
                if (ConcernPageView.this.ehU != null) {
                    ConcernPageView.this.hw(ConcernPageView.this.ehU.hasMore());
                }
                ConcernPageView.this.ehD.setVisibility(0);
                ConcernPageView.this.C(z, z2);
                ConcernPageView.this.ZH();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIP() {
                ConcernPageView.this.C(true, false);
                ConcernPageView.this.ZH();
                if (v.J(ConcernPageView.this.ehD.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.ehY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.YK();
            }
        };
        this.ehZ = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ehW = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ehW = false;
        this.mSkinType = 3;
        this.ehX = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIO() {
                if (ConcernPageView.this.ehT == null) {
                    if (ConcernPageView.this.ehV != null) {
                        ConcernPageView.this.ehV.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.C(false, false);
                    return;
                }
                boolean aIL = ConcernPageView.this.aIL();
                ConcernPageView.this.ZH();
                if (aIL) {
                    ConcernPageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                ConcernPageView.this.ehT.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void oC(String str) {
                if (ConcernPageView.this.ehT != null) {
                    ConcernPageView.this.ehT.oD(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.C(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.ehU != null) {
                        ConcernPageView.this.hw(ConcernPageView.this.ehU.hasMore());
                    }
                    if (j.kX()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.ehD.setVisibility(8);
                if (ConcernPageView.this.ehV != null) {
                    ConcernPageView.this.ehV.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void D(boolean z, boolean z2) {
                if (ConcernPageView.this.ehU != null) {
                    ConcernPageView.this.hw(ConcernPageView.this.ehU.hasMore());
                }
                ConcernPageView.this.ehD.setVisibility(0);
                ConcernPageView.this.C(z, z2);
                ConcernPageView.this.ZH();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIP() {
                ConcernPageView.this.C(true, false);
                ConcernPageView.this.ZH();
                if (v.J(ConcernPageView.this.ehD.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.ehY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.YK();
            }
        };
        this.ehZ = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ehW = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ehW = false;
        this.mSkinType = 3;
        this.ehX = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIO() {
                if (ConcernPageView.this.ehT == null) {
                    if (ConcernPageView.this.ehV != null) {
                        ConcernPageView.this.ehV.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.C(false, false);
                    return;
                }
                boolean aIL = ConcernPageView.this.aIL();
                ConcernPageView.this.ZH();
                if (aIL) {
                    ConcernPageView.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
                }
                ConcernPageView.this.ehT.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void oC(String str) {
                if (ConcernPageView.this.ehT != null) {
                    ConcernPageView.this.ehT.oD(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.C(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.ehU != null) {
                        ConcernPageView.this.hw(ConcernPageView.this.ehU.hasMore());
                    }
                    if (j.kX()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.ehD.setVisibility(8);
                if (ConcernPageView.this.ehV != null) {
                    ConcernPageView.this.ehV.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void D(boolean z, boolean z2) {
                if (ConcernPageView.this.ehU != null) {
                    ConcernPageView.this.hw(ConcernPageView.this.ehU.hasMore());
                }
                ConcernPageView.this.ehD.setVisibility(0);
                ConcernPageView.this.C(z, z2);
                ConcernPageView.this.ZH();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aIP() {
                ConcernPageView.this.C(true, false);
                ConcernPageView.this.ZH();
                if (v.J(ConcernPageView.this.ehD.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.ehY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.YK();
            }
        };
        this.ehZ = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ehW = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ehD = new BdTypeListView(context);
        this.ehD.setDividerHeight(0);
        this.ehD.setSelector(17170445);
        this.bJY = new PbListView(context);
        this.bJY.getView();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.setHeight(l.h(context, e.C0175e.tbds182));
        this.bJY.DL();
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.dU(e.d.cp_cont_e);
        this.bJY.setOnClickListener(this.ehY);
        this.ehD.setNextPage(this.bJY);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new k(this.pageContext);
        this.ehD.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dCl = BdListViewHelper.a(context, this.ehD, BdListViewHelper.HeadType.DEFAULT);
        }
        this.ehS = new com.baidu.tieba.homepage.concern.a(context, this.ehD);
        this.ehU = new b(this.pageContext, this.ehD, this.ehS);
        addView(this.ehD);
        this.ehD.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dCl != null && this.dCl.getLayoutParams() != null) {
            this.dCl.getLayoutParams().height = i;
            this.dCl.setLayoutParams(this.dCl.getLayoutParams());
        }
        this.mHeaderViewHeight = i;
    }

    public void aDP() {
        this.ehU.a(this.ehX);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.Ux().jp("page_concern");
                    ConcernPageView.this.ehU.update();
                }
            }
        });
        this.ehD.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.YK();
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
        this.ehT = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bJY != null) {
            this.bJY.DP();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ehU.a(z, dataRes, 0, null);
    }

    public void aIJ() {
        if (!TbadkCoreApplication.isLogin()) {
            aIM();
        } else if (this.ehU != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds520));
            this.ehU.update();
        }
    }

    public void aIK() {
        if (!TbadkCoreApplication.isLogin()) {
            aIM();
        } else if (this.ehU != null) {
            this.ehU.aIQ();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.ehU != null) {
            this.ehU.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ehV != null) {
                this.ehV.onChangeSkinType(i);
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
            this.ehS.onChangeSkinType(i);
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
        this.ehU.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.ehU != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.ehU.update();
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
    public void ZH() {
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
            this.ehD.setNextPage(this.bJY);
        }
        if (this.ehT != null) {
            this.ehT.E(z, z2);
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
        if (this.ehV == null) {
            this.ehV = new ConcernNotLoginLayout(getContext());
            this.ehV.onChangeSkinType(this.mSkinType);
        }
        if (this.ehV.getParent() == null) {
            this.ehD.setVisibility(8);
            this.ehV.setVisibility(0);
            addView(this.ehV);
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
        this.ehD.setNextPage(null);
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
        if (this.ehU != null) {
            this.ehU.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.ehU != null) {
            this.ehU.gs(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ehU != null) {
            this.ehU.hx(z);
        }
    }

    public void reload() {
        if (this.ehD != null) {
            if (this.ehW && this.ehD.getFirstVisiblePosition() != 0) {
                this.ehW = false;
                return;
            }
            this.ehD.setSelection(0);
            if (this.ehD.isRefreshDone()) {
                this.ehD.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.ehU.a((b.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.ehD.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.ehD.setRecyclerListener(null);
    }

    public void aIN() {
        if (this.ehU != null) {
            this.ehU.gs(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YK() {
        if (this.bJY != null && !this.bJY.DU()) {
            this.bJY.DO();
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.ehU.YK();
    }
}
