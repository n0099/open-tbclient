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
    private com.baidu.tbadk.coreExtra.view.a aMS;
    private View amM;
    private BawuTeamInfoActivity dEd;
    private h dEe;
    private NoNetworkView dEf;
    private boolean dEg = false;
    private h.b dEh;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dEd = bawuTeamInfoActivity;
        this.amM = LayoutInflater.from(this.dEd.getPageContext().getPageActivity()).inflate(e.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dEd.setContentView(this.amM);
        this.mParent = this.amM.findViewById(e.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dEd.getString(e.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dEf = (NoNetworkView) this.amM.findViewById(e.g.view_no_network);
        this.OF = (BdListView) this.amM.findViewById(e.g.listview_bawu_team_info);
        this.dEe = new h(this.dEd.getPageContext());
        this.OF.setAdapter((ListAdapter) this.dEe);
        this.dEh = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void nO(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ay.Ef().c(g.this.dEd.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.dEe.a(this.dEh);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.dEg = true;
        } else {
            this.dEg = false;
        }
        if (z && this.dEg) {
            azn();
            return;
        }
        azo();
        this.dEe.N(arrayList);
        this.dEe.a(pVar);
        this.dEe.notifyDataSetChanged();
    }

    public boolean azm() {
        return this.dEg;
    }

    public void onChangeSkinType(int i) {
        this.dEd.getLayoutMode().setNightMode(i == 1);
        this.dEd.getLayoutMode().onModeChanged(this.amM);
        this.mNavigationBar.onChangeSkinType(this.dEd.getPageContext(), i);
        this.dEf.onChangeSkinType(this.dEd.getPageContext(), i);
        this.dEe.notifyDataSetChanged();
    }

    public void azn() {
        this.OF.setVisibility(8);
        this.dEd.showNetRefreshView(this.amM, this.dEd.getPageContext().getResources().getString(e.j.no_data_text), true);
    }

    public void azo() {
        this.dEd.hideNetRefreshView(this.amM);
        this.OF.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dEf.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aMS == null) {
            this.aMS = new com.baidu.tbadk.coreExtra.view.a(this.dEd);
        }
        this.aMS.Ku();
        this.aMS.setAccountData(accountData);
        this.aMS.fr(1);
    }

    public void onDestroy() {
        if (this.aMS != null) {
            this.aMS.onDestroy();
        }
    }
}
