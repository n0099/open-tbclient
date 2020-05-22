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
    private NoNetworkView.a faq;
    private BdSwipeRefreshLayout fcW;
    private g fkQ;
    private int gQw;
    private List<f> gTN;
    private com.baidu.tieba.enterForum.recommend.a gTt;
    private RecommendForumHeaderView gUR;
    private com.baidu.tieba.enterForum.recommend.a.a gUS;
    private com.baidu.tieba.enterForum.recommend.b.a gUT;
    private com.baidu.tieba.enterForum.home.c gUU;
    private FrameLayout gUV;
    private long gUW;
    private int gUX;
    private CustomMessageListener gUY;
    private CustomMessageListener gUZ;
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
        this.gUY = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.gUU != null) {
                    RecommendView.this.gUU.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.faq = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.gTt != null) {
                    RecommendView.this.gTt.loadData();
                }
            }
        };
        this.gUZ = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.gUT != null && l != null) {
                        RecommendView.this.gUW = l.longValue();
                        if (RecommendView.this.gTt != null) {
                            RecommendView.this.gTt.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int feq = -1;
            int gVb = 0;

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.feq != i && RecommendView.this.gUU != null) {
                    this.feq = i;
                    if (this.feq != 1) {
                        if (RecommendView.this.a(recyclerView)) {
                        }
                        RecommendView.this.gUR.bPJ();
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.gVb += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.gQw = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.gUX = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.gUZ);
        tbPageContext.registerListener(this.gUY);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.fcW = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.fcW.setProgressView(this.mPullView);
        this.fcW.setClipChildren(false);
        this.Vw = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(context));
        this.Vw.setFadingEdgeLength(0);
        this.Vw.setOverScrollMode(2);
        this.Vw.setClipChildren(false);
        this.Vw.addOnScrollListener(this.mOnScrollListener);
        this.gUS = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Vw);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fcW.getLayoutParams();
        marginLayoutParams.topMargin = this.gQw - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.fcW.setLayoutParams(marginLayoutParams);
        this.gUR = new RecommendForumHeaderView(this.mPageContext);
        this.gUR.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.gUX));
        this.gUV = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gUS != null) {
            this.gUS.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.gUR != null) {
            this.gUR.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.gTt = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.gUT = aVar;
            if (v.isEmpty(aVar.bPx()) && v.isEmpty(aVar.mm(true))) {
                showNoDataView();
                return;
            }
            bvM();
            List<f> dZ = aVar.dZ(this.gUW);
            this.gUW = 0L;
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
        a(this.gUT, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void bPH() {
        if (this.Vw != null && !v.isEmpty(this.Vw.getData()) && this.Vw.getData().size() == 1 && (this.Vw.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void bY(List<f> list) {
        this.Vw.removeHeaderView(this.gUV);
        this.Vw.removeHeaderView(this.gUR);
        if (this.Vw.getHeaderViewsCount() == 0) {
        }
        this.Vw.addHeaderView(this.gUR);
        this.gTN = list;
        this.gUR.setData(list);
        this.gUU.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.gUS.setData(aVar.h(j, !v.isEmpty(this.gTN)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bqV() {
        this.fcW.setRefreshing(false);
    }

    public void bvM() {
        if (this.Vw != null) {
            this.Vw.setVisibility(0);
        }
    }

    public void fV(boolean z) {
        if (!bPL()) {
            if (this.fkQ == null) {
                this.fkQ = new g(getContext());
                this.fkQ.bew();
                this.fkQ.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.fkQ.onChangeSkinType();
            }
            this.fkQ.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this);
            this.fkQ = null;
        }
    }

    public boolean bPL() {
        if (this.fkQ != null) {
            return this.fkQ.isViewAttached();
        }
        return false;
    }

    public void mq(boolean z) {
        if (!bPM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.gTt != null) {
                            RecommendView.this.gTt.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.nt(R.drawable.new_pic_emotion_08);
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
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.gTt != null) {
                        RecommendView.this.gTt.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.nt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Vw.setVisibility(8);
    }

    public void bqO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bPM() {
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
            if (this.fkQ != null) {
                this.fkQ.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.gUS != null) {
                this.gUS.notifyDataSetChanged();
            }
            if (this.gUR != null) {
                this.gUR.onChangeSkinType();
            }
            am.setBackgroundColor(this.fcW, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.Vw, R.color.cp_bg_line_e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.gUU = cVar;
        if (this.gUU != null) {
        }
    }

    public void onDestroy() {
        if (this.Vw != null) {
            this.Vw.removeOnScrollListener(this.mOnScrollListener);
        }
        bqV();
        hideLoadingView();
        bqO();
        if (this.gUR != null) {
            this.gUR.bPK();
        }
    }
}
