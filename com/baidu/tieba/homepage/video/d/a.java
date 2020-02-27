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
    private PbListView eli;
    private View ent;
    private g etW;
    private com.baidu.tieba.homepage.personalize.bigday.a gWL;
    private BigdaySwipeRefreshLayout gWU;
    private m gqA;
    private NEGFeedBackView.a haX;
    private e hjp;
    private com.baidu.tieba.homepage.video.a.a hjq;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int gpO = 0;
    private int ejQ = 0;
    private boolean mIsBackground = false;
    private boolean hby = true;
    private boolean gqt = false;
    private g.d hbz = new g.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            a.this.bOn();
        }
    };
    private g.b hbA = new g.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.mD(true);
            if (a.this.gqA != null && !a.this.mIsBackground && a.this.hby) {
                a.this.gqA.a(a.this.gpO, a.this.ejQ, a.this.gqt, true);
            }
        }
    };
    private CustomMessageListener cMk = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hjq.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.hby) {
                        a.this.gqA.a(a.this.gpO, a.this.ejQ, a.this.gqt, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener gpG = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bOo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bOo = a.this.bOo()) != null && bOo.nk() != null) {
                    bOo.nk().b(new a.C0052a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.gqA != null) {
                    a.this.gqA.cl(view);
                }
                if (view.getTag() instanceof d) {
                    ((d) view.getTag()).bvI().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int enA = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.gqA != null && a.this.hby) {
                a.this.gqA.a(a.this.gpO, a.this.ejQ, a.this.gqt, 1);
            }
            if (this.enA != i) {
                this.enA = i;
                if (this.enA == 1) {
                    a.this.mT(true);
                } else {
                    a.this.bPH();
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
            a.this.gpO = i;
            a.this.ejQ = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public af bOo() {
        if (this.gqA == null || this.gqA.cyG() == null || !(this.gqA.cyG().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gqA.cyG().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.haX = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gqA = new m(this.mPageContext, this.BK);
        this.gqA.Aq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gqA.setUniqueId(this.mBdUniqueId);
        this.gWU = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.gWL = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gWU.setProgressView(this.gWL);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gWU.setCustomDistances(i, i, i * 2);
        this.eli = new PbListView(this.mPageContext.getPageActivity());
        this.eli.createView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.eli.setLineGone();
        this.eli.setTextSize(R.dimen.tbfontsize36);
        this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.eli.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hjq = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.BK);
        this.hjq.b(this.haX);
        this.hjq.setPageUniqueId(this.mBdUniqueId);
        this.hjp = new e();
        this.hjp.h(this.mBdUniqueId);
        this.hjq.b(this.hjp);
        this.ent = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aHL();
    }

    public void init() {
        this.BK.addOnScrollListener(this.mScrollListener);
        this.BK.setRecyclerListener(this.mRecyclerListener);
        this.gWL.a(this.hbz);
        this.gWL.a(this.hbA);
        this.gWL.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cMk.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cMk);
        this.gpG.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gpG);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.etW == null) {
                this.etW = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.etW.onChangeSkinType();
            }
            this.etW.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.etW == null) {
            return false;
        }
        return this.etW.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this.mRootView);
        }
    }

    public void bcr() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.BK.setNextPage(this.eli);
            }
            this.eli.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.eli.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.eli.setOnClickListener(null);
            this.eli.endLoadData();
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.BK.setNextPage(this.eli);
            }
            this.eli.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.eli.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.eli.setOnClickListener(onClickListener);
            this.eli.endLoadData();
        }
    }

    public void bcs() {
        if (this.eli != null) {
            if (this.eli.getView().getParent() == null) {
                this.BK.setNextPage(this.eli);
            }
            this.eli.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.eli.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.eli.setOnClickListener(null);
            this.eli.startLoadData();
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
        this.mRefreshView.vy(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bcv() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.gWU.setRefreshing(true);
    }

    public void b(g.e eVar) {
        this.gWU.c(eVar);
    }

    public void bPG() {
        lt(false);
    }

    public void onPause() {
        if (this.hjq != null) {
            this.hjq.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void bNd() {
        lt(true);
    }

    private void lt(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gqA != null) {
            this.gqA.oB(!z);
            af bOo = bOo();
            if (bOo != null && bOo.nk() != null) {
                z2 = bOo.nk().b(new a.C0052a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gqA.bOn();
                } else if (this.hby) {
                    this.gqA.a(this.gpO, this.ejQ, this.gqt, true);
                }
            }
        }
    }

    public void mD(boolean z) {
        this.hby = z;
    }

    public void bOm() {
        if (this.gqA != null && this.hby) {
            this.gqA.a(this.gpO, this.ejQ, this.gqt, true);
        }
    }

    public void bOn() {
        if (this.gqA != null) {
            this.gqA.bOn();
        }
    }

    public void av(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hjq != null) {
            this.hjq.setData(list);
        }
        bOm();
    }

    public void Ci(String str) {
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
                    if (cVar.aAe() != null && cVar.aAe().getTid().equals(str)) {
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
        if (this.hjq != null) {
            return this.hjq.getDataList();
        }
        return null;
    }

    public void bOp() {
        av(new LinkedList());
    }

    public void bOl() {
        if (this.BK != null) {
            this.BK.setSelection(0);
        }
    }

    public void wN() {
        if (this.hjq != null) {
            this.hjq.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gWL != null) {
            this.gWL.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.BK != null) {
            this.BK.setOnSrollToBottomListener(eVar);
        }
    }

    public void aHL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.etW != null) {
            this.etW.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.etW.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gWL != null) {
            this.gWL.changeSkin(skinType);
        }
        if (this.hjq != null) {
            this.hjq.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.etW != null) {
            this.etW.release();
        }
        b((g.e) null);
        if (this.gWL != null) {
            this.gWL.release();
        }
        if (this.hjq != null) {
            this.hjq.onDestroy();
        }
        if (this.gqA != null) {
            this.gqA.destroy();
        }
        bOq();
        MessageManager.getInstance().unRegisterListener(this.gpG);
        MessageManager.getInstance().unRegisterListener(this.cMk);
    }

    private void bOq() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mScrollListener);
            this.BK.setRecyclerListener(null);
        }
        if (this.gWL != null) {
            this.gWL.a((g.d) null);
            this.gWL.a((g.b) null);
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
    public void bPH() {
        if (a(this.BK)) {
            mT(false);
        } else {
            mT(true);
        }
    }
}
