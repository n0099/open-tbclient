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
/* loaded from: classes2.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView efW;
    private PbListView ehe;
    private a enW;
    private SpecialRecommendTabModel enX;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean enF = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a enY = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void k(List<m> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!v.isEmpty(list)) {
                RecommendTabFragment.this.efW.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.bbb();
            } else {
                RecommendTabFragment.this.bba();
            }
            RecommendTabFragment.this.hn(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.baf();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void ac(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bbc();
            RecommendTabFragment.this.bae();
        }
    };
    private BdListView.e Ah = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bbc();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.enX.bao();
            }
        }
    };
    private final g.c enH = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.enX.yj();
            } else {
                RecommendTabFragment.this.hn(false);
            }
        }
    };

    public static RecommendTabFragment ow(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.enX == null) {
            this.enX = new SpecialRecommendTabModel(getPageContext());
            this.enX.a(this.enY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.efW = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.efW.setFadingEdgeLength(0);
            this.efW.setOverScrollMode(2);
            this.efW.setScrollable(this);
            this.efW.setOnSrollToBottomListener(this.Ah);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.enH);
            this.efW.setPullRefresh(this.mPullView);
            this.ehe = new PbListView(getContext());
            this.ehe.createView();
            this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.ehe.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.ehe.setLineGone();
            this.ehe.setTextSize(R.dimen.tbfontsize33);
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ehe.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.enW = new a();
            this.efW.addAdapters(this.enW.apl);
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
    public void bae() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.enF) {
            this.efW.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.enF = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.enX.yj();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baf() {
        if (this.efW != null && this.mRefreshView != null) {
            this.efW.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.enF = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bba() {
        this.efW.setNextPage(this.ehe);
        this.ehe.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbb() {
        this.efW.setNextPage(this.ehe);
        this.ehe.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.setText(getResources().getString(R.string.list_no_more));
        this.ehe.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbc() {
        this.efW.setNextPage(this.ehe);
        this.ehe.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ehe.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void hn(boolean z) {
        if (!z) {
            this.efW.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ehe != null) {
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ehe.changeSkin(i);
        }
        am.setBackgroundColor(this.efW, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void baZ() {
        super.baZ();
        if (this.efW != null) {
            this.efW.smoothScrollToPosition(0);
            this.efW.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.efW != null) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.efW.setOnSrollToBottomListener(null);
        this.efW.setScrollable(null);
        this.enX.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes2.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> apl = new LinkedList();
        private f enR;
        private e eoa;

        public a() {
            this.eoa = new e(RecommendTabFragment.this.getPageContext());
            this.enR = new f(RecommendTabFragment.this.getPageContext());
            this.enR.setFrom(2);
            this.apl.add(this.eoa);
            this.apl.add(this.enR);
            this.enR.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bj bjVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bjVar, str);
                    if (bjVar != null) {
                        TiebaStatic.log(new an("c12900").cp("tid", bjVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
            if (tbPageContext != null && bjVar != null && bjVar.azX() != null && bjVar.aAq() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bjVar.azX().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bj bjVar2 : RecommendTabFragment.this.enX.baY()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(R(bjVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData R(bj bjVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
            alaLiveInfoCoreData.userName = bjVar.azX().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
