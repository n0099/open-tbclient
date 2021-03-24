package com.baidu.tbadk.switchs;

import d.b.b.e.f.a;
/* loaded from: classes3.dex */
public class LbsWebViewSwitch extends a {
    public static final String LBS_WEBVIEW_SWITCH_KEY = "android_lbs_webview_open";
    public static final int TYPE_OFF = 0;
    public static final int TYPE_ON = 1;

    @Override // d.b.b.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.b.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.b.e.f.a
    public int getDefaultType() {
        return 1;
    }

    @Override // d.b.b.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.b.e.f.a
    public String getName() {
        return LBS_WEBVIEW_SWITCH_KEY;
    }

    @Override // d.b.b.e.f.a
    public int getOffType() {
        return 0;
    }
}
