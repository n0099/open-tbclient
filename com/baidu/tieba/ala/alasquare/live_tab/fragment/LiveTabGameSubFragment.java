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
    private PbListView elM;
    private BdSwipeRefreshLayout emJ;
    private b emK;
    private AlaLiveTabGameModel emL;
    private AlaLiveTabGameModel.a emM = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void d(boolean z, List<m> list) {
            if (z) {
                LiveTabGameSubFragment.this.bcz();
            } else {
                LiveTabGameSubFragment.this.bcy();
            }
            LiveTabGameSubFragment.this.bcI();
            LiveTabGameSubFragment.this.setData(list);
            if (v.isEmpty(list)) {
                LiveTabGameSubFragment.this.aix();
            } else {
                LiveTabGameSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bcI();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private g.c emN = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.emL.refresh();
            } else {
                LiveTabGameSubFragment.this.bcI();
            }
        }
    };
    private BdListView.e emO = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.emL.bck();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.emE) {
                LiveTabGameSubFragment.this.bcG();
            }
        }
    };
    private h mPullView;
    private View mRootView;

    public static LiveTabGameSubFragment hU(boolean z) {
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
            this.ema = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.emL == null) {
            this.emL = new AlaLiveTabGameModel(getPageContext(), this.emM);
        }
        this.emL.init();
        this.emL.cO(this.emF, this.emG);
        registerListener(this.emH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.ema) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.emJ = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.emC = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new h(getPageContext());
        this.emJ.setProgressView(this.mPullView);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.emK = new b(getPageContext(), this.BK);
        this.elM = new PbListView(this.mContext);
        this.elM.createView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.elM.setLineGone();
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elM.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.BK.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.emN);
        a(this.emO);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<m> list) {
        this.emK.setData(list);
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
        this.emJ.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcI() {
        this.emJ.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.BK.setNextPage(this.elM);
            }
            this.elM.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.elM.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.elM.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcz() {
        if (this.elM != null) {
            if (this.elM.getView().getParent() == null) {
                this.BK.setNextPage(this.elM);
            }
            this.elM.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.elM.setText(this.mContext.getResources().getString(R.string.loading));
            this.elM.startLoadData();
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
        if (this.elM != null) {
            this.elM.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elM.changeSkin(i);
        }
        if (this.emK != null) {
            this.emK.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.emJ, R.color.cp_bg_line_e);
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
        if (this.emL != null) {
            this.emL.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.emL != null) {
            this.emL.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void AJ() {
        this.BK.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bcH() {
        if (this.emK != null) {
            this.emK.notifyDataSetChanged();
        }
    }
}
