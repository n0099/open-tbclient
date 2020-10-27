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
    private BdTypeRecyclerView Xe;
    private com.baidu.tbadk.h.f aiM;
    private PbListView gdy;
    private BdSwipeRefreshLayout gez;
    private int gga;
    private g gmB;
    private boolean hqk;
    private ScrollFragmentTabHost jpD;
    ScrollFragmentTabHost.a jpE;
    private TabLayout.OnTabSelectedListener jvq;
    private b jvt;
    private h jvw;
    private HotTopicHeaderView jvx;
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
        this.gga = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.gga != i && HotTopicTabView.this.jpD != null) {
                    HotTopicTabView.this.gga = i;
                    if (HotTopicTabView.this.gga == 1) {
                        HotTopicTabView.this.jpD.bMQ();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.jpD.bMR();
                    } else {
                        HotTopicTabView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.jpE = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cHl() {
                if (HotTopicTabView.this.jpD != null) {
                    HotTopicTabView.this.gga = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.Xe)) {
                        HotTopicTabView.this.jpD.bMR();
                    } else {
                        HotTopicTabView.this.jpD.bMQ();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bTF();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.gez = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gez.setProgressView(this.mPullView);
        this.Xe = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Xe.setLayoutManager(new LinearLayoutManager(context));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.jvw = new h(this.mPageContext, this.Xe);
        this.gdy = new PbListView(this.mPageContext.getPageActivity());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_g);
    }

    private void bTF() {
        this.Xe.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jvq = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.jpD != null) {
            this.jpD.b(this.jpE);
            this.jpD.a(this.jpE);
            this.jpE.cHl();
        }
        if (this.hqk) {
            this.hqk = false;
            if (y.isEmpty(this.jvw.getData())) {
                this.jvt.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.jvw != null) {
            this.jvw.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.jvt = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cHZ() {
        return (this.jvx == null || this.jvx.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.jvx == null) {
            this.jvx = new HotTopicHeaderView(getContext());
        }
        this.Xe.setHeaderView(this.jvx);
        this.jvx.setOnItemCoverListener(this.aiM);
        this.jvx.setOnTabSelectedListener(this.jvq);
        this.jvx.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<q> list) {
        this.jvw.setData(list);
    }

    public void TJ() {
        this.Xe.setNextPage(this.gdy);
        this.gdy.endLoadData();
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.ap(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cIa() {
        this.Xe.setNextPage(null);
    }

    public void reload() {
        this.Xe.setSelection(0);
        startPullRefresh();
        if (this.jpE != null) {
            this.jpE.cHl();
        }
    }

    public void startPullRefresh() {
        this.gez.setRefreshing(true);
    }

    public void bMH() {
        this.gez.setRefreshing(false);
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
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.jvt != null) {
                            HotTopicTabView.this.hA(false);
                            HotTopicTabView.this.jvt.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
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
            ap.setBackgroundColor(this.gez, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_d);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.gmB != null) {
                this.gmB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jvw != null) {
                this.jvw.notifyDataSetChanged();
            }
            if (this.gdy != null) {
                this.gdy.changeSkin(skinType);
                this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            if (this.jvx != null) {
                this.jvx.onChangeSkinType(skinType);
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
        bMH();
        hideLoadingView();
        TK();
        this.hqk = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jvt.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.aiM = fVar;
        if (this.jvw != null) {
            this.jvw.setOnItemCoverListener(fVar);
        }
        if (this.jvx != null) {
            this.jvx.setOnItemCoverListener(fVar);
        }
    }
}
