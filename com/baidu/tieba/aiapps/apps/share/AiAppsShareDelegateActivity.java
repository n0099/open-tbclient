package com.baidu.tieba.aiapps.apps.share;

import android.content.Intent;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
/* loaded from: classes4.dex */
public class AiAppsShareDelegateActivity extends ProcessDelegateBaseActivity {
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null || intent.getExtras() == null) {
            exit();
            return;
        }
        int i3 = intent.getExtras().getInt("extra_share_status", 3);
        if (i3 == 1) {
            this.mDelegation.mResult.putBoolean("share_result", true);
            this.mDelegation.mResult.putString("callBack", this.mDelegation.mParams.getString("successCallback", ""));
            this.mDelegation.mResult.putString(Config.LAUNCH_INFO, "success");
        } else if (i3 == 3) {
            this.mDelegation.mResult.putBoolean("share_result", false);
            this.mDelegation.mResult.putString("callBack", this.mDelegation.mParams.getString("errorCallback", ""));
            this.mDelegation.mResult.putString(Config.LAUNCH_INFO, "user cancel");
        } else if (i3 == 2) {
            this.mDelegation.mResult.putBoolean("share_result", false);
            this.mDelegation.mResult.putString("callBack", this.mDelegation.mParams.getString("errorCallback", ""));
            this.mDelegation.mResult.putString(Config.LAUNCH_INFO, "failed");
        }
        exit();
    }
}
