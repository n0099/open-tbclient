package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
/* loaded from: classes.dex */
public final class u extends com.baidu.adp.a.f {
    private int a;
    private NavigationBar c;
    private View d;
    private GroupAddressLocateActivity e;
    private TextView f;
    private View g;
    private View h;
    private TextView i;
    private ImageView j;
    private TextView k;
    private View l;
    private TextView m;
    private ImageView n;
    private BdListView o;
    private AnimationDrawable p;
    private SettingTextSwitchView q;
    private String r;
    private String s;
    private boolean t;
    private t u;
    private com.baidu.tieba.im.f.d v;
    private String w;
    private String x;
    private DialogInterface.OnClickListener y;
    private DialogInterface.OnClickListener z;

    public u(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity);
        this.a = 3;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = "";
        this.s = "";
        this.t = false;
        this.u = null;
        this.v = null;
        this.w = "";
        this.x = "";
        this.y = null;
        this.z = null;
        this.r = str;
        this.s = str2;
        this.t = z;
        this.e = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(com.baidu.tieba.im.i.group_address_locate_activity);
        this.d = groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.address_content_currentpos);
        this.i = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.address_title_currentpos);
        this.h = groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.address_content_container);
        this.h.setOnClickListener(this.e);
        this.j = (ImageView) groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.r)) {
            stringBuffer.append(this.r);
        }
        if (!TextUtils.isEmpty(this.s)) {
            stringBuffer.append(this.s);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            textView.setText(stringBuffer2);
        }
        this.l = groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.group_address_locate_locatearea_layout);
        this.l.setOnClickListener(this.e);
        this.m = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.group_address_locate_locatearea_textview);
        this.n = (ImageView) groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.group_address_locate_locatearea_rightarrow);
        this.n.setVisibility(8);
        this.k = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.address_title_poslist);
        this.o = (BdListView) groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.group_address_locate_addresslist_listview);
        this.o.setOnItemClickListener(this.e);
        this.q = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.address_showorhidden);
        if (this.t) {
            this.q.b();
        } else {
            this.q.a();
        }
        this.q.setSwitchStateChangeListener(this.e);
        this.c = (NavigationBar) groupAddressLocateActivity.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.c.a(groupAddressLocateActivity.getResources().getString(com.baidu.tieba.im.j.group_address_edit));
        this.c.setSystemClickable(false);
        this.g = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(com.baidu.tieba.im.j.save));
        this.g.setOnClickListener(groupAddressLocateActivity);
        this.f.setOnClickListener(groupAddressLocateActivity);
        this.v = new com.baidu.tieba.im.f.d(this.e);
        this.v.a(this.e.getUniqueId());
        this.v.a();
    }

    public final void a() {
        this.v.a();
    }

    public final void d() {
        if (this.v != null) {
            this.v.b();
            this.v = null;
        }
    }

    public final void e() {
        this.j.setVisibility(8);
    }

    public final void f() {
        this.j.setVisibility(0);
    }

    public final void g() {
        if (this.u != null) {
            this.u.notifyDataSetChanged();
        }
    }

    public final void h() {
        this.k.setText(com.baidu.tieba.im.j.address_pos_list);
        this.m.setText(com.baidu.tieba.im.j.address_locating);
        this.n.setVisibility(8);
        this.a = 3;
        r();
    }

    public final void i() {
        this.k.setText(com.baidu.tieba.im.j.address_locate_noaddresslist);
        this.m.setText(com.baidu.tieba.im.j.address_locate_failed_tryagain);
        this.n.setVisibility(0);
        this.a = 2;
        r();
    }

    public final void a(String[] strArr) {
        this.l.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.k.setText(com.baidu.tieba.im.j.address_pos_list);
            this.u = new t(this.e, strArr);
            this.o.setAdapter((ListAdapter) this.u);
            this.o.setVisibility(0);
        } else {
            this.k.setText(com.baidu.tieba.im.j.address_locate_noaddresslist);
        }
        r();
    }

    public final void j() {
        this.k.setText(com.baidu.tieba.im.j.address_pos_list);
        this.m.setText(com.baidu.tieba.im.j.address_locate_failed_opengps);
        this.n.setVisibility(0);
        this.a = 1;
        r();
    }

    public final void k() {
        Drawable[] compoundDrawables = this.m.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.p = (AnimationDrawable) compoundDrawables[0];
            r();
        }
    }

    private void r() {
        if (this.p != null) {
            if (this.a == 3) {
                this.p.start();
                return;
            }
            this.p.stop();
            this.p.selectDrawable(0);
        }
    }

    public final void a(String str) {
        this.w = str;
    }

    public final void b(String str) {
        this.x = str;
    }

    public final View l() {
        return this.f;
    }

    public final View m() {
        return this.g;
    }

    public final View n() {
        return this.h;
    }

    public final View o() {
        return this.l;
    }

    public final int p() {
        return this.a;
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public final void b(DialogInterface.OnClickListener onClickListener) {
        this.z = onClickListener;
    }

    public final void q() {
        new AlertDialog.Builder(this.e).setTitle(com.baidu.tieba.im.j.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.im.j.group_update_alert_save).setPositiveButton(com.baidu.tieba.im.j.group_update_canel, new v(this)).setNegativeButton(com.baidu.tieba.im.j.group_update_done, new w(this)).create().show();
    }

    public final void a(int i) {
        this.e.getLayoutMode().a(i == 1);
        this.e.getLayoutMode().a(this.d);
        ba.b(this.d, i);
        this.c.b(i);
        if (i == 1) {
            this.d.setBackgroundResource(com.baidu.tieba.im.e.group_info_bg_1);
        } else {
            this.d.setBackgroundResource(com.baidu.tieba.im.e.group_info_bg);
        }
    }
}
