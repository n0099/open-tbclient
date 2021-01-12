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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.f;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    private String gAn;
    private f gEL;
    private AlaNewSquareSubListModel gEM;
    private String gEN;
    private BdTypeListView gwr;
    private PbListView gxy;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gEz = false;
    private boolean mIsInit = false;
    private AlaNewSquareSubListModel.a gEO = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void mG(boolean z) {
            OtherSubTabFragment.this.mHasMore = z;
            OtherSubTabFragment.this.mIsInit = true;
            OtherSubTabFragment.this.lQ(false);
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            if (x.getCount(OtherSubTabFragment.this.gEM.getDatas()) == 0) {
                OtherSubTabFragment.this.bQQ();
                return;
            }
            OtherSubTabFragment.this.gwr.setData(OtherSubTabFragment.this.gEM.getDatas());
            if (!OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.Vp();
            } else {
                OtherSubTabFragment.this.Vo();
            }
            OtherSubTabFragment.this.Vq();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aF(int i, String str) {
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            OtherSubTabFragment.this.bRO();
            OtherSubTabFragment.this.bQQ();
        }
    };
    private BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                OtherSubTabFragment.this.bRO();
            } else if (OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.gEM.bRT();
            }
        }
    };
    private final f.c gEB = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                OtherSubTabFragment.this.gEM.refreshData();
            } else {
                OtherSubTabFragment.this.lQ(false);
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

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getParcelable("tab_origin_tab_info") != null) {
            SpecialLiveTabInfo specialLiveTabInfo = (SpecialLiveTabInfo) arguments.getParcelable("tab_origin_tab_info");
            if (specialLiveTabInfo.tabType == 1) {
                this.gAn = specialLiveTabInfo.tabName;
            } else if (specialLiveTabInfo.tabType == 2) {
                this.gAn = "游戏";
                this.gEN = specialLiveTabInfo.tabName;
            }
        }
        if (this.gEM == null) {
            this.gEM = new AlaNewSquareSubListModel(getPageContext());
            this.gEM.a(this.gEO);
        }
        this.gEM.setEntryName(this.gAn);
        this.gEM.setLabelName(this.gEN);
        this.gEM.mI(false);
        if (this.gEL == null) {
            this.gEL = new com.baidu.tieba.ala.alasquare.special_forum.a.f(getPageContext());
            this.gEL.setFrom(1);
            this.gEL.b(new com.baidu.tieba.ala.alasquare.subtablist.view.g() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
                public void a(int i, String str, bz bzVar) {
                    OtherSubTabFragment.this.a(OtherSubTabFragment.this.getPageContext(), bzVar, str);
                    if (bzVar != null && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new aq("c12904").dW("tid", bzVar.getTid()).dW("entryname", str));
                    }
                }

                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
                public void a(c cVar) {
                }
            });
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.gwr = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gwr.setOnSrollToBottomListener(this.WL);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gEB);
            this.gwr.setPullRefresh(this.mPullView);
            this.gxy = new PbListView(getContext());
            this.gxy.createView();
            this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gxy.setLineGone();
            this.gxy.setTextSize(R.dimen.tbfontsize33);
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gxy.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gEL);
            this.gwr.addAdapters(arrayList);
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
    public void bQQ() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gEz) {
            this.gwr.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gEz = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bRN() {
        super.bRN();
        if (this.gwr != null) {
            this.gwr.smoothScrollToPosition(0);
            this.gwr.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gwr != null) {
            this.gwr.getAdapter().notifyDataSetChanged();
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
        this.gEM.refreshData();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        if (this.gwr != null && this.mRefreshView != null) {
            this.gEz = false;
            this.gwr.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vo() {
        this.gwr.setNextPage(this.gxy);
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vp() {
        this.gwr.setNextPage(this.gxy);
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.setText(getResources().getString(R.string.list_no_more));
        this.gxy.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRO() {
        this.gwr.setNextPage(this.gxy);
        this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gxy.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lQ(boolean z) {
        if (!z) {
            this.gwr.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(i);
        }
        ao.setBackgroundColor(this.gwr, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gwr != null) {
            this.gwr.setOnSrollToBottomListener(null);
            this.gwr.setScrollable(null);
        }
        if (this.gEM != null) {
            this.gEM.onDestroy();
        }
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bz bzVar, String str) {
        if (tbPageContext != null && bzVar != null && bzVar.bnx() != null && bzVar.bnQ() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.bnx().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bz bzVar2 : this.gEM.bRM()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V(bzVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_sub_tab", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData V(bz bzVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
        alaLiveInfoCoreData.userName = bzVar.bnx().getUserName();
        return alaLiveInfoCoreData;
    }
}
