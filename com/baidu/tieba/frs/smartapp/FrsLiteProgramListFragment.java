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
    private PbListView dbn;
    private FrsListProgramListModel fsK;
    private a fsM;
    private FrsListProgramListModel.a fsN;
    private BaseWebView fsQ;
    private String mForumId;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private View mRootView;
    private BdListView fsL = null;
    private ArrayList<b> fsO = new ArrayList<>();
    public boolean fsP = false;
    private int pageNumber = 1;
    private final BdListView.e fsR = new BdListView.e() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsLiteProgramListFragment.this.mHasMore) {
                if (FrsLiteProgramListFragment.this.dbn != null) {
                    FrsLiteProgramListFragment.this.dbn.aeC();
                }
                FrsLiteProgramListFragment.g(FrsLiteProgramListFragment.this);
                FrsLiteProgramListFragment.this.t(FrsLiteProgramListFragment.this.mForumId, FrsLiteProgramListFragment.this.pageNumber, 10);
            } else if (FrsLiteProgramListFragment.this.dbn != null) {
                FrsLiteProgramListFragment.this.dbn.aeE();
            }
        }
    };
    protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar;
            if (!v.T(FrsLiteProgramListFragment.this.fsO) && (bVar = (b) FrsLiteProgramListFragment.this.fsO.get(i)) != null) {
                String str = bVar.h5_url;
                String str2 = bVar.name;
                String str3 = bVar.id;
                if (!com.baidu.tieba.aiapps.a.H(str3, bVar.link, "1191003700000000")) {
                    if (!StringUtils.isNULL(str)) {
                        ba.adD().c(FrsLiteProgramListFragment.this.getPageContext(), new String[]{str});
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
        if (this.fsN == null) {
            this.fsN = new FrsListProgramListModel.a() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.1
                @Override // com.baidu.tieba.frs.smartapp.FrsListProgramListModel.a
                public void a(ArrayList<b> arrayList, int i, String str, boolean z) {
                    FrsLiteProgramListFragment.this.hideLoadingView();
                    if (!v.T(arrayList)) {
                        FrsLiteProgramListFragment.this.fsO.addAll(arrayList);
                    }
                    FrsLiteProgramListFragment.this.mHasMore = z;
                    if (v.T(FrsLiteProgramListFragment.this.fsO)) {
                        FrsLiteProgramListFragment.this.fsL.setVisibility(8);
                        FrsLiteProgramListFragment.this.showNetRefreshView(FrsLiteProgramListFragment.this.mRootView, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(d.j.net_error_text, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(d.j.error_unkown_try_again), 0), false);
                    } else if (FrsLiteProgramListFragment.this.fsL != null) {
                        FrsLiteProgramListFragment.this.hideNetRefreshView(FrsLiteProgramListFragment.this.mRootView);
                        FrsLiteProgramListFragment.this.fsL.setVisibility(0);
                        if (FrsLiteProgramListFragment.this.fsM != null) {
                            FrsLiteProgramListFragment.this.fsM.setData(FrsLiteProgramListFragment.this.fsO);
                            FrsLiteProgramListFragment.this.fsM.notifyDataSetChanged();
                        } else {
                            FrsLiteProgramListFragment.this.fsM = new a(FrsLiteProgramListFragment.this.getPageContext());
                            FrsLiteProgramListFragment.this.fsM.setData(FrsLiteProgramListFragment.this.fsO);
                            FrsLiteProgramListFragment.this.fsL.setAdapter((ListAdapter) FrsLiteProgramListFragment.this.fsM);
                        }
                    }
                    if (FrsLiteProgramListFragment.this.fsL != null && FrsLiteProgramListFragment.this.dbn != null && !FrsLiteProgramListFragment.this.mHasMore) {
                        FrsLiteProgramListFragment.this.dbn.aeE();
                        FrsLiteProgramListFragment.this.fsL.setNextPage(FrsLiteProgramListFragment.this.dbn);
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
            if (this.fsK == null) {
                this.fsK = new FrsListProgramListModel(this.fsN);
            }
            this.fsK.s(this.mForumId, i, i2);
        }
    }

    public void vD(String str) {
        this.mForumId = str;
        this.fsL.setVisibility(8);
        showNetRefreshView(this.mRootView, getPageContext().getResources().getString(d.j.net_error_text, getPageContext().getResources().getString(d.j.neterror), 0), false);
    }

    public void vE(String str) {
        this.fsL.setVisibility(8);
        this.fsQ.setVisibility(0);
        this.fsQ.loadUrl(str);
    }

    public void showLoadingView() {
        this.fsL.setVisibility(8);
        showLoadingView(this.mRootView);
    }

    public void hideLoadingView() {
        this.fsL.setVisibility(0);
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
        this.fsL = (BdListView) view.findViewById(d.g.list);
        this.fsQ = (BaseWebView) view.findViewById(d.g.app_webView);
        this.fsL.setOnSrollToBottomListener(this.fsR);
        this.fsL.setOnItemClickListener(this.mOnItemClickListener);
        this.mNetworkView = (NoNetworkView) view.findViewById(d.g.no_network);
        this.dbn = new PbListView(getPageContext().getPageActivity());
        this.dbn.oM();
        this.dbn.ib(d.C0277d.cp_bg_line_e);
        this.dbn.setHeight(l.h(getActivity(), d.e.tbds182));
        this.dbn.aez();
        this.dbn.setTextSize(d.e.tbfontsize33);
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbn.ia(d.C0277d.cp_cont_e);
        this.fsL.setNextPage(this.dbn);
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
        al.f(this.fsL, d.C0277d.cp_bg_line_e, i);
        al.f(this.mNavigationBar, d.C0277d.cp_bg_line_d, i);
        al.d(this.mNavigationBar.mCenterText, d.C0277d.cp_cont_b, 1);
        al.a(this.mNavigationBar.getBackImageView(), d.f.icon_return_bg_s, d.f.icon_return_bg);
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.dbn != null) {
            this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbn.ic(i);
        }
        if (this.fsM != null) {
            this.fsM.notifyDataSetChanged();
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
        if (this.fsO != null) {
            this.fsO.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fsK != null) {
            this.fsK.onDestroy();
        }
        clear();
    }
}
