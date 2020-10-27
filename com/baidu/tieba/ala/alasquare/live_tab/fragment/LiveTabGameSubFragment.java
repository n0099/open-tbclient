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
    private BdTypeRecyclerView Xe;
    private PbListView gdy;
    private b geH;
    private AlaLiveTabGameModel geI;
    private BdSwipeRefreshLayout gez;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabGameModel.a geJ = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            if (z) {
                LiveTabGameSubFragment.this.bMx();
            } else {
                LiveTabGameSubFragment.this.bMw();
            }
            LiveTabGameSubFragment.this.bMH();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bMH();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c geE = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.geI.refresh();
            } else {
                LiveTabGameSubFragment.this.bMH();
            }
        }
    };
    private BdListView.e geF = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.geI.bMi();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.gev) {
                LiveTabGameSubFragment.this.bMF();
            }
        }
    };

    public static LiveTabGameSubFragment lw(boolean z) {
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
            this.gdO = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.geI == null) {
            this.geI = new AlaLiveTabGameModel(getPageContext(), this.geJ);
        }
        this.geI.init();
        this.geI.ei(this.fsZ, this.gew);
        registerListener(this.gex);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.gdO) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gez = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.get = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gez.setProgressView(this.mPullView);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.geH = new b(getPageContext(), this.Xe);
        this.geH.lu(bhI());
        this.gdy = new PbListView(this.mContext);
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Xe.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.geE);
        a(this.geF);
        if (bhI()) {
            this.gez.setEnabled(false);
            this.gez.interruptRefresh();
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
        this.geH.setData(list);
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
        if (bhI()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fIe = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.gez.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMH() {
        if (bhI()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fIe = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.gez.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMw() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.Xe.setNextPage(this.gdy);
            }
            this.gdy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gdy.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gdy.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMx() {
        if (this.gdy != null) {
            if (this.gdy.getView().getParent() == null) {
                this.Xe.setNextPage(this.gdy);
            }
            this.gdy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gdy.setText(this.mContext.getResources().getString(R.string.loading));
            this.gdy.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Xe.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.changeSkin(i);
        }
        if (this.geH != null) {
            this.geH.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gez, R.color.cp_bg_line_e);
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
        if (this.geI != null) {
            this.geI.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.geI != null) {
            this.geI.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        boK();
    }

    private void boK() {
        aq aqVar = new aq("c13008");
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dR("fid", this.fsZ);
        aqVar.aj("obj_locate", 2);
        aqVar.aj("obj_type", 15);
        aqVar.boK();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Rd() {
        this.Xe.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bMG() {
        if (this.geH != null) {
            this.geH.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bqb() {
        if (j.isNetWorkAvailable()) {
            this.geI.refresh();
        } else {
            bMH();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bqc() {
    }
}
