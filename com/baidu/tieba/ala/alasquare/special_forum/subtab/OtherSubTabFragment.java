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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.f;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView gpZ;
    private PbListView grg;
    private String gtV;
    private f gyo;
    private AlaNewSquareSubListModel gyp;
    private String gyq;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gyc = false;
    private boolean mIsInit = false;
    private AlaNewSquareSubListModel.a gyr = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void mn(boolean z) {
            OtherSubTabFragment.this.mHasMore = z;
            OtherSubTabFragment.this.mIsInit = true;
            OtherSubTabFragment.this.lx(false);
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            if (y.getCount(OtherSubTabFragment.this.gyp.getDatas()) == 0) {
                OtherSubTabFragment.this.bSf();
                return;
            }
            OtherSubTabFragment.this.gpZ.setData(OtherSubTabFragment.this.gyp.getDatas());
            if (!OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.Ya();
            } else {
                OtherSubTabFragment.this.XZ();
            }
            OtherSubTabFragment.this.Yb();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aC(int i, String str) {
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            OtherSubTabFragment.this.bTb();
            OtherSubTabFragment.this.bSf();
        }
    };
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                OtherSubTabFragment.this.bTb();
            } else if (OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.gyp.bTg();
            }
        }
    };
    private final f.c gye = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                OtherSubTabFragment.this.gyp.refreshData();
            } else {
                OtherSubTabFragment.this.lx(false);
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
                this.gtV = specialLiveTabInfo.tabName;
            } else if (specialLiveTabInfo.tabType == 2) {
                this.gtV = "游戏";
                this.gyq = specialLiveTabInfo.tabName;
            }
        }
        if (this.gyp == null) {
            this.gyp = new AlaNewSquareSubListModel(getPageContext());
            this.gyp.a(this.gyr);
        }
        this.gyp.setEntryName(this.gtV);
        this.gyp.setLabelName(this.gyq);
        this.gyp.mp(false);
        if (this.gyo == null) {
            this.gyo = new com.baidu.tieba.ala.alasquare.special_forum.a.f(getPageContext());
            this.gyo.setFrom(1);
            this.gyo.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, by byVar) {
                    OtherSubTabFragment.this.a(OtherSubTabFragment.this.getPageContext(), byVar, str);
                    if (byVar != null && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new ar("c12904").dY("tid", byVar.getTid()).dY("entryname", str));
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
            arrayList.add(this.gyo);
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
        this.gyp.refreshData();
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
        ap.setBackgroundColor(this.gpZ, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gpZ != null) {
            this.gpZ.setOnSrollToBottomListener(null);
            this.gpZ.setScrollable(null);
        }
        if (this.gyp != null) {
            this.gyp.onDestroy();
        }
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, by byVar, String str) {
        if (tbPageContext != null && byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = byVar.boP().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (by byVar2 : this.gyp.bSZ()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V(byVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_sub_tab", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData V(by byVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
        alaLiveInfoCoreData.userName = byVar.boP().getUserName();
        return alaLiveInfoCoreData;
    }
}
