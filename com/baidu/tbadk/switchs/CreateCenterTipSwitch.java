package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import d.a.c.e.f.a;
/* loaded from: classes3.dex */
public class CreateCenterTipSwitch extends a {
    public static final String KEY_SWITCH = "work_up_pop_window";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_OPEN = 1;

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(KEY_SWITCH) == 1;
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
