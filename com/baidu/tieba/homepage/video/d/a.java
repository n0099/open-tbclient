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
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
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
    private BdTypeRecyclerView VT;
    private g fBv;
    private PbListView fsC;
    private View fuQ;
    private i hoU;
    private e iHy;
    private com.baidu.tieba.homepage.video.a.a iHz;
    private com.baidu.tieba.homepage.personalize.bigday.a isd;
    private BigdaySwipeRefreshLayout ism;
    private NEGFeedBackView.a iwg;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int hHG = 0;
    private int frk = 0;
    private boolean mIsBackground = false;
    private boolean iwH = true;
    private boolean hIq = false;
    private f.d iwI = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cmG();
        }
    };
    private f.b iwJ = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.oZ(true);
            if (a.this.hoU != null && !a.this.mIsBackground && a.this.iwH) {
                a.this.hoU.a(a.this.hHG, a.this.frk, a.this.hIq, true);
            }
        }
    };
    private CustomMessageListener dMl = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iHz.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.iwH) {
                        a.this.hoU.a(a.this.hHG, a.this.frk, a.this.hIq, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hHn = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ak cmH;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cmH = a.this.cmH()) != null && cmH.sg() != null) {
                    cmH.sg().b(new a.C0096a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.hoU != null) {
                    a.this.hoU.cA(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bSs().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int fuW = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.hoU != null && a.this.iwH) {
                a.this.hoU.a(a.this.hHG, a.this.frk, a.this.hIq, 1);
            }
            if (this.fuW != i) {
                this.fuW = i;
                if (this.fuW == 1) {
                    a.this.po(true);
                } else {
                    a.this.cow();
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
            co(i3, (i4 - i3) + 1);
        }

        private void co(int i, int i2) {
            a.this.hHG = i;
            a.this.frk = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public ak cmH() {
        if (this.hoU == null || this.hoU.cYQ() == null || !(this.hoU.cYQ().getTag() instanceof ak)) {
            return null;
        }
        return (ak) this.hoU.cYQ().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iwg = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.VT = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.VT.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.hoU = new i(this.mPageContext, this.VT);
        this.hoU.Dl(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hoU.setUniqueId(this.mBdUniqueId);
        this.ism = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.isd = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.ism.setProgressView(this.isd);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.ism.setCustomDistances(i, i, i * 2);
        this.fsC = new PbListView(this.mPageContext.getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize36);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iHz = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.VT);
        this.iHz.b(this.iwg);
        this.iHz.setPageUniqueId(this.mBdUniqueId);
        this.iHy = new e();
        this.iHy.i(this.mBdUniqueId);
        this.iHz.b(this.iHy);
        this.fuQ = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bci();
    }

    public void init() {
        this.VT.addOnScrollListener(this.mScrollListener);
        this.VT.setRecyclerListener(this.mRecyclerListener);
        this.isd.a(this.iwI);
        this.isd.a(this.iwJ);
        this.isd.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dMl.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dMl);
        this.hHn.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hHn);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fBv == null) {
                this.fBv = new g(this.mPageContext.getPageActivity());
                this.fBv.onChangeSkinType();
            }
            this.fBv.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fBv == null) {
            return false;
        }
        return this.fBv.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.mRootView);
        }
    }

    public void bwS() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.VT.setNextPage(this.fsC);
            }
            this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.fsC.setOnClickListener(null);
            this.fsC.endLoadData();
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.VT.setNextPage(this.fsC);
            }
            this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.fsC.setOnClickListener(onClickListener);
            this.fsC.endLoadData();
        }
    }

    public void bwT() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.VT.setNextPage(this.fsC);
            }
            this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fsC.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fsC.setOnClickListener(null);
            this.fsC.startLoadData();
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.oi(R.drawable.new_pic_emotion_08);
        this.mRefreshView.ok(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.oi(R.drawable.new_pic_emotion_03);
        this.mRefreshView.zX(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.ism.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.ism.c(eVar);
    }

    public void cov() {
        nN(false);
    }

    public void onPause() {
        if (this.iHz != null) {
            this.iHz.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void clx() {
        nN(true);
    }

    private void nN(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hoU != null) {
            this.hoU.qZ(!z);
            ak cmH = cmH();
            if (cmH != null && cmH.sg() != null) {
                z2 = cmH.sg().b(new a.C0096a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hoU.cmG();
                } else if (this.iwH) {
                    this.hoU.a(this.hHG, this.frk, this.hIq, true);
                }
            }
        }
    }

    public void oZ(boolean z) {
        this.iwH = z;
    }

    public void cmF() {
        if (this.hoU != null && this.iwH) {
            this.hoU.a(this.hHG, this.frk, this.hIq, true);
        }
    }

    public void cmG() {
        if (this.hoU != null) {
            this.hoU.cmG();
        }
    }

    public void aK(List<q> list) {
        if (this.iHz != null) {
            this.iHz.setData(list);
        }
        cmF();
    }

    public void GQ(String str) {
        List<Integer> b = b(str, this.VT);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.VT.m(intValue, intValue2);
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
                    if (cVar.aTN() != null && cVar.aTN().getTid().equals(str)) {
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
        if (this.iHz != null) {
            return this.iHz.getDataList();
        }
        return null;
    }

    public void cmI() {
        aK(new LinkedList());
    }

    public void cmE() {
        if (this.VT != null) {
            this.VT.setSelection(0);
        }
    }

    public void DT() {
        if (this.iHz != null) {
            this.iHz.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.isd != null) {
            this.isd.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.VT != null) {
            this.VT.setOnSrollToBottomListener(eVar);
        }
    }

    public void bci() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fBv != null) {
            this.fBv.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fBv.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.isd != null) {
            this.isd.changeSkin(skinType);
        }
        if (this.iHz != null) {
            this.iHz.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fBv != null) {
            this.fBv.release();
        }
        b((f.e) null);
        if (this.isd != null) {
            this.isd.release();
        }
        if (this.iHz != null) {
            this.iHz.onDestroy();
        }
        if (this.hoU != null) {
            this.hoU.destroy();
        }
        cmJ();
        MessageManager.getInstance().unRegisterListener(this.hHn);
        MessageManager.getInstance().unRegisterListener(this.dMl);
    }

    private void cmJ() {
        if (this.VT != null) {
            this.VT.removeOnScrollListener(this.mScrollListener);
            this.VT.setRecyclerListener(null);
        }
        if (this.isd != null) {
            this.isd.a((f.d) null);
            this.isd.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void po(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cow() {
        if (a(this.VT)) {
            po(false);
        } else {
            po(true);
        }
    }
}
