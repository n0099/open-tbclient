package com.baidu.tieba.group;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a {
    TextView a;
    private BaseFragmentActivity b;
    private GroupActivity c;
    private NavigationBar d;
    private View e;
    private GroupTabWidget f;
    private GroupTabWidget g;
    private GroupTabWidget h;
    private GroupTabWidget i;
    private GroupTabWidget j;
    private NoNetworkView k;

    public a(BaseFragmentActivity baseFragmentActivity, GroupActivity groupActivity) {
        this.a = null;
        this.b = baseFragmentActivity;
        this.c = groupActivity;
        this.e = this.c.q();
        this.d = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.d.a(this.b.getString(R.string.groups));
        this.a = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c);
        this.f = (GroupTabWidget) this.e.findViewById(R.id.nearby_widget);
        this.f.setOnClickListener(this.c);
        this.g = (GroupTabWidget) this.e.findViewById(R.id.hot_widget);
        this.g.setOnClickListener(this.c);
        this.h = (GroupTabWidget) this.e.findViewById(R.id.my_widget);
        this.h.setOnClickListener(this.c);
        this.i = (GroupTabWidget) this.e.findViewById(R.id.addgroup_widget);
        this.i.setOnClickListener(this.c);
        this.j = (GroupTabWidget) this.e.findViewById(R.id.quick_response_widget);
        this.j.setOnClickListener(this.c);
        this.k = (NoNetworkView) this.e.findViewById(R.id.view_no_network_group);
    }

    public void a(int i) {
        this.b.a().a(i == 1);
        this.b.a().a(this.e);
        this.d.c(i);
        this.f.a(i);
        this.g.a(i);
        this.h.a(i);
        this.i.a(i);
        this.j.a(i);
        this.k.a(i);
    }

    public void b(int i) {
        String str;
        if (i <= 0) {
            this.f.setText("附近群组");
            return;
        }
        this.f.a("附近群组(" + i + ")", 5, str.length() - 1);
    }
}
