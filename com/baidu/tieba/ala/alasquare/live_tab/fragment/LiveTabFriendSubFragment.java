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
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel;
import java.util.List;
/* loaded from: classes10.dex */
public class LiveTabFriendSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView XW;
    private PbListView gAw;
    private BdSwipeRefreshLayout gBw;
    private a gBx;
    private AlaLiveTabFriendModel gBy;
    private g mPullView;
    private View mRootView;
    private int gBz = 0;
    private AlaLiveTabFriendModel.a gBA = new AlaLiveTabFriendModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void f(boolean z, List<n> list) {
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.WZ();
            if (z) {
                LiveTabFriendSubFragment.this.bRy();
            } else {
                LiveTabFriendSubFragment.this.bRx();
            }
            LiveTabFriendSubFragment.this.bRI();
            LiveTabFriendSubFragment.this.setData(list);
            if (y.isEmpty(list)) {
                LiveTabFriendSubFragment.this.bRF();
            } else {
                LiveTabFriendSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void g(int i, String str, boolean z) {
            LiveTabFriendSubFragment.this.bRI();
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.WZ();
            if (!z) {
                if (!LiveTabFriendSubFragment.this.gBy.hasData()) {
                    LiveTabFriendSubFragment.this.bRB();
                    return;
                } else {
                    LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
                    return;
                }
            }
            LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
        }
    };
    private f.c gBB = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabFriendSubFragment.this.gBy.refresh();
            } else {
                LiveTabFriendSubFragment.this.bRI();
            }
        }
    };
    private BdListView.e gBC = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabFriendSubFragment.this.bRJ();
            } else {
                LiveTabFriendSubFragment.this.gBy.bRj();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.4
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabFriendSubFragment.this.gBs) {
                LiveTabFriendSubFragment.this.bRG();
            }
        }
    };

    public static LiveTabFriendSubFragment mx(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabFriendSubFragment liveTabFriendSubFragment = new LiveTabFriendSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabFriendSubFragment.setArguments(bundle);
        return liveTabFriendSubFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gAM = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gBy == null) {
            this.gBy = new AlaLiveTabFriendModel(getPageContext(), this.gBA);
            this.gAM = true;
        }
        this.gBy.init();
        registerListener(this.gBu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
            if (viewGroup != null) {
                this.gBz = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            }
        }
        if (this.gAM) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gBw = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gBq = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gBw.setProgressView(this.mPullView);
        this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.XW.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        this.gBx = new a(getPageContext(), this.XW, 103);
        this.gAw = new PbListView(this.mContext);
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.transparent);
        this.gAw.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.XW.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gBB);
        a(this.gBC);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<n> list) {
        this.gBx.setData(list);
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
        this.gBw.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRI() {
        this.gBw.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRx() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.XW.setNextPage(this.gAw);
            }
            this.gAw.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gAw.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gAw.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.XW.setNextPage(this.gAw);
            }
            this.gAw.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gAw.setText(this.mContext.getResources().getString(R.string.loading));
            this.gAw.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRJ() {
        this.XW.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.changeSkin(i);
        }
        if (this.gBx != null) {
            this.gBx.notifyDataSetChanged();
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
        if (this.gBy != null) {
            this.gBy.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gBy != null) {
            WZ();
            showLoadingView();
            this.gBy.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Ut() {
        this.XW.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bRH() {
        if (this.gBx != null) {
            this.gBx.notifyDataSetChanged();
        }
    }

    private void showLoadingView() {
        this.gBq.setVisibility(0);
        super.showLoadingView(this.gBq, false, this.gBz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gBq.setVisibility(8);
        super.hideLoadingView(this.gBq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRB() {
        this.gBq.setVisibility(0);
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
        this.mRefreshView.rn(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rp(0);
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.gBq, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        this.gBq.setVisibility(8);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gBq);
            this.mRefreshView = null;
        }
    }
}
