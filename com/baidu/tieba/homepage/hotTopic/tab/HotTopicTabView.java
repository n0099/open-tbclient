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
    private PbListView gAi;
    private BdSwipeRefreshLayout gBi;
    private int gCJ;
    private g gJn;
    private boolean hRj;
    private ScrollFragmentTabHost jZX;
    ScrollFragmentTabHost.a jZY;
    private TabLayout.OnTabSelectedListener kga;
    private b kgd;
    private h kgg;
    private HotTopicHeaderView kgh;
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
        this.gCJ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.gCJ != i && HotTopicTabView.this.jZX != null) {
                    HotTopicTabView.this.gCJ = i;
                    if (HotTopicTabView.this.gCJ == 1) {
                        HotTopicTabView.this.jZX.bRJ();
                    } else if (HotTopicTabView.this.c(recyclerView)) {
                        HotTopicTabView.this.jZX.bRK();
                    } else {
                        HotTopicTabView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.jZY = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cPT() {
                if (HotTopicTabView.this.jZX != null) {
                    HotTopicTabView.this.gCJ = -1;
                    if (HotTopicTabView.this.c(HotTopicTabView.this.XW)) {
                        HotTopicTabView.this.jZX.bRK();
                    } else {
                        HotTopicTabView.this.jZX.bRJ();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bZe();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.gBi = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gBi.setProgressView(this.mPullView);
        this.XW = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.XW.setLayoutManager(new LinearLayoutManager(context));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.XW.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.kgg = new h(this.mPageContext, this.XW);
        this.gAi = new PbListView(this.mPageContext.getPageActivity());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0111);
    }

    private void bZe() {
        this.XW.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.kga = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
            this.jZX.a(this.jZY);
            this.jZY.cPT();
        }
        if (this.hRj) {
            this.hRj = false;
            if (y.isEmpty(this.kgg.getData())) {
                this.kgd.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.kgg != null) {
            this.kgg.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.kgd = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cQH() {
        return (this.kgh == null || this.kgh.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.kgh == null) {
            this.kgh = new HotTopicHeaderView(getContext());
        }
        this.XW.setHeaderView(this.kgh);
        this.kgh.setOnItemCoverListener(this.ajq);
        this.kgh.setOnTabSelectedListener(this.kga);
        this.kgh.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<n> list) {
        this.kgg.setData(list);
    }

    public void WY() {
        this.XW.setNextPage(this.gAi);
        this.gAi.endLoadData();
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.av(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cQI() {
        this.XW.setNextPage(null);
    }

    public void reload() {
        this.XW.setSelection(0);
        startPullRefresh();
        if (this.jZY != null) {
            this.jZY.cPT();
        }
    }

    public void startPullRefresh() {
        this.gBi.setRefreshing(true);
    }

    public void bRB() {
        this.gBi.setRefreshing(false);
    }

    public void ir(boolean z) {
        if (!cqL()) {
            if (this.gJn == null) {
                this.gJn = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gJn.bCS();
                this.gJn.setTopMargin(height);
                this.gJn.onChangeSkinType();
            }
            this.gJn.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this);
            this.gJn = null;
        }
    }

    public boolean cqL() {
        if (this.gJn != null) {
            return this.gJn.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.kgd != null) {
                            HotTopicTabView.this.ir(false);
                            HotTopicTabView.this.kgd.loadData();
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

    public boolean cqM() {
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
            if (this.gJn != null) {
                this.gJn.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kgg != null) {
                this.kgg.notifyDataSetChanged();
            }
            if (this.gAi != null) {
                this.gAi.changeSkin(skinType);
                this.gAi.setContainerBackgroundColorResId(R.color.transparent);
            }
            if (this.kgh != null) {
                this.kgh.onChangeSkinType(skinType);
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
        this.jZX = scrollFragmentTabHost;
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
            this.jZX.a(this.jZY);
        }
    }

    public void destroy() {
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
        }
        bRB();
        hideLoadingView();
        WZ();
        this.hRj = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.kgd.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.ajq = fVar;
        if (this.kgg != null) {
            this.kgg.setOnItemCoverListener(fVar);
        }
        if (this.kgh != null) {
            this.kgh.setOnItemCoverListener(fVar);
        }
    }
}
