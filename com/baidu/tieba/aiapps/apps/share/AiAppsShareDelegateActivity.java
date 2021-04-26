package com.baidu.tieba.aiapps.apps.share;

import android.content.Intent;
import com.alipay.sdk.util.e;
import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
/* loaded from: classes4.dex */
public class AiAppsShareDelegateActivity extends ProcessDelegateBaseActivity {
    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (intent != null && intent.getExtras() != null) {
            int i4 = intent.getExtras().getInt("extra_share_status", 3);
            if (i4 == 1) {
                this.mDelegation.mResult.putBoolean("share_result", true);
                this.mDelegation.mResult.putString("callBack", this.mDelegation.mParams.getString("successCallback", ""));
                this.mDelegation.mResult.putString("info", "success");
            } else if (i4 == 3) {
                this.mDelegation.mResult.putBoolean("share_result", false);
                this.mDelegation.mResult.putString("callBack", this.mDelegation.mParams.getString("errorCallback", ""));
                this.mDelegation.mResult.putString("info", "user cancel");
            } else if (i4 == 2) {
                this.mDelegation.mResult.putBoolean("share_result", false);
                this.mDelegation.mResult.putString("callBack", this.mDelegation.mParams.getString("errorCallback", ""));
                this.mDelegation.mResult.putString("info", e.f1950a);
            }
            exit();
            return;
        }
        exit();
    }
}
