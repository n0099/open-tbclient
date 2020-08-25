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
    private PbListView fDW;
    private View fGj;
    private g fMN;
    private i hBL;
    private BigdaySwipeRefreshLayout iGB;
    private com.baidu.tieba.homepage.personalize.bigday.a iGs;
    private NEGFeedBackView.a iKv;
    private e iWw;
    private com.baidu.tieba.homepage.video.a.a iWx;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int hUW = 0;
    private int fCF = 0;
    private boolean mIsBackground = false;
    private boolean iKW = true;
    private boolean hVG = false;
    private f.d iKX = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cxp();
        }
    };
    private f.b iKY = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.pE(true);
            if (a.this.hBL != null && !a.this.mIsBackground && a.this.iKW) {
                a.this.hBL.a(a.this.hUW, a.this.fCF, a.this.hVG, true);
            }
        }
    };
    private CustomMessageListener dVu = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iWx.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.iKW) {
                        a.this.hBL.a(a.this.hUW, a.this.fCF, a.this.hVG, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hUD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            al cxq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cxq = a.this.cxq()) != null && cxq.tR() != null) {
                    cxq.tR().b(new a.C0095a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.hBL != null) {
                    a.this.hBL.cE(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).ccE().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int fGp = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.hBL != null && a.this.iKW) {
                a.this.hBL.a(a.this.hUW, a.this.fCF, a.this.hVG, 1);
            }
            if (this.fGp != i) {
                this.fGp = i;
                if (this.fGp == 1) {
                    a.this.pU(true);
                } else {
                    a.this.czp();
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
            a.this.hUW = i;
            a.this.fCF = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public al cxq() {
        if (this.hBL == null || this.hBL.djT() == null || !(this.hBL.djT().getTag() instanceof al)) {
            return null;
        }
        return (al) this.hBL.djT().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iKv = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.hBL = new i(this.mPageContext, this.Wu);
        this.hBL.FG(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hBL.setUniqueId(this.mBdUniqueId);
        this.iGB = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.iGs = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.iGB.setProgressView(this.iGs);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.iGB.setCustomDistances(i, i, i * 2);
        this.fDW = new PbListView(this.mPageContext.getPageActivity());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize36);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iWx = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Wu);
        this.iWx.b(this.iKv);
        this.iWx.setPageUniqueId(this.mBdUniqueId);
        this.iWw = new e();
        this.iWw.i(this.mBdUniqueId);
        this.iWx.b(this.iWw);
        this.fGj = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bkF();
    }

    public void init() {
        this.Wu.addOnScrollListener(this.mScrollListener);
        this.Wu.setRecyclerListener(this.mRecyclerListener);
        this.iGs.a(this.iKX);
        this.iGs.a(this.iKY);
        this.iGs.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dVu.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dVu);
        this.hUD.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hUD);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fMN == null) {
                this.fMN = new g(this.mPageContext.getPageActivity());
                this.fMN.onChangeSkinType();
            }
            this.fMN.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fMN == null) {
            return false;
        }
        return this.fMN.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this.mRootView);
        }
    }

    public void bFR() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.Wu.setNextPage(this.fDW);
            }
            this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.fDW.setOnClickListener(null);
            this.fDW.endLoadData();
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.Wu.setNextPage(this.fDW);
            }
            this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.fDW.setOnClickListener(onClickListener);
            this.fDW.endLoadData();
        }
    }

    public void bFS() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.Wu.setNextPage(this.fDW);
            }
            this.fDW.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fDW.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fDW.setOnClickListener(null);
            this.fDW.startLoadData();
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
        this.mRefreshView.Cn(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.iGB.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.iGB.c(eVar);
    }

    public void czo() {
        or(false);
    }

    public void onPause() {
        if (this.iWx != null) {
            this.iWx.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cwg() {
        or(true);
    }

    private void or(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hBL != null) {
            this.hBL.rF(!z);
            al cxq = cxq();
            if (cxq != null && cxq.tR() != null) {
                z2 = cxq.tR().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hBL.cxp();
                } else if (this.iKW) {
                    this.hBL.a(this.hUW, this.fCF, this.hVG, true);
                }
            }
        }
    }

    public void pE(boolean z) {
        this.iKW = z;
    }

    public void cxo() {
        if (this.hBL != null && this.iKW) {
            this.hBL.a(this.hUW, this.fCF, this.hVG, true);
        }
    }

    public void cxp() {
        if (this.hBL != null) {
            this.hBL.cxp();
        }
    }

    public void aK(List<q> list) {
        if (this.iWx != null) {
            this.iWx.setData(list);
        }
        cxo();
    }

    public void JG(String str) {
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
        if (this.iWx != null) {
            return this.iWx.getDataList();
        }
        return null;
    }

    public void cxr() {
        aK(new LinkedList());
    }

    public void cxn() {
        if (this.Wu != null) {
            this.Wu.setSelection(0);
        }
    }

    public void Jw() {
        if (this.iWx != null) {
            this.iWx.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.iGs != null) {
            this.iGs.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Wu != null) {
            this.Wu.setOnSrollToBottomListener(eVar);
        }
    }

    public void bkF() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fMN != null) {
            this.fMN.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fMN.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.iGs != null) {
            this.iGs.changeSkin(skinType);
        }
        if (this.iWx != null) {
            this.iWx.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fMN != null) {
            this.fMN.release();
        }
        b((f.e) null);
        if (this.iGs != null) {
            this.iGs.release();
        }
        if (this.iWx != null) {
            this.iWx.onDestroy();
        }
        if (this.hBL != null) {
            this.hBL.destroy();
        }
        cxs();
        MessageManager.getInstance().unRegisterListener(this.hUD);
        MessageManager.getInstance().unRegisterListener(this.dVu);
    }

    private void cxs() {
        if (this.Wu != null) {
            this.Wu.removeOnScrollListener(this.mScrollListener);
            this.Wu.setRecyclerListener(null);
        }
        if (this.iGs != null) {
            this.iGs.a((f.d) null);
            this.iGs.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pU(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czp() {
        if (a(this.Wu)) {
            pU(false);
        } else {
            pU(true);
        }
    }
}
