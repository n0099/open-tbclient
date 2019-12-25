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
/* loaded from: classes6.dex */
public class ConcernPageView extends FrameLayout {
    private PbListView egU;
    private int eiC;
    private g eoy;
    private c.a gRA;
    private View.OnClickListener gRB;
    private CustomMessageListener gRC;
    private com.baidu.tieba.homepage.personalize.bigday.a gRq;
    private BdTypeRecyclerView gRr;
    private com.baidu.tieba.homepage.concern.a gRs;
    private a gRt;
    private c gRu;
    private ConcernNotLoginLayout gRv;
    private boolean gRw;
    private ScrollFragmentTabHost gRx;
    ScrollFragmentTabHost.a gRy;
    private BigdaySwipeRefreshLayout gRz;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes6.dex */
    public interface a {
        void BD(String str);

        void R(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gRx = scrollFragmentTabHost;
        if (this.gRx != null) {
            this.gRx.b(this.gRy);
            this.gRx.a(this.gRy);
        }
    }

    public void completePullRefresh() {
        if (this.gRz != null) {
            this.gRz.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gRs != null) {
            this.gRs.setPageUniqueId(bdUniqueId);
        }
        if (this.gRu != null) {
            this.gRu.q(bdUniqueId);
        }
        if (this.gRq != null) {
            this.gRq.setTag(bdUniqueId);
        }
        if (this.gRC != null) {
            this.gRC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gRC);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.gRw = false;
        this.mSkinType = 3;
        this.eiC = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.eiC != i && ConcernPageView.this.gRx != null) {
                    ConcernPageView.this.eiC = i;
                    if (ConcernPageView.this.eiC == 1) {
                        ConcernPageView.this.gRx.aZW();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gRx.aZX();
                    } else {
                        ConcernPageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gRy = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bKw() {
                if (ConcernPageView.this.gRx != null) {
                    ConcernPageView.this.eiC = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gRr)) {
                        ConcernPageView.this.gRx.aZX();
                    } else {
                        ConcernPageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gRA = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bKx() {
                ConcernPageView.this.aZK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gRr.setSelection(0);
                if (ConcernPageView.this.gRr.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bKt();
                } else {
                    ConcernPageView.this.eA(true);
                }
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void BC(String str) {
                ConcernPageView.this.aZK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bKs();
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.BD(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.R(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gRr.setVisibility(8);
                    ConcernPageView.this.ky(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Q(boolean z, boolean z2) {
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.R(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.aZK();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gRu.bKA()) {
                    ConcernPageView.this.bKt();
                } else {
                    ConcernPageView.this.bKs();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bKy() {
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.R(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.aZK();
                ConcernPageView.this.gRr.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gRB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aZs();
            }
        };
        this.gRC = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gRw = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gRw = false;
        this.mSkinType = 3;
        this.eiC = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.eiC != i && ConcernPageView.this.gRx != null) {
                    ConcernPageView.this.eiC = i;
                    if (ConcernPageView.this.eiC == 1) {
                        ConcernPageView.this.gRx.aZW();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gRx.aZX();
                    } else {
                        ConcernPageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gRy = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bKw() {
                if (ConcernPageView.this.gRx != null) {
                    ConcernPageView.this.eiC = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gRr)) {
                        ConcernPageView.this.gRx.aZX();
                    } else {
                        ConcernPageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gRA = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bKx() {
                ConcernPageView.this.aZK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gRr.setSelection(0);
                if (ConcernPageView.this.gRr.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bKt();
                } else {
                    ConcernPageView.this.eA(true);
                }
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void BC(String str) {
                ConcernPageView.this.aZK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bKs();
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.BD(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.R(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gRr.setVisibility(8);
                    ConcernPageView.this.ky(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Q(boolean z, boolean z2) {
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.R(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.aZK();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gRu.bKA()) {
                    ConcernPageView.this.bKt();
                } else {
                    ConcernPageView.this.bKs();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bKy() {
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.R(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.aZK();
                ConcernPageView.this.gRr.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gRB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aZs();
            }
        };
        this.gRC = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gRw = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gRw = false;
        this.mSkinType = 3;
        this.eiC = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.eiC != i2 && ConcernPageView.this.gRx != null) {
                    ConcernPageView.this.eiC = i2;
                    if (ConcernPageView.this.eiC == 1) {
                        ConcernPageView.this.gRx.aZW();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gRx.aZX();
                    } else {
                        ConcernPageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gRy = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bKw() {
                if (ConcernPageView.this.gRx != null) {
                    ConcernPageView.this.eiC = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gRr)) {
                        ConcernPageView.this.gRx.aZX();
                    } else {
                        ConcernPageView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gRA = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bKx() {
                ConcernPageView.this.aZK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gRr.setSelection(0);
                if (ConcernPageView.this.gRr.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bKt();
                } else {
                    ConcernPageView.this.eA(true);
                }
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void BC(String str) {
                ConcernPageView.this.aZK();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bKs();
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.BD(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.R(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.gRr.setVisibility(8);
                    ConcernPageView.this.ky(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Q(boolean z, boolean z2) {
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.R(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.aZK();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gRu.bKA()) {
                    ConcernPageView.this.bKt();
                } else {
                    ConcernPageView.this.bKs();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bKy() {
                if (ConcernPageView.this.gRt != null) {
                    ConcernPageView.this.gRt.R(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.aZK();
                ConcernPageView.this.gRr.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gRB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.aZs();
            }
        };
        this.gRC = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gRw = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gRr = new BdTypeRecyclerView(context);
        this.gRr.setLayoutManager(new LinearLayoutManager(context));
        this.gRr.setFadingEdgeLength(0);
        this.gRr.setOverScrollMode(2);
        this.gRz = new BigdaySwipeRefreshLayout(context);
        this.gRz.addView(this.gRr);
        this.egU = new PbListView(context);
        this.egU.createView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setLineGone();
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.egU.setOnClickListener(this.gRB);
        this.gRr.setNextPage(this.egU);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.gRz);
        this.gRq = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.gRq.setEnable(true);
        this.gRz.setProgressView(this.gRq);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.gRz.setCustomDistances(i, i, i * 2);
        this.gRs = new com.baidu.tieba.homepage.concern.a(context, this.gRr);
        this.gRu = new c(this.pageContext, this.gRr, this.gRs, this.gRz);
        this.gRz.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void initListeners() {
        this.gRu.a(this.gRA);
        this.gRq.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aUV().wp("page_concern");
                    ConcernPageView.this.gRu.update();
                }
            }
        });
        this.gRr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.aZs();
            }
        });
        this.gRr.removeOnScrollListener(this.mOnScrollListener);
        this.gRr.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.gRt = aVar;
    }

    public void bKp() {
        if (!TbadkCoreApplication.isLogin()) {
            bKr();
        } else if (this.gRu != null) {
            this.gRu.update();
            eA(true);
        }
    }

    public void bKq() {
        if (!TbadkCoreApplication.isLogin()) {
            bKr();
        } else if (this.gRu != null) {
            this.gRu.bKz();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.gRu != null) {
            this.gRu.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gRv != null) {
                this.gRv.onChangeSkinType(i);
            }
            if (this.eoy != null) {
                this.eoy.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gRq != null) {
                this.gRq.changeSkin(i);
            }
            if (this.egU != null) {
                this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
                this.egU.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.gRs.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.gRz, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gRr, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bKu();
    }

    public void aF(String str, int i) {
        this.gRu.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.gRu.a(z, dataRes, 0, null);
    }

    public void ky(boolean z) {
        if (!bwF()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.gRu != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.gRu.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this);
            this.eoy = null;
        }
    }

    private boolean bwF() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bKr() {
        if (this.gRv == null) {
            this.gRv = new ConcernNotLoginLayout(getContext());
            this.gRv.onChangeSkinType(this.mSkinType);
        }
        if (this.gRv.getParent() == null) {
            this.gRz.setVisibility(8);
            this.gRv.setVisibility(0);
            addView(this.gRv);
        }
    }

    public boolean bwE() {
        if (this.eoy != null) {
            return this.eoy.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(boolean z) {
        if (!bwE()) {
            if (this.eoy == null) {
                this.eoy = new com.baidu.tbadk.k.g(getContext());
                this.eoy.mm(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.eoy.aNc();
                this.eoy.setWrapStyle(true);
            }
            this.eoy.onChangeSkinType();
            this.eoy.attachView(this, z);
        }
    }

    public void bKs() {
        this.gRz.setVisibility(0);
        this.gRr.setVisibility(0);
        if (this.gRu.hasMore()) {
            this.egU.startLoadData();
        } else {
            this.egU.endLoadDataWithNoMore();
        }
        this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.egU.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void bKt() {
        this.gRz.setVisibility(0);
        this.gRr.setVisibility(0);
        this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.egU.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.cr(null, getContext().getString(R.string.concern_no_data_title)), null);
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
        if (this.gRu != null) {
            this.gRu.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.gRu != null) {
            this.gRu.lf(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gRu != null) {
            this.gRu.mk(z);
        }
        if (this.gRx != null) {
            this.gRx.b(this.gRy);
            this.gRx.a(this.gRy);
            this.gRy.bKw();
        }
    }

    public void reload() {
        if (this.gRr != null && this.gRz != null) {
            if (this.gRw && this.gRr.getFirstVisiblePosition() != 0) {
                this.gRw = false;
                return;
            }
            this.gRr.setSelection(0);
            if (!this.gRz.isRefreshing()) {
                this.gRz.setRefreshing(true);
            }
            if (this.gRy != null) {
                this.gRy.bKw();
            }
        }
    }

    public void onDestroy() {
        if (this.gRx != null) {
            this.gRx.b(this.gRy);
        }
        this.gRr.removeOnScrollListener(this.mOnScrollListener);
        this.gRu.a((c.a) null);
        this.gRq.setListPullRefreshListener(null);
        this.gRq.a((g.d) null);
        this.gRr.setOnSrollToBottomListener(null);
        this.gRq.a((g.b) null);
        this.gRq.release();
        this.gRr.setRecyclerListener(null);
    }

    public void bKu() {
        if (this.gRs != null) {
            this.gRs.notifyDataSetChanged();
        }
    }

    public void bKv() {
        if (this.gRu != null) {
            this.gRu.lf(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZs() {
        if (this.gRu != null) {
            this.gRu.aZs();
        }
    }

    public void qZ() {
        if (this.gRs != null) {
            List<m> dataList = this.gRs.getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cMS != 0 && kVar.cMR != null) {
                            int[] imageWidthAndHeight = kVar.cMR.getImageWidthAndHeight();
                            kVar.cMS = imageWidthAndHeight[0];
                            kVar.cMT = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.gRs != null) {
                            ConcernPageView.this.gRs.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
