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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class ConcernPageView extends FrameLayout {
    private g fBv;
    private PbListView fsC;
    private int fuW;
    private com.baidu.tieba.homepage.personalize.bigday.a isb;
    private BdTypeRecyclerView isc;
    private com.baidu.tieba.homepage.concern.a isd;
    private a ise;
    private c isf;
    private ConcernNotLoginLayout isg;
    private boolean ish;
    private ScrollFragmentTabHost isi;
    ScrollFragmentTabHost.a isj;
    private BigdaySwipeRefreshLayout isk;
    private c.a isl;
    private View.OnClickListener ism;
    private CustomMessageListener isn;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes16.dex */
    public interface a {
        void GK(String str);

        void Y(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.isi = scrollFragmentTabHost;
        if (this.isi != null) {
            this.isi.b(this.isj);
            this.isi.a(this.isj);
        }
    }

    public void completePullRefresh() {
        if (this.isk != null) {
            this.isk.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.isd != null) {
            this.isd.setPageUniqueId(bdUniqueId);
        }
        if (this.isf != null) {
            this.isf.t(bdUniqueId);
        }
        if (this.isb != null) {
            this.isb.setTag(bdUniqueId);
        }
        if (this.isn != null) {
            this.isn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.isn);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.ish = false;
        this.mSkinType = 3;
        this.fuW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fuW != i && ConcernPageView.this.isi != null) {
                    ConcernPageView.this.fuW = i;
                    if (ConcernPageView.this.fuW == 1) {
                        ConcernPageView.this.isi.bxm();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.isi.bxn();
                    } else {
                        ConcernPageView.this.isi.bxm();
                    }
                }
            }
        };
        this.isj = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cly() {
                if (ConcernPageView.this.isi != null) {
                    ConcernPageView.this.fuW = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.isc)) {
                        ConcernPageView.this.isi.bxn();
                    } else {
                        ConcernPageView.this.isi.bxm();
                    }
                }
            }
        };
        this.isl = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clz() {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.isc.setSelection(0);
                if (ConcernPageView.this.isc.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.gw(true);
                }
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void GJ(String str) {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.clu();
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.GK(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.Y(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.isc.setVisibility(8);
                    ConcernPageView.this.ng(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void X(boolean z, boolean z2) {
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.Y(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.isf.clC()) {
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.clu();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clA() {
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.Y(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.isc.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.ism = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bwE();
            }
        };
        this.isn = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ish = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ish = false;
        this.mSkinType = 3;
        this.fuW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fuW != i && ConcernPageView.this.isi != null) {
                    ConcernPageView.this.fuW = i;
                    if (ConcernPageView.this.fuW == 1) {
                        ConcernPageView.this.isi.bxm();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.isi.bxn();
                    } else {
                        ConcernPageView.this.isi.bxm();
                    }
                }
            }
        };
        this.isj = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cly() {
                if (ConcernPageView.this.isi != null) {
                    ConcernPageView.this.fuW = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.isc)) {
                        ConcernPageView.this.isi.bxn();
                    } else {
                        ConcernPageView.this.isi.bxm();
                    }
                }
            }
        };
        this.isl = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clz() {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.isc.setSelection(0);
                if (ConcernPageView.this.isc.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.gw(true);
                }
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void GJ(String str) {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.clu();
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.GK(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.Y(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.isc.setVisibility(8);
                    ConcernPageView.this.ng(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void X(boolean z, boolean z2) {
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.Y(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.isf.clC()) {
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.clu();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clA() {
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.Y(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.isc.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.ism = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bwE();
            }
        };
        this.isn = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ish = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ish = false;
        this.mSkinType = 3;
        this.fuW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.fuW != i2 && ConcernPageView.this.isi != null) {
                    ConcernPageView.this.fuW = i2;
                    if (ConcernPageView.this.fuW == 1) {
                        ConcernPageView.this.isi.bxm();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.isi.bxn();
                    } else {
                        ConcernPageView.this.isi.bxm();
                    }
                }
            }
        };
        this.isj = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cly() {
                if (ConcernPageView.this.isi != null) {
                    ConcernPageView.this.fuW = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.isc)) {
                        ConcernPageView.this.isi.bxn();
                    } else {
                        ConcernPageView.this.isi.bxm();
                    }
                }
            }
        };
        this.isl = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clz() {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.isc.setSelection(0);
                if (ConcernPageView.this.isc.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.gw(true);
                }
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void GJ(String str) {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.clu();
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.GK(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.Y(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.isc.setVisibility(8);
                    ConcernPageView.this.ng(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void X(boolean z, boolean z2) {
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.Y(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.isf.clC()) {
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.clu();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clA() {
                if (ConcernPageView.this.ise != null) {
                    ConcernPageView.this.ise.Y(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.isc.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.ism = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bwE();
            }
        };
        this.isn = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ish = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.isc = new BdTypeRecyclerView(context);
        this.isc.setLayoutManager(new LinearLayoutManager(context));
        this.isc.setFadingEdgeLength(0);
        this.isc.setOverScrollMode(2);
        this.isk = new BigdaySwipeRefreshLayout(context);
        this.isk.addView(this.isc);
        this.fsC = new PbListView(context);
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setLineGone();
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.setOnClickListener(this.ism);
        this.isc.setNextPage(this.fsC);
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        addView(this.isk);
        this.isb = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.isb.setEnable(true);
        this.isk.setProgressView(this.isb);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.isk.setCustomDistances(i, i, i * 2);
        this.isd = new com.baidu.tieba.homepage.concern.a(context, this.isc);
        this.isf = new c(this.pageContext, this.isc, this.isd, this.isk);
        this.isk.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bCM() {
        this.isf.a(this.isl);
        this.isb.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.brD().AO("page_concern");
                    ConcernPageView.this.isf.update();
                }
            }
        });
        this.isc.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bwE();
            }
        });
        this.isc.removeOnScrollListener(this.mOnScrollListener);
        this.isc.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.ise = aVar;
    }

    public void clr() {
        if (!TbadkCoreApplication.isLogin()) {
            clt();
        } else if (this.isf != null) {
            this.isf.update();
            gw(true);
        }
    }

    public void cls() {
        if (!TbadkCoreApplication.isLogin()) {
            clt();
        } else if (this.isf != null) {
            this.isf.clB();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.isf != null) {
            this.isf.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.isg != null) {
                this.isg.onChangeSkinType(i);
            }
            if (this.fBv != null) {
                this.fBv.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.isb != null) {
                this.isb.changeSkin(i);
            }
            if (this.fsC != null) {
                this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
                this.fsC.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.isd.onChangeSkinType(i);
            ao.setBackgroundColor(this, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.isk, R.color.cp_bg_line_e);
            ao.setBackgroundColor(this.isc, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        clw();
    }

    public void aN(String str, int i) {
        this.isf.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.isf.a(z, dataRes, 0, null);
    }

    public void ng(boolean z) {
        if (!bWj()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.isf != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.isf.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this);
            this.fBv = null;
        }
    }

    private boolean bWj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void clt() {
        if (this.isg == null) {
            this.isg = new ConcernNotLoginLayout(getContext());
            this.isg.onChangeSkinType(this.mSkinType);
        }
        if (this.isg.getParent() == null) {
            this.isk.setVisibility(8);
            this.isg.setVisibility(0);
            addView(this.isg);
        }
    }

    public boolean bWi() {
        if (this.fBv != null) {
            return this.fBv.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(boolean z) {
        if (!bWi()) {
            if (this.fBv == null) {
                this.fBv = new g(getContext());
                this.fBv.bi(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.fBv.bkn();
                this.fBv.setWrapStyle(true);
            }
            this.fBv.onChangeSkinType();
            this.fBv.attachView(this, z);
        }
    }

    public void clu() {
        this.isk.setVisibility(0);
        this.isc.setVisibility(0);
        if (this.isf.hasMore()) {
            this.fsC.startLoadData();
        } else {
            this.fsC.endLoadDataWithNoMore();
        }
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void clv() {
        this.isk.setVisibility(0);
        this.isc.setVisibility(0);
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.m31do(null, getContext().getString(R.string.concern_no_data_title)), null);
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
        if (this.isf != null) {
            this.isf.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.isf != null) {
            this.isf.nN(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.isf != null) {
            this.isf.oT(z);
        }
        if (this.isi != null) {
            this.isi.b(this.isj);
            this.isi.a(this.isj);
            this.isj.cly();
        }
    }

    public void reload() {
        if (this.isc != null && this.isk != null) {
            if (this.ish && this.isc.getFirstVisiblePosition() != 0) {
                this.ish = false;
                return;
            }
            this.isc.setSelection(0);
            if (!this.isk.isRefreshing()) {
                this.isk.setRefreshing(true);
            }
            if (this.isj != null) {
                this.isj.cly();
            }
        }
    }

    public void onDestroy() {
        if (this.isi != null) {
            this.isi.b(this.isj);
        }
        this.isc.removeOnScrollListener(this.mOnScrollListener);
        this.isf.a((c.a) null);
        this.isb.setListPullRefreshListener(null);
        this.isb.a((f.d) null);
        this.isc.setOnSrollToBottomListener(null);
        this.isb.a((f.b) null);
        this.isb.release();
        this.isc.setRecyclerListener(null);
    }

    public void clw() {
        if (this.isd != null) {
            this.isd.notifyDataSetChanged();
        }
    }

    public void clx() {
        if (this.isf != null) {
            this.isf.nN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwE() {
        if (this.isf != null) {
            this.isf.bwE();
        }
    }

    public void zc() {
        if (this.isd != null) {
            List<q> dataList = this.isd.getDataList();
            if (!x.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof k) {
                        k kVar = (k) qVar;
                        if (kVar.dRu != 0 && kVar.dLK != null) {
                            int[] imageWidthAndHeight = kVar.dLK.getImageWidthAndHeight();
                            kVar.dRu = imageWidthAndHeight[0];
                            kVar.dRv = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.isd != null) {
                            ConcernPageView.this.isd.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
