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
    private NoNetworkView.a faq;
    private PbListView fbY;
    private BdSwipeRefreshLayout fcW;
    private int feq;
    private g fkQ;
    private ScrollFragmentTabHost hWU;
    ScrollFragmentTabHost.a hWV;
    private com.baidu.tieba.homepage.topic.topictab.a ihY;
    private com.baidu.tieba.homepage.topic.topictab.a.b iil;
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
        this.feq = -1;
        this.faq = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.ihY != null) {
                    TopicListView.this.ihY.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.feq != i && TopicListView.this.hWU != null) {
                    TopicListView.this.feq = i;
                    if (TopicListView.this.feq == 1) {
                        TopicListView.this.hWU.bre();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.hWU.brf();
                    } else {
                        TopicListView.this.hWU.bre();
                    }
                }
            }
        };
        this.hWV = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ceY() {
                if (TopicListView.this.hWU != null) {
                    TopicListView.this.feq = -1;
                    if (TopicListView.this.a(TopicListView.this.Vw)) {
                        TopicListView.this.hWU.brf();
                    } else {
                        TopicListView.this.hWU.bre();
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
        this.fcW = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fcW.setProgressView(this.mPullView);
        this.Vw = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(context));
        this.Vw.setFadingEdgeLength(0);
        this.Vw.setOverScrollMode(2);
        this.iil = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Vw);
        this.fbY = new PbListView(this.mPageContext.getPageActivity());
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void bwA() {
        this.Vw.removeOnScrollListener(this.mOnScrollListener);
        this.Vw.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.hWU != null) {
            this.hWU.b(this.hWV);
            this.hWU.a(this.hWV);
            this.hWV.ceY();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iil != null) {
            this.iil.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.ihY = aVar;
    }

    public void setData(List<o> list) {
        if (!v.isEmpty(list)) {
            this.iil.setData(list);
        }
    }

    public void brL() {
        this.Vw.setNextPage(this.fbY);
        this.fbY.endLoadData();
        this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fbY.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.fbY.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Vw.setSelection(0);
        startPullRefresh();
        if (this.hWV != null) {
            this.hWV.ceY();
        }
    }

    public void brJ() {
        this.iil.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.fcW.setRefreshing(true);
    }

    public void bqV() {
        this.fcW.setRefreshing(false);
    }

    public void bvM() {
        if (this.Vw != null) {
            this.Vw.setVisibility(0);
        }
    }

    public void fV(boolean z) {
        if (!bPL()) {
            if (this.fkQ == null) {
                this.fkQ = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.fkQ.bew();
                this.fkQ.setTopMargin(height);
                this.fkQ.onChangeSkinType();
            }
            this.fkQ.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this);
            this.fkQ = null;
        }
    }

    public boolean bPL() {
        if (this.fkQ != null) {
            return this.fkQ.isViewAttached();
        }
        return false;
    }

    public void mq(boolean z) {
        if (!bPM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.ihY != null) {
                            TopicListView.this.Vw.setVisibility(0);
                            TopicListView.this.ihY.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Vw.setVisibility(8);
        }
    }

    public void bqO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bPM() {
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
            if (this.fkQ != null) {
                this.fkQ.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iil != null) {
                this.iil.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.fcW, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Vw, R.color.cp_bg_line_d);
            if (this.fbY != null) {
                this.fbY.changeSkin(skinType);
                this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hWU = scrollFragmentTabHost;
        if (this.hWU != null) {
            this.hWU.b(this.hWV);
            this.hWU.a(this.hWV);
        }
    }

    public void destroy() {
        if (this.hWU != null) {
            this.hWU.b(this.hWV);
        }
        this.Vw.removeOnScrollListener(this.mOnScrollListener);
        bqV();
        hideLoadingView();
        bqO();
    }
}
