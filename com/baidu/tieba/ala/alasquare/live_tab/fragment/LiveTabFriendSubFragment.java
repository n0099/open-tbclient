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
    private BdTypeRecyclerView Xi;
    private PbListView giV;
    private BdSwipeRefreshLayout gjV;
    private a gjW;
    private AlaLiveTabFriendModel gjX;
    private int gjY = 0;
    private AlaLiveTabFriendModel.a gjZ = new AlaLiveTabFriendModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void e(boolean z, List<q> list) {
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.VB();
            if (z) {
                LiveTabFriendSubFragment.this.bOq();
            } else {
                LiveTabFriendSubFragment.this.bOp();
            }
            LiveTabFriendSubFragment.this.bOA();
            LiveTabFriendSubFragment.this.setData(list);
            if (y.isEmpty(list)) {
                LiveTabFriendSubFragment.this.bOx();
            } else {
                LiveTabFriendSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void h(int i, String str, boolean z) {
            LiveTabFriendSubFragment.this.bOA();
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.VB();
            if (!z) {
                if (!LiveTabFriendSubFragment.this.gjX.hasData()) {
                    LiveTabFriendSubFragment.this.bOt();
                    return;
                } else {
                    LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
                    return;
                }
            }
            LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
        }
    };
    private f.c gka = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabFriendSubFragment.this.gjX.refresh();
            } else {
                LiveTabFriendSubFragment.this.bOA();
            }
        }
    };
    private BdListView.e gkb = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabFriendSubFragment.this.bOB();
            } else {
                LiveTabFriendSubFragment.this.gjX.bOb();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabFriendSubFragment.this.gjR) {
                LiveTabFriendSubFragment.this.bOy();
            }
        }
    };
    private g mPullView;
    private View mRootView;

    public static LiveTabFriendSubFragment lF(boolean z) {
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
            this.gjl = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gjX == null) {
            this.gjX = new AlaLiveTabFriendModel(getPageContext(), this.gjZ);
            this.gjl = true;
        }
        this.gjX.init();
        registerListener(this.gjT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
            if (viewGroup != null) {
                this.gjY = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            }
        }
        if (this.gjl) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gjV = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gjP = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gjV.setProgressView(this.mPullView);
        this.Xi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Xi.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Xi.setFadingEdgeLength(0);
        this.Xi.setOverScrollMode(2);
        this.gjW = new a(getPageContext(), this.Xi, 103);
        this.giV = new PbListView(this.mContext);
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.transparent);
        this.giV.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Xi.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gka);
        a(this.gkb);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        this.gjW.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Xi != null) {
            this.Xi.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        this.gjV.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOA() {
        this.gjV.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOp() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Xi.setNextPage(this.giV);
            }
            this.giV.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.giV.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.giV.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOq() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Xi.setNextPage(this.giV);
            }
            this.giV.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.giV.setText(this.mContext.getResources().getString(R.string.loading));
            this.giV.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOB() {
        this.Xi.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.changeSkin(i);
        }
        if (this.gjW != null) {
            this.gjW.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Xi != null) {
            this.Xi.removeOnScrollListener(this.mOnScrollListener);
            this.Xi.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gjX != null) {
            this.gjX.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gjX != null) {
            VB();
            showLoadingView();
            this.gjX.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Tc() {
        this.Xi.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bOz() {
        if (this.gjW != null) {
            this.gjW.notifyDataSetChanged();
        }
    }

    private void showLoadingView() {
        this.gjP.setVisibility(0);
        super.showLoadingView(this.gjP, false, this.gjY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gjP.setVisibility(8);
        super.hideLoadingView(this.gjP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOt() {
        this.gjP.setVisibility(0);
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
        this.mRefreshView.sb(R.drawable.new_pic_emotion_08);
        this.mRefreshView.sd(0);
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.gjP, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        this.gjP.setVisibility(8);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gjP);
            this.mRefreshView = null;
        }
    }
}
