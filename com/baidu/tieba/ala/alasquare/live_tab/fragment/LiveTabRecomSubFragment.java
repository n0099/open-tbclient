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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveTabRecomSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView Wa;
    private PbListView fnt;

    /* renamed from: for  reason: not valid java name */
    private BdSwipeRefreshLayout f4for;
    private a foy;
    private AlaLiveTabRecomModel foz;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabRecomModel.a foA = new AlaLiveTabRecomModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.a
        public void e(boolean z, List<q> list) {
            if (z) {
                LiveTabRecomSubFragment.this.btK();
            } else {
                LiveTabRecomSubFragment.this.btJ();
            }
            LiveTabRecomSubFragment.this.btV();
            LiveTabRecomSubFragment.this.setData(list);
            if (w.isEmpty(list)) {
                LiveTabRecomSubFragment.this.btS();
            } else {
                LiveTabRecomSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.a
        public void g(int i, String str, boolean z) {
            LiveTabRecomSubFragment.this.btV();
            if (z) {
                LiveTabRecomSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fov = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabRecomSubFragment.this.foz.refresh();
            } else {
                LiveTabRecomSubFragment.this.btV();
            }
        }
    };
    private BdListView.e fow = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabRecomSubFragment.this.hideLoadingView();
            } else {
                LiveTabRecomSubFragment.this.foz.btv();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabRecomSubFragment.this.fon) {
                LiveTabRecomSubFragment.this.btT();
            }
        }
    };

    public static LiveTabRecomSubFragment jA(boolean z) {
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
            this.fnI = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.foz == null) {
            this.foz = new AlaLiveTabRecomModel(getPageContext(), this.foA);
        }
        this.foz.init();
        registerListener(this.fop);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.fnI) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.f4for = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fol = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.f4for.setProgressView(this.mPullView);
        this.Wa = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Wa.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Wa.setFadingEdgeLength(0);
        this.Wa.setOverScrollMode(2);
        this.foy = new a(getPageContext(), this.Wa, 101);
        this.fnt = new PbListView(this.mContext);
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Wa.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.fov);
        a(this.fow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        this.foy.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Wa != null) {
            this.Wa.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.f4for.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btV() {
        this.f4for.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btJ() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.Wa.setNextPage(this.fnt);
            }
            this.fnt.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fnt.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fnt.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btK() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.Wa.setNextPage(this.fnt);
            }
            this.fnt.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fnt.setText(this.mContext.getResources().getString(R.string.loading));
            this.fnt.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Wa.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.changeSkin(i);
        }
        if (this.foy != null) {
            this.foy.notifyDataSetChanged();
        }
        an.setBackgroundColor(this.f4for, R.color.cp_bg_line_e);
        an.setBackgroundColor(this.Wa, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Wa != null) {
            this.Wa.removeOnScrollListener(this.mOnScrollListener);
            this.Wa.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.foz != null) {
            this.foz.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.foz != null) {
            this.foz.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void IB() {
        this.Wa.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void btU() {
        if (this.foy != null) {
            this.foy.notifyDataSetChanged();
        }
    }
}
