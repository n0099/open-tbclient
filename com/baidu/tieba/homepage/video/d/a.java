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
    private BdTypeRecyclerView XW;
    private PbListView gAi;
    private View gCD;
    private g gJn;
    private i iPi;
    private com.baidu.tieba.homepage.personalize.bigday.a jZQ;
    private BigdaySwipeRefreshLayout jZZ;
    private NEGFeedBackView.a kfk;
    private e krH;
    private com.baidu.tieba.homepage.video.a.a krI;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int jiq = 0;
    private int gyR = 0;
    private boolean mIsBackground = false;
    private boolean kfL = true;
    private boolean jja = false;
    private f.d kfM = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cQu();
        }
    };
    private f.b kfN = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.se(true);
            if (a.this.iPi != null && !a.this.mIsBackground && a.this.kfL) {
                a.this.iPi.b(a.this.jiq, a.this.gyR, a.this.jja, true);
            }
        }
    };
    private CustomMessageListener eKB = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.krI.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.kfL) {
                        a.this.iPi.b(a.this.jiq, a.this.gyR, a.this.jja, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener jhW = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cQv;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cQv = a.this.cQv()) != null && cQv.tj() != null) {
                    cQv.tj().b(new a.C0089a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.iPi != null) {
                    a.this.iPi.dt(view);
                }
                if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                    ((HomePageCardVideoViewHolder) view.getTag()).ctb().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int gCJ = -1;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.iPi != null && a.this.kfL) {
                a.this.iPi.a(a.this.jiq, a.this.gyR, a.this.jja, 1);
            }
            if (this.gCJ != i) {
                this.gCJ = i;
                if (this.gCJ == 1) {
                    a.this.sw(true);
                } else {
                    a.this.cSy();
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
            cC(i4, (i3 - i4) + 1);
        }

        private void cC(int i, int i2) {
            a.this.jiq = i;
            a.this.gyR = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadCardViewHolder cQv() {
        if (this.iPi == null || this.iPi.dzV() == null || !(this.iPi.dzV().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iPi.dzV().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kfk = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.XW.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.XW.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.iPi = new i(this.mPageContext, this.XW);
        this.iPi.Hn(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iPi.setUniqueId(this.mBdUniqueId);
        this.jZZ = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.jZQ = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jZZ.setProgressView(this.jZQ);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jZZ.setCustomDistances(i, i, i * 2);
        this.gAi = new PbListView(this.mPageContext.getPageActivity());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.transparent);
        this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize36);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.krI = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.XW);
        this.krI.b(this.kfk);
        this.krI.setPageUniqueId(this.mBdUniqueId);
        this.krH = new e();
        this.krH.i(this.mBdUniqueId);
        this.krI.b(this.krH);
        this.gCD = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bup();
    }

    public void init() {
        this.XW.addOnScrollListener(this.mScrollListener);
        this.XW.setRecyclerListener(this.mRecyclerListener);
        this.jZQ.a(this.kfM);
        this.jZQ.a(this.kfN);
        this.jZQ.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eKB.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eKB);
        this.jhW.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.jhW);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gJn == null) {
                this.gJn = new g(this.mPageContext.getPageActivity());
                this.gJn.onChangeSkinType();
            }
            this.gJn.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gJn == null) {
            return false;
        }
        return this.gJn.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this.mRootView);
        }
    }

    public void bRq() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.XW.setNextPage(this.gAi);
            }
            this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.gAi.setOnClickListener(null);
            this.gAi.endLoadData();
        }
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.XW.setNextPage(this.gAi);
            }
            this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.gAi.setOnClickListener(onClickListener);
            this.gAi.endLoadData();
        }
    }

    public void bRr() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.XW.setNextPage(this.gAi);
            }
            this.gAi.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAi.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gAi.setOnClickListener(null);
            this.gAi.startLoadData();
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.rn(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rp(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.rn(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Dm(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.jZZ.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.jZZ.c(eVar);
    }

    public void cSx() {
        qJ(false);
    }

    public void onPause() {
        if (this.krI != null) {
            this.krI.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cON() {
        qJ(true);
    }

    private void qJ(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iPi != null) {
            this.iPi.tN(!z);
            ThreadCardViewHolder cQv = cQv();
            if (cQv != null && cQv.tj() != null) {
                z2 = cQv.tj().b(new a.C0089a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iPi.cQu();
                } else if (this.kfL) {
                    this.iPi.b(this.jiq, this.gyR, this.jja, true);
                }
            }
        }
    }

    public void se(boolean z) {
        this.kfL = z;
    }

    public void cQt() {
        if (this.iPi != null && this.kfL) {
            this.iPi.b(this.jiq, this.gyR, this.jja, true);
        }
    }

    public void cQu() {
        if (this.iPi != null) {
            this.iPi.cQu();
        }
    }

    public void bn(List<n> list) {
        if (this.krI != null) {
            this.krI.setData(list);
        }
        cQt();
    }

    public void LX(String str) {
        List<Integer> b2 = b(str, this.XW);
        int intValue = b2.get(0).intValue();
        int intValue2 = b2.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.XW.p(intValue, intValue2);
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
                    if (bVar.bln() != null && bVar.bln().getTid().equals(str)) {
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
        if (this.krI != null) {
            return this.krI.getDataList();
        }
        return null;
    }

    public void cQw() {
        bn(new LinkedList());
    }

    public void cQs() {
        if (this.XW != null) {
            this.XW.setSelection(0);
        }
    }

    public void Kx() {
        if (this.krI != null) {
            this.krI.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jZQ != null) {
            this.jZQ.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.XW != null) {
            this.XW.setOnSrollToBottomListener(eVar);
        }
    }

    public void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gJn != null) {
            this.gJn.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gJn.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jZQ != null) {
            this.jZQ.changeSkin(skinType);
        }
        if (this.krI != null) {
            this.krI.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gJn != null) {
            this.gJn.release();
        }
        b((f.e) null);
        if (this.jZQ != null) {
            this.jZQ.release();
        }
        if (this.krI != null) {
            this.krI.onDestroy();
        }
        if (this.iPi != null) {
            this.iPi.destroy();
        }
        cQx();
        MessageManager.getInstance().unRegisterListener(this.jhW);
        MessageManager.getInstance().unRegisterListener(this.eKB);
    }

    private void cQx() {
        if (this.XW != null) {
            this.XW.removeOnScrollListener(this.mScrollListener);
            this.XW.setRecyclerListener(null);
        }
        if (this.jZQ != null) {
            this.jZQ.a((f.d) null);
            this.jZQ.a((f.b) null);
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
    public void cSy() {
        if (c(this.XW)) {
            sw(false);
        } else {
            sw(true);
        }
    }
}
