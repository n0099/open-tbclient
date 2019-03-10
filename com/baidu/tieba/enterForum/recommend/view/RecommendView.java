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
    private BdTypeRecyclerView Qq;
    private g cXq;
    private BdSwipeRefreshLayout ddF;
    private com.baidu.tieba.enterForum.recommend.a eEY;
    private long eGA;
    private CustomMessageListener eGB;
    private CustomMessageListener eGC;
    c.a eGD;
    private RecommendForumHeaderView eGw;
    private com.baidu.tieba.enterForum.recommend.a.a eGx;
    private com.baidu.tieba.enterForum.recommend.b.a eGy;
    private com.baidu.tieba.enterForum.home.c eGz;
    private NoNetworkView.a emQ;
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
        this.eGB = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.eGw != null) {
                    RecommendView.this.eGw.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.emQ = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && RecommendView.this.eEY != null) {
                    RecommendView.this.eEY.loadData();
                }
            }
        };
        this.eGC = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.eGy != null && l != null) {
                        RecommendView.this.eGA = l.longValue();
                        if (RecommendView.this.eEY != null) {
                            RecommendView.this.eEY.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int dcL = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dcL != i && RecommendView.this.eGz != null) {
                    this.dcL = i;
                    if (this.dcL == 1) {
                        RecommendView.this.eGz.aBF();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.eGz.aBG();
                    } else {
                        RecommendView.this.eGz.aBF();
                    }
                    RecommendView.this.eGw.aXq();
                }
            }
        };
        this.eGD = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void aWN() {
                if (RecommendView.this.eGz != null) {
                    if (RecommendView.this.a(RecommendView.this.Qq)) {
                        RecommendView.this.eGz.aBG();
                    } else {
                        RecommendView.this.eGz.aBF();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.eGC);
        tbPageContext.registerListener(this.eGB);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.fragment_enter_recommend_layout, (ViewGroup) this, true);
        this.ddF = (BdSwipeRefreshLayout) findViewById(d.g.enter_recommend_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.ddF.setProgressView(this.mPullView);
        this.Qq = (BdTypeRecyclerView) findViewById(d.g.enter_recommend_list_view);
        this.Qq.setLayoutManager(new LinearLayoutManager(context));
        this.Qq.setFadingEdgeLength(0);
        this.Qq.setOverScrollMode(2);
        this.Qq.addOnScrollListener(this.mOnScrollListener);
        this.eGx = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Qq);
        this.eGw = new RecommendForumHeaderView(this.mPageContext);
        this.eGw.setOnSecectedListener(this);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eGx != null) {
            this.eGx.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.eEY = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.eGy = aVar;
            if (v.T(aVar.aXe()) && v.T(aVar.aXd())) {
                showNoDataView();
                return;
            }
            aOB();
            List<f> cx = aVar.cx(this.eGA);
            this.eGA = 0L;
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
        a(this.eGy, j);
    }

    private void bB(List<f> list) {
        if (this.Qq.getHeaderViewsCount() == 0) {
            this.Qq.addHeaderView(this.eGw);
        }
        this.eGw.setData(list);
        this.eGw.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.eGx.setData(aVar.cy(j));
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void aBN() {
        this.ddF.setRefreshing(false);
    }

    public void aOB() {
        if (this.Qq != null) {
            this.Qq.setVisibility(0);
        }
    }

    public void cE(boolean z) {
        if (!aXr()) {
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

    public boolean aXr() {
        if (this.cXq != null) {
            return this.cXq.isViewAttached();
        }
        return false;
    }

    public void iD(boolean z) {
        if (!aXs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && RecommendView.this.eEY != null) {
                            RecommendView.this.eEY.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(d.j.refresh_view_title_text));
            this.mRefreshView.jP(d.f.new_pic_emotion_09);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.anC();
            this.Qq.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kM() && RecommendView.this.eEY != null) {
                        RecommendView.this.eEY.loadData();
                    }
                }
            });
        }
        this.mRefreshView.jP(d.f.new_pic_emotion_05);
        this.mRefreshView.setTitle(this.mPageContext.getString(d.j.no_data_text));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.anC();
        this.Qq.setVisibility(8);
    }

    public void aBu() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean aXs() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0236d.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.ic(skinType);
            }
            if (this.cXq != null) {
                this.cXq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.eGx != null) {
                this.eGx.notifyDataSetChanged();
            }
            if (this.eGw != null) {
                this.eGw.onChangeSkinType();
            }
            al.l(this.ddF, d.C0236d.cp_bg_line_e);
            al.l(this.Qq, d.C0236d.cp_bg_line_d);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.eGz = cVar;
        if (this.eGz != null) {
            this.eGz.b(this.eGD);
            this.eGz.a(this.eGD);
        }
    }

    public void onDestroy() {
        if (this.Qq != null) {
            this.Qq.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.eGz != null) {
            this.eGz.b(this.eGD);
        }
        aBN();
        hideLoadingView();
        aBu();
    }
}
