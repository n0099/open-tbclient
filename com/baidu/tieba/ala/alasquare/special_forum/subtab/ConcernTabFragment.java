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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.b;
import com.baidu.tieba.ala.alasquare.special_forum.a.c;
import com.baidu.tieba.ala.alasquare.special_forum.data.f;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    private a dBG;
    private SpecialConcernTabModel dBH;
    private PbListView dvS;
    private BdSwipeRefreshLayout dxt;
    private i mPullView;
    private h mRefreshView;
    private View mRootView;
    private BdTypeRecyclerView yJ;
    private boolean mHasMore = true;
    private boolean dBI = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.dBH != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a dBJ = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void b(List<m> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.fU(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (v.getCount(list) == 0) {
                ConcernTabFragment.this.aJl();
            } else {
                ConcernTabFragment.this.yJ.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.aKh();
                } else {
                    ConcernTabFragment.this.aKg();
                }
                ConcernTabFragment.this.aJm();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void R(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.aKi();
            ConcernTabFragment.this.aJl();
        }
    };
    private BdListView.e xE = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.aKi();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.dBH.aJr();
            }
        }
    };
    private final h.c dBK = new h.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.dBH.vV();
            } else {
                ConcernTabFragment.this.fU(false);
            }
        }
    };

    public static ConcernTabFragment ml(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.dBH == null) {
            this.dBH = new SpecialConcernTabModel(getPageContext());
            this.dBH.a(this.dBJ);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.yJ = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.yJ.setLayoutManager(new LinearLayoutManager(getContext()));
            this.yJ.setFadingEdgeLength(0);
            this.yJ.setOverScrollMode(2);
            this.yJ.setOnSrollToBottomListener(this.xE);
            this.mPullView = new i(getPageContext());
            this.mPullView.setListPullRefreshListener(this.dBK);
            this.dvS = new PbListView(getContext());
            this.dvS.createView();
            this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.dvS.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.dvS.setLineGone();
            this.dvS.setTextSize(R.dimen.tbfontsize33);
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dvS.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.dxt = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.dxt.setProgressView(this.mPullView);
            this.dBG = new a();
            this.yJ.addAdapters(this.dBG.agy);
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
    public void aKf() {
        super.aKf();
        if (this.yJ != null) {
            this.yJ.scrollToPosition(0);
        }
        if (this.dxt != null) {
            this.dxt.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.yJ != null) {
            this.yJ.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJl() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.dBI) {
            this.yJ.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.dBI = true;
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
        this.dBH.vV();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJm() {
        if (this.yJ != null && this.mRefreshView != null) {
            this.yJ.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.dBI = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKg() {
        this.yJ.setNextPage(this.dvS);
        this.dvS.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
        this.yJ.setNextPage(this.dvS);
        this.dvS.setText(getResources().getString(R.string.list_no_more));
        this.dvS.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKi() {
        this.yJ.setNextPage(null);
    }

    public void fU(boolean z) {
        if (!z) {
            this.dxt.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.dvS != null) {
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.changeSkin(i);
        }
        if (this.yJ != null) {
            this.yJ.getListAdapter().notifyDataSetChanged();
        }
        am.setBackgroundColor(this.dxt, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.yJ, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.yJ.setOnSrollToBottomListener(null);
        this.yJ.setScrollable(null);
        this.dBH.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes6.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> agy = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a dBM;
        private b dBN;
        private c dBO;

        public a() {
            this.dBM = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.dBN = new b(ConcernTabFragment.this.getPageContext());
            this.dBO = new c(ConcernTabFragment.this.getPageContext());
            this.dBN.a(new s() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.s
                public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (mVar != null && (mVar instanceof f)) {
                        f fVar = (f) mVar;
                        if (fVar.dBi != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast((int) R.string.neterror);
                                return;
                            }
                            if (((f) mVar).dBj) {
                                TiebaStatic.log(new an("c12896"));
                            } else {
                                TiebaStatic.log(new an("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.dBi);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.agy.add(this.dBM);
            this.agy.add(this.dBN);
            this.agy.add(this.dBO);
        }
    }
}
