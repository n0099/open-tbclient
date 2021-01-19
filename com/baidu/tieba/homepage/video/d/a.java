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
    private BdTypeRecyclerView Ya;
    private g gGD;
    private PbListView gxy;
    private View gzT;
    private i iJA;
    private com.baidu.tieba.homepage.personalize.bigday.a jSp;
    private BigdaySwipeRefreshLayout jSy;
    private NEGFeedBackView.a jXI;
    private e kjA;
    private com.baidu.tieba.homepage.video.a.a kjB;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int jcJ = 0;
    private int gwh = 0;
    private boolean mIsBackground = false;
    private boolean jYj = true;
    private boolean jdt = false;
    private f.d jYk = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cOx();
        }
    };
    private f.b jYl = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.rS(true);
            if (a.this.iJA != null && !a.this.mIsBackground && a.this.jYj) {
                a.this.iJA.b(a.this.jcJ, a.this.gwh, a.this.jdt, true);
            }
        }
    };
    private CustomMessageListener eIv = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.kjB.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.jYj) {
                        a.this.iJA.b(a.this.jcJ, a.this.gwh, a.this.jdt, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener jcq = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder cOy;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cOy = a.this.cOy()) != null && cOy.tm() != null) {
                    cOy.tm().b(new a.C0089a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.iJA != null) {
                    a.this.iJA.dv(view);
                }
                if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                    ((HomePageCardVideoViewHolder) view.getTag()).crP().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int gzZ = -1;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.iJA != null && a.this.jYj) {
                a.this.iJA.a(a.this.jcJ, a.this.gwh, a.this.jdt, 1);
            }
            if (this.gzZ != i) {
                this.gzZ = i;
                if (this.gzZ == 1) {
                    a.this.sj(true);
                } else {
                    a.this.cQz();
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
            a.this.jcJ = i;
            a.this.gwh = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadCardViewHolder cOy() {
        if (this.iJA == null || this.iJA.dxN() == null || !(this.iJA.dxN().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.iJA.dxN().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jXI = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Ya = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Ya.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Ya.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.iJA = new i(this.mPageContext, this.Ya);
        this.iJA.GV(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iJA.setUniqueId(this.mBdUniqueId);
        this.jSy = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.jSp = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jSy.setProgressView(this.jSp);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jSy.setCustomDistances(i, i, i * 2);
        this.gxy = new PbListView(this.mPageContext.getPageActivity());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.transparent);
        this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize36);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.kjB = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Ya);
        this.kjB.b(this.jXI);
        this.kjB.setPageUniqueId(this.mBdUniqueId);
        this.kjA = new e();
        this.kjA.i(this.mBdUniqueId);
        this.kjB.b(this.kjA);
        this.gzT = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        btV();
    }

    public void init() {
        this.Ya.addOnScrollListener(this.mScrollListener);
        this.Ya.setRecyclerListener(this.mRecyclerListener);
        this.jSp.a(this.jYk);
        this.jSp.a(this.jYl);
        this.jSp.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eIv.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eIv);
        this.jcq.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.jcq);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gGD == null) {
                this.gGD = new g(this.mPageContext.getPageActivity());
                this.gGD.onChangeSkinType();
            }
            this.gGD.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gGD == null) {
            return false;
        }
        return this.gGD.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.mRootView);
        }
    }

    public void bQM() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.Ya.setNextPage(this.gxy);
            }
            this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.gxy.setOnClickListener(null);
            this.gxy.endLoadData();
        }
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.Ya.setNextPage(this.gxy);
            }
            this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.gxy.setOnClickListener(onClickListener);
            this.gxy.endLoadData();
        }
    }

    public void bQN() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.Ya.setNextPage(this.gxy);
            }
            this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gxy.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gxy.setOnClickListener(null);
            this.gxy.startLoadData();
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.ri(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rk(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.ri(R.drawable.new_pic_emotion_03);
        this.mRefreshView.CV(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.jSy.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.jSy.c(eVar);
    }

    public void cQy() {
        qz(false);
    }

    public void onPause() {
        if (this.kjB != null) {
            this.kjB.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cMQ() {
        qz(true);
    }

    private void qz(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iJA != null) {
            this.iJA.tA(!z);
            ThreadCardViewHolder cOy = cOy();
            if (cOy != null && cOy.tm() != null) {
                z2 = cOy.tm().b(new a.C0089a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iJA.cOx();
                } else if (this.jYj) {
                    this.iJA.b(this.jcJ, this.gwh, this.jdt, true);
                }
            }
        }
    }

    public void rS(boolean z) {
        this.jYj = z;
    }

    public void cOw() {
        if (this.iJA != null && this.jYj) {
            this.iJA.b(this.jcJ, this.gwh, this.jdt, true);
        }
    }

    public void cOx() {
        if (this.iJA != null) {
            this.iJA.cOx();
        }
    }

    public void bs(List<n> list) {
        if (this.kjB != null) {
            this.kjB.setData(list);
        }
        cOw();
    }

    public void Ln(String str) {
        List<Integer> b2 = b(str, this.Ya);
        int intValue = b2.get(0).intValue();
        int intValue2 = b2.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Ya.p(intValue, intValue2);
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
                    if (bVar.bkV() != null && bVar.bkV().getTid().equals(str)) {
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
        if (this.kjB != null) {
            return this.kjB.getDataList();
        }
        return null;
    }

    public void cOz() {
        bs(new LinkedList());
    }

    public void cOv() {
        if (this.Ya != null) {
            this.Ya.setSelection(0);
        }
    }

    public void IZ() {
        if (this.kjB != null) {
            this.kjB.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jSp != null) {
            this.jSp.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Ya != null) {
            this.Ya.setOnSrollToBottomListener(eVar);
        }
    }

    public void btV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gGD != null) {
            this.gGD.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gGD.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jSp != null) {
            this.jSp.changeSkin(skinType);
        }
        if (this.kjB != null) {
            this.kjB.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.gGD != null) {
            this.gGD.release();
        }
        b((f.e) null);
        if (this.jSp != null) {
            this.jSp.release();
        }
        if (this.kjB != null) {
            this.kjB.onDestroy();
        }
        if (this.iJA != null) {
            this.iJA.destroy();
        }
        cOA();
        MessageManager.getInstance().unRegisterListener(this.jcq);
        MessageManager.getInstance().unRegisterListener(this.eIv);
    }

    private void cOA() {
        if (this.Ya != null) {
            this.Ya.removeOnScrollListener(this.mScrollListener);
            this.Ya.setRecyclerListener(null);
        }
        if (this.jSp != null) {
            this.jSp.a((f.d) null);
            this.jSp.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean c(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQz() {
        if (c(this.Ya)) {
            sj(false);
        } else {
            sj(true);
        }
    }
}
