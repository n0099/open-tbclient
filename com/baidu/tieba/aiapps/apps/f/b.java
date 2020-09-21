package com.baidu.tieba.aiapps.apps.f;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.t.b.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class b implements f {
    private static BroadcastReceiver broadcastReceiver = null;

    @Override // com.baidu.swan.apps.t.b.f
    public void e(Activity activity, String str, final com.baidu.l.a.a aVar) {
        DelegateUtils.callOnMainWithActivity(com.baidu.swan.apps.v.f.asJ().ast(), MainProcessDelegateActivity.class, com.baidu.tieba.aiapps.apps.f.b.a.class, com.baidu.tieba.aiapps.apps.f.b.a.Ew(str), new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.f.b.1
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(DelegateResult delegateResult) {
                aVar.onPayResult(delegateResult.mResult.getInt("status_code"), delegateResult.mResult.getString("params"));
            }
        });
    }

    @Override // com.baidu.swan.apps.t.b.f
    public void f(Activity activity, String str, final com.baidu.l.a.a aVar) {
        if (!com.baidu.tbadk.pay.c.bvh().isWalletOk()) {
            l.showToast(TbadkCoreApplication.getInst(), R.string.plugin_pay_wallet_not_found);
            return;
        }
        e aAr = e.aAr();
        if (aAr != null && aAr.getActivity() != null) {
            a aVar2 = new a();
            aVar2.mParams.putInt("type", 2);
            aVar2.mParams.putString("orderInfo", str);
            aVar2.aj(aAr.getActivity());
            aVar2.a(new com.baidu.tieba.aiapps.apps.f.a.a() { // from class: com.baidu.tieba.aiapps.apps.f.b.2
                @Override // com.baidu.tieba.aiapps.apps.f.a.a
                public void ah(Bundle bundle) {
                    if (aVar != null) {
                        aVar.onPayResult(bundle.getInt("result_code"), bundle.getString(AbstractThirdPartyService.EXTRA_RESULT_MSG));
                    }
                }
            });
            aVar2.onExec();
        }
    }

    @Override // com.baidu.swan.apps.t.b.f
    public void b(Context context, JSONObject jSONObject, final com.baidu.l.a.a aVar) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
        PayReq dg = dg(jSONObject);
        createWXAPI.registerApp(dg.appId);
        if (!createWXAPI.isWXAppInstalled()) {
            aVar.onPayResult(3, "wx_not_installed");
            d.a(context, "您没有安装微信，请选择其他支付方式").showToast();
        } else if (e.aAr() != null) {
            if (!createWXAPI.sendReq(dg)) {
                aVar.onPayResult(6, "wx_start_failed");
            }
            if (broadcastReceiver != null) {
                TbadkCoreApplication.getInst().unregisterReceiver(broadcastReceiver);
            }
            broadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.tieba.aiapps.apps.f.b.3
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    intent.getExtras();
                    aVar.onPayResult(intent.getExtras().getInt(TiebaInitialize.LogFields.ERROR_CODE, -1), intent.getExtras().getString(TiebaInitialize.LogFields.ERROR_MESSAGE));
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("WXPayResult");
            TbadkCoreApplication.getInst().registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    private PayReq dg(JSONObject jSONObject) {
        PayReq payReq = new PayReq();
        payReq.appId = jSONObject.optString("appid");
        payReq.partnerId = jSONObject.optString("partnerid");
        payReq.prepayId = jSONObject.optString("prepayid");
        payReq.packageValue = jSONObject.optString("packagealias");
        payReq.nonceStr = jSONObject.optString("noncestr");
        payReq.timeStamp = jSONObject.optString("timestamp");
        payReq.sign = jSONObject.optString("sign");
        return payReq;
    }

    @Override // com.baidu.swan.apps.t.b.f
    public boolean aK(Context context) {
        if (WXAPIFactory.createWXAPI(context, null).isWXAppInstalled()) {
            return true;
        }
        d.a(context, "您没有安装微信，请选择其他支付方式").showToast();
        return false;
    }
}
