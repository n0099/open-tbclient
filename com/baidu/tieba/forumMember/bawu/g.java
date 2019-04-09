package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {
    private BdListView Pj;
    private com.baidu.tbadk.coreExtra.view.c bWa;
    private View buc;
    private BawuTeamInfoActivity eUB;
    private h eUC;
    private NoNetworkView eUD;
    private boolean eUE = false;
    private h.b eUF;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.eUB = bawuTeamInfoActivity;
        this.buc = LayoutInflater.from(this.eUB.getPageContext().getPageActivity()).inflate(d.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.eUB.setContentView(this.buc);
        this.mParent = this.buc.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.buc.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eUB.getString(d.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eUD = (NoNetworkView) this.buc.findViewById(d.g.view_no_network);
        this.Pj = (BdListView) this.buc.findViewById(d.g.listview_bawu_team_info);
        this.eUC = new h(this.eUB.getPageContext());
        this.Pj.setAdapter((ListAdapter) this.eUC);
        this.eUF = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void uL(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.adA().c(g.this.eUB.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.eUC.a(this.eUF);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.eUE = true;
        } else {
            this.eUE = false;
        }
        if (z && this.eUE) {
            baW();
            return;
        }
        baX();
        this.eUC.Q(arrayList);
        this.eUC.a(pVar);
        this.eUC.notifyDataSetChanged();
    }

    public boolean baV() {
        return this.eUE;
    }

    public void onChangeSkinType(int i) {
        this.eUB.getLayoutMode().setNightMode(i == 1);
        this.eUB.getLayoutMode().onModeChanged(this.buc);
        this.mNavigationBar.onChangeSkinType(this.eUB.getPageContext(), i);
        this.eUD.onChangeSkinType(this.eUB.getPageContext(), i);
        this.eUC.notifyDataSetChanged();
    }

    public void baW() {
        this.Pj.setVisibility(8);
        this.eUB.showNetRefreshView(this.buc, this.eUB.getPageContext().getResources().getString(d.j.no_data_text), true);
    }

    public void baX() {
        this.eUB.hideNetRefreshView(this.buc);
        this.Pj.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.eUD.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.bWa == null) {
            this.bWa = new com.baidu.tbadk.coreExtra.view.c(this.eUB);
        }
        this.bWa.akj();
        this.bWa.setAccountData(accountData);
        this.bWa.iZ(1);
    }

    public void onDestroy() {
        if (this.bWa != null) {
            this.bWa.onDestroy();
        }
    }
}
