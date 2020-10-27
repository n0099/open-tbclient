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
    private PbListView gdy;
    private View gfU;
    private g gmB;
    private i iko;
    private e jGH;
    private com.baidu.tieba.homepage.video.a.a jGI;
    private BigdaySwipeRefreshLayout jpF;
    private com.baidu.tieba.homepage.personalize.bigday.a jpw;
    private NEGFeedBackView.a juC;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int iDz = 0;
    private int gch = 0;
    private boolean mIsBackground = false;
    private boolean jvd = true;
    private boolean iEj = false;
    private f.d jve = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cHM();
        }
    };
    private f.b jvf = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.qM(true);
            if (a.this.iko != null && !a.this.mIsBackground && a.this.jvd) {
                a.this.iko.a(a.this.iDz, a.this.gch, a.this.iEj, true);
            }
        }
    };
    private CustomMessageListener esj = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jGI.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.jvd) {
                        a.this.iko.a(a.this.iDz, a.this.gch, a.this.iEj, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iDg = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cHN;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cHN = a.this.cHN()) != null && cHN.tW() != null) {
                    cHN.tW().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.iko != null) {
                    a.this.iko.cV(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                    ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).cmx().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int gga = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.iko != null && a.this.jvd) {
                a.this.iko.a(a.this.iDz, a.this.gch, a.this.iEj, 1);
            }
            if (this.gga != i) {
                this.gga = i;
                if (this.gga == 1) {
                    a.this.rc(true);
                } else {
                    a.this.cJN();
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
            cB(i3, (i4 - i3) + 1);
        }

        private void cB(int i, int i2) {
            a.this.iDz = i;
            a.this.gch = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public am cHN() {
        if (this.iko == null || this.iko.duu() == null || !(this.iko.duu().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iko.duu().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.juC = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.iko = new i(this.mPageContext, this.Xe);
        this.iko.Hg(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iko.setUniqueId(this.mBdUniqueId);
        this.jpF = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.jpw = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jpF.setProgressView(this.jpw);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jpF.setCustomDistances(i, i, i * 2);
        this.gdy = new PbListView(this.mPageContext.getPageActivity());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize36);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jGI = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Xe);
        this.jGI.b(this.juC);
        this.jGI.setPageUniqueId(this.mBdUniqueId);
        this.jGH = new e();
        this.jGH.i(this.mBdUniqueId);
        this.jGI.b(this.jGH);
        this.gfU = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bqd();
    }

    public void init() {
        this.Xe.addOnScrollListener(this.mScrollListener);
        this.Xe.setRecyclerListener(this.mRecyclerListener);
        this.jpw.a(this.jve);
        this.jpw.a(this.jvf);
        this.jpw.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.esj.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.esj);
        this.iDg.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iDg);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gmB == null) {
                this.gmB = new g(this.mPageContext.getPageActivity());
                this.gmB.onChangeSkinType();
            }
            this.gmB.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gmB == null) {
            return false;
        }
        return this.gmB.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this.mRootView);
        }
    }

    public void bMw() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.Xe.setNextPage(this.gdy);
            }
            this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gdy.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.gdy.setOnClickListener(null);
            this.gdy.endLoadData();
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.Xe.setNextPage(this.gdy);
            }
            this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gdy.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.gdy.setOnClickListener(onClickListener);
            this.gdy.endLoadData();
        }
    }

    public void bMx() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.Xe.setNextPage(this.gdy);
            }
            this.gdy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gdy.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gdy.setOnClickListener(null);
            this.gdy.startLoadData();
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.rt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rv(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.rt(R.drawable.new_pic_emotion_03);
        this.mRefreshView.DP(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.jpF.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.jpF.c(eVar);
    }

    public void cJM() {
        pw(false);
    }

    public void onPause() {
        if (this.jGI != null) {
            this.jGI.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cGf() {
        pw(true);
    }

    private void pw(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iko != null) {
            this.iko.sO(!z);
            am cHN = cHN();
            if (cHN != null && cHN.tW() != null) {
                z2 = cHN.tW().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iko.cHM();
                } else if (this.jvd) {
                    this.iko.a(this.iDz, this.gch, this.iEj, true);
                }
            }
        }
    }

    public void qM(boolean z) {
        this.jvd = z;
    }

    public void cHL() {
        if (this.iko != null && this.jvd) {
            this.iko.a(this.iDz, this.gch, this.iEj, true);
        }
    }

    public void cHM() {
        if (this.iko != null) {
            this.iko.cHM();
        }
    }

    public void bb(List<q> list) {
        if (this.jGI != null) {
            this.jGI.setData(list);
        }
        cHL();
    }

    public void Lw(String str) {
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
                    if (cVar.bhz() != null && cVar.bhz().getTid().equals(str)) {
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
        if (this.jGI != null) {
            return this.jGI.getDataList();
        }
        return null;
    }

    public void cHO() {
        bb(new LinkedList());
    }

    public void cHK() {
        if (this.Xe != null) {
            this.Xe.setSelection(0);
        }
    }

    public void Lz() {
        if (this.jGI != null) {
            this.jGI.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jpw != null) {
            this.jpw.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Xe != null) {
            this.Xe.setOnSrollToBottomListener(eVar);
        }
    }

    public void bqd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gmB != null) {
            this.gmB.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gmB.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jpw != null) {
            this.jpw.changeSkin(skinType);
        }
        if (this.jGI != null) {
            this.jGI.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gmB != null) {
            this.gmB.release();
        }
        b((f.e) null);
        if (this.jpw != null) {
            this.jpw.release();
        }
        if (this.jGI != null) {
            this.jGI.onDestroy();
        }
        if (this.iko != null) {
            this.iko.destroy();
        }
        cHP();
        MessageManager.getInstance().unRegisterListener(this.iDg);
        MessageManager.getInstance().unRegisterListener(this.esj);
    }

    private void cHP() {
        if (this.Xe != null) {
            this.Xe.removeOnScrollListener(this.mScrollListener);
            this.Xe.setRecyclerListener(null);
        }
        if (this.jpw != null) {
            this.jpw.a((f.d) null);
            this.jpw.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJN() {
        if (a(this.Xe)) {
            rc(false);
        } else {
            rc(true);
        }
    }
}
