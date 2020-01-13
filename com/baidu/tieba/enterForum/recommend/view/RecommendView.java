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
/* loaded from: classes7.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView Bs;
    private BdSwipeRefreshLayout ehX;
    private g epL;
    private int fTx;
    private com.baidu.tieba.enterForum.recommend.a fVd;
    private RecommendForumHeaderView fWA;
    private com.baidu.tieba.enterForum.recommend.a.a fWB;
    private com.baidu.tieba.enterForum.recommend.b.a fWC;
    private com.baidu.tieba.enterForum.home.c fWD;
    private FrameLayout fWE;
    private long fWF;
    private int fWG;
    private CustomMessageListener fWH;
    private NoNetworkView.a fWI;
    private CustomMessageListener fWJ;
    c.a fWK;
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
        this.fWH = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.fWD != null) {
                    RecommendView.this.fWD.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fWI = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.fVd != null) {
                    RecommendView.this.fVd.loadData();
                }
            }
        };
        this.fWJ = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.fWC != null && l != null) {
                        RecommendView.this.fWF = l.longValue();
                        if (RecommendView.this.fVd != null) {
                            RecommendView.this.fVd.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int ejq = -1;
            int fWM = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.ejq != i && RecommendView.this.fWD != null) {
                    this.ejq = i;
                    if (this.ejq == 1) {
                        RecommendView.this.fWD.bav();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.fWD.baw();
                    } else {
                        RecommendView.this.fWD.bav();
                    }
                    RecommendView.this.fWA.bxE();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.fWM += i2;
                if (RecommendView.this.fWD.bwT() == 2) {
                    RecommendView.this.fWD.e(recyclerView, i, i2, 0, 0);
                }
            }
        };
        this.fWK = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void bwZ() {
                if (RecommendView.this.fWD != null) {
                    if (RecommendView.this.a(RecommendView.this.Bs)) {
                        RecommendView.this.fWD.baw();
                    } else {
                        RecommendView.this.fWD.bav();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fTx = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.fWG = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.fWJ);
        tbPageContext.registerListener(this.fWH);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.ehX = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.ehX.setProgressView(this.mPullView);
        this.ehX.setClipChildren(false);
        this.Bs = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Bs.setLayoutManager(new LinearLayoutManager(context));
        this.Bs.setFadingEdgeLength(0);
        this.Bs.setOverScrollMode(2);
        this.Bs.setClipChildren(false);
        this.Bs.addOnScrollListener(this.mOnScrollListener);
        this.fWB = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Bs);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ehX.getLayoutParams();
        marginLayoutParams.topMargin = this.fTx - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.ehX.setLayoutParams(marginLayoutParams);
        this.fWA = new RecommendForumHeaderView(this.mPageContext);
        this.fWA.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.fWG));
        this.fWE = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fWB != null) {
            this.fWB.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fWA != null) {
            this.fWA.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.fVd = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.fWC = aVar;
            if (v.isEmpty(aVar.bxs()) && v.isEmpty(aVar.bxr())) {
                showNoDataView();
                return;
            }
            bem();
            List<f> m28do = aVar.m28do(this.fWF);
            this.fWF = 0L;
            f fVar = (f) v.getItem(m28do, 1);
            if (fVar == null) {
                fVar = (f) v.getItem(m28do, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bS(m28do);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void dq(long j) {
        a(this.fWC, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bxC() {
        if (this.Bs != null && !v.isEmpty(this.Bs.getData()) && this.Bs.getData().size() == 1 && (this.Bs.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void bS(List<f> list) {
        this.Bs.removeHeaderView(this.fWE);
        this.Bs.removeHeaderView(this.fWA);
        if (this.Bs.getHeaderViewsCount() == 0) {
        }
        this.Bs.addHeaderView(this.fWA);
        this.fWA.setData(list);
        this.fWD.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.fWB.setData(aVar.dp(j));
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bam() {
        this.ehX.setRefreshing(false);
    }

    public void bem() {
        if (this.Bs != null) {
            this.Bs.setVisibility(0);
        }
    }

    public void eF(boolean z) {
        if (!bxG()) {
            if (this.epL == null) {
                this.epL = new com.baidu.tbadk.k.g(getContext());
                this.epL.aNv();
                this.epL.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.epL.onChangeSkinType();
            }
            this.epL.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this);
            this.epL = null;
        }
    }

    public boolean bxG() {
        if (this.epL != null) {
            return this.epL.isViewAttached();
        }
        return false;
    }

    public void kJ(boolean z) {
        if (!bxH()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.fVd != null) {
                            RecommendView.this.fVd.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.mn(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Bs.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.fVd != null) {
                        RecommendView.this.fVd.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.mn(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Bs.setVisibility(8);
    }

    public void baf() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bxH() {
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
            if (this.epL != null) {
                this.epL.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fWB != null) {
                this.fWB.notifyDataSetChanged();
            }
            if (this.fWA != null) {
                this.fWA.onChangeSkinType();
            }
            am.setBackgroundColor(this.ehX, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Bs, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.fWD = cVar;
        if (this.fWD != null) {
            this.fWD.b(this.fWK);
            this.fWD.a(this.fWK);
        }
    }

    public void onDestroy() {
        if (this.Bs != null) {
            this.Bs.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.fWD != null) {
            this.fWD.b(this.fWK);
        }
        bam();
        hideLoadingView();
        baf();
        if (this.fWA != null) {
            this.fWA.bxF();
        }
    }
}
