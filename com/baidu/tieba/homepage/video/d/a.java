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
    private PbListView elw;
    private View enI;
    private g euk;
    private com.baidu.tieba.homepage.personalize.bigday.a gWZ;
    private BigdaySwipeRefreshLayout gXi;
    private m gqP;
    private NEGFeedBackView.a hbl;
    private e hjD;
    private com.baidu.tieba.homepage.video.a.a hjE;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int gqd = 0;
    private int eke = 0;
    private boolean mIsBackground = false;
    private boolean hbM = true;
    private boolean gqI = false;
    private g.d hbN = new g.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            a.this.bOq();
        }
    };
    private g.b hbO = new g.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.mD(true);
            if (a.this.gqP != null && !a.this.mIsBackground && a.this.hbM) {
                a.this.gqP.a(a.this.gqd, a.this.eke, a.this.gqI, true);
            }
        }
    };
    private CustomMessageListener cMm = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hjE.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.hbM) {
                        a.this.gqP.a(a.this.gqd, a.this.eke, a.this.gqI, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener gpV = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bOr;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bOr = a.this.bOr()) != null && bOr.nk() != null) {
                    bOr.nk().b(new a.C0052a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.gqP != null) {
                    a.this.gqP.cl(view);
                }
                if (view.getTag() instanceof d) {
                    ((d) view.getTag()).bvL().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int enO = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.gqP != null && a.this.hbM) {
                a.this.gqP.a(a.this.gqd, a.this.eke, a.this.gqI, 1);
            }
            if (this.enO != i) {
                this.enO = i;
                if (this.enO == 1) {
                    a.this.mT(true);
                } else {
                    a.this.bPK();
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
            a.this.gqd = i;
            a.this.eke = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public af bOr() {
        if (this.gqP == null || this.gqP.cyJ() == null || !(this.gqP.cyJ().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gqP.cyJ().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hbl = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gqP = new m(this.mPageContext, this.BK);
        this.gqP.Aq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gqP.setUniqueId(this.mBdUniqueId);
        this.gXi = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.gWZ = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gXi.setProgressView(this.gWZ);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gXi.setCustomDistances(i, i, i * 2);
        this.elw = new PbListView(this.mPageContext.getPageActivity());
        this.elw.createView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.elw.setLineGone();
        this.elw.setTextSize(R.dimen.tbfontsize36);
        this.elw.setTextColor(am.getColor(R.color.cp_cont_d));
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elw.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hjE = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.BK);
        this.hjE.b(this.hbl);
        this.hjE.setPageUniqueId(this.mBdUniqueId);
        this.hjD = new e();
        this.hjD.h(this.mBdUniqueId);
        this.hjE.b(this.hjD);
        this.enI = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aHO();
    }

    public void init() {
        this.BK.addOnScrollListener(this.mScrollListener);
        this.BK.setRecyclerListener(this.mRecyclerListener);
        this.gWZ.a(this.hbN);
        this.gWZ.a(this.hbO);
        this.gWZ.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cMm.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cMm);
        this.gpV.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gpV);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.euk == null) {
                this.euk = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.euk.onChangeSkinType();
            }
            this.euk.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.euk == null) {
            return false;
        }
        return this.euk.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.euk != null) {
            this.euk.dettachView(this.mRootView);
        }
    }

    public void bcu() {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.BK.setNextPage(this.elw);
            }
            this.elw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elw.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.elw.setOnClickListener(null);
            this.elw.endLoadData();
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.BK.setNextPage(this.elw);
            }
            this.elw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elw.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.elw.setOnClickListener(onClickListener);
            this.elw.endLoadData();
        }
    }

    public void bcv() {
        if (this.elw != null) {
            if (this.elw.getView().getParent() == null) {
                this.BK.setNextPage(this.elw);
            }
            this.elw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elw.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.elw.setOnClickListener(null);
            this.elw.startLoadData();
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
        this.mRefreshView.vz(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bcy() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.gXi.setRefreshing(true);
    }

    public void b(g.e eVar) {
        this.gXi.c(eVar);
    }

    public void bPJ() {
        lt(false);
    }

    public void onPause() {
        if (this.hjE != null) {
            this.hjE.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void bNg() {
        lt(true);
    }

    private void lt(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gqP != null) {
            this.gqP.oB(!z);
            af bOr = bOr();
            if (bOr != null && bOr.nk() != null) {
                z2 = bOr.nk().b(new a.C0052a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gqP.bOq();
                } else if (this.hbM) {
                    this.gqP.a(this.gqd, this.eke, this.gqI, true);
                }
            }
        }
    }

    public void mD(boolean z) {
        this.hbM = z;
    }

    public void bOp() {
        if (this.gqP != null && this.hbM) {
            this.gqP.a(this.gqd, this.eke, this.gqI, true);
        }
    }

    public void bOq() {
        if (this.gqP != null) {
            this.gqP.bOq();
        }
    }

    public void av(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hjE != null) {
            this.hjE.setData(list);
        }
        bOp();
    }

    public void Cj(String str) {
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
        if (this.hjE != null) {
            return this.hjE.getDataList();
        }
        return null;
    }

    public void bOs() {
        av(new LinkedList());
    }

    public void bOo() {
        if (this.BK != null) {
            this.BK.setSelection(0);
        }
    }

    public void wN() {
        if (this.hjE != null) {
            this.hjE.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gWZ != null) {
            this.gWZ.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.BK != null) {
            this.BK.setOnSrollToBottomListener(eVar);
        }
    }

    public void aHO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.euk != null) {
            this.euk.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.euk.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gWZ != null) {
            this.gWZ.changeSkin(skinType);
        }
        if (this.hjE != null) {
            this.hjE.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.euk != null) {
            this.euk.release();
        }
        b((g.e) null);
        if (this.gWZ != null) {
            this.gWZ.release();
        }
        if (this.hjE != null) {
            this.hjE.onDestroy();
        }
        if (this.gqP != null) {
            this.gqP.destroy();
        }
        bOt();
        MessageManager.getInstance().unRegisterListener(this.gpV);
        MessageManager.getInstance().unRegisterListener(this.cMm);
    }

    private void bOt() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mScrollListener);
            this.BK.setRecyclerListener(null);
        }
        if (this.gWZ != null) {
            this.gWZ.a((g.d) null);
            this.gWZ.a((g.b) null);
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
    public void bPK() {
        if (a(this.BK)) {
            mT(false);
        } else {
            mT(true);
        }
    }
}
