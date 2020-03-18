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
    private BdSwipeRefreshLayout emJ;
    private g euG;
    private int fWN;
    private com.baidu.tieba.enterForum.recommend.a fYb;
    private List<f> fYv;
    private com.baidu.tieba.enterForum.recommend.b.a fZA;
    private com.baidu.tieba.enterForum.home.c fZB;
    private FrameLayout fZC;
    private long fZD;
    private int fZE;
    private CustomMessageListener fZF;
    private NoNetworkView.a fZG;
    private CustomMessageListener fZH;
    c.a fZI;
    private RecommendForumHeaderView fZy;
    private com.baidu.tieba.enterForum.recommend.a.a fZz;
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
        this.fZF = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.fZB != null) {
                    RecommendView.this.fZB.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fZG = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.fYb != null) {
                    RecommendView.this.fYb.loadData();
                }
            }
        };
        this.fZH = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.fZA != null && l != null) {
                        RecommendView.this.fZD = l.longValue();
                        if (RecommendView.this.fYb != null) {
                            RecommendView.this.fYb.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int eog = -1;
            int fZK = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.eog != i && RecommendView.this.fZB != null) {
                    this.eog = i;
                    if (this.eog == 1) {
                        RecommendView.this.fZB.bcR();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.fZB.bcS();
                    } else {
                        RecommendView.this.fZB.bcR();
                    }
                    RecommendView.this.fZy.bzp();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.fZK += i2;
                if (RecommendView.this.fZB.byH() == 2) {
                    RecommendView.this.fZB.e(recyclerView, i, i2, 0, 0);
                }
            }
        };
        this.fZI = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void byN() {
                if (RecommendView.this.fZB != null) {
                    if (RecommendView.this.a(RecommendView.this.BK)) {
                        RecommendView.this.fZB.bcS();
                    } else {
                        RecommendView.this.fZB.bcR();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fWN = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.fZE = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.fZH);
        tbPageContext.registerListener(this.fZF);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.emJ = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.emJ.setProgressView(this.mPullView);
        this.emJ.setClipChildren(false);
        this.BK = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.BK.setLayoutManager(new LinearLayoutManager(context));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.BK.setClipChildren(false);
        this.BK.addOnScrollListener(this.mOnScrollListener);
        this.fZz = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.BK);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.emJ.getLayoutParams();
        marginLayoutParams.topMargin = this.fWN - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.emJ.setLayoutParams(marginLayoutParams);
        this.fZy = new RecommendForumHeaderView(this.mPageContext);
        this.fZy.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.fZE));
        this.fZC = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fZz != null) {
            this.fZz.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fZy != null) {
            this.fZy.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.fYb = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.fZA = aVar;
            if (v.isEmpty(aVar.bzd()) && v.isEmpty(aVar.kO(true))) {
                showNoDataView();
                return;
            }
            bgE();
            List<f> dp = aVar.dp(this.fZD);
            this.fZD = 0L;
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
        a(this.fZA, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bzn() {
        if (this.BK != null && !v.isEmpty(this.BK.getData()) && this.BK.getData().size() == 1 && (this.BK.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void bP(List<f> list) {
        this.BK.removeHeaderView(this.fZC);
        this.BK.removeHeaderView(this.fZy);
        if (this.BK.getHeaderViewsCount() == 0) {
        }
        this.BK.addHeaderView(this.fZy);
        this.fYv = list;
        this.fZy.setData(list);
        this.fZB.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.fZz.setData(aVar.g(j, !v.isEmpty(this.fYv)));
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bcI() {
        this.emJ.setRefreshing(false);
    }

    public void bgE() {
        if (this.BK != null) {
            this.BK.setVisibility(0);
        }
    }

    public void eN(boolean z) {
        if (!bzr()) {
            if (this.euG == null) {
                this.euG = new com.baidu.tbadk.k.g(getContext());
                this.euG.aPY();
                this.euG.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.euG.onChangeSkinType();
            }
            this.euG.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this);
            this.euG = null;
        }
    }

    public boolean bzr() {
        if (this.euG != null) {
            return this.euG.isViewAttached();
        }
        return false;
    }

    public void kS(boolean z) {
        if (!bzs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.fYb != null) {
                            RecommendView.this.fYb.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.mG(R.drawable.new_pic_emotion_08);
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
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.fYb != null) {
                        RecommendView.this.fYb.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.mG(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.BK.setVisibility(8);
    }

    public void bcC() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzs() {
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
            if (this.euG != null) {
                this.euG.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fZz != null) {
                this.fZz.notifyDataSetChanged();
            }
            if (this.fZy != null) {
                this.fZy.onChangeSkinType();
            }
            am.setBackgroundColor(this.emJ, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.BK, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.fZB = cVar;
        if (this.fZB != null) {
            this.fZB.b(this.fZI);
            this.fZB.a(this.fZI);
        }
    }

    public void onDestroy() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.fZB != null) {
            this.fZB.b(this.fZI);
        }
        bcI();
        hideLoadingView();
        bcC();
        if (this.fZy != null) {
            this.fZy.bzq();
        }
    }
}
