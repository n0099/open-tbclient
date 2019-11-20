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
/* loaded from: classes5.dex */
public class g {
    private com.baidu.tbadk.coreExtra.view.c ctu;
    private BawuTeamInfoActivity fqr;
    private h fqs;
    private NoNetworkView fqt;
    private boolean fqu = false;
    private h.b fqv;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;
    private BdListView xL;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.fqr = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.fqr.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.fqr.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fqr.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fqt = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.xL = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.fqs = new h(this.fqr.getPageContext());
        this.xL.setAdapter((ListAdapter) this.fqs);
        this.fqv = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void vC(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.amO().b(g.this.fqr.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.fqs.a(this.fqv);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.fqu = true;
        } else {
            this.fqu = false;
        }
        if (z && this.fqu) {
            bir();
            return;
        }
        bis();
        this.fqs.Z(arrayList);
        this.fqs.a(pVar);
        this.fqs.notifyDataSetChanged();
    }

    public boolean biq() {
        return this.fqu;
    }

    public void onChangeSkinType(int i) {
        this.fqr.getLayoutMode().setNightMode(i == 1);
        this.fqr.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.fqr.getPageContext(), i);
        this.fqt.onChangeSkinType(this.fqr.getPageContext(), i);
        this.fqs.notifyDataSetChanged();
    }

    public void bir() {
        this.xL.setVisibility(8);
        this.fqr.showNetRefreshView(this.mRoot, this.fqr.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bis() {
        this.fqr.hideNetRefreshView(this.mRoot);
        this.xL.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.fqt.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.ctu == null) {
            this.ctu = new com.baidu.tbadk.coreExtra.view.c(this.fqr);
        }
        this.ctu.asx();
        this.ctu.setAccountData(accountData);
        this.ctu.jt(1);
    }

    public void onDestroy() {
        if (this.ctu != null) {
            this.ctu.onDestroy();
        }
    }
}
