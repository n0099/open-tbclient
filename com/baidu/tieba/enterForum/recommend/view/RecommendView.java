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
    private BdTypeRecyclerView NZ;
    private g dhX;
    private BdSwipeRefreshLayout doi;
    private NoNetworkView.a eCk;
    private com.baidu.tieba.enterForum.recommend.a eUA;
    private RecommendForumHeaderView eVZ;
    private com.baidu.tieba.enterForum.recommend.a.a eWa;
    private com.baidu.tieba.enterForum.recommend.b.a eWb;
    private com.baidu.tieba.enterForum.home.c eWc;
    private long eWd;
    private CustomMessageListener eWe;
    private CustomMessageListener eWf;
    c.a eWg;
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
        this.eWe = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.eVZ != null) {
                    RecommendView.this.eVZ.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.eCk = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                if (z && RecommendView.this.eUA != null) {
                    RecommendView.this.eUA.loadData();
                }
            }
        };
        this.eWf = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.eWb != null && l != null) {
                        RecommendView.this.eWd = l.longValue();
                        if (RecommendView.this.eUA != null) {
                            RecommendView.this.eUA.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int dno = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dno != i && RecommendView.this.eWc != null) {
                    this.dno = i;
                    if (this.dno == 1) {
                        RecommendView.this.eWc.aHR();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.eWc.aHS();
                    } else {
                        RecommendView.this.eWc.aHR();
                    }
                    RecommendView.this.eVZ.beA();
                }
            }
        };
        this.eWg = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void bdX() {
                if (RecommendView.this.eWc != null) {
                    if (RecommendView.this.a(RecommendView.this.NZ)) {
                        RecommendView.this.eWc.aHS();
                    } else {
                        RecommendView.this.eWc.aHR();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.eWf);
        tbPageContext.registerListener(this.eWe);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setPadding(0, UtilHelper.getStatusBarHeight() + getResources().getDimensionPixelOffset(R.dimen.tbds140), 0, 0);
        this.doi = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.doi.setProgressView(this.mPullView);
        this.NZ = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.NZ.setLayoutManager(new LinearLayoutManager(context));
        this.NZ.setFadingEdgeLength(0);
        this.NZ.setOverScrollMode(2);
        this.NZ.addOnScrollListener(this.mOnScrollListener);
        this.eWa = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.NZ);
        this.eVZ = new RecommendForumHeaderView(this.mPageContext);
        this.eVZ.setOnSecectedListener(this);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eWa != null) {
            this.eWa.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.eVZ != null) {
            this.eVZ.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.eUA = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.eWb = aVar;
            if (v.aa(aVar.bep()) && v.aa(aVar.beo())) {
                showNoDataView();
                return;
            }
            aUE();
            List<f> cU = aVar.cU(this.eWd);
            this.eWd = 0L;
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
        a(this.eWb, j);
    }

    private void bH(List<f> list) {
        if (this.NZ.getHeaderViewsCount() == 0) {
            this.NZ.addHeaderView(this.eVZ);
        }
        this.eVZ.setData(list);
        this.eVZ.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.eWa.setData(aVar.cV(j));
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void aHZ() {
        this.doi.setRefreshing(false);
    }

    public void aUE() {
        if (this.NZ != null) {
            this.NZ.setVisibility(0);
        }
    }

    public void cV(boolean z) {
        if (!beC()) {
            if (this.dhX == null) {
                this.dhX = new g(getContext());
                this.dhX.onChangeSkinType();
            }
            this.dhX.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dhX != null) {
            this.dhX.dettachView(this);
            this.dhX = null;
        }
    }

    public boolean beC() {
        if (this.dhX != null) {
            return this.dhX.isViewAttached();
        }
        return false;
    }

    public void jk(boolean z) {
        if (!beD()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG() && RecommendView.this.eUA != null) {
                            RecommendView.this.eUA.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.kC(R.drawable.new_pic_emotion_09);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.asB();
            this.NZ.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jG() && RecommendView.this.eUA != null) {
                        RecommendView.this.eUA.loadData();
                    }
                }
            });
        }
        this.mRefreshView.kC(R.drawable.new_pic_emotion_05);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.no_data_text));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.asB();
        this.NZ.setVisibility(8);
    }

    public void aHH() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean beD() {
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
            if (this.dhX != null) {
                this.dhX.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.eWa != null) {
                this.eWa.notifyDataSetChanged();
            }
            if (this.eVZ != null) {
                this.eVZ.onChangeSkinType();
            }
            al.l(this.doi, R.color.cp_bg_line_e);
            al.l(this.NZ, R.color.cp_bg_line_c);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.eWc = cVar;
        if (this.eWc != null) {
            this.eWc.b(this.eWg);
            this.eWc.a(this.eWg);
        }
    }

    public void onDestroy() {
        if (this.NZ != null) {
            this.NZ.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.eWc != null) {
            this.eWc.b(this.eWg);
        }
        aHZ();
        hideLoadingView();
        aHH();
        if (this.eVZ != null) {
            this.eVZ.beB();
        }
    }
}
