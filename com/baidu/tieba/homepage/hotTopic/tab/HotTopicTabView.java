package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.hotTopic.tab.a.h;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView Yc;
    private com.baidu.tbadk.h.f aks;
    private PbListView gCf;
    private BdSwipeRefreshLayout gDf;
    private int gEG;
    private g gLj;
    private boolean hRv;
    private ScrollFragmentTabHost jXb;
    ScrollFragmentTabHost.a jXc;
    private TabLayout.OnTabSelectedListener kdc;
    private b kdf;
    private h kdi;
    private HotTopicHeaderView kdj;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private com.baidu.tbadk.l.h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public HotTopicTabView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gEG = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.gEG != i && HotTopicTabView.this.jXb != null) {
                    HotTopicTabView.this.gEG = i;
                    if (HotTopicTabView.this.gEG == 1) {
                        HotTopicTabView.this.jXb.bUY();
                    } else if (HotTopicTabView.this.c(recyclerView)) {
                        HotTopicTabView.this.jXb.bUZ();
                    } else {
                        HotTopicTabView.this.jXb.bUY();
                    }
                }
            }
        };
        this.jXc = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cRO() {
                if (HotTopicTabView.this.jXb != null) {
                    HotTopicTabView.this.gEG = -1;
                    if (HotTopicTabView.this.c(HotTopicTabView.this.Yc)) {
                        HotTopicTabView.this.jXb.bUZ();
                    } else {
                        HotTopicTabView.this.jXb.bUY();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        cbY();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.gDf = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gDf.setProgressView(this.mPullView);
        this.Yc = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Yc.setLayoutManager(new LinearLayoutManager(context));
        this.Yc.setFadingEdgeLength(0);
        this.Yc.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Yc.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.kdi = new h(this.mPageContext, this.Yc);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0111);
    }

    private void cbY() {
        this.Yc.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.kdc = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
            this.jXb.a(this.jXc);
            this.jXc.cRO();
        }
        if (this.hRv) {
            this.hRv = false;
            if (x.isEmpty(this.kdi.getData())) {
                this.kdf.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.kdi != null) {
            this.kdi.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.kdf = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cSC() {
        return (this.kdj == null || this.kdj.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.kdj == null) {
            this.kdj = new HotTopicHeaderView(getContext());
        }
        this.Yc.setHeaderView(this.kdj);
        this.kdj.setOnItemCoverListener(this.aks);
        this.kdj.setOnTabSelectedListener(this.kdc);
        this.kdj.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<n> list) {
        this.kdi.setData(list);
    }

    public void Zi() {
        this.Yc.setNextPage(this.gCf);
        this.gCf.endLoadData();
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.at(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cSD() {
        this.Yc.setNextPage(null);
    }

    public void reload() {
        this.Yc.setSelection(0);
        startPullRefresh();
        if (this.jXc != null) {
            this.jXc.cRO();
        }
    }

    public void startPullRefresh() {
        this.gDf.setRefreshing(true);
    }

    public void bUP() {
        this.gDf.setRefreshing(false);
    }

    public void it(boolean z) {
        if (!ctt()) {
            if (this.gLj == null) {
                this.gLj = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gLj.bGt();
                this.gLj.setTopMargin(height);
                this.gLj.onChangeSkinType();
            }
            this.gLj.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
        }
    }

    public boolean ctt() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void pU(boolean z) {
        if (!ctu()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.kdf != null) {
                            HotTopicTabView.this.it(false);
                            HotTopicTabView.this.kdf.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Zj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean ctu() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.gLj != null) {
                this.gLj.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kdi != null) {
                this.kdi.notifyDataSetChanged();
            }
            if (this.gCf != null) {
                this.gCf.changeSkin(skinType);
                this.gCf.setContainerBackgroundColorResId(R.color.transparent);
            }
            if (this.kdj != null) {
                this.kdj.onChangeSkinType(skinType);
            }
            if (this.Yc != null) {
                com.baidu.tbadk.core.elementsMaven.c.bv(this.Yc).setBackGroundColor(R.color.CAM_X0202);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jXb = scrollFragmentTabHost;
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
            this.jXb.a(this.jXc);
        }
    }

    public void destroy() {
        if (this.jXb != null) {
            this.jXb.b(this.jXc);
        }
        bUP();
        hideLoadingView();
        Zj();
        this.hRv = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.kdf.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.aks = fVar;
        if (this.kdi != null) {
            this.kdi.setOnItemCoverListener(fVar);
        }
        if (this.kdj != null) {
            this.kdj.setOnItemCoverListener(fVar);
        }
    }
}
