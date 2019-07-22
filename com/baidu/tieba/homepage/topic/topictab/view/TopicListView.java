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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicListView extends FrameLayout {
    private BdTypeRecyclerView Op;
    private g djG;
    private PbListView dnG;
    private int dpp;
    private BdSwipeRefreshLayout dqr;
    private NoNetworkView.a eHh;
    private ScrollFragmentTabHost gca;
    ScrollFragmentTabHost.a gcb;
    private com.baidu.tieba.homepage.topic.topictab.a.b gnC;
    private com.baidu.tieba.homepage.topic.topictab.a gnp;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public TopicListView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.dpp = -1;
        this.eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                if (z && TopicListView.this.gnp != null) {
                    TopicListView.this.gnp.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.dpp != i && TopicListView.this.gca != null) {
                    TopicListView.this.dpp = i;
                    if (TopicListView.this.dpp == 1) {
                        TopicListView.this.gca.aJu();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.gca.aJv();
                    } else {
                        TopicListView.this.gca.aJu();
                    }
                }
            }
        };
        this.gcb = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvM() {
                if (TopicListView.this.gca != null) {
                    TopicListView.this.dpp = -1;
                    if (TopicListView.this.a(TopicListView.this.Op)) {
                        TopicListView.this.gca.aJv();
                    } else {
                        TopicListView.this.gca.aJu();
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
        this.dqr = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.dqr.setProgressView(this.mPullView);
        this.Op = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.Op.setLayoutManager(new LinearLayoutManager(context));
        this.Op.setFadingEdgeLength(0);
        this.Op.setOverScrollMode(2);
        this.gnC = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Op);
        this.dnG = new PbListView(this.mPageContext.getPageActivity());
        this.dnG.nZ();
        this.dnG.iU(R.color.cp_bg_line_e);
    }

    public void bpT() {
        this.Op.removeOnScrollListener(this.mOnScrollListener);
        this.Op.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.gca != null) {
            this.gca.b(this.gcb);
            this.gca.a(this.gcb);
            this.gcb.bvM();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gnC != null) {
            this.gnC.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.gnp = aVar;
    }

    public void setData(List<m> list) {
        if (!v.aa(list)) {
            this.gnC.setData(list);
        }
    }

    public void aKj() {
        this.Op.setNextPage(this.dnG);
        this.dnG.akE();
        this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnG.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.dnG.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Op.setSelection(0);
        startPullRefresh();
        if (this.gcb != null) {
            this.gcb.bvM();
        }
    }

    public void aKh() {
        this.gnC.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.dqr.setRefreshing(true);
    }

    public void aJB() {
        this.dqr.setRefreshing(false);
    }

    public void aVP() {
        if (this.Op != null) {
            this.Op.setVisibility(0);
        }
    }

    public void cY(boolean z) {
        if (!bgI()) {
            if (this.djG == null) {
                this.djG = new g(getContext());
                this.djG.onChangeSkinType();
            }
            this.djG.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.djG != null) {
            this.djG.dettachView(this);
            this.djG = null;
        }
    }

    public boolean bgI() {
        if (this.djG != null) {
            return this.djG.isViewAttached();
        }
        return false;
    }

    public void ju(boolean z) {
        if (!bgJ()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && TopicListView.this.gnp != null) {
                            TopicListView.this.Op.setVisibility(0);
                            TopicListView.this.gnp.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atI();
            this.Op.setVisibility(8);
        }
    }

    public void aJh() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bgJ() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.iV(skinType);
            }
            if (this.djG != null) {
                this.djG.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gnC != null) {
                this.gnC.notifyDataSetChanged();
            }
            am.l(this.dqr, R.color.cp_bg_line_e);
            am.l(this.Op, R.color.cp_bg_line_d);
            if (this.dnG != null) {
                this.dnG.iV(skinType);
                this.dnG.iU(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gca = scrollFragmentTabHost;
        if (this.gca != null) {
            this.gca.b(this.gcb);
            this.gca.a(this.gcb);
        }
    }

    public void destroy() {
        if (this.gca != null) {
            this.gca.b(this.gcb);
        }
        this.Op.removeOnScrollListener(this.mOnScrollListener);
        aJB();
        hideLoadingView();
        aJh();
    }
}
