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
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {
    private BdListView MS;
    private View bBg;
    private com.baidu.tbadk.coreExtra.view.c cdV;
    private BawuTeamInfoActivity fkL;
    private h fkM;
    private NoNetworkView fkN;
    private boolean fkO = false;
    private h.b fkP;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.fkL = bawuTeamInfoActivity;
        this.bBg = LayoutInflater.from(this.fkL.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.fkL.setContentView(this.bBg);
        this.mParent = this.bBg.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fkL.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fkN = (NoNetworkView) this.bBg.findViewById(R.id.view_no_network);
        this.MS = (BdListView) this.bBg.findViewById(R.id.listview_bawu_team_info);
        this.fkM = new h(this.fkL.getPageContext());
        this.MS.setAdapter((ListAdapter) this.fkM);
        this.fkP = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void wf(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aiz().c(g.this.fkL.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.fkM.a(this.fkP);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.fkO = true;
        } else {
            this.fkO = false;
        }
        if (z && this.fkO) {
            bip();
            return;
        }
        biq();
        this.fkM.U(arrayList);
        this.fkM.a(pVar);
        this.fkM.notifyDataSetChanged();
    }

    public boolean bio() {
        return this.fkO;
    }

    public void onChangeSkinType(int i) {
        this.fkL.getLayoutMode().setNightMode(i == 1);
        this.fkL.getLayoutMode().onModeChanged(this.bBg);
        this.mNavigationBar.onChangeSkinType(this.fkL.getPageContext(), i);
        this.fkN.onChangeSkinType(this.fkL.getPageContext(), i);
        this.fkM.notifyDataSetChanged();
    }

    public void bip() {
        this.MS.setVisibility(8);
        this.fkL.showNetRefreshView(this.bBg, this.fkL.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void biq() {
        this.fkL.hideNetRefreshView(this.bBg);
        this.MS.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.fkN.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.cdV == null) {
            this.cdV = new com.baidu.tbadk.coreExtra.view.c(this.fkL);
        }
        this.cdV.apm();
        this.cdV.setAccountData(accountData);
        this.cdV.jN(1);
    }

    public void onDestroy() {
        if (this.cdV != null) {
            this.cdV.onDestroy();
        }
    }
}
