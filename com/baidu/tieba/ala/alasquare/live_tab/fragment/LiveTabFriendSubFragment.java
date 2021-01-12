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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel;
import java.util.List;
/* loaded from: classes9.dex */
public class LiveTabFriendSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView Ya;
    private PbListView gxy;
    private AlaLiveTabFriendModel gyA;
    private BdSwipeRefreshLayout gyy;
    private a gyz;
    private g mPullView;
    private View mRootView;
    private int gyB = 0;
    private AlaLiveTabFriendModel.a gyC = new AlaLiveTabFriendModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void f(boolean z, List<n> list) {
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.Vq();
            if (z) {
                LiveTabFriendSubFragment.this.bQN();
            } else {
                LiveTabFriendSubFragment.this.bQM();
            }
            LiveTabFriendSubFragment.this.bQX();
            LiveTabFriendSubFragment.this.setData(list);
            if (x.isEmpty(list)) {
                LiveTabFriendSubFragment.this.bQU();
            } else {
                LiveTabFriendSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void h(int i, String str, boolean z) {
            LiveTabFriendSubFragment.this.bQX();
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.Vq();
            if (!z) {
                if (!LiveTabFriendSubFragment.this.gyA.hasData()) {
                    LiveTabFriendSubFragment.this.bQQ();
                    return;
                } else {
                    LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
                    return;
                }
            }
            LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
        }
    };
    private f.c gyD = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabFriendSubFragment.this.gyA.refresh();
            } else {
                LiveTabFriendSubFragment.this.bQX();
            }
        }
    };
    private BdListView.e gyE = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabFriendSubFragment.this.bQY();
            } else {
                LiveTabFriendSubFragment.this.gyA.bQy();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.4
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabFriendSubFragment.this.gyu) {
                LiveTabFriendSubFragment.this.bQV();
            }
        }
    };

    public static LiveTabFriendSubFragment mt(boolean z) {
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
            this.gxO = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gyA == null) {
            this.gyA = new AlaLiveTabFriendModel(getPageContext(), this.gyC);
            this.gxO = true;
        }
        this.gyA.init();
        registerListener(this.gyw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
            if (viewGroup != null) {
                this.gyB = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            }
        }
        if (this.gxO) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gyy = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gys = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gyy.setProgressView(this.mPullView);
        this.Ya = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Ya.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Ya.setFadingEdgeLength(0);
        this.Ya.setOverScrollMode(2);
        this.gyz = new a(getPageContext(), this.Ya, 103);
        this.gxy = new PbListView(this.mContext);
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.transparent);
        this.gxy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Ya.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gyD);
        a(this.gyE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<n> list) {
        this.gyz.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Ya != null) {
            this.Ya.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.gyy.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQX() {
        this.gyy.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQM() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.Ya.setNextPage(this.gxy);
            }
            this.gxy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gxy.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gxy.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQN() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.Ya.setNextPage(this.gxy);
            }
            this.gxy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gxy.setText(this.mContext.getResources().getString(R.string.loading));
            this.gxy.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQY() {
        this.Ya.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.changeSkin(i);
        }
        if (this.gyz != null) {
            this.gyz.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Ya != null) {
            this.Ya.removeOnScrollListener(this.mOnScrollListener);
            this.Ya.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gyA != null) {
            this.gyA.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gyA != null) {
            Vq();
            showLoadingView();
            this.gyA.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void SM() {
        this.Ya.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bQW() {
        if (this.gyz != null) {
            this.gyz.notifyDataSetChanged();
        }
    }

    private void showLoadingView() {
        this.gys.setVisibility(0);
        super.showLoadingView(this.gys, false, this.gyB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gys.setVisibility(8);
        super.hideLoadingView(this.gys);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQQ() {
        this.gys.setVisibility(0);
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
        this.mRefreshView.attachView(this.gys, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        this.gys.setVisibility(8);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gys);
            this.mRefreshView = null;
        }
    }
}
