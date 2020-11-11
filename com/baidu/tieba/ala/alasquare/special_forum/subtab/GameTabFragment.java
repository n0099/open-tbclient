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
    private BdTypeListView gih;
    private PbListView gjo;
    private AlaLiveTabGameModel gkx;
    private String gmd;
    private d gqt;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gqk = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a gqu = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.lc(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (y.isEmpty(list)) {
                GameTabFragment.this.bPa();
                return;
            }
            GameTabFragment.this.gih.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.Wj();
            } else {
                GameTabFragment.this.Wi();
            }
            GameTabFragment.this.Wk();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bPW();
            GameTabFragment.this.bPa();
        }
    };
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bPW();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.gkx.bOI();
            }
        }
    };
    private final f.c gqm = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.gkx.refresh();
            } else {
                GameTabFragment.this.lc(false);
            }
        }
    };

    public static GameTabFragment Gz(String str) {
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
            this.gmd = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.gkx == null) {
            this.gkx = new AlaLiveTabGameModel(getPageContext(), this.gqu);
        }
        this.gkx.init();
        if (this.gqt == null) {
            this.gqt = new d(getPageContext());
            this.gqt.setEntryName(this.gmd);
            this.gqt.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new aq("c12904").dR("entryname", GameTabFragment.this.gmd));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gih = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gih.setOnSrollToBottomListener(this.VR);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gqm);
            this.gih.setPullRefresh(this.mPullView);
            this.gjo = new PbListView(getContext());
            this.gjo.createView();
            this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gjo.setLineGone();
            this.gjo.setTextSize(R.dimen.tbfontsize33);
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gjo.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gqt);
            this.gih.addAdapters(arrayList);
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
    public void bPa() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gqk) {
            this.gih.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gqk = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bPV() {
        super.bPV();
        if (this.gih != null) {
            this.gih.smoothScrollToPosition(0);
            this.gih.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gih != null) {
            this.gih.getAdapter().notifyDataSetChanged();
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
        this.gkx.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wk() {
        if (this.gih != null && this.mRefreshView != null) {
            this.gqk = false;
            this.gih.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wi() {
        this.gih.setNextPage(this.gjo);
        this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wj() {
        this.gih.setNextPage(this.gjo);
        this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.setText(getResources().getString(R.string.list_no_more));
        this.gjo.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPW() {
        this.gih.setNextPage(this.gjo);
        this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gjo.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lc(boolean z) {
        if (!z) {
            this.gih.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ap.setBackgroundColor(this.gih, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gih.setOnSrollToBottomListener(null);
        this.gih.setScrollable(null);
        this.gkx.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.ghL != null) {
            if (aVar.ghL.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.ghL.roomId, String.valueOf(aVar.ghL.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.ghL.roomId, 0L);
            if (aVar.ghL.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.ghL.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.ghL.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.ghL.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.ghL.title;
                alaLiveInfoCoreData.audienceCount = aVar.ghL.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
