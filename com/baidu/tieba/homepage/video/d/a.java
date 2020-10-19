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
import com.baidu.card.am;
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
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Xc;
    private PbListView fTv;
    private View fVQ;
    private g gcx;
    private i hXO;
    private com.baidu.tieba.homepage.personalize.bigday.a jda;
    private BigdaySwipeRefreshLayout jdj;
    private NEGFeedBackView.a jif;
    private e juh;
    private com.baidu.tieba.homepage.video.a.a jui;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int ird = 0;
    private int fSe = 0;
    private boolean mIsBackground = false;
    private boolean jiG = true;
    private boolean irN = false;
    private f.d jiH = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cEF();
        }
    };
    private f.b jiI = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.qu(true);
            if (a.this.hXO != null && !a.this.mIsBackground && a.this.jiG) {
                a.this.hXO.a(a.this.ird, a.this.fSe, a.this.irN, true);
            }
        }
    };
    private CustomMessageListener ejK = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jui.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.jiG) {
                        a.this.hXO.a(a.this.ird, a.this.fSe, a.this.irN, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iqK = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cEG;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cEG = a.this.cEG()) != null && cEG.tW() != null) {
                    cEG.tW().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.hXO != null) {
                    a.this.hXO.cR(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).cjq().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int fVW = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.hXO != null && a.this.jiG) {
                a.this.hXO.a(a.this.ird, a.this.fSe, a.this.irN, 1);
            }
            if (this.fVW != i) {
                this.fVW = i;
                if (this.fVW == 1) {
                    a.this.qK(true);
                } else {
                    a.this.cGG();
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
            cz(i3, (i4 - i3) + 1);
        }

        private void cz(int i, int i2) {
            a.this.ird = i;
            a.this.fSe = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public am cEG() {
        if (this.hXO == null || this.hXO.drn() == null || !(this.hXO.drn().getTag() instanceof am)) {
            return null;
        }
        return (am) this.hXO.drn().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jif = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Xc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Xc.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.hXO = new i(this.mPageContext, this.Xc);
        this.hXO.GN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hXO.setUniqueId(this.mBdUniqueId);
        this.jdj = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.jda = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jdj.setProgressView(this.jda);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jdj.setCustomDistances(i, i, i * 2);
        this.fTv = new PbListView(this.mPageContext.getPageActivity());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize36);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jui = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Xc);
        this.jui.b(this.jif);
        this.jui.setPageUniqueId(this.mBdUniqueId);
        this.juh = new e();
        this.juh.i(this.mBdUniqueId);
        this.jui.b(this.juh);
        this.fVQ = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bok();
    }

    public void init() {
        this.Xc.addOnScrollListener(this.mScrollListener);
        this.Xc.setRecyclerListener(this.mRecyclerListener);
        this.jda.a(this.jiH);
        this.jda.a(this.jiI);
        this.jda.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.ejK.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.ejK);
        this.iqK.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iqK);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gcx == null) {
                this.gcx = new g(this.mPageContext.getPageActivity());
                this.gcx.onChangeSkinType();
            }
            this.gcx.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gcx == null) {
            return false;
        }
        return this.gcx.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this.mRootView);
        }
    }

    public void bJU() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.Xc.setNextPage(this.fTv);
            }
            this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fTv.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.fTv.setOnClickListener(null);
            this.fTv.endLoadData();
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.Xc.setNextPage(this.fTv);
            }
            this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fTv.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.fTv.setOnClickListener(onClickListener);
            this.fTv.endLoadData();
        }
    }

    public void bJV() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.Xc.setNextPage(this.fTv);
            }
            this.fTv.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fTv.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fTv.setOnClickListener(null);
            this.fTv.startLoadData();
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.ri(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rk(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.ri(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Dw(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.jdj.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.jdj.c(eVar);
    }

    public void cGF() {
        pe(false);
    }

    public void onPause() {
        if (this.jui != null) {
            this.jui.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cCY() {
        pe(true);
    }

    private void pe(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hXO != null) {
            this.hXO.sw(!z);
            am cEG = cEG();
            if (cEG != null && cEG.tW() != null) {
                z2 = cEG.tW().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hXO.cEF();
                } else if (this.jiG) {
                    this.hXO.a(this.ird, this.fSe, this.irN, true);
                }
            }
        }
    }

    public void qu(boolean z) {
        this.jiG = z;
    }

    public void cEE() {
        if (this.hXO != null && this.jiG) {
            this.hXO.a(this.ird, this.fSe, this.irN, true);
        }
    }

    public void cEF() {
        if (this.hXO != null) {
            this.hXO.cEF();
        }
    }

    public void aR(List<q> list) {
        if (this.jui != null) {
            this.jui.setData(list);
        }
        cEE();
    }

    public void KY(String str) {
        List<Integer> b = b(str, this.Xc);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Xc.o(intValue, intValue2);
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
                    if (cVar.bfG() != null && cVar.bfG().getTid().equals(str)) {
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
        if (this.jui != null) {
            return this.jui.getDataList();
        }
        return null;
    }

    public void cEH() {
        aR(new LinkedList());
    }

    public void cED() {
        if (this.Xc != null) {
            this.Xc.setSelection(0);
        }
    }

    public void Lf() {
        if (this.jui != null) {
            this.jui.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jda != null) {
            this.jda.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Xc != null) {
            this.Xc.setOnSrollToBottomListener(eVar);
        }
    }

    public void bok() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gcx != null) {
            this.gcx.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gcx.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jda != null) {
            this.jda.changeSkin(skinType);
        }
        if (this.jui != null) {
            this.jui.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gcx != null) {
            this.gcx.release();
        }
        b((f.e) null);
        if (this.jda != null) {
            this.jda.release();
        }
        if (this.jui != null) {
            this.jui.onDestroy();
        }
        if (this.hXO != null) {
            this.hXO.destroy();
        }
        cEI();
        MessageManager.getInstance().unRegisterListener(this.iqK);
        MessageManager.getInstance().unRegisterListener(this.ejK);
    }

    private void cEI() {
        if (this.Xc != null) {
            this.Xc.removeOnScrollListener(this.mScrollListener);
            this.Xc.setRecyclerListener(null);
        }
        if (this.jda != null) {
            this.jda.a((f.d) null);
            this.jda.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qK(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGG() {
        if (a(this.Xc)) {
            qK(false);
        } else {
            qK(true);
        }
    }
}
