package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.a.d;
import com.baidu.tieba.f;
import com.baidu.tieba.homepage.concern.b;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernPageView extends FrameLayout {
    private int aui;
    private f brv;
    private PbListView bvC;
    private com.baidu.tieba.homepage.concern.a dSI;
    private a dSJ;
    private b dSK;
    private ConcernNotLoginLayout dSL;
    private boolean dSM;
    private b.a dSN;
    private View.OnClickListener dSO;
    private CustomMessageListener dSP;
    private BdTypeListView dSt;
    private View don;
    private NoDataView mNoDataView;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void B(boolean z, boolean z2);

        void nu(String str);

        void onPullToRefresh();
    }

    public void completePullRefresh() {
        if (this.dSt != null) {
            this.dSt.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dSI != null) {
            this.dSI.setPageUniqueId(bdUniqueId);
        }
        if (this.dSK != null) {
            this.dSK.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.dSP != null) {
            this.dSP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dSP);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.dSM = false;
        this.mSkinType = 3;
        this.dSN = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDj() {
                if (ConcernPageView.this.dSJ == null) {
                    if (ConcernPageView.this.dSL != null) {
                        ConcernPageView.this.dSL.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(f.j.neterror), true);
                    ConcernPageView.this.z(false, false);
                    return;
                }
                boolean aDg = ConcernPageView.this.aDg();
                ConcernPageView.this.Un();
                if (aDg) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds520));
                }
                ConcernPageView.this.dSJ.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nt(String str) {
                if (ConcernPageView.this.dSJ != null) {
                    ConcernPageView.this.dSJ.nu(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.z(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.dSK != null) {
                        ConcernPageView.this.gG(ConcernPageView.this.dSK.hasMore());
                    }
                    if (j.jE()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dSt.setVisibility(8);
                if (ConcernPageView.this.dSL != null) {
                    ConcernPageView.this.dSL.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void A(boolean z, boolean z2) {
                if (ConcernPageView.this.dSK != null) {
                    ConcernPageView.this.gG(ConcernPageView.this.dSK.hasMore());
                }
                ConcernPageView.this.dSt.setVisibility(0);
                ConcernPageView.this.z(z, z2);
                ConcernPageView.this.Un();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDk() {
                ConcernPageView.this.z(true, false);
                ConcernPageView.this.Un();
                if (w.z(ConcernPageView.this.dSt.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Tq();
            }
        };
        this.dSP = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dSM = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dSM = false;
        this.mSkinType = 3;
        this.dSN = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDj() {
                if (ConcernPageView.this.dSJ == null) {
                    if (ConcernPageView.this.dSL != null) {
                        ConcernPageView.this.dSL.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(f.j.neterror), true);
                    ConcernPageView.this.z(false, false);
                    return;
                }
                boolean aDg = ConcernPageView.this.aDg();
                ConcernPageView.this.Un();
                if (aDg) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds520));
                }
                ConcernPageView.this.dSJ.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nt(String str) {
                if (ConcernPageView.this.dSJ != null) {
                    ConcernPageView.this.dSJ.nu(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.z(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.dSK != null) {
                        ConcernPageView.this.gG(ConcernPageView.this.dSK.hasMore());
                    }
                    if (j.jE()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dSt.setVisibility(8);
                if (ConcernPageView.this.dSL != null) {
                    ConcernPageView.this.dSL.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void A(boolean z, boolean z2) {
                if (ConcernPageView.this.dSK != null) {
                    ConcernPageView.this.gG(ConcernPageView.this.dSK.hasMore());
                }
                ConcernPageView.this.dSt.setVisibility(0);
                ConcernPageView.this.z(z, z2);
                ConcernPageView.this.Un();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDk() {
                ConcernPageView.this.z(true, false);
                ConcernPageView.this.Un();
                if (w.z(ConcernPageView.this.dSt.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Tq();
            }
        };
        this.dSP = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dSM = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dSM = false;
        this.mSkinType = 3;
        this.dSN = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDj() {
                if (ConcernPageView.this.dSJ == null) {
                    if (ConcernPageView.this.dSL != null) {
                        ConcernPageView.this.dSL.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(f.j.neterror), true);
                    ConcernPageView.this.z(false, false);
                    return;
                }
                boolean aDg = ConcernPageView.this.aDg();
                ConcernPageView.this.Un();
                if (aDg) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds520));
                }
                ConcernPageView.this.dSJ.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nt(String str) {
                if (ConcernPageView.this.dSJ != null) {
                    ConcernPageView.this.dSJ.nu(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.z(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.dSK != null) {
                        ConcernPageView.this.gG(ConcernPageView.this.dSK.hasMore());
                    }
                    if (j.jE()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dSt.setVisibility(8);
                if (ConcernPageView.this.dSL != null) {
                    ConcernPageView.this.dSL.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void A(boolean z, boolean z2) {
                if (ConcernPageView.this.dSK != null) {
                    ConcernPageView.this.gG(ConcernPageView.this.dSK.hasMore());
                }
                ConcernPageView.this.dSt.setVisibility(0);
                ConcernPageView.this.z(z, z2);
                ConcernPageView.this.Un();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDk() {
                ConcernPageView.this.z(true, false);
                ConcernPageView.this.Un();
                if (w.z(ConcernPageView.this.dSt.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Tq();
            }
        };
        this.dSP = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dSM = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dSt = new BdTypeListView(context);
        this.dSt.setDividerHeight(0);
        this.dSt.setSelector(17170445);
        this.bvC = new PbListView(context);
        this.bvC.getView();
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.setHeight(l.f(context, f.e.tbds182));
        this.bvC.As();
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
        this.bvC.dz(f.d.cp_cont_e);
        this.bvC.setOnClickListener(this.dSO);
        this.dSt.setNextPage(this.bvC);
        e<?> ad = i.ad(context);
        if (ad instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ad;
        }
        this.mPullView = new h(this.pageContext);
        this.dSt.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.don = BdListViewHelper.a(context, this.dSt, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dSI = new com.baidu.tieba.homepage.concern.a(context, this.dSt);
        this.dSK = new b(this.pageContext, this.dSt, this.dSI);
        addView(this.dSt);
        this.dSt.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.don != null && this.don.getLayoutParams() != null) {
            this.don.getLayoutParams().height = i;
            this.don.setLayoutParams(this.don.getLayoutParams());
        }
        this.aui = i;
    }

    public void ayh() {
        this.dSK.a(this.dSN);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.QN().iA("page_concern");
                    ConcernPageView.this.dSK.update();
                }
            }
        });
        this.dSt.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.Tq();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG(boolean z) {
        if (this.bvC != null) {
            if (z) {
                this.bvC.Ay();
                this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bvC.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.dSJ = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bvC != null) {
            this.bvC.Aw();
            this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dSK.a(z, dataRes, 0, null);
    }

    public void aDe() {
        if (!TbadkCoreApplication.isLogin()) {
            aDh();
        } else if (this.dSK != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds520));
            this.dSK.update();
        }
    }

    public void aDf() {
        if (!TbadkCoreApplication.isLogin()) {
            aDh();
        } else if (this.dSK != null) {
            this.dSK.aDl();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dSK != null) {
            this.dSK.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dSL != null) {
                this.dSL.onChangeSkinType(i);
            }
            if (this.brv != null) {
                this.brv.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dB(i);
            }
            if (this.bvC != null) {
                this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
                this.bvC.dB(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(f.d.cp_cont_b);
            }
            this.dSI.onChangeSkinType(i);
            am.j(this, f.d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void W(String str, int i) {
        if (this.bvC != null) {
            this.bvC.Aw();
            this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dSK.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.dSK != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.dSK.update();
                    }
                }
            });
        }
        this.refreshView.fg(getContext().getResources().getDimensionPixelSize(f.e.ds280));
        this.refreshView.hk(str);
        this.refreshView.c(view, z);
        this.refreshView.Jk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Un() {
        if (this.refreshView != null) {
            this.refreshView.Q(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        if (this.brv != null) {
            this.brv.Q(this);
            this.brv = null;
            this.dSt.setNextPage(this.bvC);
        }
        if (this.dSJ != null) {
            this.dSJ.B(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDg() {
        if (this.refreshView != null) {
            return this.refreshView.Jc();
        }
        return false;
    }

    private void aDh() {
        if (this.dSL == null) {
            this.dSL = new ConcernNotLoginLayout(getContext());
            this.dSL.onChangeSkinType(this.mSkinType);
        }
        if (this.dSL.getParent() == null) {
            this.dSt.setVisibility(8);
            this.dSL.setVisibility(0);
            addView(this.dSL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.brv == null) {
            if (i < 0) {
                this.brv = new com.baidu.tbadk.k.f(getContext());
            } else {
                this.brv = new com.baidu.tbadk.k.f(getContext(), i);
            }
            this.brv.onChangeSkinType();
        }
        this.brv.c(this, z);
        this.dSt.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(f.e.tbds160) + this.aui;
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(f.e.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, f.C0146f.pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(f.e.ds320), dimensionPixelSize2), NoDataViewFactory.d.D(f.j.no_context_text, getResources().getDimensionPixelSize(f.e.tbds50)), null);
            this.mNoDataView.setSubTitleTextSize(l.f(getContext(), f.e.fontsize42));
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setSubTitleTextColor(f.d.cp_cont_b);
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
        if (this.dSK != null) {
            this.dSK.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.dSK != null) {
            this.dSK.fJ(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dSK != null) {
            this.dSK.gH(z);
        }
    }

    public void reload() {
        if (this.dSt != null) {
            if (this.dSM && this.dSt.getFirstVisiblePosition() != 0) {
                this.dSM = false;
                return;
            }
            this.dSt.setSelection(0);
            if (this.dSt.isRefreshDone()) {
                this.dSt.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dSK.a((b.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.dSt.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        this.dSt.setRecyclerListener(null);
    }

    public void aDi() {
        if (this.dSK != null) {
            this.dSK.fJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tq() {
        if (this.bvC != null && !this.bvC.AB()) {
            this.bvC.Av();
            this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dSK.Tq();
    }
}
