package com.baidu.tbadk.switchs;

import com.baidu.tieba.debugtool.annotation.Modify;
import d.a.c.e.f.a;
import d.a.m0.r.d0.b;
/* loaded from: classes3.dex */
public class SplashDealyTimeoutSwitch extends a {
    public static final String KEY_SWITCH = "ad_screen_delay_switch";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_OPEN = 1;

    @Modify(description = "开屏广告是否打开请求超时开关")
    public static boolean isOpen() {
        return b.j().k("pref_key_splash_timeout_enable", 1) == 1;
    }

    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
    }

    @Override // d.a.c.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.a.c.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.a.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.a.c.e.f.a
    public String getName() {
        return KEY_SWITCH;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
