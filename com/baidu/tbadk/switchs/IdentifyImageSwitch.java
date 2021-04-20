package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import d.b.c.e.f.a;
/* loaded from: classes3.dex */
public class IdentifyImageSwitch extends a {
    public static final String KEY = "android_identify_image";
    public static final int TYPE_CLOSE = 0;
    public static final int TYPE_OPEN = 1;

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(KEY) == 1;
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
        return KEY;
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
