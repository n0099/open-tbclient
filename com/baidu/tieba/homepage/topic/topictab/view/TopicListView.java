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
    private PbListView eli;
    private BdSwipeRefreshLayout eme;
    private int enA;
    private g etW;
    private NoNetworkView.a fYJ;
    private ScrollFragmentTabHost gWS;
    ScrollFragmentTabHost.a gWT;
    private com.baidu.tieba.homepage.topic.topictab.a hhK;
    private com.baidu.tieba.homepage.topic.topictab.a.b hhX;
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
        this.enA = -1;
        this.fYJ = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.hhK != null) {
                    TopicListView.this.hhK.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.enA != i && TopicListView.this.gWS != null) {
                    TopicListView.this.enA = i;
                    if (TopicListView.this.enA == 1) {
                        TopicListView.this.gWS.bcK();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.gWS.bcL();
                    } else {
                        TopicListView.this.gWS.bcK();
                    }
                }
            }
        };
        this.gWT = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bNM() {
                if (TopicListView.this.gWS != null) {
                    TopicListView.this.enA = -1;
                    if (TopicListView.this.a(TopicListView.this.BK)) {
                        TopicListView.this.gWS.bcL();
                    } else {
                        TopicListView.this.gWS.bcK();
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
        this.eme = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.eme.setProgressView(this.mPullView);
        this.BK = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.BK.setLayoutManager(new LinearLayoutManager(context));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.hhX = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.BK);
        this.eli = new PbListView(this.mPageContext.getPageActivity());
        this.eli.createView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void initListeners() {
        this.BK.removeOnScrollListener(this.mOnScrollListener);
        this.BK.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.gWS != null) {
            this.gWS.b(this.gWT);
            this.gWS.a(this.gWT);
            this.gWT.bNM();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hhX != null) {
            this.hhX.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.hhK = aVar;
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.hhX.setData(list);
        }
    }

    public void bdq() {
        this.BK.setNextPage(this.eli);
        this.eli.endLoadData();
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.eli.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.BK.setSelection(0);
        startPullRefresh();
        if (this.gWT != null) {
            this.gWT.bNM();
        }
    }

    public void bdo() {
        this.hhX.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.eme.setRefreshing(true);
    }

    public void bcB() {
        this.eme.setRefreshing(false);
    }

    public void bgw() {
        if (this.BK != null) {
            this.BK.setVisibility(0);
        }
    }

    public void eM(boolean z) {
        if (!bzi()) {
            if (this.etW == null) {
                this.etW = new com.baidu.tbadk.k.g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.etW.aPR();
                this.etW.setTopMargin(height);
                this.etW.onChangeSkinType();
            }
            this.etW.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this);
            this.etW = null;
        }
    }

    public boolean bzi() {
        if (this.etW != null) {
            return this.etW.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.hhK != null) {
                            TopicListView.this.BK.setVisibility(0);
                            TopicListView.this.hhK.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.BK.setVisibility(8);
        }
    }

    public void bcv() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzj() {
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
            if (this.etW != null) {
                this.etW.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hhX != null) {
                this.hhX.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.eme, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.BK, R.color.cp_bg_line_d);
            if (this.eli != null) {
                this.eli.changeSkin(skinType);
                this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gWS = scrollFragmentTabHost;
        if (this.gWS != null) {
            this.gWS.b(this.gWT);
            this.gWS.a(this.gWT);
        }
    }

    public void destroy() {
        if (this.gWS != null) {
            this.gWS.b(this.gWT);
        }
        this.BK.removeOnScrollListener(this.mOnScrollListener);
        bcB();
        hideLoadingView();
        bcv();
    }
}
