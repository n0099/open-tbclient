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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.aa;
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
    private PbListView fcj;
    private int feB;
    private g flb;
    private com.baidu.tieba.homepage.personalize.bigday.a hXA;
    private BdTypeRecyclerView hXB;
    private com.baidu.tieba.homepage.concern.a hXC;
    private a hXD;
    private c hXE;
    private ConcernNotLoginLayout hXF;
    private boolean hXG;
    private ScrollFragmentTabHost hXH;
    ScrollFragmentTabHost.a hXI;
    private BigdaySwipeRefreshLayout hXJ;
    private c.a hXK;
    private View.OnClickListener hXL;
    private CustomMessageListener hXM;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes9.dex */
    public interface a {
        void Fy(String str);

        void W(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hXH = scrollFragmentTabHost;
        if (this.hXH != null) {
            this.hXH.b(this.hXI);
            this.hXH.a(this.hXI);
        }
    }

    public void completePullRefresh() {
        if (this.hXJ != null) {
            this.hXJ.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hXC != null) {
            this.hXC.setPageUniqueId(bdUniqueId);
        }
        if (this.hXE != null) {
            this.hXE.s(bdUniqueId);
        }
        if (this.hXA != null) {
            this.hXA.setTag(bdUniqueId);
        }
        if (this.hXM != null) {
            this.hXM.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hXM);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.hXG = false;
        this.mSkinType = 3;
        this.feB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.feB != i && ConcernPageView.this.hXH != null) {
                    ConcernPageView.this.feB = i;
                    if (ConcernPageView.this.feB == 1) {
                        ConcernPageView.this.hXH.brg();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hXH.brh();
                    } else {
                        ConcernPageView.this.hXH.brg();
                    }
                }
            }
        };
        this.hXI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ceB() {
                if (ConcernPageView.this.hXH != null) {
                    ConcernPageView.this.feB = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hXB)) {
                        ConcernPageView.this.hXH.brh();
                    } else {
                        ConcernPageView.this.hXH.brg();
                    }
                }
            }
        };
        this.hXK = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ceC() {
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hXB.setSelection(0);
                if (ConcernPageView.this.hXB.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cey();
                } else {
                    ConcernPageView.this.fV(true);
                }
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Fx(String str) {
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cex();
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.Fy(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.W(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.hXB.setVisibility(8);
                    ConcernPageView.this.mq(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void V(boolean z, boolean z2) {
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.W(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hXE.ceF()) {
                    ConcernPageView.this.cey();
                } else {
                    ConcernPageView.this.cex();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ceD() {
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.W(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hXB.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hXL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bqx();
            }
        };
        this.hXM = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hXG = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hXG = false;
        this.mSkinType = 3;
        this.feB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.feB != i && ConcernPageView.this.hXH != null) {
                    ConcernPageView.this.feB = i;
                    if (ConcernPageView.this.feB == 1) {
                        ConcernPageView.this.hXH.brg();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hXH.brh();
                    } else {
                        ConcernPageView.this.hXH.brg();
                    }
                }
            }
        };
        this.hXI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ceB() {
                if (ConcernPageView.this.hXH != null) {
                    ConcernPageView.this.feB = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hXB)) {
                        ConcernPageView.this.hXH.brh();
                    } else {
                        ConcernPageView.this.hXH.brg();
                    }
                }
            }
        };
        this.hXK = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ceC() {
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hXB.setSelection(0);
                if (ConcernPageView.this.hXB.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cey();
                } else {
                    ConcernPageView.this.fV(true);
                }
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Fx(String str) {
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cex();
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.Fy(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.W(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.hXB.setVisibility(8);
                    ConcernPageView.this.mq(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void V(boolean z, boolean z2) {
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.W(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hXE.ceF()) {
                    ConcernPageView.this.cey();
                } else {
                    ConcernPageView.this.cex();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ceD() {
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.W(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hXB.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hXL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bqx();
            }
        };
        this.hXM = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hXG = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hXG = false;
        this.mSkinType = 3;
        this.feB = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.feB != i2 && ConcernPageView.this.hXH != null) {
                    ConcernPageView.this.feB = i2;
                    if (ConcernPageView.this.feB == 1) {
                        ConcernPageView.this.hXH.brg();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hXH.brh();
                    } else {
                        ConcernPageView.this.hXH.brg();
                    }
                }
            }
        };
        this.hXI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ceB() {
                if (ConcernPageView.this.hXH != null) {
                    ConcernPageView.this.feB = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hXB)) {
                        ConcernPageView.this.hXH.brh();
                    } else {
                        ConcernPageView.this.hXH.brg();
                    }
                }
            }
        };
        this.hXK = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ceC() {
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hXB.setSelection(0);
                if (ConcernPageView.this.hXB.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.cey();
                } else {
                    ConcernPageView.this.fV(true);
                }
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Fx(String str) {
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.cex();
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.Fy(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.W(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.hXB.setVisibility(8);
                    ConcernPageView.this.mq(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void V(boolean z, boolean z2) {
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.W(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hXE.ceF()) {
                    ConcernPageView.this.cey();
                } else {
                    ConcernPageView.this.cex();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void ceD() {
                if (ConcernPageView.this.hXD != null) {
                    ConcernPageView.this.hXD.W(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bqQ();
                ConcernPageView.this.hXB.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hXL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bqx();
            }
        };
        this.hXM = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hXG = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hXB = new BdTypeRecyclerView(context);
        this.hXB.setLayoutManager(new LinearLayoutManager(context));
        this.hXB.setFadingEdgeLength(0);
        this.hXB.setOverScrollMode(2);
        this.hXJ = new BigdaySwipeRefreshLayout(context);
        this.hXJ.addView(this.hXB);
        this.fcj = new PbListView(context);
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setLineGone();
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fcj.setOnClickListener(this.hXL);
        this.hXB.setNextPage(this.fcj);
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        addView(this.hXJ);
        this.hXA = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.hXA.setEnable(true);
        this.hXJ.setProgressView(this.hXA);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.hXJ.setCustomDistances(i, i, i * 2);
        this.hXC = new com.baidu.tieba.homepage.concern.a(context, this.hXB);
        this.hXE = new c(this.pageContext, this.hXB, this.hXC, this.hXJ);
        this.hXJ.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bwC() {
        this.hXE.a(this.hXK);
        this.hXA.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.bmb().zK("page_concern");
                    ConcernPageView.this.hXE.update();
                }
            }
        });
        this.hXB.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bqx();
            }
        });
        this.hXB.removeOnScrollListener(this.mOnScrollListener);
        this.hXB.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.hXD = aVar;
    }

    public void ceu() {
        if (!TbadkCoreApplication.isLogin()) {
            cew();
        } else if (this.hXE != null) {
            this.hXE.update();
            fV(true);
        }
    }

    public void cev() {
        if (!TbadkCoreApplication.isLogin()) {
            cew();
        } else if (this.hXE != null) {
            this.hXE.ceE();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.hXE != null) {
            this.hXE.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hXF != null) {
                this.hXF.onChangeSkinType(i);
            }
            if (this.flb != null) {
                this.flb.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.hXA != null) {
                this.hXA.changeSkin(i);
            }
            if (this.fcj != null) {
                this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
                this.fcj.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.hXC.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.hXJ, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.hXB, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        cez();
    }

    public void aP(String str, int i) {
        this.hXE.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.hXE.a(z, dataRes, 0, null);
    }

    public void mq(boolean z) {
        if (!bPO()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.hXE != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.hXE.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqQ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this);
            this.flb = null;
        }
    }

    private boolean bPO() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void cew() {
        if (this.hXF == null) {
            this.hXF = new ConcernNotLoginLayout(getContext());
            this.hXF.onChangeSkinType(this.mSkinType);
        }
        if (this.hXF.getParent() == null) {
            this.hXJ.setVisibility(8);
            this.hXF.setVisibility(0);
            addView(this.hXF);
        }
    }

    public boolean bPN() {
        if (this.flb != null) {
            return this.flb.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(boolean z) {
        if (!bPN()) {
            if (this.flb == null) {
                this.flb = new g(getContext());
                this.flb.ba(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.flb.bex();
                this.flb.setWrapStyle(true);
            }
            this.flb.onChangeSkinType();
            this.flb.attachView(this, z);
        }
    }

    public void cex() {
        this.hXJ.setVisibility(0);
        this.hXB.setVisibility(0);
        if (this.hXE.hasMore()) {
            this.fcj.startLoadData();
        } else {
            this.fcj.endLoadDataWithNoMore();
        }
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void cey() {
        this.hXJ.setVisibility(0);
        this.hXB.setVisibility(0);
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dj(null, getContext().getString(R.string.concern_no_data_title)), null);
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
        if (this.hXE != null) {
            this.hXE.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.hXE != null) {
            this.hXE.mX(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.hXE != null) {
            this.hXE.oc(z);
        }
        if (this.hXH != null) {
            this.hXH.b(this.hXI);
            this.hXH.a(this.hXI);
            this.hXI.ceB();
        }
    }

    public void reload() {
        if (this.hXB != null && this.hXJ != null) {
            if (this.hXG && this.hXB.getFirstVisiblePosition() != 0) {
                this.hXG = false;
                return;
            }
            this.hXB.setSelection(0);
            if (!this.hXJ.isRefreshing()) {
                this.hXJ.setRefreshing(true);
            }
            if (this.hXI != null) {
                this.hXI.ceB();
            }
        }
    }

    public void onDestroy() {
        if (this.hXH != null) {
            this.hXH.b(this.hXI);
        }
        this.hXB.removeOnScrollListener(this.mOnScrollListener);
        this.hXE.a((c.a) null);
        this.hXA.setListPullRefreshListener(null);
        this.hXA.a((f.d) null);
        this.hXB.setOnSrollToBottomListener(null);
        this.hXA.a((f.b) null);
        this.hXA.release();
        this.hXB.setRecyclerListener(null);
    }

    public void cez() {
        if (this.hXC != null) {
            this.hXC.notifyDataSetChanged();
        }
    }

    public void ceA() {
        if (this.hXE != null) {
            this.hXE.mX(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqx() {
        if (this.hXE != null) {
            this.hXE.bqx();
        }
    }

    public void ya() {
        if (this.hXC != null) {
            List<o> dataList = this.hXC.getDataList();
            if (!v.isEmpty(dataList)) {
                for (o oVar : dataList) {
                    if (oVar instanceof k) {
                        k kVar = (k) oVar;
                        if (kVar.dEB != 0 && kVar.dEA != null) {
                            int[] imageWidthAndHeight = kVar.dEA.getImageWidthAndHeight();
                            kVar.dEB = imageWidthAndHeight[0];
                            kVar.dEC = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.hXC != null) {
                            ConcernPageView.this.hXC.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
