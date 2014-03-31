package com.baidu.tbadk.plugins;

import android.content.Context;
import android.view.View;
@com.baidu.tbplugin.a.c(a = "SapiCoreLight")
@com.baidu.tbplugin.a.a(a = "sapi_core_light.jar", b = "dex.wrapper.BdSapiCoreLightDelegateImpl")
/* loaded from: classes.dex */
public interface BdSapiCoreLightDelegate {

    /* loaded from: classes.dex */
    public interface SapiCoreLightCallback {
        void finishActivity();

        void onAuthorizationFailed(int i, String str);

        void onAuthorizationSuccess(String str, String str2, String str3, String str4, String str5);
    }

    void initSapi(Context context, String str, String str2, String str3, String str4);

    void setCallback(SapiCoreLightCallback sapiCoreLightCallback);

    void setupViews(View view);
}
