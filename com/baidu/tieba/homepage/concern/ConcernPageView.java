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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private View.OnClickListener bVg;
    private g dEq;
    private PbListView dwJ;
    private int dyr;
    private com.baidu.tieba.homepage.personalize.bigday.a gdX;
    private BdTypeRecyclerView gdY;
    private com.baidu.tieba.homepage.concern.a gdZ;
    private a gea;
    private c geb;
    private ConcernNotLoginLayout gec;
    private boolean ged;
    private ScrollFragmentTabHost gee;
    ScrollFragmentTabHost.a gef;
    private BigdaySwipeRefreshLayout geg;
    private c.a geh;
    private View.OnClickListener gei;
    private CustomMessageListener gej;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void S(boolean z, boolean z2);

        void onPullToRefresh();

        void wP(String str);
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gee = scrollFragmentTabHost;
        if (this.gee != null) {
            this.gee.b(this.gef);
            this.gee.a(this.gef);
        }
    }

    public void completePullRefresh() {
        if (this.geg != null) {
            this.geg.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gdZ != null) {
            this.gdZ.setPageUniqueId(bdUniqueId);
        }
        if (this.geb != null) {
            this.geb.p(bdUniqueId);
        }
        if (this.gdX != null) {
            this.gdX.setTag(bdUniqueId);
        }
        if (this.gej != null) {
            this.gej.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gej);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.ged = false;
        this.mSkinType = 3;
        this.dyr = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dyr != i && ConcernPageView.this.gee != null) {
                    ConcernPageView.this.dyr = i;
                    if (ConcernPageView.this.dyr == 1) {
                        ConcernPageView.this.gee.aJA();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gee.aJB();
                    } else {
                        ConcernPageView.this.gee.aJA();
                    }
                }
            }
        };
        this.bVg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetworkAvailableForImmediately()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.gef = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bta() {
                if (ConcernPageView.this.gee != null) {
                    ConcernPageView.this.dyr = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gdY)) {
                        ConcernPageView.this.gee.aJB();
                    } else {
                        ConcernPageView.this.gee.aJA();
                    }
                }
            }
        };
        this.geh = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void btb() {
                if (ConcernPageView.this.gea == null) {
                    if (ConcernPageView.this.gec != null) {
                        ConcernPageView.this.gec.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.Q(false, false);
                    return;
                }
                boolean bfm = ConcernPageView.this.bfm();
                ConcernPageView.this.aJo();
                if (bfm) {
                    ConcernPageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gea.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void wO(String str) {
                if (ConcernPageView.this.gea != null) {
                    ConcernPageView.this.gea.wP(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.Q(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.geb != null) {
                        ConcernPageView.this.kW(ConcernPageView.this.geb.hasMore());
                    }
                    if (j.isNetWorkAvailable()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.geg.setVisibility(8);
                if (ConcernPageView.this.gec != null) {
                    ConcernPageView.this.gec.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void R(boolean z, boolean z2) {
                if (ConcernPageView.this.geb != null) {
                    ConcernPageView.this.kW(ConcernPageView.this.geb.hasMore());
                }
                ConcernPageView.this.geg.setVisibility(0);
                ConcernPageView.this.Q(z, z2);
                ConcernPageView.this.aJo();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void btc() {
                ConcernPageView.this.Q(true, false);
                ConcernPageView.this.aJo();
                if (v.isEmpty(ConcernPageView.this.gdY.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gei = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIW();
            }
        };
        this.gej = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ged = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ged = false;
        this.mSkinType = 3;
        this.dyr = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dyr != i && ConcernPageView.this.gee != null) {
                    ConcernPageView.this.dyr = i;
                    if (ConcernPageView.this.dyr == 1) {
                        ConcernPageView.this.gee.aJA();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gee.aJB();
                    } else {
                        ConcernPageView.this.gee.aJA();
                    }
                }
            }
        };
        this.bVg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetworkAvailableForImmediately()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.gef = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bta() {
                if (ConcernPageView.this.gee != null) {
                    ConcernPageView.this.dyr = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gdY)) {
                        ConcernPageView.this.gee.aJB();
                    } else {
                        ConcernPageView.this.gee.aJA();
                    }
                }
            }
        };
        this.geh = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void btb() {
                if (ConcernPageView.this.gea == null) {
                    if (ConcernPageView.this.gec != null) {
                        ConcernPageView.this.gec.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.Q(false, false);
                    return;
                }
                boolean bfm = ConcernPageView.this.bfm();
                ConcernPageView.this.aJo();
                if (bfm) {
                    ConcernPageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gea.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void wO(String str) {
                if (ConcernPageView.this.gea != null) {
                    ConcernPageView.this.gea.wP(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.Q(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.geb != null) {
                        ConcernPageView.this.kW(ConcernPageView.this.geb.hasMore());
                    }
                    if (j.isNetWorkAvailable()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.geg.setVisibility(8);
                if (ConcernPageView.this.gec != null) {
                    ConcernPageView.this.gec.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void R(boolean z, boolean z2) {
                if (ConcernPageView.this.geb != null) {
                    ConcernPageView.this.kW(ConcernPageView.this.geb.hasMore());
                }
                ConcernPageView.this.geg.setVisibility(0);
                ConcernPageView.this.Q(z, z2);
                ConcernPageView.this.aJo();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void btc() {
                ConcernPageView.this.Q(true, false);
                ConcernPageView.this.aJo();
                if (v.isEmpty(ConcernPageView.this.gdY.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gei = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIW();
            }
        };
        this.gej = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ged = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ged = false;
        this.mSkinType = 3;
        this.dyr = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.dyr != i2 && ConcernPageView.this.gee != null) {
                    ConcernPageView.this.dyr = i2;
                    if (ConcernPageView.this.dyr == 1) {
                        ConcernPageView.this.gee.aJA();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gee.aJB();
                    } else {
                        ConcernPageView.this.gee.aJA();
                    }
                }
            }
        };
        this.bVg = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetworkAvailableForImmediately()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.gef = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bta() {
                if (ConcernPageView.this.gee != null) {
                    ConcernPageView.this.dyr = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gdY)) {
                        ConcernPageView.this.gee.aJB();
                    } else {
                        ConcernPageView.this.gee.aJA();
                    }
                }
            }
        };
        this.geh = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void btb() {
                if (ConcernPageView.this.gea == null) {
                    if (ConcernPageView.this.gec != null) {
                        ConcernPageView.this.gec.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.Q(false, false);
                    return;
                }
                boolean bfm = ConcernPageView.this.bfm();
                ConcernPageView.this.aJo();
                if (bfm) {
                    ConcernPageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gea.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void wO(String str) {
                if (ConcernPageView.this.gea != null) {
                    ConcernPageView.this.gea.wP(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                ConcernPageView.this.Q(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.geb != null) {
                        ConcernPageView.this.kW(ConcernPageView.this.geb.hasMore());
                    }
                    if (j.isNetWorkAvailable()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.geg.setVisibility(8);
                if (ConcernPageView.this.gec != null) {
                    ConcernPageView.this.gec.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void R(boolean z, boolean z2) {
                if (ConcernPageView.this.geb != null) {
                    ConcernPageView.this.kW(ConcernPageView.this.geb.hasMore());
                }
                ConcernPageView.this.geg.setVisibility(0);
                ConcernPageView.this.Q(z, z2);
                ConcernPageView.this.aJo();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void btc() {
                ConcernPageView.this.Q(true, false);
                ConcernPageView.this.aJo();
                if (v.isEmpty(ConcernPageView.this.gdY.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gei = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIW();
            }
        };
        this.gej = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ged = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gdY = new BdTypeRecyclerView(context);
        this.gdY.setLayoutManager(new LinearLayoutManager(context));
        this.gdY.setFadingEdgeLength(0);
        this.gdY.setOverScrollMode(2);
        this.geg = new BigdaySwipeRefreshLayout(context);
        this.geg.addView(this.gdY);
        this.dwJ = new PbListView(context);
        this.dwJ.getView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setLineGone();
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dwJ.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.dwJ.setOnClickListener(this.gei);
        this.gdY.setNextPage(this.dwJ);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.geg);
        ((FrameLayout.LayoutParams) this.geg.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.gdX = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.gdX.setEnable(true);
        this.geg.setProgressView(this.gdX);
        int i = (int) (61.0f * getResources().getDisplayMetrics().density);
        this.geg.setCustomDistances(i, i, i * 2);
        this.gdZ = new com.baidu.tieba.homepage.concern.a(context, this.gdY);
        this.geb = new c(this.pageContext, this.gdY, this.gdZ, this.geg);
        this.geg.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void aNd() {
        this.geb.a(this.geh);
        this.gdX.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aDe().rg("page_concern");
                    ConcernPageView.this.geb.update();
                }
            }
        });
        this.gdY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aIW();
            }
        });
        this.gdY.removeOnScrollListener(this.mOnScrollListener);
        this.gdY.addOnScrollListener(this.mOnScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(boolean z) {
        if (this.dwJ != null) {
            if (z) {
                this.dwJ.showEndLoadData();
                this.dwJ.showEmptyView(0);
                return;
            }
            this.dwJ.hideWithoutEmptyView(0);
        }
    }

    public void setCallback(a aVar) {
        this.gea = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dwJ != null) {
            this.dwJ.endLoadData();
            this.dwJ.showEmptyView(0);
        }
        this.geb.a(z, dataRes, 0, null);
    }

    public void bsV() {
        if (!TbadkCoreApplication.isLogin()) {
            bsX();
        } else if (this.geb != null) {
            p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.geb.update();
        }
    }

    public void bsW() {
        if (!TbadkCoreApplication.isLogin()) {
            bsX();
        } else if (this.geb != null) {
            this.geb.btd();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        if (this.geb != null) {
            this.geb.setRecommendFrsNavigationAnimDispatcher(wVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gec != null) {
                this.gec.onChangeSkinType(i);
            }
            if (this.dEq != null) {
                this.dEq.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gdX != null) {
                this.gdX.changeSkin(i);
            }
            if (this.dwJ != null) {
                this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dwJ.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.gdZ.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bsY();
    }

    public void aw(String str, int i) {
        if (this.dwJ != null) {
            this.dwJ.endLoadData();
            this.dwJ.showEmptyView(0);
        }
        this.geb.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.geb != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.geb.update();
                    }
                }
            });
        }
        this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
        this.refreshView.setSubText(str);
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJo() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z, boolean z2) {
        if (this.dEq != null) {
            this.dEq.dettachView(this);
            this.dEq = null;
            this.gdY.setNextPage(this.dwJ);
        }
        if (this.gea != null) {
            this.gea.S(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bsX() {
        if (this.gec == null) {
            this.gec = new ConcernNotLoginLayout(getContext());
            this.gec.onChangeSkinType(this.mSkinType);
        }
        if (this.gec.getParent() == null) {
            this.geg.setVisibility(8);
            this.gec.setVisibility(0);
            addView(this.gec);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dEq == null) {
            if (i < 0) {
                this.dEq = new g(getContext());
            } else {
                this.dEq = new g(getContext(), i);
            }
            this.dEq.onChangeSkinType();
        }
        this.dEq.attachView(this, z);
        this.gdY.setNextPage(null);
        if (this.geg != null) {
            this.geg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds160);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.ds320), dimensionPixelSize2), NoDataViewFactory.d.aj(R.string.no_context_text_click_refresh, getResources().getDimensionPixelSize(R.dimen.tbds50)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getResources().getString(R.string.refresh), this.bVg)));
            this.mNoDataView.setSubTitleTextSize(l.getDimens(getContext(), R.dimen.fontsize42));
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
        if (this.geb != null) {
            this.geb.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.geb != null) {
            this.geb.jT(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.geb != null) {
            this.geb.kX(z);
        }
        if (this.gee != null) {
            this.gee.b(this.gef);
            this.gee.a(this.gef);
            this.gef.bta();
        }
    }

    public void reload() {
        if (this.gdY != null && this.geg != null) {
            if (this.ged && this.gdY.getFirstVisiblePosition() != 0) {
                this.ged = false;
                return;
            }
            this.gdY.setSelection(0);
            if (!this.geg.isRefreshing()) {
                this.geg.setRefreshing(true);
            }
            if (this.gef != null) {
                this.gef.bta();
            }
        }
    }

    public void onDestroy() {
        if (this.gee != null) {
            this.gee.b(this.gef);
        }
        this.gdY.removeOnScrollListener(this.mOnScrollListener);
        this.geb.a((c.a) null);
        this.gdX.setListPullRefreshListener(null);
        this.gdX.a((h.d) null);
        this.gdY.setOnSrollToBottomListener(null);
        this.gdX.a((h.b) null);
        this.gdX.release();
        this.gdY.setRecyclerListener(null);
    }

    public void bsY() {
        if (this.gdZ != null) {
            this.gdZ.notifyDataSetChanged();
        }
    }

    public void bsZ() {
        if (this.geb != null) {
            this.geb.jT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIW() {
        if (this.dwJ != null && !this.dwJ.isLoading()) {
            this.dwJ.startLoadData();
            this.dwJ.showEmptyView(0);
        }
        this.geb.aIW();
    }

    public void pC() {
        if (this.gdZ != null) {
            List<m> dataList = this.gdZ.getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cbr != 0 && kVar.cbq != null) {
                            int[] imageWidthAndHeight = kVar.cbq.getImageWidthAndHeight();
                            kVar.cbr = imageWidthAndHeight[0];
                            kVar.cbs = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.gdZ != null) {
                            ConcernPageView.this.gdZ.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
