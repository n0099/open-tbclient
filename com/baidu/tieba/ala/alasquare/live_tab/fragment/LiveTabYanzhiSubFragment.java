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
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.v;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements au {
    private BdTypeRecyclerView Xe;
    private PbListView gjo;
    private AlaLiveTabYanzhiModel gkD;
    private BdSwipeRefreshLayout gko;
    private a gkp;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabYanzhiModel.a gkE = new AlaLiveTabYanzhiModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void e(boolean z, List<q> list) {
            if (z) {
                LiveTabYanzhiSubFragment.this.bOX();
            } else {
                LiveTabYanzhiSubFragment.this.bOW();
            }
            LiveTabYanzhiSubFragment.this.bPh();
            LiveTabYanzhiSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void h(int i, String str, boolean z) {
            LiveTabYanzhiSubFragment.this.bPh();
            if (z) {
                LiveTabYanzhiSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c gkt = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabYanzhiSubFragment.this.gkD.refresh();
            } else {
                LiveTabYanzhiSubFragment.this.bPh();
            }
        }
    };
    private BdListView.e gku = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabYanzhiSubFragment.this.hideLoadingView();
            } else {
                LiveTabYanzhiSubFragment.this.gkD.bOI();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            Log.e("D444", "dy" + i2 + ", dx" + i);
            if (i2 >= 4 && !LiveTabYanzhiSubFragment.this.gkk) {
                LiveTabYanzhiSubFragment.this.bPf();
            }
        }
    };

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

    public static LiveTabYanzhiSubFragment lH(boolean z) {
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
            this.gjE = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gkD == null) {
            this.gkD = new AlaLiveTabYanzhiModel(getPageContext(), this.gkE);
        }
        this.gkD.init();
        this.gkD.ei(this.fyR, this.gkl);
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
        this.gkp = new a(getPageContext(), this.Xe, 102);
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
        if (bki()) {
            v vVar = new v();
            vVar.tabId = 1120;
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
            vVar.tabId = 1120;
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
        if (this.gkD != null) {
            this.gkD.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gkD != null) {
            this.gkD.refresh();
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

    @Override // com.baidu.tieba.frs.au
    public void bsB() {
        if (j.isNetWorkAvailable()) {
            this.gkD.refresh();
        } else {
            bPh();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bsC() {
    }
}
