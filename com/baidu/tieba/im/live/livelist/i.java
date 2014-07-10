package com.baidu.tieba.im.live.livelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f {
    private BlackMembersListActivity a;
    private e b;
    private ViewGroup c;
    private NavigationBar d;
    private BdListView e;
    private ViewGroup f;
    private View g;
    private TextView h;

    public i(BlackMembersListActivity blackMembersListActivity) {
        super(blackMembersListActivity);
        this.a = blackMembersListActivity;
        blackMembersListActivity.setContentView(com.baidu.tieba.w.live_black_members_activity);
        a(blackMembersListActivity);
        b(blackMembersListActivity);
    }

    private void a(BlackMembersListActivity blackMembersListActivity) {
        this.c = (ViewGroup) this.a.findViewById(com.baidu.tieba.v.rootView);
        this.d = (NavigationBar) this.a.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.d.a(this.a.getString(com.baidu.tieba.y.live_black_members_title));
        this.g = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g.setOnClickListener(this.a);
        this.h = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(com.baidu.tieba.y.members_edit));
        this.h.setOnClickListener(this.a);
    }

    public View a() {
        return this.g;
    }

    public TextView b() {
        return this.h;
    }

    private void b(BlackMembersListActivity blackMembersListActivity) {
        this.f = (ViewGroup) this.a.findViewById(com.baidu.tieba.v.no_data_container);
        this.e = (BdListView) this.a.findViewById(com.baidu.tieba.v.black_list);
        this.b = new e(this.a);
        this.e.setAdapter((ListAdapter) this.b);
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.c);
        this.d.c(i);
    }

    public void c() {
        this.b.notifyDataSetChanged();
    }

    public BdListView d() {
        return this.e;
    }

    public e e() {
        return this.b;
    }

    public void a(boolean z) {
        if (z) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            return;
        }
        this.e.setVisibility(0);
        this.f.setVisibility(8);
    }
}
