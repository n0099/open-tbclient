package com.baidu.tieba.im.randchat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class f extends com.baidu.adp.a.e {
    private View a;
    private WaittingActivity c;
    private NavigationBar d;
    private RingLayoutView e;
    private WaitingTipView f;
    private ImageView g;
    private TextView h;

    public f(WaittingActivity waittingActivity) {
        super(waittingActivity);
        this.c = waittingActivity;
        this.c.setContentView(R.layout.im_waitting_activity);
        this.d = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.e = (RingLayoutView) this.c.findViewById(R.id.waittingView);
        this.g = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(R.string.rand_chat_waiting_title);
        this.h = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c.getString(R.string.rand_chat_waiting_button_change));
        this.f = (WaitingTipView) this.c.findViewById(R.id.tipView);
        this.g.setOnClickListener(this.c);
        this.h.setOnClickListener(this.c);
    }

    public final void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.a);
        this.d.b(i);
    }

    public final void a() {
        if (com.baidu.tieba.sharedPref.b.a().a("is_show_randchat_create", true)) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.a(this.h).a(178).b(true);
            gVar.a(new g(this));
            gVar.a().a(this.c);
            com.baidu.tieba.sharedPref.b.a().b("is_show_randchat_create", false);
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

    public final com.baidu.tieba.view.p e() {
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

    public final ImageView h() {
        return this.g;
    }

    public final void i() {
        this.e.d();
    }
}
