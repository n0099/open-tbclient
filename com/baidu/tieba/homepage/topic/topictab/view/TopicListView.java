package com.baidu.tieba.homepage.topic.topictab.view;

import android.content.Context;
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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes9.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView BK;
    private PbListView elj;
    private BdSwipeRefreshLayout emf;
    private int enB;
    private g etX;
    private NoNetworkView.a fYL;
    private ScrollFragmentTabHost gWU;
    ScrollFragmentTabHost.a gWV;
    private com.baidu.tieba.homepage.topic.topictab.a hhM;
    private com.baidu.tieba.homepage.topic.topictab.a.b hhZ;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public TopicListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.enB = -1;
        this.fYL = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.hhM != null) {
                    TopicListView.this.hhM.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.enB != i && TopicListView.this.gWU != null) {
                    TopicListView.this.enB = i;
                    if (TopicListView.this.enB == 1) {
                        TopicListView.this.gWU.bcM();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.gWU.bcN();
                    } else {
                        TopicListView.this.gWU.bcM();
                    }
                }
            }
        };
        this.gWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNO() {
                if (TopicListView.this.gWU != null) {
                    TopicListView.this.enB = -1;
                    if (TopicListView.this.a(TopicListView.this.BK)) {
                        TopicListView.this.gWU.bcN();
                    } else {
                        TopicListView.this.gWU.bcM();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_topic_list_layout, (ViewGroup) this, true);
        this.emf = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.emf.setProgressView(this.mPullView);
        this.BK = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.BK.setLayoutManager(new LinearLayoutManager(context));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.hhZ = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.BK);
        this.elj = new PbListView(this.mPageContext.getPageActivity());
        this.elj.createView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void initListeners() {
        this.BK.removeOnScrollListener(this.mOnScrollListener);
        this.BK.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.gWU != null) {
            this.gWU.b(this.gWV);
            this.gWU.a(this.gWV);
            this.gWV.bNO();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hhZ != null) {
            this.hhZ.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.hhM = aVar;
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.hhZ.setData(list);
        }
    }

    public void bds() {
        this.BK.setNextPage(this.elj);
        this.elj.endLoadData();
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.elj.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.BK.setSelection(0);
        startPullRefresh();
        if (this.gWV != null) {
            this.gWV.bNO();
        }
    }

    public void bdq() {
        this.hhZ.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.emf.setRefreshing(true);
    }

    public void bcD() {
        this.emf.setRefreshing(false);
    }

    public void bgy() {
        if (this.BK != null) {
            this.BK.setVisibility(0);
        }
    }

    public void eM(boolean z) {
        if (!bzk()) {
            if (this.etX == null) {
                this.etX = new com.baidu.tbadk.k.g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.etX.aPT();
                this.etX.setTopMargin(height);
                this.etX.onChangeSkinType();
            }
            this.etX.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this);
            this.etX = null;
        }
    }

    public boolean bzk() {
        if (this.etX != null) {
            return this.etX.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzl()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.hhM != null) {
                            TopicListView.this.BK.setVisibility(0);
                            TopicListView.this.hhM.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.BK.setVisibility(8);
        }
    }

    public void bcx() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzl() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.etX != null) {
                this.etX.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hhZ != null) {
                this.hhZ.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.emf, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.BK, R.color.cp_bg_line_d);
            if (this.elj != null) {
                this.elj.changeSkin(skinType);
                this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gWU = scrollFragmentTabHost;
        if (this.gWU != null) {
            this.gWU.b(this.gWV);
            this.gWU.a(this.gWV);
        }
    }

    public void destroy() {
        if (this.gWU != null) {
            this.gWU.b(this.gWV);
        }
        this.BK.removeOnScrollListener(this.mOnScrollListener);
        bcD();
        hideLoadingView();
        bcx();
    }
}
