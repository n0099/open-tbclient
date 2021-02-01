package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
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
/* loaded from: classes2.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView XW;
    private PbListView gAi;
    private BdSwipeRefreshLayout gBi;
    private g gJn;
    private ScrollFragmentTabHost jZX;
    ScrollFragmentTabHost.a jZY;
    private com.baidu.tieba.homepage.topic.topictab.a kqe;
    private com.baidu.tieba.homepage.topic.topictab.a.a kqq;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bZe() {
        this.XW.removeOnScrollListener(this.mOnScrollListener);
        this.XW.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
            this.jZX.a(this.jZY);
            this.jZY.cPT();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kqq != null) {
            this.kqq.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.kqe = aVar;
    }

    public void setData(List<n> list) {
        if (!y.isEmpty(list)) {
            this.kqq.setData(list);
        }
    }

    public void WY() {
        this.XW.setNextPage(this.gAi);
        this.gAi.endLoadData();
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.gAi.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.XW.setSelection(0);
        startPullRefresh();
        if (this.jZY != null) {
            this.jZY.cPT();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.gBi.setRefreshing(true);
    }

    public void bRB() {
        this.gBi.setRefreshing(false);
    }

    public void bYh() {
        if (this.XW != null) {
            this.XW.setVisibility(0);
        }
    }

    public void ir(boolean z) {
        if (!cqL()) {
            if (this.gJn == null) {
                this.gJn = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gJn.bCS();
                this.gJn.setTopMargin(height);
                this.gJn.onChangeSkinType();
            }
            this.gJn.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this);
            this.gJn = null;
        }
    }

    public boolean cqL() {
        if (this.gJn != null) {
            return this.gJn.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.kqe != null) {
                            TopicListView.this.XW.setVisibility(0);
                            TopicListView.this.kqe.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.XW.setVisibility(8);
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqM() {
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
            if (this.gJn != null) {
                this.gJn.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kqq != null) {
                this.kqq.notifyDataSetChanged();
            }
            if (this.gAi != null) {
                this.gAi.changeSkin(skinType);
                this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jZX = scrollFragmentTabHost;
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
            this.jZX.a(this.jZY);
        }
    }

    public void destroy() {
        if (this.jZX != null) {
            this.jZX.b(this.jZY);
        }
        this.XW.removeOnScrollListener(this.mOnScrollListener);
        bRB();
        hideLoadingView();
        WZ();
    }
}
