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
/* loaded from: classes9.dex */
public class GameTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView gAY;
    private PbListView gCf;
    private AlaLiveTabGameModel gDo;
    private String gEU;
    private d gJp;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gJg = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a gJq = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void g(boolean z, List<n> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.lU(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (y.isEmpty(list)) {
                GameTabFragment.this.bRH();
                return;
            }
            GameTabFragment.this.gAY.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.Xb();
            } else {
                GameTabFragment.this.Xa();
            }
            GameTabFragment.this.Xc();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void g(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bSE();
            GameTabFragment.this.bRH();
        }
    };
    private BdListView.e Yb = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bSE();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.gDo.bRp();
            }
        }
    };
    private final f.c gJi = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.gDo.refresh();
            } else {
                GameTabFragment.this.lU(false);
            }
        }
    };

    public static GameTabFragment Gi(String str) {
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
            this.gEU = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.gDo == null) {
            this.gDo = new AlaLiveTabGameModel(getPageContext(), this.gJq);
        }
        this.gDo.init();
        if (this.gJp == null) {
            this.gJp = new d(getPageContext());
            this.gJp.setEntryName(this.gEU);
            this.gJp.a(new com.baidu.tieba.ala.alasquare.subtablist.view.f() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.f
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new ar("c12904").dR("entryname", GameTabFragment.this.gEU));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gAY = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gAY.setOnSrollToBottomListener(this.Yb);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gJi);
            this.gAY.setPullRefresh(this.mPullView);
            this.gCf = new PbListView(getContext());
            this.gCf.createView();
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gCf.setLineGone();
            this.gCf.setTextSize(R.dimen.tbfontsize33);
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gCf.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gJp);
            this.gAY.addAdapters(arrayList);
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
    public void bRH() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gJg) {
            this.gAY.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gJg = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bSD() {
        super.bSD();
        if (this.gAY != null) {
            this.gAY.smoothScrollToPosition(0);
            this.gAY.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gAY != null) {
            this.gAY.getAdapter().notifyDataSetChanged();
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
        this.gDo.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        if (this.gAY != null && this.mRefreshView != null) {
            this.gJg = false;
            this.gAY.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        this.gAY.setNextPage(this.gCf);
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xb() {
        this.gAY.setNextPage(this.gCf);
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.setText(getResources().getString(R.string.list_no_more));
        this.gCf.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSE() {
        this.gAY.setNextPage(this.gCf);
        this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gCf.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lU(boolean z) {
        if (!z) {
            this.gAY.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ap.setBackgroundColor(this.gAY, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gAY.setOnSrollToBottomListener(null);
        this.gAY.setScrollable(null);
        this.gDo.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.gAu != null) {
            if (aVar.gAu.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.gAu.roomId, String.valueOf(aVar.gAu.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.gAu.roomId, 0L);
            if (aVar.gAu.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.gAu.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.gAu.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.gAu.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.gAu.title;
                alaLiveInfoCoreData.audienceCount = aVar.gAu.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
