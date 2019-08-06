package com.baidu.tieba.frs.smartapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.smartapp.FrsListProgramListModel;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FrsLiteProgramListFragment extends BaseFragment {
    private PbListView dnN;
    private FrsListProgramListModel fOH;
    private a fOJ;
    private FrsListProgramListModel.a fOK;
    private BaseWebView fON;
    private String mForumId;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private View mRootView;
    private BdListView fOI = null;
    private ArrayList<b> fOL = new ArrayList<>();
    public boolean fOM = false;
    private int pageNumber = 1;
    private final BdListView.e fOO = new BdListView.e() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsLiteProgramListFragment.this.mHasMore) {
                if (FrsLiteProgramListFragment.this.dnN != null) {
                    FrsLiteProgramListFragment.this.dnN.akF();
                }
                FrsLiteProgramListFragment.g(FrsLiteProgramListFragment.this);
                FrsLiteProgramListFragment.this.t(FrsLiteProgramListFragment.this.mForumId, FrsLiteProgramListFragment.this.pageNumber, 10);
            } else if (FrsLiteProgramListFragment.this.dnN != null) {
                FrsLiteProgramListFragment.this.dnN.akH();
            }
        }
    };
    protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar;
            if (!v.aa(FrsLiteProgramListFragment.this.fOL) && (bVar = (b) FrsLiteProgramListFragment.this.fOL.get(i)) != null) {
                String str = bVar.h5_url;
                String str2 = bVar.name;
                String str3 = bVar.id;
                Long l = bVar.fOD;
                if (!com.baidu.tieba.aiapps.a.b(str3, bVar.link, "1191003700000000", bVar.bzy)) {
                    if (!StringUtils.isNULL(str)) {
                        bb.ajE().c(FrsLiteProgramListFragment.this.getPageContext(), new String[]{str});
                    } else {
                        return;
                    }
                }
                TiebaStatic.log(new an("c13274").bT("fid", FrsLiteProgramListFragment.this.mForumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", str2).l(VideoPlayActivityConfig.OBJ_ID, l.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", bVar.bzy.intValue()));
            }
        }
    };

    static /* synthetic */ int g(FrsLiteProgramListFragment frsLiteProgramListFragment) {
        int i = frsLiteProgramListFragment.pageNumber;
        frsLiteProgramListFragment.pageNumber = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.frs_lite_program_list_fragment_layout, viewGroup, false);
        bN(this.mRootView);
        if (this.fOK == null) {
            this.fOK = new FrsListProgramListModel.a() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.1
                @Override // com.baidu.tieba.frs.smartapp.FrsListProgramListModel.a
                public void a(ArrayList<b> arrayList, int i, String str, boolean z) {
                    FrsLiteProgramListFragment.this.hideLoadingView();
                    if (!v.aa(arrayList)) {
                        FrsLiteProgramListFragment.this.fOL.addAll(arrayList);
                    }
                    FrsLiteProgramListFragment.this.mHasMore = z;
                    if (v.aa(FrsLiteProgramListFragment.this.fOL)) {
                        FrsLiteProgramListFragment.this.fOI.setVisibility(8);
                        FrsLiteProgramListFragment.this.showNetRefreshView(FrsLiteProgramListFragment.this.mRootView, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(R.string.net_error_text, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(R.string.error_unkown_try_again), 0), false);
                    } else if (FrsLiteProgramListFragment.this.fOI != null) {
                        FrsLiteProgramListFragment.this.hideNetRefreshView(FrsLiteProgramListFragment.this.mRootView);
                        FrsLiteProgramListFragment.this.fOI.setVisibility(0);
                        if (FrsLiteProgramListFragment.this.fOJ != null) {
                            FrsLiteProgramListFragment.this.fOJ.setData(FrsLiteProgramListFragment.this.fOL);
                            FrsLiteProgramListFragment.this.fOJ.notifyDataSetChanged();
                        } else {
                            FrsLiteProgramListFragment.this.fOJ = new a(FrsLiteProgramListFragment.this.getPageContext());
                            FrsLiteProgramListFragment.this.fOJ.setData(FrsLiteProgramListFragment.this.fOL);
                            FrsLiteProgramListFragment.this.fOI.setAdapter((ListAdapter) FrsLiteProgramListFragment.this.fOJ);
                        }
                    }
                    if (FrsLiteProgramListFragment.this.fOI != null && FrsLiteProgramListFragment.this.dnN != null && !FrsLiteProgramListFragment.this.mHasMore) {
                        FrsLiteProgramListFragment.this.dnN.akH();
                        FrsLiteProgramListFragment.this.fOI.setNextPage(FrsLiteProgramListFragment.this.dnN);
                    }
                }
            };
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void t(String str, int i, int i2) {
        this.mForumId = str;
        if (j.kc() && !StringUtils.isNULL(this.mForumId)) {
            if (this.fOH == null) {
                this.fOH = new FrsListProgramListModel(this.fOK);
            }
            this.fOH.s(this.mForumId, i, i2);
        }
    }

    public void xD(String str) {
        this.mForumId = str;
        this.fOI.setVisibility(8);
        showNetRefreshView(this.mRootView, getPageContext().getResources().getString(R.string.net_error_text, getPageContext().getResources().getString(R.string.neterror), 0), false);
    }

    public void xE(String str) {
        this.fOI.setVisibility(8);
        this.fON.setVisibility(0);
        this.fON.loadUrl(str);
    }

    public void showLoadingView() {
        this.fOI.setVisibility(8);
        showLoadingView(this.mRootView);
    }

    public void hideLoadingView() {
        this.fOI.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    private void bN(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.smart_app));
        if (this.mNavigationBar != null && this.mNavigationBar.mCenterText != null) {
            this.mNavigationBar.mCenterText.setTextSize(getResources().getDimensionPixelSize(R.dimen.tbds18));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
            }
        });
        this.mNavigationBar.showBottomLine();
        this.fOI = (BdListView) view.findViewById(R.id.list);
        this.fON = (BaseWebView) view.findViewById(R.id.app_webView);
        this.fOI.setOnSrollToBottomListener(this.fOO);
        this.fOI.setOnItemClickListener(this.mOnItemClickListener);
        this.mNetworkView = (NoNetworkView) view.findViewById(R.id.no_network);
        this.dnN = new PbListView(getPageContext().getPageActivity());
        this.dnN.nZ();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.dnN.akC();
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnN.iT(R.color.cp_cont_e);
        this.fOI.setNextPage(this.dnN);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.support.v4.app.Fragment
    public void setInitialSavedState(Fragment.SavedState savedState) {
        if (!isAdded() && isStateSaved()) {
            super.setInitialSavedState(savedState);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.h(this.fOI, R.color.cp_bg_line_e, i);
        am.h(this.mNavigationBar, R.color.cp_bg_line_d, i);
        am.f(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
        am.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg);
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.dnN != null) {
            this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dnN.iV(i);
        }
        if (this.fOJ != null) {
            this.fOJ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kc() && !StringUtils.isNULL(this.mForumId)) {
            hideNetRefreshView(this.mRootView);
            showLoadingView();
            clear();
            t(this.mForumId, 1, 10);
        }
    }

    public void clear() {
        if (this.fOL != null) {
            this.fOL.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fOH != null) {
            this.fOH.onDestroy();
        }
        clear();
    }
}
