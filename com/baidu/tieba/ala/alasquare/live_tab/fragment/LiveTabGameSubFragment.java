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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.b;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabGameSubFragment extends LiveTabBaseSubFragment implements as {
    private BdTypeRecyclerView VT;
    private PbListView fsC;
    private BdSwipeRefreshLayout ftC;
    private b ftD;
    private AlaLiveTabGameModel ftE;
    private AlaLiveTabGameModel.a ftF = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            if (z) {
                LiveTabGameSubFragment.this.bwT();
            } else {
                LiveTabGameSubFragment.this.bwS();
            }
            LiveTabGameSubFragment.this.bxe();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void g(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bxe();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c ftG = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.ftE.refresh();
            } else {
                LiveTabGameSubFragment.this.bxe();
            }
        }
    };
    private BdListView.e ftH = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.ftE.bwE();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.fty) {
                LiveTabGameSubFragment.this.bxc();
            }
        }
    };
    private g mPullView;
    private View mRootView;

    public static LiveTabGameSubFragment kd(boolean z) {
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
            this.fsR = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.ftE == null) {
            this.ftE = new AlaLiveTabGameModel(getPageContext(), this.ftF);
        }
        this.ftE.init();
        this.ftE.dC(this.eKO, this.ftz);
        registerListener(this.ftA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.fsR) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.ftC = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.ftw = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.ftC.setProgressView(this.mPullView);
        this.VT = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.VT.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.VT.setFadingEdgeLength(0);
        this.VT.setOverScrollMode(2);
        this.ftD = new b(getPageContext(), this.VT);
        this.ftD.kc(aTV());
        this.fsC = new PbListView(this.mContext);
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.VT.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.ftG);
        a(this.ftH);
        if (aTV()) {
            this.ftC.setEnabled(false);
            this.ftC.interruptRefresh();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        if (x.isEmpty(list)) {
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(new r());
        }
        this.ftD.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.VT != null) {
            this.VT.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (aTV()) {
            u uVar = new u();
            uVar.tabId = 1121;
            uVar.eZg = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.ftC.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxe() {
        if (aTV()) {
            u uVar = new u();
            uVar.tabId = 1121;
            uVar.eZg = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.ftC.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwS() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.VT.setNextPage(this.fsC);
            }
            this.fsC.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fsC.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fsC.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwT() {
        if (this.fsC != null) {
            if (this.fsC.getView().getParent() == null) {
                this.VT.setNextPage(this.fsC);
            }
            this.fsC.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fsC.setText(this.mContext.getResources().getString(R.string.loading));
            this.fsC.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.VT.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.fsC.changeSkin(i);
        }
        if (this.ftD != null) {
            this.ftD.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.ftC, R.color.cp_bg_line_e);
        ao.setBackgroundColor(this.VT, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.VT != null) {
            this.VT.removeOnScrollListener(this.mOnScrollListener);
            this.VT.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.ftE != null) {
            this.ftE.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.ftE != null) {
            this.ftE.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void IH() {
        this.VT.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bxd() {
        if (this.ftD != null) {
            this.ftD.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bcg() {
        if (j.isNetWorkAvailable()) {
            this.ftE.refresh();
        } else {
            bxe();
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bch() {
    }
}
