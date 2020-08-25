package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.b;
import com.baidu.tieba.ala.alasquare.special_forum.a.c;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeRecyclerView Wu;
    private PbListView fDW;
    private BdSwipeRefreshLayout fGi;
    private a fKH;
    private SpecialConcernTabModel fKI;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fKJ = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.fKI != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a fKK = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void d(List<q> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.kf(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (y.getCount(list) == 0) {
                ConcernTabFragment.this.bFV();
            } else {
                ConcernTabFragment.this.Wu.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.bGS();
                } else {
                    ConcernTabFragment.this.bGR();
                }
                ConcernTabFragment.this.bFW();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void az(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.bGT();
            ConcernTabFragment.this.bFV();
        }
    };
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.bGT();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.fKI.bGf();
            }
        }
    };
    private final f.c fKL = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.fKI.OA();
            } else {
                ConcernTabFragment.this.kf(false);
            }
        }
    };

    public static ConcernTabFragment sK(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fKI == null) {
            this.fKI = new SpecialConcernTabModel(getPageContext());
            this.fKI.a(this.fKK);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.Wu.setLayoutManager(new LinearLayoutManager(getContext()));
            this.Wu.setFadingEdgeLength(0);
            this.Wu.setOverScrollMode(2);
            this.Wu.setOnSrollToBottomListener(this.Vh);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fKL);
            this.fDW = new PbListView(getContext());
            this.fDW.createView();
            this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fDW.setLineGone();
            this.fDW.setTextSize(R.dimen.tbfontsize33);
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fDW.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.fGi = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.fGi.setProgressView(this.mPullView);
            this.fKH = new a();
            this.Wu.addAdapters(this.fKH.bbu);
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
    public void bGQ() {
        super.bGQ();
        if (this.Wu != null) {
            this.Wu.scrollToPosition(0);
        }
        if (this.fGi != null) {
            this.fGi.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.Wu != null) {
            this.Wu.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFV() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fKJ) {
            this.Wu.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fKJ = true;
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
        this.fKI.OA();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFW() {
        if (this.Wu != null && this.mRefreshView != null) {
            this.Wu.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.fKJ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGR() {
        this.Wu.setNextPage(this.fDW);
        this.fDW.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGS() {
        this.Wu.setNextPage(this.fDW);
        this.fDW.setText(getResources().getString(R.string.list_no_more));
        this.fDW.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGT() {
        this.Wu.setNextPage(null);
    }

    public void kf(boolean z) {
        if (!z) {
            this.fGi.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(i);
        }
        if (this.Wu != null) {
            this.Wu.getListAdapter().notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fGi, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Wu.setOnSrollToBottomListener(null);
        this.Wu.setScrollable(null);
        this.fKI.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes4.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a fKN;
        private b fKO;
        private c fKP;

        public a() {
            this.fKN = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.fKO = new b(ConcernTabFragment.this.getPageContext());
            this.fKP = new c(ConcernTabFragment.this.getPageContext());
            this.fKO.a(new ab() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.ab
                public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (qVar != null && (qVar instanceof com.baidu.tieba.ala.alasquare.special_forum.data.f)) {
                        com.baidu.tieba.ala.alasquare.special_forum.data.f fVar = (com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar;
                        if (fVar.fKj != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast((int) R.string.neterror);
                                return;
                            }
                            if (((com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar).fKk) {
                                TiebaStatic.log(new aq("c12896"));
                            } else {
                                TiebaStatic.log(new aq("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.fKj);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.bbu.add(this.fKN);
            this.bbu.add(this.fKO);
            this.bbu.add(this.fKP);
        }
    }
}
