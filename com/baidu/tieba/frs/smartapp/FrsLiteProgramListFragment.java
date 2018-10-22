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
    private PbListView bJY;
    private FrsListProgramListModel dTo;
    private a dTq;
    private FrsListProgramListModel.a dTr;
    private BaseWebView dTu;
    private String mForumId;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private View mRootView;
    private BdListView dTp = null;
    private ArrayList<b> dTs = new ArrayList<>();
    public boolean dTt = false;
    private int pageNumber = 1;
    private final BdListView.e dTv = new BdListView.e() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsLiteProgramListFragment.this.mHasMore) {
                if (FrsLiteProgramListFragment.this.bJY != null) {
                    FrsLiteProgramListFragment.this.bJY.DO();
                }
                FrsLiteProgramListFragment.g(FrsLiteProgramListFragment.this);
                FrsLiteProgramListFragment.this.r(FrsLiteProgramListFragment.this.mForumId, FrsLiteProgramListFragment.this.pageNumber, 10);
            } else if (FrsLiteProgramListFragment.this.bJY != null) {
                FrsLiteProgramListFragment.this.bJY.DQ();
            }
        }
    };
    protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar;
            if (!v.J(FrsLiteProgramListFragment.this.dTs) && (bVar = (b) FrsLiteProgramListFragment.this.dTs.get(i)) != null) {
                String str = bVar.h5_url;
                String str2 = bVar.name;
                String str3 = bVar.id;
                if (!com.baidu.tieba.aiapps.a.u(str3, bVar.link, "1191003700000000")) {
                    if (!StringUtils.isNULL(str)) {
                        ay.CU().c(FrsLiteProgramListFragment.this.getPageContext(), new String[]{str});
                    } else {
                        return;
                    }
                }
                TiebaStatic.log(new am("c13274").ax(ImageViewerConfig.FORUM_ID, FrsLiteProgramListFragment.this.mForumId).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_name", str2).ax(VideoPlayActivityConfig.OBJ_ID, str3).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
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
        if (this.dTr == null) {
            this.dTr = new FrsListProgramListModel.a() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.1
                @Override // com.baidu.tieba.frs.smartapp.FrsListProgramListModel.a
                public void a(ArrayList<b> arrayList, int i, String str, boolean z) {
                    FrsLiteProgramListFragment.this.hideLoadingView();
                    if (!v.J(arrayList)) {
                        FrsLiteProgramListFragment.this.dTs.addAll(arrayList);
                    }
                    FrsLiteProgramListFragment.this.mHasMore = z;
                    if (v.J(FrsLiteProgramListFragment.this.dTs)) {
                        FrsLiteProgramListFragment.this.dTp.setVisibility(8);
                        FrsLiteProgramListFragment.this.showNetRefreshView(FrsLiteProgramListFragment.this.mRootView, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(e.j.net_error_text, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(e.j.error_unkown_try_again), 0), false);
                    } else if (FrsLiteProgramListFragment.this.dTp != null) {
                        FrsLiteProgramListFragment.this.hideNetRefreshView(FrsLiteProgramListFragment.this.mRootView);
                        FrsLiteProgramListFragment.this.dTp.setVisibility(0);
                        if (FrsLiteProgramListFragment.this.dTq != null) {
                            FrsLiteProgramListFragment.this.dTq.setData(FrsLiteProgramListFragment.this.dTs);
                            FrsLiteProgramListFragment.this.dTq.notifyDataSetChanged();
                        } else {
                            FrsLiteProgramListFragment.this.dTq = new a(FrsLiteProgramListFragment.this.getPageContext());
                            FrsLiteProgramListFragment.this.dTq.setData(FrsLiteProgramListFragment.this.dTs);
                            FrsLiteProgramListFragment.this.dTp.setAdapter((ListAdapter) FrsLiteProgramListFragment.this.dTq);
                        }
                    }
                    if (FrsLiteProgramListFragment.this.dTp != null && FrsLiteProgramListFragment.this.bJY != null && !FrsLiteProgramListFragment.this.mHasMore) {
                        FrsLiteProgramListFragment.this.bJY.DQ();
                        FrsLiteProgramListFragment.this.dTp.setNextPage(FrsLiteProgramListFragment.this.bJY);
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
        if (j.kX() && !StringUtils.isNULL(this.mForumId)) {
            if (this.dTo == null) {
                this.dTo = new FrsListProgramListModel(this.dTr);
            }
            this.dTo.q(this.mForumId, i, i2);
        }
    }

    public void od(String str) {
        this.mForumId = str;
        this.dTp.setVisibility(8);
        showNetRefreshView(this.mRootView, getPageContext().getResources().getString(e.j.net_error_text, getPageContext().getResources().getString(e.j.neterror), 0), false);
    }

    public void oe(String str) {
        this.dTp.setVisibility(8);
        this.dTu.setVisibility(0);
        this.dTu.loadUrl(str);
    }

    public void showLoadingView() {
        this.dTp.setVisibility(8);
        showLoadingView(this.mRootView);
    }

    public void hideLoadingView() {
        this.dTp.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    private void aG(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.smart_app));
        if (this.mNavigationBar != null && this.mNavigationBar.mCenterText != null) {
            this.mNavigationBar.mCenterText.setTextSize(getResources().getDimensionPixelSize(e.C0175e.tbds18));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
            }
        });
        this.mNavigationBar.showBottomLine();
        this.dTp = (BdListView) view.findViewById(e.g.list);
        this.dTu = (BaseWebView) view.findViewById(e.g.app_webView);
        this.dTp.setOnSrollToBottomListener(this.dTv);
        this.dTp.setOnItemClickListener(this.mOnItemClickListener);
        this.mNetworkView = (NoNetworkView) view.findViewById(e.g.no_network);
        this.bJY = new PbListView(getPageContext().getPageActivity());
        this.bJY.oG();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.setHeight(l.h(getActivity(), e.C0175e.tbds182));
        this.bJY.DL();
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.dU(e.d.cp_cont_e);
        this.dTp.setNextPage(this.bJY);
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
        al.e(this.dTp, e.d.cp_bg_line_e, i);
        al.e(this.mNavigationBar, e.d.cp_bg_line_d, i);
        al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_b, 1);
        al.a(this.mNavigationBar.getBackImageView(), e.f.icon_return_bg_s, e.f.icon_return_bg);
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.bJY != null) {
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bJY.dW(i);
        }
        if (this.dTq != null) {
            this.dTq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kX() && !StringUtils.isNULL(this.mForumId)) {
            hideNetRefreshView(this.mRootView);
            showLoadingView();
            clear();
            r(this.mForumId, 1, 10);
        }
    }

    public void clear() {
        if (this.dTs != null) {
            this.dTs.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dTo != null) {
            this.dTo.onDestroy();
        }
        clear();
    }
}
