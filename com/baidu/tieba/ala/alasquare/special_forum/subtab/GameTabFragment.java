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
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.a;
import com.baidu.tieba.ala.alasquare.live_tab.c;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel;
import com.baidu.tieba.ala.alasquare.special_forum.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class GameTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView eOe;
    private PbListView ePm;
    private AlaLiveTabGameModel eQl;
    private String eRS;
    private d eWg;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean eVX = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a eWh = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void d(boolean z, List<m> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.it(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (v.isEmpty(list)) {
                GameTabFragment.this.bls();
                return;
            }
            GameTabFragment.this.eOe.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.bmp();
            } else {
                GameTabFragment.this.bmo();
            }
            GameTabFragment.this.blt();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bmq();
            GameTabFragment.this.bls();
        }
    };
    private BdListView.e TQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bmq();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.eQl.blb();
            }
        }
    };
    private final g.c eVZ = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.eQl.refresh();
            } else {
                GameTabFragment.this.it(false);
            }
        }
    };

    public static GameTabFragment zp(String str) {
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
            this.eRS = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.eQl == null) {
            this.eQl = new AlaLiveTabGameModel(getPageContext(), this.eWh);
        }
        this.eQl.init();
        if (this.eWg == null) {
            this.eWg = new d(getPageContext());
            this.eWg.setEntryName(this.eRS);
            this.eWg.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new an("c12904").cI("entryname", GameTabFragment.this.eRS));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.eOe = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.eOe.setOnSrollToBottomListener(this.TQ);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.eVZ);
            this.eOe.setPullRefresh(this.mPullView);
            this.ePm = new PbListView(getContext());
            this.ePm.createView();
            this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.ePm.setLineGone();
            this.ePm.setTextSize(R.dimen.tbfontsize33);
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ePm.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.eWg);
            this.eOe.addAdapters(arrayList);
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
    public void bls() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.eVX) {
            this.eOe.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.eVX = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bmn() {
        super.bmn();
        if (this.eOe != null) {
            this.eOe.smoothScrollToPosition(0);
            this.eOe.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.eOe != null) {
            this.eOe.getAdapter().notifyDataSetChanged();
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
        this.eQl.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blt() {
        if (this.eOe != null && this.mRefreshView != null) {
            this.eVX = false;
            this.eOe.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmo() {
        this.eOe.setNextPage(this.ePm);
        this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmp() {
        this.eOe.setNextPage(this.ePm);
        this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.setText(getResources().getString(R.string.list_no_more));
        this.ePm.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmq() {
        this.eOe.setNextPage(this.ePm);
        this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePm.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void it(boolean z) {
        if (!z) {
            this.eOe.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        am.setBackgroundColor(this.eOe, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eOe.setOnSrollToBottomListener(null);
        this.eOe.setScrollable(null);
        this.eQl.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.eNJ != null) {
            if (aVar.eNJ.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.eNJ.roomId, String.valueOf(aVar.eNJ.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.eNJ.roomId, 0L);
            if (aVar.eNJ.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.eNJ.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.eNJ.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.eNJ.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.eNJ.title;
                alaLiveInfoCoreData.audienceCount = aVar.eNJ.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
