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
/* loaded from: classes9.dex */
public class FrsLiteProgramListFragment extends BaseFragment {
    private PbListView elw;
    private FrsListProgramListModel gIO;
    private a gIQ;
    private FrsListProgramListModel.a gIR;
    private BaseWebView gIU;
    private String mForumId;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private View mRootView;
    private BdListView gIP = null;
    private ArrayList<b> gIS = new ArrayList<>();
    public boolean gIT = false;
    private int pageNumber = 1;
    private final BdListView.e gIV = new BdListView.e() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsLiteProgramListFragment.this.mHasMore) {
                if (FrsLiteProgramListFragment.this.elw != null) {
                    FrsLiteProgramListFragment.this.elw.startLoadData();
                }
                FrsLiteProgramListFragment.g(FrsLiteProgramListFragment.this);
                FrsLiteProgramListFragment.this.u(FrsLiteProgramListFragment.this.mForumId, FrsLiteProgramListFragment.this.pageNumber, 10);
            } else if (FrsLiteProgramListFragment.this.elw != null) {
                FrsLiteProgramListFragment.this.elw.endLoadDataWithNoMore();
            }
        }
    };
    protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar;
            if (!v.isEmpty(FrsLiteProgramListFragment.this.gIS) && (bVar = (b) FrsLiteProgramListFragment.this.gIS.get(i)) != null) {
                String str = bVar.h5_url;
                String str2 = bVar.name;
                String str3 = bVar.id;
                Long l = bVar.gIK;
                if (!com.baidu.tieba.aiapps.a.b(str3, bVar.link, "1191003700000000", bVar.cID)) {
                    if (!StringUtils.isNULL(str)) {
                        ba.aGG().b(FrsLiteProgramListFragment.this.getPageContext(), new String[]{str});
                    } else {
                        return;
                    }
                }
                TiebaStatic.log(new an("c13274").cy("fid", FrsLiteProgramListFragment.this.mForumId).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", str2).s("obj_id", l.longValue()).cy("obj_source", "frs_Bside").X("obj_param1", bVar.cID.intValue()));
            }
        }
    };

    static /* synthetic */ int g(FrsLiteProgramListFragment frsLiteProgramListFragment) {
        int i = frsLiteProgramListFragment.pageNumber;
        frsLiteProgramListFragment.pageNumber = i + 1;
        return i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.frs_lite_program_list_fragment_layout, viewGroup, false);
        bJ(this.mRootView);
        if (this.gIR == null) {
            this.gIR = new FrsListProgramListModel.a() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.1
                @Override // com.baidu.tieba.frs.smartapp.FrsListProgramListModel.a
                public void a(ArrayList<b> arrayList, int i, String str, boolean z) {
                    FrsLiteProgramListFragment.this.hideLoadingView();
                    if (!v.isEmpty(arrayList)) {
                        FrsLiteProgramListFragment.this.gIS.addAll(arrayList);
                    }
                    FrsLiteProgramListFragment.this.mHasMore = z;
                    if (v.isEmpty(FrsLiteProgramListFragment.this.gIS)) {
                        FrsLiteProgramListFragment.this.gIP.setVisibility(8);
                        FrsLiteProgramListFragment.this.showNetRefreshView(FrsLiteProgramListFragment.this.mRootView, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(R.string.net_error_text, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(R.string.error_unkown_try_again), 0), false);
                    } else if (FrsLiteProgramListFragment.this.gIP != null) {
                        FrsLiteProgramListFragment.this.hideNetRefreshView(FrsLiteProgramListFragment.this.mRootView);
                        FrsLiteProgramListFragment.this.gIP.setVisibility(0);
                        if (FrsLiteProgramListFragment.this.gIQ != null) {
                            FrsLiteProgramListFragment.this.gIQ.setData(FrsLiteProgramListFragment.this.gIS);
                            FrsLiteProgramListFragment.this.gIQ.notifyDataSetChanged();
                        } else {
                            FrsLiteProgramListFragment.this.gIQ = new a(FrsLiteProgramListFragment.this.getPageContext());
                            FrsLiteProgramListFragment.this.gIQ.setData(FrsLiteProgramListFragment.this.gIS);
                            FrsLiteProgramListFragment.this.gIP.setAdapter((ListAdapter) FrsLiteProgramListFragment.this.gIQ);
                        }
                    }
                    if (FrsLiteProgramListFragment.this.gIP != null && FrsLiteProgramListFragment.this.elw != null && !FrsLiteProgramListFragment.this.mHasMore) {
                        FrsLiteProgramListFragment.this.elw.endLoadDataWithNoMore();
                        FrsLiteProgramListFragment.this.gIP.setNextPage(FrsLiteProgramListFragment.this.elw);
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

    public void u(String str, int i, int i2) {
        this.mForumId = str;
        if (j.isNetWorkAvailable() && !StringUtils.isNULL(this.mForumId)) {
            if (this.gIO == null) {
                this.gIO = new FrsListProgramListModel(this.gIR);
            }
            this.gIO.s(this.mForumId, i, i2);
        }
    }

    public void BK(String str) {
        this.mForumId = str;
        this.gIP.setVisibility(8);
        showNetRefreshView(this.mRootView, getPageContext().getResources().getString(R.string.net_error_text, getPageContext().getResources().getString(R.string.neterror), 0), false);
    }

    public void BL(String str) {
        this.gIP.setVisibility(8);
        this.gIU.setVisibility(0);
        this.gIU.loadUrl(str);
    }

    public void showLoadingView() {
        this.gIP.setVisibility(8);
        showLoadingView(this.mRootView);
    }

    public void hideLoadingView() {
        this.gIP.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    private void bJ(View view) {
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.smart_app));
        if (this.mNavigationBar != null && this.mNavigationBar.mCenterText != null) {
            this.mNavigationBar.mCenterText.setTextSize(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        }
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gIP = (BdListView) view.findViewById(R.id.list);
        this.gIU = (BaseWebView) view.findViewById(R.id.app_webView);
        this.gIP.setOnSrollToBottomListener(this.gIV);
        this.gIP.setOnItemClickListener(this.mOnItemClickListener);
        this.mNetworkView = (NoNetworkView) view.findViewById(R.id.no_network);
        this.elw = new PbListView(getPageContext().getPageActivity());
        this.elw.createView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.elw.setLineGone();
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gIP.setNextPage(this.elw);
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
        am.setBackgroundColor(this.gIP, R.color.cp_bg_line_e, i);
        am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_d, i);
        am.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
        am.setNavbarIconSrc(this.mNavigationBar.getBackImageView(), R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.elw != null) {
            this.elw.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elw.changeSkin(i);
        }
        if (this.gIQ != null) {
            this.gIQ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && !StringUtils.isNULL(this.mForumId)) {
            hideNetRefreshView(this.mRootView);
            showLoadingView();
            clear();
            u(this.mForumId, 1, 10);
        }
    }

    public void clear() {
        if (this.gIS != null) {
            this.gIS.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gIO != null) {
            this.gIO.onDestroy();
        }
        clear();
    }
}
