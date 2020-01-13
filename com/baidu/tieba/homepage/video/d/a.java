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
/* loaded from: classes7.dex */
public class a {
    private BdTypeRecyclerView Bs;
    private PbListView ehe;
    private View ejk;
    private g epL;
    private com.baidu.tieba.homepage.personalize.bigday.a gUK;
    private BigdaySwipeRefreshLayout gUT;
    private NEGFeedBackView.a gYX;
    private m goz;
    private e hho;
    private com.baidu.tieba.homepage.video.a.a hhp;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int gnN = 0;
    private int efM = 0;
    private boolean mIsBackground = false;
    private boolean gZy = true;
    private boolean gos = false;
    private g.d gZz = new g.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            a.this.bML();
        }
    };
    private g.b gZA = new g.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.mB(true);
            if (a.this.goz != null && !a.this.mIsBackground && a.this.gZy) {
                a.this.goz.a(a.this.gnN, a.this.efM, a.this.gos, true);
            }
        }
    };
    private CustomMessageListener cIh = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hhp.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.gZy) {
                        a.this.goz.a(a.this.gnN, a.this.efM, a.this.gos, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener gnF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bMM;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bMM = a.this.bMM()) != null && bMM.mU() != null) {
                    bMM.mU().b(new a.C0050a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.goz != null) {
                    a.this.goz.cl(view);
                }
                if (view.getTag() instanceof d) {
                    ((d) view.getTag()).bue().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int ejq = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.goz != null && a.this.gZy) {
                a.this.goz.a(a.this.gnN, a.this.efM, a.this.gos, 1);
            }
            if (this.ejq != i) {
                this.ejq = i;
                if (this.ejq == 1) {
                    a.this.mR(true);
                } else {
                    a.this.bOf();
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
            bS(i3, (i4 - i3) + 1);
        }

        private void bS(int i, int i2) {
            a.this.gnN = i;
            a.this.efM = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public af bMM() {
        if (this.goz == null || this.goz.cxl() == null || !(this.goz.cxl().getTag() instanceof af)) {
            return null;
        }
        return (af) this.goz.cxl().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gYX = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Bs = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Bs.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.goz = new m(this.mPageContext, this.Bs);
        this.goz.Ah(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.goz.setUniqueId(this.mBdUniqueId);
        this.gUT = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.gUK = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gUT.setProgressView(this.gUK);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gUT.setCustomDistances(i, i, i * 2);
        this.ehe = new PbListView(this.mPageContext.getPageActivity());
        this.ehe.createView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.ehe.setLineGone();
        this.ehe.setTextSize(R.dimen.tbfontsize36);
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ehe.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hhp = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Bs);
        this.hhp.b(this.gYX);
        this.hhp.setPageUniqueId(this.mBdUniqueId);
        this.hho = new e();
        this.hho.h(this.mBdUniqueId);
        this.hhp.b(this.hho);
        this.ejk = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aFw();
    }

    public void init() {
        this.Bs.addOnScrollListener(this.mScrollListener);
        this.Bs.setRecyclerListener(this.mRecyclerListener);
        this.gUK.a(this.gZz);
        this.gUK.a(this.gZA);
        this.gUK.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cIh.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cIh);
        this.gnF.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gnF);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.epL == null) {
                this.epL = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.epL.onChangeSkinType();
            }
            this.epL.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.epL == null) {
            return false;
        }
        return this.epL.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this.mRootView);
        }
    }

    public void bab() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.Bs.setNextPage(this.ehe);
            }
            this.ehe.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ehe.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.ehe.setOnClickListener(null);
            this.ehe.endLoadData();
        }
    }

    public void y(View.OnClickListener onClickListener) {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.Bs.setNextPage(this.ehe);
            }
            this.ehe.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ehe.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.ehe.setOnClickListener(onClickListener);
            this.ehe.endLoadData();
        }
    }

    public void bac() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.Bs.setNextPage(this.ehe);
            }
            this.ehe.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ehe.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.ehe.setOnClickListener(null);
            this.ehe.startLoadData();
        }
    }

    public void l(View.OnClickListener onClickListener) {
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
        this.mRefreshView.vh(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void baf() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.gUT.setRefreshing(true);
    }

    public void b(g.e eVar) {
        this.gUT.c(eVar);
    }

    public void bOe() {
        lq(false);
    }

    public void onPause() {
        if (this.hhp != null) {
            this.hhp.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void bLA() {
        lq(true);
    }

    private void lq(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.goz != null) {
            this.goz.oz(!z);
            af bMM = bMM();
            if (bMM != null && bMM.mU() != null) {
                z2 = bMM.mU().b(new a.C0050a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.goz.bML();
                } else if (this.gZy) {
                    this.goz.a(this.gnN, this.efM, this.gos, true);
                }
            }
        }
    }

    public void mB(boolean z) {
        this.gZy = z;
    }

    public void bMK() {
        if (this.goz != null && this.gZy) {
            this.goz.a(this.gnN, this.efM, this.gos, true);
        }
    }

    public void bML() {
        if (this.goz != null) {
            this.goz.bML();
        }
    }

    public void av(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hhp != null) {
            this.hhp.setData(list);
        }
        bMK();
    }

    public void BS(String str) {
        List<Integer> b = b(str, this.Bs);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Bs.l(intValue, intValue2);
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
                    if (cVar.axQ() != null && cVar.axQ().getTid().equals(str)) {
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
        if (this.hhp != null) {
            return this.hhp.getDataList();
        }
        return null;
    }

    public void bMN() {
        av(new LinkedList());
    }

    public void bMJ() {
        if (this.Bs != null) {
            this.Bs.setSelection(0);
        }
    }

    public void vj() {
        if (this.hhp != null) {
            this.hhp.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gUK != null) {
            this.gUK.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Bs != null) {
            this.Bs.setOnSrollToBottomListener(eVar);
        }
    }

    public void aFw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.epL != null) {
            this.epL.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.epL.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gUK != null) {
            this.gUK.changeSkin(skinType);
        }
        if (this.hhp != null) {
            this.hhp.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.epL != null) {
            this.epL.release();
        }
        b((g.e) null);
        if (this.gUK != null) {
            this.gUK.release();
        }
        if (this.hhp != null) {
            this.hhp.onDestroy();
        }
        if (this.goz != null) {
            this.goz.destroy();
        }
        bMO();
        MessageManager.getInstance().unRegisterListener(this.gnF);
        MessageManager.getInstance().unRegisterListener(this.cIh);
    }

    private void bMO() {
        if (this.Bs != null) {
            this.Bs.removeOnScrollListener(this.mScrollListener);
            this.Bs.setRecyclerListener(null);
        }
        if (this.gUK != null) {
            this.gUK.a((g.d) null);
            this.gUK.a((g.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOf() {
        if (a(this.Bs)) {
            mR(false);
        } else {
            mR(true);
        }
    }
}
