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
    private a dBW;
    private SpecialRecommendTabModel dBX;
    private BdTypeListView duK;
    private PbListView dvS;
    private i mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean dBI = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a dBY = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void h(List<m> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!v.isEmpty(list)) {
                RecommendTabFragment.this.duK.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.aKh();
            } else {
                RecommendTabFragment.this.aKg();
            }
            RecommendTabFragment.this.fU(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.aJm();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void R(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.aKi();
            RecommendTabFragment.this.aJl();
        }
    };
    private BdListView.e xE = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.aKi();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.dBX.aJr();
            }
        }
    };
    private final h.c dBK = new h.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.dBX.vV();
            } else {
                RecommendTabFragment.this.fU(false);
            }
        }
    };

    public static RecommendTabFragment mm(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.dBX == null) {
            this.dBX = new SpecialRecommendTabModel(getPageContext());
            this.dBX.a(this.dBY);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.duK = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.duK.setFadingEdgeLength(0);
            this.duK.setOverScrollMode(2);
            this.duK.setScrollable(this);
            this.duK.setOnSrollToBottomListener(this.xE);
            this.mPullView = new i(getPageContext());
            this.mPullView.setListPullRefreshListener(this.dBK);
            this.duK.setPullRefresh(this.mPullView);
            this.dvS = new PbListView(getContext());
            this.dvS.createView();
            this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.dvS.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.dvS.setLineGone();
            this.dvS.setTextSize(R.dimen.tbfontsize33);
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dvS.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.dBW = new a();
            this.duK.addAdapters(this.dBW.agy);
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
    public void aJl() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.dBI) {
            this.duK.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.dBI = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.dBX.vV();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJm() {
        if (this.duK != null && this.mRefreshView != null) {
            this.duK.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.dBI = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKg() {
        this.duK.setNextPage(this.dvS);
        this.dvS.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
        this.duK.setNextPage(this.dvS);
        this.dvS.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.setText(getResources().getString(R.string.list_no_more));
        this.dvS.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKi() {
        this.duK.setNextPage(this.dvS);
        this.dvS.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.dvS.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void fU(boolean z) {
        if (!z) {
            this.duK.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.dvS != null) {
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.changeSkin(i);
        }
        am.setBackgroundColor(this.duK, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void aKf() {
        super.aKf();
        if (this.duK != null) {
            this.duK.smoothScrollToPosition(0);
            this.duK.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.duK != null) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.duK.setOnSrollToBottomListener(null);
        this.duK.setScrollable(null);
        this.dBX.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes6.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> agy = new LinkedList();
        private e dBR;
        private d dCa;

        public a() {
            this.dCa = new d(RecommendTabFragment.this.getPageContext());
            this.dBR = new e(RecommendTabFragment.this.getPageContext());
            this.dBR.setFrom(2);
            this.agy.add(this.dCa);
            this.agy.add(this.dBR);
            this.dBR.b(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
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
            if (tbPageContext != null && bhVar != null && bhVar.aiE() != null && bhVar.aiX() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bhVar.aiE().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bh bhVar2 : RecommendTabFragment.this.dBX.aKe()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(M(bhVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData M(bh bhVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
            alaLiveInfoCoreData.userName = bhVar.aiE().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
