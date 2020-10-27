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
/* loaded from: classes22.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Xe;
    private PbListView gdy;
    private BdSwipeRefreshLayout gez;
    private g gmB;
    private com.baidu.tieba.homepage.topic.topictab.a jFe;
    private com.baidu.tieba.homepage.topic.topictab.a.a jFq;
    private ScrollFragmentTabHost jpD;
    ScrollFragmentTabHost.a jpE;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bTF() {
        this.Xe.removeOnScrollListener(this.mOnScrollListener);
        this.Xe.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.jpD != null) {
            this.jpD.b(this.jpE);
            this.jpD.a(this.jpE);
            this.jpE.cHl();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jFq != null) {
            this.jFq.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.jFe = aVar;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.jFq.setData(list);
        }
    }

    public void TJ() {
        this.Xe.setNextPage(this.gdy);
        this.gdy.endLoadData();
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.gdy.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Xe.setSelection(0);
        startPullRefresh();
        if (this.jpE != null) {
            this.jpE.cHl();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.gez.setRefreshing(true);
    }

    public void bMH() {
        this.gez.setRefreshing(false);
    }

    public void bSR() {
        if (this.Xe != null) {
            this.Xe.setVisibility(0);
        }
    }

    public void hA(boolean z) {
        if (!ckh()) {
            if (this.gmB == null) {
                this.gmB = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gmB.byH();
                this.gmB.setTopMargin(height);
                this.gmB.onChangeSkinType();
            }
            this.gmB.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this);
            this.gmB = null;
        }
    }

    public boolean ckh() {
        if (this.gmB != null) {
            return this.gmB.isViewAttached();
        }
        return false;
    }

    public void oP(boolean z) {
        if (!cki()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.jFe != null) {
                            TopicListView.this.Xe.setVisibility(0);
                            TopicListView.this.jFe.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Xe.setVisibility(8);
        }
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cki() {
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
            if (this.gmB != null) {
                this.gmB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jFq != null) {
                this.jFq.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.gez, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_d);
            if (this.gdy != null) {
                this.gdy.changeSkin(skinType);
                this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jpD = scrollFragmentTabHost;
        if (this.jpD != null) {
            this.jpD.b(this.jpE);
            this.jpD.a(this.jpE);
        }
    }

    public void destroy() {
        if (this.jpD != null) {
            this.jpD.b(this.jpE);
        }
        this.Xe.removeOnScrollListener(this.mOnScrollListener);
        bMH();
        hideLoadingView();
        TK();
    }
}
