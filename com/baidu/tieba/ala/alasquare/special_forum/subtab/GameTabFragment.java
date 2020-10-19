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
    private BdTypeListView fSo;
    private PbListView fTv;
    private AlaLiveTabGameModel fUE;
    private String fWl;
    private d gaC;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gat = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a gaD = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void f(boolean z, List<q> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.kG(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (y.isEmpty(list)) {
                GameTabFragment.this.bJY();
                return;
            }
            GameTabFragment.this.fSo.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.SJ();
            } else {
                GameTabFragment.this.SI();
            }
            GameTabFragment.this.SK();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bKU();
            GameTabFragment.this.bJY();
        }
    };
    private BdListView.e VQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bKU();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.fUE.bJG();
            }
        }
    };
    private final f.c gav = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.fUE.refresh();
            } else {
                GameTabFragment.this.kG(false);
            }
        }
    };

    public static GameTabFragment FM(String str) {
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
            this.fWl = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.fUE == null) {
            this.fUE = new AlaLiveTabGameModel(getPageContext(), this.gaD);
        }
        this.fUE.init();
        if (this.gaC == null) {
            this.gaC = new d(getPageContext());
            this.gaC.setEntryName(this.fWl);
            this.gaC.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new aq("c12904").dK("entryname", GameTabFragment.this.fWl));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.fSo = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.fSo.setOnSrollToBottomListener(this.VQ);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gav);
            this.fSo.setPullRefresh(this.mPullView);
            this.fTv = new PbListView(getContext());
            this.fTv.createView();
            this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fTv.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fTv.setLineGone();
            this.fTv.setTextSize(R.dimen.tbfontsize33);
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fTv.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gaC);
            this.fSo.addAdapters(arrayList);
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
    public void bJY() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gat) {
            this.fSo.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gat = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bKT() {
        super.bKT();
        if (this.fSo != null) {
            this.fSo.smoothScrollToPosition(0);
            this.fSo.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.fSo != null) {
            this.fSo.getAdapter().notifyDataSetChanged();
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
        this.fUE.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
        if (this.fSo != null && this.mRefreshView != null) {
            this.gat = false;
            this.fSo.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SI() {
        this.fSo.setNextPage(this.fTv);
        this.fTv.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SJ() {
        this.fSo.setNextPage(this.fTv);
        this.fTv.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.setText(getResources().getString(R.string.list_no_more));
        this.fTv.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKU() {
        this.fSo.setNextPage(this.fTv);
        this.fTv.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fTv.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void kG(boolean z) {
        if (!z) {
            this.fSo.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ap.setBackgroundColor(this.fSo, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fSo.setOnSrollToBottomListener(null);
        this.fSo.setScrollable(null);
        this.fUE.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.fRT != null) {
            if (aVar.fRT.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.fRT.roomId, String.valueOf(aVar.fRT.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.fRT.roomId, 0L);
            if (aVar.fRT.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.fRT.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.fRT.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.fRT.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.fRT.title;
                alaLiveInfoCoreData.audienceCount = aVar.fRT.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
