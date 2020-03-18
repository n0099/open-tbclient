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
    private BdTypeListView ekE;
    private PbListView elM;
    private AlaLiveTabGameModel emL;
    private String eov;
    private d esK;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean esB = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a esL = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void d(boolean z, List<m> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.hv(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (v.isEmpty(list)) {
                GameTabFragment.this.bcB();
                return;
            }
            GameTabFragment.this.ekE.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.bdy();
            } else {
                GameTabFragment.this.bdx();
            }
            GameTabFragment.this.bcC();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bdz();
            GameTabFragment.this.bcB();
        }
    };
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bdz();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.emL.bck();
            }
        }
    };
    private final g.c esD = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.emL.refresh();
            } else {
                GameTabFragment.this.hv(false);
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
            this.eov = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.emL == null) {
            this.emL = new AlaLiveTabGameModel(getPageContext(), this.esL);
        }
        this.emL.init();
        if (this.esK == null) {
            this.esK = new d(getPageContext());
            this.esK.setEntryName(this.eov);
            this.esK.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new an("c12904").cx("entryname", GameTabFragment.this.eov));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.ekE = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.ekE.setOnSrollToBottomListener(this.Az);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.esD);
            this.ekE.setPullRefresh(this.mPullView);
            this.elM = new PbListView(getContext());
            this.elM.createView();
            this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.elM.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.elM.setLineGone();
            this.elM.setTextSize(R.dimen.tbfontsize33);
            this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elM.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.esK);
            this.ekE.addAdapters(arrayList);
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
    public void bcB() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.esB) {
            this.ekE.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.esB = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bdw() {
        super.bdw();
        if (this.ekE != null) {
            this.ekE.smoothScrollToPosition(0);
            this.ekE.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.ekE != null) {
            this.ekE.getAdapter().notifyDataSetChanged();
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
        this.emL.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcC() {
        if (this.ekE != null && this.mRefreshView != null) {
            this.esB = false;
            this.ekE.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdx() {
        this.ekE.setNextPage(this.elM);
        this.elM.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdy() {
        this.ekE.setNextPage(this.elM);
        this.elM.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.setText(getResources().getString(R.string.list_no_more));
        this.elM.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdz() {
        this.ekE.setNextPage(this.elM);
        this.elM.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elM.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void hv(boolean z) {
        if (!z) {
            this.ekE.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elM != null) {
            this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elM.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        am.setBackgroundColor(this.ekE, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ekE.setOnSrollToBottomListener(null);
        this.ekE.setScrollable(null);
        this.emL.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.ekj != null) {
            if (aVar.ekj.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.ekj.roomId, String.valueOf(aVar.ekj.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.ekj.roomId, 0L);
            if (aVar.ekj.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.ekj.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.ekj.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.ekj.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.ekj.title;
                alaLiveInfoCoreData.audienceCount = aVar.ekj.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
