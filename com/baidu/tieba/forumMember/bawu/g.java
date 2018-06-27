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
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private BdListView LS;
    private com.baidu.tbadk.coreExtra.view.a aBd;
    private View abt;
    private BawuTeamInfoActivity dfD;
    private h dfE;
    private NoNetworkView dfF;
    private boolean dfG = false;
    private h.b dfH;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dfD = bawuTeamInfoActivity;
        this.abt = LayoutInflater.from(this.dfD.getPageContext().getPageActivity()).inflate(d.i.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dfD.setContentView(this.abt);
        this.mParent = this.abt.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.abt.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dfD.getString(d.k.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dfF = (NoNetworkView) this.abt.findViewById(d.g.view_no_network);
        this.LS = (BdListView) this.abt.findViewById(d.g.listview_bawu_team_info);
        this.dfE = new h(this.dfD.getPageContext());
        this.LS.setAdapter((ListAdapter) this.dfE);
        this.dfH = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void mj(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    az.zV().c(g.this.dfD.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.dfE.a(this.dfH);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.dfG = true;
        } else {
            this.dfG = false;
        }
        if (z && this.dfG) {
            ass();
            return;
        }
        ast();
        this.dfE.N(arrayList);
        this.dfE.a(pVar);
        this.dfE.notifyDataSetChanged();
    }

    public boolean asr() {
        return this.dfG;
    }

    public void onChangeSkinType(int i) {
        this.dfD.getLayoutMode().setNightMode(i == 1);
        this.dfD.getLayoutMode().onModeChanged(this.abt);
        this.mNavigationBar.onChangeSkinType(this.dfD.getPageContext(), i);
        this.dfF.onChangeSkinType(this.dfD.getPageContext(), i);
        this.dfE.notifyDataSetChanged();
    }

    public void ass() {
        this.LS.setVisibility(8);
        this.dfD.showNetRefreshView(this.abt, this.dfD.getPageContext().getResources().getString(d.k.no_data_text), true);
    }

    public void ast() {
        this.dfD.hideNetRefreshView(this.abt);
        this.LS.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dfF.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aBd == null) {
            this.aBd = new com.baidu.tbadk.coreExtra.view.a(this.dfD);
        }
        this.aBd.FR();
        this.aBd.setAccountData(accountData);
        this.aBd.es(1);
    }

    public void onDestroy() {
        if (this.aBd != null) {
            this.aBd.onDestroy();
        }
    }
}
