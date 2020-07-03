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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
    private BdTypeListView fml;
    private PbListView fnt;
    private String fqb;
    private f fuw;
    private AlaNewSquareSubListModel fux;
    private String fuy;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean fuk = false;
    private boolean mIsInit = false;
    private AlaNewSquareSubListModel.a fuz = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void jM(boolean z) {
            OtherSubTabFragment.this.mHasMore = z;
            OtherSubTabFragment.this.mIsInit = true;
            OtherSubTabFragment.this.jc(false);
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            if (w.getCount(OtherSubTabFragment.this.fux.getDatas()) == 0) {
                OtherSubTabFragment.this.btM();
                return;
            }
            OtherSubTabFragment.this.fml.setData(OtherSubTabFragment.this.fux.getDatas());
            if (!OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.buJ();
            } else {
                OtherSubTabFragment.this.buI();
            }
            OtherSubTabFragment.this.btN();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void an(int i, String str) {
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            OtherSubTabFragment.this.buK();
            OtherSubTabFragment.this.btM();
        }
    };
    private BdListView.e UJ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                OtherSubTabFragment.this.buK();
            } else if (OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.fux.buP();
            }
        }
    };
    private final f.c fum = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                OtherSubTabFragment.this.fux.refreshData();
            } else {
                OtherSubTabFragment.this.jc(false);
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
                this.fqb = specialLiveTabInfo.tabName;
            } else if (specialLiveTabInfo.tabType == 2) {
                this.fqb = "游戏";
                this.fuy = specialLiveTabInfo.tabName;
            }
        }
        if (this.fux == null) {
            this.fux = new AlaNewSquareSubListModel(getPageContext());
            this.fux.a(this.fuz);
        }
        this.fux.setEntryName(this.fqb);
        this.fux.setLabelName(this.fuy);
        this.fux.jO(false);
        if (this.fuw == null) {
            this.fuw = new com.baidu.tieba.ala.alasquare.special_forum.a.f(getPageContext());
            this.fuw.setFrom(1);
            this.fuw.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bu buVar) {
                    OtherSubTabFragment.this.a(OtherSubTabFragment.this.getPageContext(), buVar, str);
                    if (buVar != null && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new ao("c12904").dk("tid", buVar.getTid()).dk("entryname", str));
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
            arrayList.add(this.fuw);
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
    public void btM() {
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
    public void buH() {
        super.buH();
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
        this.fux.refreshData();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btN() {
        if (this.fml != null && this.mRefreshView != null) {
            this.fuk = false;
            this.fml.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buI() {
        this.fml.setNextPage(this.fnt);
        this.fnt.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buJ() {
        this.fml.setNextPage(this.fnt);
        this.fnt.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.setText(getResources().getString(R.string.list_no_more));
        this.fnt.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buK() {
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
        an.setBackgroundColor(this.fml, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fml != null) {
            this.fml.setOnSrollToBottomListener(null);
            this.fml.setScrollable(null);
        }
        if (this.fux != null) {
            this.fux.onDestroy();
        }
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bu buVar, String str) {
        if (tbPageContext != null && buVar != null && buVar.aSp() != null && buVar.aSJ() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = buVar.aSp().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bu buVar2 : this.fux.buG()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V(buVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_sub_tab", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData V(bu buVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
        alaLiveInfoCoreData.userName = buVar.aSp().getUserName();
        return alaLiveInfoCoreData;
    }
}
