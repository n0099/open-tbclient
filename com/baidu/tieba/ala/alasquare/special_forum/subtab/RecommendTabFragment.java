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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.e;
import com.baidu.tieba.ala.alasquare.special_forum.a.f;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView eOj;
    private PbListView ePr;
    private a eWt;
    private SpecialRecommendTabModel eWu;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean eWc = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a eWv = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void l(List<m> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!v.isEmpty(list)) {
                RecommendTabFragment.this.eOj.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.bmn();
            } else {
                RecommendTabFragment.this.bmm();
            }
            RecommendTabFragment.this.it(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.blr();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void as(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bmo();
            RecommendTabFragment.this.blq();
        }
    };
    private BdListView.e TT = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bmo();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.eWu.blz();
            }
        }
    };
    private final g.c eWe = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.eWu.FG();
            } else {
                RecommendTabFragment.this.it(false);
            }
        }
    };

    public static RecommendTabFragment pi(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.eWu == null) {
            this.eWu = new SpecialRecommendTabModel(getPageContext());
            this.eWu.a(this.eWv);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.eOj = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.eOj.setFadingEdgeLength(0);
            this.eOj.setOverScrollMode(2);
            this.eOj.setScrollable(this);
            this.eOj.setOnSrollToBottomListener(this.TT);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.eWe);
            this.eOj.setPullRefresh(this.mPullView);
            this.ePr = new PbListView(getContext());
            this.ePr.createView();
            this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.ePr.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.ePr.setLineGone();
            this.ePr.setTextSize(R.dimen.tbfontsize33);
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ePr.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.eWt = new a();
            this.eOj.addAdapters(this.eWt.aMj);
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
    public void blq() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.eWc) {
            this.eOj.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.eWc = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.eWu.FG();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blr() {
        if (this.eOj != null && this.mRefreshView != null) {
            this.eOj.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.eWc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmm() {
        this.eOj.setNextPage(this.ePr);
        this.ePr.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmn() {
        this.eOj.setNextPage(this.ePr);
        this.ePr.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.setText(getResources().getString(R.string.list_no_more));
        this.ePr.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmo() {
        this.eOj.setNextPage(this.ePr);
        this.ePr.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePr.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void it(boolean z) {
        if (!z) {
            this.eOj.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePr.changeSkin(i);
        }
        am.setBackgroundColor(this.eOj, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bml() {
        super.bml();
        if (this.eOj != null) {
            this.eOj.smoothScrollToPosition(0);
            this.eOj.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.eOj != null) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eOj.setOnSrollToBottomListener(null);
        this.eOj.setScrollable(null);
        this.eWu.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes3.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> aMj = new LinkedList();
        private f eWo;
        private e eWx;

        public a() {
            this.eWx = new e(RecommendTabFragment.this.getPageContext());
            this.eWo = new f(RecommendTabFragment.this.getPageContext());
            this.eWo.setFrom(2);
            this.aMj.add(this.eWx);
            this.aMj.add(this.eWo);
            this.eWo.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bj bjVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bjVar, str);
                    if (bjVar != null) {
                        TiebaStatic.log(new an("c12900").cI("tid", bjVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
            if (tbPageContext != null && bjVar != null && bjVar.aKC() != null && bjVar.aKV() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bjVar.aKC().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bjVar.aKV());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bj bjVar2 : RecommendTabFragment.this.eWu.bmk()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bjVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData T(bj bjVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aKV());
            alaLiveInfoCoreData.userName = bjVar.aKC().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
