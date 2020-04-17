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
    private BdTypeRecyclerView Vf;
    private PbListView ePm;
    private View eRx;
    private g eYb;
    private m gHv;
    private com.baidu.tieba.homepage.personalize.bigday.a hHX;
    private BigdaySwipeRefreshLayout hIg;
    private NEGFeedBackView.a hMj;
    private e hUM;
    private com.baidu.tieba.homepage.video.a.a hUN;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int gZW = 0;
    private int eNU = 0;
    private boolean mIsBackground = false;
    private boolean hMK = true;
    private boolean haF = false;
    private g.d hML = new g.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            a.this.bZf();
        }
    };
    private g.b hMM = new g.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.nN(true);
            if (a.this.gHv != null && !a.this.mIsBackground && a.this.hMK) {
                a.this.gHv.a(a.this.gZW, a.this.eNU, a.this.haF, true);
            }
        }
    };
    private CustomMessageListener dlD = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hUN.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.hMK) {
                        a.this.gHv.a(a.this.gZW, a.this.eNU, a.this.haF, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener gZN = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bZg;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bZg = a.this.bZg()) != null && bZg.rD() != null) {
                    bZg.rD().b(new a.C0074a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.gHv != null) {
                    a.this.gHv.ct(view);
                }
                if (view.getTag() instanceof f) {
                    ((f) view.getTag()).bFB().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int eRD = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.gHv != null && a.this.hMK) {
                a.this.gHv.a(a.this.gZW, a.this.eNU, a.this.haF, 1);
            }
            if (this.eRD != i) {
                this.eRD = i;
                if (this.eRD == 1) {
                    a.this.od(true);
                } else {
                    a.this.caC();
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
            a.this.gZW = i;
            a.this.eNU = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public af bZg() {
        if (this.gHv == null || this.gHv.cJH() == null || !(this.gHv.cJH().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gHv.cJH().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hMj = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Vf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Vf.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gHv = new m(this.mPageContext, this.Vf);
        this.gHv.AY(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gHv.setUniqueId(this.mBdUniqueId);
        this.hIg = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.hHX = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.hIg.setProgressView(this.hHX);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.hIg.setCustomDistances(i, i, i * 2);
        this.ePm = new PbListView(this.mPageContext.getPageActivity());
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize36);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hUN = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Vf);
        this.hUN.b(this.hMj);
        this.hUN.setPageUniqueId(this.mBdUniqueId);
        this.hUM = new e();
        this.hUM.h(this.mBdUniqueId);
        this.hUN.b(this.hUM);
        this.eRx = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aQp();
    }

    public void init() {
        this.Vf.addOnScrollListener(this.mScrollListener);
        this.Vf.setRecyclerListener(this.mRecyclerListener);
        this.hHX.a(this.hML);
        this.hHX.a(this.hMM);
        this.hHX.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dlD.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dlD);
        this.gZN.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gZN);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.eYb == null) {
                this.eYb = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.eYb.onChangeSkinType();
            }
            this.eYb.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.eYb == null) {
            return false;
        }
        return this.eYb.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this.mRootView);
        }
    }

    public void blp() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.Vf.setNextPage(this.ePm);
            }
            this.ePm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePm.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.ePm.setOnClickListener(null);
            this.ePm.endLoadData();
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.Vf.setNextPage(this.ePm);
            }
            this.ePm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePm.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.ePm.setOnClickListener(onClickListener);
            this.ePm.endLoadData();
        }
    }

    public void blq() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.Vf.setNextPage(this.ePm);
            }
            this.ePm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePm.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.ePm.setOnClickListener(null);
            this.ePm.startLoadData();
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
        this.mRefreshView.wO(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void blt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.hIg.setRefreshing(true);
    }

    public void b(g.e eVar) {
        this.hIg.c(eVar);
    }

    public void caB() {
        mC(false);
    }

    public void onPause() {
        if (this.hUN != null) {
            this.hUN.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void bXV() {
        mC(true);
    }

    private void mC(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gHv != null) {
            this.gHv.pL(!z);
            af bZg = bZg();
            if (bZg != null && bZg.rD() != null) {
                z2 = bZg.rD().b(new a.C0074a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gHv.bZf();
                } else if (this.hMK) {
                    this.gHv.a(this.gZW, this.eNU, this.haF, true);
                }
            }
        }
    }

    public void nN(boolean z) {
        this.hMK = z;
    }

    public void bZe() {
        if (this.gHv != null && this.hMK) {
            this.gHv.a(this.gZW, this.eNU, this.haF, true);
        }
    }

    public void bZf() {
        if (this.gHv != null) {
            this.gHv.bZf();
        }
    }

    public void aE(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hUN != null) {
            this.hUN.setData(list);
        }
        bZe();
    }

    public void DR(String str) {
        List<Integer> b = b(str, this.Vf);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Vf.l(intValue, intValue2);
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
                    if (cVar.aIw() != null && cVar.aIw().getTid().equals(str)) {
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
        if (this.hUN != null) {
            return this.hUN.getDataList();
        }
        return null;
    }

    public void bZh() {
        aE(new LinkedList());
    }

    public void bZd() {
        if (this.Vf != null) {
            this.Vf.setSelection(0);
        }
    }

    public void BD() {
        if (this.hUN != null) {
            this.hUN.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.hHX != null) {
            this.hHX.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Vf != null) {
            this.Vf.setOnSrollToBottomListener(eVar);
        }
    }

    public void aQp() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.eYb != null) {
            this.eYb.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.eYb.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.hHX != null) {
            this.hHX.changeSkin(skinType);
        }
        if (this.hUN != null) {
            this.hUN.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.eYb != null) {
            this.eYb.release();
        }
        b((g.e) null);
        if (this.hHX != null) {
            this.hHX.release();
        }
        if (this.hUN != null) {
            this.hUN.onDestroy();
        }
        if (this.gHv != null) {
            this.gHv.destroy();
        }
        bZi();
        MessageManager.getInstance().unRegisterListener(this.gZN);
        MessageManager.getInstance().unRegisterListener(this.dlD);
    }

    private void bZi() {
        if (this.Vf != null) {
            this.Vf.removeOnScrollListener(this.mScrollListener);
            this.Vf.setRecyclerListener(null);
        }
        if (this.hHX != null) {
            this.hHX.a((g.d) null);
            this.hHX.a((g.b) null);
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
    public void caC() {
        if (a(this.Vf)) {
            od(false);
        } else {
            od(true);
        }
    }
}
