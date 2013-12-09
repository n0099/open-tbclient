package com.baidu.tieba.im.hotGroup;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.a.e;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private HotGroupActivity f1785a;
    private View c;
    private NavigationBar d;
    private NoNetworkView e;
    private ImageView f;
    private HotGroupFragment g;

    public d(HotGroupActivity hotGroupActivity) {
        super(hotGroupActivity);
        this.f1785a = hotGroupActivity;
        hotGroupActivity.setContentView(R.layout.hot_group_activity);
        e();
    }

    private void e() {
        this.c = this.f1785a.findViewById(R.id.parent);
        this.d = (NavigationBar) this.f1785a.findViewById(R.id.view_navigation_bar);
        this.d.a(R.string.hot_group);
        this.f = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f.setOnClickListener(this.f1785a);
        this.g = (HotGroupFragment) this.f1785a.getSupportFragmentManager().a(R.id.hot_group_fragment);
        this.e = (NoNetworkView) this.f1785a.findViewById(R.id.view_no_network);
    }

    public ImageView a() {
        return this.f;
    }

    public void a(int i) {
        this.f1785a.a().a(i == 1);
        this.f1785a.a().a(this.c);
        this.d.c(i);
        this.g.c(i);
        this.e.a(i);
    }
}
