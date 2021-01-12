package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.l;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class g {
    private BdListView WT;
    private NoNetworkView fJE;
    private com.baidu.tbadk.coreExtra.view.b fnD;
    private BawuTeamInfoActivity iWd;
    private h iWe;
    private boolean iWf = false;
    private h.b iWg;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.iWd = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.iWd.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.iWd.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iWd.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fJE = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.WT = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.iWe = new h(this.iWd.getPageContext());
        this.WT.setAdapter((ListAdapter) this.iWe);
        this.iWg = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void Jk(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    be.bsB().b(g.this.iWd.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.iWe.a(this.iWg);
    }

    public void a(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.iWf = true;
        } else {
            this.iWf = false;
        }
        if (z && this.iWf) {
            czw();
            return;
        }
        czx();
        this.iWe.at(arrayList);
        this.iWe.a(lVar);
        this.iWe.notifyDataSetChanged();
    }

    public boolean czv() {
        return this.iWf;
    }

    public void onChangeSkinType(int i) {
        this.iWd.getLayoutMode().setNightMode(i == 1);
        this.iWd.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iWd.getPageContext(), i);
        this.fJE.onChangeSkinType(this.iWd.getPageContext(), i);
        this.iWe.notifyDataSetChanged();
    }

    public void czw() {
        this.WT.setVisibility(8);
        this.iWd.showNetRefreshView(this.mRoot, this.iWd.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void czx() {
        this.iWd.hideNetRefreshView(this.mRoot);
        this.WT.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.fJE.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.fnD == null) {
            this.fnD = new com.baidu.tbadk.coreExtra.view.b(this.iWd);
        }
        this.fnD.bzi();
        this.fnD.setAccountData(accountData);
        this.fnD.qy(1);
    }

    public void onDestroy() {
        if (this.fnD != null) {
            this.fnD.onDestroy();
        }
    }
}
