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
    private BdTypeRecyclerView Vw;
    private NoNetworkView.a faB;
    private BdSwipeRefreshLayout fdh;
    private g flb;
    private int gQH;
    private com.baidu.tieba.enterForum.recommend.a gTE;
    private List<f> gTY;
    private RecommendForumHeaderView gVc;
    private com.baidu.tieba.enterForum.recommend.a.a gVd;
    private com.baidu.tieba.enterForum.recommend.b.a gVe;
    private com.baidu.tieba.enterForum.home.c gVf;
    private FrameLayout gVg;
    private long gVh;
    private int gVi;
    private CustomMessageListener gVj;
    private CustomMessageListener gVk;
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
        this.gVj = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.gVf != null) {
                    RecommendView.this.gVf.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.faB = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.gTE != null) {
                    RecommendView.this.gTE.loadData();
                }
            }
        };
        this.gVk = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.gVe != null && l != null) {
                        RecommendView.this.gVh = l.longValue();
                        if (RecommendView.this.gTE != null) {
                            RecommendView.this.gTE.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int feB = -1;
            int gVm = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.feB != i && RecommendView.this.gVf != null) {
                    this.feB = i;
                    if (this.feB != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.gVc.bPL();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.gVm += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.gQH = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.gVi = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.gVk);
        tbPageContext.registerListener(this.gVj);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.fdh = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fdh.setProgressView(this.mPullView);
        this.fdh.setClipChildren(false);
        this.Vw = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(context));
        this.Vw.setFadingEdgeLength(0);
        this.Vw.setOverScrollMode(2);
        this.Vw.setClipChildren(false);
        this.Vw.addOnScrollListener(this.mOnScrollListener);
        this.gVd = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Vw);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fdh.getLayoutParams();
        marginLayoutParams.topMargin = this.gQH - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.fdh.setLayoutParams(marginLayoutParams);
        this.gVc = new RecommendForumHeaderView(this.mPageContext);
        this.gVc.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.gVi));
        this.gVg = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gVd != null) {
            this.gVd.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.gVc != null) {
            this.gVc.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.gTE = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.gVe = aVar;
            if (v.isEmpty(aVar.bPz()) && v.isEmpty(aVar.mm(true))) {
                showNoDataView();
                return;
            }
            bvO();
            List<f> dZ = aVar.dZ(this.gVh);
            this.gVh = 0L;
            f fVar = (f) v.getItem(dZ, 1);
            if (fVar == null) {
                fVar = (f) v.getItem(dZ, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bY(dZ);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void ea(long j) {
        a(this.gVe, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bPJ() {
        if (this.Vw != null && !v.isEmpty(this.Vw.getData()) && this.Vw.getData().size() == 1 && (this.Vw.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void bY(List<f> list) {
        this.Vw.removeHeaderView(this.gVg);
        this.Vw.removeHeaderView(this.gVc);
        if (this.Vw.getHeaderViewsCount() == 0) {
        }
        this.Vw.addHeaderView(this.gVc);
        this.gTY = list;
        this.gVc.setData(list);
        this.gVf.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.gVd.setData(aVar.h(j, !v.isEmpty(this.gTY)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bqX() {
        this.fdh.setRefreshing(false);
    }

    public void bvO() {
        if (this.Vw != null) {
            this.Vw.setVisibility(0);
        }
    }

    public void fV(boolean z) {
        if (!bPN()) {
            if (this.flb == null) {
                this.flb = new g(getContext());
                this.flb.bex();
                this.flb.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.flb.onChangeSkinType();
            }
            this.flb.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this);
            this.flb = null;
        }
    }

    public boolean bPN() {
        if (this.flb != null) {
            return this.flb.isViewAttached();
        }
        return false;
    }

    public void mq(boolean z) {
        if (!bPO()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.gTE != null) {
                            RecommendView.this.gTE.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.nv(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Vw.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.gTE != null) {
                        RecommendView.this.gTE.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.nv(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Vw.setVisibility(8);
    }

    public void bqQ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bPO() {
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
            if (this.flb != null) {
                this.flb.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gVd != null) {
                this.gVd.notifyDataSetChanged();
            }
            if (this.gVc != null) {
                this.gVc.onChangeSkinType();
            }
            am.setBackgroundColor(this.fdh, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Vw, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.gVf = cVar;
        if (this.gVf != null) {
        }
    }

    public void onDestroy() {
        if (this.Vw != null) {
            this.Vw.removeOnScrollListener(this.mOnScrollListener);
        }
        bqX();
        hideLoadingView();
        bqQ();
        if (this.gVc != null) {
            this.gVc.bPM();
        }
    }
}
