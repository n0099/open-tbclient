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
    private g dDz;
    private PbListView dvS;
    private int dxA;
    private BdSwipeRefreshLayout dyC;
    private NoNetworkView.a eQL;
    private ScrollFragmentTabHost gdn;
    ScrollFragmentTabHost.a gdo;
    private com.baidu.tieba.homepage.topic.topictab.a goG;
    private com.baidu.tieba.homepage.topic.topictab.a.b goT;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private int mSkinType;
    private BdTypeRecyclerView yJ;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public TopicListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.dxA = -1;
        this.eQL = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.goG != null) {
                    TopicListView.this.goG.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.dxA != i && TopicListView.this.gdn != null) {
                    TopicListView.this.dxA = i;
                    if (TopicListView.this.dxA == 1) {
                        TopicListView.this.gdn.aJy();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.gdn.aJz();
                    } else {
                        TopicListView.this.gdn.aJy();
                    }
                }
            }
        };
        this.gdo = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void btQ() {
                if (TopicListView.this.gdn != null) {
                    TopicListView.this.dxA = -1;
                    if (TopicListView.this.a(TopicListView.this.yJ)) {
                        TopicListView.this.gdn.aJz();
                    } else {
                        TopicListView.this.gdn.aJy();
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
        this.dyC = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.dyC.setProgressView(this.mPullView);
        this.yJ = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.yJ.setLayoutManager(new LinearLayoutManager(context));
        this.yJ.setFadingEdgeLength(0);
        this.yJ.setOverScrollMode(2);
        this.goT = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.yJ);
        this.dvS = new PbListView(this.mPageContext.getPageActivity());
        this.dvS.createView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void aNb() {
        this.yJ.removeOnScrollListener(this.mOnScrollListener);
        this.yJ.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.gdn != null) {
            this.gdn.b(this.gdo);
            this.gdn.a(this.gdo);
            this.gdo.btQ();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.goT != null) {
            this.goT.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.goG = aVar;
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.goT.setData(list);
        }
    }

    public void aKh() {
        this.yJ.setNextPage(this.dvS);
        this.dvS.endLoadData();
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.dvS.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.yJ.setSelection(0);
        startPullRefresh();
        if (this.gdo != null) {
            this.gdo.btQ();
        }
    }

    public void aKf() {
        this.goT.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.dyC.setRefreshing(true);
    }

    public void aJF() {
        this.dyC.setRefreshing(false);
    }

    public void aMo() {
        if (this.yJ != null) {
            this.yJ.setVisibility(0);
        }
    }

    public void dp(boolean z) {
        if (!bfj()) {
            if (this.dDz == null) {
                this.dDz = new g(getContext());
                this.dDz.onChangeSkinType();
            }
            this.dDz.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this);
            this.dDz = null;
        }
    }

    public boolean bfj() {
        if (this.dDz != null) {
            return this.dDz.isViewAttached();
        }
        return false;
    }

    public void jm(boolean z) {
        if (!bfk()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.goG != null) {
                            TopicListView.this.yJ.setVisibility(0);
                            TopicListView.this.goG.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.yJ.setVisibility(8);
        }
    }

    public void aJm() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bfk() {
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
            if (this.dDz != null) {
                this.dDz.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.goT != null) {
                this.goT.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.dyC, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.yJ, R.color.cp_bg_line_d);
            if (this.dvS != null) {
                this.dvS.changeSkin(skinType);
                this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gdn = scrollFragmentTabHost;
        if (this.gdn != null) {
            this.gdn.b(this.gdo);
            this.gdn.a(this.gdo);
        }
    }

    public void destroy() {
        if (this.gdn != null) {
            this.gdn.b(this.gdo);
        }
        this.yJ.removeOnScrollListener(this.mOnScrollListener);
        aJF();
        hideLoadingView();
        aJm();
    }
}
