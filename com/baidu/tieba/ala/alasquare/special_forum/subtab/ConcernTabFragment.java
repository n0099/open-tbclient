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
/* loaded from: classes6.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeRecyclerView Yf;
    private PbListView grg;
    private BdSwipeRefreshLayout gtA;
    private a gya;
    private SpecialConcernTabModel gyb;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gyc = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.gyb != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a gyd = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void d(List<q> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.lx(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (y.getCount(list) == 0) {
                ConcernTabFragment.this.bSf();
            } else {
                ConcernTabFragment.this.Yf.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.Ya();
                } else {
                    ConcernTabFragment.this.XZ();
                }
                ConcernTabFragment.this.Yb();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void t(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.bTb();
            ConcernTabFragment.this.bSf();
        }
    };
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.bTb();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.gyb.bSp();
            }
        }
    };
    private final f.c gye = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.gyb.VC();
            } else {
                ConcernTabFragment.this.lx(false);
            }
        }
    };

    public static ConcernTabFragment vf(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gyb == null) {
            this.gyb = new SpecialConcernTabModel(getPageContext());
            this.gyb.a(this.gyd);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.Yf.setLayoutManager(new LinearLayoutManager(getContext()));
            this.Yf.setFadingEdgeLength(0);
            this.Yf.setOverScrollMode(2);
            this.Yf.setOnSrollToBottomListener(this.WQ);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gye);
            this.grg = new PbListView(getContext());
            this.grg.createView();
            this.grg.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.grg.setLineGone();
            this.grg.setTextSize(R.dimen.tbfontsize33);
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
            this.grg.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.gtA = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.gtA.setProgressView(this.mPullView);
            this.gya = new a();
            this.Yf.addAdapters(this.gya.bnf);
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
    public void bTa() {
        super.bTa();
        if (this.Yf != null) {
            this.Yf.scrollToPosition(0);
        }
        if (this.gtA != null) {
            this.gtA.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.Yf != null) {
            this.Yf.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSf() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gyc) {
            this.Yf.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gyc = true;
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
        this.gyb.VC();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yb() {
        if (this.Yf != null && this.mRefreshView != null) {
            this.Yf.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gyc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XZ() {
        this.Yf.setNextPage(this.grg);
        this.grg.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        this.Yf.setNextPage(this.grg);
        this.grg.setText(getResources().getString(R.string.list_no_more));
        this.grg.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTb() {
        this.Yf.setNextPage(null);
    }

    public void lx(boolean z) {
        if (!z) {
            this.gtA.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(i);
        }
        if (this.Yf != null) {
            this.Yf.getListAdapter().notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gtA, R.color.CAM_X0204);
        ap.setBackgroundColor(this.Yf, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Yf.setOnSrollToBottomListener(null);
        this.Yf.setScrollable(null);
        this.gyb.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes6.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a gyg;
        private b gyh;
        private c gyi;

        public a() {
            this.gyg = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.gyh = new b(ConcernTabFragment.this.getPageContext());
            this.gyi = new c(ConcernTabFragment.this.getPageContext());
            this.gyh.a(new ab() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.ab
                public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (qVar != null && (qVar instanceof com.baidu.tieba.ala.alasquare.special_forum.data.f)) {
                        com.baidu.tieba.ala.alasquare.special_forum.data.f fVar = (com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar;
                        if (fVar.gxC != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast((int) R.string.neterror);
                                return;
                            }
                            if (((com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar).gxD) {
                                TiebaStatic.log(new ar("c12896"));
                            } else {
                                TiebaStatic.log(new ar("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.gxC);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.bnf.add(this.gyg);
            this.bnf.add(this.gyh);
            this.bnf.add(this.gyi);
        }
    }
}
