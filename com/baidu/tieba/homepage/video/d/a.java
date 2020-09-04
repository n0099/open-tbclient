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
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.model.e;
import com.baidu.tieba.play.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView Wu;
    private PbListView fEa;
    private View fGn;
    private g fMR;
    private i hBR;
    private BigdaySwipeRefreshLayout iGH;
    private com.baidu.tieba.homepage.personalize.bigday.a iGy;
    private NEGFeedBackView.a iKB;
    private e iWC;
    private com.baidu.tieba.homepage.video.a.a iWD;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int hVc = 0;
    private int fCJ = 0;
    private boolean mIsBackground = false;
    private boolean iLc = true;
    private boolean hVM = false;
    private f.d iLd = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cxq();
        }
    };
    private f.b iLe = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.pG(true);
            if (a.this.hBR != null && !a.this.mIsBackground && a.this.iLc) {
                a.this.hBR.a(a.this.hVc, a.this.fCJ, a.this.hVM, true);
            }
        }
    };
    private CustomMessageListener dVy = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iWD.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.iLc) {
                        a.this.hBR.a(a.this.hVc, a.this.fCJ, a.this.hVM, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            al cxr;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cxr = a.this.cxr()) != null && cxr.tR() != null) {
                    cxr.tR().b(new a.C0095a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.hBR != null) {
                    a.this.hBR.cE(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).ccF().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int fGt = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.hBR != null && a.this.iLc) {
                a.this.hBR.a(a.this.hVc, a.this.fCJ, a.this.hVM, 1);
            }
            if (this.fGt != i) {
                this.fGt = i;
                if (this.fGt == 1) {
                    a.this.pW(true);
                } else {
                    a.this.czq();
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
            cw(i3, (i4 - i3) + 1);
        }

        private void cw(int i, int i2) {
            a.this.hVc = i;
            a.this.fCJ = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public al cxr() {
        if (this.hBR == null || this.hBR.djW() == null || !(this.hBR.djW().getTag() instanceof al)) {
            return null;
        }
        return (al) this.hBR.djW().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iKB = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.hBR = new i(this.mPageContext, this.Wu);
        this.hBR.FG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hBR.setUniqueId(this.mBdUniqueId);
        this.iGH = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.iGy = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.iGH.setProgressView(this.iGy);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.iGH.setCustomDistances(i, i, i * 2);
        this.fEa = new PbListView(this.mPageContext.getPageActivity());
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize36);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iWD = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Wu);
        this.iWD.b(this.iKB);
        this.iWD.setPageUniqueId(this.mBdUniqueId);
        this.iWC = new e();
        this.iWC.i(this.mBdUniqueId);
        this.iWD.b(this.iWC);
        this.fGn = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bkF();
    }

    public void init() {
        this.Wu.addOnScrollListener(this.mScrollListener);
        this.Wu.setRecyclerListener(this.mRecyclerListener);
        this.iGy.a(this.iLd);
        this.iGy.a(this.iLe);
        this.iGy.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dVy.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dVy);
        this.hUJ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hUJ);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fMR == null) {
                this.fMR = new g(this.mPageContext.getPageActivity());
                this.fMR.onChangeSkinType();
            }
            this.fMR.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fMR == null) {
            return false;
        }
        return this.fMR.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this.mRootView);
        }
    }

    public void bFS() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.Wu.setNextPage(this.fEa);
            }
            this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fEa.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.fEa.setOnClickListener(null);
            this.fEa.endLoadData();
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.Wu.setNextPage(this.fEa);
            }
            this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fEa.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.fEa.setOnClickListener(onClickListener);
            this.fEa.endLoadData();
        }
    }

    public void bFT() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.Wu.setNextPage(this.fEa);
            }
            this.fEa.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fEa.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fEa.setOnClickListener(null);
            this.fEa.startLoadData();
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.qt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.qv(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.qt(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Co(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.iGH.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.iGH.c(eVar);
    }

    public void czp() {
        ot(false);
    }

    public void onPause() {
        if (this.iWD != null) {
            this.iWD.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cwh() {
        ot(true);
    }

    private void ot(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hBR != null) {
            this.hBR.rH(!z);
            al cxr = cxr();
            if (cxr != null && cxr.tR() != null) {
                z2 = cxr.tR().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hBR.cxq();
                } else if (this.iLc) {
                    this.hBR.a(this.hVc, this.fCJ, this.hVM, true);
                }
            }
        }
    }

    public void pG(boolean z) {
        this.iLc = z;
    }

    public void cxp() {
        if (this.hBR != null && this.iLc) {
            this.hBR.a(this.hVc, this.fCJ, this.hVM, true);
        }
    }

    public void cxq() {
        if (this.hBR != null) {
            this.hBR.cxq();
        }
    }

    public void aK(List<q> list) {
        if (this.iWD != null) {
            this.iWD.setData(list);
        }
        cxp();
    }

    public void JH(String str) {
        List<Integer> b = b(str, this.Wu);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Wu.o(intValue, intValue2);
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
                q item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c) {
                    c cVar = (c) item;
                    if (cVar.bce() != null && cVar.bce().getTid().equals(str)) {
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

    public List<q> getDataList() {
        if (this.iWD != null) {
            return this.iWD.getDataList();
        }
        return null;
    }

    public void cxs() {
        aK(new LinkedList());
    }

    public void cxo() {
        if (this.Wu != null) {
            this.Wu.setSelection(0);
        }
    }

    public void Jw() {
        if (this.iWD != null) {
            this.iWD.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.iGy != null) {
            this.iGy.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Wu != null) {
            this.Wu.setOnSrollToBottomListener(eVar);
        }
    }

    public void bkF() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fMR != null) {
            this.fMR.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fMR.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.iGy != null) {
            this.iGy.changeSkin(skinType);
        }
        if (this.iWD != null) {
            this.iWD.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fMR != null) {
            this.fMR.release();
        }
        b((f.e) null);
        if (this.iGy != null) {
            this.iGy.release();
        }
        if (this.iWD != null) {
            this.iWD.onDestroy();
        }
        if (this.hBR != null) {
            this.hBR.destroy();
        }
        cxt();
        MessageManager.getInstance().unRegisterListener(this.hUJ);
        MessageManager.getInstance().unRegisterListener(this.dVy);
    }

    private void cxt() {
        if (this.Wu != null) {
            this.Wu.removeOnScrollListener(this.mScrollListener);
            this.Wu.setRecyclerListener(null);
        }
        if (this.iGy != null) {
            this.iGy.a((f.d) null);
            this.iGy.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czq() {
        if (a(this.Wu)) {
            pW(false);
        } else {
            pW(true);
        }
    }
}
