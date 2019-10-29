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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private g dEq;
    private BdSwipeRefreshLayout dzt;
    private NoNetworkView.a eRC;
    private int fcB;
    private com.baidu.tieba.enterForum.recommend.a feh;
    private RecommendForumHeaderView ffF;
    private com.baidu.tieba.enterForum.recommend.a.a ffG;
    private com.baidu.tieba.enterForum.recommend.b.a ffH;
    private com.baidu.tieba.enterForum.home.c ffI;
    private FrameLayout ffJ;
    private long ffK;
    private int ffL;
    private CustomMessageListener ffM;
    private CustomMessageListener ffN;
    c.a ffO;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private int mSkinType;
    private BdTypeRecyclerView zj;

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public RecommendView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.ffM = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.ffI != null) {
                    RecommendView.this.ffI.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.eRC = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.feh != null) {
                    RecommendView.this.feh.loadData();
                }
            }
        };
        this.ffN = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.ffH != null && l != null) {
                        RecommendView.this.ffK = l.longValue();
                        if (RecommendView.this.feh != null) {
                            RecommendView.this.feh.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int dyr = -1;
            int ffQ = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dyr != i && RecommendView.this.ffI != null) {
                    this.dyr = i;
                    if (this.dyr == 1) {
                        RecommendView.this.ffI.aJA();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.ffI.aJB();
                    } else {
                        RecommendView.this.ffI.aJA();
                    }
                    RecommendView.this.ffF.bfj();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.ffQ += i2;
                if (RecommendView.this.ffI.bey() == 2) {
                    RecommendView.this.ffI.e(recyclerView, i, i2, 0, 0);
                }
            }
        };
        this.ffO = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void beF() {
                if (RecommendView.this.ffI != null) {
                    if (RecommendView.this.a(RecommendView.this.zj)) {
                        RecommendView.this.ffI.aJB();
                    } else {
                        RecommendView.this.ffI.aJA();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fcB = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.ffL = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.ffN);
        tbPageContext.registerListener(this.ffM);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.dzt = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.dzt.setProgressView(this.mPullView);
        this.dzt.setClipChildren(false);
        this.zj = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.zj.setLayoutManager(new LinearLayoutManager(context));
        this.zj.setFadingEdgeLength(0);
        this.zj.setOverScrollMode(2);
        this.zj.setClipChildren(false);
        this.zj.addOnScrollListener(this.mOnScrollListener);
        this.ffG = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.zj);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dzt.getLayoutParams();
        marginLayoutParams.topMargin = this.fcB - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.dzt.setLayoutParams(marginLayoutParams);
        this.ffF = new RecommendForumHeaderView(this.mPageContext);
        this.ffF.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.ffL));
        this.ffJ = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ffG != null) {
            this.ffG.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.ffF != null) {
            this.ffF.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.feh = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.ffH = aVar;
            if (v.isEmpty(aVar.beY()) && v.isEmpty(aVar.beX())) {
                showNoDataView();
                return;
            }
            aMq();
            List<f> cE = aVar.cE(this.ffK);
            this.ffK = 0L;
            f fVar = (f) v.getItem(cE, 1);
            if (fVar == null) {
                fVar = (f) v.getItem(cE, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bW(cE);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cG(long j) {
        a(this.ffH, j);
    }

    private void bW(List<f> list) {
        this.zj.removeHeaderView(this.ffJ);
        this.zj.removeHeaderView(this.ffF);
        if (this.zj.getHeaderViewsCount() == 0) {
        }
        this.zj.addHeaderView(this.ffF);
        this.ffF.setData(list);
        this.ffI.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.ffG.setData(aVar.cF(j));
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void aJH() {
        this.dzt.setRefreshing(false);
    }

    public void aMq() {
        if (this.zj != null) {
            this.zj.setVisibility(0);
        }
    }

    public void dp(boolean z) {
        if (!bfl()) {
            if (this.dEq == null) {
                this.dEq = new g(getContext());
                this.dEq.onChangeSkinType();
            }
            this.dEq.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dEq != null) {
            this.dEq.dettachView(this);
            this.dEq = null;
        }
    }

    public boolean bfl() {
        if (this.dEq != null) {
            return this.dEq.isViewAttached();
        }
        return false;
    }

    public void jm(boolean z) {
        if (!bfm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.feh != null) {
                            RecommendView.this.feh.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.ka(R.drawable.new_pic_emotion_09);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.zj.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.feh != null) {
                        RecommendView.this.feh.loadData();
                    }
                }
            });
        }
        this.mRefreshView.ka(R.drawable.new_pic_emotion_05);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.no_data_text));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.zj.setVisibility(8);
    }

    public void aJo() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bfm() {
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
            if (this.dEq != null) {
                this.dEq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.ffG != null) {
                this.ffG.notifyDataSetChanged();
            }
            if (this.ffF != null) {
                this.ffF.onChangeSkinType();
            }
            am.setBackgroundColor(this.dzt, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.zj, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.ffI = cVar;
        if (this.ffI != null) {
            this.ffI.b(this.ffO);
            this.ffI.a(this.ffO);
        }
    }

    public void onDestroy() {
        if (this.zj != null) {
            this.zj.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.ffI != null) {
            this.ffI.b(this.ffO);
        }
        aJH();
        hideLoadingView();
        aJo();
        if (this.ffF != null) {
            this.ffF.bfk();
        }
    }
}
