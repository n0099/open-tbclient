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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.model.e;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Wa;
    private PbListView fnt;
    private View fpG;
    private g fwo;
    private m hjm;
    private e iBs;
    private com.baidu.tieba.homepage.video.a.a iBt;
    private com.baidu.tieba.homepage.personalize.bigday.a ilY;
    private BigdaySwipeRefreshLayout imi;
    private NEGFeedBackView.a iqa;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int hBI = 0;
    private int fmb = 0;
    private boolean mIsBackground = false;
    private boolean iqB = true;
    private boolean hCs = false;
    private f.d iqC = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cje();
        }
    };
    private f.b iqD = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.ou(true);
            if (a.this.hjm != null && !a.this.mIsBackground && a.this.iqB) {
                a.this.hjm.a(a.this.hBI, a.this.fmb, a.this.hCs, true);
            }
        }
    };
    private CustomMessageListener dGa = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iBt.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.iqB) {
                        a.this.hjm.a(a.this.hBI, a.this.fmb, a.this.hCs, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener hBs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ak cjf;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cjf = a.this.cjf()) != null && cjf.se() != null) {
                    cjf.se().b(new a.C0098a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.hjm != null) {
                    a.this.hjm.cu(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.f) {
                    ((com.baidu.tieba.homepage.personalize.a.f) view.getTag()).bPg().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int fpM = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.hjm != null && a.this.iqB) {
                a.this.hjm.a(a.this.hBI, a.this.fmb, a.this.hCs, 1);
            }
            if (this.fpM != i) {
                this.fpM = i;
                if (this.fpM == 1) {
                    a.this.oJ(true);
                } else {
                    a.this.ckV();
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
            cl(i3, (i4 - i3) + 1);
        }

        private void cl(int i, int i2) {
            a.this.hBI = i;
            a.this.fmb = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public ak cjf() {
        if (this.hjm == null || this.hjm.cVl() == null || !(this.hjm.cVl().getTag() instanceof ak)) {
            return null;
        }
        return (ak) this.hjm.cVl().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iqa = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Wa = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Wa.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.hjm = new m(this.mPageContext, this.Wa);
        this.hjm.CM(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hjm.setUniqueId(this.mBdUniqueId);
        this.imi = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.ilY = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.imi.setProgressView(this.ilY);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.imi.setCustomDistances(i, i, i * 2);
        this.fnt = new PbListView(this.mPageContext.getPageActivity());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize36);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.iBt = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Wa);
        this.iBt.b(this.iqa);
        this.iBt.setPageUniqueId(this.mBdUniqueId);
        this.iBs = new e();
        this.iBs.i(this.mBdUniqueId);
        this.iBt.b(this.iBs);
        this.fpG = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        aYj();
    }

    public void init() {
        this.Wa.addOnScrollListener(this.mScrollListener);
        this.Wa.setRecyclerListener(this.mRecyclerListener);
        this.ilY.a(this.iqC);
        this.ilY.a(this.iqD);
        this.ilY.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dGa.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dGa);
        this.hBs.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.hBs);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.fwo == null) {
                this.fwo = new g(this.mPageContext.getPageActivity());
                this.fwo.onChangeSkinType();
            }
            this.fwo.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.fwo == null) {
            return false;
        }
        return this.fwo.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this.mRootView);
        }
    }

    public void btI() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.Wa.setNextPage(this.fnt);
            }
            this.fnt.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fnt.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.fnt.setOnClickListener(null);
            this.fnt.endLoadData();
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.Wa.setNextPage(this.fnt);
            }
            this.fnt.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fnt.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.fnt.setOnClickListener(onClickListener);
            this.fnt.endLoadData();
        }
    }

    public void btJ() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.Wa.setNextPage(this.fnt);
            }
            this.fnt.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.fnt.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.fnt.setOnClickListener(null);
            this.fnt.startLoadData();
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.nQ(R.drawable.new_pic_emotion_08);
        this.mRefreshView.nS(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.nQ(R.drawable.new_pic_emotion_03);
        this.mRefreshView.yQ(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void btN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.imi.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.imi.c(eVar);
    }

    public void ckU() {
        ni(false);
    }

    public void onPause() {
        if (this.iBt != null) {
            this.iBt.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void chX() {
        ni(true);
    }

    private void ni(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.hjm != null) {
            this.hjm.qs(!z);
            ak cjf = cjf();
            if (cjf != null && cjf.se() != null) {
                z2 = cjf.se().b(new a.C0098a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.hjm.cje();
                } else if (this.iqB) {
                    this.hjm.a(this.hBI, this.fmb, this.hCs, true);
                }
            }
        }
    }

    public void ou(boolean z) {
        this.iqB = z;
    }

    public void cjd() {
        if (this.hjm != null && this.iqB) {
            this.hjm.a(this.hBI, this.fmb, this.hCs, true);
        }
    }

    public void cje() {
        if (this.hjm != null) {
            this.hjm.cje();
        }
    }

    public void aD(List<q> list) {
        if (this.iBt != null) {
            this.iBt.setData(list);
        }
        cjd();
    }

    public void Ge(String str) {
        List<Integer> b = b(str, this.Wa);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Wa.m(intValue, intValue2);
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
                    if (cVar.aPS() != null && cVar.aPS().getTid().equals(str)) {
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
        if (this.iBt != null) {
            return this.iBt.getDataList();
        }
        return null;
    }

    public void cjg() {
        aD(new LinkedList());
    }

    public void cjc() {
        if (this.Wa != null) {
            this.Wa.setSelection(0);
        }
    }

    public void DA() {
        if (this.iBt != null) {
            this.iBt.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.ilY != null) {
            this.ilY.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Wa != null) {
            this.Wa.setOnSrollToBottomListener(eVar);
        }
    }

    public void aYj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.fwo != null) {
            this.fwo.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.fwo.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.ilY != null) {
            this.ilY.changeSkin(skinType);
        }
        if (this.iBt != null) {
            this.iBt.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.fwo != null) {
            this.fwo.release();
        }
        b((f.e) null);
        if (this.ilY != null) {
            this.ilY.release();
        }
        if (this.iBt != null) {
            this.iBt.onDestroy();
        }
        if (this.hjm != null) {
            this.hjm.destroy();
        }
        cjh();
        MessageManager.getInstance().unRegisterListener(this.hBs);
        MessageManager.getInstance().unRegisterListener(this.dGa);
    }

    private void cjh() {
        if (this.Wa != null) {
            this.Wa.removeOnScrollListener(this.mScrollListener);
            this.Wa.setRecyclerListener(null);
        }
        if (this.ilY != null) {
            this.ilY.a((f.d) null);
            this.ilY.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oJ(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckV() {
        if (a(this.Wa)) {
            oJ(false);
        } else {
            oJ(true);
        }
    }
}
