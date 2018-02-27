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
    private View aHS;
    private BdListView auY;
    private BawuTeamInfoActivity dAJ;
    private h dAK;
    private NoNetworkView dAL;
    private boolean dAM = false;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dAJ = bawuTeamInfoActivity;
        this.aHS = LayoutInflater.from(this.dAJ.getPageContext().getPageActivity()).inflate(d.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dAJ.setContentView(this.aHS);
        this.mParent = this.aHS.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.aHS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dAJ.getString(d.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dAL = (NoNetworkView) this.aHS.findViewById(d.g.view_no_network);
        this.auY = (BdListView) this.aHS.findViewById(d.g.listview_bawu_team_info);
        this.dAK = new h(this.dAJ.getPageContext());
        this.auY.setAdapter((ListAdapter) this.dAK);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.dAM = true;
        } else {
            this.dAM = false;
        }
        if (z && this.dAM) {
            atN();
            return;
        }
        atO();
        this.dAK.I(arrayList);
        this.dAK.a(pVar);
        this.dAK.notifyDataSetChanged();
    }

    public boolean atM() {
        return this.dAM;
    }

    public void onChangeSkinType(int i) {
        this.dAJ.getLayoutMode().aQ(i == 1);
        this.dAJ.getLayoutMode().aM(this.aHS);
        this.mNavigationBar.onChangeSkinType(this.dAJ.getPageContext(), i);
        this.dAL.onChangeSkinType(this.dAJ.getPageContext(), i);
        this.dAK.notifyDataSetChanged();
    }

    public void atN() {
        this.auY.setVisibility(8);
        this.dAJ.showNetRefreshView(this.aHS, this.dAJ.getPageContext().getResources().getString(d.j.no_data_text), true);
    }

    public void atO() {
        this.dAJ.hideNetRefreshView(this.aHS);
        this.auY.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dAL.a(aVar);
    }
}
