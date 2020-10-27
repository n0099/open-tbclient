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
    private BdTypeListView gcr;
    private PbListView gdy;
    private AlaLiveTabGameModel geI;
    private String ggp;
    private d gkG;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gkx = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a gkH = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.kT(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (y.isEmpty(list)) {
                GameTabFragment.this.bMA();
                return;
            }
            GameTabFragment.this.gcr.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.TJ();
            } else {
                GameTabFragment.this.TI();
            }
            GameTabFragment.this.TK();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bNw();
            GameTabFragment.this.bMA();
        }
    };
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bNw();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.geI.bMi();
            }
        }
    };
    private final f.c gkz = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.geI.refresh();
            } else {
                GameTabFragment.this.kT(false);
            }
        }
    };

    public static GameTabFragment Gl(String str) {
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
            this.ggp = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.geI == null) {
            this.geI = new AlaLiveTabGameModel(getPageContext(), this.gkH);
        }
        this.geI.init();
        if (this.gkG == null) {
            this.gkG = new d(getPageContext());
            this.gkG.setEntryName(this.ggp);
            this.gkG.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new aq("c12904").dR("entryname", GameTabFragment.this.ggp));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gcr = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gcr.setOnSrollToBottomListener(this.VR);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gkz);
            this.gcr.setPullRefresh(this.mPullView);
            this.gdy = new PbListView(getContext());
            this.gdy.createView();
            this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gdy.setLineGone();
            this.gdy.setTextSize(R.dimen.tbfontsize33);
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gdy.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gkG);
            this.gcr.addAdapters(arrayList);
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
    public void bMA() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gkx) {
            this.gcr.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gkx = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bNv() {
        super.bNv();
        if (this.gcr != null) {
            this.gcr.smoothScrollToPosition(0);
            this.gcr.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gcr != null) {
            this.gcr.getAdapter().notifyDataSetChanged();
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
        this.geI.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TK() {
        if (this.gcr != null && this.mRefreshView != null) {
            this.gkx = false;
            this.gcr.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TI() {
        this.gcr.setNextPage(this.gdy);
        this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TJ() {
        this.gcr.setNextPage(this.gdy);
        this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.setText(getResources().getString(R.string.list_no_more));
        this.gdy.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNw() {
        this.gcr.setNextPage(this.gdy);
        this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gdy.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void kT(boolean z) {
        if (!z) {
            this.gcr.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ap.setBackgroundColor(this.gcr, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gcr.setOnSrollToBottomListener(null);
        this.gcr.setScrollable(null);
        this.geI.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.gbW != null) {
            if (aVar.gbW.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.gbW.roomId, String.valueOf(aVar.gbW.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.gbW.roomId, 0L);
            if (aVar.gbW.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.gbW.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.gbW.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.gbW.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.gbW.title;
                alaLiveInfoCoreData.audienceCount = aVar.gbW.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
