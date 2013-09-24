package com.baidu.tieba.forumdetail;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.tieba.util.as;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.a.d {
    com.baidu.tieba.j b;
    private ForumDetailData c;
    private ViewGroup d;
    private ProgressBar e;
    private NavigationBar f;
    private ItemHeaderView g;
    private ItemInfoView h;
    private ItemHotThreadView i;
    private ItemFootNavView j;

    public e(com.baidu.tieba.j jVar) {
        super(jVar);
        this.b = null;
        this.c = null;
        this.d = null;
        this.b = jVar;
        b();
    }

    public void a(ForumDetailData forumDetailData) {
        this.c = forumDetailData;
        this.e.setVisibility(8);
        d();
        e();
        f();
        g();
    }

    private void b() {
        this.b.setContentView(R.layout.forum_detail_activity);
        this.f = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.f.a(this.b.getString(R.string.forum_detail_title));
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.HOME_BUTTON);
        this.g = (ItemHeaderView) this.b.findViewById(R.id.item_header);
        this.h = (ItemInfoView) this.b.findViewById(R.id.item_info);
        this.i = (ItemHotThreadView) this.b.findViewById(R.id.item_hot_thread);
        this.j = (ItemFootNavView) this.b.findViewById(R.id.item_foot_nav);
        this.d = (ViewGroup) this.b.findViewById(R.id.parent);
        c().setVisibility(0);
    }

    private ProgressBar c() {
        this.e = new ProgressBar(this.b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.e.setLayoutParams(layoutParams);
        this.e.setIndeterminateDrawable(this.b.getResources().getDrawable(R.drawable.progressbar));
        this.e.setVisibility(8);
        ((ViewGroup) this.b.findViewById(16908290)).addView(this.e);
        return this.e;
    }

    private void d() {
        if (this.g.a(this.c)) {
            this.g.setVisibility(0);
        }
    }

    private void e() {
        if (this.h.a(this.c, this.b)) {
            this.h.setVisibility(0);
        }
    }

    private void f() {
        if (this.i.a(this.c)) {
            this.i.setVisibility(0);
        }
    }

    private void g() {
        if (this.j.a(this.c, this.b)) {
            this.j.setVisibility(0);
        }
    }

    public void a(int i) {
        this.b.l().a(i == 1);
        this.b.l().a(this.d);
        as.b(this.d, i);
        this.f.b(i);
        this.g.a(this.b, i);
        this.h.a(this.b, i);
        this.i.a(this.b, i);
    }
}
