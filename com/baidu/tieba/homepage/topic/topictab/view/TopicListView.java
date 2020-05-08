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
    private BdTypeRecyclerView Vi;
    private PbListView ePr;
    private BdSwipeRefreshLayout eQo;
    private int eRI;
    private g eYg;
    private NoNetworkView.a gGr;
    private ScrollFragmentTabHost hIk;
    ScrollFragmentTabHost.a hIl;
    private com.baidu.tieba.homepage.topic.topictab.a.b hTB;
    private com.baidu.tieba.homepage.topic.topictab.a hTo;
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
        this.eRI = -1;
        this.gGr = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.hTo != null) {
                    TopicListView.this.hTo.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.eRI != i && TopicListView.this.hIk != null) {
                    TopicListView.this.eRI = i;
                    if (TopicListView.this.eRI == 1) {
                        TopicListView.this.hIk.blG();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.hIk.blH();
                    } else {
                        TopicListView.this.hIk.blG();
                    }
                }
            }
        };
        this.hIl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bYC() {
                if (TopicListView.this.hIk != null) {
                    TopicListView.this.eRI = -1;
                    if (TopicListView.this.a(TopicListView.this.Vi)) {
                        TopicListView.this.hIk.blH();
                    } else {
                        TopicListView.this.hIk.blG();
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
        this.eQo = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.eQo.setProgressView(this.mPullView);
        this.Vi = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.Vi.setLayoutManager(new LinearLayoutManager(context));
        this.Vi.setFadingEdgeLength(0);
        this.Vi.setOverScrollMode(2);
        this.hTB = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Vi);
        this.ePr = new PbListView(this.mPageContext.getPageActivity());
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void bqI() {
        this.Vi.removeOnScrollListener(this.mOnScrollListener);
        this.Vi.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.hIk != null) {
            this.hIk.b(this.hIl);
            this.hIk.a(this.hIl);
            this.hIl.bYC();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hTB != null) {
            this.hTB.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.hTo = aVar;
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.hTB.setData(list);
        }
    }

    public void bmn() {
        this.Vi.setNextPage(this.ePr);
        this.ePr.endLoadData();
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.ePr.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Vi.setSelection(0);
        startPullRefresh();
        if (this.hIl != null) {
            this.hIl.bYC();
        }
    }

    public void bml() {
        this.hTB.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.eQo.setRefreshing(true);
    }

    public void blx() {
        this.eQo.setRefreshing(false);
    }

    public void bpT() {
        if (this.Vi != null) {
            this.Vi.setVisibility(0);
        }
    }

    public void fK(boolean z) {
        if (!bJr()) {
            if (this.eYg == null) {
                this.eYg = new com.baidu.tbadk.k.g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.eYg.aYn();
                this.eYg.setTopMargin(height);
                this.eYg.onChangeSkinType();
            }
            this.eYg.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this);
            this.eYg = null;
        }
    }

    public boolean bJr() {
        if (this.eYg != null) {
            return this.eYg.isViewAttached();
        }
        return false;
    }

    public void lV(boolean z) {
        if (!bJs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.hTo != null) {
                            TopicListView.this.Vi.setVisibility(0);
                            TopicListView.this.hTo.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Vi.setVisibility(8);
        }
    }

    public void blr() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bJs() {
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
            if (this.eYg != null) {
                this.eYg.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hTB != null) {
                this.hTB.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.eQo, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Vi, R.color.cp_bg_line_d);
            if (this.ePr != null) {
                this.ePr.changeSkin(skinType);
                this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hIk = scrollFragmentTabHost;
        if (this.hIk != null) {
            this.hIk.b(this.hIl);
            this.hIk.a(this.hIl);
        }
    }

    public void destroy() {
        if (this.hIk != null) {
            this.hIk.b(this.hIl);
        }
        this.Vi.removeOnScrollListener(this.mOnScrollListener);
        blx();
        hideLoadingView();
        blr();
    }
}
