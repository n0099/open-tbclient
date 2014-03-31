package com.baidu.tieba.im.mygroup;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public final class k extends com.baidu.adp.a.f {
    private MyGroupActivity a;
    private MyGroupFragment c;
    private View d;
    private NavigationBar e;
    private NoNetworkView f;

    public k(MyGroupActivity myGroupActivity) {
        super(myGroupActivity);
        this.a = myGroupActivity;
        myGroupActivity.setContentView(com.baidu.tieba.im.i.my_group_activity);
        this.d = this.a.findViewById(com.baidu.tieba.im.h.parent);
        this.e = (NavigationBar) this.a.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.e.a(this.a.getString(com.baidu.tieba.im.j.my_group));
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = (NoNetworkView) this.a.findViewById(com.baidu.tieba.im.h.view_no_network);
        this.c = (MyGroupFragment) this.a.getSupportFragmentManager().findFragmentById(com.baidu.tieba.im.h.my_group_fragment);
    }

    public final void a(int i) {
        this.a.b().a(i == 1);
        this.a.b().a(this.d);
        this.e.b(i);
        this.c.onChangeSkinType(i);
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
