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
/* loaded from: classes23.dex */
public class g {
    private BdListView VX;
    private com.baidu.tbadk.coreExtra.view.b eNM;
    private NoNetworkView fjl;
    private BawuTeamInfoActivity ikv;
    private h ikw;
    private boolean ikx = false;
    private h.b iky;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.ikv = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.ikv.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.ikv.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ikv.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fjl = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.VX = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.ikw = new h(this.ikv.getPageContext());
        this.VX.setAdapter((ListAdapter) this.ikw);
        this.iky = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void Jr(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    be.bmY().b(g.this.ikv.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.ikw.a(this.iky);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.ikx = true;
        } else {
            this.ikx = false;
        }
        if (z && this.ikx) {
            cqT();
            return;
        }
        cqU();
        this.ikw.av(arrayList);
        this.ikw.a(pVar);
        this.ikw.notifyDataSetChanged();
    }

    public boolean cqS() {
        return this.ikx;
    }

    public void onChangeSkinType(int i) {
        this.ikv.getLayoutMode().setNightMode(i == 1);
        this.ikv.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.ikv.getPageContext(), i);
        this.fjl.onChangeSkinType(this.ikv.getPageContext(), i);
        this.ikw.notifyDataSetChanged();
    }

    public void cqT() {
        this.VX.setVisibility(8);
        this.ikv.showNetRefreshView(this.mRoot, this.ikv.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cqU() {
        this.ikv.hideNetRefreshView(this.mRoot);
        this.VX.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.fjl.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.eNM == null) {
            this.eNM = new com.baidu.tbadk.coreExtra.view.b(this.ikv);
        }
        this.eNM.btz();
        this.eNM.setAccountData(accountData);
        this.eNM.qy(1);
    }

    public void onDestroy() {
        if (this.eNM != null) {
            this.eNM.onDestroy();
        }
    }
}
