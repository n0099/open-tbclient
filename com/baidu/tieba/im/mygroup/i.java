package com.baidu.tieba.im.mygroup;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class i extends com.baidu.adp.a.e {
    private MyGroupActivity a;
    private MyGroupFragment c;
    private View d;
    private NavigationBar e;
    private NoNetworkView f;

    public i(MyGroupActivity myGroupActivity) {
        super(myGroupActivity);
        this.a = myGroupActivity;
        myGroupActivity.setContentView(R.layout.my_group_activity);
        this.d = this.a.findViewById(R.id.parent);
        this.e = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.e.a(this.a.getString(R.string.my_group));
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
        this.c = (MyGroupFragment) this.a.getSupportFragmentManager().findFragmentById(R.id.my_group_fragment);
    }

    public final void a(int i) {
        this.a.a().a(i == 1);
        this.a.a().a(this.d);
        this.e.b(i);
        this.c.c(i);
        this.f.a(i);
    }

    public final void a() {
        if (this.f != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                this.f.setVisible(true);
            } else {
                this.f.setVisible(false);
            }
        }
    }
}
