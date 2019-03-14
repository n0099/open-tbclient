package com.baidu.tieba.aiapps.apps.k;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.poly.a;
import com.baidu.poly.bean.PayChannel;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.constant.WBConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class d {
    private static com.baidu.poly.a cWa = null;
    private static volatile d cWb;
    private Context mContext;

    public static synchronized d dI(Context context) {
        d dVar;
        synchronized (d.class) {
            if (cWb == null) {
                synchronized (d.class) {
                    if (cWb == null) {
                        cWb = new d(context.getApplicationContext());
                    }
                }
            }
            dVar = cWb;
        }
        return dVar;
    }

    private d(Context context) {
        this.mContext = context;
    }

    public void a(Context context, String str, final com.baidu.swan.apps.aa.a.b bVar) {
        if (!com.baidu.tbadk.pay.c.aoW().aoX()) {
            l.showToast(TbadkCoreApplication.getInst(), d.j.plugin_pay_wallet_not_found);
        } else if (context instanceof Activity) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            bundle.putString("orderInfo", str);
            DelegateUtils.callOnMainWithActivity((Activity) context, PluginDelegateActivity.class, a.class, bundle, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.k.d.1
                @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                    if (bVar != null) {
                        bVar.m(delegateResult.mResult.getInt("result_code"), delegateResult.mResult.getString("result_msg"));
                    }
                }
            });
        }
    }

    public void a(Context context, String str, final com.baidu.swan.apps.aa.a.a aVar) {
        if (!com.baidu.tbadk.pay.c.aoW().aoX()) {
            l.showToast(TbadkCoreApplication.getInst(), d.j.plugin_pay_wallet_not_found);
        } else if (context instanceof Activity) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 2);
            bundle.putString("orderInfo", str);
            DelegateUtils.callOnMainWithActivity((Activity) context, PluginDelegateActivity.class, a.class, bundle, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.k.d.2
                @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                    if (aVar != null) {
                        aVar.n(delegateResult.mResult.getInt("result_code"), delegateResult.mResult.getString("result_msg"));
                    }
                }
            });
        }
    }

    public void a(com.baidu.swan.apps.ae.b bVar, String str, String[] strArr, final com.baidu.swan.apps.aa.a.c cVar) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            Bundle bundle = new Bundle();
            String bJ = com.baidu.swan.apps.u.a.CD().bJ(com.baidu.swan.apps.u.a.Cy());
            if (com.baidu.swan.apps.u.a.CD().bH(com.baidu.swan.apps.u.a.Cy())) {
                bundle.putString("bduss", com.baidu.swan.apps.u.a.CD().bI(com.baidu.swan.apps.u.a.Cy()));
            }
            bundle.putString("cuid", bJ);
            bundle.putString(WBConstants.SSO_APP_KEY, jSONObject2.optString(WBConstants.SSO_APP_KEY));
            bundle.putString("dealId", jSONObject2.optString("dealId"));
            bundle.putString("dealTitle", jSONObject2.optString("dealTitle"));
            bundle.putString("rsaSign", jSONObject2.optString("rsaSign"));
            bundle.putString("totalAmount", jSONObject2.optString("totalAmount"));
            bundle.putString("tpOrderId", jSONObject2.optString("tpOrderId"));
            String optString = jSONObject2.optString("bizInfo");
            if (TextUtils.isEmpty(optString)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(optString);
            }
            if (bVar.uB() != null) {
                jSONObject.put("swanFrom", bVar.uB().axG);
            }
            jSONObject.put("cuid", bJ);
            jSONObject.put("appId", com.baidu.swan.apps.ae.b.Ji());
            bundle.putString("bizInfo", jSONObject2.optString("bizInfo"));
            bundle.putString("platformId", "100003");
            bundle.putString("nativeAppId", "tieba");
            if (!TextUtils.isEmpty(jSONObject2.optString(Headers.LOCATION))) {
                bundle.putString(Headers.LOCATION, jSONObject2.optString(Headers.LOCATION));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString(ISapiAccount.SAPI_ACCOUNT_PHONE))) {
                bundle.putString(ISapiAccount.SAPI_ACCOUNT_PHONE, jSONObject2.optString(ISapiAccount.SAPI_ACCOUNT_PHONE));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("userId"))) {
                bundle.putString("userId", jSONObject2.optString("userId"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("isSplit"))) {
                bundle.putString("isSplit", jSONObject2.optString("isSplit"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("goodsInfo"))) {
                bundle.putString("goodsInfo", jSONObject2.optString("goodsInfo"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("signFieldsRange"))) {
                bundle.putString("signFieldsRange", jSONObject2.optString("signFieldsRange"));
            }
            if (strArr != null) {
                String[] strArr2 = new String[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    String str2 = strArr[i];
                    char c = 65535;
                    switch (str2.hashCode()) {
                        case -1708856474:
                            if (str2.equals("WeChat")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1865715419:
                            if (str2.equals("BDWallet")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1963873898:
                            if (str2.equals("Alipay")) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            strArr2[i] = PayChannel.ALIPAY;
                            break;
                        case 1:
                            strArr2[i] = PayChannel.WECHAT;
                            break;
                        case 2:
                            strArr2[i] = PayChannel.BAIFUBAO;
                            break;
                    }
                }
                bundle.putStringArray("blockedPayChannels", strArr2);
            }
            ad(bVar.getActivity()).a(bundle, new a.c() { // from class: com.baidu.tieba.aiapps.apps.k.d.3
                @Override // com.baidu.poly.a.c
                public void onResult(int i2, String str3) {
                    if (i2 == 0) {
                        try {
                            if (TextUtils.isEmpty(str3)) {
                                cVar.h(6, str3);
                            } else {
                                cVar.h(new JSONObject(str3).optInt("statusCode"), str3);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            cVar.h(6, str3);
                        }
                    }
                }

                @Override // com.baidu.poly.a.c
                public void onFail(String str3) {
                }

                @Override // com.baidu.poly.a.c
                public void onCancel(String str3) {
                    cVar.h(2, str3);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static com.baidu.poly.a ad(Activity activity) {
        if (cWa != null) {
            return cWa;
        }
        cWa = new a.C0078a().a(new com.baidu.poly.d.b.a(activity)).bE(a.b.agl).bf(activity);
        return cWa;
    }

    public static com.baidu.poly.a azM() {
        return cWa;
    }

    public boolean bK(Context context) {
        return true;
    }
}
