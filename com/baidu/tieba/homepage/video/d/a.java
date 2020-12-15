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
    private g gAg;
    private PbListView grg;
    private View gtB;
    private i iBV;
    private com.baidu.tieba.homepage.personalize.bigday.a jJI;
    private BigdaySwipeRefreshLayout jJR;
    private NEGFeedBackView.a jOZ;
    private e kaU;
    private com.baidu.tieba.homepage.video.a.a kaV;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int iVe = 0;
    private int gpP = 0;
    private boolean mIsBackground = false;
    private boolean jPA = true;
    private boolean iVO = false;
    private f.d jPB = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cPi();
        }
    };
    private f.b jPC = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.rz(true);
            if (a.this.iBV != null && !a.this.mIsBackground && a.this.jPA) {
                a.this.iBV.a(a.this.iVe, a.this.gpP, a.this.iVO, true);
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
                    a.this.kaV.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.jPA) {
                        a.this.iBV.a(a.this.iVe, a.this.gpP, a.this.iVO, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iUL = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cPj;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cPj = a.this.cPj()) != null && cPj.tZ() != null) {
                    cPj.tZ().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.iBV != null) {
                    a.this.iBV.dl(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                    ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).csN().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int gtH = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.iBV != null && a.this.jPA) {
                a.this.iBV.a(a.this.iVe, a.this.gpP, a.this.iVO, 1);
            }
            if (this.gtH != i) {
                this.gtH = i;
                if (this.gtH == 1) {
                    a.this.rQ(true);
                } else {
                    a.this.cRk();
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
            a.this.iVe = i;
            a.this.gpP = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public am cPj() {
        if (this.iBV == null || this.iBV.dBP() == null || !(this.iBV.dBP().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iBV.dBP().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jOZ = aVar;
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
        this.iBV = new i(this.mPageContext, this.Yf);
        this.iBV.II(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iBV.setUniqueId(this.mBdUniqueId);
        this.jJR = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.jJI = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jJR.setProgressView(this.jJI);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jJR.setCustomDistances(i, i, i * 2);
        this.grg = new PbListView(this.mPageContext.getPageActivity());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.transparent);
        this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize36);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.kaV = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Yf);
        this.kaV.b(this.jOZ);
        this.kaV.setPageUniqueId(this.mBdUniqueId);
        this.kaU = new e();
        this.kaU.i(this.mBdUniqueId);
        this.kaV.b(this.kaU);
        this.gtB = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bvt();
    }

    public void init() {
        this.Yf.addOnScrollListener(this.mScrollListener);
        this.Yf.setRecyclerListener(this.mRecyclerListener);
        this.jJI.a(this.jPB);
        this.jJI.a(this.jPC);
        this.jJI.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eDt.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eDt);
        this.iUL.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iUL);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gAg == null) {
                this.gAg = new g(this.mPageContext.getPageActivity());
                this.gAg.onChangeSkinType();
            }
            this.gAg.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gAg == null) {
            return false;
        }
        return this.gAg.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this.mRootView);
        }
    }

    public void bSb() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.Yf.setNextPage(this.grg);
            }
            this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.grg.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.grg.setOnClickListener(null);
            this.grg.endLoadData();
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.Yf.setNextPage(this.grg);
            }
            this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.grg.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.grg.setOnClickListener(onClickListener);
            this.grg.endLoadData();
        }
    }

    public void bSc() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.Yf.setNextPage(this.grg);
            }
            this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.grg.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.grg.setOnClickListener(null);
            this.grg.startLoadData();
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
        this.jJR.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.jJR.c(eVar);
    }

    public void cRj() {
        qf(false);
    }

    public void onPause() {
        if (this.kaV != null) {
            this.kaV.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cNB() {
        qf(true);
    }

    private void qf(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iBV != null) {
            this.iBV.tC(!z);
            am cPj = cPj();
            if (cPj != null && cPj.tZ() != null) {
                z2 = cPj.tZ().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iBV.cPi();
                } else if (this.jPA) {
                    this.iBV.a(this.iVe, this.gpP, this.iVO, true);
                }
            }
        }
    }

    public void rz(boolean z) {
        this.jPA = z;
    }

    public void cPh() {
        if (this.iBV != null && this.jPA) {
            this.iBV.a(this.iVe, this.gpP, this.iVO, true);
        }
    }

    public void cPi() {
        if (this.iBV != null) {
            this.iBV.cPi();
        }
    }

    public void bl(List<q> list) {
        if (this.kaV != null) {
            this.kaV.setData(list);
        }
        cPh();
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
        if (this.kaV != null) {
            return this.kaV.getDataList();
        }
        return null;
    }

    public void cPk() {
        bl(new LinkedList());
    }

    public void cPg() {
        if (this.Yf != null) {
            this.Yf.setSelection(0);
        }
    }

    public void Nv() {
        if (this.kaV != null) {
            this.kaV.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jJI != null) {
            this.jJI.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Yf != null) {
            this.Yf.setOnSrollToBottomListener(eVar);
        }
    }

    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gAg != null) {
            this.gAg.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gAg.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jJI != null) {
            this.jJI.changeSkin(skinType);
        }
        if (this.kaV != null) {
            this.kaV.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gAg != null) {
            this.gAg.release();
        }
        b((f.e) null);
        if (this.jJI != null) {
            this.jJI.release();
        }
        if (this.kaV != null) {
            this.kaV.onDestroy();
        }
        if (this.iBV != null) {
            this.iBV.destroy();
        }
        cPl();
        MessageManager.getInstance().unRegisterListener(this.iUL);
        MessageManager.getInstance().unRegisterListener(this.eDt);
    }

    private void cPl() {
        if (this.Yf != null) {
            this.Yf.removeOnScrollListener(this.mScrollListener);
            this.Yf.setRecyclerListener(null);
        }
        if (this.jJI != null) {
            this.jJI.a((f.d) null);
            this.jJI.a((f.b) null);
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
    public void cRk() {
        if (a(this.Yf)) {
            rQ(false);
        } else {
            rQ(true);
        }
    }
}
