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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes16.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView VT;
    private g fBv;
    private PbListView fsC;
    private BdSwipeRefreshLayout ftC;
    private com.baidu.tieba.homepage.topic.topictab.a iFT;
    private com.baidu.tieba.homepage.topic.topictab.a.a iGf;
    private ScrollFragmentTabHost isi;
    ScrollFragmentTabHost.a isj;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bCM() {
        this.VT.removeOnScrollListener(this.mOnScrollListener);
        this.VT.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.isi != null) {
            this.isi.b(this.isj);
            this.isi.a(this.isj);
            this.isj.cmf();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iGf != null) {
            this.iGf.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.iFT = aVar;
    }

    public void setData(List<q> list) {
        if (!x.isEmpty(list)) {
            this.iGf.setData(list);
        }
    }

    public void bxT() {
        this.VT.setNextPage(this.fsC);
        this.fsC.endLoadData();
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.fsC.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.VT.setSelection(0);
        startPullRefresh();
        if (this.isj != null) {
            this.isj.cmf();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.ftC.setRefreshing(true);
    }

    public void bxe() {
        this.ftC.setRefreshing(false);
    }

    public void bBY() {
        if (this.VT != null) {
            this.VT.setVisibility(0);
        }
    }

    public void gw(boolean z) {
        if (!bWi()) {
            if (this.fBv == null) {
                this.fBv = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.fBv.bkn();
                this.fBv.setTopMargin(height);
                this.fBv.onChangeSkinType();
            }
            this.fBv.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this);
            this.fBv = null;
        }
    }

    public boolean bWi() {
        if (this.fBv != null) {
            return this.fBv.isViewAttached();
        }
        return false;
    }

    public void ng(boolean z) {
        if (!bWj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.iFT != null) {
                            TopicListView.this.VT.setVisibility(0);
                            TopicListView.this.iFT.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.VT.setVisibility(8);
        }
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bWj() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.fBv != null) {
                this.fBv.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iGf != null) {
                this.iGf.notifyDataSetChanged();
            }
            ao.setBackgroundColor(this.ftC, R.color.cp_bg_line_e);
            ao.setBackgroundColor(this.VT, R.color.cp_bg_line_d);
            if (this.fsC != null) {
                this.fsC.changeSkin(skinType);
                this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.isi = scrollFragmentTabHost;
        if (this.isi != null) {
            this.isi.b(this.isj);
            this.isi.a(this.isj);
        }
    }

    public void destroy() {
        if (this.isi != null) {
            this.isi.b(this.isj);
        }
        this.VT.removeOnScrollListener(this.mOnScrollListener);
        bxe();
        hideLoadingView();
        bwX();
    }
}
