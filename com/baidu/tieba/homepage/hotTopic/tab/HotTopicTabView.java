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
    private g gAe;
    private PbListView gre;
    private BdSwipeRefreshLayout gse;
    private int gtF;
    private boolean hFt;
    private ScrollFragmentTabHost jJN;
    ScrollFragmentTabHost.a jJO;
    private TabLayout.OnTabSelectedListener jPM;
    private b jPP;
    private h jPS;
    private HotTopicHeaderView jPT;
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
        this.gtF = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.gtF != i && HotTopicTabView.this.jJN != null) {
                    HotTopicTabView.this.gtF = i;
                    if (HotTopicTabView.this.gtF == 1) {
                        HotTopicTabView.this.jJN.bSu();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.jJN.bSv();
                    } else {
                        HotTopicTabView.this.jJN.bSu();
                    }
                }
            }
        };
        this.jJO = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cOG() {
                if (HotTopicTabView.this.jJN != null) {
                    HotTopicTabView.this.gtF = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.Yf)) {
                        HotTopicTabView.this.jJN.bSv();
                    } else {
                        HotTopicTabView.this.jJN.bSu();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bZp();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.gse = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gse.setProgressView(this.mPullView);
        this.Yf = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Yf.setLayoutManager(new LinearLayoutManager(context));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        if (!d.bkA()) {
            this.Yf.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        this.jPS = new h(this.mPageContext, this.Yf);
        this.gre = new PbListView(this.mPageContext.getPageActivity());
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gre.setNoMoreTextColorId(R.color.CAM_X0111);
    }

    private void bZp() {
        this.Yf.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jPM = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
            this.jJN.a(this.jJO);
            this.jJO.cOG();
        }
        if (this.hFt) {
            this.hFt = false;
            if (y.isEmpty(this.jPS.getData())) {
                this.jPP.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.jPS != null) {
            this.jPS.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.jPP = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cPu() {
        return (this.jPT == null || this.jPT.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.jPT == null) {
            this.jPT = new HotTopicHeaderView(getContext());
        }
        this.Yf.setHeaderView(this.jPT);
        this.jPT.setOnItemCoverListener(this.ajQ);
        this.jPT.setOnTabSelectedListener(this.jPM);
        this.jPT.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<q> list) {
        this.jPS.setData(list);
    }

    public void Ya() {
        this.Yf.setNextPage(this.gre);
        this.gre.endLoadData();
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.ar(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cPv() {
        this.Yf.setNextPage(null);
    }

    public void reload() {
        this.Yf.setSelection(0);
        startPullRefresh();
        if (this.jJO != null) {
            this.jJO.cOG();
        }
    }

    public void startPullRefresh() {
        this.gse.setRefreshing(true);
    }

    public void bSl() {
        this.gse.setRefreshing(false);
    }

    public void ib(boolean z) {
        if (!cqy()) {
            if (this.gAe == null) {
                this.gAe = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gAe.bDY();
                this.gAe.setTopMargin(height);
                this.gAe.onChangeSkinType();
            }
            this.gAe.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this);
            this.gAe = null;
        }
    }

    public boolean cqy() {
        if (this.gAe != null) {
            return this.gAe.isViewAttached();
        }
        return false;
    }

    public void px(boolean z) {
        if (!cqz()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.jPP != null) {
                            HotTopicTabView.this.ib(false);
                            HotTopicTabView.this.jPP.loadData();
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

    public boolean cqz() {
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
            if (this.gAe != null) {
                this.gAe.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jPS != null) {
                this.jPS.notifyDataSetChanged();
            }
            if (this.gre != null) {
                this.gre.changeSkin(skinType);
                this.gre.setContainerBackgroundColorResId(R.color.transparent);
            }
            if (this.jPT != null) {
                this.jPT.onChangeSkinType(skinType);
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
        this.jJN = scrollFragmentTabHost;
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
            this.jJN.a(this.jJO);
        }
    }

    public void destroy() {
        if (this.jJN != null) {
            this.jJN.b(this.jJO);
        }
        bSl();
        hideLoadingView();
        Yb();
        this.hFt = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jPP.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.ajQ = fVar;
        if (this.jPS != null) {
            this.jPS.setOnItemCoverListener(fVar);
        }
        if (this.jPT != null) {
            this.jPT.setOnItemCoverListener(fVar);
        }
    }
}
