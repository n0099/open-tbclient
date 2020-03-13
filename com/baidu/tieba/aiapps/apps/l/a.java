package com.baidu.tieba.aiapps.apps.l;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.y.f;
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
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/navigateToProgram");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            String acH = e.acH();
            if (TextUtils.isEmpty(acH) || TextUtils.isEmpty(acH.trim())) {
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
                com.baidu.tieba.aiapps.apps.m.e.aQ(context, unitedSchemeEntity.getParam("params"));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            Request g = g(acH, optParamsAsJo);
            if (g == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.acR().a(g, new Callback() { // from class: com.baidu.tieba.aiapps.apps.l.a.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    try {
                        JSONObject jSONObject = new JSONObject(response.body().string());
                        if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                        } else {
                            JSONObject optJSONObject = jSONObject.optJSONObject("data");
                            if (optJSONObject != null) {
                                Uri lu = a.this.lu(optJSONObject.optString(SuspensionBallEntity.KEY_SCHEME));
                                if (lu == null) {
                                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                                } else {
                                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(SchemeRouter.invokeScheme(context, lu, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) ? 0 : 1001).toString());
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

    private Request g(String str, JSONObject jSONObject) {
        Request request = null;
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_key", str);
                jSONObject2.put("srcAppPage", bbf());
                jSONObject2.put("params", jSONObject);
                request = new Request.Builder().url("https://spapi.baidu.com/ma/navigate").post(FormBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
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
    public Uri lu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.parse(str);
    }

    private String bbf() {
        com.baidu.swan.apps.core.d.e GC = f.WS().GC();
        if (GC == null || GC.Oo() == null) {
            return "";
        }
        return GC.Oo().Oc().getPage() + "?" + GC.Oo().Oc().getParams();
    }
}
