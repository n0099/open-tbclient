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
    private PbListView gre;
    private BdSwipeRefreshLayout gty;
    private a gxY;
    private SpecialConcernTabModel gxZ;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gya = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.gxZ != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a gyb = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void d(List<q> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.lx(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (y.getCount(list) == 0) {
                ConcernTabFragment.this.bSe();
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
            ConcernTabFragment.this.bTa();
            ConcernTabFragment.this.bSe();
        }
    };
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.bTa();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.gxZ.bSo();
            }
        }
    };
    private final f.c gyc = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.gxZ.VC();
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
        if (this.gxZ == null) {
            this.gxZ = new SpecialConcernTabModel(getPageContext());
            this.gxZ.a(this.gyb);
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
            this.mPullView.setListPullRefreshListener(this.gyc);
            this.gre = new PbListView(getContext());
            this.gre.createView();
            this.gre.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gre.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gre.setLineGone();
            this.gre.setTextSize(R.dimen.tbfontsize33);
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gre.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.gty = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.gty.setProgressView(this.mPullView);
            this.gxY = new a();
            this.Yf.addAdapters(this.gxY.bnf);
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
    public void bSZ() {
        super.bSZ();
        if (this.Yf != null) {
            this.Yf.scrollToPosition(0);
        }
        if (this.gty != null) {
            this.gty.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.Yf != null) {
            this.Yf.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSe() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gya) {
            this.Yf.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gya = true;
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
        this.gxZ.VC();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yb() {
        if (this.Yf != null && this.mRefreshView != null) {
            this.Yf.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gya = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XZ() {
        this.Yf.setNextPage(this.gre);
        this.gre.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        this.Yf.setNextPage(this.gre);
        this.gre.setText(getResources().getString(R.string.list_no_more));
        this.gre.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTa() {
        this.Yf.setNextPage(null);
    }

    public void lx(boolean z) {
        if (!z) {
            this.gty.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.changeSkin(i);
        }
        if (this.Yf != null) {
            this.Yf.getListAdapter().notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gty, R.color.CAM_X0204);
        ap.setBackgroundColor(this.Yf, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Yf.setOnSrollToBottomListener(null);
        this.Yf.setScrollable(null);
        this.gxZ.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes6.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a gye;
        private b gyf;
        private c gyg;

        public a() {
            this.gye = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.gyf = new b(ConcernTabFragment.this.getPageContext());
            this.gyg = new c(ConcernTabFragment.this.getPageContext());
            this.gyf.a(new ab() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.ab
                public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (qVar != null && (qVar instanceof com.baidu.tieba.ala.alasquare.special_forum.data.f)) {
                        com.baidu.tieba.ala.alasquare.special_forum.data.f fVar = (com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar;
                        if (fVar.gxA != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast(R.string.neterror);
                                return;
                            }
                            if (((com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar).gxB) {
                                TiebaStatic.log(new ar("c12896"));
                            } else {
                                TiebaStatic.log(new ar("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.gxA);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.bnf.add(this.gye);
            this.bnf.add(this.gyf);
            this.bnf.add(this.gyg);
        }
    }
}
