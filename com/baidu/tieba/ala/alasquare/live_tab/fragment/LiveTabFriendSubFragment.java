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
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabFriendSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView Xc;
    private PbListView fTv;
    private BdSwipeRefreshLayout fUv;
    private a fUw;
    private AlaLiveTabFriendModel fUx;
    private g mPullView;
    private View mRootView;
    private int fUy = 0;
    private AlaLiveTabFriendModel.a fUz = new AlaLiveTabFriendModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void f(boolean z, List<q> list) {
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.SK();
            if (z) {
                LiveTabFriendSubFragment.this.bJV();
            } else {
                LiveTabFriendSubFragment.this.bJU();
            }
            LiveTabFriendSubFragment.this.bKf();
            LiveTabFriendSubFragment.this.setData(list);
            if (y.isEmpty(list)) {
                LiveTabFriendSubFragment.this.bKc();
            } else {
                LiveTabFriendSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void h(int i, String str, boolean z) {
            LiveTabFriendSubFragment.this.bKf();
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.SK();
            if (!z) {
                if (!LiveTabFriendSubFragment.this.fUx.hasData()) {
                    LiveTabFriendSubFragment.this.bJY();
                    return;
                } else {
                    LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
                    return;
                }
            }
            LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
        }
    };
    private f.c fUA = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabFriendSubFragment.this.fUx.refresh();
            } else {
                LiveTabFriendSubFragment.this.bKf();
            }
        }
    };
    private BdListView.e fUB = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabFriendSubFragment.this.bKg();
            } else {
                LiveTabFriendSubFragment.this.fUx.bJG();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabFriendSubFragment.this.fUr) {
                LiveTabFriendSubFragment.this.bKd();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fTL = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.fUx == null) {
            this.fUx = new AlaLiveTabFriendModel(getPageContext(), this.fUz);
            this.fTL = true;
        }
        this.fUx.init();
        registerListener(this.fUt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
            this.fUy = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
        }
        if (this.fTL) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.fUv = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fUp = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.fUv.setProgressView(this.mPullView);
        this.Xc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Xc.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Xc.setFadingEdgeLength(0);
        this.Xc.setOverScrollMode(2);
        this.fUw = new a(getPageContext(), this.Xc, 103);
        this.fTv = new PbListView(this.mContext);
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Xc.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.fUA);
        a(this.fUB);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        this.fUw.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Xc != null) {
            this.Xc.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.fUv.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKf() {
        this.fUv.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJU() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.Xc.setNextPage(this.fTv);
            }
            this.fTv.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fTv.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fTv.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJV() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.Xc.setNextPage(this.fTv);
            }
            this.fTv.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fTv.setText(this.mContext.getResources().getString(R.string.loading));
            this.fTv.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKg() {
        this.Xc.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.changeSkin(i);
        }
        if (this.fUw != null) {
            this.fUw.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fUv, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.Xc, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Xc != null) {
            this.Xc.removeOnScrollListener(this.mOnScrollListener);
            this.Xc.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.fUx != null) {
            this.fUx.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.fUx != null) {
            SK();
            showLoadingView();
            this.fUx.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Qi() {
        this.Xc.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bKe() {
        if (this.fUw != null) {
            this.fUw.notifyDataSetChanged();
        }
    }

    private void showLoadingView() {
        this.fUp.setVisibility(0);
        super.showLoadingView(this.fUp, false, this.fUy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.fUp.setVisibility(8);
        super.hideLoadingView(this.fUp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJY() {
        this.fUp.setVisibility(0);
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetworkAvailableForImmediately()) {
                        LiveTabFriendSubFragment.this.loadData();
                    }
                }
            });
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.ri(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rk(0);
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.fUp, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
        this.fUp.setVisibility(8);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.fUp);
            this.mRefreshView = null;
        }
    }
}
