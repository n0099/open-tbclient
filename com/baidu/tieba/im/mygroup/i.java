package com.baidu.tieba.im.mygroup;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private MyGroupActivity f1841a;
    private MyGroupFragment c;
    private View d;
    private NavigationBar e;
    private NoNetworkView f;
    private TextView g;

    public i(MyGroupActivity myGroupActivity) {
        super(myGroupActivity);
        this.f1841a = myGroupActivity;
        myGroupActivity.setContentView(R.layout.my_group_activity);
        f();
    }

    private void f() {
        this.d = this.f1841a.findViewById(R.id.parent);
        this.e = (NavigationBar) this.f1841a.findViewById(R.id.view_navigation_bar);
        this.e.a(this.f1841a.getString(R.string.my_group));
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f1841a.getString(R.string.nearby_group_create), this.f1841a);
        this.f = (NoNetworkView) this.f1841a.findViewById(R.id.view_no_network);
        this.c = (MyGroupFragment) this.f1841a.getSupportFragmentManager().a(R.id.my_group_fragment);
    }

    public void a(int i) {
        this.f1841a.a().a(i == 1);
        this.f1841a.a().a(this.d);
        this.e.c(i);
        this.c.c(i);
        this.f.a(i);
    }

    private void g() {
        if (this.f != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f1841a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                this.f.setVisible(false);
            } else {
                this.f.setVisible(true);
            }
        }
    }

    public void a() {
        g();
    }

    public int e() {
        if (this.g != null) {
            return this.g.getId();
        }
        return 0;
    }
}
