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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
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
    private BdTypeListView frv;
    private PbListView fsC;
    private AlaLiveTabGameModel ftE;
    private String fvl;
    private d fzA;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fzr = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a fzB = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.jH(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (x.isEmpty(list)) {
                GameTabFragment.this.bwW();
                return;
            }
            GameTabFragment.this.frv.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.bxT();
            } else {
                GameTabFragment.this.bxS();
            }
            GameTabFragment.this.bwX();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void g(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bxU();
            GameTabFragment.this.bwW();
        }
    };
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bxU();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.ftE.bwE();
            }
        }
    };
    private final f.c fzt = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.ftE.refresh();
            } else {
                GameTabFragment.this.jH(false);
            }
        }
    };

    public static GameTabFragment Ci(String str) {
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
            this.fvl = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.ftE == null) {
            this.ftE = new AlaLiveTabGameModel(getPageContext(), this.fzB);
        }
        this.ftE.init();
        if (this.fzA == null) {
            this.fzA = new d(getPageContext());
            this.fzA.setEntryName(this.fvl);
            this.fzA.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new ap("c12904").dn("entryname", GameTabFragment.this.fvl));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.frv = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.frv.setOnSrollToBottomListener(this.UC);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fzt);
            this.frv.setPullRefresh(this.mPullView);
            this.fsC = new PbListView(getContext());
            this.fsC.createView();
            this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fsC.setLineGone();
            this.fsC.setTextSize(R.dimen.tbfontsize33);
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fsC.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.fzA);
            this.frv.addAdapters(arrayList);
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
    public void bwW() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fzr) {
            this.frv.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.fzr = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bxR() {
        super.bxR();
        if (this.frv != null) {
            this.frv.smoothScrollToPosition(0);
            this.frv.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.frv != null) {
            this.frv.getAdapter().notifyDataSetChanged();
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
        this.ftE.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        if (this.frv != null && this.mRefreshView != null) {
            this.fzr = false;
            this.frv.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxS() {
        this.frv.setNextPage(this.fsC);
        this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxT() {
        this.frv.setNextPage(this.fsC);
        this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.setText(getResources().getString(R.string.list_no_more));
        this.fsC.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxU() {
        this.frv.setNextPage(this.fsC);
        this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fsC.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void jH(boolean z) {
        if (!z) {
            this.frv.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ao.setBackgroundColor(this.frv, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.frv.setOnSrollToBottomListener(null);
        this.frv.setScrollable(null);
        this.ftE.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.fqY != null) {
            if (aVar.fqY.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.fqY.roomId, String.valueOf(aVar.fqY.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.fqY.roomId, 0L);
            if (aVar.fqY.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.fqY.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.fqY.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.fqY.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.fqY.title;
                alaLiveInfoCoreData.audienceCount = aVar.fqY.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
