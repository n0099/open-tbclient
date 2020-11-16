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
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.hotTopic.tab.a.h;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes21.dex */
public class HotTopicTabView extends FrameLayout implements f.c {
    private BdTypeRecyclerView Xi;
    private com.baidu.tbadk.h.f aiR;
    private PbListView giV;
    private BdSwipeRefreshLayout gjV;
    private int glw;
    private g grV;
    private boolean hvP;
    private TabLayout.OnTabSelectedListener jCk;
    private b jCn;
    private h jCq;
    private HotTopicHeaderView jCr;
    private ScrollFragmentTabHost jwm;
    ScrollFragmentTabHost.a jwn;
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
        this.glw = -1;
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.1
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (HotTopicTabView.this.glw != i && HotTopicTabView.this.jwm != null) {
                    HotTopicTabView.this.glw = i;
                    if (HotTopicTabView.this.glw == 1) {
                        HotTopicTabView.this.jwm.bOJ();
                    } else if (HotTopicTabView.this.a(recyclerView)) {
                        HotTopicTabView.this.jwm.bOK();
                    } else {
                        HotTopicTabView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.jwn = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.2
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void cJr() {
                if (HotTopicTabView.this.jwm != null) {
                    HotTopicTabView.this.glw = -1;
                    if (HotTopicTabView.this.a(HotTopicTabView.this.Xi)) {
                        HotTopicTabView.this.jwm.bOK();
                    } else {
                        HotTopicTabView.this.jwm.bOJ();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        bVF();
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_hot_topic_tab_layout, (ViewGroup) this, true);
        this.gjV = (BdSwipeRefreshLayout) findViewById(R.id.hotTopicRefreshLayout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gjV.setProgressView(this.mPullView);
        this.Xi = (BdTypeRecyclerView) findViewById(R.id.hotTopicListView);
        this.Xi.setLayoutManager(new LinearLayoutManager(context));
        this.Xi.setFadingEdgeLength(0);
        this.Xi.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        if (!d.bhw()) {
            this.Xi.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        this.jCq = new h(this.mPageContext, this.Xi);
        this.giV = new PbListView(this.mPageContext.getPageActivity());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0111);
    }

    private void bVF() {
        this.Xi.addOnScrollListener(this.mOnScrollListener);
        this.mPullView.setListPullRefreshListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jCk = onTabSelectedListener;
    }

    public void setViewForeground() {
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
            this.jwm.a(this.jwn);
            this.jwn.cJr();
        }
        if (this.hvP) {
            this.hvP = false;
            if (y.isEmpty(this.jCq.getData())) {
                this.jCn.loadData();
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (this.jCq != null) {
            this.jCq.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(b bVar) {
        this.jCn = bVar;
    }

    public void setData(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        a(aVar);
        setListData(aVar.getDataList());
    }

    public boolean cKf() {
        return (this.jCr == null || this.jCr.getParent() == null) ? false : true;
    }

    public void a(@NonNull com.baidu.tieba.homepage.hotTopic.tab.net.a aVar) {
        if (this.jCr == null) {
            this.jCr = new HotTopicHeaderView(getContext());
        }
        this.Xi.setHeaderView(this.jCr);
        this.jCr.setOnItemCoverListener(this.aiR);
        this.jCr.setOnTabSelectedListener(this.jCk);
        this.jCr.setData(aVar.getResData());
    }

    public void setListData(@NonNull List<q> list) {
        this.jCq.setData(list);
    }

    public void VA() {
        this.Xi.setNextPage(this.giV);
        this.giV.endLoadData();
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.aq(getResources().getString(R.string.really_great), l.getDimens(getContext(), R.dimen.tbds158));
    }

    public void cKg() {
        this.Xi.setNextPage(null);
    }

    public void reload() {
        this.Xi.setSelection(0);
        startPullRefresh();
        if (this.jwn != null) {
            this.jwn.cJr();
        }
    }

    public void startPullRefresh() {
        this.gjV.setRefreshing(true);
    }

    public void bOA() {
        this.gjV.setRefreshing(false);
    }

    public void hM(boolean z) {
        if (!cml()) {
            if (this.grV == null) {
                this.grV = new g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.grV.bAw();
                this.grV.setTopMargin(height);
                this.grV.onChangeSkinType();
            }
            this.grV.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this);
            this.grV = null;
        }
    }

    public boolean cml() {
        if (this.grV != null) {
            return this.grV.isViewAttached();
        }
        return false;
    }

    public void pb(boolean z) {
        if (!cmm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.hotTopic.tab.HotTopicTabView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && HotTopicTabView.this.jCn != null) {
                            HotTopicTabView.this.hM(false);
                            HotTopicTabView.this.jCn.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cmm() {
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
            if (this.grV != null) {
                this.grV.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jCq != null) {
                this.jCq.notifyDataSetChanged();
            }
            if (this.giV != null) {
                this.giV.changeSkin(skinType);
                this.giV.setContainerBackgroundColorResId(R.color.transparent);
            }
            if (this.jCr != null) {
                this.jCr.onChangeSkinType(skinType);
            }
            if (this.Xi != null) {
                if (!d.bhw()) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(this.Xi).setBackGroundColor(R.color.CAM_X0202);
                } else {
                    com.baidu.tbadk.core.elementsMaven.c.bj(this.Xi).setBackGroundColor(R.color.CAM_X0204);
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
        this.jwm = scrollFragmentTabHost;
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
            this.jwm.a(this.jwn);
        }
    }

    public void destroy() {
        if (this.jwm != null) {
            this.jwm.b(this.jwn);
        }
        bOA();
        hideLoadingView();
        VB();
        this.hvP = true;
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jCn.loadData();
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        this.aiR = fVar;
        if (this.jCq != null) {
            this.jCq.setOnItemCoverListener(fVar);
        }
        if (this.jCr != null) {
            this.jCr.setOnItemCoverListener(fVar);
        }
    }
}
