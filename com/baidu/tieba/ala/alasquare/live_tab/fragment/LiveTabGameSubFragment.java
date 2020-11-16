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
import com.baidu.tbadk.core.util.ar;
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
    private BdTypeRecyclerView Xi;
    private PbListView giV;
    private BdSwipeRefreshLayout gjV;
    private b gkd;
    private AlaLiveTabGameModel gke;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabGameModel.a gkf = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            if (z) {
                LiveTabGameSubFragment.this.bOq();
            } else {
                LiveTabGameSubFragment.this.bOp();
            }
            LiveTabGameSubFragment.this.bOA();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bOA();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c gka = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.gke.refresh();
            } else {
                LiveTabGameSubFragment.this.bOA();
            }
        }
    };
    private BdListView.e gkb = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.gke.bOb();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.gjR) {
                LiveTabGameSubFragment.this.bOy();
            }
        }
    };

    public static LiveTabGameSubFragment lG(boolean z) {
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
            this.gjl = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gke == null) {
            this.gke = new AlaLiveTabGameModel(getPageContext(), this.gkf);
        }
        this.gke.init();
        this.gke.ei(this.fyg, this.gjS);
        registerListener(this.gjT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.gjl) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gjV = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gjP = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gjV.setProgressView(this.mPullView);
        this.Xi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Xi.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Xi.setFadingEdgeLength(0);
        this.Xi.setOverScrollMode(2);
        this.gkd = new b(getPageContext(), this.Xi);
        this.gkd.lE(bjk());
        this.giV = new PbListView(this.mContext);
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.transparent);
        this.giV.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Xi.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gka);
        a(this.gkb);
        if (bjk()) {
            this.gjV.setEnabled(false);
            this.gjV.interruptRefresh();
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
        this.gkd.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Xi != null) {
            this.Xi.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (bjk()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fNx = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.gjV.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOA() {
        if (bjk()) {
            v vVar = new v();
            vVar.tabId = 1121;
            vVar.fNx = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
            return;
        }
        this.gjV.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOp() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Xi.setNextPage(this.giV);
            }
            this.giV.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.giV.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.giV.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOq() {
        if (this.giV != null) {
            if (this.giV.getView().getParent() == null) {
                this.Xi.setNextPage(this.giV);
            }
            this.giV.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.giV.setText(this.mContext.getResources().getString(R.string.loading));
            this.giV.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Xi.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.changeSkin(i);
        }
        if (this.gkd != null) {
            this.gkd.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Xi != null) {
            this.Xi.removeOnScrollListener(this.mOnScrollListener);
            this.Xi.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gke != null) {
            this.gke.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gke != null) {
            this.gke.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bqy();
    }

    private void bqy() {
        ar arVar = new ar("c13008");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("fid", this.fyg);
        arVar.ak("obj_locate", 2);
        arVar.ak("obj_type", 15);
        arVar.bqy();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Tc() {
        this.Xi.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bOz() {
        if (this.gkd != null) {
            this.gkd.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void brR() {
        if (j.isNetWorkAvailable()) {
            this.gke.refresh();
        } else {
            bOA();
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void brS() {
    }
}
