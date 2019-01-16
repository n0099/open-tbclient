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
    private BdListView OQ;
    private com.baidu.tbadk.coreExtra.view.a aNw;
    private View ano;
    private BawuTeamInfoActivity dHA;
    private h dHB;
    private NoNetworkView dHC;
    private boolean dHD = false;
    private h.b dHE;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dHA = bawuTeamInfoActivity;
        this.ano = LayoutInflater.from(this.dHA.getPageContext().getPageActivity()).inflate(e.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dHA.setContentView(this.ano);
        this.mParent = this.ano.findViewById(e.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.ano.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dHA.getString(e.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dHC = (NoNetworkView) this.ano.findViewById(e.g.view_no_network);
        this.OQ = (BdListView) this.ano.findViewById(e.g.listview_bawu_team_info);
        this.dHB = new h(this.dHA.getPageContext());
        this.OQ.setAdapter((ListAdapter) this.dHB);
        this.dHE = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void oi(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ay.Es().c(g.this.dHA.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.dHB.a(this.dHE);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.dHD = true;
        } else {
            this.dHD = false;
        }
        if (z && this.dHD) {
            aAz();
            return;
        }
        aAA();
        this.dHB.N(arrayList);
        this.dHB.a(pVar);
        this.dHB.notifyDataSetChanged();
    }

    public boolean aAy() {
        return this.dHD;
    }

    public void onChangeSkinType(int i) {
        this.dHA.getLayoutMode().setNightMode(i == 1);
        this.dHA.getLayoutMode().onModeChanged(this.ano);
        this.mNavigationBar.onChangeSkinType(this.dHA.getPageContext(), i);
        this.dHC.onChangeSkinType(this.dHA.getPageContext(), i);
        this.dHB.notifyDataSetChanged();
    }

    public void aAz() {
        this.OQ.setVisibility(8);
        this.dHA.showNetRefreshView(this.ano, this.dHA.getPageContext().getResources().getString(e.j.no_data_text), true);
    }

    public void aAA() {
        this.dHA.hideNetRefreshView(this.ano);
        this.OQ.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dHC.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aNw == null) {
            this.aNw = new com.baidu.tbadk.coreExtra.view.a(this.dHA);
        }
        this.aNw.KK();
        this.aNw.setAccountData(accountData);
        this.aNw.fs(1);
    }

    public void onDestroy() {
        if (this.aNw != null) {
            this.aNw.onDestroy();
        }
    }
}
