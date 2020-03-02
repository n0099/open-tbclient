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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.b.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes9.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView BK;
    private BdSwipeRefreshLayout emf;
    private g etX;
    private int fVS;
    private List<f> fXA;
    private com.baidu.tieba.enterForum.recommend.a fXg;
    private RecommendForumHeaderView fYD;
    private com.baidu.tieba.enterForum.recommend.a.a fYE;
    private com.baidu.tieba.enterForum.recommend.b.a fYF;
    private com.baidu.tieba.enterForum.home.c fYG;
    private FrameLayout fYH;
    private long fYI;
    private int fYJ;
    private CustomMessageListener fYK;
    private NoNetworkView.a fYL;
    private CustomMessageListener fYM;
    c.a fYN;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private int mSkinType;

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public RecommendView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fYK = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.fYG != null) {
                    RecommendView.this.fYG.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fYL = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.fXg != null) {
                    RecommendView.this.fXg.loadData();
                }
            }
        };
        this.fYM = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.fYF != null && l != null) {
                        RecommendView.this.fYI = l.longValue();
                        if (RecommendView.this.fXg != null) {
                            RecommendView.this.fXg.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int enB = -1;
            int fYP = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.enB != i && RecommendView.this.fYG != null) {
                    this.enB = i;
                    if (this.enB == 1) {
                        RecommendView.this.fYG.bcM();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.fYG.bcN();
                    } else {
                        RecommendView.this.fYG.bcM();
                    }
                    RecommendView.this.fYD.bzi();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.fYP += i2;
                if (RecommendView.this.fYG.byA() == 2) {
                    RecommendView.this.fYG.e(recyclerView, i, i2, 0, 0);
                }
            }
        };
        this.fYN = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void byG() {
                if (RecommendView.this.fYG != null) {
                    if (RecommendView.this.a(RecommendView.this.BK)) {
                        RecommendView.this.fYG.bcN();
                    } else {
                        RecommendView.this.fYG.bcM();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fVS = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.fYJ = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.fYM);
        tbPageContext.registerListener(this.fYK);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.emf = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.emf.setProgressView(this.mPullView);
        this.emf.setClipChildren(false);
        this.BK = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.BK.setLayoutManager(new LinearLayoutManager(context));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.BK.setClipChildren(false);
        this.BK.addOnScrollListener(this.mOnScrollListener);
        this.fYE = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.BK);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.emf.getLayoutParams();
        marginLayoutParams.topMargin = this.fVS - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.emf.setLayoutParams(marginLayoutParams);
        this.fYD = new RecommendForumHeaderView(this.mPageContext);
        this.fYD.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.fYJ));
        this.fYH = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fYE != null) {
            this.fYE.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fYD != null) {
            this.fYD.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.fXg = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.fYF = aVar;
            if (v.isEmpty(aVar.byW()) && v.isEmpty(aVar.kJ(true))) {
                showNoDataView();
                return;
            }
            bgy();
            List<f> dp = aVar.dp(this.fYI);
            this.fYI = 0L;
            f fVar = (f) v.getItem(dp, 1);
            if (fVar == null) {
                fVar = (f) v.getItem(dp, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bP(dp);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void dq(long j) {
        a(this.fYF, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bzg() {
        if (this.BK != null && !v.isEmpty(this.BK.getData()) && this.BK.getData().size() == 1 && (this.BK.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void bP(List<f> list) {
        this.BK.removeHeaderView(this.fYH);
        this.BK.removeHeaderView(this.fYD);
        if (this.BK.getHeaderViewsCount() == 0) {
        }
        this.BK.addHeaderView(this.fYD);
        this.fXA = list;
        this.fYD.setData(list);
        this.fYG.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.fYE.setData(aVar.f(j, !v.isEmpty(this.fXA)));
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bcD() {
        this.emf.setRefreshing(false);
    }

    public void bgy() {
        if (this.BK != null) {
            this.BK.setVisibility(0);
        }
    }

    public void eM(boolean z) {
        if (!bzk()) {
            if (this.etX == null) {
                this.etX = new com.baidu.tbadk.k.g(getContext());
                this.etX.aPT();
                this.etX.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.etX.onChangeSkinType();
            }
            this.etX.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this);
            this.etX = null;
        }
    }

    public boolean bzk() {
        if (this.etX != null) {
            return this.etX.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzl()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.fXg != null) {
                            RecommendView.this.fXg.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.mE(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.BK.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.fXg != null) {
                        RecommendView.this.fXg.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.mE(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.BK.setVisibility(8);
    }

    public void bcx() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzl() {
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
            if (this.etX != null) {
                this.etX.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fYE != null) {
                this.fYE.notifyDataSetChanged();
            }
            if (this.fYD != null) {
                this.fYD.onChangeSkinType();
            }
            am.setBackgroundColor(this.emf, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.BK, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.fYG = cVar;
        if (this.fYG != null) {
            this.fYG.b(this.fYN);
            this.fYG.a(this.fYN);
        }
    }

    public void onDestroy() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.fYG != null) {
            this.fYG.b(this.fYN);
        }
        bcD();
        hideLoadingView();
        bcx();
        if (this.fYD != null) {
            this.fYD.bzj();
        }
    }
}
