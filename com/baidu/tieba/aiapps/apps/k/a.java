package com.baidu.tieba.aiapps.apps.k;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc;
import com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.BaiduPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.RequestPolymerPaymentAction;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements IAiAppPaymentIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public void baiduPay(Context context, String str, BaiduPayCallback baiduPayCallback) {
        c.cl(context).a(context, str, baiduPayCallback);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public void aliPay(Context context, String str, AliPayCallback aliPayCallback) {
        c.cl(context).doAliPay(context, str, aliPayCallback);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public boolean polymerPay(Context context, String str, Activity activity, String[] strArr, PolymerPayCallback polymerPayCallback) {
        c.cl(context).a(activity, str, strArr, polymerPayCallback);
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public boolean removeWalletUI() {
        com.baidu.poly.a YU = c.YU();
        return YU != null && YU.finish();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public void doPolymerPayBySwan(Context context, JSONObject jSONObject, RequestPolymerPaymentAction.OnWalletPayBack onWalletPayBack) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public boolean isWxAppInstalledAndSupported(Context context) {
        return c.cl(context).isWxAppInstalledAndSupported(context);
    }
}
