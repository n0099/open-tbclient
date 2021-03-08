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
    private BdTypeRecyclerView Zq;
    private com.baidu.tbadk.h.f akI;
    private PbListView gCf;
    private BdSwipeRefreshLayout gDf;
    private int gEG;
    private g gLk;
    private boolean hTg;
    private ScrollFragmentTabHost kcn;
    ScrollFragmentTabHost.a kco;
    private TabLayout.OnTabSelectedListener kir;
    private b kiu;
    private h kix;
    private HotTopicHeaderView kiy;
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
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.gEG != i && HotTopicTabView.this.kcn != null) {
                    HotTopicTabView.this.gEG = i;
                    if (HotTopicTabView.this.gEG == 1) {
                        HotTopicTabView.this.kcn.bRW();
                    } else if (HotTopicTabView.this.c(recyclerView)) {
                        HotTopicTabView.this.kcn.bRX();
                    } else {
                        HotTopicTabView.this.kcn.bRW();
                    }
                }
            }
        };
        this.kco = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cQh() {
                if (HotTopicTabView.this.kcn != null) {
                    HotTopicTabView.this.gEG = -1;
                    if (HotTopicTabView.this.c(HotTopicTabView.this.Zq)) {
                        HotTopicTabView.this.kcn.bRX();
                    } else {
                        HotTopicTabView.this.kcn.bRW();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bZr();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.gDf = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gDf.setProgressView(this.mPullView);
        this.Zq = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Zq.setLayoutManager(new LinearLayoutManager(context));
        this.Zq.setFadingEdgeLength(0);
        this.Zq.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Zq.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.kix = new h(this.mPageContext, this.Zq);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0111);
    }

    private void bZr() {
        this.Zq.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.kir = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.kcn != null) {
            this.kcn.b(this.kco);
            this.kcn.a(this.kco);
            this.kco.cQh();
        }
        if (this.hTg) {
            this.hTg = false;
            if (y.isEmpty(this.kix.getData())) {
                this.kiu.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.kix != null) {
            this.kix.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.kiu = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cQV() {
        return (this.kiy == null || this.kiy.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.kiy == null) {
            this.kiy = new HotTopicHeaderView(getContext());
        }
        this.Zq.setHeaderView(this.kiy);
        this.kiy.setOnItemCoverListener(this.akI);
        this.kiy.setOnTabSelectedListener(this.kir);
        this.kiy.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<n> list) {
        this.kix.setData(list);
    }

    public void Xb() {
        this.Zq.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setText(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cQW() {
        this.Zq.setNextPage(null);
    }

    public void reload() {
        this.Zq.setSelection(0);
        startPullRefresh();
        if (this.kco != null) {
            this.kco.cQh();
        }
    }

    public void startPullRefresh() {
        this.gDf.setRefreshing(true);
    }

    public void bRO() {
        this.gDf.setRefreshing(false);
    }

    public void ir(boolean z) {
        if (!cqY()) {
            if (this.gLk == null) {
                this.gLk = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gLk.bCV();
                this.gLk.setTopMargin(height);
                this.gLk.onChangeSkinType();
            }
            this.gLk.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
            this.gLk = null;
        }
    }

    public boolean cqY() {
        if (this.gLk != null) {
            return this.gLk.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqZ()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.kiu != null) {
                            HotTopicTabView.this.ir(false);
                            HotTopicTabView.this.kiu.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqZ() {
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
            if (this.gLk != null) {
                this.gLk.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kix != null) {
                this.kix.notifyDataSetChanged();
            }
            if (this.gCf != null) {
                this.gCf.changeSkin(skinType);
                this.gCf.setContainerBackgroundColorResId(R.color.transparent);
            }
            if (this.kiy != null) {
                this.kiy.onChangeSkinType(skinType);
            }
            if (this.Zq != null) {
                com.baidu.tbadk.core.elementsMaven.c.br(this.Zq).setBackGroundColor(R.color.CAM_X0202);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.kcn = scrollFragmentTabHost;
        if (this.kcn != null) {
            this.kcn.b(this.kco);
            this.kcn.a(this.kco);
        }
    }

    public void destroy() {
        if (this.kcn != null) {
            this.kcn.b(this.kco);
        }
        bRO();
        hideLoadingView();
        Xc();
        this.hTg = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.kiu.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.akI = fVar;
        if (this.kix != null) {
            this.kix.setOnItemCoverListener(fVar);
        }
        if (this.kiy != null) {
            this.kiy.setOnItemCoverListener(fVar);
        }
    }
}
