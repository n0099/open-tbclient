package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes2.dex */
public class TBCdnPortraitSwitch extends a {
    public static final String CDNPORTRAIT_SWITCH_KEY = "portrait_cdn_open";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
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
    protected int getMaxCrashTimes() {
        return 10;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return CDNPORTRAIT_SWITCH_KEY;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 0;
    }
}
