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
/* loaded from: classes23.dex */
public class g {
    private BdListView WX;
    private NoNetworkView fEG;
    private com.baidu.tbadk.coreExtra.view.b fiF;
    private h iOA;
    private boolean iOB = false;
    private h.b iOC;
    private BawuTeamInfoActivity iOz;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.iOz = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.iOz.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.iOz.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iOz.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fEG = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.WX = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.iOA = new h(this.iOz.getPageContext());
        this.WX.setAdapter((ListAdapter) this.iOA);
        this.iOC = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void Ky(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    bf.bua().b(g.this.iOz.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.iOA.a(this.iOC);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.iOB = true;
        } else {
            this.iOB = false;
        }
        if (z && this.iOB) {
            cAu();
            return;
        }
        cAv();
        this.iOA.ay(arrayList);
        this.iOA.a(pVar);
        this.iOA.notifyDataSetChanged();
    }

    public boolean cAt() {
        return this.iOB;
    }

    public void onChangeSkinType(int i) {
        this.iOz.getLayoutMode().setNightMode(i == 1);
        this.iOz.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iOz.getPageContext(), i);
        this.fEG.onChangeSkinType(this.iOz.getPageContext(), i);
        this.iOA.notifyDataSetChanged();
    }

    public void cAu() {
        this.WX.setVisibility(8);
        this.iOz.showNetRefreshView(this.mRoot, this.iOz.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cAv() {
        this.iOz.hideNetRefreshView(this.mRoot);
        this.WX.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.fEG.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.fiF == null) {
            this.fiF = new com.baidu.tbadk.coreExtra.view.b(this.iOz);
        }
        this.fiF.bAH();
        this.fiF.setAccountData(accountData);
        this.fiF.rS(1);
    }

    public void onDestroy() {
        if (this.fiF != null) {
            this.fiF.onDestroy();
        }
    }
}
