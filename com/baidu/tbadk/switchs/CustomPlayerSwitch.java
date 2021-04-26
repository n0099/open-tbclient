package com.baidu.tbadk.switchs;

import d.a.c.e.f.a;
/* loaded from: classes3.dex */
public class CustomPlayerSwitch extends a {
    public static final String CUSTOM_PLAYER_SWITCH = "android_custom_player_enabled_2";
    public static final int DEFAULT_TYPE = 1;
    public static final int OFF_TYPE = 0;
    public static int mSwitchStatus = 1;

    public static int getSwitchStatus() {
        return mSwitchStatus;
    }

    public static void setSwitchStatus(int i2) {
        mSwitchStatus = i2;
    }

    @Override // d.a.c.e.f.a
    public void changeSettingByType(int i2) {
    }

    @Override // d.a.c.e.f.a
    public String[] getCrashKeys() {
        return new String[0];
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
        return CUSTOM_PLAYER_SWITCH;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
