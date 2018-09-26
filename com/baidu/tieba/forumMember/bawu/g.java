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
    private BdListView Op;
    private com.baidu.tbadk.coreExtra.view.a aDY;
    private View adA;
    private BawuTeamInfoActivity dok;
    private h dol;
    private NoNetworkView dom;
    private boolean don = false;
    private h.b doo;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dok = bawuTeamInfoActivity;
        this.adA = LayoutInflater.from(this.dok.getPageContext().getPageActivity()).inflate(e.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dok.setContentView(this.adA);
        this.mParent = this.adA.findViewById(e.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.adA.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dok.getString(e.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dom = (NoNetworkView) this.adA.findViewById(e.g.view_no_network);
        this.Op = (BdListView) this.adA.findViewById(e.g.listview_bawu_team_info);
        this.dol = new h(this.dok.getPageContext());
        this.Op.setAdapter((ListAdapter) this.dol);
        this.doo = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void mM(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ay.AN().c(g.this.dok.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.dol.a(this.doo);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.don = true;
        } else {
            this.don = false;
        }
        if (z && this.don) {
            auJ();
            return;
        }
        auK();
        this.dol.N(arrayList);
        this.dol.a(pVar);
        this.dol.notifyDataSetChanged();
    }

    public boolean auI() {
        return this.don;
    }

    public void onChangeSkinType(int i) {
        this.dok.getLayoutMode().setNightMode(i == 1);
        this.dok.getLayoutMode().onModeChanged(this.adA);
        this.mNavigationBar.onChangeSkinType(this.dok.getPageContext(), i);
        this.dom.onChangeSkinType(this.dok.getPageContext(), i);
        this.dol.notifyDataSetChanged();
    }

    public void auJ() {
        this.Op.setVisibility(8);
        this.dok.showNetRefreshView(this.adA, this.dok.getPageContext().getResources().getString(e.j.no_data_text), true);
    }

    public void auK() {
        this.dok.hideNetRefreshView(this.adA);
        this.Op.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dom.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aDY == null) {
            this.aDY = new com.baidu.tbadk.coreExtra.view.a(this.dok);
        }
        this.aDY.Hd();
        this.aDY.setAccountData(accountData);
        this.aDY.eG(1);
    }

    public void onDestroy() {
        if (this.aDY != null) {
            this.aDY.onDestroy();
        }
    }
}
