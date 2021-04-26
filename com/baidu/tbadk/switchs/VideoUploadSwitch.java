package com.baidu.tbadk.switchs;

import d.a.c.e.f.a;
/* loaded from: classes3.dex */
public class VideoUploadSwitch extends a {
    public static final String KEY = "movideo_split";
    public static final int UPLOAD_TYPE_MULTI = 1;
    public static final int UPLOAD_TYPE_SINGLE = 0;

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
        return 0;
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
