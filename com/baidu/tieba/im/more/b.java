package com.baidu.tieba.im.more;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b extends e {
    private NavigationBar a;
    private ViewGroup b;
    private View c;
    private SettingTextSwitchView d;
    private TbSettingTextTipView e;
    private SecretSettingActivity f;

    public b(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity);
        this.a = null;
        this.f = secretSettingActivity;
        secretSettingActivity.setContentView(s.secret_setting_activity);
    }

    public void a(SecretSettingActivity secretSettingActivity) {
        b(secretSettingActivity);
    }

    public void a(int i) {
        this.f.getLayoutMode().a(i == 1);
        this.f.getLayoutMode().a((View) this.b);
        this.a.c(i);
    }

    void b(SecretSettingActivity secretSettingActivity) {
        this.b = (RelativeLayout) secretSettingActivity.findViewById(r.parent);
        this.a = (NavigationBar) secretSettingActivity.findViewById(r.view_navigation_bar);
        this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(secretSettingActivity.getString(u.secretSetting_title));
        this.d = (SettingTextSwitchView) secretSettingActivity.findViewById(r.only_send_me);
        this.d.setSwitchStateChangeListener(this.f);
        this.e = (TbSettingTextTipView) secretSettingActivity.findViewById(r.black_address_list);
        this.e.setOnClickListener(this.f);
    }

    public void a() {
        this.f.showLoadingDialog(this.f.getString(u.loading));
    }

    public void b() {
        this.e.d();
    }

    public void c() {
        this.f.showLoadingDialog(this.f.getString(u.saving));
    }

    public void d() {
        this.f.closeLoadingDialog();
    }

    public View e() {
        return this.c;
    }

    public SettingTextSwitchView f() {
        return this.d;
    }

    public TbSettingTextTipView g() {
        return this.e;
    }
}
