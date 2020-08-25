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
    private NoNetworkView.a fCp;
    private BdSwipeRefreshLayout fEV;
    private g fMN;
    private RecommendForumHeaderView hAm;
    private com.baidu.tieba.enterForum.recommend.a.a hAn;
    private com.baidu.tieba.enterForum.recommend.b.a hAo;
    private com.baidu.tieba.enterForum.home.c hAp;
    private FrameLayout hAq;
    private long hAr;
    private int hAs;
    private CustomMessageListener hAt;
    private CustomMessageListener hAu;
    private int hvY;
    private com.baidu.tieba.enterForum.recommend.a hyO;
    private List<f> hzi;
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
        this.hAt = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.hAp != null) {
                    RecommendView.this.hAp.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fCp = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.hyO != null) {
                    RecommendView.this.hyO.loadData();
                }
            }
        };
        this.hAu = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.hAo != null && l != null) {
                        RecommendView.this.hAr = l.longValue();
                        if (RecommendView.this.hyO != null) {
                            RecommendView.this.hyO.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int fGp = -1;
            int hAw = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.fGp != i && RecommendView.this.hAp != null) {
                    this.fGp = i;
                    if (this.fGp != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.hAm.cgt();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.hAw += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.hvY = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.hAs = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.hAu);
        tbPageContext.registerListener(this.hAt);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.fEV = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fEV.setProgressView(this.mPullView);
        this.fEV.setClipChildren(false);
        this.Wu = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Wu.setLayoutManager(new LinearLayoutManager(context));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.Wu.setClipChildren(false);
        this.Wu.addOnScrollListener(this.mOnScrollListener);
        this.hAn = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Wu);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fEV.getLayoutParams();
        marginLayoutParams.topMargin = this.hvY - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.fEV.setLayoutParams(marginLayoutParams);
        this.hAm = new RecommendForumHeaderView(this.mPageContext);
        this.hAm.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.hAs));
        this.hAq = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hAn != null) {
            this.hAn.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.hAm != null) {
            this.hAm.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.hyO = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.hAo = aVar;
            if (y.isEmpty(aVar.cgh()) && y.isEmpty(aVar.nG(true))) {
                showNoDataView();
                return;
            }
            bLs();
            List<f> eA = aVar.eA(this.hAr);
            this.hAr = 0L;
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
        a(this.hAo, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cgr() {
        if (this.Wu != null && !y.isEmpty(this.Wu.getData()) && this.Wu.getData().size() == 1 && (this.Wu.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void co(List<f> list) {
        this.Wu.removeHeaderView(this.hAq);
        this.Wu.removeHeaderView(this.hAm);
        if (this.Wu.getHeaderViewsCount() == 0) {
        }
        this.Wu.addHeaderView(this.hAm);
        this.hzi = list;
        this.hAm.setData(list);
        this.hAp.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.hAn.setData(aVar.h(j, !y.isEmpty(this.hzi)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bGd() {
        this.fEV.setRefreshing(false);
    }

    public void bLs() {
        if (this.Wu != null) {
            this.Wu.setVisibility(0);
        }
    }

    public void gS(boolean z) {
        if (!cgv()) {
            if (this.fMN == null) {
                this.fMN = new g(getContext());
                this.fMN.bsZ();
                this.fMN.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.fMN.onChangeSkinType();
            }
            this.fMN.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this);
            this.fMN = null;
        }
    }

    public boolean cgv() {
        if (this.fMN != null) {
            return this.fMN.isViewAttached();
        }
        return false;
    }

    public void nK(boolean z) {
        if (!cgw()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.hyO != null) {
                            RecommendView.this.hyO.loadData();
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
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.hyO != null) {
                        RecommendView.this.hyO.loadData();
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

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cgw() {
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
            if (this.fMN != null) {
                this.fMN.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hAn != null) {
                this.hAn.notifyDataSetChanged();
            }
            if (this.hAm != null) {
                this.hAm.onChangeSkinType();
            }
            ap.setBackgroundColor(this.fEV, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.hAp = cVar;
        if (this.hAp != null) {
        }
    }

    public void onDestroy() {
        if (this.Wu != null) {
            this.Wu.removeOnScrollListener(this.mOnScrollListener);
        }
        bGd();
        hideLoadingView();
        bFW();
        if (this.hAm != null) {
            this.hAm.cgu();
        }
    }
}
