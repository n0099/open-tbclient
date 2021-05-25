package com.baidu.tbadk.switchs;

import d.a.c.e.f.a;
import d.a.m0.m0.k;
/* loaded from: classes3.dex */
public class PerformanceSwitch extends a {
    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
        k.d().h(1 == i2);
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
        return "log_stat_smallflow";
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 1;
    }
}
