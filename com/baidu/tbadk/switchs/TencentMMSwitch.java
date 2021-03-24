package com.baidu.tbadk.switchs;

import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class TencentMMSwitch extends a {
    public static final String MM = "tencent_mm";
    public static final int MM_DEFAULT_TYPE = 0;
    public static final String[] MM_KEY = {"com.tencent.mm"};
    public static final int MM_OFF_TYPE = 1;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return MM_KEY;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return MM;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 1;
    }
}
