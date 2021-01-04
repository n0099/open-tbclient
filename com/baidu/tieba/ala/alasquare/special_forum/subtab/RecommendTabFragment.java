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
/* loaded from: classes10.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView gAY;
    private PbListView gCf;
    private a gJw;
    private SpecialRecommendTabModel gJx;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gJf = false;
    private boolean mIsInit = false;
    private SpecialRecommendTabModel.a gJy = new SpecialRecommendTabModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.1
        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void m(List<n> list, boolean z) {
            RecommendTabFragment.this.mHasMore = z;
            RecommendTabFragment.this.mIsInit = true;
            if (!x.isEmpty(list)) {
                RecommendTabFragment.this.gAY.setData(list);
            }
            if (!RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.Zh();
            } else {
                RecommendTabFragment.this.Zg();
            }
            RecommendTabFragment.this.lU(false);
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.Zi();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.a
        public void v(int i, String str) {
            RecommendTabFragment.this.hideLoadingView(RecommendTabFragment.this.mRootView);
            RecommendTabFragment.this.bVF();
            RecommendTabFragment.this.bUH();
        }
    };
    private BdListView.e WN = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                RecommendTabFragment.this.bVF();
            } else if (RecommendTabFragment.this.mHasMore) {
                RecommendTabFragment.this.gJx.bUR();
            }
        }
    };
    private final f.c gJh = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                RecommendTabFragment.this.gJx.WE();
            } else {
                RecommendTabFragment.this.lU(false);
            }
        }
    };

    public static RecommendTabFragment vr(int i) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.gJx == null) {
            this.gJx = new SpecialRecommendTabModel(getPageContext());
            this.gJx.a(this.gJy);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gAY = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gAY.setFadingEdgeLength(0);
            this.gAY.setOverScrollMode(2);
            this.gAY.setScrollable(this);
            this.gAY.setOnSrollToBottomListener(this.WN);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gJh);
            this.gAY.setPullRefresh(this.mPullView);
            this.gCf = new PbListView(getContext());
            this.gCf.createView();
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gCf.setLineGone();
            this.gCf.setTextSize(R.dimen.tbfontsize33);
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gCf.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.gJw = new a();
            this.gAY.addAdapters(this.gJw.boM);
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
    public void bUH() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gJf) {
            this.gAY.addHeaderView(this.mRefreshView.getAttachedView(), 0);
        }
        this.gJf = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.gJx.WE();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi() {
        if (this.gAY != null && this.mRefreshView != null) {
            this.gAY.removeHeaderView(this.mRefreshView.getAttachedView());
        }
        this.gJf = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zg() {
        this.gAY.setNextPage(this.gCf);
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh() {
        this.gAY.setNextPage(this.gCf);
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setText(getResources().getString(R.string.list_no_more));
        this.gCf.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVF() {
        this.gAY.setNextPage(this.gCf);
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gCf.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lU(boolean z) {
        if (!z) {
            this.gAY.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        ao.setBackgroundColor(this.gAY, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bVE() {
        super.bVE();
        if (this.gAY != null) {
            this.gAY.smoothScrollToPosition(0);
            this.gAY.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gAY != null) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gAY.setOnSrollToBottomListener(null);
        this.gAY.setScrollable(null);
        this.gJx.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* loaded from: classes10.dex */
    class a {
        private List<com.baidu.adp.widget.ListView.a> boM = new LinkedList();
        private e gJA;
        private com.baidu.tieba.ala.alasquare.special_forum.a.f gJr;

        public a() {
            this.gJA = new e(RecommendTabFragment.this.getPageContext());
            this.gJr = new com.baidu.tieba.ala.alasquare.special_forum.a.f(RecommendTabFragment.this.getPageContext());
            this.gJr.setFrom(2);
            this.boM.add(this.gJA);
            this.boM.add(this.gJr);
            this.gJr.b(new com.baidu.tieba.ala.alasquare.subtablist.view.g() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.RecommendTabFragment.a.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
                public void a(int i, String str, bz bzVar) {
                    a.this.a(RecommendTabFragment.this.getPageContext(), bzVar, str);
                    if (bzVar != null) {
                        TiebaStatic.log(new aq("c12900").dX("tid", bzVar.getTid()));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
                public void a(c cVar) {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(TbPageContext<?> tbPageContext, bz bzVar, String str) {
            if (tbPageContext != null && bzVar != null && bzVar.brq() != null && bzVar.brJ() != null) {
                boolean z = false;
                String str2 = "";
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = bzVar.brq().getUserId();
                    str2 = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, str2);
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(bzVar.brJ());
                AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
                alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
                for (bz bzVar2 : RecommendTabFragment.this.gJx.bVD()) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(bzVar2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_recommend_tab", str2, z, "颜值".equals(str) ? str : null, null)));
            }
        }

        private AlaLiveInfoCoreData V(bz bzVar) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.brJ());
            alaLiveInfoCoreData.userName = bzVar.brq().getUserName();
            return alaLiveInfoCoreData;
        }
    }
}
