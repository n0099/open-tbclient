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
/* loaded from: classes7.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Bs;
    private BdSwipeRefreshLayout ehX;
    private PbListView ehe;
    private int ejq;
    private g epL;
    private NoNetworkView.a fWI;
    private ScrollFragmentTabHost gUR;
    ScrollFragmentTabHost.a gUS;
    private com.baidu.tieba.homepage.topic.topictab.a hfK;
    private com.baidu.tieba.homepage.topic.topictab.a.b hfX;
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
        this.ejq = -1;
        this.fWI = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.hfK != null) {
                    TopicListView.this.hfK.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.ejq != i && TopicListView.this.gUR != null) {
                    TopicListView.this.ejq = i;
                    if (TopicListView.this.ejq == 1) {
                        TopicListView.this.gUR.bav();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.gUR.baw();
                    } else {
                        TopicListView.this.gUR.bav();
                    }
                }
            }
        };
        this.gUS = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bMk() {
                if (TopicListView.this.gUR != null) {
                    TopicListView.this.ejq = -1;
                    if (TopicListView.this.a(TopicListView.this.Bs)) {
                        TopicListView.this.gUR.baw();
                    } else {
                        TopicListView.this.gUR.bav();
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
        this.ehX = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.ehX.setProgressView(this.mPullView);
        this.Bs = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.Bs.setLayoutManager(new LinearLayoutManager(context));
        this.Bs.setFadingEdgeLength(0);
        this.Bs.setOverScrollMode(2);
        this.hfX = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Bs);
        this.ehe = new PbListView(this.mPageContext.getPageActivity());
        this.ehe.createView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void initListeners() {
        this.Bs.removeOnScrollListener(this.mOnScrollListener);
        this.Bs.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.gUR != null) {
            this.gUR.b(this.gUS);
            this.gUR.a(this.gUS);
            this.gUS.bMk();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hfX != null) {
            this.hfX.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.hfK = aVar;
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.hfX.setData(list);
        }
    }

    public void bbb() {
        this.Bs.setNextPage(this.ehe);
        this.ehe.endLoadData();
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.ehe.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Bs.setSelection(0);
        startPullRefresh();
        if (this.gUS != null) {
            this.gUS.bMk();
        }
    }

    public void baZ() {
        this.hfX.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.ehX.setRefreshing(true);
    }

    public void bam() {
        this.ehX.setRefreshing(false);
    }

    public void bem() {
        if (this.Bs != null) {
            this.Bs.setVisibility(0);
        }
    }

    public void eF(boolean z) {
        if (!bxG()) {
            if (this.epL == null) {
                this.epL = new com.baidu.tbadk.k.g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.epL.aNv();
                this.epL.setTopMargin(height);
                this.epL.onChangeSkinType();
            }
            this.epL.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this);
            this.epL = null;
        }
    }

    public boolean bxG() {
        if (this.epL != null) {
            return this.epL.isViewAttached();
        }
        return false;
    }

    public void kJ(boolean z) {
        if (!bxH()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.hfK != null) {
                            TopicListView.this.Bs.setVisibility(0);
                            TopicListView.this.hfK.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Bs.setVisibility(8);
        }
    }

    public void baf() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bxH() {
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
            if (this.epL != null) {
                this.epL.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hfX != null) {
                this.hfX.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.ehX, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Bs, R.color.cp_bg_line_d);
            if (this.ehe != null) {
                this.ehe.changeSkin(skinType);
                this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gUR = scrollFragmentTabHost;
        if (this.gUR != null) {
            this.gUR.b(this.gUS);
            this.gUR.a(this.gUS);
        }
    }

    public void destroy() {
        if (this.gUR != null) {
            this.gUR.b(this.gUS);
        }
        this.Bs.removeOnScrollListener(this.mOnScrollListener);
        bam();
        hideLoadingView();
        baf();
    }
}
