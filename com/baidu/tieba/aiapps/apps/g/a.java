package com.baidu.tieba.aiapps.apps.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.model.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidubce.AbstractBceClient;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/navigateToProgram");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            String aoH = e.aoH();
            if (TextUtils.isEmpty(aoH) || TextUtils.isEmpty(aoH.trim())) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString2 = optParamsAsJo.optString("path");
            if (!StringUtils.isNull(optString2) && optString2.contains("/pages/frshistory/frshistory?")) {
                com.baidu.tieba.aiapps.apps.h.e.az(context, unitedSchemeEntity.getParam("params"));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            Request h = h(aoH, optParamsAsJo);
            if (h == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.aoT().a(h, new Callback() { // from class: com.baidu.tieba.aiapps.apps.g.a.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    try {
                        JSONObject jSONObject = new JSONObject(response.body().string());
                        if (!TextUtils.equals(jSONObject.optString(BaseJsonData.TAG_ERRNO), "0")) {
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                        } else {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                Uri og = a.this.og(optJSONObject.optString(SuspensionBallEntity.KEY_SCHEME));
                                if (og == null) {
                                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                                } else {
                                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(SchemeRouter.invokeScheme(context, og, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) ? 0 : 1001).toString());
                                }
                            } else {
                                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                            }
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            Log.d("NavigateToSmartProgram", e.getMessage());
                        }
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                    }
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    private Request h(String str, JSONObject jSONObject) {
        Request request = null;
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            String d = b.d(aj.atU());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_key", str);
                jSONObject2.put("srcAppPage", d);
                jSONObject2.put("params", jSONObject);
                String SL = com.baidu.swan.apps.u.a.afd().SL();
                request = new Request.Builder().url(SL).post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
                if (DEBUG) {
                    Log.i("NavigateToSmartProgram", "appId :" + str + "\nrequest params" + jSONObject2.toString());
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri og(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        String schemeHead = SchemeConfig.getSchemeHead();
        if (TextUtils.isEmpty(schemeHead)) {
            schemeHead = "baiduboxapp";
        }
        buildUpon.scheme(schemeHead);
        if (DEBUG) {
            Log.i("NavigateToSmartProgram", buildUpon.build().toString());
        }
        return buildUpon.build();
    }
}
