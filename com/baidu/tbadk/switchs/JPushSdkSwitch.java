package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import d.a.c.e.f.a;
/* loaded from: classes3.dex */
public class JPushSdkSwitch extends a {
    public static final String JPUSH_SDK_KEY = "android_jpush_switch";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(JPUSH_SDK_KEY) == 1;
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
        return JPUSH_SDK_KEY;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
