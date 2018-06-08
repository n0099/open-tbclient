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
    private BdListView LQ;
    private com.baidu.tbadk.coreExtra.view.a aAl;
    private View abp;
    private BawuTeamInfoActivity ddL;
    private h ddM;
    private NoNetworkView ddN;
    private boolean ddO = false;
    private h.b ddP;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.ddL = bawuTeamInfoActivity;
        this.abp = LayoutInflater.from(this.ddL.getPageContext().getPageActivity()).inflate(d.i.bawu_team_info_activity_layout, (ViewGroup) null);
        this.ddL.setContentView(this.abp);
        this.mParent = this.abp.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.abp.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ddL.getString(d.k.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.ddN = (NoNetworkView) this.abp.findViewById(d.g.view_no_network);
        this.LQ = (BdListView) this.abp.findViewById(d.g.listview_bawu_team_info);
        this.ddM = new h(this.ddL.getPageContext());
        this.LQ.setAdapter((ListAdapter) this.ddM);
        this.ddP = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void mj(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ay.zG().c(g.this.ddL.getPageContext(), new String[]{str});
                } else {
                    g.this.j(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.ddM.a(this.ddP);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.ddO = true;
        } else {
            this.ddO = false;
        }
        if (z && this.ddO) {
            ash();
            return;
        }
        asi();
        this.ddM.H(arrayList);
        this.ddM.a(pVar);
        this.ddM.notifyDataSetChanged();
    }

    public boolean asg() {
        return this.ddO;
    }

    public void onChangeSkinType(int i) {
        this.ddL.getLayoutMode().setNightMode(i == 1);
        this.ddL.getLayoutMode().onModeChanged(this.abp);
        this.mNavigationBar.onChangeSkinType(this.ddL.getPageContext(), i);
        this.ddN.onChangeSkinType(this.ddL.getPageContext(), i);
        this.ddM.notifyDataSetChanged();
    }

    public void ash() {
        this.LQ.setVisibility(8);
        this.ddL.showNetRefreshView(this.abp, this.ddL.getPageContext().getResources().getString(d.k.no_data_text), true);
    }

    public void asi() {
        this.ddL.hideNetRefreshView(this.abp);
        this.LQ.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.ddN.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.aAl == null) {
            this.aAl = new com.baidu.tbadk.coreExtra.view.a(this.ddL.getPageContext());
        }
        this.aAl.Fz();
        this.aAl.i(accountData);
        this.aAl.er(1);
    }

    public void onDestroy() {
        if (this.aAl != null) {
            this.aAl.onDestroy();
        }
    }
}
