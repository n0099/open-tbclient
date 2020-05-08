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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.s;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveTabGameSubFragment extends LiveTabBaseSubFragment implements an {
    private BdTypeRecyclerView Vi;
    private PbListView ePr;
    private BdSwipeRefreshLayout eQo;
    private b eQp;
    private AlaLiveTabGameModel eQq;
    private AlaLiveTabGameModel.a eQr = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void d(boolean z, List<m> list) {
            if (z) {
                LiveTabGameSubFragment.this.blo();
            } else {
                LiveTabGameSubFragment.this.bln();
            }
            LiveTabGameSubFragment.this.blx();
            LiveTabGameSubFragment.this.setData(list);
            if (v.isEmpty(list)) {
                LiveTabGameSubFragment.this.aqE();
            } else {
                LiveTabGameSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.blx();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private g.c eQs = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.eQq.refresh();
            } else {
                LiveTabGameSubFragment.this.blx();
            }
        }
    };
    private BdListView.e eQt = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.eQq.bkZ();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.eQj) {
                LiveTabGameSubFragment.this.blv();
            }
        }
    };
    private h mPullView;
    private View mRootView;

    public static LiveTabGameSubFragment iT(boolean z) {
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
            this.ePF = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.eQq == null) {
            this.eQq = new AlaLiveTabGameModel(getPageContext(), this.eQr);
        }
        this.eQq.init();
        this.eQq.da(this.eQk, this.eQl);
        registerListener(this.eQm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.ePF) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.eQo = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.eQh = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new h(getPageContext());
        this.eQo.setProgressView(this.mPullView);
        this.Vi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Vi.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Vi.setFadingEdgeLength(0);
        this.Vi.setOverScrollMode(2);
        this.eQp = new b(getPageContext(), this.Vi);
        this.ePr = new PbListView(this.mContext);
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Vi.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.eQs);
        a(this.eQt);
        if (aMs()) {
            this.eQo.setEnabled(false);
            this.eQo.interruptRefresh();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<m> list) {
        this.eQp.setData(list);
    }

    private void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Vi != null) {
            this.Vi.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (aMs()) {
            s sVar = new s();
            sVar.tabId = 1121;
            sVar.etP = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
            return;
        }
        this.eQo.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blx() {
        if (aMs()) {
            s sVar = new s();
            sVar.tabId = 1121;
            sVar.etP = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
            return;
        }
        this.eQo.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bln() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.Vi.setNextPage(this.ePr);
            }
            this.ePr.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.ePr.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.ePr.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blo() {
        if (this.ePr != null) {
            if (this.ePr.getView().getParent() == null) {
                this.Vi.setNextPage(this.ePr);
            }
            this.ePr.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.ePr.setText(this.mContext.getResources().getString(R.string.loading));
            this.ePr.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Vi.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePr.changeSkin(i);
        }
        if (this.eQp != null) {
            this.eQp.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.eQo, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Vi, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Vi != null) {
            this.Vi.removeOnScrollListener(this.mOnScrollListener);
            this.Vi.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.eQq != null) {
            this.eQq.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.eQq != null) {
            this.eQq.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void FG() {
        this.Vi.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void blw() {
        if (this.eQp != null) {
            this.eQp.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aQk() {
        if (j.isNetWorkAvailable()) {
            this.eQq.refresh();
        } else {
            blx();
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aQl() {
    }
}
