package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.c {
    NavigationBar a;
    View b;
    GroupAddressEditActivity c;
    TextView d;
    BdListView e;
    q f;
    private View g;
    private TextView h;
    private String[] i;
    private boolean j;

    public View a() {
        return this.d;
    }

    public View b() {
        return this.g;
    }

    public p(GroupAddressEditActivity groupAddressEditActivity, String[] strArr, boolean z) {
        super(groupAddressEditActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = null;
        this.e = null;
        this.h = null;
        this.i = null;
        this.j = false;
        this.f = null;
        this.i = strArr;
        this.j = z;
        b(groupAddressEditActivity);
        a(groupAddressEditActivity);
    }

    private void a(GroupAddressEditActivity groupAddressEditActivity) {
        this.g.setOnClickListener(groupAddressEditActivity);
        this.d.setOnClickListener(groupAddressEditActivity);
    }

    private void b(GroupAddressEditActivity groupAddressEditActivity) {
        this.c = groupAddressEditActivity;
        groupAddressEditActivity.setContentView(com.baidu.tieba.w.group_address_activity);
        this.b = groupAddressEditActivity.findViewById(com.baidu.tieba.v.parent);
        this.e = (BdListView) groupAddressEditActivity.findViewById(com.baidu.tieba.v.lv_address);
        this.f = new q(this.c, this.i);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(this.c);
        this.h = (TextView) groupAddressEditActivity.findViewById(com.baidu.tieba.v.address_title_poslist);
        if (this.i == null || this.i.length < 1) {
            this.e.setVisibility(8);
            this.h.setText(y.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(com.baidu.tieba.v.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(this.c);
        if (this.j) {
            settingTextSwitchView.b();
        } else {
            settingTextSwitchView.a();
        }
        this.a = (NavigationBar) groupAddressEditActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.a.a(groupAddressEditActivity.getResources().getString(y.group_address_edit));
        this.a.setSystemClickable(false);
        this.g = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(y.save));
    }

    public void c() {
        this.f.notifyDataSetChanged();
    }

    public void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.b);
        bc.b(this.b, i);
        this.a.c(i);
        if (i == 1) {
            this.b.setBackgroundResource(com.baidu.tieba.s.group_info_bg_1);
        } else {
            this.b.setBackgroundResource(com.baidu.tieba.s.group_info_bg);
        }
    }
}
