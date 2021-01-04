package com.baidu.tieba.aiapps.apps.h;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends aa {
    public static String goo = "com.baidu.tieba://";
    private String mCallback;

    public b(j jVar) {
        super(jVar, "/swanAPI/pageTransition");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
            return false;
        }
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
            return false;
        }
        JSONObject parseString = v.parseString(param);
        this.mCallback = parseString.optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        final String optString = parseString.optString("authority");
        final String optString2 = parseString.optString("path");
        final String optString3 = parseString.optString(BdStatsConstant.StatsKey.TYPE, "NA");
        final String optString4 = parseString.optString("action");
        JSONObject optJSONObject = parseString.optJSONObject("scheme");
        try {
            optJSONObject.put("launchMode", "standard");
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        final String jSONObject = optJSONObject.toString();
        eVar.aMw().b((Activity) context, "mapp_i_baiduapp_page_trans", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.tieba.aiapps.apps.h.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(h<b.d> hVar) {
                if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, b.this.mCallback);
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
                            Gc(optString);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                str6 = h(str, str2, str3, str4, str5);
                z = aR(context, str6);
            }
            if (DEBUG) {
                Log.i("PageTransitionAction", "result = " + z + "\n拼接后的uri is: " + str6);
            }
        }
        return z;
    }

    private void Gc(String str) {
        com.baidu.swan.apps.process.messaging.client.a aMb;
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk != null && (aMb = aMk.aMb()) != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_param_url", str);
            aMb.b(bundle, a.class);
        }
    }

    private static String h(String str, String str2, String str3, String str4, String str5) {
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
                sb.append(next + "=" + Uri.encode(jSONObject.opt(next).toString()) + ETAG.ITEM_SEPARATOR);
            }
            if (!TextUtils.isEmpty(str4)) {
                str4 = "/" + str4;
            }
            String str6 = TextUtils.equals(str3, "NA") ? "" : "/" + str3;
            if (TextUtils.isEmpty(str2)) {
                str2 = str6 + str4;
            }
            String str7 = goo;
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

    private static boolean aR(final Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && str.contains("tbwebview")) {
            Uri parse = Uri.parse(str);
            if (f.r(parse)) {
                f.bln().a(str, parse, new f.a() { // from class: com.baidu.tieba.aiapps.apps.h.b.2
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void onCallBack(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.PARAM_URL) instanceof String)) {
                            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, null, (String) hashMap.get(f.PARAM_URL), true);
                            tbWebViewActivityConfig.setIsFromSchema(true);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
                        }
                    }
                });
                return true;
            }
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context);
            tbWebViewActivityConfig.setUri(parse);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
            return true;
        }
        if (!TextUtils.isEmpty(str) && str.contains("com.baidu.tieba")) {
            Uri parse2 = Uri.parse(str);
            if ("miniapp".equals(parse2.getAuthority()) && "/goods".equals(parse2.getPath())) {
                g.publishEvent(new GoodsEvent(parse2.getQueryParameter("goodsList")));
                return true;
            }
        }
        return UtilHelper.dealOneScheme(context, str);
    }
}
