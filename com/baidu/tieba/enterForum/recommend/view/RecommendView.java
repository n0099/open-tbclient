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
    private BdSwipeRefreshLayout gBi;
    private g gJn;
    private NoNetworkView.a gxZ;
    private int iJC;
    private List<f> iMH;
    private com.baidu.tieba.enterForum.recommend.a iMn;
    private RecommendForumHeaderView iNJ;
    private com.baidu.tieba.enterForum.recommend.a.a iNK;
    private com.baidu.tieba.enterForum.recommend.b.a iNL;
    private com.baidu.tieba.enterForum.home.c iNM;
    private FrameLayout iNN;
    private long iNO;
    private int iNP;
    private CustomMessageListener iNQ;
    private CustomMessageListener iNR;
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
        this.iNQ = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.iNM != null) {
                    RecommendView.this.iNM.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.gxZ = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.iMn != null) {
                    RecommendView.this.iMn.loadData();
                }
            }
        };
        this.iNR = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.iNL != null && l != null) {
                        RecommendView.this.iNO = l.longValue();
                        if (RecommendView.this.iMn != null) {
                            RecommendView.this.iMn.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int gCJ = -1;
            int iNT = 0;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.gCJ != i && RecommendView.this.iNM != null) {
                    this.gCJ = i;
                    if (this.gCJ != 1) {
                        if (RecommendView.this.c(recyclerView)) {
                        }
                        RecommendView.this.iNJ.cwW();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.iNT += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.iJC = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.iNP = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.iNR);
        tbPageContext.registerListener(this.iNQ);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.gBi = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gBi.setProgressView(this.mPullView);
        this.gBi.setClipChildren(false);
        this.XW = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.XW.setLayoutManager(new LinearLayoutManager(context));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        this.XW.setClipChildren(false);
        this.XW.addOnScrollListener(this.mOnScrollListener);
        this.iNK = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.XW);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gBi.getLayoutParams();
        marginLayoutParams.topMargin = this.iJC - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.gBi.setLayoutParams(marginLayoutParams);
        this.iNJ = new RecommendForumHeaderView(this.mPageContext);
        this.iNJ.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.iNP));
        this.iNN = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iNK != null) {
            this.iNK.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.iNJ != null) {
            this.iNJ.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.iMn = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.iNL = aVar;
            if (y.isEmpty(aVar.cwK()) && y.isEmpty(aVar.pW(true))) {
                showNoDataView();
                return;
            }
            bYh();
            List<f> gk = aVar.gk(this.iNO);
            this.iNO = 0L;
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
        a(this.iNL, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cwU() {
        if (this.XW != null && !y.isEmpty(this.XW.getData()) && this.XW.getData().size() == 1 && (this.XW.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cU(List<f> list) {
        this.XW.removeHeaderView(this.iNN);
        this.XW.removeHeaderView(this.iNJ);
        if (this.XW.getHeaderViewsCount() == 0) {
        }
        this.XW.addHeaderView(this.iNJ);
        this.iMH = list;
        this.iNJ.setData(list);
        this.iNM.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.iNK.setData(aVar.l(j, !y.isEmpty(this.iMH)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bRB() {
        this.gBi.setRefreshing(false);
    }

    public void bYh() {
        if (this.XW != null) {
            this.XW.setVisibility(0);
        }
    }

    public void ir(boolean z) {
        if (!cqL()) {
            if (this.gJn == null) {
                this.gJn = new g(getContext());
                this.gJn.bCS();
                this.gJn.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.gJn.onChangeSkinType();
            }
            this.gJn.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this);
            this.gJn = null;
        }
    }

    public boolean cqL() {
        if (this.gJn != null) {
            return this.gJn.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.iMn != null) {
                            RecommendView.this.iMn.loadData();
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
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.iMn != null) {
                        RecommendView.this.iMn.loadData();
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

    public boolean cqM() {
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
            if (this.gJn != null) {
                this.gJn.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iNK != null) {
                this.iNK.notifyDataSetChanged();
            }
            if (this.iNJ != null) {
                this.iNJ.onChangeSkinType();
            }
            ap.setBackgroundColor(this.gBi, R.color.CAM_X0205);
            ap.setBackgroundColor(this.XW, R.color.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.iNM = cVar;
        if (this.iNM != null) {
        }
    }

    public void onDestroy() {
        if (this.XW != null) {
            this.XW.removeOnScrollListener(this.mOnScrollListener);
        }
        bRB();
        hideLoadingView();
        WZ();
        if (this.iNJ != null) {
            this.iNJ.cwX();
        }
    }
}
