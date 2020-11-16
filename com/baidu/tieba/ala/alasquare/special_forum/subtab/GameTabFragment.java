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
import com.baidu.tbadk.core.util.ar;
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
    private BdTypeListView ghN;
    private PbListView giV;
    private AlaLiveTabGameModel gke;
    private String glK;
    private d gqa;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gpR = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a gqb = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.ld(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (y.isEmpty(list)) {
                GameTabFragment.this.bOt();
                return;
            }
            GameTabFragment.this.ghN.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.VA();
            } else {
                GameTabFragment.this.Vz();
            }
            GameTabFragment.this.VB();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bPp();
            GameTabFragment.this.bOt();
        }
    };
    private BdListView.e VT = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bPp();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.gke.bOb();
            }
        }
    };
    private final f.c gpT = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.gke.refresh();
            } else {
                GameTabFragment.this.ld(false);
            }
        }
    };

    public static GameTabFragment Ga(String str) {
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
            this.glK = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.gke == null) {
            this.gke = new AlaLiveTabGameModel(getPageContext(), this.gqb);
        }
        this.gke.init();
        if (this.gqa == null) {
            this.gqa = new d(getPageContext());
            this.gqa.setEntryName(this.glK);
            this.gqa.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new ar("c12904").dR("entryname", GameTabFragment.this.glK));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.ghN = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.ghN.setOnSrollToBottomListener(this.VT);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gpT);
            this.ghN.setPullRefresh(this.mPullView);
            this.giV = new PbListView(getContext());
            this.giV.createView();
            this.giV.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.giV.setLineGone();
            this.giV.setTextSize(R.dimen.tbfontsize33);
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
            this.giV.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gqa);
            this.ghN.addAdapters(arrayList);
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
    public void bOt() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gpR) {
            this.ghN.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gpR = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bPo() {
        super.bPo();
        if (this.ghN != null) {
            this.ghN.smoothScrollToPosition(0);
            this.ghN.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.ghN != null) {
            this.ghN.getAdapter().notifyDataSetChanged();
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
        this.gke.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        if (this.ghN != null && this.mRefreshView != null) {
            this.gpR = false;
            this.ghN.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vz() {
        this.ghN.setNextPage(this.giV);
        this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VA() {
        this.ghN.setNextPage(this.giV);
        this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.setText(getResources().getString(R.string.list_no_more));
        this.giV.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPp() {
        this.ghN.setNextPage(this.giV);
        this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.giV.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void ld(boolean z) {
        if (!z) {
            this.ghN.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ap.setBackgroundColor(this.ghN, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ghN.setOnSrollToBottomListener(null);
        this.ghN.setScrollable(null);
        this.gke.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.ghs != null) {
            if (aVar.ghs.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.ghs.roomId, String.valueOf(aVar.ghs.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.ghs.roomId, 0L);
            if (aVar.ghs.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.ghs.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.ghs.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.ghs.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.ghs.title;
                alaLiveInfoCoreData.audienceCount = aVar.ghs.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
