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
/* loaded from: classes16.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView Wu;
    private com.baidu.tbadk.h.f ahW;
    private PbListView fDW;
    private BdSwipeRefreshLayout fEV;
    private int fGp;
    private g fMN;
    private boolean gLX;
    ScrollFragmentTabHost.a iGA;
    private ScrollFragmentTabHost iGz;
    private TabLayout.OnTabSelectedListener iLj;
    private b iLm;
    private h iLp;
    private HotTopicHeaderView iLq;
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
        this.fGp = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.fGp != i && HotTopicTabView.this.iGz != null) {
                    HotTopicTabView.this.fGp = i;
                    if (HotTopicTabView.this.fGp == 1) {
                        HotTopicTabView.this.iGz.bGl();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.iGz.bGm();
                    } else {
                        HotTopicTabView.this.iGz.bGl();
                    }
                }
            }
        };
        this.iGA = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwO() {
                if (HotTopicTabView.this.iGz != null) {
                    HotTopicTabView.this.fGp = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.Wu)) {
                        HotTopicTabView.this.iGz.bGm();
                    } else {
                        HotTopicTabView.this.iGz.bGl();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bMg();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.fEV = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fEV.setProgressView(this.mPullView);
        this.Wu = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Wu.setLayoutManager(new LinearLayoutManager(context));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.iLp = new h(this.mPageContext, this.Wu);
        this.fDW = new PbListView(this.mPageContext.getPageActivity());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_g);
    }

    private void bMg() {
        this.Wu.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.iLj = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
            this.iGz.a(this.iGA);
            this.iGA.cwO();
        }
        if (this.gLX) {
            this.gLX = false;
            if (y.isEmpty(this.iLp.getData())) {
                this.iLm.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.iLp != null) {
            this.iLp.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.iLm = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cxC() {
        return (this.iLq == null || this.iLq.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.iLq == null) {
            this.iLq = new HotTopicHeaderView(getContext());
        }
        this.Wu.setHeaderView(this.iLq);
        this.iLq.setOnItemCoverListener(this.ahW);
        this.iLq.setOnTabSelectedListener(this.iLj);
        this.iLq.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<q> list) {
        this.iLp.setData(list);
    }

    public void bGS() {
        this.Wu.setNextPage(this.fDW);
        this.fDW.endLoadData();
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.ao(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cxD() {
        this.Wu.setNextPage(null);
    }

    public void reload() {
        this.Wu.setSelection(0);
        startPullRefresh();
        if (this.iGA != null) {
            this.iGA.cwO();
        }
    }

    public void startPullRefresh() {
        this.fEV.setRefreshing(true);
    }

    public void bGd() {
        this.fEV.setRefreshing(false);
    }

    public void gS(boolean z) {
        if (!cgv()) {
            if (this.fMN == null) {
                this.fMN = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.fMN.bsZ();
                this.fMN.setTopMargin(height);
                this.fMN.onChangeSkinType();
            }
            this.fMN.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this);
            this.fMN = null;
        }
    }

    public boolean cgv() {
        if (this.fMN != null) {
            return this.fMN.isViewAttached();
        }
        return false;
    }

    public void nK(boolean z) {
        if (!cgw()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.iLm != null) {
                            HotTopicTabView.this.gS(false);
                            HotTopicTabView.this.iLm.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cgw() {
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
            ap.setBackgroundColor(this.fEV, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_d);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.fMN != null) {
                this.fMN.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iLp != null) {
                this.iLp.notifyDataSetChanged();
            }
            if (this.fDW != null) {
                this.fDW.changeSkin(skinType);
                this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            if (this.iLq != null) {
                this.iLq.onChangeSkinType(skinType);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iGz = scrollFragmentTabHost;
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
            this.iGz.a(this.iGA);
        }
    }

    public void destroy() {
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
        }
        bGd();
        hideLoadingView();
        bFW();
        this.gLX = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.iLm.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.ahW = fVar;
        if (this.iLp != null) {
            this.iLp.setOnItemCoverListener(fVar);
        }
        if (this.iLq != null) {
            this.iLq.setOnItemCoverListener(fVar);
        }
    }
}
