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
    private g dhX;
    private PbListView dlX;
    private int dno;
    private BdSwipeRefreshLayout doi;
    private NoNetworkView.a eCk;
    private ScrollFragmentTabHost fXa;
    ScrollFragmentTabHost.a fXb;
    private com.baidu.tieba.homepage.topic.topictab.a ggZ;
    private com.baidu.tieba.homepage.topic.topictab.a.b ghm;
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
        this.dno = -1;
        this.eCk = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                if (z && TopicListView.this.ggZ != null) {
                    TopicListView.this.ggZ.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.dno != i && TopicListView.this.fXa != null) {
                    TopicListView.this.dno = i;
                    if (TopicListView.this.dno == 1) {
                        TopicListView.this.fXa.aHR();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.fXa.aHS();
                    } else {
                        TopicListView.this.fXa.aHR();
                    }
                }
            }
        };
        this.fXb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btF() {
                if (TopicListView.this.fXa != null) {
                    TopicListView.this.dno = -1;
                    if (TopicListView.this.a(TopicListView.this.NZ)) {
                        TopicListView.this.fXa.aHS();
                    } else {
                        TopicListView.this.fXa.aHR();
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
        this.doi = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.doi.setProgressView(this.mPullView);
        this.NZ = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.NZ.setLayoutManager(new LinearLayoutManager(context));
        this.NZ.setFadingEdgeLength(0);
        this.NZ.setOverScrollMode(2);
        this.ghm = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.NZ);
        this.dlX = new PbListView(this.mPageContext.getPageActivity());
        this.dlX.nG();
        this.dlX.iO(R.color.cp_bg_line_e);
    }

    public void bnP() {
        this.NZ.removeOnScrollListener(this.mOnScrollListener);
        this.NZ.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.fXa != null) {
            this.fXa.b(this.fXb);
            this.fXa.a(this.fXb);
            this.fXb.btF();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ghm != null) {
            this.ghm.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.ggZ = aVar;
    }

    public void setData(List<m> list) {
        if (!v.aa(list)) {
            this.ghm.setData(list);
        }
    }

    public void aIF() {
        this.NZ.setNextPage(this.dlX);
        this.dlX.ajz();
        this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlX.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.dlX.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.NZ.setSelection(0);
        startPullRefresh();
        if (this.fXb != null) {
            this.fXb.btF();
        }
    }

    public void aID() {
        this.ghm.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.doi.setRefreshing(true);
    }

    public void aHZ() {
        this.doi.setRefreshing(false);
    }

    public void aUE() {
        if (this.NZ != null) {
            this.NZ.setVisibility(0);
        }
    }

    public void cV(boolean z) {
        if (!beC()) {
            if (this.dhX == null) {
                this.dhX = new g(getContext());
                this.dhX.onChangeSkinType();
            }
            this.dhX.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dhX != null) {
            this.dhX.dettachView(this);
            this.dhX = null;
        }
    }

    public boolean beC() {
        if (this.dhX != null) {
            return this.dhX.isViewAttached();
        }
        return false;
    }

    public void jk(boolean z) {
        if (!beD()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG() && TopicListView.this.ggZ != null) {
                            TopicListView.this.NZ.setVisibility(0);
                            TopicListView.this.ggZ.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.asB();
            this.NZ.setVisibility(8);
        }
    }

    public void aHH() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean beD() {
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
            if (this.dhX != null) {
                this.dhX.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.ghm != null) {
                this.ghm.notifyDataSetChanged();
            }
            al.l(this.doi, R.color.cp_bg_line_e);
            al.l(this.NZ, R.color.cp_bg_line_d);
            if (this.dlX != null) {
                this.dlX.iP(skinType);
                this.dlX.iO(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fXa = scrollFragmentTabHost;
        if (this.fXa != null) {
            this.fXa.b(this.fXb);
            this.fXa.a(this.fXb);
        }
    }

    public void destroy() {
        if (this.fXa != null) {
            this.fXa.b(this.fXb);
        }
        this.NZ.removeOnScrollListener(this.mOnScrollListener);
        aHZ();
        hideLoadingView();
        aHH();
    }
}
