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
    private PbListView elj;
    private int enB;
    private g etX;
    private com.baidu.tieba.homepage.personalize.bigday.a gWN;
    private BdTypeRecyclerView gWO;
    private com.baidu.tieba.homepage.concern.a gWP;
    private a gWQ;
    private c gWR;
    private ConcernNotLoginLayout gWS;
    private boolean gWT;
    private ScrollFragmentTabHost gWU;
    ScrollFragmentTabHost.a gWV;
    private BigdaySwipeRefreshLayout gWW;
    private c.a gWX;
    private View.OnClickListener gWY;
    private CustomMessageListener gWZ;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes9.dex */
    public interface a {
        void Cd(String str);

        void T(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gWU = scrollFragmentTabHost;
        if (this.gWU != null) {
            this.gWU.b(this.gWV);
            this.gWU.a(this.gWV);
        }
    }

    public void completePullRefresh() {
        if (this.gWW != null) {
            this.gWW.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gWP != null) {
            this.gWP.setPageUniqueId(bdUniqueId);
        }
        if (this.gWR != null) {
            this.gWR.q(bdUniqueId);
        }
        if (this.gWN != null) {
            this.gWN.setTag(bdUniqueId);
        }
        if (this.gWZ != null) {
            this.gWZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gWZ);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.gWT = false;
        this.mSkinType = 3;
        this.enB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.enB != i && ConcernPageView.this.gWU != null) {
                    ConcernPageView.this.enB = i;
                    if (ConcernPageView.this.enB == 1) {
                        ConcernPageView.this.gWU.bcM();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gWU.bcN();
                    } else {
                        ConcernPageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.gWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNg() {
                if (ConcernPageView.this.gWU != null) {
                    ConcernPageView.this.enB = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gWO)) {
                        ConcernPageView.this.gWU.bcN();
                    } else {
                        ConcernPageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.gWX = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNh() {
                ConcernPageView.this.bcx();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gWO.setSelection(0);
                if (ConcernPageView.this.gWO.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNd();
                } else {
                    ConcernPageView.this.eM(true);
                }
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cc(String str) {
                ConcernPageView.this.bcx();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNc();
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.Cd(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gWO.setVisibility(8);
                    ConcernPageView.this.kN(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcx();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gWR.bNk()) {
                    ConcernPageView.this.bNd();
                } else {
                    ConcernPageView.this.bNc();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNi() {
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcx();
                ConcernPageView.this.gWO.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bcf();
            }
        };
        this.gWZ = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gWT = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWT = false;
        this.mSkinType = 3;
        this.enB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.enB != i && ConcernPageView.this.gWU != null) {
                    ConcernPageView.this.enB = i;
                    if (ConcernPageView.this.enB == 1) {
                        ConcernPageView.this.gWU.bcM();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gWU.bcN();
                    } else {
                        ConcernPageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.gWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNg() {
                if (ConcernPageView.this.gWU != null) {
                    ConcernPageView.this.enB = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gWO)) {
                        ConcernPageView.this.gWU.bcN();
                    } else {
                        ConcernPageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.gWX = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNh() {
                ConcernPageView.this.bcx();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gWO.setSelection(0);
                if (ConcernPageView.this.gWO.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNd();
                } else {
                    ConcernPageView.this.eM(true);
                }
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cc(String str) {
                ConcernPageView.this.bcx();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNc();
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.Cd(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gWO.setVisibility(8);
                    ConcernPageView.this.kN(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcx();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gWR.bNk()) {
                    ConcernPageView.this.bNd();
                } else {
                    ConcernPageView.this.bNc();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNi() {
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcx();
                ConcernPageView.this.gWO.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bcf();
            }
        };
        this.gWZ = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gWT = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gWT = false;
        this.mSkinType = 3;
        this.enB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.enB != i2 && ConcernPageView.this.gWU != null) {
                    ConcernPageView.this.enB = i2;
                    if (ConcernPageView.this.enB == 1) {
                        ConcernPageView.this.gWU.bcM();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gWU.bcN();
                    } else {
                        ConcernPageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.gWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNg() {
                if (ConcernPageView.this.gWU != null) {
                    ConcernPageView.this.enB = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gWO)) {
                        ConcernPageView.this.gWU.bcN();
                    } else {
                        ConcernPageView.this.gWU.bcM();
                    }
                }
            }
        };
        this.gWX = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNh() {
                ConcernPageView.this.bcx();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gWO.setSelection(0);
                if (ConcernPageView.this.gWO.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNd();
                } else {
                    ConcernPageView.this.eM(true);
                }
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cc(String str) {
                ConcernPageView.this.bcx();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNc();
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.Cd(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.gWO.setVisibility(8);
                    ConcernPageView.this.kN(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcx();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gWR.bNk()) {
                    ConcernPageView.this.bNd();
                } else {
                    ConcernPageView.this.bNc();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNi() {
                if (ConcernPageView.this.gWQ != null) {
                    ConcernPageView.this.gWQ.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcx();
                ConcernPageView.this.gWO.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gWY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bcf();
            }
        };
        this.gWZ = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gWT = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gWO = new BdTypeRecyclerView(context);
        this.gWO.setLayoutManager(new LinearLayoutManager(context));
        this.gWO.setFadingEdgeLength(0);
        this.gWO.setOverScrollMode(2);
        this.gWW = new BigdaySwipeRefreshLayout(context);
        this.gWW.addView(this.gWO);
        this.elj = new PbListView(context);
        this.elj.createView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setLineGone();
        this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elj.setOnClickListener(this.gWY);
        this.gWO.setNextPage(this.elj);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.gWW);
        this.gWN = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.gWN.setEnable(true);
        this.gWW.setProgressView(this.gWN);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.gWW.setCustomDistances(i, i, i * 2);
        this.gWP = new com.baidu.tieba.homepage.concern.a(context, this.gWO);
        this.gWR = new c(this.pageContext, this.gWO, this.gWP, this.gWW);
        this.gWW.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void initListeners() {
        this.gWR.a(this.gWX);
        this.gWN.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aXF().wN("page_concern");
                    ConcernPageView.this.gWR.update();
                }
            }
        });
        this.gWO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bcf();
            }
        });
        this.gWO.removeOnScrollListener(this.mOnScrollListener);
        this.gWO.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.gWQ = aVar;
    }

    public void bMZ() {
        if (!TbadkCoreApplication.isLogin()) {
            bNb();
        } else if (this.gWR != null) {
            this.gWR.update();
            eM(true);
        }
    }

    public void bNa() {
        if (!TbadkCoreApplication.isLogin()) {
            bNb();
        } else if (this.gWR != null) {
            this.gWR.bNj();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.gWR != null) {
            this.gWR.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gWS != null) {
                this.gWS.onChangeSkinType(i);
            }
            if (this.etX != null) {
                this.etX.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gWN != null) {
                this.gWN.changeSkin(i);
            }
            if (this.elj != null) {
                this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
                this.elj.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.gWP.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.gWW, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gWO, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bNe();
    }

    public void aE(String str, int i) {
        this.gWR.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.gWR.a(z, dataRes, 0, null);
    }

    public void kN(boolean z) {
        if (!bzl()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.gWR != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.gWR.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcx() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this);
            this.etX = null;
        }
    }

    private boolean bzl() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bNb() {
        if (this.gWS == null) {
            this.gWS = new ConcernNotLoginLayout(getContext());
            this.gWS.onChangeSkinType(this.mSkinType);
        }
        if (this.gWS.getParent() == null) {
            this.gWW.setVisibility(8);
            this.gWS.setVisibility(0);
            addView(this.gWS);
        }
    }

    public boolean bzk() {
        if (this.etX != null) {
            return this.etX.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(boolean z) {
        if (!bzk()) {
            if (this.etX == null) {
                this.etX = new com.baidu.tbadk.k.g(getContext());
                this.etX.aN(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.etX.aPT();
                this.etX.setWrapStyle(true);
            }
            this.etX.onChangeSkinType();
            this.etX.attachView(this, z);
        }
    }

    public void bNc() {
        this.gWW.setVisibility(0);
        this.gWO.setVisibility(0);
        if (this.gWR.hasMore()) {
            this.elj.startLoadData();
        } else {
            this.elj.endLoadDataWithNoMore();
        }
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void bNd() {
        this.gWW.setVisibility(0);
        this.gWO.setVisibility(0);
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.cA(null, getContext().getString(R.string.concern_no_data_title)), null);
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
        if (this.gWR != null) {
            this.gWR.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.gWR != null) {
            this.gWR.lt(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gWR != null) {
            this.gWR.mx(z);
        }
        if (this.gWU != null) {
            this.gWU.b(this.gWV);
            this.gWU.a(this.gWV);
            this.gWV.bNg();
        }
    }

    public void reload() {
        if (this.gWO != null && this.gWW != null) {
            if (this.gWT && this.gWO.getFirstVisiblePosition() != 0) {
                this.gWT = false;
                return;
            }
            this.gWO.setSelection(0);
            if (!this.gWW.isRefreshing()) {
                this.gWW.setRefreshing(true);
            }
            if (this.gWV != null) {
                this.gWV.bNg();
            }
        }
    }

    public void onDestroy() {
        if (this.gWU != null) {
            this.gWU.b(this.gWV);
        }
        this.gWO.removeOnScrollListener(this.mOnScrollListener);
        this.gWR.a((c.a) null);
        this.gWN.setListPullRefreshListener(null);
        this.gWN.a((g.d) null);
        this.gWO.setOnSrollToBottomListener(null);
        this.gWN.a((g.b) null);
        this.gWN.release();
        this.gWO.setRecyclerListener(null);
    }

    public void bNe() {
        if (this.gWP != null) {
            this.gWP.notifyDataSetChanged();
        }
    }

    public void bNf() {
        if (this.gWR != null) {
            this.gWR.lt(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcf() {
        if (this.gWR != null) {
            this.gWR.bcf();
        }
    }

    public void sm() {
        if (this.gWP != null) {
            List<m> dataList = this.gWP.getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cRg != 0 && kVar.cRf != null) {
                            int[] imageWidthAndHeight = kVar.cRf.getImageWidthAndHeight();
                            kVar.cRg = imageWidthAndHeight[0];
                            kVar.cRh = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.gWP != null) {
                            ConcernPageView.this.gWP.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
