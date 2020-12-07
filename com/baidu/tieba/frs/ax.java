package com.baidu.tieba.frs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
/* loaded from: classes21.dex */
public class ax extends com.baidu.adp.lib.featureSwitch.a {
    public static boolean isOn() {
        return SwitchManager.getInstance().findType("official_thread_enable_delete_switch") == 1;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return "official_thread_enable_delete_switch";
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getDefaultType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
