package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import d.a.c.e.f.a;
import d.a.c.e.f.b;
/* loaded from: classes3.dex */
public class KeepAliveSwitch extends a {
    public static final String KEEP_ALIVE_KEY = "android_new_keep_alive";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

    @Override // d.a.c.e.f.a
    public void addToManager() {
        b bVar = new b(this.mName, this.mDefaultType, this.mSwitchListener);
        bVar.i(this.mMaxCrashTimes, this.mKey, this.mOffType);
        bVar.k(getSwitchLibs());
        bVar.j(true);
        SwitchManager.getInstance().addSwitchData(bVar);
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
        return KEEP_ALIVE_KEY;
    }

    @Override // d.a.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
