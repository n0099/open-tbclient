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
/* loaded from: classes21.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView WM;
    private PbListView fHm;
    private BdSwipeRefreshLayout fIl;
    private g fQf;
    private ScrollFragmentTabHost iOp;
    ScrollFragmentTabHost.a iOq;
    private com.baidu.tieba.homepage.topic.topictab.a jdF;
    private com.baidu.tieba.homepage.topic.topictab.a.a jdR;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bNr() {
        this.WM.removeOnScrollListener(this.mOnScrollListener);
        this.WM.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
            this.iOp.a(this.iOq);
            this.iOq.cAx();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jdR != null) {
            this.jdR.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.jdF = aVar;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.jdR.setData(list);
        }
    }

    public void bIj() {
        this.WM.setNextPage(this.fHm);
        this.fHm.endLoadData();
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.fHm.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.WM.setSelection(0);
        startPullRefresh();
        if (this.iOq != null) {
            this.iOq.cAx();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.fIl.setRefreshing(true);
    }

    public void bHu() {
        this.fIl.setRefreshing(false);
    }

    public void bMD() {
        if (this.WM != null) {
            this.WM.setVisibility(0);
        }
    }

    public void gR(boolean z) {
        if (!cdE()) {
            if (this.fQf == null) {
                this.fQf = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.fQf.bue();
                this.fQf.setTopMargin(height);
                this.fQf.onChangeSkinType();
            }
            this.fQf.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
            this.fQf = null;
        }
    }

    public boolean cdE() {
        if (this.fQf != null) {
            return this.fQf.isViewAttached();
        }
        return false;
    }

    public void nS(boolean z) {
        if (!cdF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.jdF != null) {
                            TopicListView.this.WM.setVisibility(0);
                            TopicListView.this.jdF.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.WM.setVisibility(8);
        }
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cdF() {
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
            if (this.fQf != null) {
                this.fQf.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jdR != null) {
                this.jdR.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.fIl, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.WM, R.color.cp_bg_line_d);
            if (this.fHm != null) {
                this.fHm.changeSkin(skinType);
                this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iOp = scrollFragmentTabHost;
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
            this.iOp.a(this.iOq);
        }
    }

    public void destroy() {
        if (this.iOp != null) {
            this.iOp.b(this.iOq);
        }
        this.WM.removeOnScrollListener(this.mOnScrollListener);
        bHu();
        hideLoadingView();
        bHn();
    }
}
