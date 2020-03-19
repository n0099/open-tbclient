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
    private BdListView AG;
    private com.baidu.tbadk.coreExtra.view.c dlZ;
    private BawuTeamInfoActivity gkW;
    private h gkX;
    private NoNetworkView gkY;
    private boolean gkZ = false;
    private h.b gla;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.gkW = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.gkW.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.gkW.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gkW.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gkY = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.AG = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.gkX = new h(this.gkW.getPageContext());
        this.AG.setAdapter((ListAdapter) this.gkX);
        this.gla = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void AX(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aGK().b(g.this.gkW.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.gkX.a(this.gla);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.gkZ = true;
        } else {
            this.gkZ = false;
        }
        if (z && this.gkZ) {
            bCz();
            return;
        }
        bCA();
        this.gkX.ak(arrayList);
        this.gkX.a(pVar);
        this.gkX.notifyDataSetChanged();
    }

    public boolean bCy() {
        return this.gkZ;
    }

    public void onChangeSkinType(int i) {
        this.gkW.getLayoutMode().setNightMode(i == 1);
        this.gkW.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gkW.getPageContext(), i);
        this.gkY.onChangeSkinType(this.gkW.getPageContext(), i);
        this.gkX.notifyDataSetChanged();
    }

    public void bCz() {
        this.AG.setVisibility(8);
        this.gkW.showNetRefreshView(this.mRoot, this.gkW.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bCA() {
        this.gkW.hideNetRefreshView(this.mRoot);
        this.AG.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.gkY.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.dlZ == null) {
            this.dlZ = new com.baidu.tbadk.coreExtra.view.c(this.gkW);
        }
        this.dlZ.aMS();
        this.dlZ.setAccountData(accountData);
        this.dlZ.ma(1);
    }

    public void onDestroy() {
        if (this.dlZ != null) {
            this.dlZ.onDestroy();
        }
    }
}
