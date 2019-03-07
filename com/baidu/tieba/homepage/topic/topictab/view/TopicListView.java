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
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Qq;
    private g cXq;
    private int dbB;
    private BdSwipeRefreshLayout ddF;
    private NoNetworkView.a emQ;
    private ScrollFragmentTabHost fKU;
    ScrollFragmentTabHost.a fKV;
    private com.baidu.tieba.homepage.topic.topictab.a fQd;
    private com.baidu.tieba.homepage.topic.topictab.a.b fQm;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public TopicListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.emQ = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && TopicListView.this.fQd != null) {
                    TopicListView.this.fQd.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            private int dcL = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcL != i && TopicListView.this.fKU != null) {
                    this.dcL = i;
                    if (this.dcL == 1) {
                        TopicListView.this.fKU.aBE();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.fKU.aBF();
                    } else {
                        TopicListView.this.fKU.aBE();
                    }
                }
            }
        };
        this.fKV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bml() {
                if (TopicListView.this.fKU != null) {
                    if (TopicListView.this.a(TopicListView.this.Qq)) {
                        TopicListView.this.fKU.aBF();
                    } else {
                        TopicListView.this.fKU.aBE();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.fragment_topic_list_layout, (ViewGroup) this, true);
        this.ddF = (BdSwipeRefreshLayout) findViewById(d.g.topic_refresh_layout);
        ((FrameLayout.LayoutParams) this.ddF.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mPullView = new i(this.mPageContext);
        this.ddF.setProgressView(this.mPullView);
        this.Qq = (BdTypeRecyclerView) findViewById(d.g.topic_list_view);
        this.Qq.setLayoutManager(new LinearLayoutManager(context));
        this.Qq.setFadingEdgeLength(0);
        this.Qq.setOverScrollMode(2);
        this.fQm = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Qq);
        this.Qq.addOnScrollListener(this.mOnScrollListener);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fQm != null) {
            this.fQm.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.fQd = aVar;
    }

    public void setData(List<m> list) {
        if (!v.T(list)) {
            this.fQm.setData(list);
        }
    }

    public void reload() {
        this.Qq.setSelection(0);
        startPullRefresh();
        if (this.fKV != null) {
            this.fKV.bml();
        }
    }

    public void aCt() {
        this.fQm.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.ddF.setRefreshing(true);
    }

    public void aBM() {
        this.ddF.setRefreshing(false);
    }

    public void aOA() {
        if (this.Qq != null) {
            this.Qq.setVisibility(0);
        }
    }

    public void cE(boolean z) {
        if (!aXq()) {
            if (this.cXq == null) {
                this.cXq = new g(getContext());
                this.cXq.onChangeSkinType();
            }
            this.cXq.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.cXq != null) {
            this.cXq.dettachView(this);
            this.cXq = null;
        }
    }

    public boolean aXq() {
        if (this.cXq != null) {
            return this.cXq.isViewAttached();
        }
        return false;
    }

    public void iD(boolean z) {
        if (!aXr()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && TopicListView.this.fQd != null) {
                            TopicListView.this.Qq.setVisibility(0);
                            TopicListView.this.fQd.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.jS(this.dbB);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.anC();
            this.Qq.setVisibility(8);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dbB = i;
    }

    public void aBt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aXr() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0236d.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.ic(skinType);
            }
            if (this.cXq != null) {
                this.cXq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fQm != null) {
                this.fQm.notifyDataSetChanged();
            }
            al.l(this.ddF, d.C0236d.cp_bg_line_e);
            al.l(this.Qq, d.C0236d.cp_bg_line_d);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fKU = scrollFragmentTabHost;
        if (this.fKU != null) {
            this.fKU.b(this.fKV);
            this.fKU.a(this.fKV);
        }
    }

    public void destroy() {
        this.Qq.removeOnScrollListener(this.mOnScrollListener);
        if (this.fKU != null) {
            this.fKU.b(this.fKV);
        }
        aBM();
        hideLoadingView();
        aBt();
    }
}
