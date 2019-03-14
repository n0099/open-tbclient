package com.baidu.tieba.aiapps.apps.k;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b.b.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.d;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e implements o {
    private static final String TAG = e.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.b.b.o
    public boolean a(final Context context, final String str, final UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, final CallbackHandler callbackHandler, final String str2) {
        final com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        JSONArray optJSONArray = jSONObject.optJSONArray("bannedChannels");
        final String[] strArr = null;
        if (optJSONArray != null) {
            strArr = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                strArr[i] = String.valueOf(optJSONArray.opt(i));
            }
        }
        if (IX == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (IX.getActivity() == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (TextUtils.isEmpty(str)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            if (IX.Jj()) {
                IX.Jc().a(IX.getActivity(), null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.tieba.aiapps.apps.k.e.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i2) {
                        if (i2 == 0) {
                            e.this.a(context, str, unitedSchemeEntity, IX, callbackHandler, strArr, str2);
                        } else {
                            e.this.a(callbackHandler, 5, (String) null, unitedSchemeEntity, (String) null, str2);
                        }
                    }
                });
            } else {
                a(context, str, unitedSchemeEntity, IX, callbackHandler, strArr, str2);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, final UnitedSchemeEntity unitedSchemeEntity, final com.baidu.swan.apps.ae.b bVar, final CallbackHandler callbackHandler, String[] strArr, final String str2) {
        d.dI(context).a(bVar, str, strArr, new com.baidu.swan.apps.aa.a.c() { // from class: com.baidu.tieba.aiapps.apps.k.e.2
            @Override // com.baidu.swan.apps.aa.a.c
            public void h(int i, String str3) {
                if (e.DEBUG) {
                    Log.d(e.TAG, "onPolymerPay result: " + i + " params: " + str3);
                }
                e.this.a(i, "nuomi", str3, bVar);
                e.this.a(callbackHandler, i, str3, unitedSchemeEntity, (String) null, str2);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    @Override // com.baidu.swan.apps.b.b.o
    public boolean vT() {
        com.baidu.poly.a azM = d.azM();
        return azM != null && azM.tu();
    }

    @Override // com.baidu.swan.apps.b.b.o
    public boolean a(Context context, String str, final com.baidu.swan.apps.aa.a.c cVar) {
        JSONException e;
        String str2;
        String str3;
        String str4;
        if (!com.baidu.tbadk.pay.c.aoW().aoX()) {
            l.showToast(TbadkCoreApplication.getInst(), d.j.plugin_pay_wallet_not_found);
            return false;
        } else if (context instanceof Activity) {
            a aVar = new a();
            aVar.mParams.putInt("type", 3);
            try {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString("order_info");
                try {
                    str3 = str2;
                    str4 = jSONObject.optString("req_data");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    str3 = str2;
                    str4 = null;
                    if (StringUtils.isNull(str3)) {
                    }
                    return false;
                }
            } catch (JSONException e3) {
                e = e3;
                str2 = null;
            }
            if (!StringUtils.isNull(str3) || StringUtils.isNull(str4)) {
                return false;
            }
            aVar.mParams.putSerializable(LegoListActivityConfig.PARAMS, (HashMap) new com.google.gson.d().fromJson(str3, HashMap.class));
            aVar.mParams.putString("orderInfo", str4);
            aVar.ac((Activity) context);
            aVar.a(new com.baidu.tieba.aiapps.apps.k.a.a() { // from class: com.baidu.tieba.aiapps.apps.k.e.3
                @Override // com.baidu.tieba.aiapps.apps.k.a.a
                public void H(Bundle bundle) {
                    if (cVar != null) {
                        cVar.h(bundle.getInt("result_code"), bundle.getString("result_msg"));
                    }
                }
            });
            aVar.onExec();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.v.b.b uB = bVar.uB();
        com.baidu.swan.apps.statistic.c.a(i == 0, str, str2, uB != null ? uB.axX : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, int i, String str, UnitedSchemeEntity unitedSchemeEntity, String str2, String str3) {
        String str4;
        com.baidu.swan.apps.console.c.d(TAG, "sendSecondCallback, statusCode: " + i + ", params: " + str);
        String str5 = unitedSchemeEntity.getParams().get(LegoListActivityConfig.PARAMS);
        if (!TextUtils.isEmpty(str5)) {
            try {
                str4 = new JSONObject(str5).optString("cb");
                try {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str)) {
                        String optString = new JSONObject(str).optString("responseData");
                        if (TextUtils.equals(str3, "2.0")) {
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str2)) {
                                jSONObject.put("payId", str2);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject.put("payResult", Base64.encodeToString(optString.getBytes(HTTP.UTF_8), 2));
                            }
                            callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i, cJ(i)).toString());
                            return;
                        }
                        callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParamsWithBase64(optString, i, cJ(i)).toString());
                        return;
                    }
                    callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i, cJ(i)).toString());
                } catch (UnsupportedEncodingException e) {
                    e = e;
                    e.printStackTrace();
                    callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i, cJ(i)).toString());
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i, cJ(i)).toString());
                }
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                str4 = null;
            } catch (JSONException e4) {
                e = e4;
                str4 = null;
            }
        }
    }

    private static String cJ(int i) {
        switch (i) {
            case 0:
                return "支付成功";
            case 1:
            default:
                return "支付失败";
            case 2:
                return "支付取消";
        }
    }
}
