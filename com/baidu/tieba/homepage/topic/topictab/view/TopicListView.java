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
    private BdTypeRecyclerView Oo;
    private g dly;
    private PbListView dpz;
    private int drh;
    private BdSwipeRefreshLayout dsj;
    private NoNetworkView.a eIX;
    private ScrollFragmentTabHost geI;
    ScrollFragmentTabHost.a geJ;
    private com.baidu.tieba.homepage.topic.topictab.a gpY;
    private com.baidu.tieba.homepage.topic.topictab.a.b gql;
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
        this.drh = -1;
        this.eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void es(boolean z) {
                if (z && TopicListView.this.gpY != null) {
                    TopicListView.this.gpY.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.drh != i && TopicListView.this.geI != null) {
                    TopicListView.this.drh = i;
                    if (TopicListView.this.drh == 1) {
                        TopicListView.this.geI.aKa();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.geI.aKb();
                    } else {
                        TopicListView.this.geI.aKa();
                    }
                }
            }
        };
        this.geJ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bwN() {
                if (TopicListView.this.geI != null) {
                    TopicListView.this.drh = -1;
                    if (TopicListView.this.a(TopicListView.this.Oo)) {
                        TopicListView.this.geI.aKb();
                    } else {
                        TopicListView.this.geI.aKa();
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
        this.dsj = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.dsj.setProgressView(this.mPullView);
        this.Oo = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.Oo.setLayoutManager(new LinearLayoutManager(context));
        this.Oo.setFadingEdgeLength(0);
        this.Oo.setOverScrollMode(2);
        this.gql = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Oo);
        this.dpz = new PbListView(this.mPageContext.getPageActivity());
        this.dpz.nZ();
        this.dpz.iX(R.color.cp_bg_line_e);
    }

    public void bqS() {
        this.Oo.removeOnScrollListener(this.mOnScrollListener);
        this.Oo.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.geI != null) {
            this.geI.b(this.geJ);
            this.geI.a(this.geJ);
            this.geJ.bwN();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gql != null) {
            this.gql.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.gpY = aVar;
    }

    public void setData(List<m> list) {
        if (!v.aa(list)) {
            this.gql.setData(list);
        }
    }

    public void aKP() {
        this.Oo.setNextPage(this.dpz);
        this.dpz.akS();
        this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dpz.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.dpz.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Oo.setSelection(0);
        startPullRefresh();
        if (this.geJ != null) {
            this.geJ.bwN();
        }
    }

    public void aKN() {
        this.gql.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.dsj.setRefreshing(true);
    }

    public void aKh() {
        this.dsj.setRefreshing(false);
    }

    public void aWv() {
        if (this.Oo != null) {
            this.Oo.setVisibility(0);
        }
    }

    public void cY(boolean z) {
        if (!bhr()) {
            if (this.dly == null) {
                this.dly = new g(getContext());
                this.dly.onChangeSkinType();
            }
            this.dly.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dly != null) {
            this.dly.dettachView(this);
            this.dly = null;
        }
    }

    public boolean bhr() {
        if (this.dly != null) {
            return this.dly.isViewAttached();
        }
        return false;
    }

    public void jx(boolean z) {
        if (!bhs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && TopicListView.this.gpY != null) {
                            TopicListView.this.Oo.setVisibility(0);
                            TopicListView.this.gpY.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atW();
            this.Oo.setVisibility(8);
        }
    }

    public void aJN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bhs() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.iY(skinType);
            }
            if (this.dly != null) {
                this.dly.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gql != null) {
                this.gql.notifyDataSetChanged();
            }
            am.l(this.dsj, R.color.cp_bg_line_e);
            am.l(this.Oo, R.color.cp_bg_line_d);
            if (this.dpz != null) {
                this.dpz.iY(skinType);
                this.dpz.iX(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.geI = scrollFragmentTabHost;
        if (this.geI != null) {
            this.geI.b(this.geJ);
            this.geI.a(this.geJ);
        }
    }

    public void destroy() {
        if (this.geI != null) {
            this.geI.b(this.geJ);
        }
        this.Oo.removeOnScrollListener(this.mOnScrollListener);
        aKh();
        hideLoadingView();
        aJN();
    }
}
