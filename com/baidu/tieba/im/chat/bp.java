package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.base.f {
    private GroupSettingActivity a;
    private RelativeLayout b;
    private AlertDialog c;
    private AlertDialog d;
    private SettingTextSwitchView e;
    private SettingTextSwitchView f;
    private TbSettingTextTipView g;
    private TbSettingTextTipView h;
    private TbSettingTextTipView i;
    private Button j;
    private Button k;
    private DialogInterface.OnClickListener l;
    private AlertDialog m;
    private NavigationBar n;
    private View o;

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public bp(GroupSettingActivity groupSettingActivity) {
        super(groupSettingActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = null;
        this.a = groupSettingActivity;
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        this.e.a(i);
        this.f.a(i);
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.b);
        this.n.c(i);
        if (i == 1) {
            this.j.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.big_red_button_1));
            this.k.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.big_red_button_1));
            return;
        }
        this.j.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.big_red_button));
        this.k.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.big_red_button));
    }

    public View a() {
        return this.o;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.g.setText(str);
        }
    }

    private void v() {
        this.a.setContentView(com.baidu.tieba.v.group_setting_activity);
        this.e = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.u.sv_group_msg_notify);
        this.f = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.u.sv_group_add_group);
        this.g = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.u.tv_change_name);
        this.h = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.u.sv_report);
        this.i = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.u.sv_delete_msg);
        this.j = (Button) this.a.findViewById(com.baidu.tieba.u.btn_dismiss);
        this.k = (Button) this.a.findViewById(com.baidu.tieba.u.btn_quit);
        this.b = (RelativeLayout) this.a.findViewById(com.baidu.tieba.u.parent);
        this.n = (NavigationBar) this.a.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.o = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.n.a(com.baidu.tieba.x.group_setting);
    }

    public void b() {
        this.e.setSwitchStateChangeListener(this.a);
        this.f.setSwitchStateChangeListener(this.a);
        this.g.setOnClickListener(this.a);
        this.h.setOnClickListener(this.a);
        this.j.setOnClickListener(this.a);
        this.k.setOnClickListener(this.a);
        this.i.setOnClickListener(this.a);
    }

    public TbSettingTextTipView c() {
        return this.g;
    }

    public Button d() {
        return this.k;
    }

    public Button e() {
        return this.j;
    }

    public TbSettingTextTipView f() {
        return this.h;
    }

    public TbSettingTextTipView g() {
        return this.i;
    }

    public void h() {
        if (this.d == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setTitle(com.baidu.tieba.x.alert_title);
            builder.setIcon((Drawable) null);
            builder.setCancelable(false);
            builder.setMessage(com.baidu.tieba.x.group_quit_alert);
            builder.setPositiveButton(com.baidu.tieba.x.alert_yes_button, this.a);
            builder.setNegativeButton(com.baidu.tieba.x.alert_no_button, new bq(this));
            this.d = builder.create();
            this.d.setCanceledOnTouchOutside(true);
        }
        if (!this.d.isShowing()) {
            com.baidu.adp.lib.e.e.a(this.d, this.a);
        }
    }

    public AlertDialog i() {
        return this.d;
    }

    public void j() {
        if (this.c == null) {
            this.c = new AlertDialog.Builder(this.a).setTitle(com.baidu.tieba.x.group_report).setItems(new CharSequence[]{new SpannableString(this.a.getString(com.baidu.tieba.x.group_report_ad)), new SpannableString(this.a.getString(com.baidu.tieba.x.group_report_sex)), new SpannableString(this.a.getString(com.baidu.tieba.x.group_report_lllegal))}, this.l).create();
        }
        this.c.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.e.e.a(this.c, this.a);
    }

    public void k() {
        if (this.k != null) {
            this.k.setVisibility(8);
        }
    }

    public void l() {
        if (this.j != null) {
            this.j.setVisibility(8);
        }
    }

    public void a(boolean z) {
        if (this.f != null) {
            this.f.setVisibility(z ? 0 : 8);
        }
    }

    public void b(boolean z) {
        if (z) {
            this.f.b();
        } else {
            this.f.a();
        }
    }

    public void m() {
        if (this.k != null) {
            this.k.setVisibility(0);
        }
    }

    public void n() {
        if (this.j != null) {
            this.j.setVisibility(0);
        }
    }

    public void o() {
        if (this.h != null) {
            this.h.setVisibility(0);
        }
    }

    public void p() {
        if (this.h != null) {
            this.h.setVisibility(8);
        }
    }

    public BdSwitchView q() {
        return this.f.getSwitchView();
    }

    public BdSwitchView r() {
        return this.e.getSwitchView();
    }

    public void s() {
        if (this.m == null) {
            this.m = new AlertDialog.Builder(this.mContext).setTitle(this.mContext.getString(com.baidu.tieba.x.alert_title)).setCancelable(false).setMessage(com.baidu.tieba.x.group_dismiss_alert).setPositiveButton(com.baidu.tieba.x.alert_yes_button, this.a).setNegativeButton(com.baidu.tieba.x.alert_no_button, new br(this)).create();
        }
        if (!this.m.isShowing()) {
            com.baidu.adp.lib.e.e.a(this.m, this.a);
        }
    }

    public AlertDialog t() {
        return this.m;
    }

    public void u() {
        if (this.m != null && this.m.isShowing()) {
            com.baidu.adp.lib.e.e.b(this.m, (Activity) this.mContext);
            this.m = null;
        }
        if (this.c != null && this.c.isShowing()) {
            com.baidu.adp.lib.e.e.b(this.c, (Activity) this.mContext);
            this.c = null;
        }
        if (this.d != null && this.d.isShowing()) {
            com.baidu.adp.lib.e.e.b(this.d, (Activity) this.mContext);
            this.d = null;
        }
    }
}
