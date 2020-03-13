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
    private PbListView elw;
    private int enO;
    private g euk;
    private com.baidu.tieba.homepage.personalize.bigday.a gWZ;
    private BdTypeRecyclerView gXa;
    private com.baidu.tieba.homepage.concern.a gXb;
    private a gXc;
    private c gXd;
    private ConcernNotLoginLayout gXe;
    private boolean gXf;
    private ScrollFragmentTabHost gXg;
    ScrollFragmentTabHost.a gXh;
    private BigdaySwipeRefreshLayout gXi;
    private c.a gXj;
    private View.OnClickListener gXk;
    private CustomMessageListener gXl;
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
        this.gXg = scrollFragmentTabHost;
        if (this.gXg != null) {
            this.gXg.b(this.gXh);
            this.gXg.a(this.gXh);
        }
    }

    public void completePullRefresh() {
        if (this.gXi != null) {
            this.gXi.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gXb != null) {
            this.gXb.setPageUniqueId(bdUniqueId);
        }
        if (this.gXd != null) {
            this.gXd.q(bdUniqueId);
        }
        if (this.gWZ != null) {
            this.gWZ.setTag(bdUniqueId);
        }
        if (this.gXl != null) {
            this.gXl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.gXl);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.gXf = false;
        this.mSkinType = 3;
        this.enO = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.enO != i && ConcernPageView.this.gXg != null) {
                    ConcernPageView.this.enO = i;
                    if (ConcernPageView.this.enO == 1) {
                        ConcernPageView.this.gXg.bcN();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gXg.bcO();
                    } else {
                        ConcernPageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.gXh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNh() {
                if (ConcernPageView.this.gXg != null) {
                    ConcernPageView.this.enO = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gXa)) {
                        ConcernPageView.this.gXg.bcO();
                    } else {
                        ConcernPageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.gXj = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNi() {
                ConcernPageView.this.bcy();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gXa.setSelection(0);
                if (ConcernPageView.this.gXa.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNe();
                } else {
                    ConcernPageView.this.eM(true);
                }
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cd(String str) {
                ConcernPageView.this.bcy();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNd();
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.Ce(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gXa.setVisibility(8);
                    ConcernPageView.this.kN(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcy();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gXd.bNl()) {
                    ConcernPageView.this.bNe();
                } else {
                    ConcernPageView.this.bNd();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNj() {
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcy();
                ConcernPageView.this.gXa.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gXk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bcg();
            }
        };
        this.gXl = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gXf = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXf = false;
        this.mSkinType = 3;
        this.enO = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.enO != i && ConcernPageView.this.gXg != null) {
                    ConcernPageView.this.enO = i;
                    if (ConcernPageView.this.enO == 1) {
                        ConcernPageView.this.gXg.bcN();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gXg.bcO();
                    } else {
                        ConcernPageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.gXh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNh() {
                if (ConcernPageView.this.gXg != null) {
                    ConcernPageView.this.enO = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gXa)) {
                        ConcernPageView.this.gXg.bcO();
                    } else {
                        ConcernPageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.gXj = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNi() {
                ConcernPageView.this.bcy();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gXa.setSelection(0);
                if (ConcernPageView.this.gXa.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNe();
                } else {
                    ConcernPageView.this.eM(true);
                }
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cd(String str) {
                ConcernPageView.this.bcy();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNd();
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.Ce(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.gXa.setVisibility(8);
                    ConcernPageView.this.kN(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcy();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gXd.bNl()) {
                    ConcernPageView.this.bNe();
                } else {
                    ConcernPageView.this.bNd();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNj() {
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcy();
                ConcernPageView.this.gXa.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gXk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bcg();
            }
        };
        this.gXl = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gXf = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gXf = false;
        this.mSkinType = 3;
        this.enO = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.enO != i2 && ConcernPageView.this.gXg != null) {
                    ConcernPageView.this.enO = i2;
                    if (ConcernPageView.this.enO == 1) {
                        ConcernPageView.this.gXg.bcN();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.gXg.bcO();
                    } else {
                        ConcernPageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.gXh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNh() {
                if (ConcernPageView.this.gXg != null) {
                    ConcernPageView.this.enO = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.gXa)) {
                        ConcernPageView.this.gXg.bcO();
                    } else {
                        ConcernPageView.this.gXg.bcN();
                    }
                }
            }
        };
        this.gXj = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNi() {
                ConcernPageView.this.bcy();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.gXa.setSelection(0);
                if (ConcernPageView.this.gXa.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.bNe();
                } else {
                    ConcernPageView.this.eM(true);
                }
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void Cd(String str) {
                ConcernPageView.this.bcy();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bNd();
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.Ce(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.T(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.gXa.setVisibility(8);
                    ConcernPageView.this.kN(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void S(boolean z, boolean z2) {
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.T(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcy();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.gXd.bNl()) {
                    ConcernPageView.this.bNe();
                } else {
                    ConcernPageView.this.bNd();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void bNj() {
                if (ConcernPageView.this.gXc != null) {
                    ConcernPageView.this.gXc.T(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bcy();
                ConcernPageView.this.gXa.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.gXk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bcg();
            }
        };
        this.gXl = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.gXf = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gXa = new BdTypeRecyclerView(context);
        this.gXa.setLayoutManager(new LinearLayoutManager(context));
        this.gXa.setFadingEdgeLength(0);
        this.gXa.setOverScrollMode(2);
        this.gXi = new BigdaySwipeRefreshLayout(context);
        this.gXi.addView(this.gXa);
        this.elw = new PbListView(context);
        this.elw.createView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setLineGone();
        this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elw.setOnClickListener(this.gXk);
        this.gXa.setNextPage(this.elw);
        e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        addView(this.gXi);
        this.gWZ = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.gWZ.setEnable(true);
        this.gXi.setProgressView(this.gWZ);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.gXi.setCustomDistances(i, i, i * 2);
        this.gXb = new com.baidu.tieba.homepage.concern.a(context, this.gXa);
        this.gXd = new c(this.pageContext, this.gXa, this.gXb, this.gXi);
        this.gXi.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void initListeners() {
        this.gXd.a(this.gXj);
        this.gWZ.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.aXG().wO("page_concern");
                    ConcernPageView.this.gXd.update();
                }
            }
        });
        this.gXa.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bcg();
            }
        });
        this.gXa.removeOnScrollListener(this.mOnScrollListener);
        this.gXa.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.gXc = aVar;
    }

    public void bNa() {
        if (!TbadkCoreApplication.isLogin()) {
            bNc();
        } else if (this.gXd != null) {
            this.gXd.update();
            eM(true);
        }
    }

    public void bNb() {
        if (!TbadkCoreApplication.isLogin()) {
            bNc();
        } else if (this.gXd != null) {
            this.gXd.bNk();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(z zVar) {
        if (this.gXd != null) {
            this.gXd.setRecommendFrsNavigationAnimDispatcher(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gXe != null) {
                this.gXe.onChangeSkinType(i);
            }
            if (this.euk != null) {
                this.euk.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.gWZ != null) {
                this.gWZ.changeSkin(i);
            }
            if (this.elw != null) {
                this.elw.setTextColor(am.getColor(R.color.cp_cont_d));
                this.elw.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.gXb.onChangeSkinType(i);
            am.setBackgroundColor(this, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.gXi, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gXa, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        bNf();
    }

    public void aE(String str, int i) {
        this.gXd.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.gXd.a(z, dataRes, 0, null);
    }

    public void kN(boolean z) {
        if (!bzm()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.gXd != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.gXd.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.euk != null) {
            this.euk.dettachView(this);
            this.euk = null;
        }
    }

    private boolean bzm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void bNc() {
        if (this.gXe == null) {
            this.gXe = new ConcernNotLoginLayout(getContext());
            this.gXe.onChangeSkinType(this.mSkinType);
        }
        if (this.gXe.getParent() == null) {
            this.gXi.setVisibility(8);
            this.gXe.setVisibility(0);
            addView(this.gXe);
        }
    }

    public boolean bzl() {
        if (this.euk != null) {
            return this.euk.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(boolean z) {
        if (!bzl()) {
            if (this.euk == null) {
                this.euk = new com.baidu.tbadk.k.g(getContext());
                this.euk.aN(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.euk.aPU();
                this.euk.setWrapStyle(true);
            }
            this.euk.onChangeSkinType();
            this.euk.attachView(this, z);
        }
    }

    public void bNd() {
        this.gXi.setVisibility(0);
        this.gXa.setVisibility(0);
        if (this.gXd.hasMore()) {
            this.elw.startLoadData();
        } else {
            this.elw.endLoadDataWithNoMore();
        }
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void bNe() {
        this.gXi.setVisibility(0);
        this.gXa.setVisibility(0);
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.setHeight(0);
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
        if (this.gXd != null) {
            this.gXd.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.gXd != null) {
            this.gXd.lt(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.gXd != null) {
            this.gXd.mx(z);
        }
        if (this.gXg != null) {
            this.gXg.b(this.gXh);
            this.gXg.a(this.gXh);
            this.gXh.bNh();
        }
    }

    public void reload() {
        if (this.gXa != null && this.gXi != null) {
            if (this.gXf && this.gXa.getFirstVisiblePosition() != 0) {
                this.gXf = false;
                return;
            }
            this.gXa.setSelection(0);
            if (!this.gXi.isRefreshing()) {
                this.gXi.setRefreshing(true);
            }
            if (this.gXh != null) {
                this.gXh.bNh();
            }
        }
    }

    public void onDestroy() {
        if (this.gXg != null) {
            this.gXg.b(this.gXh);
        }
        this.gXa.removeOnScrollListener(this.mOnScrollListener);
        this.gXd.a((c.a) null);
        this.gWZ.setListPullRefreshListener(null);
        this.gWZ.a((g.d) null);
        this.gXa.setOnSrollToBottomListener(null);
        this.gWZ.a((g.b) null);
        this.gWZ.release();
        this.gXa.setRecyclerListener(null);
    }

    public void bNf() {
        if (this.gXb != null) {
            this.gXb.notifyDataSetChanged();
        }
    }

    public void bNg() {
        if (this.gXd != null) {
            this.gXd.lt(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcg() {
        if (this.gXd != null) {
            this.gXd.bcg();
        }
    }

    public void sm() {
        if (this.gXb != null) {
            List<m> dataList = this.gXb.getDataList();
            if (!v.isEmpty(dataList)) {
                for (m mVar : dataList) {
                    if (mVar instanceof k) {
                        k kVar = (k) mVar;
                        if (kVar.cRh != 0 && kVar.cRg != null) {
                            int[] imageWidthAndHeight = kVar.cRg.getImageWidthAndHeight();
                            kVar.cRh = imageWidthAndHeight[0];
                            kVar.cRi = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.gXb != null) {
                            ConcernPageView.this.gXb.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
