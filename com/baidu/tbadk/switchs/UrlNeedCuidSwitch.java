package com.baidu.tbadk.switchs;

import d.b.c.e.f.a;
/* loaded from: classes3.dex */
public class UrlNeedCuidSwitch extends a {
    public static final int TYPE_CLOSE = 0;
    public static final int TYPE_OPEN = 1;
    public static final String URL_NEED_CUID_SWITCH = "android_url_need_cuid";

    @Override // d.b.c.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.c.e.f.a
    public String[] getCrashKeys() {
        return new String[0];
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
        return URL_NEED_CUID_SWITCH;
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
