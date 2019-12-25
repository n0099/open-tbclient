package com.baidu.tieba.homepage.topic.topictab.view;

import android.content.Context;
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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes6.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Bn;
    private PbListView egU;
    private int eiC;
    private BdSwipeRefreshLayout ejE;
    private g eoy;
    private NoNetworkView.a fTz;
    private ScrollFragmentTabHost gRx;
    ScrollFragmentTabHost.a gRy;
    private com.baidu.tieba.homepage.topic.topictab.a hch;
    private com.baidu.tieba.homepage.topic.topictab.a.b hcu;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public TopicListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eiC = -1;
        this.fTz = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicListView.this.hch != null) {
                    TopicListView.this.hch.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.eiC != i && TopicListView.this.gRx != null) {
                    TopicListView.this.eiC = i;
                    if (TopicListView.this.eiC == 1) {
                        TopicListView.this.gRx.aZW();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.gRx.aZX();
                    } else {
                        TopicListView.this.gRx.aZW();
                    }
                }
            }
        };
        this.gRy = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bLe() {
                if (TopicListView.this.gRx != null) {
                    TopicListView.this.eiC = -1;
                    if (TopicListView.this.a(TopicListView.this.Bn)) {
                        TopicListView.this.gRx.aZX();
                    } else {
                        TopicListView.this.gRx.aZW();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_topic_list_layout, (ViewGroup) this, true);
        this.ejE = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.ejE.setProgressView(this.mPullView);
        this.Bn = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.Bn.setLayoutManager(new LinearLayoutManager(context));
        this.Bn.setFadingEdgeLength(0);
        this.Bn.setOverScrollMode(2);
        this.hcu = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Bn);
        this.egU = new PbListView(this.mPageContext.getPageActivity());
        this.egU.createView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
    }

    public void initListeners() {
        this.Bn.removeOnScrollListener(this.mOnScrollListener);
        this.Bn.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.gRx != null) {
            this.gRx.b(this.gRy);
            this.gRx.a(this.gRy);
            this.gRy.bLe();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hcu != null) {
            this.hcu.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.hch = aVar;
    }

    public void setData(List<m> list) {
        if (!v.isEmpty(list)) {
            this.hcu.setData(list);
        }
    }

    public void baG() {
        this.Bn.setNextPage(this.egU);
        this.egU.endLoadData();
        this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.egU.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.egU.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Bn.setSelection(0);
        startPullRefresh();
        if (this.gRy != null) {
            this.gRy.bLe();
        }
    }

    public void baE() {
        this.hcu.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.ejE.setRefreshing(true);
    }

    public void bad() {
        this.ejE.setRefreshing(false);
    }

    public void bdR() {
        if (this.Bn != null) {
            this.Bn.setVisibility(0);
        }
    }

    public void eA(boolean z) {
        if (!bwE()) {
            if (this.eoy == null) {
                this.eoy = new com.baidu.tbadk.k.g(getContext());
                int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                this.eoy.aNc();
                this.eoy.setTopMargin(height);
                this.eoy.onChangeSkinType();
            }
            this.eoy.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this);
            this.eoy = null;
        }
    }

    public boolean bwE() {
        if (this.eoy != null) {
            return this.eoy.isViewAttached();
        }
        return false;
    }

    public void ky(boolean z) {
        if (!bwF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicListView.this.hch != null) {
                            TopicListView.this.Bn.setVisibility(0);
                            TopicListView.this.hch.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Bn.setVisibility(8);
        }
    }

    public void aZK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bwF() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.eoy != null) {
                this.eoy.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hcu != null) {
                this.hcu.notifyDataSetChanged();
            }
            am.setBackgroundColor(this.ejE, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Bn, R.color.cp_bg_line_d);
            if (this.egU != null) {
                this.egU.changeSkin(skinType);
                this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gRx = scrollFragmentTabHost;
        if (this.gRx != null) {
            this.gRx.b(this.gRy);
            this.gRx.a(this.gRy);
        }
    }

    public void destroy() {
        if (this.gRx != null) {
            this.gRx.b(this.gRy);
        }
        this.Bn.removeOnScrollListener(this.mOnScrollListener);
        bad();
        hideLoadingView();
        aZK();
    }
}
