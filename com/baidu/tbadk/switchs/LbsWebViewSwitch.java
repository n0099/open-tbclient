package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes2.dex */
public class LbsWebViewSwitch extends a {
    public static final String LBS_WEBVIEW_SWITCH_KEY = "android_lbs_webview_open";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return LBS_WEBVIEW_SWITCH_KEY;
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
