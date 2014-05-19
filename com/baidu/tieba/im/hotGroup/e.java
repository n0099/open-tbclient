package com.baidu.tieba.im.hotGroup;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    private HotGroupActivity a;
    private View b;
    private NavigationBar c;
    private NoNetworkView d;
    private View e;
    private HotGroupFragment f;

    public e(HotGroupActivity hotGroupActivity) {
        super(hotGroupActivity);
        this.a = hotGroupActivity;
        hotGroupActivity.setContentView(s.hot_group_activity);
        b();
    }

    private void b() {
        this.b = this.a.findViewById(r.parent);
        this.c = (NavigationBar) this.a.findViewById(r.view_navigation_bar);
        this.e = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.setOnClickListener(this.a);
        this.c.a(u.hot_group);
        this.f = (HotGroupFragment) this.a.getSupportFragmentManager().findFragmentById(r.hot_group_fragment);
        this.d = (NoNetworkView) this.a.findViewById(r.view_no_network);
    }

    public View a() {
        return this.e;
    }

    public void a(int i) {
        this.a.a().a(i == 1);
        this.a.a().a(this.b);
        this.c.c(i);
        this.f.c(i);
        this.d.a(i);
    }
}
