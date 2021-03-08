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
import com.baidu.tieba.forumMember.member.l;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class g {
    private BdListView Yj;
    private NoNetworkView fNp;
    private com.baidu.tbadk.coreExtra.view.b frx;
    private BawuTeamInfoActivity jdH;
    private h jdI;
    private boolean jdJ = false;
    private h.b jdK;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.jdH = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.jdH.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.jdH.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jdH.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fNp = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Yj = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.jdI = new h(this.jdH.getPageContext());
        this.Yj.setAdapter((ListAdapter) this.jdI);
        this.jdK = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void Kf(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    bf.bsY().b(g.this.jdH.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.jdI.a(this.jdK);
    }

    public void a(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.jdJ = true;
        } else {
            this.jdJ = false;
        }
        if (z && this.jdJ) {
            cAU();
            return;
        }
        cAV();
        this.jdI.as(arrayList);
        this.jdI.a(lVar);
        this.jdI.notifyDataSetChanged();
    }

    public boolean cAT() {
        return this.jdJ;
    }

    public void onChangeSkinType(int i) {
        this.jdH.getLayoutMode().setNightMode(i == 1);
        this.jdH.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jdH.getPageContext(), i);
        this.fNp.onChangeSkinType(this.jdH.getPageContext(), i);
        this.jdI.notifyDataSetChanged();
    }

    public void cAU() {
        this.Yj.setVisibility(8);
        this.jdH.showNetRefreshView(this.mRoot, this.jdH.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cAV() {
        this.jdH.hideNetRefreshView(this.mRoot);
        this.Yj.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.fNp.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.frx == null) {
            this.frx = new com.baidu.tbadk.coreExtra.view.b(this.jdH);
        }
        this.frx.bzD();
        this.frx.setAccountData(accountData);
        this.frx.qE(1);
    }

    public void onDestroy() {
        if (this.frx != null) {
            this.frx.onDestroy();
        }
    }
}
