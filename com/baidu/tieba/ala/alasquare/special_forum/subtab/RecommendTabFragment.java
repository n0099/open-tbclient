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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.e;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView fCP;
    private PbListView fDW;
    private a fLa;
    private SpecialRecommendTabModel fLb;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fKJ = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a fLc = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void j(List<q> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!y.isEmpty(list)) {
                RecommendTabFragment.this.fCP.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.bGS();
            } else {
                RecommendTabFragment.this.bGR();
            }
            RecommendTabFragment.this.kf(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bFW();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void az(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bGT();
            RecommendTabFragment.this.bFV();
        }
    };
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bGT();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.fLb.bGf();
            }
        }
    };
    private final f.c fKL = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.fLb.OA();
            } else {
                RecommendTabFragment.this.kf(false);
            }
        }
    };

    public static RecommendTabFragment sL(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fLb == null) {
            this.fLb = new SpecialRecommendTabModel(getPageContext());
            this.fLb.a(this.fLc);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.fCP = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.fCP.setFadingEdgeLength(0);
            this.fCP.setOverScrollMode(2);
            this.fCP.setScrollable(this);
            this.fCP.setOnSrollToBottomListener(this.Vh);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fKL);
            this.fCP.setPullRefresh(this.mPullView);
            this.fDW = new PbListView(getContext());
            this.fDW.createView();
            this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fDW.setLineGone();
            this.fDW.setTextSize(R.dimen.tbfontsize33);
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fDW.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fLa = new a();
            this.fCP.addAdapters(this.fLa.bbu);
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
    public void bFV() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fKJ) {
            this.fCP.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fKJ = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.fLb.OA();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFW() {
        if (this.fCP != null && this.mRefreshView != null) {
            this.fCP.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.fKJ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGR() {
        this.fCP.setNextPage(this.fDW);
        this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGS() {
        this.fCP.setNextPage(this.fDW);
        this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.setText(getResources().getString(R.string.list_no_more));
        this.fDW.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGT() {
        this.fCP.setNextPage(this.fDW);
        this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fDW.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void kf(boolean z) {
        if (!z) {
            this.fCP.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(i);
        }
        ap.setBackgroundColor(this.fCP, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bGQ() {
        super.bGQ();
        if (this.fCP != null) {
            this.fCP.smoothScrollToPosition(0);
            this.fCP.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.fCP != null) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fCP.setOnSrollToBottomListener(null);
        this.fCP.setScrollable(null);
        this.fLb.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes4.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.f fKV;
        private e fLe;

        public a() {
            this.fLe = new e(RecommendTabFragment.this.getPageContext());
            this.fKV = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.fKV.setFrom(2);
            this.bbu.add(this.fLe);
            this.bbu.add(this.fKV);
            this.fKV.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bw bwVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bwVar, str);
                    if (bwVar != null) {
                        TiebaStatic.log(new aq("c12900").dD("tid", bwVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
            if (tbPageContext != null && bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bwVar.beE().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bw bwVar2 : RecommendTabFragment.this.fLb.bGP()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bwVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData S(bw bwVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
            alaLiveInfoCoreData.userName = bwVar.beE().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
