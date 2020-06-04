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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes9.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Vw;
    private NoNetworkView.a faB;
    private PbListView fcj;
    private BdSwipeRefreshLayout fdh;
    private int feB;
    private g flb;
    private ScrollFragmentTabHost hXH;
    ScrollFragmentTabHost.a hXI;
    private com.baidu.tieba.homepage.topic.topictab.a iiL;
    private com.baidu.tieba.homepage.topic.topictab.a.b iiY;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public TopicListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.feB = -1;
        this.faB = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.iiL != null) {
                    TopicListView.this.iiL.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.feB != i && TopicListView.this.hXH != null) {
                    TopicListView.this.feB = i;
                    if (TopicListView.this.feB == 1) {
                        TopicListView.this.hXH.brg();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.hXH.brh();
                    } else {
                        TopicListView.this.hXH.brg();
                    }
                }
            }
        };
        this.hXI = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cfh() {
                if (TopicListView.this.hXH != null) {
                    TopicListView.this.feB = -1;
                    if (TopicListView.this.a(TopicListView.this.Vw)) {
                        TopicListView.this.hXH.brh();
                    } else {
                        TopicListView.this.hXH.brg();
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
        this.fdh = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fdh.setProgressView(this.mPullView);
        this.Vw = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(context));
        this.Vw.setFadingEdgeLength(0);
        this.Vw.setOverScrollMode(2);
        this.iiY = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Vw);
        this.fcj = new PbListView(this.mPageContext.getPageActivity());
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void bwC() {
        this.Vw.removeOnScrollListener(this.mOnScrollListener);
        this.Vw.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.hXH != null) {
            this.hXH.b(this.hXI);
            this.hXH.a(this.hXI);
            this.hXI.cfh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iiY != null) {
            this.iiY.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.iiL = aVar;
    }

    public void setData(List<o> list) {
        if (!v.isEmpty(list)) {
            this.iiY.setData(list);
        }
    }

    public void brN() {
        this.Vw.setNextPage(this.fcj);
        this.fcj.endLoadData();
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.fcj.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Vw.setSelection(0);
        startPullRefresh();
        if (this.hXI != null) {
            this.hXI.cfh();
        }
    }

    public void brL() {
        this.iiY.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.fdh.setRefreshing(true);
    }

    public void bqX() {
        this.fdh.setRefreshing(false);
    }

    public void bvO() {
        if (this.Vw != null) {
            this.Vw.setVisibility(0);
        }
    }

    public void fV(boolean z) {
        if (!bPN()) {
            if (this.flb == null) {
                this.flb = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.flb.bex();
                this.flb.setTopMargin(height);
                this.flb.onChangeSkinType();
            }
            this.flb.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this);
            this.flb = null;
        }
    }

    public boolean bPN() {
        if (this.flb != null) {
            return this.flb.isViewAttached();
        }
        return false;
    }

    public void mq(boolean z) {
        if (!bPO()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.iiL != null) {
                            TopicListView.this.Vw.setVisibility(0);
                            TopicListView.this.iiL.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Vw.setVisibility(8);
        }
    }

    public void bqQ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bPO() {
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
            if (this.flb != null) {
                this.flb.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iiY != null) {
                this.iiY.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.fdh, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Vw, R.color.cp_bg_line_d);
            if (this.fcj != null) {
                this.fcj.changeSkin(skinType);
                this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hXH = scrollFragmentTabHost;
        if (this.hXH != null) {
            this.hXH.b(this.hXI);
            this.hXH.a(this.hXI);
        }
    }

    public void destroy() {
        if (this.hXH != null) {
            this.hXH.b(this.hXI);
        }
        this.Vw.removeOnScrollListener(this.mOnScrollListener);
        bqX();
        hideLoadingView();
        bqQ();
    }
}
