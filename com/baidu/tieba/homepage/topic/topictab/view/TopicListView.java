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
    private BdTypeRecyclerView Xc;
    private PbListView fTv;
    private BdSwipeRefreshLayout fUv;
    private g gcx;
    private ScrollFragmentTabHost jdh;
    ScrollFragmentTabHost.a jdi;
    private com.baidu.tieba.homepage.topic.topictab.a jsE;
    private com.baidu.tieba.homepage.topic.topictab.a.a jsQ;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public void bQI() {
        this.Xc.removeOnScrollListener(this.mOnScrollListener);
        this.Xc.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.jdh != null) {
            this.jdh.b(this.jdi);
            this.jdh.a(this.jdi);
            this.jdi.cEe();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jsQ != null) {
            this.jsQ.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.jsE = aVar;
    }

    public void setData(List<q> list) {
        if (!y.isEmpty(list)) {
            this.jsQ.setData(list);
        }
    }

    public void SJ() {
        this.Xc.setNextPage(this.fTv);
        this.fTv.endLoadData();
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.fTv.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Xc.setSelection(0);
        startPullRefresh();
        if (this.jdi != null) {
            this.jdi.cEe();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.fUv.setRefreshing(true);
    }

    public void bKf() {
        this.fUv.setRefreshing(false);
    }

    public void bPU() {
        if (this.Xc != null) {
            this.Xc.setVisibility(0);
        }
    }

    public void hn(boolean z) {
        if (!cha()) {
            if (this.gcx == null) {
                this.gcx = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gcx.bwO();
                this.gcx.setTopMargin(height);
                this.gcx.onChangeSkinType();
            }
            this.gcx.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this);
            this.gcx = null;
        }
    }

    public boolean cha() {
        if (this.gcx != null) {
            return this.gcx.isViewAttached();
        }
        return false;
    }

    public void ox(boolean z) {
        if (!chb()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.jsE != null) {
                            TopicListView.this.Xc.setVisibility(0);
                            TopicListView.this.jsE.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Xc.setVisibility(8);
        }
    }

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean chb() {
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
            if (this.gcx != null) {
                this.gcx.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jsQ != null) {
                this.jsQ.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.fUv, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Xc, R.color.cp_bg_line_d);
            if (this.fTv != null) {
                this.fTv.changeSkin(skinType);
                this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jdh = scrollFragmentTabHost;
        if (this.jdh != null) {
            this.jdh.b(this.jdi);
            this.jdh.a(this.jdi);
        }
    }

    public void destroy() {
        if (this.jdh != null) {
            this.jdh.b(this.jdi);
        }
        this.Xc.removeOnScrollListener(this.mOnScrollListener);
        bKf();
        hideLoadingView();
        SK();
    }
}
