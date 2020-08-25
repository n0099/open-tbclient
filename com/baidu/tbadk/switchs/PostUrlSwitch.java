package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes2.dex */
public class PostUrlSwitch extends a {
    public static final String KEY_POST_URL_SWITCH = "android_url_post";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_OPEN = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return KEY_POST_URL_SWITCH;
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

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(KEY_POST_URL_SWITCH) == 1;
    }
}
