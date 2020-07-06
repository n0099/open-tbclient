package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class g {
    private BdListView US;
    private NoNetworkView eDk;
    private com.baidu.tbadk.coreExtra.view.b eiZ;
    private BawuTeamInfoActivity hvp;
    private h hvq;
    private boolean hvr = false;
    private h.b hvs;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.hvp = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.hvp.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.hvp.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hvp.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eDk = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.US = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.hvq = new h(this.hvp.getPageContext());
        this.US.setAdapter((ListAdapter) this.hvq);
        this.hvs = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void EU(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    bc.aWU().b(g.this.hvp.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.hvq.a(this.hvs);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.hvr = true;
        } else {
            this.hvr = false;
        }
        if (z && this.hvr) {
            bWs();
            return;
        }
        bWt();
        this.hvq.am(arrayList);
        this.hvq.a(pVar);
        this.hvq.notifyDataSetChanged();
    }

    public boolean bWr() {
        return this.hvr;
    }

    public void onChangeSkinType(int i) {
        this.hvp.getLayoutMode().setNightMode(i == 1);
        this.hvp.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hvp.getPageContext(), i);
        this.eDk.onChangeSkinType(this.hvp.getPageContext(), i);
        this.hvq.notifyDataSetChanged();
    }

    public void bWs() {
        this.US.setVisibility(8);
        this.hvp.showNetRefreshView(this.mRoot, this.hvp.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bWt() {
        this.hvp.hideNetRefreshView(this.mRoot);
        this.US.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.eDk.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.eiZ == null) {
            this.eiZ = new com.baidu.tbadk.coreExtra.view.b(this.hvp);
        }
        this.eiZ.bdz();
        this.eiZ.setAccountData(accountData);
        this.eiZ.nk(1);
    }

    public void onDestroy() {
        if (this.eiZ != null) {
            this.eiZ.onDestroy();
        }
    }
}
