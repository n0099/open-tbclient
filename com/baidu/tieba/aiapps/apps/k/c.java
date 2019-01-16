package com.baidu.tieba.aiapps.apps.k;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.poly.a;
import com.baidu.poly.bean.PayChannel;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.BaiduPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeWalletDispatcher;
import com.baidu.searchbox.ng.ai.apps.system.sysinfo.util.AiAppsSysInfoUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class c {
    private static com.baidu.poly.a bKu = null;
    private static volatile c bKv;
    private Context mContext;

    public static synchronized c cl(Context context) {
        c cVar;
        synchronized (c.class) {
            if (bKv == null) {
                synchronized (c.class) {
                    if (bKv == null) {
                        bKv = new c(context.getApplicationContext());
                    }
                }
            }
            cVar = bKv;
        }
        return cVar;
    }

    private c(Context context) {
        this.mContext = context;
    }

    public void a(Context context, String str, final BaiduPayCallback baiduPayCallback) {
        if (!com.baidu.tbadk.pay.c.Pq().Pr()) {
            l.showToast(TbadkCoreApplication.getInst(), e.j.plugin_pay_wallet_not_found);
        } else if (context instanceof Activity) {
            d dVar = new d();
            dVar.mParams.putInt("type", 1);
            dVar.mParams.putString("orderInfo", str);
            dVar.G((Activity) context);
            dVar.a(new com.baidu.tieba.aiapps.apps.k.a.a() { // from class: com.baidu.tieba.aiapps.apps.k.c.1
                @Override // com.baidu.tieba.aiapps.apps.k.a.a
                public void o(Bundle bundle) {
                    if (baiduPayCallback != null) {
                        baiduPayCallback.onBaiduPayResult(bundle.getInt("result_code"), bundle.getString("result_msg"));
                    }
                }
            });
            dVar.onExec();
        }
    }

    public void doAliPay(Context context, String str, final AliPayCallback aliPayCallback) {
        if (!com.baidu.tbadk.pay.c.Pq().Pr()) {
            l.showToast(TbadkCoreApplication.getInst(), e.j.plugin_pay_wallet_not_found);
        } else if (context instanceof Activity) {
            d dVar = new d();
            dVar.mParams.putInt("type", 2);
            dVar.mParams.putString("orderInfo", str);
            dVar.G((Activity) context);
            dVar.a(new com.baidu.tieba.aiapps.apps.k.a.a() { // from class: com.baidu.tieba.aiapps.apps.k.c.2
                @Override // com.baidu.tieba.aiapps.apps.k.a.a
                public void o(Bundle bundle) {
                    if (aliPayCallback != null) {
                        aliPayCallback.onAliPayResult(bundle.getInt("result_code"), bundle.getString("result_msg"));
                    }
                }
            });
            dVar.onExec();
        }
    }

    public void a(Activity activity, String str, String[] strArr, final PolymerPayCallback polymerPayCallback) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle = new Bundle();
            String cuid = AiAppsSysInfoUtil.getCUID();
            if (AiAppsRuntime.getAiAppAccountRuntime().isLogin(AiAppsRuntime.getAppContext())) {
                bundle.putString("bduss", AiAppsRuntime.getAiAppAccountRuntime().getBduss(AiAppsRuntime.getAppContext()));
            }
            bundle.putString("cuid", cuid);
            bundle.putString(WBConstants.SSO_APP_KEY, jSONObject.optString(WBConstants.SSO_APP_KEY));
            bundle.putString("dealId", jSONObject.optString("dealId"));
            bundle.putString("dealTitle", jSONObject.optString("dealTitle"));
            bundle.putString("rsaSign", jSONObject.optString("rsaSign"));
            bundle.putString("totalAmount", jSONObject.optString("totalAmount"));
            bundle.putString("tpOrderId", jSONObject.optString("tpOrderId"));
            bundle.putString("bizInfo", jSONObject.optString("bizInfo"));
            bundle.putString(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "100003");
            bundle.putString("nativeAppId", NgWebViewInitHelper.INIT_BWEBKIT_APPID);
            if (!TextUtils.isEmpty(jSONObject.optString(Headers.LOCATION))) {
                bundle.putString(Headers.LOCATION, jSONObject.optString(Headers.LOCATION));
            }
            if (!TextUtils.isEmpty(jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE))) {
                bundle.putString(ISapiAccount.SAPI_ACCOUNT_PHONE, jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PHONE));
            }
            if (!TextUtils.isEmpty(jSONObject.optString("userId"))) {
                bundle.putString("userId", jSONObject.optString("userId"));
            }
            if (!TextUtils.isEmpty(jSONObject.optString("isSplit"))) {
                bundle.putString("isSplit", jSONObject.optString("isSplit"));
            }
            if (!TextUtils.isEmpty(jSONObject.optString("goodsInfo"))) {
                bundle.putString("goodsInfo", jSONObject.optString("goodsInfo"));
            }
            if (!TextUtils.isEmpty(jSONObject.optString("signFieldsRange"))) {
                bundle.putString("signFieldsRange", jSONObject.optString("signFieldsRange"));
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
                            if (str2.equals(AiAppUnitedSchemeWalletDispatcher.MODULE_WALLET)) {
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
            F(activity).a(bundle, new a.c() { // from class: com.baidu.tieba.aiapps.apps.k.c.3
                @Override // com.baidu.poly.a.c
                public void onResult(int i2, String str3) {
                    if (i2 == 0) {
                        try {
                            if (TextUtils.isEmpty(str3)) {
                                polymerPayCallback.onPolymerPayResult(6, str3);
                            } else {
                                polymerPayCallback.onPolymerPayResult(new JSONObject(str3).optInt(BaseRequestAction.PARAMS_STATUSCODE), str3);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            polymerPayCallback.onPolymerPayResult(6, str3);
                        }
                    }
                }

                @Override // com.baidu.poly.a.c
                public void dk(String str3) {
                }

                @Override // com.baidu.poly.a.c
                public void onCancel(String str3) {
                    polymerPayCallback.onPolymerPayResult(2, str3);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static com.baidu.poly.a F(Activity activity) {
        if (bKu != null) {
            return bKu;
        }
        bKu = new a.C0110a().a(new com.baidu.poly.d.b.a(activity)).bK(a.b.ONLINE).bn(activity);
        return bKu;
    }

    public static com.baidu.poly.a Zt() {
        return bKu;
    }

    public boolean isWxAppInstalledAndSupported(Context context) {
        return true;
    }
}
