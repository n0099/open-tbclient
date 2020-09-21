package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabGameSubFragment extends LiveTabBaseSubFragment implements au {
    private BdTypeRecyclerView WM;
    private PbListView fHm;
    private BdSwipeRefreshLayout fIl;
    private b fIm;
    private AlaLiveTabGameModel fIn;
    private AlaLiveTabGameModel.a fIo = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(boolean z, List<q> list) {
            if (z) {
                LiveTabGameSubFragment.this.bHj();
            } else {
                LiveTabGameSubFragment.this.bHi();
            }
            LiveTabGameSubFragment.this.bHu();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bHu();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fIp = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.fIn.refresh();
            } else {
                LiveTabGameSubFragment.this.bHu();
            }
        }
    };
    private BdListView.e fIq = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.fIn.bGU();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.fIh) {
                LiveTabGameSubFragment.this.bHs();
            }
        }
    };
    private g mPullView;
    private View mRootView;

    public static LiveTabGameSubFragment kF(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabGameSubFragment liveTabGameSubFragment = new LiveTabGameSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabGameSubFragment.setArguments(bundle);
        return liveTabGameSubFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fHB = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.fIn == null) {
            this.fIn = new AlaLiveTabGameModel(getPageContext(), this.fIo);
        }
        this.fIn.init();
        this.fIn.dV(this.eYo, this.fIi);
        registerListener(this.fIj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.fHB) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.fIl = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fIf = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.fIl.setProgressView(this.mPullView);
        this.WM = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.WM.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.WM.setFadingEdgeLength(0);
        this.WM.setOverScrollMode(2);
        this.fIm = new b(getPageContext(), this.WM);
        this.fIm.kE(bdg());
        this.fHm = new PbListView(this.mContext);
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.WM.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.fIp);
        a(this.fIq);
        if (bdg()) {
            this.fIl.setEnabled(false);
            this.fIl.interruptRefresh();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        if (y.isEmpty(list)) {
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(new s());
        }
        this.fIm.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.WM != null) {
            this.WM.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (bdg()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fnv = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.fIl.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHu() {
        if (bdg()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fnv = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.fIl.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHi() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.WM.setNextPage(this.fHm);
            }
            this.fHm.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fHm.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fHm.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHj() {
        if (this.fHm != null) {
            if (this.fHm.getView().getParent() == null) {
                this.WM.setNextPage(this.fHm);
            }
            this.fHm.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fHm.setText(this.mContext.getResources().getString(R.string.loading));
            this.fHm.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.WM.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fHm.changeSkin(i);
        }
        if (this.fIm != null) {
            this.fIm.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fIl, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.WM, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.WM != null) {
            this.WM.removeOnScrollListener(this.mOnScrollListener);
            this.WM.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.fIn != null) {
            this.fIn.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.fIn != null) {
            this.fIn.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bki();
    }

    private void bki() {
        aq aqVar = new aq("c13008");
        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dF("fid", this.eYo);
        aqVar.ai("obj_locate", 2);
        aqVar.ai("obj_type", 15);
        aqVar.bki();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Pd() {
        this.WM.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bHt() {
        if (this.fIm != null) {
            this.fIm.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bly() {
        if (j.isNetWorkAvailable()) {
            this.fIn.refresh();
        } else {
            bHu();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void blz() {
    }
}
