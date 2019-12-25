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
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.recommend.b.e;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.view.ForumTestView;
import java.util.List;
/* loaded from: classes6.dex */
public class RecommendView extends FrameLayout implements ForumTestView.a {
    private BdTypeRecyclerView Bn;
    private BdSwipeRefreshLayout ejE;
    private g eoy;
    private int fQo;
    private com.baidu.tieba.enterForum.recommend.a fRT;
    private CustomMessageListener fTA;
    c.a fTB;
    private RecommendForumHeaderView fTr;
    private com.baidu.tieba.enterForum.recommend.a.a fTs;
    private com.baidu.tieba.enterForum.recommend.b.a fTt;
    private com.baidu.tieba.enterForum.home.c fTu;
    private FrameLayout fTv;
    private long fTw;
    private int fTx;
    private CustomMessageListener fTy;
    private NoNetworkView.a fTz;
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
        this.fTy = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.fTu != null) {
                    RecommendView.this.fTu.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.fTz = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.fRT != null) {
                    RecommendView.this.fRT.loadData();
                }
            }
        };
        this.fTA = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.fTt != null && l != null) {
                        RecommendView.this.fTw = l.longValue();
                        if (RecommendView.this.fRT != null) {
                            RecommendView.this.fRT.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int eiC = -1;
            int fTD = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.eiC != i && RecommendView.this.fTu != null) {
                    this.eiC = i;
                    if (this.eiC == 1) {
                        RecommendView.this.fTu.aZW();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.fTu.aZX();
                    } else {
                        RecommendView.this.fTu.aZW();
                    }
                    RecommendView.this.fTr.bwC();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.fTD += i2;
                if (RecommendView.this.fTu.bvR() == 2) {
                    RecommendView.this.fTu.e(recyclerView, i, i2, 0, 0);
                }
            }
        };
        this.fTB = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void bvX() {
                if (RecommendView.this.fTu != null) {
                    if (RecommendView.this.a(RecommendView.this.Bn)) {
                        RecommendView.this.fTu.aZX();
                    } else {
                        RecommendView.this.fTu.aZW();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fQo = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.fTx = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.fTA);
        tbPageContext.registerListener(this.fTy);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.ejE = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new h(this.mPageContext);
        this.ejE.setProgressView(this.mPullView);
        this.ejE.setClipChildren(false);
        this.Bn = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Bn.setLayoutManager(new LinearLayoutManager(context));
        this.Bn.setFadingEdgeLength(0);
        this.Bn.setOverScrollMode(2);
        this.Bn.setClipChildren(false);
        this.Bn.addOnScrollListener(this.mOnScrollListener);
        this.fTs = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Bn);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ejE.getLayoutParams();
        marginLayoutParams.topMargin = this.fQo - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.ejE.setLayoutParams(marginLayoutParams);
        this.fTr = new RecommendForumHeaderView(this.mPageContext);
        this.fTr.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.fTx));
        this.fTv = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fTs != null) {
            this.fTs.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fTr != null) {
            this.fTr.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.fRT = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.fTt = aVar;
            if (v.isEmpty(aVar.bwq()) && v.isEmpty(aVar.bwp())) {
                showNoDataView();
                return;
            }
            bdR();
            List<f> dj = aVar.dj(this.fTw);
            this.fTw = 0L;
            f fVar = (f) v.getItem(dj, 1);
            if (fVar == null) {
                fVar = (f) v.getItem(dj, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bS(dj);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void dl(long j) {
        a(this.fTt, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bwA() {
        if (this.Bn != null && !v.isEmpty(this.Bn.getData()) && this.Bn.getData().size() == 1 && (this.Bn.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void bS(List<f> list) {
        this.Bn.removeHeaderView(this.fTv);
        this.Bn.removeHeaderView(this.fTr);
        if (this.Bn.getHeaderViewsCount() == 0) {
        }
        this.Bn.addHeaderView(this.fTr);
        this.fTr.setData(list);
        this.fTu.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.fTs.setData(aVar.dk(j));
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bad() {
        this.ejE.setRefreshing(false);
    }

    public void bdR() {
        if (this.Bn != null) {
            this.Bn.setVisibility(0);
        }
    }

    public void eA(boolean z) {
        if (!bwE()) {
            if (this.eoy == null) {
                this.eoy = new com.baidu.tbadk.k.g(getContext());
                this.eoy.aNc();
                this.eoy.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.eoy.onChangeSkinType();
            }
            this.eoy.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this);
            this.eoy = null;
        }
    }

    public boolean bwE() {
        if (this.eoy != null) {
            return this.eoy.isViewAttached();
        }
        return false;
    }

    public void ky(boolean z) {
        if (!bwF()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.fRT != null) {
                            RecommendView.this.fRT.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.mn(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Bn.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.fRT != null) {
                        RecommendView.this.fRT.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.mn(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Bn.setVisibility(8);
    }

    public void aZK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bwF() {
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
            if (this.eoy != null) {
                this.eoy.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fTs != null) {
                this.fTs.notifyDataSetChanged();
            }
            if (this.fTr != null) {
                this.fTr.onChangeSkinType();
            }
            am.setBackgroundColor(this.ejE, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Bn, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.fTu = cVar;
        if (this.fTu != null) {
            this.fTu.b(this.fTB);
            this.fTu.a(this.fTB);
        }
    }

    public void onDestroy() {
        if (this.Bn != null) {
            this.Bn.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.fTu != null) {
            this.fTu.b(this.fTB);
        }
        bad();
        hideLoadingView();
        aZK();
        if (this.fTr != null) {
            this.fTr.bwD();
        }
    }
}
