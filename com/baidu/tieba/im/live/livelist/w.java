package com.baidu.tieba.im.live.livelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.f {
    private FrsLiveListActivity a;
    private o b;
    private ViewGroup c;
    private NavigationBar d;
    private BdListView e;
    private NoNetworkView f;

    public w(FrsLiveListActivity frsLiveListActivity) {
        super(frsLiveListActivity);
        this.a = frsLiveListActivity;
        frsLiveListActivity.setContentView(com.baidu.tieba.v.live_frs_list_activity);
        a(frsLiveListActivity);
        b(frsLiveListActivity);
    }

    private void a(FrsLiveListActivity frsLiveListActivity) {
        this.c = (ViewGroup) this.a.findViewById(com.baidu.tieba.u.rootView);
        this.d = (NavigationBar) this.a.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.d.a(this.a.getString(com.baidu.tieba.x.live_frs_list_title));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (NoNetworkView) this.a.findViewById(com.baidu.tieba.u.view_no_network);
    }

    private void b(FrsLiveListActivity frsLiveListActivity) {
        this.e = (BdListView) this.a.findViewById(com.baidu.tieba.u.live_list);
        this.b = new o(this.a);
        this.b.a(true);
        this.e.setAdapter((ListAdapter) this.b);
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.c);
        this.d.c(i);
        this.f.a(i);
    }

    public void a() {
        this.e.d();
    }

    public void b() {
        this.b.notifyDataSetChanged();
    }

    public o c() {
        return this.b;
    }

    public BdListView d() {
        return this.e;
    }
}
