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
    private PbListView elM;
    private BdSwipeRefreshLayout emJ;
    private int eog;
    private g euG;
    private NoNetworkView.a fZG;
    private ScrollFragmentTabHost gYn;
    ScrollFragmentTabHost.a gYo;
    private com.baidu.tieba.homepage.topic.topictab.a.b hjM;
    private com.baidu.tieba.homepage.topic.topictab.a hjz;
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
        this.eog = -1;
        this.fZG = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.hjz != null) {
                    TopicListView.this.hjz.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.eog != i && TopicListView.this.gYn != null) {
                    TopicListView.this.eog = i;
                    if (TopicListView.this.eog == 1) {
                        TopicListView.this.gYn.bcR();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.gYn.bcS();
                    } else {
                        TopicListView.this.gYn.bcR();
                    }
                }
            }
        };
        this.gYo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bOd() {
                if (TopicListView.this.gYn != null) {
                    TopicListView.this.eog = -1;
                    if (TopicListView.this.a(TopicListView.this.BK)) {
                        TopicListView.this.gYn.bcS();
                    } else {
                        TopicListView.this.gYn.bcR();
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
        this.emJ = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.emJ.setProgressView(this.mPullView);
        this.BK = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.BK.setLayoutManager(new LinearLayoutManager(context));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.hjM = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.BK);
        this.elM = new PbListView(this.mPageContext.getPageActivity());
        this.elM.createView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void initListeners() {
        this.BK.removeOnScrollListener(this.mOnScrollListener);
        this.BK.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.gYn != null) {
            this.gYn.b(this.gYo);
            this.gYn.a(this.gYo);
            this.gYo.bOd();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hjM != null) {
            this.hjM.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.hjz = aVar;
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.hjM.setData(list);
        }
    }

    public void bdy() {
        this.BK.setNextPage(this.elM);
        this.elM.endLoadData();
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.elM.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.BK.setSelection(0);
        startPullRefresh();
        if (this.gYo != null) {
            this.gYo.bOd();
        }
    }

    public void bdw() {
        this.hjM.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.emJ.setRefreshing(true);
    }

    public void bcI() {
        this.emJ.setRefreshing(false);
    }

    public void bgE() {
        if (this.BK != null) {
            this.BK.setVisibility(0);
        }
    }

    public void eN(boolean z) {
        if (!bzr()) {
            if (this.euG == null) {
                this.euG = new com.baidu.tbadk.k.g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.euG.aPY();
                this.euG.setTopMargin(height);
                this.euG.onChangeSkinType();
            }
            this.euG.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this);
            this.euG = null;
        }
    }

    public boolean bzr() {
        if (this.euG != null) {
            return this.euG.isViewAttached();
        }
        return false;
    }

    public void kS(boolean z) {
        if (!bzs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.hjz != null) {
                            TopicListView.this.BK.setVisibility(0);
                            TopicListView.this.hjz.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.BK.setVisibility(8);
        }
    }

    public void bcC() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzs() {
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
            if (this.euG != null) {
                this.euG.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hjM != null) {
                this.hjM.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.emJ, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.BK, R.color.cp_bg_line_d);
            if (this.elM != null) {
                this.elM.changeSkin(skinType);
                this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gYn = scrollFragmentTabHost;
        if (this.gYn != null) {
            this.gYn.b(this.gYo);
            this.gYn.a(this.gYo);
        }
    }

    public void destroy() {
        if (this.gYn != null) {
            this.gYn.b(this.gYo);
        }
        this.BK.removeOnScrollListener(this.mOnScrollListener);
        bcI();
        hideLoadingView();
        bcC();
    }
}
