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
/* loaded from: classes9.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements aq {
    private BdTypeRecyclerView Zq;
    private PbListView gCf;
    private BdSwipeRefreshLayout gDf;
    private a gDg;
    private AlaLiveTabYanzhiModel gDu;
    private g mPullView;
    private View mRootView;
    private AlaLiveTabYanzhiModel.a gDv = new AlaLiveTabYanzhiModel.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.1
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void g(boolean z, List<n> list) {
            if (z) {
                LiveTabYanzhiSubFragment.this.bRE();
            } else {
                LiveTabYanzhiSubFragment.this.bRD();
            }
            LiveTabYanzhiSubFragment.this.bRO();
            LiveTabYanzhiSubFragment.this.setData(list);
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.a
        public void g(int i, String str, boolean z) {
            LiveTabYanzhiSubFragment.this.bRO();
            if (z) {
                LiveTabYanzhiSubFragment.this.showToast(R.string.data_load_error);
            }
        }
    };
    private f.c gDk = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                LiveTabYanzhiSubFragment.this.gDu.refresh();
            } else {
                LiveTabYanzhiSubFragment.this.bRO();
            }
        }
    };
    private BdListView.e gDl = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                LiveTabYanzhiSubFragment.this.hideLoadingView();
            } else {
                LiveTabYanzhiSubFragment.this.gDu.bRp();
            }
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment.4
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            Log.e("D444", "dy" + i2 + ", dx" + i);
            if (i2 >= 4 && !LiveTabYanzhiSubFragment.this.gDb) {
                LiveTabYanzhiSubFragment.this.bRM();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bsR();
    }

    private void bsR() {
        ar arVar = new ar("c13008");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("fid", this.fOD);
        arVar.aq("obj_locate", 2);
        arVar.aq("obj_type", 15);
        arVar.bsR();
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
            this.gCv = arguments.getBoolean("arg_after_lazy_loaded", false);
        }
        if (this.gDu == null) {
            this.gDu = new AlaLiveTabYanzhiModel(getPageContext(), this.gDv);
        }
        this.gDu.init();
        this.gDu.eg(this.fOD, this.gDc);
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
        this.Zq = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.live_tab_list_view);
        this.Zq.setLayoutManager(new LinearLayoutManager(this.mContext));
        this.Zq.setFadingEdgeLength(0);
        this.Zq.setOverScrollMode(2);
        this.gDg = new a(getPageContext(), this.Zq, 102);
        this.gCf = new PbListView(this.mContext);
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mPullView.setTag(getPageContext().getUniqueId());
        this.Zq.addOnScrollListener(this.mOnScrollListener);
        setListPullRefreshListener(this.gDk);
        a(this.gDl);
        if (blw()) {
            this.gDf.setEnabled(false);
            this.gDf.interruptRefresh();
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
        this.gDg.setData(list);
    }

    private void setListPullRefreshListener(f.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    private void a(BdListView.e eVar) {
        if (this.Zq != null) {
            this.Zq.setOnSrollToBottomListener(eVar);
        }
    }

    private void startPullRefresh() {
        if (blw()) {
            t tVar = new t();
            tVar.tabId = 1120;
            tVar.gec = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
            return;
        }
        this.gDf.setRefreshing(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRO() {
        if (blw()) {
            t tVar = new t();
            tVar.tabId = 1120;
            tVar.gec = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
            return;
        }
        this.gDf.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRD() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Zq.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gCf.setText(this.mContext.getResources().getString(R.string.list_no_more));
            this.gCf.endLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRE() {
        if (this.gCf != null) {
            if (this.gCf.getView().getParent() == null) {
                this.Zq.setNextPage(this.gCf);
            }
            this.gCf.setHeight(l.getDimens(this.mContext, R.dimen.tbds182));
            this.gCf.setText(this.mContext.getResources().getString(R.string.loading));
            this.gCf.startLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.Zq.setNextPage(null);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.gDg != null) {
            this.gDg.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.Zq != null) {
            this.Zq.removeOnScrollListener(this.mOnScrollListener);
            this.Zq.setOnSrollToBottomListener(null);
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
        if (this.gDu != null) {
            this.gDu.onDestroy();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        if (this.gDu != null) {
            this.gDu.refresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void Uw() {
        this.Zq.setSelection(0);
        startPullRefresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void bRN() {
        if (this.gDg != null) {
            this.gDg.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bup() {
        if (j.isNetWorkAvailable()) {
            this.gDu.refresh();
        } else {
            bRO();
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void buq() {
    }
}
