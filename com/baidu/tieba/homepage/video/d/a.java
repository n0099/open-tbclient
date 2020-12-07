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
import com.baidu.tbadk.a.d;
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
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.model.e;
import com.baidu.tieba.play.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Yf;
    private g gAe;
    private PbListView gre;
    private View gtz;
    private i iBT;
    private com.baidu.tieba.homepage.personalize.bigday.a jJG;
    private BigdaySwipeRefreshLayout jJP;
    private NEGFeedBackView.a jOX;
    private e kaS;
    private com.baidu.tieba.homepage.video.a.a kaT;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int iVc = 0;
    private int gpN = 0;
    private boolean mIsBackground = false;
    private boolean jPy = true;
    private boolean iVM = false;
    private f.d jPz = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cPh();
        }
    };
    private f.b jPA = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.rz(true);
            if (a.this.iBT != null && !a.this.mIsBackground && a.this.jPy) {
                a.this.iBT.a(a.this.iVc, a.this.gpN, a.this.iVM, true);
            }
        }
    };
    private CustomMessageListener eDt = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kaT.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.jPy) {
                        a.this.iBT.a(a.this.iVc, a.this.gpN, a.this.iVM, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cPi;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cPi = a.this.cPi()) != null && cPi.tZ() != null) {
                    cPi.tZ().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.iBT != null) {
                    a.this.iBT.dl(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                    ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).csM().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int gtF = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.iBT != null && a.this.jPy) {
                a.this.iBT.a(a.this.iVc, a.this.gpN, a.this.iVM, 1);
            }
            if (this.gtF != i) {
                this.gtF = i;
                if (this.gtF == 1) {
                    a.this.rQ(true);
                } else {
                    a.this.cRj();
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
            cI(i3, (i4 - i3) + 1);
        }

        private void cI(int i, int i2) {
            a.this.iVc = i;
            a.this.gpN = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public am cPi() {
        if (this.iBT == null || this.iBT.dBO() == null || !(this.iBT.dBO().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iBT.dBO().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jOX = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        if (!d.bkA()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.Yf.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        this.iBT = new i(this.mPageContext, this.Yf);
        this.iBT.II(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iBT.setUniqueId(this.mBdUniqueId);
        this.jJP = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.jJG = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jJP.setProgressView(this.jJG);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jJP.setCustomDistances(i, i, i * 2);
        this.gre = new PbListView(this.mPageContext.getPageActivity());
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.transparent);
        this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize36);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.kaT = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Yf);
        this.kaT.b(this.jOX);
        this.kaT.setPageUniqueId(this.mBdUniqueId);
        this.kaS = new e();
        this.kaS.i(this.mBdUniqueId);
        this.kaT.b(this.kaS);
        this.gtz = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bvt();
    }

    public void init() {
        this.Yf.addOnScrollListener(this.mScrollListener);
        this.Yf.setRecyclerListener(this.mRecyclerListener);
        this.jJG.a(this.jPz);
        this.jJG.a(this.jPA);
        this.jJG.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eDt.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eDt);
        this.iUJ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iUJ);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gAe == null) {
                this.gAe = new g(this.mPageContext.getPageActivity());
                this.gAe.onChangeSkinType();
            }
            this.gAe.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gAe == null) {
            return false;
        }
        return this.gAe.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this.mRootView);
        }
    }

    public void bSa() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.Yf.setNextPage(this.gre);
            }
            this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gre.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.gre.setOnClickListener(null);
            this.gre.endLoadData();
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.Yf.setNextPage(this.gre);
            }
            this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gre.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.gre.setOnClickListener(onClickListener);
            this.gre.endLoadData();
        }
    }

    public void bSb() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.Yf.setNextPage(this.gre);
            }
            this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gre.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gre.setOnClickListener(null);
            this.gre.startLoadData();
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.sC(R.drawable.new_pic_emotion_08);
        this.mRefreshView.sE(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.sC(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Ek(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.jJP.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.jJP.c(eVar);
    }

    public void cRi() {
        qf(false);
    }

    public void onPause() {
        if (this.kaT != null) {
            this.kaT.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cNA() {
        qf(true);
    }

    private void qf(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iBT != null) {
            this.iBT.tC(!z);
            am cPi = cPi();
            if (cPi != null && cPi.tZ() != null) {
                z2 = cPi.tZ().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iBT.cPh();
                } else if (this.jPy) {
                    this.iBT.a(this.iVc, this.gpN, this.iVM, true);
                }
            }
        }
    }

    public void rz(boolean z) {
        this.jPy = z;
    }

    public void cPg() {
        if (this.iBT != null && this.jPy) {
            this.iBT.a(this.iVc, this.gpN, this.iVM, true);
        }
    }

    public void cPh() {
        if (this.iBT != null) {
            this.iBT.cPh();
        }
    }

    public void bl(List<q> list) {
        if (this.kaT != null) {
            this.kaT.setData(list);
        }
        cPg();
    }

    public void Mv(String str) {
        List<Integer> b = b(str, this.Yf);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Yf.p(intValue, intValue2);
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
                if (item instanceof b) {
                    b bVar = (b) item;
                    if (bVar.bmn() != null && bVar.bmn().getTid().equals(str)) {
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
        if (this.kaT != null) {
            return this.kaT.getDataList();
        }
        return null;
    }

    public void cPj() {
        bl(new LinkedList());
    }

    public void cPf() {
        if (this.Yf != null) {
            this.Yf.setSelection(0);
        }
    }

    public void Nv() {
        if (this.kaT != null) {
            this.kaT.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jJG != null) {
            this.jJG.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Yf != null) {
            this.Yf.setOnSrollToBottomListener(eVar);
        }
    }

    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gAe != null) {
            this.gAe.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gAe.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jJG != null) {
            this.jJG.changeSkin(skinType);
        }
        if (this.kaT != null) {
            this.kaT.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gAe != null) {
            this.gAe.release();
        }
        b((f.e) null);
        if (this.jJG != null) {
            this.jJG.release();
        }
        if (this.kaT != null) {
            this.kaT.onDestroy();
        }
        if (this.iBT != null) {
            this.iBT.destroy();
        }
        cPk();
        MessageManager.getInstance().unRegisterListener(this.iUJ);
        MessageManager.getInstance().unRegisterListener(this.eDt);
    }

    private void cPk() {
        if (this.Yf != null) {
            this.Yf.removeOnScrollListener(this.mScrollListener);
            this.Yf.setRecyclerListener(null);
        }
        if (this.jJG != null) {
            this.jJG.a((f.d) null);
            this.jJG.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRj() {
        if (a(this.Yf)) {
            rQ(false);
        } else {
            rQ(true);
        }
    }
}
