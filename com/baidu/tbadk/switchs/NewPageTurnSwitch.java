package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import d.b.c.e.f.a;
/* loaded from: classes3.dex */
public class NewPageTurnSwitch extends a {
    public static final String KEY_NEW_PAGE_TURN = "android_new_page_turn";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(KEY_NEW_PAGE_TURN) == 1;
    }

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
        return KEY_NEW_PAGE_TURN;
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
