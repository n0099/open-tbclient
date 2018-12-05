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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.smartapp.FrsListProgramListModel;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class FrsLiteProgramListFragment extends BaseFragment {
    private PbListView bOy;
    private FrsListProgramListModel eaX;
    private a eaZ;
    private FrsListProgramListModel.a eba;
    private BaseWebView ebd;
    private String mForumId;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private View mRootView;
    private BdListView eaY = null;
    private ArrayList<b> ebb = new ArrayList<>();
    public boolean ebc = false;
    private int pageNumber = 1;
    private final BdListView.e ebe = new BdListView.e() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsLiteProgramListFragment.this.mHasMore) {
                if (FrsLiteProgramListFragment.this.bOy != null) {
                    FrsLiteProgramListFragment.this.bOy.Fc();
                }
                FrsLiteProgramListFragment.g(FrsLiteProgramListFragment.this);
                FrsLiteProgramListFragment.this.t(FrsLiteProgramListFragment.this.mForumId, FrsLiteProgramListFragment.this.pageNumber, 10);
            } else if (FrsLiteProgramListFragment.this.bOy != null) {
                FrsLiteProgramListFragment.this.bOy.Fe();
            }
        }
    };
    protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar;
            if (!v.I(FrsLiteProgramListFragment.this.ebb) && (bVar = (b) FrsLiteProgramListFragment.this.ebb.get(i)) != null) {
                String str = bVar.h5_url;
                String str2 = bVar.name;
                String str3 = bVar.id;
                if (!com.baidu.tieba.aiapps.a.u(str3, bVar.link, "1191003700000000")) {
                    if (!StringUtils.isNULL(str)) {
                        ay.Ef().c(FrsLiteProgramListFragment.this.getPageContext(), new String[]{str});
                    } else {
                        return;
                    }
                }
                TiebaStatic.log(new am("c13274").aA(ImageViewerConfig.FORUM_ID, FrsLiteProgramListFragment.this.mForumId).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_name", str2).aA(VideoPlayActivityConfig.OBJ_ID, str3).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
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
        this.mRootView = layoutInflater.inflate(e.h.frs_lite_program_list_fragment_layout, viewGroup, false);
        aI(this.mRootView);
        if (this.eba == null) {
            this.eba = new FrsListProgramListModel.a() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.1
                @Override // com.baidu.tieba.frs.smartapp.FrsListProgramListModel.a
                public void a(ArrayList<b> arrayList, int i, String str, boolean z) {
                    FrsLiteProgramListFragment.this.hideLoadingView();
                    if (!v.I(arrayList)) {
                        FrsLiteProgramListFragment.this.ebb.addAll(arrayList);
                    }
                    FrsLiteProgramListFragment.this.mHasMore = z;
                    if (v.I(FrsLiteProgramListFragment.this.ebb)) {
                        FrsLiteProgramListFragment.this.eaY.setVisibility(8);
                        FrsLiteProgramListFragment.this.showNetRefreshView(FrsLiteProgramListFragment.this.mRootView, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(e.j.net_error_text, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(e.j.error_unkown_try_again), 0), false);
                    } else if (FrsLiteProgramListFragment.this.eaY != null) {
                        FrsLiteProgramListFragment.this.hideNetRefreshView(FrsLiteProgramListFragment.this.mRootView);
                        FrsLiteProgramListFragment.this.eaY.setVisibility(0);
                        if (FrsLiteProgramListFragment.this.eaZ != null) {
                            FrsLiteProgramListFragment.this.eaZ.setData(FrsLiteProgramListFragment.this.ebb);
                            FrsLiteProgramListFragment.this.eaZ.notifyDataSetChanged();
                        } else {
                            FrsLiteProgramListFragment.this.eaZ = new a(FrsLiteProgramListFragment.this.getPageContext());
                            FrsLiteProgramListFragment.this.eaZ.setData(FrsLiteProgramListFragment.this.ebb);
                            FrsLiteProgramListFragment.this.eaY.setAdapter((ListAdapter) FrsLiteProgramListFragment.this.eaZ);
                        }
                    }
                    if (FrsLiteProgramListFragment.this.eaY != null && FrsLiteProgramListFragment.this.bOy != null && !FrsLiteProgramListFragment.this.mHasMore) {
                        FrsLiteProgramListFragment.this.bOy.Fe();
                        FrsLiteProgramListFragment.this.eaY.setNextPage(FrsLiteProgramListFragment.this.bOy);
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
        if (j.kV() && !StringUtils.isNULL(this.mForumId)) {
            if (this.eaX == null) {
                this.eaX = new FrsListProgramListModel(this.eba);
            }
            this.eaX.s(this.mForumId, i, i2);
        }
    }

    public void oF(String str) {
        this.mForumId = str;
        this.eaY.setVisibility(8);
        showNetRefreshView(this.mRootView, getPageContext().getResources().getString(e.j.net_error_text, getPageContext().getResources().getString(e.j.neterror), 0), false);
    }

    public void oG(String str) {
        this.eaY.setVisibility(8);
        this.ebd.setVisibility(0);
        this.ebd.loadUrl(str);
    }

    public void showLoadingView() {
        this.eaY.setVisibility(8);
        showLoadingView(this.mRootView);
    }

    public void hideLoadingView() {
        this.eaY.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    private void aI(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.smart_app));
        if (this.mNavigationBar != null && this.mNavigationBar.mCenterText != null) {
            this.mNavigationBar.mCenterText.setTextSize(getResources().getDimensionPixelSize(e.C0210e.tbds18));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
            }
        });
        this.mNavigationBar.showBottomLine();
        this.eaY = (BdListView) view.findViewById(e.g.list);
        this.ebd = (BaseWebView) view.findViewById(e.g.app_webView);
        this.eaY.setOnSrollToBottomListener(this.ebe);
        this.eaY.setOnItemClickListener(this.mOnItemClickListener);
        this.mNetworkView = (NoNetworkView) view.findViewById(e.g.no_network);
        this.bOy = new PbListView(getPageContext().getPageActivity());
        this.bOy.oD();
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.setHeight(l.h(getActivity(), e.C0210e.tbds182));
        this.bOy.EZ();
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOy.ew(e.d.cp_cont_e);
        this.eaY.setNextPage(this.bOy);
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
        al.e(this.eaY, e.d.cp_bg_line_e, i);
        al.e(this.mNavigationBar, e.d.cp_bg_line_d, i);
        al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_b, 1);
        al.a(this.mNavigationBar.getBackImageView(), e.f.icon_return_bg_s, e.f.icon_return_bg);
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.bOy != null) {
            this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOy.ey(i);
        }
        if (this.eaZ != null) {
            this.eaZ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kV() && !StringUtils.isNULL(this.mForumId)) {
            hideNetRefreshView(this.mRootView);
            showLoadingView();
            clear();
            t(this.mForumId, 1, 10);
        }
    }

    public void clear() {
        if (this.ebb != null) {
            this.ebb.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eaX != null) {
            this.eaX.onDestroy();
        }
        clear();
    }
}
