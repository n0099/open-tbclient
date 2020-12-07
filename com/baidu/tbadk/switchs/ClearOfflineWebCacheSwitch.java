package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.featureSwitch.a;
import com.baidu.adp.lib.featureSwitch.b;
/* loaded from: classes.dex */
public class ClearOfflineWebCacheSwitch extends a {
    public static final String CLEAR_OFFLINE_WEB_CACHE = "clear_offline_web_cache";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

    public static boolean isOn() {
        return SwitchManager.getInstance().findType(CLEAR_OFFLINE_WEB_CACHE) == 1;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void addToManager() {
        b bVar = new b(this.mName, this.mDefaultType, this.mSwitchListener);
        bVar.a(this.mMaxCrashTimes, this.mKey, this.mOffType);
        bVar.g(getSwitchLibs());
        bVar.ab(true);
        SwitchManager.getInstance().addSwitchData(bVar);
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return CLEAR_OFFLINE_WEB_CACHE;
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
