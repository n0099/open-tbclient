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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes3.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView fbb;
    private PbListView fcj;
    private String feQ;
    private f fjj;
    private AlaNewSquareSubListModel fjk;
    private String fjl;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fiX = false;
    private boolean mIsInit = false;
    private AlaNewSquareSubListModel.a fjm = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void jz(boolean z) {
            OtherSubTabFragment.this.mHasMore = z;
            OtherSubTabFragment.this.mIsInit = true;
            OtherSubTabFragment.this.iQ(false);
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            if (v.getCount(OtherSubTabFragment.this.fjk.getDatas()) == 0) {
                OtherSubTabFragment.this.bqP();
                return;
            }
            OtherSubTabFragment.this.fbb.setData(OtherSubTabFragment.this.fjk.getDatas());
            if (!OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.brN();
            } else {
                OtherSubTabFragment.this.brM();
            }
            OtherSubTabFragment.this.bqQ();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void al(int i, String str) {
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            OtherSubTabFragment.this.brO();
            OtherSubTabFragment.this.bqP();
        }
    };
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                OtherSubTabFragment.this.brO();
            } else if (OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.fjk.brT();
            }
        }
    };
    private final f.c fiZ = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                OtherSubTabFragment.this.fjk.refreshData();
            } else {
                OtherSubTabFragment.this.iQ(false);
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
                this.feQ = specialLiveTabInfo.tabName;
            } else if (specialLiveTabInfo.tabType == 2) {
                this.feQ = "游戏";
                this.fjl = specialLiveTabInfo.tabName;
            }
        }
        if (this.fjk == null) {
            this.fjk = new AlaNewSquareSubListModel(getPageContext());
            this.fjk.a(this.fjm);
        }
        this.fjk.setEntryName(this.feQ);
        this.fjk.setLabelName(this.fjl);
        this.fjk.jB(false);
        if (this.fjj == null) {
            this.fjj = new com.baidu.tieba.ala.alasquare.special_forum.a.f(getPageContext());
            this.fjj.setFrom(1);
            this.fjj.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bk bkVar) {
                    OtherSubTabFragment.this.a(OtherSubTabFragment.this.getPageContext(), bkVar, str);
                    if (bkVar != null && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new an("c12904").dh("tid", bkVar.getTid()).dh("entryname", str));
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
            this.fbb = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.fbb.setOnSrollToBottomListener(this.Uf);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.fiZ);
            this.fbb.setPullRefresh(this.mPullView);
            this.fcj = new PbListView(getContext());
            this.fcj.createView();
            this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fcj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fcj.setLineGone();
            this.fcj.setTextSize(R.dimen.tbfontsize33);
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fcj.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.fjj);
            this.fbb.addAdapters(arrayList);
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
    public void bqP() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.fiX) {
            this.fbb.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.fiX = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void brL() {
        super.brL();
        if (this.fbb != null) {
            this.fbb.smoothScrollToPosition(0);
            this.fbb.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.fbb != null) {
            this.fbb.getAdapter().notifyDataSetChanged();
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
        this.fjk.refreshData();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqQ() {
        if (this.fbb != null && this.mRefreshView != null) {
            this.fiX = false;
            this.fbb.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brM() {
        this.fbb.setNextPage(this.fcj);
        this.fcj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brN() {
        this.fbb.setNextPage(this.fcj);
        this.fcj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.setText(getResources().getString(R.string.list_no_more));
        this.fcj.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brO() {
        this.fbb.setNextPage(this.fcj);
        this.fcj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fcj.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void iQ(boolean z) {
        if (!z) {
            this.fbb.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.changeSkin(i);
        }
        am.setBackgroundColor(this.fbb, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fbb != null) {
            this.fbb.setOnSrollToBottomListener(null);
            this.fbb.setScrollable(null);
        }
        if (this.fjk != null) {
            this.fjk.onDestroy();
        }
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bk bkVar, String str) {
        if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bkVar.aQx().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bk bkVar2 : this.fjk.brK()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(U(bkVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_sub_tab", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData U(bk bkVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
        alaLiveInfoCoreData.userName = bkVar.aQx().getUserName();
        return alaLiveInfoCoreData;
    }
}
