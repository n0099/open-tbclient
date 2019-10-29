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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicListView extends FrameLayout {
    private g dEq;
    private PbListView dwJ;
    private int dyr;
    private BdSwipeRefreshLayout dzt;
    private NoNetworkView.a eRC;
    private ScrollFragmentTabHost gee;
    ScrollFragmentTabHost.a gef;
    private com.baidu.tieba.homepage.topic.topictab.a.b gpK;
    private com.baidu.tieba.homepage.topic.topictab.a gpx;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private int mSkinType;
    private BdTypeRecyclerView zj;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public TopicListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.dyr = -1;
        this.eRC = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.gpx != null) {
                    TopicListView.this.gpx.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.dyr != i && TopicListView.this.gee != null) {
                    TopicListView.this.dyr = i;
                    if (TopicListView.this.dyr == 1) {
                        TopicListView.this.gee.aJA();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.gee.aJB();
                    } else {
                        TopicListView.this.gee.aJA();
                    }
                }
            }
        };
        this.gef = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btS() {
                if (TopicListView.this.gee != null) {
                    TopicListView.this.dyr = -1;
                    if (TopicListView.this.a(TopicListView.this.zj)) {
                        TopicListView.this.gee.aJB();
                    } else {
                        TopicListView.this.gee.aJA();
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
        this.dzt = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.dzt.setProgressView(this.mPullView);
        this.zj = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.zj.setLayoutManager(new LinearLayoutManager(context));
        this.zj.setFadingEdgeLength(0);
        this.zj.setOverScrollMode(2);
        this.gpK = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.zj);
        this.dwJ = new PbListView(this.mPageContext.getPageActivity());
        this.dwJ.createView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void aNd() {
        this.zj.removeOnScrollListener(this.mOnScrollListener);
        this.zj.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.gee != null) {
            this.gee.b(this.gef);
            this.gee.a(this.gef);
            this.gef.btS();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gpK != null) {
            this.gpK.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.gpx = aVar;
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.gpK.setData(list);
        }
    }

    public void aKj() {
        this.zj.setNextPage(this.dwJ);
        this.dwJ.endLoadData();
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.dwJ.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.zj.setSelection(0);
        startPullRefresh();
        if (this.gef != null) {
            this.gef.btS();
        }
    }

    public void aKh() {
        this.gpK.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.dzt.setRefreshing(true);
    }

    public void aJH() {
        this.dzt.setRefreshing(false);
    }

    public void aMq() {
        if (this.zj != null) {
            this.zj.setVisibility(0);
        }
    }

    public void dp(boolean z) {
        if (!bfl()) {
            if (this.dEq == null) {
                this.dEq = new g(getContext());
                this.dEq.onChangeSkinType();
            }
            this.dEq.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dEq != null) {
            this.dEq.dettachView(this);
            this.dEq = null;
        }
    }

    public boolean bfl() {
        if (this.dEq != null) {
            return this.dEq.isViewAttached();
        }
        return false;
    }

    public void jm(boolean z) {
        if (!bfm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.gpx != null) {
                            TopicListView.this.zj.setVisibility(0);
                            TopicListView.this.gpx.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.zj.setVisibility(8);
        }
    }

    public void aJo() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bfm() {
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
            if (this.dEq != null) {
                this.dEq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gpK != null) {
                this.gpK.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.dzt, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.zj, R.color.cp_bg_line_d);
            if (this.dwJ != null) {
                this.dwJ.changeSkin(skinType);
                this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gee = scrollFragmentTabHost;
        if (this.gee != null) {
            this.gee.b(this.gef);
            this.gee.a(this.gef);
        }
    }

    public void destroy() {
        if (this.gee != null) {
            this.gee.b(this.gef);
        }
        this.zj.removeOnScrollListener(this.mOnScrollListener);
        aJH();
        hideLoadingView();
        aJo();
    }
}
