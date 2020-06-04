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
import com.baidu.adp.widget.ListView.o;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.model.e;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Vw;
    private PbListView fcj;
    private View fev;
    private g flb;
    private m gWx;
    private com.baidu.tieba.homepage.personalize.bigday.a hXA;
    private BigdaySwipeRefreshLayout hXJ;
    private NEGFeedBackView.a ibD;
    private e ikq;
    private com.baidu.tieba.homepage.video.a.a ikr;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int hpb = 0;
    private int faR = 0;
    private boolean mIsBackground = false;
    private boolean ice = true;
    private boolean hpK = false;
    private f.d icf = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cfI();
        }
    };
    private f.b icg = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.oj(true);
            if (a.this.gWx != null && !a.this.mIsBackground && a.this.ice) {
                a.this.gWx.a(a.this.hpb, a.this.faR, a.this.hpK, true);
            }
        }
    };
    private CustomMessageListener dzH = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ikr.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.ice) {
                        a.this.gWx.a(a.this.hpb, a.this.faR, a.this.hpK, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hoS = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ag cfJ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cfJ = a.this.cfJ()) != null && cfJ.rM() != null) {
                    cfJ.rM().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.gWx != null) {
                    a.this.gWx.ct(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bLW().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int feB = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.gWx != null && a.this.ice) {
                a.this.gWx.a(a.this.hpb, a.this.faR, a.this.hpK, 1);
            }
            if (this.feB != i) {
                this.feB = i;
                if (this.feB == 1) {
                    a.this.oz(true);
                } else {
                    a.this.chj();
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
            cf(i3, (i4 - i3) + 1);
        }

        private void cf(int i, int i2) {
            a.this.hpb = i;
            a.this.faR = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public ag cfJ() {
        if (this.gWx == null || this.gWx.cQU() == null || !(this.gWx.cQU().getTag() instanceof ag)) {
            return null;
        }
        return (ag) this.gWx.cQU().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ibD = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gWx = new m(this.mPageContext, this.Vw);
        this.gWx.BK(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gWx.setUniqueId(this.mBdUniqueId);
        this.hXJ = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.hXA = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.hXJ.setProgressView(this.hXA);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.hXJ.setCustomDistances(i, i, i * 2);
        this.fcj = new PbListView(this.mPageContext.getPageActivity());
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fcj.setLineGone();
        this.fcj.setTextSize(R.dimen.tbfontsize36);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fcj.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ikr = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Vw);
        this.ikr.b(this.ibD);
        this.ikr.setPageUniqueId(this.mBdUniqueId);
        this.ikq = new e();
        this.ikq.i(this.mBdUniqueId);
        this.ikr.b(this.ikq);
        this.fev = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aWr();
    }

    public void init() {
        this.Vw.addOnScrollListener(this.mScrollListener);
        this.Vw.setRecyclerListener(this.mRecyclerListener);
        this.hXA.a(this.icf);
        this.hXA.a(this.icg);
        this.hXA.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dzH.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dzH);
        this.hoS.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hoS);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.flb == null) {
                this.flb = new g(this.mPageContext.getPageActivity());
                this.flb.onChangeSkinType();
            }
            this.flb.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.flb == null) {
            return false;
        }
        return this.flb.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this.mRootView);
        }
    }

    public void bqL() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.Vw.setNextPage(this.fcj);
            }
            this.fcj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.fcj.setOnClickListener(null);
            this.fcj.endLoadData();
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.Vw.setNextPage(this.fcj);
            }
            this.fcj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.fcj.setOnClickListener(onClickListener);
            this.fcj.endLoadData();
        }
    }

    public void bqM() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.Vw.setNextPage(this.fcj);
            }
            this.fcj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fcj.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fcj.setOnClickListener(null);
            this.fcj.startLoadData();
        }
    }

    public void k(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.nv(R.drawable.new_pic_emotion_08);
        this.mRefreshView.nx(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.nv(R.drawable.new_pic_emotion_03);
        this.mRefreshView.yx(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bqQ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.hXJ.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.hXJ.c(eVar);
    }

    public void chi() {
        mX(false);
    }

    public void onPause() {
        if (this.ikr != null) {
            this.ikr.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ceA() {
        mX(true);
    }

    private void mX(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gWx != null) {
            this.gWx.qi(!z);
            ag cfJ = cfJ();
            if (cfJ != null && cfJ.rM() != null) {
                z2 = cfJ.rM().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gWx.cfI();
                } else if (this.ice) {
                    this.gWx.a(this.hpb, this.faR, this.hpK, true);
                }
            }
        }
    }

    public void oj(boolean z) {
        this.ice = z;
    }

    public void cfH() {
        if (this.gWx != null && this.ice) {
            this.gWx.a(this.hpb, this.faR, this.hpK, true);
        }
    }

    public void cfI() {
        if (this.gWx != null) {
            this.gWx.cfI();
        }
    }

    public void az(List<o> list) {
        if (this.ikr != null) {
            this.ikr.setData(list);
        }
        cfH();
    }

    public void FD(String str) {
        List<Integer> b = b(str, this.Vw);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Vw.l(intValue, intValue2);
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
                o item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c) {
                    c cVar = (c) item;
                    if (cVar.aOi() != null && cVar.aOi().getTid().equals(str)) {
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

    public List<o> getDataList() {
        if (this.ikr != null) {
            return this.ikr.getDataList();
        }
        return null;
    }

    public void cfK() {
        az(new LinkedList());
    }

    public void cfG() {
        if (this.Vw != null) {
            this.Vw.setSelection(0);
        }
    }

    public void CZ() {
        if (this.ikr != null) {
            this.ikr.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.hXA != null) {
            this.hXA.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Vw != null) {
            this.Vw.setOnSrollToBottomListener(eVar);
        }
    }

    public void aWr() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.flb != null) {
            this.flb.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.flb.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.hXA != null) {
            this.hXA.changeSkin(skinType);
        }
        if (this.ikr != null) {
            this.ikr.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.flb != null) {
            this.flb.release();
        }
        b((f.e) null);
        if (this.hXA != null) {
            this.hXA.release();
        }
        if (this.ikr != null) {
            this.ikr.onDestroy();
        }
        if (this.gWx != null) {
            this.gWx.destroy();
        }
        cfL();
        MessageManager.getInstance().unRegisterListener(this.hoS);
        MessageManager.getInstance().unRegisterListener(this.dzH);
    }

    private void cfL() {
        if (this.Vw != null) {
            this.Vw.removeOnScrollListener(this.mScrollListener);
            this.Vw.setRecyclerListener(null);
        }
        if (this.hXA != null) {
            this.hXA.a((f.d) null);
            this.hXA.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chj() {
        if (a(this.Vw)) {
            oz(false);
        } else {
            oz(true);
        }
    }
}
