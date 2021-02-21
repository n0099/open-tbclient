package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.b;
import com.baidu.tieba.ala.alasquare.special_forum.a.c;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeRecyclerView XW;
    private PbListView gAw;
    private BdSwipeRefreshLayout gCQ;
    private a gHv;
    private SpecialConcernTabModel gHw;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gHx = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.gHw != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a gHy = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void d(List<n> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.lU(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (y.getCount(list) == 0) {
                ConcernTabFragment.this.bRB();
            } else {
                ConcernTabFragment.this.XW.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.WY();
                } else {
                    ConcernTabFragment.this.WX();
                }
                ConcernTabFragment.this.WZ();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void A(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.bSy();
            ConcernTabFragment.this.bRB();
        }
    };
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.bSy();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.gHw.bRL();
            }
        }
    };
    private final f.c gHz = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.gHw.Ut();
            } else {
                ConcernTabFragment.this.lU(false);
            }
        }
    };

    public static ConcernTabFragment tQ(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gHw == null) {
            this.gHw = new SpecialConcernTabModel(getPageContext());
            this.gHw.a(this.gHy);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.XW.setLayoutManager(new LinearLayoutManager(getContext()));
            this.XW.setFadingEdgeLength(0);
            this.XW.setOverScrollMode(2);
            this.XW.setOnSrollToBottomListener(this.WH);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gHz);
            this.gAw = new PbListView(getContext());
            this.gAw.createView();
            this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gAw.setLineGone();
            this.gAw.setTextSize(R.dimen.tbfontsize33);
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gAw.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.gCQ = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.gCQ.setProgressView(this.mPullView);
            this.gHv = new a();
            this.XW.addAdapters(this.gHv.bns);
        }
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin()) {
            refreshData();
        }
        return this.mRootView;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bSx() {
        super.bSx();
        if (this.XW != null) {
            this.XW.scrollToPosition(0);
        }
        if (this.gCQ != null) {
            this.gCQ.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.XW != null) {
            this.XW.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRB() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gHx) {
            this.XW.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gHx = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        this.mIsInit = false;
        this.gHw.Ut();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        if (this.XW != null && this.mRefreshView != null) {
            this.XW.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gHx = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WX() {
        this.XW.setNextPage(this.gAw);
        this.gAw.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WY() {
        this.XW.setNextPage(this.gAw);
        this.gAw.setText(getResources().getString(R.string.list_no_more));
        this.gAw.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSy() {
        this.XW.setNextPage(null);
    }

    public void lU(boolean z) {
        if (!z) {
            this.gCQ.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.changeSkin(i);
        }
        if (this.XW != null) {
            this.XW.getListAdapter().notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gCQ, R.color.CAM_X0204);
        ap.setBackgroundColor(this.XW, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.XW.setOnSrollToBottomListener(null);
        this.XW.setScrollable(null);
        this.gHw.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes10.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a gHB;
        private b gHC;
        private c gHD;

        public a() {
            this.gHB = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.gHC = new b(ConcernTabFragment.this.getPageContext());
            this.gHD = new c(ConcernTabFragment.this.getPageContext());
            this.gHC.a(new w() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.w
                public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (nVar != null && (nVar instanceof com.baidu.tieba.ala.alasquare.special_forum.data.f)) {
                        com.baidu.tieba.ala.alasquare.special_forum.data.f fVar = (com.baidu.tieba.ala.alasquare.special_forum.data.f) nVar;
                        if (fVar.gGX != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast(R.string.neterror);
                                return;
                            }
                            if (((com.baidu.tieba.ala.alasquare.special_forum.data.f) nVar).gGY) {
                                TiebaStatic.log(new ar("c12896"));
                            } else {
                                TiebaStatic.log(new ar("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.gGX);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.bns.add(this.gHB);
            this.bns.add(this.gHC);
            this.bns.add(this.gHD);
        }
    }
}
