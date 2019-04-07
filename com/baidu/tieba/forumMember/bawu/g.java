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
    private com.baidu.tbadk.coreExtra.view.c bVZ;
    private View bub;
    private BawuTeamInfoActivity eUA;
    private h eUB;
    private NoNetworkView eUC;
    private boolean eUD = false;
    private h.b eUE;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.eUA = bawuTeamInfoActivity;
        this.bub = LayoutInflater.from(this.eUA.getPageContext().getPageActivity()).inflate(d.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.eUA.setContentView(this.bub);
        this.mParent = this.bub.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.bub.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eUA.getString(d.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eUC = (NoNetworkView) this.bub.findViewById(d.g.view_no_network);
        this.Pj = (BdListView) this.bub.findViewById(d.g.listview_bawu_team_info);
        this.eUB = new h(this.eUA.getPageContext());
        this.Pj.setAdapter((ListAdapter) this.eUB);
        this.eUE = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void uL(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.adA().c(g.this.eUA.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.eUB.a(this.eUE);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.eUD = true;
        } else {
            this.eUD = false;
        }
        if (z && this.eUD) {
            baW();
            return;
        }
        baX();
        this.eUB.Q(arrayList);
        this.eUB.a(pVar);
        this.eUB.notifyDataSetChanged();
    }

    public boolean baV() {
        return this.eUD;
    }

    public void onChangeSkinType(int i) {
        this.eUA.getLayoutMode().setNightMode(i == 1);
        this.eUA.getLayoutMode().onModeChanged(this.bub);
        this.mNavigationBar.onChangeSkinType(this.eUA.getPageContext(), i);
        this.eUC.onChangeSkinType(this.eUA.getPageContext(), i);
        this.eUB.notifyDataSetChanged();
    }

    public void baW() {
        this.Pj.setVisibility(8);
        this.eUA.showNetRefreshView(this.bub, this.eUA.getPageContext().getResources().getString(d.j.no_data_text), true);
    }

    public void baX() {
        this.eUA.hideNetRefreshView(this.bub);
        this.Pj.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.eUC.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.bVZ == null) {
            this.bVZ = new com.baidu.tbadk.coreExtra.view.c(this.eUA);
        }
        this.bVZ.akj();
        this.bVZ.setAccountData(accountData);
        this.bVZ.iZ(1);
    }

    public void onDestroy() {
        if (this.bVZ != null) {
            this.bVZ.onDestroy();
        }
    }
}
