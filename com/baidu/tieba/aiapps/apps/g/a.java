package com.baidu.tieba.aiapps.apps.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.model.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidubce.AbstractBceClient;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/navigateToProgram");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            String aJW = e.aJW();
            if (TextUtils.isEmpty(aJW) || TextUtils.isEmpty(aJW.trim())) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString2 = optParamsAsJo.optString("path");
            if (!StringUtils.isNull(optString2) && optString2.contains("/pages/frshistory/frshistory?")) {
                com.baidu.tieba.aiapps.apps.h.e.aK(context, unitedSchemeEntity.getParam("params"));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            Request j = j(aJW, optParamsAsJo);
            if (j == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            a(j.body(), unitedSchemeEntity, optString, callbackHandler, eVar);
            return true;
        }
    }

    private void a(RequestBody requestBody, UnitedSchemeEntity unitedSchemeEntity, final String str, final CallbackHandler callbackHandler, final e eVar) {
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(com.baidu.swan.apps.t.a.azm().akF(), requestBody, new ResponseCallback() { // from class: com.baidu.tieba.aiapps.apps.g.a.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                a.this.a(response, str, callbackHandler, eVar);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        });
        aVar.emE = true;
        aVar.emF = false;
        aVar.emG = true;
        com.baidu.swan.a.c.a.bdi().b(aVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response, String str, CallbackHandler callbackHandler, e eVar) {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (!TextUtils.equals(jSONObject.optString(BaseJsonData.TAG_ERRNO), "0")) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                } else {
                    Uri tl = tl(optJSONObject.optString("scheme"));
                    if (tl == null) {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(SchemeRouter.invokeScheme(eVar.getApplicationContext(), tl, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) ? 0 : 1001).toString());
                    }
                }
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("NavigateToSmartProgram", e.getMessage());
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
        }
    }

    private Request j(String str, JSONObject jSONObject) {
        Request request = null;
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            String d = b.d(ak.aPA());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_key", str);
                jSONObject2.put("srcAppPage", d);
                jSONObject2.put("params", jSONObject);
                String akF = com.baidu.swan.apps.t.a.azm().akF();
                request = new Request.Builder().url(akF).post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
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

    private Uri tl(String str) {
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
