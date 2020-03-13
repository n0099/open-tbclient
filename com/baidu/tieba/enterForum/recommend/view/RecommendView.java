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
    private BdSwipeRefreshLayout ems;
    private g euk;
    private int fWf;
    private List<f> fXN;
    private com.baidu.tieba.enterForum.recommend.a fXt;
    private RecommendForumHeaderView fYQ;
    private com.baidu.tieba.enterForum.recommend.a.a fYR;
    private com.baidu.tieba.enterForum.recommend.b.a fYS;
    private com.baidu.tieba.enterForum.home.c fYT;
    private FrameLayout fYU;
    private long fYV;
    private int fYW;
    private CustomMessageListener fYX;
    private NoNetworkView.a fYY;
    private CustomMessageListener fYZ;
    c.a fZa;
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
        this.fYX = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.fYT != null) {
                    RecommendView.this.fYT.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fYY = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.fXt != null) {
                    RecommendView.this.fXt.loadData();
                }
            }
        };
        this.fYZ = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.fYS != null && l != null) {
                        RecommendView.this.fYV = l.longValue();
                        if (RecommendView.this.fXt != null) {
                            RecommendView.this.fXt.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int enO = -1;
            int fZc = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.enO != i && RecommendView.this.fYT != null) {
                    this.enO = i;
                    if (this.enO == 1) {
                        RecommendView.this.fYT.bcN();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.fYT.bcO();
                    } else {
                        RecommendView.this.fYT.bcN();
                    }
                    RecommendView.this.fYQ.bzj();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.fZc += i2;
                if (RecommendView.this.fYT.byB() == 2) {
                    RecommendView.this.fYT.e(recyclerView, i, i2, 0, 0);
                }
            }
        };
        this.fZa = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void byH() {
                if (RecommendView.this.fYT != null) {
                    if (RecommendView.this.a(RecommendView.this.BK)) {
                        RecommendView.this.fYT.bcO();
                    } else {
                        RecommendView.this.fYT.bcN();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fWf = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.fYW = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.fYZ);
        tbPageContext.registerListener(this.fYX);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.ems = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.ems.setProgressView(this.mPullView);
        this.ems.setClipChildren(false);
        this.BK = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.BK.setLayoutManager(new LinearLayoutManager(context));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.BK.setClipChildren(false);
        this.BK.addOnScrollListener(this.mOnScrollListener);
        this.fYR = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.BK);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ems.getLayoutParams();
        marginLayoutParams.topMargin = this.fWf - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.ems.setLayoutParams(marginLayoutParams);
        this.fYQ = new RecommendForumHeaderView(this.mPageContext);
        this.fYQ.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.fYW));
        this.fYU = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fYR != null) {
            this.fYR.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fYQ != null) {
            this.fYQ.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.fXt = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.fYS = aVar;
            if (v.isEmpty(aVar.byX()) && v.isEmpty(aVar.kJ(true))) {
                showNoDataView();
                return;
            }
            bgz();
            List<f> dp = aVar.dp(this.fYV);
            this.fYV = 0L;
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
        a(this.fYS, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bzh() {
        if (this.BK != null && !v.isEmpty(this.BK.getData()) && this.BK.getData().size() == 1 && (this.BK.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void bP(List<f> list) {
        this.BK.removeHeaderView(this.fYU);
        this.BK.removeHeaderView(this.fYQ);
        if (this.BK.getHeaderViewsCount() == 0) {
        }
        this.BK.addHeaderView(this.fYQ);
        this.fXN = list;
        this.fYQ.setData(list);
        this.fYT.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.fYR.setData(aVar.f(j, !v.isEmpty(this.fXN)));
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bcE() {
        this.ems.setRefreshing(false);
    }

    public void bgz() {
        if (this.BK != null) {
            this.BK.setVisibility(0);
        }
    }

    public void eM(boolean z) {
        if (!bzl()) {
            if (this.euk == null) {
                this.euk = new com.baidu.tbadk.k.g(getContext());
                this.euk.aPU();
                this.euk.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.euk.onChangeSkinType();
            }
            this.euk.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.euk != null) {
            this.euk.dettachView(this);
            this.euk = null;
        }
    }

    public boolean bzl() {
        if (this.euk != null) {
            return this.euk.isViewAttached();
        }
        return false;
    }

    public void kN(boolean z) {
        if (!bzm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.fXt != null) {
                            RecommendView.this.fXt.loadData();
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
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.fXt != null) {
                        RecommendView.this.fXt.loadData();
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

    public void bcy() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bzm() {
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
            if (this.euk != null) {
                this.euk.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fYR != null) {
                this.fYR.notifyDataSetChanged();
            }
            if (this.fYQ != null) {
                this.fYQ.onChangeSkinType();
            }
            am.setBackgroundColor(this.ems, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.BK, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.fYT = cVar;
        if (this.fYT != null) {
            this.fYT.b(this.fZa);
            this.fYT.a(this.fZa);
        }
    }

    public void onDestroy() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.fYT != null) {
            this.fYT.b(this.fZa);
        }
        bcE();
        hideLoadingView();
        bcy();
        if (this.fYQ != null) {
            this.fYQ.bzk();
        }
    }
}
