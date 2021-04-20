package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import d.b.c.e.f.a;
import d.b.h0.r.d0.b;
/* loaded from: classes3.dex */
public class FunAdSdkSwitch extends a {
    public static final String KEY_SWITCH = "bear_wxb_download";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_OPEN = 1;

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(KEY_SWITCH) == 1;
    }

    public static boolean isOpen() {
        return b.j().k("pref_key_fun_ad_sdk_enable", 1) == 1;
    }

    @Override // d.b.c.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.c.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.c.e.f.a
    public int getDefaultType() {
        return 1;
    }

    @Override // d.b.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.c.e.f.a
    public String getName() {
        return KEY_SWITCH;
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
