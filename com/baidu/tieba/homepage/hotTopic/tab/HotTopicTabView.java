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
/* loaded from: classes22.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView Xe;
    private com.baidu.tbadk.h.f aiM;
    private PbListView gjo;
    private BdSwipeRefreshLayout gko;
    private int glP;
    private g gso;
    private boolean hwi;
    private TabLayout.OnTabSelectedListener jBn;
    private b jBq;
    private h jBt;
    private HotTopicHeaderView jBu;
    private ScrollFragmentTabHost jvA;
    ScrollFragmentTabHost.a jvB;
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
        this.glP = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.glP != i && HotTopicTabView.this.jvA != null) {
                    HotTopicTabView.this.glP = i;
                    if (HotTopicTabView.this.glP == 1) {
                        HotTopicTabView.this.jvA.bPq();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.jvA.bPr();
                    } else {
                        HotTopicTabView.this.jvA.bPq();
                    }
                }
            }
        };
        this.jvB = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cJM() {
                if (HotTopicTabView.this.jvA != null) {
                    HotTopicTabView.this.glP = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.Xe)) {
                        HotTopicTabView.this.jvA.bPr();
                    } else {
                        HotTopicTabView.this.jvA.bPq();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bWm();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.gko = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gko.setProgressView(this.mPullView);
        this.Xe = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Xe.setLayoutManager(new LinearLayoutManager(context));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.jBt = new h(this.mPageContext, this.Xe);
        this.gjo = new PbListView(this.mPageContext.getPageActivity());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_g);
    }

    private void bWm() {
        this.Xe.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jBn = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
            this.jvA.a(this.jvB);
            this.jvB.cJM();
        }
        if (this.hwi) {
            this.hwi = false;
            if (y.isEmpty(this.jBt.getData())) {
                this.jBq.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.jBt != null) {
            this.jBt.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.jBq = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cKA() {
        return (this.jBu == null || this.jBu.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.jBu == null) {
            this.jBu = new HotTopicHeaderView(getContext());
        }
        this.Xe.setHeaderView(this.jBu);
        this.jBu.setOnItemCoverListener(this.aiM);
        this.jBu.setOnTabSelectedListener(this.jBn);
        this.jBu.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<q> list) {
        this.jBt.setData(list);
    }

    public void Wj() {
        this.Xe.setNextPage(this.gjo);
        this.gjo.endLoadData();
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.ar(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cKB() {
        this.Xe.setNextPage(null);
    }

    public void reload() {
        this.Xe.setSelection(0);
        startPullRefresh();
        if (this.jvB != null) {
            this.jvB.cJM();
        }
    }

    public void startPullRefresh() {
        this.gko.setRefreshing(true);
    }

    public void bPh() {
        this.gko.setRefreshing(false);
    }

    public void hJ(boolean z) {
        if (!cmJ()) {
            if (this.gso == null) {
                this.gso = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gso.bBg();
                this.gso.setTopMargin(height);
                this.gso.onChangeSkinType();
            }
            this.gso.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
            this.gso = null;
        }
    }

    public boolean cmJ() {
        if (this.gso != null) {
            return this.gso.isViewAttached();
        }
        return false;
    }

    public void oY(boolean z) {
        if (!cmK()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.jBq != null) {
                            HotTopicTabView.this.hJ(false);
                            HotTopicTabView.this.jBq.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cmK() {
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
            ap.setBackgroundColor(this.gko, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_d);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.gso != null) {
                this.gso.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jBt != null) {
                this.jBt.notifyDataSetChanged();
            }
            if (this.gjo != null) {
                this.gjo.changeSkin(skinType);
                this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            if (this.jBu != null) {
                this.jBu.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jvA = scrollFragmentTabHost;
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
            this.jvA.a(this.jvB);
        }
    }

    public void destroy() {
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
        }
        bPh();
        hideLoadingView();
        Wk();
        this.hwi = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jBq.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.aiM = fVar;
        if (this.jBt != null) {
            this.jBt.setOnItemCoverListener(fVar);
        }
        if (this.jBu != null) {
            this.jBu.setOnItemCoverListener(fVar);
        }
    }
}
