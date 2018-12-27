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
    private f bKy;
    private PbListView bOB;
    private View dMP;
    private BdTypeListView esJ;
    private com.baidu.tieba.homepage.concern.a esY;
    private a esZ;
    private b eta;
    private ConcernNotLoginLayout etb;
    private boolean etd;
    private b.a ete;
    private View.OnClickListener etf;
    private CustomMessageListener etg;
    private int mHeaderViewHeight;
    private NoDataView mNoDataView;
    private k mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes6.dex */
    public interface a {
        void G(boolean z, boolean z2);

        void onPullToRefresh();

        void pj(String str);
    }

    public void completePullRefresh() {
        if (this.esJ != null) {
            this.esJ.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.esY != null) {
            this.esY.setPageUniqueId(bdUniqueId);
        }
        if (this.eta != null) {
            this.eta.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.etg != null) {
            this.etg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.etg);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.etd = false;
        this.mSkinType = 3;
        this.ete = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKS() {
                if (ConcernPageView.this.esZ == null) {
                    if (ConcernPageView.this.etb != null) {
                        ConcernPageView.this.etb.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aKP = ConcernPageView.this.aKP();
                ConcernPageView.this.aba();
                if (aKP) {
                    ConcernPageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                ConcernPageView.this.esZ.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void pi(String str) {
                if (ConcernPageView.this.esZ != null) {
                    ConcernPageView.this.esZ.pj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.eta != null) {
                        ConcernPageView.this.hL(ConcernPageView.this.eta.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.esJ.setVisibility(8);
                if (ConcernPageView.this.etb != null) {
                    ConcernPageView.this.etb.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.eta != null) {
                    ConcernPageView.this.hL(ConcernPageView.this.eta.hasMore());
                }
                ConcernPageView.this.esJ.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.aba();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKT() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.aba();
                if (v.I(ConcernPageView.this.esJ.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.etf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aad();
            }
        };
        this.etg = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.etd = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etd = false;
        this.mSkinType = 3;
        this.ete = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKS() {
                if (ConcernPageView.this.esZ == null) {
                    if (ConcernPageView.this.etb != null) {
                        ConcernPageView.this.etb.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aKP = ConcernPageView.this.aKP();
                ConcernPageView.this.aba();
                if (aKP) {
                    ConcernPageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                ConcernPageView.this.esZ.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void pi(String str) {
                if (ConcernPageView.this.esZ != null) {
                    ConcernPageView.this.esZ.pj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.eta != null) {
                        ConcernPageView.this.hL(ConcernPageView.this.eta.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.esJ.setVisibility(8);
                if (ConcernPageView.this.etb != null) {
                    ConcernPageView.this.etb.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.eta != null) {
                    ConcernPageView.this.hL(ConcernPageView.this.eta.hasMore());
                }
                ConcernPageView.this.esJ.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.aba();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKT() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.aba();
                if (v.I(ConcernPageView.this.esJ.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.etf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aad();
            }
        };
        this.etg = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.etd = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.etd = false;
        this.mSkinType = 3;
        this.ete = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKS() {
                if (ConcernPageView.this.esZ == null) {
                    if (ConcernPageView.this.etb != null) {
                        ConcernPageView.this.etb.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(e.j.neterror), true);
                    ConcernPageView.this.E(false, false);
                    return;
                }
                boolean aKP = ConcernPageView.this.aKP();
                ConcernPageView.this.aba();
                if (aKP) {
                    ConcernPageView.this.i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
                }
                ConcernPageView.this.esZ.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void pi(String str) {
                if (ConcernPageView.this.esZ != null) {
                    ConcernPageView.this.esZ.pj(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.E(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.eta != null) {
                        ConcernPageView.this.hL(ConcernPageView.this.eta.hasMore());
                    }
                    if (j.kV()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.esJ.setVisibility(8);
                if (ConcernPageView.this.etb != null) {
                    ConcernPageView.this.etb.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void F(boolean z, boolean z2) {
                if (ConcernPageView.this.eta != null) {
                    ConcernPageView.this.hL(ConcernPageView.this.eta.hasMore());
                }
                ConcernPageView.this.esJ.setVisibility(0);
                ConcernPageView.this.E(z, z2);
                ConcernPageView.this.aba();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aKT() {
                ConcernPageView.this.E(true, false);
                ConcernPageView.this.aba();
                if (v.I(ConcernPageView.this.esJ.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.etf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aad();
            }
        };
        this.etg = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.etd = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.esJ = new BdTypeListView(context);
        this.esJ.setDividerHeight(0);
        this.esJ.setSelector(17170445);
        this.bOB = new PbListView(context);
        this.bOB.getView();
        this.bOB.ex(e.d.cp_bg_line_e);
        this.bOB.setHeight(l.h(context, e.C0210e.tbds182));
        this.bOB.EZ();
        this.bOB.setTextSize(e.C0210e.tbfontsize33);
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOB.ew(e.d.cp_cont_e);
        this.bOB.setOnClickListener(this.etf);
        this.esJ.setNextPage(this.bOB);
        com.baidu.adp.base.e<?> aK = i.aK(context);
        if (aK instanceof TbPageContext) {
            this.pageContext = (TbPageContext) aK;
        }
        this.mPullView = new k(this.pageContext);
        this.esJ.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dMP = BdListViewHelper.a(context, this.esJ, BdListViewHelper.HeadType.DEFAULT);
        }
        this.esY = new com.baidu.tieba.homepage.concern.a(context, this.esJ);
        this.eta = new b(this.pageContext, this.esJ, this.esY);
        addView(this.esJ);
        this.esJ.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dMP != null && this.dMP.getLayoutParams() != null) {
            this.dMP.getLayoutParams().height = i;
            this.dMP.setLayoutParams(this.dMP.getLayoutParams());
        }
        this.mHeaderViewHeight = i;
    }

    public void aFL() {
        this.eta.a(this.ete);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.VO().jK("page_concern");
                    ConcernPageView.this.eta.update();
                }
            }
        });
        this.esJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aad();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL(boolean z) {
        if (this.bOB != null) {
            if (z) {
                this.bOB.Ff();
                this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bOB.eA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.esZ = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bOB != null) {
            this.bOB.Fd();
            this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eta.a(z, dataRes, 0, null);
    }

    public void aKN() {
        if (!TbadkCoreApplication.isLogin()) {
            aKQ();
        } else if (this.eta != null) {
            i(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds520));
            this.eta.update();
        }
    }

    public void aKO() {
        if (!TbadkCoreApplication.isLogin()) {
            aKQ();
        } else if (this.eta != null) {
            this.eta.aKU();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(u uVar) {
        if (this.eta != null) {
            this.eta.setRecommendFrsNavigationAnimDispatcher(uVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.etb != null) {
                this.etb.onChangeSkinType(i);
            }
            if (this.bKy != null) {
                this.bKy.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.bOB != null) {
                this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bOB.ey(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(e.d.cp_cont_b);
            }
            this.esY.onChangeSkinType(i);
            al.j(this, e.d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void ah(String str, int i) {
        if (this.bOB != null) {
            this.bOB.Fd();
            this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eta.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.eta != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.eta.update();
                    }
                }
            });
        }
        this.refreshView.ge(getContext().getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.refreshView.io(str);
        this.refreshView.attachView(view, z);
        this.refreshView.NM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aba() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z, boolean z2) {
        if (this.bKy != null) {
            this.bKy.dettachView(this);
            this.bKy = null;
            this.esJ.setNextPage(this.bOB);
        }
        if (this.esZ != null) {
            this.esZ.G(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aKP() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void aKQ() {
        if (this.etb == null) {
            this.etb = new ConcernNotLoginLayout(getContext());
            this.etb.onChangeSkinType(this.mSkinType);
        }
        if (this.etb.getParent() == null) {
            this.esJ.setVisibility(8);
            this.etb.setVisibility(0);
            addView(this.etb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, int i) {
        if (this.bKy == null) {
            if (i < 0) {
                this.bKy = new f(getContext());
            } else {
                this.bKy = new f(getContext(), i);
            }
            this.bKy.onChangeSkinType();
        }
        this.bKy.attachView(this, z);
        this.esJ.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.tbds160) + this.mHeaderViewHeight;
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(e.C0210e.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(e.C0210e.ds320), dimensionPixelSize2), NoDataViewFactory.d.G(e.j.no_context_text, getResources().getDimensionPixelSize(e.C0210e.tbds50)), null);
            this.mNoDataView.setSubTitleTextSize(l.h(getContext(), e.C0210e.fontsize42));
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
        if (this.eta != null) {
            this.eta.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.eta != null) {
            this.eta.gG(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.eta != null) {
            this.eta.hM(z);
        }
    }

    public void reload() {
        if (this.esJ != null) {
            if (this.etd && this.esJ.getFirstVisiblePosition() != 0) {
                this.etd = false;
                return;
            }
            this.esJ.setSelection(0);
            if (this.esJ.isRefreshDone()) {
                this.esJ.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.eta.a((b.a) null);
        this.mPullView.a((j.b) null);
        this.mPullView.a((j.c) null);
        this.esJ.setOnSrollToBottomListener(null);
        this.mPullView.a((j.a) null);
        this.mPullView.release();
        this.esJ.setRecyclerListener(null);
    }

    public void aKR() {
        if (this.eta != null) {
            this.eta.gG(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aad() {
        if (this.bOB != null && !this.bOB.Fi()) {
            this.bOB.Fc();
            this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.eta.aad();
    }
}
