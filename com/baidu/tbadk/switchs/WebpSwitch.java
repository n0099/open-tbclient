package com.baidu.tbadk.switchs;

import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class WebpSwitch extends a {
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;
    public static final String WEBP_ENABLE = "webp_enable";

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
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
        return WEBP_ENABLE;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
