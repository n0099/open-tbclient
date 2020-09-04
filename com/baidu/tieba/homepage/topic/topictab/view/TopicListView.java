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
    private BdSwipeRefreshLayout fEZ;
    private PbListView fEa;
    private g fMR;
    private ScrollFragmentTabHost iGF;
    ScrollFragmentTabHost.a iGG;
    private com.baidu.tieba.homepage.topic.topictab.a iUZ;
    private com.baidu.tieba.homepage.topic.topictab.a.a iVl;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bMh() {
        this.Wu.removeOnScrollListener(this.mOnScrollListener);
        this.Wu.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.iGF != null) {
            this.iGF.b(this.iGG);
            this.iGF.a(this.iGG);
            this.iGG.cwP();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iVl != null) {
            this.iVl.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.iUZ = aVar;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.iVl.setData(list);
        }
    }

    public void bGT() {
        this.Wu.setNextPage(this.fEa);
        this.fEa.endLoadData();
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.fEa.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Wu.setSelection(0);
        startPullRefresh();
        if (this.iGG != null) {
            this.iGG.cwP();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.fEZ.setRefreshing(true);
    }

    public void bGe() {
        this.fEZ.setRefreshing(false);
    }

    public void bLt() {
        if (this.Wu != null) {
            this.Wu.setVisibility(0);
        }
    }

    public void gT(boolean z) {
        if (!cgw()) {
            if (this.fMR == null) {
                this.fMR = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.fMR.bta();
                this.fMR.setTopMargin(height);
                this.fMR.onChangeSkinType();
            }
            this.fMR.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this);
            this.fMR = null;
        }
    }

    public boolean cgw() {
        if (this.fMR != null) {
            return this.fMR.isViewAttached();
        }
        return false;
    }

    public void nM(boolean z) {
        if (!cgx()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.iUZ != null) {
                            TopicListView.this.Wu.setVisibility(0);
                            TopicListView.this.iUZ.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Wu.setVisibility(8);
        }
    }

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cgx() {
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
            if (this.fMR != null) {
                this.fMR.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iVl != null) {
                this.iVl.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.fEZ, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_d);
            if (this.fEa != null) {
                this.fEa.changeSkin(skinType);
                this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iGF = scrollFragmentTabHost;
        if (this.iGF != null) {
            this.iGF.b(this.iGG);
            this.iGF.a(this.iGG);
        }
    }

    public void destroy() {
        if (this.iGF != null) {
            this.iGF.b(this.iGG);
        }
        this.Wu.removeOnScrollListener(this.mOnScrollListener);
        bGe();
        hideLoadingView();
        bFX();
    }
}
