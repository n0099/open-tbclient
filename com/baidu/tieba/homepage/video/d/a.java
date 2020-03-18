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
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.homepage.personalize.a.f;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.model.e;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView BK;
    private PbListView elM;
    private View enZ;
    private g euG;
    private com.baidu.tieba.homepage.personalize.bigday.a gYg;
    private BigdaySwipeRefreshLayout gYp;
    private m grz;
    private NEGFeedBackView.a hct;
    private e hld;
    private com.baidu.tieba.homepage.video.a.a hle;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int gqN = 0;
    private int eku = 0;
    private boolean mIsBackground = false;
    private boolean hcU = true;
    private boolean grs = false;
    private g.d hcV = new g.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            a.this.bOE();
        }
    };
    private g.b hcW = new g.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.mJ(true);
            if (a.this.grz != null && !a.this.mIsBackground && a.this.hcU) {
                a.this.grz.a(a.this.gqN, a.this.eku, a.this.grs, true);
            }
        }
    };
    private CustomMessageListener cMx = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hle.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.hcU) {
                        a.this.grz.a(a.this.gqN, a.this.eku, a.this.grs, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener gqF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bOF;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bOF = a.this.bOF()) != null && bOF.nk() != null) {
                    bOF.nk().b(new a.C0052a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.grz != null) {
                    a.this.grz.cl(view);
                }
                if (view.getTag() instanceof f) {
                    ((f) view.getTag()).bvQ().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int eog = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.grz != null && a.this.hcU) {
                a.this.grz.a(a.this.gqN, a.this.eku, a.this.grs, 1);
            }
            if (this.eog != i) {
                this.eog = i;
                if (this.eog == 1) {
                    a.this.mZ(true);
                } else {
                    a.this.bQc();
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
            bU(i3, (i4 - i3) + 1);
        }

        private void bU(int i, int i2) {
            a.this.gqN = i;
            a.this.eku = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public af bOF() {
        if (this.grz == null || this.grz.czc() == null || !(this.grz.czc().getTag() instanceof af)) {
            return null;
        }
        return (af) this.grz.czc().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hct = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.grz = new m(this.mPageContext, this.BK);
        this.grz.Ay(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grz.setUniqueId(this.mBdUniqueId);
        this.gYp = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.gYg = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gYp.setProgressView(this.gYg);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gYp.setCustomDistances(i, i, i * 2);
        this.elM = new PbListView(this.mPageContext.getPageActivity());
        this.elM.createView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.elM.setLineGone();
        this.elM.setTextSize(R.dimen.tbfontsize36);
        this.elM.setTextColor(am.getColor(R.color.cp_cont_d));
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elM.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hle = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.BK);
        this.hle.b(this.hct);
        this.hle.setPageUniqueId(this.mBdUniqueId);
        this.hld = new e();
        this.hld.h(this.mBdUniqueId);
        this.hle.b(this.hld);
        this.enZ = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aHS();
    }

    public void init() {
        this.BK.addOnScrollListener(this.mScrollListener);
        this.BK.setRecyclerListener(this.mRecyclerListener);
        this.gYg.a(this.hcV);
        this.gYg.a(this.hcW);
        this.gYg.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cMx.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cMx);
        this.gqF.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gqF);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.euG == null) {
                this.euG = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.euG.onChangeSkinType();
            }
            this.euG.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.euG == null) {
            return false;
        }
        return this.euG.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this.mRootView);
        }
    }

    public void bcy() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.BK.setNextPage(this.elM);
            }
            this.elM.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elM.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.elM.setOnClickListener(null);
            this.elM.endLoadData();
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.BK.setNextPage(this.elM);
            }
            this.elM.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elM.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.elM.setOnClickListener(onClickListener);
            this.elM.endLoadData();
        }
    }

    public void bcz() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.BK.setNextPage(this.elM);
            }
            this.elM.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elM.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.elM.setOnClickListener(null);
            this.elM.startLoadData();
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mG(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mI(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mG(R.drawable.new_pic_emotion_03);
        this.mRefreshView.vy(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bcC() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.gYp.setRefreshing(true);
    }

    public void b(g.e eVar) {
        this.gYp.c(eVar);
    }

    public void bQb() {
        lz(false);
    }

    public void onPause() {
        if (this.hle != null) {
            this.hle.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void bNu() {
        lz(true);
    }

    private void lz(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.grz != null) {
            this.grz.oH(!z);
            af bOF = bOF();
            if (bOF != null && bOF.nk() != null) {
                z2 = bOF.nk().b(new a.C0052a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.grz.bOE();
                } else if (this.hcU) {
                    this.grz.a(this.gqN, this.eku, this.grs, true);
                }
            }
        }
    }

    public void mJ(boolean z) {
        this.hcU = z;
    }

    public void bOD() {
        if (this.grz != null && this.hcU) {
            this.grz.a(this.gqN, this.eku, this.grs, true);
        }
    }

    public void bOE() {
        if (this.grz != null) {
            this.grz.bOE();
        }
    }

    public void av(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hle != null) {
            this.hle.setData(list);
        }
        bOD();
    }

    public void Ci(String str) {
        List<Integer> b = b(str, this.BK);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.BK.m(intValue, intValue2);
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
                com.baidu.adp.widget.ListView.m item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c) {
                    c cVar = (c) item;
                    if (cVar.aAj() != null && cVar.aAj().getTid().equals(str)) {
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

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.hle != null) {
            return this.hle.getDataList();
        }
        return null;
    }

    public void bOG() {
        av(new LinkedList());
    }

    public void bOC() {
        if (this.BK != null) {
            this.BK.setSelection(0);
        }
    }

    public void wS() {
        if (this.hle != null) {
            this.hle.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gYg != null) {
            this.gYg.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.BK != null) {
            this.BK.setOnSrollToBottomListener(eVar);
        }
    }

    public void aHS() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.euG != null) {
            this.euG.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.euG.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gYg != null) {
            this.gYg.changeSkin(skinType);
        }
        if (this.hle != null) {
            this.hle.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.euG != null) {
            this.euG.release();
        }
        b((g.e) null);
        if (this.gYg != null) {
            this.gYg.release();
        }
        if (this.hle != null) {
            this.hle.onDestroy();
        }
        if (this.grz != null) {
            this.grz.destroy();
        }
        bOH();
        MessageManager.getInstance().unRegisterListener(this.gqF);
        MessageManager.getInstance().unRegisterListener(this.cMx);
    }

    private void bOH() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mScrollListener);
            this.BK.setRecyclerListener(null);
        }
        if (this.gYg != null) {
            this.gYg.a((g.d) null);
            this.gYg.a((g.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mZ(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQc() {
        if (a(this.BK)) {
            mZ(false);
        } else {
            mZ(true);
        }
    }
}
