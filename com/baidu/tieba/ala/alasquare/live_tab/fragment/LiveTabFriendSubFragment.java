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
/* loaded from: classes10.dex */
public class LiveTabFriendSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView Yc;
    private PbListView gCf;
    private BdSwipeRefreshLayout gDf;
    private a gDg;
    private AlaLiveTabFriendModel gDh;
    private int gDi = 0;
    private AlaLiveTabFriendModel.a gDj = new AlaLiveTabFriendModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void f(boolean z, List<n> list) {
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.Zi();
            if (z) {
                LiveTabFriendSubFragment.this.bUE();
            } else {
                LiveTabFriendSubFragment.this.bUD();
            }
            LiveTabFriendSubFragment.this.bUO();
            LiveTabFriendSubFragment.this.setData(list);
            if (x.isEmpty(list)) {
                LiveTabFriendSubFragment.this.bUL();
            } else {
                LiveTabFriendSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void h(int i, String str, boolean z) {
            LiveTabFriendSubFragment.this.bUO();
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.Zi();
            if (!z) {
                if (!LiveTabFriendSubFragment.this.gDh.hasData()) {
                    LiveTabFriendSubFragment.this.bUH();
                    return;
                } else {
                    LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
                    return;
                }
            }
            LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
        }
    };
    private f.c gDk = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabFriendSubFragment.this.gDh.refresh();
            } else {
                LiveTabFriendSubFragment.this.bUO();
            }
        }
    };
    private BdListView.e gDl = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabFriendSubFragment.this.bUP();
            } else {
                LiveTabFriendSubFragment.this.gDh.bUp();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.4
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabFriendSubFragment.this.gDb) {
                LiveTabFriendSubFragment.this.bUM();
            }
        }
    };
    private g mPullView;
    private View mRootView;

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
            this.gCv = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gDh == null) {
            this.gDh = new AlaLiveTabFriendModel(getPageContext(), this.gDj);
            this.gCv = true;
        }
        this.gDh.init();
        registerListener(this.gDd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
            if (viewGroup != null) {
                this.gDi = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            }
        }
        if (this.gCv) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gDf = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gCZ = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gDf.setProgressView(this.mPullView);
        this.Yc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Yc.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Yc.setFadingEdgeLength(0);
        this.Yc.setOverScrollMode(2);
        this.gDg = new a(getPageContext(), this.Yc, 103);
        this.gCf = new PbListView(this.mContext);
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Yc.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gDk);
        a(this.gDl);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<n> list) {
        this.gDg.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Yc != null) {
            this.Yc.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.gDf.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUO() {
        this.gDf.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yc.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gCf.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yc.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gCf.setText(this.mContext.getResources().getString(R.string.loading));
            this.gCf.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUP() {
        this.Yc.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.gDg != null) {
            this.gDg.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Yc != null) {
            this.Yc.removeOnScrollListener(this.mOnScrollListener);
            this.Yc.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gDh != null) {
            this.gDh.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gDh != null) {
            Zi();
            showLoadingView();
            this.gDh.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void WE() {
        this.Yc.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bUN() {
        if (this.gDg != null) {
            this.gDg.notifyDataSetChanged();
        }
    }

    private void showLoadingView() {
        this.gCZ.setVisibility(0);
        super.showLoadingView(this.gCZ, false, this.gDi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gCZ.setVisibility(8);
        super.hideLoadingView(this.gCZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUH() {
        this.gCZ.setVisibility(0);
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
        this.mRefreshView.sO(R.drawable.new_pic_emotion_08);
        this.mRefreshView.sQ(0);
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.gCZ, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi() {
        this.gCZ.setVisibility(8);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gCZ);
            this.mRefreshView = null;
        }
    }
}
