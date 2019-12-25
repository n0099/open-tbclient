package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.sharedPref.b;
/* loaded from: classes.dex */
public class ImmersiveStickySwitch extends a {
    public static final String KEY = "android_immersive_switch";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return KEY;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
        if (i == 1) {
            b.aCY().putBoolean(SharedPrefConfig.SWITCH_IMMERSIVE_STICKY_STATUS, true);
        } else {
            b.aCY().putBoolean(SharedPrefConfig.SWITCH_IMMERSIVE_STICKY_STATUS, false);
        }
    }
}
