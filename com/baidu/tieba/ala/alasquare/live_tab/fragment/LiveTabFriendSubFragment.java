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
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel;
import java.util.List;
/* loaded from: classes6.dex */
public class LiveTabFriendSubFragment extends LiveTabBaseSubFragment {
    private BdTypeRecyclerView Yf;
    private PbListView grg;
    private BdSwipeRefreshLayout gsg;
    private a gsh;
    private AlaLiveTabFriendModel gsi;
    private int gsj = 0;
    private AlaLiveTabFriendModel.a gsk = new AlaLiveTabFriendModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void e(boolean z, List<q> list) {
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.Yb();
            if (z) {
                LiveTabFriendSubFragment.this.bSc();
            } else {
                LiveTabFriendSubFragment.this.bSb();
            }
            LiveTabFriendSubFragment.this.bSm();
            LiveTabFriendSubFragment.this.setData(list);
            if (y.isEmpty(list)) {
                LiveTabFriendSubFragment.this.bSj();
            } else {
                LiveTabFriendSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void h(int i, String str, boolean z) {
            LiveTabFriendSubFragment.this.bSm();
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.Yb();
            if (!z) {
                if (!LiveTabFriendSubFragment.this.gsi.hasData()) {
                    LiveTabFriendSubFragment.this.bSf();
                    return;
                } else {
                    LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
                    return;
                }
            }
            LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
        }
    };
    private f.c gsl = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabFriendSubFragment.this.gsi.refresh();
            } else {
                LiveTabFriendSubFragment.this.bSm();
            }
        }
    };
    private BdListView.e gsm = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabFriendSubFragment.this.bSn();
            } else {
                LiveTabFriendSubFragment.this.gsi.bRN();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabFriendSubFragment.this.gsc) {
                LiveTabFriendSubFragment.this.bSk();
            }
        }
    };
    private g mPullView;
    private View mRootView;

    public static LiveTabFriendSubFragment ma(boolean z) {
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
            this.grw = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gsi == null) {
            this.gsi = new AlaLiveTabFriendModel(getPageContext(), this.gsk);
            this.grw = true;
        }
        this.gsi.init();
        registerListener(this.gse);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
            if (viewGroup != null) {
                this.gsj = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            }
        }
        if (this.grw) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gsg = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gsa = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gsg.setProgressView(this.mPullView);
        this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        this.gsh = new a(getPageContext(), this.Yf, 103);
        this.grg = new PbListView(this.mContext);
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.transparent);
        this.grg.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Yf.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gsl);
        a(this.gsm);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        this.gsh.setData(list);
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
        this.gsg.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSm() {
        this.gsg.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSb() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.Yf.setNextPage(this.grg);
            }
            this.grg.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.grg.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.grg.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSc() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.Yf.setNextPage(this.grg);
            }
            this.grg.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.grg.setText(this.mContext.getResources().getString(R.string.loading));
            this.grg.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSn() {
        this.Yf.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.grg.changeSkin(i);
        }
        if (this.gsh != null) {
            this.gsh.notifyDataSetChanged();
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
        if (this.gsi != null) {
            this.gsi.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gsi != null) {
            Yb();
            showLoadingView();
            this.gsi.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void VC() {
        this.Yf.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bSl() {
        if (this.gsh != null) {
            this.gsh.notifyDataSetChanged();
        }
    }

    private void showLoadingView() {
        this.gsa.setVisibility(0);
        super.showLoadingView(this.gsa, false, this.gsj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gsa.setVisibility(8);
        super.hideLoadingView(this.gsa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSf() {
        this.gsa.setVisibility(0);
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
        this.mRefreshView.sC(R.drawable.new_pic_emotion_08);
        this.mRefreshView.sE(0);
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.gsa, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yb() {
        this.gsa.setVisibility(8);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gsa);
            this.mRefreshView = null;
        }
    }
}
