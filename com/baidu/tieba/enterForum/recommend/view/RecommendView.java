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
    private BdTypeRecyclerView WM;
    private NoNetworkView.a fFF;
    private BdSwipeRefreshLayout fIl;
    private g fQf;
    private int hDi;
    private com.baidu.tieba.enterForum.recommend.a hFW;
    private List<f> hGq;
    private int hHA;
    private CustomMessageListener hHB;
    private CustomMessageListener hHC;
    private RecommendForumHeaderView hHu;
    private com.baidu.tieba.enterForum.recommend.a.a hHv;
    private com.baidu.tieba.enterForum.recommend.b.a hHw;
    private com.baidu.tieba.enterForum.home.c hHx;
    private FrameLayout hHy;
    private long hHz;
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
        this.hHB = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.hHx != null) {
                    RecommendView.this.hHx.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fFF = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.hFW != null) {
                    RecommendView.this.hFW.loadData();
                }
            }
        };
        this.hHC = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.hHw != null && l != null) {
                        RecommendView.this.hHz = l.longValue();
                        if (RecommendView.this.hFW != null) {
                            RecommendView.this.hFW.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int fJF = -1;
            int hHE = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.fJF != i && RecommendView.this.hHx != null) {
                    this.fJF = i;
                    if (this.fJF != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.hHu.cjL();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.hHE += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.hDi = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.hHA = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.hHC);
        tbPageContext.registerListener(this.hHB);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.fIl = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fIl.setProgressView(this.mPullView);
        this.fIl.setClipChildren(false);
        this.WM = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.WM.setLayoutManager(new LinearLayoutManager(context));
        this.WM.setFadingEdgeLength(0);
        this.WM.setOverScrollMode(2);
        this.WM.setClipChildren(false);
        this.WM.addOnScrollListener(this.mOnScrollListener);
        this.hHv = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.WM);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fIl.getLayoutParams();
        marginLayoutParams.topMargin = this.hDi - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.fIl.setLayoutParams(marginLayoutParams);
        this.hHu = new RecommendForumHeaderView(this.mPageContext);
        this.hHu.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.hHA));
        this.hHy = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hHv != null) {
            this.hHv.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.hHu != null) {
            this.hHu.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.hFW = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.hHw = aVar;
            if (y.isEmpty(aVar.cjz()) && y.isEmpty(aVar.nO(true))) {
                showNoDataView();
                return;
            }
            bMD();
            List<f> eK = aVar.eK(this.hHz);
            this.hHz = 0L;
            f fVar = (f) y.getItem(eK, 1);
            if (fVar == null) {
                fVar = (f) y.getItem(eK, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            cu(eK);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void eL(long j) {
        a(this.hHw, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cjJ() {
        if (this.WM != null && !y.isEmpty(this.WM.getData()) && this.WM.getData().size() == 1 && (this.WM.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cu(List<f> list) {
        this.WM.removeHeaderView(this.hHy);
        this.WM.removeHeaderView(this.hHu);
        if (this.WM.getHeaderViewsCount() == 0) {
        }
        this.WM.addHeaderView(this.hHu);
        this.hGq = list;
        this.hHu.setData(list);
        this.hHx.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.hHv.setData(aVar.i(j, !y.isEmpty(this.hGq)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bHu() {
        this.fIl.setRefreshing(false);
    }

    public void bMD() {
        if (this.WM != null) {
            this.WM.setVisibility(0);
        }
    }

    public void gR(boolean z) {
        if (!cdE()) {
            if (this.fQf == null) {
                this.fQf = new g(getContext());
                this.fQf.bue();
                this.fQf.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.fQf.onChangeSkinType();
            }
            this.fQf.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
            this.fQf = null;
        }
    }

    public boolean cdE() {
        if (this.fQf != null) {
            return this.fQf.isViewAttached();
        }
        return false;
    }

    public void nS(boolean z) {
        if (!cdF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.hFW != null) {
                            RecommendView.this.hFW.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.qK(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.WM.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.hFW != null) {
                        RecommendView.this.hFW.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.qK(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.WM.setVisibility(8);
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cdF() {
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
            if (this.fQf != null) {
                this.fQf.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hHv != null) {
                this.hHv.notifyDataSetChanged();
            }
            if (this.hHu != null) {
                this.hHu.onChangeSkinType();
            }
            ap.setBackgroundColor(this.fIl, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.WM, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.hHx = cVar;
        if (this.hHx != null) {
        }
    }

    public void onDestroy() {
        if (this.WM != null) {
            this.WM.removeOnScrollListener(this.mOnScrollListener);
        }
        bHu();
        hideLoadingView();
        bHn();
        if (this.hHu != null) {
            this.hHu.cjM();
        }
    }
}
