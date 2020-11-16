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
/* loaded from: classes21.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView Xi;
    private NoNetworkView.a ghn;
    private BdSwipeRefreshLayout gjV;
    private g grV;
    private int ilq;
    private com.baidu.tieba.enterForum.recommend.a ioe;
    private List<f> ioy;
    private RecommendForumHeaderView ipC;
    private com.baidu.tieba.enterForum.recommend.a.a ipD;
    private com.baidu.tieba.enterForum.recommend.b.a ipE;
    private com.baidu.tieba.enterForum.home.c ipF;
    private FrameLayout ipG;
    private long ipH;
    private int ipI;
    private CustomMessageListener ipJ;
    private CustomMessageListener ipK;
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
        this.ipJ = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.ipF != null) {
                    RecommendView.this.ipF.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.ghn = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.ioe != null) {
                    RecommendView.this.ioe.loadData();
                }
            }
        };
        this.ipK = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.ipE != null && l != null) {
                        RecommendView.this.ipH = l.longValue();
                        if (RecommendView.this.ioe != null) {
                            RecommendView.this.ioe.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int glw = -1;
            int ipM = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.glw != i && RecommendView.this.ipF != null) {
                    this.glw = i;
                    if (this.glw != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.ipC.css();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.ipM += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.ilq = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.ipI = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.ipK);
        tbPageContext.registerListener(this.ipJ);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.gjV = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gjV.setProgressView(this.mPullView);
        this.gjV.setClipChildren(false);
        this.Xi = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Xi.setLayoutManager(new LinearLayoutManager(context));
        this.Xi.setFadingEdgeLength(0);
        this.Xi.setOverScrollMode(2);
        this.Xi.setClipChildren(false);
        this.Xi.addOnScrollListener(this.mOnScrollListener);
        this.ipD = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Xi);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gjV.getLayoutParams();
        marginLayoutParams.topMargin = this.ilq - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.gjV.setLayoutParams(marginLayoutParams);
        this.ipC = new RecommendForumHeaderView(this.mPageContext);
        this.ipC.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.ipI));
        this.ipG = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ipD != null) {
            this.ipD.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.ipC != null) {
            this.ipC.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.ioe = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.ipE = aVar;
            if (y.isEmpty(aVar.csg()) && y.isEmpty(aVar.oX(true))) {
                showNoDataView();
                return;
            }
            bUJ();
            List<f> fB = aVar.fB(this.ipH);
            this.ipH = 0L;
            f fVar = (f) y.getItem(fB, 1);
            if (fVar == null) {
                fVar = (f) y.getItem(fB, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            cO(fB);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void fC(long j) {
        a(this.ipE, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void csq() {
        if (this.Xi != null && !y.isEmpty(this.Xi.getData()) && this.Xi.getData().size() == 1 && (this.Xi.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cO(List<f> list) {
        this.Xi.removeHeaderView(this.ipG);
        this.Xi.removeHeaderView(this.ipC);
        if (this.Xi.getHeaderViewsCount() == 0) {
        }
        this.Xi.addHeaderView(this.ipC);
        this.ioy = list;
        this.ipC.setData(list);
        this.ipF.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.ipD.setData(aVar.j(j, !y.isEmpty(this.ioy)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bOA() {
        this.gjV.setRefreshing(false);
    }

    public void bUJ() {
        if (this.Xi != null) {
            this.Xi.setVisibility(0);
        }
    }

    public void hM(boolean z) {
        if (!cml()) {
            if (this.grV == null) {
                this.grV = new g(getContext());
                this.grV.bAw();
                this.grV.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.grV.onChangeSkinType();
            }
            this.grV.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this);
            this.grV = null;
        }
    }

    public boolean cml() {
        if (this.grV != null) {
            return this.grV.isViewAttached();
        }
        return false;
    }

    public void pb(boolean z) {
        if (!cmm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.ioe != null) {
                            RecommendView.this.ioe.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.sb(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Xi.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.ioe != null) {
                        RecommendView.this.ioe.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.sb(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Xi.setVisibility(8);
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cmm() {
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
            if (this.grV != null) {
                this.grV.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.ipD != null) {
                this.ipD.notifyDataSetChanged();
            }
            if (this.ipC != null) {
                this.ipC.onChangeSkinType();
            }
            ap.setBackgroundColor(this.gjV, R.color.CAM_X0205);
            ap.setBackgroundColor(this.Xi, R.color.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.ipF = cVar;
        if (this.ipF != null) {
        }
    }

    public void onDestroy() {
        if (this.Xi != null) {
            this.Xi.removeOnScrollListener(this.mOnScrollListener);
        }
        bOA();
        hideLoadingView();
        VB();
        if (this.ipC != null) {
            this.ipC.cst();
        }
    }
}
