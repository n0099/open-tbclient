package com.baidu.tieba.aiapps.apps.e;

import android.util.Log;
import android.webkit.CookieManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.setting.oauth.f;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        CookieManager cookieManager;
        if (DEBUG) {
            Log.d("RealCookieManager", "storeCookie httpUrl: " + str);
            Log.d("RealCookieManager", "storeCookie cookies: " + list);
        }
        try {
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            BdLog.e(th);
            cookieManager = null;
        }
        if (cookieManager != null && list != null && list.size() > 0) {
            for (String str2 : list) {
                cookieManager.setCookie(str, str2);
            }
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        CookieManager cookieManager;
        try {
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            BdLog.e(th);
            cookieManager = null;
        }
        if (cookieManager == null) {
            return null;
        }
        return cookieManager.getCookie(str);
    }
}
