package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.d;
import com.baidu.tieba.ala.alasquare.special_forum.a.e;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    private a dCN;
    private SpecialRecommendTabModel dCO;
    private BdTypeListView dvB;
    private PbListView dwJ;
    private i mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean dCz = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a dCP = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void h(List<m> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!v.isEmpty(list)) {
                RecommendTabFragment.this.dvB.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.aKj();
            } else {
                RecommendTabFragment.this.aKi();
            }
            RecommendTabFragment.this.fU(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.aJo();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void S(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.aKk();
            RecommendTabFragment.this.aJn();
        }
    };
    private BdListView.e ye = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.aKk();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.dCO.aJt();
            }
        }
    };
    private final h.c dCB = new h.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.dCO.vU();
            } else {
                RecommendTabFragment.this.fU(false);
            }
        }
    };

    public static RecommendTabFragment mn(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.dCO == null) {
            this.dCO = new SpecialRecommendTabModel(getPageContext());
            this.dCO.a(this.dCP);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.dvB = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.dvB.setFadingEdgeLength(0);
            this.dvB.setOverScrollMode(2);
            this.dvB.setScrollable(this);
            this.dvB.setOnSrollToBottomListener(this.ye);
            this.mPullView = new i(getPageContext());
            this.mPullView.setListPullRefreshListener(this.dCB);
            this.dvB.setPullRefresh(this.mPullView);
            this.dwJ = new PbListView(getContext());
            this.dwJ.createView();
            this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.dwJ.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.dwJ.setLineGone();
            this.dwJ.setTextSize(R.dimen.tbfontsize33);
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dwJ.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.dCN = new a();
            this.dvB.addAdapters(this.dCN.agQ);
        }
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.mIsInit) {
            refreshData();
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
            this.dvB.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.dCz = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.dCO.vU();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJo() {
        if (this.dvB != null && this.mRefreshView != null) {
            this.dvB.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.dCz = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKi() {
        this.dvB.setNextPage(this.dwJ);
        this.dwJ.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKj() {
        this.dvB.setNextPage(this.dwJ);
        this.dwJ.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.setText(getResources().getString(R.string.list_no_more));
        this.dwJ.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKk() {
        this.dvB.setNextPage(this.dwJ);
        this.dwJ.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.dwJ.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void fU(boolean z) {
        if (!z) {
            this.dvB.completePullRefresh();
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
        am.setBackgroundColor(this.dvB, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void aKh() {
        super.aKh();
        if (this.dvB != null) {
            this.dvB.smoothScrollToPosition(0);
            this.dvB.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.dvB != null) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dvB.setOnSrollToBottomListener(null);
        this.dvB.setScrollable(null);
        this.dCO.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes6.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> agQ = new LinkedList();
        private e dCI;
        private d dCR;

        public a() {
            this.dCR = new d(RecommendTabFragment.this.getPageContext());
            this.dCI = new e(RecommendTabFragment.this.getPageContext());
            this.dCI.setFrom(2);
            this.agQ.add(this.dCR);
            this.agQ.add(this.dCI);
            this.dCI.b(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void a(int i, String str, bh bhVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bhVar, str);
                    if (bhVar != null) {
                        TiebaStatic.log(new an("c12900").bS("tid", bhVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bh bhVar, String str) {
            if (tbPageContext != null && bhVar != null && bhVar.aiG() != null && bhVar.aiZ() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bhVar.aiG().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bh bhVar2 : RecommendTabFragment.this.dCO.aKg()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(M(bhVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData M(bh bhVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
            alaLiveInfoCoreData.userName = bhVar.aiG().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
