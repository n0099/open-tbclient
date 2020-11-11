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
    private PbListView gjo;
    private BdSwipeRefreshLayout gko;
    private b gkw;
    private AlaLiveTabGameModel gkx;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabGameModel.a gky = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            if (z) {
                LiveTabGameSubFragment.this.bOX();
            } else {
                LiveTabGameSubFragment.this.bOW();
            }
            LiveTabGameSubFragment.this.bPh();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bPh();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c gkt = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.gkx.refresh();
            } else {
                LiveTabGameSubFragment.this.bPh();
            }
        }
    };
    private BdListView.e gku = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.gkx.bOI();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.gkk) {
                LiveTabGameSubFragment.this.bPf();
            }
        }
    };

    public static LiveTabGameSubFragment lF(boolean z) {
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
            this.gjE = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gkx == null) {
            this.gkx = new AlaLiveTabGameModel(getPageContext(), this.gky);
        }
        this.gkx.init();
        this.gkx.ei(this.fyR, this.gkl);
        registerListener(this.gkm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
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
        this.gkw = new b(getPageContext(), this.Xe);
        this.gkw.lD(bki());
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
        if (bki()) {
            this.gko.setEnabled(false);
            this.gko.interruptRefresh();
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
        this.gkw.setData(list);
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
        if (bki()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fNU = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.gko.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPh() {
        if (bki()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fNU = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
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
    public void hideLoadingView() {
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
        if (this.gkw != null) {
            this.gkw.notifyDataSetChanged();
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
        if (this.gkx != null) {
            this.gkx.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gkx != null) {
            this.gkx.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        brk();
    }

    private void brk() {
        aq aqVar = new aq("c13008");
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dR("fid", this.fyR);
        aqVar.al("obj_locate", 2);
        aqVar.al("obj_type", 15);
        aqVar.brk();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void TL() {
        this.Xe.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bPg() {
        if (this.gkw != null) {
            this.gkw.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bsB() {
        if (j.isNetWorkAvailable()) {
            this.gkx.refresh();
        } else {
            bPh();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bsC() {
    }
}
