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
    private BdTypeRecyclerView WM;
    private PbListView fHm;
    private BdSwipeRefreshLayout fJy;
    private a fNZ;
    private SpecialConcernTabModel fOa;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fOb = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.fOa != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a fOc = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void d(List<q> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.ki(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (y.getCount(list) == 0) {
                ConcernTabFragment.this.bHm();
            } else {
                ConcernTabFragment.this.WM.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.bIj();
                } else {
                    ConcernTabFragment.this.bIi();
                }
                ConcernTabFragment.this.bHn();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void az(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.bIk();
            ConcernTabFragment.this.bHm();
        }
    };
    private BdListView.e Vz = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.bIk();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.fOa.bHw();
            }
        }
    };
    private final f.c fOd = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.fOa.Pd();
            } else {
                ConcernTabFragment.this.ki(false);
            }
        }
    };

    public static ConcernTabFragment tc(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fOa == null) {
            this.fOa = new SpecialConcernTabModel(getPageContext());
            this.fOa.a(this.fOc);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.WM = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.WM.setLayoutManager(new LinearLayoutManager(getContext()));
            this.WM.setFadingEdgeLength(0);
            this.WM.setOverScrollMode(2);
            this.WM.setOnSrollToBottomListener(this.Vz);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fOd);
            this.fHm = new PbListView(getContext());
            this.fHm.createView();
            this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fHm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fHm.setLineGone();
            this.fHm.setTextSize(R.dimen.tbfontsize33);
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fHm.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.fJy = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.fJy.setProgressView(this.mPullView);
            this.fNZ = new a();
            this.WM.addAdapters(this.fNZ.bdV);
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
    public void bIh() {
        super.bIh();
        if (this.WM != null) {
            this.WM.scrollToPosition(0);
        }
        if (this.fJy != null) {
            this.fJy.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.WM != null) {
            this.WM.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHm() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fOb) {
            this.WM.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fOb = true;
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
        this.fOa.Pd();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHn() {
        if (this.WM != null && this.mRefreshView != null) {
            this.WM.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.fOb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIi() {
        this.WM.setNextPage(this.fHm);
        this.fHm.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        this.WM.setNextPage(this.fHm);
        this.fHm.setText(getResources().getString(R.string.list_no_more));
        this.fHm.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIk() {
        this.WM.setNextPage(null);
    }

    public void ki(boolean z) {
        if (!z) {
            this.fJy.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(i);
        }
        if (this.WM != null) {
            this.WM.getListAdapter().notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fJy, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.WM, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.WM.setOnSrollToBottomListener(null);
        this.WM.setScrollable(null);
        this.fOa.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes4.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a fOf;
        private b fOg;
        private c fOh;

        public a() {
            this.fOf = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.fOg = new b(ConcernTabFragment.this.getPageContext());
            this.fOh = new c(ConcernTabFragment.this.getPageContext());
            this.fOg.a(new ab() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.ab
                public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (qVar != null && (qVar instanceof com.baidu.tieba.ala.alasquare.special_forum.data.f)) {
                        com.baidu.tieba.ala.alasquare.special_forum.data.f fVar = (com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar;
                        if (fVar.fNB != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast(R.string.neterror);
                                return;
                            }
                            if (((com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar).fNC) {
                                TiebaStatic.log(new aq("c12896"));
                            } else {
                                TiebaStatic.log(new aq("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.fNB);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.bdV.add(this.fOf);
            this.bdV.add(this.fOg);
            this.bdV.add(this.fOh);
        }
    }
}
