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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes22.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Yf;
    private g gAe;
    private PbListView gre;
    private BdSwipeRefreshLayout gse;
    private ScrollFragmentTabHost jJN;
    ScrollFragmentTabHost.a jJO;
    private com.baidu.tieba.homepage.topic.topictab.a.a jZB;
    private com.baidu.tieba.homepage.topic.topictab.a jZp;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bZp() {
        this.Yf.removeOnScrollListener(this.mOnScrollListener);
        this.Yf.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
            this.jJN.a(this.jJO);
            this.jJO.cOG();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jZB != null) {
            this.jZB.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.jZp = aVar;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.jZB.setData(list);
        }
    }

    public void Ya() {
        this.Yf.setNextPage(this.gre);
        this.gre.endLoadData();
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.gre.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Yf.setSelection(0);
        startPullRefresh();
        if (this.jJO != null) {
            this.jJO.cOG();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.gse.setRefreshing(true);
    }

    public void bSl() {
        this.gse.setRefreshing(false);
    }

    public void bYs() {
        if (this.Yf != null) {
            this.Yf.setVisibility(0);
        }
    }

    public void ib(boolean z) {
        if (!cqy()) {
            if (this.gAe == null) {
                this.gAe = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gAe.bDY();
                this.gAe.setTopMargin(height);
                this.gAe.onChangeSkinType();
            }
            this.gAe.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this);
            this.gAe = null;
        }
    }

    public boolean cqy() {
        if (this.gAe != null) {
            return this.gAe.isViewAttached();
        }
        return false;
    }

    public void px(boolean z) {
        if (!cqz()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.jZp != null) {
                            TopicListView.this.Yf.setVisibility(0);
                            TopicListView.this.jZp.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Yf.setVisibility(8);
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqz() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.gAe != null) {
                this.gAe.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jZB != null) {
                this.jZB.notifyDataSetChanged();
            }
            if (this.gre != null) {
                this.gre.changeSkin(skinType);
                this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jJN = scrollFragmentTabHost;
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
            this.jJN.a(this.jJO);
        }
    }

    public void destroy() {
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
        }
        this.Yf.removeOnScrollListener(this.mOnScrollListener);
        bSl();
        hideLoadingView();
        Yb();
    }
}
