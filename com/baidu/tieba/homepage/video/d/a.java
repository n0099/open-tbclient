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
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView Bn;
    private PbListView egU;
    private View eiw;
    private g eoy;
    private com.baidu.tieba.homepage.personalize.bigday.a gRq;
    private BigdaySwipeRefreshLayout gRz;
    private NEGFeedBackView.a gVz;
    private m glq;
    private e hdL;
    private com.baidu.tieba.homepage.video.a.a hdM;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int gkE = 0;
    private int efC = 0;
    private boolean mIsBackground = false;
    private boolean gWa = true;
    private boolean glj = false;
    private g.d gWb = new g.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            a.this.bLD();
        }
    };
    private g.b gWc = new g.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.mq(true);
            if (a.this.glq != null && !a.this.mIsBackground && a.this.gWa) {
                a.this.glq.a(a.this.gkE, a.this.efC, a.this.glj, true);
            }
        }
    };
    private CustomMessageListener cHV = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hdM.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.gWa) {
                        a.this.glq.a(a.this.gkE, a.this.efC, a.this.glj, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener gkw = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bLE;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bLE = a.this.bLE()) != null && bLE.mT() != null) {
                    bLE.mT().b(new a.C0050a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.glq != null) {
                    a.this.glq.cg(view);
                }
                if (view.getTag() instanceof d) {
                    ((d) view.getTag()).btc().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int eiC = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.glq != null && a.this.gWa) {
                a.this.glq.a(a.this.gkE, a.this.efC, a.this.glj, 1);
            }
            if (this.eiC != i) {
                this.eiC = i;
                if (this.eiC == 1) {
                    a.this.hJ(true);
                } else {
                    a.this.bae();
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
            a.this.gkE = i;
            a.this.efC = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public af bLE() {
        if (this.glq == null || this.glq.cwe() == null || !(this.glq.cwe().getTag() instanceof af)) {
            return null;
        }
        return (af) this.glq.cwe().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gVz = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Bn = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Bn.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.glq = new m(this.mPageContext, this.Bn);
        this.glq.Ac(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.glq.setUniqueId(this.mBdUniqueId);
        this.gRz = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.gRq = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gRz.setProgressView(this.gRq);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gRz.setCustomDistances(i, i, i * 2);
        this.egU = new PbListView(this.mPageContext.getPageActivity());
        this.egU.createView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.egU.setLineGone();
        this.egU.setTextSize(R.dimen.tbfontsize36);
        this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.egU.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hdM = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Bn);
        this.hdM.b(this.gVz);
        this.hdM.setPageUniqueId(this.mBdUniqueId);
        this.hdL = new e();
        this.hdL.h(this.mBdUniqueId);
        this.hdM.b(this.hdL);
        this.eiw = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aFd();
    }

    public void init() {
        this.Bn.addOnScrollListener(this.mScrollListener);
        this.Bn.setRecyclerListener(this.mRecyclerListener);
        this.gRq.a(this.gWb);
        this.gRq.a(this.gWc);
        this.gRq.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cHV.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cHV);
        this.gkw.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gkw);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.eoy == null) {
                this.eoy = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.eoy.onChangeSkinType();
            }
            this.eoy.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.eoy == null) {
            return false;
        }
        return this.eoy.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this.mRootView);
        }
    }

    public void aZG() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.Bn.setNextPage(this.egU);
            }
            this.egU.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.egU.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.egU.setOnClickListener(null);
            this.egU.endLoadData();
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.Bn.setNextPage(this.egU);
            }
            this.egU.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.egU.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.egU.setOnClickListener(onClickListener);
            this.egU.endLoadData();
        }
    }

    public void aZH() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.Bn.setNextPage(this.egU);
            }
            this.egU.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.egU.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.egU.setOnClickListener(null);
            this.egU.startLoadData();
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mn(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mp(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mn(R.drawable.new_pic_emotion_03);
        this.mRefreshView.vc(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void aZK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.gRz.setRefreshing(true);
    }

    public void b(g.e eVar) {
        this.gRz.c(eVar);
    }

    public void bMW() {
        lf(false);
    }

    public void onPause() {
        if (this.hdM != null) {
            this.hdM.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void bKv() {
        lf(true);
    }

    private void lf(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.glq != null) {
            this.glq.on(!z);
            af bLE = bLE();
            if (bLE != null && bLE.mT() != null) {
                z2 = bLE.mT().b(new a.C0050a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.glq.bLD();
                } else if (this.gWa) {
                    this.glq.a(this.gkE, this.efC, this.glj, true);
                }
            }
        }
    }

    public void mq(boolean z) {
        this.gWa = z;
    }

    public void bLC() {
        if (this.glq != null && this.gWa) {
            this.glq.a(this.gkE, this.efC, this.glj, true);
        }
    }

    public void bLD() {
        if (this.glq != null) {
            this.glq.bLD();
        }
    }

    public void aw(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hdM != null) {
            this.hdM.setData(list);
        }
        bLC();
    }

    public void BI(String str) {
        List<Integer> b = b(str, this.Bn);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Bn.l(intValue, intValue2);
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
                    if (cVar.axx() != null && cVar.axx().getTid().equals(str)) {
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
        if (this.hdM != null) {
            return this.hdM.getDataList();
        }
        return null;
    }

    public void bLF() {
        aw(new LinkedList());
    }

    public void bLB() {
        if (this.Bn != null) {
            this.Bn.setSelection(0);
        }
    }

    public void uS() {
        if (this.hdM != null) {
            this.hdM.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gRq != null) {
            this.gRq.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Bn != null) {
            this.Bn.setOnSrollToBottomListener(eVar);
        }
    }

    public void aFd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.eoy != null) {
            this.eoy.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.eoy.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gRq != null) {
            this.gRq.changeSkin(skinType);
        }
        if (this.hdM != null) {
            this.hdM.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.eoy != null) {
            this.eoy.release();
        }
        b((g.e) null);
        if (this.gRq != null) {
            this.gRq.release();
        }
        if (this.hdM != null) {
            this.hdM.onDestroy();
        }
        if (this.glq != null) {
            this.glq.destroy();
        }
        bLG();
        MessageManager.getInstance().unRegisterListener(this.gkw);
        MessageManager.getInstance().unRegisterListener(this.cHV);
    }

    private void bLG() {
        if (this.Bn != null) {
            this.Bn.removeOnScrollListener(this.mScrollListener);
            this.Bn.setRecyclerListener(null);
        }
        if (this.gRq != null) {
            this.gRq.a((g.d) null);
            this.gRq.a((g.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hJ(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        if (a(this.Bn)) {
            hJ(false);
        } else {
            hJ(true);
        }
    }
}
