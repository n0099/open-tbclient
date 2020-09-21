package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class g {
    private BdListView VG;
    private com.baidu.tbadk.coreExtra.view.b eBF;
    private NoNetworkView eWZ;
    private BawuTeamInfoActivity hVw;
    private h hVx;
    private boolean hVy = false;
    private h.b hVz;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.hVw = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.hVw.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.hVw.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hVw.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eWZ = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.VG = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.hVx = new h(this.hVw.getPageContext());
        this.VG.setAdapter((ListAdapter) this.hVx);
        this.hVz = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void IE(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    be.bkp().b(g.this.hVw.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.hVx.a(this.hVz);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.hVy = true;
        } else {
            this.hVy = false;
        }
        if (z && this.hVy) {
            cnv();
            return;
        }
        cnw();
        this.hVx.av(arrayList);
        this.hVx.a(pVar);
        this.hVx.notifyDataSetChanged();
    }

    public boolean cnu() {
        return this.hVy;
    }

    public void onChangeSkinType(int i) {
        this.hVw.getLayoutMode().setNightMode(i == 1);
        this.hVw.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hVw.getPageContext(), i);
        this.eWZ.onChangeSkinType(this.hVw.getPageContext(), i);
        this.hVx.notifyDataSetChanged();
    }

    public void cnv() {
        this.VG.setVisibility(8);
        this.hVw.showNetRefreshView(this.mRoot, this.hVw.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cnw() {
        this.hVw.hideNetRefreshView(this.mRoot);
        this.VG.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.eWZ.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.eBF == null) {
            this.eBF = new com.baidu.tbadk.coreExtra.view.b(this.hVw);
        }
        this.eBF.bqP();
        this.eBF.setAccountData(accountData);
        this.eBF.qa(1);
    }

    public void onDestroy() {
        if (this.eBF != null) {
            this.eBF.onDestroy();
        }
    }
}
