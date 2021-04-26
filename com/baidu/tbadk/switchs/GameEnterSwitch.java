package com.baidu.tbadk.switchs;

import d.a.c.e.f.a;
/* loaded from: classes3.dex */
public class GameEnterSwitch extends a {
    public static final String GAME_ENTER_KEY = "android_game_enter_switch";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

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
        return GAME_ENTER_KEY;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
