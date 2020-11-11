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
    private BdTypeRecyclerView Xe;
    private PbListView gjo;
    private View glJ;
    private g gso;
    private i iqn;
    private NEGFeedBackView.a jAz;
    private e jMF;
    private com.baidu.tieba.homepage.video.a.a jMG;
    private BigdaySwipeRefreshLayout jvC;
    private com.baidu.tieba.homepage.personalize.bigday.a jvt;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int iJw = 0;
    private int ghW = 0;
    private boolean mIsBackground = false;
    private boolean jBa = true;
    private boolean iKg = false;
    private f.d jBb = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cKn();
        }
    };
    private f.b jBc = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.qV(true);
            if (a.this.iqn != null && !a.this.mIsBackground && a.this.jBa) {
                a.this.iqn.a(a.this.iJw, a.this.ghW, a.this.iKg, true);
            }
        }
    };
    private CustomMessageListener eyc = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jMG.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.jBa) {
                        a.this.iqn.a(a.this.iJw, a.this.ghW, a.this.iKg, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iJd = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cKo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cKo = a.this.cKo()) != null && cKo.tW() != null) {
                    cKo.tW().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.iqn != null) {
                    a.this.iqn.da(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                    ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).coY().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int glP = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.iqn != null && a.this.jBa) {
                a.this.iqn.a(a.this.iJw, a.this.ghW, a.this.iKg, 1);
            }
            if (this.glP != i) {
                this.glP = i;
                if (this.glP == 1) {
                    a.this.rl(true);
                } else {
                    a.this.cMo();
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
            cD(i3, (i4 - i3) + 1);
        }

        private void cD(int i, int i2) {
            a.this.iJw = i;
            a.this.ghW = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public am cKo() {
        if (this.iqn == null || this.iqn.dwW() == null || !(this.iqn.dwW().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iqn.dwW().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jAz = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.iqn = new i(this.mPageContext, this.Xe);
        this.iqn.Ht(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iqn.setUniqueId(this.mBdUniqueId);
        this.jvC = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.jvt = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jvC.setProgressView(this.jvt);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jvC.setCustomDistances(i, i, i * 2);
        this.gjo = new PbListView(this.mPageContext.getPageActivity());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize36);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jMG = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Xe);
        this.jMG.b(this.jAz);
        this.jMG.setPageUniqueId(this.mBdUniqueId);
        this.jMF = new e();
        this.jMF.i(this.mBdUniqueId);
        this.jMG.b(this.jMF);
        this.glJ = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bsD();
    }

    public void init() {
        this.Xe.addOnScrollListener(this.mScrollListener);
        this.Xe.setRecyclerListener(this.mRecyclerListener);
        this.jvt.a(this.jBb);
        this.jvt.a(this.jBc);
        this.jvt.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eyc.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eyc);
        this.iJd.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iJd);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gso == null) {
                this.gso = new g(this.mPageContext.getPageActivity());
                this.gso.onChangeSkinType();
            }
            this.gso.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gso == null) {
            return false;
        }
        return this.gso.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this.mRootView);
        }
    }

    public void bOW() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.Xe.setNextPage(this.gjo);
            }
            this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.gjo.setOnClickListener(null);
            this.gjo.endLoadData();
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.Xe.setNextPage(this.gjo);
            }
            this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.gjo.setOnClickListener(onClickListener);
            this.gjo.endLoadData();
        }
    }

    public void bOX() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.Xe.setNextPage(this.gjo);
            }
            this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gjo.setOnClickListener(null);
            this.gjo.startLoadData();
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.rD(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rF(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.rD(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Ed(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.jvC.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.jvC.c(eVar);
    }

    public void cMn() {
        pF(false);
    }

    public void onPause() {
        if (this.jMG != null) {
            this.jMG.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cIG() {
        pF(true);
    }

    private void pF(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iqn != null) {
            this.iqn.sX(!z);
            am cKo = cKo();
            if (cKo != null && cKo.tW() != null) {
                z2 = cKo.tW().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iqn.cKn();
                } else if (this.jBa) {
                    this.iqn.a(this.iJw, this.ghW, this.iKg, true);
                }
            }
        }
    }

    public void qV(boolean z) {
        this.jBa = z;
    }

    public void cKm() {
        if (this.iqn != null && this.jBa) {
            this.iqn.a(this.iJw, this.ghW, this.iKg, true);
        }
    }

    public void cKn() {
        if (this.iqn != null) {
            this.iqn.cKn();
        }
    }

    public void bi(List<q> list) {
        if (this.jMG != null) {
            this.jMG.setData(list);
        }
        cKm();
    }

    public void LN(String str) {
        List<Integer> b = b(str, this.Xe);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Xe.o(intValue, intValue2);
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
                    if (cVar.bjZ() != null && cVar.bjZ().getTid().equals(str)) {
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
        if (this.jMG != null) {
            return this.jMG.getDataList();
        }
        return null;
    }

    public void cKp() {
        bi(new LinkedList());
    }

    public void cKl() {
        if (this.Xe != null) {
            this.Xe.setSelection(0);
        }
    }

    public void LZ() {
        if (this.jMG != null) {
            this.jMG.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jvt != null) {
            this.jvt.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Xe != null) {
            this.Xe.setOnSrollToBottomListener(eVar);
        }
    }

    public void bsD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gso != null) {
            this.gso.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gso.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jvt != null) {
            this.jvt.changeSkin(skinType);
        }
        if (this.jMG != null) {
            this.jMG.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gso != null) {
            this.gso.release();
        }
        b((f.e) null);
        if (this.jvt != null) {
            this.jvt.release();
        }
        if (this.jMG != null) {
            this.jMG.onDestroy();
        }
        if (this.iqn != null) {
            this.iqn.destroy();
        }
        cKq();
        MessageManager.getInstance().unRegisterListener(this.iJd);
        MessageManager.getInstance().unRegisterListener(this.eyc);
    }

    private void cKq() {
        if (this.Xe != null) {
            this.Xe.removeOnScrollListener(this.mScrollListener);
            this.Xe.setRecyclerListener(null);
        }
        if (this.jvt != null) {
            this.jvt.a((f.d) null);
            this.jvt.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rl(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMo() {
        if (a(this.Xe)) {
            rl(false);
        } else {
            rl(true);
        }
    }
}
