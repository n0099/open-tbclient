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
/* loaded from: classes8.dex */
public class g {
    private BdListView WO;
    private NoNetworkView fLP;
    private com.baidu.tbadk.coreExtra.view.b fpW;
    private BawuTeamInfoActivity jbK;
    private h jbL;
    private boolean jbM = false;
    private h.b jbN;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.jbK = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.jbK.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.jbK.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jbK.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fLP = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.WO = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.jbL = new h(this.jbK.getPageContext());
        this.WO.setAdapter((ListAdapter) this.jbL);
        this.jbN = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void JV(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    bf.bsV().b(g.this.jbK.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.jbL.a(this.jbN);
    }

    public void a(ArrayList<i> arrayList, l lVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.jbM = true;
        } else {
            this.jbM = false;
        }
        if (z && this.jbM) {
            cAH();
            return;
        }
        cAI();
        this.jbL.as(arrayList);
        this.jbL.a(lVar);
        this.jbL.notifyDataSetChanged();
    }

    public boolean cAG() {
        return this.jbM;
    }

    public void onChangeSkinType(int i) {
        this.jbK.getLayoutMode().setNightMode(i == 1);
        this.jbK.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jbK.getPageContext(), i);
        this.fLP.onChangeSkinType(this.jbK.getPageContext(), i);
        this.jbL.notifyDataSetChanged();
    }

    public void cAH() {
        this.WO.setVisibility(8);
        this.jbK.showNetRefreshView(this.mRoot, this.jbK.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cAI() {
        this.jbK.hideNetRefreshView(this.mRoot);
        this.WO.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.fLP.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.fpW == null) {
            this.fpW = new com.baidu.tbadk.coreExtra.view.b(this.jbK);
        }
        this.fpW.bzA();
        this.fpW.setAccountData(accountData);
        this.fpW.qD(1);
    }

    public void onDestroy() {
        if (this.fpW != null) {
            this.fpW.onDestroy();
        }
    }
}
