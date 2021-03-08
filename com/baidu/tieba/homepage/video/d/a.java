package com.baidu.tieba.homepage.video.d;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.model.e;
import com.baidu.tieba.play.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Zq;
    private PbListView gCf;
    private View gEA;
    private g gLk;
    private i iRf;
    private com.baidu.tieba.homepage.personalize.bigday.a kcg;
    private BigdaySwipeRefreshLayout kcp;
    private NEGFeedBackView.a khA;
    private e ktX;
    private com.baidu.tieba.homepage.video.a.a ktY;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int jkn = 0;
    private int gAO = 0;
    private boolean mIsBackground = false;
    private boolean kib = true;
    private boolean jkX = false;
    private f.d kic = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cQI();
        }
    };
    private f.b kie = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.se(true);
            if (a.this.iRf != null && !a.this.mIsBackground && a.this.kib) {
                a.this.iRf.b(a.this.jkn, a.this.gAO, a.this.jkX, true);
            }
        }
    };
    private CustomMessageListener eMc = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ktY.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.kib) {
                        a.this.iRf.b(a.this.jkn, a.this.gAO, a.this.jkX, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener jjU = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cQJ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cQJ = a.this.cQJ()) != null && cQJ.tj() != null) {
                    cQJ.tj().b(new a.C0095a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.iRf != null) {
                    a.this.iRf.dt(view);
                }
                if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                    ((HomePageCardVideoViewHolder) view.getTag()).cto().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int gEG = -1;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.iRf != null && a.this.kib) {
                a.this.iRf.a(a.this.jkn, a.this.gAO, a.this.jkX, 1);
            }
            if (this.gEG != i) {
                this.gEG = i;
                if (this.gEG == 1) {
                    a.this.sw(true);
                } else {
                    a.this.cSM();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4;
            if (recyclerView instanceof BdRecyclerView) {
                int firstVisiblePosition = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i3 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
                i4 = firstVisiblePosition;
            } else {
                i3 = 0;
                i4 = 0;
            }
            cD(i4, (i3 - i4) + 1);
        }

        private void cD(int i, int i2) {
            a.this.jkn = i;
            a.this.gAO = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadCardViewHolder cQJ() {
        if (this.iRf == null || this.iRf.dAk() == null || !(this.iRf.dAk().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iRf.dAk().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.khA = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Zq = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Zq.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Zq.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.iRf = new i(this.mPageContext, this.Zq);
        this.iRf.Hq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iRf.setUniqueId(this.mBdUniqueId);
        this.kcp = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.kcg = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.kcp.setProgressView(this.kcg);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.kcp.setCustomDistances(i, i, i * 2);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize36);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ktY = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Zq);
        this.ktY.b(this.khA);
        this.ktY.setPageUniqueId(this.mBdUniqueId);
        this.ktX = new e();
        this.ktX.i(this.mBdUniqueId);
        this.ktY.b(this.ktX);
        this.gEA = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bus();
    }

    public void init() {
        this.Zq.addOnScrollListener(this.mScrollListener);
        this.Zq.setRecyclerListener(this.mRecyclerListener);
        this.kcg.a(this.kic);
        this.kcg.a(this.kie);
        this.kcg.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eMc.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eMc);
        this.jjU.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.jjU);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gLk == null) {
                this.gLk = new g(this.mPageContext.getPageActivity());
                this.gLk.onChangeSkinType();
            }
            this.gLk.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gLk == null) {
            return false;
        }
        return this.gLk.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this.mRootView);
        }
    }

    public void bRD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Zq.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.gCf.setOnClickListener(null);
            this.gCf.endLoadData();
        }
    }

    public void F(View.OnClickListener onClickListener) {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Zq.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.gCf.setOnClickListener(onClickListener);
            this.gCf.endLoadData();
        }
    }

    public void bRE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Zq.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gCf.setOnClickListener(null);
            this.gCf.startLoadData();
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.ro(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rq(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.ro(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Dr(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.kcp.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.kcp.c(eVar);
    }

    public void cSL() {
        qJ(false);
    }

    public void onPause() {
        if (this.ktY != null) {
            this.ktY.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cPb() {
        qJ(true);
    }

    private void qJ(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iRf != null) {
            this.iRf.tN(!z);
            ThreadCardViewHolder cQJ = cQJ();
            if (cQJ != null && cQJ.tj() != null) {
                z2 = cQJ.tj().b(new a.C0095a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iRf.cQI();
                } else if (this.kib) {
                    this.iRf.b(this.jkn, this.gAO, this.jkX, true);
                }
            }
        }
    }

    public void se(boolean z) {
        this.kib = z;
    }

    public void cQH() {
        if (this.iRf != null && this.kib) {
            this.iRf.b(this.jkn, this.gAO, this.jkX, true);
        }
    }

    public void cQI() {
        if (this.iRf != null) {
            this.iRf.cQI();
        }
    }

    public void bn(List<n> list) {
        if (this.ktY != null) {
            this.ktY.setData(list);
        }
        cQH();
    }

    public void Me(String str) {
        List<Integer> b = b(str, this.Zq);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Zq.p(intValue, intValue2);
        }
    }

    private List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = -1;
        ArrayList arrayList = new ArrayList(2);
        int i2 = 0;
        boolean z = false;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i2 < bdTypeRecyclerView.getCount()) {
                n item = bdTypeRecyclerView.getItem(i2);
                if (item instanceof b) {
                    b bVar = (b) item;
                    if (bVar.blp() != null && bVar.blp().getTid().equals(str)) {
                        if (!z) {
                            i4 = i2;
                        }
                        z = true;
                        i3 = i2;
                    }
                }
                i = i4;
                i2++;
            } else {
                arrayList.add(Integer.valueOf(i4));
                arrayList.add(Integer.valueOf(i3));
                return arrayList;
            }
        }
    }

    public List<n> getDataList() {
        if (this.ktY != null) {
            return this.ktY.getDataList();
        }
        return null;
    }

    public void cQK() {
        bn(new LinkedList());
    }

    public void cQG() {
        if (this.Zq != null) {
            this.Zq.setSelection(0);
        }
    }

    public void KA() {
        if (this.ktY != null) {
            this.ktY.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.kcg != null) {
            this.kcg.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Zq != null) {
            this.Zq.setOnSrollToBottomListener(eVar);
        }
    }

    public void bus() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gLk != null) {
            this.gLk.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gLk.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.kcg != null) {
            this.kcg.changeSkin(skinType);
        }
        if (this.ktY != null) {
            this.ktY.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gLk != null) {
            this.gLk.release();
        }
        b((f.e) null);
        if (this.kcg != null) {
            this.kcg.release();
        }
        if (this.ktY != null) {
            this.ktY.onDestroy();
        }
        if (this.iRf != null) {
            this.iRf.destroy();
        }
        cQL();
        MessageManager.getInstance().unRegisterListener(this.jjU);
        MessageManager.getInstance().unRegisterListener(this.eMc);
    }

    private void cQL() {
        if (this.Zq != null) {
            this.Zq.removeOnScrollListener(this.mScrollListener);
            this.Zq.setRecyclerListener(null);
        }
        if (this.kcg != null) {
            this.kcg.a((f.d) null);
            this.kcg.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sw(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSM() {
        if (c(this.Zq)) {
            sw(false);
        } else {
            sw(true);
        }
    }
}
