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
    private BdListView Ua;
    private com.baidu.tbadk.coreExtra.view.c dLY;
    private BawuTeamInfoActivity gUj;
    private h gUk;
    private NoNetworkView gUl;
    private boolean gUm = false;
    private h.b gUn;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.gUj = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.gUj.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.gUj.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gUj.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gUl = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Ua = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.gUk = new h(this.gUj.getPageContext());
        this.Ua.setAdapter((ListAdapter) this.gUk);
        this.gUn = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void CK(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aOV().b(g.this.gUj.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.gUk.a(this.gUn);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.gUm = true;
        } else {
            this.gUm = false;
        }
        if (z && this.gUm) {
            bMX();
            return;
        }
        bMY();
        this.gUk.am(arrayList);
        this.gUk.a(pVar);
        this.gUk.notifyDataSetChanged();
    }

    public boolean bMW() {
        return this.gUm;
    }

    public void onChangeSkinType(int i) {
        this.gUj.getLayoutMode().setNightMode(i == 1);
        this.gUj.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gUj.getPageContext(), i);
        this.gUl.onChangeSkinType(this.gUj.getPageContext(), i);
        this.gUk.notifyDataSetChanged();
    }

    public void bMX() {
        this.Ua.setVisibility(8);
        this.gUj.showNetRefreshView(this.mRoot, this.gUj.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bMY() {
        this.gUj.hideNetRefreshView(this.mRoot);
        this.Ua.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.gUl.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.dLY == null) {
            this.dLY = new com.baidu.tbadk.coreExtra.view.c(this.gUj);
        }
        this.dLY.aVn();
        this.dLY.setAccountData(accountData);
        this.dLY.mm(1);
    }

    public void onDestroy() {
        if (this.dLY != null) {
            this.dLY.onDestroy();
        }
    }
}
