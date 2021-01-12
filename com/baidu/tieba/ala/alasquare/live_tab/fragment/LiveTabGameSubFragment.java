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
/* loaded from: classes9.dex */
public class LiveTabGameSubFragment extends LiveTabBaseSubFragment implements aq {
    private BdTypeRecyclerView Ya;
    private PbListView gxy;
    private b gyG;
    private AlaLiveTabGameModel gyH;
    private BdSwipeRefreshLayout gyy;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabGameModel.a gyI = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(boolean z, List<n> list) {
            if (z) {
                LiveTabGameSubFragment.this.bQN();
            } else {
                LiveTabGameSubFragment.this.bQM();
            }
            LiveTabGameSubFragment.this.bQX();
            LiveTabGameSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            LiveTabGameSubFragment.this.bQX();
            if (z) {
                LiveTabGameSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c gyD = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabGameSubFragment.this.gyH.refresh();
            } else {
                LiveTabGameSubFragment.this.bQX();
            }
        }
    };
    private BdListView.e gyE = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabGameSubFragment.this.hideLoadingView();
            } else {
                LiveTabGameSubFragment.this.gyH.bQy();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabGameSubFragment.4
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 >= 4 && !LiveTabGameSubFragment.this.gyu) {
                LiveTabGameSubFragment.this.bQV();
            }
        }
    };

    public static LiveTabGameSubFragment mu(boolean z) {
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
            this.gxO = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gyH == null) {
            this.gyH = new AlaLiveTabGameModel(getPageContext(), this.gyI);
        }
        this.gyH.init();
        this.gyH.ei(this.fKR, this.gyv);
        registerListener(this.gyw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
            initView();
        }
        if (this.gxO) {
            loadData();
        }
        return this.mRootView;
    }

    private void initView() {
        this.gyy = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.live_tab_refresh_layout);
        this.gys = (LinearLayout) this.mRootView.findViewById(R.id.top_container);
        this.mPullView = new g(getPageContext());
        this.gyy.setProgressView(this.mPullView);
        this.Ya = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Ya.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Ya.setFadingEdgeLength(0);
        this.Ya.setOverScrollMode(2);
        this.gyG = new b(getPageContext(), this.Ya);
        this.gyG.ms(blc());
        this.gxy = new PbListView(this.mContext);
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.transparent);
        this.gxy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Ya.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gyD);
        a(this.gyE);
        if (blc()) {
            this.gyy.setEnabled(false);
            this.gyy.interruptRefresh();
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
        this.gyG.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Ya != null) {
            this.Ya.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (blc()) {
            t tVar = new t();
            tVar.tabId = 1121;
            tVar.gae = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
            return;
        }
        this.gyy.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQX() {
        if (blc()) {
            t tVar = new t();
            tVar.tabId = 1121;
            tVar.gae = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
            return;
        }
        this.gyy.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQM() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.Ya.setNextPage(this.gxy);
            }
            this.gxy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gxy.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gxy.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQN() {
        if (this.gxy != null) {
            if (this.gxy.getView().getParent() == null) {
                this.Ya.setNextPage(this.gxy);
            }
            this.gxy.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gxy.setText(this.mContext.getResources().getString(R.string.loading));
            this.gxy.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Ya.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.changeSkin(i);
        }
        if (this.gyG != null) {
            this.gyG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Ya != null) {
            this.Ya.removeOnScrollListener(this.mOnScrollListener);
            this.Ya.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gyH != null) {
            this.gyH.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gyH != null) {
            this.gyH.refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bsu();
    }

    private void bsu() {
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13008");
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dW("fid", this.fKR);
        aqVar.an("obj_locate", 2);
        aqVar.an("obj_type", 15);
        aqVar.bsu();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void SM() {
        this.Ya.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bQW() {
        if (this.gyG != null) {
            this.gyG.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void btS() {
        if (j.isNetWorkAvailable()) {
            this.gyH.refresh();
        } else {
            bQX();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void btT() {
    }
}
