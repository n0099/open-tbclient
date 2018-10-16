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
    private BdListView OE;
    private com.baidu.tbadk.coreExtra.view.a aIC;
    private View aix;
    private BawuTeamInfoActivity dwm;
    private h dwn;
    private NoNetworkView dwo;
    private boolean dwp = false;
    private h.b dwq;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dwm = bawuTeamInfoActivity;
        this.aix = LayoutInflater.from(this.dwm.getPageContext().getPageActivity()).inflate(e.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dwm.setContentView(this.aix);
        this.mParent = this.aix.findViewById(e.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.aix.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dwm.getString(e.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dwo = (NoNetworkView) this.aix.findViewById(e.g.view_no_network);
        this.OE = (BdListView) this.aix.findViewById(e.g.listview_bawu_team_info);
        this.dwn = new h(this.dwm.getPageContext());
        this.OE.setAdapter((ListAdapter) this.dwn);
        this.dwq = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void no(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ay.CU().c(g.this.dwm.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.dwn.a(this.dwq);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.dwp = true;
        } else {
            this.dwp = false;
        }
        if (z && this.dwp) {
            ayf();
            return;
        }
        ayg();
        this.dwn.N(arrayList);
        this.dwn.a(pVar);
        this.dwn.notifyDataSetChanged();
    }

    public boolean aye() {
        return this.dwp;
    }

    public void onChangeSkinType(int i) {
        this.dwm.getLayoutMode().setNightMode(i == 1);
        this.dwm.getLayoutMode().onModeChanged(this.aix);
        this.mNavigationBar.onChangeSkinType(this.dwm.getPageContext(), i);
        this.dwo.onChangeSkinType(this.dwm.getPageContext(), i);
        this.dwn.notifyDataSetChanged();
    }

    public void ayf() {
        this.OE.setVisibility(8);
        this.dwm.showNetRefreshView(this.aix, this.dwm.getPageContext().getResources().getString(e.j.no_data_text), true);
    }

    public void ayg() {
        this.dwm.hideNetRefreshView(this.aix);
        this.OE.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dwo.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aIC == null) {
            this.aIC = new com.baidu.tbadk.coreExtra.view.a(this.dwm);
        }
        this.aIC.Je();
        this.aIC.setAccountData(accountData);
        this.aIC.eP(1);
    }

    public void onDestroy() {
        if (this.aIC != null) {
            this.aIC.onDestroy();
        }
    }
}
