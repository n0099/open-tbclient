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
    private BdTypeRecyclerView Xe;
    private NoNetworkView.a gbR;
    private BdSwipeRefreshLayout gez;
    private g gmB;
    private int ieF;
    private List<f> ihL;
    private com.baidu.tieba.enterForum.recommend.a ihr;
    private RecommendForumHeaderView iiP;
    private com.baidu.tieba.enterForum.recommend.a.a iiQ;
    private com.baidu.tieba.enterForum.recommend.b.a iiR;
    private com.baidu.tieba.enterForum.home.c iiS;
    private FrameLayout iiT;
    private long iiU;
    private int iiV;
    private CustomMessageListener iiW;
    private CustomMessageListener iiX;
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
        this.iiW = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.iiS != null) {
                    RecommendView.this.iiS.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.gbR = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.ihr != null) {
                    RecommendView.this.ihr.loadData();
                }
            }
        };
        this.iiX = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.iiR != null && l != null) {
                        RecommendView.this.iiU = l.longValue();
                        if (RecommendView.this.ihr != null) {
                            RecommendView.this.ihr.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int gga = -1;
            int iiZ = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.gga != i && RecommendView.this.iiS != null) {
                    this.gga = i;
                    if (this.gga != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.iiP.cqo();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.iiZ += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.ieF = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.iiV = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.iiX);
        tbPageContext.registerListener(this.iiW);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.gez = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gez.setProgressView(this.mPullView);
        this.gez.setClipChildren(false);
        this.Xe = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(context));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.Xe.setClipChildren(false);
        this.Xe.addOnScrollListener(this.mOnScrollListener);
        this.iiQ = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Xe);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gez.getLayoutParams();
        marginLayoutParams.topMargin = this.ieF - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.gez.setLayoutParams(marginLayoutParams);
        this.iiP = new RecommendForumHeaderView(this.mPageContext);
        this.iiP.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.iiV));
        this.iiT = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iiQ != null) {
            this.iiQ.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.iiP != null) {
            this.iiP.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.ihr = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.iiR = aVar;
            if (y.isEmpty(aVar.cqc()) && y.isEmpty(aVar.oL(true))) {
                showNoDataView();
                return;
            }
            bSR();
            List<f> fc = aVar.fc(this.iiU);
            this.iiU = 0L;
            f fVar = (f) y.getItem(fc, 1);
            if (fVar == null) {
                fVar = (f) y.getItem(fc, 0);
            }
            long j = fVar != null ? fVar.testId : 0L;
            cG(fc);
            a(aVar, j);
        }
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void fd(long j) {
        a(this.iiR, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void cqm() {
        if (this.Xe != null && !y.isEmpty(this.Xe.getData()) && this.Xe.getData().size() == 1 && (this.Xe.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cG(List<f> list) {
        this.Xe.removeHeaderView(this.iiT);
        this.Xe.removeHeaderView(this.iiP);
        if (this.Xe.getHeaderViewsCount() == 0) {
        }
        this.Xe.addHeaderView(this.iiP);
        this.ihL = list;
        this.iiP.setData(list);
        this.iiS.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.iiQ.setData(aVar.j(j, !y.isEmpty(this.ihL)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bMH() {
        this.gez.setRefreshing(false);
    }

    public void bSR() {
        if (this.Xe != null) {
            this.Xe.setVisibility(0);
        }
    }

    public void hA(boolean z) {
        if (!ckh()) {
            if (this.gmB == null) {
                this.gmB = new g(getContext());
                this.gmB.byH();
                this.gmB.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.gmB.onChangeSkinType();
            }
            this.gmB.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this);
            this.gmB = null;
        }
    }

    public boolean ckh() {
        if (this.gmB != null) {
            return this.gmB.isViewAttached();
        }
        return false;
    }

    public void oP(boolean z) {
        if (!cki()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.ihr != null) {
                            RecommendView.this.ihr.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.rt(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Xe.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.ihr != null) {
                        RecommendView.this.ihr.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.rt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Xe.setVisibility(8);
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cki() {
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
            if (this.gmB != null) {
                this.gmB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iiQ != null) {
                this.iiQ.notifyDataSetChanged();
            }
            if (this.iiP != null) {
                this.iiP.onChangeSkinType();
            }
            ap.setBackgroundColor(this.gez, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.iiS = cVar;
        if (this.iiS != null) {
        }
    }

    public void onDestroy() {
        if (this.Xe != null) {
            this.Xe.removeOnScrollListener(this.mOnScrollListener);
        }
        bMH();
        hideLoadingView();
        TK();
        if (this.iiP != null) {
            this.iiP.cqp();
        }
    }
}
