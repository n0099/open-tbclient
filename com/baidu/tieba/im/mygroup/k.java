package com.baidu.tieba.im.mygroup;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.f {
    private MyGroupActivity a;
    private MyGroupFragment b;
    private View c;
    private NavigationBar d;
    private NoNetworkView e;
    private LinearLayout f;

    public k(MyGroupActivity myGroupActivity) {
        super(myGroupActivity);
        this.a = myGroupActivity;
        myGroupActivity.setContentView(com.baidu.tieba.v.my_group_activity);
        b();
    }

    private void b() {
        this.c = this.a.findViewById(com.baidu.tieba.u.parent);
        this.d = (NavigationBar) this.a.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.d.a(this.a.getString(com.baidu.tieba.x.my_group));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (LinearLayout) this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_create_group_btn, (View.OnClickListener) null);
        this.f.setOnClickListener(new l(this));
        this.e = (NoNetworkView) this.a.findViewById(com.baidu.tieba.u.view_no_network);
        this.b = (MyGroupFragment) this.a.getSupportFragmentManager().findFragmentById(com.baidu.tieba.u.my_group_fragment);
    }

    public void a(int i) {
        this.a.c().a(i == 1);
        this.a.c().a(this.c);
        this.d.c(i);
        this.b.c(i);
        this.e.a(i);
    }

    private void c() {
        if (this.e != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                this.e.a(false);
            } else {
                this.e.a(true);
            }
        }
    }

    public void a() {
        c();
    }
}
