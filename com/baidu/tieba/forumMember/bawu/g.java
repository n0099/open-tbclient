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
    private View aId;
    private BdListView avh;
    private BawuTeamInfoActivity dAV;
    private h dAW;
    private NoNetworkView dAX;
    private boolean dAY = false;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.dAV = bawuTeamInfoActivity;
        this.aId = LayoutInflater.from(this.dAV.getPageContext().getPageActivity()).inflate(d.h.bawu_team_info_activity_layout, (ViewGroup) null);
        this.dAV.setContentView(this.aId);
        this.mParent = this.aId.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.aId.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dAV.getString(d.j.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dAX = (NoNetworkView) this.aId.findViewById(d.g.view_no_network);
        this.avh = (BdListView) this.aId.findViewById(d.g.listview_bawu_team_info);
        this.dAW = new h(this.dAV.getPageContext());
        this.avh.setAdapter((ListAdapter) this.dAW);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.dAY = true;
        } else {
            this.dAY = false;
        }
        if (z && this.dAY) {
            atO();
            return;
        }
        atP();
        this.dAW.I(arrayList);
        this.dAW.a(pVar);
        this.dAW.notifyDataSetChanged();
    }

    public boolean atN() {
        return this.dAY;
    }

    public void onChangeSkinType(int i) {
        this.dAV.getLayoutMode().aQ(i == 1);
        this.dAV.getLayoutMode().aM(this.aId);
        this.mNavigationBar.onChangeSkinType(this.dAV.getPageContext(), i);
        this.dAX.onChangeSkinType(this.dAV.getPageContext(), i);
        this.dAW.notifyDataSetChanged();
    }

    public void atO() {
        this.avh.setVisibility(8);
        this.dAV.showNetRefreshView(this.aId, this.dAV.getPageContext().getResources().getString(d.j.no_data_text), true);
    }

    public void atP() {
        this.dAV.hideNetRefreshView(this.aId);
        this.avh.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.dAX.a(aVar);
    }
}
