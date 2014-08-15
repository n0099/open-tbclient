package com.baidu.tieba.discover.memberprivilege;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    private MemberPrivilegeActivity a;
    private View b;
    private NavigationBar c;
    private NoNetworkView d;
    private BdListView e;
    private c f;

    public f(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity);
        this.a = memberPrivilegeActivity;
        b();
    }

    private void b() {
        this.a.setContentView(v.memberprivilege_activity);
        this.b = this.a.findViewById(u.root);
        this.c = (NavigationBar) this.b.findViewById(u.navigationbar);
        this.c.a(x.member_center);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = (NoNetworkView) this.b.findViewById(u.nonetworkview);
        this.d.a(new g(this));
        this.e = (BdListView) this.b.findViewById(u.listview);
        this.f = new c(this.a);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(this.a);
    }

    public c a() {
        return this.f;
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.b);
        this.c.c(i);
        this.d.a(i);
    }
}
