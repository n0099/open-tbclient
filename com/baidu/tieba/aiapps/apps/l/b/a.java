package com.baidu.tieba.aiapps.apps.l.b;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.pay.c;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation {
    private static final boolean DEBUG = b.DEBUG;

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (this.mParams.isEmpty()) {
            if (DEBUG) {
                Log.d("BaiFuBaoPayDelegation", "onExec params is null.");
            }
        } else {
            if (DEBUG) {
                Log.d("BaiFuBaoPayDelegation", "PAYMENT onExec");
            }
            Log.d("BaiFuBaoPayDelegation", "PAYMENT onExec");
            if (!c.avi().avj()) {
                l.showToast(TbadkCoreApplication.getInst(), (int) R.string.plugin_pay_wallet_not_found);
            } else if (getAgent() instanceof Activity) {
                com.baidu.tieba.aiapps.apps.l.a aVar = new com.baidu.tieba.aiapps.apps.l.a();
                aVar.mParams.putInt("type", 1);
                aVar.mParams.putString("orderInfo", this.mParams.getString("order_info"));
                aVar.ai(getAgent());
                aVar.a(new com.baidu.tieba.aiapps.apps.l.a.a() { // from class: com.baidu.tieba.aiapps.apps.l.b.a.1
                    @Override // com.baidu.tieba.aiapps.apps.l.a.a
                    public void I(Bundle bundle) {
                        a.this.mResult.putInt("status_code", bundle.getInt("result_code"));
                        a.this.mResult.putString("params", bundle.getString("result_msg"));
                        a.this.finish();
                    }
                });
                aVar.onExec();
            }
        }
        return false;
    }

    public static Bundle to(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("order_info", str);
        return bundle;
    }
}
