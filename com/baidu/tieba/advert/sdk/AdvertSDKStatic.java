package com.baidu.tieba.advert.sdk;

import android.util.Log;
/* loaded from: classes7.dex */
public class AdvertSDKStatic {
    static {
        new a().registerTask();
        Log.e("AdvertSDKStatic", "Advert install finished.");
        new b().registerTask();
        new c().registerTask();
    }
}
