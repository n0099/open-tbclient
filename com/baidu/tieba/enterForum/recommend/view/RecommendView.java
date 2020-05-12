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
    private BdTypeRecyclerView Vi;
    private BdSwipeRefreshLayout eQo;
    private g eYg;
    private int gBN;
    private com.baidu.tieba.enterForum.recommend.a gEL;
    private List<f> gFf;
    private RecommendForumHeaderView gGj;
    private com.baidu.tieba.enterForum.recommend.a.a gGk;
    private com.baidu.tieba.enterForum.recommend.b.a gGl;
    private com.baidu.tieba.enterForum.home.c gGm;
    private FrameLayout gGn;
    private long gGo;
    private int gGp;
    private CustomMessageListener gGq;
    private NoNetworkView.a gGr;
    private CustomMessageListener gGs;
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
        this.gGq = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.gGm != null) {
                    RecommendView.this.gGm.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.gGr = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.gEL != null) {
                    RecommendView.this.gEL.loadData();
                }
            }
        };
        this.gGs = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.gGl != null && l != null) {
                        RecommendView.this.gGo = l.longValue();
                        if (RecommendView.this.gEL != null) {
                            RecommendView.this.gEL.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int eRI = -1;
            int gGu = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.eRI != i && RecommendView.this.gGm != null) {
                    this.eRI = i;
                    if (this.eRI != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.gGj.bJq();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.gGu += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.gBN = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.gGp = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.gGs);
        tbPageContext.registerListener(this.gGq);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.eQo = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.eQo.setProgressView(this.mPullView);
        this.eQo.setClipChildren(false);
        this.Vi = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Vi.setLayoutManager(new LinearLayoutManager(context));
        this.Vi.setFadingEdgeLength(0);
        this.Vi.setOverScrollMode(2);
        this.Vi.setClipChildren(false);
        this.Vi.addOnScrollListener(this.mOnScrollListener);
        this.gGk = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Vi);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eQo.getLayoutParams();
        marginLayoutParams.topMargin = this.gBN - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.eQo.setLayoutParams(marginLayoutParams);
        this.gGj = new RecommendForumHeaderView(this.mPageContext);
        this.gGj.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.gGp));
        this.gGn = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gGk != null) {
            this.gGk.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.gGj != null) {
            this.gGj.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.gEL = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.gGl = aVar;
            if (v.isEmpty(aVar.bJe()) && v.isEmpty(aVar.lR(true))) {
                showNoDataView();
                return;
            }
            bpT();
            List<f> dY = aVar.dY(this.gGo);
            this.gGo = 0L;
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
        a(this.gGl, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bJo() {
        if (this.Vi != null && !v.isEmpty(this.Vi.getData()) && this.Vi.getData().size() == 1 && (this.Vi.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cb(List<f> list) {
        this.Vi.removeHeaderView(this.gGn);
        this.Vi.removeHeaderView(this.gGj);
        if (this.Vi.getHeaderViewsCount() == 0) {
        }
        this.Vi.addHeaderView(this.gGj);
        this.gFf = list;
        this.gGj.setData(list);
        this.gGm.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.gGk.setData(aVar.g(j, !v.isEmpty(this.gFf)));
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void blx() {
        this.eQo.setRefreshing(false);
    }

    public void bpT() {
        if (this.Vi != null) {
            this.Vi.setVisibility(0);
        }
    }

    public void fK(boolean z) {
        if (!bJs()) {
            if (this.eYg == null) {
                this.eYg = new com.baidu.tbadk.k.g(getContext());
                this.eYg.aYn();
                this.eYg.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.eYg.onChangeSkinType();
            }
            this.eYg.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this);
            this.eYg = null;
        }
    }

    public boolean bJs() {
        if (this.eYg != null) {
            return this.eYg.isViewAttached();
        }
        return false;
    }

    public void lV(boolean z) {
        if (!bJt()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.gEL != null) {
                            RecommendView.this.gEL.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.mR(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Vi.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.gEL != null) {
                        RecommendView.this.gEL.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.mR(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Vi.setVisibility(8);
    }

    public void blr() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bJt() {
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
            if (this.eYg != null) {
                this.eYg.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gGk != null) {
                this.gGk.notifyDataSetChanged();
            }
            if (this.gGj != null) {
                this.gGj.onChangeSkinType();
            }
            am.setBackgroundColor(this.eQo, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Vi, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.gGm = cVar;
        if (this.gGm != null) {
        }
    }

    public void onDestroy() {
        if (this.Vi != null) {
            this.Vi.removeOnScrollListener(this.mOnScrollListener);
        }
        blx();
        hideLoadingView();
        blr();
        if (this.gGj != null) {
            this.gGj.bJr();
        }
    }
}
