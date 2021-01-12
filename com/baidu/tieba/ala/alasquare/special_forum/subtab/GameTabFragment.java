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
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.a;
import com.baidu.tieba.ala.alasquare.live_tab.c;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel;
import com.baidu.tieba.ala.alasquare.special_forum.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class GameTabFragment extends SpecialForumTabBaseFragment {
    private String gAn;
    private d gEI;
    private BdTypeListView gwr;
    private PbListView gxy;
    private AlaLiveTabGameModel gyH;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gEz = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a gEJ = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(boolean z, List<n> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.lQ(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (x.isEmpty(list)) {
                GameTabFragment.this.bQQ();
                return;
            }
            GameTabFragment.this.gwr.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.Vp();
            } else {
                GameTabFragment.this.Vo();
            }
            GameTabFragment.this.Vq();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bRO();
            GameTabFragment.this.bQQ();
        }
    };
    private BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bRO();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.gyH.bQy();
            }
        }
    };
    private final f.c gEB = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.gyH.refresh();
            } else {
                GameTabFragment.this.lQ(false);
            }
        }
    };

    public static GameTabFragment FA(String str) {
        GameTabFragment gameTabFragment = new GameTabFragment();
        if (!StringUtils.isNull(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("key_special_forum_game_tab_entryname", str);
            gameTabFragment.setArguments(bundle);
        }
        return gameTabFragment;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && !StringUtils.isNull(arguments.getString("key_special_forum_game_tab_entryname"))) {
            this.gAn = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.gyH == null) {
            this.gyH = new AlaLiveTabGameModel(getPageContext(), this.gEJ);
        }
        this.gyH.init();
        if (this.gEI == null) {
            this.gEI = new d(getPageContext());
            this.gEI.setEntryName(this.gAn);
            this.gEI.a(new com.baidu.tieba.ala.alasquare.subtablist.view.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.f
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new aq("c12904").dW("entryname", GameTabFragment.this.gAn));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gwr = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gwr.setOnSrollToBottomListener(this.WL);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gEB);
            this.gwr.setPullRefresh(this.mPullView);
            this.gxy = new PbListView(getContext());
            this.gxy.createView();
            this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gxy.setLineGone();
            this.gxy.setTextSize(R.dimen.tbfontsize33);
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gxy.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gEI);
            this.gwr.addAdapters(arrayList);
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
    public void bQQ() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gEz) {
            this.gwr.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gEz = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bRN() {
        super.bRN();
        if (this.gwr != null) {
            this.gwr.smoothScrollToPosition(0);
            this.gwr.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gwr != null) {
            this.gwr.getAdapter().notifyDataSetChanged();
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
        this.gyH.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        if (this.gwr != null && this.mRefreshView != null) {
            this.gEz = false;
            this.gwr.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vo() {
        this.gwr.setNextPage(this.gxy);
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vp() {
        this.gwr.setNextPage(this.gxy);
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.setText(getResources().getString(R.string.list_no_more));
        this.gxy.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRO() {
        this.gwr.setNextPage(this.gxy);
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gxy.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lQ(boolean z) {
        if (!z) {
            this.gwr.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ao.setBackgroundColor(this.gwr, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gwr.setOnSrollToBottomListener(null);
        this.gwr.setScrollable(null);
        this.gyH.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.gvN != null) {
            if (aVar.gvN.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.gvN.roomId, String.valueOf(aVar.gvN.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.gvN.roomId, 0L);
            if (aVar.gvN.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.gvN.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.gvN.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.gvN.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.gvN.title;
                alaLiveInfoCoreData.audienceCount = aVar.gvN.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
