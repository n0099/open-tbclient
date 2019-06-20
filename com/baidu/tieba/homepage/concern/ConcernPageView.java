package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.a.d;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class ConcernPageView extends FrameLayout {
    private View.OnClickListener bBr;
    private g dhY;
    private PbListView dlY;
    private int dnp;
    private com.baidu.tieba.homepage.personalize.bigday.a fWW;
    private BdTypeRecyclerView fWX;
    private com.baidu.tieba.homepage.concern.a fWY;
    private a fWZ;
    private c fXa;
    private ConcernNotLoginLayout fXb;
    private boolean fXc;
    private ScrollFragmentTabHost fXd;
    ScrollFragmentTabHost.a fXe;
    private BigdaySwipeRefreshLayout fXf;
    private c.a fXg;
    private View.OnClickListener fXh;
    private CustomMessageListener fXi;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void M(boolean z, boolean z2);

        void onPullToRefresh();

        void xr(String str);
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fXd = scrollFragmentTabHost;
        if (this.fXd != null) {
            this.fXd.b(this.fXe);
            this.fXd.a(this.fXe);
        }
    }

    public void completePullRefresh() {
        if (this.fXf != null) {
            this.fXf.oz();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fWY != null) {
            this.fWY.setPageUniqueId(bdUniqueId);
        }
        if (this.fXa != null) {
            this.fXa.n(bdUniqueId);
        }
        if (this.fWW != null) {
            this.fWW.setTag(bdUniqueId);
        }
        if (this.fXi != null) {
            this.fXi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fXi);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.fXc = false;
        this.mSkinType = 3;
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dnp != i && ConcernPageView.this.fXd != null) {
                    ConcernPageView.this.dnp = i;
                    if (ConcernPageView.this.dnp == 1) {
                        ConcernPageView.this.fXd.aHU();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.fXd.aHV();
                    } else {
                        ConcernPageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.bBr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jG()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.fXe = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsT() {
                if (ConcernPageView.this.fXd != null) {
                    ConcernPageView.this.dnp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.fWX)) {
                        ConcernPageView.this.fXd.aHV();
                    } else {
                        ConcernPageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.fXg = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onUpdate() {
                if (ConcernPageView.this.fWZ == null) {
                    if (ConcernPageView.this.fXb != null) {
                        ConcernPageView.this.fXb.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.K(false, false);
                    return;
                }
                boolean beG = ConcernPageView.this.beG();
                ConcernPageView.this.aHK();
                if (beG) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.fWZ.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xq(String str) {
                if (ConcernPageView.this.fWZ != null) {
                    ConcernPageView.this.fWZ.xr(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.K(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.fXa != null) {
                        ConcernPageView.this.kV(ConcernPageView.this.fXa.hasMore());
                    }
                    if (j.jS()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.fXf.setVisibility(8);
                if (ConcernPageView.this.fXb != null) {
                    ConcernPageView.this.fXb.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void L(boolean z, boolean z2) {
                if (ConcernPageView.this.fXa != null) {
                    ConcernPageView.this.kV(ConcernPageView.this.fXa.hasMore());
                }
                ConcernPageView.this.fXf.setVisibility(0);
                ConcernPageView.this.K(z, z2);
                ConcernPageView.this.aHK();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsU() {
                ConcernPageView.this.K(true, false);
                ConcernPageView.this.aHK();
                if (v.aa(ConcernPageView.this.fWX.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.fXh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aHt();
            }
        };
        this.fXi = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fXc = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fXc = false;
        this.mSkinType = 3;
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dnp != i && ConcernPageView.this.fXd != null) {
                    ConcernPageView.this.dnp = i;
                    if (ConcernPageView.this.dnp == 1) {
                        ConcernPageView.this.fXd.aHU();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.fXd.aHV();
                    } else {
                        ConcernPageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.bBr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jG()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.fXe = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsT() {
                if (ConcernPageView.this.fXd != null) {
                    ConcernPageView.this.dnp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.fWX)) {
                        ConcernPageView.this.fXd.aHV();
                    } else {
                        ConcernPageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.fXg = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onUpdate() {
                if (ConcernPageView.this.fWZ == null) {
                    if (ConcernPageView.this.fXb != null) {
                        ConcernPageView.this.fXb.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.K(false, false);
                    return;
                }
                boolean beG = ConcernPageView.this.beG();
                ConcernPageView.this.aHK();
                if (beG) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.fWZ.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xq(String str) {
                if (ConcernPageView.this.fWZ != null) {
                    ConcernPageView.this.fWZ.xr(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.K(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.fXa != null) {
                        ConcernPageView.this.kV(ConcernPageView.this.fXa.hasMore());
                    }
                    if (j.jS()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.fXf.setVisibility(8);
                if (ConcernPageView.this.fXb != null) {
                    ConcernPageView.this.fXb.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void L(boolean z, boolean z2) {
                if (ConcernPageView.this.fXa != null) {
                    ConcernPageView.this.kV(ConcernPageView.this.fXa.hasMore());
                }
                ConcernPageView.this.fXf.setVisibility(0);
                ConcernPageView.this.K(z, z2);
                ConcernPageView.this.aHK();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsU() {
                ConcernPageView.this.K(true, false);
                ConcernPageView.this.aHK();
                if (v.aa(ConcernPageView.this.fWX.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.fXh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aHt();
            }
        };
        this.fXi = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fXc = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fXc = false;
        this.mSkinType = 3;
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.dnp != i2 && ConcernPageView.this.fXd != null) {
                    ConcernPageView.this.dnp = i2;
                    if (ConcernPageView.this.dnp == 1) {
                        ConcernPageView.this.fXd.aHU();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.fXd.aHV();
                    } else {
                        ConcernPageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.bBr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jG()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.fXe = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsT() {
                if (ConcernPageView.this.fXd != null) {
                    ConcernPageView.this.dnp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.fWX)) {
                        ConcernPageView.this.fXd.aHV();
                    } else {
                        ConcernPageView.this.fXd.aHU();
                    }
                }
            }
        };
        this.fXg = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onUpdate() {
                if (ConcernPageView.this.fWZ == null) {
                    if (ConcernPageView.this.fXb != null) {
                        ConcernPageView.this.fXb.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.K(false, false);
                    return;
                }
                boolean beG = ConcernPageView.this.beG();
                ConcernPageView.this.aHK();
                if (beG) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.fWZ.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xq(String str) {
                if (ConcernPageView.this.fWZ != null) {
                    ConcernPageView.this.fWZ.xr(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                ConcernPageView.this.K(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.fXa != null) {
                        ConcernPageView.this.kV(ConcernPageView.this.fXa.hasMore());
                    }
                    if (j.jS()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.fXf.setVisibility(8);
                if (ConcernPageView.this.fXb != null) {
                    ConcernPageView.this.fXb.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void L(boolean z, boolean z2) {
                if (ConcernPageView.this.fXa != null) {
                    ConcernPageView.this.kV(ConcernPageView.this.fXa.hasMore());
                }
                ConcernPageView.this.fXf.setVisibility(0);
                ConcernPageView.this.K(z, z2);
                ConcernPageView.this.aHK();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsU() {
                ConcernPageView.this.K(true, false);
                ConcernPageView.this.aHK();
                if (v.aa(ConcernPageView.this.fWX.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.fXh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aHt();
            }
        };
        this.fXi = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fXc = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fWX = new BdTypeRecyclerView(context);
        this.fWX.setLayoutManager(new LinearLayoutManager(context));
        this.fWX.setFadingEdgeLength(0);
        this.fWX.setOverScrollMode(2);
        this.fXf = new BigdaySwipeRefreshLayout(context);
        this.fXf.addView(this.fWX);
        this.dlY = new PbListView(context);
        this.dlY.getView();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.ajv();
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.iN(R.color.cp_cont_e);
        this.dlY.setHeight(l.g(context, R.dimen.tbds182));
        this.dlY.setOnClickListener(this.fXh);
        this.fWX.setNextPage(this.dlY);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.fXf);
        ((FrameLayout.LayoutParams) this.fXf.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.fWW = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.fWW.setEnable(true);
        this.fXf.setProgressView(this.fWW);
        int i = (int) (61.0f * getResources().getDisplayMetrics().density);
        this.fXf.setCustomDistances(i, i, i * 2);
        this.fWY = new com.baidu.tieba.homepage.concern.a(context, this.fWX);
        this.fXa = new c(this.pageContext, this.fWX, this.fWY, this.fXf);
        this.fXf.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bnS() {
        this.fXa.a(this.fXg);
        this.fWW.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aBq().rT("page_concern");
                    ConcernPageView.this.fXa.update();
                }
            }
        });
        this.fWX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aHt();
            }
        });
        this.fWX.removeOnScrollListener(this.mOnScrollListener);
        this.fWX.addOnScrollListener(this.mOnScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kV(boolean z) {
        if (this.dlY != null) {
            if (z) {
                this.dlY.ajB();
                this.dlY.iQ(0);
                return;
            }
            this.dlY.iR(0);
        }
    }

    public void setCallback(a aVar) {
        this.fWZ = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dlY != null) {
            this.dlY.ajz();
            this.dlY.iQ(0);
        }
        this.fXa.a(z, dataRes, 0, null);
    }

    public void bsO() {
        if (!TbadkCoreApplication.isLogin()) {
            bsQ();
        } else if (this.fXa != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.fXa.update();
        }
    }

    public void bsP() {
        if (!TbadkCoreApplication.isLogin()) {
            bsQ();
        } else if (this.fXa != null) {
            this.fXa.bsV();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fXa != null) {
            this.fXa.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fXb != null) {
                this.fXb.onChangeSkinType(i);
            }
            if (this.dhY != null) {
                this.dhY.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.fWW != null) {
                this.fWW.iP(i);
            }
            if (this.dlY != null) {
                this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
                this.dlY.iP(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.fWY.onChangeSkinType(i);
            al.l(this, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bsR();
    }

    public void ay(String str, int i) {
        if (this.dlY != null) {
            this.dlY.ajz();
            this.dlY.iQ(0);
        }
        this.fXa.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.fXa != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.fXa.update();
                    }
                }
            });
        }
        this.refreshView.kE(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.qw(str);
        this.refreshView.attachView(view, z);
        this.refreshView.asB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z, boolean z2) {
        if (this.dhY != null) {
            this.dhY.dettachView(this);
            this.dhY = null;
            this.fWX.setNextPage(this.dlY);
        }
        if (this.fWZ != null) {
            this.fWZ.M(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beG() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bsQ() {
        if (this.fXb == null) {
            this.fXb = new ConcernNotLoginLayout(getContext());
            this.fXb.onChangeSkinType(this.mSkinType);
        }
        if (this.fXb.getParent() == null) {
            this.fXf.setVisibility(8);
            this.fXb.setVisibility(0);
            addView(this.fXb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.dhY == null) {
            if (i < 0) {
                this.dhY = new g(getContext());
            } else {
                this.dhY = new g(getContext(), i);
            }
            this.dhY.onChangeSkinType();
        }
        this.dhY.attachView(this, z);
        this.fWX.setNextPage(null);
        if (this.fXf != null) {
            this.fXf.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds160);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.ds320), dimensionPixelSize2), NoDataViewFactory.d.ac(R.string.no_context_text_click_refresh, getResources().getDimensionPixelSize(R.dimen.tbds50)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getResources().getString(R.string.refresh), this.bBr)));
            this.mNoDataView.setSubTitleTextSize(l.g(getContext(), R.dimen.fontsize42));
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
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
        if (this.fXa != null) {
            this.fXa.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.fXa != null) {
            this.fXa.jS(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.fXa != null) {
            this.fXa.kW(z);
        }
        if (this.fXd != null) {
            this.fXd.b(this.fXe);
            this.fXd.a(this.fXe);
            this.fXe.bsT();
        }
    }

    public void reload() {
        if (this.fWX != null && this.fXf != null) {
            if (this.fXc && this.fWX.getFirstVisiblePosition() != 0) {
                this.fXc = false;
                return;
            }
            this.fWX.setSelection(0);
            if (!this.fXf.isRefreshing()) {
                this.fXf.setRefreshing(true);
            }
            if (this.fXe != null) {
                this.fXe.bsT();
            }
        }
    }

    public void onDestroy() {
        if (this.fXd != null) {
            this.fXd.b(this.fXe);
        }
        this.fWX.removeOnScrollListener(this.mOnScrollListener);
        this.fXa.a((c.a) null);
        this.fWW.setListPullRefreshListener(null);
        this.fWW.a((h.d) null);
        this.fWX.setOnSrollToBottomListener(null);
        this.fWW.a((h.b) null);
        this.fWW.release();
        this.fWX.setRecyclerListener(null);
    }

    public void bsR() {
        if (this.fWY != null) {
            this.fWY.notifyDataSetChanged();
        }
    }

    public void bsS() {
        if (this.fXa != null) {
            this.fXa.jS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        if (this.dlY != null && !this.dlY.pu()) {
            this.dlY.ajy();
            this.dlY.iQ(0);
        }
        this.fXa.aHt();
    }

    public void bln() {
        if (this.fWY != null) {
            List<m> dataList = this.fWY.getDataList();
            if (!v.aa(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bIg != 0 && kVar.threadData != null) {
                            int[] afo = kVar.threadData.afo();
                            kVar.bIg = afo[0];
                            kVar.bIh = afo[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.fWY != null) {
                            ConcernPageView.this.fWY.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
