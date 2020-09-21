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
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView WM;
    private PbListView fHm;
    private View fJz;
    private g fQf;
    private i hIT;
    private com.baidu.tieba.homepage.personalize.bigday.a iOi;
    private BigdaySwipeRefreshLayout iOr;
    private NEGFeedBackView.a iTh;
    private e jfi;
    private com.baidu.tieba.homepage.video.a.a jfj;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int icc = 0;
    private int fFV = 0;
    private boolean mIsBackground = false;
    private boolean iTI = true;
    private boolean icM = false;
    private f.d iTJ = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cAY();
        }
    };
    private f.b iTK = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.pO(true);
            if (a.this.hIT != null && !a.this.mIsBackground && a.this.iTI) {
                a.this.hIT.a(a.this.icc, a.this.fFV, a.this.icM, true);
            }
        }
    };
    private CustomMessageListener dXI = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jfj.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.iTI) {
                        a.this.hIT.a(a.this.icc, a.this.fFV, a.this.icM, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener ibJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cAZ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cAZ = a.this.cAZ()) != null && cAZ.tW() != null) {
                    cAZ.tW().b(new a.C0096a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.hIT != null) {
                    a.this.hIT.cN(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).cfU().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int fJF = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.hIT != null && a.this.iTI) {
                a.this.hIT.a(a.this.icc, a.this.fFV, a.this.icM, 1);
            }
            if (this.fJF != i) {
                this.fJF = i;
                if (this.fJF == 1) {
                    a.this.qe(true);
                } else {
                    a.this.cCX();
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
            a.this.icc = i;
            a.this.fFV = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public am cAZ() {
        if (this.hIT == null || this.hIT.dnC() == null || !(this.hIT.dnC().getTag() instanceof am)) {
            return null;
        }
        return (am) this.hIT.dnC().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iTh = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.WM = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.WM.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.hIT = new i(this.mPageContext, this.WM);
        this.hIT.Gh(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hIT.setUniqueId(this.mBdUniqueId);
        this.iOr = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.iOi = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.iOr.setProgressView(this.iOi);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.iOr.setCustomDistances(i, i, i * 2);
        this.fHm = new PbListView(this.mPageContext.getPageActivity());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize36);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jfj = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.WM);
        this.jfj.b(this.iTh);
        this.jfj.setPageUniqueId(this.mBdUniqueId);
        this.jfi = new e();
        this.jfi.i(this.mBdUniqueId);
        this.jfj.b(this.jfi);
        this.fJz = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        blA();
    }

    public void init() {
        this.WM.addOnScrollListener(this.mScrollListener);
        this.WM.setRecyclerListener(this.mRecyclerListener);
        this.iOi.a(this.iTJ);
        this.iOi.a(this.iTK);
        this.iOi.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dXI.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dXI);
        this.ibJ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.ibJ);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fQf == null) {
                this.fQf = new g(this.mPageContext.getPageActivity());
                this.fQf.onChangeSkinType();
            }
            this.fQf.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fQf == null) {
            return false;
        }
        return this.fQf.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this.mRootView);
        }
    }

    public void bHi() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.WM.setNextPage(this.fHm);
            }
            this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fHm.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.fHm.setOnClickListener(null);
            this.fHm.endLoadData();
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.WM.setNextPage(this.fHm);
            }
            this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fHm.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.fHm.setOnClickListener(onClickListener);
            this.fHm.endLoadData();
        }
    }

    public void bHj() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.WM.setNextPage(this.fHm);
            }
            this.fHm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fHm.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fHm.setOnClickListener(null);
            this.fHm.startLoadData();
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.qK(R.drawable.new_pic_emotion_08);
        this.mRefreshView.qM(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.qK(R.drawable.new_pic_emotion_03);
        this.mRefreshView.CK(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.iOr.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.iOr.c(eVar);
    }

    public void cCW() {
        oz(false);
    }

    public void onPause() {
        if (this.jfj != null) {
            this.jfj.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void czB() {
        oz(true);
    }

    private void oz(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hIT != null) {
            this.hIT.rP(!z);
            am cAZ = cAZ();
            if (cAZ != null && cAZ.tW() != null) {
                z2 = cAZ.tW().b(new a.C0096a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hIT.cAY();
                } else if (this.iTI) {
                    this.hIT.a(this.icc, this.fFV, this.icM, true);
                }
            }
        }
    }

    public void pO(boolean z) {
        this.iTI = z;
    }

    public void cAX() {
        if (this.hIT != null && this.iTI) {
            this.hIT.a(this.icc, this.fFV, this.icM, true);
        }
    }

    public void cAY() {
        if (this.hIT != null) {
            this.hIT.cAY();
        }
    }

    public void aO(List<q> list) {
        if (this.jfj != null) {
            this.jfj.setData(list);
        }
        cAX();
    }

    public void Kj(String str) {
        List<Integer> b = b(str, this.WM);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.WM.o(intValue, intValue2);
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
                    if (cVar.bcY() != null && cVar.bcY().getTid().equals(str)) {
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
        if (this.jfj != null) {
            return this.jfj.getDataList();
        }
        return null;
    }

    public void cBa() {
        aO(new LinkedList());
    }

    public void cAW() {
        if (this.WM != null) {
            this.WM.setSelection(0);
        }
    }

    public void Ka() {
        if (this.jfj != null) {
            this.jfj.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.iOi != null) {
            this.iOi.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.WM != null) {
            this.WM.setOnSrollToBottomListener(eVar);
        }
    }

    public void blA() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fQf != null) {
            this.fQf.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fQf.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.iOi != null) {
            this.iOi.changeSkin(skinType);
        }
        if (this.jfj != null) {
            this.jfj.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fQf != null) {
            this.fQf.release();
        }
        b((f.e) null);
        if (this.iOi != null) {
            this.iOi.release();
        }
        if (this.jfj != null) {
            this.jfj.onDestroy();
        }
        if (this.hIT != null) {
            this.hIT.destroy();
        }
        cBb();
        MessageManager.getInstance().unRegisterListener(this.ibJ);
        MessageManager.getInstance().unRegisterListener(this.dXI);
    }

    private void cBb() {
        if (this.WM != null) {
            this.WM.removeOnScrollListener(this.mScrollListener);
            this.WM.setRecyclerListener(null);
        }
        if (this.iOi != null) {
            this.iOi.a((f.d) null);
            this.iOi.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCX() {
        if (a(this.WM)) {
            qe(false);
        } else {
            qe(true);
        }
    }
}
