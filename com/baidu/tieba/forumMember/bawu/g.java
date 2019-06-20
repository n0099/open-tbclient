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
    private BdListView MR;
    private View bBg;
    private com.baidu.tbadk.coreExtra.view.c cdW;
    private BawuTeamInfoActivity fkM;
    private h fkN;
    private NoNetworkView fkO;
    private boolean fkP = false;
    private h.b fkQ;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.fkM = bawuTeamInfoActivity;
        this.bBg = LayoutInflater.from(this.fkM.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.fkM.setContentView(this.bBg);
        this.mParent = this.bBg.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fkM.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fkO = (NoNetworkView) this.bBg.findViewById(R.id.view_no_network);
        this.MR = (BdListView) this.bBg.findViewById(R.id.listview_bawu_team_info);
        this.fkN = new h(this.fkM.getPageContext());
        this.MR.setAdapter((ListAdapter) this.fkN);
        this.fkQ = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void we(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aiz().c(g.this.fkM.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.fkN.a(this.fkQ);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.fkP = true;
        } else {
            this.fkP = false;
        }
        if (z && this.fkP) {
            bis();
            return;
        }
        bit();
        this.fkN.U(arrayList);
        this.fkN.a(pVar);
        this.fkN.notifyDataSetChanged();
    }

    public boolean bir() {
        return this.fkP;
    }

    public void onChangeSkinType(int i) {
        this.fkM.getLayoutMode().setNightMode(i == 1);
        this.fkM.getLayoutMode().onModeChanged(this.bBg);
        this.mNavigationBar.onChangeSkinType(this.fkM.getPageContext(), i);
        this.fkO.onChangeSkinType(this.fkM.getPageContext(), i);
        this.fkN.notifyDataSetChanged();
    }

    public void bis() {
        this.MR.setVisibility(8);
        this.fkM.showNetRefreshView(this.bBg, this.fkM.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bit() {
        this.fkM.hideNetRefreshView(this.bBg);
        this.MR.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.fkO.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.cdW == null) {
            this.cdW = new com.baidu.tbadk.coreExtra.view.c(this.fkM);
        }
        this.cdW.apm();
        this.cdW.setAccountData(accountData);
        this.cdW.jN(1);
    }

    public void onDestroy() {
        if (this.cdW != null) {
            this.cdW.onDestroy();
        }
    }
}
