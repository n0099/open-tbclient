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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes9.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView Wa;
    private NoNetworkView.a flL;

    /* renamed from: for  reason: not valid java name */
    private BdSwipeRefreshLayout f6for;
    private g fwo;
    private int hdq;
    private List<f> hgH;
    private com.baidu.tieba.enterForum.recommend.a hgn;
    private RecommendForumHeaderView hhL;
    private com.baidu.tieba.enterForum.recommend.a.a hhM;
    private com.baidu.tieba.enterForum.recommend.b.a hhN;
    private com.baidu.tieba.enterForum.home.c hhO;
    private FrameLayout hhP;
    private long hhQ;
    private int hhR;
    private CustomMessageListener hhS;
    private CustomMessageListener hhT;
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
        this.hhS = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.hhO != null) {
                    RecommendView.this.hhO.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.flL = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.hgn != null) {
                    RecommendView.this.hgn.loadData();
                }
            }
        };
        this.hhT = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.hhN != null && l != null) {
                        RecommendView.this.hhQ = l.longValue();
                        if (RecommendView.this.hgn != null) {
                            RecommendView.this.hgn.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int fpM = -1;
            int hhV = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.fpM != i && RecommendView.this.hhO != null) {
                    this.fpM = i;
                    if (this.fpM != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.hhL.bSP();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.hhV += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.hdq = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.hhR = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.hhT);
        tbPageContext.registerListener(this.hhS);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.f6for = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.f6for.setProgressView(this.mPullView);
        this.f6for.setClipChildren(false);
        this.Wa = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Wa.setLayoutManager(new LinearLayoutManager(context));
        this.Wa.setFadingEdgeLength(0);
        this.Wa.setOverScrollMode(2);
        this.Wa.setClipChildren(false);
        this.Wa.addOnScrollListener(this.mOnScrollListener);
        this.hhM = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Wa);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f6for.getLayoutParams();
        marginLayoutParams.topMargin = this.hdq - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.f6for.setLayoutParams(marginLayoutParams);
        this.hhL = new RecommendForumHeaderView(this.mPageContext);
        this.hhL.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.hhR));
        this.hhP = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hhM != null) {
            this.hhM.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.hhL != null) {
            this.hhL.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.hgn = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.hhN = aVar;
            if (w.isEmpty(aVar.bSD()) && w.isEmpty(aVar.mx(true))) {
                showNoDataView();
                return;
            }
            byK();
            List<f> ec = aVar.ec(this.hhQ);
            this.hhQ = 0L;
            f fVar = (f) w.getItem(ec, 1);
            if (fVar == null) {
                fVar = (f) w.getItem(ec, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            ch(ec);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void ed(long j) {
        a(this.hhN, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bSN() {
        if (this.Wa != null && !w.isEmpty(this.Wa.getData()) && this.Wa.getData().size() == 1 && (this.Wa.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void ch(List<f> list) {
        this.Wa.removeHeaderView(this.hhP);
        this.Wa.removeHeaderView(this.hhL);
        if (this.Wa.getHeaderViewsCount() == 0) {
        }
        this.Wa.addHeaderView(this.hhL);
        this.hgH = list;
        this.hhL.setData(list);
        this.hhO.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.hhM.setData(aVar.h(j, !w.isEmpty(this.hgH)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void btV() {
        this.f6for.setRefreshing(false);
    }

    public void byK() {
        if (this.Wa != null) {
            this.Wa.setVisibility(0);
        }
    }

    public void ga(boolean z) {
        if (!bSR()) {
            if (this.fwo == null) {
                this.fwo = new g(getContext());
                this.fwo.bgC();
                this.fwo.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.fwo.onChangeSkinType();
            }
            this.fwo.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this);
            this.fwo = null;
        }
    }

    public boolean bSR() {
        if (this.fwo != null) {
            return this.fwo.isViewAttached();
        }
        return false;
    }

    public void mB(boolean z) {
        if (!bSS()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.hgn != null) {
                            RecommendView.this.hgn.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.nQ(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Wa.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.hgn != null) {
                        RecommendView.this.hgn.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.nQ(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Wa.setVisibility(8);
    }

    public void btO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bSS() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            an.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.fwo != null) {
                this.fwo.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hhM != null) {
                this.hhM.notifyDataSetChanged();
            }
            if (this.hhL != null) {
                this.hhL.onChangeSkinType();
            }
            an.setBackgroundColor(this.f6for, R.color.cp_bg_line_e);
            an.setBackgroundColor(this.Wa, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.hhO = cVar;
        if (this.hhO != null) {
        }
    }

    public void onDestroy() {
        if (this.Wa != null) {
            this.Wa.removeOnScrollListener(this.mOnScrollListener);
        }
        btV();
        hideLoadingView();
        btO();
        if (this.hhL != null) {
            this.hhL.bSQ();
        }
    }
}
