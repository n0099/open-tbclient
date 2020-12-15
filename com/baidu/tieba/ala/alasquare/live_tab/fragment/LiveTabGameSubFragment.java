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
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class LiveTabGameSubFragment extends LiveTabBaseSubFragment implements at {
    private BdTypeRecyclerView Yf;
    private PbListView grg;
    private BdSwipeRefreshLayout gsg;
    private b gso;
    private AlaLiveTabGameModel gsp;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabGameModel.a gsq = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            if (z) {
                LiveTabGameSubFragment.this.bSc();
            } else {
                LiveTabGameSubFragment.this.bSb();
            }
            LiveTabGameSubFragment.this.bSm();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bSm();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c gsl = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.gsp.refresh();
            } else {
                LiveTabGameSubFragment.this.bSm();
            }
        }
    };
    private BdListView.e gsm = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.gsp.bRN();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.gsc) {
                LiveTabGameSubFragment.this.bSk();
            }
        }
    };

    public static LiveTabGameSubFragment mb(boolean z) {
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
            this.grw = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gsp == null) {
            this.gsp = new AlaLiveTabGameModel(getPageContext(), this.gsq);
        }
        this.gsp.init();
        this.gsp.ek(this.fFV, this.gsd);
        registerListener(this.gse);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.grw) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gsg = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gsa = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gsg.setProgressView(this.mPullView);
        this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        this.gso = new b(getPageContext(), this.Yf);
        this.gso.lZ(bmu());
        this.grg = new PbListView(this.mContext);
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.transparent);
        this.grg.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Yf.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gsl);
        a(this.gsm);
        if (bmu()) {
            this.gsg.setEnabled(false);
            this.gsg.interruptRefresh();
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
        this.gso.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Yf != null) {
            this.Yf.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (bmu()) {
            u uVar = new u();
            uVar.tabId = 1121;
            uVar.fVi = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.gsg.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSm() {
        if (bmu()) {
            u uVar = new u();
            uVar.tabId = 1121;
            uVar.fVi = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.gsg.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSb() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.Yf.setNextPage(this.grg);
            }
            this.grg.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.grg.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.grg.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSc() {
        if (this.grg != null) {
            if (this.grg.getView().getParent() == null) {
                this.Yf.setNextPage(this.grg);
            }
            this.grg.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.grg.setText(this.mContext.getResources().getString(R.string.loading));
            this.grg.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Yf.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.grg.changeSkin(i);
        }
        if (this.gso != null) {
            this.gso.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Yf != null) {
            this.Yf.removeOnScrollListener(this.mOnScrollListener);
            this.Yf.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gsp != null) {
            this.gsp.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gsp != null) {
            this.gsp.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        btT();
    }

    private void btT() {
        ar arVar = new ar("c13008");
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dY("fid", this.fFV);
        arVar.al("obj_locate", 2);
        arVar.al("obj_type", 15);
        arVar.btT();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void VC() {
        this.Yf.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bSl() {
        if (this.gso != null) {
            this.gso.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.at
    public void bvq() {
        if (j.isNetWorkAvailable()) {
            this.gsp.refresh();
        } else {
            bSm();
        }
    }

    @Override // com.baidu.tieba.frs.at
    public void bvr() {
    }
}
