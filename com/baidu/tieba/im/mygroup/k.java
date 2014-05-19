package com.baidu.tieba.im.mygroup;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.e {
    private MyGroupActivity a;
    private MyGroupFragment b;
    private View c;
    private NavigationBar d;
    private NoNetworkView e;

    public k(MyGroupActivity myGroupActivity) {
        super(myGroupActivity);
        this.a = myGroupActivity;
        myGroupActivity.setContentView(s.my_group_activity);
        b();
    }

    private void b() {
        this.c = this.a.findViewById(r.parent);
        this.d = (NavigationBar) this.a.findViewById(r.view_navigation_bar);
        this.d.a(this.a.getString(u.my_group));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (NoNetworkView) this.a.findViewById(r.view_no_network);
        this.b = (MyGroupFragment) this.a.getSupportFragmentManager().findFragmentById(r.my_group_fragment);
    }

    public void a(int i) {
        this.a.a().a(i == 1);
        this.a.a().a(this.c);
        this.d.c(i);
        this.b.c(i);
        this.e.a(i);
    }

    private void c() {
        if (this.e != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                this.e.setVisible(false);
            } else {
                this.e.setVisible(true);
            }
        }
    }

    public void a() {
        c();
    }
}
