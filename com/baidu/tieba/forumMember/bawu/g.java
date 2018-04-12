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
    private BdListView FL;
    private View Tl;
    private NoNetworkView cTA;
    private boolean cTB = false;
    private BawuTeamInfoActivity cTy;
    private h cTz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.cTy = bawuTeamInfoActivity;
        this.Tl = LayoutInflater.from(this.cTy.getPageContext().getPageActivity()).inflate(d.i.bawu_team_info_activity_layout, (ViewGroup) null);
        this.cTy.setContentView(this.Tl);
        this.mParent = this.Tl.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cTy.getString(d.k.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cTA = (NoNetworkView) this.Tl.findViewById(d.g.view_no_network);
        this.FL = (BdListView) this.Tl.findViewById(d.g.listview_bawu_team_info);
        this.cTz = new h(this.cTy.getPageContext());
        this.FL.setAdapter((ListAdapter) this.cTz);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.cTB = true;
        } else {
            this.cTB = false;
        }
        if (z && this.cTB) {
            aod();
            return;
        }
        aoe();
        this.cTz.I(arrayList);
        this.cTz.a(pVar);
        this.cTz.notifyDataSetChanged();
    }

    public boolean aoc() {
        return this.cTB;
    }

    public void onChangeSkinType(int i) {
        this.cTy.getLayoutMode().setNightMode(i == 1);
        this.cTy.getLayoutMode().u(this.Tl);
        this.mNavigationBar.onChangeSkinType(this.cTy.getPageContext(), i);
        this.cTA.onChangeSkinType(this.cTy.getPageContext(), i);
        this.cTz.notifyDataSetChanged();
    }

    public void aod() {
        this.FL.setVisibility(8);
        this.cTy.showNetRefreshView(this.Tl, this.cTy.getPageContext().getResources().getString(d.k.no_data_text), true);
    }

    public void aoe() {
        this.cTy.hideNetRefreshView(this.Tl);
        this.FL.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.cTA.a(aVar);
    }
}
