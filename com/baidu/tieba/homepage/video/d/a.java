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
import com.baidu.tbadk.core.util.ao;
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
    private BdTypeRecyclerView Yc;
    private PbListView gCf;
    private View gEA;
    private g gLj;
    private i iOh;
    private com.baidu.tieba.homepage.personalize.bigday.a jWU;
    private BigdaySwipeRefreshLayout jXd;
    private NEGFeedBackView.a kcn;
    private e kof;
    private com.baidu.tieba.homepage.video.a.a kog;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int jhq = 0;
    private int gAO = 0;
    private boolean mIsBackground = false;
    private boolean kcO = true;
    private boolean jia = false;
    private f.d kcP = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cSp();
        }
    };
    private f.b kcQ = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.rW(true);
            if (a.this.iOh != null && !a.this.mIsBackground && a.this.kcO) {
                a.this.iOh.b(a.this.jhq, a.this.gAO, a.this.jia, true);
            }
        }
    };
    private CustomMessageListener eNg = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kog.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.kcO) {
                        a.this.iOh.b(a.this.jhq, a.this.gAO, a.this.jia, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener jgX = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cSq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cSq = a.this.cSq()) != null && cSq.ty() != null) {
                    cSq.ty().b(new a.C0090a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.iOh != null) {
                    a.this.iOh.dv(view);
                }
                if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                    ((HomePageCardVideoViewHolder) view.getTag()).cvH().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int gEG = -1;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.iOh != null && a.this.kcO) {
                a.this.iOh.a(a.this.jhq, a.this.gAO, a.this.jia, 1);
            }
            if (this.gEG != i) {
                this.gEG = i;
                if (this.gEG == 1) {
                    a.this.sn(true);
                } else {
                    a.this.cUr();
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
            cF(i4, (i3 - i4) + 1);
        }

        private void cF(int i, int i2) {
            a.this.jhq = i;
            a.this.gAO = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadCardViewHolder cSq() {
        if (this.iOh == null || this.iOh.dBF() == null || !(this.iOh.dBF().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iOh.dBF().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kcn = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Yc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Yc.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Yc.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.iOh = new i(this.mPageContext, this.Yc);
        this.iOh.IC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iOh.setUniqueId(this.mBdUniqueId);
        this.jXd = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.jWU = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jXd.setProgressView(this.jWU);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jXd.setCustomDistances(i, i, i * 2);
        this.gCf = new PbListView(this.mPageContext.getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize36);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.kog = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Yc);
        this.kog.b(this.kcn);
        this.kog.setPageUniqueId(this.mBdUniqueId);
        this.kof = new e();
        this.kof.i(this.mBdUniqueId);
        this.kog.b(this.kof);
        this.gEA = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bxP();
    }

    public void init() {
        this.Yc.addOnScrollListener(this.mScrollListener);
        this.Yc.setRecyclerListener(this.mRecyclerListener);
        this.jWU.a(this.kcP);
        this.jWU.a(this.kcQ);
        this.jWU.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eNg.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eNg);
        this.jgX.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.jgX);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gLj == null) {
                this.gLj = new g(this.mPageContext.getPageActivity());
                this.gLj.onChangeSkinType();
            }
            this.gLj.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gLj == null) {
            return false;
        }
        return this.gLj.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.mRootView);
        }
    }

    public void bUE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yc.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.gCf.setOnClickListener(null);
            this.gCf.endLoadData();
        }
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yc.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gCf.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.gCf.setOnClickListener(onClickListener);
            this.gCf.endLoadData();
        }
    }

    public void bUF() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yc.setNextPage(this.gCf);
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
        this.mRefreshView.sO(R.drawable.new_pic_emotion_08);
        this.mRefreshView.sQ(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.sO(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Eg(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void Zj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.jXd.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.jXd.c(eVar);
    }

    public void cUq() {
        qD(false);
    }

    public void onPause() {
        if (this.kog != null) {
            this.kog.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cQI() {
        qD(true);
    }

    private void qD(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iOh != null) {
            this.iOh.tE(!z);
            ThreadCardViewHolder cSq = cSq();
            if (cSq != null && cSq.ty() != null) {
                z2 = cSq.ty().b(new a.C0090a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iOh.cSp();
                } else if (this.kcO) {
                    this.iOh.b(this.jhq, this.gAO, this.jia, true);
                }
            }
        }
    }

    public void rW(boolean z) {
        this.kcO = z;
    }

    public void cSo() {
        if (this.iOh != null && this.kcO) {
            this.iOh.b(this.jhq, this.gAO, this.jia, true);
        }
    }

    public void cSp() {
        if (this.iOh != null) {
            this.iOh.cSp();
        }
    }

    public void bs(List<n> list) {
        if (this.kog != null) {
            this.kog.setData(list);
        }
        cSo();
    }

    public void Mu(String str) {
        List<Integer> b2 = b(str, this.Yc);
        int intValue = b2.get(0).intValue();
        int intValue2 = b2.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Yc.p(intValue, intValue2);
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
                    if (bVar.boP() != null && bVar.boP().getTid().equals(str)) {
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
        if (this.kog != null) {
            return this.kog.getDataList();
        }
        return null;
    }

    public void cSr() {
        bs(new LinkedList());
    }

    public void cSn() {
        if (this.Yc != null) {
            this.Yc.setSelection(0);
        }
    }

    public void MU() {
        if (this.kog != null) {
            this.kog.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jWU != null) {
            this.jWU.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Yc != null) {
            this.Yc.setOnSrollToBottomListener(eVar);
        }
    }

    public void bxP() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gLj != null) {
            this.gLj.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gLj.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jWU != null) {
            this.jWU.changeSkin(skinType);
        }
        if (this.kog != null) {
            this.kog.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gLj != null) {
            this.gLj.release();
        }
        b((f.e) null);
        if (this.jWU != null) {
            this.jWU.release();
        }
        if (this.kog != null) {
            this.kog.onDestroy();
        }
        if (this.iOh != null) {
            this.iOh.destroy();
        }
        cSs();
        MessageManager.getInstance().unRegisterListener(this.jgX);
        MessageManager.getInstance().unRegisterListener(this.eNg);
    }

    private void cSs() {
        if (this.Yc != null) {
            this.Yc.removeOnScrollListener(this.mScrollListener);
            this.Yc.setRecyclerListener(null);
        }
        if (this.jWU != null) {
            this.jWU.a((f.d) null);
            this.jWU.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUr() {
        if (c(this.Yc)) {
            sn(false);
        } else {
            sn(true);
        }
    }
}
