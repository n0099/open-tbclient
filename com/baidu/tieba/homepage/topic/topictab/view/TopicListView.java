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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes2.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Ya;
    private g gGD;
    private PbListView gxy;
    private BdSwipeRefreshLayout gyy;
    private ScrollFragmentTabHost jSw;
    ScrollFragmentTabHost.a jSx;
    private com.baidu.tieba.homepage.topic.topictab.a khW;
    private com.baidu.tieba.homepage.topic.topictab.a.a kij;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bYg() {
        this.Ya.removeOnScrollListener(this.mOnScrollListener);
        this.Ya.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
            this.jSw.a(this.jSx);
            this.jSx.cNW();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kij != null) {
            this.kij.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.khW = aVar;
    }

    public void setData(List<n> list) {
        if (!x.isEmpty(list)) {
            this.kij.setData(list);
        }
    }

    public void Vp() {
        this.Ya.setNextPage(this.gxy);
        this.gxy.endLoadData();
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.gxy.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Ya.setSelection(0);
        startPullRefresh();
        if (this.jSx != null) {
            this.jSx.cNW();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.gyy.setRefreshing(true);
    }

    public void bQX() {
        this.gyy.setRefreshing(false);
    }

    public void bXh() {
        if (this.Ya != null) {
            this.Ya.setVisibility(0);
        }
    }

    public void ip(boolean z) {
        if (!cpB()) {
            if (this.gGD == null) {
                this.gGD = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gGD.bCA();
                this.gGD.setTopMargin(height);
                this.gGD.onChangeSkinType();
            }
            this.gGD.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
        }
    }

    public boolean cpB() {
        if (this.gGD != null) {
            return this.gGD.isViewAttached();
        }
        return false;
    }

    public void pQ(boolean z) {
        if (!cpC()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.khW != null) {
                            TopicListView.this.Ya.setVisibility(0);
                            TopicListView.this.khW.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Ya.setVisibility(8);
        }
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cpC() {
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
            if (this.gGD != null) {
                this.gGD.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kij != null) {
                this.kij.notifyDataSetChanged();
            }
            if (this.gxy != null) {
                this.gxy.changeSkin(skinType);
                this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jSw = scrollFragmentTabHost;
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
            this.jSw.a(this.jSx);
        }
    }

    public void destroy() {
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
        }
        this.Ya.removeOnScrollListener(this.mOnScrollListener);
        bQX();
        hideLoadingView();
        Vq();
    }
}
