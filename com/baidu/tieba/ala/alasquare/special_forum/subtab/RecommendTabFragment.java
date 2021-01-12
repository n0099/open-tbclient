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
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.e;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    private a gEQ;
    private SpecialRecommendTabModel gER;
    private BdTypeListView gwr;
    private PbListView gxy;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gEz = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a gES = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void m(List<n> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!x.isEmpty(list)) {
                RecommendTabFragment.this.gwr.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.Vp();
            } else {
                RecommendTabFragment.this.Vo();
            }
            RecommendTabFragment.this.lQ(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.Vq();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void w(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bRO();
            RecommendTabFragment.this.bQQ();
        }
    };
    private BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bRO();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.gER.bRa();
            }
        }
    };
    private final f.c gEB = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.gER.SM();
            } else {
                RecommendTabFragment.this.lQ(false);
            }
        }
    };

    public static RecommendTabFragment tL(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gER == null) {
            this.gER = new SpecialRecommendTabModel(getPageContext());
            this.gER.a(this.gES);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gwr = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gwr.setFadingEdgeLength(0);
            this.gwr.setOverScrollMode(2);
            this.gwr.setScrollable(this);
            this.gwr.setOnSrollToBottomListener(this.WL);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gEB);
            this.gwr.setPullRefresh(this.mPullView);
            this.gxy = new PbListView(getContext());
            this.gxy.createView();
            this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gxy.setLineGone();
            this.gxy.setTextSize(R.dimen.tbfontsize33);
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gxy.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gEQ = new a();
            this.gwr.addAdapters(this.gEQ.bjZ);
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
    public void bQQ() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gEz) {
            this.gwr.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gEz = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.gER.SM();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        if (this.gwr != null && this.mRefreshView != null) {
            this.gwr.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gEz = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vo() {
        this.gwr.setNextPage(this.gxy);
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vp() {
        this.gwr.setNextPage(this.gxy);
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.setText(getResources().getString(R.string.list_no_more));
        this.gxy.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRO() {
        this.gwr.setNextPage(this.gxy);
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gxy.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lQ(boolean z) {
        if (!z) {
            this.gwr.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(i);
        }
        ao.setBackgroundColor(this.gwr, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bRN() {
        super.bRN();
        if (this.gwr != null) {
            this.gwr.smoothScrollToPosition(0);
            this.gwr.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gwr != null) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gwr.setOnSrollToBottomListener(null);
        this.gwr.setScrollable(null);
        this.gER.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes9.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.f gEL;
        private e gEU;

        public a() {
            this.gEU = new e(RecommendTabFragment.this.getPageContext());
            this.gEL = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.gEL.setFrom(2);
            this.bjZ.add(this.gEU);
            this.bjZ.add(this.gEL);
            this.gEL.b(new com.baidu.tieba.ala.alasquare.subtablist.view.g() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
                public void a(int i, String str, bz bzVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bzVar, str);
                    if (bzVar != null) {
                        TiebaStatic.log(new aq("c12900").dW("tid", bzVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bz bzVar, String str) {
            if (tbPageContext != null && bzVar != null && bzVar.bnx() != null && bzVar.bnQ() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bzVar.bnx().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bz bzVar2 : RecommendTabFragment.this.gER.bRM()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(bzVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData V(bz bzVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
            alaLiveInfoCoreData.userName = bzVar.bnx().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
