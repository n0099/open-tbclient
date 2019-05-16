package com.baidu.tieba.aiapps.apps.m;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.aa.a.d;
import com.baidu.swan.apps.u.b.q;
import com.baidu.swan.apps.w.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.Map;
/* loaded from: classes4.dex */
public class b implements q {
    private static final String TAG = b.class.getSimpleName();

    @Override // com.baidu.swan.apps.u.b.q
    public void a(com.baidu.swan.apps.ae.b bVar, String str, final com.baidu.swan.apps.aa.a.b bVar2) {
        Log.d(TAG, "baiduPay start");
        DelegateUtils.callOnMainWithActivity(e.FV().FH(), MainProcessDelegateActivity.class, com.baidu.tieba.aiapps.apps.m.b.a.class, com.baidu.tieba.aiapps.apps.m.b.a.sT(str), new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.m.b.1
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(DelegateResult delegateResult) {
                int i = delegateResult.mResult.getInt("status_code");
                String string = delegateResult.mResult.getString("params");
                Log.d(b.TAG, "baiduPay result: " + i + " params: " + string);
                bVar2.j(i, string);
            }
        });
    }

    @Override // com.baidu.swan.apps.u.b.q
    public void a(com.baidu.swan.apps.ae.b bVar, String str, final com.baidu.swan.apps.aa.a.a aVar) {
        Log.d(TAG, "alipay start");
        if (!com.baidu.tbadk.pay.c.atX().atY()) {
            l.showToast(TbadkCoreApplication.getInst(), (int) R.string.plugin_pay_wallet_not_found);
        } else if (bVar.getActivity() instanceof Activity) {
            a aVar2 = new a();
            aVar2.mParams.putInt("type", 2);
            aVar2.mParams.putString("orderInfo", str);
            aVar2.af(bVar.getActivity());
            aVar2.a(new com.baidu.tieba.aiapps.apps.m.a.a() { // from class: com.baidu.tieba.aiapps.apps.m.b.2
                @Override // com.baidu.tieba.aiapps.apps.m.a.a
                public void I(Bundle bundle) {
                    if (aVar != null) {
                        aVar.i(bundle.getInt("result_code"), bundle.getString("result_msg"));
                    }
                }
            });
            aVar2.onExec();
        }
    }

    @Override // com.baidu.swan.apps.u.b.q
    public void a(Context context, Map<String, String> map, d dVar) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, null);
        PayReq s = s(map);
        createWXAPI.registerApp(s.appId);
        if (!createWXAPI.isWXAppInstalled()) {
            dVar.k(3, "wx_not_installed");
            com.baidu.swan.apps.res.widget.b.d.a(context, "您没有安装微信，请选择其他支付方式").Ld();
        } else if (com.baidu.swan.apps.ae.b.Lq() != null) {
            boolean sendReq = createWXAPI.sendReq(s);
            com.baidu.swan.apps.aa.d.Hz().aFl = dVar;
            if (!sendReq) {
                dVar.k(6, "wx_start_failed");
            }
        }
    }

    private PayReq s(Map<String, String> map) {
        PayReq payReq = new PayReq();
        payReq.appId = map.get("appid");
        payReq.partnerId = map.get("partnerid");
        payReq.prepayId = map.get("prepayid");
        payReq.packageValue = map.get("packagealias");
        payReq.nonceStr = map.get("noncestr");
        payReq.timeStamp = map.get("timestamp");
        payReq.sign = map.get("sign");
        return payReq;
    }

    @Override // com.baidu.swan.apps.u.b.q
    public boolean bf(Context context) {
        if (WXAPIFactory.createWXAPI(context, null).isWXAppInstalled()) {
            return true;
        }
        com.baidu.swan.apps.res.widget.b.d.a(context, "您没有安装微信，请选择其他支付方式").Ld();
        return false;
    }
}
