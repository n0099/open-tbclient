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
    private BdTypeRecyclerView Zq;
    private PbListView gCf;
    private BdSwipeRefreshLayout gDf;
    private g gLk;
    private ScrollFragmentTabHost kcn;
    ScrollFragmentTabHost.a kco;
    private com.baidu.tieba.homepage.topic.topictab.a.a ksG;
    private com.baidu.tieba.homepage.topic.topictab.a ksu;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bZr() {
        this.Zq.removeOnScrollListener(this.mOnScrollListener);
        this.Zq.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.kcn != null) {
            this.kcn.b(this.kco);
            this.kcn.a(this.kco);
            this.kco.cQh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ksG != null) {
            this.ksG.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.ksu = aVar;
    }

    public void setData(List<n> list) {
        if (!y.isEmpty(list)) {
            this.ksG.setData(list);
        }
    }

    public void Xb() {
        this.Zq.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.gCf.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Zq.setSelection(0);
        startPullRefresh();
        if (this.kco != null) {
            this.kco.cQh();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.gDf.setRefreshing(true);
    }

    public void bRO() {
        this.gDf.setRefreshing(false);
    }

    public void bYu() {
        if (this.Zq != null) {
            this.Zq.setVisibility(0);
        }
    }

    public void ir(boolean z) {
        if (!cqY()) {
            if (this.gLk == null) {
                this.gLk = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gLk.bCV();
                this.gLk.setTopMargin(height);
                this.gLk.onChangeSkinType();
            }
            this.gLk.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
            this.gLk = null;
        }
    }

    public boolean cqY() {
        if (this.gLk != null) {
            return this.gLk.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqZ()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.ksu != null) {
                            TopicListView.this.Zq.setVisibility(0);
                            TopicListView.this.ksu.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Zq.setVisibility(8);
        }
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqZ() {
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
            if (this.gLk != null) {
                this.gLk.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.ksG != null) {
                this.ksG.notifyDataSetChanged();
            }
            if (this.gCf != null) {
                this.gCf.changeSkin(skinType);
                this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.kcn = scrollFragmentTabHost;
        if (this.kcn != null) {
            this.kcn.b(this.kco);
            this.kcn.a(this.kco);
        }
    }

    public void destroy() {
        if (this.kcn != null) {
            this.kcn.b(this.kco);
        }
        this.Zq.removeOnScrollListener(this.mOnScrollListener);
        bRO();
        hideLoadingView();
        Xc();
    }
}
