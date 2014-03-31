package com.baidu.tieba.im.randchat;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public final class f extends com.baidu.adp.a.f {
    private View a;
    private WaittingActivity c;
    private NavigationBar d;
    private RingLayoutView e;
    private WaitingTipView f;
    private View g;
    private TextView h;

    public f(WaittingActivity waittingActivity) {
        super(waittingActivity);
        this.c = waittingActivity;
        this.c.setContentView(com.baidu.tieba.im.i.im_waitting_activity);
        this.d = (NavigationBar) this.c.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.e = (RingLayoutView) this.c.findViewById(com.baidu.tieba.im.h.waittingView);
        this.g = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(com.baidu.tieba.im.j.rand_chat_waiting_title);
        this.h = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c.getString(com.baidu.tieba.im.j.rand_chat_waiting_button_change));
        this.f = (WaitingTipView) this.c.findViewById(com.baidu.tieba.im.h.tipView);
        this.g.setOnClickListener(this.c);
        this.h.setOnClickListener(this.c);
    }

    public final void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.a);
        this.d.b(i);
    }

    public final void a() {
        if (com.baidu.tbadk.core.sharedPref.b.a().a("is_show_randchat_create", true)) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.a(this.h).a(178).b(true);
            gVar.a(new g(this));
            gVar.a().a(this.c);
            com.baidu.tbadk.core.sharedPref.b.a().b("is_show_randchat_create", false);
        }
    }

    public final RingLayoutView d() {
        return this.e;
    }

    public final void a(View.OnClickListener onClickListener) {
        if (this.e != null) {
            this.e.setChatClickListener(onClickListener);
        }
    }

    public final com.baidu.tieba.im.view.h e() {
        if (this.e == null) {
            return null;
        }
        return this.e.getChatterboxView();
    }

    public final TextView f() {
        return this.h;
    }

    public final WaitingTipView g() {
        return this.f;
    }

    public final View h() {
        return this.g;
    }

    public final void i() {
        this.e.d();
    }
}
