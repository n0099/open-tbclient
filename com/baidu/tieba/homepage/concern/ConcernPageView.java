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
    private PbListView eli;
    private int enA;
    private g etW;
    private com.baidu.tieba.homepage.personalize.bigday.a gWL;
    private BdTypeRecyclerView gWM;
    private com.baidu.tieba.homepage.concern.a gWN;
    private a gWO;
    private c gWP;
    private ConcernNotLoginLayout gWQ;
    private boolean gWR;
    private ScrollFragmentTabHost gWS;
    ScrollFragmentTabHost.a gWT;
    private BigdaySwipeRefreshLayout gWU;
    private c.a gWV;
    private View.OnClickListener gWW;
    private CustomMessageListener gWX;
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
        this.gWS = scrollFragmentTabHost;
        if (this.gWS != null) {
            this.gWS.b(this.gWT);
            this.gWS.a(this.gWT);
        }
    }

    public void completePullRefresh() {
        if (this.gWU != null) {
            this.gWU.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gWN != null) {
            this.gWN.setPageUniqueId(bdUniqueId);
        }
        if (this.gWP != null) {
            this.gWP.q(bdUniqueId);
        }
        if (this.gWL != null) {
            this.gWL.setTag(bdUniqueId);
        }
        if (this.gWX != null) {
            this.gWX.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gWX);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.gWR = false;
        this.mSkinType = 3;
        this.enA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.enA != i && ConcernPageView.this.gWS != null) {
                    ConcernPageView.this.enA = i;
                    if (ConcernPageView.this.enA == 1) {
                        ConcernPageView.this.gWS.bcK();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gWS.bcL();
                    } else {
                        ConcernPageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.gWT = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNe() {
                if (ConcernPageView.this.gWS != null) {
                    ConcernPageView.this.enA = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gWM)) {
                        ConcernPageView.this.gWS.bcL();
                    } else {
                        ConcernPageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.gWV = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNf() {
                ConcernPageView.this.bcv();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gWM.setSelection(0);
                if (ConcernPageView.this.gWM.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNb();
                } else {
                    ConcernPageView.this.eM(true);
                }
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cc(String str) {
                ConcernPageView.this.bcv();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNa();
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.Cd(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gWM.setVisibility(8);
                    ConcernPageView.this.kN(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcv();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gWP.bNi()) {
                    ConcernPageView.this.bNb();
                } else {
                    ConcernPageView.this.bNa();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNg() {
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcv();
                ConcernPageView.this.gWM.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gWW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bcd();
            }
        };
        this.gWX = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gWR = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWR = false;
        this.mSkinType = 3;
        this.enA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.enA != i && ConcernPageView.this.gWS != null) {
                    ConcernPageView.this.enA = i;
                    if (ConcernPageView.this.enA == 1) {
                        ConcernPageView.this.gWS.bcK();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gWS.bcL();
                    } else {
                        ConcernPageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.gWT = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNe() {
                if (ConcernPageView.this.gWS != null) {
                    ConcernPageView.this.enA = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gWM)) {
                        ConcernPageView.this.gWS.bcL();
                    } else {
                        ConcernPageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.gWV = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNf() {
                ConcernPageView.this.bcv();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gWM.setSelection(0);
                if (ConcernPageView.this.gWM.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNb();
                } else {
                    ConcernPageView.this.eM(true);
                }
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cc(String str) {
                ConcernPageView.this.bcv();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNa();
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.Cd(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gWM.setVisibility(8);
                    ConcernPageView.this.kN(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcv();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gWP.bNi()) {
                    ConcernPageView.this.bNb();
                } else {
                    ConcernPageView.this.bNa();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNg() {
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcv();
                ConcernPageView.this.gWM.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gWW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bcd();
            }
        };
        this.gWX = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gWR = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gWR = false;
        this.mSkinType = 3;
        this.enA = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.enA != i2 && ConcernPageView.this.gWS != null) {
                    ConcernPageView.this.enA = i2;
                    if (ConcernPageView.this.enA == 1) {
                        ConcernPageView.this.gWS.bcK();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gWS.bcL();
                    } else {
                        ConcernPageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.gWT = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNe() {
                if (ConcernPageView.this.gWS != null) {
                    ConcernPageView.this.enA = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gWM)) {
                        ConcernPageView.this.gWS.bcL();
                    } else {
                        ConcernPageView.this.gWS.bcK();
                    }
                }
            }
        };
        this.gWV = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNf() {
                ConcernPageView.this.bcv();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gWM.setSelection(0);
                if (ConcernPageView.this.gWM.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNb();
                } else {
                    ConcernPageView.this.eM(true);
                }
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cc(String str) {
                ConcernPageView.this.bcv();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNa();
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.Cd(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.gWM.setVisibility(8);
                    ConcernPageView.this.kN(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcv();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gWP.bNi()) {
                    ConcernPageView.this.bNb();
                } else {
                    ConcernPageView.this.bNa();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNg() {
                if (ConcernPageView.this.gWO != null) {
                    ConcernPageView.this.gWO.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcv();
                ConcernPageView.this.gWM.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gWW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bcd();
            }
        };
        this.gWX = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gWR = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gWM = new BdTypeRecyclerView(context);
        this.gWM.setLayoutManager(new LinearLayoutManager(context));
        this.gWM.setFadingEdgeLength(0);
        this.gWM.setOverScrollMode(2);
        this.gWU = new BigdaySwipeRefreshLayout(context);
        this.gWU.addView(this.gWM);
        this.eli = new PbListView(context);
        this.eli.createView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setLineGone();
        this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.eli.setOnClickListener(this.gWW);
        this.gWM.setNextPage(this.eli);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.gWU);
        this.gWL = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.gWL.setEnable(true);
        this.gWU.setProgressView(this.gWL);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.gWU.setCustomDistances(i, i, i * 2);
        this.gWN = new com.baidu.tieba.homepage.concern.a(context, this.gWM);
        this.gWP = new c(this.pageContext, this.gWM, this.gWN, this.gWU);
        this.gWU.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void initListeners() {
        this.gWP.a(this.gWV);
        this.gWL.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aXD().wN("page_concern");
                    ConcernPageView.this.gWP.update();
                }
            }
        });
        this.gWM.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bcd();
            }
        });
        this.gWM.removeOnScrollListener(this.mOnScrollListener);
        this.gWM.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.gWO = aVar;
    }

    public void bMX() {
        if (!TbadkCoreApplication.isLogin()) {
            bMZ();
        } else if (this.gWP != null) {
            this.gWP.update();
            eM(true);
        }
    }

    public void bMY() {
        if (!TbadkCoreApplication.isLogin()) {
            bMZ();
        } else if (this.gWP != null) {
            this.gWP.bNh();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.gWP != null) {
            this.gWP.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gWQ != null) {
                this.gWQ.onChangeSkinType(i);
            }
            if (this.etW != null) {
                this.etW.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gWL != null) {
                this.gWL.changeSkin(i);
            }
            if (this.eli != null) {
                this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
                this.eli.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.gWN.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.gWU, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gWM, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bNc();
    }

    public void aE(String str, int i) {
        this.gWP.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.gWP.a(z, dataRes, 0, null);
    }

    public void kN(boolean z) {
        if (!bzj()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.gWP != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.gWP.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcv() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this);
            this.etW = null;
        }
    }

    private boolean bzj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bMZ() {
        if (this.gWQ == null) {
            this.gWQ = new ConcernNotLoginLayout(getContext());
            this.gWQ.onChangeSkinType(this.mSkinType);
        }
        if (this.gWQ.getParent() == null) {
            this.gWU.setVisibility(8);
            this.gWQ.setVisibility(0);
            addView(this.gWQ);
        }
    }

    public boolean bzi() {
        if (this.etW != null) {
            return this.etW.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(boolean z) {
        if (!bzi()) {
            if (this.etW == null) {
                this.etW = new com.baidu.tbadk.k.g(getContext());
                this.etW.aN(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.etW.aPR();
                this.etW.setWrapStyle(true);
            }
            this.etW.onChangeSkinType();
            this.etW.attachView(this, z);
        }
    }

    public void bNa() {
        this.gWU.setVisibility(0);
        this.gWM.setVisibility(0);
        if (this.gWP.hasMore()) {
            this.eli.startLoadData();
        } else {
            this.eli.endLoadDataWithNoMore();
        }
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void bNb() {
        this.gWU.setVisibility(0);
        this.gWM.setVisibility(0);
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.setHeight(0);
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
        if (this.gWP != null) {
            this.gWP.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.gWP != null) {
            this.gWP.lt(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gWP != null) {
            this.gWP.mx(z);
        }
        if (this.gWS != null) {
            this.gWS.b(this.gWT);
            this.gWS.a(this.gWT);
            this.gWT.bNe();
        }
    }

    public void reload() {
        if (this.gWM != null && this.gWU != null) {
            if (this.gWR && this.gWM.getFirstVisiblePosition() != 0) {
                this.gWR = false;
                return;
            }
            this.gWM.setSelection(0);
            if (!this.gWU.isRefreshing()) {
                this.gWU.setRefreshing(true);
            }
            if (this.gWT != null) {
                this.gWT.bNe();
            }
        }
    }

    public void onDestroy() {
        if (this.gWS != null) {
            this.gWS.b(this.gWT);
        }
        this.gWM.removeOnScrollListener(this.mOnScrollListener);
        this.gWP.a((c.a) null);
        this.gWL.setListPullRefreshListener(null);
        this.gWL.a((g.d) null);
        this.gWM.setOnSrollToBottomListener(null);
        this.gWL.a((g.b) null);
        this.gWL.release();
        this.gWM.setRecyclerListener(null);
    }

    public void bNc() {
        if (this.gWN != null) {
            this.gWN.notifyDataSetChanged();
        }
    }

    public void bNd() {
        if (this.gWP != null) {
            this.gWP.lt(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcd() {
        if (this.gWP != null) {
            this.gWP.bcd();
        }
    }

    public void sm() {
        if (this.gWN != null) {
            List<m> dataList = this.gWN.getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cRf != 0 && kVar.cRe != null) {
                            int[] imageWidthAndHeight = kVar.cRe.getImageWidthAndHeight();
                            kVar.cRf = imageWidthAndHeight[0];
                            kVar.cRg = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.gWN != null) {
                            ConcernPageView.this.gWN.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
