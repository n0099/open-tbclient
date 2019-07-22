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
import com.baidu.tbadk.core.util.am;
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
    private BdTypeRecyclerView Op;
    private g djG;
    private BdSwipeRefreshLayout dqr;
    private NoNetworkView.a eHh;
    private com.baidu.tieba.enterForum.recommend.a eZC;
    private RecommendForumHeaderView fbb;
    private com.baidu.tieba.enterForum.recommend.a.a fbc;
    private com.baidu.tieba.enterForum.recommend.b.a fbd;
    private com.baidu.tieba.enterForum.home.c fbe;
    private long fbf;
    private CustomMessageListener fbg;
    private CustomMessageListener fbh;
    c.a fbi;
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
        this.fbg = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.fbb != null) {
                    RecommendView.this.fbb.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                if (z && RecommendView.this.eZC != null) {
                    RecommendView.this.eZC.loadData();
                }
            }
        };
        this.fbh = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.fbd != null && l != null) {
                        RecommendView.this.fbf = l.longValue();
                        if (RecommendView.this.eZC != null) {
                            RecommendView.this.eZC.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int dpp = -1;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dpp != i && RecommendView.this.fbe != null) {
                    this.dpp = i;
                    if (this.dpp == 1) {
                        RecommendView.this.fbe.aJu();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.fbe.aJv();
                    } else {
                        RecommendView.this.fbe.aJu();
                    }
                    RecommendView.this.fbb.bgG();
                }
            }
        };
        this.fbi = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void bgd() {
                if (RecommendView.this.fbe != null) {
                    if (RecommendView.this.a(RecommendView.this.Op)) {
                        RecommendView.this.fbe.aJv();
                    } else {
                        RecommendView.this.fbe.aJu();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.fbh);
        tbPageContext.registerListener(this.fbg);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setPadding(0, UtilHelper.getStatusBarHeight() + getResources().getDimensionPixelOffset(R.dimen.tbds140), 0, 0);
        this.dqr = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.dqr.setProgressView(this.mPullView);
        this.Op = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Op.setLayoutManager(new LinearLayoutManager(context));
        this.Op.setFadingEdgeLength(0);
        this.Op.setOverScrollMode(2);
        this.Op.addOnScrollListener(this.mOnScrollListener);
        this.fbc = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Op);
        this.fbb = new RecommendForumHeaderView(this.mPageContext);
        this.fbb.setOnSecectedListener(this);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fbc != null) {
            this.fbc.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fbb != null) {
            this.fbb.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.eZC = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.fbd = aVar;
            if (v.aa(aVar.bgv()) && v.aa(aVar.bgu())) {
                showNoDataView();
                return;
            }
            aVP();
            List<f> db = aVar.db(this.fbf);
            this.fbf = 0L;
            f fVar = (f) v.c(db, 1);
            if (fVar == null) {
                fVar = (f) v.c(db, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bJ(db);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void dd(long j) {
        a(this.fbd, j);
    }

    private void bJ(List<f> list) {
        if (this.Op.getHeaderViewsCount() == 0) {
            this.Op.addHeaderView(this.fbb);
        }
        this.fbb.setData(list);
        this.fbb.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.fbc.setData(aVar.dc(j));
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
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
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && RecommendView.this.eZC != null) {
                            RecommendView.this.eZC.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.kI(R.drawable.new_pic_emotion_09);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atI();
            this.Op.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jQ() && RecommendView.this.eZC != null) {
                        RecommendView.this.eZC.loadData();
                    }
                }
            });
        }
        this.mRefreshView.kI(R.drawable.new_pic_emotion_05);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.no_data_text));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.atI();
        this.Op.setVisibility(8);
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
            if (this.fbc != null) {
                this.fbc.notifyDataSetChanged();
            }
            if (this.fbb != null) {
                this.fbb.onChangeSkinType();
            }
            am.l(this.dqr, R.color.cp_bg_line_e);
            am.l(this.Op, R.color.cp_bg_line_c);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.fbe = cVar;
        if (this.fbe != null) {
            this.fbe.b(this.fbi);
            this.fbe.a(this.fbi);
        }
    }

    public void onDestroy() {
        if (this.Op != null) {
            this.Op.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.fbe != null) {
            this.fbe.b(this.fbi);
        }
        aJB();
        hideLoadingView();
        aJh();
        if (this.fbb != null) {
            this.fbb.bgH();
        }
    }
}
