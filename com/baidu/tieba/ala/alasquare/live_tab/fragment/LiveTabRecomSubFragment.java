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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveTabRecomSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView Vw;
    private PbListView fbY;
    private BdSwipeRefreshLayout fcW;
    private a fdd;
    private AlaLiveTabRecomModel fde;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabRecomModel.a fdf = new AlaLiveTabRecomModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.a
        public void d(boolean z, List<o> list) {
            if (z) {
                LiveTabRecomSubFragment.this.bqK();
            } else {
                LiveTabRecomSubFragment.this.bqJ();
            }
            LiveTabRecomSubFragment.this.bqV();
            LiveTabRecomSubFragment.this.setData(list);
            if (v.isEmpty(list)) {
                LiveTabRecomSubFragment.this.bqS();
            } else {
                LiveTabRecomSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.a
        public void g(int i, String str, boolean z) {
            LiveTabRecomSubFragment.this.bqV();
            if (z) {
                LiveTabRecomSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fda = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabRecomSubFragment.this.fde.refresh();
            } else {
                LiveTabRecomSubFragment.this.bqV();
            }
        }
    };
    private BdListView.e fdb = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabRecomSubFragment.this.hideLoadingView();
            } else {
                LiveTabRecomSubFragment.this.fde.bqv();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabRecomSubFragment.this.fcS) {
                LiveTabRecomSubFragment.this.bqT();
            }
        }
    };

    public static LiveTabRecomSubFragment jn(boolean z) {
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
            this.fcn = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.fde == null) {
            this.fde = new AlaLiveTabRecomModel(getPageContext(), this.fdf);
        }
        this.fde.init();
        registerListener(this.fcU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.fcn) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.fcW = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fcQ = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.fcW.setProgressView(this.mPullView);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Vw.setFadingEdgeLength(0);
        this.Vw.setOverScrollMode(2);
        this.fdd = new a(getPageContext(), this.Vw, 101);
        this.fbY = new PbListView(this.mContext);
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fbY.setLineGone();
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Vw.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.fda);
        a(this.fdb);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<o> list) {
        this.fdd.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Vw != null) {
            this.Vw.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.fcW.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqV() {
        this.fcW.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqJ() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.Vw.setNextPage(this.fbY);
            }
            this.fbY.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fbY.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fbY.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqK() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.Vw.setNextPage(this.fbY);
            }
            this.fbY.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fbY.setText(this.mContext.getResources().getString(R.string.loading));
            this.fbY.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Vw.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fbY != null) {
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fbY.changeSkin(i);
        }
        if (this.fdd != null) {
            this.fdd.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.fcW, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Vw, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Vw != null) {
            this.Vw.removeOnScrollListener(this.mOnScrollListener);
            this.Vw.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.fde != null) {
            this.fde.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.fde != null) {
            this.fde.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Ho() {
        this.Vw.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bqU() {
        if (this.fdd != null) {
            this.fdd.notifyDataSetChanged();
        }
    }
}
