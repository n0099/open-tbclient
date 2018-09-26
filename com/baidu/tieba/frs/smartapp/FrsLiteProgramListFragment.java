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
/* loaded from: classes2.dex */
public class FrsLiteProgramListFragment extends BaseFragment {
    private PbListView bBr;
    private FrsListProgramListModel dLr;
    private a dLt;
    private FrsListProgramListModel.a dLu;
    private BaseWebView dLx;
    private String mForumId;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private View mRootView;
    private BdListView dLs = null;
    private ArrayList<b> dLv = new ArrayList<>();
    public boolean dLw = false;
    private int pageNumber = 1;
    private final BdListView.e dLy = new BdListView.e() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsLiteProgramListFragment.this.mHasMore) {
                if (FrsLiteProgramListFragment.this.bBr != null) {
                    FrsLiteProgramListFragment.this.bBr.BI();
                }
                FrsLiteProgramListFragment.g(FrsLiteProgramListFragment.this);
                FrsLiteProgramListFragment.this.r(FrsLiteProgramListFragment.this.mForumId, FrsLiteProgramListFragment.this.pageNumber, 10);
            } else if (FrsLiteProgramListFragment.this.bBr != null) {
                FrsLiteProgramListFragment.this.bBr.BK();
            }
        }
    };
    protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!v.z(FrsLiteProgramListFragment.this.dLv)) {
                String str = ((b) FrsLiteProgramListFragment.this.dLv.get(i)).h5_url;
                String str2 = ((b) FrsLiteProgramListFragment.this.dLv.get(i)).name;
                String str3 = ((b) FrsLiteProgramListFragment.this.dLv.get(i)).id;
                if (!StringUtils.isNULL(str)) {
                    ay.AN().c(FrsLiteProgramListFragment.this.getPageContext(), new String[]{str});
                    TiebaStatic.log(new am("c13274").al(ImageViewerConfig.FORUM_ID, FrsLiteProgramListFragment.this.mForumId).al("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_name", str2).al(VideoPlayActivityConfig.OBJ_ID, str3).al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
                }
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
        aG(this.mRootView);
        if (this.dLu == null) {
            this.dLu = new FrsListProgramListModel.a() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.1
                @Override // com.baidu.tieba.frs.smartapp.FrsListProgramListModel.a
                public void a(ArrayList<b> arrayList, int i, String str, boolean z) {
                    FrsLiteProgramListFragment.this.hideLoadingView();
                    if (!v.z(arrayList)) {
                        FrsLiteProgramListFragment.this.dLv.addAll(arrayList);
                    }
                    FrsLiteProgramListFragment.this.mHasMore = z;
                    if (v.z(FrsLiteProgramListFragment.this.dLv)) {
                        FrsLiteProgramListFragment.this.dLs.setVisibility(8);
                        FrsLiteProgramListFragment.this.showNetRefreshView(FrsLiteProgramListFragment.this.mRootView, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(e.j.net_error_text, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(e.j.error_unkown_try_again), 0), false);
                    } else if (FrsLiteProgramListFragment.this.dLs != null) {
                        FrsLiteProgramListFragment.this.hideNetRefreshView(FrsLiteProgramListFragment.this.mRootView);
                        FrsLiteProgramListFragment.this.dLs.setVisibility(0);
                        if (FrsLiteProgramListFragment.this.dLt != null) {
                            FrsLiteProgramListFragment.this.dLt.setData(FrsLiteProgramListFragment.this.dLv);
                            FrsLiteProgramListFragment.this.dLt.notifyDataSetChanged();
                        } else {
                            FrsLiteProgramListFragment.this.dLt = new a(FrsLiteProgramListFragment.this.getPageContext());
                            FrsLiteProgramListFragment.this.dLt.setData(FrsLiteProgramListFragment.this.dLv);
                            FrsLiteProgramListFragment.this.dLs.setAdapter((ListAdapter) FrsLiteProgramListFragment.this.dLt);
                        }
                    }
                    if (FrsLiteProgramListFragment.this.dLs != null && FrsLiteProgramListFragment.this.bBr != null && !FrsLiteProgramListFragment.this.mHasMore) {
                        FrsLiteProgramListFragment.this.bBr.BK();
                        FrsLiteProgramListFragment.this.dLs.setNextPage(FrsLiteProgramListFragment.this.bBr);
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

    public void r(String str, int i, int i2) {
        this.mForumId = str;
        if (j.kK() && !StringUtils.isNULL(this.mForumId)) {
            if (this.dLr == null) {
                this.dLr = new FrsListProgramListModel(this.dLu);
            }
            this.dLr.q(this.mForumId, i, i2);
        }
    }

    public void nB(String str) {
        this.mForumId = str;
        this.dLs.setVisibility(8);
        showNetRefreshView(this.mRootView, getPageContext().getResources().getString(e.j.net_error_text, getPageContext().getResources().getString(e.j.neterror), 0), false);
    }

    public void nC(String str) {
        this.dLs.setVisibility(8);
        this.dLx.setVisibility(0);
        this.dLx.loadUrl(str);
    }

    public void showLoadingView() {
        this.dLs.setVisibility(8);
        showLoadingView(this.mRootView);
    }

    public void hideLoadingView() {
        this.dLs.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    private void aG(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.smart_app));
        if (this.mNavigationBar != null && this.mNavigationBar.mCenterText != null) {
            this.mNavigationBar.mCenterText.setTextSize(getResources().getDimensionPixelSize(e.C0141e.tbds18));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921366));
            }
        });
        this.mNavigationBar.showBottomLine();
        this.dLs = (BdListView) view.findViewById(e.g.list);
        this.dLx = (BaseWebView) view.findViewById(e.g.app_webView);
        this.dLs.setOnSrollToBottomListener(this.dLy);
        this.dLs.setOnItemClickListener(this.mOnItemClickListener);
        this.mNetworkView = (NoNetworkView) view.findViewById(e.g.no_network);
        this.bBr = new PbListView(getPageContext().getPageActivity());
        this.bBr.ov();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.setHeight(l.h(getActivity(), e.C0141e.tbds182));
        this.bBr.BF();
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bBr.dK(e.d.cp_cont_e);
        this.dLs.setNextPage(this.bBr);
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
        al.e(this.dLs, e.d.cp_bg_line_e, i);
        al.e(this.mNavigationBar, e.d.cp_bg_line_d, i);
        al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_b, 1);
        al.a(this.mNavigationBar.getBackImageView(), e.f.icon_return_bg_s, e.f.icon_return_bg);
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.bBr != null) {
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bBr.dM(i);
        }
        if (this.dLt != null) {
            this.dLt.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kK() && !StringUtils.isNULL(this.mForumId)) {
            hideNetRefreshView(this.mRootView);
            showLoadingView();
            clear();
            r(this.mForumId, 1, 10);
        }
    }

    public void clear() {
        if (this.dLv != null) {
            this.dLv.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dLr != null) {
            this.dLr.onDestroy();
        }
        clear();
    }
}
