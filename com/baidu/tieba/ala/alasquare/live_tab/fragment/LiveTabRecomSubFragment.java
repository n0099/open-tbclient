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
/* loaded from: classes6.dex */
public class LiveTabRecomSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView Yf;
    private PbListView gre;
    private BdSwipeRefreshLayout gse;
    private a gsf;
    private AlaLiveTabRecomModel gsq;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabRecomModel.a gsr = new AlaLiveTabRecomModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.a
        public void e(boolean z, List<q> list) {
            if (z) {
                LiveTabRecomSubFragment.this.bSb();
            } else {
                LiveTabRecomSubFragment.this.bSa();
            }
            LiveTabRecomSubFragment.this.bSl();
            LiveTabRecomSubFragment.this.setData(list);
            if (y.isEmpty(list)) {
                LiveTabRecomSubFragment.this.bSi();
            } else {
                LiveTabRecomSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.a
        public void h(int i, String str, boolean z) {
            LiveTabRecomSubFragment.this.bSl();
            if (z) {
                LiveTabRecomSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c gsj = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabRecomSubFragment.this.gsq.refresh();
            } else {
                LiveTabRecomSubFragment.this.bSl();
            }
        }
    };
    private BdListView.e gsk = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabRecomSubFragment.this.hideLoadingView();
            } else {
                LiveTabRecomSubFragment.this.gsq.bRM();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabRecomSubFragment.this.gsa) {
                LiveTabRecomSubFragment.this.bSj();
            }
        }
    };

    public static LiveTabRecomSubFragment mc(boolean z) {
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
            this.gru = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gsq == null) {
            this.gsq = new AlaLiveTabRecomModel(getPageContext(), this.gsr);
        }
        this.gsq.init();
        registerListener(this.gsc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.gru) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gse = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.grY = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gse.setProgressView(this.mPullView);
        this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        this.gsf = new a(getPageContext(), this.Yf, 101);
        this.gre = new PbListView(this.mContext);
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.transparent);
        this.gre.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Yf.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gsj);
        a(this.gsk);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        this.gsf.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Yf != null) {
            this.Yf.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.gse.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSl() {
        this.gse.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSa() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.Yf.setNextPage(this.gre);
            }
            this.gre.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gre.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gre.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSb() {
        if (this.gre != null) {
            if (this.gre.getView().getParent() == null) {
                this.Yf.setNextPage(this.gre);
            }
            this.gre.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gre.setText(this.mContext.getResources().getString(R.string.loading));
            this.gre.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Yf.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gre.changeSkin(i);
        }
        if (this.gsf != null) {
            this.gsf.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Yf != null) {
            this.Yf.removeOnScrollListener(this.mOnScrollListener);
            this.Yf.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gsq != null) {
            this.gsq.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gsq != null) {
            this.gsq.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void VC() {
        this.Yf.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bSk() {
        if (this.gsf != null) {
            this.gsf.notifyDataSetChanged();
        }
    }
}
