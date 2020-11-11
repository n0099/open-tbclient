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
/* loaded from: classes22.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView Xe;
    private NoNetworkView.a ghG;
    private BdSwipeRefreshLayout gko;
    private g gso;
    private int ikC;
    private List<f> inK;
    private com.baidu.tieba.enterForum.recommend.a inp;
    private RecommendForumHeaderView ioO;
    private com.baidu.tieba.enterForum.recommend.a.a ioP;
    private com.baidu.tieba.enterForum.recommend.b.a ioQ;
    private com.baidu.tieba.enterForum.home.c ioR;
    private FrameLayout ioS;
    private long ioT;
    private int ioU;
    private CustomMessageListener ioV;
    private CustomMessageListener ioW;
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
        this.ioV = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.ioR != null) {
                    RecommendView.this.ioR.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.ghG = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.inp != null) {
                    RecommendView.this.inp.loadData();
                }
            }
        };
        this.ioW = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.ioQ != null && l != null) {
                        RecommendView.this.ioT = l.longValue();
                        if (RecommendView.this.inp != null) {
                            RecommendView.this.inp.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int glP = -1;
            int ioY = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.glP != i && RecommendView.this.ioR != null) {
                    this.glP = i;
                    if (this.glP != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.ioO.csP();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.ioY += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.ikC = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.ioU = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.ioW);
        tbPageContext.registerListener(this.ioV);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.gko = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gko.setProgressView(this.mPullView);
        this.gko.setClipChildren(false);
        this.Xe = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(context));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.Xe.setClipChildren(false);
        this.Xe.addOnScrollListener(this.mOnScrollListener);
        this.ioP = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Xe);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gko.getLayoutParams();
        marginLayoutParams.topMargin = this.ikC - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.gko.setLayoutParams(marginLayoutParams);
        this.ioO = new RecommendForumHeaderView(this.mPageContext);
        this.ioO.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.ioU));
        this.ioS = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ioP != null) {
            this.ioP.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.ioO != null) {
            this.ioO.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.inp = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.ioQ = aVar;
            if (y.isEmpty(aVar.csD()) && y.isEmpty(aVar.oU(true))) {
                showNoDataView();
                return;
            }
            bVq();
            List<f> fy = aVar.fy(this.ioT);
            this.ioT = 0L;
            f fVar = (f) y.getItem(fy, 1);
            if (fVar == null) {
                fVar = (f) y.getItem(fy, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            cO(fy);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void fz(long j) {
        a(this.ioQ, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void csN() {
        if (this.Xe != null && !y.isEmpty(this.Xe.getData()) && this.Xe.getData().size() == 1 && (this.Xe.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cO(List<f> list) {
        this.Xe.removeHeaderView(this.ioS);
        this.Xe.removeHeaderView(this.ioO);
        if (this.Xe.getHeaderViewsCount() == 0) {
        }
        this.Xe.addHeaderView(this.ioO);
        this.inK = list;
        this.ioO.setData(list);
        this.ioR.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.ioP.setData(aVar.j(j, !y.isEmpty(this.inK)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bPh() {
        this.gko.setRefreshing(false);
    }

    public void bVq() {
        if (this.Xe != null) {
            this.Xe.setVisibility(0);
        }
    }

    public void hJ(boolean z) {
        if (!cmJ()) {
            if (this.gso == null) {
                this.gso = new g(getContext());
                this.gso.bBg();
                this.gso.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.gso.onChangeSkinType();
            }
            this.gso.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
            this.gso = null;
        }
    }

    public boolean cmJ() {
        if (this.gso != null) {
            return this.gso.isViewAttached();
        }
        return false;
    }

    public void oY(boolean z) {
        if (!cmK()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.inp != null) {
                            RecommendView.this.inp.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.rD(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Xe.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.inp != null) {
                        RecommendView.this.inp.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.rD(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Xe.setVisibility(8);
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cmK() {
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
            if (this.gso != null) {
                this.gso.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.ioP != null) {
                this.ioP.notifyDataSetChanged();
            }
            if (this.ioO != null) {
                this.ioO.onChangeSkinType();
            }
            ap.setBackgroundColor(this.gko, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.ioR = cVar;
        if (this.ioR != null) {
        }
    }

    public void onDestroy() {
        if (this.Xe != null) {
            this.Xe.removeOnScrollListener(this.mOnScrollListener);
        }
        bPh();
        hideLoadingView();
        Wk();
        if (this.ioO != null) {
            this.ioO.csQ();
        }
    }
}
