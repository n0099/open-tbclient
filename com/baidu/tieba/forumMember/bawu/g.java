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
    private BawuTeamInfoActivity cTv;
    private h cTw;
    private NoNetworkView cTx;
    private boolean cTy = false;
    private NavigationBar mNavigationBar;
    private View mParent;

    public View getRootView() {
        return this.mParent;
    }

    public g(BawuTeamInfoActivity bawuTeamInfoActivity) {
        this.cTv = bawuTeamInfoActivity;
        this.Tl = LayoutInflater.from(this.cTv.getPageContext().getPageActivity()).inflate(d.i.bawu_team_info_activity_layout, (ViewGroup) null);
        this.cTv.setContentView(this.Tl);
        this.mParent = this.Tl.findViewById(d.g.root_bawu_team_info);
        this.mNavigationBar = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cTv.getString(d.k.bawu_manager_team));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cTx = (NoNetworkView) this.Tl.findViewById(d.g.view_no_network);
        this.FL = (BdListView) this.Tl.findViewById(d.g.listview_bawu_team_info);
        this.cTw = new h(this.cTv.getPageContext());
        this.FL.setAdapter((ListAdapter) this.cTw);
    }

    public void a(ArrayList<i> arrayList, p pVar, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.cTy = true;
        } else {
            this.cTy = false;
        }
        if (z && this.cTy) {
            aod();
            return;
        }
        aoe();
        this.cTw.I(arrayList);
        this.cTw.a(pVar);
        this.cTw.notifyDataSetChanged();
    }

    public boolean aoc() {
        return this.cTy;
    }

    public void onChangeSkinType(int i) {
        this.cTv.getLayoutMode().setNightMode(i == 1);
        this.cTv.getLayoutMode().u(this.Tl);
        this.mNavigationBar.onChangeSkinType(this.cTv.getPageContext(), i);
        this.cTx.onChangeSkinType(this.cTv.getPageContext(), i);
        this.cTw.notifyDataSetChanged();
    }

    public void aod() {
        this.FL.setVisibility(8);
        this.cTv.showNetRefreshView(this.Tl, this.cTv.getPageContext().getResources().getString(d.k.no_data_text), true);
    }

    public void aoe() {
        this.cTv.hideNetRefreshView(this.Tl);
        this.FL.setVisibility(0);
    }

    public void f(NoNetworkView.a aVar) {
        this.cTx.a(aVar);
    }
}
