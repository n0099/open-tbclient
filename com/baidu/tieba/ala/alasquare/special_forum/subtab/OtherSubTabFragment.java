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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.f;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView eOe;
    private PbListView ePm;
    private String eRS;
    private f eWj;
    private AlaNewSquareSubListModel eWk;
    private String eWl;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean eVX = false;
    private boolean mIsInit = false;
    private AlaNewSquareSubListModel.a eWm = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void jg(boolean z) {
            OtherSubTabFragment.this.mHasMore = z;
            OtherSubTabFragment.this.mIsInit = true;
            OtherSubTabFragment.this.it(false);
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            if (v.getCount(OtherSubTabFragment.this.eWk.getDatas()) == 0) {
                OtherSubTabFragment.this.bls();
                return;
            }
            OtherSubTabFragment.this.eOe.setData(OtherSubTabFragment.this.eWk.getDatas());
            if (!OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.bmp();
            } else {
                OtherSubTabFragment.this.bmo();
            }
            OtherSubTabFragment.this.blt();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void av(int i, String str) {
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            OtherSubTabFragment.this.bmq();
            OtherSubTabFragment.this.bls();
        }
    };
    private BdListView.e TQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                OtherSubTabFragment.this.bmq();
            } else if (OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.eWk.bmv();
            }
        }
    };
    private final g.c eVZ = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                OtherSubTabFragment.this.eWk.refreshData();
            } else {
                OtherSubTabFragment.this.it(false);
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
                this.eRS = specialLiveTabInfo.tabName;
            } else if (specialLiveTabInfo.tabType == 2) {
                this.eRS = "游戏";
                this.eWl = specialLiveTabInfo.tabName;
            }
        }
        if (this.eWk == null) {
            this.eWk = new AlaNewSquareSubListModel(getPageContext());
            this.eWk.a(this.eWm);
        }
        this.eWk.setEntryName(this.eRS);
        this.eWk.setLabelName(this.eWl);
        this.eWk.ji(false);
        if (this.eWj == null) {
            this.eWj = new f(getPageContext());
            this.eWj.setFrom(1);
            this.eWj.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bj bjVar) {
                    OtherSubTabFragment.this.a(OtherSubTabFragment.this.getPageContext(), bjVar, str);
                    if (bjVar != null && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new an("c12904").cI("tid", bjVar.getTid()).cI("entryname", str));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(c cVar) {
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.eOe = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.eOe.setOnSrollToBottomListener(this.TQ);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.eVZ);
            this.eOe.setPullRefresh(this.mPullView);
            this.ePm = new PbListView(getContext());
            this.ePm.createView();
            this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.ePm.setLineGone();
            this.ePm.setTextSize(R.dimen.tbfontsize33);
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ePm.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.eWj);
            this.eOe.addAdapters(arrayList);
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
    public void bls() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.eVX) {
            this.eOe.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.eVX = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bmn() {
        super.bmn();
        if (this.eOe != null) {
            this.eOe.smoothScrollToPosition(0);
            this.eOe.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.eOe != null) {
            this.eOe.getAdapter().notifyDataSetChanged();
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
        this.eWk.refreshData();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blt() {
        if (this.eOe != null && this.mRefreshView != null) {
            this.eVX = false;
            this.eOe.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmo() {
        this.eOe.setNextPage(this.ePm);
        this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmp() {
        this.eOe.setNextPage(this.ePm);
        this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.setText(getResources().getString(R.string.list_no_more));
        this.ePm.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmq() {
        this.eOe.setNextPage(this.ePm);
        this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePm.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void it(boolean z) {
        if (!z) {
            this.eOe.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.changeSkin(i);
        }
        am.setBackgroundColor(this.eOe, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eOe != null) {
            this.eOe.setOnSrollToBottomListener(null);
            this.eOe.setScrollable(null);
        }
        if (this.eWk != null) {
            this.eWk.onDestroy();
        }
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.aKE() != null && bjVar.aKX() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aKE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aKX());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.eWk.bmm()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(T(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_sub_tab", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aKX());
        alaLiveInfoCoreData.userName = bjVar.aKE().getUserName();
        return alaLiveInfoCoreData;
    }
}
