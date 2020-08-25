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
/* loaded from: classes17.dex */
public class g {
    private BdListView Vo;
    private NoNetworkView eUf;
    private com.baidu.tbadk.coreExtra.view.b ezx;
    private BawuTeamInfoActivity hOq;
    private h hOr;
    private boolean hOs = false;
    private h.b hOt;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.hOq = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.hOq.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.hOq.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hOq.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eUf = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Vo = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.hOr = new h(this.hOq.getPageContext());
        this.Vo.setAdapter((ListAdapter) this.hOr);
        this.hOt = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void Ig(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    be.bju().b(g.this.hOq.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.hOr.a(this.hOt);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.hOs = true;
        } else {
            this.hOs = false;
        }
        if (z && this.hOs) {
            ckh();
            return;
        }
        cki();
        this.hOr.at(arrayList);
        this.hOr.a(pVar);
        this.hOr.notifyDataSetChanged();
    }

    public boolean ckg() {
        return this.hOs;
    }

    public void onChangeSkinType(int i) {
        this.hOq.getLayoutMode().setNightMode(i == 1);
        this.hOq.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hOq.getPageContext(), i);
        this.eUf.onChangeSkinType(this.hOq.getPageContext(), i);
        this.hOr.notifyDataSetChanged();
    }

    public void ckh() {
        this.Vo.setVisibility(8);
        this.hOq.showNetRefreshView(this.mRoot, this.hOq.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cki() {
        this.hOq.hideNetRefreshView(this.mRoot);
        this.Vo.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.eUf.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.ezx == null) {
            this.ezx = new com.baidu.tbadk.coreExtra.view.b(this.hOq);
        }
        this.ezx.bpU();
        this.ezx.setAccountData(accountData);
        this.ezx.pN(1);
    }

    public void onDestroy() {
        if (this.ezx != null) {
            this.ezx.onDestroy();
        }
    }
}
