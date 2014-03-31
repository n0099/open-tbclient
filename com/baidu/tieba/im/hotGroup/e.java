package com.baidu.tieba.im.hotGroup;

import android.view.View;
import com.baidu.adp.a.f;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.im.h;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.j;
/* loaded from: classes.dex */
public final class e extends f {
    private HotGroupActivity a;
    private View c;
    private NavigationBar d;
    private NoNetworkView e;
    private View f;
    private HotGroupFragment g;

    public e(HotGroupActivity hotGroupActivity) {
        super(hotGroupActivity);
        this.a = hotGroupActivity;
        hotGroupActivity.setContentView(i.hot_group_activity);
        this.c = this.a.findViewById(h.parent);
        this.d = (NavigationBar) this.a.findViewById(h.view_navigation_bar);
        this.f = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f.setOnClickListener(this.a);
        this.d.a(j.hot_group);
        this.g = (HotGroupFragment) this.a.getSupportFragmentManager().findFragmentById(h.hot_group_fragment);
        this.e = (NoNetworkView) this.a.findViewById(h.view_no_network);
    }

    public final View a() {
        return this.f;
    }

    public final void a(int i) {
        this.a.b().a(i == 1);
        this.a.b().a(this.c);
        this.d.b(i);
        this.g.onChangeSkinType(i);
        this.e.a(i);
    }
}
