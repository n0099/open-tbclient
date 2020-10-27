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
    private BdTypeRecyclerView Xe;
    private PbListView gdy;
    private a geA;
    private AlaLiveTabFriendModel geB;
    private BdSwipeRefreshLayout gez;
    private g mPullView;
    private View mRootView;
    private int geC = 0;
    private AlaLiveTabFriendModel.a geD = new AlaLiveTabFriendModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void e(boolean z, List<q> list) {
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.TK();
            if (z) {
                LiveTabFriendSubFragment.this.bMx();
            } else {
                LiveTabFriendSubFragment.this.bMw();
            }
            LiveTabFriendSubFragment.this.bMH();
            LiveTabFriendSubFragment.this.setData(list);
            if (y.isEmpty(list)) {
                LiveTabFriendSubFragment.this.bME();
            } else {
                LiveTabFriendSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void h(int i, String str, boolean z) {
            LiveTabFriendSubFragment.this.bMH();
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.TK();
            if (!z) {
                if (!LiveTabFriendSubFragment.this.geB.hasData()) {
                    LiveTabFriendSubFragment.this.bMA();
                    return;
                } else {
                    LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
                    return;
                }
            }
            LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
        }
    };
    private f.c geE = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabFriendSubFragment.this.geB.refresh();
            } else {
                LiveTabFriendSubFragment.this.bMH();
            }
        }
    };
    private BdListView.e geF = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabFriendSubFragment.this.bMI();
            } else {
                LiveTabFriendSubFragment.this.geB.bMi();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabFriendSubFragment.this.gev) {
                LiveTabFriendSubFragment.this.bMF();
            }
        }
    };

    public static LiveTabFriendSubFragment lv(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabFriendSubFragment liveTabFriendSubFragment = new LiveTabFriendSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabFriendSubFragment.setArguments(bundle);
        return liveTabFriendSubFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gdO = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.geB == null) {
            this.geB = new AlaLiveTabFriendModel(getPageContext(), this.geD);
            this.gdO = true;
        }
        this.geB.init();
        registerListener(this.gex);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
            this.geC = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
        }
        if (this.gdO) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gez = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.get = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gez.setProgressView(this.mPullView);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.geA = new a(getPageContext(), this.Xe, 103);
        this.gdy = new PbListView(this.mContext);
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Xe.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.geE);
        a(this.geF);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        this.geA.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Xe != null) {
            this.Xe.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.gez.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMH() {
        this.gez.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMw() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.Xe.setNextPage(this.gdy);
            }
            this.gdy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gdy.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gdy.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMx() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.Xe.setNextPage(this.gdy);
            }
            this.gdy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gdy.setText(this.mContext.getResources().getString(R.string.loading));
            this.gdy.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMI() {
        this.Xe.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.changeSkin(i);
        }
        if (this.geA != null) {
            this.geA.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gez, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Xe != null) {
            this.Xe.removeOnScrollListener(this.mOnScrollListener);
            this.Xe.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.geB != null) {
            this.geB.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.geB != null) {
            TK();
            showLoadingView();
            this.geB.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Rd() {
        this.Xe.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bMG() {
        if (this.geA != null) {
            this.geA.notifyDataSetChanged();
        }
    }

    private void showLoadingView() {
        this.get.setVisibility(0);
        super.showLoadingView(this.get, false, this.geC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.get.setVisibility(8);
        super.hideLoadingView(this.get);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMA() {
        this.get.setVisibility(0);
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
        this.mRefreshView.rt(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rv(0);
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.get, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TK() {
        this.get.setVisibility(8);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.get);
            this.mRefreshView = null;
        }
    }
}
