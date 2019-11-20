package com.baidu.tieba.aiapps.apps.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.a.g;
import com.baidu.swan.apps.setting.oauth.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends z {
    public c(j jVar) {
        super(jVar, "/swan/thirdPartyLogin");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        final String optString2 = optParamsAsJo.optString("type", "");
        int rZ = rZ(optString2);
        final g.a aVar = new g.a(optParamsAsJo);
        final Bundle bundle = new Bundle();
        bundle.putInt("key_login_mode", rZ);
        bVar.Rf().a((Activity) context, "mapp_i_login", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.tieba.aiapps.apps.a.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: b */
            public void B(Boolean bool) {
                if (bool.booleanValue()) {
                    if (c.this.aw(context, optString2)) {
                        c.this.a(bVar, (Activity) context, aVar, callbackHandler, optString, bundle);
                        return;
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10008, com.baidu.swan.apps.setting.oauth.c.getErrMessage(10008)).toString());
                    return;
                }
                com.baidu.swan.apps.console.c.i("ThirdPartyLoginAction", "request authorize denied");
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(401, "request authorize denied").toString());
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ae.b bVar, Activity activity, final g.a aVar, final CallbackHandler callbackHandler, final String str, Bundle bundle) {
        bVar.Rf().a(activity, aVar, bundle, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<e.c>>() { // from class: com.baidu.tieba.aiapps.apps.a.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: a */
            public void B(com.baidu.swan.apps.setting.oauth.g<e.c> gVar) {
                if (!gVar.isOk()) {
                    com.baidu.swan.apps.console.c.w("ThirdPartyLoginAction", gVar.getErrorCode() + HanziToPinyin.Token.SEPARATOR + aVar.toString());
                    String errMessage = com.baidu.swan.apps.setting.oauth.c.getErrMessage(gVar.getErrorCode());
                    if (!TextUtils.isEmpty(errMessage)) {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode(), errMessage).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode()).toString());
                    }
                } else if (TextUtils.isEmpty(gVar.mData.code)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("code", gVar.mData.code);
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, gVar.getErrorCode()).toString());
                    } catch (JSONException e) {
                        if (c.DEBUG) {
                            e.printStackTrace();
                        }
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                    }
                }
            }
        });
    }

    private int rZ(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -791575966:
                if (str.equals(LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND)) {
                    c = 2;
                    break;
                }
                break;
            case -265713450:
                if (str.equals("username")) {
                    c = 0;
                    break;
                }
                break;
            case 3616:
                if (str.equals(LogConfig.LIVE_SHARE_HK_QQ_FRIEND)) {
                    c = 3;
                    break;
                }
                break;
            case 114009:
                if (str.equals("sms")) {
                    c = 1;
                    break;
                }
                break;
            case 113011944:
                if (str.equals(LogConfig.LIVE_SHARE_HK_WEIBO)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aw(Context context, String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -791575966:
                if (str.equals(LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND)) {
                    c = 0;
                    break;
                }
                break;
            case -265713450:
                if (str.equals("username")) {
                    c = 4;
                    break;
                }
                break;
            case 3616:
                if (str.equals(LogConfig.LIVE_SHARE_HK_QQ_FRIEND)) {
                    c = 1;
                    break;
                }
                break;
            case 114009:
                if (str.equals("sms")) {
                    c = 3;
                    break;
                }
                break;
            case 113011944:
                if (str.equals(LogConfig.LIVE_SHARE_HK_WEIBO)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return ac.isAppInstalled(context, "com.tencent.mm");
            case 1:
                return ac.isAppInstalled(context, "com.tencent.mobileqq");
            case 2:
                return ac.isAppInstalled(context, "com.sina.weibo");
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }
}
