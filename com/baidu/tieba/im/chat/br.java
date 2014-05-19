package com.baidu.tieba.im.chat;

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
public class br extends com.baidu.adp.base.e {
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

    public br(GroupSettingActivity groupSettingActivity) {
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
            this.j.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.q.big_red_button_1));
            this.k.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.q.big_red_button_1));
            return;
        }
        this.j.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.q.big_red_button));
        this.k.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.q.big_red_button));
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
        this.a.setContentView(com.baidu.tieba.s.group_setting_activity);
        this.e = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.r.sv_group_msg_notify);
        this.f = (SettingTextSwitchView) this.a.findViewById(com.baidu.tieba.r.sv_group_add_group);
        this.g = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.r.tv_change_name);
        this.h = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.r.sv_report);
        this.i = (TbSettingTextTipView) this.a.findViewById(com.baidu.tieba.r.sv_delete_msg);
        this.j = (Button) this.a.findViewById(com.baidu.tieba.r.btn_dismiss);
        this.k = (Button) this.a.findViewById(com.baidu.tieba.r.btn_quit);
        this.b = (RelativeLayout) this.a.findViewById(com.baidu.tieba.r.parent);
        this.n = (NavigationBar) this.a.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.o = this.n.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.n.a(com.baidu.tieba.u.group_setting);
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
            builder.setTitle(com.baidu.tieba.u.alerm_title);
            builder.setIcon((Drawable) null);
            builder.setCancelable(false);
            builder.setMessage(com.baidu.tieba.u.group_quit_alert);
            builder.setPositiveButton(com.baidu.tieba.u.alert_yes_button, this.a);
            builder.setNegativeButton(com.baidu.tieba.u.alert_no_button, new bs(this));
            this.d = builder.create();
            this.d.setCanceledOnTouchOutside(true);
        }
        if (!this.d.isShowing()) {
            this.d.show();
        }
    }

    public AlertDialog i() {
        return this.d;
    }

    public void j() {
        if (this.c == null) {
            this.c = new AlertDialog.Builder(this.a).setTitle(com.baidu.tieba.u.group_report).setItems(new CharSequence[]{new SpannableString(this.a.getString(com.baidu.tieba.u.group_report_ad)), new SpannableString(this.a.getString(com.baidu.tieba.u.group_report_sex)), new SpannableString(this.a.getString(com.baidu.tieba.u.group_report_lllegal))}, this.l).create();
        }
        this.c.setCanceledOnTouchOutside(true);
        this.c.show();
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
            this.m = new AlertDialog.Builder(this.mContext).setTitle(this.mContext.getString(com.baidu.tieba.u.alerm_title)).setCancelable(false).setMessage(com.baidu.tieba.u.group_dismiss_alert).setPositiveButton(com.baidu.tieba.u.alert_yes_button, this.a).setNegativeButton(com.baidu.tieba.u.alert_no_button, new bt(this)).create();
        }
        if (!this.m.isShowing()) {
            this.m.show();
        }
    }

    public AlertDialog t() {
        return this.m;
    }

    public void u() {
        if (this.m != null && this.m.isShowing()) {
            this.m.dismiss();
            this.m = null;
        }
        if (this.c != null && this.c.isShowing()) {
            this.c.dismiss();
            this.c = null;
        }
        if (this.d != null && this.d.isShowing()) {
            this.d.dismiss();
            this.d = null;
        }
    }
}
