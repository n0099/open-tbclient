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
    private com.baidu.tbadk.coreExtra.view.c dlz;
    private BawuTeamInfoActivity gkb;
    private h gkc;
    private NoNetworkView gkd;
    private boolean gke = false;
    private h.b gkf;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.gkb = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.gkb.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.gkb.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gkb.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gkd = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.AG = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.gkc = new h(this.gkb.getPageContext());
        this.AG.setAdapter((ListAdapter) this.gkc);
        this.gkf = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void AU(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aGG().b(g.this.gkb.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.gkc.a(this.gkf);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.gke = true;
        } else {
            this.gke = false;
        }
        if (z && this.gke) {
            bCs();
            return;
        }
        bCt();
        this.gkc.ak(arrayList);
        this.gkc.a(pVar);
        this.gkc.notifyDataSetChanged();
    }

    public boolean bCr() {
        return this.gke;
    }

    public void onChangeSkinType(int i) {
        this.gkb.getLayoutMode().setNightMode(i == 1);
        this.gkb.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gkb.getPageContext(), i);
        this.gkd.onChangeSkinType(this.gkb.getPageContext(), i);
        this.gkc.notifyDataSetChanged();
    }

    public void bCs() {
        this.AG.setVisibility(8);
        this.gkb.showNetRefreshView(this.mRoot, this.gkb.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bCt() {
        this.gkb.hideNetRefreshView(this.mRoot);
        this.AG.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.gkd.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.dlz == null) {
            this.dlz = new com.baidu.tbadk.coreExtra.view.c(this.gkb);
        }
        this.dlz.aMN();
        this.dlz.setAccountData(accountData);
        this.dlz.lY(1);
    }

    public void onDestroy() {
        if (this.dlz != null) {
            this.dlz.onDestroy();
        }
    }
}
