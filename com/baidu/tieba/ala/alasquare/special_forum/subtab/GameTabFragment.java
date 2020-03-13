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
    private BdTypeListView eko;
    private PbListView elw;
    private AlaLiveTabGameModel emu;
    private String eod;
    private d eso;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean esf = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a esp = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void d(boolean z, List<m> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.hu(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (v.isEmpty(list)) {
                GameTabFragment.this.bcx();
                return;
            }
            GameTabFragment.this.eko.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.bdt();
            } else {
                GameTabFragment.this.bds();
            }
            GameTabFragment.this.bcy();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bdu();
            GameTabFragment.this.bcx();
        }
    };
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bdu();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.emu.bcg();
            }
        }
    };
    private final g.c esh = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.emu.refresh();
            } else {
                GameTabFragment.this.hu(false);
            }
        }
    };

    public static GameTabFragment xK(String str) {
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
            this.eod = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.emu == null) {
            this.emu = new AlaLiveTabGameModel(getPageContext(), this.esp);
        }
        this.emu.init();
        if (this.eso == null) {
            this.eso = new d(getPageContext());
            this.eso.setEntryName(this.eod);
            this.eso.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new an("c12904").cy("entryname", GameTabFragment.this.eod));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.eko = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.eko.setOnSrollToBottomListener(this.Az);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.esh);
            this.eko.setPullRefresh(this.mPullView);
            this.elw = new PbListView(getContext());
            this.elw.createView();
            this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.elw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.elw.setLineGone();
            this.elw.setTextSize(R.dimen.tbfontsize33);
            this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elw.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.eso);
            this.eko.addAdapters(arrayList);
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
    public void bcx() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.esf) {
            this.eko.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.esf = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bdr() {
        super.bdr();
        if (this.eko != null) {
            this.eko.smoothScrollToPosition(0);
            this.eko.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.eko != null) {
            this.eko.getAdapter().notifyDataSetChanged();
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
        this.emu.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (this.eko != null && this.mRefreshView != null) {
            this.esf = false;
            this.eko.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bds() {
        this.eko.setNextPage(this.elw);
        this.elw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdt() {
        this.eko.setNextPage(this.elw);
        this.elw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.setText(getResources().getString(R.string.list_no_more));
        this.elw.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdu() {
        this.eko.setNextPage(this.elw);
        this.elw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elw.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void hu(boolean z) {
        if (!z) {
            this.eko.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elw != null) {
            this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elw.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        am.setBackgroundColor(this.eko, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eko.setOnSrollToBottomListener(null);
        this.eko.setScrollable(null);
        this.emu.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.ejT != null) {
            if (aVar.ejT.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.ejT.roomId, String.valueOf(aVar.ejT.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.ejT.roomId, 0L);
            if (aVar.ejT.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.ejT.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.ejT.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.ejT.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.ejT.title;
                alaLiveInfoCoreData.audienceCount = aVar.ejT.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
