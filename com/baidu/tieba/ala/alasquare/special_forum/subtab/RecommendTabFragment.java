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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes10.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    private PbListView gAi;
    private a gHA;
    private SpecialRecommendTabModel gHB;
    private BdTypeListView gzb;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gHj = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a gHC = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void m(List<n> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!y.isEmpty(list)) {
                RecommendTabFragment.this.gzb.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.WY();
            } else {
                RecommendTabFragment.this.WX();
            }
            RecommendTabFragment.this.lU(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.WZ();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void A(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bSr();
            RecommendTabFragment.this.bRu();
        }
    };
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bSr();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.gHB.bRE();
            }
        }
    };
    private final f.c gHl = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.gHB.Ut();
            } else {
                RecommendTabFragment.this.lU(false);
            }
        }
    };

    public static RecommendTabFragment tR(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gHB == null) {
            this.gHB = new SpecialRecommendTabModel(getPageContext());
            this.gHB.a(this.gHC);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gzb = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gzb.setFadingEdgeLength(0);
            this.gzb.setOverScrollMode(2);
            this.gzb.setScrollable(this);
            this.gzb.setOnSrollToBottomListener(this.WH);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gHl);
            this.gzb.setPullRefresh(this.mPullView);
            this.gAi = new PbListView(getContext());
            this.gAi.createView();
            this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gAi.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gAi.setLineGone();
            this.gAi.setTextSize(R.dimen.tbfontsize33);
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gAi.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gHA = new a();
            this.gzb.addAdapters(this.gHA.bns);
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
    public void bRu() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gHj) {
            this.gzb.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gHj = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.gHB.Ut();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        if (this.gzb != null && this.mRefreshView != null) {
            this.gzb.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gHj = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WX() {
        this.gzb.setNextPage(this.gAi);
        this.gAi.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WY() {
        this.gzb.setNextPage(this.gAi);
        this.gAi.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.setText(getResources().getString(R.string.list_no_more));
        this.gAi.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSr() {
        this.gzb.setNextPage(this.gAi);
        this.gAi.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAi.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lU(boolean z) {
        if (!z) {
            this.gzb.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.changeSkin(i);
        }
        ap.setBackgroundColor(this.gzb, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bSq() {
        super.bSq();
        if (this.gzb != null) {
            this.gzb.smoothScrollToPosition(0);
            this.gzb.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gzb != null) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gzb.setOnSrollToBottomListener(null);
        this.gzb.setScrollable(null);
        this.gHB.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes10.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
        private e gHE;
        private com.baidu.tieba.ala.alasquare.special_forum.a.f gHv;

        public a() {
            this.gHE = new e(RecommendTabFragment.this.getPageContext());
            this.gHv = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.gHv.setFrom(2);
            this.bns.add(this.gHE);
            this.bns.add(this.gHv);
            this.gHv.b(new com.baidu.tieba.ala.alasquare.subtablist.view.g() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
                public void a(int i, String str, cb cbVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), cbVar, str);
                    if (cbVar != null) {
                        TiebaStatic.log(new ar("c12900").dR("tid", cbVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, cb cbVar, String str) {
            if (tbPageContext != null && cbVar != null && cbVar.bnQ() != null && cbVar.boj() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = cbVar.bnQ().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (cb cbVar2 : RecommendTabFragment.this.gHB.bSp()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(W(cbVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData W(cb cbVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
            alaLiveInfoCoreData.userName = cbVar.bnQ().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
