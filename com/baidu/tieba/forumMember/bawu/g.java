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
import com.baidu.tieba.forumMember.member.l;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class g {
    private BdListView WV;
    private NoNetworkView fOl;
    private com.baidu.tbadk.coreExtra.view.b fso;
    private BawuTeamInfoActivity jaK;
    private h jaL;
    private boolean jaM = false;
    private h.b jaN;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.jaK = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.jaK.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.jaK.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jaK.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fOl = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.WV = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.jaL = new h(this.jaK.getPageContext());
        this.WV.setAdapter((ListAdapter) this.jaL);
        this.jaN = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void Kw(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    be.bwu().b(g.this.jaK.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.jaL.a(this.jaN);
    }

    public void a(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.jaM = true;
        } else {
            this.jaM = false;
        }
        if (z && this.jaM) {
            cDn();
            return;
        }
        cDo();
        this.jaL.ay(arrayList);
        this.jaL.a(lVar);
        this.jaL.notifyDataSetChanged();
    }

    public boolean cDm() {
        return this.jaM;
    }

    public void onChangeSkinType(int i) {
        this.jaK.getLayoutMode().setNightMode(i == 1);
        this.jaK.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jaK.getPageContext(), i);
        this.fOl.onChangeSkinType(this.jaK.getPageContext(), i);
        this.jaL.notifyDataSetChanged();
    }

    public void cDn() {
        this.WV.setVisibility(8);
        this.jaK.showNetRefreshView(this.mRoot, this.jaK.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cDo() {
        this.jaK.hideNetRefreshView(this.mRoot);
        this.WV.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.fOl.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.fso == null) {
            this.fso = new com.baidu.tbadk.coreExtra.view.b(this.jaK);
        }
        this.fso.bDb();
        this.fso.setAccountData(accountData);
        this.fso.se(1);
    }

    public void onDestroy() {
        if (this.fso != null) {
            this.fso.onDestroy();
        }
    }
}
