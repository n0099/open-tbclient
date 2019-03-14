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
    private com.baidu.tbadk.coreExtra.view.c bVX;
    private View btY;
    private BawuTeamInfoActivity eUO;
    private h eUP;
    private NoNetworkView eUQ;
    private boolean eUR = false;
    private h.b eUS;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.eUO = bawuTeamInfoActivity;
        this.btY = LayoutInflater.from(this.eUO.getPageContext().getPageActivity()).inflate(d.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.eUO.setContentView(this.btY);
        this.mParent = this.btY.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.btY.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eUO.getString(d.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eUQ = (NoNetworkView) this.btY.findViewById(d.g.view_no_network);
        this.Pj = (BdListView) this.btY.findViewById(d.g.listview_bawu_team_info);
        this.eUP = new h(this.eUO.getPageContext());
        this.Pj.setAdapter((ListAdapter) this.eUP);
        this.eUS = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void uM(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.adD().c(g.this.eUO.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.eUP.a(this.eUS);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.eUR = true;
        } else {
            this.eUR = false;
        }
        if (z && this.eUR) {
            baY();
            return;
        }
        baZ();
        this.eUP.Q(arrayList);
        this.eUP.a(pVar);
        this.eUP.notifyDataSetChanged();
    }

    public boolean baX() {
        return this.eUR;
    }

    public void onChangeSkinType(int i) {
        this.eUO.getLayoutMode().setNightMode(i == 1);
        this.eUO.getLayoutMode().onModeChanged(this.btY);
        this.mNavigationBar.onChangeSkinType(this.eUO.getPageContext(), i);
        this.eUQ.onChangeSkinType(this.eUO.getPageContext(), i);
        this.eUP.notifyDataSetChanged();
    }

    public void baY() {
        this.Pj.setVisibility(8);
        this.eUO.showNetRefreshView(this.btY, this.eUO.getPageContext().getResources().getString(d.j.no_data_text), true);
    }

    public void baZ() {
        this.eUO.hideNetRefreshView(this.btY);
        this.Pj.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.eUQ.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.bVX == null) {
            this.bVX = new com.baidu.tbadk.coreExtra.view.c(this.eUO);
        }
        this.bVX.akm();
        this.bVX.setAccountData(accountData);
        this.bVX.ja(1);
    }

    public void onDestroy() {
        if (this.bVX != null) {
            this.bVX.onDestroy();
        }
    }
}
