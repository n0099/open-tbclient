package com.baidu.tieba.aiapps.apps.d;

import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.setting.oauth.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CookieManager deT;

    public a() {
        this.deT = null;
        this.deT = new b();
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return this.deT.shouldAcceptCookie(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, n(str, str2, 1));
        if (!callOnMainWithContentProvider.isOk()) {
            return false;
        }
        return callOnMainWithContentProvider.mResult.getBoolean("result");
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return this.deT.shouldSendCookie(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, n(str, str2, 2));
        if (!callOnMainWithContentProvider.isOk()) {
            return false;
        }
        return callOnMainWithContentProvider.mResult.getBoolean("result");
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        if (ProcessUtils.isMainProcess()) {
            this.deT.storeCookie(str, list);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("type", 3);
        bundle.putString("param1", str);
        bundle.putStringArrayList("param2", (ArrayList) list);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
        if (DEBUG) {
            Log.d("DelegationCookieManager", "set cookies for " + str);
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        if (ProcessUtils.isMainProcess()) {
            return this.deT.getCookie(str);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, n(str, "", 4));
        if (!callOnMainWithContentProvider.isOk()) {
            return "";
        }
        String string = callOnMainWithContentProvider.mResult.getString("result");
        if (DEBUG) {
            Log.d("DelegationCookieManager", "getCookie cookie : " + string);
            return string;
        }
        return string;
    }

    private Bundle n(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        return bundle;
    }
}
