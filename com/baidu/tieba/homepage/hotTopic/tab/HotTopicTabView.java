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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes9.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView Wa;
    private PbListView fnt;

    /* renamed from: for  reason: not valid java name */
    private BdSwipeRefreshLayout f8for;
    private int fpM;
    private g fwo;
    private boolean gud;
    private ScrollFragmentTabHost imf;
    ScrollFragmentTabHost.a imh;
    private b iqJ;
    private com.baidu.tieba.homepage.hotTopic.tab.a.a iqL;
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
        this.fpM = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.fpM != i && HotTopicTabView.this.imf != null) {
                    HotTopicTabView.this.fpM = i;
                    if (HotTopicTabView.this.fpM == 1) {
                        HotTopicTabView.this.imf.bud();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.imf.bue();
                    } else {
                        HotTopicTabView.this.imf.bud();
                    }
                }
            }
        };
        this.imh = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void ciE() {
                if (HotTopicTabView.this.imf != null) {
                    HotTopicTabView.this.fpM = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.Wa)) {
                        HotTopicTabView.this.imf.bue();
                    } else {
                        HotTopicTabView.this.imf.bud();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bzy();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.f8for = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.f8for.setProgressView(this.mPullView);
        this.Wa = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Wa.setLayoutManager(new LinearLayoutManager(context));
        this.Wa.setFadingEdgeLength(0);
        this.Wa.setOverScrollMode(2);
        this.Wa.setPadding(0, 0, 0, l.getDimens(getContext(), R.dimen.tbds45));
        this.iqL = new com.baidu.tieba.homepage.hotTopic.tab.a.a(this.mPageContext, this.Wa);
        this.fnt = new PbListView(this.mPageContext.getPageActivity());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    private void bzy() {
        this.Wa.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setViewForeground() {
        if (this.imf != null) {
            this.imf.b(this.imh);
            this.imf.a(this.imh);
            this.imh.ciE();
        }
        if (this.gud) {
            this.gud = false;
            if (w.isEmpty(this.iqL.getData())) {
                this.iqJ.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.iqL != null) {
            this.iqL.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.iqJ = bVar;
    }

    public void setData(@NonNull List<q> list) {
        this.iqL.setData(list);
    }

    public void buK() {
        this.Wa.setNextPage(this.fnt);
        this.fnt.endLoadData();
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.setText(getResources().getString(R.string.really_great));
    }

    public void cjp() {
        this.Wa.setNextPage(null);
    }

    public void reload() {
        this.Wa.setSelection(0);
        startPullRefresh();
        if (this.imh != null) {
            this.imh.ciE();
        }
    }

    public void startPullRefresh() {
        this.f8for.setRefreshing(true);
    }

    public void btV() {
        this.f8for.setRefreshing(false);
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
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.iqJ != null) {
                            HotTopicTabView.this.ga(false);
                            HotTopicTabView.this.iqJ.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
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
            if (this.iqL != null) {
                this.iqL.notifyDataSetChanged();
            }
            an.setBackgroundColor(this.f8for, R.color.cp_bg_line_e);
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
        btV();
        hideLoadingView();
        btO();
        this.gud = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.iqJ.loadData();
    }
}
