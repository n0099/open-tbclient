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
    private com.baidu.tbadk.coreExtra.view.b fbX;
    private NoNetworkView fxC;
    private BawuTeamInfoActivity iCQ;
    private h iCR;
    private boolean iCS = false;
    private h.b iCT;
    private NavigationBar mNavigationBar;
    private View mParent;
    private View mRoot;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.iCQ = bawuTeamInfoActivity;
        this.mRoot = LayoutInflater.from(this.iCQ.getPageContext().getPageActivity()).inflate(R.layout.bawu_team_info_activity_layout, (ViewGroup) null);
        this.iCQ.setContentView(this.mRoot);
        this.mParent = this.mRoot.findViewById(R.id.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iCQ.getString(R.string.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.fxC = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.VY = (BdListView) this.mRoot.findViewById(R.id.listview_bawu_team_info);
        this.iCR = new h(this.iCQ.getPageContext());
        this.VY.setAdapter((ListAdapter) this.iCR);
        this.iCT = new h.b() { // from class: com.baidu.tieba.forumMember.bawu.g.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.forumMember.bawu.h.b
            public void Kh(String str) {
                if (!TbadkCoreApplication.isLogin() || !StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    be.brr().b(g.this.iCQ.getPageContext(), new String[]{str});
                } else {
                    g.this.i(TbadkCoreApplication.getCurrentAccountInfo());
                }
            }
        };
        this.iCR.a(this.iCT);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.iCS = true;
        } else {
            this.iCS = false;
        }
        if (z && this.iCS) {
            cwB();
            return;
        }
        cwC();
        this.iCR.aw(arrayList);
        this.iCR.a(pVar);
        this.iCR.notifyDataSetChanged();
    }

    public boolean cwA() {
        return this.iCS;
    }

    public void onChangeSkinType(int i) {
        this.iCQ.getLayoutMode().setNightMode(i == 1);
        this.iCQ.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iCQ.getPageContext(), i);
        this.fxC.onChangeSkinType(this.iCQ.getPageContext(), i);
        this.iCR.notifyDataSetChanged();
    }

    public void cwB() {
        this.VY.setVisibility(8);
        this.iCQ.showNetRefreshView(this.mRoot, this.iCQ.getPageContext().getResources().getString(R.string.no_data_text), true);
    }

    public void cwC() {
        this.iCQ.hideNetRefreshView(this.mRoot);
        this.VY.setVisibility(0);
    }

    public void e(NoNetworkView.a aVar) {
        this.fxC.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.fbX == null) {
            this.fbX = new com.baidu.tbadk.coreExtra.view.b(this.iCQ);
        }
        this.fbX.bxR();
        this.fbX.setAccountData(accountData);
        this.fbX.qT(1);
    }

    public void onDestroy() {
        if (this.fbX != null) {
            this.fbX.onDestroy();
        }
    }
}
