package com.baidu.tbadk.switchs;

import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class VCacheSwitch extends a {
    public static final String CACHE_SWITCH = "android_video_cache_open";
    public static final int DEFAULT_TYPE = 1;
    public static final int OFF_TYPE = 0;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 1;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return CACHE_SWITCH;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
