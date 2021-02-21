package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.hotTopic.tab.a.h;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView XW;
    private com.baidu.tbadk.h.f ajq;
    private PbListView gAw;
    private BdSwipeRefreshLayout gBw;
    private int gCX;
    private g gJB;
    private boolean hRx;
    private ScrollFragmentTabHost kal;
    ScrollFragmentTabHost.a kam;
    private TabLayout.OnTabSelectedListener kgo;
    private b kgr;
    private h kgu;
    private HotTopicHeaderView kgv;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private com.baidu.tbadk.l.h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public HotTopicTabView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gCX = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.gCX != i && HotTopicTabView.this.kal != null) {
                    HotTopicTabView.this.gCX = i;
                    if (HotTopicTabView.this.gCX == 1) {
                        HotTopicTabView.this.kal.bRQ();
                    } else if (HotTopicTabView.this.c(recyclerView)) {
                        HotTopicTabView.this.kal.bRR();
                    } else {
                        HotTopicTabView.this.kal.bRQ();
                    }
                }
            }
        };
        this.kam = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cQa() {
                if (HotTopicTabView.this.kal != null) {
                    HotTopicTabView.this.gCX = -1;
                    if (HotTopicTabView.this.c(HotTopicTabView.this.XW)) {
                        HotTopicTabView.this.kal.bRR();
                    } else {
                        HotTopicTabView.this.kal.bRQ();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bZl();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.gBw = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gBw.setProgressView(this.mPullView);
        this.XW = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.XW.setLayoutManager(new LinearLayoutManager(context));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.XW.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.kgu = new h(this.mPageContext, this.XW);
        this.gAw = new PbListView(this.mPageContext.getPageActivity());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0111);
    }

    private void bZl() {
        this.XW.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.kgo = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.kal != null) {
            this.kal.b(this.kam);
            this.kal.a(this.kam);
            this.kam.cQa();
        }
        if (this.hRx) {
            this.hRx = false;
            if (y.isEmpty(this.kgu.getData())) {
                this.kgr.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.kgu != null) {
            this.kgu.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.kgr = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cQO() {
        return (this.kgv == null || this.kgv.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.kgv == null) {
            this.kgv = new HotTopicHeaderView(getContext());
        }
        this.XW.setHeaderView(this.kgv);
        this.kgv.setOnItemCoverListener(this.ajq);
        this.kgv.setOnTabSelectedListener(this.kgo);
        this.kgv.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<n> list) {
        this.kgu.setData(list);
    }

    public void WY() {
        this.XW.setNextPage(this.gAw);
        this.gAw.endLoadData();
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.av(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cQP() {
        this.XW.setNextPage(null);
    }

    public void reload() {
        this.XW.setSelection(0);
        startPullRefresh();
        if (this.kam != null) {
            this.kam.cQa();
        }
    }

    public void startPullRefresh() {
        this.gBw.setRefreshing(true);
    }

    public void bRI() {
        this.gBw.setRefreshing(false);
    }

    public void ir(boolean z) {
        if (!cqS()) {
            if (this.gJB == null) {
                this.gJB = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gJB.bCS();
                this.gJB.setTopMargin(height);
                this.gJB.onChangeSkinType();
            }
            this.gJB.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
        }
    }

    public boolean cqS() {
        if (this.gJB != null) {
            return this.gJB.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqT()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.kgr != null) {
                            HotTopicTabView.this.ir(false);
                            HotTopicTabView.this.kgr.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqT() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.gJB != null) {
                this.gJB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kgu != null) {
                this.kgu.notifyDataSetChanged();
            }
            if (this.gAw != null) {
                this.gAw.changeSkin(skinType);
                this.gAw.setContainerBackgroundColorResId(R.color.transparent);
            }
            if (this.kgv != null) {
                this.kgv.onChangeSkinType(skinType);
            }
            if (this.XW != null) {
                com.baidu.tbadk.core.elementsMaven.c.br(this.XW).setBackGroundColor(R.color.CAM_X0202);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.kal = scrollFragmentTabHost;
        if (this.kal != null) {
            this.kal.b(this.kam);
            this.kal.a(this.kam);
        }
    }

    public void destroy() {
        if (this.kal != null) {
            this.kal.b(this.kam);
        }
        bRI();
        hideLoadingView();
        WZ();
        this.hRx = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.kgr.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.ajq = fVar;
        if (this.kgu != null) {
            this.kgu.setOnItemCoverListener(fVar);
        }
        if (this.kgv != null) {
            this.kgv.setOnItemCoverListener(fVar);
        }
    }
}
