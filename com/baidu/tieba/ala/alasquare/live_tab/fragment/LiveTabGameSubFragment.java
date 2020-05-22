package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.s;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveTabGameSubFragment extends LiveTabBaseSubFragment implements an {
    private BdTypeRecyclerView Vw;
    private PbListView fbY;
    private BdSwipeRefreshLayout fcW;
    private b fcX;
    private AlaLiveTabGameModel fcY;
    private AlaLiveTabGameModel.a fcZ = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void d(boolean z, List<o> list) {
            if (z) {
                LiveTabGameSubFragment.this.bqK();
            } else {
                LiveTabGameSubFragment.this.bqJ();
            }
            LiveTabGameSubFragment.this.bqV();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void g(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bqV();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fda = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.fcY.refresh();
            } else {
                LiveTabGameSubFragment.this.bqV();
            }
        }
    };
    private BdListView.e fdb = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.fcY.bqv();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.fcS) {
                LiveTabGameSubFragment.this.bqT();
            }
        }
    };
    private g mPullView;
    private View mRootView;

    public static LiveTabGameSubFragment jm(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabGameSubFragment liveTabGameSubFragment = new LiveTabGameSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabGameSubFragment.setArguments(bundle);
        return liveTabGameSubFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fcn = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.fcY == null) {
            this.fcY = new AlaLiveTabGameModel(getPageContext(), this.fcZ);
        }
        this.fcY.init();
        this.fcY.dy(this.evm, this.fcT);
        registerListener(this.fcU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.fcn) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.fcW = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fcQ = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.fcW.setProgressView(this.mPullView);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Vw.setFadingEdgeLength(0);
        this.Vw.setOverScrollMode(2);
        this.fcX = new b(getPageContext(), this.Vw);
        this.fcX.jl(aSr());
        this.fbY = new PbListView(this.mContext);
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fbY.setLineGone();
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Vw.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.fda);
        a(this.fdb);
        if (aSr()) {
            this.fcW.setEnabled(false);
            this.fcW.interruptRefresh();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<o> list) {
        if (v.isEmpty(list)) {
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(new p());
        }
        this.fcX.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Vw != null) {
            this.Vw.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (aSr()) {
            s sVar = new s();
            sVar.tabId = 1121;
            sVar.eIo = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
            return;
        }
        this.fcW.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqV() {
        if (aSr()) {
            s sVar = new s();
            sVar.tabId = 1121;
            sVar.eIo = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
            return;
        }
        this.fcW.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqJ() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.Vw.setNextPage(this.fbY);
            }
            this.fbY.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fbY.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fbY.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqK() {
        if (this.fbY != null) {
            if (this.fbY.getView().getParent() == null) {
                this.Vw.setNextPage(this.fbY);
            }
            this.fbY.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fbY.setText(this.mContext.getResources().getString(R.string.loading));
            this.fbY.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Vw.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fbY != null) {
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fbY.changeSkin(i);
        }
        if (this.fcX != null) {
            this.fcX.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.fcW, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Vw, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Vw != null) {
            this.Vw.removeOnScrollListener(this.mOnScrollListener);
            this.Vw.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.fcY != null) {
            this.fcY.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.fcY != null) {
            this.fcY.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Ho() {
        this.Vw.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bqU() {
        if (this.fcX != null) {
            this.fcX.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aWo() {
        if (j.isNetWorkAvailable()) {
            this.fcY.refresh();
        } else {
            bqV();
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aWp() {
    }
}
