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
    private BdTypeRecyclerView Ya;
    private com.baidu.tbadk.h.f ajB;
    private g gGD;
    private PbListView gxy;
    private BdSwipeRefreshLayout gyy;
    private int gzZ;
    private boolean hMP;
    private ScrollFragmentTabHost jSw;
    ScrollFragmentTabHost.a jSx;
    private b jYA;
    private h jYD;
    private HotTopicHeaderView jYE;
    private TabLayout.OnTabSelectedListener jYx;
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
        this.gzZ = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.gzZ != i && HotTopicTabView.this.jSw != null) {
                    HotTopicTabView.this.gzZ = i;
                    if (HotTopicTabView.this.gzZ == 1) {
                        HotTopicTabView.this.jSw.bRg();
                    } else if (HotTopicTabView.this.c(recyclerView)) {
                        HotTopicTabView.this.jSw.bRh();
                    } else {
                        HotTopicTabView.this.jSw.bRg();
                    }
                }
            }
        };
        this.jSx = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cNW() {
                if (HotTopicTabView.this.jSw != null) {
                    HotTopicTabView.this.gzZ = -1;
                    if (HotTopicTabView.this.c(HotTopicTabView.this.Ya)) {
                        HotTopicTabView.this.jSw.bRh();
                    } else {
                        HotTopicTabView.this.jSw.bRg();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bYg();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.gyy = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gyy.setProgressView(this.mPullView);
        this.Ya = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Ya.setLayoutManager(new LinearLayoutManager(context));
        this.Ya.setFadingEdgeLength(0);
        this.Ya.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Ya.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.jYD = new h(this.mPageContext, this.Ya);
        this.gxy = new PbListView(this.mPageContext.getPageActivity());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0111);
    }

    private void bYg() {
        this.Ya.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jYx = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
            this.jSw.a(this.jSx);
            this.jSx.cNW();
        }
        if (this.hMP) {
            this.hMP = false;
            if (x.isEmpty(this.jYD.getData())) {
                this.jYA.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.jYD != null) {
            this.jYD.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.jYA = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cOK() {
        return (this.jYE == null || this.jYE.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.jYE == null) {
            this.jYE = new HotTopicHeaderView(getContext());
        }
        this.Ya.setHeaderView(this.jYE);
        this.jYE.setOnItemCoverListener(this.ajB);
        this.jYE.setOnTabSelectedListener(this.jYx);
        this.jYE.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<n> list) {
        this.jYD.setData(list);
    }

    public void Vp() {
        this.Ya.setNextPage(this.gxy);
        this.gxy.endLoadData();
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.at(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cOL() {
        this.Ya.setNextPage(null);
    }

    public void reload() {
        this.Ya.setSelection(0);
        startPullRefresh();
        if (this.jSx != null) {
            this.jSx.cNW();
        }
    }

    public void startPullRefresh() {
        this.gyy.setRefreshing(true);
    }

    public void bQX() {
        this.gyy.setRefreshing(false);
    }

    public void ip(boolean z) {
        if (!cpB()) {
            if (this.gGD == null) {
                this.gGD = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.gGD.bCA();
                this.gGD.setTopMargin(height);
                this.gGD.onChangeSkinType();
            }
            this.gGD.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
        }
    }

    public boolean cpB() {
        if (this.gGD != null) {
            return this.gGD.isViewAttached();
        }
        return false;
    }

    public void pQ(boolean z) {
        if (!cpC()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.l.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.jYA != null) {
                            HotTopicTabView.this.ip(false);
                            HotTopicTabView.this.jYA.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cpC() {
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
            if (this.gGD != null) {
                this.gGD.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jYD != null) {
                this.jYD.notifyDataSetChanged();
            }
            if (this.gxy != null) {
                this.gxy.changeSkin(skinType);
                this.gxy.setContainerBackgroundColorResId(R.color.transparent);
            }
            if (this.jYE != null) {
                this.jYE.onChangeSkinType(skinType);
            }
            if (this.Ya != null) {
                com.baidu.tbadk.core.elementsMaven.c.bv(this.Ya).setBackGroundColor(R.color.CAM_X0202);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jSw = scrollFragmentTabHost;
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
            this.jSw.a(this.jSx);
        }
    }

    public void destroy() {
        if (this.jSw != null) {
            this.jSw.b(this.jSx);
        }
        bQX();
        hideLoadingView();
        Vq();
        this.hMP = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jYA.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.ajB = fVar;
        if (this.jYD != null) {
            this.jYD.setOnItemCoverListener(fVar);
        }
        if (this.jYE != null) {
            this.jYE.setOnItemCoverListener(fVar);
        }
    }
}
