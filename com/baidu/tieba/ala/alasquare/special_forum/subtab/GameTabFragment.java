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
    private BdTypeListView gpX;
    private PbListView gre;
    private AlaLiveTabGameModel gsn;
    private String gtT;
    private d gyj;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gya = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a gyk = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.lx(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (y.isEmpty(list)) {
                GameTabFragment.this.bSe();
                return;
            }
            GameTabFragment.this.gpX.setData(list);
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
            GameTabFragment.this.bTa();
            GameTabFragment.this.bSe();
        }
    };
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.bTa();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.gsn.bRM();
            }
        }
    };
    private final f.c gyc = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.gsn.refresh();
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
            this.gtT = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.gsn == null) {
            this.gsn = new AlaLiveTabGameModel(getPageContext(), this.gyk);
        }
        this.gsn.init();
        if (this.gyj == null) {
            this.gyj = new d(getPageContext());
            this.gyj.setEntryName(this.gtT);
            this.gyj.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new ar("c12904").dY("entryname", GameTabFragment.this.gtT));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gpX = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gpX.setOnSrollToBottomListener(this.WQ);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gyc);
            this.gpX.setPullRefresh(this.mPullView);
            this.gre = new PbListView(getContext());
            this.gre.createView();
            this.gre.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gre.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gre.setLineGone();
            this.gre.setTextSize(R.dimen.tbfontsize33);
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gre.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gyj);
            this.gpX.addAdapters(arrayList);
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
    public void bSe() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gya) {
            this.gpX.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gya = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bSZ() {
        super.bSZ();
        if (this.gpX != null) {
            this.gpX.smoothScrollToPosition(0);
            this.gpX.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gpX != null) {
            this.gpX.getAdapter().notifyDataSetChanged();
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
        this.gsn.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yb() {
        if (this.gpX != null && this.mRefreshView != null) {
            this.gya = false;
            this.gpX.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XZ() {
        this.gpX.setNextPage(this.gre);
        this.gre.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        this.gpX.setNextPage(this.gre);
        this.gre.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.setText(getResources().getString(R.string.list_no_more));
        this.gre.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTa() {
        this.gpX.setNextPage(this.gre);
        this.gre.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gre.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lx(boolean z) {
        if (!z) {
            this.gpX.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        ap.setBackgroundColor(this.gpX, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gpX.setOnSrollToBottomListener(null);
        this.gpX.setScrollable(null);
        this.gsn.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.gpC != null) {
            if (aVar.gpC.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.gpC.roomId, String.valueOf(aVar.gpC.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.gpC.roomId, 0L);
            if (aVar.gpC.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.gpC.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.gpC.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.gpC.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.gpC.title;
                alaLiveInfoCoreData.audienceCount = aVar.gpC.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
