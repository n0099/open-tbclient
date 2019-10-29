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
    private a dCx;
    private SpecialConcernTabModel dCy;
    private PbListView dwJ;
    private BdSwipeRefreshLayout dyk;
    private i mPullView;
    private h mRefreshView;
    private View mRootView;
    private BdTypeRecyclerView zj;
    private boolean mHasMore = true;
    private boolean dCz = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.dCy != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a dCA = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void d(List<m> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.fU(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (v.getCount(list) == 0) {
                ConcernTabFragment.this.aJn();
            } else {
                ConcernTabFragment.this.zj.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.aKj();
                } else {
                    ConcernTabFragment.this.aKi();
                }
                ConcernTabFragment.this.aJo();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void S(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.aKk();
            ConcernTabFragment.this.aJn();
        }
    };
    private BdListView.e ye = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.aKk();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.dCy.aJt();
            }
        }
    };
    private final h.c dCB = new h.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.dCy.vU();
            } else {
                ConcernTabFragment.this.fU(false);
            }
        }
    };

    public static ConcernTabFragment mm(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.dCy == null) {
            this.dCy = new SpecialConcernTabModel(getPageContext());
            this.dCy.a(this.dCA);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.zj = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.zj.setLayoutManager(new LinearLayoutManager(getContext()));
            this.zj.setFadingEdgeLength(0);
            this.zj.setOverScrollMode(2);
            this.zj.setOnSrollToBottomListener(this.ye);
            this.mPullView = new i(getPageContext());
            this.mPullView.setListPullRefreshListener(this.dCB);
            this.dwJ = new PbListView(getContext());
            this.dwJ.createView();
            this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.dwJ.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.dwJ.setLineGone();
            this.dwJ.setTextSize(R.dimen.tbfontsize33);
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dwJ.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.dyk = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.dyk.setProgressView(this.mPullView);
            this.dCx = new a();
            this.zj.addAdapters(this.dCx.agQ);
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
    public void aKh() {
        super.aKh();
        if (this.zj != null) {
            this.zj.scrollToPosition(0);
        }
        if (this.dyk != null) {
            this.dyk.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.zj != null) {
            this.zj.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJn() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.dCz) {
            this.zj.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.dCz = true;
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
        this.dCy.vU();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJo() {
        if (this.zj != null && this.mRefreshView != null) {
            this.zj.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.dCz = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKi() {
        this.zj.setNextPage(this.dwJ);
        this.dwJ.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKj() {
        this.zj.setNextPage(this.dwJ);
        this.dwJ.setText(getResources().getString(R.string.list_no_more));
        this.dwJ.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKk() {
        this.zj.setNextPage(null);
    }

    public void fU(boolean z) {
        if (!z) {
            this.dyk.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.dwJ != null) {
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dwJ.changeSkin(i);
        }
        if (this.zj != null) {
            this.zj.getListAdapter().notifyDataSetChanged();
        }
        am.setBackgroundColor(this.dyk, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.zj, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.zj.setOnSrollToBottomListener(null);
        this.zj.setScrollable(null);
        this.dCy.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes6.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> agQ = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a dCD;
        private b dCE;
        private c dCF;

        public a() {
            this.dCD = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.dCE = new b(ConcernTabFragment.this.getPageContext());
            this.dCF = new c(ConcernTabFragment.this.getPageContext());
            this.dCE.a(new s() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.s
                public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (mVar != null && (mVar instanceof f)) {
                        f fVar = (f) mVar;
                        if (fVar.dBZ != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast((int) R.string.neterror);
                                return;
                            }
                            if (((f) mVar).dCa) {
                                TiebaStatic.log(new an("c12896"));
                            } else {
                                TiebaStatic.log(new an("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.dBZ);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.agQ.add(this.dCD);
            this.agQ.add(this.dCE);
            this.agQ.add(this.dCF);
        }
    }
}
