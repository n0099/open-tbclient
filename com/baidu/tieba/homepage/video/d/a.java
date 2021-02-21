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
    private PbListView gAw;
    private View gCR;
    private g gJB;
    private i iPw;
    private com.baidu.tieba.homepage.personalize.bigday.a kae;
    private BigdaySwipeRefreshLayout kan;
    private NEGFeedBackView.a kfy;
    private e krV;
    private com.baidu.tieba.homepage.video.a.a krW;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int jiE = 0;
    private int gzf = 0;
    private boolean mIsBackground = false;
    private boolean kfZ = true;
    private boolean jjo = false;
    private f.d kga = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cQB();
        }
    };
    private f.b kgb = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.se(true);
            if (a.this.iPw != null && !a.this.mIsBackground && a.this.kfZ) {
                a.this.iPw.b(a.this.jiE, a.this.gzf, a.this.jjo, true);
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
                    a.this.krW.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.kfZ) {
                        a.this.iPw.b(a.this.jiE, a.this.gzf, a.this.jjo, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener jil = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cQC;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cQC = a.this.cQC()) != null && cQC.tj() != null) {
                    cQC.tj().b(new a.C0089a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.iPw != null) {
                    a.this.iPw.dt(view);
                }
                if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                    ((HomePageCardVideoViewHolder) view.getTag()).cti().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int gCX = -1;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.iPw != null && a.this.kfZ) {
                a.this.iPw.a(a.this.jiE, a.this.gzf, a.this.jjo, 1);
            }
            if (this.gCX != i) {
                this.gCX = i;
                if (this.gCX == 1) {
                    a.this.sw(true);
                } else {
                    a.this.cSF();
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
            a.this.jiE = i;
            a.this.gzf = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadCardViewHolder cQC() {
        if (this.iPw == null || this.iPw.dAc() == null || !(this.iPw.dAc().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iPw.dAc().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.kfy = aVar;
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
        this.iPw = new i(this.mPageContext, this.XW);
        this.iPw.Hn(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iPw.setUniqueId(this.mBdUniqueId);
        this.kan = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.kae = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.kan.setProgressView(this.kae);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.kan.setCustomDistances(i, i, i * 2);
        this.gAw = new PbListView(this.mPageContext.getPageActivity());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.transparent);
        this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize36);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.krW = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.XW);
        this.krW.b(this.kfy);
        this.krW.setPageUniqueId(this.mBdUniqueId);
        this.krV = new e();
        this.krV.i(this.mBdUniqueId);
        this.krW.b(this.krV);
        this.gCR = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        bup();
    }

    public void init() {
        this.XW.addOnScrollListener(this.mScrollListener);
        this.XW.setRecyclerListener(this.mRecyclerListener);
        this.kae.a(this.kga);
        this.kae.a(this.kgb);
        this.kae.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eKB.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eKB);
        this.jil.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.jil);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gJB == null) {
                this.gJB = new g(this.mPageContext.getPageActivity());
                this.gJB.onChangeSkinType();
            }
            this.gJB.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gJB == null) {
            return false;
        }
        return this.gJB.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.mRootView);
        }
    }

    public void bRx() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.XW.setNextPage(this.gAw);
            }
            this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.gAw.setOnClickListener(null);
            this.gAw.endLoadData();
        }
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.XW.setNextPage(this.gAw);
            }
            this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.gAw.setOnClickListener(onClickListener);
            this.gAw.endLoadData();
        }
    }

    public void bRy() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.XW.setNextPage(this.gAw);
            }
            this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gAw.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gAw.setOnClickListener(null);
            this.gAw.startLoadData();
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
        this.mRefreshView.Dk(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.kan.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.kan.c(eVar);
    }

    public void cSE() {
        qJ(false);
    }

    public void onPause() {
        if (this.krW != null) {
            this.krW.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cOU() {
        qJ(true);
    }

    private void qJ(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iPw != null) {
            this.iPw.tN(!z);
            ThreadCardViewHolder cQC = cQC();
            if (cQC != null && cQC.tj() != null) {
                z2 = cQC.tj().b(new a.C0089a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iPw.cQB();
                } else if (this.kfZ) {
                    this.iPw.b(this.jiE, this.gzf, this.jjo, true);
                }
            }
        }
    }

    public void se(boolean z) {
        this.kfZ = z;
    }

    public void cQA() {
        if (this.iPw != null && this.kfZ) {
            this.iPw.b(this.jiE, this.gzf, this.jjo, true);
        }
    }

    public void cQB() {
        if (this.iPw != null) {
            this.iPw.cQB();
        }
    }

    public void bn(List<n> list) {
        if (this.krW != null) {
            this.krW.setData(list);
        }
        cQA();
    }

    public void LY(String str) {
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
        if (this.krW != null) {
            return this.krW.getDataList();
        }
        return null;
    }

    public void cQD() {
        bn(new LinkedList());
    }

    public void cQz() {
        if (this.XW != null) {
            this.XW.setSelection(0);
        }
    }

    public void Kx() {
        if (this.krW != null) {
            this.krW.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.kae != null) {
            this.kae.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.XW != null) {
            this.XW.setOnSrollToBottomListener(eVar);
        }
    }

    public void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gJB != null) {
            this.gJB.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gJB.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.kae != null) {
            this.kae.changeSkin(skinType);
        }
        if (this.krW != null) {
            this.krW.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gJB != null) {
            this.gJB.release();
        }
        b((f.e) null);
        if (this.kae != null) {
            this.kae.release();
        }
        if (this.krW != null) {
            this.krW.onDestroy();
        }
        if (this.iPw != null) {
            this.iPw.destroy();
        }
        cQE();
        MessageManager.getInstance().unRegisterListener(this.jil);
        MessageManager.getInstance().unRegisterListener(this.eKB);
    }

    private void cQE() {
        if (this.XW != null) {
            this.XW.removeOnScrollListener(this.mScrollListener);
            this.XW.setRecyclerListener(null);
        }
        if (this.kae != null) {
            this.kae.a((f.d) null);
            this.kae.a((f.b) null);
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
    public void cSF() {
        if (c(this.XW)) {
            sw(false);
        } else {
            sw(true);
        }
    }
}
