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
    private BdListView Nj;
    private com.baidu.tbadk.coreExtra.view.c cfZ;
    private BawuTeamInfoActivity frX;
    private h frY;
    private NoNetworkView frZ;
    private boolean fsa = false;
    private h.b fsb;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.frX = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.frX.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.frX.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.frX.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.frZ = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Nj = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.frY = new h(this.frX.getPageContext());
        this.Nj.setAdapter((ListAdapter) this.frY);
        this.fsb = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void xj(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.ajK().c(g.this.frX.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.frY.a(this.fsb);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.fsa = true;
        } else {
            this.fsa = false;
        }
        if (z && this.fsa) {
            blm();
            return;
        }
        bln();
        this.frY.U(arrayList);
        this.frY.a(pVar);
        this.frY.notifyDataSetChanged();
    }

    public boolean bll() {
        return this.fsa;
    }

    public void onChangeSkinType(int i) {
        this.frX.getLayoutMode().setNightMode(i == 1);
        this.frX.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.frX.getPageContext(), i);
        this.frZ.onChangeSkinType(this.frX.getPageContext(), i);
        this.frY.notifyDataSetChanged();
    }

    public void blm() {
        this.Nj.setVisibility(8);
        this.frX.showNetRefreshView(this.mRoot, this.frX.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bln() {
        this.frX.hideNetRefreshView(this.mRoot);
        this.Nj.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.frZ.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.cfZ == null) {
            this.cfZ = new com.baidu.tbadk.coreExtra.view.c(this.frX);
        }
        this.cfZ.aqF();
        this.cfZ.setAccountData(accountData);
        this.cfZ.jX(1);
    }

    public void onDestroy() {
        if (this.cfZ != null) {
            this.cfZ.onDestroy();
        }
    }
}
