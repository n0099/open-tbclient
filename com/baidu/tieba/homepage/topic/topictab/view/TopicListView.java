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
    private BdTypeRecyclerView Yc;
    private PbListView gCf;
    private BdSwipeRefreshLayout gDf;
    private g gLj;
    private ScrollFragmentTabHost jXb;
    ScrollFragmentTabHost.a jXc;
    private com.baidu.tieba.homepage.topic.topictab.a kmC;
    private com.baidu.tieba.homepage.topic.topictab.a.a kmO;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void cbY() {
        this.Yc.removeOnScrollListener(this.mOnScrollListener);
        this.Yc.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
            this.jXb.a(this.jXc);
            this.jXc.cRO();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kmO != null) {
            this.kmO.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.kmC = aVar;
    }

    public void setData(List<n> list) {
        if (!x.isEmpty(list)) {
            this.kmO.setData(list);
        }
    }

    public void Zi() {
        this.Yc.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.gCf.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Yc.setSelection(0);
        startPullRefresh();
        if (this.jXc != null) {
            this.jXc.cRO();
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

    public void bUP() {
        this.gDf.setRefreshing(false);
    }

    public void caZ() {
        if (this.Yc != null) {
            this.Yc.setVisibility(0);
        }
    }

    public void it(boolean z) {
        if (!ctt()) {
            if (this.gLj == null) {
                this.gLj = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gLj.bGt();
                this.gLj.setTopMargin(height);
                this.gLj.onChangeSkinType();
            }
            this.gLj.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
        }
    }

    public boolean ctt() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void pU(boolean z) {
        if (!ctu()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.kmC != null) {
                            TopicListView.this.Yc.setVisibility(0);
                            TopicListView.this.kmC.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Yc.setVisibility(8);
        }
    }

    public void Zj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean ctu() {
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
            if (this.gLj != null) {
                this.gLj.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kmO != null) {
                this.kmO.notifyDataSetChanged();
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
        this.jXb = scrollFragmentTabHost;
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
            this.jXb.a(this.jXc);
        }
    }

    public void destroy() {
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
        }
        this.Yc.removeOnScrollListener(this.mOnScrollListener);
        bUP();
        hideLoadingView();
        Zj();
    }
}
