package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.hotTopic.tab.a.h;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes21.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView WM;
    private com.baidu.tbadk.h.f ait;
    private PbListView fHm;
    private BdSwipeRefreshLayout fIl;
    private int fJF;
    private g fQf;
    private boolean gPr;
    private ScrollFragmentTabHost iOp;
    ScrollFragmentTabHost.a iOq;
    private TabLayout.OnTabSelectedListener iTV;
    private b iTY;
    private h iUb;
    private HotTopicHeaderView iUc;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public HotTopicTabView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fJF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.fJF != i && HotTopicTabView.this.iOp != null) {
                    HotTopicTabView.this.fJF = i;
                    if (HotTopicTabView.this.fJF == 1) {
                        HotTopicTabView.this.iOp.bHC();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.iOp.bHD();
                    } else {
                        HotTopicTabView.this.iOp.bHC();
                    }
                }
            }
        };
        this.iOq = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cAx() {
                if (HotTopicTabView.this.iOp != null) {
                    HotTopicTabView.this.fJF = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.WM)) {
                        HotTopicTabView.this.iOp.bHD();
                    } else {
                        HotTopicTabView.this.iOp.bHC();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bNr();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.fIl = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fIl.setProgressView(this.mPullView);
        this.WM = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.WM.setLayoutManager(new LinearLayoutManager(context));
        this.WM.setFadingEdgeLength(0);
        this.WM.setOverScrollMode(2);
        this.iUb = new h(this.mPageContext, this.WM);
        this.fHm = new PbListView(this.mPageContext.getPageActivity());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_g);
    }

    private void bNr() {
        this.WM.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.iTV = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
            this.iOp.a(this.iOq);
            this.iOq.cAx();
        }
        if (this.gPr) {
            this.gPr = false;
            if (y.isEmpty(this.iUb.getData())) {
                this.iTY.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.iUb != null) {
            this.iUb.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.iTY = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cBl() {
        return (this.iUc == null || this.iUc.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.iUc == null) {
            this.iUc = new HotTopicHeaderView(getContext());
        }
        this.WM.setHeaderView(this.iUc);
        this.iUc.setOnItemCoverListener(this.ait);
        this.iUc.setOnTabSelectedListener(this.iTV);
        this.iUc.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<q> list) {
        this.iUb.setData(list);
    }

    public void bIj() {
        this.WM.setNextPage(this.fHm);
        this.fHm.endLoadData();
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.ao(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cBm() {
        this.WM.setNextPage(null);
    }

    public void reload() {
        this.WM.setSelection(0);
        startPullRefresh();
        if (this.iOq != null) {
            this.iOq.cAx();
        }
    }

    public void startPullRefresh() {
        this.fIl.setRefreshing(true);
    }

    public void bHu() {
        this.fIl.setRefreshing(false);
    }

    public void gR(boolean z) {
        if (!cdE()) {
            if (this.fQf == null) {
                this.fQf = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.fQf.bue();
                this.fQf.setTopMargin(height);
                this.fQf.onChangeSkinType();
            }
            this.fQf.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
            this.fQf = null;
        }
    }

    public boolean cdE() {
        if (this.fQf != null) {
            return this.fQf.isViewAttached();
        }
        return false;
    }

    public void nS(boolean z) {
        if (!cdF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.iTY != null) {
                            HotTopicTabView.this.gR(false);
                            HotTopicTabView.this.iTY.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cdF() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.fIl, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.WM, R.color.cp_bg_line_d);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.fQf != null) {
                this.fQf.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iUb != null) {
                this.iUb.notifyDataSetChanged();
            }
            if (this.fHm != null) {
                this.fHm.changeSkin(skinType);
                this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            if (this.iUc != null) {
                this.iUc.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iOp = scrollFragmentTabHost;
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
            this.iOp.a(this.iOq);
        }
    }

    public void destroy() {
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
        }
        bHu();
        hideLoadingView();
        bHn();
        this.gPr = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.iTY.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.ait = fVar;
        if (this.iUb != null) {
            this.iUb.setOnItemCoverListener(fVar);
        }
        if (this.iUc != null) {
            this.iUc.setOnItemCoverListener(fVar);
        }
    }
}
