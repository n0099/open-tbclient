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
/* loaded from: classes7.dex */
public class g {
    private BdListView Ak;
    private com.baidu.tbadk.coreExtra.view.c dhg;
    private BawuTeamInfoActivity geO;
    private h geP;
    private NoNetworkView geQ;
    private boolean geR = false;
    private h.b geS;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.geO = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.geO.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.geO.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.geO.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.geQ = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Ak = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.geP = new h(this.geO.getPageContext());
        this.Ak.setAdapter((ListAdapter) this.geP);
        this.geS = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void Au(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aEa().b(g.this.geO.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.geP.a(this.geS);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.geR = true;
        } else {
            this.geR = false;
        }
        if (z && this.geR) {
            bzM();
            return;
        }
        bzN();
        this.geP.ak(arrayList);
        this.geP.a(pVar);
        this.geP.notifyDataSetChanged();
    }

    public boolean bzL() {
        return this.geR;
    }

    public void onChangeSkinType(int i) {
        this.geO.getLayoutMode().setNightMode(i == 1);
        this.geO.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.geO.getPageContext(), i);
        this.geQ.onChangeSkinType(this.geO.getPageContext(), i);
        this.geP.notifyDataSetChanged();
    }

    public void bzM() {
        this.Ak.setVisibility(8);
        this.geO.showNetRefreshView(this.mRoot, this.geO.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bzN() {
        this.geO.hideNetRefreshView(this.mRoot);
        this.Ak.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.geQ.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.dhg == null) {
            this.dhg = new com.baidu.tbadk.coreExtra.view.c(this.geO);
        }
        this.dhg.aJW();
        this.dhg.setAccountData(accountData);
        this.dhg.lG(1);
    }

    public void onDestroy() {
        if (this.dhg != null) {
            this.dhg.onDestroy();
        }
    }
}
