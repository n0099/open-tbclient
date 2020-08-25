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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabGameSubFragment extends LiveTabBaseSubFragment implements au {
    private BdTypeRecyclerView Wu;
    private PbListView fDW;
    private BdSwipeRefreshLayout fEV;
    private b fEW;
    private AlaLiveTabGameModel fEX;
    private AlaLiveTabGameModel.a fEY = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(boolean z, List<q> list) {
            if (z) {
                LiveTabGameSubFragment.this.bFS();
            } else {
                LiveTabGameSubFragment.this.bFR();
            }
            LiveTabGameSubFragment.this.bGd();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bGd();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fEZ = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.fEX.refresh();
            } else {
                LiveTabGameSubFragment.this.bGd();
            }
        }
    };
    private BdListView.e fFa = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.fEX.bFD();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.fER) {
                LiveTabGameSubFragment.this.bGb();
            }
        }
    };
    private g mPullView;
    private View mRootView;

    public static LiveTabGameSubFragment kB(boolean z) {
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
            this.fEl = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.fEX == null) {
            this.fEX = new AlaLiveTabGameModel(getPageContext(), this.fEY);
        }
        this.fEX.init();
        this.fEX.dS(this.eVt, this.fES);
        registerListener(this.fET);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.fEl) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.fEV = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fEP = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.fEV.setProgressView(this.mPullView);
        this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.fEW = new b(getPageContext(), this.Wu);
        this.fEW.kA(bcm());
        this.fDW = new PbListView(this.mContext);
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Wu.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.fEZ);
        a(this.fFa);
        if (bcm()) {
            this.fEV.setEnabled(false);
            this.fEV.interruptRefresh();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        if (y.isEmpty(list)) {
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(new s());
        }
        this.fEW.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Wu != null) {
            this.Wu.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (bcm()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fky = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.fEV.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGd() {
        if (bcm()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fky = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.fEV.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFR() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.Wu.setNextPage(this.fDW);
            }
            this.fDW.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fDW.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fDW.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFS() {
        if (this.fDW != null) {
            if (this.fDW.getView().getParent() == null) {
                this.Wu.setNextPage(this.fDW);
            }
            this.fDW.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fDW.setText(this.mContext.getResources().getString(R.string.loading));
            this.fDW.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Wu.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fDW.changeSkin(i);
        }
        if (this.fEW != null) {
            this.fEW.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fEV, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Wu != null) {
            this.Wu.removeOnScrollListener(this.mOnScrollListener);
            this.Wu.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.fEX != null) {
            this.fEX.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.fEX != null) {
            this.fEX.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bjn();
    }

    private void bjn() {
        aq aqVar = new aq("c13008");
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dD("fid", this.eVt);
        aqVar.ai("obj_locate", 2);
        aqVar.ai("obj_type", 15);
        aqVar.bjn();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void OA() {
        this.Wu.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bGc() {
        if (this.fEW != null) {
            this.fEW.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bkD() {
        if (j.isNetWorkAvailable()) {
            this.fEX.refresh();
        } else {
            bGd();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bkE() {
    }
}
