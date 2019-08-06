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
    private g djN;
    private PbListView dnN;
    private int dpw;
    private com.baidu.tieba.homepage.personalize.bigday.a gcJ;
    private BdTypeRecyclerView gcK;
    private com.baidu.tieba.homepage.concern.a gcL;
    private a gcM;
    private c gcN;
    private ConcernNotLoginLayout gcO;
    private boolean gcP;
    private ScrollFragmentTabHost gcQ;
    ScrollFragmentTabHost.a gcR;
    private BigdaySwipeRefreshLayout gcS;
    private c.a gcT;
    private View.OnClickListener gcU;
    private CustomMessageListener gcV;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void P(boolean z, boolean z2);

        void onPullToRefresh();

        void xX(String str);
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gcQ = scrollFragmentTabHost;
        if (this.gcQ != null) {
            this.gcQ.b(this.gcR);
            this.gcQ.a(this.gcR);
        }
    }

    public void completePullRefresh() {
        if (this.gcS != null) {
            this.gcS.oU();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gcL != null) {
            this.gcL.setPageUniqueId(bdUniqueId);
        }
        if (this.gcN != null) {
            this.gcN.o(bdUniqueId);
        }
        if (this.gcJ != null) {
            this.gcJ.setTag(bdUniqueId);
        }
        if (this.gcV != null) {
            this.gcV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gcV);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.gcP = false;
        this.mSkinType = 3;
        this.dpw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dpw != i && ConcernPageView.this.gcQ != null) {
                    ConcernPageView.this.dpw = i;
                    if (ConcernPageView.this.dpw == 1) {
                        ConcernPageView.this.gcQ.aJw();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gcQ.aJx();
                    } else {
                        ConcernPageView.this.gcQ.aJw();
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
        this.gcR = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvh() {
                if (ConcernPageView.this.gcQ != null) {
                    ConcernPageView.this.dpw = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gcK)) {
                        ConcernPageView.this.gcQ.aJx();
                    } else {
                        ConcernPageView.this.gcQ.aJw();
                    }
                }
            }
        };
        this.gcT = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvi() {
                if (ConcernPageView.this.gcM == null) {
                    if (ConcernPageView.this.gcO != null) {
                        ConcernPageView.this.gcO.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.N(false, false);
                    return;
                }
                boolean bgM = ConcernPageView.this.bgM();
                ConcernPageView.this.aJj();
                if (bgM) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gcM.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xW(String str) {
                if (ConcernPageView.this.gcM != null) {
                    ConcernPageView.this.gcM.xX(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.N(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.gcN != null) {
                        ConcernPageView.this.lf(ConcernPageView.this.gcN.hasMore());
                    }
                    if (j.kc()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.gcS.setVisibility(8);
                if (ConcernPageView.this.gcO != null) {
                    ConcernPageView.this.gcO.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void O(boolean z, boolean z2) {
                if (ConcernPageView.this.gcN != null) {
                    ConcernPageView.this.lf(ConcernPageView.this.gcN.hasMore());
                }
                ConcernPageView.this.gcS.setVisibility(0);
                ConcernPageView.this.N(z, z2);
                ConcernPageView.this.aJj();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvj() {
                ConcernPageView.this.N(true, false);
                ConcernPageView.this.aJj();
                if (v.aa(ConcernPageView.this.gcK.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gcU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIS();
            }
        };
        this.gcV = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gcP = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gcP = false;
        this.mSkinType = 3;
        this.dpw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dpw != i && ConcernPageView.this.gcQ != null) {
                    ConcernPageView.this.dpw = i;
                    if (ConcernPageView.this.dpw == 1) {
                        ConcernPageView.this.gcQ.aJw();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gcQ.aJx();
                    } else {
                        ConcernPageView.this.gcQ.aJw();
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
        this.gcR = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvh() {
                if (ConcernPageView.this.gcQ != null) {
                    ConcernPageView.this.dpw = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gcK)) {
                        ConcernPageView.this.gcQ.aJx();
                    } else {
                        ConcernPageView.this.gcQ.aJw();
                    }
                }
            }
        };
        this.gcT = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvi() {
                if (ConcernPageView.this.gcM == null) {
                    if (ConcernPageView.this.gcO != null) {
                        ConcernPageView.this.gcO.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.N(false, false);
                    return;
                }
                boolean bgM = ConcernPageView.this.bgM();
                ConcernPageView.this.aJj();
                if (bgM) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gcM.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xW(String str) {
                if (ConcernPageView.this.gcM != null) {
                    ConcernPageView.this.gcM.xX(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.N(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.gcN != null) {
                        ConcernPageView.this.lf(ConcernPageView.this.gcN.hasMore());
                    }
                    if (j.kc()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.gcS.setVisibility(8);
                if (ConcernPageView.this.gcO != null) {
                    ConcernPageView.this.gcO.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void O(boolean z, boolean z2) {
                if (ConcernPageView.this.gcN != null) {
                    ConcernPageView.this.lf(ConcernPageView.this.gcN.hasMore());
                }
                ConcernPageView.this.gcS.setVisibility(0);
                ConcernPageView.this.N(z, z2);
                ConcernPageView.this.aJj();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvj() {
                ConcernPageView.this.N(true, false);
                ConcernPageView.this.aJj();
                if (v.aa(ConcernPageView.this.gcK.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gcU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIS();
            }
        };
        this.gcV = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gcP = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gcP = false;
        this.mSkinType = 3;
        this.dpw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.dpw != i2 && ConcernPageView.this.gcQ != null) {
                    ConcernPageView.this.dpw = i2;
                    if (ConcernPageView.this.dpw == 1) {
                        ConcernPageView.this.gcQ.aJw();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gcQ.aJx();
                    } else {
                        ConcernPageView.this.gcQ.aJw();
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
        this.gcR = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvh() {
                if (ConcernPageView.this.gcQ != null) {
                    ConcernPageView.this.dpw = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gcK)) {
                        ConcernPageView.this.gcQ.aJx();
                    } else {
                        ConcernPageView.this.gcQ.aJw();
                    }
                }
            }
        };
        this.gcT = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvi() {
                if (ConcernPageView.this.gcM == null) {
                    if (ConcernPageView.this.gcO != null) {
                        ConcernPageView.this.gcO.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.N(false, false);
                    return;
                }
                boolean bgM = ConcernPageView.this.bgM();
                ConcernPageView.this.aJj();
                if (bgM) {
                    ConcernPageView.this.o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gcM.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void xW(String str) {
                if (ConcernPageView.this.gcM != null) {
                    ConcernPageView.this.gcM.xX(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                ConcernPageView.this.N(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.gcN != null) {
                        ConcernPageView.this.lf(ConcernPageView.this.gcN.hasMore());
                    }
                    if (j.kc()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.gcS.setVisibility(8);
                if (ConcernPageView.this.gcO != null) {
                    ConcernPageView.this.gcO.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void O(boolean z, boolean z2) {
                if (ConcernPageView.this.gcN != null) {
                    ConcernPageView.this.lf(ConcernPageView.this.gcN.hasMore());
                }
                ConcernPageView.this.gcS.setVisibility(0);
                ConcernPageView.this.N(z, z2);
                ConcernPageView.this.aJj();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bvj() {
                ConcernPageView.this.N(true, false);
                ConcernPageView.this.aJj();
                if (v.aa(ConcernPageView.this.gcK.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gcU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIS();
            }
        };
        this.gcV = new CustomMessageListener(2921058) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gcP = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gcK = new BdTypeRecyclerView(context);
        this.gcK.setLayoutManager(new LinearLayoutManager(context));
        this.gcK.setFadingEdgeLength(0);
        this.gcK.setOverScrollMode(2);
        this.gcS = new BigdaySwipeRefreshLayout(context);
        this.gcS.addView(this.gcK);
        this.dnN = new PbListView(context);
        this.dnN.getView();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.akC();
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.iT(R.color.cp_cont_e);
        this.dnN.setHeight(l.g(context, R.dimen.tbds182));
        this.dnN.setOnClickListener(this.gcU);
        this.gcK.setNextPage(this.dnN);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.gcS);
        ((FrameLayout.LayoutParams) this.gcS.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.gcJ = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.gcJ.setEnable(true);
        this.gcS.setProgressView(this.gcJ);
        int i = (int) (61.0f * getResources().getDisplayMetrics().density);
        this.gcS.setCustomDistances(i, i, i * 2);
        this.gcL = new com.baidu.tieba.homepage.concern.a(context, this.gcK);
        this.gcN = new c(this.pageContext, this.gcK, this.gcL, this.gcS);
        this.gcS.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bqg() {
        this.gcN.a(this.gcT);
        this.gcJ.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aCH().sl("page_concern");
                    ConcernPageView.this.gcN.update();
                }
            }
        });
        this.gcK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aIS();
            }
        });
        this.gcK.removeOnScrollListener(this.mOnScrollListener);
        this.gcK.addOnScrollListener(this.mOnScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lf(boolean z) {
        if (this.dnN != null) {
            if (z) {
                this.dnN.akI();
                this.dnN.iW(0);
                return;
            }
            this.dnN.iX(0);
        }
    }

    public void setCallback(a aVar) {
        this.gcM = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dnN != null) {
            this.dnN.akG();
            this.dnN.iW(0);
        }
        this.gcN.a(z, dataRes, 0, null);
    }

    public void bvc() {
        if (!TbadkCoreApplication.isLogin()) {
            bve();
        } else if (this.gcN != null) {
            o(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.gcN.update();
        }
    }

    public void bvd() {
        if (!TbadkCoreApplication.isLogin()) {
            bve();
        } else if (this.gcN != null) {
            this.gcN.bvk();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(x xVar) {
        if (this.gcN != null) {
            this.gcN.setRecommendFrsNavigationAnimDispatcher(xVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gcO != null) {
                this.gcO.onChangeSkinType(i);
            }
            if (this.djN != null) {
                this.djN.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gcJ != null) {
                this.gcJ.iV(i);
            }
            if (this.dnN != null) {
                this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dnN.iV(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.gcL.onChangeSkinType(i);
            am.l(this, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bvf();
    }

    public void az(String str, int i) {
        if (this.dnN != null) {
            this.dnN.akG();
            this.dnN.iW(0);
        }
        this.gcN.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.gcN != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.gcN.update();
                    }
                }
            });
        }
        this.refreshView.kL(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.qN(str);
        this.refreshView.attachView(view, z);
        this.refreshView.atK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJj() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z, boolean z2) {
        if (this.djN != null) {
            this.djN.dettachView(this);
            this.djN = null;
            this.gcK.setNextPage(this.dnN);
        }
        if (this.gcM != null) {
            this.gcM.P(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bve() {
        if (this.gcO == null) {
            this.gcO = new ConcernNotLoginLayout(getContext());
            this.gcO.onChangeSkinType(this.mSkinType);
        }
        if (this.gcO.getParent() == null) {
            this.gcS.setVisibility(8);
            this.gcO.setVisibility(0);
            addView(this.gcO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, int i) {
        if (this.djN == null) {
            if (i < 0) {
                this.djN = new g(getContext());
            } else {
                this.djN = new g(getContext(), i);
            }
            this.djN.onChangeSkinType();
        }
        this.djN.attachView(this, z);
        this.gcK.setNextPage(null);
        if (this.gcS != null) {
            this.gcS.setVisibility(8);
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
        if (this.gcN != null) {
            this.gcN.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.gcN != null) {
            this.gcN.kc(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gcN != null) {
            this.gcN.lg(z);
        }
        if (this.gcQ != null) {
            this.gcQ.b(this.gcR);
            this.gcQ.a(this.gcR);
            this.gcR.bvh();
        }
    }

    public void reload() {
        if (this.gcK != null && this.gcS != null) {
            if (this.gcP && this.gcK.getFirstVisiblePosition() != 0) {
                this.gcP = false;
                return;
            }
            this.gcK.setSelection(0);
            if (!this.gcS.isRefreshing()) {
                this.gcS.setRefreshing(true);
            }
            if (this.gcR != null) {
                this.gcR.bvh();
            }
        }
    }

    public void onDestroy() {
        if (this.gcQ != null) {
            this.gcQ.b(this.gcR);
        }
        this.gcK.removeOnScrollListener(this.mOnScrollListener);
        this.gcN.a((c.a) null);
        this.gcJ.setListPullRefreshListener(null);
        this.gcJ.a((h.d) null);
        this.gcK.setOnSrollToBottomListener(null);
        this.gcJ.a((h.b) null);
        this.gcJ.release();
        this.gcK.setRecyclerListener(null);
    }

    public void bvf() {
        if (this.gcL != null) {
            this.gcL.notifyDataSetChanged();
        }
    }

    public void bvg() {
        if (this.gcN != null) {
            this.gcN.kc(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIS() {
        if (this.dnN != null && !this.dnN.pP()) {
            this.dnN.akF();
            this.dnN.iW(0);
        }
        this.gcN.aIS();
    }

    public void bny() {
        if (this.gcL != null) {
            List<m> dataList = this.gcL.getDataList();
            if (!v.aa(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.bJl != 0 && kVar.threadData != null) {
                            int[] agr = kVar.threadData.agr();
                            kVar.bJl = agr[0];
                            kVar.bJm = agr[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.gcL != null) {
                            ConcernPageView.this.gcL.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
