package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
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
public final class az extends com.baidu.adp.a.e {
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

    public final void a(DialogInterface.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public az(GroupSettingActivity groupSettingActivity) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        this.f.a(i);
        this.g.a(i);
        this.i.a(i);
        this.h.a(i);
        this.j.a(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.c);
        this.p.b(i);
    }

    public final ImageView a() {
        return this.q;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.h.setText(str);
        }
    }

    public final void d() {
        this.f.setSwitchStateChangeListener(this.a);
        this.g.setSwitchStateChangeListener(this.a);
        this.h.setOnClickListener(this.a);
        this.i.setOnClickListener(this.a);
        this.k.setOnClickListener(this.a);
        this.l.setOnClickListener(this.a);
        this.j.setOnClickListener(this.a);
    }

    public final SettingTextTipView e() {
        return this.h;
    }

    public final Button f() {
        return this.l;
    }

    public final Button g() {
        return this.k;
    }

    public final SettingTextTipView h() {
        return this.i;
    }

    public final SettingTextTipView i() {
        return this.j;
    }

    public final void j() {
        if (this.e == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setTitle(R.string.alerm_title);
            builder.setIcon((Drawable) null);
            builder.setCancelable(false);
            builder.setMessage(R.string.group_quit_alert);
            builder.setPositiveButton(R.string.alert_yes_button, this.a);
            builder.setNegativeButton(R.string.alert_no_button, new ba(this));
            this.e = builder.create();
            this.e.setCanceledOnTouchOutside(true);
        }
        if (!this.e.isShowing()) {
            this.e.show();
        }
    }

    public final AlertDialog k() {
        return this.e;
    }

    public final void l() {
        if (this.d == null) {
            this.d = new AlertDialog.Builder(this.a).setTitle(R.string.group_report).setItems(new CharSequence[]{new SpannableString(this.a.getString(R.string.group_report_ad)), new SpannableString(this.a.getString(R.string.group_report_sex)), new SpannableString(this.a.getString(R.string.group_report_lllegal))}, this.m).create();
        }
        this.d.setCanceledOnTouchOutside(true);
        this.d.show();
    }

    public final void m() {
        if (this.l != null) {
            this.l.setVisibility(8);
        }
    }

    public final void n() {
        if (this.k != null) {
            this.k.setVisibility(8);
        }
    }

    public final void a(boolean z) {
        if (this.g != null) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    public final void b(boolean z) {
        if (z) {
            this.g.b();
        } else {
            this.g.a();
        }
    }

    public final void o() {
        if (this.l != null) {
            this.l.setVisibility(0);
        }
    }

    public final void p() {
        if (this.k != null) {
            this.k.setVisibility(0);
        }
    }

    public final void q() {
        if (this.i != null) {
            this.i.setVisibility(0);
        }
    }

    public final void r() {
        if (this.i != null) {
            this.i.setVisibility(8);
        }
    }

    public final BdSwitchView s() {
        return this.g.getSwitchView();
    }

    public final BdSwitchView t() {
        return this.f.getSwitchView();
    }

    public final void u() {
        if (this.o == null) {
            this.o = new AlertDialog.Builder(this.b).setTitle(this.b.getString(R.string.alerm_title)).setCancelable(false).setMessage(R.string.group_dismiss_alert).setPositiveButton(R.string.alert_yes_button, this.a).setNegativeButton(R.string.alert_no_button, new bb(this)).create();
        }
        if (!this.o.isShowing()) {
            this.o.show();
        }
    }

    public final AlertDialog v() {
        return this.o;
    }

    public final void w() {
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
