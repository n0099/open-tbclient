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
    private BdTypeListView ekb;
    private PbListView elj;
    private String enQ;
    private f ese;
    private AlaNewSquareSubListModel esf;
    private String esg;
    private h mPullView;
    private com.baidu.tbadk.k.h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean erS = false;
    private boolean mIsInit = false;
    private AlaNewSquareSubListModel.a esh = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ie(boolean z) {
            OtherSubTabFragment.this.mHasMore = z;
            OtherSubTabFragment.this.mIsInit = true;
            OtherSubTabFragment.this.hu(false);
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            if (v.getCount(OtherSubTabFragment.this.esf.getDatas()) == 0) {
                OtherSubTabFragment.this.bcw();
                return;
            }
            OtherSubTabFragment.this.ekb.setData(OtherSubTabFragment.this.esf.getDatas());
            if (!OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.bds();
            } else {
                OtherSubTabFragment.this.bdr();
            }
            OtherSubTabFragment.this.bcx();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void ag(int i, String str) {
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            OtherSubTabFragment.this.bdt();
            OtherSubTabFragment.this.bcw();
        }
    };
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                OtherSubTabFragment.this.bdt();
            } else if (OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.esf.bdy();
            }
        }
    };
    private final g.c erU = new g.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                OtherSubTabFragment.this.esf.refreshData();
            } else {
                OtherSubTabFragment.this.hu(false);
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
                this.enQ = specialLiveTabInfo.tabName;
            } else if (specialLiveTabInfo.tabType == 2) {
                this.enQ = "游戏";
                this.esg = specialLiveTabInfo.tabName;
            }
        }
        if (this.esf == null) {
            this.esf = new AlaNewSquareSubListModel(getPageContext());
            this.esf.a(this.esh);
        }
        this.esf.setEntryName(this.enQ);
        this.esf.setLabelName(this.esg);
        this.esf.ig(false);
        if (this.ese == null) {
            this.ese = new f(getPageContext());
            this.ese.setFrom(1);
            this.ese.b(new i() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.c.i
                public void a(int i, String str, bj bjVar) {
                    OtherSubTabFragment.this.a(OtherSubTabFragment.this.getPageContext(), bjVar, str);
                    if (bjVar != null && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new an("c12904").cy("tid", bjVar.getTid()).cy("entryname", str));
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
            this.ekb = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.ekb.setOnSrollToBottomListener(this.Az);
            this.mPullView = new h(getPageContext());
            this.mPullView.setListPullRefreshListener(this.erU);
            this.ekb.setPullRefresh(this.mPullView);
            this.elj = new PbListView(getContext());
            this.elj.createView();
            this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.elj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.elj.setLineGone();
            this.elj.setTextSize(R.dimen.tbfontsize33);
            this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elj.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.ese);
            this.ekb.addAdapters(arrayList);
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
    public void bcw() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.erS) {
            this.ekb.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.erS = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bdq() {
        super.bdq();
        if (this.ekb != null) {
            this.ekb.smoothScrollToPosition(0);
            this.ekb.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.ekb != null) {
            this.ekb.getAdapter().notifyDataSetChanged();
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
        this.esf.refreshData();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcx() {
        if (this.ekb != null && this.mRefreshView != null) {
            this.erS = false;
            this.ekb.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdr() {
        this.ekb.setNextPage(this.elj);
        this.elj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bds() {
        this.ekb.setNextPage(this.elj);
        this.elj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.setText(getResources().getString(R.string.list_no_more));
        this.elj.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdt() {
        this.ekb.setNextPage(this.elj);
        this.elj.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elj.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void hu(boolean z) {
        if (!z) {
            this.ekb.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elj != null) {
            this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elj.changeSkin(i);
        }
        am.setBackgroundColor(this.ekb, R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ekb != null) {
            this.ekb.setOnSrollToBottomListener(null);
            this.ekb.setScrollable(null);
        }
        if (this.esf != null) {
            this.esf.onDestroy();
        }
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar, String str) {
        if (tbPageContext != null && bjVar != null && bjVar.aCo() != null && bjVar.aCH() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCo().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (bj bjVar2 : this.esf.bdp()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(S(bjVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_sub_tab", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
        alaLiveInfoCoreData.userName = bjVar.aCo().getUserName();
        return alaLiveInfoCoreData;
    }
}
