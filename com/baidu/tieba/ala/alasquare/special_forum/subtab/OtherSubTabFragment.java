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
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    private PbListView gAw;
    private String gDl;
    private f gHJ;
    private AlaNewSquareSubListModel gHK;
    private String gHL;
    private BdTypeListView gzp;
    private g mPullView;
    private h mRefreshView;
    private View mRootView;
    private boolean mHasMore = true;
    private boolean gHx = false;
    private boolean mIsInit = false;
    private AlaNewSquareSubListModel.a gHM = new AlaNewSquareSubListModel.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.2
        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void mK(boolean z) {
            OtherSubTabFragment.this.mHasMore = z;
            OtherSubTabFragment.this.mIsInit = true;
            OtherSubTabFragment.this.lU(false);
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            if (y.getCount(OtherSubTabFragment.this.gHK.getDatas()) == 0) {
                OtherSubTabFragment.this.bRB();
                return;
            }
            OtherSubTabFragment.this.gzp.setData(OtherSubTabFragment.this.gHK.getDatas());
            if (!OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.WY();
            } else {
                OtherSubTabFragment.this.WX();
            }
            OtherSubTabFragment.this.WZ();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.a
        public void aJ(int i, String str) {
            OtherSubTabFragment.this.hideLoadingView(OtherSubTabFragment.this.mRootView);
            OtherSubTabFragment.this.bSy();
            OtherSubTabFragment.this.bRB();
        }
    };
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (!l.isNetOk()) {
                OtherSubTabFragment.this.bSy();
            } else if (OtherSubTabFragment.this.mHasMore) {
                OtherSubTabFragment.this.gHK.bSD();
            }
        }
    };
    private final f.c gHz = new f.c() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (j.isNetWorkAvailable()) {
                OtherSubTabFragment.this.gHK.refreshData();
            } else {
                OtherSubTabFragment.this.lU(false);
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
                this.gDl = specialLiveTabInfo.tabName;
            } else if (specialLiveTabInfo.tabType == 2) {
                this.gDl = "游戏";
                this.gHL = specialLiveTabInfo.tabName;
            }
        }
        if (this.gHK == null) {
            this.gHK = new AlaNewSquareSubListModel(getPageContext());
            this.gHK.a(this.gHM);
        }
        this.gHK.setEntryName(this.gDl);
        this.gHK.setLabelName(this.gHL);
        this.gHK.mM(false);
        if (this.gHJ == null) {
            this.gHJ = new com.baidu.tieba.ala.alasquare.special_forum.a.f(getPageContext());
            this.gHJ.setFrom(1);
            this.gHJ.b(new com.baidu.tieba.ala.alasquare.subtablist.view.g() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.OtherSubTabFragment.1
                @Override // com.baidu.tieba.ala.alasquare.subtablist.view.g
                public void a(int i, String str, cb cbVar) {
                    OtherSubTabFragment.this.a(OtherSubTabFragment.this.getPageContext(), cbVar, str);
                    if (cbVar != null && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new ar("c12904").dR("tid", cbVar.getTid()).dR("entryname", str));
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
            this.gzp = (BdTypeListView) this.mRootView.findViewById(R.id.content_thread);
            this.gzp.setOnSrollToBottomListener(this.WH);
            this.mPullView = new g(getPageContext());
            this.mPullView.setListPullRefreshListener(this.gHz);
            this.gzp.setPullRefresh(this.mPullView);
            this.gAw = new PbListView(getContext());
            this.gAw.createView();
            this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gAw.setLineGone();
            this.gAw.setTextSize(R.dimen.tbfontsize33);
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gAw.getView().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.gHJ);
            this.gzp.addAdapters(arrayList);
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
    public void bRB() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.showRefreshButton();
            this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.mRefreshView.onChangeSkinType();
        if (!this.gHx) {
            this.gzp.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            this.gHx = true;
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void bSx() {
        super.bSx();
        if (this.gzp != null) {
            this.gzp.smoothScrollToPosition(0);
            this.gzp.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    protected void notifyDataSetChanged() {
        if (this.gzp != null) {
            this.gzp.getAdapter().notifyDataSetChanged();
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
        this.gHK.refreshData();
        showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        if (this.gzp != null && this.mRefreshView != null) {
            this.gHx = false;
            this.gzp.removeHeaderView(this.mRefreshView.getAttachedView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WX() {
        this.gzp.setNextPage(this.gAw);
        this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WY() {
        this.gzp.setNextPage(this.gAw);
        this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.setText(getResources().getString(R.string.list_no_more));
        this.gAw.endLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSy() {
        this.gzp.setNextPage(this.gAw);
        this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.gAw.hideWithoutEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void lU(boolean z) {
        if (!z) {
            this.gzp.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.changeSkin(i);
        }
        ap.setBackgroundColor(this.gzp, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gzp != null) {
            this.gzp.setOnSrollToBottomListener(null);
            this.gzp.setScrollable(null);
        }
        if (this.gHK != null) {
            this.gHK.onDestroy();
        }
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, cb cbVar, String str) {
        if (tbPageContext != null && cbVar != null && cbVar.bnQ() != null && cbVar.boj() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnQ().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (cb cbVar2 : this.gHK.bSw()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(W(cbVar2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "frs_live_tab_sub_tab", str2, z, "颜值".equals(str) ? str : null, null)));
        }
    }

    private AlaLiveInfoCoreData W(cb cbVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
        alaLiveInfoCoreData.userName = cbVar.bnQ().getUserName();
        return alaLiveInfoCoreData;
    }
}
