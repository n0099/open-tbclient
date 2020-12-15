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
    private g gAg;
    private PbListView grg;
    private BdSwipeRefreshLayout gsg;
    private ScrollFragmentTabHost jJP;
    ScrollFragmentTabHost.a jJQ;
    private com.baidu.tieba.homepage.topic.topictab.a.a jZD;
    private com.baidu.tieba.homepage.topic.topictab.a jZr;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bZq() {
        this.Yf.removeOnScrollListener(this.mOnScrollListener);
        this.Yf.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
            this.jJP.a(this.jJQ);
            this.jJQ.cOH();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jZD != null) {
            this.jZD.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.jZr = aVar;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.jZD.setData(list);
        }
    }

    public void Ya() {
        this.Yf.setNextPage(this.grg);
        this.grg.endLoadData();
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.grg.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Yf.setSelection(0);
        startPullRefresh();
        if (this.jJQ != null) {
            this.jJQ.cOH();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.gsg.setRefreshing(true);
    }

    public void bSm() {
        this.gsg.setRefreshing(false);
    }

    public void bYt() {
        if (this.Yf != null) {
            this.Yf.setVisibility(0);
        }
    }

    public void ib(boolean z) {
        if (!cqz()) {
            if (this.gAg == null) {
                this.gAg = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gAg.bDY();
                this.gAg.setTopMargin(height);
                this.gAg.onChangeSkinType();
            }
            this.gAg.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this);
            this.gAg = null;
        }
    }

    public boolean cqz() {
        if (this.gAg != null) {
            return this.gAg.isViewAttached();
        }
        return false;
    }

    public void px(boolean z) {
        if (!cqA()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.jZr != null) {
                            TopicListView.this.Yf.setVisibility(0);
                            TopicListView.this.jZr.loadData();
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

    public boolean cqA() {
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
            if (this.gAg != null) {
                this.gAg.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jZD != null) {
                this.jZD.notifyDataSetChanged();
            }
            if (this.grg != null) {
                this.grg.changeSkin(skinType);
                this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jJP = scrollFragmentTabHost;
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
            this.jJP.a(this.jJQ);
        }
    }

    public void destroy() {
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
        }
        this.Yf.removeOnScrollListener(this.mOnScrollListener);
        bSm();
        hideLoadingView();
        Yb();
    }
}
