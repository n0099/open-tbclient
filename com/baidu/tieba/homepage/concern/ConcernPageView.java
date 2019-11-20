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
    private View.OnClickListener bUp;
    private g dDz;
    private PbListView dvS;
    private int dxA;
    private com.baidu.tieba.homepage.personalize.bigday.a gdg;
    private BdTypeRecyclerView gdh;
    private com.baidu.tieba.homepage.concern.a gdi;
    private a gdj;
    private c gdk;
    private ConcernNotLoginLayout gdl;
    private boolean gdm;
    private ScrollFragmentTabHost gdn;
    ScrollFragmentTabHost.a gdo;
    private BigdaySwipeRefreshLayout gdp;
    private c.a gdq;
    private View.OnClickListener gdr;
    private CustomMessageListener gds;
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
        this.gdn = scrollFragmentTabHost;
        if (this.gdn != null) {
            this.gdn.b(this.gdo);
            this.gdn.a(this.gdo);
        }
    }

    public void completePullRefresh() {
        if (this.gdp != null) {
            this.gdp.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gdi != null) {
            this.gdi.setPageUniqueId(bdUniqueId);
        }
        if (this.gdk != null) {
            this.gdk.p(bdUniqueId);
        }
        if (this.gdg != null) {
            this.gdg.setTag(bdUniqueId);
        }
        if (this.gds != null) {
            this.gds.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gds);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.gdm = false;
        this.mSkinType = 3;
        this.dxA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dxA != i && ConcernPageView.this.gdn != null) {
                    ConcernPageView.this.dxA = i;
                    if (ConcernPageView.this.dxA == 1) {
                        ConcernPageView.this.gdn.aJy();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gdn.aJz();
                    } else {
                        ConcernPageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.bUp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetworkAvailableForImmediately()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.gdo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsY() {
                if (ConcernPageView.this.gdn != null) {
                    ConcernPageView.this.dxA = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gdh)) {
                        ConcernPageView.this.gdn.aJz();
                    } else {
                        ConcernPageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.gdq = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsZ() {
                if (ConcernPageView.this.gdj == null) {
                    if (ConcernPageView.this.gdl != null) {
                        ConcernPageView.this.gdl.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.Q(false, false);
                    return;
                }
                boolean bfk = ConcernPageView.this.bfk();
                ConcernPageView.this.aJm();
                if (bfk) {
                    ConcernPageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gdj.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void wO(String str) {
                if (ConcernPageView.this.gdj != null) {
                    ConcernPageView.this.gdj.wP(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.Q(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.gdk != null) {
                        ConcernPageView.this.kW(ConcernPageView.this.gdk.hasMore());
                    }
                    if (j.isNetWorkAvailable()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.gdp.setVisibility(8);
                if (ConcernPageView.this.gdl != null) {
                    ConcernPageView.this.gdl.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void R(boolean z, boolean z2) {
                if (ConcernPageView.this.gdk != null) {
                    ConcernPageView.this.kW(ConcernPageView.this.gdk.hasMore());
                }
                ConcernPageView.this.gdp.setVisibility(0);
                ConcernPageView.this.Q(z, z2);
                ConcernPageView.this.aJm();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bta() {
                ConcernPageView.this.Q(true, false);
                ConcernPageView.this.aJm();
                if (v.isEmpty(ConcernPageView.this.gdh.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gdr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIU();
            }
        };
        this.gds = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gdm = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdm = false;
        this.mSkinType = 3;
        this.dxA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.dxA != i && ConcernPageView.this.gdn != null) {
                    ConcernPageView.this.dxA = i;
                    if (ConcernPageView.this.dxA == 1) {
                        ConcernPageView.this.gdn.aJy();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gdn.aJz();
                    } else {
                        ConcernPageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.bUp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetworkAvailableForImmediately()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.gdo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsY() {
                if (ConcernPageView.this.gdn != null) {
                    ConcernPageView.this.dxA = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gdh)) {
                        ConcernPageView.this.gdn.aJz();
                    } else {
                        ConcernPageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.gdq = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsZ() {
                if (ConcernPageView.this.gdj == null) {
                    if (ConcernPageView.this.gdl != null) {
                        ConcernPageView.this.gdl.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.Q(false, false);
                    return;
                }
                boolean bfk = ConcernPageView.this.bfk();
                ConcernPageView.this.aJm();
                if (bfk) {
                    ConcernPageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gdj.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void wO(String str) {
                if (ConcernPageView.this.gdj != null) {
                    ConcernPageView.this.gdj.wP(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                ConcernPageView.this.Q(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i == 1) {
                    if (ConcernPageView.this.gdk != null) {
                        ConcernPageView.this.kW(ConcernPageView.this.gdk.hasMore());
                    }
                    if (j.isNetWorkAvailable()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.gdp.setVisibility(8);
                if (ConcernPageView.this.gdl != null) {
                    ConcernPageView.this.gdl.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void R(boolean z, boolean z2) {
                if (ConcernPageView.this.gdk != null) {
                    ConcernPageView.this.kW(ConcernPageView.this.gdk.hasMore());
                }
                ConcernPageView.this.gdp.setVisibility(0);
                ConcernPageView.this.Q(z, z2);
                ConcernPageView.this.aJm();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bta() {
                ConcernPageView.this.Q(true, false);
                ConcernPageView.this.aJm();
                if (v.isEmpty(ConcernPageView.this.gdh.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gdr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIU();
            }
        };
        this.gds = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gdm = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gdm = false;
        this.mSkinType = 3;
        this.dxA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.dxA != i2 && ConcernPageView.this.gdn != null) {
                    ConcernPageView.this.dxA = i2;
                    if (ConcernPageView.this.dxA == 1) {
                        ConcernPageView.this.gdn.aJy();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gdn.aJz();
                    } else {
                        ConcernPageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.bUp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetworkAvailableForImmediately()) {
                    ConcernPageView.this.hideNoDataView();
                    ConcernPageView.this.reload();
                }
            }
        };
        this.gdo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bsY() {
                if (ConcernPageView.this.gdn != null) {
                    ConcernPageView.this.dxA = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gdh)) {
                        ConcernPageView.this.gdn.aJz();
                    } else {
                        ConcernPageView.this.gdn.aJy();
                    }
                }
            }
        };
        this.gdq = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bsZ() {
                if (ConcernPageView.this.gdj == null) {
                    if (ConcernPageView.this.gdl != null) {
                        ConcernPageView.this.gdl.setVisibility(8);
                    }
                    ConcernPageView.this.showNetRefreshView(ConcernPageView.this, TbadkCoreApplication.getInst().getString(R.string.neterror), true);
                    ConcernPageView.this.Q(false, false);
                    return;
                }
                boolean bfk = ConcernPageView.this.bfk();
                ConcernPageView.this.aJm();
                if (bfk) {
                    ConcernPageView.this.p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
                }
                ConcernPageView.this.gdj.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void wO(String str) {
                if (ConcernPageView.this.gdj != null) {
                    ConcernPageView.this.gdj.wP(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                ConcernPageView.this.Q(false, false);
                ConcernPageView.this.hideNoDataView();
                if (i2 == 1) {
                    if (ConcernPageView.this.gdk != null) {
                        ConcernPageView.this.kW(ConcernPageView.this.gdk.hasMore());
                    }
                    if (j.isNetWorkAvailable()) {
                        ConcernPageView.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                ConcernPageView.this.gdp.setVisibility(8);
                if (ConcernPageView.this.gdl != null) {
                    ConcernPageView.this.gdl.setVisibility(8);
                }
                ConcernPageView.this.showNetRefreshView(ConcernPageView.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void R(boolean z, boolean z2) {
                if (ConcernPageView.this.gdk != null) {
                    ConcernPageView.this.kW(ConcernPageView.this.gdk.hasMore());
                }
                ConcernPageView.this.gdp.setVisibility(0);
                ConcernPageView.this.Q(z, z2);
                ConcernPageView.this.aJm();
                ConcernPageView.this.hideNoDataView();
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bta() {
                ConcernPageView.this.Q(true, false);
                ConcernPageView.this.aJm();
                if (v.isEmpty(ConcernPageView.this.gdh.getData())) {
                    ConcernPageView.this.showNoDataView();
                }
            }
        };
        this.gdr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aIU();
            }
        };
        this.gds = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gdm = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gdh = new BdTypeRecyclerView(context);
        this.gdh.setLayoutManager(new LinearLayoutManager(context));
        this.gdh.setFadingEdgeLength(0);
        this.gdh.setOverScrollMode(2);
        this.gdp = new BigdaySwipeRefreshLayout(context);
        this.gdp.addView(this.gdh);
        this.dvS = new PbListView(context);
        this.dvS.getView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setLineGone();
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dvS.setHeight(l.getDimens(context, R.dimen.tbds182));
        this.dvS.setOnClickListener(this.gdr);
        this.gdh.setNextPage(this.dvS);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.gdp);
        ((FrameLayout.LayoutParams) this.gdp.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.gdg = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.gdg.setEnable(true);
        this.gdp.setProgressView(this.gdg);
        int i = (int) (61.0f * getResources().getDisplayMetrics().density);
        this.gdp.setCustomDistances(i, i, i * 2);
        this.gdi = new com.baidu.tieba.homepage.concern.a(context, this.gdh);
        this.gdk = new c(this.pageContext, this.gdh, this.gdi, this.gdp);
        this.gdp.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void aNb() {
        this.gdk.a(this.gdq);
        this.gdg.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aDc().rg("page_concern");
                    ConcernPageView.this.gdk.update();
                }
            }
        });
        this.gdh.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aIU();
            }
        });
        this.gdh.removeOnScrollListener(this.mOnScrollListener);
        this.gdh.addOnScrollListener(this.mOnScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(boolean z) {
        if (this.dvS != null) {
            if (z) {
                this.dvS.showEndLoadData();
                this.dvS.showEmptyView(0);
                return;
            }
            this.dvS.hideWithoutEmptyView(0);
        }
    }

    public void setCallback(a aVar) {
        this.gdj = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.dvS != null) {
            this.dvS.endLoadData();
            this.dvS.showEmptyView(0);
        }
        this.gdk.a(z, dataRes, 0, null);
    }

    public void bsT() {
        if (!TbadkCoreApplication.isLogin()) {
            bsV();
        } else if (this.gdk != null) {
            p(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds520));
            this.gdk.update();
        }
    }

    public void bsU() {
        if (!TbadkCoreApplication.isLogin()) {
            bsV();
        } else if (this.gdk != null) {
            this.gdk.btb();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(w wVar) {
        if (this.gdk != null) {
            this.gdk.setRecommendFrsNavigationAnimDispatcher(wVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gdl != null) {
                this.gdl.onChangeSkinType(i);
            }
            if (this.dDz != null) {
                this.dDz.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gdg != null) {
                this.gdg.changeSkin(i);
            }
            if (this.dvS != null) {
                this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dvS.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.gdi.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bsW();
    }

    public void aw(String str, int i) {
        if (this.dvS != null) {
            this.dvS.endLoadData();
            this.dvS.showEmptyView(0);
        }
        this.gdk.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ConcernPageView.this.gdk != null && TbadkCoreApplication.isLogin()) {
                        ConcernPageView.this.gdk.update();
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
    public void aJm() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z, boolean z2) {
        if (this.dDz != null) {
            this.dDz.dettachView(this);
            this.dDz = null;
            this.gdh.setNextPage(this.dvS);
        }
        if (this.gdj != null) {
            this.gdj.S(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bfk() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bsV() {
        if (this.gdl == null) {
            this.gdl = new ConcernNotLoginLayout(getContext());
            this.gdl.onChangeSkinType(this.mSkinType);
        }
        if (this.gdl.getParent() == null) {
            this.gdp.setVisibility(8);
            this.gdl.setVisibility(0);
            addView(this.gdl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, int i) {
        if (this.dDz == null) {
            if (i < 0) {
                this.dDz = new g(getContext());
            } else {
                this.dDz = new g(getContext(), i);
            }
            this.dDz.onChangeSkinType();
        }
        this.dDz.attachView(this, z);
        this.gdh.setNextPage(null);
        if (this.gdp != null) {
            this.gdp.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds160);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds420);
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_03, dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.ds320), dimensionPixelSize2), NoDataViewFactory.d.ah(R.string.no_context_text_click_refresh, getResources().getDimensionPixelSize(R.dimen.tbds50)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getContext().getResources().getString(R.string.refresh), this.bUp)));
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
        if (this.gdk != null) {
            this.gdk.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.gdk != null) {
            this.gdk.jT(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gdk != null) {
            this.gdk.kX(z);
        }
        if (this.gdn != null) {
            this.gdn.b(this.gdo);
            this.gdn.a(this.gdo);
            this.gdo.bsY();
        }
    }

    public void reload() {
        if (this.gdh != null && this.gdp != null) {
            if (this.gdm && this.gdh.getFirstVisiblePosition() != 0) {
                this.gdm = false;
                return;
            }
            this.gdh.setSelection(0);
            if (!this.gdp.isRefreshing()) {
                this.gdp.setRefreshing(true);
            }
            if (this.gdo != null) {
                this.gdo.bsY();
            }
        }
    }

    public void onDestroy() {
        if (this.gdn != null) {
            this.gdn.b(this.gdo);
        }
        this.gdh.removeOnScrollListener(this.mOnScrollListener);
        this.gdk.a((c.a) null);
        this.gdg.setListPullRefreshListener(null);
        this.gdg.a((h.d) null);
        this.gdh.setOnSrollToBottomListener(null);
        this.gdg.a((h.b) null);
        this.gdg.release();
        this.gdh.setRecyclerListener(null);
    }

    public void bsW() {
        if (this.gdi != null) {
            this.gdi.notifyDataSetChanged();
        }
    }

    public void bsX() {
        if (this.gdk != null) {
            this.gdk.jT(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIU() {
        if (this.dvS != null && !this.dvS.isLoading()) {
            this.dvS.startLoadData();
            this.dvS.showEmptyView(0);
        }
        this.gdk.aIU();
    }

    public void pC() {
        if (this.gdi != null) {
            List<m> dataList = this.gdi.getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.caA != 0 && kVar.caz != null) {
                            int[] imageWidthAndHeight = kVar.caz.getImageWidthAndHeight();
                            kVar.caA = imageWidthAndHeight[0];
                            kVar.caB = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.gdi != null) {
                            ConcernPageView.this.gdi.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
