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
    private BdTypeRecyclerView Xc;
    private PbListView fTv;
    private b fUD;
    private AlaLiveTabGameModel fUE;
    private BdSwipeRefreshLayout fUv;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabGameModel.a fUF = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(boolean z, List<q> list) {
            if (z) {
                LiveTabGameSubFragment.this.bJV();
            } else {
                LiveTabGameSubFragment.this.bJU();
            }
            LiveTabGameSubFragment.this.bKf();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bKf();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fUA = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.fUE.refresh();
            } else {
                LiveTabGameSubFragment.this.bKf();
            }
        }
    };
    private BdListView.e fUB = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.fUE.bJG();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.fUr) {
                LiveTabGameSubFragment.this.bKd();
            }
        }
    };

    public static LiveTabGameSubFragment ld(boolean z) {
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
            this.fTL = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.fUE == null) {
            this.fUE = new AlaLiveTabGameModel(getPageContext(), this.fUF);
        }
        this.fUE.init();
        this.fUE.eb(this.fkA, this.fUs);
        registerListener(this.fUt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.fTL) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.fUv = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fUp = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.fUv.setProgressView(this.mPullView);
        this.Xc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Xc.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Xc.setFadingEdgeLength(0);
        this.Xc.setOverScrollMode(2);
        this.fUD = new b(getPageContext(), this.Xc);
        this.fUD.lc(bfP());
        this.fTv = new PbListView(this.mContext);
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Xc.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.fUA);
        a(this.fUB);
        if (bfP()) {
            this.fUv.setEnabled(false);
            this.fUv.interruptRefresh();
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
        this.fUD.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Xc != null) {
            this.Xc.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (bfP()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fzJ = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.fUv.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKf() {
        if (bfP()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fzJ = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.fUv.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJU() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.Xc.setNextPage(this.fTv);
            }
            this.fTv.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fTv.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fTv.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJV() {
        if (this.fTv != null) {
            if (this.fTv.getView().getParent() == null) {
                this.Xc.setNextPage(this.fTv);
            }
            this.fTv.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fTv.setText(this.mContext.getResources().getString(R.string.loading));
            this.fTv.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Xc.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.changeSkin(i);
        }
        if (this.fUD != null) {
            this.fUD.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fUv, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.Xc, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Xc != null) {
            this.Xc.removeOnScrollListener(this.mOnScrollListener);
            this.Xc.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.fUE != null) {
            this.fUE.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.fUE != null) {
            this.fUE.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bmR();
    }

    private void bmR() {
        aq aqVar = new aq("c13008");
        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dK("fid", this.fkA);
        aqVar.aj("obj_locate", 2);
        aqVar.aj("obj_type", 15);
        aqVar.bmR();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Qi() {
        this.Xc.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bKe() {
        if (this.fUD != null) {
            this.fUD.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void boi() {
        if (j.isNetWorkAvailable()) {
            this.fUE.refresh();
        } else {
            bKf();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void boj() {
    }
}
