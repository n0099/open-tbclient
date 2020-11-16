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
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes21.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Xi;
    private PbListView giV;
    private BdSwipeRefreshLayout gjV;
    private g grV;
    private com.baidu.tieba.homepage.topic.topictab.a jLM;
    private com.baidu.tieba.homepage.topic.topictab.a.a jLY;
    private ScrollFragmentTabHost jwm;
    ScrollFragmentTabHost.a jwn;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bVF() {
        this.Xi.removeOnScrollListener(this.mOnScrollListener);
        this.Xi.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
            this.jwm.a(this.jwn);
            this.jwn.cJr();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jLY != null) {
            this.jLY.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.jLM = aVar;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.jLY.setData(list);
        }
    }

    public void VA() {
        this.Xi.setNextPage(this.giV);
        this.giV.endLoadData();
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.giV.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Xi.setSelection(0);
        startPullRefresh();
        if (this.jwn != null) {
            this.jwn.cJr();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.gjV.setRefreshing(true);
    }

    public void bOA() {
        this.gjV.setRefreshing(false);
    }

    public void bUJ() {
        if (this.Xi != null) {
            this.Xi.setVisibility(0);
        }
    }

    public void hM(boolean z) {
        if (!cml()) {
            if (this.grV == null) {
                this.grV = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.grV.bAw();
                this.grV.setTopMargin(height);
                this.grV.onChangeSkinType();
            }
            this.grV.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this);
            this.grV = null;
        }
    }

    public boolean cml() {
        if (this.grV != null) {
            return this.grV.isViewAttached();
        }
        return false;
    }

    public void pb(boolean z) {
        if (!cmm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.jLM != null) {
                            TopicListView.this.Xi.setVisibility(0);
                            TopicListView.this.jLM.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Xi.setVisibility(8);
        }
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cmm() {
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
            if (this.grV != null) {
                this.grV.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jLY != null) {
                this.jLY.notifyDataSetChanged();
            }
            if (this.giV != null) {
                this.giV.changeSkin(skinType);
                this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jwm = scrollFragmentTabHost;
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
            this.jwm.a(this.jwn);
        }
    }

    public void destroy() {
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
        }
        this.Xi.removeOnScrollListener(this.mOnScrollListener);
        bOA();
        hideLoadingView();
        VB();
    }
}
