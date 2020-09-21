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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.a.f;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo;
import com.baidu.tieba.ala.alasquare.subtablist.b.c;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView fGf;
    private PbListView fHm;
    private String fJU;
    private f fOn;
    private AlaNewSquareSubListModel fOo;
    private String fOp;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fOb = false;
    private boolean mIsInit = false;
    private AlaNewSquareSubListModel.a fOq = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void kS(boolean z) {
            OtherSubTabFragment.this.mHasMore = z;
            OtherSubTabFragment.this.mIsInit = true;
            OtherSubTabFragment.this.ki(false);
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            if (y.getCount(OtherSubTabFragment.this.fOo.getDatas()) == 0) {
                OtherSubTabFragment.this.bHm();
                return;
            }
            OtherSubTabFragment.this.fGf.setData(OtherSubTabFragment.this.fOo.getDatas());
            if (!OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.bIj();
            } else {
                OtherSubTabFragment.this.bIi();
            }
            OtherSubTabFragment.this.bHn();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void an(int i, String str) {
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            OtherSubTabFragment.this.bIk();
            OtherSubTabFragment.this.bHm();
        }
    };
    private BdListView.e Vz = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                OtherSubTabFragment.this.bIk();
            } else if (OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.fOo.bIp();
            }
        }
    };
    private final f.c fOd = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                OtherSubTabFragment.this.fOo.refreshData();
            } else {
                OtherSubTabFragment.this.ki(false);
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
                this.fJU = specialLiveTabInfo.tabName;
            } else if (specialLiveTabInfo.tabType == 2) {
                this.fJU = "游戏";
                this.fOp = specialLiveTabInfo.tabName;
            }
        }
        if (this.fOo == null) {
            this.fOo = new AlaNewSquareSubListModel(getPageContext());
            this.fOo.a(this.fOq);
        }
        this.fOo.setEntryName(this.fJU);
        this.fOo.setLabelName(this.fOp);
        this.fOo.kU(false);
        if (this.fOn == null) {
            this.fOn = new com.baidu.tieba.ala.alasquare.special_forum.a.f(getPageContext());
            this.fOn.setFrom(1);
            this.fOn.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bw bwVar) {
                    OtherSubTabFragment.this.a(OtherSubTabFragment.this.getPageContext(), bwVar, str);
                    if (bwVar != null && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new aq("c12904").dF("tid", bwVar.getTid()).dF("entryname", str));
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
            this.fGf = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.fGf.setOnSrollToBottomListener(this.Vz);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fOd);
            this.fGf.setPullRefresh(this.mPullView);
            this.fHm = new PbListView(getContext());
            this.fHm.createView();
            this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fHm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fHm.setLineGone();
            this.fHm.setTextSize(R.dimen.tbfontsize33);
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fHm.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.fOn);
            this.fGf.addAdapters(arrayList);
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
    public void bHm() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fOb) {
            this.fGf.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.fOb = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bIh() {
        super.bIh();
        if (this.fGf != null) {
            this.fGf.smoothScrollToPosition(0);
            this.fGf.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.fGf != null) {
            this.fGf.getAdapter().notifyDataSetChanged();
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
        this.fOo.refreshData();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHn() {
        if (this.fGf != null && this.mRefreshView != null) {
            this.fOb = false;
            this.fGf.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIi() {
        this.fGf.setNextPage(this.fHm);
        this.fHm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        this.fGf.setNextPage(this.fHm);
        this.fHm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.setText(getResources().getString(R.string.list_no_more));
        this.fHm.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIk() {
        this.fGf.setNextPage(this.fHm);
        this.fHm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fHm.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void ki(boolean z) {
        if (!z) {
            this.fGf.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(i);
        }
        ap.setBackgroundColor(this.fGf, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fGf != null) {
            this.fGf.setOnSrollToBottomListener(null);
            this.fGf.setScrollable(null);
        }
        if (this.fOo != null) {
            this.fOo.onDestroy();
        }
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar, String str) {
        if (tbPageContext != null && bwVar != null && bwVar.bfy() != null && bwVar.bfS() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bfy().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bfS());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bw bwVar2 : this.fOo.bIg()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_sub_tab", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bfS());
        alaLiveInfoCoreData.userName = bwVar.bfy().getUserName();
        return alaLiveInfoCoreData;
    }
}
