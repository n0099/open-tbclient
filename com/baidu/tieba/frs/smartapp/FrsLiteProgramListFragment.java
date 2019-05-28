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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    private PbListView dlY;
    private FrsListProgramListModel fIT;
    private a fIV;
    private FrsListProgramListModel.a fIW;
    private BaseWebView fIZ;
    private String mForumId;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private View mRootView;
    private BdListView fIU = null;
    private ArrayList<b> fIX = new ArrayList<>();
    public boolean fIY = false;
    private int pageNumber = 1;
    private final BdListView.e fJa = new BdListView.e() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsLiteProgramListFragment.this.mHasMore) {
                if (FrsLiteProgramListFragment.this.dlY != null) {
                    FrsLiteProgramListFragment.this.dlY.ajy();
                }
                FrsLiteProgramListFragment.g(FrsLiteProgramListFragment.this);
                FrsLiteProgramListFragment.this.t(FrsLiteProgramListFragment.this.mForumId, FrsLiteProgramListFragment.this.pageNumber, 10);
            } else if (FrsLiteProgramListFragment.this.dlY != null) {
                FrsLiteProgramListFragment.this.dlY.ajA();
            }
        }
    };
    protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar;
            if (!v.aa(FrsLiteProgramListFragment.this.fIX) && (bVar = (b) FrsLiteProgramListFragment.this.fIX.get(i)) != null) {
                String str = bVar.h5_url;
                String str2 = bVar.name;
                String str3 = bVar.id;
                Long l = bVar.fIP;
                if (!com.baidu.tieba.aiapps.a.b(str3, bVar.link, "1191003700000000", bVar.byE)) {
                    if (!StringUtils.isNULL(str)) {
                        ba.aiz().c(FrsLiteProgramListFragment.this.getPageContext(), new String[]{str});
                    } else {
                        return;
                    }
                }
                TiebaStatic.log(new am("c13274").bT("fid", FrsLiteProgramListFragment.this.mForumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", str2).l(VideoPlayActivityConfig.OBJ_ID, l.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", bVar.byE.intValue()));
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
        bK(this.mRootView);
        if (this.fIW == null) {
            this.fIW = new FrsListProgramListModel.a() { // from class: com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment.1
                @Override // com.baidu.tieba.frs.smartapp.FrsListProgramListModel.a
                public void a(ArrayList<b> arrayList, int i, String str, boolean z) {
                    FrsLiteProgramListFragment.this.hideLoadingView();
                    if (!v.aa(arrayList)) {
                        FrsLiteProgramListFragment.this.fIX.addAll(arrayList);
                    }
                    FrsLiteProgramListFragment.this.mHasMore = z;
                    if (v.aa(FrsLiteProgramListFragment.this.fIX)) {
                        FrsLiteProgramListFragment.this.fIU.setVisibility(8);
                        FrsLiteProgramListFragment.this.showNetRefreshView(FrsLiteProgramListFragment.this.mRootView, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(R.string.net_error_text, FrsLiteProgramListFragment.this.getPageContext().getResources().getString(R.string.error_unkown_try_again), 0), false);
                    } else if (FrsLiteProgramListFragment.this.fIU != null) {
                        FrsLiteProgramListFragment.this.hideNetRefreshView(FrsLiteProgramListFragment.this.mRootView);
                        FrsLiteProgramListFragment.this.fIU.setVisibility(0);
                        if (FrsLiteProgramListFragment.this.fIV != null) {
                            FrsLiteProgramListFragment.this.fIV.setData(FrsLiteProgramListFragment.this.fIX);
                            FrsLiteProgramListFragment.this.fIV.notifyDataSetChanged();
                        } else {
                            FrsLiteProgramListFragment.this.fIV = new a(FrsLiteProgramListFragment.this.getPageContext());
                            FrsLiteProgramListFragment.this.fIV.setData(FrsLiteProgramListFragment.this.fIX);
                            FrsLiteProgramListFragment.this.fIU.setAdapter((ListAdapter) FrsLiteProgramListFragment.this.fIV);
                        }
                    }
                    if (FrsLiteProgramListFragment.this.fIU != null && FrsLiteProgramListFragment.this.dlY != null && !FrsLiteProgramListFragment.this.mHasMore) {
                        FrsLiteProgramListFragment.this.dlY.ajA();
                        FrsLiteProgramListFragment.this.fIU.setNextPage(FrsLiteProgramListFragment.this.dlY);
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
        if (j.jS() && !StringUtils.isNULL(this.mForumId)) {
            if (this.fIT == null) {
                this.fIT = new FrsListProgramListModel(this.fIW);
            }
            this.fIT.s(this.mForumId, i, i2);
        }
    }

    public void wV(String str) {
        this.mForumId = str;
        this.fIU.setVisibility(8);
        showNetRefreshView(this.mRootView, getPageContext().getResources().getString(R.string.net_error_text, getPageContext().getResources().getString(R.string.neterror), 0), false);
    }

    public void wW(String str) {
        this.fIU.setVisibility(8);
        this.fIZ.setVisibility(0);
        this.fIZ.loadUrl(str);
    }

    public void showLoadingView() {
        this.fIU.setVisibility(8);
        showLoadingView(this.mRootView);
    }

    public void hideLoadingView() {
        this.fIU.setVisibility(0);
        hideLoadingView(this.mRootView);
    }

    private void bK(View view) {
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
        this.fIU = (BdListView) view.findViewById(R.id.list);
        this.fIZ = (BaseWebView) view.findViewById(R.id.app_webView);
        this.fIU.setOnSrollToBottomListener(this.fJa);
        this.fIU.setOnItemClickListener(this.mOnItemClickListener);
        this.mNetworkView = (NoNetworkView) view.findViewById(R.id.no_network);
        this.dlY = new PbListView(getPageContext().getPageActivity());
        this.dlY.nG();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.setHeight(l.g(getActivity(), R.dimen.tbds182));
        this.dlY.ajv();
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.iN(R.color.cp_cont_e);
        this.fIU.setNextPage(this.dlY);
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
        al.h(this.fIU, R.color.cp_bg_line_e, i);
        al.h(this.mNavigationBar, R.color.cp_bg_line_d, i);
        al.f(this.mNavigationBar.mCenterText, R.color.cp_cont_b, 1);
        al.a(this.mNavigationBar.getBackImageView(), (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg);
        if (this.mNetworkView != null) {
            this.mNetworkView.onChangeSkinType(getPageContext(), i);
        }
        if (this.dlY != null) {
            this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
            this.dlY.iP(i);
        }
        if (this.fIV != null) {
            this.fIV.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jS() && !StringUtils.isNULL(this.mForumId)) {
            hideNetRefreshView(this.mRootView);
            showLoadingView();
            clear();
            t(this.mForumId, 1, 10);
        }
    }

    public void clear() {
        if (this.fIX != null) {
            this.fIX.clear();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fIT != null) {
            this.fIT.onDestroy();
        }
        clear();
    }
}
