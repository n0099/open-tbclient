package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes2.dex */
public class HttpsConnSwitch extends a {
    public static final String KEY = "is_call_test_https";
    public static final int TYPE_CLOSE = 0;
    public static final int TYPE_OPEN = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
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

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return KEY;
    }
}
