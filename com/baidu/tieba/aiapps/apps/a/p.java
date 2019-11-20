package com.baidu.tieba.aiapps.apps.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class p {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String dlG = "cookieMap";
    public static String dlH = "ptokenDomains";
    public static String dlI = "bdussDomains";

    public static void dd(Context context) {
        if (ProcessUtils.isMainProcess()) {
            a(context, null);
        } else {
            de(context);
        }
    }

    private static void de(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, e.class, null);
        if (callOnMainWithContentProvider.isOk()) {
            a(context, callOnMainWithContentProvider);
        }
    }

    public static void a(Context context, DelegateResult delegateResult) {
        ArrayList<String> stringArrayList;
        Map<String, String> map;
        ArrayList<String> arrayList = null;
        if (context != null) {
            if (delegateResult == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("bd_box_bduss", "");
                hashMap.put("bd_box_ptoken", "");
                stringArrayList = null;
                map = c.j(context, hashMap);
            } else {
                Map<String, String> map2 = delegateResult.mResult.getSerializable(dlG) != null ? (Map) delegateResult.mResult.getSerializable(dlG) : null;
                stringArrayList = delegateResult.mResult.containsKey(dlI) ? delegateResult.mResult.getStringArrayList(dlI) : null;
                if (delegateResult.mResult.containsKey(dlH)) {
                    arrayList = delegateResult.mResult.getStringArrayList(dlH);
                    map = map2;
                } else {
                    map = map2;
                }
            }
            if (map == null) {
                if (DEBUG) {
                    Log.w("SwanAppCookieUtils", "cookie is invalid");
                    return;
                }
                return;
            }
            for (String str : map.keySet()) {
                if (TextUtils.equals(str, "bd_box_bduss")) {
                    b(context, map.get(str), stringArrayList);
                } else if (TextUtils.equals(str, "bd_box_ptoken")) {
                    c(context, map.get(str), arrayList);
                }
            }
        }
    }

    private static void b(Context context, String str, List<String> list) {
        String buildBDUSSCookie;
        if (list == null) {
            list = SapiUtils.getAuthorizedDomains(context.getApplicationContext());
        }
        if (list == null) {
            if (DEBUG) {
                Log.w("SwanAppCookieUtils", "bduss domains is invalid");
                return;
            }
            return;
        }
        for (String str2 : list) {
            if (TextUtils.isEmpty(str)) {
                buildBDUSSCookie = aa.b(str2, "BDUSS", "deleted", 0L);
            } else {
                buildBDUSSCookie = SapiUtils.buildBDUSSCookie(str2, str);
            }
            v("http://www." + str2, buildBDUSSCookie, false);
        }
    }

    private static void c(Context context, String str, List<String> list) {
        String buildPtokenCookie;
        if (list == null) {
            list = SapiUtils.getAuthorizedDomainsForPtoken(context);
        }
        if (list == null) {
            if (DEBUG) {
                Log.w("SwanAppCookieUtils", "ptoken domains is invalid");
                return;
            }
            return;
        }
        for (String str2 : list) {
            if (TextUtils.isEmpty(str)) {
                buildPtokenCookie = aa.b(str2, "PTOKEN", "deleted", 0L);
            } else {
                buildPtokenCookie = SapiUtils.buildPtokenCookie(str2, str);
            }
            v("http://www." + str2, buildPtokenCookie, false);
        }
    }

    private static void v(String str, String str2, boolean z) {
        CookieManager.getInstance().setCookie(str, CookieManager.getInstance().getCookie(".baidu.com"));
        if (z) {
            CookieSyncManager.getInstance().sync();
        }
    }
}
