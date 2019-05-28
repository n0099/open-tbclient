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
import com.baidu.tbadk.core.util.al;
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
    private BdTypeRecyclerView NZ;
    private g dhY;
    private PbListView dlY;
    private int dnp;
    private BdSwipeRefreshLayout doj;
    private NoNetworkView.a eCl;
    private ScrollFragmentTabHost fXb;
    ScrollFragmentTabHost.a fXc;
    private com.baidu.tieba.homepage.topic.topictab.a gha;
    private com.baidu.tieba.homepage.topic.topictab.a.b ghn;
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
        this.dnp = -1;
        this.eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                if (z && TopicListView.this.gha != null) {
                    TopicListView.this.gha.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.dnp != i && TopicListView.this.fXb != null) {
                    TopicListView.this.dnp = i;
                    if (TopicListView.this.dnp == 1) {
                        TopicListView.this.fXb.aHU();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.fXb.aHV();
                    } else {
                        TopicListView.this.fXb.aHU();
                    }
                }
            }
        };
        this.fXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btI() {
                if (TopicListView.this.fXb != null) {
                    TopicListView.this.dnp = -1;
                    if (TopicListView.this.a(TopicListView.this.NZ)) {
                        TopicListView.this.fXb.aHV();
                    } else {
                        TopicListView.this.fXb.aHU();
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
        this.doj = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.doj.setProgressView(this.mPullView);
        this.NZ = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.NZ.setLayoutManager(new LinearLayoutManager(context));
        this.NZ.setFadingEdgeLength(0);
        this.NZ.setOverScrollMode(2);
        this.ghn = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.NZ);
        this.dlY = new PbListView(this.mPageContext.getPageActivity());
        this.dlY.nG();
        this.dlY.iO(R.color.cp_bg_line_e);
    }

    public void bnS() {
        this.NZ.removeOnScrollListener(this.mOnScrollListener);
        this.NZ.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.fXb != null) {
            this.fXb.b(this.fXc);
            this.fXb.a(this.fXc);
            this.fXc.btI();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ghn != null) {
            this.ghn.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.gha = aVar;
    }

    public void setData(List<m> list) {
        if (!v.aa(list)) {
            this.ghn.setData(list);
        }
    }

    public void aII() {
        this.NZ.setNextPage(this.dlY);
        this.dlY.ajz();
        this.dlY.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlY.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.dlY.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.NZ.setSelection(0);
        startPullRefresh();
        if (this.fXc != null) {
            this.fXc.btI();
        }
    }

    public void aIG() {
        this.ghn.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.doj.setRefreshing(true);
    }

    public void aIc() {
        this.doj.setRefreshing(false);
    }

    public void aUH() {
        if (this.NZ != null) {
            this.NZ.setVisibility(0);
        }
    }

    public void cV(boolean z) {
        if (!beF()) {
            if (this.dhY == null) {
                this.dhY = new g(getContext());
                this.dhY.onChangeSkinType();
            }
            this.dhY.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dhY != null) {
            this.dhY.dettachView(this);
            this.dhY = null;
        }
    }

    public boolean beF() {
        if (this.dhY != null) {
            return this.dhY.isViewAttached();
        }
        return false;
    }

    public void jk(boolean z) {
        if (!beG()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG() && TopicListView.this.gha != null) {
                            TopicListView.this.NZ.setVisibility(0);
                            TopicListView.this.gha.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.asB();
            this.NZ.setVisibility(8);
        }
    }

    public void aHK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean beG() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.iP(skinType);
            }
            if (this.dhY != null) {
                this.dhY.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.ghn != null) {
                this.ghn.notifyDataSetChanged();
            }
            al.l(this.doj, R.color.cp_bg_line_e);
            al.l(this.NZ, R.color.cp_bg_line_d);
            if (this.dlY != null) {
                this.dlY.iP(skinType);
                this.dlY.iO(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fXb = scrollFragmentTabHost;
        if (this.fXb != null) {
            this.fXb.b(this.fXc);
            this.fXb.a(this.fXc);
        }
    }

    public void destroy() {
        if (this.fXb != null) {
            this.fXb.b(this.fXc);
        }
        this.NZ.removeOnScrollListener(this.mOnScrollListener);
        aIc();
        hideLoadingView();
        aHK();
    }
}
