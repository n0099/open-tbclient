package com.baidu.tieba.im.randchat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.e {
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
        j();
    }

    private void j() {
        this.d = (NavigationBar) this.c.findViewById(R.id.view_navigation_bar);
        this.e = (RingLayoutView) this.c.findViewById(R.id.waittingView);
        this.g = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(R.string.rand_chat_waiting_title);
        this.h = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.c.getString(R.string.rand_chat_waiting_button_change));
        this.f = (WaitingTipView) this.c.findViewById(R.id.tipView);
        this.g.setOnClickListener(this.c);
        this.h.setOnClickListener(this.c);
    }

    public void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.a);
        this.d.c(i);
    }

    public RingLayoutView a() {
        return this.e;
    }

    public void a(View.OnClickListener onClickListener) {
        if (this.e != null) {
            this.e.setChatClickListener(onClickListener);
        }
    }

    public com.baidu.tieba.view.p e() {
        if (this.e == null) {
            return null;
        }
        return this.e.getChatterboxView();
    }

    public TextView f() {
        return this.h;
    }

    public WaitingTipView g() {
        return this.f;
    }

    public ImageView h() {
        return this.g;
    }

    public void i() {
        this.e.d();
    }
}
