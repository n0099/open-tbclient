package com.baidu.tbadk.switchs;

import d.a.c.e.f.a;
import d.a.m0.r.d0.b;
/* loaded from: classes3.dex */
public class BigdaySwitch extends a {
    public static final String BIGDAY_KEY = "android_bigday_switch";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
    }

    @Override // d.a.c.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.a.c.e.f.a
    public int getDefaultType() {
        return b.j().k("key_bigday_sync_switch", 0);
    }

    @Override // d.a.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.a.c.e.f.a
    public String getName() {
        return BIGDAY_KEY;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
