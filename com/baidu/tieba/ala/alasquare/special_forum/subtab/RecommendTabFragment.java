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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
    private BdTypeListView ghN;
    private PbListView giV;
    private a gqi;
    private SpecialRecommendTabModel gqj;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gpR = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a gqk = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void l(List<q> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!y.isEmpty(list)) {
                RecommendTabFragment.this.ghN.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.VA();
            } else {
                RecommendTabFragment.this.Vz();
            }
            RecommendTabFragment.this.ld(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.VB();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void t(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bPp();
            RecommendTabFragment.this.bOt();
        }
    };
    private BdListView.e VT = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bPp();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.gqj.bOD();
            }
        }
    };
    private final f.c gpT = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.gqj.Tc();
            } else {
                RecommendTabFragment.this.ld(false);
            }
        }
    };

    public static RecommendTabFragment uC(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gqj == null) {
            this.gqj = new SpecialRecommendTabModel(getPageContext());
            this.gqj.a(this.gqk);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.ghN = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.ghN.setFadingEdgeLength(0);
            this.ghN.setOverScrollMode(2);
            this.ghN.setScrollable(this);
            this.ghN.setOnSrollToBottomListener(this.VT);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gpT);
            this.ghN.setPullRefresh(this.mPullView);
            this.giV = new PbListView(getContext());
            this.giV.createView();
            this.giV.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.giV.setLineGone();
            this.giV.setTextSize(R.dimen.tbfontsize33);
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
            this.giV.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gqi = new a();
            this.ghN.addAdapters(this.gqi.biN);
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
    public void bOt() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gpR) {
            this.ghN.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gpR = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.gqj.Tc();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        if (this.ghN != null && this.mRefreshView != null) {
            this.ghN.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gpR = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vz() {
        this.ghN.setNextPage(this.giV);
        this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VA() {
        this.ghN.setNextPage(this.giV);
        this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.setText(getResources().getString(R.string.list_no_more));
        this.giV.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPp() {
        this.ghN.setNextPage(this.giV);
        this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.giV.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void ld(boolean z) {
        if (!z) {
            this.ghN.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.changeSkin(i);
        }
        ap.setBackgroundColor(this.ghN, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bPo() {
        super.bPo();
        if (this.ghN != null) {
            this.ghN.smoothScrollToPosition(0);
            this.ghN.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.ghN != null) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ghN.setOnSrollToBottomListener(null);
        this.ghN.setScrollable(null);
        this.gqj.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes4.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.f gqd;
        private e gqm;

        public a() {
            this.gqm = new e(RecommendTabFragment.this.getPageContext());
            this.gqd = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.gqd.setFrom(2);
            this.biN.add(this.gqm);
            this.biN.add(this.gqd);
            this.gqd.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bx bxVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bxVar, str);
                    if (bxVar != null) {
                        TiebaStatic.log(new ar("c12900").dR("tid", bxVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bx bxVar, String str) {
            if (tbPageContext != null && bxVar != null && bxVar.blC() != null && bxVar.blW() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bxVar.blC().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bxVar.blW());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bx bxVar2 : RecommendTabFragment.this.gqj.bPn()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(bxVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData V(bx bxVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bxVar.blW());
            alaLiveInfoCoreData.userName = bxVar.blC().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
