package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {
    private BdListView Ni;
    private com.baidu.tbadk.coreExtra.view.c ceZ;
    private BawuTeamInfoActivity fpK;
    private h fpL;
    private NoNetworkView fpM;
    private boolean fpN = false;
    private h.b fpO;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.fpK = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.fpK.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.fpK.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fpK.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fpM = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Ni = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.fpL = new h(this.fpK.getPageContext());
        this.Ni.setAdapter((ListAdapter) this.fpL);
        this.fpO = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void wJ(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    bb.ajC().c(g.this.fpK.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.fpL.a(this.fpO);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.fpN = true;
        } else {
            this.fpN = false;
        }
        if (z && this.fpN) {
            bku();
            return;
        }
        bkv();
        this.fpL.U(arrayList);
        this.fpL.a(pVar);
        this.fpL.notifyDataSetChanged();
    }

    public boolean bkt() {
        return this.fpN;
    }

    public void onChangeSkinType(int i) {
        this.fpK.getLayoutMode().setNightMode(i == 1);
        this.fpK.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.fpK.getPageContext(), i);
        this.fpM.onChangeSkinType(this.fpK.getPageContext(), i);
        this.fpL.notifyDataSetChanged();
    }

    public void bku() {
        this.Ni.setVisibility(8);
        this.fpK.showNetRefreshView(this.mRoot, this.fpK.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bkv() {
        this.fpK.hideNetRefreshView(this.mRoot);
        this.Ni.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.fpM.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.ceZ == null) {
            this.ceZ = new com.baidu.tbadk.coreExtra.view.c(this.fpK);
        }
        this.ceZ.aqr();
        this.ceZ.setAccountData(accountData);
        this.ceZ.jT(1);
    }

    public void onDestroy() {
        if (this.ceZ != null) {
            this.ceZ.onDestroy();
        }
    }
}
