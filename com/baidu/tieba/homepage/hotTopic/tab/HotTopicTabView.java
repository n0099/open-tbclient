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
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.hotTopic.tab.a.h;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes22.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView Yf;
    private com.baidu.tbadk.h.f ajQ;
    private g gAg;
    private PbListView grg;
    private BdSwipeRefreshLayout gsg;
    private int gtH;
    private boolean hFv;
    private ScrollFragmentTabHost jJP;
    ScrollFragmentTabHost.a jJQ;
    private TabLayout.OnTabSelectedListener jPO;
    private b jPR;
    private h jPU;
    private HotTopicHeaderView jPV;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private com.baidu.tbadk.l.h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public HotTopicTabView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gtH = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.gtH != i && HotTopicTabView.this.jJP != null) {
                    HotTopicTabView.this.gtH = i;
                    if (HotTopicTabView.this.gtH == 1) {
                        HotTopicTabView.this.jJP.bSv();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.jJP.bSw();
                    } else {
                        HotTopicTabView.this.jJP.bSv();
                    }
                }
            }
        };
        this.jJQ = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOH() {
                if (HotTopicTabView.this.jJP != null) {
                    HotTopicTabView.this.gtH = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.Yf)) {
                        HotTopicTabView.this.jJP.bSw();
                    } else {
                        HotTopicTabView.this.jJP.bSv();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bZq();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.gsg = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gsg.setProgressView(this.mPullView);
        this.Yf = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Yf.setLayoutManager(new LinearLayoutManager(context));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        if (!d.bkA()) {
            this.Yf.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        this.jPU = new h(this.mPageContext, this.Yf);
        this.grg = new PbListView(this.mPageContext.getPageActivity());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0111);
    }

    private void bZq() {
        this.Yf.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jPO = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
            this.jJP.a(this.jJQ);
            this.jJQ.cOH();
        }
        if (this.hFv) {
            this.hFv = false;
            if (y.isEmpty(this.jPU.getData())) {
                this.jPR.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.jPU != null) {
            this.jPU.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.jPR = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cPv() {
        return (this.jPV == null || this.jPV.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.jPV == null) {
            this.jPV = new HotTopicHeaderView(getContext());
        }
        this.Yf.setHeaderView(this.jPV);
        this.jPV.setOnItemCoverListener(this.ajQ);
        this.jPV.setOnTabSelectedListener(this.jPO);
        this.jPV.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<q> list) {
        this.jPU.setData(list);
    }

    public void Ya() {
        this.Yf.setNextPage(this.grg);
        this.grg.endLoadData();
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.ar(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cPw() {
        this.Yf.setNextPage(null);
    }

    public void reload() {
        this.Yf.setSelection(0);
        startPullRefresh();
        if (this.jJQ != null) {
            this.jJQ.cOH();
        }
    }

    public void startPullRefresh() {
        this.gsg.setRefreshing(true);
    }

    public void bSm() {
        this.gsg.setRefreshing(false);
    }

    public void ib(boolean z) {
        if (!cqz()) {
            if (this.gAg == null) {
                this.gAg = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gAg.bDY();
                this.gAg.setTopMargin(height);
                this.gAg.onChangeSkinType();
            }
            this.gAg.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this);
            this.gAg = null;
        }
    }

    public boolean cqz() {
        if (this.gAg != null) {
            return this.gAg.isViewAttached();
        }
        return false;
    }

    public void px(boolean z) {
        if (!cqA()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.jPR != null) {
                            HotTopicTabView.this.ib(false);
                            HotTopicTabView.this.jPR.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqA() {
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
            if (this.gAg != null) {
                this.gAg.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jPU != null) {
                this.jPU.notifyDataSetChanged();
            }
            if (this.grg != null) {
                this.grg.changeSkin(skinType);
                this.grg.setContainerBackgroundColorResId(R.color.transparent);
            }
            if (this.jPV != null) {
                this.jPV.onChangeSkinType(skinType);
            }
            if (this.Yf != null) {
                if (!d.bkA()) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(this.Yf).setBackGroundColor(R.color.CAM_X0202);
                } else {
                    com.baidu.tbadk.core.elementsMaven.c.bm(this.Yf).setBackGroundColor(R.color.CAM_X0204);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jJP = scrollFragmentTabHost;
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
            this.jJP.a(this.jJQ);
        }
    }

    public void destroy() {
        if (this.jJP != null) {
            this.jJP.b(this.jJQ);
        }
        bSm();
        hideLoadingView();
        Yb();
        this.hFv = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jPR.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.ajQ = fVar;
        if (this.jPU != null) {
            this.jPU.setOnItemCoverListener(fVar);
        }
        if (this.jPV != null) {
            this.jPV.setOnItemCoverListener(fVar);
        }
    }
}
