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
/* loaded from: classes2.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    private BdTypeListView efW;
    private PbListView ehe;
    private String ejF;
    private f enR;
    private AlaNewSquareSubListModel enS;
    private String enT;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean enF = false;
    private boolean mIsInit = false;
    private AlaNewSquareSubListModel.a enU = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void hX(boolean z) {
            OtherSubTabFragment.this.mHasMore = z;
            OtherSubTabFragment.this.mIsInit = true;
            OtherSubTabFragment.this.hn(false);
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            if (v.getCount(OtherSubTabFragment.this.enS.getDatas()) == 0) {
                OtherSubTabFragment.this.bae();
                return;
            }
            OtherSubTabFragment.this.efW.setData(OtherSubTabFragment.this.enS.getDatas());
            if (!OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.bbb();
            } else {
                OtherSubTabFragment.this.bba();
            }
            OtherSubTabFragment.this.baf();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void af(int i, String str) {
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            OtherSubTabFragment.this.bbc();
            OtherSubTabFragment.this.bae();
        }
    };
    private BdListView.e Ah = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                OtherSubTabFragment.this.bbc();
            } else if (OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.enS.bbh();
            }
        }
    };
    private final g.c enH = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                OtherSubTabFragment.this.enS.refreshData();
            } else {
                OtherSubTabFragment.this.hn(false);
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
                this.ejF = specialLiveTabInfo.tabName;
            } else if (specialLiveTabInfo.tabType == 2) {
                this.ejF = "游戏";
                this.enT = specialLiveTabInfo.tabName;
            }
        }
        if (this.enS == null) {
            this.enS = new AlaNewSquareSubListModel(getPageContext());
            this.enS.a(this.enU);
        }
        this.enS.setEntryName(this.ejF);
        this.enS.setLabelName(this.enT);
        this.enS.hZ(false);
        if (this.enR == null) {
            this.enR = new f(getPageContext());
            this.enR.setFrom(1);
            this.enR.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bj bjVar) {
                    OtherSubTabFragment.this.a(OtherSubTabFragment.this.getPageContext(), bjVar, str);
                    if (bjVar != null && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new an("c12904").cp("tid", bjVar.getTid()).cp("entryname", str));
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
            this.efW = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.efW.setOnSrollToBottomListener(this.Ah);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.enH);
            this.efW.setPullRefresh(this.mPullView);
            this.ehe = new PbListView(getContext());
            this.ehe.createView();
            this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.ehe.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.ehe.setLineGone();
            this.ehe.setTextSize(R.dimen.tbfontsize33);
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ehe.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.enR);
            this.efW.addAdapters(arrayList);
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
    public void bae() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.enF) {
            this.efW.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.enF = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void baZ() {
        super.baZ();
        if (this.efW != null) {
            this.efW.smoothScrollToPosition(0);
            this.efW.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.efW != null) {
            this.efW.getAdapter().notifyDataSetChanged();
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
        this.enS.refreshData();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baf() {
        if (this.efW != null && this.mRefreshView != null) {
            this.enF = false;
            this.efW.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bba() {
        this.efW.setNextPage(this.ehe);
        this.ehe.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbb() {
        this.efW.setNextPage(this.ehe);
        this.ehe.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.setText(getResources().getString(R.string.list_no_more));
        this.ehe.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbc() {
        this.efW.setNextPage(this.ehe);
        this.ehe.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ehe.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void hn(boolean z) {
        if (!z) {
            this.efW.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ehe != null) {
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ehe.changeSkin(i);
        }
        am.setBackgroundColor(this.efW, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.efW != null) {
            this.efW.setOnSrollToBottomListener(null);
            this.efW.setScrollable(null);
        }
        if (this.enS != null) {
            this.enS.onDestroy();
        }
        if (this.mRootView != null) {
            hideLoadingView(this.mRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.azX() != null && bjVar.aAq() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.azX().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.enS.baY()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(R(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_sub_tab", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData R(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
        alaLiveInfoCoreData.userName = bjVar.azX().getUserName();
        return alaLiveInfoCoreData;
    }
}
