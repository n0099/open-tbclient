package com.baidu.tieba.im.more;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.a.f;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.im.h;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.j;
/* loaded from: classes.dex */
public final class b extends f {
    private NavigationBar a;
    private ViewGroup c;
    private View d;
    private SettingTextSwitchView e;
    private TbSettingTextTipView f;
    private SecretSettingActivity g;

    public b(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity);
        this.a = null;
        this.g = secretSettingActivity;
        secretSettingActivity.setContentView(i.secret_setting_activity);
    }

    public final void a(int i) {
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a(this.c);
        this.a.b(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(SecretSettingActivity secretSettingActivity) {
        this.c = (RelativeLayout) secretSettingActivity.findViewById(h.parent);
        this.a = (NavigationBar) secretSettingActivity.findViewById(h.view_navigation_bar);
        this.d = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(secretSettingActivity.getString(j.secretSetting_title));
        this.e = (SettingTextSwitchView) secretSettingActivity.findViewById(h.only_send_me);
        this.e.setSwitchStateChangeListener(this.g);
        this.f = (TbSettingTextTipView) secretSettingActivity.findViewById(h.black_address_list);
        this.f.setOnClickListener(this.g);
    }

    public final void a() {
        this.g.showLoadingDialog(this.g.getString(j.loading));
    }

    public final void d() {
        TbSettingTextTipView tbSettingTextTipView = this.f;
        TbSettingTextTipView.c();
    }

    public final void e() {
        this.g.showLoadingDialog(this.g.getString(j.saving));
    }

    public final void f() {
        this.g.closeLoadingDialog();
    }

    public final View g() {
        return this.d;
    }

    public final SettingTextSwitchView h() {
        return this.e;
    }

    public final TbSettingTextTipView i() {
        return this.f;
    }
}
