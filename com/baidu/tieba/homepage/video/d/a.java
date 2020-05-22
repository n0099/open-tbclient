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
    private PbListView fbY;
    private View fek;
    private g fkQ;
    private m gWm;
    private com.baidu.tieba.homepage.personalize.bigday.a hWN;
    private BigdaySwipeRefreshLayout hWW;
    private NEGFeedBackView.a iaQ;
    private e ijD;
    private com.baidu.tieba.homepage.video.a.a ijE;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int hoQ = 0;
    private int faG = 0;
    private boolean mIsBackground = false;
    private boolean ibr = true;
    private boolean hpz = false;
    private f.d ibs = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cfz();
        }
    };
    private f.b ibt = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.oj(true);
            if (a.this.gWm != null && !a.this.mIsBackground && a.this.ibr) {
                a.this.gWm.a(a.this.hoQ, a.this.faG, a.this.hpz, true);
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
                    a.this.ijE.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.ibr) {
                        a.this.gWm.a(a.this.hoQ, a.this.faG, a.this.hpz, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hoH = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ag cfA;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cfA = a.this.cfA()) != null && cfA.rM() != null) {
                    cfA.rM().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.gWm != null) {
                    a.this.gWm.ct(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bLU().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int feq = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.gWm != null && a.this.ibr) {
                a.this.gWm.a(a.this.hoQ, a.this.faG, a.this.hpz, 1);
            }
            if (this.feq != i) {
                this.feq = i;
                if (this.feq == 1) {
                    a.this.oz(true);
                } else {
                    a.this.cha();
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
            a.this.hoQ = i;
            a.this.faG = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public ag cfA() {
        if (this.gWm == null || this.gWm.cQE() == null || !(this.gWm.cQE().getTag() instanceof ag)) {
            return null;
        }
        return (ag) this.gWm.cQE().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iaQ = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gWm = new m(this.mPageContext, this.Vw);
        this.gWm.BI(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gWm.setUniqueId(this.mBdUniqueId);
        this.hWW = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.hWN = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.hWW.setProgressView(this.hWN);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.hWW.setCustomDistances(i, i, i * 2);
        this.fbY = new PbListView(this.mPageContext.getPageActivity());
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fbY.setLineGone();
        this.fbY.setTextSize(R.dimen.tbfontsize36);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ijE = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Vw);
        this.ijE.b(this.iaQ);
        this.ijE.setPageUniqueId(this.mBdUniqueId);
        this.ijD = new e();
        this.ijD.i(this.mBdUniqueId);
        this.ijE.b(this.ijD);
        this.fek = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aWq();
    }

    public void init() {
        this.Vw.addOnScrollListener(this.mScrollListener);
        this.Vw.setRecyclerListener(this.mRecyclerListener);
        this.hWN.a(this.ibs);
        this.hWN.a(this.ibt);
        this.hWN.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dzH.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dzH);
        this.hoH.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hoH);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fkQ == null) {
                this.fkQ = new g(this.mPageContext.getPageActivity());
                this.fkQ.onChangeSkinType();
            }
            this.fkQ.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fkQ == null) {
            return false;
        }
        return this.fkQ.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this.mRootView);
        }
    }

    public void bqJ() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.Vw.setNextPage(this.fbY);
            }
            this.fbY.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fbY.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.fbY.setOnClickListener(null);
            this.fbY.endLoadData();
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.Vw.setNextPage(this.fbY);
            }
            this.fbY.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fbY.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.fbY.setOnClickListener(onClickListener);
            this.fbY.endLoadData();
        }
    }

    public void bqK() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.Vw.setNextPage(this.fbY);
            }
            this.fbY.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fbY.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fbY.setOnClickListener(null);
            this.fbY.startLoadData();
        }
    }

    public void k(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.nt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.nv(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.nt(R.drawable.new_pic_emotion_03);
        this.mRefreshView.yx(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bqO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.hWW.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.hWW.c(eVar);
    }

    public void cgZ() {
        mX(false);
    }

    public void onPause() {
        if (this.ijE != null) {
            this.ijE.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void ces() {
        mX(true);
    }

    private void mX(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gWm != null) {
            this.gWm.qi(!z);
            ag cfA = cfA();
            if (cfA != null && cfA.rM() != null) {
                z2 = cfA.rM().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gWm.cfz();
                } else if (this.ibr) {
                    this.gWm.a(this.hoQ, this.faG, this.hpz, true);
                }
            }
        }
    }

    public void oj(boolean z) {
        this.ibr = z;
    }

    public void cfy() {
        if (this.gWm != null && this.ibr) {
            this.gWm.a(this.hoQ, this.faG, this.hpz, true);
        }
    }

    public void cfz() {
        if (this.gWm != null) {
            this.gWm.cfz();
        }
    }

    public void az(List<o> list) {
        if (this.ijE != null) {
            this.ijE.setData(list);
        }
        cfy();
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
        if (this.ijE != null) {
            return this.ijE.getDataList();
        }
        return null;
    }

    public void cfB() {
        az(new LinkedList());
    }

    public void cfx() {
        if (this.Vw != null) {
            this.Vw.setSelection(0);
        }
    }

    public void CZ() {
        if (this.ijE != null) {
            this.ijE.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.hWN != null) {
            this.hWN.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Vw != null) {
            this.Vw.setOnSrollToBottomListener(eVar);
        }
    }

    public void aWq() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fkQ != null) {
            this.fkQ.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fkQ.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.hWN != null) {
            this.hWN.changeSkin(skinType);
        }
        if (this.ijE != null) {
            this.ijE.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fkQ != null) {
            this.fkQ.release();
        }
        b((f.e) null);
        if (this.hWN != null) {
            this.hWN.release();
        }
        if (this.ijE != null) {
            this.ijE.onDestroy();
        }
        if (this.gWm != null) {
            this.gWm.destroy();
        }
        cfC();
        MessageManager.getInstance().unRegisterListener(this.hoH);
        MessageManager.getInstance().unRegisterListener(this.dzH);
    }

    private void cfC() {
        if (this.Vw != null) {
            this.Vw.removeOnScrollListener(this.mScrollListener);
            this.Vw.setRecyclerListener(null);
        }
        if (this.hWN != null) {
            this.hWN.a((f.d) null);
            this.hWN.a((f.b) null);
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
    public void cha() {
        if (a(this.Vw)) {
            oz(false);
        } else {
            oz(true);
        }
    }
}
