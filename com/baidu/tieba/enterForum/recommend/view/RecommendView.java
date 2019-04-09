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
    private g cXq;
    private BdSwipeRefreshLayout ddG;
    private com.baidu.tieba.enterForum.recommend.a eEG;
    private RecommendForumHeaderView eGf;
    private com.baidu.tieba.enterForum.recommend.a.a eGg;
    private com.baidu.tieba.enterForum.recommend.b.a eGh;
    private com.baidu.tieba.enterForum.home.c eGi;
    private long eGj;
    private CustomMessageListener eGk;
    private CustomMessageListener eGl;
    c.a eGm;
    private NoNetworkView.a emz;
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
        this.eGk = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.eGf != null) {
                    RecommendView.this.eGf.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.emz = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && RecommendView.this.eEG != null) {
                    RecommendView.this.eEG.loadData();
                }
            }
        };
        this.eGl = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.eGh != null && l != null) {
                        RecommendView.this.eGj = l.longValue();
                        if (RecommendView.this.eEG != null) {
                            RecommendView.this.eEG.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int dcM = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcM != i && RecommendView.this.eGi != null) {
                    this.dcM = i;
                    if (this.dcM == 1) {
                        RecommendView.this.eGi.aBB();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.eGi.aBC();
                    } else {
                        RecommendView.this.eGi.aBB();
                    }
                    RecommendView.this.eGf.aXn();
                }
            }
        };
        this.eGm = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void aWK() {
                if (RecommendView.this.eGi != null) {
                    if (RecommendView.this.a(RecommendView.this.Qr)) {
                        RecommendView.this.eGi.aBC();
                    } else {
                        RecommendView.this.eGi.aBB();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.eGl);
        tbPageContext.registerListener(this.eGk);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.fragment_enter_recommend_layout, (ViewGroup) this, true);
        this.ddG = (BdSwipeRefreshLayout) findViewById(d.g.enter_recommend_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.ddG.setProgressView(this.mPullView);
        this.Qr = (BdTypeRecyclerView) findViewById(d.g.enter_recommend_list_view);
        this.Qr.setLayoutManager(new LinearLayoutManager(context));
        this.Qr.setFadingEdgeLength(0);
        this.Qr.setOverScrollMode(2);
        this.Qr.addOnScrollListener(this.mOnScrollListener);
        this.eGg = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Qr);
        this.eGf = new RecommendForumHeaderView(this.mPageContext);
        this.eGf.setOnSecectedListener(this);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eGg != null) {
            this.eGg.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.eEG = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.eGh = aVar;
            if (v.T(aVar.aXb()) && v.T(aVar.aXa())) {
                showNoDataView();
                return;
            }
            aOs();
            List<f> cx = aVar.cx(this.eGj);
            this.eGj = 0L;
            f fVar = (f) v.c(cx, 1);
            if (fVar == null) {
                fVar = (f) v.c(cx, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bz(cx);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cz(long j) {
        a(this.eGh, j);
    }

    private void bz(List<f> list) {
        if (this.Qr.getHeaderViewsCount() == 0) {
            this.Qr.addHeaderView(this.eGf);
        }
        this.eGf.setData(list);
        this.eGf.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.eGg.setData(aVar.cy(j));
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void aBJ() {
        this.ddG.setRefreshing(false);
    }

    public void aOs() {
        if (this.Qr != null) {
            this.Qr.setVisibility(0);
        }
    }

    public void cE(boolean z) {
        if (!aXo()) {
            if (this.cXq == null) {
                this.cXq = new g(getContext());
                this.cXq.onChangeSkinType();
            }
            this.cXq.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.cXq != null) {
            this.cXq.dettachView(this);
            this.cXq = null;
        }
    }

    public boolean aXo() {
        if (this.cXq != null) {
            return this.cXq.isViewAttached();
        }
        return false;
    }

    public void iD(boolean z) {
        if (!aXp()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && RecommendView.this.eEG != null) {
                            RecommendView.this.eEG.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(d.j.refresh_view_title_text));
            this.mRefreshView.jO(d.f.new_pic_emotion_09);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.any();
            this.Qr.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kM() && RecommendView.this.eEG != null) {
                        RecommendView.this.eEG.loadData();
                    }
                }
            });
        }
        this.mRefreshView.jO(d.f.new_pic_emotion_05);
        this.mRefreshView.setTitle(this.mPageContext.getString(d.j.no_data_text));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.any();
        this.Qr.setVisibility(8);
    }

    public void aBq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aXp() {
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
                this.mPullView.ib(skinType);
            }
            if (this.cXq != null) {
                this.cXq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.eGg != null) {
                this.eGg.notifyDataSetChanged();
            }
            if (this.eGf != null) {
                this.eGf.onChangeSkinType();
            }
            al.l(this.ddG, d.C0277d.cp_bg_line_e);
            al.l(this.Qr, d.C0277d.cp_bg_line_d);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.eGi = cVar;
        if (this.eGi != null) {
            this.eGi.b(this.eGm);
            this.eGi.a(this.eGm);
        }
    }

    public void onDestroy() {
        if (this.Qr != null) {
            this.Qr.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.eGi != null) {
            this.eGi.b(this.eGm);
        }
        aBJ();
        hideLoadingView();
        aBq();
    }
}
