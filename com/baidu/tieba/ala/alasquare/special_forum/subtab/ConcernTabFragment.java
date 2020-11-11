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
    private BdTypeRecyclerView Xe;
    private PbListView gjo;
    private BdSwipeRefreshLayout glI;
    private a gqi;
    private SpecialConcernTabModel gqj;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gqk = false;
    private boolean mIsInit = false;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && ConcernTabFragment.this.gqj != null && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                ConcernTabFragment.this.refreshData();
            }
        }
    };
    private SpecialConcernTabModel.a gql = new SpecialConcernTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void d(List<q> list, boolean z, int i) {
            ConcernTabFragment.this.mHasMore = z;
            ConcernTabFragment.this.mIsInit = true;
            ConcernTabFragment.this.lc(false);
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            if (y.getCount(list) == 0) {
                ConcernTabFragment.this.bPa();
            } else {
                ConcernTabFragment.this.Xe.setData(list);
                if (!ConcernTabFragment.this.mHasMore) {
                    ConcernTabFragment.this.Wj();
                } else {
                    ConcernTabFragment.this.Wi();
                }
                ConcernTabFragment.this.Wk();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.a
        public void t(int i, String str) {
            ConcernTabFragment.this.hideLoadingView(ConcernTabFragment.this.mRootView);
            ConcernTabFragment.this.bPW();
            ConcernTabFragment.this.bPa();
        }
    };
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                ConcernTabFragment.this.bPW();
            } else if (ConcernTabFragment.this.mHasMore) {
                ConcernTabFragment.this.gqj.bPk();
            }
        }
    };
    private final f.c gqm = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                ConcernTabFragment.this.gqj.TL();
            } else {
                ConcernTabFragment.this.lc(false);
            }
        }
    };

    public static ConcernTabFragment ud(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gqj == null) {
            this.gqj = new SpecialConcernTabModel(getPageContext());
            this.gqj.a(this.gql);
        }
        MessageManager.getInstance().registerListener(this.mAccountChangedListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.content_thread);
            this.Xe.setLayoutManager(new LinearLayoutManager(getContext()));
            this.Xe.setFadingEdgeLength(0);
            this.Xe.setOverScrollMode(2);
            this.Xe.setOnSrollToBottomListener(this.VR);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gqm);
            this.gjo = new PbListView(getContext());
            this.gjo.createView();
            this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gjo.setLineGone();
            this.gjo.setTextSize(R.dimen.tbfontsize33);
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gjo.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.glI = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pull_refresh_layout);
            this.glI.setProgressView(this.mPullView);
            this.gqi = new a();
            this.Xe.addAdapters(this.gqi.bky);
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
    public void bPV() {
        super.bPV();
        if (this.Xe != null) {
            this.Xe.scrollToPosition(0);
        }
        if (this.glI != null) {
            this.glI.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.Xe != null) {
            this.Xe.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPa() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gqk) {
            this.Xe.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gqk = true;
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
        this.gqj.TL();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wk() {
        if (this.Xe != null && this.mRefreshView != null) {
            this.Xe.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gqk = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wi() {
        this.Xe.setNextPage(this.gjo);
        this.gjo.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wj() {
        this.Xe.setNextPage(this.gjo);
        this.gjo.setText(getResources().getString(R.string.list_no_more));
        this.gjo.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPW() {
        this.Xe.setNextPage(null);
    }

    public void lc(boolean z) {
        if (!z) {
            this.glI.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
        if (this.Xe != null) {
            this.Xe.getListAdapter().notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.glI, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.Xe, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Xe.setOnSrollToBottomListener(null);
        this.Xe.setScrollable(null);
        this.gqj.onDestroy();
        hideLoadingView(this.mRootView);
        MessageManager.getInstance().unRegisterListener(this.mAccountChangedListener);
    }

    /* loaded from: classes4.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.a gqo;
        private b gqp;
        private c gqq;

        public a() {
            this.gqo = new com.baidu.tieba.ala.alasquare.special_forum.a.a(ConcernTabFragment.this.getPageContext());
            this.gqp = new b(ConcernTabFragment.this.getPageContext());
            this.gqq = new c(ConcernTabFragment.this.getPageContext());
            this.gqp.a(new ab() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.ConcernTabFragment.a.1
                @Override // com.baidu.adp.widget.ListView.ab
                public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                    if (qVar != null && (qVar instanceof com.baidu.tieba.ala.alasquare.special_forum.data.f)) {
                        com.baidu.tieba.ala.alasquare.special_forum.data.f fVar = (com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar;
                        if (fVar.gpK != null) {
                            if (!l.isNetOk()) {
                                ConcernTabFragment.this.getPageContext().showToast((int) R.string.neterror);
                                return;
                            }
                            if (((com.baidu.tieba.ala.alasquare.special_forum.data.f) qVar).gpL) {
                                TiebaStatic.log(new aq("c12896"));
                            } else {
                                TiebaStatic.log(new aq("c12894"));
                            }
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.fillWithInfoData(fVar.gpK);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, "frs_live_tab_concern_tab", TbadkCoreApplication.getCurrentAccount(), false, "")));
                        }
                    }
                }
            });
            this.bky.add(this.gqo);
            this.bky.add(this.gqp);
            this.bky.add(this.gqq);
        }
    }
}
