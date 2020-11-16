package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes.dex */
public class OpenJsSdkSwitch extends a {
    public static final String KEY = "openJSSDK";
    public static final int NOT_USE_NA_TYPE = 1;
    public static final int USE_NA_TYPE = 0;

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
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(KEY) == 0;
    }
}
