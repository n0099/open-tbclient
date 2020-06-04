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
    private BawuTeamInfoActivity hjg;
    private h hjh;
    private NoNetworkView hji;
    private boolean hjj = false;
    private h.b hjk;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.hjg = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.hjg.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.hjg.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hjg.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hji = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.Um = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.hjh = new h(this.hjg.getPageContext());
        this.Um.setAdapter((ListAdapter) this.hjh);
        this.hjk = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void Et(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    ba.aVa().b(g.this.hjg.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.hjh.a(this.hjk);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.hjj = true;
        } else {
            this.hjj = false;
        }
        if (z && this.hjj) {
            bTv();
            return;
        }
        bTw();
        this.hjh.am(arrayList);
        this.hjh.a(pVar);
        this.hjh.notifyDataSetChanged();
    }

    public boolean bTu() {
        return this.hjj;
    }

    public void onChangeSkinType(int i) {
        this.hjg.getLayoutMode().setNightMode(i == 1);
        this.hjg.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hjg.getPageContext(), i);
        this.hji.onChangeSkinType(this.hjg.getPageContext(), i);
        this.hjh.notifyDataSetChanged();
    }

    public void bTv() {
        this.Um.setVisibility(8);
        this.hjg.showNetRefreshView(this.mRoot, this.hjg.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void bTw() {
        this.hjg.hideNetRefreshView(this.mRoot);
        this.Um.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.hji.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.eap == null) {
            this.eap = new com.baidu.tbadk.coreExtra.view.b(this.hjg);
        }
        this.eap.bbx();
        this.eap.setAccountData(accountData);
        this.eap.mQ(1);
    }

    public void onDestroy() {
        if (this.eap != null) {
            this.eap.onDestroy();
        }
    }
}
