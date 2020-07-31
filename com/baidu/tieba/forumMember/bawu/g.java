package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public class g {
    private BdListView UL;
    private NoNetworkView eJz;
    private com.baidu.tbadk.coreExtra.view.b epl;
    private BawuTeamInfoActivity hBb;
    private h hBc;
    private boolean hBd = false;
    private h.b hBe;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.hBb = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.hBb.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.hBb.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hBb.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eJz = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.UL = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.hBc = new h(this.hBb.getPageContext());
        this.UL.setAdapter((ListAdapter) this.hBc);
        this.hBe = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void FF(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    bd.baV().b(g.this.hBb.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.hBc.a(this.hBe);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.hBd = true;
        } else {
            this.hBd = false;
        }
        if (z && this.hBd) {
            bZL();
            return;
        }
        bZM();
        this.hBc.an(arrayList);
        this.hBc.a(pVar);
        this.hBc.notifyDataSetChanged();
    }

    public boolean bZK() {
        return this.hBd;
    }

    public void onChangeSkinType(int i) {
        this.hBb.getLayoutMode().setNightMode(i == 1);
        this.hBb.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hBb.getPageContext(), i);
        this.eJz.onChangeSkinType(this.hBb.getPageContext(), i);
        this.hBc.notifyDataSetChanged();
    }

    public void bZL() {
        this.UL.setVisibility(8);
        this.hBb.showNetRefreshView(this.mRoot, this.hBb.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bZM() {
        this.hBb.hideNetRefreshView(this.mRoot);
        this.UL.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.eJz.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.epl == null) {
            this.epl = new com.baidu.tbadk.coreExtra.view.b(this.hBb);
        }
        this.epl.bhi();
        this.epl.setAccountData(accountData);
        this.epl.nC(1);
    }

    public void onDestroy() {
        if (this.epl != null) {
            this.epl.onDestroy();
        }
    }
}
