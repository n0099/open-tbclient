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
/* loaded from: classes10.dex */
public class g {
    private BdListView Um;
    private com.baidu.tbadk.coreExtra.view.b eap;
    private BawuTeamInfoActivity hiV;
    private h hiW;
    private NoNetworkView hiX;
    private boolean hiY = false;
    private h.b hiZ;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.hiV = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.hiV.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.hiV.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hiV.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hiX = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Um = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.hiW = new h(this.hiV.getPageContext());
        this.Um.setAdapter((ListAdapter) this.hiW);
        this.hiZ = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void Et(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aUZ().b(g.this.hiV.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.hiW.a(this.hiZ);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.hiY = true;
        } else {
            this.hiY = false;
        }
        if (z && this.hiY) {
            bTt();
            return;
        }
        bTu();
        this.hiW.am(arrayList);
        this.hiW.a(pVar);
        this.hiW.notifyDataSetChanged();
    }

    public boolean bTs() {
        return this.hiY;
    }

    public void onChangeSkinType(int i) {
        this.hiV.getLayoutMode().setNightMode(i == 1);
        this.hiV.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hiV.getPageContext(), i);
        this.hiX.onChangeSkinType(this.hiV.getPageContext(), i);
        this.hiW.notifyDataSetChanged();
    }

    public void bTt() {
        this.Um.setVisibility(8);
        this.hiV.showNetRefreshView(this.mRoot, this.hiV.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bTu() {
        this.hiV.hideNetRefreshView(this.mRoot);
        this.Um.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.hiX.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.eap == null) {
            this.eap = new com.baidu.tbadk.coreExtra.view.b(this.hiV);
        }
        this.eap.bbw();
        this.eap.setAccountData(accountData);
        this.eap.mO(1);
    }

    public void onDestroy() {
        if (this.eap != null) {
            this.eap.onDestroy();
        }
    }
}
