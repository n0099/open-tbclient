package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
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
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class LiveTabGameSubFragment extends LiveTabBaseSubFragment implements aq {
    private BdTypeRecyclerView Yc;
    private PbListView gCf;
    private BdSwipeRefreshLayout gDf;
    private b gDn;
    private AlaLiveTabGameModel gDo;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabGameModel.a gDp = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(boolean z, List<n> list) {
            if (z) {
                LiveTabGameSubFragment.this.bUE();
            } else {
                LiveTabGameSubFragment.this.bUD();
            }
            LiveTabGameSubFragment.this.bUO();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bUO();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c gDk = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.gDo.refresh();
            } else {
                LiveTabGameSubFragment.this.bUO();
            }
        }
    };
    private BdListView.e gDl = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.gDo.bUp();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.gDb) {
                LiveTabGameSubFragment.this.bUM();
            }
        }
    };

    public static LiveTabGameSubFragment my(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabGameSubFragment liveTabGameSubFragment = new LiveTabGameSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabGameSubFragment.setArguments(bundle);
        return liveTabGameSubFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gCv = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gDo == null) {
            this.gDo = new AlaLiveTabGameModel(getPageContext(), this.gDp);
        }
        this.gDo.init();
        this.gDo.ej(this.fPy, this.gDc);
        registerListener(this.gDd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.gCv) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gDf = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gCZ = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gDf.setProgressView(this.mPullView);
        this.Yc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Yc.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Yc.setFadingEdgeLength(0);
        this.Yc.setOverScrollMode(2);
        this.gDn = new b(getPageContext(), this.Yc);
        this.gDn.mw(boV());
        this.gCf = new PbListView(this.mContext);
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Yc.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gDk);
        a(this.gDl);
        if (boV()) {
            this.gDf.setEnabled(false);
            this.gDf.interruptRefresh();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<n> list) {
        if (x.isEmpty(list)) {
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(new s());
        }
        this.gDn.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Yc != null) {
            this.Yc.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (boV()) {
            t tVar = new t();
            tVar.tabId = 1121;
            tVar.geO = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
            return;
        }
        this.gDf.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUO() {
        if (boV()) {
            t tVar = new t();
            tVar.tabId = 1121;
            tVar.geO = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
            return;
        }
        this.gDf.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yc.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gCf.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Yc.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gCf.setText(this.mContext.getResources().getString(R.string.loading));
            this.gCf.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Yc.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.gDn != null) {
            this.gDn.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Yc != null) {
            this.Yc.removeOnScrollListener(this.mOnScrollListener);
            this.Yc.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gDo != null) {
            this.gDo.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gDo != null) {
            this.gDo.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bwn();
    }

    private void bwn() {
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13008");
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dX("fid", this.fPy);
        aqVar.an("obj_locate", 2);
        aqVar.an("obj_type", 15);
        aqVar.bwn();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void WE() {
        this.Yc.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bUN() {
        if (this.gDn != null) {
            this.gDn.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxL() {
        if (j.isNetWorkAvailable()) {
            this.gDo.refresh();
        } else {
            bUO();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxM() {
    }
}
