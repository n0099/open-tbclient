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
    private BdTypeRecyclerView Vf;
    private PbListView ePm;
    private BdSwipeRefreshLayout eQj;
    private int eRD;
    private g eYb;
    private NoNetworkView.a gGl;
    private ScrollFragmentTabHost hIe;
    ScrollFragmentTabHost.a hIf;
    private com.baidu.tieba.homepage.topic.topictab.a hTi;
    private com.baidu.tieba.homepage.topic.topictab.a.b hTv;
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
        this.eRD = -1;
        this.gGl = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.hTi != null) {
                    TopicListView.this.hTi.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.eRD != i && TopicListView.this.hIe != null) {
                    TopicListView.this.eRD = i;
                    if (TopicListView.this.eRD == 1) {
                        TopicListView.this.hIe.blI();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.hIe.blJ();
                    } else {
                        TopicListView.this.hIe.blI();
                    }
                }
            }
        };
        this.hIf = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bYE() {
                if (TopicListView.this.hIe != null) {
                    TopicListView.this.eRD = -1;
                    if (TopicListView.this.a(TopicListView.this.Vf)) {
                        TopicListView.this.hIe.blJ();
                    } else {
                        TopicListView.this.hIe.blI();
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
        this.eQj = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.eQj.setProgressView(this.mPullView);
        this.Vf = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.Vf.setLayoutManager(new LinearLayoutManager(context));
        this.Vf.setFadingEdgeLength(0);
        this.Vf.setOverScrollMode(2);
        this.hTv = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Vf);
        this.ePm = new PbListView(this.mPageContext.getPageActivity());
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void bqK() {
        this.Vf.removeOnScrollListener(this.mOnScrollListener);
        this.Vf.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.hIe != null) {
            this.hIe.b(this.hIf);
            this.hIe.a(this.hIf);
            this.hIf.bYE();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hTv != null) {
            this.hTv.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.hTi = aVar;
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.hTv.setData(list);
        }
    }

    public void bmp() {
        this.Vf.setNextPage(this.ePm);
        this.ePm.endLoadData();
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.ePm.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Vf.setSelection(0);
        startPullRefresh();
        if (this.hIf != null) {
            this.hIf.bYE();
        }
    }

    public void bmn() {
        this.hTv.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.eQj.setRefreshing(true);
    }

    public void blz() {
        this.eQj.setRefreshing(false);
    }

    public void bpV() {
        if (this.Vf != null) {
            this.Vf.setVisibility(0);
        }
    }

    public void fK(boolean z) {
        if (!bJt()) {
            if (this.eYb == null) {
                this.eYb = new com.baidu.tbadk.k.g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.eYb.aYp();
                this.eYb.setTopMargin(height);
                this.eYb.onChangeSkinType();
            }
            this.eYb.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this);
            this.eYb = null;
        }
    }

    public boolean bJt() {
        if (this.eYb != null) {
            return this.eYb.isViewAttached();
        }
        return false;
    }

    public void lV(boolean z) {
        if (!bJu()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.hTi != null) {
                            TopicListView.this.Vf.setVisibility(0);
                            TopicListView.this.hTi.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Vf.setVisibility(8);
        }
    }

    public void blt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bJu() {
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
            if (this.eYb != null) {
                this.eYb.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hTv != null) {
                this.hTv.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.eQj, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Vf, R.color.cp_bg_line_d);
            if (this.ePm != null) {
                this.ePm.changeSkin(skinType);
                this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hIe = scrollFragmentTabHost;
        if (this.hIe != null) {
            this.hIe.b(this.hIf);
            this.hIe.a(this.hIf);
        }
    }

    public void destroy() {
        if (this.hIe != null) {
            this.hIe.b(this.hIf);
        }
        this.Vf.removeOnScrollListener(this.mOnScrollListener);
        blz();
        hideLoadingView();
        blt();
    }
}
