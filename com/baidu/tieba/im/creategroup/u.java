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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.c {
    private int a;
    private NavigationBar b;
    private View c;
    private GroupAddressLocateActivity d;
    private TextView e;
    private View f;
    private View g;
    private TextView h;
    private ImageView i;
    private TextView j;
    private View k;
    private TextView l;
    private ImageView m;
    private BdListView n;
    private AnimationDrawable o;
    private SettingTextSwitchView p;
    private String q;
    private String r;
    private boolean s;
    private t t;
    private com.baidu.tieba.im.f.e u;
    private String v;
    private String w;
    private DialogInterface.OnClickListener x;
    private DialogInterface.OnClickListener y;

    public u(GroupAddressLocateActivity groupAddressLocateActivity, String str, String str2, boolean z) {
        super(groupAddressLocateActivity);
        this.a = 3;
        this.b = null;
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
        this.q = "";
        this.r = "";
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = "";
        this.w = "";
        this.x = null;
        this.y = null;
        this.q = str;
        this.r = str2;
        this.s = z;
        a(groupAddressLocateActivity);
        b(groupAddressLocateActivity);
        p();
    }

    public void a() {
        this.u.a();
    }

    public void b() {
        if (this.u != null) {
            this.u.b();
            this.u = null;
        }
    }

    public void c() {
        this.i.setVisibility(8);
    }

    public void d() {
        this.i.setVisibility(0);
    }

    public void e() {
        if (this.t != null) {
            this.t.notifyDataSetChanged();
        }
    }

    private void a(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.d = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(com.baidu.tieba.w.group_address_locate_activity);
        this.c = groupAddressLocateActivity.findViewById(com.baidu.tieba.v.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_content_currentpos);
        this.h = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_title_currentpos);
        this.g = groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_content_container);
        this.g.setOnClickListener(this.d);
        this.i = (ImageView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.q)) {
            stringBuffer.append(this.q);
        }
        if (!TextUtils.isEmpty(this.r)) {
            stringBuffer.append(this.r);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.g.setVisibility(8);
            this.h.setVisibility(8);
        }
        this.k = groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_locatearea_layout);
        this.k.setOnClickListener(this.d);
        this.l = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_locatearea_textview);
        this.m = (ImageView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_locatearea_rightarrow);
        this.m.setVisibility(8);
        this.j = (TextView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_title_poslist);
        this.n = (BdListView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.group_address_locate_addresslist_listview);
        this.n.setOnItemClickListener(this.d);
        this.p = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.address_showorhidden);
        if (this.s) {
            this.p.b();
        } else {
            this.p.a();
        }
        this.p.setSwitchStateChangeListener(this.d);
        this.b = (NavigationBar) groupAddressLocateActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.b.a(groupAddressLocateActivity.getResources().getString(y.group_address_edit));
        this.b.setSystemClickable(false);
        this.f = this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(y.save));
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.f.setOnClickListener(groupAddressLocateActivity);
        this.e.setOnClickListener(groupAddressLocateActivity);
    }

    private void p() {
        this.u = new com.baidu.tieba.im.f.e(this.d);
        this.u.a(this.d.getUniqueId());
        a();
    }

    public void f() {
        this.j.setText(y.address_pos_list);
        this.l.setText(y.address_locating);
        this.m.setVisibility(8);
        this.a = 3;
        q();
    }

    public void g() {
        this.j.setText(y.address_locate_noaddresslist);
        this.l.setText(y.address_locate_failed_tryagain);
        this.m.setVisibility(0);
        this.a = 2;
        q();
    }

    public void a(String[] strArr) {
        this.k.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.j.setText(y.address_pos_list);
            this.t = new t(this.d, strArr);
            this.n.setAdapter((ListAdapter) this.t);
            this.n.setVisibility(0);
        } else {
            this.j.setText(y.address_locate_noaddresslist);
        }
        q();
    }

    public void h() {
        this.j.setText(y.address_pos_list);
        this.l.setText(y.address_locate_failed_opengps);
        this.m.setVisibility(0);
        this.a = 1;
        q();
    }

    public void i() {
        Drawable[] compoundDrawables = this.l.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.o = (AnimationDrawable) compoundDrawables[0];
            q();
        }
    }

    private void q() {
        if (this.o != null) {
            if (this.a == 3) {
                this.o.start();
                return;
            }
            this.o.stop();
            this.o.selectDrawable(0);
        }
    }

    public void a(String str) {
        this.v = str;
    }

    public void b(String str) {
        this.w = str;
    }

    public View j() {
        return this.e;
    }

    public View k() {
        return this.f;
    }

    public View l() {
        return this.g;
    }

    public View m() {
        return this.k;
    }

    public int n() {
        return this.a;
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void o() {
        new AlertDialog.Builder(this.d).setTitle(y.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(y.group_update_alert_save).setPositiveButton(y.group_update_canel, new v(this)).setNegativeButton(y.group_update_done, new w(this)).create().show();
    }

    public void a(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a(this.c);
        bc.b(this.c, i);
        this.b.c(i);
        if (i == 1) {
            this.c.setBackgroundResource(com.baidu.tieba.s.group_info_bg_1);
        } else {
            this.c.setBackgroundResource(com.baidu.tieba.s.group_info_bg);
        }
    }
}
