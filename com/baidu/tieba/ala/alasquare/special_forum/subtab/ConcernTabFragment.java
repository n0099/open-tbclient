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
/* loaded from: classes3.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeRecyclerView Vf;
    private PbListView ePm;
    private BdSwipeRefreshLayout eRw;
    private a eVV;
    private SpecialConcernTabModel eVW;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean eVX = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.eVW != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a eVY = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void d(List<m> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.it(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (v.getCount(list) == 0) {
                ConcernTabFragment.this.bls();
            } else {
                ConcernTabFragment.this.Vf.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.bmp();
                } else {
                    ConcernTabFragment.this.bmo();
                }
                ConcernTabFragment.this.blt();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void as(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.bmq();
            ConcernTabFragment.this.bls();
        }
    };
    private BdListView.e TQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.bmq();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.eVW.blB();
            }
        }
    };
    private final g.c eVZ = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.eVW.FH();
            } else {
                ConcernTabFragment.this.it(false);
            }
        }
    };

    public static ConcernTabFragment ph(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.eVW == null) {
            this.eVW = new SpecialConcernTabModel(getPageContext());
            this.eVW.a(this.eVY);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.Vf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.Vf.setLayoutManager(new LinearLayoutManager(getContext()));
            this.Vf.setFadingEdgeLength(0);
            this.Vf.setOverScrollMode(2);
            this.Vf.setOnSrollToBottomListener(this.TQ);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.eVZ);
            this.ePm = new PbListView(getContext());
            this.ePm.createView();
            this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.ePm.setLineGone();
            this.ePm.setTextSize(R.dimen.tbfontsize33);
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ePm.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.eRw = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.eRw.setProgressView(this.mPullView);
            this.eVV = new a();
            this.Vf.addAdapters(this.eVV.aMd);
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
    public void bmn() {
        super.bmn();
        if (this.Vf != null) {
            this.Vf.scrollToPosition(0);
        }
        if (this.eRw != null) {
            this.eRw.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.Vf != null) {
            this.Vf.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bls() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.eVX) {
            this.Vf.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.eVX = true;
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
        this.eVW.FH();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blt() {
        if (this.Vf != null && this.mRefreshView != null) {
            this.Vf.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.eVX = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmo() {
        this.Vf.setNextPage(this.ePm);
        this.ePm.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmp() {
        this.Vf.setNextPage(this.ePm);
        this.ePm.setText(getResources().getString(R.string.list_no_more));
        this.ePm.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmq() {
        this.Vf.setNextPage(null);
    }

    public void it(boolean z) {
        if (!z) {
            this.eRw.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.changeSkin(i);
        }
        if (this.Vf != null) {
            this.Vf.getListAdapter().notifyDataSetChanged();
        }
        am.setBackgroundColor(this.eRw, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.Vf, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Vf.setOnSrollToBottomListener(null);
        this.Vf.setScrollable(null);
        this.eVW.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes3.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> aMd = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a eWb;
        private b eWc;
        private c eWd;

        public a() {
            this.eWb = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.eWc = new b(ConcernTabFragment.this.getPageContext());
            this.eWd = new c(ConcernTabFragment.this.getPageContext());
            this.eWc.a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.v
                public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (mVar != null && (mVar instanceof f)) {
                        f fVar = (f) mVar;
                        if (fVar.eVx != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast((int) R.string.neterror);
                                return;
                            }
                            if (((f) mVar).eVy) {
                                TiebaStatic.log(new an("c12896"));
                            } else {
                                TiebaStatic.log(new an("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.eVx);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.aMd.add(this.eWb);
            this.aMd.add(this.eWc);
            this.aMd.add(this.eWd);
        }
    }
}
