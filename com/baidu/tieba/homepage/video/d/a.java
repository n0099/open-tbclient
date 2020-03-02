package com.baidu.tieba.homepage.video.d;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.homepage.personalize.a.d;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.model.e;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView BK;
    private PbListView elj;
    private View enu;
    private g etX;
    private com.baidu.tieba.homepage.personalize.bigday.a gWN;
    private BigdaySwipeRefreshLayout gWW;
    private m gqC;
    private NEGFeedBackView.a haZ;
    private e hjr;
    private com.baidu.tieba.homepage.video.a.a hjs;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int gpQ = 0;
    private int ejR = 0;
    private boolean mIsBackground = false;
    private boolean hbA = true;
    private boolean gqv = false;
    private g.d hbB = new g.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            a.this.bOp();
        }
    };
    private g.b hbC = new g.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.mD(true);
            if (a.this.gqC != null && !a.this.mIsBackground && a.this.hbA) {
                a.this.gqC.a(a.this.gpQ, a.this.ejR, a.this.gqv, true);
            }
        }
    };
    private CustomMessageListener cMl = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hjs.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.hbA) {
                        a.this.gqC.a(a.this.gpQ, a.this.ejR, a.this.gqv, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener gpI = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bOq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bOq = a.this.bOq()) != null && bOq.nk() != null) {
                    bOq.nk().b(new a.C0052a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.gqC != null) {
                    a.this.gqC.cl(view);
                }
                if (view.getTag() instanceof d) {
                    ((d) view.getTag()).bvK().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int enB = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.gqC != null && a.this.hbA) {
                a.this.gqC.a(a.this.gpQ, a.this.ejR, a.this.gqv, 1);
            }
            if (this.enB != i) {
                this.enB = i;
                if (this.enB == 1) {
                    a.this.mT(true);
                } else {
                    a.this.bPJ();
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4 = 0;
            if (recyclerView instanceof BdRecyclerView) {
                i3 = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i4 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            } else {
                i3 = 0;
            }
            bT(i3, (i4 - i3) + 1);
        }

        private void bT(int i, int i2) {
            a.this.gpQ = i;
            a.this.ejR = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public af bOq() {
        if (this.gqC == null || this.gqC.cyI() == null || !(this.gqC.cyI().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gqC.cyI().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.haZ = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gqC = new m(this.mPageContext, this.BK);
        this.gqC.Aq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gqC.setUniqueId(this.mBdUniqueId);
        this.gWW = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.gWN = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gWW.setProgressView(this.gWN);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gWW.setCustomDistances(i, i, i * 2);
        this.elj = new PbListView(this.mPageContext.getPageActivity());
        this.elj.createView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.elj.setLineGone();
        this.elj.setTextSize(R.dimen.tbfontsize36);
        this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elj.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hjs = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.BK);
        this.hjs.b(this.haZ);
        this.hjs.setPageUniqueId(this.mBdUniqueId);
        this.hjr = new e();
        this.hjr.h(this.mBdUniqueId);
        this.hjs.b(this.hjr);
        this.enu = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aHN();
    }

    public void init() {
        this.BK.addOnScrollListener(this.mScrollListener);
        this.BK.setRecyclerListener(this.mRecyclerListener);
        this.gWN.a(this.hbB);
        this.gWN.a(this.hbC);
        this.gWN.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cMl.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cMl);
        this.gpI.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gpI);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.etX == null) {
                this.etX = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.etX.onChangeSkinType();
            }
            this.etX.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.etX == null) {
            return false;
        }
        return this.etX.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this.mRootView);
        }
    }

    public void bct() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.BK.setNextPage(this.elj);
            }
            this.elj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elj.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.elj.setOnClickListener(null);
            this.elj.endLoadData();
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.BK.setNextPage(this.elj);
            }
            this.elj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elj.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.elj.setOnClickListener(onClickListener);
            this.elj.endLoadData();
        }
    }

    public void bcu() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.BK.setNextPage(this.elj);
            }
            this.elj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elj.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.elj.setOnClickListener(null);
            this.elj.startLoadData();
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mE(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mG(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mE(R.drawable.new_pic_emotion_03);
        this.mRefreshView.vy(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bcx() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.gWW.setRefreshing(true);
    }

    public void b(g.e eVar) {
        this.gWW.c(eVar);
    }

    public void bPI() {
        lt(false);
    }

    public void onPause() {
        if (this.hjs != null) {
            this.hjs.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void bNf() {
        lt(true);
    }

    private void lt(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gqC != null) {
            this.gqC.oB(!z);
            af bOq = bOq();
            if (bOq != null && bOq.nk() != null) {
                z2 = bOq.nk().b(new a.C0052a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gqC.bOp();
                } else if (this.hbA) {
                    this.gqC.a(this.gpQ, this.ejR, this.gqv, true);
                }
            }
        }
    }

    public void mD(boolean z) {
        this.hbA = z;
    }

    public void bOo() {
        if (this.gqC != null && this.hbA) {
            this.gqC.a(this.gpQ, this.ejR, this.gqv, true);
        }
    }

    public void bOp() {
        if (this.gqC != null) {
            this.gqC.bOp();
        }
    }

    public void av(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hjs != null) {
            this.hjs.setData(list);
        }
        bOo();
    }

    public void Ci(String str) {
        List<Integer> b = b(str, this.BK);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.BK.m(intValue, intValue2);
        }
    }

    private List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        ArrayList arrayList = new ArrayList(2);
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i4 < bdTypeRecyclerView.getCount()) {
                com.baidu.adp.widget.ListView.m item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c) {
                    c cVar = (c) item;
                    if (cVar.aAg() != null && cVar.aAg().getTid().equals(str)) {
                        if (!z) {
                            i3 = i4;
                        }
                        z = true;
                        i2 = i4;
                    }
                }
                i = i4 + 1;
            } else {
                arrayList.add(Integer.valueOf(i3));
                arrayList.add(Integer.valueOf(i2));
                return arrayList;
            }
        }
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.hjs != null) {
            return this.hjs.getDataList();
        }
        return null;
    }

    public void bOr() {
        av(new LinkedList());
    }

    public void bOn() {
        if (this.BK != null) {
            this.BK.setSelection(0);
        }
    }

    public void wN() {
        if (this.hjs != null) {
            this.hjs.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gWN != null) {
            this.gWN.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.BK != null) {
            this.BK.setOnSrollToBottomListener(eVar);
        }
    }

    public void aHN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.etX != null) {
            this.etX.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.etX.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gWN != null) {
            this.gWN.changeSkin(skinType);
        }
        if (this.hjs != null) {
            this.hjs.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.etX != null) {
            this.etX.release();
        }
        b((g.e) null);
        if (this.gWN != null) {
            this.gWN.release();
        }
        if (this.hjs != null) {
            this.hjs.onDestroy();
        }
        if (this.gqC != null) {
            this.gqC.destroy();
        }
        bOs();
        MessageManager.getInstance().unRegisterListener(this.gpI);
        MessageManager.getInstance().unRegisterListener(this.cMl);
    }

    private void bOs() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mScrollListener);
            this.BK.setRecyclerListener(null);
        }
        if (this.gWN != null) {
            this.gWN.a((g.d) null);
            this.gWN.a((g.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mT(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPJ() {
        if (a(this.BK)) {
            mT(false);
        } else {
            mT(true);
        }
    }
}
