package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private BdListView OF;
    private com.baidu.tbadk.coreExtra.view.a aMU;
    private View amM;
    private BawuTeamInfoActivity dGR;
    private h dGS;
    private NoNetworkView dGT;
    private boolean dGU = false;
    private h.b dGV;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dGR = bawuTeamInfoActivity;
        this.amM = LayoutInflater.from(this.dGR.getPageContext().getPageActivity()).inflate(e.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dGR.setContentView(this.amM);
        this.mParent = this.amM.findViewById(e.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dGR.getString(e.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dGT = (NoNetworkView) this.amM.findViewById(e.g.view_no_network);
        this.OF = (BdListView) this.amM.findViewById(e.g.listview_bawu_team_info);
        this.dGS = new h(this.dGR.getPageContext());
        this.OF.setAdapter((ListAdapter) this.dGS);
        this.dGV = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void nR(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ay.Ef().c(g.this.dGR.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.dGS.a(this.dGV);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.dGU = true;
        } else {
            this.dGU = false;
        }
        if (z && this.dGU) {
            aAc();
            return;
        }
        aAd();
        this.dGS.N(arrayList);
        this.dGS.a(pVar);
        this.dGS.notifyDataSetChanged();
    }

    public boolean aAb() {
        return this.dGU;
    }

    public void onChangeSkinType(int i) {
        this.dGR.getLayoutMode().setNightMode(i == 1);
        this.dGR.getLayoutMode().onModeChanged(this.amM);
        this.mNavigationBar.onChangeSkinType(this.dGR.getPageContext(), i);
        this.dGT.onChangeSkinType(this.dGR.getPageContext(), i);
        this.dGS.notifyDataSetChanged();
    }

    public void aAc() {
        this.OF.setVisibility(8);
        this.dGR.showNetRefreshView(this.amM, this.dGR.getPageContext().getResources().getString(e.j.no_data_text), true);
    }

    public void aAd() {
        this.dGR.hideNetRefreshView(this.amM);
        this.OF.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dGT.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aMU == null) {
            this.aMU = new com.baidu.tbadk.coreExtra.view.a(this.dGR);
        }
        this.aMU.Kv();
        this.aMU.setAccountData(accountData);
        this.aMU.fs(1);
    }

    public void onDestroy() {
        if (this.aMU != null) {
            this.aMU.onDestroy();
        }
    }
}
