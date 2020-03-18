package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.featureSwitch.a;
import com.baidu.tbadk.core.sharedPref.b;
/* loaded from: classes.dex */
public class MissionEntranceSwitch extends a {
    public static final String KEY = "android_mission_system_entrance_switch";
    public static final int TYPE_CLOSE = 0;
    public static final int TYPE_OPEN = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return KEY;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getDefaultType() {
        return b.aFH().getInt("key_mission_entrance", 0);
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(KEY) == 1;
    }
}
