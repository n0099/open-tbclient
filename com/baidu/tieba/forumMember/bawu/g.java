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
    private com.baidu.tbadk.coreExtra.view.c dlM;
    private BawuTeamInfoActivity gko;
    private h gkp;
    private NoNetworkView gkq;
    private boolean gkr = false;
    private h.b gks;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.gko = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.gko.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.gko.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gko.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gkq = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.AG = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.gkp = new h(this.gko.getPageContext());
        this.AG.setAdapter((ListAdapter) this.gkp);
        this.gks = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void AV(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aGG().b(g.this.gko.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.gkp.a(this.gks);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.gkr = true;
        } else {
            this.gkr = false;
        }
        if (z && this.gkr) {
            bCt();
            return;
        }
        bCu();
        this.gkp.ak(arrayList);
        this.gkp.a(pVar);
        this.gkp.notifyDataSetChanged();
    }

    public boolean bCs() {
        return this.gkr;
    }

    public void onChangeSkinType(int i) {
        this.gko.getLayoutMode().setNightMode(i == 1);
        this.gko.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gko.getPageContext(), i);
        this.gkq.onChangeSkinType(this.gko.getPageContext(), i);
        this.gkp.notifyDataSetChanged();
    }

    public void bCt() {
        this.AG.setVisibility(8);
        this.gko.showNetRefreshView(this.mRoot, this.gko.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bCu() {
        this.gko.hideNetRefreshView(this.mRoot);
        this.AG.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.gkq.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.dlM == null) {
            this.dlM = new com.baidu.tbadk.coreExtra.view.c(this.gko);
        }
        this.dlM.aMO();
        this.dlM.setAccountData(accountData);
        this.dlM.lY(1);
    }

    public void onDestroy() {
        if (this.dlM != null) {
            this.dlM.onDestroy();
        }
    }
}
