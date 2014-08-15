package com.baidu.tieba.im.more;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class a extends f {
    private NavigationBar a;
    private ViewGroup b;
    private View c;
    private TbSettingTextTipView d;
    private SecretSettingActivity e;

    public a(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity);
        this.a = null;
        this.e = secretSettingActivity;
        secretSettingActivity.setContentView(v.secret_setting_activity);
    }

    public void a(SecretSettingActivity secretSettingActivity) {
        b(secretSettingActivity);
    }

    public void a(int i) {
        this.e.getLayoutMode().a(i == 1);
        this.e.getLayoutMode().a((View) this.b);
        this.a.c(i);
    }

    void b(SecretSettingActivity secretSettingActivity) {
        this.b = (RelativeLayout) secretSettingActivity.findViewById(u.parent);
        this.a = (NavigationBar) secretSettingActivity.findViewById(u.view_navigation_bar);
        this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.a(secretSettingActivity.getString(x.secretSetting_title));
        this.d = (TbSettingTextTipView) secretSettingActivity.findViewById(u.black_address_list);
        this.d.setOnClickListener(this.e);
    }

    public void a() {
        this.d.d();
    }

    public View b() {
        return this.c;
    }

    public TbSettingTextTipView c() {
        return this.d;
    }
}
