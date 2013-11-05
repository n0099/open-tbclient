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
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.more.SettingTextSwitchView;
import com.baidu.tieba.more.SettingTextTipView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private GroupSettingActivity f1473a;
    private RelativeLayout c;
    private RelativeLayout d;
    private TextView e;
    private ImageView f;
    private AlertDialog g;
    private AlertDialog h;
    private SettingTextSwitchView i;
    private SettingTextSwitchView j;
    private SettingTextTipView k;
    private SettingTextTipView l;
    private Button m;
    private Button n;
    private DialogInterface.OnClickListener o;
    private ProgressBar p;

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    public w(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity);
        this.f1473a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.o = null;
        this.f1473a = groupSettingActivity;
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        this.i.a(i);
        this.j.a(i);
        this.l.a(i);
        this.k.a(i);
        this.f1473a.m().a(i == 1);
        this.f1473a.m().a(this.c);
    }

    public ImageView a() {
        return this.f;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.k.setText(str);
        }
    }

    private void t() {
        this.f1473a.setContentView(R.layout.group_setting_activity);
        this.i = (SettingTextSwitchView) this.f1473a.findViewById(R.id.sv_group_msg_notify);
        this.j = (SettingTextSwitchView) this.f1473a.findViewById(R.id.sv_group_add_group);
        this.k = (SettingTextTipView) this.f1473a.findViewById(R.id.tv_change_name);
        this.l = (SettingTextTipView) this.f1473a.findViewById(R.id.sv_report);
        this.m = (Button) this.f1473a.findViewById(R.id.btn_dismiss);
        this.n = (Button) this.f1473a.findViewById(R.id.btn_quit);
        this.c = (RelativeLayout) this.f1473a.findViewById(R.id.parent);
        this.d = (RelativeLayout) this.f1473a.findViewById(R.id.title);
        this.e = (TextView) this.f1473a.findViewById(R.id.title_text);
        this.f = (ImageView) this.f1473a.findViewById(R.id.back);
        this.p = (ProgressBar) this.f1473a.findViewById(R.id.progress_loading);
    }

    public void e() {
        this.i.setSwitchStateChangeListener(this.f1473a);
        this.j.setSwitchStateChangeListener(this.f1473a);
        this.k.setOnClickListener(this.f1473a);
        this.l.setOnClickListener(this.f1473a);
        this.m.setOnClickListener(this.f1473a);
        this.f.setOnClickListener(this.f1473a);
        this.n.setOnClickListener(this.f1473a);
    }

    public SettingTextTipView f() {
        return this.k;
    }

    public Button g() {
        return this.n;
    }

    public SettingTextTipView h() {
        return this.l;
    }

    public void i() {
        if (this.h == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f1473a);
            builder.setTitle(R.string.alerm_title);
            builder.setIcon((Drawable) null);
            builder.setCancelable(false);
            builder.setMessage(R.string.group_quit_alert);
            builder.setPositiveButton(R.string.alert_yes_button, this.f1473a);
            builder.setNegativeButton(R.string.alert_no_button, new x(this));
            this.h = builder.create();
            this.h.setCanceledOnTouchOutside(true);
        }
        if (!this.h.isShowing()) {
            this.h.show();
        }
    }

    public AlertDialog j() {
        return this.h;
    }

    public void k() {
        if (this.g == null) {
            this.g = new AlertDialog.Builder(this.f1473a).setTitle(R.string.group_report).setItems(new CharSequence[]{new SpannableString(this.f1473a.getString(R.string.group_report_ad)), new SpannableString(this.f1473a.getString(R.string.group_report_sex)), new SpannableString(this.f1473a.getString(R.string.group_report_lllegal))}, this.o).create();
        }
        this.g.setCanceledOnTouchOutside(true);
        this.g.show();
    }

    public void l() {
        this.p.setVisibility(8);
    }

    public void m() {
        this.p.setVisibility(0);
    }

    public void n() {
        if (this.n != null) {
            this.n.setVisibility(8);
        }
    }

    public void a(boolean z) {
        if (this.j != null) {
            this.j.setVisibility(z ? 0 : 8);
        }
    }

    public void b(boolean z) {
        if (z) {
            this.j.b();
        } else {
            this.j.a();
        }
    }

    public void o() {
        if (this.n != null) {
            this.n.setVisibility(0);
        }
    }

    public void p() {
        if (this.l != null) {
            this.l.setVisibility(0);
        }
    }

    public void q() {
        if (this.l != null) {
            this.l.setVisibility(8);
        }
    }

    public BdSwitchView r() {
        return this.j.getSwitchView();
    }

    public BdSwitchView s() {
        return this.i.getSwitchView();
    }
}
