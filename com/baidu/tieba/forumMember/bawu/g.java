package com.baidu.tieba.forumMember.bawu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private View aHT;
    private BdListView auZ;
    private BawuTeamInfoActivity dAM;
    private h dAN;
    private NoNetworkView dAO;
    private boolean dAP = false;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dAM = bawuTeamInfoActivity;
        this.aHT = LayoutInflater.from(this.dAM.getPageContext().getPageActivity()).inflate(d.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dAM.setContentView(this.aHT);
        this.mParent = this.aHT.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.aHT.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dAM.getString(d.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dAO = (NoNetworkView) this.aHT.findViewById(d.g.view_no_network);
        this.auZ = (BdListView) this.aHT.findViewById(d.g.listview_bawu_team_info);
        this.dAN = new h(this.dAM.getPageContext());
        this.auZ.setAdapter((ListAdapter) this.dAN);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.dAP = true;
        } else {
            this.dAP = false;
        }
        if (z && this.dAP) {
            atO();
            return;
        }
        atP();
        this.dAN.I(arrayList);
        this.dAN.a(pVar);
        this.dAN.notifyDataSetChanged();
    }

    public boolean atN() {
        return this.dAP;
    }

    public void onChangeSkinType(int i) {
        this.dAM.getLayoutMode().aQ(i == 1);
        this.dAM.getLayoutMode().aM(this.aHT);
        this.mNavigationBar.onChangeSkinType(this.dAM.getPageContext(), i);
        this.dAO.onChangeSkinType(this.dAM.getPageContext(), i);
        this.dAN.notifyDataSetChanged();
    }

    public void atO() {
        this.auZ.setVisibility(8);
        this.dAM.showNetRefreshView(this.aHT, this.dAM.getPageContext().getResources().getString(d.j.no_data_text), true);
    }

    public void atP() {
        this.dAM.hideNetRefreshView(this.aHT);
        this.auZ.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dAO.a(aVar);
    }
}
