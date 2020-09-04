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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes16.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView Wu;
    private NoNetworkView.a fCt;
    private BdSwipeRefreshLayout fEZ;
    private g fMR;
    private CustomMessageListener hAA;
    private RecommendForumHeaderView hAs;
    private com.baidu.tieba.enterForum.recommend.a.a hAt;
    private com.baidu.tieba.enterForum.recommend.b.a hAu;
    private com.baidu.tieba.enterForum.home.c hAv;
    private FrameLayout hAw;
    private long hAx;
    private int hAy;
    private CustomMessageListener hAz;
    private int hwe;
    private com.baidu.tieba.enterForum.recommend.a hyU;
    private List<f> hzo;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public RecommendView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.hAz = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.hAv != null) {
                    RecommendView.this.hAv.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fCt = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.hyU != null) {
                    RecommendView.this.hyU.loadData();
                }
            }
        };
        this.hAA = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.hAu != null && l != null) {
                        RecommendView.this.hAx = l.longValue();
                        if (RecommendView.this.hyU != null) {
                            RecommendView.this.hyU.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int fGt = -1;
            int hAC = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.fGt != i && RecommendView.this.hAv != null) {
                    this.fGt = i;
                    if (this.fGt != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.hAs.cgu();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.hAC += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.hwe = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.hAy = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.hAA);
        tbPageContext.registerListener(this.hAz);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.fEZ = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fEZ.setProgressView(this.mPullView);
        this.fEZ.setClipChildren(false);
        this.Wu = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Wu.setLayoutManager(new LinearLayoutManager(context));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.Wu.setClipChildren(false);
        this.Wu.addOnScrollListener(this.mOnScrollListener);
        this.hAt = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Wu);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fEZ.getLayoutParams();
        marginLayoutParams.topMargin = this.hwe - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.fEZ.setLayoutParams(marginLayoutParams);
        this.hAs = new RecommendForumHeaderView(this.mPageContext);
        this.hAs.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.hAy));
        this.hAw = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hAt != null) {
            this.hAt.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.hAs != null) {
            this.hAs.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.hyU = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.hAu = aVar;
            if (y.isEmpty(aVar.cgi()) && y.isEmpty(aVar.nI(true))) {
                showNoDataView();
                return;
            }
            bLt();
            List<f> eA = aVar.eA(this.hAx);
            this.hAx = 0L;
            f fVar = (f) y.getItem(eA, 1);
            if (fVar == null) {
                fVar = (f) y.getItem(eA, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            co(eA);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void eB(long j) {
        a(this.hAu, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cgs() {
        if (this.Wu != null && !y.isEmpty(this.Wu.getData()) && this.Wu.getData().size() == 1 && (this.Wu.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void co(List<f> list) {
        this.Wu.removeHeaderView(this.hAw);
        this.Wu.removeHeaderView(this.hAs);
        if (this.Wu.getHeaderViewsCount() == 0) {
        }
        this.Wu.addHeaderView(this.hAs);
        this.hzo = list;
        this.hAs.setData(list);
        this.hAv.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.hAt.setData(aVar.h(j, !y.isEmpty(this.hzo)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bGe() {
        this.fEZ.setRefreshing(false);
    }

    public void bLt() {
        if (this.Wu != null) {
            this.Wu.setVisibility(0);
        }
    }

    public void gT(boolean z) {
        if (!cgw()) {
            if (this.fMR == null) {
                this.fMR = new g(getContext());
                this.fMR.bta();
                this.fMR.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.fMR.onChangeSkinType();
            }
            this.fMR.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this);
            this.fMR = null;
        }
    }

    public boolean cgw() {
        if (this.fMR != null) {
            return this.fMR.isViewAttached();
        }
        return false;
    }

    public void nM(boolean z) {
        if (!cgx()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.hyU != null) {
                            RecommendView.this.hyU.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.qt(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Wu.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.hyU != null) {
                        RecommendView.this.hyU.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.qt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Wu.setVisibility(8);
    }

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cgx() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.fMR != null) {
                this.fMR.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hAt != null) {
                this.hAt.notifyDataSetChanged();
            }
            if (this.hAs != null) {
                this.hAs.onChangeSkinType();
            }
            ap.setBackgroundColor(this.fEZ, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.hAv = cVar;
        if (this.hAv != null) {
        }
    }

    public void onDestroy() {
        if (this.Wu != null) {
            this.Wu.removeOnScrollListener(this.mOnScrollListener);
        }
        bGe();
        hideLoadingView();
        bFX();
        if (this.hAs != null) {
            this.hAs.cgv();
        }
    }
}
