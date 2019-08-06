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
    private g djN;
    private PbListView dnN;
    private int dpw;
    private BdSwipeRefreshLayout dqy;
    private NoNetworkView.a eHo;
    private ScrollFragmentTabHost gcQ;
    ScrollFragmentTabHost.a gcR;
    private com.baidu.tieba.homepage.topic.topictab.a goh;
    private com.baidu.tieba.homepage.topic.topictab.a.b gou;
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
        this.dpw = -1;
        this.eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                if (z && TopicListView.this.goh != null) {
                    TopicListView.this.goh.loadData();
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.2
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (TopicListView.this.dpw != i && TopicListView.this.gcQ != null) {
                    TopicListView.this.dpw = i;
                    if (TopicListView.this.dpw == 1) {
                        TopicListView.this.gcQ.aJw();
                    } else if (TopicListView.this.a(recyclerView)) {
                        TopicListView.this.gcQ.aJx();
                    } else {
                        TopicListView.this.gcQ.aJw();
                    }
                }
            }
        };
        this.gcR = new ScrollFragmentTabHost.a() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.3
            @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
            public void bvZ() {
                if (TopicListView.this.gcQ != null) {
                    TopicListView.this.dpw = -1;
                    if (TopicListView.this.a(TopicListView.this.Op)) {
                        TopicListView.this.gcQ.aJx();
                    } else {
                        TopicListView.this.gcQ.aJw();
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
        this.dqy = (BdSwipeRefreshLayout) findViewById(R.id.topic_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.dqy.setProgressView(this.mPullView);
        this.Op = (BdTypeRecyclerView) findViewById(R.id.topic_list_view);
        this.Op.setLayoutManager(new LinearLayoutManager(context));
        this.Op.setFadingEdgeLength(0);
        this.Op.setOverScrollMode(2);
        this.gou = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext, this.Op);
        this.dnN = new PbListView(this.mPageContext.getPageActivity());
        this.dnN.nZ();
        this.dnN.iU(R.color.cp_bg_line_e);
    }

    public void bqg() {
        this.Op.removeOnScrollListener(this.mOnScrollListener);
        this.Op.addOnScrollListener(this.mOnScrollListener);
    }

    public void setViewForeground() {
        if (this.gcQ != null) {
            this.gcQ.b(this.gcR);
            this.gcQ.a(this.gcR);
            this.gcR.bvZ();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gou != null) {
            this.gou.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.homepage.topic.topictab.a aVar) {
        this.goh = aVar;
    }

    public void setData(List<m> list) {
        if (!v.aa(list)) {
            this.gou.setData(list);
        }
    }

    public void aKl() {
        this.Op.setNextPage(this.dnN);
        this.dnN.akG();
        this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnN.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds150));
        this.dnN.setText(getResources().getString(R.string.really_great));
    }

    public void reload() {
        this.Op.setSelection(0);
        startPullRefresh();
        if (this.gcR != null) {
            this.gcR.bvZ();
        }
    }

    public void aKj() {
        this.gou.notifyDataSetChanged();
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void startPullRefresh() {
        this.dqy.setRefreshing(true);
    }

    public void aJD() {
        this.dqy.setRefreshing(false);
    }

    public void aVR() {
        if (this.Op != null) {
            this.Op.setVisibility(0);
        }
    }

    public void cY(boolean z) {
        if (!bgL()) {
            if (this.djN == null) {
                this.djN = new g(getContext());
                this.djN.onChangeSkinType();
            }
            this.djN.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.djN != null) {
            this.djN.dettachView(this);
            this.djN = null;
        }
    }

    public boolean bgL() {
        if (this.djN != null) {
            return this.djN.isViewAttached();
        }
        return false;
    }

    public void ju(boolean z) {
        if (!bgM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicListView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && TopicListView.this.goh != null) {
                            TopicListView.this.Op.setVisibility(0);
                            TopicListView.this.goh.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atK();
            this.Op.setVisibility(8);
        }
    }

    public void aJj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bgM() {
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
            if (this.djN != null) {
                this.djN.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gou != null) {
                this.gou.notifyDataSetChanged();
            }
            am.l(this.dqy, R.color.cp_bg_line_e);
            am.l(this.Op, R.color.cp_bg_line_d);
            if (this.dnN != null) {
                this.dnN.iV(skinType);
                this.dnN.iU(R.color.cp_bg_line_e);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gcQ = scrollFragmentTabHost;
        if (this.gcQ != null) {
            this.gcQ.b(this.gcR);
            this.gcQ.a(this.gcR);
        }
    }

    public void destroy() {
        if (this.gcQ != null) {
            this.gcQ.b(this.gcR);
        }
        this.Op.removeOnScrollListener(this.mOnScrollListener);
        aJD();
        hideLoadingView();
        aJj();
    }
}
