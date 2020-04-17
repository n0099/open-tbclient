package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.s;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements an {
    private BdTypeRecyclerView Vf;
    private PbListView ePm;
    private BdSwipeRefreshLayout eQj;
    private a eQq;
    private AlaLiveTabYanzhiModel eQu;
    private h mPullView;
    private View mRootView;
    private AlaLiveTabYanzhiModel.a eQv = new AlaLiveTabYanzhiModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void d(boolean z, List<m> list) {
            if (z) {
                LiveTabYanzhiSubFragment.this.blq();
            } else {
                LiveTabYanzhiSubFragment.this.blp();
            }
            LiveTabYanzhiSubFragment.this.blz();
            LiveTabYanzhiSubFragment.this.setData(list);
            if (v.isEmpty(list)) {
                LiveTabYanzhiSubFragment.this.aqF();
            } else {
                LiveTabYanzhiSubFragment.this.hideEmptyView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void f(int i, String str, boolean z) {
            LiveTabYanzhiSubFragment.this.blz();
            if (z) {
                LiveTabYanzhiSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private g.c eQn = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.2
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabYanzhiSubFragment.this.eQu.refresh();
            } else {
                LiveTabYanzhiSubFragment.this.blz();
            }
        }
    };
    private BdListView.e eQo = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabYanzhiSubFragment.this.hideLoadingView();
            } else {
                LiveTabYanzhiSubFragment.this.eQu.blb();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            Log.e("D444", "dy" + i2 + ", dx" + i);
            if (i2 >= 4 && !LiveTabYanzhiSubFragment.this.eQe) {
                LiveTabYanzhiSubFragment.this.blx();
            }
        }
    };

    public static LiveTabYanzhiSubFragment iV(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabYanzhiSubFragment liveTabYanzhiSubFragment = new LiveTabYanzhiSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabYanzhiSubFragment.setArguments(bundle);
        return liveTabYanzhiSubFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ePA = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.eQu == null) {
            this.eQu = new AlaLiveTabYanzhiModel(getPageContext(), this.eQv);
        }
        this.eQu.init();
        this.eQu.da(this.eQf, this.eQg);
        registerListener(this.eQh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.ePA) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.eQj = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.eQc = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new h(getPageContext());
        this.eQj.setProgressView(this.mPullView);
        this.Vf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Vf.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Vf.setFadingEdgeLength(0);
        this.Vf.setOverScrollMode(2);
        this.eQq = new a(getPageContext(), this.Vf, 102);
        this.ePm = new PbListView(this.mContext);
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Vf.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.eQn);
        a(this.eQo);
        if (aMu()) {
            this.eQj.setEnabled(false);
            this.eQj.interruptRefresh();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<m> list) {
        this.eQq.setData(list);
    }

    private void setListPullRefreshListener(g.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Vf != null) {
            this.Vf.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (aMu()) {
            s sVar = new s();
            sVar.tabId = 1120;
            sVar.etK = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
            return;
        }
        this.eQj.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blz() {
        if (aMu()) {
            s sVar = new s();
            sVar.tabId = 1120;
            sVar.etK = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
            return;
        }
        this.eQj.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blp() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.Vf.setNextPage(this.ePm);
            }
            this.ePm.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.ePm.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.ePm.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blq() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.Vf.setNextPage(this.ePm);
            }
            this.ePm.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.ePm.setText(this.mContext.getResources().getString(R.string.loading));
            this.ePm.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Vf.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePm.changeSkin(i);
        }
        if (this.eQq != null) {
            this.eQq.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.eQj, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.Vf, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Vf != null) {
            this.Vf.removeOnScrollListener(this.mOnScrollListener);
            this.Vf.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.eQu != null) {
            this.eQu.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.eQu != null) {
            this.eQu.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void FH() {
        this.Vf.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bly() {
        if (this.eQq != null) {
            this.eQq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aQn() {
        if (j.isNetWorkAvailable()) {
            this.eQu.refresh();
        } else {
            blz();
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aQo() {
    }
}
