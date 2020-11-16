package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.h;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class g {
    private BdListView Wa;
    private com.baidu.tbadk.coreExtra.view.b fbf;
    private NoNetworkView fwR;
    private BawuTeamInfoActivity iDF;
    private h iDG;
    private boolean iDH = false;
    private h.b iDI;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.iDF = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.iDF.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.iDF.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iDF.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fwR = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Wa = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.iDG = new h(this.iDF.getPageContext());
        this.Wa.setAdapter((ListAdapter) this.iDG);
        this.iDI = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void JI(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    bf.bqF().b(g.this.iDF.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.iDG.a(this.iDI);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.iDH = true;
        } else {
            this.iDH = false;
        }
        if (z && this.iDH) {
            cwe();
            return;
        }
        cwf();
        this.iDG.ax(arrayList);
        this.iDG.a(pVar);
        this.iDG.notifyDataSetChanged();
    }

    public boolean cwd() {
        return this.iDH;
    }

    public void onChangeSkinType(int i) {
        this.iDF.getLayoutMode().setNightMode(i == 1);
        this.iDF.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iDF.getPageContext(), i);
        this.fwR.onChangeSkinType(this.iDF.getPageContext(), i);
        this.iDG.notifyDataSetChanged();
    }

    public void cwe() {
        this.Wa.setVisibility(8);
        this.iDF.showNetRefreshView(this.mRoot, this.iDF.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cwf() {
        this.iDF.hideNetRefreshView(this.mRoot);
        this.Wa.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.fwR.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.fbf == null) {
            this.fbf = new com.baidu.tbadk.coreExtra.view.b(this.iDF);
        }
        this.fbf.bxh();
        this.fbf.setAccountData(accountData);
        this.fbf.rr(1);
    }

    public void onDestroy() {
        if (this.fbf != null) {
            this.fbf.onDestroy();
        }
    }
}
