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
    private com.baidu.tbadk.coreExtra.view.a aJs;
    private View ajk;
    private BawuTeamInfoActivity dxE;
    private h dxF;
    private NoNetworkView dxG;
    private boolean dxH = false;
    private h.b dxI;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dxE = bawuTeamInfoActivity;
        this.ajk = LayoutInflater.from(this.dxE.getPageContext().getPageActivity()).inflate(e.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dxE.setContentView(this.ajk);
        this.mParent = this.ajk.findViewById(e.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.ajk.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dxE.getString(e.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dxG = (NoNetworkView) this.ajk.findViewById(e.g.view_no_network);
        this.OF = (BdListView) this.ajk.findViewById(e.g.listview_bawu_team_info);
        this.dxF = new h(this.dxE.getPageContext());
        this.OF.setAdapter((ListAdapter) this.dxF);
        this.dxI = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void np(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ay.Db().c(g.this.dxE.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.dxF.a(this.dxI);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.dxH = true;
        } else {
            this.dxH = false;
        }
        if (z && this.dxH) {
            axD();
            return;
        }
        axE();
        this.dxF.N(arrayList);
        this.dxF.a(pVar);
        this.dxF.notifyDataSetChanged();
    }

    public boolean axC() {
        return this.dxH;
    }

    public void onChangeSkinType(int i) {
        this.dxE.getLayoutMode().setNightMode(i == 1);
        this.dxE.getLayoutMode().onModeChanged(this.ajk);
        this.mNavigationBar.onChangeSkinType(this.dxE.getPageContext(), i);
        this.dxG.onChangeSkinType(this.dxE.getPageContext(), i);
        this.dxF.notifyDataSetChanged();
    }

    public void axD() {
        this.OF.setVisibility(8);
        this.dxE.showNetRefreshView(this.ajk, this.dxE.getPageContext().getResources().getString(e.j.no_data_text), true);
    }

    public void axE() {
        this.dxE.hideNetRefreshView(this.ajk);
        this.OF.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dxG.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aJs == null) {
            this.aJs = new com.baidu.tbadk.coreExtra.view.a(this.dxE);
        }
        this.aJs.Jq();
        this.aJs.setAccountData(accountData);
        this.aJs.fd(1);
    }

    public void onDestroy() {
        if (this.aJs != null) {
            this.aJs.onDestroy();
        }
    }
}
