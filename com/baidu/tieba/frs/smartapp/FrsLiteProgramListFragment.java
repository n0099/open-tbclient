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
import com.baidu.tbadk.core.util.ba;
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
    private PbListView dpz;
    private FrsListProgramListModel.a fQA;
    private BaseWebView fQD;
    private FrsListProgramListModel fQx;
    private a fQz;
    private String mForumId;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private View mRootView;
    private BdListView fQy = null;
    private ArrayList<b> fQB = new ArrayList<>();
    public boolean fQC = false;
    private int pageNumber = 1;
    private final BdListView.e fQE = new BdListView.e() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsLiteProgramListFragment.this.mHasMore) {
                if (FrsLiteProgramListFragment.this.dpz != null) {
                    FrsLiteProgramListFragment.this.dpz.akR();
                }
                FrsLiteProgramListFragment.g(FrsLiteProgramListFragment.this);
                FrsLiteProgramListFragment.this.t(FrsLiteProgramListFragment.this.mForumId, FrsLiteProgramListFragment.this.pageNumber, 10);
            } else if (FrsLiteProgramListFragment.this.dpz != null) {
                FrsLiteProgramListFragment.this.dpz.akT();
            }
        }
    };
    protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar;
            if (!v.aa(FrsLiteProgramListFragment.this.fQB) && (bVar = (b) FrsLiteProgramListFragment.this.fQB.get(i)) != null) {
                String str = bVar.h5_url;
                String str2 = bVar.name;
                String str3 = bVar.id;
                Long l = bVar.fQt;
                if (!com.baidu.tieba.aiapps.a.b(str3, bVar.link, "1191003700000000", bVar.bzW)) {
                    if (!StringUtils.isNULL(str)) {
                        ba.ajK().c(FrsLiteProgramListFragment.this.getPageContext(), new String[]{str});
                    } else {
                        return;
                    }
                }
                TiebaStatic.log(new an("c13274").bT("fid", FrsLiteProgramListFragment.this.mForumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", str2).n(VideoPlayActivityConfig.OBJ_ID, l.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", bVar.bzW.intValue()));
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
        bM(this.mRootView);
        if (this.fQA == null) {
            this.fQA = new FrsListProgramListModel.a() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.1
                @Override // com.baidu.tieba.frs.smartapp.FrsListProgramListModel.a
                public void a(ArrayList<b> arrayList, int i, String str, boolean z) {
                    FrsLiteProgramListFragment.this.hideLoadingView();
                    if (!v.aa(arrayList)) {
                        FrsLiteProgramListFragment.this.fQB.addAll(arrayList);
                    }
                    FrsLiteProgramListFragment.this.mHasMore = z;
                    if (v.aa(FrsLiteProgramListFragment.this.fQB)) {
                        FrsLiteProgramListFragment.this.fQy.setVisibility(8);
                        FrsLiteProgramListFragment.this.showNetRefreshView(FrsLiteProgramListFragment.this.mRootView, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(R.string.net_error_text, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(R.string.error_unkown_try_again), 0), false);
                    } else if (FrsLiteProgramListFragment.this.fQy != null) {
                        FrsLiteProgramListFragment.this.hideNetRefreshView(FrsLiteProgramListFragment.this.mRootView);
                        FrsLiteProgramListFragment.this.fQy.setVisibility(0);
                        if (FrsLiteProgramListFragment.this.fQz != null) {
                            FrsLiteProgramListFragment.this.fQz.setData(FrsLiteProgramListFragment.this.fQB);
                            FrsLiteProgramListFragment.this.fQz.notifyDataSetChanged();
                        } else {
                            FrsLiteProgramListFragment.this.fQz = new a(FrsLiteProgramListFragment.this.getPageContext());
                            FrsLiteProgramListFragment.this.fQz.setData(FrsLiteProgramListFragment.this.fQB);
                            FrsLiteProgramListFragment.this.fQy.setAdapter((ListAdapter) FrsLiteProgramListFragment.this.fQz);
                        }
                    }
                    if (FrsLiteProgramListFragment.this.fQy != null && FrsLiteProgramListFragment.this.dpz != null && !FrsLiteProgramListFragment.this.mHasMore) {
                        FrsLiteProgramListFragment.this.dpz.akT();
                        FrsLiteProgramListFragment.this.fQy.setNextPage(FrsLiteProgramListFragment.this.dpz);
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
            if (this.fQx == null) {
                this.fQx = new FrsListProgramListModel(this.fQA);
            }
            this.fQx.s(this.mForumId, i, i2);
        }
    }

    public void yc(String str) {
        this.mForumId = str;
        this.fQy.setVisibility(8);
        showNetRefreshView(this.mRootView, getPageContext().getResources().getString(R.string.net_error_text, getPageContext().getResources().getString(R.string.neterror), 0), false);
    }

    public void yd(String str) {
        this.fQy.setVisibility(8);
        this.fQD.setVisibility(0);
        this.fQD.loadUrl(str);
    }

    public void showLoadingView() {
        this.fQy.setVisibility(8);
        showLoadingView(this.mRootView);
    }

    public void hideLoadingView() {
        this.fQy.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    private void bM(View view) {
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
        this.fQy = (BdListView) view.findViewById(R.id.list);
        this.fQD = (BaseWebView) view.findViewById(R.id.app_webView);
        this.fQy.setOnSrollToBottomListener(this.fQE);
        this.fQy.setOnItemClickListener(this.mOnItemClickListener);
        this.mNetworkView = (NoNetworkView) view.findViewById(R.id.no_network);
        this.dpz = new PbListView(getPageContext().getPageActivity());
        this.dpz.nZ();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.dpz.akO();
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dpz.iW(R.color.cp_cont_e);
        this.fQy.setNextPage(this.dpz);
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
        am.h(this.fQy, R.color.cp_bg_line_e, i);
        am.h(this.mNavigationBar, R.color.cp_bg_line_d, i);
        am.f(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
        am.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg);
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.dpz != null) {
            this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dpz.iY(i);
        }
        if (this.fQz != null) {
            this.fQz.notifyDataSetChanged();
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
        if (this.fQB != null) {
            this.fQB.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fQx != null) {
            this.fQx.onDestroy();
        }
        clear();
    }
}
