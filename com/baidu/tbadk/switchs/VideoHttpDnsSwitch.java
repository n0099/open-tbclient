package com.baidu.tbadk.switchs;

import d.b.c.e.f.a;
/* loaded from: classes3.dex */
public class VideoHttpDnsSwitch extends a {
    public static final int DEFAULT_TYPE = 1;
    public static final String HTTP_DNS_SWITCH_KEY = "android_video_http_dns_open";
    public static final int OFF_TYPE = 0;

    @Override // d.b.c.e.f.a
    public void changeSettingByType(int i) {
    }

    @Override // d.b.c.e.f.a
    public String[] getCrashKeys() {
        return null;
    }

    @Override // d.b.c.e.f.a
    public int getDefaultType() {
        return 1;
    }

    @Override // d.b.c.e.f.a
    public int getMaxCrashTimes() {
        return 10;
    }

    @Override // d.b.c.e.f.a
    public String getName() {
        return HTTP_DNS_SWITCH_KEY;
    }

    @Override // d.b.c.e.f.a
    public int getOffType() {
        return 0;
    }
}
