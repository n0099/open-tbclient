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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView Qr;
    private g cXm;
    private BdSwipeRefreshLayout ddB;
    private com.baidu.tieba.enterForum.recommend.a eEU;
    private RecommendForumHeaderView eGs;
    private com.baidu.tieba.enterForum.recommend.a.a eGt;
    private com.baidu.tieba.enterForum.recommend.b.a eGu;
    private com.baidu.tieba.enterForum.home.c eGv;
    private long eGw;
    private CustomMessageListener eGx;
    private CustomMessageListener eGy;
    c.a eGz;
    private NoNetworkView.a emM;
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
        this.eGx = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.eGs != null) {
                    RecommendView.this.eGs.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.emM = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && RecommendView.this.eEU != null) {
                    RecommendView.this.eEU.loadData();
                }
            }
        };
        this.eGy = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.eGu != null && l != null) {
                        RecommendView.this.eGw = l.longValue();
                        if (RecommendView.this.eEU != null) {
                            RecommendView.this.eEU.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int dcH = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcH != i && RecommendView.this.eGv != null) {
                    this.dcH = i;
                    if (this.dcH == 1) {
                        RecommendView.this.eGv.aBE();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.eGv.aBF();
                    } else {
                        RecommendView.this.eGv.aBE();
                    }
                    RecommendView.this.eGs.aXp();
                }
            }
        };
        this.eGz = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void aWM() {
                if (RecommendView.this.eGv != null) {
                    if (RecommendView.this.a(RecommendView.this.Qr)) {
                        RecommendView.this.eGv.aBF();
                    } else {
                        RecommendView.this.eGv.aBE();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.eGy);
        tbPageContext.registerListener(this.eGx);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.fragment_enter_recommend_layout, (ViewGroup) this, true);
        this.ddB = (BdSwipeRefreshLayout) findViewById(d.g.enter_recommend_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.ddB.setProgressView(this.mPullView);
        this.Qr = (BdTypeRecyclerView) findViewById(d.g.enter_recommend_list_view);
        this.Qr.setLayoutManager(new LinearLayoutManager(context));
        this.Qr.setFadingEdgeLength(0);
        this.Qr.setOverScrollMode(2);
        this.Qr.addOnScrollListener(this.mOnScrollListener);
        this.eGt = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Qr);
        this.eGs = new RecommendForumHeaderView(this.mPageContext);
        this.eGs.setOnSecectedListener(this);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eGt != null) {
            this.eGt.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.eEU = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.eGu = aVar;
            if (v.T(aVar.aXd()) && v.T(aVar.aXc())) {
                showNoDataView();
                return;
            }
            aOA();
            List<f> cx = aVar.cx(this.eGw);
            this.eGw = 0L;
            f fVar = (f) v.c(cx, 1);
            if (fVar == null) {
                fVar = (f) v.c(cx, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bB(cx);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cz(long j) {
        a(this.eGu, j);
    }

    private void bB(List<f> list) {
        if (this.Qr.getHeaderViewsCount() == 0) {
            this.Qr.addHeaderView(this.eGs);
        }
        this.eGs.setData(list);
        this.eGs.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.eGt.setData(aVar.cy(j));
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void aBM() {
        this.ddB.setRefreshing(false);
    }

    public void aOA() {
        if (this.Qr != null) {
            this.Qr.setVisibility(0);
        }
    }

    public void cE(boolean z) {
        if (!aXq()) {
            if (this.cXm == null) {
                this.cXm = new g(getContext());
                this.cXm.onChangeSkinType();
            }
            this.cXm.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.cXm != null) {
            this.cXm.dettachView(this);
            this.cXm = null;
        }
    }

    public boolean aXq() {
        if (this.cXm != null) {
            return this.cXm.isViewAttached();
        }
        return false;
    }

    public void iD(boolean z) {
        if (!aXr()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && RecommendView.this.eEU != null) {
                            RecommendView.this.eEU.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(d.j.refresh_view_title_text));
            this.mRefreshView.jP(d.f.new_pic_emotion_09);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.anB();
            this.Qr.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kM() && RecommendView.this.eEU != null) {
                        RecommendView.this.eEU.loadData();
                    }
                }
            });
        }
        this.mRefreshView.jP(d.f.new_pic_emotion_05);
        this.mRefreshView.setTitle(this.mPageContext.getString(d.j.no_data_text));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.anB();
        this.Qr.setVisibility(8);
    }

    public void aBt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aXr() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0277d.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.ic(skinType);
            }
            if (this.cXm != null) {
                this.cXm.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.eGt != null) {
                this.eGt.notifyDataSetChanged();
            }
            if (this.eGs != null) {
                this.eGs.onChangeSkinType();
            }
            al.l(this.ddB, d.C0277d.cp_bg_line_e);
            al.l(this.Qr, d.C0277d.cp_bg_line_d);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.eGv = cVar;
        if (this.eGv != null) {
            this.eGv.b(this.eGz);
            this.eGv.a(this.eGz);
        }
    }

    public void onDestroy() {
        if (this.Qr != null) {
            this.Qr.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.eGv != null) {
            this.eGv.b(this.eGz);
        }
        aBM();
        hideLoadingView();
        aBt();
    }
}
