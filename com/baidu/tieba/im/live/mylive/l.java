package com.baidu.tieba.im.live.mylive;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f {
    private MyLiveActivity a;
    private View b;
    private TextView c;
    private NavigationBar d;
    private RadioGroup e;
    private RadioButton f;
    private RadioButton g;
    private ViewGroup h;
    private ViewGroup i;
    private a[] j;
    private NoNetworkView k;
    private ViewPager l;
    private boolean m;

    public l(MyLiveActivity myLiveActivity) {
        super(myLiveActivity);
        this.m = false;
        this.a = myLiveActivity;
        this.a.setContentView(w.mylive_activity);
        e();
        f();
        g();
    }

    private void e() {
        this.b = this.a.findViewById(v.mylive_activity_root);
        this.d = (NavigationBar) this.a.findViewById(v.mylive_activity_navigationbar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(this.a.getString(y.live_mylive));
        this.c = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(y.members_edit));
        this.c.setOnClickListener(this.a);
        this.k = (NoNetworkView) this.a.findViewById(v.mylive_activity_view_no_network);
    }

    private void f() {
        this.e = (RadioGroup) this.a.findViewById(v.mylive_activity_raidos_change);
        this.f = (RadioButton) this.a.findViewById(v.mylive_activity_radio_mylive);
        this.g = (RadioButton) this.a.findViewById(v.mylive_activity_radio_mymark);
        this.h = (ViewGroup) this.a.findViewById(v.mylive_activity_radio_mylive_line);
        this.i = (ViewGroup) this.a.findViewById(v.mylive_activity_radio_mymark_line);
        b(0);
    }

    private void g() {
        this.j = new a[2];
        this.j[0] = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("KeyOfFragmentType", 2);
        this.j[0].setArguments(bundle);
        this.j[1] = new a();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("KeyOfFragmentType", 1);
        this.j[1].setArguments(bundle2);
        this.l = (ViewPager) this.a.findViewById(v.mylive_activity_fragment);
        this.l.setAdapter(new m(this.a.getSupportFragmentManager(), this.j));
        this.l.setOnPageChangeListener(this.a);
    }

    public boolean a() {
        int currentItem = this.l.getCurrentItem();
        if (currentItem < 0 || this.j == null || this.j.length <= currentItem) {
            return false;
        }
        return this.j[currentItem].i();
    }

    public void b() {
        if (!a()) {
            a(!this.m);
        }
    }

    public void a(boolean z) {
        this.m = z;
        b(z);
        c(z);
    }

    private void b(boolean z) {
        this.c.setText(z ? this.a.getString(y.group_create_step_done_tip) : this.a.getString(y.members_edit));
    }

    private void c(boolean z) {
        if (this.j != null && this.j.length > 1) {
            this.j[1].a(z, this.a.getResources().getString(y.live_mylive_dismiss));
            this.j[0].a(z, this.a.getResources().getString(y.del_post));
        }
        if (this.c != null) {
            if (!z) {
                bk.i(this.c, TbadkApplication.m252getInst().getSkinType());
            } else {
                bk.g(this.c, TbadkApplication.m252getInst().getSkinType());
            }
        }
    }

    public void a(int i) {
        a aVar = this.j[i];
        if (aVar != null && !aVar.h()) {
            aVar.g();
        }
    }

    public void a(LiveCardData liveCardData) {
        if (this.j != null && this.j[0] != null && this.j[0].f() == 2) {
            this.j[0].a(liveCardData);
        }
    }

    public void b(int i) {
        if (i == 0) {
            this.g.setChecked(true);
            this.i.setVisibility(0);
            this.f.setChecked(false);
            this.h.setVisibility(4);
        } else if (i == 1) {
            this.g.setChecked(false);
            this.i.setVisibility(4);
            this.f.setChecked(true);
            this.h.setVisibility(0);
        }
    }

    public void c(int i) {
        if (i >= 0 && i <= 1) {
            this.l.setCurrentItem(i);
        }
    }

    public void c() {
        this.e.setOnCheckedChangeListener(this.a);
    }

    public void d(int i) {
        this.a.c().a(i == 1);
        this.a.c().a(this.b);
        this.d.c(i);
        if (this.k != null) {
            this.k.a(i);
        }
    }

    public TextView d() {
        return this.c;
    }
}
