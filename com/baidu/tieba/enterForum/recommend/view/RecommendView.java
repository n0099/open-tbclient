package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView NY;
    private g dhY;
    private BdSwipeRefreshLayout doj;
    private NoNetworkView.a eCl;
    private com.baidu.tieba.enterForum.recommend.a eUB;
    private RecommendForumHeaderView eWa;
    private com.baidu.tieba.enterForum.recommend.a.a eWb;
    private com.baidu.tieba.enterForum.recommend.b.a eWc;
    private com.baidu.tieba.enterForum.home.c eWd;
    private long eWe;
    private CustomMessageListener eWf;
    private CustomMessageListener eWg;
    c.a eWh;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private int mSkinType;

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public RecommendView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.eWf = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.eWa != null) {
                    RecommendView.this.eWa.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                if (z && RecommendView.this.eUB != null) {
                    RecommendView.this.eUB.loadData();
                }
            }
        };
        this.eWg = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.eWc != null && l != null) {
                        RecommendView.this.eWe = l.longValue();
                        if (RecommendView.this.eUB != null) {
                            RecommendView.this.eUB.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int dnp = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dnp != i && RecommendView.this.eWd != null) {
                    this.dnp = i;
                    if (this.dnp == 1) {
                        RecommendView.this.eWd.aHU();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.eWd.aHV();
                    } else {
                        RecommendView.this.eWd.aHU();
                    }
                    RecommendView.this.eWa.beD();
                }
            }
        };
        this.eWh = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void bea() {
                if (RecommendView.this.eWd != null) {
                    if (RecommendView.this.a(RecommendView.this.NY)) {
                        RecommendView.this.eWd.aHV();
                    } else {
                        RecommendView.this.eWd.aHU();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.eWg);
        tbPageContext.registerListener(this.eWf);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setPadding(0, UtilHelper.getStatusBarHeight() + getResources().getDimensionPixelOffset(R.dimen.tbds140), 0, 0);
        this.doj = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.doj.setProgressView(this.mPullView);
        this.NY = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.NY.setLayoutManager(new LinearLayoutManager(context));
        this.NY.setFadingEdgeLength(0);
        this.NY.setOverScrollMode(2);
        this.NY.addOnScrollListener(this.mOnScrollListener);
        this.eWb = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.NY);
        this.eWa = new RecommendForumHeaderView(this.mPageContext);
        this.eWa.setOnSecectedListener(this);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eWb != null) {
            this.eWb.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.eWa != null) {
            this.eWa.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.eUB = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.eWc = aVar;
            if (v.aa(aVar.bes()) && v.aa(aVar.ber())) {
                showNoDataView();
                return;
            }
            aUH();
            List<f> cU = aVar.cU(this.eWe);
            this.eWe = 0L;
            f fVar = (f) v.c(cU, 1);
            if (fVar == null) {
                fVar = (f) v.c(cU, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bH(cU);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cW(long j) {
        a(this.eWc, j);
    }

    private void bH(List<f> list) {
        if (this.NY.getHeaderViewsCount() == 0) {
            this.NY.addHeaderView(this.eWa);
        }
        this.eWa.setData(list);
        this.eWa.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.eWb.setData(aVar.cV(j));
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void aIc() {
        this.doj.setRefreshing(false);
    }

    public void aUH() {
        if (this.NY != null) {
            this.NY.setVisibility(0);
        }
    }

    public void cV(boolean z) {
        if (!beF()) {
            if (this.dhY == null) {
                this.dhY = new g(getContext());
                this.dhY.onChangeSkinType();
            }
            this.dhY.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dhY != null) {
            this.dhY.dettachView(this);
            this.dhY = null;
        }
    }

    public boolean beF() {
        if (this.dhY != null) {
            return this.dhY.isViewAttached();
        }
        return false;
    }

    public void jk(boolean z) {
        if (!beG()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG() && RecommendView.this.eUB != null) {
                            RecommendView.this.eUB.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.kC(R.drawable.new_pic_emotion_09);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.asB();
            this.NY.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jG() && RecommendView.this.eUB != null) {
                        RecommendView.this.eUB.loadData();
                    }
                }
            });
        }
        this.mRefreshView.kC(R.drawable.new_pic_emotion_05);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.no_data_text));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.asB();
        this.NY.setVisibility(8);
    }

    public void aHK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean beG() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.iP(skinType);
            }
            if (this.dhY != null) {
                this.dhY.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.eWb != null) {
                this.eWb.notifyDataSetChanged();
            }
            if (this.eWa != null) {
                this.eWa.onChangeSkinType();
            }
            al.l(this.doj, R.color.cp_bg_line_e);
            al.l(this.NY, R.color.cp_bg_line_c);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.eWd = cVar;
        if (this.eWd != null) {
            this.eWd.b(this.eWh);
            this.eWd.a(this.eWh);
        }
    }

    public void onDestroy() {
        if (this.NY != null) {
            this.NY.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.eWd != null) {
            this.eWd.b(this.eWh);
        }
        aIc();
        hideLoadingView();
        aHK();
        if (this.eWa != null) {
            this.eWa.beE();
        }
    }
}
