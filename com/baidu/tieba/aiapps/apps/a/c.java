package com.baidu.tieba.aiapps.apps.a;

import android.content.Context;
import android.provider.Settings;
import com.baidu.swan.apps.adaptation.a.t;
/* loaded from: classes24.dex */
public class c implements t {
    @Override // com.baidu.swan.apps.adaptation.a.t
    public String bt(Context context) {
        return com.baidu.helios.b.aj(context).zr();
    }

    @Override // com.baidu.swan.apps.adaptation.a.t
    public String getAndroidId(Context context) {
        return Settings.System.getString(context.getContentResolver(), "android_id");
    }
}
