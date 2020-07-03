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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements as {
    private BdTypeRecyclerView Wa;
    private PbListView fnt;
    private AlaLiveTabYanzhiModel foC;

    /* renamed from: for  reason: not valid java name */
    private BdSwipeRefreshLayout f5for;
    private a foy;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabYanzhiModel.a foD = new AlaLiveTabYanzhiModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void e(boolean z, List<q> list) {
            if (z) {
                LiveTabYanzhiSubFragment.this.btJ();
            } else {
                LiveTabYanzhiSubFragment.this.btI();
            }
            LiveTabYanzhiSubFragment.this.btU();
            LiveTabYanzhiSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void g(int i, String str, boolean z) {
            LiveTabYanzhiSubFragment.this.btU();
            if (z) {
                LiveTabYanzhiSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c fov = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabYanzhiSubFragment.this.foC.refresh();
            } else {
                LiveTabYanzhiSubFragment.this.btU();
            }
        }
    };
    private BdListView.e fow = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabYanzhiSubFragment.this.hideLoadingView();
            } else {
                LiveTabYanzhiSubFragment.this.foC.btu();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            Log.e("D444", "dy" + i2 + ", dx" + i);
            if (i2 >= 4 && !LiveTabYanzhiSubFragment.this.fon) {
                LiveTabYanzhiSubFragment.this.btS();
            }
        }
    };

    public static LiveTabYanzhiSubFragment jB(boolean z) {
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
            this.fnI = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.foC == null) {
            this.foC = new AlaLiveTabYanzhiModel(getPageContext(), this.foD);
        }
        this.foC.init();
        this.foC.dC(this.eEs, this.foo);
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
        this.f5for = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.fol = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.f5for.setProgressView(this.mPullView);
        this.Wa = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Wa.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Wa.setFadingEdgeLength(0);
        this.Wa.setOverScrollMode(2);
        this.foy = new a(getPageContext(), this.Wa, 102);
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
            this.f5for.setEnabled(false);
            this.f5for.interruptRefresh();
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
        this.foy.setData(list);
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
            uVar.tabId = 1120;
            uVar.eSL = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.f5for.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btU() {
        if (aUi()) {
            u uVar = new u();
            uVar.tabId = 1120;
            uVar.eSL = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
            return;
        }
        this.f5for.setRefreshing(false);
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
        if (this.foy != null) {
            this.foy.notifyDataSetChanged();
        }
        an.setBackgroundColor(this.f5for, R.color.cp_bg_line_e);
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
        if (this.foC != null) {
            this.foC.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.foC != null) {
            this.foC.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void IB() {
        this.Wa.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void btT() {
        if (this.foy != null) {
            this.foy.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void aYg() {
        if (j.isNetWorkAvailable()) {
            this.foC.refresh();
        } else {
            btU();
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void aYh() {
    }
}
