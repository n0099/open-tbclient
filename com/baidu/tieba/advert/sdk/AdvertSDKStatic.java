package com.baidu.tieba.advert.sdk;

import com.baidu.mobads.AdSettings;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.SplashAd;
/* loaded from: classes8.dex */
public class AdvertSDKStatic {
    static {
        new a().registerTask();
        AdSettings.setSupportHttps(true);
        SplashAd.setMaxVideoCacheCapacityMb(30);
        MobadsPermissionSettings.setPermissionReadDeviceID(true);
        MobadsPermissionSettings.setPermissionAppList(true);
        new b().registerTask();
    }
}
