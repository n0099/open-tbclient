package com.baidu.tbadk.switchs;

import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class LoginDefaultTypeSmsSwitch extends a {
    public static final String SWITCH_NAME = "android_pass_login_sms_enable";
    public static final int TYPE_CLOSED = 0;
    public static final int TYPE_OPEN = 1;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return new String[0];
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
        return SWITCH_NAME;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
