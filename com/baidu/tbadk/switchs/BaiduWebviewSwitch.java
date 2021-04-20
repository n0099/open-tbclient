package com.baidu.tbadk.switchs;

import d.b.c.e.f.a;
/* loaded from: classes3.dex */
public class BaiduWebviewSwitch extends a {
    public static final String BAIDU_WEBVIEW = "baidu_webview";
    public static final int BAIDU_WEBVIEW_DEFAULT_TYPE = 0;
    public static final int BAIDU_WEBVIEW_EXTERNAL_TYPE = 2;
    public static final String[] BAIDU_WEBVIEW_KEY = {"com.baidu.browser"};
    public static final int BAIDU_WEBVIEW_OFF_TYPE = 1;

    @Override // d.b.c.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.c.e.f.a
    public String[] getCrashKeys() {
        return BAIDU_WEBVIEW_KEY;
    }

    @Override // d.b.c.e.f.a
    public int getDefaultType() {
        return 0;
    }

    @Override // d.b.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.c.e.f.a
    public String getName() {
        return BAIDU_WEBVIEW;
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 1;
    }
}
