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
    private PbListView gAw;
    private BdSwipeRefreshLayout gBw;
    private g gJB;
    private ScrollFragmentTabHost kal;
    ScrollFragmentTabHost.a kam;
    private com.baidu.tieba.homepage.topic.topictab.a.a kqE;
    private com.baidu.tieba.homepage.topic.topictab.a kqs;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bZl() {
        this.XW.removeOnScrollListener(this.mOnScrollListener);
        this.XW.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.kal != null) {
            this.kal.b(this.kam);
            this.kal.a(this.kam);
            this.kam.cQa();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kqE != null) {
            this.kqE.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.kqs = aVar;
    }

    public void setData(List<n> list) {
        if (!y.isEmpty(list)) {
            this.kqE.setData(list);
        }
    }

    public void WY() {
        this.XW.setNextPage(this.gAw);
        this.gAw.endLoadData();
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.gAw.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.XW.setSelection(0);
        startPullRefresh();
        if (this.kam != null) {
            this.kam.cQa();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.gBw.setRefreshing(true);
    }

    public void bRI() {
        this.gBw.setRefreshing(false);
    }

    public void bYo() {
        if (this.XW != null) {
            this.XW.setVisibility(0);
        }
    }

    public void ir(boolean z) {
        if (!cqS()) {
            if (this.gJB == null) {
                this.gJB = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gJB.bCS();
                this.gJB.setTopMargin(height);
                this.gJB.onChangeSkinType();
            }
            this.gJB.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
        }
    }

    public boolean cqS() {
        if (this.gJB != null) {
            return this.gJB.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqT()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.kqs != null) {
                            TopicListView.this.XW.setVisibility(0);
                            TopicListView.this.kqs.loadData();
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

    public boolean cqT() {
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
            if (this.gJB != null) {
                this.gJB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kqE != null) {
                this.kqE.notifyDataSetChanged();
            }
            if (this.gAw != null) {
                this.gAw.changeSkin(skinType);
                this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.kal = scrollFragmentTabHost;
        if (this.kal != null) {
            this.kal.b(this.kam);
            this.kal.a(this.kam);
        }
    }

    public void destroy() {
        if (this.kal != null) {
            this.kal.b(this.kam);
        }
        this.XW.removeOnScrollListener(this.mOnScrollListener);
        bRI();
        hideLoadingView();
        WZ();
    }
}
