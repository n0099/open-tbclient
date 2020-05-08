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
    private PbListView ePr;
    private int eRI;
    private g eYg;
    private com.baidu.tieba.homepage.personalize.bigday.a hId;
    private BdTypeRecyclerView hIe;
    private com.baidu.tieba.homepage.concern.a hIf;
    private a hIg;
    private c hIh;
    private ConcernNotLoginLayout hIi;
    private boolean hIj;
    private ScrollFragmentTabHost hIk;
    ScrollFragmentTabHost.a hIl;
    private BigdaySwipeRefreshLayout hIm;
    private c.a hIn;
    private View.OnClickListener hIo;
    private CustomMessageListener hIp;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes9.dex */
    public interface a {
        void DP(String str);

        void T(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hIk = scrollFragmentTabHost;
        if (this.hIk != null) {
            this.hIk.b(this.hIl);
            this.hIk.a(this.hIl);
        }
    }

    public void completePullRefresh() {
        if (this.hIm != null) {
            this.hIm.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hIf != null) {
            this.hIf.setPageUniqueId(bdUniqueId);
        }
        if (this.hIh != null) {
            this.hIh.q(bdUniqueId);
        }
        if (this.hId != null) {
            this.hId.setTag(bdUniqueId);
        }
        if (this.hIp != null) {
            this.hIp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hIp);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.hIj = false;
        this.mSkinType = 3;
        this.eRI = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.eRI != i && ConcernPageView.this.hIk != null) {
                    ConcernPageView.this.eRI = i;
                    if (ConcernPageView.this.eRI == 1) {
                        ConcernPageView.this.hIk.blG();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hIk.blH();
                    } else {
                        ConcernPageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hIl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bXU() {
                if (ConcernPageView.this.hIk != null) {
                    ConcernPageView.this.eRI = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hIe)) {
                        ConcernPageView.this.hIk.blH();
                    } else {
                        ConcernPageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hIn = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXV() {
                ConcernPageView.this.blr();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hIe.setSelection(0);
                if (ConcernPageView.this.hIe.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bXR();
                } else {
                    ConcernPageView.this.fK(true);
                }
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void DO(String str) {
                ConcernPageView.this.blr();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bXQ();
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.DP(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.hIe.setVisibility(8);
                    ConcernPageView.this.lV(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blr();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hIh.bXY()) {
                    ConcernPageView.this.bXR();
                } else {
                    ConcernPageView.this.bXQ();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXW() {
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blr();
                ConcernPageView.this.hIe.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hIo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bkZ();
            }
        };
        this.hIp = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hIj = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hIj = false;
        this.mSkinType = 3;
        this.eRI = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.eRI != i && ConcernPageView.this.hIk != null) {
                    ConcernPageView.this.eRI = i;
                    if (ConcernPageView.this.eRI == 1) {
                        ConcernPageView.this.hIk.blG();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hIk.blH();
                    } else {
                        ConcernPageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hIl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bXU() {
                if (ConcernPageView.this.hIk != null) {
                    ConcernPageView.this.eRI = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hIe)) {
                        ConcernPageView.this.hIk.blH();
                    } else {
                        ConcernPageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hIn = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXV() {
                ConcernPageView.this.blr();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hIe.setSelection(0);
                if (ConcernPageView.this.hIe.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bXR();
                } else {
                    ConcernPageView.this.fK(true);
                }
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void DO(String str) {
                ConcernPageView.this.blr();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bXQ();
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.DP(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.hIe.setVisibility(8);
                    ConcernPageView.this.lV(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blr();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hIh.bXY()) {
                    ConcernPageView.this.bXR();
                } else {
                    ConcernPageView.this.bXQ();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXW() {
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blr();
                ConcernPageView.this.hIe.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hIo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bkZ();
            }
        };
        this.hIp = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hIj = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hIj = false;
        this.mSkinType = 3;
        this.eRI = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.eRI != i2 && ConcernPageView.this.hIk != null) {
                    ConcernPageView.this.eRI = i2;
                    if (ConcernPageView.this.eRI == 1) {
                        ConcernPageView.this.hIk.blG();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hIk.blH();
                    } else {
                        ConcernPageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hIl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bXU() {
                if (ConcernPageView.this.hIk != null) {
                    ConcernPageView.this.eRI = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hIe)) {
                        ConcernPageView.this.hIk.blH();
                    } else {
                        ConcernPageView.this.hIk.blG();
                    }
                }
            }
        };
        this.hIn = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXV() {
                ConcernPageView.this.blr();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hIe.setSelection(0);
                if (ConcernPageView.this.hIe.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bXR();
                } else {
                    ConcernPageView.this.fK(true);
                }
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void DO(String str) {
                ConcernPageView.this.blr();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bXQ();
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.DP(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.hIe.setVisibility(8);
                    ConcernPageView.this.lV(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blr();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hIh.bXY()) {
                    ConcernPageView.this.bXR();
                } else {
                    ConcernPageView.this.bXQ();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXW() {
                if (ConcernPageView.this.hIg != null) {
                    ConcernPageView.this.hIg.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blr();
                ConcernPageView.this.hIe.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hIo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bkZ();
            }
        };
        this.hIp = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hIj = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hIe = new BdTypeRecyclerView(context);
        this.hIe.setLayoutManager(new LinearLayoutManager(context));
        this.hIe.setFadingEdgeLength(0);
        this.hIe.setOverScrollMode(2);
        this.hIm = new BigdaySwipeRefreshLayout(context);
        this.hIm.addView(this.hIe);
        this.ePr = new PbListView(context);
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setLineGone();
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.setOnClickListener(this.hIo);
        this.hIe.setNextPage(this.ePr);
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        addView(this.hIm);
        this.hId = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.hId.setEnable(true);
        this.hIm.setProgressView(this.hId);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.hIm.setCustomDistances(i, i, i * 2);
        this.hIf = new com.baidu.tieba.homepage.concern.a(context, this.hIe);
        this.hIh = new c(this.pageContext, this.hIe, this.hIf, this.hIm);
        this.hIm.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bqI() {
        this.hIh.a(this.hIn);
        this.hId.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.bfN().ye("page_concern");
                    ConcernPageView.this.hIh.update();
                }
            }
        });
        this.hIe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bkZ();
            }
        });
        this.hIe.removeOnScrollListener(this.mOnScrollListener);
        this.hIe.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.hIg = aVar;
    }

    public void bXN() {
        if (!TbadkCoreApplication.isLogin()) {
            bXP();
        } else if (this.hIh != null) {
            this.hIh.update();
            fK(true);
        }
    }

    public void bXO() {
        if (!TbadkCoreApplication.isLogin()) {
            bXP();
        } else if (this.hIh != null) {
            this.hIh.bXX();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.hIh != null) {
            this.hIh.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hIi != null) {
                this.hIi.onChangeSkinType(i);
            }
            if (this.eYg != null) {
                this.eYg.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.hId != null) {
                this.hId.changeSkin(i);
            }
            if (this.ePr != null) {
                this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
                this.ePr.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.hIf.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.hIm, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.hIe, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bXS();
    }

    public void aO(String str, int i) {
        this.hIh.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.hIh.a(z, dataRes, 0, null);
    }

    public void lV(boolean z) {
        if (!bJs()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.hIh != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.hIh.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blr() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this);
            this.eYg = null;
        }
    }

    private boolean bJs() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bXP() {
        if (this.hIi == null) {
            this.hIi = new ConcernNotLoginLayout(getContext());
            this.hIi.onChangeSkinType(this.mSkinType);
        }
        if (this.hIi.getParent() == null) {
            this.hIm.setVisibility(8);
            this.hIi.setVisibility(0);
            addView(this.hIi);
        }
    }

    public boolean bJr() {
        if (this.eYg != null) {
            return this.eYg.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(boolean z) {
        if (!bJr()) {
            if (this.eYg == null) {
                this.eYg = new com.baidu.tbadk.k.g(getContext());
                this.eYg.aZ(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.eYg.aYn();
                this.eYg.setWrapStyle(true);
            }
            this.eYg.onChangeSkinType();
            this.eYg.attachView(this, z);
        }
    }

    public void bXQ() {
        this.hIm.setVisibility(0);
        this.hIe.setVisibility(0);
        if (this.hIh.hasMore()) {
            this.ePr.startLoadData();
        } else {
            this.ePr.endLoadDataWithNoMore();
        }
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void bXR() {
        this.hIm.setVisibility(0);
        this.hIe.setVisibility(0);
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.cK(null, getContext().getString(R.string.concern_no_data_title)), null);
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
        if (this.hIh != null) {
            this.hIh.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.hIh != null) {
            this.hIh.mC(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.hIh != null) {
            this.hIh.nH(z);
        }
        if (this.hIk != null) {
            this.hIk.b(this.hIl);
            this.hIk.a(this.hIl);
            this.hIl.bXU();
        }
    }

    public void reload() {
        if (this.hIe != null && this.hIm != null) {
            if (this.hIj && this.hIe.getFirstVisiblePosition() != 0) {
                this.hIj = false;
                return;
            }
            this.hIe.setSelection(0);
            if (!this.hIm.isRefreshing()) {
                this.hIm.setRefreshing(true);
            }
            if (this.hIl != null) {
                this.hIl.bXU();
            }
        }
    }

    public void onDestroy() {
        if (this.hIk != null) {
            this.hIk.b(this.hIl);
        }
        this.hIe.removeOnScrollListener(this.mOnScrollListener);
        this.hIh.a((c.a) null);
        this.hId.setListPullRefreshListener(null);
        this.hId.a((g.d) null);
        this.hIe.setOnSrollToBottomListener(null);
        this.hId.a((g.b) null);
        this.hId.release();
        this.hIe.setRecyclerListener(null);
    }

    public void bXS() {
        if (this.hIf != null) {
            this.hIf.notifyDataSetChanged();
        }
    }

    public void bXT() {
        if (this.hIh != null) {
            this.hIh.mC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkZ() {
        if (this.hIh != null) {
            this.hIh.bkZ();
        }
    }

    public void wJ() {
        if (this.hIf != null) {
            List<m> dataList = this.hIf.getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.dqF != 0 && kVar.dqE != null) {
                            int[] imageWidthAndHeight = kVar.dqE.getImageWidthAndHeight();
                            kVar.dqF = imageWidthAndHeight[0];
                            kVar.dqG = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.hIf != null) {
                            ConcernPageView.this.hIf.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
