package com.baidu.tbadk.switchs;

import d.b.c.e.f.a;
import d.b.h0.k0.e;
/* loaded from: classes3.dex */
public class PageStayDurationSwitch extends a {
    @Override // d.b.c.e.f.a
    public void changeSettingByType(int i) {
        e.b().g(1 == i);
    }

    @Override // d.b.c.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.c.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.b.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.c.e.f.a
    public String getName() {
        return "log_online_smallflow";
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 1;
    }
}
