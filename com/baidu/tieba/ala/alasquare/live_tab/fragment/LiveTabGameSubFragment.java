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
    private BdSwipeRefreshLayout fEZ;
    private PbListView fEa;
    private b fFa;
    private AlaLiveTabGameModel fFb;
    private AlaLiveTabGameModel.a fFc = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(boolean z, List<q> list) {
            if (z) {
                LiveTabGameSubFragment.this.bFT();
            } else {
                LiveTabGameSubFragment.this.bFS();
            }
            LiveTabGameSubFragment.this.bGe();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bGe();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fFd = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.fFb.refresh();
            } else {
                LiveTabGameSubFragment.this.bGe();
            }
        }
    };
    private BdListView.e fFe = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.fFb.bFE();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.fEV) {
                LiveTabGameSubFragment.this.bGc();
            }
        }
    };
    private g mPullView;
    private View mRootView;

    public static LiveTabGameSubFragment kD(boolean z) {
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
            this.fEp = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.fFb == null) {
            this.fFb = new AlaLiveTabGameModel(getPageContext(), this.fFc);
        }
        this.fFb.init();
        this.fFb.dT(this.eVx, this.fEW);
        registerListener(this.fEX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.fEp) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.fEZ = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fET = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.fEZ.setProgressView(this.mPullView);
        this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.fFa = new b(getPageContext(), this.Wu);
        this.fFa.kC(bcm());
        this.fEa = new PbListView(this.mContext);
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Wu.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.fFd);
        a(this.fFe);
        if (bcm()) {
            this.fEZ.setEnabled(false);
            this.fEZ.interruptRefresh();
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
        this.fFa.setData(list);
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
            vVar.fkC = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.fEZ.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGe() {
        if (bcm()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fkC = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.fEZ.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFS() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.Wu.setNextPage(this.fEa);
            }
            this.fEa.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fEa.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fEa.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFT() {
        if (this.fEa != null) {
            if (this.fEa.getView().getParent() == null) {
                this.Wu.setNextPage(this.fEa);
            }
            this.fEa.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fEa.setText(this.mContext.getResources().getString(R.string.loading));
            this.fEa.startLoadData();
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
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fEa.changeSkin(i);
        }
        if (this.fFa != null) {
            this.fFa.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fEZ, R.color.cp_bg_line_e);
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
        if (this.fFb != null) {
            this.fFb.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.fFb != null) {
            this.fFb.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bjn();
    }

    private void bjn() {
        aq aqVar = new aq("c13008");
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dD("fid", this.eVx);
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
    public void bGd() {
        if (this.fFa != null) {
            this.fFa.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bkD() {
        if (j.isNetWorkAvailable()) {
            this.fFb.refresh();
        } else {
            bGe();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bkE() {
    }
}
