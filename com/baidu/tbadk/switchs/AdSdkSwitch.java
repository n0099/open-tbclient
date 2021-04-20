package com.baidu.tbadk.switchs;

import d.b.c.e.f.a;
/* loaded from: classes3.dex */
public class AdSdkSwitch extends a {
    public static final String KEY_AD_SDK_SWITCH = "ad_baichuan_open";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_OPEN = 1;

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
        return KEY_AD_SDK_SWITCH;
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
