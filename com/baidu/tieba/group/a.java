package com.baidu.tieba.group;

import android.view.View;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private BaseFragmentActivity f1429a;
    private GroupActivity b;
    private NavigationBar c;
    private View d;
    private GroupTabWidget e;
    private GroupTabWidget f;
    private GroupTabWidget g;
    private GroupTabWidget h;
    private GroupTabWidget i;

    public a(BaseFragmentActivity baseFragmentActivity, GroupActivity groupActivity) {
        this.f1429a = baseFragmentActivity;
        this.b = groupActivity;
        this.d = this.b.q();
        this.c = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.c.a(this.f1429a.getString(R.string.groups));
        this.e = (GroupTabWidget) this.d.findViewById(R.id.nearby_widget);
        this.e.setOnClickListener(this.b);
        this.f = (GroupTabWidget) this.d.findViewById(R.id.hot_widget);
        this.f.setOnClickListener(this.b);
        this.g = (GroupTabWidget) this.d.findViewById(R.id.my_widget);
        this.g.setOnClickListener(this.b);
        this.h = (GroupTabWidget) this.d.findViewById(R.id.addgroup_widget);
        this.h.setOnClickListener(this.b);
        this.i = (GroupTabWidget) this.d.findViewById(R.id.quick_response_widget);
        this.i.setOnClickListener(this.b);
    }

    public void a(int i) {
        this.f1429a.a().a(i == 1);
        this.f1429a.a().a(this.d);
        this.c.c(i);
        this.e.a(i);
        this.f.a(i);
        this.g.a(i);
        this.h.a(i);
        this.i.a(i);
    }

    public void b(int i) {
        String str;
        if (i <= 0) {
            this.e.setText("附近群组");
            return;
        }
        this.e.a("附近群组(" + i + ")", 5, str.length() - 1);
    }
}
