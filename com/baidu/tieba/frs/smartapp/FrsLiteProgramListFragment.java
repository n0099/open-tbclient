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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.smartapp.FrsListProgramListModel;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FrsLiteProgramListFragment extends BaseFragment {
    private PbListView dbs;
    private BaseWebView fsC;
    private FrsListProgramListModel fsw;
    private a fsy;
    private FrsListProgramListModel.a fsz;
    private String mForumId;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private View mRootView;
    private BdListView fsx = null;
    private ArrayList<b> fsA = new ArrayList<>();
    public boolean fsB = false;
    private int pageNumber = 1;
    private final BdListView.e fsD = new BdListView.e() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsLiteProgramListFragment.this.mHasMore) {
                if (FrsLiteProgramListFragment.this.dbs != null) {
                    FrsLiteProgramListFragment.this.dbs.aez();
                }
                FrsLiteProgramListFragment.g(FrsLiteProgramListFragment.this);
                FrsLiteProgramListFragment.this.t(FrsLiteProgramListFragment.this.mForumId, FrsLiteProgramListFragment.this.pageNumber, 10);
            } else if (FrsLiteProgramListFragment.this.dbs != null) {
                FrsLiteProgramListFragment.this.dbs.aeB();
            }
        }
    };
    protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar;
            if (!v.T(FrsLiteProgramListFragment.this.fsA) && (bVar = (b) FrsLiteProgramListFragment.this.fsA.get(i)) != null) {
                String str = bVar.h5_url;
                String str2 = bVar.name;
                String str3 = bVar.id;
                if (!com.baidu.tieba.aiapps.a.H(str3, bVar.link, "1191003700000000")) {
                    if (!StringUtils.isNULL(str)) {
                        ba.adA().c(FrsLiteProgramListFragment.this.getPageContext(), new String[]{str});
                    } else {
                        return;
                    }
                }
                TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, FrsLiteProgramListFragment.this.mForumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", str2).bJ(VideoPlayActivityConfig.OBJ_ID, str3).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
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
        this.mRootView = layoutInflater.inflate(d.h.frs_lite_program_list_fragment_layout, viewGroup, false);
        bD(this.mRootView);
        if (this.fsz == null) {
            this.fsz = new FrsListProgramListModel.a() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.1
                @Override // com.baidu.tieba.frs.smartapp.FrsListProgramListModel.a
                public void a(ArrayList<b> arrayList, int i, String str, boolean z) {
                    FrsLiteProgramListFragment.this.hideLoadingView();
                    if (!v.T(arrayList)) {
                        FrsLiteProgramListFragment.this.fsA.addAll(arrayList);
                    }
                    FrsLiteProgramListFragment.this.mHasMore = z;
                    if (v.T(FrsLiteProgramListFragment.this.fsA)) {
                        FrsLiteProgramListFragment.this.fsx.setVisibility(8);
                        FrsLiteProgramListFragment.this.showNetRefreshView(FrsLiteProgramListFragment.this.mRootView, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(d.j.net_error_text, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(d.j.error_unkown_try_again), 0), false);
                    } else if (FrsLiteProgramListFragment.this.fsx != null) {
                        FrsLiteProgramListFragment.this.hideNetRefreshView(FrsLiteProgramListFragment.this.mRootView);
                        FrsLiteProgramListFragment.this.fsx.setVisibility(0);
                        if (FrsLiteProgramListFragment.this.fsy != null) {
                            FrsLiteProgramListFragment.this.fsy.setData(FrsLiteProgramListFragment.this.fsA);
                            FrsLiteProgramListFragment.this.fsy.notifyDataSetChanged();
                        } else {
                            FrsLiteProgramListFragment.this.fsy = new a(FrsLiteProgramListFragment.this.getPageContext());
                            FrsLiteProgramListFragment.this.fsy.setData(FrsLiteProgramListFragment.this.fsA);
                            FrsLiteProgramListFragment.this.fsx.setAdapter((ListAdapter) FrsLiteProgramListFragment.this.fsy);
                        }
                    }
                    if (FrsLiteProgramListFragment.this.fsx != null && FrsLiteProgramListFragment.this.dbs != null && !FrsLiteProgramListFragment.this.mHasMore) {
                        FrsLiteProgramListFragment.this.dbs.aeB();
                        FrsLiteProgramListFragment.this.fsx.setNextPage(FrsLiteProgramListFragment.this.dbs);
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
        if (j.kY() && !StringUtils.isNULL(this.mForumId)) {
            if (this.fsw == null) {
                this.fsw = new FrsListProgramListModel(this.fsz);
            }
            this.fsw.s(this.mForumId, i, i2);
        }
    }

    public void vC(String str) {
        this.mForumId = str;
        this.fsx.setVisibility(8);
        showNetRefreshView(this.mRootView, getPageContext().getResources().getString(d.j.net_error_text, getPageContext().getResources().getString(d.j.neterror), 0), false);
    }

    public void vD(String str) {
        this.fsx.setVisibility(8);
        this.fsC.setVisibility(0);
        this.fsC.loadUrl(str);
    }

    public void showLoadingView() {
        this.fsx.setVisibility(8);
        showLoadingView(this.mRootView);
    }

    public void hideLoadingView() {
        this.fsx.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    private void bD(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.smart_app));
        if (this.mNavigationBar != null && this.mNavigationBar.mCenterText != null) {
            this.mNavigationBar.mCenterText.setTextSize(getResources().getDimensionPixelSize(d.e.tbds18));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
            }
        });
        this.mNavigationBar.showBottomLine();
        this.fsx = (BdListView) view.findViewById(d.g.list);
        this.fsC = (BaseWebView) view.findViewById(d.g.app_webView);
        this.fsx.setOnSrollToBottomListener(this.fsD);
        this.fsx.setOnItemClickListener(this.mOnItemClickListener);
        this.mNetworkView = (NoNetworkView) view.findViewById(d.g.no_network);
        this.dbs = new PbListView(getPageContext().getPageActivity());
        this.dbs.oM();
        this.dbs.ia(d.C0277d.cp_bg_line_e);
        this.dbs.setHeight(l.h(getActivity(), d.e.tbds182));
        this.dbs.aew();
        this.dbs.setTextSize(d.e.tbfontsize33);
        this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbs.hZ(d.C0277d.cp_cont_e);
        this.fsx.setNextPage(this.dbs);
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
        al.f(this.fsx, d.C0277d.cp_bg_line_e, i);
        al.f(this.mNavigationBar, d.C0277d.cp_bg_line_d, i);
        al.d(this.mNavigationBar.mCenterText, d.C0277d.cp_cont_b, 1);
        al.a(this.mNavigationBar.getBackImageView(), d.f.icon_return_bg_s, d.f.icon_return_bg);
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.dbs != null) {
            this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbs.ib(i);
        }
        if (this.fsy != null) {
            this.fsy.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kY() && !StringUtils.isNULL(this.mForumId)) {
            hideNetRefreshView(this.mRootView);
            showLoadingView();
            clear();
            t(this.mForumId, 1, 10);
        }
    }

    public void clear() {
        if (this.fsA != null) {
            this.fsA.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fsw != null) {
            this.fsw.onDestroy();
        }
        clear();
    }
}
