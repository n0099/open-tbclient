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
    private BdTypeListView eko;
    private PbListView elw;
    private a esw;
    private SpecialRecommendTabModel esx;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean esf = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a esy = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void l(List<m> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!v.isEmpty(list)) {
                RecommendTabFragment.this.eko.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.bdt();
            } else {
                RecommendTabFragment.this.bds();
            }
            RecommendTabFragment.this.hu(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bcy();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void ad(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bdu();
            RecommendTabFragment.this.bcx();
        }
    };
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bdu();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.esx.bcG();
            }
        }
    };
    private final g.c esh = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.esx.AC();
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
        if (this.esx == null) {
            this.esx = new SpecialRecommendTabModel(getPageContext());
            this.esx.a(this.esy);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.eko = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.eko.setFadingEdgeLength(0);
            this.eko.setOverScrollMode(2);
            this.eko.setScrollable(this);
            this.eko.setOnSrollToBottomListener(this.Az);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.esh);
            this.eko.setPullRefresh(this.mPullView);
            this.elw = new PbListView(getContext());
            this.elw.createView();
            this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.elw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.elw.setLineGone();
            this.elw.setTextSize(R.dimen.tbfontsize33);
            this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elw.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.esw = new a();
            this.eko.addAdapters(this.esw.asF);
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
    public void bcx() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.esf) {
            this.eko.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.esf = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.esx.AC();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (this.eko != null && this.mRefreshView != null) {
            this.eko.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.esf = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bds() {
        this.eko.setNextPage(this.elw);
        this.elw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdt() {
        this.eko.setNextPage(this.elw);
        this.elw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.setText(getResources().getString(R.string.list_no_more));
        this.elw.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdu() {
        this.eko.setNextPage(this.elw);
        this.elw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elw.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void hu(boolean z) {
        if (!z) {
            this.eko.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elw != null) {
            this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elw.changeSkin(i);
        }
        am.setBackgroundColor(this.eko, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bdr() {
        super.bdr();
        if (this.eko != null) {
            this.eko.smoothScrollToPosition(0);
            this.eko.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.eko != null) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eko.setOnSrollToBottomListener(null);
        this.eko.setScrollable(null);
        this.esx.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes3.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> asF = new LinkedList();
        private e esA;
        private f esr;

        public a() {
            this.esA = new e(RecommendTabFragment.this.getPageContext());
            this.esr = new f(RecommendTabFragment.this.getPageContext());
            this.esr.setFrom(2);
            this.asF.add(this.esA);
            this.asF.add(this.esr);
            this.esr.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
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
            if (tbPageContext != null && bjVar != null && bjVar.aCo() != null && bjVar.aCH() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bjVar.aCo().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bj bjVar2 : RecommendTabFragment.this.esx.bdq()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bjVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData S(bj bjVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
            alaLiveInfoCoreData.userName = bjVar.aCo().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
