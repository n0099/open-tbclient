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
    private BdListView FH;
    private View Th;
    private BawuTeamInfoActivity cUC;
    private h cUD;
    private NoNetworkView cUE;
    private boolean cUF = false;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.cUC = bawuTeamInfoActivity;
        this.Th = LayoutInflater.from(this.cUC.getPageContext().getPageActivity()).inflate(d.i.bawu_team_info_activity_layout, (ViewGroup) null);
        this.cUC.setContentView(this.Th);
        this.mParent = this.Th.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.Th.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cUC.getString(d.k.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cUE = (NoNetworkView) this.Th.findViewById(d.g.view_no_network);
        this.FH = (BdListView) this.Th.findViewById(d.g.listview_bawu_team_info);
        this.cUD = new h(this.cUC.getPageContext());
        this.FH.setAdapter((ListAdapter) this.cUD);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.cUF = true;
        } else {
            this.cUF = false;
        }
        if (z && this.cUF) {
            aoc();
            return;
        }
        aod();
        this.cUD.I(arrayList);
        this.cUD.a(pVar);
        this.cUD.notifyDataSetChanged();
    }

    public boolean aob() {
        return this.cUF;
    }

    public void onChangeSkinType(int i) {
        this.cUC.getLayoutMode().setNightMode(i == 1);
        this.cUC.getLayoutMode().u(this.Th);
        this.mNavigationBar.onChangeSkinType(this.cUC.getPageContext(), i);
        this.cUE.onChangeSkinType(this.cUC.getPageContext(), i);
        this.cUD.notifyDataSetChanged();
    }

    public void aoc() {
        this.FH.setVisibility(8);
        this.cUC.showNetRefreshView(this.Th, this.cUC.getPageContext().getResources().getString(d.k.no_data_text), true);
    }

    public void aod() {
        this.cUC.hideNetRefreshView(this.Th);
        this.FH.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.cUE.a(aVar);
    }
}
