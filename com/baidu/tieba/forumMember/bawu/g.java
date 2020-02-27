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
    private com.baidu.tbadk.coreExtra.view.c dly;
    private BawuTeamInfoActivity gjZ;
    private h gka;
    private NoNetworkView gkb;
    private boolean gkc = false;
    private h.b gkd;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.gjZ = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.gjZ.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.gjZ.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gjZ.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gkb = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.AG = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.gka = new h(this.gjZ.getPageContext());
        this.AG.setAdapter((ListAdapter) this.gka);
        this.gkd = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void AU(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aGE().b(g.this.gjZ.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.gka.a(this.gkd);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.gkc = true;
        } else {
            this.gkc = false;
        }
        if (z && this.gkc) {
            bCq();
            return;
        }
        bCr();
        this.gka.ak(arrayList);
        this.gka.a(pVar);
        this.gka.notifyDataSetChanged();
    }

    public boolean bCp() {
        return this.gkc;
    }

    public void onChangeSkinType(int i) {
        this.gjZ.getLayoutMode().setNightMode(i == 1);
        this.gjZ.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gjZ.getPageContext(), i);
        this.gkb.onChangeSkinType(this.gjZ.getPageContext(), i);
        this.gka.notifyDataSetChanged();
    }

    public void bCq() {
        this.AG.setVisibility(8);
        this.gjZ.showNetRefreshView(this.mRoot, this.gjZ.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bCr() {
        this.gjZ.hideNetRefreshView(this.mRoot);
        this.AG.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.gkb.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.dly == null) {
            this.dly = new com.baidu.tbadk.coreExtra.view.c(this.gjZ);
        }
        this.dly.aML();
        this.dly.setAccountData(accountData);
        this.dly.lY(1);
    }

    public void onDestroy() {
        if (this.dly != null) {
            this.dly.onDestroy();
        }
    }
}
