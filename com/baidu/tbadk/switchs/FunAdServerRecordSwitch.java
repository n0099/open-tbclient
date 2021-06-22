package com.baidu.tbadk.switchs;

import d.a.c.e.f.a;
import d.a.n0.r.d0.b;
/* loaded from: classes3.dex */
public class FunAdServerRecordSwitch extends a {
    public static final String KEY_SWITCH = "ad_stlog_switch";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_OPEN = 1;

    public static boolean isOpen() {
        return b.j().k("pref_key_fun_ad_server_record_enable", 0) == 1;
    }

    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
    }

    @Override // d.a.c.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.a.c.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.a.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.a.c.e.f.a
    public String getName() {
        return KEY_SWITCH;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
