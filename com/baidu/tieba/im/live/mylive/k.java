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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.c {
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
    private ViewGroup[] k;
    private NoNetworkView l;
    private ViewPager m;

    public k(MyLiveActivity myLiveActivity) {
        super(myLiveActivity);
        this.a = myLiveActivity;
        this.a.setContentView(w.mylive_activity);
        c();
        d();
        e();
    }

    private void c() {
        this.b = this.a.findViewById(v.mylive_activity_root);
        this.d = (NavigationBar) this.a.findViewById(v.mylive_activity_navigationbar);
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.a(this.a.getString(y.live_mylive));
        this.c = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(y.members_edit));
        this.c.setOnClickListener(this.a);
        this.l = (NoNetworkView) this.a.findViewById(v.mylive_activity_view_no_network);
    }

    private void d() {
        this.e = (RadioGroup) this.a.findViewById(v.mylive_activity_raidos_change);
        this.f = (RadioButton) this.a.findViewById(v.mylive_activity_radio_mylive);
        this.g = (RadioButton) this.a.findViewById(v.mylive_activity_radio_mymark);
        this.h = (ViewGroup) this.a.findViewById(v.mylive_activity_radio_mylive_line);
        this.i = (ViewGroup) this.a.findViewById(v.mylive_activity_radio_mymark_line);
        this.k = new ViewGroup[2];
        this.k[0] = this.h;
        this.k[1] = this.i;
        b(0);
        this.f.setChecked(true);
    }

    private void e() {
        this.j = new a[2];
        this.j[0] = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("KeyOfFragmentType", 1);
        this.j[0].setArguments(bundle);
        this.j[1] = new a();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("KeyOfFragmentType", 2);
        this.j[1].setArguments(bundle2);
        this.m = (ViewPager) this.a.findViewById(v.mylive_activity_fragment);
        this.m.setAdapter(new l(this.a.getSupportFragmentManager(), this.j));
        this.m.setOnPageChangeListener(this.a);
    }

    public void a(boolean z) {
        if (this.j != null && this.j.length > 1) {
            this.j[0].a(z, this.a.getResources().getString(y.live_mylive_dismiss));
            this.j[1].a(z, this.a.getResources().getString(y.del_post));
        }
        if (this.c != null) {
            if (!z) {
                be.i(this.c, TbadkApplication.m252getInst().getSkinType());
            } else {
                be.g(this.c, TbadkApplication.m252getInst().getSkinType());
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
        if (this.j != null && this.j[1] != null && this.j[1].f() == 2) {
            this.j[1].a(liveCardData);
        }
    }

    public void b(int i) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (i == i2) {
                this.k[i2].setVisibility(0);
            } else {
                this.k[i2].setVisibility(4);
            }
        }
    }

    public void c(int i) {
        if (i >= 0 && i <= 1) {
            this.m.setCurrentItem(i);
        }
    }

    public void d(int i) {
        switch (i + 1) {
            case 1:
                this.f.setChecked(true);
                return;
            case 2:
                this.g.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void a() {
        this.e.setOnCheckedChangeListener(this.a);
    }

    public void e(int i) {
        this.a.a().a(i == 1);
        this.a.a().a(this.b);
        this.d.c(i);
        if (this.l != null) {
            this.l.a(i);
        }
    }

    public TextView b() {
        return this.c;
    }
}
