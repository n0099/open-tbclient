package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.f;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private BdListView LO;
    private com.baidu.tbadk.coreExtra.view.a aAU;
    private View aaW;
    private BawuTeamInfoActivity dir;
    private h dis;
    private NoNetworkView dit;
    private boolean diu = false;
    private h.b div;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dir = bawuTeamInfoActivity;
        this.aaW = LayoutInflater.from(this.dir.getPageContext().getPageActivity()).inflate(f.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dir.setContentView(this.aaW);
        this.mParent = this.aaW.findViewById(f.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.aaW.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dir.getString(f.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dit = (NoNetworkView) this.aaW.findViewById(f.g.view_no_network);
        this.LO = (BdListView) this.aaW.findViewById(f.g.listview_bawu_team_info);
        this.dis = new h(this.dir.getPageContext());
        this.LO.setAdapter((ListAdapter) this.dis);
        this.div = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void mk(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    az.zI().c(g.this.dir.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.dis.a(this.div);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.diu = true;
        } else {
            this.diu = false;
        }
        if (z && this.diu) {
            asV();
            return;
        }
        asW();
        this.dis.N(arrayList);
        this.dis.a(pVar);
        this.dis.notifyDataSetChanged();
    }

    public boolean asU() {
        return this.diu;
    }

    public void onChangeSkinType(int i) {
        this.dir.getLayoutMode().setNightMode(i == 1);
        this.dir.getLayoutMode().onModeChanged(this.aaW);
        this.mNavigationBar.onChangeSkinType(this.dir.getPageContext(), i);
        this.dit.onChangeSkinType(this.dir.getPageContext(), i);
        this.dis.notifyDataSetChanged();
    }

    public void asV() {
        this.LO.setVisibility(8);
        this.dir.showNetRefreshView(this.aaW, this.dir.getPageContext().getResources().getString(f.j.no_data_text), true);
    }

    public void asW() {
        this.dir.hideNetRefreshView(this.aaW);
        this.LO.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dit.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aAU == null) {
            this.aAU = new com.baidu.tbadk.coreExtra.view.a(this.dir);
        }
        this.aAU.FN();
        this.aAU.setAccountData(accountData);
        this.aAU.eu(1);
    }

    public void onDestroy() {
        if (this.aAU != null) {
            this.aAU.onDestroy();
        }
    }
}
