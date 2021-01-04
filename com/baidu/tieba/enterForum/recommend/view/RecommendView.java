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
    private BdTypeRecyclerView Yc;
    private BdSwipeRefreshLayout gDf;
    private g gLj;
    private NoNetworkView.a gzW;
    private int iIz;
    private List<f> iLF;
    private com.baidu.tieba.enterForum.recommend.a iLl;
    private RecommendForumHeaderView iMI;
    private com.baidu.tieba.enterForum.recommend.a.a iMJ;
    private com.baidu.tieba.enterForum.recommend.b.a iMK;
    private com.baidu.tieba.enterForum.home.c iML;
    private FrameLayout iMM;
    private long iMN;
    private int iMO;
    private CustomMessageListener iMP;
    private CustomMessageListener iMQ;
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
        this.iMP = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RecommendView.this.iML != null) {
                    RecommendView.this.iML.setSearchHint(TbSingleton.getInstance().getHotSearch());
                }
            }
        };
        this.gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.2
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && RecommendView.this.iLl != null) {
                    RecommendView.this.iLl.loadData();
                }
            }
        };
        this.iMQ = new CustomMessageListener(2921383) { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() instanceof Long) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (RecommendView.this.iMK != null && l != null) {
                        RecommendView.this.iMN = l.longValue();
                        if (RecommendView.this.iLl != null) {
                            RecommendView.this.iLl.loadData();
                        }
                    }
                }
            }
        };
        this.mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.4
            private int gEG = -1;
            int iMS = 0;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (this.gEG != i && RecommendView.this.iML != null) {
                    this.gEG = i;
                    if (this.gEG != 1) {
                        if (RecommendView.this.c(recyclerView)) {
                        }
                        RecommendView.this.iMI.czB();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                this.iMS += i2;
            }
        };
        this.mPageContext = tbPageContext;
        this.iIz = UtilHelper.getStatusBarHeight() + l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds240);
        this.iMO = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds114);
        init(tbPageContext.getPageActivity());
        tbPageContext.registerListener(this.iMQ);
        tbPageContext.registerListener(this.iMP);
        onChangeSkinType();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fragment_enter_recommend_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.gDf = (BdSwipeRefreshLayout) findViewById(R.id.enter_recommend_refresh_layout);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mPageContext);
        this.gDf.setProgressView(this.mPullView);
        this.gDf.setClipChildren(false);
        this.Yc = (BdTypeRecyclerView) findViewById(R.id.enter_recommend_list_view);
        this.Yc.setLayoutManager(new LinearLayoutManager(context));
        this.Yc.setFadingEdgeLength(0);
        this.Yc.setOverScrollMode(2);
        this.Yc.setClipChildren(false);
        this.Yc.addOnScrollListener(this.mOnScrollListener);
        this.iMJ = new com.baidu.tieba.enterForum.recommend.a.a(this.mPageContext, this.Yc);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gDf.getLayoutParams();
        marginLayoutParams.topMargin = this.iIz - getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.gDf.setLayoutParams(marginLayoutParams);
        this.iMI = new RecommendForumHeaderView(this.mPageContext);
        this.iMI.setOnSecectedListener(this);
        FrameLayout frameLayout = new FrameLayout(this.mPageContext.getPageActivity());
        frameLayout.addView(new View(this.mPageContext.getPageActivity()), new FrameLayout.LayoutParams(-1, this.iMO));
        this.iMM = frameLayout;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iMJ != null) {
            this.iMJ.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.iMI != null) {
            this.iMI.setPageId(bdUniqueId);
        }
    }

    public void setPresenter(com.baidu.tieba.enterForum.recommend.a aVar) {
        this.iLl = aVar;
    }

    public void setData(com.baidu.tieba.enterForum.recommend.b.a aVar) {
        if (aVar != null) {
            this.iMK = aVar;
            if (x.isEmpty(aVar.czp()) && x.isEmpty(aVar.pQ(true))) {
                showNoDataView();
                return;
            }
            caY();
            List<f> gf = aVar.gf(this.iMN);
            this.iMN = 0L;
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
        a(this.iMK, j);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.ForumTestView.a
    public void czz() {
        if (this.Yc != null && !x.isEmpty(this.Yc.getData()) && this.Yc.getData().size() == 1 && (this.Yc.getData().get(0) instanceof e)) {
            showNoDataView();
        }
    }

    private void cZ(List<f> list) {
        this.Yc.removeHeaderView(this.iMM);
        this.Yc.removeHeaderView(this.iMI);
        if (this.Yc.getHeaderViewsCount() == 0) {
        }
        this.Yc.addHeaderView(this.iMI);
        this.iLF = list;
        this.iMI.setData(list);
        this.iML.setSearchHint(TbSingleton.getInstance().getHotSearch());
    }

    private void a(com.baidu.tieba.enterForum.recommend.b.a aVar, long j) {
        if (aVar != null) {
            this.iMJ.setData(aVar.k(j, !x.isEmpty(this.iLF)));
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void bUO() {
        this.gDf.setRefreshing(false);
    }

    public void caY() {
        if (this.Yc != null) {
            this.Yc.setVisibility(0);
        }
    }

    public void it(boolean z) {
        if (!cts()) {
            if (this.gLj == null) {
                this.gLj = new g(getContext());
                this.gLj.bGs();
                this.gLj.setTopMargin((getHeight() - l.getDimens(getContext(), R.dimen.tbds304)) / 2);
                this.gLj.onChangeSkinType();
            }
            this.gLj.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
        }
    }

    public boolean cts() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void pU(boolean z) {
        if (!ctt()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && RecommendView.this.iLl != null) {
                            RecommendView.this.iLl.loadData();
                        }
                    }
                });
                this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
            }
            this.mRefreshView.setTitle(this.mPageContext.getString(R.string.refresh_view_title_text));
            this.mRefreshView.sO(R.drawable.new_pic_emotion_08);
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.Yc.setVisibility(8);
        }
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.recommend.view.RecommendView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately() && RecommendView.this.iLl != null) {
                        RecommendView.this.iLl.loadData();
                    }
                }
            });
            this.mRefreshView.setLayoutMargin(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds364));
        }
        this.mRefreshView.sO(R.drawable.new_pic_emotion_08);
        this.mRefreshView.setTitle(this.mPageContext.getString(R.string.recommend_forum_no_data));
        this.mRefreshView.attachView(this, false);
        this.mRefreshView.showRefreshButton();
        this.Yc.setVisibility(8);
    }

    public void Zi() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean ctt() {
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
            if (this.gLj != null) {
                this.gLj.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iMJ != null) {
                this.iMJ.notifyDataSetChanged();
            }
            if (this.iMI != null) {
                this.iMI.onChangeSkinType();
            }
            ao.setBackgroundColor(this.gDf, R.color.CAM_X0205);
            ao.setBackgroundColor(this.Yc, R.color.CAM_X0205);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDestroy();
        super.onDetachedFromWindow();
    }

    public void setTabViewController(com.baidu.tieba.enterForum.home.c cVar) {
        this.iML = cVar;
        if (this.iML != null) {
        }
    }

    public void onDestroy() {
        if (this.Yc != null) {
            this.Yc.removeOnScrollListener(this.mOnScrollListener);
        }
        bUO();
        hideLoadingView();
        Zi();
        if (this.iMI != null) {
            this.iMI.czC();
        }
    }
}
