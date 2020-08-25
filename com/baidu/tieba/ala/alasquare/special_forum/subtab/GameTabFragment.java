package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.a;
import com.baidu.tieba.ala.alasquare.live_tab.c;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel;
import com.baidu.tieba.ala.alasquare.special_forum.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class GameTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView fCP;
    private PbListView fDW;
    private AlaLiveTabGameModel fEX;
    private String fGE;
    private d fKS;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fKJ = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a fKT = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(boolean z, List<q> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.kf(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (y.isEmpty(list)) {
                GameTabFragment.this.bFV();
                return;
            }
            GameTabFragment.this.fCP.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.bGS();
            } else {
                GameTabFragment.this.bGR();
            }
            GameTabFragment.this.bFW();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bGT();
            GameTabFragment.this.bFV();
        }
    };
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bGT();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.fEX.bFD();
            }
        }
    };
    private final f.c fKL = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.fEX.refresh();
            } else {
                GameTabFragment.this.kf(false);
            }
        }
    };

    public static GameTabFragment EC(String str) {
        GameTabFragment gameTabFragment = new GameTabFragment();
        if (!StringUtils.isNull(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("key_special_forum_game_tab_entryname", str);
            gameTabFragment.setArguments(bundle);
        }
        return gameTabFragment;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && !StringUtils.isNull(arguments.getString("key_special_forum_game_tab_entryname"))) {
            this.fGE = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.fEX == null) {
            this.fEX = new AlaLiveTabGameModel(getPageContext(), this.fKT);
        }
        this.fEX.init();
        if (this.fKS == null) {
            this.fKS = new d(getPageContext());
            this.fKS.setEntryName(this.fGE);
            this.fKS.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new aq("c12904").dD("entryname", GameTabFragment.this.fGE));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.fCP = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.fCP.setOnSrollToBottomListener(this.Vh);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fKL);
            this.fCP.setPullRefresh(this.mPullView);
            this.fDW = new PbListView(getContext());
            this.fDW.createView();
            this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fDW.setLineGone();
            this.fDW.setTextSize(R.dimen.tbfontsize33);
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fDW.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.fKS);
            this.fCP.addAdapters(arrayList);
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
    public void bFV() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fKJ) {
            this.fCP.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.fKJ = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bGQ() {
        super.bGQ();
        if (this.fCP != null) {
            this.fCP.smoothScrollToPosition(0);
            this.fCP.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.fCP != null) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.fEX.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFW() {
        if (this.fCP != null && this.mRefreshView != null) {
            this.fKJ = false;
            this.fCP.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGR() {
        this.fCP.setNextPage(this.fDW);
        this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGS() {
        this.fCP.setNextPage(this.fDW);
        this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.setText(getResources().getString(R.string.list_no_more));
        this.fDW.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGT() {
        this.fCP.setNextPage(this.fDW);
        this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fDW.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void kf(boolean z) {
        if (!z) {
            this.fCP.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ap.setBackgroundColor(this.fCP, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fCP.setOnSrollToBottomListener(null);
        this.fCP.setScrollable(null);
        this.fEX.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.fCu != null) {
            if (aVar.fCu.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.fCu.roomId, String.valueOf(aVar.fCu.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.fCu.roomId, 0L);
            if (aVar.fCu.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.fCu.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.fCu.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.fCu.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.fCu.title;
                alaLiveInfoCoreData.audienceCount = aVar.fCu.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
