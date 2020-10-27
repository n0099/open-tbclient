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
    private BdListView VY;
    private com.baidu.tbadk.coreExtra.view.b eWi;
    private NoNetworkView frK;
    private BawuTeamInfoActivity iwT;
    private h iwU;
    private boolean iwV = false;
    private h.b iwW;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.iwT = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.iwT.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.iwT.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iwT.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.frK = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.VY = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.iwU = new h(this.iwT.getPageContext());
        this.VY.setAdapter((ListAdapter) this.iwU);
        this.iwW = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void JQ(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    be.boR().b(g.this.iwT.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.iwU.a(this.iwW);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.iwV = true;
        } else {
            this.iwV = false;
        }
        if (z && this.iwV) {
            cua();
            return;
        }
        cub();
        this.iwU.aw(arrayList);
        this.iwU.a(pVar);
        this.iwU.notifyDataSetChanged();
    }

    public boolean ctZ() {
        return this.iwV;
    }

    public void onChangeSkinType(int i) {
        this.iwT.getLayoutMode().setNightMode(i == 1);
        this.iwT.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iwT.getPageContext(), i);
        this.frK.onChangeSkinType(this.iwT.getPageContext(), i);
        this.iwU.notifyDataSetChanged();
    }

    public void cua() {
        this.VY.setVisibility(8);
        this.iwT.showNetRefreshView(this.mRoot, this.iwT.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cub() {
        this.iwT.hideNetRefreshView(this.mRoot);
        this.VY.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.frK.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.eWi == null) {
            this.eWi = new com.baidu.tbadk.coreExtra.view.b(this.iwT);
        }
        this.eWi.bvs();
        this.eWi.setAccountData(accountData);
        this.eWi.qJ(1);
    }

    public void onDestroy() {
        if (this.eWi != null) {
            this.eWi.onDestroy();
        }
    }
}
