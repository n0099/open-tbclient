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
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.b;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.model.e;
import com.baidu.tieba.play.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView Xi;
    private PbListView giV;
    private View glq;
    private g grV;
    private i irb;
    private NEGFeedBackView.a jBv;
    private e jNp;
    private com.baidu.tieba.homepage.video.a.a jNq;
    private com.baidu.tieba.homepage.personalize.bigday.a jwf;
    private BigdaySwipeRefreshLayout jwo;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private int iKj = 0;
    private int ghD = 0;
    private boolean mIsBackground = false;
    private boolean jBW = true;
    private boolean iKT = false;
    private f.d jBX = new f.d() { // from class: com.baidu.tieba.homepage.video.d.a.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            a.this.cJS();
        }
    };
    private f.b jBY = new f.b() { // from class: com.baidu.tieba.homepage.video.d.a.2
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            a.this.qY(true);
            if (a.this.irb != null && !a.this.mIsBackground && a.this.jBW) {
                a.this.irb.a(a.this.iKj, a.this.ghD, a.this.iKT, true);
            }
        }
    };
    private CustomMessageListener ews = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.video.d.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.video.d.a.3.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jNq.notifyDataSetChanged();
                    if (!a.this.mIsBackground && a.this.jBW) {
                        a.this.irb.a(a.this.iKj, a.this.ghD, a.this.iKT, true);
                    }
                }
            }, 500L);
        }
    };
    private CustomMessageListener iJR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.video.d.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cJT;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cJT = a.this.cJT()) != null && cJT.tW() != null) {
                    cJT.tW().b(new a.C0096a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.video.d.a.5
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (a.this.irb != null) {
                    a.this.irb.de(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                    ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).coz().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.video.d.a.6
        private int glw = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 && a.this.irb != null && a.this.jBW) {
                a.this.irb.a(a.this.iKj, a.this.ghD, a.this.iKT, 1);
            }
            if (this.glw != i) {
                this.glw = i;
                if (this.glw == 1) {
                    a.this.ro(true);
                } else {
                    a.this.cLV();
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
            cD(i3, (i4 - i3) + 1);
        }

        private void cD(int i, int i2) {
            a.this.iKj = i;
            a.this.ghD = (i + i2) - 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public am cJT() {
        if (this.irb == null || this.irb.dww() == null || !(this.irb.dww().getTag() instanceof am)) {
            return null;
        }
        return (am) this.irb.dww().getTag();
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jBv = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.video_tab_framelayout);
        this.Xi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_tab_recycle_view);
        this.Xi.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        if (!d.bhw()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.Xi.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        }
        this.irb = new i(this.mPageContext, this.Xi);
        this.irb.HR(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.irb.setUniqueId(this.mBdUniqueId);
        this.jwo = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.video_tab_refresh_layout);
        this.jwf = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jwo.setProgressView(this.jwf);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jwo.setCustomDistances(i, i, i * 2);
        this.giV = new PbListView(this.mPageContext.getPageActivity());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.transparent);
        this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize36);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jNq = new com.baidu.tieba.homepage.video.a.a(this.mPageContext, this.Xi);
        this.jNq.b(this.jBv);
        this.jNq.setPageUniqueId(this.mBdUniqueId);
        this.jNp = new e();
        this.jNp.i(this.mBdUniqueId);
        this.jNq.b(this.jNp);
        this.glq = this.mRootView.findViewById(R.id.video_tab_divider_shadow);
        brT();
    }

    public void init() {
        this.Xi.addOnScrollListener(this.mScrollListener);
        this.Xi.setRecyclerListener(this.mRecyclerListener);
        this.jwf.a(this.jBX);
        this.jwf.a(this.jBY);
        this.jwf.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.ews.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.ews);
        this.iJR.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iJR);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.grV == null) {
                this.grV = new g(this.mPageContext.getPageActivity());
                this.grV.onChangeSkinType();
            }
            this.grV.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.grV == null) {
            return false;
        }
        return this.grV.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this.mRootView);
        }
    }

    public void bOp() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Xi.setNextPage(this.giV);
            }
            this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.giV.setText(this.mPageContext.getResources().getString(R.string.video_tab_no_more));
            this.giV.setOnClickListener(null);
            this.giV.endLoadData();
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Xi.setNextPage(this.giV);
            }
            this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.giV.setText(this.mPageContext.getResources().getString(R.string.video_tab_click_load));
            this.giV.setOnClickListener(onClickListener);
            this.giV.endLoadData();
        }
    }

    public void bOq() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Xi.setNextPage(this.giV);
            }
            this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.giV.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.giV.setOnClickListener(null);
            this.giV.startLoadData();
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.sb(R.drawable.new_pic_emotion_08);
        this.mRefreshView.sd(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.sb(R.drawable.new_pic_emotion_03);
        this.mRefreshView.DC(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void startPullRefresh() {
        this.jwo.setRefreshing(true);
    }

    public void b(f.e eVar) {
        this.jwo.c(eVar);
    }

    public void cLU() {
        pI(false);
    }

    public void onPause() {
        if (this.jNq != null) {
            this.jNq.onPause();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void cIl() {
        pI(true);
    }

    private void pI(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.irb != null) {
            this.irb.ta(!z);
            am cJT = cJT();
            if (cJT != null && cJT.tW() != null) {
                z2 = cJT.tW().b(new a.C0096a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.irb.cJS();
                } else if (this.jBW) {
                    this.irb.a(this.iKj, this.ghD, this.iKT, true);
                }
            }
        }
    }

    public void qY(boolean z) {
        this.jBW = z;
    }

    public void cJR() {
        if (this.irb != null && this.jBW) {
            this.irb.a(this.iKj, this.ghD, this.iKT, true);
        }
    }

    public void cJS() {
        if (this.irb != null) {
            this.irb.cJS();
        }
    }

    public void bi(List<q> list) {
        if (this.jNq != null) {
            this.jNq.setData(list);
        }
        cJR();
    }

    public void Lo(String str) {
        List<Integer> b = b(str, this.Xi);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Xi.o(intValue, intValue2);
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
                    if (bVar.bjd() != null && bVar.bjd().getTid().equals(str)) {
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
        if (this.jNq != null) {
            return this.jNq.getDataList();
        }
        return null;
    }

    public void cJU() {
        bi(new LinkedList());
    }

    public void cJQ() {
        if (this.Xi != null) {
            this.Xi.setSelection(0);
        }
    }

    public void Lq() {
        if (this.jNq != null) {
            this.jNq.notifyDataSetChanged();
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jwf != null) {
            this.jwf.setListPullRefreshListener(cVar);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Xi != null) {
            this.Xi.setOnSrollToBottomListener(eVar);
        }
    }

    public void brT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.grV != null) {
            this.grV.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.grV.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jwf != null) {
            this.jwf.changeSkin(skinType);
        }
        if (this.jNq != null) {
            this.jNq.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        if (this.grV != null) {
            this.grV.release();
        }
        b((f.e) null);
        if (this.jwf != null) {
            this.jwf.release();
        }
        if (this.jNq != null) {
            this.jNq.onDestroy();
        }
        if (this.irb != null) {
            this.irb.destroy();
        }
        cJV();
        MessageManager.getInstance().unRegisterListener(this.iJR);
        MessageManager.getInstance().unRegisterListener(this.ews);
    }

    private void cJV() {
        if (this.Xi != null) {
            this.Xi.removeOnScrollListener(this.mScrollListener);
            this.Xi.setRecyclerListener(null);
        }
        if (this.jwf != null) {
            this.jwf.a((f.d) null);
            this.jwf.a((f.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ro(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
    }

    private boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLV() {
        if (a(this.Xi)) {
            ro(false);
        } else {
            ro(true);
        }
    }
}
