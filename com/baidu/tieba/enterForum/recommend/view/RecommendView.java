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
    private BdSwipeRefreshLayout eme;
    private g etW;
    private int fVQ;
    private com.baidu.tieba.enterForum.recommend.a fXe;
    private List<f> fXy;
    private RecommendForumHeaderView fYB;
    private com.baidu.tieba.enterForum.recommend.a.a fYC;
    private com.baidu.tieba.enterForum.recommend.b.a fYD;
    private com.baidu.tieba.enterForum.home.c fYE;
    private FrameLayout fYF;
    private long fYG;
    private int fYH;
    private CustomMessageListener fYI;
    private NoNetworkView.a fYJ;
    private CustomMessageListener fYK;
    c.a fYL;
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
        this.fYI = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.fYE != null) {
                    RecommendView.this.fYE.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fYJ = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.fXe != null) {
                    RecommendView.this.fXe.loadData();
                }
            }
        };
        this.fYK = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.fYD != null && l != null) {
                        RecommendView.this.fYG = l.longValue();
                        if (RecommendView.this.fXe != null) {
                            RecommendView.this.fXe.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int enA = -1;
            int fYN = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.enA != i && RecommendView.this.fYE != null) {
                    this.enA = i;
                    if (this.enA == 1) {
                        RecommendView.this.fYE.bcK();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.fYE.bcL();
                    } else {
                        RecommendView.this.fYE.bcK();
                    }
                    RecommendView.this.fYB.bzg();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.fYN += i2;
                if (RecommendView.this.fYE.byy() == 2) {
                    RecommendView.this.fYE.e(recyclerView, i, i2, 0, 0);
                }
            }
        };
        this.fYL = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void byE() {
                if (RecommendView.this.fYE != null) {
                    if (RecommendView.this.a(RecommendView.this.BK)) {
                        RecommendView.this.fYE.bcL();
                    } else {
                        RecommendView.this.fYE.bcK();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fVQ = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.fYH = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.fYK);
        tbPageContext.registerListener(this.fYI);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.eme = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.eme.setProgressView(this.mPullView);
        this.eme.setClipChildren(false);
        this.BK = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.BK.setLayoutManager(new LinearLayoutManager(context));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.BK.setClipChildren(false);
        this.BK.addOnScrollListener(this.mOnScrollListener);
        this.fYC = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.BK);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eme.getLayoutParams();
        marginLayoutParams.topMargin = this.fVQ - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.eme.setLayoutParams(marginLayoutParams);
        this.fYB = new RecommendForumHeaderView(this.mPageContext);
        this.fYB.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.fYH));
        this.fYF = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fYC != null) {
            this.fYC.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fYB != null) {
            this.fYB.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.fXe = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.fYD = aVar;
            if (v.isEmpty(aVar.byU()) && v.isEmpty(aVar.kJ(true))) {
                showNoDataView();
                return;
            }
            bgw();
            List<f> dp = aVar.dp(this.fYG);
            this.fYG = 0L;
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
        a(this.fYD, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bze() {
        if (this.BK != null && !v.isEmpty(this.BK.getData()) && this.BK.getData().size() == 1 && (this.BK.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void bP(List<f> list) {
        this.BK.removeHeaderView(this.fYF);
        this.BK.removeHeaderView(this.fYB);
        if (this.BK.getHeaderViewsCount() == 0) {
        }
        this.BK.addHeaderView(this.fYB);
        this.fXy = list;
        this.fYB.setData(list);
        this.fYE.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.fYC.setData(aVar.f(j, !v.isEmpty(this.fXy)));
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bcB() {
        this.eme.setRefreshing(false);
    }

    public void bgw() {
        if (this.BK != null) {
            this.BK.setVisibility(0);
        }
    }

    public void eM(boolean z) {
        if (!bzi()) {
            if (this.etW == null) {
                this.etW = new com.baidu.tbadk.k.g(getContext());
                this.etW.aPR();
                this.etW.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.etW.onChangeSkinType();
            }
            this.etW.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this);
            this.etW = null;
        }
    }

    public boolean bzi() {
        if (this.etW != null) {
            return this.etW.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.fXe != null) {
                            RecommendView.this.fXe.loadData();
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
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.fXe != null) {
                        RecommendView.this.fXe.loadData();
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

    public void bcv() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzj() {
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
            if (this.etW != null) {
                this.etW.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fYC != null) {
                this.fYC.notifyDataSetChanged();
            }
            if (this.fYB != null) {
                this.fYB.onChangeSkinType();
            }
            am.setBackgroundColor(this.eme, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.BK, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.fYE = cVar;
        if (this.fYE != null) {
            this.fYE.b(this.fYL);
            this.fYE.a(this.fYL);
        }
    }

    public void onDestroy() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.fYE != null) {
            this.fYE.b(this.fYL);
        }
        bcB();
        hideLoadingView();
        bcv();
        if (this.fYB != null) {
            this.fYB.bzh();
        }
    }
}
