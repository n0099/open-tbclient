package com.baidu.tieba.aiapps.apps.k;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPolymerPay;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.BaiduPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.WeChatPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.delegation.AliPayDelegation;
import com.baidu.searchbox.ng.ai.apps.pay.delegation.BaiFuBaoPayDelegation;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements IAiAppPolymerPay {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPolymerPay
    public void doBaiFuBaoPay(Context context, String str, final BaiduPayCallback baiduPayCallback) {
        DelegateUtils.callOnMainWithActivity(AiAppsController.getInstance().getActivity(), PluginDelegateActivity.class, BaiFuBaoPayDelegation.class, BaiFuBaoPayDelegation.createExecParams(str), new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.k.b.1
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                baiduPayCallback.onBaiduPayResult(delegateResult.mResult.getInt("status_code"), delegateResult.mResult.getString("params"));
            }
        });
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPolymerPay
    public void doAliPay(Context context, String str, final AliPayCallback aliPayCallback) {
        DelegateUtils.callOnMainWithActivity(AiAppsController.getInstance().getActivity(), PluginDelegateActivity.class, AliPayDelegation.class, AliPayDelegation.createExecParams(str), new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.k.b.2
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                aliPayCallback.onAliPayResult(delegateResult.mResult.getInt("status_code"), delegateResult.mResult.getString("params"));
            }
        });
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPolymerPay
    public void doWeChatPay(Context context, Map<String, String> map, WeChatPayCallback weChatPayCallback) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPolymerPay
    public void doBaiduWalletPolymerPay(Context context, String str, final PolymerPayCallback polymerPayCallback) {
        JSONException e;
        String str2;
        String str3;
        String str4;
        if (!com.baidu.tbadk.pay.c.OY().OZ()) {
            l.showToast(TbadkCoreApplication.getInst(), e.j.plugin_pay_wallet_not_found);
        } else if (context instanceof Activity) {
            d dVar = new d();
            dVar.mParams.putInt("type", 3);
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
                    return;
                }
            } catch (JSONException e3) {
                e = e3;
                str2 = null;
            }
            if (StringUtils.isNull(str3) && !StringUtils.isNull(str4)) {
                dVar.mParams.putSerializable("params", (HashMap) new com.google.gson.d().fromJson(str3, HashMap.class));
                dVar.mParams.putString("orderInfo", str4);
                dVar.F((Activity) context);
                dVar.a(new com.baidu.tieba.aiapps.apps.k.a.a() { // from class: com.baidu.tieba.aiapps.apps.k.b.3
                    @Override // com.baidu.tieba.aiapps.apps.k.a.a
                    public void o(Bundle bundle) {
                        if (polymerPayCallback != null) {
                            polymerPayCallback.onPolymerPayResult(bundle.getInt("result_code"), bundle.getString("result_msg"));
                        }
                    }
                });
                dVar.onExec();
            }
        }
    }
}
