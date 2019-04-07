package com.baidu.tieba.aiapps.apps.d;

import android.util.Log;
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
        if (DEBUG) {
            Log.d("RealCookieManager", "storeCookie httpUrl: " + str);
            Log.d("RealCookieManager", "storeCookie cookies: " + list);
        }
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
            }
            com.baidu.tieba.aiapps.apps.a.a.Dn().storeCookie(str, list);
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        return com.baidu.tieba.aiapps.apps.a.a.Dn().getCookie(str);
    }
}
