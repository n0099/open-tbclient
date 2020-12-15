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
import com.baidu.tbadk.core.data.by;
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
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView gpZ;
    private PbListView grg;
    private a gyt;
    private SpecialRecommendTabModel gyu;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gyc = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a gyv = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void m(List<q> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!y.isEmpty(list)) {
                RecommendTabFragment.this.gpZ.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.Ya();
            } else {
                RecommendTabFragment.this.XZ();
            }
            RecommendTabFragment.this.lx(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.Yb();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void t(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bTb();
            RecommendTabFragment.this.bSf();
        }
    };
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bTb();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.gyu.bSp();
            }
        }
    };
    private final f.c gye = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.gyu.VC();
            } else {
                RecommendTabFragment.this.lx(false);
            }
        }
    };

    public static RecommendTabFragment vg(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gyu == null) {
            this.gyu = new SpecialRecommendTabModel(getPageContext());
            this.gyu.a(this.gyv);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gpZ = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gpZ.setFadingEdgeLength(0);
            this.gpZ.setOverScrollMode(2);
            this.gpZ.setScrollable(this);
            this.gpZ.setOnSrollToBottomListener(this.WQ);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gye);
            this.gpZ.setPullRefresh(this.mPullView);
            this.grg = new PbListView(getContext());
            this.grg.createView();
            this.grg.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.grg.setLineGone();
            this.grg.setTextSize(R.dimen.tbfontsize33);
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
            this.grg.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gyt = new a();
            this.gpZ.addAdapters(this.gyt.bnf);
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
    public void bSf() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gyc) {
            this.gpZ.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gyc = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.gyu.VC();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yb() {
        if (this.gpZ != null && this.mRefreshView != null) {
            this.gpZ.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gyc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XZ() {
        this.gpZ.setNextPage(this.grg);
        this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        this.gpZ.setNextPage(this.grg);
        this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.setText(getResources().getString(R.string.list_no_more));
        this.grg.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTb() {
        this.gpZ.setNextPage(this.grg);
        this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.grg.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lx(boolean z) {
        if (!z) {
            this.gpZ.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(i);
        }
        ap.setBackgroundColor(this.gpZ, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bTa() {
        super.bTa();
        if (this.gpZ != null) {
            this.gpZ.smoothScrollToPosition(0);
            this.gpZ.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gpZ != null) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gpZ.setOnSrollToBottomListener(null);
        this.gpZ.setScrollable(null);
        this.gyu.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes6.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
        private com.baidu.tieba.ala.alasquare.special_forum.a.f gyo;
        private e gyx;

        public a() {
            this.gyx = new e(RecommendTabFragment.this.getPageContext());
            this.gyo = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.gyo.setFrom(2);
            this.bnf.add(this.gyx);
            this.bnf.add(this.gyo);
            this.gyo.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, by byVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), byVar, str);
                    if (byVar != null) {
                        TiebaStatic.log(new ar("c12900").dY("tid", byVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, by byVar, String str) {
            if (tbPageContext != null && byVar != null && byVar.boP() != null && byVar.bpj() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = byVar.boP().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (by byVar2 : RecommendTabFragment.this.gyu.bSZ()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(byVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData V(by byVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
            alaLiveInfoCoreData.userName = byVar.boP().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
