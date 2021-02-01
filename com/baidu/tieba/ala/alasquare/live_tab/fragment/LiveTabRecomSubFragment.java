package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
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
/* loaded from: classes10.dex */
public class LiveTabRecomSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView XW;
    private PbListView gAi;
    private BdSwipeRefreshLayout gBi;
    private a gBj;
    private AlaLiveTabRecomModel gBu;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabRecomModel.a gBv = new AlaLiveTabRecomModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.a
        public void f(boolean z, List<n> list) {
            if (z) {
                LiveTabRecomSubFragment.this.bRr();
            } else {
                LiveTabRecomSubFragment.this.bRq();
            }
            LiveTabRecomSubFragment.this.bRB();
            LiveTabRecomSubFragment.this.setData(list);
            if (y.isEmpty(list)) {
                LiveTabRecomSubFragment.this.bRy();
            } else {
                LiveTabRecomSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.a
        public void g(int i, String str, boolean z) {
            LiveTabRecomSubFragment.this.bRB();
            if (z) {
                LiveTabRecomSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c gBn = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabRecomSubFragment.this.gBu.refresh();
            } else {
                LiveTabRecomSubFragment.this.bRB();
            }
        }
    };
    private BdListView.e gBo = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabRecomSubFragment.this.hideLoadingView();
            } else {
                LiveTabRecomSubFragment.this.gBu.bRc();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.4
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabRecomSubFragment.this.gBe) {
                LiveTabRecomSubFragment.this.bRz();
            }
        }
    };

    public static LiveTabRecomSubFragment mz(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabRecomSubFragment liveTabRecomSubFragment = new LiveTabRecomSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabRecomSubFragment.setArguments(bundle);
        return liveTabRecomSubFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gAy = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gBu == null) {
            this.gBu = new AlaLiveTabRecomModel(getPageContext(), this.gBv);
        }
        this.gBu.init();
        registerListener(this.gBg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.gAy) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gBi = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gBc = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gBi.setProgressView(this.mPullView);
        this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.XW.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        this.gBj = new a(getPageContext(), this.XW, 101);
        this.gAi = new PbListView(this.mContext);
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.transparent);
        this.gAi.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.XW.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gBn);
        a(this.gBo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<n> list) {
        this.gBj.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.XW != null) {
            this.XW.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.gBi.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRB() {
        this.gBi.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRq() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.XW.setNextPage(this.gAi);
            }
            this.gAi.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gAi.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gAi.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRr() {
        if (this.gAi != null) {
            if (this.gAi.getView().getParent() == null) {
                this.XW.setNextPage(this.gAi);
            }
            this.gAi.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gAi.setText(this.mContext.getResources().getString(R.string.loading));
            this.gAi.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.XW.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAi.changeSkin(i);
        }
        if (this.gBj != null) {
            this.gBj.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.XW != null) {
            this.XW.removeOnScrollListener(this.mOnScrollListener);
            this.XW.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gBu != null) {
            this.gBu.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gBu != null) {
            this.gBu.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Ut() {
        this.XW.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bRA() {
        if (this.gBj != null) {
            this.gBj.notifyDataSetChanged();
        }
    }
}
