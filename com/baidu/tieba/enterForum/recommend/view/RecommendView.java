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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes9.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView Vf;
    private BdSwipeRefreshLayout eQj;
    private g eYb;
    private int gBH;
    private com.baidu.tieba.enterForum.recommend.a gEF;
    private List<f> gEZ;
    private RecommendForumHeaderView gGd;
    private com.baidu.tieba.enterForum.recommend.a.a gGe;
    private com.baidu.tieba.enterForum.recommend.b.a gGf;
    private com.baidu.tieba.enterForum.home.c gGg;
    private FrameLayout gGh;
    private long gGi;
    private int gGj;
    private CustomMessageListener gGk;
    private NoNetworkView.a gGl;
    private CustomMessageListener gGm;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private int mSkinType;

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public RecommendView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.gGk = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.gGg != null) {
                    RecommendView.this.gGg.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.gGl = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.gEF != null) {
                    RecommendView.this.gEF.loadData();
                }
            }
        };
        this.gGm = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.gGf != null && l != null) {
                        RecommendView.this.gGi = l.longValue();
                        if (RecommendView.this.gEF != null) {
                            RecommendView.this.gEF.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int eRD = -1;
            int gGo = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.eRD != i && RecommendView.this.gGg != null) {
                    this.eRD = i;
                    if (this.eRD != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.gGd.bJr();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.gGo += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.gBH = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.gGj = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.gGm);
        tbPageContext.registerListener(this.gGk);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.eQj = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.eQj.setProgressView(this.mPullView);
        this.eQj.setClipChildren(false);
        this.Vf = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Vf.setLayoutManager(new LinearLayoutManager(context));
        this.Vf.setFadingEdgeLength(0);
        this.Vf.setOverScrollMode(2);
        this.Vf.setClipChildren(false);
        this.Vf.addOnScrollListener(this.mOnScrollListener);
        this.gGe = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Vf);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eQj.getLayoutParams();
        marginLayoutParams.topMargin = this.gBH - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.eQj.setLayoutParams(marginLayoutParams);
        this.gGd = new RecommendForumHeaderView(this.mPageContext);
        this.gGd.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.gGj));
        this.gGh = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gGe != null) {
            this.gGe.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.gGd != null) {
            this.gGd.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.gEF = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.gGf = aVar;
            if (v.isEmpty(aVar.bJf()) && v.isEmpty(aVar.lR(true))) {
                showNoDataView();
                return;
            }
            bpV();
            List<f> dY = aVar.dY(this.gGi);
            this.gGi = 0L;
            f fVar = (f) v.getItem(dY, 1);
            if (fVar == null) {
                fVar = (f) v.getItem(dY, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            cb(dY);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void dZ(long j) {
        a(this.gGf, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bJp() {
        if (this.Vf != null && !v.isEmpty(this.Vf.getData()) && this.Vf.getData().size() == 1 && (this.Vf.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cb(List<f> list) {
        this.Vf.removeHeaderView(this.gGh);
        this.Vf.removeHeaderView(this.gGd);
        if (this.Vf.getHeaderViewsCount() == 0) {
        }
        this.Vf.addHeaderView(this.gGd);
        this.gEZ = list;
        this.gGd.setData(list);
        this.gGg.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.gGe.setData(aVar.g(j, !v.isEmpty(this.gEZ)));
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void blz() {
        this.eQj.setRefreshing(false);
    }

    public void bpV() {
        if (this.Vf != null) {
            this.Vf.setVisibility(0);
        }
    }

    public void fK(boolean z) {
        if (!bJt()) {
            if (this.eYb == null) {
                this.eYb = new com.baidu.tbadk.k.g(getContext());
                this.eYb.aYp();
                this.eYb.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.eYb.onChangeSkinType();
            }
            this.eYb.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this);
            this.eYb = null;
        }
    }

    public boolean bJt() {
        if (this.eYb != null) {
            return this.eYb.isViewAttached();
        }
        return false;
    }

    public void lV(boolean z) {
        if (!bJu()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.gEF != null) {
                            RecommendView.this.gEF.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.mR(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Vf.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.gEF != null) {
                        RecommendView.this.gEF.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.mR(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Vf.setVisibility(8);
    }

    public void blt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bJu() {
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
            if (this.eYb != null) {
                this.eYb.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gGe != null) {
                this.gGe.notifyDataSetChanged();
            }
            if (this.gGd != null) {
                this.gGd.onChangeSkinType();
            }
            am.setBackgroundColor(this.eQj, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Vf, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.gGg = cVar;
        if (this.gGg != null) {
        }
    }

    public void onDestroy() {
        if (this.Vf != null) {
            this.Vf.removeOnScrollListener(this.mOnScrollListener);
        }
        blz();
        hideLoadingView();
        blt();
        if (this.gGd != null) {
            this.gGd.bJs();
        }
    }
}
