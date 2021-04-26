package com.baidu.tbadk.switchs;

import d.a.c.e.f.a;
/* loaded from: classes3.dex */
public class MotuSwitch extends a {
    public static final int DEFAULT_TYPE = 0;
    public static final String MOTU = "motu_sdk";
    public static final String[] MOTU_KEY = {"cn.jingling.lib"};
    public static final int OFF_TYPE = 1;

    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
    }

    @Override // d.a.c.e.f.a
    public String[] getCrashKeys() {
        return MOTU_KEY;
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
        return MOTU;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 1;
    }
}
