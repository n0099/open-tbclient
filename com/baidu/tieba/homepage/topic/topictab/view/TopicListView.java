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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes9.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Wa;
    private PbListView fnt;

    /* renamed from: for  reason: not valid java name */
    private BdSwipeRefreshLayout f9for;
    private g fwo;
    private com.baidu.tieba.homepage.topic.topictab.a.a iAb;
    private ScrollFragmentTabHost imf;
    ScrollFragmentTabHost.a imh;
    private com.baidu.tieba.homepage.topic.topictab.a izP;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bzy() {
        this.Wa.removeOnScrollListener(this.mOnScrollListener);
        this.Wa.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.imf != null) {
            this.imf.b(this.imh);
            this.imf.a(this.imh);
            this.imh.ciE();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iAb != null) {
            this.iAb.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.izP = aVar;
    }

    public void setData(List<q> list) {
        if (!w.isEmpty(list)) {
            this.iAb.setData(list);
        }
    }

    public void buK() {
        this.Wa.setNextPage(this.fnt);
        this.fnt.endLoadData();
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.fnt.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Wa.setSelection(0);
        startPullRefresh();
        if (this.imh != null) {
            this.imh.ciE();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.f9for.setRefreshing(true);
    }

    public void btV() {
        this.f9for.setRefreshing(false);
    }

    public void byK() {
        if (this.Wa != null) {
            this.Wa.setVisibility(0);
        }
    }

    public void ga(boolean z) {
        if (!bSR()) {
            if (this.fwo == null) {
                this.fwo = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.fwo.bgC();
                this.fwo.setTopMargin(height);
                this.fwo.onChangeSkinType();
            }
            this.fwo.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this);
            this.fwo = null;
        }
    }

    public boolean bSR() {
        if (this.fwo != null) {
            return this.fwo.isViewAttached();
        }
        return false;
    }

    public void mB(boolean z) {
        if (!bSS()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.izP != null) {
                            TopicListView.this.Wa.setVisibility(0);
                            TopicListView.this.izP.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Wa.setVisibility(8);
        }
    }

    public void btO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bSS() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            an.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.fwo != null) {
                this.fwo.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iAb != null) {
                this.iAb.notifyDataSetChanged();
            }
            an.setBackgroundColor(this.f9for, R.color.cp_bg_line_e);
            an.setBackgroundColor(this.Wa, R.color.cp_bg_line_d);
            if (this.fnt != null) {
                this.fnt.changeSkin(skinType);
                this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.imf = scrollFragmentTabHost;
        if (this.imf != null) {
            this.imf.b(this.imh);
            this.imf.a(this.imh);
        }
    }

    public void destroy() {
        if (this.imf != null) {
            this.imf.b(this.imh);
        }
        this.Wa.removeOnScrollListener(this.mOnScrollListener);
        btV();
        hideLoadingView();
        btO();
    }
}
