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
    private BdTypeListView ekE;
    private PbListView elM;
    private a esS;
    private SpecialRecommendTabModel esT;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean esB = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a esU = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void l(List<m> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!v.isEmpty(list)) {
                RecommendTabFragment.this.ekE.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.bdy();
            } else {
                RecommendTabFragment.this.bdx();
            }
            RecommendTabFragment.this.hv(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bcC();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void ad(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bdz();
            RecommendTabFragment.this.bcB();
        }
    };
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bdz();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.esT.bcK();
            }
        }
    };
    private final g.c esD = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.esT.AJ();
            } else {
                RecommendTabFragment.this.hv(false);
            }
        }
    };

    public static RecommendTabFragment oP(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.esT == null) {
            this.esT = new SpecialRecommendTabModel(getPageContext());
            this.esT.a(this.esU);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.ekE = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.ekE.setFadingEdgeLength(0);
            this.ekE.setOverScrollMode(2);
            this.ekE.setScrollable(this);
            this.ekE.setOnSrollToBottomListener(this.Az);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.esD);
            this.ekE.setPullRefresh(this.mPullView);
            this.elM = new PbListView(getContext());
            this.elM.createView();
            this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.elM.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.elM.setLineGone();
            this.elM.setTextSize(R.dimen.tbfontsize33);
            this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elM.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.esS = new a();
            this.ekE.addAdapters(this.esS.asP);
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
    public void bcB() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.esB) {
            this.ekE.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.esB = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.esT.AJ();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcC() {
        if (this.ekE != null && this.mRefreshView != null) {
            this.ekE.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.esB = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdx() {
        this.ekE.setNextPage(this.elM);
        this.elM.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdy() {
        this.ekE.setNextPage(this.elM);
        this.elM.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.setText(getResources().getString(R.string.list_no_more));
        this.elM.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdz() {
        this.ekE.setNextPage(this.elM);
        this.elM.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elM.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void hv(boolean z) {
        if (!z) {
            this.ekE.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elM != null) {
            this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elM.changeSkin(i);
        }
        am.setBackgroundColor(this.ekE, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bdw() {
        super.bdw();
        if (this.ekE != null) {
            this.ekE.smoothScrollToPosition(0);
            this.ekE.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.ekE != null) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ekE.setOnSrollToBottomListener(null);
        this.ekE.setScrollable(null);
        this.esT.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes3.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> asP = new LinkedList();
        private f esN;
        private e esW;

        public a() {
            this.esW = new e(RecommendTabFragment.this.getPageContext());
            this.esN = new f(RecommendTabFragment.this.getPageContext());
            this.esN.setFrom(2);
            this.asP.add(this.esW);
            this.asP.add(this.esN);
            this.esN.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bj bjVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bjVar, str);
                    if (bjVar != null) {
                        TiebaStatic.log(new an("c12900").cx("tid", bjVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
            if (tbPageContext != null && bjVar != null && bjVar.aCr() != null && bjVar.aCK() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bjVar.aCr().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bjVar.aCK());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bj bjVar2 : RecommendTabFragment.this.esT.bdv()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bjVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData T(bj bjVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCK());
            alaLiveInfoCoreData.userName = bjVar.aCr().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
