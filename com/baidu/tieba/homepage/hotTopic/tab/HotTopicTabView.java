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
/* loaded from: classes16.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView Wu;
    private com.baidu.tbadk.h.f ahY;
    private BdSwipeRefreshLayout fEZ;
    private PbListView fEa;
    private int fGt;
    private g fMR;
    private boolean gMb;
    private ScrollFragmentTabHost iGF;
    ScrollFragmentTabHost.a iGG;
    private TabLayout.OnTabSelectedListener iLp;
    private b iLs;
    private h iLv;
    private HotTopicHeaderView iLw;
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
        this.fGt = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.fGt != i && HotTopicTabView.this.iGF != null) {
                    HotTopicTabView.this.fGt = i;
                    if (HotTopicTabView.this.fGt == 1) {
                        HotTopicTabView.this.iGF.bGm();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.iGF.bGn();
                    } else {
                        HotTopicTabView.this.iGF.bGm();
                    }
                }
            }
        };
        this.iGG = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cwP() {
                if (HotTopicTabView.this.iGF != null) {
                    HotTopicTabView.this.fGt = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.Wu)) {
                        HotTopicTabView.this.iGF.bGn();
                    } else {
                        HotTopicTabView.this.iGF.bGm();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bMh();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.fEZ = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fEZ.setProgressView(this.mPullView);
        this.Wu = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Wu.setLayoutManager(new LinearLayoutManager(context));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.iLv = new h(this.mPageContext, this.Wu);
        this.fEa = new PbListView(this.mPageContext.getPageActivity());
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_g);
    }

    private void bMh() {
        this.Wu.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.iLp = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.iGF != null) {
            this.iGF.b(this.iGG);
            this.iGF.a(this.iGG);
            this.iGG.cwP();
        }
        if (this.gMb) {
            this.gMb = false;
            if (y.isEmpty(this.iLv.getData())) {
                this.iLs.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.iLv != null) {
            this.iLv.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.iLs = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cxD() {
        return (this.iLw == null || this.iLw.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.iLw == null) {
            this.iLw = new HotTopicHeaderView(getContext());
        }
        this.Wu.setHeaderView(this.iLw);
        this.iLw.setOnItemCoverListener(this.ahY);
        this.iLw.setOnTabSelectedListener(this.iLp);
        this.iLw.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<q> list) {
        this.iLv.setData(list);
    }

    public void bGT() {
        this.Wu.setNextPage(this.fEa);
        this.fEa.endLoadData();
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.ao(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cxE() {
        this.Wu.setNextPage(null);
    }

    public void reload() {
        this.Wu.setSelection(0);
        startPullRefresh();
        if (this.iGG != null) {
            this.iGG.cwP();
        }
    }

    public void startPullRefresh() {
        this.fEZ.setRefreshing(true);
    }

    public void bGe() {
        this.fEZ.setRefreshing(false);
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
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.iLs != null) {
                            HotTopicTabView.this.gT(false);
                            HotTopicTabView.this.iLs.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
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
            ap.setBackgroundColor(this.fEZ, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_d);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.fMR != null) {
                this.fMR.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iLv != null) {
                this.iLv.notifyDataSetChanged();
            }
            if (this.fEa != null) {
                this.fEa.changeSkin(skinType);
                this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
            if (this.iLw != null) {
                this.iLw.onChangeSkinType(skinType);
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
        bGe();
        hideLoadingView();
        bFX();
        this.gMb = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.iLs.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.ahY = fVar;
        if (this.iLv != null) {
            this.iLv.setOnItemCoverListener(fVar);
        }
        if (this.iLw != null) {
            this.iLw.setOnItemCoverListener(fVar);
        }
    }
}
