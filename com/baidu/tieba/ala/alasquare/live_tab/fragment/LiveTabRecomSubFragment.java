package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabRecomSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView WM;
    private PbListView fHm;
    private BdSwipeRefreshLayout fIl;
    private a fIs;
    private AlaLiveTabRecomModel fIt;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabRecomModel.a fIu = new AlaLiveTabRecomModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.a
        public void f(boolean z, List<q> list) {
            if (z) {
                LiveTabRecomSubFragment.this.bHj();
            } else {
                LiveTabRecomSubFragment.this.bHi();
            }
            LiveTabRecomSubFragment.this.bHu();
            LiveTabRecomSubFragment.this.setData(list);
            if (y.isEmpty(list)) {
                LiveTabRecomSubFragment.this.bHr();
            } else {
                LiveTabRecomSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.a
        public void f(int i, String str, boolean z) {
            LiveTabRecomSubFragment.this.bHu();
            if (z) {
                LiveTabRecomSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fIp = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabRecomSubFragment.this.fIt.refresh();
            } else {
                LiveTabRecomSubFragment.this.bHu();
            }
        }
    };
    private BdListView.e fIq = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabRecomSubFragment.this.hideLoadingView();
            } else {
                LiveTabRecomSubFragment.this.fIt.bGU();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabRecomSubFragment.this.fIh) {
                LiveTabRecomSubFragment.this.bHs();
            }
        }
    };

    public static LiveTabRecomSubFragment kG(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabRecomSubFragment liveTabRecomSubFragment = new LiveTabRecomSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabRecomSubFragment.setArguments(bundle);
        return liveTabRecomSubFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fHB = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.fIt == null) {
            this.fIt = new AlaLiveTabRecomModel(getPageContext(), this.fIu);
        }
        this.fIt.init();
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
        this.fIs = new a(getPageContext(), this.WM, 101);
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
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        this.fIs.setData(list);
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
        this.fIl.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHu() {
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
        if (this.fIs != null) {
            this.fIs.notifyDataSetChanged();
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
        if (this.fIt != null) {
            this.fIt.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.fIt != null) {
            this.fIt.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Pd() {
        this.WM.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bHt() {
        if (this.fIs != null) {
            this.fIs.notifyDataSetChanged();
        }
    }
}
