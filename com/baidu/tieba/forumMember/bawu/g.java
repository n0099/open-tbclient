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
/* loaded from: classes8.dex */
public class g {
    private BdListView Ao;
    private com.baidu.tbadk.coreExtra.view.c dhs;
    private BawuTeamInfoActivity ghX;
    private h ghY;
    private NoNetworkView ghZ;
    private boolean gia = false;
    private h.b gib;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.ghX = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.ghX.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.ghX.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ghX.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.ghZ = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Ao = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.ghY = new h(this.ghX.getPageContext());
        this.Ao.setAdapter((ListAdapter) this.ghY);
        this.gib = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void AE(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aEt().b(g.this.ghX.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.ghY.a(this.gib);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.gia = true;
        } else {
            this.gia = false;
        }
        if (z && this.gia) {
            bAO();
            return;
        }
        bAP();
        this.ghY.ak(arrayList);
        this.ghY.a(pVar);
        this.ghY.notifyDataSetChanged();
    }

    public boolean bAN() {
        return this.gia;
    }

    public void onChangeSkinType(int i) {
        this.ghX.getLayoutMode().setNightMode(i == 1);
        this.ghX.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.ghX.getPageContext(), i);
        this.ghZ.onChangeSkinType(this.ghX.getPageContext(), i);
        this.ghY.notifyDataSetChanged();
    }

    public void bAO() {
        this.Ao.setVisibility(8);
        this.ghX.showNetRefreshView(this.mRoot, this.ghX.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bAP() {
        this.ghX.hideNetRefreshView(this.mRoot);
        this.Ao.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.ghZ.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.dhs == null) {
            this.dhs = new com.baidu.tbadk.coreExtra.view.c(this.ghX);
        }
        this.dhs.aKp();
        this.dhs.setAccountData(accountData);
        this.dhs.lG(1);
    }

    public void onDestroy() {
        if (this.dhs != null) {
            this.dhs.onDestroy();
        }
    }
}
