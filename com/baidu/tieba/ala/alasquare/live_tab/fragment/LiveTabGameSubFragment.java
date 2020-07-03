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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes3.dex */
public class LiveTabGameSubFragment extends LiveTabBaseSubFragment implements as {
    private BdTypeRecyclerView Wa;
    private PbListView fnt;

    /* renamed from: for  reason: not valid java name */
    private BdSwipeRefreshLayout f3for;
    private b fos;
    private AlaLiveTabGameModel fot;
    private AlaLiveTabGameModel.a fou = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            if (z) {
                LiveTabGameSubFragment.this.btJ();
            } else {
                LiveTabGameSubFragment.this.btI();
            }
            LiveTabGameSubFragment.this.btU();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void g(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.btU();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fov = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.fot.refresh();
            } else {
                LiveTabGameSubFragment.this.btU();
            }
        }
    };
    private BdListView.e fow = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.fot.btu();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.fon) {
                LiveTabGameSubFragment.this.btS();
            }
        }
    };
    private g mPullView;
    private View mRootView;

    public static LiveTabGameSubFragment jz(boolean z) {
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
            this.fnI = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.fot == null) {
            this.fot = new AlaLiveTabGameModel(getPageContext(), this.fou);
        }
        this.fot.init();
        this.fot.dC(this.eEs, this.foo);
        registerListener(this.fop);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.fnI) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.f3for = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fol = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.f3for.setProgressView(this.mPullView);
        this.Wa = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Wa.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Wa.setFadingEdgeLength(0);
        this.Wa.setOverScrollMode(2);
        this.fos = new b(getPageContext(), this.Wa);
        this.fos.jy(aUi());
        this.fnt = new PbListView(this.mContext);
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Wa.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.fov);
        a(this.fow);
        if (aUi()) {
            this.f3for.setEnabled(false);
            this.f3for.interruptRefresh();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<q> list) {
        if (w.isEmpty(list)) {
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(new r());
        }
        this.fos.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Wa != null) {
            this.Wa.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (aUi()) {
            u uVar = new u();
            uVar.tabId = 1121;
            uVar.eSL = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.f3for.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btU() {
        if (aUi()) {
            u uVar = new u();
            uVar.tabId = 1121;
            uVar.eSL = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.f3for.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btI() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.Wa.setNextPage(this.fnt);
            }
            this.fnt.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fnt.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.fnt.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btJ() {
        if (this.fnt != null) {
            if (this.fnt.getView().getParent() == null) {
                this.Wa.setNextPage(this.fnt);
            }
            this.fnt.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.fnt.setText(this.mContext.getResources().getString(R.string.loading));
            this.fnt.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Wa.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.changeSkin(i);
        }
        if (this.fos != null) {
            this.fos.notifyDataSetChanged();
        }
        an.setBackgroundColor(this.f3for, R.color.cp_bg_line_e);
        an.setBackgroundColor(this.Wa, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Wa != null) {
            this.Wa.removeOnScrollListener(this.mOnScrollListener);
            this.Wa.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.fot != null) {
            this.fot.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.fot != null) {
            this.fot.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void IB() {
        this.Wa.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void btT() {
        if (this.fos != null) {
            this.fos.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void aYg() {
        if (j.isNetWorkAvailable()) {
            this.fot.refresh();
        } else {
            btU();
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void aYh() {
    }
}
