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
    private g cXq;
    private int dbC;
    private BdSwipeRefreshLayout ddG;
    private NoNetworkView.a emz;
    private ScrollFragmentTabHost fKH;
    ScrollFragmentTabHost.a fKI;
    private com.baidu.tieba.homepage.topic.topictab.a fPR;
    private com.baidu.tieba.homepage.topic.topictab.a.b fQa;
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
        this.emz = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && TopicListView.this.fPR != null) {
                    TopicListView.this.fPR.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            private int dcM = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcM != i && TopicListView.this.fKH != null) {
                    this.dcM = i;
                    if (this.dcM == 1) {
                        TopicListView.this.fKH.aBB();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.fKH.aBC();
                    } else {
                        TopicListView.this.fKH.aBB();
                    }
                }
            }
        };
        this.fKI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bmi() {
                if (TopicListView.this.fKH != null) {
                    if (TopicListView.this.a(TopicListView.this.Qr)) {
                        TopicListView.this.fKH.aBC();
                    } else {
                        TopicListView.this.fKH.aBB();
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
        this.ddG = (BdSwipeRefreshLayout) findViewById(d.g.topic_refresh_layout);
        ((FrameLayout.LayoutParams) this.ddG.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mPullView = new i(this.mPageContext);
        this.ddG.setProgressView(this.mPullView);
        this.Qr = (BdTypeRecyclerView) findViewById(d.g.topic_list_view);
        this.Qr.setLayoutManager(new LinearLayoutManager(context));
        this.Qr.setFadingEdgeLength(0);
        this.Qr.setOverScrollMode(2);
        this.fQa = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Qr);
        this.Qr.addOnScrollListener(this.mOnScrollListener);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fQa != null) {
            this.fQa.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.fPR = aVar;
    }

    public void setData(List<m> list) {
        if (!v.T(list)) {
            this.fQa.setData(list);
        }
    }

    public void reload() {
        this.Qr.setSelection(0);
        startPullRefresh();
        if (this.fKI != null) {
            this.fKI.bmi();
        }
    }

    public void aCq() {
        this.fQa.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.ddG.setRefreshing(true);
    }

    public void aBJ() {
        this.ddG.setRefreshing(false);
    }

    public void aOs() {
        if (this.Qr != null) {
            this.Qr.setVisibility(0);
        }
    }

    public void cE(boolean z) {
        if (!aXo()) {
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

    public boolean aXo() {
        if (this.cXq != null) {
            return this.cXq.isViewAttached();
        }
        return false;
    }

    public void iD(boolean z) {
        if (!aXp()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && TopicListView.this.fPR != null) {
                            TopicListView.this.Qr.setVisibility(0);
                            TopicListView.this.fPR.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.jR(this.dbC);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.any();
            this.Qr.setVisibility(8);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dbC = i;
    }

    public void aBq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aXp() {
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
                this.mPullView.ib(skinType);
            }
            if (this.cXq != null) {
                this.cXq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fQa != null) {
                this.fQa.notifyDataSetChanged();
            }
            al.l(this.ddG, d.C0277d.cp_bg_line_e);
            al.l(this.Qr, d.C0277d.cp_bg_line_d);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fKH = scrollFragmentTabHost;
        if (this.fKH != null) {
            this.fKH.b(this.fKI);
            this.fKH.a(this.fKI);
        }
    }

    public void destroy() {
        this.Qr.removeOnScrollListener(this.mOnScrollListener);
        if (this.fKH != null) {
            this.fKH.b(this.fKI);
        }
        aBJ();
        hideLoadingView();
        aBq();
    }
}
