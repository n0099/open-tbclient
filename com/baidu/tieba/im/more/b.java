package com.baidu.tieba.im.more;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.base.c;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class b extends c {
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
        secretSettingActivity.setContentView(w.secret_setting_activity);
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
        this.b = (RelativeLayout) secretSettingActivity.findViewById(v.parent);
        this.a = (NavigationBar) secretSettingActivity.findViewById(v.view_navigation_bar);
        this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(secretSettingActivity.getString(y.secretSetting_title));
        this.d = (SettingTextSwitchView) secretSettingActivity.findViewById(v.only_send_me);
        this.d.setSwitchStateChangeListener(this.f);
        this.e = (TbSettingTextTipView) secretSettingActivity.findViewById(v.black_address_list);
        this.e.setOnClickListener(this.f);
    }

    public void a() {
        this.f.showLoadingDialog(this.f.getString(y.loading));
    }

    public void b() {
        this.e.d();
    }

    public void c() {
        this.f.showLoadingDialog(this.f.getString(y.saving));
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
