package com.baidu.tieba.aiapps.apps.n;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.aiapps.apps.o.e;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends z {
    public b(j jVar) {
        super(jVar, "/swan/navigateToProgram");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (aq.bV(optParamsAsJo.optString("appKey"), "flFqXclepWs7RdugAszy9eERL7G5dS0I") && optParamsAsJo.optJSONObject("extraData") != null && aq.bV(optParamsAsJo.optJSONObject("extraData").optString("from"), "阿婆娱乐")) {
            e.aB(context, unitedSchemeEntity.getParam("params"));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        if (DEBUG) {
            Log.d("NavigateToSmartProgram", "paramsJson: " + optParamsAsJo);
        }
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final String Ms = com.baidu.swan.apps.ae.b.Ms();
        final String optString = optParamsAsJo.optString("appKey");
        final String optString2 = optParamsAsJo.optString("path");
        final String optString3 = optParamsAsJo.optString("from");
        final String optString4 = optParamsAsJo.optString("extraData");
        if (TextUtils.isEmpty(Ms.trim()) || TextUtils.isEmpty(optString.trim())) {
            c.i("NavigateToSmartProgram", "mAppId or appId is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        if (DEBUG) {
            Log.d("NavigateToSmartProgram", "mAppId: " + Ms);
            Log.d("NavigateToSmartProgram", "appId: " + optString);
        }
        final String optString5 = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString5)) {
            c.i("NavigateToSmartProgram", "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", Ms);
            jSONObject.put("navigate_to_ma_id", optString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        final boolean[] zArr = new boolean[1];
        bVar.Mn().a(new Request.Builder().url("http://mbd.baidu.com/ma/game/rest/navigate_to_program").post(FormBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString())).build(), new Callback() { // from class: com.baidu.tieba.aiapps.apps.n.b.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callbackHandler.handleSchemeDispatchCallback(optString5, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    JSONObject jSONObject2 = new JSONObject(response.body().string());
                    if (b.DEBUG) {
                        Log.d("NavigateToSmartProgram", "response data:" + jSONObject2.toString());
                    }
                    String optString6 = jSONObject2.optString("errno");
                    if (!optString6.equals("0")) {
                        if (b.DEBUG) {
                            Log.d("NavigateToSmartProgram", "Response.errno:" + optString6);
                        }
                        callbackHandler.handleSchemeDispatchCallback(optString5, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                        return;
                    }
                    String optString7 = jSONObject2.optString("data");
                    if (optString7.equals("")) {
                        if (b.DEBUG) {
                            Log.d("NavigateToSmartProgram", "data is null");
                        }
                        callbackHandler.handleSchemeDispatchCallback(optString5, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                        return;
                    }
                    JSONObject jSONObject3 = new JSONObject(optString7);
                    String string = jSONObject3.getString("is_swangame");
                    if (string.equals("1")) {
                        zArr[0] = true;
                    } else if (string.equals("0")) {
                        zArr[0] = false;
                    }
                    if (b.DEBUG) {
                        Log.d("NavigateToSmartProgram", "is_swangame:" + string);
                    }
                    if (jSONObject3.optString("navigate_ok", "0").equals("0")) {
                        if (b.DEBUG) {
                            Log.d("NavigateToSmartProgram", "navigateOk is false");
                        }
                        callbackHandler.handleSchemeDispatchCallback(optString5, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                        return;
                    }
                    Uri a = b.this.a(zArr[0], optString, optString2, "", optString3, optString4, Ms);
                    if (a != null) {
                        if (b.DEBUG) {
                            Log.d("NavigateToSmartProgram", "uri:" + a.toString());
                        }
                        if (SchemeRouter.invokeScheme(context, a, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                            if (b.DEBUG) {
                                Log.d("NavigateToSmartProgram", "success");
                            }
                            callbackHandler.handleSchemeDispatchCallback(optString5, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                            return;
                        }
                        callbackHandler.handleSchemeDispatchCallback(optString5, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                        if (b.DEBUG) {
                            Log.d("NavigateToSmartProgram", SmsLoginView.StatEvent.LOGIN_FAILURE);
                            return;
                        }
                        return;
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString5, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                } catch (Exception e2) {
                    if (b.DEBUG) {
                        Log.d("NavigateToSmartProgram", e2.getStackTrace().toString());
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString5, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri a(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str5)) {
            str5 = "{}";
        }
        int i = z ? 1 : 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", str4);
            jSONObject.put("ext", "{}");
            jSONObject.put("extraData", str5);
            jSONObject.put("srcAppId", str6);
            jSONObject.put("srcAppPage", MV());
        } catch (JSONException e) {
            if (DEBUG) {
                throw new RuntimeException(e);
            }
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            jSONObject2 = "";
        }
        return com.baidu.swan.apps.v.d.a.b(i, str, str2, jSONObject2);
    }

    private String MV() {
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN == null || vN.Aw() == null) {
            return "";
        }
        return vN.Aw().Aj() + "?" + vN.Aw().Ak();
    }
}
