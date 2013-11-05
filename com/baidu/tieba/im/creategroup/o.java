package com.baidu.tieba.im.creategroup;

import android.location.Address;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    NavigationBar f1503a;
    View c;
    GroupAddressActivity d;
    Button e;
    BdListView f;
    String g;
    m h;
    com.baidu.adp.lib.c.d i;

    public Button a() {
        return this.e;
    }

    public o(GroupAddressActivity groupAddressActivity) {
        super(groupAddressActivity);
        this.f1503a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = new p(this);
        b(groupAddressActivity);
        a(groupAddressActivity);
    }

    public void a(String str) {
        this.g = str;
        f();
    }

    public Address e() {
        return this.h.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int count;
        if (this.g != null && !this.g.equals("") && (count = this.h.getCount()) != 0) {
            for (int i = 0; i < count; i++) {
                Address address = (Address) this.h.getItem(i);
                if (address != null && address.getAddressLine(0).equals(this.g)) {
                    this.h.a(i);
                    return;
                }
            }
        }
    }

    private void a(GroupAddressActivity groupAddressActivity) {
        this.e.setOnClickListener(groupAddressActivity);
    }

    public void a(int i) {
        this.h.a(i);
    }

    private void b(GroupAddressActivity groupAddressActivity) {
        this.d = groupAddressActivity;
        groupAddressActivity.setContentView(R.layout.group_address_activity);
        this.c = groupAddressActivity.findViewById(R.id.parent);
        this.f = (BdListView) groupAddressActivity.findViewById(R.id.lv_address);
        this.h = new m(this.d);
        this.f.setAdapter((ListAdapter) this.h);
        this.f1503a = (NavigationBar) groupAddressActivity.findViewById(R.id.view_navigation_bar);
        this.f1503a.a(groupAddressActivity.getResources().getString(R.string.group_address));
        this.e = this.f1503a.b(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressActivity.getResources().getString(R.string.group_create_step_done_tip));
        this.f.setOnItemClickListener(this.d);
        com.baidu.adp.lib.c.a.a().a(true, this.i);
    }

    public void b(int i) {
        this.d.m().a(i == 1);
        this.d.m().a(this.c);
        bb.b(this.c, i);
        this.f1503a.b(i);
    }
}
