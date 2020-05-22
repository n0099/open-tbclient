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
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes3.dex */
public class GameTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView faQ;
    private PbListView fbY;
    private AlaLiveTabGameModel fcY;
    private String feF;
    private d fiV;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fiM = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a fiW = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void d(boolean z, List<o> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.iQ(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (v.isEmpty(list)) {
                GameTabFragment.this.bqN();
                return;
            }
            GameTabFragment.this.faQ.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.brL();
            } else {
                GameTabFragment.this.brK();
            }
            GameTabFragment.this.bqO();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void g(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.brM();
            GameTabFragment.this.bqN();
        }
    };
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.brM();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.fcY.bqv();
            }
        }
    };
    private final f.c fiO = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.fcY.refresh();
            } else {
                GameTabFragment.this.iQ(false);
            }
        }
    };

    public static GameTabFragment AY(String str) {
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
            this.feF = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.fcY == null) {
            this.fcY = new AlaLiveTabGameModel(getPageContext(), this.fiW);
        }
        this.fcY.init();
        if (this.fiV == null) {
            this.fiV = new d(getPageContext());
            this.fiV.setEntryName(this.feF);
            this.fiV.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new an("c12904").dh("entryname", GameTabFragment.this.feF));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.faQ = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
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
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.fiV);
            this.faQ.addAdapters(arrayList);
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
            this.fiM = true;
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        refreshData();
    }

    private void refreshData() {
        this.mIsInit = false;
        this.fcY.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqO() {
        if (this.faQ != null && this.mRefreshView != null) {
            this.fiM = false;
            this.faQ.removeHeaderView(this.mRefreshView.getAttachedView());
        }
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
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        am.setBackgroundColor(this.faQ, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.faQ.setOnSrollToBottomListener(null);
        this.faQ.setScrollable(null);
        this.fcY.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.fav != null) {
            if (aVar.fav.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.fav.roomId, String.valueOf(aVar.fav.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.fav.roomId, 0L);
            if (aVar.fav.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.fav.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.fav.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.fav.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.fav.title;
                alaLiveInfoCoreData.audienceCount = aVar.fav.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
