package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {
    private BdListView Ni;
    private com.baidu.tbadk.coreExtra.view.c cfg;
    private BawuTeamInfoActivity fqj;
    private h fqk;
    private NoNetworkView fql;
    private boolean fqm = false;
    private h.b fqn;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.fqj = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.fqj.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.fqj.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fqj.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fql = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Ni = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.fqk = new h(this.fqj.getPageContext());
        this.Ni.setAdapter((ListAdapter) this.fqk);
        this.fqn = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void wK(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    bb.ajE().c(g.this.fqj.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.fqk.a(this.fqn);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.fqm = true;
        } else {
            this.fqm = false;
        }
        if (z && this.fqm) {
            bkB();
            return;
        }
        bkC();
        this.fqk.U(arrayList);
        this.fqk.a(pVar);
        this.fqk.notifyDataSetChanged();
    }

    public boolean bkA() {
        return this.fqm;
    }

    public void onChangeSkinType(int i) {
        this.fqj.getLayoutMode().setNightMode(i == 1);
        this.fqj.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.fqj.getPageContext(), i);
        this.fql.onChangeSkinType(this.fqj.getPageContext(), i);
        this.fqk.notifyDataSetChanged();
    }

    public void bkB() {
        this.Ni.setVisibility(8);
        this.fqj.showNetRefreshView(this.mRoot, this.fqj.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bkC() {
        this.fqj.hideNetRefreshView(this.mRoot);
        this.Ni.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.fql.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.cfg == null) {
            this.cfg = new com.baidu.tbadk.coreExtra.view.c(this.fqj);
        }
        this.cfg.aqt();
        this.cfg.setAccountData(accountData);
        this.cfg.jU(1);
    }

    public void onDestroy() {
        if (this.cfg != null) {
            this.cfg.onDestroy();
        }
    }
}
