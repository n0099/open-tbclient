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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.b;
import com.baidu.tieba.ala.alasquare.special_forum.a.c;
import com.baidu.tieba.ala.alasquare.special_forum.data.f;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeRecyclerView Bn;
    private PbListView egU;
    private BdSwipeRefreshLayout eiv;
    private a emE;
    private SpecialConcernTabModel emF;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean emG = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.emF != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a emH = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void f(List<m> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.hi(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (v.getCount(list) == 0) {
                ConcernTabFragment.this.aZJ();
            } else {
                ConcernTabFragment.this.Bn.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.baG();
                } else {
                    ConcernTabFragment.this.baF();
                }
                ConcernTabFragment.this.aZK();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void aa(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.baH();
            ConcernTabFragment.this.aZJ();
        }
    };
    private BdListView.e Ac = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.baH();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.emF.aZP();
            }
        }
    };
    private final g.c emI = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.emF.xT();
            } else {
                ConcernTabFragment.this.hi(false);
            }
        }
    };

    public static ConcernTabFragment ou(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.emF == null) {
            this.emF = new SpecialConcernTabModel(getPageContext());
            this.emF.a(this.emH);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.Bn = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.Bn.setLayoutManager(new LinearLayoutManager(getContext()));
            this.Bn.setFadingEdgeLength(0);
            this.Bn.setOverScrollMode(2);
            this.Bn.setOnSrollToBottomListener(this.Ac);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.emI);
            this.egU = new PbListView(getContext());
            this.egU.createView();
            this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.egU.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.egU.setLineGone();
            this.egU.setTextSize(R.dimen.tbfontsize33);
            this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
            this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
            this.egU.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.eiv = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.eiv.setProgressView(this.mPullView);
            this.emE = new a();
            this.Bn.addAdapters(this.emE.aoz);
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
    public void baE() {
        super.baE();
        if (this.Bn != null) {
            this.Bn.scrollToPosition(0);
        }
        if (this.eiv != null) {
            this.eiv.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.Bn != null) {
            this.Bn.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZJ() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.emG) {
            this.Bn.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.emG = true;
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
        this.emF.xT();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZK() {
        if (this.Bn != null && this.mRefreshView != null) {
            this.Bn.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.emG = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baF() {
        this.Bn.setNextPage(this.egU);
        this.egU.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baG() {
        this.Bn.setNextPage(this.egU);
        this.egU.setText(getResources().getString(R.string.list_no_more));
        this.egU.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baH() {
        this.Bn.setNextPage(null);
    }

    public void hi(boolean z) {
        if (!z) {
            this.eiv.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.egU != null) {
            this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
            this.egU.changeSkin(i);
        }
        if (this.Bn != null) {
            this.Bn.getListAdapter().notifyDataSetChanged();
        }
        am.setBackgroundColor(this.eiv, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.Bn, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Bn.setOnSrollToBottomListener(null);
        this.Bn.setScrollable(null);
        this.emF.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes2.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> aoz = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a emK;
        private b emL;
        private c emM;

        public a() {
            this.emK = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.emL = new b(ConcernTabFragment.this.getPageContext());
            this.emM = new c(ConcernTabFragment.this.getPageContext());
            this.emL.a(new s() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.s
                public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (mVar != null && (mVar instanceof f)) {
                        f fVar = (f) mVar;
                        if (fVar.emg != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast((int) R.string.neterror);
                                return;
                            }
                            if (((f) mVar).emh) {
                                TiebaStatic.log(new an("c12896"));
                            } else {
                                TiebaStatic.log(new an("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.emg);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.aoz.add(this.emK);
            this.aoz.add(this.emL);
            this.aoz.add(this.emM);
        }
    }
}
