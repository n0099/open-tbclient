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
    private g dDz;
    private BdSwipeRefreshLayout dyC;
    private NoNetworkView.a eQL;
    private int fbK;
    private com.baidu.tieba.enterForum.recommend.a fdq;
    private RecommendForumHeaderView feO;
    private com.baidu.tieba.enterForum.recommend.a.a feP;
    private com.baidu.tieba.enterForum.recommend.b.a feQ;
    private com.baidu.tieba.enterForum.home.c feR;
    private FrameLayout feS;
    private long feT;
    private int feU;
    private CustomMessageListener feV;
    private CustomMessageListener feW;
    c.a feX;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private int mSkinType;
    private BdTypeRecyclerView yJ;

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public RecommendView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.feV = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.feR != null) {
                    RecommendView.this.feR.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.eQL = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.fdq != null) {
                    RecommendView.this.fdq.loadData();
                }
            }
        };
        this.feW = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.feQ != null && l != null) {
                        RecommendView.this.feT = l.longValue();
                        if (RecommendView.this.fdq != null) {
                            RecommendView.this.fdq.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int dxA = -1;
            int feZ = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dxA != i && RecommendView.this.feR != null) {
                    this.dxA = i;
                    if (this.dxA == 1) {
                        RecommendView.this.feR.aJy();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.feR.aJz();
                    } else {
                        RecommendView.this.feR.aJy();
                    }
                    RecommendView.this.feO.bfh();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.feZ += i2;
                if (RecommendView.this.feR.bew() == 2) {
                    RecommendView.this.feR.e(recyclerView, i, i2, 0, 0);
                }
            }
        };
        this.feX = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void beD() {
                if (RecommendView.this.feR != null) {
                    if (RecommendView.this.a(RecommendView.this.yJ)) {
                        RecommendView.this.feR.aJz();
                    } else {
                        RecommendView.this.feR.aJy();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fbK = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.feU = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.feW);
        tbPageContext.registerListener(this.feV);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.dyC = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.dyC.setProgressView(this.mPullView);
        this.dyC.setClipChildren(false);
        this.yJ = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.yJ.setLayoutManager(new LinearLayoutManager(context));
        this.yJ.setFadingEdgeLength(0);
        this.yJ.setOverScrollMode(2);
        this.yJ.setClipChildren(false);
        this.yJ.addOnScrollListener(this.mOnScrollListener);
        this.feP = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.yJ);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dyC.getLayoutParams();
        marginLayoutParams.topMargin = this.fbK - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.dyC.setLayoutParams(marginLayoutParams);
        this.feO = new RecommendForumHeaderView(this.mPageContext);
        this.feO.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.feU));
        this.feS = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.feP != null) {
            this.feP.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.feO != null) {
            this.feO.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.fdq = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.feQ = aVar;
            if (v.isEmpty(aVar.beW()) && v.isEmpty(aVar.beV())) {
                showNoDataView();
                return;
            }
            aMo();
            List<f> cD = aVar.cD(this.feT);
            this.feT = 0L;
            f fVar = (f) v.getItem(cD, 1);
            if (fVar == null) {
                fVar = (f) v.getItem(cD, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bW(cD);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cF(long j) {
        a(this.feQ, j);
    }

    private void bW(List<f> list) {
        this.yJ.removeHeaderView(this.feS);
        this.yJ.removeHeaderView(this.feO);
        if (this.yJ.getHeaderViewsCount() == 0) {
        }
        this.yJ.addHeaderView(this.feO);
        this.feO.setData(list);
        this.feR.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.feP.setData(aVar.cE(j));
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void aJF() {
        this.dyC.setRefreshing(false);
    }

    public void aMo() {
        if (this.yJ != null) {
            this.yJ.setVisibility(0);
        }
    }

    public void dp(boolean z) {
        if (!bfj()) {
            if (this.dDz == null) {
                this.dDz = new g(getContext());
                this.dDz.onChangeSkinType();
            }
            this.dDz.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this);
            this.dDz = null;
        }
    }

    public boolean bfj() {
        if (this.dDz != null) {
            return this.dDz.isViewAttached();
        }
        return false;
    }

    public void jm(boolean z) {
        if (!bfk()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.fdq != null) {
                            RecommendView.this.fdq.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.jZ(R.drawable.new_pic_emotion_09);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.yJ.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.fdq != null) {
                        RecommendView.this.fdq.loadData();
                    }
                }
            });
        }
        this.mRefreshView.jZ(R.drawable.new_pic_emotion_05);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.no_data_text));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.yJ.setVisibility(8);
    }

    public void aJm() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bfk() {
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
            if (this.dDz != null) {
                this.dDz.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.feP != null) {
                this.feP.notifyDataSetChanged();
            }
            if (this.feO != null) {
                this.feO.onChangeSkinType();
            }
            am.setBackgroundColor(this.dyC, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.yJ, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.feR = cVar;
        if (this.feR != null) {
            this.feR.b(this.feX);
            this.feR.a(this.feX);
        }
    }

    public void onDestroy() {
        if (this.yJ != null) {
            this.yJ.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.feR != null) {
            this.feR.b(this.feX);
        }
        aJF();
        hideLoadingView();
        aJm();
        if (this.feO != null) {
            this.feO.bfi();
        }
    }
}
