package com.baidu.tbadk.switchs;

import d.b.c.e.f.a;
/* loaded from: classes3.dex */
public class RepostToDynamicDefaultSwitch extends a {
    public static final String KEY = "repost_to_dynamic_by_default";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

    @Override // d.b.c.e.f.a
    public void changeSettingByType(int i) {
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
        return KEY;
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
