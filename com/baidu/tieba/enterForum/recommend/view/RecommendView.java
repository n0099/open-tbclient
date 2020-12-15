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
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes22.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView Yf;
    private g gAg;
    private NoNetworkView.a gpz;
    private BdSwipeRefreshLayout gsg;
    private FrameLayout iAA;
    private long iAB;
    private int iAC;
    private CustomMessageListener iAD;
    private CustomMessageListener iAE;
    private RecommendForumHeaderView iAw;
    private com.baidu.tieba.enterForum.recommend.a.a iAx;
    private com.baidu.tieba.enterForum.recommend.b.a iAy;
    private com.baidu.tieba.enterForum.home.c iAz;
    private int iwm;
    private com.baidu.tieba.enterForum.recommend.a iyY;
    private List<f> izs;
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
        this.iAD = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.iAz != null) {
                    RecommendView.this.iAz.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.gpz = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.iyY != null) {
                    RecommendView.this.iyY.loadData();
                }
            }
        };
        this.iAE = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.iAy != null && l != null) {
                        RecommendView.this.iAB = l.longValue();
                        if (RecommendView.this.iyY != null) {
                            RecommendView.this.iyY.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int gtH = -1;
            int iAG = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.gtH != i && RecommendView.this.iAz != null) {
                    this.gtH = i;
                    if (this.gtH != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.iAw.cwI();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.iAG += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.iwm = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.iAC = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.iAE);
        tbPageContext.registerListener(this.iAD);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.gsg = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gsg.setProgressView(this.mPullView);
        this.gsg.setClipChildren(false);
        this.Yf = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Yf.setLayoutManager(new LinearLayoutManager(context));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        this.Yf.setClipChildren(false);
        this.Yf.addOnScrollListener(this.mOnScrollListener);
        this.iAx = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Yf);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gsg.getLayoutParams();
        marginLayoutParams.topMargin = this.iwm - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.gsg.setLayoutParams(marginLayoutParams);
        this.iAw = new RecommendForumHeaderView(this.mPageContext);
        this.iAw.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.iAC));
        this.iAA = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iAx != null) {
            this.iAx.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.iAw != null) {
            this.iAw.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.iyY = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.iAy = aVar;
            if (y.isEmpty(aVar.cww()) && y.isEmpty(aVar.pt(true))) {
                showNoDataView();
                return;
            }
            bYt();
            List<f> gf = aVar.gf(this.iAB);
            this.iAB = 0L;
            f fVar = (f) y.getItem(gf, 1);
            if (fVar == null) {
                fVar = (f) y.getItem(gf, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            cS(gf);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void gg(long j) {
        a(this.iAy, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cwG() {
        if (this.Yf != null && !y.isEmpty(this.Yf.getData()) && this.Yf.getData().size() == 1 && (this.Yf.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cS(List<f> list) {
        this.Yf.removeHeaderView(this.iAA);
        this.Yf.removeHeaderView(this.iAw);
        if (this.Yf.getHeaderViewsCount() == 0) {
        }
        this.Yf.addHeaderView(this.iAw);
        this.izs = list;
        this.iAw.setData(list);
        this.iAz.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.iAx.setData(aVar.j(j, !y.isEmpty(this.izs)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bSm() {
        this.gsg.setRefreshing(false);
    }

    public void bYt() {
        if (this.Yf != null) {
            this.Yf.setVisibility(0);
        }
    }

    public void ib(boolean z) {
        if (!cqz()) {
            if (this.gAg == null) {
                this.gAg = new g(getContext());
                this.gAg.bDY();
                this.gAg.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.gAg.onChangeSkinType();
            }
            this.gAg.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this);
            this.gAg = null;
        }
    }

    public boolean cqz() {
        if (this.gAg != null) {
            return this.gAg.isViewAttached();
        }
        return false;
    }

    public void px(boolean z) {
        if (!cqA()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.iyY != null) {
                            RecommendView.this.iyY.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.sC(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Yf.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.iyY != null) {
                        RecommendView.this.iyY.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.sC(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Yf.setVisibility(8);
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqA() {
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
            if (this.gAg != null) {
                this.gAg.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iAx != null) {
                this.iAx.notifyDataSetChanged();
            }
            if (this.iAw != null) {
                this.iAw.onChangeSkinType();
            }
            ap.setBackgroundColor(this.gsg, R.color.CAM_X0205);
            ap.setBackgroundColor(this.Yf, R.color.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.iAz = cVar;
        if (this.iAz != null) {
        }
    }

    public void onDestroy() {
        if (this.Yf != null) {
            this.Yf.removeOnScrollListener(this.mOnScrollListener);
        }
        bSm();
        hideLoadingView();
        Yb();
        if (this.iAw != null) {
            this.iAw.cwJ();
        }
    }
}
