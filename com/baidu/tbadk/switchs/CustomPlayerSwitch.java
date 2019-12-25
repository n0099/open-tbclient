package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes.dex */
public class CustomPlayerSwitch extends a {
    public static final String CUSTOM_PLAYER_SWITCH = "android_custom_player_enabled_2";
    public static final int DEFAULT_TYPE = 1;
    public static final int OFF_TYPE = 0;
    private static int mSwitchStatus = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return CUSTOM_PLAYER_SWITCH;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return new String[0];
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

    public static void setSwitchStatus(int i) {
        mSwitchStatus = i;
    }

    public static int getSwitchStatus() {
        return mSwitchStatus;
    }
}
