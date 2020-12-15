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
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.a;
import com.baidu.tieba.ala.alasquare.live_tab.c;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel;
import com.baidu.tieba.ala.alasquare.special_forum.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class GameTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView gpZ;
    private PbListView grg;
    private AlaLiveTabGameModel gsp;
    private String gtV;
    private d gyl;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gyc = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a gym = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.lx(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (y.isEmpty(list)) {
                GameTabFragment.this.bSf();
                return;
            }
            GameTabFragment.this.gpZ.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.Ya();
            } else {
                GameTabFragment.this.XZ();
            }
            GameTabFragment.this.Yb();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void h(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.bTb();
            GameTabFragment.this.bSf();
        }
    };
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bTb();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.gsp.bRN();
            }
        }
    };
    private final f.c gye = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.gsp.refresh();
            } else {
                GameTabFragment.this.lx(false);
            }
        }
    };

    public static GameTabFragment GO(String str) {
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
            this.gtV = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.gsp == null) {
            this.gsp = new AlaLiveTabGameModel(getPageContext(), this.gym);
        }
        this.gsp.init();
        if (this.gyl == null) {
            this.gyl = new d(getPageContext());
            this.gyl.setEntryName(this.gtV);
            this.gyl.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new ar("c12904").dY("entryname", GameTabFragment.this.gtV));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gpZ = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gpZ.setOnSrollToBottomListener(this.WQ);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gye);
            this.gpZ.setPullRefresh(this.mPullView);
            this.grg = new PbListView(getContext());
            this.grg.createView();
            this.grg.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.grg.setLineGone();
            this.grg.setTextSize(R.dimen.tbfontsize33);
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
            this.grg.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gyl);
            this.gpZ.addAdapters(arrayList);
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
    public void bSf() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gyc) {
            this.gpZ.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gyc = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bTa() {
        super.bTa();
        if (this.gpZ != null) {
            this.gpZ.smoothScrollToPosition(0);
            this.gpZ.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gpZ != null) {
            this.gpZ.getAdapter().notifyDataSetChanged();
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
        this.gsp.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yb() {
        if (this.gpZ != null && this.mRefreshView != null) {
            this.gyc = false;
            this.gpZ.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XZ() {
        this.gpZ.setNextPage(this.grg);
        this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        this.gpZ.setNextPage(this.grg);
        this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.setText(getResources().getString(R.string.list_no_more));
        this.grg.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTb() {
        this.gpZ.setNextPage(this.grg);
        this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.grg.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lx(boolean z) {
        if (!z) {
            this.gpZ.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ap.setBackgroundColor(this.gpZ, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gpZ.setOnSrollToBottomListener(null);
        this.gpZ.setScrollable(null);
        this.gsp.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.gpE != null) {
            if (aVar.gpE.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.gpE.roomId, String.valueOf(aVar.gpE.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.gpE.roomId, 0L);
            if (aVar.gpE.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.gpE.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.gpE.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.gpE.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.gpE.title;
                alaLiveInfoCoreData.audienceCount = aVar.gpE.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
