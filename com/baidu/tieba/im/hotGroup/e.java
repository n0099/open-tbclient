package com.baidu.tieba.im.hotGroup;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.c {
    private HotGroupActivity a;
    private View b;
    private NavigationBar c;
    private NoNetworkView d;
    private View e;
    private HotGroupFragment f;

    public e(HotGroupActivity hotGroupActivity) {
        super(hotGroupActivity);
        this.a = hotGroupActivity;
        hotGroupActivity.setContentView(w.hot_group_activity);
        b();
    }

    private void b() {
        this.b = this.a.findViewById(v.parent);
        this.c = (NavigationBar) this.a.findViewById(v.view_navigation_bar);
        this.e = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.setOnClickListener(this.a);
        this.c.a(y.hot_group);
        this.f = (HotGroupFragment) this.a.getSupportFragmentManager().findFragmentById(v.hot_group_fragment);
        this.d = (NoNetworkView) this.a.findViewById(v.view_no_network);
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
