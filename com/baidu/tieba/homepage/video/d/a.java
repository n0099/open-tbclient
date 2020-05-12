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
import com.baidu.tieba.homepage.personalize.a.f;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.model.e;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Vi;
    private PbListView ePr;
    private View eRC;
    private g eYg;
    private m gHB;
    private com.baidu.tieba.homepage.personalize.bigday.a hId;
    private BigdaySwipeRefreshLayout hIm;
    private NEGFeedBackView.a hMp;
    private e hUS;
    private com.baidu.tieba.homepage.video.a.a hUT;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int hac = 0;
    private int eNZ = 0;
    private boolean mIsBackground = false;
    private boolean hMQ = true;
    private boolean haL = false;
    private g.d hMR = new g.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            a.this.bZe();
        }
    };
    private g.b hMS = new g.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.nN(true);
            if (a.this.gHB != null && !a.this.mIsBackground && a.this.hMQ) {
                a.this.gHB.a(a.this.hac, a.this.eNZ, a.this.haL, true);
            }
        }
    };
    private CustomMessageListener dlH = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hUT.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.hMQ) {
                        a.this.gHB.a(a.this.hac, a.this.eNZ, a.this.haL, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener gZT = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bZf;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bZf = a.this.bZf()) != null && bZf.rD() != null) {
                    bZf.rD().b(new a.C0095a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.gHB != null) {
                    a.this.gHB.ct(view);
                }
                if (view.getTag() instanceof f) {
                    ((f) view.getTag()).bFA().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int eRI = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.gHB != null && a.this.hMQ) {
                a.this.gHB.a(a.this.hac, a.this.eNZ, a.this.haL, 1);
            }
            if (this.eRI != i) {
                this.eRI = i;
                if (this.eRI == 1) {
                    a.this.od(true);
                } else {
                    a.this.caB();
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
            ca(i3, (i4 - i3) + 1);
        }

        private void ca(int i, int i2) {
            a.this.hac = i;
            a.this.eNZ = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public af bZf() {
        if (this.gHB == null || this.gHB.cJF() == null || !(this.gHB.cJF().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gHB.cJF().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hMp = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Vi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Vi.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gHB = new m(this.mPageContext, this.Vi);
        this.gHB.AY(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gHB.setUniqueId(this.mBdUniqueId);
        this.hIm = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.hId = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.hIm.setProgressView(this.hId);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.hIm.setCustomDistances(i, i, i * 2);
        this.ePr = new PbListView(this.mPageContext.getPageActivity());
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize36);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hUT = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Vi);
        this.hUT.b(this.hMp);
        this.hUT.setPageUniqueId(this.mBdUniqueId);
        this.hUS = new e();
        this.hUS.h(this.mBdUniqueId);
        this.hUT.b(this.hUS);
        this.eRC = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aQm();
    }

    public void init() {
        this.Vi.addOnScrollListener(this.mScrollListener);
        this.Vi.setRecyclerListener(this.mRecyclerListener);
        this.hId.a(this.hMR);
        this.hId.a(this.hMS);
        this.hId.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dlH.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dlH);
        this.gZT.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gZT);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.eYg == null) {
                this.eYg = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.eYg.onChangeSkinType();
            }
            this.eYg.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.eYg == null) {
            return false;
        }
        return this.eYg.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this.mRootView);
        }
    }

    public void bln() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.Vi.setNextPage(this.ePr);
            }
            this.ePr.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.ePr.setOnClickListener(null);
            this.ePr.endLoadData();
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.Vi.setNextPage(this.ePr);
            }
            this.ePr.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.ePr.setOnClickListener(onClickListener);
            this.ePr.endLoadData();
        }
    }

    public void blo() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.Vi.setNextPage(this.ePr);
            }
            this.ePr.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePr.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.ePr.setOnClickListener(null);
            this.ePr.startLoadData();
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mR(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mT(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mR(R.drawable.new_pic_emotion_03);
        this.mRefreshView.wR(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void blr() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.hIm.setRefreshing(true);
    }

    public void b(g.e eVar) {
        this.hIm.c(eVar);
    }

    public void caA() {
        mC(false);
    }

    public void onPause() {
        if (this.hUT != null) {
            this.hUT.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void bXU() {
        mC(true);
    }

    private void mC(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gHB != null) {
            this.gHB.pL(!z);
            af bZf = bZf();
            if (bZf != null && bZf.rD() != null) {
                z2 = bZf.rD().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gHB.bZe();
                } else if (this.hMQ) {
                    this.gHB.a(this.hac, this.eNZ, this.haL, true);
                }
            }
        }
    }

    public void nN(boolean z) {
        this.hMQ = z;
    }

    public void bZd() {
        if (this.gHB != null && this.hMQ) {
            this.gHB.a(this.hac, this.eNZ, this.haL, true);
        }
    }

    public void bZe() {
        if (this.gHB != null) {
            this.gHB.bZe();
        }
    }

    public void aE(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hUT != null) {
            this.hUT.setData(list);
        }
        bZd();
    }

    public void DU(String str) {
        List<Integer> b = b(str, this.Vi);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Vi.l(intValue, intValue2);
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
                    if (cVar.aIu() != null && cVar.aIu().getTid().equals(str)) {
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
        if (this.hUT != null) {
            return this.hUT.getDataList();
        }
        return null;
    }

    public void bZg() {
        aE(new LinkedList());
    }

    public void bZc() {
        if (this.Vi != null) {
            this.Vi.setSelection(0);
        }
    }

    public void BC() {
        if (this.hUT != null) {
            this.hUT.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.hId != null) {
            this.hId.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Vi != null) {
            this.Vi.setOnSrollToBottomListener(eVar);
        }
    }

    public void aQm() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.eYg != null) {
            this.eYg.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.eYg.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.hId != null) {
            this.hId.changeSkin(skinType);
        }
        if (this.hUT != null) {
            this.hUT.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.eYg != null) {
            this.eYg.release();
        }
        b((g.e) null);
        if (this.hId != null) {
            this.hId.release();
        }
        if (this.hUT != null) {
            this.hUT.onDestroy();
        }
        if (this.gHB != null) {
            this.gHB.destroy();
        }
        bZh();
        MessageManager.getInstance().unRegisterListener(this.gZT);
        MessageManager.getInstance().unRegisterListener(this.dlH);
    }

    private void bZh() {
        if (this.Vi != null) {
            this.Vi.removeOnScrollListener(this.mScrollListener);
            this.Vi.setRecyclerListener(null);
        }
        if (this.hId != null) {
            this.hId.a((g.d) null);
            this.hId.a((g.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void od(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caB() {
        if (a(this.Vi)) {
            od(false);
        } else {
            od(true);
        }
    }
}
