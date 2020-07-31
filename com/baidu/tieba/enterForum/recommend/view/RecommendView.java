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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private BdTypeRecyclerView VT;
    private g fBv;
    private NoNetworkView.a fqT;
    private BdSwipeRefreshLayout ftC;
    private int hja;
    private com.baidu.tieba.enterForum.recommend.a hlX;
    private List<f> hmr;
    private long hnA;
    private int hnB;
    private CustomMessageListener hnC;
    private CustomMessageListener hnD;
    private RecommendForumHeaderView hnv;
    private com.baidu.tieba.enterForum.recommend.a.a hnw;
    private com.baidu.tieba.enterForum.recommend.b.a hnx;
    private com.baidu.tieba.enterForum.home.c hny;
    private FrameLayout hnz;
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
        this.hnC = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.hny != null) {
                    RecommendView.this.hny.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fqT = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.hlX != null) {
                    RecommendView.this.hlX.loadData();
                }
            }
        };
        this.hnD = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.hnx != null && l != null) {
                        RecommendView.this.hnA = l.longValue();
                        if (RecommendView.this.hlX != null) {
                            RecommendView.this.hlX.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int fuW = -1;
            int hnF = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.fuW != i && RecommendView.this.hny != null) {
                    this.fuW = i;
                    if (this.fuW != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.hnv.bWg();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.hnF += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.hja = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.hnB = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.hnD);
        tbPageContext.registerListener(this.hnC);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.ftC = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.ftC.setProgressView(this.mPullView);
        this.ftC.setClipChildren(false);
        this.VT = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.VT.setLayoutManager(new LinearLayoutManager(context));
        this.VT.setFadingEdgeLength(0);
        this.VT.setOverScrollMode(2);
        this.VT.setClipChildren(false);
        this.VT.addOnScrollListener(this.mOnScrollListener);
        this.hnw = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.VT);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ftC.getLayoutParams();
        marginLayoutParams.topMargin = this.hja - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.ftC.setLayoutParams(marginLayoutParams);
        this.hnv = new RecommendForumHeaderView(this.mPageContext);
        this.hnv.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.hnB));
        this.hnz = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hnw != null) {
            this.hnw.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.hnv != null) {
            this.hnv.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.hlX = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.hnx = aVar;
            if (x.isEmpty(aVar.bVU()) && x.isEmpty(aVar.nc(true))) {
                showNoDataView();
                return;
            }
            bBY();
            List<f> ep = aVar.ep(this.hnA);
            this.hnA = 0L;
            f fVar = (f) x.getItem(ep, 1);
            if (fVar == null) {
                fVar = (f) x.getItem(ep, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            cm(ep);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void eq(long j) {
        a(this.hnx, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bWe() {
        if (this.VT != null && !x.isEmpty(this.VT.getData()) && this.VT.getData().size() == 1 && (this.VT.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cm(List<f> list) {
        this.VT.removeHeaderView(this.hnz);
        this.VT.removeHeaderView(this.hnv);
        if (this.VT.getHeaderViewsCount() == 0) {
        }
        this.VT.addHeaderView(this.hnv);
        this.hmr = list;
        this.hnv.setData(list);
        this.hny.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.hnw.setData(aVar.h(j, !x.isEmpty(this.hmr)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bxe() {
        this.ftC.setRefreshing(false);
    }

    public void bBY() {
        if (this.VT != null) {
            this.VT.setVisibility(0);
        }
    }

    public void gw(boolean z) {
        if (!bWi()) {
            if (this.fBv == null) {
                this.fBv = new g(getContext());
                this.fBv.bkn();
                this.fBv.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.fBv.onChangeSkinType();
            }
            this.fBv.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this);
            this.fBv = null;
        }
    }

    public boolean bWi() {
        if (this.fBv != null) {
            return this.fBv.isViewAttached();
        }
        return false;
    }

    public void ng(boolean z) {
        if (!bWj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.hlX != null) {
                            RecommendView.this.hlX.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.oi(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.VT.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.hlX != null) {
                        RecommendView.this.hlX.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.oi(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.VT.setVisibility(8);
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bWj() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.fBv != null) {
                this.fBv.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hnw != null) {
                this.hnw.notifyDataSetChanged();
            }
            if (this.hnv != null) {
                this.hnv.onChangeSkinType();
            }
            ao.setBackgroundColor(this.ftC, R.color.cp_bg_line_e);
            ao.setBackgroundColor(this.VT, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.hny = cVar;
        if (this.hny != null) {
        }
    }

    public void onDestroy() {
        if (this.VT != null) {
            this.VT.removeOnScrollListener(this.mOnScrollListener);
        }
        bxe();
        hideLoadingView();
        bwX();
        if (this.hnv != null) {
            this.hnv.bWh();
        }
    }
}
