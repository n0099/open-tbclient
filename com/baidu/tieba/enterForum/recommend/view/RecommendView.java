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
/* loaded from: classes22.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView Xc;
    private NoNetworkView.a fRO;
    private BdSwipeRefreshLayout fUv;
    private g gcx;
    private int hSe;
    private com.baidu.tieba.enterForum.recommend.a hUR;
    private List<f> hVl;
    private RecommendForumHeaderView hWp;
    private com.baidu.tieba.enterForum.recommend.a.a hWq;
    private com.baidu.tieba.enterForum.recommend.b.a hWr;
    private com.baidu.tieba.enterForum.home.c hWs;
    private FrameLayout hWt;
    private long hWu;
    private int hWv;
    private CustomMessageListener hWw;
    private CustomMessageListener hWx;
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
        this.hWw = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.hWs != null) {
                    RecommendView.this.hWs.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fRO = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.hUR != null) {
                    RecommendView.this.hUR.loadData();
                }
            }
        };
        this.hWx = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.hWr != null && l != null) {
                        RecommendView.this.hWu = l.longValue();
                        if (RecommendView.this.hUR != null) {
                            RecommendView.this.hUR.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int fVW = -1;
            int hWz = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.fVW != i && RecommendView.this.hWs != null) {
                    this.fVW = i;
                    if (this.fVW != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.hWp.cnh();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.hWz += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.hSe = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.hWv = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.hWx);
        tbPageContext.registerListener(this.hWw);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.fUv = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fUv.setProgressView(this.mPullView);
        this.fUv.setClipChildren(false);
        this.Xc = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Xc.setLayoutManager(new LinearLayoutManager(context));
        this.Xc.setFadingEdgeLength(0);
        this.Xc.setOverScrollMode(2);
        this.Xc.setClipChildren(false);
        this.Xc.addOnScrollListener(this.mOnScrollListener);
        this.hWq = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Xc);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fUv.getLayoutParams();
        marginLayoutParams.topMargin = this.hSe - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.fUv.setLayoutParams(marginLayoutParams);
        this.hWp = new RecommendForumHeaderView(this.mPageContext);
        this.hWp.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.hWv));
        this.hWt = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hWq != null) {
            this.hWq.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.hWp != null) {
            this.hWp.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.hUR = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.hWr = aVar;
            if (y.isEmpty(aVar.cmV()) && y.isEmpty(aVar.ot(true))) {
                showNoDataView();
                return;
            }
            bPU();
            List<f> fb = aVar.fb(this.hWu);
            this.hWu = 0L;
            f fVar = (f) y.getItem(fb, 1);
            if (fVar == null) {
                fVar = (f) y.getItem(fb, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            cx(fb);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void fc(long j) {
        a(this.hWr, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cnf() {
        if (this.Xc != null && !y.isEmpty(this.Xc.getData()) && this.Xc.getData().size() == 1 && (this.Xc.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cx(List<f> list) {
        this.Xc.removeHeaderView(this.hWt);
        this.Xc.removeHeaderView(this.hWp);
        if (this.Xc.getHeaderViewsCount() == 0) {
        }
        this.Xc.addHeaderView(this.hWp);
        this.hVl = list;
        this.hWp.setData(list);
        this.hWs.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.hWq.setData(aVar.i(j, !y.isEmpty(this.hVl)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bKf() {
        this.fUv.setRefreshing(false);
    }

    public void bPU() {
        if (this.Xc != null) {
            this.Xc.setVisibility(0);
        }
    }

    public void hn(boolean z) {
        if (!cha()) {
            if (this.gcx == null) {
                this.gcx = new g(getContext());
                this.gcx.bwO();
                this.gcx.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.gcx.onChangeSkinType();
            }
            this.gcx.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this);
            this.gcx = null;
        }
    }

    public boolean cha() {
        if (this.gcx != null) {
            return this.gcx.isViewAttached();
        }
        return false;
    }

    public void ox(boolean z) {
        if (!chb()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.hUR != null) {
                            RecommendView.this.hUR.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.ri(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Xc.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.hUR != null) {
                        RecommendView.this.hUR.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.ri(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Xc.setVisibility(8);
    }

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean chb() {
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
            if (this.gcx != null) {
                this.gcx.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.hWq != null) {
                this.hWq.notifyDataSetChanged();
            }
            if (this.hWp != null) {
                this.hWp.onChangeSkinType();
            }
            ap.setBackgroundColor(this.fUv, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Xc, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.hWs = cVar;
        if (this.hWs != null) {
        }
    }

    public void onDestroy() {
        if (this.Xc != null) {
            this.Xc.removeOnScrollListener(this.mOnScrollListener);
        }
        bKf();
        hideLoadingView();
        SK();
        if (this.hWp != null) {
            this.hWp.cni();
        }
    }
}
