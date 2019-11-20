package com.baidu.tieba.aiapps.apps.o;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
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
public class b extends z {
    public static String drQ = "com.baidu.tieba://";
    private String mCallback;

    public b(j jVar) {
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
        JSONObject dP = o.dP(param);
        this.mCallback = dP.optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final String optString = dP.optString("authority");
        final String optString2 = dP.optString("path");
        final String optString3 = dP.optString(BdStatsConstant.StatsKey.TYPE, "NA");
        final String optString4 = dP.optString("action");
        JSONObject optJSONObject = dP.optJSONObject("scheme");
        try {
            optJSONObject.put("launchMode", "standard");
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        final String jSONObject = optJSONObject.toString();
        bVar.Rf().a((Activity) context, "mapp_i_baiduapp_page_trans", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.tieba.aiapps.apps.o.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: b */
            public void B(Boolean bool) {
                if (!bool.booleanValue()) {
                    com.baidu.swan.apps.console.c.e("PageTransitionAction", "non-authorized");
                    callbackHandler.handleSchemeDispatchCallback(b.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                } else if (!b.this.h(context, optString, optString2, optString3, optString4, jSONObject)) {
                    com.baidu.swan.apps.console.c.e("PageTransitionAction", "page transition fail");
                    callbackHandler.handleSchemeDispatchCallback(b.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    com.baidu.swan.apps.console.c.i("PageTransitionAction", "page transition success");
                    callbackHandler.handleSchemeDispatchCallback(b.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(0).toString());
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
            String str6 = null;
            switch (str3.hashCode()) {
                case -330473854:
                    if (str3.equals("anything")) {
                    }
                    break;
            }
            if ("icashwebview".equals(str4)) {
                if (!StringUtils.isNull(str5)) {
                    try {
                        String optString = new JSONObject(str5).optString("url");
                        if (!StringUtils.isNull(optString)) {
                            sy(optString);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                str6 = f(str, str2, str3, str4, str5);
                z = ax(context, str6);
            }
            if (DEBUG) {
                Log.i("PageTransitionAction", "result = " + z + "\n拼接后的uri is: " + str6);
            }
        }
        return z;
    }

    private void sy(String str) {
        com.baidu.swan.apps.process.messaging.client.a Iz;
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null && (Iz = Ra.Iz()) != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_param_url", str);
            Iz.a(bundle, a.class);
        }
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
            String str7 = drQ;
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

    private static boolean ax(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return UtilHelper.dealOneScheme(context, str);
    }
}
