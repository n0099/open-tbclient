package com.baidu.tieba.aiapps.apps.a;

import android.content.Context;
import android.provider.Settings;
import com.baidu.swan.apps.adaptation.a.t;
/* loaded from: classes19.dex */
public class c implements t {
    @Override // com.baidu.swan.apps.adaptation.a.t
    public String bo(Context context) {
        return com.baidu.helios.b.ag(context).zE();
    }

    @Override // com.baidu.swan.apps.adaptation.a.t
    public String getAndroidId(Context context) {
        return Settings.System.getString(context.getContentResolver(), "android_id");
    }
}
