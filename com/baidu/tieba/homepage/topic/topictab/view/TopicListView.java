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
    private BdTypeRecyclerView BK;
    private PbListView elw;
    private BdSwipeRefreshLayout ems;
    private int enO;
    private g euk;
    private NoNetworkView.a fYY;
    private ScrollFragmentTabHost gXg;
    ScrollFragmentTabHost.a gXh;
    private com.baidu.tieba.homepage.topic.topictab.a hhY;
    private com.baidu.tieba.homepage.topic.topictab.a.b him;
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
        this.enO = -1;
        this.fYY = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.hhY != null) {
                    TopicListView.this.hhY.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.enO != i && TopicListView.this.gXg != null) {
                    TopicListView.this.enO = i;
                    if (TopicListView.this.enO == 1) {
                        TopicListView.this.gXg.bcN();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.gXg.bcO();
                    } else {
                        TopicListView.this.gXg.bcN();
                    }
                }
            }
        };
        this.gXh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNP() {
                if (TopicListView.this.gXg != null) {
                    TopicListView.this.enO = -1;
                    if (TopicListView.this.a(TopicListView.this.BK)) {
                        TopicListView.this.gXg.bcO();
                    } else {
                        TopicListView.this.gXg.bcN();
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
        this.ems = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.ems.setProgressView(this.mPullView);
        this.BK = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.BK.setLayoutManager(new LinearLayoutManager(context));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.him = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.BK);
        this.elw = new PbListView(this.mPageContext.getPageActivity());
        this.elw.createView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void initListeners() {
        this.BK.removeOnScrollListener(this.mOnScrollListener);
        this.BK.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.gXg != null) {
            this.gXg.b(this.gXh);
            this.gXg.a(this.gXh);
            this.gXh.bNP();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.him != null) {
            this.him.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.hhY = aVar;
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.him.setData(list);
        }
    }

    public void bdt() {
        this.BK.setNextPage(this.elw);
        this.elw.endLoadData();
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.elw.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.BK.setSelection(0);
        startPullRefresh();
        if (this.gXh != null) {
            this.gXh.bNP();
        }
    }

    public void bdr() {
        this.him.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.ems.setRefreshing(true);
    }

    public void bcE() {
        this.ems.setRefreshing(false);
    }

    public void bgz() {
        if (this.BK != null) {
            this.BK.setVisibility(0);
        }
    }

    public void eM(boolean z) {
        if (!bzl()) {
            if (this.euk == null) {
                this.euk = new com.baidu.tbadk.k.g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.euk.aPU();
                this.euk.setTopMargin(height);
                this.euk.onChangeSkinType();
            }
            this.euk.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.euk != null) {
            this.euk.dettachView(this);
            this.euk = null;
        }
    }

    public boolean bzl() {
        if (this.euk != null) {
            return this.euk.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.hhY != null) {
                            TopicListView.this.BK.setVisibility(0);
                            TopicListView.this.hhY.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.BK.setVisibility(8);
        }
    }

    public void bcy() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzm() {
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
            if (this.euk != null) {
                this.euk.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.him != null) {
                this.him.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.ems, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.BK, R.color.cp_bg_line_d);
            if (this.elw != null) {
                this.elw.changeSkin(skinType);
                this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gXg = scrollFragmentTabHost;
        if (this.gXg != null) {
            this.gXg.b(this.gXh);
            this.gXg.a(this.gXh);
        }
    }

    public void destroy() {
        if (this.gXg != null) {
            this.gXg.b(this.gXh);
        }
        this.BK.removeOnScrollListener(this.mOnScrollListener);
        bcE();
        hideLoadingView();
        bcy();
    }
}
