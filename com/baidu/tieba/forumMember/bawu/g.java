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
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private BdListView LO;
    private com.baidu.tbadk.coreExtra.view.a aAX;
    private View aaV;
    private BawuTeamInfoActivity dit;
    private h diu;
    private NoNetworkView div;
    private boolean diw = false;
    private h.b dix;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dit = bawuTeamInfoActivity;
        this.aaV = LayoutInflater.from(this.dit.getPageContext().getPageActivity()).inflate(d.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dit.setContentView(this.aaV);
        this.mParent = this.aaV.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.aaV.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dit.getString(d.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.div = (NoNetworkView) this.aaV.findViewById(d.g.view_no_network);
        this.LO = (BdListView) this.aaV.findViewById(d.g.listview_bawu_team_info);
        this.diu = new h(this.dit.getPageContext());
        this.LO.setAdapter((ListAdapter) this.diu);
        this.dix = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void mi(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ay.zK().c(g.this.dit.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.diu.a(this.dix);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.diw = true;
        } else {
            this.diw = false;
        }
        if (z && this.diw) {
            asW();
            return;
        }
        asX();
        this.diu.N(arrayList);
        this.diu.a(pVar);
        this.diu.notifyDataSetChanged();
    }

    public boolean asV() {
        return this.diw;
    }

    public void onChangeSkinType(int i) {
        this.dit.getLayoutMode().setNightMode(i == 1);
        this.dit.getLayoutMode().onModeChanged(this.aaV);
        this.mNavigationBar.onChangeSkinType(this.dit.getPageContext(), i);
        this.div.onChangeSkinType(this.dit.getPageContext(), i);
        this.diu.notifyDataSetChanged();
    }

    public void asW() {
        this.LO.setVisibility(8);
        this.dit.showNetRefreshView(this.aaV, this.dit.getPageContext().getResources().getString(d.j.no_data_text), true);
    }

    public void asX() {
        this.dit.hideNetRefreshView(this.aaV);
        this.LO.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.div.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aAX == null) {
            this.aAX = new com.baidu.tbadk.coreExtra.view.a(this.dit);
        }
        this.aAX.FN();
        this.aAX.setAccountData(accountData);
        this.aAX.ev(1);
    }

    public void onDestroy() {
        if (this.aAX != null) {
            this.aAX.onDestroy();
        }
    }
}
