package com.baidu.tieba.aiapps.apps.o;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends z {
    public static String dhw = "com.baidu.tieba://";
    private String mCallback;

    public a(j jVar) {
        super(jVar, "/swan/pageTransition");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
            return false;
        }
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
            return false;
        }
        JSONObject dd = o.dd(param);
        this.mCallback = dd.optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final String optString = dd.optString("authority");
        final String optString2 = dd.optString("path");
        final String optString3 = dd.optString("module", "NA");
        final String optString4 = dd.optString("action");
        JSONObject optJSONObject = dd.optJSONObject("scheme");
        try {
            optJSONObject.put("launchMode", "standard");
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        final String jSONObject = optJSONObject.toString();
        bVar.Mh().a((Activity) context, "mapp_i_baiduapp_page_trans", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.tieba.aiapps.apps.o.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: b */
            public void D(Boolean bool) {
                if (!bool.booleanValue()) {
                    com.baidu.swan.apps.console.c.e("PageTransitionAction", "non-authorized");
                    callbackHandler.handleSchemeDispatchCallback(a.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                } else if (!a.this.h(context, optString, optString2, optString3, optString4, jSONObject)) {
                    com.baidu.swan.apps.console.c.e("PageTransitionAction", "page transition fail");
                    callbackHandler.handleSchemeDispatchCallback(a.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    com.baidu.swan.apps.console.c.i("PageTransitionAction", "page transition success");
                    callbackHandler.handleSchemeDispatchCallback(a.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
        });
        com.baidu.swan.apps.console.c.i("PageTransitionAction", "callback success");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(Context context, String str, String str2, String str3, String str4, String str5) {
        boolean z = false;
        if (!TextUtils.isEmpty(str5) && context != null) {
            switch (str3.hashCode()) {
                case -330473854:
                    if (str3.equals("anything")) {
                    }
                    break;
            }
            String f = f(str, str2, str3, str4, str5);
            z = at(context, f);
            if (DEBUG) {
                Log.i("PageTransitionAction", "result = " + z + "\n拼接后的uri is: " + f);
            }
        }
        return z;
    }

    private static String f(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str5)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<String> keys = new JSONObject(str5).keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (TextUtils.isEmpty(next)) {
                    return null;
                }
                sb.append(next + "=" + Uri.encode(jSONObject.opt(next).toString()) + "&");
            }
            if (!TextUtils.isEmpty(str4)) {
                str4 = "/" + str4;
            }
            String str6 = TextUtils.equals(str3, "NA") ? "" : "/" + str3;
            if (TextUtils.isEmpty(str2)) {
                str2 = str6 + str4;
            }
            String str7 = dhw;
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    str7 = str7 + str;
                }
            } else {
                String substring = str2.substring(1, str2.length());
                str7 = TextUtils.isEmpty(str) ? str7 + substring : str7 + str + "/" + substring;
            }
            StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.length() - 1));
            String str8 = str7 + "?" + ((Object) sb2);
            if (DEBUG) {
                Log.i("PageTransitionAction", "encodeParams: " + ((Object) sb2));
                return str8;
            }
            return str8;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private static boolean at(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return UtilHelper.dealOneScheme(context, str);
    }
}
