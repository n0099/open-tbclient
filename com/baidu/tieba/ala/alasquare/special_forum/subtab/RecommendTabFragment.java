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
    private BdTypeListView eka;
    private PbListView eli;
    private a esi;
    private SpecialRecommendTabModel esj;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean erR = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a esk = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void l(List<m> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!v.isEmpty(list)) {
                RecommendTabFragment.this.eka.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.bdq();
            } else {
                RecommendTabFragment.this.bdp();
            }
            RecommendTabFragment.this.hu(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bcv();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void ad(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bdr();
            RecommendTabFragment.this.bcu();
        }
    };
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bdr();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.esj.bcD();
            }
        }
    };
    private final g.c erT = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.esj.AA();
            } else {
                RecommendTabFragment.this.hu(false);
            }
        }
    };

    public static RecommendTabFragment oN(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.esj == null) {
            this.esj = new SpecialRecommendTabModel(getPageContext());
            this.esj.a(this.esk);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.eka = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.eka.setFadingEdgeLength(0);
            this.eka.setOverScrollMode(2);
            this.eka.setScrollable(this);
            this.eka.setOnSrollToBottomListener(this.Az);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.erT);
            this.eka.setPullRefresh(this.mPullView);
            this.eli = new PbListView(getContext());
            this.eli.createView();
            this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.eli.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.eli.setLineGone();
            this.eli.setTextSize(R.dimen.tbfontsize33);
            this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
            this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
            this.eli.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.esi = new a();
            this.eka.addAdapters(this.esi.asE);
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
    public void bcu() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.erR) {
            this.eka.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.erR = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.esj.AA();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcv() {
        if (this.eka != null && this.mRefreshView != null) {
            this.eka.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.erR = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdp() {
        this.eka.setNextPage(this.eli);
        this.eli.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdq() {
        this.eka.setNextPage(this.eli);
        this.eli.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.setText(getResources().getString(R.string.list_no_more));
        this.eli.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdr() {
        this.eka.setNextPage(this.eli);
        this.eli.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.eli.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void hu(boolean z) {
        if (!z) {
            this.eka.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.eli != null) {
            this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
            this.eli.changeSkin(i);
        }
        am.setBackgroundColor(this.eka, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bdo() {
        super.bdo();
        if (this.eka != null) {
            this.eka.smoothScrollToPosition(0);
            this.eka.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.eka != null) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eka.setOnSrollToBottomListener(null);
        this.eka.setScrollable(null);
        this.esj.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes3.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
        private f esd;
        private e esm;

        public a() {
            this.esm = new e(RecommendTabFragment.this.getPageContext());
            this.esd = new f(RecommendTabFragment.this.getPageContext());
            this.esd.setFrom(2);
            this.asE.add(this.esm);
            this.asE.add(this.esd);
            this.esd.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bj bjVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bjVar, str);
                    if (bjVar != null) {
                        TiebaStatic.log(new an("c12900").cy("tid", bjVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
            if (tbPageContext != null && bjVar != null && bjVar.aCm() != null && bjVar.aCF() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bjVar.aCm().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bjVar.aCF());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bj bjVar2 : RecommendTabFragment.this.esj.bdn()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bjVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData S(bj bjVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCF());
            alaLiveInfoCoreData.userName = bjVar.aCm().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
