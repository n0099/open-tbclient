package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.e;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    private e dBR;
    private AlaNewSquareSubListModel dBS;
    private String dBT;
    private BdTypeListView duK;
    private PbListView dvS;
    private String dxP;
    private i mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean dBI = false;
    private boolean mIsInit = false;
    private AlaNewSquareSubListModel.a dBU = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void gI(boolean z) {
            OtherSubTabFragment.this.mHasMore = z;
            OtherSubTabFragment.this.mIsInit = true;
            OtherSubTabFragment.this.fU(false);
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            if (v.getCount(OtherSubTabFragment.this.dBS.getDatas()) == 0) {
                OtherSubTabFragment.this.aJl();
                return;
            }
            OtherSubTabFragment.this.duK.setData(OtherSubTabFragment.this.dBS.getDatas());
            if (!OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.aKh();
            } else {
                OtherSubTabFragment.this.aKg();
            }
            OtherSubTabFragment.this.aJm();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void O(int i, String str) {
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            OtherSubTabFragment.this.aKi();
            OtherSubTabFragment.this.aJl();
        }
    };
    private BdListView.e xE = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                OtherSubTabFragment.this.aKi();
            } else if (OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.dBS.aKn();
            }
        }
    };
    private final h.c dBK = new h.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                OtherSubTabFragment.this.dBS.refreshData();
            } else {
                OtherSubTabFragment.this.fU(false);
            }
        }
    };

    public static OtherSubTabFragment a(int i, SpecialLiveTabInfo specialLiveTabInfo) {
        OtherSubTabFragment otherSubTabFragment = new OtherSubTabFragment();
        if (specialLiveTabInfo != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_origin_tab_position", i);
            bundle.putParcelable("tab_origin_tab_info", specialLiveTabInfo);
            otherSubTabFragment.setArguments(bundle);
        }
        return otherSubTabFragment;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getParcelable("tab_origin_tab_info") != null) {
            SpecialLiveTabInfo specialLiveTabInfo = (SpecialLiveTabInfo) arguments.getParcelable("tab_origin_tab_info");
            if (specialLiveTabInfo.tabType == 1) {
                this.dxP = specialLiveTabInfo.tabName;
            } else if (specialLiveTabInfo.tabType == 2) {
                this.dxP = "游戏";
                this.dBT = specialLiveTabInfo.tabName;
            }
        }
        if (this.dBS == null) {
            this.dBS = new AlaNewSquareSubListModel(getPageContext());
            this.dBS.a(this.dBU);
        }
        this.dBS.setEntryName(this.dxP);
        this.dBS.setLabelName(this.dBT);
        this.dBS.gK(false);
        if (this.dBR == null) {
            this.dBR = new e(getPageContext());
            this.dBR.setFrom(1);
            this.dBR.b(new com.baidu.tieba.ala.alasquare.subtablist.c.h() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void a(int i, String str, bh bhVar) {
                    OtherSubTabFragment.this.a(OtherSubTabFragment.this.getPageContext(), bhVar, str);
                    if (bhVar != null && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new an("c12904").bS("tid", bhVar.getTid()).bS("entryname", str));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.h
                public void a(c cVar) {
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.duK = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.duK.setOnSrollToBottomListener(this.xE);
            this.mPullView = new i(getPageContext());
            this.mPullView.setListPullRefreshListener(this.dBK);
            this.duK.setPullRefresh(this.mPullView);
            this.dvS = new PbListView(getContext());
            this.dvS.createView();
            this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.dvS.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.dvS.setLineGone();
            this.dvS.setTextSize(R.dimen.tbfontsize33);
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dvS.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.dBR);
            this.duK.addAdapters(arrayList);
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
    public void aJl() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.dBI) {
            this.duK.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.dBI = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void aKf() {
        super.aKf();
        if (this.duK != null) {
            this.duK.smoothScrollToPosition(0);
            this.duK.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.duK != null) {
            this.duK.getAdapter().notifyDataSetChanged();
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
        this.dBS.refreshData();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJm() {
        if (this.duK != null && this.mRefreshView != null) {
            this.dBI = false;
            this.duK.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKg() {
        this.duK.setNextPage(this.dvS);
        this.dvS.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
        this.duK.setNextPage(this.dvS);
        this.dvS.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.setText(getResources().getString(R.string.list_no_more));
        this.dvS.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKi() {
        this.duK.setNextPage(this.dvS);
        this.dvS.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.dvS.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void fU(boolean z) {
        if (!z) {
            this.duK.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.dvS != null) {
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.changeSkin(i);
        }
        am.setBackgroundColor(this.duK, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.duK.setOnSrollToBottomListener(null);
        this.duK.setScrollable(null);
        this.dBS.onDestroy();
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bh bhVar, String str) {
        if (tbPageContext != null && bhVar != null && bhVar.aiE() != null && bhVar.aiX() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bh bhVar2 : this.dBS.aKe()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(M(bhVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_sub_tab", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData M(bh bhVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
        alaLiveInfoCoreData.userName = bhVar.aiE().getUserName();
        return alaLiveInfoCoreData;
    }
}
