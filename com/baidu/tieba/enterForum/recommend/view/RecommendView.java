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
    private BdTypeRecyclerView Zq;
    private BdSwipeRefreshLayout gDf;
    private g gLk;
    private NoNetworkView.a gzW;
    private int iLz;
    private List<f> iOE;
    private com.baidu.tieba.enterForum.recommend.a iOk;
    private RecommendForumHeaderView iPG;
    private com.baidu.tieba.enterForum.recommend.a.a iPH;
    private com.baidu.tieba.enterForum.recommend.b.a iPI;
    private com.baidu.tieba.enterForum.home.c iPJ;
    private FrameLayout iPK;
    private long iPL;
    private int iPM;
    private CustomMessageListener iPN;
    private CustomMessageListener iPO;
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
        this.iPN = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.iPJ != null) {
                    RecommendView.this.iPJ.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.iOk != null) {
                    RecommendView.this.iOk.loadData();
                }
            }
        };
        this.iPO = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.iPI != null && l != null) {
                        RecommendView.this.iPL = l.longValue();
                        if (RecommendView.this.iOk != null) {
                            RecommendView.this.iOk.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int gEG = -1;
            int iPQ = 0;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.gEG != i && RecommendView.this.iPJ != null) {
                    this.gEG = i;
                    if (this.gEG != 1) {
                        if (RecommendView.this.c(recyclerView)) {
                        }
                        RecommendView.this.iPG.cxj();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.iPQ += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.iLz = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.iPM = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.iPO);
        tbPageContext.registerListener(this.iPN);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.gDf = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gDf.setProgressView(this.mPullView);
        this.gDf.setClipChildren(false);
        this.Zq = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Zq.setLayoutManager(new LinearLayoutManager(context));
        this.Zq.setFadingEdgeLength(0);
        this.Zq.setOverScrollMode(2);
        this.Zq.setClipChildren(false);
        this.Zq.addOnScrollListener(this.mOnScrollListener);
        this.iPH = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Zq);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gDf.getLayoutParams();
        marginLayoutParams.topMargin = this.iLz - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.gDf.setLayoutParams(marginLayoutParams);
        this.iPG = new RecommendForumHeaderView(this.mPageContext);
        this.iPG.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.iPM));
        this.iPK = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iPH != null) {
            this.iPH.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.iPG != null) {
            this.iPG.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.iOk = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.iPI = aVar;
            if (y.isEmpty(aVar.cwX()) && y.isEmpty(aVar.pW(true))) {
                showNoDataView();
                return;
            }
            bYu();
            List<f> gk = aVar.gk(this.iPL);
            this.iPL = 0L;
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
        a(this.iPI, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cxh() {
        if (this.Zq != null && !y.isEmpty(this.Zq.getData()) && this.Zq.getData().size() == 1 && (this.Zq.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cU(List<f> list) {
        this.Zq.removeHeaderView(this.iPK);
        this.Zq.removeHeaderView(this.iPG);
        if (this.Zq.getHeaderViewsCount() == 0) {
        }
        this.Zq.addHeaderView(this.iPG);
        this.iOE = list;
        this.iPG.setData(list);
        this.iPJ.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.iPH.setData(aVar.l(j, !y.isEmpty(this.iOE)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bRO() {
        this.gDf.setRefreshing(false);
    }

    public void bYu() {
        if (this.Zq != null) {
            this.Zq.setVisibility(0);
        }
    }

    public void ir(boolean z) {
        if (!cqY()) {
            if (this.gLk == null) {
                this.gLk = new g(getContext());
                this.gLk.bCV();
                this.gLk.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.gLk.onChangeSkinType();
            }
            this.gLk.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
            this.gLk = null;
        }
    }

    public boolean cqY() {
        if (this.gLk != null) {
            return this.gLk.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqZ()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.iOk != null) {
                            RecommendView.this.iOk.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.ro(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Zq.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.iOk != null) {
                        RecommendView.this.iOk.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.ro(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Zq.setVisibility(8);
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqZ() {
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
            if (this.gLk != null) {
                this.gLk.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iPH != null) {
                this.iPH.notifyDataSetChanged();
            }
            if (this.iPG != null) {
                this.iPG.onChangeSkinType();
            }
            ap.setBackgroundColor(this.gDf, R.color.CAM_X0205);
            ap.setBackgroundColor(this.Zq, R.color.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.iPJ = cVar;
        if (this.iPJ != null) {
        }
    }

    public void onDestroy() {
        if (this.Zq != null) {
            this.Zq.removeOnScrollListener(this.mOnScrollListener);
        }
        bRO();
        hideLoadingView();
        Xc();
        if (this.iPG != null) {
            this.iPG.cxk();
        }
    }
}
