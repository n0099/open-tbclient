package com.baidu.tbadk.switchs;

import d.a.c.e.f.a;
/* loaded from: classes3.dex */
public class VideoMiddlePageSwitch extends a {
    public static final String KEY = "video_middle_page_three";
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
        return 1;
    }

    @Override // d.a.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.a.c.e.f.a
    public String getName() {
        return KEY;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
