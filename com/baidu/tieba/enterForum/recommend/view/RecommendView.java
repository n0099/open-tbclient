package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes2.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView XW;
    private BdSwipeRefreshLayout gBw;
    private g gJB;
    private NoNetworkView.a gyn;
    private int iJQ;
    private com.baidu.tieba.enterForum.recommend.a iMB;
    private List<f> iMV;
    private RecommendForumHeaderView iNX;
    private com.baidu.tieba.enterForum.recommend.a.a iNY;
    private com.baidu.tieba.enterForum.recommend.b.a iNZ;
    private com.baidu.tieba.enterForum.home.c iOa;
    private FrameLayout iOb;
    private long iOc;
    private int iOd;
    private CustomMessageListener iOe;
    private CustomMessageListener iOf;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private int mSkinType;

    public boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public RecommendView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.iOe = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.iOa != null) {
                    RecommendView.this.iOa.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.gyn = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.iMB != null) {
                    RecommendView.this.iMB.loadData();
                }
            }
        };
        this.iOf = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.iNZ != null && l != null) {
                        RecommendView.this.iOc = l.longValue();
                        if (RecommendView.this.iMB != null) {
                            RecommendView.this.iMB.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int gCX = -1;
            int iOh = 0;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.gCX != i && RecommendView.this.iOa != null) {
                    this.gCX = i;
                    if (this.gCX != 1) {
                        if (RecommendView.this.c(recyclerView)) {
                        }
                        RecommendView.this.iNX.cxd();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.iOh += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.iJQ = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.iOd = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.iOf);
        tbPageContext.registerListener(this.iOe);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.gBw = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gBw.setProgressView(this.mPullView);
        this.gBw.setClipChildren(false);
        this.XW = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.XW.setLayoutManager(new LinearLayoutManager(context));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        this.XW.setClipChildren(false);
        this.XW.addOnScrollListener(this.mOnScrollListener);
        this.iNY = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.XW);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gBw.getLayoutParams();
        marginLayoutParams.topMargin = this.iJQ - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.gBw.setLayoutParams(marginLayoutParams);
        this.iNX = new RecommendForumHeaderView(this.mPageContext);
        this.iNX.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.iOd));
        this.iOb = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iNY != null) {
            this.iNY.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.iNX != null) {
            this.iNX.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.iMB = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.iNZ = aVar;
            if (y.isEmpty(aVar.cwR()) && y.isEmpty(aVar.pW(true))) {
                showNoDataView();
                return;
            }
            bYo();
            List<f> gk = aVar.gk(this.iOc);
            this.iOc = 0L;
            f fVar = (f) y.getItem(gk, 1);
            if (fVar == null) {
                fVar = (f) y.getItem(gk, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            cU(gk);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void gl(long j) {
        a(this.iNZ, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cxb() {
        if (this.XW != null && !y.isEmpty(this.XW.getData()) && this.XW.getData().size() == 1 && (this.XW.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cU(List<f> list) {
        this.XW.removeHeaderView(this.iOb);
        this.XW.removeHeaderView(this.iNX);
        if (this.XW.getHeaderViewsCount() == 0) {
        }
        this.XW.addHeaderView(this.iNX);
        this.iMV = list;
        this.iNX.setData(list);
        this.iOa.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.iNY.setData(aVar.l(j, !y.isEmpty(this.iMV)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bRI() {
        this.gBw.setRefreshing(false);
    }

    public void bYo() {
        if (this.XW != null) {
            this.XW.setVisibility(0);
        }
    }

    public void ir(boolean z) {
        if (!cqS()) {
            if (this.gJB == null) {
                this.gJB = new g(getContext());
                this.gJB.bCS();
                this.gJB.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.gJB.onChangeSkinType();
            }
            this.gJB.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
        }
    }

    public boolean cqS() {
        if (this.gJB != null) {
            return this.gJB.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqT()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.iMB != null) {
                            RecommendView.this.iMB.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.rn(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.XW.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.iMB != null) {
                        RecommendView.this.iMB.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.rn(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.XW.setVisibility(8);
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqT() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0205);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.gJB != null) {
                this.gJB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iNY != null) {
                this.iNY.notifyDataSetChanged();
            }
            if (this.iNX != null) {
                this.iNX.onChangeSkinType();
            }
            ap.setBackgroundColor(this.gBw, R.color.CAM_X0205);
            ap.setBackgroundColor(this.XW, R.color.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.iOa = cVar;
        if (this.iOa != null) {
        }
    }

    public void onDestroy() {
        if (this.XW != null) {
            this.XW.removeOnScrollListener(this.mOnScrollListener);
        }
        bRI();
        hideLoadingView();
        WZ();
        if (this.iNX != null) {
            this.iNX.cxe();
        }
    }
}
