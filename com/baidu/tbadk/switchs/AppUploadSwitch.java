package com.baidu.tbadk.switchs;

import d.b.c.e.f.a;
/* loaded from: classes3.dex */
public class AppUploadSwitch extends a {
    public static final String KEY = "upload_app_lists";
    public static final int TYPE_CLOSE = 0;
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
