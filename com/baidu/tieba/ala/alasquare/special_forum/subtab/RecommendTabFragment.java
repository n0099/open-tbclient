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
    private BdTypeListView fbb;
    private PbListView fcj;
    private a fjo;
    private SpecialRecommendTabModel fjp;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fiX = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a fjq = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void l(List<o> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!v.isEmpty(list)) {
                RecommendTabFragment.this.fbb.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.brN();
            } else {
                RecommendTabFragment.this.brM();
            }
            RecommendTabFragment.this.iQ(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bqQ();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void ax(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.brO();
            RecommendTabFragment.this.bqP();
        }
    };
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.brO();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.fjp.bqZ();
            }
        }
    };
    private final f.c fiZ = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.fjp.Ho();
            } else {
                RecommendTabFragment.this.iQ(false);
            }
        }
    };

    public static RecommendTabFragment pL(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fjp == null) {
            this.fjp = new SpecialRecommendTabModel(getPageContext());
            this.fjp.a(this.fjq);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.fbb = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.fbb.setFadingEdgeLength(0);
            this.fbb.setOverScrollMode(2);
            this.fbb.setScrollable(this);
            this.fbb.setOnSrollToBottomListener(this.Uf);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fiZ);
            this.fbb.setPullRefresh(this.mPullView);
            this.fcj = new PbListView(getContext());
            this.fcj.createView();
            this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fcj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fcj.setLineGone();
            this.fcj.setTextSize(R.dimen.tbfontsize33);
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fcj.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.fjo = new a();
            this.fbb.addAdapters(this.fjo.aSj);
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
    public void bqP() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fiX) {
            this.fbb.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.fiX = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.fjp.Ho();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqQ() {
        if (this.fbb != null && this.mRefreshView != null) {
            this.fbb.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.fiX = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brM() {
        this.fbb.setNextPage(this.fcj);
        this.fcj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brN() {
        this.fbb.setNextPage(this.fcj);
        this.fcj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.setText(getResources().getString(R.string.list_no_more));
        this.fcj.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brO() {
        this.fbb.setNextPage(this.fcj);
        this.fcj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fcj.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void iQ(boolean z) {
        if (!z) {
            this.fbb.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.changeSkin(i);
        }
        am.setBackgroundColor(this.fbb, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void brL() {
        super.brL();
        if (this.fbb != null) {
            this.fbb.smoothScrollToPosition(0);
            this.fbb.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.fbb != null) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fbb.setOnSrollToBottomListener(null);
        this.fbb.setScrollable(null);
        this.fjp.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes3.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.f fjj;
        private e fjs;

        public a() {
            this.fjs = new e(RecommendTabFragment.this.getPageContext());
            this.fjj = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.fjj.setFrom(2);
            this.aSj.add(this.fjs);
            this.aSj.add(this.fjj);
            this.fjj.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
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
                for (bk bkVar2 : RecommendTabFragment.this.fjp.brK()) {
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
