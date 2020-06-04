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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.s;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements an {
    private BdTypeRecyclerView Vw;
    private PbListView fcj;
    private BdSwipeRefreshLayout fdh;
    private a fdo;
    private AlaLiveTabYanzhiModel fds;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabYanzhiModel.a fdt = new AlaLiveTabYanzhiModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void d(boolean z, List<o> list) {
            if (z) {
                LiveTabYanzhiSubFragment.this.bqM();
            } else {
                LiveTabYanzhiSubFragment.this.bqL();
            }
            LiveTabYanzhiSubFragment.this.bqX();
            LiveTabYanzhiSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void g(int i, String str, boolean z) {
            LiveTabYanzhiSubFragment.this.bqX();
            if (z) {
                LiveTabYanzhiSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fdl = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabYanzhiSubFragment.this.fds.refresh();
            } else {
                LiveTabYanzhiSubFragment.this.bqX();
            }
        }
    };
    private BdListView.e fdm = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabYanzhiSubFragment.this.hideLoadingView();
            } else {
                LiveTabYanzhiSubFragment.this.fds.bqx();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            Log.e("D444", "dy" + i2 + ", dx" + i);
            if (i2 >= 4 && !LiveTabYanzhiSubFragment.this.fdd) {
                LiveTabYanzhiSubFragment.this.bqV();
            }
        }
    };

    public static LiveTabYanzhiSubFragment jo(boolean z) {
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
            this.fcy = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.fds == null) {
            this.fds = new AlaLiveTabYanzhiModel(getPageContext(), this.fdt);
        }
        this.fds.init();
        this.fds.dy(this.evm, this.fde);
        registerListener(this.fdf);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.fcy) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.fdh = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fdb = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.fdh.setProgressView(this.mPullView);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Vw.setFadingEdgeLength(0);
        this.Vw.setOverScrollMode(2);
        this.fdo = new a(getPageContext(), this.Vw, 102);
        this.fcj = new PbListView(this.mContext);
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fcj.setLineGone();
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fcj.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Vw.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.fdl);
        a(this.fdm);
        if (aSr()) {
            this.fdh.setEnabled(false);
            this.fdh.interruptRefresh();
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
        this.fdo.setData(list);
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
            sVar.tabId = 1120;
            sVar.eIz = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
            return;
        }
        this.fdh.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqX() {
        if (aSr()) {
            s sVar = new s();
            sVar.tabId = 1120;
            sVar.eIz = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
            return;
        }
        this.fdh.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqL() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.Vw.setNextPage(this.fcj);
            }
            this.fcj.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fcj.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fcj.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqM() {
        if (this.fcj != null) {
            if (this.fcj.getView().getParent() == null) {
                this.Vw.setNextPage(this.fcj);
            }
            this.fcj.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fcj.setText(this.mContext.getResources().getString(R.string.loading));
            this.fcj.startLoadData();
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
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fcj.changeSkin(i);
        }
        if (this.fdo != null) {
            this.fdo.notifyDataSetChanged();
        }
        am.setBackgroundColor(this.fdh, R.color.cp_bg_line_e);
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
        if (this.fds != null) {
            this.fds.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.fds != null) {
            this.fds.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Ho() {
        this.Vw.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bqW() {
        if (this.fdo != null) {
            this.fdo.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aWp() {
        if (j.isNetWorkAvailable()) {
            this.fds.refresh();
        } else {
            bqX();
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aWq() {
    }
}
