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
    private BdTypeRecyclerView Op;
    private g djN;
    private BdSwipeRefreshLayout dqy;
    private NoNetworkView.a eHo;
    private int eYk;
    private com.baidu.tieba.enterForum.recommend.a eZQ;
    private RecommendForumHeaderView fbo;
    private com.baidu.tieba.enterForum.recommend.a.a fbp;
    private com.baidu.tieba.enterForum.recommend.b.a fbq;
    private com.baidu.tieba.enterForum.home.c fbr;
    private FrameLayout fbs;
    private long fbt;
    private int fbu;
    private CustomMessageListener fbv;
    private CustomMessageListener fbw;
    c.a fbx;
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
        this.fbv = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.fbr != null) {
                    RecommendView.this.fbr.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                if (z && RecommendView.this.eZQ != null) {
                    RecommendView.this.eZQ.loadData();
                }
            }
        };
        this.fbw = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.fbq != null && l != null) {
                        RecommendView.this.fbt = l.longValue();
                        if (RecommendView.this.eZQ != null) {
                            RecommendView.this.eZQ.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int dpw = -1;
            int fbz = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.dpw != i && RecommendView.this.fbr != null) {
                    this.dpw = i;
                    if (this.dpw == 1) {
                        RecommendView.this.fbr.aJw();
                        return;
                    }
                    if (RecommendView.this.a(recyclerView)) {
                        RecommendView.this.fbr.aJx();
                    } else {
                        RecommendView.this.fbr.aJw();
                    }
                    RecommendView.this.fbo.bgJ();
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.fbz += i2;
                if (RecommendView.this.fbr.bga() == 2) {
                    RecommendView.this.fbr.d(recyclerView, i, i2, 0, 0);
                }
            }
        };
        this.fbx = new c.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
            @Override // com.baidu.tieba.enterForum.home.c.a
            public void bgg() {
                if (RecommendView.this.fbr != null) {
                    if (RecommendView.this.a(RecommendView.this.Op)) {
                        RecommendView.this.fbr.aJx();
                    } else {
                        RecommendView.this.fbr.aJw();
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.eYk = UtilHelper.getStatusBarHeight() + l.g(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.fbu = l.g(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.fbw);
        tbPageContext.registerListener(this.fbv);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.dqy = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new i(this.mPageContext);
        this.dqy.setProgressView(this.mPullView);
        this.dqy.setClipChildren(false);
        this.Op = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Op.setLayoutManager(new LinearLayoutManager(context));
        this.Op.setFadingEdgeLength(0);
        this.Op.setOverScrollMode(2);
        this.Op.setClipChildren(false);
        this.Op.addOnScrollListener(this.mOnScrollListener);
        this.fbp = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Op);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dqy.getLayoutParams();
        marginLayoutParams.topMargin = this.eYk - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.dqy.setLayoutParams(marginLayoutParams);
        this.fbo = new RecommendForumHeaderView(this.mPageContext);
        this.fbo.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.fbu));
        this.fbs = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fbp != null) {
            this.fbp.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.fbo != null) {
            this.fbo.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.eZQ = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.fbq = aVar;
            if (v.aa(aVar.bgy()) && v.aa(aVar.bgx())) {
                showNoDataView();
                return;
            }
            aVR();
            List<f> db = aVar.db(this.fbt);
            this.fbt = 0L;
            f fVar = (f) v.c(db, 1);
            if (fVar == null) {
                fVar = (f) v.c(db, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            bJ(db);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void dd(long j) {
        a(this.fbq, j);
    }

    private void bJ(List<f> list) {
        this.Op.removeHeaderView(this.fbs);
        this.Op.removeHeaderView(this.fbo);
        if (this.Op.getHeaderViewsCount() == 0) {
        }
        this.Op.addHeaderView(this.fbo);
        this.fbo.setData(list);
        this.fbr.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.fbp.setData(aVar.dc(j));
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void aJD() {
        this.dqy.setRefreshing(false);
    }

    public void aVR() {
        if (this.Op != null) {
            this.Op.setVisibility(0);
        }
    }

    public void cY(boolean z) {
        if (!bgL()) {
            if (this.djN == null) {
                this.djN = new g(getContext());
                this.djN.onChangeSkinType();
            }
            this.djN.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.djN != null) {
            this.djN.dettachView(this);
            this.djN = null;
        }
    }

    public boolean bgL() {
        if (this.djN != null) {
            return this.djN.isViewAttached();
        }
        return false;
    }

    public void ju(boolean z) {
        if (!bgM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ() && RecommendView.this.eZQ != null) {
                            RecommendView.this.eZQ.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.kJ(R.drawable.new_pic_emotion_09);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.atK();
            this.Op.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jQ() && RecommendView.this.eZQ != null) {
                        RecommendView.this.eZQ.loadData();
                    }
                }
            });
        }
        this.mRefreshView.kJ(R.drawable.new_pic_emotion_05);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.no_data_text));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.atK();
        this.Op.setVisibility(8);
    }

    public void aJj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bgM() {
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
                this.mPullView.iV(skinType);
            }
            if (this.djN != null) {
                this.djN.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fbp != null) {
                this.fbp.notifyDataSetChanged();
            }
            if (this.fbo != null) {
                this.fbo.onChangeSkinType();
            }
            am.l(this.dqy, R.color.cp_bg_line_e);
            am.l(this.Op, R.color.cp_bg_line_c);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.fbr = cVar;
        if (this.fbr != null) {
            this.fbr.b(this.fbx);
            this.fbr.a(this.fbx);
        }
    }

    public void onDestroy() {
        if (this.Op != null) {
            this.Op.removeOnScrollListener(this.mOnScrollListener);
        }
        if (this.fbr != null) {
            this.fbr.b(this.fbx);
        }
        aJD();
        hideLoadingView();
        aJj();
        if (this.fbo != null) {
            this.fbo.bgK();
        }
    }
}
