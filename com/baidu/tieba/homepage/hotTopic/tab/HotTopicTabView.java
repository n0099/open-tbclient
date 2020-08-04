package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
@SuppressLint({"ViewConstructor"})
/* loaded from: classes16.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView VT;
    private g fBv;
    private PbListView fsC;
    private BdSwipeRefreshLayout ftC;
    private int fuW;
    private boolean gzA;
    private ScrollFragmentTabHost isk;
    ScrollFragmentTabHost.a isl;
    private b iwP;
    private com.baidu.tieba.homepage.hotTopic.tab.a.a iwR;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public HotTopicTabView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fuW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.fuW != i && HotTopicTabView.this.isk != null) {
                    HotTopicTabView.this.fuW = i;
                    if (HotTopicTabView.this.fuW == 1) {
                        HotTopicTabView.this.isk.bxm();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.isk.bxn();
                    } else {
                        HotTopicTabView.this.isk.bxm();
                    }
                }
            }
        };
        this.isl = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cmf() {
                if (HotTopicTabView.this.isk != null) {
                    HotTopicTabView.this.fuW = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.VT)) {
                        HotTopicTabView.this.isk.bxn();
                    } else {
                        HotTopicTabView.this.isk.bxm();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bCM();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.ftC = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.ftC.setProgressView(this.mPullView);
        this.VT = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.VT.setLayoutManager(new LinearLayoutManager(context));
        this.VT.setFadingEdgeLength(0);
        this.VT.setOverScrollMode(2);
        this.VT.setPadding(0, 0, 0, l.getDimens(getContext(), R.dimen.tbds45));
        this.iwR = new com.baidu.tieba.homepage.hotTopic.tab.a.a(this.mPageContext, this.VT);
        this.fsC = new PbListView(this.mPageContext.getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    private void bCM() {
        this.VT.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setViewForeground() {
        if (this.isk != null) {
            this.isk.b(this.isl);
            this.isk.a(this.isl);
            this.isl.cmf();
        }
        if (this.gzA) {
            this.gzA = false;
            if (x.isEmpty(this.iwR.getData())) {
                this.iwP.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.iwR != null) {
            this.iwR.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.iwP = bVar;
    }

    public void setData(@NonNull List<q> list) {
        this.iwR.setData(list);
    }

    public void bxT() {
        this.VT.setNextPage(this.fsC);
        this.fsC.endLoadData();
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.setText(getResources().getString(R.string.really_great));
    }

    public void cmQ() {
        this.VT.setNextPage(null);
    }

    public void reload() {
        this.VT.setSelection(0);
        startPullRefresh();
        if (this.isl != null) {
            this.isl.cmf();
        }
    }

    public void startPullRefresh() {
        this.ftC.setRefreshing(true);
    }

    public void bxe() {
        this.ftC.setRefreshing(false);
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
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.iwP != null) {
                            HotTopicTabView.this.gw(false);
                            HotTopicTabView.this.iwP.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
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
            if (this.iwR != null) {
                this.iwR.notifyDataSetChanged();
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
        this.isk = scrollFragmentTabHost;
        if (this.isk != null) {
            this.isk.b(this.isl);
            this.isk.a(this.isl);
        }
    }

    public void destroy() {
        if (this.isk != null) {
            this.isk.b(this.isl);
        }
        bxe();
        hideLoadingView();
        bwX();
        this.gzA = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.iwP.loadData();
    }
}
