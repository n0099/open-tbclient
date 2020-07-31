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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
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
    private BdTypeRecyclerView VT;
    private PbListView fsC;
    private BdSwipeRefreshLayout fuP;
    private a fzp;
    private SpecialConcernTabModel fzq;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fzr = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.fzq != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a fzs = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void d(List<q> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.jH(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (x.getCount(list) == 0) {
                ConcernTabFragment.this.bwW();
            } else {
                ConcernTabFragment.this.VT.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.bxT();
                } else {
                    ConcernTabFragment.this.bxS();
                }
                ConcernTabFragment.this.bwX();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void aB(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.bxU();
            ConcernTabFragment.this.bwW();
        }
    };
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.bxU();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.fzq.bxg();
            }
        }
    };
    private final f.c fzt = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.fzq.IH();
            } else {
                ConcernTabFragment.this.jH(false);
            }
        }
    };

    public static ConcernTabFragment qy(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fzq == null) {
            this.fzq = new SpecialConcernTabModel(getPageContext());
            this.fzq.a(this.fzs);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.VT = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.VT.setLayoutManager(new LinearLayoutManager(getContext()));
            this.VT.setFadingEdgeLength(0);
            this.VT.setOverScrollMode(2);
            this.VT.setOnSrollToBottomListener(this.UC);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fzt);
            this.fsC = new PbListView(getContext());
            this.fsC.createView();
            this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fsC.setLineGone();
            this.fsC.setTextSize(R.dimen.tbfontsize33);
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fsC.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.fuP = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.fuP.setProgressView(this.mPullView);
            this.fzp = new a();
            this.VT.addAdapters(this.fzp.aWf);
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
    public void bxR() {
        super.bxR();
        if (this.VT != null) {
            this.VT.scrollToPosition(0);
        }
        if (this.fuP != null) {
            this.fuP.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.VT != null) {
            this.VT.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwW() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fzr) {
            this.VT.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fzr = true;
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
        this.fzq.IH();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        if (this.VT != null && this.mRefreshView != null) {
            this.VT.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.fzr = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxS() {
        this.VT.setNextPage(this.fsC);
        this.fsC.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxT() {
        this.VT.setNextPage(this.fsC);
        this.fsC.setText(getResources().getString(R.string.list_no_more));
        this.fsC.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxU() {
        this.VT.setNextPage(null);
    }

    public void jH(boolean z) {
        if (!z) {
            this.fuP.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
        if (this.VT != null) {
            this.VT.getListAdapter().notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.fuP, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.VT, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.VT.setOnSrollToBottomListener(null);
        this.VT.setScrollable(null);
        this.fzq.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes4.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a fzv;
        private b fzw;
        private c fzx;

        public a() {
            this.fzv = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.fzw = new b(ConcernTabFragment.this.getPageContext());
            this.fzx = new c(ConcernTabFragment.this.getPageContext());
            this.fzw.a(new z() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.z
                public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (qVar != null && (qVar instanceof com.baidu.tieba.ala.alasquare.special_forum.data.f)) {
                        com.baidu.tieba.ala.alasquare.special_forum.data.f fVar = (com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar;
                        if (fVar.fyR != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast(R.string.neterror);
                                return;
                            }
                            if (((com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar).fyS) {
                                TiebaStatic.log(new ap("c12896"));
                            } else {
                                TiebaStatic.log(new ap("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.fyR);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.aWf.add(this.fzv);
            this.aWf.add(this.fzw);
            this.aWf.add(this.fzx);
        }
    }
}
