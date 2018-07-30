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
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.b;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import tbclient.Userlike.DataRes;
/* loaded from: classes2.dex */
public class ConcernPageView extends FrameLayout {
    private int auh;
    private f brt;
    private PbListView bvA;
    private com.baidu.tieba.homepage.concern.a dSN;
    private a dSO;
    private b dSP;
    private ConcernNotLoginLayout dSQ;
    private boolean dSR;
    private b.a dSS;
    private View.OnClickListener dST;
    private CustomMessageListener dSU;
    private BdTypeListView dSy;
    private View dop;
    private NoDataView mNoDataView;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void B(boolean z, boolean z2);

        void ns(String str);

        void onPullToRefresh();
    }

    public void completePullRefresh() {
        if (this.dSy != null) {
            this.dSy.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dSN != null) {
            this.dSN.setPageUniqueId(bdUniqueId);
        }
        if (this.dSP != null) {
            this.dSP.l(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.dSU != null) {
            this.dSU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dSU);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.dSR = false;
        this.mSkinType = 3;
        this.dSS = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDm() {
                if (ConcernPageView.this.dSO == null) {
                    if (ConcernPageView.this.dSQ != null) {
                        ConcernPageView.this.dSQ.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.z(false, false);
                    return;
                }
                boolean aDj = ConcernPageView.this.aDj();
                ConcernPageView.this.Uk();
                if (aDj) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dSO.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nr(String str) {
                if (ConcernPageView.this.dSO != null) {
                    ConcernPageView.this.dSO.ns(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.z(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.dSP != null) {
                        ConcernPageView.this.gG(ConcernPageView.this.dSP.hasMore());
                    }
                    if (j.jE()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dSy.setVisibility(8);
                if (ConcernPageView.this.dSQ != null) {
                    ConcernPageView.this.dSQ.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void A(boolean z, boolean z2) {
                if (ConcernPageView.this.dSP != null) {
                    ConcernPageView.this.gG(ConcernPageView.this.dSP.hasMore());
                }
                ConcernPageView.this.dSy.setVisibility(0);
                ConcernPageView.this.z(z, z2);
                ConcernPageView.this.Uk();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDn() {
                ConcernPageView.this.z(true, false);
                ConcernPageView.this.Uk();
                if (w.z(ConcernPageView.this.dSy.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dST = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Tn();
            }
        };
        this.dSU = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dSR = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dSR = false;
        this.mSkinType = 3;
        this.dSS = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDm() {
                if (ConcernPageView.this.dSO == null) {
                    if (ConcernPageView.this.dSQ != null) {
                        ConcernPageView.this.dSQ.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.z(false, false);
                    return;
                }
                boolean aDj = ConcernPageView.this.aDj();
                ConcernPageView.this.Uk();
                if (aDj) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dSO.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nr(String str) {
                if (ConcernPageView.this.dSO != null) {
                    ConcernPageView.this.dSO.ns(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i, String str) {
                ConcernPageView.this.z(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.dSP != null) {
                        ConcernPageView.this.gG(ConcernPageView.this.dSP.hasMore());
                    }
                    if (j.jE()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dSy.setVisibility(8);
                if (ConcernPageView.this.dSQ != null) {
                    ConcernPageView.this.dSQ.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void A(boolean z, boolean z2) {
                if (ConcernPageView.this.dSP != null) {
                    ConcernPageView.this.gG(ConcernPageView.this.dSP.hasMore());
                }
                ConcernPageView.this.dSy.setVisibility(0);
                ConcernPageView.this.z(z, z2);
                ConcernPageView.this.Uk();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDn() {
                ConcernPageView.this.z(true, false);
                ConcernPageView.this.Uk();
                if (w.z(ConcernPageView.this.dSy.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dST = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Tn();
            }
        };
        this.dSU = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dSR = true;
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dSR = false;
        this.mSkinType = 3;
        this.dSS = new b.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDm() {
                if (ConcernPageView.this.dSO == null) {
                    if (ConcernPageView.this.dSQ != null) {
                        ConcernPageView.this.dSQ.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(d.j.neterror), true);
                    ConcernPageView.this.z(false, false);
                    return;
                }
                boolean aDj = ConcernPageView.this.aDj();
                ConcernPageView.this.Uk();
                if (aDj) {
                    ConcernPageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                ConcernPageView.this.dSO.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void nr(String str) {
                if (ConcernPageView.this.dSO != null) {
                    ConcernPageView.this.dSO.ns(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void onError(int i2, String str) {
                ConcernPageView.this.z(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.dSP != null) {
                        ConcernPageView.this.gG(ConcernPageView.this.dSP.hasMore());
                    }
                    if (j.jE()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.dSy.setVisibility(8);
                if (ConcernPageView.this.dSQ != null) {
                    ConcernPageView.this.dSQ.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void A(boolean z, boolean z2) {
                if (ConcernPageView.this.dSP != null) {
                    ConcernPageView.this.gG(ConcernPageView.this.dSP.hasMore());
                }
                ConcernPageView.this.dSy.setVisibility(0);
                ConcernPageView.this.z(z, z2);
                ConcernPageView.this.Uk();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.b.a
            public void aDn() {
                ConcernPageView.this.z(true, false);
                ConcernPageView.this.Uk();
                if (w.z(ConcernPageView.this.dSy.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.dST = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.Tn();
            }
        };
        this.dSU = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.dSR = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dSy = new BdTypeListView(context);
        this.dSy.setDividerHeight(0);
        this.dSy.setSelector(17170445);
        this.bvA = new PbListView(context);
        this.bvA.getView();
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.setHeight(l.f(context, d.e.tbds182));
        this.bvA.Au();
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
        this.bvA.dA(d.C0140d.cp_cont_e);
        this.bvA.setOnClickListener(this.dST);
        this.dSy.setNextPage(this.bvA);
        e<?> ad = i.ad(context);
        if (ad instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ad;
        }
        this.mPullView = new h(this.pageContext);
        this.dSy.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        if (TbadkCoreApplication.isLogin()) {
            this.dop = BdListViewHelper.a(context, this.dSy, BdListViewHelper.HeadType.DEFAULT);
        }
        this.dSN = new com.baidu.tieba.homepage.concern.a(context, this.dSy);
        this.dSP = new b(this.pageContext, this.dSy, this.dSN);
        addView(this.dSy);
        this.dSy.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.dop != null && this.dop.getLayoutParams() != null) {
            this.dop.getLayoutParams().height = i;
            this.dop.setLayoutParams(this.dop.getLayoutParams());
        }
        this.auh = i;
    }

    public void ayj() {
        this.dSP.a(this.dSS);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.a.d.QI().iz("page_concern");
                    ConcernPageView.this.dSP.update();
                }
            }
        });
        this.dSy.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.Tn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG(boolean z) {
        if (this.bvA != null) {
            if (z) {
                this.bvA.AA();
                this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bvA.dE(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.dSO = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bvA != null) {
            this.bvA.Ay();
            this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dSP.a(z, dataRes, 0, null);
    }

    public void aDh() {
        if (!TbadkCoreApplication.isLogin()) {
            aDk();
        } else if (this.dSP != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dSP.update();
        }
    }

    public void aDi() {
        if (!TbadkCoreApplication.isLogin()) {
            aDk();
        } else if (this.dSP != null) {
            this.dSP.aDo();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dSP != null) {
            this.dSP.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.dSQ != null) {
                this.dSQ.onChangeSkinType(i);
            }
            if (this.brt != null) {
                this.brt.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dC(i);
            }
            if (this.bvA != null) {
                this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
                this.bvA.dC(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(d.C0140d.cp_cont_b);
            }
            this.dSN.onChangeSkinType(i);
            am.j(this, d.C0140d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
    }

    public void W(String str, int i) {
        if (this.bvA != null) {
            this.bvA.Ay();
            this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dSP.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.dSP != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.dSP.update();
                    }
                }
            });
        }
        this.refreshView.fh(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.hk(str);
        this.refreshView.c(view, z);
        this.refreshView.Jk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uk() {
        if (this.refreshView != null) {
            this.refreshView.Q(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        if (this.brt != null) {
            this.brt.Q(this);
            this.brt = null;
            this.dSy.setNextPage(this.bvA);
        }
        if (this.dSO != null) {
            this.dSO.B(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDj() {
        if (this.refreshView != null) {
            return this.refreshView.Jc();
        }
        return false;
    }

    private void aDk() {
        if (this.dSQ == null) {
            this.dSQ = new ConcernNotLoginLayout(getContext());
            this.dSQ.onChangeSkinType(this.mSkinType);
        }
        if (this.dSQ.getParent() == null) {
            this.dSy.setVisibility(8);
            this.dSQ.setVisibility(0);
            addView(this.dSQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.brt == null) {
            if (i < 0) {
                this.brt = new f(getContext());
            } else {
                this.brt = new f(getContext(), i);
            }
            this.brt.onChangeSkinType();
        }
        this.brt.c(this, z);
        this.dSy.setNextPage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.tbds160) + this.auh;
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(d.e.ds320), dimensionPixelSize2), NoDataViewFactory.d.D(d.j.no_context_text, getResources().getDimensionPixelSize(d.e.tbds50)), null);
            this.mNoDataView.setSubTitleTextSize(l.f(getContext(), d.e.fontsize42));
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setSubTitleTextColor(d.C0140d.cp_cont_b);
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
        if (this.dSP != null) {
            this.dSP.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.dSP != null) {
            this.dSP.fJ(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dSP != null) {
            this.dSP.gH(z);
        }
    }

    public void reload() {
        if (this.dSy != null) {
            if (this.dSR && this.dSy.getFirstVisiblePosition() != 0) {
                this.dSR = false;
                return;
            }
            this.dSy.setSelection(0);
            if (this.dSy.isRefreshDone()) {
                this.dSy.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.dSP.a((b.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.dSy.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        this.dSy.setRecyclerListener(null);
    }

    public void aDl() {
        if (this.dSP != null) {
            this.dSP.fJ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tn() {
        if (this.bvA != null && !this.bvA.AE()) {
            this.bvA.Ax();
            this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dSP.Tn();
    }
}
