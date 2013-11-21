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
public class v extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private GroupSettingActivity f1555a;
    private RelativeLayout c;
    private AlertDialog d;
    private AlertDialog e;
    private SettingTextSwitchView f;
    private SettingTextSwitchView g;
    private SettingTextTipView h;
    private SettingTextTipView i;
    private Button j;
    private Button k;
    private DialogInterface.OnClickListener l;
    private ProgressBar m;
    private NavigationBar n;
    private ImageView o;

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public v(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity);
        this.f1555a = null;
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = null;
        this.f1555a = groupSettingActivity;
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        this.f.a(i);
        this.g.a(i);
        this.i.a(i);
        this.h.a(i);
        this.f1555a.getLayoutMode().a(i == 1);
        this.f1555a.getLayoutMode().a(this.c);
        this.n.c(i);
    }

    public ImageView a() {
        return this.o;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.h.setText(str);
        }
    }

    private void t() {
        this.f1555a.setContentView(R.layout.group_setting_activity);
        this.f = (SettingTextSwitchView) this.f1555a.findViewById(R.id.sv_group_msg_notify);
        this.g = (SettingTextSwitchView) this.f1555a.findViewById(R.id.sv_group_add_group);
        this.h = (SettingTextTipView) this.f1555a.findViewById(R.id.tv_change_name);
        this.i = (SettingTextTipView) this.f1555a.findViewById(R.id.sv_report);
        this.j = (Button) this.f1555a.findViewById(R.id.btn_dismiss);
        this.k = (Button) this.f1555a.findViewById(R.id.btn_quit);
        this.c = (RelativeLayout) this.f1555a.findViewById(R.id.parent);
        this.m = (ProgressBar) this.f1555a.findViewById(R.id.progress_loading);
        this.n = (NavigationBar) this.f1555a.findViewById(R.id.view_navigation_bar);
        this.o = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.f1555a);
        this.n.a(R.string.group_setting);
    }

    public void e() {
        this.f.setSwitchStateChangeListener(this.f1555a);
        this.g.setSwitchStateChangeListener(this.f1555a);
        this.h.setOnClickListener(this.f1555a);
        this.i.setOnClickListener(this.f1555a);
        this.j.setOnClickListener(this.f1555a);
        this.k.setOnClickListener(this.f1555a);
    }

    public SettingTextTipView f() {
        return this.h;
    }

    public Button g() {
        return this.k;
    }

    public SettingTextTipView h() {
        return this.i;
    }

    public void i() {
        if (this.e == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f1555a);
            builder.setTitle(R.string.alerm_title);
            builder.setIcon((Drawable) null);
            builder.setCancelable(false);
            builder.setMessage(R.string.group_quit_alert);
            builder.setPositiveButton(R.string.alert_yes_button, this.f1555a);
            builder.setNegativeButton(R.string.alert_no_button, new w(this));
            this.e = builder.create();
            this.e.setCanceledOnTouchOutside(true);
        }
        if (!this.e.isShowing()) {
            this.e.show();
        }
    }

    public AlertDialog j() {
        return this.e;
    }

    public void k() {
        if (this.d == null) {
            this.d = new AlertDialog.Builder(this.f1555a).setTitle(R.string.group_report).setItems(new CharSequence[]{new SpannableString(this.f1555a.getString(R.string.group_report_ad)), new SpannableString(this.f1555a.getString(R.string.group_report_sex)), new SpannableString(this.f1555a.getString(R.string.group_report_lllegal))}, this.l).create();
        }
        this.d.setCanceledOnTouchOutside(true);
        this.d.show();
    }

    public void l() {
        this.m.setVisibility(8);
    }

    public void m() {
        this.m.setVisibility(0);
    }

    public void n() {
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

    public void o() {
        if (this.k != null) {
            this.k.setVisibility(0);
        }
    }

    public void p() {
        if (this.i != null) {
            this.i.setVisibility(0);
        }
    }

    public void q() {
        if (this.i != null) {
            this.i.setVisibility(8);
        }
    }

    public BdSwitchView r() {
        return this.g.getSwitchView();
    }

    public BdSwitchView s() {
        return this.f.getSwitchView();
    }
}
