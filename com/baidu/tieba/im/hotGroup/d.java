package com.baidu.tieba.im.hotGroup;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.a.e;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends e {
    private HotGroupActivity a;
    private View c;
    private NavigationBar d;
    private NoNetworkView e;
    private ImageView f;
    private HotGroupFragment g;

    public d(HotGroupActivity hotGroupActivity) {
        super(hotGroupActivity);
        this.a = hotGroupActivity;
        hotGroupActivity.setContentView(R.layout.hot_group_activity);
        e();
    }

    private void e() {
        this.c = this.a.findViewById(R.id.parent);
        this.d = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.d.a(R.string.hot_group);
        this.f = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f.setOnClickListener(this.a);
        this.g = (HotGroupFragment) this.a.getSupportFragmentManager().a(R.id.hot_group_fragment);
        this.e = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
    }

    public ImageView a() {
        return this.f;
    }

    public void a(int i) {
        this.a.a().a(i == 1);
        this.a.a().a(this.c);
        this.d.c(i);
        this.g.d(i);
        this.e.a(i);
    }
}
