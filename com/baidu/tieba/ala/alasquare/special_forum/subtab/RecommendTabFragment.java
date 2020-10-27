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
    private BdTypeListView gcr;
    private PbListView gdy;
    private a gkO;
    private SpecialRecommendTabModel gkP;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gkx = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a gkQ = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void l(List<q> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!y.isEmpty(list)) {
                RecommendTabFragment.this.gcr.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.TJ();
            } else {
                RecommendTabFragment.this.TI();
            }
            RecommendTabFragment.this.kT(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.TK();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void t(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bNw();
            RecommendTabFragment.this.bMA();
        }
    };
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bNw();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.gkP.bMK();
            }
        }
    };
    private final f.c gkz = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.gkP.Rd();
            } else {
                RecommendTabFragment.this.kT(false);
            }
        }
    };

    public static RecommendTabFragment tU(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gkP == null) {
            this.gkP = new SpecialRecommendTabModel(getPageContext());
            this.gkP.a(this.gkQ);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gcr = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gcr.setFadingEdgeLength(0);
            this.gcr.setOverScrollMode(2);
            this.gcr.setScrollable(this);
            this.gcr.setOnSrollToBottomListener(this.VR);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gkz);
            this.gcr.setPullRefresh(this.mPullView);
            this.gdy = new PbListView(getContext());
            this.gdy.createView();
            this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gdy.setLineGone();
            this.gdy.setTextSize(R.dimen.tbfontsize33);
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gdy.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gkO = new a();
            this.gcr.addAdapters(this.gkO.bje);
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
    public void bMA() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gkx) {
            this.gcr.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gkx = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.gkP.Rd();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TK() {
        if (this.gcr != null && this.mRefreshView != null) {
            this.gcr.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gkx = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TI() {
        this.gcr.setNextPage(this.gdy);
        this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TJ() {
        this.gcr.setNextPage(this.gdy);
        this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.setText(getResources().getString(R.string.list_no_more));
        this.gdy.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNw() {
        this.gcr.setNextPage(this.gdy);
        this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gdy.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void kT(boolean z) {
        if (!z) {
            this.gcr.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.changeSkin(i);
        }
        ap.setBackgroundColor(this.gcr, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bNv() {
        super.bNv();
        if (this.gcr != null) {
            this.gcr.smoothScrollToPosition(0);
            this.gcr.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gcr != null) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gcr.setOnSrollToBottomListener(null);
        this.gcr.setScrollable(null);
        this.gkP.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes4.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.f gkJ;
        private e gkS;

        public a() {
            this.gkS = new e(RecommendTabFragment.this.getPageContext());
            this.gkJ = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.gkJ.setFrom(2);
            this.bje.add(this.gkS);
            this.bje.add(this.gkJ);
            this.gkJ.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bw bwVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bwVar, str);
                    if (bwVar != null) {
                        TiebaStatic.log(new aq("c12900").dR("tid", bwVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
            if (tbPageContext != null && bwVar != null && bwVar.bka() != null && bwVar.bku() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bwVar.bka().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bwVar.bku());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bw bwVar2 : RecommendTabFragment.this.gkP.bNu()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData T(bw bwVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bku());
            alaLiveInfoCoreData.userName = bwVar.bka().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
