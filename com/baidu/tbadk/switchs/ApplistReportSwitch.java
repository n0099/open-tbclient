package com.baidu.tbadk.switchs;

import d.a.c.e.f.a;
/* loaded from: classes3.dex */
public class ApplistReportSwitch extends a {
    public static final String APPLIST_SWITCH_KEY = "applist_switch";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;

    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
    }

    @Override // d.a.c.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.a.c.e.f.a
    public int getDefaultType() {
        return 1;
    }

    @Override // d.a.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.a.c.e.f.a
    public String getName() {
        return APPLIST_SWITCH_KEY;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
