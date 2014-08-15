package com.baidu.tieba.forumdetail;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f {
    BaseActivity a;
    private ForumDetailData b;
    private ViewGroup c;
    private ProgressBar d;
    private NavigationBar e;
    private ItemHeaderView f;
    private ItemInfoView g;
    private ItemHotThreadView h;
    private ItemFootNavView i;

    public e(BaseActivity baseActivity) {
        super(baseActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = baseActivity;
        b();
    }

    public void a(ForumDetailData forumDetailData) {
        this.b = forumDetailData;
        this.d.setVisibility(8);
        d();
        e();
        f();
        g();
    }

    private void b() {
        this.a.setContentView(v.forum_detail_activity);
        this.e = (NavigationBar) this.a.findViewById(u.view_navigation_bar);
        this.e.a(this.a.getString(x.forum_detail_title));
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (ItemHeaderView) this.a.findViewById(u.item_header);
        this.g = (ItemInfoView) this.a.findViewById(u.item_info);
        this.h = (ItemHotThreadView) this.a.findViewById(u.item_hot_thread);
        this.i = (ItemFootNavView) this.a.findViewById(u.item_foot_nav);
        this.c = (ViewGroup) this.a.findViewById(u.parent);
        c().setVisibility(0);
    }

    private ProgressBar c() {
        this.d = new ProgressBar(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.d.setLayoutParams(layoutParams);
        this.d.setIndeterminateDrawable(this.a.getResources().getDrawable(t.progressbar));
        this.d.setVisibility(8);
        ((ViewGroup) this.a.findViewById(16908290)).addView(this.d);
        return this.d;
    }

    private void d() {
        if (this.f.a(this.b)) {
            this.f.setVisibility(0);
        }
    }

    private void e() {
        if (this.g.a(this.b, this.a)) {
            this.g.setVisibility(0);
        }
    }

    private void f() {
        if (this.h.a(this.b)) {
            this.h.setVisibility(0);
        }
    }

    private void g() {
        if (this.i.a(this.b, this.a)) {
            this.i.setVisibility(0);
        }
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.c);
        this.e.c(i);
        this.f.a(this.a, i);
        this.g.a(this.a, i);
        this.h.a(this.a, i);
        this.i.a(this.a, i);
    }

    public void a() {
        this.i.a(this.a);
    }
}
