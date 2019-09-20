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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.util.w;
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
    private View.OnClickListener bCL;
    private g dly;
    private PbListView dpz;
    private int drh;
    private com.baidu.tieba.homepage.personalize.bigday.a geB;
    private BdTypeRecyclerView geC;
    private com.baidu.tieba.homepage.concern.a geD;
    private a geE;
    private c geF;
    private ConcernNotLoginLayout geG;
    private boolean geH;
    private ScrollFragmentTabHost geI;
    ScrollFragmentTabHost.a geJ;
    private BigdaySwipeRefreshLayout geK;
    private c.a geL;
    private View.OnClickListener geM;
    private CustomMessageListener geN;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void P(boolean z, boolean z2);

        void onPullToRefresh();

        void yw(String str);
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.geI = scrollFragmentTabHost;
        if (this.geI != null) {
            this.geI.b(this.geJ);
            this.geI.a(this.geJ);
        }
    }

    public void completePullRefresh() {
        if (this.geK != null) {
            this.geK.oV();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.geD != null) {
            this.geD.setPageUniqueId(bdUniqueId);
        }
        if (this.geF != null) {
            this.geF.o(bdUniqueId);
        }
        if (this.geB != null) {
            this.geB.setTag(bdUniqueId);
        }
        if (this.geN != null) {
            this.geN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.geN);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.geH = false;
        this.mSkinType = 3;
        this.drh = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.drh != i && ConcernPageView.this.geI != null) {
                    ConcernPageView.this.drh = i;
                    if (ConcernPageView.this.drh == 1) {
                        ConcernPageView.this.geI.aKa();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.geI.aKb();
                    } else {
                        ConcernPageView.this.geI.aKa();
                    }
                }
            }
        };
        this.bCL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jQ()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.geJ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvV() {
                if (ConcernPageView.this.geI != null) {
                    ConcernPageView.this.drh = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.geC)) {
                        ConcernPageView.this.geI.aKb();
                    } else {
                        ConcernPageView.this.geI.aKa();
                    }
                }
            }
        };
        this.geL = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvW() {
                if (ConcernPageView.this.geE == null) {
                    if (ConcernPageView.this.geG != null) {
                        ConcernPageView.this.geG.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.N(false, false);
                    return;
                }
                boolean bhs = ConcernPageView.this.bhs();
                ConcernPageView.this.aJN();
                if (bhs) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.geE.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void yv(String str) {
                if (ConcernPageView.this.geE != null) {
                    ConcernPageView.this.geE.yw(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.N(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.geF != null) {
                        ConcernPageView.this.li(ConcernPageView.this.geF.hasMore());
                    }
                    if (j.kc()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.geK.setVisibility(8);
                if (ConcernPageView.this.geG != null) {
                    ConcernPageView.this.geG.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void O(boolean z, boolean z2) {
                if (ConcernPageView.this.geF != null) {
                    ConcernPageView.this.li(ConcernPageView.this.geF.hasMore());
                }
                ConcernPageView.this.geK.setVisibility(0);
                ConcernPageView.this.N(z, z2);
                ConcernPageView.this.aJN();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvX() {
                ConcernPageView.this.N(true, false);
                ConcernPageView.this.aJN();
                if (v.aa(ConcernPageView.this.geC.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.geM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aJw();
            }
        };
        this.geN = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.geH = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.geH = false;
        this.mSkinType = 3;
        this.drh = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.drh != i && ConcernPageView.this.geI != null) {
                    ConcernPageView.this.drh = i;
                    if (ConcernPageView.this.drh == 1) {
                        ConcernPageView.this.geI.aKa();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.geI.aKb();
                    } else {
                        ConcernPageView.this.geI.aKa();
                    }
                }
            }
        };
        this.bCL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jQ()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.geJ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvV() {
                if (ConcernPageView.this.geI != null) {
                    ConcernPageView.this.drh = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.geC)) {
                        ConcernPageView.this.geI.aKb();
                    } else {
                        ConcernPageView.this.geI.aKa();
                    }
                }
            }
        };
        this.geL = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvW() {
                if (ConcernPageView.this.geE == null) {
                    if (ConcernPageView.this.geG != null) {
                        ConcernPageView.this.geG.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.N(false, false);
                    return;
                }
                boolean bhs = ConcernPageView.this.bhs();
                ConcernPageView.this.aJN();
                if (bhs) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.geE.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void yv(String str) {
                if (ConcernPageView.this.geE != null) {
                    ConcernPageView.this.geE.yw(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.N(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.geF != null) {
                        ConcernPageView.this.li(ConcernPageView.this.geF.hasMore());
                    }
                    if (j.kc()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.geK.setVisibility(8);
                if (ConcernPageView.this.geG != null) {
                    ConcernPageView.this.geG.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void O(boolean z, boolean z2) {
                if (ConcernPageView.this.geF != null) {
                    ConcernPageView.this.li(ConcernPageView.this.geF.hasMore());
                }
                ConcernPageView.this.geK.setVisibility(0);
                ConcernPageView.this.N(z, z2);
                ConcernPageView.this.aJN();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvX() {
                ConcernPageView.this.N(true, false);
                ConcernPageView.this.aJN();
                if (v.aa(ConcernPageView.this.geC.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.geM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aJw();
            }
        };
        this.geN = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.geH = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.geH = false;
        this.mSkinType = 3;
        this.drh = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.drh != i2 && ConcernPageView.this.geI != null) {
                    ConcernPageView.this.drh = i2;
                    if (ConcernPageView.this.drh == 1) {
                        ConcernPageView.this.geI.aKa();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.geI.aKb();
                    } else {
                        ConcernPageView.this.geI.aKa();
                    }
                }
            }
        };
        this.bCL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jQ()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.geJ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvV() {
                if (ConcernPageView.this.geI != null) {
                    ConcernPageView.this.drh = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.geC)) {
                        ConcernPageView.this.geI.aKb();
                    } else {
                        ConcernPageView.this.geI.aKa();
                    }
                }
            }
        };
        this.geL = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvW() {
                if (ConcernPageView.this.geE == null) {
                    if (ConcernPageView.this.geG != null) {
                        ConcernPageView.this.geG.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.N(false, false);
                    return;
                }
                boolean bhs = ConcernPageView.this.bhs();
                ConcernPageView.this.aJN();
                if (bhs) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.geE.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void yv(String str) {
                if (ConcernPageView.this.geE != null) {
                    ConcernPageView.this.geE.yw(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                ConcernPageView.this.N(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.geF != null) {
                        ConcernPageView.this.li(ConcernPageView.this.geF.hasMore());
                    }
                    if (j.kc()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.geK.setVisibility(8);
                if (ConcernPageView.this.geG != null) {
                    ConcernPageView.this.geG.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void O(boolean z, boolean z2) {
                if (ConcernPageView.this.geF != null) {
                    ConcernPageView.this.li(ConcernPageView.this.geF.hasMore());
                }
                ConcernPageView.this.geK.setVisibility(0);
                ConcernPageView.this.N(z, z2);
                ConcernPageView.this.aJN();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvX() {
                ConcernPageView.this.N(true, false);
                ConcernPageView.this.aJN();
                if (v.aa(ConcernPageView.this.geC.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.geM = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aJw();
            }
        };
        this.geN = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.geH = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.geC = new BdTypeRecyclerView(context);
        this.geC.setLayoutManager(new LinearLayoutManager(context));
        this.geC.setFadingEdgeLength(0);
        this.geC.setOverScrollMode(2);
        this.geK = new BigdaySwipeRefreshLayout(context);
        this.geK.addView(this.geC);
        this.dpz = new PbListView(context);
        this.dpz.getView();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.akO();
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.iW(R.color.cp_cont_e);
        this.dpz.setHeight(l.g(context, R.dimen.tbds182));
        this.dpz.setOnClickListener(this.geM);
        this.geC.setNextPage(this.dpz);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.geK);
        ((FrameLayout.LayoutParams) this.geK.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.geB = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.geB.setEnable(true);
        this.geK.setProgressView(this.geB);
        int i = (int) (61.0f * getResources().getDisplayMetrics().density);
        this.geK.setCustomDistances(i, i, i * 2);
        this.geD = new com.baidu.tieba.homepage.concern.a(context, this.geC);
        this.geF = new c(this.pageContext, this.geC, this.geD, this.geK);
        this.geK.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bqS() {
        this.geF.a(this.geL);
        this.geB.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aCV().sx("page_concern");
                    ConcernPageView.this.geF.update();
                }
            }
        });
        this.geC.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aJw();
            }
        });
        this.geC.removeOnScrollListener(this.mOnScrollListener);
        this.geC.addOnScrollListener(this.mOnScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li(boolean z) {
        if (this.dpz != null) {
            if (z) {
                this.dpz.akU();
                this.dpz.iZ(0);
                return;
            }
            this.dpz.ja(0);
        }
    }

    public void setCallback(a aVar) {
        this.geE = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dpz != null) {
            this.dpz.akS();
            this.dpz.iZ(0);
        }
        this.geF.a(z, dataRes, 0, null);
    }

    public void bvQ() {
        if (!TbadkCoreApplication.isLogin()) {
            bvS();
        } else if (this.geF != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.geF.update();
        }
    }

    public void bvR() {
        if (!TbadkCoreApplication.isLogin()) {
            bvS();
        } else if (this.geF != null) {
            this.geF.bvY();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        if (this.geF != null) {
            this.geF.setRecommendFrsNavigationAnimDispatcher(wVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.geG != null) {
                this.geG.onChangeSkinType(i);
            }
            if (this.dly != null) {
                this.dly.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.geB != null) {
                this.geB.iY(i);
            }
            if (this.dpz != null) {
                this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dpz.iY(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.geD.onChangeSkinType(i);
            am.l(this, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bvT();
    }

    public void aB(String str, int i) {
        if (this.dpz != null) {
            this.dpz.akS();
            this.dpz.iZ(0);
        }
        this.geF.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.geF != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.geF.update();
                    }
                }
            });
        }
        this.refreshView.kO(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.qY(str);
        this.refreshView.attachView(view, z);
        this.refreshView.atW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJN() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z, boolean z2) {
        if (this.dly != null) {
            this.dly.dettachView(this);
            this.dly = null;
            this.geC.setNextPage(this.dpz);
        }
        if (this.geE != null) {
            this.geE.P(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhs() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bvS() {
        if (this.geG == null) {
            this.geG = new ConcernNotLoginLayout(getContext());
            this.geG.onChangeSkinType(this.mSkinType);
        }
        if (this.geG.getParent() == null) {
            this.geK.setVisibility(8);
            this.geG.setVisibility(0);
            addView(this.geG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.dly == null) {
            if (i < 0) {
                this.dly = new g(getContext());
            } else {
                this.dly = new g(getContext(), i);
            }
            this.dly.onChangeSkinType();
        }
        this.dly.attachView(this, z);
        this.geC.setNextPage(null);
        if (this.geK != null) {
            this.geK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds160);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.ds320), dimensionPixelSize2), NoDataViewFactory.d.af(R.string.no_context_text_click_refresh, getResources().getDimensionPixelSize(R.dimen.tbds50)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getResources().getString(R.string.refresh), this.bCL)));
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
        if (this.geF != null) {
            this.geF.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.geF != null) {
            this.geF.kf(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.geF != null) {
            this.geF.lj(z);
        }
        if (this.geI != null) {
            this.geI.b(this.geJ);
            this.geI.a(this.geJ);
            this.geJ.bvV();
        }
    }

    public void reload() {
        if (this.geC != null && this.geK != null) {
            if (this.geH && this.geC.getFirstVisiblePosition() != 0) {
                this.geH = false;
                return;
            }
            this.geC.setSelection(0);
            if (!this.geK.isRefreshing()) {
                this.geK.setRefreshing(true);
            }
            if (this.geJ != null) {
                this.geJ.bvV();
            }
        }
    }

    public void onDestroy() {
        if (this.geI != null) {
            this.geI.b(this.geJ);
        }
        this.geC.removeOnScrollListener(this.mOnScrollListener);
        this.geF.a((c.a) null);
        this.geB.setListPullRefreshListener(null);
        this.geB.a((h.d) null);
        this.geC.setOnSrollToBottomListener(null);
        this.geB.a((h.b) null);
        this.geB.release();
        this.geC.setRecyclerListener(null);
    }

    public void bvT() {
        if (this.geD != null) {
            this.geD.notifyDataSetChanged();
        }
    }

    public void bvU() {
        if (this.geF != null) {
            this.geF.kf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJw() {
        if (this.dpz != null && !this.dpz.pQ()) {
            this.dpz.akR();
            this.dpz.iZ(0);
        }
        this.geF.aJw();
    }

    public void boj() {
        if (this.geD != null) {
            List<m> dataList = this.geD.getDataList();
            if (!v.aa(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bJJ != 0 && kVar.threadData != null) {
                            int[] agv = kVar.threadData.agv();
                            kVar.bJJ = agv[0];
                            kVar.bJK = agv[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.geD != null) {
                            ConcernPageView.this.geD.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
