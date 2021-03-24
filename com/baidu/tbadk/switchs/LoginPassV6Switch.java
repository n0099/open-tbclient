package com.baidu.tbadk.switchs;

import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class LoginPassV6Switch extends a {
    public static final int DEFAULT_TYPE = 0;
    public static final String KEY = "switch_login_passv6";
    public static final int TYPE_OLD = 1;

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
        return KEY;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 1;
    }
}
