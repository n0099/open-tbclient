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
import com.baidu.tieba.more.SettingTextSwitchView;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.a.e {
    private int a;
    private NavigationBar c;
    private View d;
    private GroupAddressLocateActivity e;
    private TextView f;
    private ImageView g;
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
    private ag v;
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
        a(groupAddressLocateActivity);
        b(groupAddressLocateActivity);
        s();
    }

    public void a() {
        this.v.a();
    }

    public void e() {
        if (this.v != null) {
            this.v.b();
            this.v = null;
        }
    }

    public void f() {
        this.j.setVisibility(8);
    }

    public void g() {
        this.j.setVisibility(0);
    }

    public void h() {
        if (this.u != null) {
            this.u.notifyDataSetChanged();
        }
    }

    private void a(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.e = groupAddressLocateActivity;
        groupAddressLocateActivity.setContentView(R.layout.group_address_locate_activity);
        this.d = groupAddressLocateActivity.findViewById(R.id.parent);
        TextView textView = (TextView) groupAddressLocateActivity.findViewById(R.id.address_content_currentpos);
        this.i = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_currentpos);
        this.h = groupAddressLocateActivity.findViewById(R.id.address_content_container);
        this.h.setOnClickListener(this.e);
        this.j = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_currentpos_content_arrow);
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.r)) {
            stringBuffer.append(this.r);
        }
        if (!TextUtils.isEmpty(this.s)) {
            stringBuffer.append(this.s);
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 != null && !stringBuffer2.equals("")) {
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            textView.setText(stringBuffer2);
        } else {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
        }
        this.l = groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_layout);
        this.l.setOnClickListener(this.e);
        this.m = (TextView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_textview);
        this.n = (ImageView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_locatearea_rightarrow);
        this.n.setVisibility(8);
        this.k = (TextView) groupAddressLocateActivity.findViewById(R.id.address_title_poslist);
        this.o = (BdListView) groupAddressLocateActivity.findViewById(R.id.group_address_locate_addresslist_listview);
        this.o.setOnItemClickListener(this.e);
        this.q = (SettingTextSwitchView) groupAddressLocateActivity.findViewById(R.id.address_showorhidden);
        if (this.t) {
            this.q.b();
        } else {
            this.q.a();
        }
        this.q.setSwitchStateChangeListener(this.e);
        this.c = (NavigationBar) groupAddressLocateActivity.findViewById(R.id.view_navigation_bar);
        this.c.a(groupAddressLocateActivity.getResources().getString(R.string.group_address_edit));
        this.c.setSystemClickable(false);
        this.g = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupAddressLocateActivity.getResources().getString(R.string.save));
    }

    private void b(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.g.setOnClickListener(groupAddressLocateActivity);
        this.f.setOnClickListener(groupAddressLocateActivity);
    }

    private void s() {
        this.v = new ag(this.e);
        a();
    }

    public void i() {
        this.k.setText(R.string.address_pos_list);
        this.m.setText(R.string.address_locating);
        this.n.setVisibility(8);
        this.a = 3;
        t();
    }

    public void j() {
        this.k.setText(R.string.address_locate_noaddresslist);
        this.m.setText(R.string.address_locate_failed_tryagain);
        this.n.setVisibility(0);
        this.a = 2;
        t();
    }

    public void a(String[] strArr) {
        this.l.setVisibility(8);
        if (strArr != null && strArr.length > 0) {
            this.k.setText(R.string.address_pos_list);
            this.u = new t(this.e, strArr);
            this.o.setAdapter((ListAdapter) this.u);
            this.o.setVisibility(0);
        } else {
            this.k.setText(R.string.address_locate_noaddresslist);
        }
        t();
    }

    public void k() {
        this.k.setText(R.string.address_pos_list);
        this.m.setText(R.string.address_locate_failed_opengps);
        this.n.setVisibility(0);
        this.a = 1;
        t();
    }

    public void l() {
        Drawable[] compoundDrawables = this.m.getCompoundDrawables();
        if (compoundDrawables != null && compoundDrawables.length > 0 && (compoundDrawables[0] instanceof AnimationDrawable)) {
            this.p = (AnimationDrawable) compoundDrawables[0];
            t();
        }
    }

    private void t() {
        if (this.p != null) {
            if (this.a == 3) {
                this.p.start();
                return;
            }
            this.p.stop();
            this.p.selectDrawable(0);
        }
    }

    public void a(String str) {
        this.w = str;
    }

    public void b(String str) {
        this.x = str;
    }

    public View m() {
        return this.f;
    }

    public ImageView n() {
        return this.g;
    }

    public View o() {
        return this.h;
    }

    public View p() {
        return this.l;
    }

    public int q() {
        return this.a;
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.y = onClickListener;
    }

    public void b(DialogInterface.OnClickListener onClickListener) {
        this.z = onClickListener;
    }

    public void r() {
        new AlertDialog.Builder(this.e).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.group_update_alert_save).setPositiveButton(R.string.group_update_canel, new w(this)).setNegativeButton(R.string.group_update_done, new v(this)).create().show();
    }

    public void a(int i) {
        this.e.getLayoutMode().a(i == 1);
        this.e.getLayoutMode().a(this.d);
        bs.b(this.d, i);
        this.c.c(i);
        if (i == 1) {
            this.d.setBackgroundResource(R.color.group_info_bg_1);
        } else {
            this.d.setBackgroundResource(R.color.group_info_bg);
        }
    }
}
