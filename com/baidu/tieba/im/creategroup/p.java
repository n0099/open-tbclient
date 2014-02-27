package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.more.SettingTextSwitchView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class p extends com.baidu.adp.a.e {
    NavigationBar a;
    View c;
    GroupAddressEditActivity d;
    TextView e;
    BdListView f;
    q g;
    private ImageView h;
    private TextView i;
    private String[] j;
    private boolean k;

    public final ImageView a() {
        return this.h;
    }

    public p(GroupAddressEditActivity groupAddressEditActivity, String[] strArr, boolean z) {
        super(groupAddressEditActivity);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = null;
        this.f = null;
        this.i = null;
        this.j = null;
        this.k = false;
        this.g = null;
        this.j = strArr;
        this.k = z;
        this.d = groupAddressEditActivity;
        groupAddressEditActivity.setContentView(R.layout.group_address_activity);
        this.c = groupAddressEditActivity.findViewById(R.id.parent);
        this.f = (BdListView) groupAddressEditActivity.findViewById(R.id.lv_address);
        this.g = new q(this.d, this.j);
        this.f.setAdapter((ListAdapter) this.g);
        this.f.setOnItemClickListener(this.d);
        this.i = (TextView) groupAddressEditActivity.findViewById(R.id.address_title_poslist);
        if (this.j == null || this.j.length <= 0) {
            this.f.setVisibility(8);
            this.i.setText(R.string.address_locate_noaddresslist);
        }
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) groupAddressEditActivity.findViewById(R.id.address_showorhidden);
        settingTextSwitchView.setSwitchStateChangeListener(this.d);
        if (this.k) {
            settingTextSwitchView.b();
        } else {
            settingTextSwitchView.a();
        }
        this.a = (NavigationBar) groupAddressEditActivity.findViewById(R.id.view_navigation_bar);
        this.a.a(groupAddressEditActivity.getResources().getString(R.string.group_address_edit));
        this.a.setSystemClickable(false);
        this.h = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressEditActivity.getResources().getString(R.string.save));
        this.h.setOnClickListener(groupAddressEditActivity);
        this.e.setOnClickListener(groupAddressEditActivity);
    }
}
