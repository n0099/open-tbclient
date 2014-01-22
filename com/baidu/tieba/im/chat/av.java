package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.more.SettingTextSwitchView;
import com.baidu.tieba.more.SettingTextTipView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class av extends com.baidu.adp.a.e {
    private GroupSettingActivity a;
    private RelativeLayout c;
    private AlertDialog d;
    private AlertDialog e;
    private SettingTextSwitchView f;
    private SettingTextSwitchView g;
    private SettingTextTipView h;
    private SettingTextTipView i;
    private SettingTextTipView j;
    private Button k;
    private Button l;
    private DialogInterface.OnClickListener m;
    private ProgressBar n;
    private AlertDialog o;
    private NavigationBar p;
    private ImageView q;

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public av(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity);
        this.a = null;
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.m = null;
        this.a = groupSettingActivity;
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        this.f.a(i);
        this.g.a(i);
        this.i.a(i);
        this.h.a(i);
        this.j.a(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.c);
        this.p.c(i);
    }

    public ImageView a() {
        return this.q;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.h.setText(str);
        }
    }

    private void y() {
        this.a.setContentView(R.layout.group_setting_activity);
        this.f = (SettingTextSwitchView) this.a.findViewById(R.id.sv_group_msg_notify);
        this.g = (SettingTextSwitchView) this.a.findViewById(R.id.sv_group_add_group);
        this.h = (SettingTextTipView) this.a.findViewById(R.id.tv_change_name);
        this.i = (SettingTextTipView) this.a.findViewById(R.id.sv_report);
        this.j = (SettingTextTipView) this.a.findViewById(R.id.sv_delete_msg);
        this.k = (Button) this.a.findViewById(R.id.btn_dismiss);
        this.l = (Button) this.a.findViewById(R.id.btn_quit);
        this.c = (RelativeLayout) this.a.findViewById(R.id.parent);
        this.n = (ProgressBar) this.a.findViewById(R.id.progress_loading);
        this.p = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.q = this.p.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.a);
        this.p.a(R.string.group_setting);
    }

    public void e() {
        this.f.setSwitchStateChangeListener(this.a);
        this.g.setSwitchStateChangeListener(this.a);
        this.h.setOnClickListener(this.a);
        this.i.setOnClickListener(this.a);
        this.k.setOnClickListener(this.a);
        this.l.setOnClickListener(this.a);
        this.j.setOnClickListener(this.a);
    }

    public SettingTextTipView f() {
        return this.h;
    }

    public Button g() {
        return this.l;
    }

    public Button h() {
        return this.k;
    }

    public SettingTextTipView i() {
        return this.i;
    }

    public SettingTextTipView j() {
        return this.j;
    }

    public void k() {
        if (this.e == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setTitle(R.string.alerm_title);
            builder.setIcon((Drawable) null);
            builder.setCancelable(false);
            builder.setMessage(R.string.group_quit_alert);
            builder.setPositiveButton(R.string.alert_yes_button, this.a);
            builder.setNegativeButton(R.string.alert_no_button, new aw(this));
            this.e = builder.create();
            this.e.setCanceledOnTouchOutside(true);
        }
        if (!this.e.isShowing()) {
            this.e.show();
        }
    }

    public AlertDialog l() {
        return this.e;
    }

    public void m() {
        if (this.d == null) {
            this.d = new AlertDialog.Builder(this.a).setTitle(R.string.group_report).setItems(new CharSequence[]{new SpannableString(this.a.getString(R.string.group_report_ad)), new SpannableString(this.a.getString(R.string.group_report_sex)), new SpannableString(this.a.getString(R.string.group_report_lllegal))}, this.m).create();
        }
        this.d.setCanceledOnTouchOutside(true);
        this.d.show();
    }

    public void n() {
        if (this.l != null) {
            this.l.setVisibility(8);
        }
    }

    public void o() {
        if (this.k != null) {
            this.k.setVisibility(8);
        }
    }

    public void a(boolean z) {
        if (this.g != null) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    public void b(boolean z) {
        if (z) {
            this.g.b();
        } else {
            this.g.a();
        }
    }

    public void p() {
        if (this.l != null) {
            this.l.setVisibility(0);
        }
    }

    public void q() {
        if (this.k != null) {
            this.k.setVisibility(0);
        }
    }

    public void r() {
        if (this.i != null) {
            this.i.setVisibility(0);
        }
    }

    public void s() {
        if (this.i != null) {
            this.i.setVisibility(8);
        }
    }

    public BdSwitchView t() {
        return this.g.getSwitchView();
    }

    public BdSwitchView u() {
        return this.f.getSwitchView();
    }

    public void v() {
        if (this.o == null) {
            this.o = new AlertDialog.Builder(this.b).setTitle(this.b.getString(R.string.alerm_title)).setCancelable(false).setMessage(R.string.group_dismiss_alert).setPositiveButton(R.string.alert_yes_button, this.a).setNegativeButton(R.string.alert_no_button, new ax(this)).create();
        }
        if (!this.o.isShowing()) {
            this.o.show();
        }
    }

    public AlertDialog w() {
        return this.o;
    }

    public void x() {
        if (this.o != null && this.o.isShowing()) {
            this.o.dismiss();
            this.o = null;
        }
        if (this.d != null && this.d.isShowing()) {
            this.d.dismiss();
            this.d = null;
        }
        if (this.e != null && this.e.isShowing()) {
            this.e.dismiss();
            this.e = null;
        }
    }
}
