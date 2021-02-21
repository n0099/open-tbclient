package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.util.Log;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.a;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.t;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements aq {
    private BdTypeRecyclerView XW;
    private PbListView gAw;
    private AlaLiveTabYanzhiModel gBL;
    private BdSwipeRefreshLayout gBw;
    private a gBx;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabYanzhiModel.a gBM = new AlaLiveTabYanzhiModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void f(boolean z, List<n> list) {
            if (z) {
                LiveTabYanzhiSubFragment.this.bRy();
            } else {
                LiveTabYanzhiSubFragment.this.bRx();
            }
            LiveTabYanzhiSubFragment.this.bRI();
            LiveTabYanzhiSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void g(int i, String str, boolean z) {
            LiveTabYanzhiSubFragment.this.bRI();
            if (z) {
                LiveTabYanzhiSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c gBB = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabYanzhiSubFragment.this.gBL.refresh();
            } else {
                LiveTabYanzhiSubFragment.this.bRI();
            }
        }
    };
    private BdListView.e gBC = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabYanzhiSubFragment.this.hideLoadingView();
            } else {
                LiveTabYanzhiSubFragment.this.gBL.bRj();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.4
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            Log.e("D444", "dy" + i2 + ", dx" + i);
            if (i2 >= 4 && !LiveTabYanzhiSubFragment.this.gBs) {
                LiveTabYanzhiSubFragment.this.bRG();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bsO();
    }

    private void bsO() {
        ar arVar = new ar("c13008");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("fid", this.fNd);
        arVar.ap("obj_locate", 2);
        arVar.ap("obj_type", 15);
        arVar.bsO();
    }

    public static LiveTabYanzhiSubFragment mA(boolean z) {
        Bundle bundle = new Bundle();
        LiveTabYanzhiSubFragment liveTabYanzhiSubFragment = new LiveTabYanzhiSubFragment();
        bundle.putBoolean("arg_after_lazy_loaded", z);
        liveTabYanzhiSubFragment.setArguments(bundle);
        return liveTabYanzhiSubFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext().getPageActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gAM = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gBL == null) {
            this.gBL = new AlaLiveTabYanzhiModel(getPageContext(), this.gBM);
        }
        this.gBL.init();
        this.gBL.eg(this.fNd, this.gBt);
        registerListener(this.gBu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.gAM) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gBw = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gBq = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gBw.setProgressView(this.mPullView);
        this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.XW.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        this.gBx = new a(getPageContext(), this.XW, 102);
        this.gAw = new PbListView(this.mContext);
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.transparent);
        this.gAw.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.XW.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gBB);
        a(this.gBC);
        if (blu()) {
            this.gBw.setEnabled(false);
            this.gBw.interruptRefresh();
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(List<n> list) {
        if (y.isEmpty(list)) {
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(new s());
        }
        this.gBx.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.XW != null) {
            this.XW.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (blu()) {
            t tVar = new t();
            tVar.tabId = 1120;
            tVar.gcC = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
            return;
        }
        this.gBw.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRI() {
        if (blu()) {
            t tVar = new t();
            tVar.tabId = 1120;
            tVar.gcC = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
            return;
        }
        this.gBw.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRx() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.XW.setNextPage(this.gAw);
            }
            this.gAw.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gAw.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gAw.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        if (this.gAw != null) {
            if (this.gAw.getView().getParent() == null) {
                this.XW.setNextPage(this.gAw);
            }
            this.gAw.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gAw.setText(this.mContext.getResources().getString(R.string.loading));
            this.gAw.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.XW.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.changeSkin(i);
        }
        if (this.gBx != null) {
            this.gBx.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.XW != null) {
            this.XW.removeOnScrollListener(this.mOnScrollListener);
            this.XW.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gBL != null) {
            this.gBL.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gBL != null) {
            this.gBL.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Ut() {
        this.XW.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bRH() {
        if (this.gBx != null) {
            this.gBx.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bum() {
        if (j.isNetWorkAvailable()) {
            this.gBL.refresh();
        } else {
            bRI();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bun() {
    }
}
