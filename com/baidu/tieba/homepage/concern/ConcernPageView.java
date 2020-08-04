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
    private com.baidu.tieba.homepage.personalize.bigday.a isd;
    private BdTypeRecyclerView ise;
    private com.baidu.tieba.homepage.concern.a isf;
    private a isg;
    private c ish;
    private ConcernNotLoginLayout isi;
    private boolean isj;
    private ScrollFragmentTabHost isk;
    ScrollFragmentTabHost.a isl;
    private BigdaySwipeRefreshLayout ism;
    private c.a isn;
    private View.OnClickListener iso;
    private CustomMessageListener isp;
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
        this.isk = scrollFragmentTabHost;
        if (this.isk != null) {
            this.isk.b(this.isl);
            this.isk.a(this.isl);
        }
    }

    public void completePullRefresh() {
        if (this.ism != null) {
            this.ism.interruptRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.isf != null) {
            this.isf.setPageUniqueId(bdUniqueId);
        }
        if (this.ish != null) {
            this.ish.t(bdUniqueId);
        }
        if (this.isd != null) {
            this.isd.setTag(bdUniqueId);
        }
        if (this.isp != null) {
            this.isp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.isp);
        }
    }

    public ConcernPageView(Context context) {
        super(context);
        this.isj = false;
        this.mSkinType = 3;
        this.fuW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fuW != i && ConcernPageView.this.isk != null) {
                    ConcernPageView.this.fuW = i;
                    if (ConcernPageView.this.fuW == 1) {
                        ConcernPageView.this.isk.bxm();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.isk.bxn();
                    } else {
                        ConcernPageView.this.isk.bxm();
                    }
                }
            }
        };
        this.isl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cly() {
                if (ConcernPageView.this.isk != null) {
                    ConcernPageView.this.fuW = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.ise)) {
                        ConcernPageView.this.isk.bxn();
                    } else {
                        ConcernPageView.this.isk.bxm();
                    }
                }
            }
        };
        this.isn = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clz() {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.ise.setSelection(0);
                if (ConcernPageView.this.ise.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.gw(true);
                }
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void GJ(String str) {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.clu();
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.GK(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.Y(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.ise.setVisibility(8);
                    ConcernPageView.this.ng(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void X(boolean z, boolean z2) {
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.Y(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.ish.clC()) {
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.clu();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clA() {
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.Y(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.ise.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iso = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bwE();
            }
        };
        this.isp = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.isj = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isj = false;
        this.mSkinType = 3;
        this.fuW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (ConcernPageView.this.fuW != i && ConcernPageView.this.isk != null) {
                    ConcernPageView.this.fuW = i;
                    if (ConcernPageView.this.fuW == 1) {
                        ConcernPageView.this.isk.bxm();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.isk.bxn();
                    } else {
                        ConcernPageView.this.isk.bxm();
                    }
                }
            }
        };
        this.isl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cly() {
                if (ConcernPageView.this.isk != null) {
                    ConcernPageView.this.fuW = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.ise)) {
                        ConcernPageView.this.isk.bxn();
                    } else {
                        ConcernPageView.this.isk.bxm();
                    }
                }
            }
        };
        this.isn = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clz() {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.ise.setSelection(0);
                if (ConcernPageView.this.ise.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.gw(true);
                }
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void GJ(String str) {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.clu();
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.GK(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i, String str) {
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.Y(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i != 1) {
                    ConcernPageView.this.ise.setVisibility(8);
                    ConcernPageView.this.ng(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void X(boolean z, boolean z2) {
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.Y(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.ish.clC()) {
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.clu();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clA() {
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.Y(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.ise.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iso = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bwE();
            }
        };
        this.isp = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.isj = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    public ConcernPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isj = false;
        this.mSkinType = 3;
        this.fuW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (ConcernPageView.this.fuW != i2 && ConcernPageView.this.isk != null) {
                    ConcernPageView.this.fuW = i2;
                    if (ConcernPageView.this.fuW == 1) {
                        ConcernPageView.this.isk.bxm();
                    } else if (ConcernPageView.this.a(recyclerView)) {
                        ConcernPageView.this.isk.bxn();
                    } else {
                        ConcernPageView.this.isk.bxm();
                    }
                }
            }
        };
        this.isl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cly() {
                if (ConcernPageView.this.isk != null) {
                    ConcernPageView.this.fuW = -1;
                    if (ConcernPageView.this.a(ConcernPageView.this.ise)) {
                        ConcernPageView.this.isk.bxn();
                    } else {
                        ConcernPageView.this.isk.bxm();
                    }
                }
            }
        };
        this.isn = new c.a() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.3
            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clz() {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.ise.setSelection(0);
                if (ConcernPageView.this.ise.getCount() > 0) {
                    ConcernPageView.this.hideLoadingView();
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.gw(true);
                }
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.onPullToRefresh();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void GJ(String str) {
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.clu();
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.GK(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void onError(int i2, String str) {
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.Y(false, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.hideNoDataView();
                if (i2 != 1) {
                    ConcernPageView.this.ise.setVisibility(8);
                    ConcernPageView.this.ng(true);
                } else if (j.isNetWorkAvailable()) {
                    ConcernPageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void X(boolean z, boolean z2) {
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.Y(z, z2);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.hideNoDataView();
                if (ConcernPageView.this.ish.clC()) {
                    ConcernPageView.this.clv();
                } else {
                    ConcernPageView.this.clu();
                }
            }

            @Override // com.baidu.tieba.homepage.concern.c.a
            public void clA() {
                if (ConcernPageView.this.isg != null) {
                    ConcernPageView.this.isg.Y(true, false);
                }
                ConcernPageView.this.hideLoadingView();
                ConcernPageView.this.bwX();
                ConcernPageView.this.ise.setVisibility(8);
                ConcernPageView.this.showNoDataView();
            }
        };
        this.iso = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConcernPageView.this.bwE();
            }
        };
        this.isp = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    ConcernPageView.this.isj = true;
                    ConcernPageView.this.reload();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ise = new BdTypeRecyclerView(context);
        this.ise.setLayoutManager(new LinearLayoutManager(context));
        this.ise.setFadingEdgeLength(0);
        this.ise.setOverScrollMode(2);
        this.ism = new BigdaySwipeRefreshLayout(context);
        this.ism.addView(this.ise);
        this.fsC = new PbListView(context);
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setLineGone();
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.setOnClickListener(this.iso);
        this.ise.setNextPage(this.fsC);
        e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        addView(this.ism);
        this.isd = new com.baidu.tieba.homepage.personalize.bigday.a(this.pageContext);
        this.isd.setEnable(true);
        this.ism.setProgressView(this.isd);
        int i = (int) (86.0f * getResources().getDisplayMetrics().density);
        this.ism.setCustomDistances(i, i, i * 2);
        this.isf = new com.baidu.tieba.homepage.concern.a(context, this.ise);
        this.ish = new c(this.pageContext, this.ise, this.isf, this.ism);
        this.ism.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
    }

    public void bCM() {
        this.ish.a(this.isn);
        this.isd.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    d.brD().AO("page_concern");
                    ConcernPageView.this.ish.update();
                }
            }
        });
        this.ise.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                ConcernPageView.this.bwE();
            }
        });
        this.ise.removeOnScrollListener(this.mOnScrollListener);
        this.ise.addOnScrollListener(this.mOnScrollListener);
    }

    public void setCallback(a aVar) {
        this.isg = aVar;
    }

    public void clr() {
        if (!TbadkCoreApplication.isLogin()) {
            clt();
        } else if (this.ish != null) {
            this.ish.update();
            gw(true);
        }
    }

    public void cls() {
        if (!TbadkCoreApplication.isLogin()) {
            clt();
        } else if (this.ish != null) {
            this.ish.clB();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(aa aaVar) {
        if (this.ish != null) {
            this.ish.setRecommendFrsNavigationAnimDispatcher(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.isi != null) {
                this.isi.onChangeSkinType(i);
            }
            if (this.fBv != null) {
                this.fBv.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.isd != null) {
                this.isd.changeSkin(i);
            }
            if (this.fsC != null) {
                this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
                this.fsC.changeSkin(i);
            }
            if (this.mNoDataView != null && this.mNoDataView.getVisibility() == 0) {
                this.mNoDataView.onChangeSkinType(this.pageContext, i);
                this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            }
            this.isf.onChangeSkinType(i);
            ao.setBackgroundColor(this, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.ism, R.color.cp_bg_line_e);
            ao.setBackgroundColor(this.ise, R.color.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void onResume() {
        setTabInForeBackgroundState(false);
        clw();
    }

    public void aN(String str, int i) {
        this.ish.a(true, null, i, str);
    }

    public void a(DataRes dataRes, boolean z) {
        this.ish.a(z, dataRes, 0, null);
    }

    public void ng(boolean z) {
        if (!bWj()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.ConcernPageView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (ConcernPageView.this.ish != null && j.isNetworkAvailableForImmediately() && TbadkCoreApplication.isLogin()) {
                            ConcernPageView.this.ish.update();
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
        if (this.isi == null) {
            this.isi = new ConcernNotLoginLayout(getContext());
            this.isi.onChangeSkinType(this.mSkinType);
        }
        if (this.isi.getParent() == null) {
            this.ism.setVisibility(8);
            this.isi.setVisibility(0);
            addView(this.isi);
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
        this.ism.setVisibility(0);
        this.ise.setVisibility(0);
        if (this.ish.hasMore()) {
            this.fsC.startLoadData();
        } else {
            this.fsC.endLoadDataWithNoMore();
        }
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds150));
    }

    public void clv() {
        this.ism.setVisibility(0);
        this.ise.setVisibility(0);
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
        if (this.ish != null) {
            this.ish.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.ish != null) {
            this.ish.nN(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.ish != null) {
            this.ish.oT(z);
        }
        if (this.isk != null) {
            this.isk.b(this.isl);
            this.isk.a(this.isl);
            this.isl.cly();
        }
    }

    public void reload() {
        if (this.ise != null && this.ism != null) {
            if (this.isj && this.ise.getFirstVisiblePosition() != 0) {
                this.isj = false;
                return;
            }
            this.ise.setSelection(0);
            if (!this.ism.isRefreshing()) {
                this.ism.setRefreshing(true);
            }
            if (this.isl != null) {
                this.isl.cly();
            }
        }
    }

    public void onDestroy() {
        if (this.isk != null) {
            this.isk.b(this.isl);
        }
        this.ise.removeOnScrollListener(this.mOnScrollListener);
        this.ish.a((c.a) null);
        this.isd.setListPullRefreshListener(null);
        this.isd.a((f.d) null);
        this.ise.setOnSrollToBottomListener(null);
        this.isd.a((f.b) null);
        this.isd.release();
        this.ise.setRecyclerListener(null);
    }

    public void clw() {
        if (this.isf != null) {
            this.isf.notifyDataSetChanged();
        }
    }

    public void clx() {
        if (this.ish != null) {
            this.ish.nN(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwE() {
        if (this.ish != null) {
            this.ish.bwE();
        }
    }

    public void zc() {
        if (this.isf != null) {
            List<q> dataList = this.isf.getDataList();
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
                        if (ConcernPageView.this.isf != null) {
                            ConcernPageView.this.isf.notifyDataSetChanged();
                        }
                    }
                }, 500L);
            }
        }
    }
}
