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
/* loaded from: classes10.dex */
public class g {
    private BdListView TX;
    private com.baidu.tbadk.coreExtra.view.c dLU;
    private BawuTeamInfoActivity gUd;
    private h gUe;
    private NoNetworkView gUf;
    private boolean gUg = false;
    private h.b gUh;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.gUd = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.gUd.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.gUd.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gUd.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gUf = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.TX = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.gUe = new h(this.gUd.getPageContext());
        this.TX.setAdapter((ListAdapter) this.gUe);
        this.gUh = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void CH(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aOY().b(g.this.gUd.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.gUe.a(this.gUh);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.gUg = true;
        } else {
            this.gUg = false;
        }
        if (z && this.gUg) {
            bMZ();
            return;
        }
        bNa();
        this.gUe.am(arrayList);
        this.gUe.a(pVar);
        this.gUe.notifyDataSetChanged();
    }

    public boolean bMY() {
        return this.gUg;
    }

    public void onChangeSkinType(int i) {
        this.gUd.getLayoutMode().setNightMode(i == 1);
        this.gUd.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gUd.getPageContext(), i);
        this.gUf.onChangeSkinType(this.gUd.getPageContext(), i);
        this.gUe.notifyDataSetChanged();
    }

    public void bMZ() {
        this.TX.setVisibility(8);
        this.gUd.showNetRefreshView(this.mRoot, this.gUd.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bNa() {
        this.gUd.hideNetRefreshView(this.mRoot);
        this.TX.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.gUf.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.dLU == null) {
            this.dLU = new com.baidu.tbadk.coreExtra.view.c(this.gUd);
        }
        this.dLU.aVp();
        this.dLU.setAccountData(accountData);
        this.dLU.mm(1);
    }

    public void onDestroy() {
        if (this.dLU != null) {
            this.dLU.onDestroy();
        }
    }
}
