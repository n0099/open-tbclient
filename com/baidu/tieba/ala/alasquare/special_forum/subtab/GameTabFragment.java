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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes3.dex */
public class GameTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView fml;
    private PbListView fnt;
    private AlaLiveTabGameModel fot;
    private String fqb;
    private d fut;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fuk = false;
    private boolean mIsInit = false;
    private AlaLiveTabGameModel.a fuu = new AlaLiveTabGameModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void e(boolean z, List<q> list) {
            GameTabFragment.this.mHasMore = z;
            GameTabFragment.this.mIsInit = true;
            GameTabFragment.this.jc(false);
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            if (w.isEmpty(list)) {
                GameTabFragment.this.btN();
                return;
            }
            GameTabFragment.this.fml.setData(list);
            if (!GameTabFragment.this.mHasMore) {
                GameTabFragment.this.buK();
            } else {
                GameTabFragment.this.buJ();
            }
            GameTabFragment.this.btO();
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabGameModel.a
        public void g(int i, String str, boolean z) {
            GameTabFragment.this.hideLoadingView(GameTabFragment.this.mRootView);
            GameTabFragment.this.buL();
            GameTabFragment.this.btN();
        }
    };
    private BdListView.e UJ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                GameTabFragment.this.buL();
            } else if (GameTabFragment.this.mHasMore) {
                GameTabFragment.this.fot.btv();
            }
        }
    };
    private final f.c fum = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                GameTabFragment.this.fot.refresh();
            } else {
                GameTabFragment.this.jc(false);
            }
        }
    };

    public static GameTabFragment Bx(String str) {
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
            this.fqb = arguments.getString("key_special_forum_game_tab_entryname");
        }
        if (this.fot == null) {
            this.fot = new AlaLiveTabGameModel(getPageContext(), this.fuu);
        }
        this.fot.init();
        if (this.fut == null) {
            this.fut = new d(getPageContext());
            this.fut.setEntryName(this.fqb);
            this.fut.a(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.GameTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void c(a aVar) {
                    GameTabFragment.this.b(aVar);
                    TiebaStatic.log(new ao("c12904").dk("entryname", GameTabFragment.this.fqb));
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.fml = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.fml.setOnSrollToBottomListener(this.UJ);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fum);
            this.fml.setPullRefresh(this.mPullView);
            this.fnt = new PbListView(getContext());
            this.fnt.createView();
            this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fnt.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fnt.setLineGone();
            this.fnt.setTextSize(R.dimen.tbfontsize33);
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fnt.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.fut);
            this.fml.addAdapters(arrayList);
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
    public void btN() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fuk) {
            this.fml.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.fuk = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void buI() {
        super.buI();
        if (this.fml != null) {
            this.fml.smoothScrollToPosition(0);
            this.fml.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.fml != null) {
            this.fml.getAdapter().notifyDataSetChanged();
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
        this.fot.refresh();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btO() {
        if (this.fml != null && this.mRefreshView != null) {
            this.fuk = false;
            this.fml.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buJ() {
        this.fml.setNextPage(this.fnt);
        this.fnt.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buK() {
        this.fml.setNextPage(this.fnt);
        this.fnt.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.setText(getResources().getString(R.string.list_no_more));
        this.fnt.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buL() {
        this.fml.setNextPage(this.fnt);
        this.fnt.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fnt.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void jc(boolean z) {
        if (!z) {
            this.fml.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.changeSkin(i);
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        an.setBackgroundColor(this.fml, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.fml.setOnSrollToBottomListener(null);
        this.fml.setScrollable(null);
        this.fot.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null && aVar.flQ != null) {
            if (aVar.flQ.shouldJumpChushouLiveRoom()) {
                c.a(getPageContext(), aVar.flQ.roomId, String.valueOf(aVar.flQ.liveInfo.liveType));
                return;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = b.toLong(aVar.flQ.roomId, 0L);
            if (aVar.flQ.liveInfo != null) {
                alaLiveInfoCoreData.hslUrl = aVar.flQ.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = aVar.flQ.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = aVar.flQ.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = aVar.flQ.title;
                alaLiveInfoCoreData.audienceCount = aVar.flQ.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(getContext(), alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_GAME_TAB, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }
}
