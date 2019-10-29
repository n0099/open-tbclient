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
    private com.baidu.tbadk.coreExtra.view.c cul;
    private BawuTeamInfoActivity fri;
    private h frj;
    private NoNetworkView frk;
    private boolean frl = false;
    private h.b frm;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;
    private BdListView yl;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.fri = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.fri.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.fri.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fri.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.frk = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.yl = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.frj = new h(this.fri.getPageContext());
        this.yl.setAdapter((ListAdapter) this.frj);
        this.frm = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void vC(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.amQ().b(g.this.fri.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.frj.a(this.frm);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.frl = true;
        } else {
            this.frl = false;
        }
        if (z && this.frl) {
            bit();
            return;
        }
        biu();
        this.frj.Z(arrayList);
        this.frj.a(pVar);
        this.frj.notifyDataSetChanged();
    }

    public boolean bis() {
        return this.frl;
    }

    public void onChangeSkinType(int i) {
        this.fri.getLayoutMode().setNightMode(i == 1);
        this.fri.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.fri.getPageContext(), i);
        this.frk.onChangeSkinType(this.fri.getPageContext(), i);
        this.frj.notifyDataSetChanged();
    }

    public void bit() {
        this.yl.setVisibility(8);
        this.fri.showNetRefreshView(this.mRoot, this.fri.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void biu() {
        this.fri.hideNetRefreshView(this.mRoot);
        this.yl.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.frk.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.cul == null) {
            this.cul = new com.baidu.tbadk.coreExtra.view.c(this.fri);
        }
        this.cul.asz();
        this.cul.setAccountData(accountData);
        this.cul.ju(1);
    }

    public void onDestroy() {
        if (this.cul != null) {
            this.cul.onDestroy();
        }
    }
}
