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
    private PbListView ePm;
    private int eRD;
    private g eYb;
    private com.baidu.tieba.homepage.personalize.bigday.a hHX;
    private BdTypeRecyclerView hHY;
    private com.baidu.tieba.homepage.concern.a hHZ;
    private a hIa;
    private c hIb;
    private ConcernNotLoginLayout hIc;
    private boolean hId;
    private ScrollFragmentTabHost hIe;
    ScrollFragmentTabHost.a hIf;
    private BigdaySwipeRefreshLayout hIg;
    private c.a hIh;
    private View.OnClickListener hIi;
    private CustomMessageListener hIj;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes9.dex */
    public interface a {
        void DM(String str);

        void T(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hIe = scrollFragmentTabHost;
        if (this.hIe != null) {
            this.hIe.b(this.hIf);
            this.hIe.a(this.hIf);
        }
    }

    public void completePullRefresh() {
        if (this.hIg != null) {
            this.hIg.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hHZ != null) {
            this.hHZ.setPageUniqueId(bdUniqueId);
        }
        if (this.hIb != null) {
            this.hIb.q(bdUniqueId);
        }
        if (this.hHX != null) {
            this.hHX.setTag(bdUniqueId);
        }
        if (this.hIj != null) {
            this.hIj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hIj);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.hId = false;
        this.mSkinType = 3;
        this.eRD = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.eRD != i && ConcernPageView.this.hIe != null) {
                    ConcernPageView.this.eRD = i;
                    if (ConcernPageView.this.eRD == 1) {
                        ConcernPageView.this.hIe.blI();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hIe.blJ();
                    } else {
                        ConcernPageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hIf = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bXW() {
                if (ConcernPageView.this.hIe != null) {
                    ConcernPageView.this.eRD = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hHY)) {
                        ConcernPageView.this.hIe.blJ();
                    } else {
                        ConcernPageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hIh = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXX() {
                ConcernPageView.this.blt();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hHY.setSelection(0);
                if (ConcernPageView.this.hHY.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bXT();
                } else {
                    ConcernPageView.this.fK(true);
                }
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void DL(String str) {
                ConcernPageView.this.blt();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bXS();
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.DM(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.hHY.setVisibility(8);
                    ConcernPageView.this.lV(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blt();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hIb.bYa()) {
                    ConcernPageView.this.bXT();
                } else {
                    ConcernPageView.this.bXS();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXY() {
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blt();
                ConcernPageView.this.hHY.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hIi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.blb();
            }
        };
        this.hIj = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hId = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hId = false;
        this.mSkinType = 3;
        this.eRD = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.eRD != i && ConcernPageView.this.hIe != null) {
                    ConcernPageView.this.eRD = i;
                    if (ConcernPageView.this.eRD == 1) {
                        ConcernPageView.this.hIe.blI();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hIe.blJ();
                    } else {
                        ConcernPageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hIf = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bXW() {
                if (ConcernPageView.this.hIe != null) {
                    ConcernPageView.this.eRD = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hHY)) {
                        ConcernPageView.this.hIe.blJ();
                    } else {
                        ConcernPageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hIh = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXX() {
                ConcernPageView.this.blt();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hHY.setSelection(0);
                if (ConcernPageView.this.hHY.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bXT();
                } else {
                    ConcernPageView.this.fK(true);
                }
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void DL(String str) {
                ConcernPageView.this.blt();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bXS();
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.DM(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.hHY.setVisibility(8);
                    ConcernPageView.this.lV(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blt();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hIb.bYa()) {
                    ConcernPageView.this.bXT();
                } else {
                    ConcernPageView.this.bXS();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXY() {
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blt();
                ConcernPageView.this.hHY.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hIi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.blb();
            }
        };
        this.hIj = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hId = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hId = false;
        this.mSkinType = 3;
        this.eRD = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.eRD != i2 && ConcernPageView.this.hIe != null) {
                    ConcernPageView.this.eRD = i2;
                    if (ConcernPageView.this.eRD == 1) {
                        ConcernPageView.this.hIe.blI();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.hIe.blJ();
                    } else {
                        ConcernPageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hIf = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bXW() {
                if (ConcernPageView.this.hIe != null) {
                    ConcernPageView.this.eRD = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.hHY)) {
                        ConcernPageView.this.hIe.blJ();
                    } else {
                        ConcernPageView.this.hIe.blI();
                    }
                }
            }
        };
        this.hIh = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXX() {
                ConcernPageView.this.blt();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hHY.setSelection(0);
                if (ConcernPageView.this.hHY.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bXT();
                } else {
                    ConcernPageView.this.fK(true);
                }
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void DL(String str) {
                ConcernPageView.this.blt();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bXS();
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.DM(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.hHY.setVisibility(8);
                    ConcernPageView.this.lV(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blt();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.hIb.bYa()) {
                    ConcernPageView.this.bXT();
                } else {
                    ConcernPageView.this.bXS();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bXY() {
                if (ConcernPageView.this.hIa != null) {
                    ConcernPageView.this.hIa.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.blt();
                ConcernPageView.this.hHY.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.hIi = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.blb();
            }
        };
        this.hIj = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.hId = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hHY = new BdTypeRecyclerView(context);
        this.hHY.setLayoutManager(new LinearLayoutManager(context));
        this.hHY.setFadingEdgeLength(0);
        this.hHY.setOverScrollMode(2);
        this.hIg = new BigdaySwipeRefreshLayout(context);
        this.hIg.addView(this.hHY);
        this.ePm = new PbListView(context);
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setLineGone();
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.setOnClickListener(this.hIi);
        this.hHY.setNextPage(this.ePm);
        e<?> T = i.T(context);
        if (T instanceof TbPageContext) {
            this.pageContext = (TbPageContext) T;
        }
        addView(this.hIg);
        this.hHX = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.hHX.setEnable(true);
        this.hIg.setProgressView(this.hHX);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.hIg.setCustomDistances(i, i, i * 2);
        this.hHZ = new com.baidu.tieba.homepage.concern.a(context, this.hHY);
        this.hIb = new c(this.pageContext, this.hHY, this.hHZ, this.hIg);
        this.hIg.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bqK() {
        this.hIb.a(this.hIh);
        this.hHX.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.bfP().yb("page_concern");
                    ConcernPageView.this.hIb.update();
                }
            }
        });
        this.hHY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.blb();
            }
        });
        this.hHY.removeOnScrollListener(this.mOnScrollListener);
        this.hHY.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.hIa = aVar;
    }

    public void bXP() {
        if (!TbadkCoreApplication.isLogin()) {
            bXR();
        } else if (this.hIb != null) {
            this.hIb.update();
            fK(true);
        }
    }

    public void bXQ() {
        if (!TbadkCoreApplication.isLogin()) {
            bXR();
        } else if (this.hIb != null) {
            this.hIb.bXZ();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.hIb != null) {
            this.hIb.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.hIc != null) {
                this.hIc.onChangeSkinType(i);
            }
            if (this.eYb != null) {
                this.eYb.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.hHX != null) {
                this.hHX.changeSkin(i);
            }
            if (this.ePm != null) {
                this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
                this.ePm.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.hHZ.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.hIg, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.hHY, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bXU();
    }

    public void aO(String str, int i) {
        this.hIb.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.hIb.a(z, dataRes, 0, null);
    }

    public void lV(boolean z) {
        if (!bJu()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.hIb != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.hIb.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this);
            this.eYb = null;
        }
    }

    private boolean bJu() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bXR() {
        if (this.hIc == null) {
            this.hIc = new ConcernNotLoginLayout(getContext());
            this.hIc.onChangeSkinType(this.mSkinType);
        }
        if (this.hIc.getParent() == null) {
            this.hIg.setVisibility(8);
            this.hIc.setVisibility(0);
            addView(this.hIc);
        }
    }

    public boolean bJt() {
        if (this.eYb != null) {
            return this.eYb.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(boolean z) {
        if (!bJt()) {
            if (this.eYb == null) {
                this.eYb = new com.baidu.tbadk.k.g(getContext());
                this.eYb.aZ(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.eYb.aYp();
                this.eYb.setWrapStyle(true);
            }
            this.eYb.onChangeSkinType();
            this.eYb.attachView(this, z);
        }
    }

    public void bXS() {
        this.hIg.setVisibility(0);
        this.hHY.setVisibility(0);
        if (this.hIb.hasMore()) {
            this.ePm.startLoadData();
        } else {
            this.ePm.endLoadDataWithNoMore();
        }
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void bXT() {
        this.hIg.setVisibility(0);
        this.hHY.setVisibility(0);
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.setHeight(0);
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
        if (this.hIb != null) {
            this.hIb.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.hIb != null) {
            this.hIb.mC(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.hIb != null) {
            this.hIb.nH(z);
        }
        if (this.hIe != null) {
            this.hIe.b(this.hIf);
            this.hIe.a(this.hIf);
            this.hIf.bXW();
        }
    }

    public void reload() {
        if (this.hHY != null && this.hIg != null) {
            if (this.hId && this.hHY.getFirstVisiblePosition() != 0) {
                this.hId = false;
                return;
            }
            this.hHY.setSelection(0);
            if (!this.hIg.isRefreshing()) {
                this.hIg.setRefreshing(true);
            }
            if (this.hIf != null) {
                this.hIf.bXW();
            }
        }
    }

    public void onDestroy() {
        if (this.hIe != null) {
            this.hIe.b(this.hIf);
        }
        this.hHY.removeOnScrollListener(this.mOnScrollListener);
        this.hIb.a((c.a) null);
        this.hHX.setListPullRefreshListener(null);
        this.hHX.a((g.d) null);
        this.hHY.setOnSrollToBottomListener(null);
        this.hHX.a((g.b) null);
        this.hHX.release();
        this.hHY.setRecyclerListener(null);
    }

    public void bXU() {
        if (this.hHZ != null) {
            this.hHZ.notifyDataSetChanged();
        }
    }

    public void bXV() {
        if (this.hIb != null) {
            this.hIb.mC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blb() {
        if (this.hIb != null) {
            this.hIb.blb();
        }
    }

    public void wK() {
        if (this.hHZ != null) {
            List<m> dataList = this.hHZ.getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.dqB != 0 && kVar.dqA != null) {
                            int[] imageWidthAndHeight = kVar.dqA.getImageWidthAndHeight();
                            kVar.dqB = imageWidthAndHeight[0];
                            kVar.dqC = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.hHZ != null) {
                            ConcernPageView.this.hHZ.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
