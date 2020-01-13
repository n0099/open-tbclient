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
/* loaded from: classes2.dex */
public class GameTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView efW;
    private AlaLiveTabGameModel ehZ;
    private PbListView ehe;
    private String ejF;
    private d enO;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean enF = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a enP = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void d(boolean z, List<m> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.hn(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (v.isEmpty(list)) {
                GameTabFragment.this.bae();
                return;
            }
            GameTabFragment.this.efW.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.bbb();
            } else {
                GameTabFragment.this.bba();
            }
            GameTabFragment.this.baf();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bbc();
            GameTabFragment.this.bae();
        }
    };
    private BdListView.e Ah = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bbc();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.ehZ.aZN();
            }
        }
    };
    private final g.c enH = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.ehZ.refresh();
            } else {
                GameTabFragment.this.hn(false);
            }
        }
    };

    public static GameTabFragment xp(String str) {
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
            this.ejF = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.ehZ == null) {
            this.ehZ = new AlaLiveTabGameModel(getPageContext(), this.enP);
        }
        this.ehZ.init();
        if (this.enO == null) {
            this.enO = new d(getPageContext());
            this.enO.setEntryName(this.ejF);
            this.enO.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new an("c12904").cp("entryname", GameTabFragment.this.ejF));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.efW = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
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
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.enO);
            this.efW.addAdapters(arrayList);
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
            this.enF = true;
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.ehZ.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baf() {
        if (this.efW != null && this.mRefreshView != null) {
            this.enF = false;
            this.efW.removeHeaderView(this.mRefreshView.getAttachedView());
        }
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
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        am.setBackgroundColor(this.efW, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.efW.setOnSrollToBottomListener(null);
        this.efW.setScrollable(null);
        this.ehZ.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.efB != null) {
            if (aVar.efB.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.efB.roomId, String.valueOf(aVar.efB.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.efB.roomId, 0L);
            if (aVar.efB.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.efB.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.efB.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.efB.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.efB.title;
                alaLiveInfoCoreData.audienceCount = aVar.efB.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
