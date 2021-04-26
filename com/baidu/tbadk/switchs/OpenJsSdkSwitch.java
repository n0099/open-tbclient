package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import d.a.c.e.f.a;
/* loaded from: classes3.dex */
public class OpenJsSdkSwitch extends a {
    public static final String KEY = "openJSSDK";
    public static final int NOT_USE_NA_TYPE = 1;
    public static final int USE_NA_TYPE = 0;

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(KEY) == 0;
    }

    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
    }

    @Override // d.a.c.e.f.a
    public String[] getCrashKeys() {
        return new String[0];
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
        return KEY;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 1;
    }
}
