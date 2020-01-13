package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel;
import java.util.List;
/* loaded from: classes2.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView Bs;
    private BdSwipeRefreshLayout ehX;
    private PbListView ehe;
    private a eie;
    private AlaLiveTabYanzhiModel eii;
    private h mPullView;
    private View mRootView;
    private AlaLiveTabYanzhiModel.a eij = new AlaLiveTabYanzhiModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void d(boolean z, List<m> list) {
            if (z) {
                LiveTabYanzhiSubFragment.this.bac();
            } else {
                LiveTabYanzhiSubFragment.this.bab();
            }
            LiveTabYanzhiSubFragment.this.bam();
            LiveTabYanzhiSubFragment.this.setData(list);
            if (v.isEmpty(list)) {
                LiveTabYanzhiSubFragment.this.age();
            } else {
                LiveTabYanzhiSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void e(int i, String str, boolean z) {
            LiveTabYanzhiSubFragment.this.bam();
            if (z) {
                LiveTabYanzhiSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private g.c eib = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabYanzhiSubFragment.this.eii.refresh();
            } else {
                LiveTabYanzhiSubFragment.this.bam();
            }
        }
    };
    private BdListView.e eic = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabYanzhiSubFragment.this.hideLoadingView();
            } else {
                LiveTabYanzhiSubFragment.this.eii.aZN();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            Log.e("D444", "dy" + i2 + ", dx" + i);
            if (i2 >= 4 && !LiveTabYanzhiSubFragment.this.ehU) {
                LiveTabYanzhiSubFragment.this.bak();
            }
        }
    };

    public static LiveTabYanzhiSubFragment hO(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabYanzhiSubFragment liveTabYanzhiSubFragment = new LiveTabYanzhiSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabYanzhiSubFragment.setArguments(bundle);
        return liveTabYanzhiSubFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ehq = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.eii == null) {
            this.eii = new AlaLiveTabYanzhiModel(getPageContext(), this.eij);
        }
        this.eii.init();
        registerListener(this.ehV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.ehq) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.ehX = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.ehS = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new h(getPageContext());
        this.ehX.setProgressView(this.mPullView);
        this.Bs = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Bs.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Bs.setFadingEdgeLength(0);
        this.Bs.setOverScrollMode(2);
        this.eie = new a(getPageContext(), this.Bs, 102);
        this.ehe = new PbListView(this.mContext);
        this.ehe.createView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.ehe.setLineGone();
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ehe.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Bs.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.eib);
        a(this.eic);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<m> list) {
        this.eie.setData(list);
    }

    private void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Bs != null) {
            this.Bs.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.ehX.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bam() {
        this.ehX.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bab() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.Bs.setNextPage(this.ehe);
            }
            this.ehe.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.ehe.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.ehe.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bac() {
        if (this.ehe != null) {
            if (this.ehe.getView().getParent() == null) {
                this.Bs.setNextPage(this.ehe);
            }
            this.ehe.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.ehe.setText(this.mContext.getResources().getString(R.string.loading));
            this.ehe.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Bs.setNextPage(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ehe != null) {
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ehe.changeSkin(i);
        }
        if (this.eie != null) {
            this.eie.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.ehX, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Bs, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Bs != null) {
            this.Bs.removeOnScrollListener(this.mOnScrollListener);
            this.Bs.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.eii != null) {
            this.eii.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.eii != null) {
            this.eii.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void yj() {
        this.Bs.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bal() {
        if (this.eie != null) {
            this.eie.notifyDataSetChanged();
        }
    }
}
