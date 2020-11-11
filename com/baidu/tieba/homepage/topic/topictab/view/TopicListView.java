package com.baidu.tieba.homepage.topic.topictab.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes22.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Xe;
    private PbListView gjo;
    private BdSwipeRefreshLayout gko;
    private g gso;
    private com.baidu.tieba.homepage.topic.topictab.a jLc;
    private com.baidu.tieba.homepage.topic.topictab.a.a jLo;
    private ScrollFragmentTabHost jvA;
    ScrollFragmentTabHost.a jvB;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bWm() {
        this.Xe.removeOnScrollListener(this.mOnScrollListener);
        this.Xe.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
            this.jvA.a(this.jvB);
            this.jvB.cJM();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jLo != null) {
            this.jLo.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.jLc = aVar;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.jLo.setData(list);
        }
    }

    public void Wj() {
        this.Xe.setNextPage(this.gjo);
        this.gjo.endLoadData();
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.gjo.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Xe.setSelection(0);
        startPullRefresh();
        if (this.jvB != null) {
            this.jvB.cJM();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.gko.setRefreshing(true);
    }

    public void bPh() {
        this.gko.setRefreshing(false);
    }

    public void bVq() {
        if (this.Xe != null) {
            this.Xe.setVisibility(0);
        }
    }

    public void hJ(boolean z) {
        if (!cmJ()) {
            if (this.gso == null) {
                this.gso = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gso.bBg();
                this.gso.setTopMargin(height);
                this.gso.onChangeSkinType();
            }
            this.gso.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
            this.gso = null;
        }
    }

    public boolean cmJ() {
        if (this.gso != null) {
            return this.gso.isViewAttached();
        }
        return false;
    }

    public void oY(boolean z) {
        if (!cmK()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.jLc != null) {
                            TopicListView.this.Xe.setVisibility(0);
                            TopicListView.this.jLc.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Xe.setVisibility(8);
        }
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cmK() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.gso != null) {
                this.gso.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jLo != null) {
                this.jLo.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.gko, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_d);
            if (this.gjo != null) {
                this.gjo.changeSkin(skinType);
                this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jvA = scrollFragmentTabHost;
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
            this.jvA.a(this.jvB);
        }
    }

    public void destroy() {
        if (this.jvA != null) {
            this.jvA.b(this.jvB);
        }
        this.Xe.removeOnScrollListener(this.mOnScrollListener);
        bPh();
        hideLoadingView();
        Wk();
    }
}
