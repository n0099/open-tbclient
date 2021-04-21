package com.baidu.tbadk.switchs;

import d.b.c.e.f.a;
import d.b.i0.r.d0.b;
/* loaded from: classes3.dex */
public class ImmersiveStickySwitch extends a {
    public static final String KEY = "android_immersive_switch";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

    @Override // d.b.c.e.f.a
    public void changeSettingByType(int i) {
        if (i == 1) {
            b.j().t("switch_immersive_sticky_status", true);
        } else {
            b.j().t("switch_immersive_sticky_status", false);
        }
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
