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
    private PbListView gjo;
    private BdSwipeRefreshLayout gko;
    private a gkp;
    private AlaLiveTabFriendModel gkq;
    private int gkr = 0;
    private AlaLiveTabFriendModel.a gks = new AlaLiveTabFriendModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void e(boolean z, List<q> list) {
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.Wk();
            if (z) {
                LiveTabFriendSubFragment.this.bOX();
            } else {
                LiveTabFriendSubFragment.this.bOW();
            }
            LiveTabFriendSubFragment.this.bPh();
            LiveTabFriendSubFragment.this.setData(list);
            if (y.isEmpty(list)) {
                LiveTabFriendSubFragment.this.bPe();
            } else {
                LiveTabFriendSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.a
        public void h(int i, String str, boolean z) {
            LiveTabFriendSubFragment.this.bPh();
            LiveTabFriendSubFragment.this.hideLoadingView();
            LiveTabFriendSubFragment.this.Wk();
            if (!z) {
                if (!LiveTabFriendSubFragment.this.gkq.hasData()) {
                    LiveTabFriendSubFragment.this.bPa();
                    return;
                } else {
                    LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
                    return;
                }
            }
            LiveTabFriendSubFragment.this.showToast(R.string.data_load_error);
        }
    };
    private f.c gkt = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabFriendSubFragment.this.gkq.refresh();
            } else {
                LiveTabFriendSubFragment.this.bPh();
            }
        }
    };
    private BdListView.e gku = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabFriendSubFragment.this.bPi();
            } else {
                LiveTabFriendSubFragment.this.gkq.bOI();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabFriendSubFragment.this.gkk) {
                LiveTabFriendSubFragment.this.bPf();
            }
        }
    };
    private g mPullView;
    private View mRootView;

    public static LiveTabFriendSubFragment lE(boolean z) {
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
            this.gjE = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gkq == null) {
            this.gkq = new AlaLiveTabFriendModel(getPageContext(), this.gks);
            this.gjE = true;
        }
        this.gkq.init();
        registerListener(this.gkm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
            if (viewGroup != null) {
                this.gkr = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            }
        }
        if (this.gjE) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gko = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gki = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gko.setProgressView(this.mPullView);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.gkp = new a(getPageContext(), this.Xe, 103);
        this.gjo = new PbListView(this.mContext);
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Xe.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gkt);
        a(this.gku);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        this.gkp.setData(list);
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
        this.gko.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPh() {
        this.gko.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOW() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.Xe.setNextPage(this.gjo);
            }
            this.gjo.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gjo.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gjo.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOX() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.Xe.setNextPage(this.gjo);
            }
            this.gjo.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gjo.setText(this.mContext.getResources().getString(R.string.loading));
            this.gjo.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPi() {
        this.Xe.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gjo.changeSkin(i);
        }
        if (this.gkp != null) {
            this.gkp.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gko, R.color.cp_bg_line_e);
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
        if (this.gkq != null) {
            this.gkq.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gkq != null) {
            Wk();
            showLoadingView();
            this.gkq.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void TL() {
        this.Xe.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bPg() {
        if (this.gkp != null) {
            this.gkp.notifyDataSetChanged();
        }
    }

    private void showLoadingView() {
        this.gki.setVisibility(0);
        super.showLoadingView(this.gki, false, this.gkr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.gki.setVisibility(8);
        super.hideLoadingView(this.gki);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPa() {
        this.gki.setVisibility(0);
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
        this.mRefreshView.rD(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rF(0);
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.gki, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wk() {
        this.gki.setVisibility(8);
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.gki);
            this.mRefreshView = null;
        }
    }
}
