package com.baidu.tieba.im.mygroup;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.c {
    private MyGroupActivity a;
    private MyGroupFragment b;
    private View c;
    private NavigationBar d;
    private NoNetworkView e;

    public k(MyGroupActivity myGroupActivity) {
        super(myGroupActivity);
        this.a = myGroupActivity;
        myGroupActivity.setContentView(w.my_group_activity);
        b();
    }

    private void b() {
        this.c = this.a.findViewById(v.parent);
        this.d = (NavigationBar) this.a.findViewById(v.view_navigation_bar);
        this.d.a(this.a.getString(y.my_group));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = (NoNetworkView) this.a.findViewById(v.view_no_network);
        this.b = (MyGroupFragment) this.a.getSupportFragmentManager().findFragmentById(v.my_group_fragment);
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
