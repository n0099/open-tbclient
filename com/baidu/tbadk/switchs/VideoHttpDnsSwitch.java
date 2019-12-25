package com.baidu.tbadk.switchs;

import com.baidu.adp.lib.featureSwitch.a;
/* loaded from: classes.dex */
public class VideoHttpDnsSwitch extends a {
    public static final int DEFAULT_TYPE = 1;
    public static final String HTTP_DNS_SWITCH_KEY = "android_video_http_dns_open";
    public static final int OFF_TYPE = 0;

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
        return HTTP_DNS_SWITCH_KEY;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 0;
    }
}
