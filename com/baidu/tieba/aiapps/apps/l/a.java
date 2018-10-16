package com.baidu.tieba.aiapps.apps.l;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc;
import com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.RequestPolymerPaymentAction;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements IAiAppPaymentIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public void doPay(Context context, String str, PayCallback payCallback) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public void doAliPay(Context context, String str, AliPayCallback aliPayCallback) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public void doPolymerPay(Context context, Activity activity, String str, String[] strArr, PolymerPayCallback polymerPayCallback) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public boolean removeWalletUI() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppPaymentIoc
    public void doPolymerPayBySwan(Context context, JSONObject jSONObject, RequestPolymerPaymentAction.OnWalletPayBack onWalletPayBack) {
    }
}
