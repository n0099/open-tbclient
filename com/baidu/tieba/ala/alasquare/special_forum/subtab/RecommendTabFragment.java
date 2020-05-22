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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes3.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView faQ;
    private PbListView fbY;
    private a fjd;
    private SpecialRecommendTabModel fje;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fiM = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a fjf = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void l(List<o> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!v.isEmpty(list)) {
                RecommendTabFragment.this.faQ.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.brL();
            } else {
                RecommendTabFragment.this.brK();
            }
            RecommendTabFragment.this.iQ(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bqO();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void ax(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.brM();
            RecommendTabFragment.this.bqN();
        }
    };
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.brM();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.fje.bqX();
            }
        }
    };
    private final f.c fiO = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.fje.Ho();
            } else {
                RecommendTabFragment.this.iQ(false);
            }
        }
    };

    public static RecommendTabFragment pJ(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fje == null) {
            this.fje = new SpecialRecommendTabModel(getPageContext());
            this.fje.a(this.fjf);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.faQ = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.faQ.setFadingEdgeLength(0);
            this.faQ.setOverScrollMode(2);
            this.faQ.setScrollable(this);
            this.faQ.setOnSrollToBottomListener(this.Uf);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fiO);
            this.faQ.setPullRefresh(this.mPullView);
            this.fbY = new PbListView(getContext());
            this.fbY.createView();
            this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fbY.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fbY.setLineGone();
            this.fbY.setTextSize(R.dimen.tbfontsize33);
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fbY.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fjd = new a();
            this.faQ.addAdapters(this.fjd.aSj);
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
    public void bqN() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fiM) {
            this.faQ.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fiM = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.fje.Ho();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqO() {
        if (this.faQ != null && this.mRefreshView != null) {
            this.faQ.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.fiM = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brK() {
        this.faQ.setNextPage(this.fbY);
        this.fbY.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fbY.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brL() {
        this.faQ.setNextPage(this.fbY);
        this.fbY.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fbY.setText(getResources().getString(R.string.list_no_more));
        this.fbY.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brM() {
        this.faQ.setNextPage(this.fbY);
        this.fbY.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fbY.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void iQ(boolean z) {
        if (!z) {
            this.faQ.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fbY != null) {
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fbY.changeSkin(i);
        }
        am.setBackgroundColor(this.faQ, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void brJ() {
        super.brJ();
        if (this.faQ != null) {
            this.faQ.smoothScrollToPosition(0);
            this.faQ.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.faQ != null) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.faQ.setOnSrollToBottomListener(null);
        this.faQ.setScrollable(null);
        this.fje.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes3.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.f fiY;
        private e fjh;

        public a() {
            this.fjh = new e(RecommendTabFragment.this.getPageContext());
            this.fiY = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.fiY.setFrom(2);
            this.aSj.add(this.fjh);
            this.aSj.add(this.fiY);
            this.fiY.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bk bkVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bkVar, str);
                    if (bkVar != null) {
                        TiebaStatic.log(new an("c12900").dh("tid", bkVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bk bkVar, String str) {
            if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bkVar.aQx().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bk bkVar2 : RecommendTabFragment.this.fje.brI()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(U(bkVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData U(bk bkVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
            alaLiveInfoCoreData.userName = bkVar.aQx().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
