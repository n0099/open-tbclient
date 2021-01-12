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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private BdTypeRecyclerView Ya;
    private g gGD;
    private NoNetworkView.a gvp;
    private BdSwipeRefreshLayout gyy;
    private int iDS;
    private com.baidu.tieba.enterForum.recommend.a iGE;
    private List<f> iGY;
    private RecommendForumHeaderView iIb;
    private com.baidu.tieba.enterForum.recommend.a.a iIc;
    private com.baidu.tieba.enterForum.recommend.b.a iId;
    private com.baidu.tieba.enterForum.home.c iIe;
    private FrameLayout iIf;
    private long iIg;
    private int iIh;
    private CustomMessageListener iIi;
    private CustomMessageListener iIj;
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
        this.iIi = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.iIe != null) {
                    RecommendView.this.iIe.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.iGE != null) {
                    RecommendView.this.iGE.loadData();
                }
            }
        };
        this.iIj = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.iId != null && l != null) {
                        RecommendView.this.iIg = l.longValue();
                        if (RecommendView.this.iGE != null) {
                            RecommendView.this.iGE.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int gzZ = -1;
            int iIl = 0;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.gzZ != i && RecommendView.this.iIe != null) {
                    this.gzZ = i;
                    if (this.gzZ != 1) {
                        if (RecommendView.this.c(recyclerView)) {
                        }
                        RecommendView.this.iIb.cvK();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.iIl += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.iDS = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.iIh = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.iIj);
        tbPageContext.registerListener(this.iIi);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.gyy = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gyy.setProgressView(this.mPullView);
        this.gyy.setClipChildren(false);
        this.Ya = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Ya.setLayoutManager(new LinearLayoutManager(context));
        this.Ya.setFadingEdgeLength(0);
        this.Ya.setOverScrollMode(2);
        this.Ya.setClipChildren(false);
        this.Ya.addOnScrollListener(this.mOnScrollListener);
        this.iIc = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Ya);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gyy.getLayoutParams();
        marginLayoutParams.topMargin = this.iDS - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.gyy.setLayoutParams(marginLayoutParams);
        this.iIb = new RecommendForumHeaderView(this.mPageContext);
        this.iIb.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.iIh));
        this.iIf = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iIc != null) {
            this.iIc.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.iIb != null) {
            this.iIb.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.iGE = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.iId = aVar;
            if (x.isEmpty(aVar.cvy()) && x.isEmpty(aVar.pM(true))) {
                showNoDataView();
                return;
            }
            bXh();
            List<f> gf = aVar.gf(this.iIg);
            this.iIg = 0L;
            f fVar = (f) x.getItem(gf, 1);
            if (fVar == null) {
                fVar = (f) x.getItem(gf, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            cZ(gf);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void gg(long j) {
        a(this.iId, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cvI() {
        if (this.Ya != null && !x.isEmpty(this.Ya.getData()) && this.Ya.getData().size() == 1 && (this.Ya.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cZ(List<f> list) {
        this.Ya.removeHeaderView(this.iIf);
        this.Ya.removeHeaderView(this.iIb);
        if (this.Ya.getHeaderViewsCount() == 0) {
        }
        this.Ya.addHeaderView(this.iIb);
        this.iGY = list;
        this.iIb.setData(list);
        this.iIe.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.iIc.setData(aVar.l(j, !x.isEmpty(this.iGY)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bQX() {
        this.gyy.setRefreshing(false);
    }

    public void bXh() {
        if (this.Ya != null) {
            this.Ya.setVisibility(0);
        }
    }

    public void ip(boolean z) {
        if (!cpB()) {
            if (this.gGD == null) {
                this.gGD = new g(getContext());
                this.gGD.bCA();
                this.gGD.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.gGD.onChangeSkinType();
            }
            this.gGD.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
        }
    }

    public boolean cpB() {
        if (this.gGD != null) {
            return this.gGD.isViewAttached();
        }
        return false;
    }

    public void pQ(boolean z) {
        if (!cpC()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.iGE != null) {
                            RecommendView.this.iGE.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.ri(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Ya.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.iGE != null) {
                        RecommendView.this.iGE.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.ri(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Ya.setVisibility(8);
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cpC() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.CAM_X0205);
            if (this.mPullView != null) {
                this.mPullView.changeSkin(skinType);
            }
            if (this.gGD != null) {
                this.gGD.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iIc != null) {
                this.iIc.notifyDataSetChanged();
            }
            if (this.iIb != null) {
                this.iIb.onChangeSkinType();
            }
            ao.setBackgroundColor(this.gyy, R.color.CAM_X0205);
            ao.setBackgroundColor(this.Ya, R.color.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.iIe = cVar;
        if (this.iIe != null) {
        }
    }

    public void onDestroy() {
        if (this.Ya != null) {
            this.Ya.removeOnScrollListener(this.mOnScrollListener);
        }
        bQX();
        hideLoadingView();
        Vq();
        if (this.iIb != null) {
            this.iIb.cvL();
        }
    }
}
