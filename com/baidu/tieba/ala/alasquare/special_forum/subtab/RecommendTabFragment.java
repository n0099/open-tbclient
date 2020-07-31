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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
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
    private BdTypeListView frv;
    private PbListView fsC;
    private a fzI;
    private SpecialRecommendTabModel fzJ;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fzr = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a fzK = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void j(List<q> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!x.isEmpty(list)) {
                RecommendTabFragment.this.frv.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.bxT();
            } else {
                RecommendTabFragment.this.bxS();
            }
            RecommendTabFragment.this.jH(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bwX();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void aB(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bxU();
            RecommendTabFragment.this.bwW();
        }
    };
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bxU();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.fzJ.bxg();
            }
        }
    };
    private final f.c fzt = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.fzJ.IH();
            } else {
                RecommendTabFragment.this.jH(false);
            }
        }
    };

    public static RecommendTabFragment qz(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fzJ == null) {
            this.fzJ = new SpecialRecommendTabModel(getPageContext());
            this.fzJ.a(this.fzK);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.frv = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.frv.setFadingEdgeLength(0);
            this.frv.setOverScrollMode(2);
            this.frv.setScrollable(this);
            this.frv.setOnSrollToBottomListener(this.UC);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fzt);
            this.frv.setPullRefresh(this.mPullView);
            this.fsC = new PbListView(getContext());
            this.fsC.createView();
            this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fsC.setLineGone();
            this.fsC.setTextSize(R.dimen.tbfontsize33);
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fsC.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fzI = new a();
            this.frv.addAdapters(this.fzI.aWf);
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
    public void bwW() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fzr) {
            this.frv.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fzr = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.fzJ.IH();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        if (this.frv != null && this.mRefreshView != null) {
            this.frv.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.fzr = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxS() {
        this.frv.setNextPage(this.fsC);
        this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxT() {
        this.frv.setNextPage(this.fsC);
        this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.setText(getResources().getString(R.string.list_no_more));
        this.fsC.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxU() {
        this.frv.setNextPage(this.fsC);
        this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fsC.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void jH(boolean z) {
        if (!z) {
            this.frv.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
        ao.setBackgroundColor(this.frv, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bxR() {
        super.bxR();
        if (this.frv != null) {
            this.frv.smoothScrollToPosition(0);
            this.frv.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.frv != null) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.frv.setOnSrollToBottomListener(null);
        this.frv.setScrollable(null);
        this.fzJ.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes4.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.f fzD;
        private e fzM;

        public a() {
            this.fzM = new e(RecommendTabFragment.this.getPageContext());
            this.fzD = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.fzD.setFrom(2);
            this.aWf.add(this.fzM);
            this.aWf.add(this.fzD);
            this.fzD.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bv bvVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bvVar, str);
                    if (bvVar != null) {
                        TiebaStatic.log(new ap("c12900").dn("tid", bvVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bv bvVar, String str) {
            if (tbPageContext != null && bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bvVar.aWl().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bv bvVar2 : RecommendTabFragment.this.fzJ.bxQ()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bvVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData S(bv bvVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
            alaLiveInfoCoreData.userName = bvVar.aWl().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
