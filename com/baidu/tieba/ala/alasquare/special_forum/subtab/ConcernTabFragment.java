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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.b;
import com.baidu.tieba.ala.alasquare.special_forum.a.c;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeRecyclerView Vw;
    private PbListView fbY;
    private BdSwipeRefreshLayout fej;
    private a fiK;
    private SpecialConcernTabModel fiL;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fiM = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.fiL != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a fiN = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void d(List<o> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.iQ(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (v.getCount(list) == 0) {
                ConcernTabFragment.this.bqN();
            } else {
                ConcernTabFragment.this.Vw.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.brL();
                } else {
                    ConcernTabFragment.this.brK();
                }
                ConcernTabFragment.this.bqO();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void ax(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.brM();
            ConcernTabFragment.this.bqN();
        }
    };
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.brM();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.fiL.bqX();
            }
        }
    };
    private final f.c fiO = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.fiL.Ho();
            } else {
                ConcernTabFragment.this.iQ(false);
            }
        }
    };

    public static ConcernTabFragment pI(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fiL == null) {
            this.fiL = new SpecialConcernTabModel(getPageContext());
            this.fiL.a(this.fiN);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.Vw.setLayoutManager(new LinearLayoutManager(getContext()));
            this.Vw.setFadingEdgeLength(0);
            this.Vw.setOverScrollMode(2);
            this.Vw.setOnSrollToBottomListener(this.Uf);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fiO);
            this.fbY = new PbListView(getContext());
            this.fbY.createView();
            this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fbY.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fbY.setLineGone();
            this.fbY.setTextSize(R.dimen.tbfontsize33);
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fbY.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.fej = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.fej.setProgressView(this.mPullView);
            this.fiK = new a();
            this.Vw.addAdapters(this.fiK.aSj);
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
    public void brJ() {
        super.brJ();
        if (this.Vw != null) {
            this.Vw.scrollToPosition(0);
        }
        if (this.fej != null) {
            this.fej.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.Vw != null) {
            this.Vw.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqN() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fiM) {
            this.Vw.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fiM = true;
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
        this.fiL.Ho();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqO() {
        if (this.Vw != null && this.mRefreshView != null) {
            this.Vw.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.fiM = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brK() {
        this.Vw.setNextPage(this.fbY);
        this.fbY.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brL() {
        this.Vw.setNextPage(this.fbY);
        this.fbY.setText(getResources().getString(R.string.list_no_more));
        this.fbY.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brM() {
        this.Vw.setNextPage(null);
    }

    public void iQ(boolean z) {
        if (!z) {
            this.fej.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fbY != null) {
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fbY.changeSkin(i);
        }
        if (this.Vw != null) {
            this.Vw.getListAdapter().notifyDataSetChanged();
        }
        am.setBackgroundColor(this.fej, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.Vw, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Vw.setOnSrollToBottomListener(null);
        this.Vw.setScrollable(null);
        this.fiL.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes3.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a fiQ;
        private b fiR;
        private c fiS;

        public a() {
            this.fiQ = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.fiR = new b(ConcernTabFragment.this.getPageContext());
            this.fiS = new c(ConcernTabFragment.this.getPageContext());
            this.fiR.a(new x() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.x
                public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (oVar != null && (oVar instanceof com.baidu.tieba.ala.alasquare.special_forum.data.f)) {
                        com.baidu.tieba.ala.alasquare.special_forum.data.f fVar = (com.baidu.tieba.ala.alasquare.special_forum.data.f) oVar;
                        if (fVar.fil != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast((int) R.string.neterror);
                                return;
                            }
                            if (((com.baidu.tieba.ala.alasquare.special_forum.data.f) oVar).fim) {
                                TiebaStatic.log(new an("c12896"));
                            } else {
                                TiebaStatic.log(new an("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.fil);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.aSj.add(this.fiQ);
            this.aSj.add(this.fiR);
            this.aSj.add(this.fiS);
        }
    }
}
