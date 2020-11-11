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
    private BdTypeListView gih;
    private PbListView gjo;
    private a gqB;
    private SpecialRecommendTabModel gqC;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gqk = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a gqD = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void l(List<q> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!y.isEmpty(list)) {
                RecommendTabFragment.this.gih.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.Wj();
            } else {
                RecommendTabFragment.this.Wi();
            }
            RecommendTabFragment.this.lc(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.Wk();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void t(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bPW();
            RecommendTabFragment.this.bPa();
        }
    };
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bPW();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.gqC.bPk();
            }
        }
    };
    private final f.c gqm = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.gqC.TL();
            } else {
                RecommendTabFragment.this.lc(false);
            }
        }
    };

    public static RecommendTabFragment ue(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gqC == null) {
            this.gqC = new SpecialRecommendTabModel(getPageContext());
            this.gqC.a(this.gqD);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gih = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gih.setFadingEdgeLength(0);
            this.gih.setOverScrollMode(2);
            this.gih.setScrollable(this);
            this.gih.setOnSrollToBottomListener(this.VR);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gqm);
            this.gih.setPullRefresh(this.mPullView);
            this.gjo = new PbListView(getContext());
            this.gjo.createView();
            this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gjo.setLineGone();
            this.gjo.setTextSize(R.dimen.tbfontsize33);
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gjo.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gqB = new a();
            this.gih.addAdapters(this.gqB.bky);
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
    public void bPa() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gqk) {
            this.gih.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gqk = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.gqC.TL();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wk() {
        if (this.gih != null && this.mRefreshView != null) {
            this.gih.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gqk = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wi() {
        this.gih.setNextPage(this.gjo);
        this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wj() {
        this.gih.setNextPage(this.gjo);
        this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.setText(getResources().getString(R.string.list_no_more));
        this.gjo.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPW() {
        this.gih.setNextPage(this.gjo);
        this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gjo.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lc(boolean z) {
        if (!z) {
            this.gih.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
        ap.setBackgroundColor(this.gih, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bPV() {
        super.bPV();
        if (this.gih != null) {
            this.gih.smoothScrollToPosition(0);
            this.gih.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gih != null) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gih.setOnSrollToBottomListener(null);
        this.gih.setScrollable(null);
        this.gqC.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes4.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
        private e gqF;
        private com.baidu.tieba.ala.alasquare.special_forum.a.f gqw;

        public a() {
            this.gqF = new e(RecommendTabFragment.this.getPageContext());
            this.gqw = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.gqw.setFrom(2);
            this.bky.add(this.gqF);
            this.bky.add(this.gqw);
            this.gqw.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
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
            if (tbPageContext != null && bwVar != null && bwVar.bmA() != null && bwVar.bmU() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bwVar.bmA().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bw bwVar2 : RecommendTabFragment.this.gqC.bPU()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData T(bw bwVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
            alaLiveInfoCoreData.userName = bwVar.bmA().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
