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
    private BdTypeListView fCT;
    private PbListView fEa;
    private a fLe;
    private SpecialRecommendTabModel fLf;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fKN = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a fLg = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void j(List<q> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!y.isEmpty(list)) {
                RecommendTabFragment.this.fCT.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.bGT();
            } else {
                RecommendTabFragment.this.bGS();
            }
            RecommendTabFragment.this.kh(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bFX();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void ay(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bGU();
            RecommendTabFragment.this.bFW();
        }
    };
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bGU();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.fLf.bGg();
            }
        }
    };
    private final f.c fKP = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.fLf.OA();
            } else {
                RecommendTabFragment.this.kh(false);
            }
        }
    };

    public static RecommendTabFragment sL(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fLf == null) {
            this.fLf = new SpecialRecommendTabModel(getPageContext());
            this.fLf.a(this.fLg);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.fCT = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.fCT.setFadingEdgeLength(0);
            this.fCT.setOverScrollMode(2);
            this.fCT.setScrollable(this);
            this.fCT.setOnSrollToBottomListener(this.Vh);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fKP);
            this.fCT.setPullRefresh(this.mPullView);
            this.fEa = new PbListView(getContext());
            this.fEa.createView();
            this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fEa.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fEa.setLineGone();
            this.fEa.setTextSize(R.dimen.tbfontsize33);
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fEa.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fLe = new a();
            this.fCT.addAdapters(this.fLe.bbw);
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
    public void bFW() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fKN) {
            this.fCT.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fKN = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.fLf.OA();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFX() {
        if (this.fCT != null && this.mRefreshView != null) {
            this.fCT.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.fKN = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGS() {
        this.fCT.setNextPage(this.fEa);
        this.fEa.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGT() {
        this.fCT.setNextPage(this.fEa);
        this.fEa.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.setText(getResources().getString(R.string.list_no_more));
        this.fEa.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGU() {
        this.fCT.setNextPage(this.fEa);
        this.fEa.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fEa.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void kh(boolean z) {
        if (!z) {
            this.fCT.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.changeSkin(i);
        }
        ap.setBackgroundColor(this.fCT, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bGR() {
        super.bGR();
        if (this.fCT != null) {
            this.fCT.smoothScrollToPosition(0);
            this.fCT.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.fCT != null) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fCT.setOnSrollToBottomListener(null);
        this.fCT.setScrollable(null);
        this.fLf.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes4.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.f fKZ;
        private e fLi;

        public a() {
            this.fLi = new e(RecommendTabFragment.this.getPageContext());
            this.fKZ = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.fKZ.setFrom(2);
            this.bbw.add(this.fLi);
            this.bbw.add(this.fKZ);
            this.fKZ.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
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
                for (bw bwVar2 : RecommendTabFragment.this.fLf.bGQ()) {
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
