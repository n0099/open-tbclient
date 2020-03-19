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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.a.d;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.concern.view.ConcernNotLoginLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes9.dex */
public class ConcernPageView extends FrameLayout {
    private PbListView elM;
    private int eog;
    private g euG;
    private com.baidu.tieba.homepage.personalize.bigday.a gYg;
    private BdTypeRecyclerView gYh;
    private com.baidu.tieba.homepage.concern.a gYi;
    private a gYj;
    private c gYk;
    private ConcernNotLoginLayout gYl;
    private boolean gYm;
    private ScrollFragmentTabHost gYn;
    ScrollFragmentTabHost.a gYo;
    private BigdaySwipeRefreshLayout gYp;
    private c.a gYq;
    private View.OnClickListener gYr;
    private CustomMessageListener gYs;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes9.dex */
    public interface a {
        void Ce(String str);

        void T(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gYn = scrollFragmentTabHost;
        if (this.gYn != null) {
            this.gYn.b(this.gYo);
            this.gYn.a(this.gYo);
        }
    }

    public void completePullRefresh() {
        if (this.gYp != null) {
            this.gYp.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gYi != null) {
            this.gYi.setPageUniqueId(bdUniqueId);
        }
        if (this.gYk != null) {
            this.gYk.q(bdUniqueId);
        }
        if (this.gYg != null) {
            this.gYg.setTag(bdUniqueId);
        }
        if (this.gYs != null) {
            this.gYs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gYs);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.gYm = false;
        this.mSkinType = 3;
        this.eog = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.eog != i && ConcernPageView.this.gYn != null) {
                    ConcernPageView.this.eog = i;
                    if (ConcernPageView.this.eog == 1) {
                        ConcernPageView.this.gYn.bcR();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gYn.bcS();
                    } else {
                        ConcernPageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.gYo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNv() {
                if (ConcernPageView.this.gYn != null) {
                    ConcernPageView.this.eog = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gYh)) {
                        ConcernPageView.this.gYn.bcS();
                    } else {
                        ConcernPageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.gYq = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNw() {
                ConcernPageView.this.bcC();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gYh.setSelection(0);
                if (ConcernPageView.this.gYh.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNs();
                } else {
                    ConcernPageView.this.eN(true);
                }
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cd(String str) {
                ConcernPageView.this.bcC();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNr();
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.Ce(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gYh.setVisibility(8);
                    ConcernPageView.this.kS(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcC();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gYk.bNz()) {
                    ConcernPageView.this.bNs();
                } else {
                    ConcernPageView.this.bNr();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNx() {
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcC();
                ConcernPageView.this.gYh.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gYr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bck();
            }
        };
        this.gYs = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gYm = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gYm = false;
        this.mSkinType = 3;
        this.eog = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.eog != i && ConcernPageView.this.gYn != null) {
                    ConcernPageView.this.eog = i;
                    if (ConcernPageView.this.eog == 1) {
                        ConcernPageView.this.gYn.bcR();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gYn.bcS();
                    } else {
                        ConcernPageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.gYo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNv() {
                if (ConcernPageView.this.gYn != null) {
                    ConcernPageView.this.eog = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gYh)) {
                        ConcernPageView.this.gYn.bcS();
                    } else {
                        ConcernPageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.gYq = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNw() {
                ConcernPageView.this.bcC();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gYh.setSelection(0);
                if (ConcernPageView.this.gYh.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNs();
                } else {
                    ConcernPageView.this.eN(true);
                }
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cd(String str) {
                ConcernPageView.this.bcC();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNr();
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.Ce(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gYh.setVisibility(8);
                    ConcernPageView.this.kS(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcC();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gYk.bNz()) {
                    ConcernPageView.this.bNs();
                } else {
                    ConcernPageView.this.bNr();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNx() {
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcC();
                ConcernPageView.this.gYh.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gYr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bck();
            }
        };
        this.gYs = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gYm = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gYm = false;
        this.mSkinType = 3;
        this.eog = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.eog != i2 && ConcernPageView.this.gYn != null) {
                    ConcernPageView.this.eog = i2;
                    if (ConcernPageView.this.eog == 1) {
                        ConcernPageView.this.gYn.bcR();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gYn.bcS();
                    } else {
                        ConcernPageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.gYo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNv() {
                if (ConcernPageView.this.gYn != null) {
                    ConcernPageView.this.eog = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gYh)) {
                        ConcernPageView.this.gYn.bcS();
                    } else {
                        ConcernPageView.this.gYn.bcR();
                    }
                }
            }
        };
        this.gYq = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNw() {
                ConcernPageView.this.bcC();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gYh.setSelection(0);
                if (ConcernPageView.this.gYh.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNs();
                } else {
                    ConcernPageView.this.eN(true);
                }
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cd(String str) {
                ConcernPageView.this.bcC();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNr();
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.Ce(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.gYh.setVisibility(8);
                    ConcernPageView.this.kS(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcC();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gYk.bNz()) {
                    ConcernPageView.this.bNs();
                } else {
                    ConcernPageView.this.bNr();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNx() {
                if (ConcernPageView.this.gYj != null) {
                    ConcernPageView.this.gYj.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcC();
                ConcernPageView.this.gYh.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gYr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bck();
            }
        };
        this.gYs = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gYm = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gYh = new BdTypeRecyclerView(context);
        this.gYh.setLayoutManager(new LinearLayoutManager(context));
        this.gYh.setFadingEdgeLength(0);
        this.gYh.setOverScrollMode(2);
        this.gYp = new BigdaySwipeRefreshLayout(context);
        this.gYp.addView(this.gYh);
        this.elM = new PbListView(context);
        this.elM.createView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setLineGone();
        this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elM.setOnClickListener(this.gYr);
        this.gYh.setNextPage(this.elM);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.gYp);
        this.gYg = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.gYg.setEnable(true);
        this.gYp.setProgressView(this.gYg);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.gYp.setCustomDistances(i, i, i * 2);
        this.gYi = new com.baidu.tieba.homepage.concern.a(context, this.gYh);
        this.gYk = new c(this.pageContext, this.gYh, this.gYi, this.gYp);
        this.gYp.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void initListeners() {
        this.gYk.a(this.gYq);
        this.gYg.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aXK().wP("page_concern");
                    ConcernPageView.this.gYk.update();
                }
            }
        });
        this.gYh.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bck();
            }
        });
        this.gYh.removeOnScrollListener(this.mOnScrollListener);
        this.gYh.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.gYj = aVar;
    }

    public void bNo() {
        if (!TbadkCoreApplication.isLogin()) {
            bNq();
        } else if (this.gYk != null) {
            this.gYk.update();
            eN(true);
        }
    }

    public void bNp() {
        if (!TbadkCoreApplication.isLogin()) {
            bNq();
        } else if (this.gYk != null) {
            this.gYk.bNy();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.gYk != null) {
            this.gYk.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gYl != null) {
                this.gYl.onChangeSkinType(i);
            }
            if (this.euG != null) {
                this.euG.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gYg != null) {
                this.gYg.changeSkin(i);
            }
            if (this.elM != null) {
                this.elM.setTextColor(am.getColor(R.color.cp_cont_d));
                this.elM.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.gYi.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.gYp, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gYh, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bNt();
    }

    public void aE(String str, int i) {
        this.gYk.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.gYk.a(z, dataRes, 0, null);
    }

    public void kS(boolean z) {
        if (!bzs()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.gYk != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.gYk.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcC() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this);
            this.euG = null;
        }
    }

    private boolean bzs() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bNq() {
        if (this.gYl == null) {
            this.gYl = new ConcernNotLoginLayout(getContext());
            this.gYl.onChangeSkinType(this.mSkinType);
        }
        if (this.gYl.getParent() == null) {
            this.gYp.setVisibility(8);
            this.gYl.setVisibility(0);
            addView(this.gYl);
        }
    }

    public boolean bzr() {
        if (this.euG != null) {
            return this.euG.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(boolean z) {
        if (!bzr()) {
            if (this.euG == null) {
                this.euG = new com.baidu.tbadk.k.g(getContext());
                this.euG.aN(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.euG.aPY();
                this.euG.setWrapStyle(true);
            }
            this.euG.onChangeSkinType();
            this.euG.attachView(this, z);
        }
    }

    public void bNr() {
        this.gYp.setVisibility(0);
        this.gYh.setVisibility(0);
        if (this.gYk.hasMore()) {
            this.elM.startLoadData();
        } else {
            this.elM.endLoadDataWithNoMore();
        }
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void bNs() {
        this.gYp.setVisibility(0);
        this.gYh.setVisibility(0);
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.cz(null, getContext().getString(R.string.concern_no_data_title)), null);
            this.mNoDataView.setTitleContainerMargin(R.dimen.tbds0, R.dimen.tbds0);
        }
        this.mNoDataView.onChangeSkinType(this.pageContext, TbadkCoreApplication.getInst().getSkinType());
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
        if (this.gYk != null) {
            this.gYk.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.gYk != null) {
            this.gYk.lz(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gYk != null) {
            this.gYk.mD(z);
        }
        if (this.gYn != null) {
            this.gYn.b(this.gYo);
            this.gYn.a(this.gYo);
            this.gYo.bNv();
        }
    }

    public void reload() {
        if (this.gYh != null && this.gYp != null) {
            if (this.gYm && this.gYh.getFirstVisiblePosition() != 0) {
                this.gYm = false;
                return;
            }
            this.gYh.setSelection(0);
            if (!this.gYp.isRefreshing()) {
                this.gYp.setRefreshing(true);
            }
            if (this.gYo != null) {
                this.gYo.bNv();
            }
        }
    }

    public void onDestroy() {
        if (this.gYn != null) {
            this.gYn.b(this.gYo);
        }
        this.gYh.removeOnScrollListener(this.mOnScrollListener);
        this.gYk.a((c.a) null);
        this.gYg.setListPullRefreshListener(null);
        this.gYg.a((g.d) null);
        this.gYh.setOnSrollToBottomListener(null);
        this.gYg.a((g.b) null);
        this.gYg.release();
        this.gYh.setRecyclerListener(null);
    }

    public void bNt() {
        if (this.gYi != null) {
            this.gYi.notifyDataSetChanged();
        }
    }

    public void bNu() {
        if (this.gYk != null) {
            this.gYk.lz(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bck() {
        if (this.gYk != null) {
            this.gYk.bck();
        }
    }

    public void sr() {
        if (this.gYi != null) {
            List<m> dataList = this.gYi.getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cRu != 0 && kVar.cRt != null) {
                            int[] imageWidthAndHeight = kVar.cRt.getImageWidthAndHeight();
                            kVar.cRu = imageWidthAndHeight[0];
                            kVar.cRv = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.gYi != null) {
                            ConcernPageView.this.gYi.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
