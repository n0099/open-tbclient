package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.hotTopic.tab.a.h;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes22.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView Xc;
    private com.baidu.tbadk.h.f aiL;
    private PbListView fTv;
    private BdSwipeRefreshLayout fUv;
    private int fVW;
    private g gcx;
    private boolean heo;
    private ScrollFragmentTabHost jdh;
    ScrollFragmentTabHost.a jdi;
    private TabLayout.OnTabSelectedListener jiT;
    private b jiW;
    private h jiZ;
    private HotTopicHeaderView jja;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public HotTopicTabView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fVW = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.fVW != i && HotTopicTabView.this.jdh != null) {
                    HotTopicTabView.this.fVW = i;
                    if (HotTopicTabView.this.fVW == 1) {
                        HotTopicTabView.this.jdh.bKo();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.jdh.bKp();
                    } else {
                        HotTopicTabView.this.jdh.bKo();
                    }
                }
            }
        };
        this.jdi = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cEe() {
                if (HotTopicTabView.this.jdh != null) {
                    HotTopicTabView.this.fVW = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.Xc)) {
                        HotTopicTabView.this.jdh.bKp();
                    } else {
                        HotTopicTabView.this.jdh.bKo();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bQI();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.fUv = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fUv.setProgressView(this.mPullView);
        this.Xc = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Xc.setLayoutManager(new LinearLayoutManager(context));
        this.Xc.setFadingEdgeLength(0);
        this.Xc.setOverScrollMode(2);
        this.jiZ = new h(this.mPageContext, this.Xc);
        this.fTv = new PbListView(this.mPageContext.getPageActivity());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_g);
    }

    private void bQI() {
        this.Xc.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jiT = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.jdh != null) {
            this.jdh.b(this.jdi);
            this.jdh.a(this.jdi);
            this.jdi.cEe();
        }
        if (this.heo) {
            this.heo = false;
            if (y.isEmpty(this.jiZ.getData())) {
                this.jiW.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.jiZ != null) {
            this.jiZ.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.jiW = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cES() {
        return (this.jja == null || this.jja.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.jja == null) {
            this.jja = new HotTopicHeaderView(getContext());
        }
        this.Xc.setHeaderView(this.jja);
        this.jja.setOnItemCoverListener(this.aiL);
        this.jja.setOnTabSelectedListener(this.jiT);
        this.jja.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<q> list) {
        this.jiZ.setData(list);
    }

    public void SJ() {
        this.Xc.setNextPage(this.fTv);
        this.fTv.endLoadData();
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.ap(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cET() {
        this.Xc.setNextPage(null);
    }

    public void reload() {
        this.Xc.setSelection(0);
        startPullRefresh();
        if (this.jdi != null) {
            this.jdi.cEe();
        }
    }

    public void startPullRefresh() {
        this.fUv.setRefreshing(true);
    }

    public void bKf() {
        this.fUv.setRefreshing(false);
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
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.jiW != null) {
                            HotTopicTabView.this.hn(false);
                            HotTopicTabView.this.jiW.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
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
            ap.setBackgroundColor(this.fUv, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Xc, R.color.cp_bg_line_d);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.gcx != null) {
                this.gcx.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jiZ != null) {
                this.jiZ.notifyDataSetChanged();
            }
            if (this.fTv != null) {
                this.fTv.changeSkin(skinType);
                this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            if (this.jja != null) {
                this.jja.onChangeSkinType(skinType);
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
        bKf();
        hideLoadingView();
        SK();
        this.heo = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jiW.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.aiL = fVar;
        if (this.jiZ != null) {
            this.jiZ.setOnItemCoverListener(fVar);
        }
        if (this.jja != null) {
            this.jja.setOnItemCoverListener(fVar);
        }
    }
}
