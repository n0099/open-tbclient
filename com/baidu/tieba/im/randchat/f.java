package com.baidu.tieba.im.randchat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    private View a;
    private WaittingActivity b;
    private NavigationBar c;
    private RingLayoutView d;
    private WaitingTipView e;
    private View f;
    private TextView g;

    public f(WaittingActivity waittingActivity) {
        super(waittingActivity);
        this.b = waittingActivity;
        this.b.setContentView(com.baidu.tieba.v.im_waitting_activity);
        h();
    }

    private void h() {
        this.c = (NavigationBar) this.b.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.d = (RingLayoutView) this.b.findViewById(com.baidu.tieba.u.waittingView);
        this.f = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(x.rand_chat_waiting_title);
        this.g = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.b.getString(x.rand_chat_waiting_button_change));
        this.e = (WaitingTipView) this.b.findViewById(com.baidu.tieba.u.tipView);
        this.f.setOnClickListener(this.b);
        this.g.setOnClickListener(this.b);
    }

    public void a(int i) {
        this.b.getLayoutMode().a(i == 1);
        this.b.getLayoutMode().a(this.a);
        this.c.c(i);
    }

    public void a() {
        if (com.baidu.tbadk.core.sharedPref.b.a().a("is_show_randchat_create", true)) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.a(this.g).a(178).b(true);
            gVar.a(new g(this));
            gVar.a().a(this.b);
            com.baidu.tbadk.core.sharedPref.b.a().b("is_show_randchat_create", false);
        }
    }

    public RingLayoutView b() {
        return this.d;
    }

    public void a(View.OnClickListener onClickListener) {
        if (this.d != null) {
            this.d.setChatClickListener(onClickListener);
        }
    }

    public com.baidu.tieba.im.view.h c() {
        if (this.d == null) {
            return null;
        }
        return this.d.getChatterboxView();
    }

    public TextView d() {
        return this.g;
    }

    public WaitingTipView e() {
        return this.e;
    }

    public View f() {
        return this.f;
    }

    public void g() {
        this.d.d();
    }
}
