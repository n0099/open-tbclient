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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes10.dex */
public class GameTabFragment extends SpecialForumTabBaseFragment {
    private PbListView gAw;
    private AlaLiveTabGameModel gBF;
    private String gDl;
    private d gHG;
    private BdTypeListView gzp;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gHx = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a gHH = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(boolean z, List<n> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.lU(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (y.isEmpty(list)) {
                GameTabFragment.this.bRB();
                return;
            }
            GameTabFragment.this.gzp.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.WY();
            } else {
                GameTabFragment.this.WX();
            }
            GameTabFragment.this.WZ();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void g(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bSy();
            GameTabFragment.this.bRB();
        }
    };
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bSy();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.gBF.bRj();
            }
        }
    };
    private final f.c gHz = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.gBF.refresh();
            } else {
                GameTabFragment.this.lU(false);
            }
        }
    };

    public static GameTabFragment FZ(String str) {
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
            this.gDl = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.gBF == null) {
            this.gBF = new AlaLiveTabGameModel(getPageContext(), this.gHH);
        }
        this.gBF.init();
        if (this.gHG == null) {
            this.gHG = new d(getPageContext());
            this.gHG.setEntryName(this.gDl);
            this.gHG.a(new com.baidu.tieba.ala.alasquare.subtablist.view.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.f
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new ar("c12904").dR("entryname", GameTabFragment.this.gDl));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gzp = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gzp.setOnSrollToBottomListener(this.WH);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gHz);
            this.gzp.setPullRefresh(this.mPullView);
            this.gAw = new PbListView(getContext());
            this.gAw.createView();
            this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gAw.setLineGone();
            this.gAw.setTextSize(R.dimen.tbfontsize33);
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gAw.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gHG);
            this.gzp.addAdapters(arrayList);
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
    public void bRB() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gHx) {
            this.gzp.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gHx = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bSx() {
        super.bSx();
        if (this.gzp != null) {
            this.gzp.smoothScrollToPosition(0);
            this.gzp.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gzp != null) {
            this.gzp.getAdapter().notifyDataSetChanged();
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
        this.gBF.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        if (this.gzp != null && this.mRefreshView != null) {
            this.gHx = false;
            this.gzp.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WX() {
        this.gzp.setNextPage(this.gAw);
        this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WY() {
        this.gzp.setNextPage(this.gAw);
        this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.setText(getResources().getString(R.string.list_no_more));
        this.gAw.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSy() {
        this.gzp.setNextPage(this.gAw);
        this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAw.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lU(boolean z) {
        if (!z) {
            this.gzp.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ap.setBackgroundColor(this.gzp, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gzp.setOnSrollToBottomListener(null);
        this.gzp.setScrollable(null);
        this.gBF.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.gyL != null) {
            if (aVar.gyL.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.gyL.roomId, String.valueOf(aVar.gyL.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.gyL.roomId, 0L);
            if (aVar.gyL.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.gyL.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.gyL.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.gyL.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.gyL.title;
                alaLiveInfoCoreData.audienceCount = aVar.gyL.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
