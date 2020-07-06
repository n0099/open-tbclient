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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    private PbListView fnt;
    private int fpM;
    private g fwo;
    private com.baidu.tieba.homepage.personalize.bigday.a ilY;
    private BdTypeRecyclerView ilZ;
    private com.baidu.tieba.homepage.concern.a ima;
    private a imb;
    private c imc;
    private ConcernNotLoginLayout imd;
    private boolean ime;
    private ScrollFragmentTabHost imf;
    ScrollFragmentTabHost.a imh;
    private BigdaySwipeRefreshLayout imi;
    private c.a imj;
    private View.OnClickListener imk;
    private CustomMessageListener iml;
    private NoDataView mNoDataView;
    RecyclerView.OnScrollListener mOnScrollListener;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private h refreshView;

    /* loaded from: classes9.dex */
    public interface a {
        void FY(String str);

        void X(boolean z, boolean z2);

        void onPullToRefresh();
    }

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.imf = scrollFragmentTabHost;
        if (this.imf != null) {
            this.imf.b(this.imh);
            this.imf.a(this.imh);
        }
    }

    public void completePullRefresh() {
        if (this.imi != null) {
            this.imi.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ima != null) {
            this.ima.setPageUniqueId(bdUniqueId);
        }
        if (this.imc != null) {
            this.imc.s(bdUniqueId);
        }
        if (this.ilY != null) {
            this.ilY.setTag(bdUniqueId);
        }
        if (this.iml != null) {
            this.iml.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.iml);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.ime = false;
        this.mSkinType = 3;
        this.fpM = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fpM != i && ConcernPageView.this.imf != null) {
                    ConcernPageView.this.fpM = i;
                    if (ConcernPageView.this.fpM == 1) {
                        ConcernPageView.this.imf.bud();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.imf.bue();
                    } else {
                        ConcernPageView.this.imf.bud();
                    }
                }
            }
        };
        this.imh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void chZ() {
                if (ConcernPageView.this.imf != null) {
                    ConcernPageView.this.fpM = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.ilZ)) {
                        ConcernPageView.this.imf.bue();
                    } else {
                        ConcernPageView.this.imf.bud();
                    }
                }
            }
        };
        this.imj = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cia() {
                ConcernPageView.this.btO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.ilZ.setSelection(0);
                if (ConcernPageView.this.ilZ.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.chW();
                } else {
                    ConcernPageView.this.ga(true);
                }
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void FX(String str) {
                ConcernPageView.this.btO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.chV();
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.FY(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.X(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.ilZ.setVisibility(8);
                    ConcernPageView.this.mB(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void W(boolean z, boolean z2) {
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.X(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.btO();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.imc.cid()) {
                    ConcernPageView.this.chW();
                } else {
                    ConcernPageView.this.chV();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cib() {
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.X(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.btO();
                ConcernPageView.this.ilZ.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.imk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.btv();
            }
        };
        this.iml = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ime = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ime = false;
        this.mSkinType = 3;
        this.fpM = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fpM != i && ConcernPageView.this.imf != null) {
                    ConcernPageView.this.fpM = i;
                    if (ConcernPageView.this.fpM == 1) {
                        ConcernPageView.this.imf.bud();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.imf.bue();
                    } else {
                        ConcernPageView.this.imf.bud();
                    }
                }
            }
        };
        this.imh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void chZ() {
                if (ConcernPageView.this.imf != null) {
                    ConcernPageView.this.fpM = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.ilZ)) {
                        ConcernPageView.this.imf.bue();
                    } else {
                        ConcernPageView.this.imf.bud();
                    }
                }
            }
        };
        this.imj = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cia() {
                ConcernPageView.this.btO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.ilZ.setSelection(0);
                if (ConcernPageView.this.ilZ.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.chW();
                } else {
                    ConcernPageView.this.ga(true);
                }
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void FX(String str) {
                ConcernPageView.this.btO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.chV();
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.FY(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.X(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.ilZ.setVisibility(8);
                    ConcernPageView.this.mB(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void W(boolean z, boolean z2) {
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.X(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.btO();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.imc.cid()) {
                    ConcernPageView.this.chW();
                } else {
                    ConcernPageView.this.chV();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cib() {
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.X(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.btO();
                ConcernPageView.this.ilZ.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.imk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.btv();
            }
        };
        this.iml = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ime = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ime = false;
        this.mSkinType = 3;
        this.fpM = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.fpM != i2 && ConcernPageView.this.imf != null) {
                    ConcernPageView.this.fpM = i2;
                    if (ConcernPageView.this.fpM == 1) {
                        ConcernPageView.this.imf.bud();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.imf.bue();
                    } else {
                        ConcernPageView.this.imf.bud();
                    }
                }
            }
        };
        this.imh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void chZ() {
                if (ConcernPageView.this.imf != null) {
                    ConcernPageView.this.fpM = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.ilZ)) {
                        ConcernPageView.this.imf.bue();
                    } else {
                        ConcernPageView.this.imf.bud();
                    }
                }
            }
        };
        this.imj = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cia() {
                ConcernPageView.this.btO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.ilZ.setSelection(0);
                if (ConcernPageView.this.ilZ.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.chW();
                } else {
                    ConcernPageView.this.ga(true);
                }
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void FX(String str) {
                ConcernPageView.this.btO();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.chV();
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.FY(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.X(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.ilZ.setVisibility(8);
                    ConcernPageView.this.mB(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void W(boolean z, boolean z2) {
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.X(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.btO();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.imc.cid()) {
                    ConcernPageView.this.chW();
                } else {
                    ConcernPageView.this.chV();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void cib() {
                if (ConcernPageView.this.imb != null) {
                    ConcernPageView.this.imb.X(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.btO();
                ConcernPageView.this.ilZ.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.imk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.btv();
            }
        };
        this.iml = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.ime = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ilZ = new BdTypeRecyclerView(context);
        this.ilZ.setLayoutManager(new LinearLayoutManager(context));
        this.ilZ.setFadingEdgeLength(0);
        this.ilZ.setOverScrollMode(2);
        this.imi = new BigdaySwipeRefreshLayout(context);
        this.imi.addView(this.ilZ);
        this.fnt = new PbListView(context);
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setLineGone();
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.setOnClickListener(this.imk);
        this.ilZ.setNextPage(this.fnt);
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        addView(this.imi);
        this.ilY = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.ilY.setEnable(true);
        this.imi.setProgressView(this.ilY);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.imi.setCustomDistances(i, i, i * 2);
        this.ima = new com.baidu.tieba.homepage.concern.a(context, this.ilZ);
        this.imc = new c(this.pageContext, this.ilZ, this.ima, this.imi);
        this.imi.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bzy() {
        this.imc.a(this.imj);
        this.ilY.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.boB().Ad("page_concern");
                    ConcernPageView.this.imc.update();
                }
            }
        });
        this.ilZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.btv();
            }
        });
        this.ilZ.removeOnScrollListener(this.mOnScrollListener);
        this.ilZ.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.imb = aVar;
    }

    public void chS() {
        if (!TbadkCoreApplication.isLogin()) {
            chU();
        } else if (this.imc != null) {
            this.imc.update();
            ga(true);
        }
    }

    public void chT() {
        if (!TbadkCoreApplication.isLogin()) {
            chU();
        } else if (this.imc != null) {
            this.imc.cic();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.imc != null) {
            this.imc.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.imd != null) {
                this.imd.onChangeSkinType(i);
            }
            if (this.fwo != null) {
                this.fwo.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.ilY != null) {
                this.ilY.changeSkin(i);
            }
            if (this.fnt != null) {
                this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
                this.fnt.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.ima.onChangeSkinType(i);
            an.setBackgroundColor(this, R.color.cp_bg_line_d);
            an.setBackgroundColor(this.imi, R.color.cp_bg_line_e);
            an.setBackgroundColor(this.ilZ, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        chX();
    }

    public void aO(String str, int i) {
        this.imc.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.imc.a(z, dataRes, 0, null);
    }

    public void mB(boolean z) {
        if (!bSS()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.imc != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.imc.update();
                        }
                    }
                });
            }
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btO() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this);
            this.fwo = null;
        }
    }

    private boolean bSS() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    private void chU() {
        if (this.imd == null) {
            this.imd = new ConcernNotLoginLayout(getContext());
            this.imd.onChangeSkinType(this.mSkinType);
        }
        if (this.imd.getParent() == null) {
            this.imi.setVisibility(8);
            this.imd.setVisibility(0);
            addView(this.imd);
        }
    }

    public boolean bSR() {
        if (this.fwo != null) {
            return this.fwo.isViewAttached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(boolean z) {
        if (!bSR()) {
            if (this.fwo == null) {
                this.fwo = new g(getContext());
                this.fwo.bg(((TbadkCoreApplication.getInst().getMainTabBottomBarHeight() * 3) / 2) + l.getDimens(getContext(), R.dimen.tbds60));
                this.fwo.bgC();
                this.fwo.setWrapStyle(true);
            }
            this.fwo.onChangeSkinType();
            this.fwo.attachView(this, z);
        }
    }

    public void chV() {
        this.imi.setVisibility(0);
        this.ilZ.setVisibility(0);
        if (this.imc.hasMore()) {
            this.fnt.startLoadData();
        } else {
            this.fnt.endLoadDataWithNoMore();
        }
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void chW() {
        this.imi.setVisibility(0);
        this.ilZ.setVisibility(0);
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.setHeight(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(getContext(), this, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL), NoDataViewFactory.d.dm(null, getContext().getString(R.string.concern_no_data_title)), null);
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
        if (this.imc != null) {
            this.imc.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.imc != null) {
            this.imc.ni(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.imc != null) {
            this.imc.oo(z);
        }
        if (this.imf != null) {
            this.imf.b(this.imh);
            this.imf.a(this.imh);
            this.imh.chZ();
        }
    }

    public void reload() {
        if (this.ilZ != null && this.imi != null) {
            if (this.ime && this.ilZ.getFirstVisiblePosition() != 0) {
                this.ime = false;
                return;
            }
            this.ilZ.setSelection(0);
            if (!this.imi.isRefreshing()) {
                this.imi.setRefreshing(true);
            }
            if (this.imh != null) {
                this.imh.chZ();
            }
        }
    }

    public void onDestroy() {
        if (this.imf != null) {
            this.imf.b(this.imh);
        }
        this.ilZ.removeOnScrollListener(this.mOnScrollListener);
        this.imc.a((c.a) null);
        this.ilY.setListPullRefreshListener(null);
        this.ilY.a((f.d) null);
        this.ilZ.setOnSrollToBottomListener(null);
        this.ilY.a((f.b) null);
        this.ilY.release();
        this.ilZ.setRecyclerListener(null);
    }

    public void chX() {
        if (this.ima != null) {
            this.ima.notifyDataSetChanged();
        }
    }

    public void chY() {
        if (this.imc != null) {
            this.imc.ni(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btv() {
        if (this.imc != null) {
            this.imc.btv();
        }
    }

    public void yA() {
        if (this.ima != null) {
            List<q> dataList = this.ima.getDataList();
            if (!w.isEmpty(dataList)) {
                for (q qVar : dataList) {
                    if (qVar instanceof k) {
                        k kVar = (k) qVar;
                        if (kVar.dLj != 0 && kVar.dLi != null) {
                            int[] imageWidthAndHeight = kVar.dLi.getImageWidthAndHeight();
                            kVar.dLj = imageWidthAndHeight[0];
                            kVar.dLk = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConcernPageView.this.ima != null) {
                            ConcernPageView.this.ima.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
