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
    private View.OnClickListener bBp;
    private g dhY;
    private PbListView dlY;
    private int dnp;
    private com.baidu.tieba.homepage.personalize.bigday.a fWU;
    private BdTypeRecyclerView fWV;
    private com.baidu.tieba.homepage.concern.a fWW;
    private a fWX;
    private c fWY;
    private ConcernNotLoginLayout fWZ;
    private boolean fXa;
    private ScrollFragmentTabHost fXb;
    ScrollFragmentTabHost.a fXc;
    private BigdaySwipeRefreshLayout fXd;
    private c.a fXe;
    private View.OnClickListener fXf;
    private CustomMessageListener fXg;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void M(boolean z, boolean z2);

        void onPullToRefresh();

        void xp(String str);
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fXb = scrollFragmentTabHost;
        if (this.fXb != null) {
            this.fXb.b(this.fXc);
            this.fXb.a(this.fXc);
        }
    }

    public void completePullRefresh() {
        if (this.fXd != null) {
            this.fXd.oz();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fWW != null) {
            this.fWW.setPageUniqueId(bdUniqueId);
        }
        if (this.fWY != null) {
            this.fWY.n(bdUniqueId);
        }
        if (this.fWU != null) {
            this.fWU.setTag(bdUniqueId);
        }
        if (this.fXg != null) {
            this.fXg.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.fXg);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.fXa = false;
        this.mSkinType = 3;
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dnp != i && ConcernPageView.this.fXb != null) {
                    ConcernPageView.this.dnp = i;
                    if (ConcernPageView.this.dnp == 1) {
                        ConcernPageView.this.fXb.aHU();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.fXb.aHV();
                    } else {
                        ConcernPageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.bBp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jG()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.fXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsR() {
                if (ConcernPageView.this.fXb != null) {
                    ConcernPageView.this.dnp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.fWV)) {
                        ConcernPageView.this.fXb.aHV();
                    } else {
                        ConcernPageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.fXe = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsS() {
                if (ConcernPageView.this.fWX == null) {
                    if (ConcernPageView.this.fWZ != null) {
                        ConcernPageView.this.fWZ.setVisibility(8);
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
                ConcernPageView.this.fWX.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xo(String str) {
                if (ConcernPageView.this.fWX != null) {
                    ConcernPageView.this.fWX.xp(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.K(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.fWY != null) {
                        ConcernPageView.this.kU(ConcernPageView.this.fWY.hasMore());
                    }
                    if (j.jS()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.fXd.setVisibility(8);
                if (ConcernPageView.this.fWZ != null) {
                    ConcernPageView.this.fWZ.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void L(boolean z, boolean z2) {
                if (ConcernPageView.this.fWY != null) {
                    ConcernPageView.this.kU(ConcernPageView.this.fWY.hasMore());
                }
                ConcernPageView.this.fXd.setVisibility(0);
                ConcernPageView.this.K(z, z2);
                ConcernPageView.this.aHK();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsT() {
                ConcernPageView.this.K(true, false);
                ConcernPageView.this.aHK();
                if (v.aa(ConcernPageView.this.fWV.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.fXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aHt();
            }
        };
        this.fXg = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fXa = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fXa = false;
        this.mSkinType = 3;
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dnp != i && ConcernPageView.this.fXb != null) {
                    ConcernPageView.this.dnp = i;
                    if (ConcernPageView.this.dnp == 1) {
                        ConcernPageView.this.fXb.aHU();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.fXb.aHV();
                    } else {
                        ConcernPageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.bBp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jG()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.fXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsR() {
                if (ConcernPageView.this.fXb != null) {
                    ConcernPageView.this.dnp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.fWV)) {
                        ConcernPageView.this.fXb.aHV();
                    } else {
                        ConcernPageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.fXe = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsS() {
                if (ConcernPageView.this.fWX == null) {
                    if (ConcernPageView.this.fWZ != null) {
                        ConcernPageView.this.fWZ.setVisibility(8);
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
                ConcernPageView.this.fWX.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xo(String str) {
                if (ConcernPageView.this.fWX != null) {
                    ConcernPageView.this.fWX.xp(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.K(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.fWY != null) {
                        ConcernPageView.this.kU(ConcernPageView.this.fWY.hasMore());
                    }
                    if (j.jS()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.fXd.setVisibility(8);
                if (ConcernPageView.this.fWZ != null) {
                    ConcernPageView.this.fWZ.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void L(boolean z, boolean z2) {
                if (ConcernPageView.this.fWY != null) {
                    ConcernPageView.this.kU(ConcernPageView.this.fWY.hasMore());
                }
                ConcernPageView.this.fXd.setVisibility(0);
                ConcernPageView.this.K(z, z2);
                ConcernPageView.this.aHK();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsT() {
                ConcernPageView.this.K(true, false);
                ConcernPageView.this.aHK();
                if (v.aa(ConcernPageView.this.fWV.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.fXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aHt();
            }
        };
        this.fXg = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fXa = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fXa = false;
        this.mSkinType = 3;
        this.dnp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.dnp != i2 && ConcernPageView.this.fXb != null) {
                    ConcernPageView.this.dnp = i2;
                    if (ConcernPageView.this.dnp == 1) {
                        ConcernPageView.this.fXb.aHU();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.fXb.aHV();
                    } else {
                        ConcernPageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.bBp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jG()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.fXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsR() {
                if (ConcernPageView.this.fXb != null) {
                    ConcernPageView.this.dnp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.fWV)) {
                        ConcernPageView.this.fXb.aHV();
                    } else {
                        ConcernPageView.this.fXb.aHU();
                    }
                }
            }
        };
        this.fXe = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsS() {
                if (ConcernPageView.this.fWX == null) {
                    if (ConcernPageView.this.fWZ != null) {
                        ConcernPageView.this.fWZ.setVisibility(8);
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
                ConcernPageView.this.fWX.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xo(String str) {
                if (ConcernPageView.this.fWX != null) {
                    ConcernPageView.this.fWX.xp(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                ConcernPageView.this.K(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.fWY != null) {
                        ConcernPageView.this.kU(ConcernPageView.this.fWY.hasMore());
                    }
                    if (j.jS()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.fXd.setVisibility(8);
                if (ConcernPageView.this.fWZ != null) {
                    ConcernPageView.this.fWZ.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void L(boolean z, boolean z2) {
                if (ConcernPageView.this.fWY != null) {
                    ConcernPageView.this.kU(ConcernPageView.this.fWY.hasMore());
                }
                ConcernPageView.this.fXd.setVisibility(0);
                ConcernPageView.this.K(z, z2);
                ConcernPageView.this.aHK();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsT() {
                ConcernPageView.this.K(true, false);
                ConcernPageView.this.aHK();
                if (v.aa(ConcernPageView.this.fWV.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.fXf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aHt();
            }
        };
        this.fXg = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.fXa = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fWV = new BdTypeRecyclerView(context);
        this.fWV.setLayoutManager(new LinearLayoutManager(context));
        this.fWV.setFadingEdgeLength(0);
        this.fWV.setOverScrollMode(2);
        this.fXd = new BigdaySwipeRefreshLayout(context);
        this.fXd.addView(this.fWV);
        this.dlY = new PbListView(context);
        this.dlY.getView();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.ajv();
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.iN(R.color.cp_cont_e);
        this.dlY.setHeight(l.g(context, R.dimen.tbds182));
        this.dlY.setOnClickListener(this.fXf);
        this.fWV.setNextPage(this.dlY);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.fXd);
        ((FrameLayout.LayoutParams) this.fXd.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.fWU = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.fWU.setEnable(true);
        this.fXd.setProgressView(this.fWU);
        int i = (int) (61.0f * getResources().getDisplayMetrics().density);
        this.fXd.setCustomDistances(i, i, i * 2);
        this.fWW = new com.baidu.tieba.homepage.concern.a(context, this.fWV);
        this.fWY = new c(this.pageContext, this.fWV, this.fWW, this.fXd);
        this.fXd.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bnS() {
        this.fWY.a(this.fXe);
        this.fWU.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aBq().rU("page_concern");
                    ConcernPageView.this.fWY.update();
                }
            }
        });
        this.fWV.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aHt();
            }
        });
        this.fWV.removeOnScrollListener(this.mOnScrollListener);
        this.fWV.addOnScrollListener(this.mOnScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU(boolean z) {
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
        this.fWX = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dlY != null) {
            this.dlY.ajz();
            this.dlY.iQ(0);
        }
        this.fWY.a(z, dataRes, 0, null);
    }

    public void bsM() {
        if (!TbadkCoreApplication.isLogin()) {
            bsO();
        } else if (this.fWY != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.fWY.update();
        }
    }

    public void bsN() {
        if (!TbadkCoreApplication.isLogin()) {
            bsO();
        } else if (this.fWY != null) {
            this.fWY.bsU();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.fWY != null) {
            this.fWY.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fWZ != null) {
                this.fWZ.onChangeSkinType(i);
            }
            if (this.dhY != null) {
                this.dhY.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.fWU != null) {
                this.fWU.iP(i);
            }
            if (this.dlY != null) {
                this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
                this.dlY.iP(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.fWW.onChangeSkinType(i);
            al.l(this, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bsP();
    }

    public void ay(String str, int i) {
        if (this.dlY != null) {
            this.dlY.ajz();
            this.dlY.iQ(0);
        }
        this.fWY.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.fWY != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.fWY.update();
                    }
                }
            });
        }
        this.refreshView.kE(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.qx(str);
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
            this.fWV.setNextPage(this.dlY);
        }
        if (this.fWX != null) {
            this.fWX.M(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beG() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bsO() {
        if (this.fWZ == null) {
            this.fWZ = new ConcernNotLoginLayout(getContext());
            this.fWZ.onChangeSkinType(this.mSkinType);
        }
        if (this.fWZ.getParent() == null) {
            this.fXd.setVisibility(8);
            this.fWZ.setVisibility(0);
            addView(this.fWZ);
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
        this.fWV.setNextPage(null);
        if (this.fXd != null) {
            this.fXd.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds160);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.ds320), dimensionPixelSize2), NoDataViewFactory.d.ac(R.string.no_context_text_click_refresh, getResources().getDimensionPixelSize(R.dimen.tbds50)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getResources().getString(R.string.refresh), this.bBp)));
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
        if (this.fWY != null) {
            this.fWY.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.fWY != null) {
            this.fWY.jS(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.fWY != null) {
            this.fWY.kV(z);
        }
        if (this.fXb != null) {
            this.fXb.b(this.fXc);
            this.fXb.a(this.fXc);
            this.fXc.bsR();
        }
    }

    public void reload() {
        if (this.fWV != null && this.fXd != null) {
            if (this.fXa && this.fWV.getFirstVisiblePosition() != 0) {
                this.fXa = false;
                return;
            }
            this.fWV.setSelection(0);
            if (!this.fXd.isRefreshing()) {
                this.fXd.setRefreshing(true);
            }
            if (this.fXc != null) {
                this.fXc.bsR();
            }
        }
    }

    public void onDestroy() {
        if (this.fXb != null) {
            this.fXb.b(this.fXc);
        }
        this.fWV.removeOnScrollListener(this.mOnScrollListener);
        this.fWY.a((c.a) null);
        this.fWU.setListPullRefreshListener(null);
        this.fWU.a((h.d) null);
        this.fWV.setOnSrollToBottomListener(null);
        this.fWU.a((h.b) null);
        this.fWU.release();
        this.fWV.setRecyclerListener(null);
    }

    public void bsP() {
        if (this.fWW != null) {
            this.fWW.notifyDataSetChanged();
        }
    }

    public void bsQ() {
        if (this.fWY != null) {
            this.fWY.jS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        if (this.dlY != null && !this.dlY.pu()) {
            this.dlY.ajy();
            this.dlY.iQ(0);
        }
        this.fWY.aHt();
    }

    public void bln() {
        if (this.fWW != null) {
            List<m> dataList = this.fWW.getDataList();
            if (!v.aa(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bIf != 0 && kVar.threadData != null) {
                            int[] afo = kVar.threadData.afo();
                            kVar.bIf = afo[0];
                            kVar.bIg = afo[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.fWW != null) {
                            ConcernPageView.this.fWW.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
