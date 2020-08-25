package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes2.dex */
public class VCacheSwitch extends a {
    public static final String CACHE_SWITCH = "android_video_cache_open";
    public static final int DEFAULT_TYPE = 1;
    public static final int OFF_TYPE = 0;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return CACHE_SWITCH;
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
}
