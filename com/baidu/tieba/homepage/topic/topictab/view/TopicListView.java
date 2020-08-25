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
/* loaded from: classes16.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Wu;
    private PbListView fDW;
    private BdSwipeRefreshLayout fEV;
    private g fMN;
    ScrollFragmentTabHost.a iGA;
    private ScrollFragmentTabHost iGz;
    private com.baidu.tieba.homepage.topic.topictab.a iUT;
    private com.baidu.tieba.homepage.topic.topictab.a.a iVf;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bMg() {
        this.Wu.removeOnScrollListener(this.mOnScrollListener);
        this.Wu.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
            this.iGz.a(this.iGA);
            this.iGA.cwO();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iVf != null) {
            this.iVf.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.iUT = aVar;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.iVf.setData(list);
        }
    }

    public void bGS() {
        this.Wu.setNextPage(this.fDW);
        this.fDW.endLoadData();
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.fDW.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Wu.setSelection(0);
        startPullRefresh();
        if (this.iGA != null) {
            this.iGA.cwO();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.fEV.setRefreshing(true);
    }

    public void bGd() {
        this.fEV.setRefreshing(false);
    }

    public void bLs() {
        if (this.Wu != null) {
            this.Wu.setVisibility(0);
        }
    }

    public void gS(boolean z) {
        if (!cgv()) {
            if (this.fMN == null) {
                this.fMN = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.fMN.bsZ();
                this.fMN.setTopMargin(height);
                this.fMN.onChangeSkinType();
            }
            this.fMN.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this);
            this.fMN = null;
        }
    }

    public boolean cgv() {
        if (this.fMN != null) {
            return this.fMN.isViewAttached();
        }
        return false;
    }

    public void nK(boolean z) {
        if (!cgw()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.iUT != null) {
                            TopicListView.this.Wu.setVisibility(0);
                            TopicListView.this.iUT.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Wu.setVisibility(8);
        }
    }

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cgw() {
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
            if (this.fMN != null) {
                this.fMN.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iVf != null) {
                this.iVf.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.fEV, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_d);
            if (this.fDW != null) {
                this.fDW.changeSkin(skinType);
                this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iGz = scrollFragmentTabHost;
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
            this.iGz.a(this.iGA);
        }
    }

    public void destroy() {
        if (this.iGz != null) {
            this.iGz.b(this.iGA);
        }
        this.Wu.removeOnScrollListener(this.mOnScrollListener);
        bGd();
        hideLoadingView();
        bFW();
    }
}
