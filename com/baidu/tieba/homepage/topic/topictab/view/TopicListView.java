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
    private BdTypeRecyclerView Qr;
    private g cXm;
    private int dbx;
    private BdSwipeRefreshLayout ddB;
    private NoNetworkView.a emM;
    private ScrollFragmentTabHost fKT;
    ScrollFragmentTabHost.a fKU;
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
        this.emM = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && TopicListView.this.fQd != null) {
                    TopicListView.this.fQd.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            private int dcH = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcH != i && TopicListView.this.fKT != null) {
                    this.dcH = i;
                    if (this.dcH == 1) {
                        TopicListView.this.fKT.aBE();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.fKT.aBF();
                    } else {
                        TopicListView.this.fKT.aBE();
                    }
                }
            }
        };
        this.fKU = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bml() {
                if (TopicListView.this.fKT != null) {
                    if (TopicListView.this.a(TopicListView.this.Qr)) {
                        TopicListView.this.fKT.aBF();
                    } else {
                        TopicListView.this.fKT.aBE();
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
        this.ddB = (BdSwipeRefreshLayout) findViewById(d.g.topic_refresh_layout);
        ((FrameLayout.LayoutParams) this.ddB.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mPullView = new i(this.mPageContext);
        this.ddB.setProgressView(this.mPullView);
        this.Qr = (BdTypeRecyclerView) findViewById(d.g.topic_list_view);
        this.Qr.setLayoutManager(new LinearLayoutManager(context));
        this.Qr.setFadingEdgeLength(0);
        this.Qr.setOverScrollMode(2);
        this.fQm = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Qr);
        this.Qr.addOnScrollListener(this.mOnScrollListener);
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
        this.Qr.setSelection(0);
        startPullRefresh();
        if (this.fKU != null) {
            this.fKU.bml();
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
        this.ddB.setRefreshing(true);
    }

    public void aBM() {
        this.ddB.setRefreshing(false);
    }

    public void aOA() {
        if (this.Qr != null) {
            this.Qr.setVisibility(0);
        }
    }

    public void cE(boolean z) {
        if (!aXq()) {
            if (this.cXm == null) {
                this.cXm = new g(getContext());
                this.cXm.onChangeSkinType();
            }
            this.cXm.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.cXm != null) {
            this.cXm.dettachView(this);
            this.cXm = null;
        }
    }

    public boolean aXq() {
        if (this.cXm != null) {
            return this.cXm.isViewAttached();
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
                            TopicListView.this.Qr.setVisibility(0);
                            TopicListView.this.fQd.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.jS(this.dbx);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.anB();
            this.Qr.setVisibility(8);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dbx = i;
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
            al.l(this, d.C0277d.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.ic(skinType);
            }
            if (this.cXm != null) {
                this.cXm.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fQm != null) {
                this.fQm.notifyDataSetChanged();
            }
            al.l(this.ddB, d.C0277d.cp_bg_line_e);
            al.l(this.Qr, d.C0277d.cp_bg_line_d);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fKT = scrollFragmentTabHost;
        if (this.fKT != null) {
            this.fKT.b(this.fKU);
            this.fKT.a(this.fKU);
        }
    }

    public void destroy() {
        this.Qr.removeOnScrollListener(this.mOnScrollListener);
        if (this.fKT != null) {
            this.fKT.b(this.fKU);
        }
        aBM();
        hideLoadingView();
        aBt();
    }
}
