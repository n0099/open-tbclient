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
import java.util.List;
/* loaded from: classes3.dex */
public class LiveTabGameSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView BK;
    private PbListView elj;
    private BdSwipeRefreshLayout emf;
    private b emg;
    private AlaLiveTabGameModel emh;
    private AlaLiveTabGameModel.a emi = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void d(boolean z, List<m> list) {
            if (z) {
                LiveTabGameSubFragment.this.bcu();
            } else {
                LiveTabGameSubFragment.this.bct();
            }
            LiveTabGameSubFragment.this.bcD();
            LiveTabGameSubFragment.this.setData(list);
            if (v.isEmpty(list)) {
                LiveTabGameSubFragment.this.aiu();
            } else {
                LiveTabGameSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bcD();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private g.c emj = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.emh.refresh();
            } else {
                LiveTabGameSubFragment.this.bcD();
            }
        }
    };
    private BdListView.e emk = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.emh.bcf();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.ema) {
                LiveTabGameSubFragment.this.bcB();
            }
        }
    };
    private h mPullView;
    private View mRootView;

    public static LiveTabGameSubFragment hT(boolean z) {
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
            this.elx = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.emh == null) {
            this.emh = new AlaLiveTabGameModel(getPageContext(), this.emi);
        }
        this.emh.init();
        this.emh.cP(this.emb, this.emc);
        registerListener(this.emd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.elx) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.emf = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.elY = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new h(getPageContext());
        this.emf.setProgressView(this.mPullView);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.emg = new b(getPageContext(), this.BK);
        this.elj = new PbListView(this.mContext);
        this.elj.createView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.elj.setLineGone();
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elj.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.BK.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.emj);
        a(this.emk);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<m> list) {
        this.emg.setData(list);
    }

    private void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.BK != null) {
            this.BK.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.emf.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcD() {
        this.emf.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bct() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.BK.setNextPage(this.elj);
            }
            this.elj.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.elj.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.elj.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcu() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.BK.setNextPage(this.elj);
            }
            this.elj.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.elj.setText(this.mContext.getResources().getString(R.string.loading));
            this.elj.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.BK.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elj != null) {
            this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elj.changeSkin(i);
        }
        if (this.emg != null) {
            this.emg.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.emf, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.BK, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mOnScrollListener);
            this.BK.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.emh != null) {
            this.emh.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.emh != null) {
            this.emh.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void AC() {
        this.BK.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bcC() {
        if (this.emg != null) {
            this.emg.notifyDataSetChanged();
        }
    }
}
