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
    private BdTypeRecyclerView Oo;
    private g dly;
    private BdSwipeRefreshLayout dsj;
    private NoNetworkView.a eIX;
    private int eZQ;
    private com.baidu.tieba.enterForum.recommend.a fbw;
    private RecommendForumHeaderView fcU;
    private com.baidu.tieba.enterForum.recommend.a.a fcV;
    private com.baidu.tieba.enterForum.recommend.b.a fcW;
    private com.baidu.tieba.enterForum.home.c fcX;
    private FrameLayout fcY;
    private long fcZ;
    private int fda;
    private CustomMessageListener fdb;
    private CustomMessageListener fdc;
    c.a fdd;
    RecyclerView.OnScrollListener mOnScrollListener;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private int mSkinType;

    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public RecommendView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fdb = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.fcX != null) {
                    RecommendView.this.fcX.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void es(boolean z) {
                if (z && RecommendView.this.fbw != null) {
                    RecommendView.this.fbw.loadData();
                }
            }
        };
        this.fdc = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.fcW != null && l != null) {
                        RecommendView.this.fcZ = l.longValue();
                        if (RecommendView.this.fbw != null) {
                            RecommendView.this.fbw.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int drh = -1;
            int fdf = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.drh != i && RecommendView.this.fcX != null) {
                    this.drh = i;
                    if (this.drh == 1) {
                        RecommendView.this.fcX.aKa();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.fcX.aKb();
                    } else {
                        RecommendView.this.fcX.aKa();
                    }
                    RecommendView.this.fcU.bhp();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.fdf += i2;
                if (RecommendView.this.fcX.bgF() == 2) {
                    RecommendView.this.fcX.d(recyclerView, i, i2, 0, 0);
                }
            }
        };
        this.fdd = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void bgM() {
                if (RecommendView.this.fcX != null) {
                    if (RecommendView.this.a(RecommendView.this.Oo)) {
                        RecommendView.this.fcX.aKb();
                    } else {
                        RecommendView.this.fcX.aKa();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eZQ = UtilHelper.getStatusBarHeight() + l.g(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.fda = l.g(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.fdc);
        tbPageContext.registerListener(this.fdb);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.dsj = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.dsj.setProgressView(this.mPullView);
        this.dsj.setClipChildren(false);
        this.Oo = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Oo.setLayoutManager(new LinearLayoutManager(context));
        this.Oo.setFadingEdgeLength(0);
        this.Oo.setOverScrollMode(2);
        this.Oo.setClipChildren(false);
        this.Oo.addOnScrollListener(this.mOnScrollListener);
        this.fcV = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Oo);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dsj.getLayoutParams();
        marginLayoutParams.topMargin = this.eZQ - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.dsj.setLayoutParams(marginLayoutParams);
        this.fcU = new RecommendForumHeaderView(this.mPageContext);
        this.fcU.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.fda));
        this.fcY = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fcV != null) {
            this.fcV.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fcU != null) {
            this.fcU.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.fbw = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.fcW = aVar;
            if (v.aa(aVar.bhe()) && v.aa(aVar.bhd())) {
                showNoDataView();
                return;
            }
            aWv();
            List<f> de = aVar.de(this.fcZ);
            this.fcZ = 0L;
            f fVar = (f) v.c(de, 1);
            if (fVar == null) {
                fVar = (f) v.c(de, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bJ(de);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void dg(long j) {
        a(this.fcW, j);
    }

    private void bJ(List<f> list) {
        this.Oo.removeHeaderView(this.fcY);
        this.Oo.removeHeaderView(this.fcU);
        if (this.Oo.getHeaderViewsCount() == 0) {
        }
        this.Oo.addHeaderView(this.fcU);
        this.fcU.setData(list);
        this.fcX.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.fcV.setData(aVar.df(j));
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void aKh() {
        this.dsj.setRefreshing(false);
    }

    public void aWv() {
        if (this.Oo != null) {
            this.Oo.setVisibility(0);
        }
    }

    public void cY(boolean z) {
        if (!bhr()) {
            if (this.dly == null) {
                this.dly = new g(getContext());
                this.dly.onChangeSkinType();
            }
            this.dly.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dly != null) {
            this.dly.dettachView(this);
            this.dly = null;
        }
    }

    public boolean bhr() {
        if (this.dly != null) {
            return this.dly.isViewAttached();
        }
        return false;
    }

    public void jx(boolean z) {
        if (!bhs()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && RecommendView.this.fbw != null) {
                            RecommendView.this.fbw.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.kM(R.drawable.new_pic_emotion_09);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atW();
            this.Oo.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jQ() && RecommendView.this.fbw != null) {
                        RecommendView.this.fbw.loadData();
                    }
                }
            });
        }
        this.mRefreshView.kM(R.drawable.new_pic_emotion_05);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.no_data_text));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.atW();
        this.Oo.setVisibility(8);
    }

    public void aJN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bhs() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.cp_bg_line_e);
            if (this.mPullView != null) {
                this.mPullView.iY(skinType);
            }
            if (this.dly != null) {
                this.dly.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fcV != null) {
                this.fcV.notifyDataSetChanged();
            }
            if (this.fcU != null) {
                this.fcU.onChangeSkinType();
            }
            am.l(this.dsj, R.color.cp_bg_line_e);
            am.l(this.Oo, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.fcX = cVar;
        if (this.fcX != null) {
            this.fcX.b(this.fdd);
            this.fcX.a(this.fdd);
        }
    }

    public void onDestroy() {
        if (this.Oo != null) {
            this.Oo.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.fcX != null) {
            this.fcX.b(this.fdd);
        }
        aKh();
        hideLoadingView();
        aJN();
        if (this.fcU != null) {
            this.fcU.bhq();
        }
    }
}
