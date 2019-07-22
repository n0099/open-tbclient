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
    private View.OnClickListener bCn;
    private g djG;
    private PbListView dnG;
    private int dpp;
    private com.baidu.tieba.homepage.personalize.bigday.a gbT;
    private BdTypeRecyclerView gbU;
    private com.baidu.tieba.homepage.concern.a gbV;
    private a gbW;
    private c gbX;
    private ConcernNotLoginLayout gbY;
    private boolean gbZ;
    private ScrollFragmentTabHost gca;
    ScrollFragmentTabHost.a gcb;
    private BigdaySwipeRefreshLayout gcc;
    private c.a gcd;
    private View.OnClickListener gce;
    private CustomMessageListener gcf;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void P(boolean z, boolean z2);

        void onPullToRefresh();

        void xW(String str);
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gca = scrollFragmentTabHost;
        if (this.gca != null) {
            this.gca.b(this.gcb);
            this.gca.a(this.gcb);
        }
    }

    public void completePullRefresh() {
        if (this.gcc != null) {
            this.gcc.oU();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gbV != null) {
            this.gbV.setPageUniqueId(bdUniqueId);
        }
        if (this.gbX != null) {
            this.gbX.o(bdUniqueId);
        }
        if (this.gbT != null) {
            this.gbT.setTag(bdUniqueId);
        }
        if (this.gcf != null) {
            this.gcf.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gcf);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.gbZ = false;
        this.mSkinType = 3;
        this.dpp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dpp != i && ConcernPageView.this.gca != null) {
                    ConcernPageView.this.dpp = i;
                    if (ConcernPageView.this.dpp == 1) {
                        ConcernPageView.this.gca.aJu();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gca.aJv();
                    } else {
                        ConcernPageView.this.gca.aJu();
                    }
                }
            }
        };
        this.bCn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jQ()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.gcb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void buU() {
                if (ConcernPageView.this.gca != null) {
                    ConcernPageView.this.dpp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gbU)) {
                        ConcernPageView.this.gca.aJv();
                    } else {
                        ConcernPageView.this.gca.aJu();
                    }
                }
            }
        };
        this.gcd = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void buV() {
                if (ConcernPageView.this.gbW == null) {
                    if (ConcernPageView.this.gbY != null) {
                        ConcernPageView.this.gbY.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.N(false, false);
                    return;
                }
                boolean bgJ = ConcernPageView.this.bgJ();
                ConcernPageView.this.aJh();
                if (bgJ) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gbW.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xV(String str) {
                if (ConcernPageView.this.gbW != null) {
                    ConcernPageView.this.gbW.xW(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.N(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.gbX != null) {
                        ConcernPageView.this.lf(ConcernPageView.this.gbX.hasMore());
                    }
                    if (j.kc()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.gcc.setVisibility(8);
                if (ConcernPageView.this.gbY != null) {
                    ConcernPageView.this.gbY.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void O(boolean z, boolean z2) {
                if (ConcernPageView.this.gbX != null) {
                    ConcernPageView.this.lf(ConcernPageView.this.gbX.hasMore());
                }
                ConcernPageView.this.gcc.setVisibility(0);
                ConcernPageView.this.N(z, z2);
                ConcernPageView.this.aJh();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void buW() {
                ConcernPageView.this.N(true, false);
                ConcernPageView.this.aJh();
                if (v.aa(ConcernPageView.this.gbU.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIQ();
            }
        };
        this.gcf = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gbZ = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbZ = false;
        this.mSkinType = 3;
        this.dpp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dpp != i && ConcernPageView.this.gca != null) {
                    ConcernPageView.this.dpp = i;
                    if (ConcernPageView.this.dpp == 1) {
                        ConcernPageView.this.gca.aJu();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gca.aJv();
                    } else {
                        ConcernPageView.this.gca.aJu();
                    }
                }
            }
        };
        this.bCn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jQ()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.gcb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void buU() {
                if (ConcernPageView.this.gca != null) {
                    ConcernPageView.this.dpp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gbU)) {
                        ConcernPageView.this.gca.aJv();
                    } else {
                        ConcernPageView.this.gca.aJu();
                    }
                }
            }
        };
        this.gcd = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void buV() {
                if (ConcernPageView.this.gbW == null) {
                    if (ConcernPageView.this.gbY != null) {
                        ConcernPageView.this.gbY.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.N(false, false);
                    return;
                }
                boolean bgJ = ConcernPageView.this.bgJ();
                ConcernPageView.this.aJh();
                if (bgJ) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gbW.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xV(String str) {
                if (ConcernPageView.this.gbW != null) {
                    ConcernPageView.this.gbW.xW(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.N(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.gbX != null) {
                        ConcernPageView.this.lf(ConcernPageView.this.gbX.hasMore());
                    }
                    if (j.kc()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.gcc.setVisibility(8);
                if (ConcernPageView.this.gbY != null) {
                    ConcernPageView.this.gbY.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void O(boolean z, boolean z2) {
                if (ConcernPageView.this.gbX != null) {
                    ConcernPageView.this.lf(ConcernPageView.this.gbX.hasMore());
                }
                ConcernPageView.this.gcc.setVisibility(0);
                ConcernPageView.this.N(z, z2);
                ConcernPageView.this.aJh();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void buW() {
                ConcernPageView.this.N(true, false);
                ConcernPageView.this.aJh();
                if (v.aa(ConcernPageView.this.gbU.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIQ();
            }
        };
        this.gcf = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gbZ = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbZ = false;
        this.mSkinType = 3;
        this.dpp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.dpp != i2 && ConcernPageView.this.gca != null) {
                    ConcernPageView.this.dpp = i2;
                    if (ConcernPageView.this.dpp == 1) {
                        ConcernPageView.this.gca.aJu();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gca.aJv();
                    } else {
                        ConcernPageView.this.gca.aJu();
                    }
                }
            }
        };
        this.bCn = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.jQ()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.gcb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void buU() {
                if (ConcernPageView.this.gca != null) {
                    ConcernPageView.this.dpp = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gbU)) {
                        ConcernPageView.this.gca.aJv();
                    } else {
                        ConcernPageView.this.gca.aJu();
                    }
                }
            }
        };
        this.gcd = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void buV() {
                if (ConcernPageView.this.gbW == null) {
                    if (ConcernPageView.this.gbY != null) {
                        ConcernPageView.this.gbY.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.N(false, false);
                    return;
                }
                boolean bgJ = ConcernPageView.this.bgJ();
                ConcernPageView.this.aJh();
                if (bgJ) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gbW.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xV(String str) {
                if (ConcernPageView.this.gbW != null) {
                    ConcernPageView.this.gbW.xW(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                ConcernPageView.this.N(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.gbX != null) {
                        ConcernPageView.this.lf(ConcernPageView.this.gbX.hasMore());
                    }
                    if (j.kc()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.gcc.setVisibility(8);
                if (ConcernPageView.this.gbY != null) {
                    ConcernPageView.this.gbY.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void O(boolean z, boolean z2) {
                if (ConcernPageView.this.gbX != null) {
                    ConcernPageView.this.lf(ConcernPageView.this.gbX.hasMore());
                }
                ConcernPageView.this.gcc.setVisibility(0);
                ConcernPageView.this.N(z, z2);
                ConcernPageView.this.aJh();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void buW() {
                ConcernPageView.this.N(true, false);
                ConcernPageView.this.aJh();
                if (v.aa(ConcernPageView.this.gbU.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gce = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIQ();
            }
        };
        this.gcf = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gbZ = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gbU = new BdTypeRecyclerView(context);
        this.gbU.setLayoutManager(new LinearLayoutManager(context));
        this.gbU.setFadingEdgeLength(0);
        this.gbU.setOverScrollMode(2);
        this.gcc = new BigdaySwipeRefreshLayout(context);
        this.gcc.addView(this.gbU);
        this.dnG = new PbListView(context);
        this.dnG.getView();
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.akA();
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.iT(R.color.cp_cont_e);
        this.dnG.setHeight(l.g(context, R.dimen.tbds182));
        this.dnG.setOnClickListener(this.gce);
        this.gbU.setNextPage(this.dnG);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.gcc);
        ((FrameLayout.LayoutParams) this.gcc.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.gbT = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.gbT.setEnable(true);
        this.gcc.setProgressView(this.gbT);
        int i = (int) (61.0f * getResources().getDisplayMetrics().density);
        this.gcc.setCustomDistances(i, i, i * 2);
        this.gbV = new com.baidu.tieba.homepage.concern.a(context, this.gbU);
        this.gbX = new c(this.pageContext, this.gbU, this.gbV, this.gcc);
        this.gcc.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bpT() {
        this.gbX.a(this.gcd);
        this.gbT.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aCF().sl("page_concern");
                    ConcernPageView.this.gbX.update();
                }
            }
        });
        this.gbU.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aIQ();
            }
        });
        this.gbU.removeOnScrollListener(this.mOnScrollListener);
        this.gbU.addOnScrollListener(this.mOnScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lf(boolean z) {
        if (this.dnG != null) {
            if (z) {
                this.dnG.akG();
                this.dnG.iW(0);
                return;
            }
            this.dnG.iX(0);
        }
    }

    public void setCallback(a aVar) {
        this.gbW = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dnG != null) {
            this.dnG.akE();
            this.dnG.iW(0);
        }
        this.gbX.a(z, dataRes, 0, null);
    }

    public void buP() {
        if (!TbadkCoreApplication.isLogin()) {
            buR();
        } else if (this.gbX != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.gbX.update();
        }
    }

    public void buQ() {
        if (!TbadkCoreApplication.isLogin()) {
            buR();
        } else if (this.gbX != null) {
            this.gbX.buX();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.gbX != null) {
            this.gbX.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gbY != null) {
                this.gbY.onChangeSkinType(i);
            }
            if (this.djG != null) {
                this.djG.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gbT != null) {
                this.gbT.iV(i);
            }
            if (this.dnG != null) {
                this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dnG.iV(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.gbV.onChangeSkinType(i);
            am.l(this, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        buS();
    }

    public void az(String str, int i) {
        if (this.dnG != null) {
            this.dnG.akE();
            this.dnG.iW(0);
        }
        this.gbX.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.gbX != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.gbX.update();
                    }
                }
            });
        }
        this.refreshView.kK(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.qN(str);
        this.refreshView.attachView(view, z);
        this.refreshView.atI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJh() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z, boolean z2) {
        if (this.djG != null) {
            this.djG.dettachView(this);
            this.djG = null;
            this.gbU.setNextPage(this.dnG);
        }
        if (this.gbW != null) {
            this.gbW.P(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgJ() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void buR() {
        if (this.gbY == null) {
            this.gbY = new ConcernNotLoginLayout(getContext());
            this.gbY.onChangeSkinType(this.mSkinType);
        }
        if (this.gbY.getParent() == null) {
            this.gcc.setVisibility(8);
            this.gbY.setVisibility(0);
            addView(this.gbY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.djG == null) {
            if (i < 0) {
                this.djG = new g(getContext());
            } else {
                this.djG = new g(getContext(), i);
            }
            this.djG.onChangeSkinType();
        }
        this.djG.attachView(this, z);
        this.gbU.setNextPage(null);
        if (this.gcc != null) {
            this.gcc.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds160);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.ds320), dimensionPixelSize2), NoDataViewFactory.d.af(R.string.no_context_text_click_refresh, getResources().getDimensionPixelSize(R.dimen.tbds50)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getResources().getString(R.string.refresh), this.bCn)));
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
        if (this.gbX != null) {
            this.gbX.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.gbX != null) {
            this.gbX.kc(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gbX != null) {
            this.gbX.lg(z);
        }
        if (this.gca != null) {
            this.gca.b(this.gcb);
            this.gca.a(this.gcb);
            this.gcb.buU();
        }
    }

    public void reload() {
        if (this.gbU != null && this.gcc != null) {
            if (this.gbZ && this.gbU.getFirstVisiblePosition() != 0) {
                this.gbZ = false;
                return;
            }
            this.gbU.setSelection(0);
            if (!this.gcc.isRefreshing()) {
                this.gcc.setRefreshing(true);
            }
            if (this.gcb != null) {
                this.gcb.buU();
            }
        }
    }

    public void onDestroy() {
        if (this.gca != null) {
            this.gca.b(this.gcb);
        }
        this.gbU.removeOnScrollListener(this.mOnScrollListener);
        this.gbX.a((c.a) null);
        this.gbT.setListPullRefreshListener(null);
        this.gbT.a((h.d) null);
        this.gbU.setOnSrollToBottomListener(null);
        this.gbT.a((h.b) null);
        this.gbT.release();
        this.gbU.setRecyclerListener(null);
    }

    public void buS() {
        if (this.gbV != null) {
            this.gbV.notifyDataSetChanged();
        }
    }

    public void buT() {
        if (this.gbX != null) {
            this.gbX.kc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIQ() {
        if (this.dnG != null && !this.dnG.pP()) {
            this.dnG.akD();
            this.dnG.iW(0);
        }
        this.gbX.aIQ();
    }

    public void bno() {
        if (this.gbV != null) {
            List<m> dataList = this.gbV.getDataList();
            if (!v.aa(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bJg != 0 && kVar.threadData != null) {
                            int[] agq = kVar.threadData.agq();
                            kVar.bJg = agq[0];
                            kVar.bJh = agq[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.gbV != null) {
                            ConcernPageView.this.gbV.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
