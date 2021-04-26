package com.baidu.tieba.aiapps.apps.barcode;

import android.content.Intent;
import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
/* loaded from: classes4.dex */
public class ScanCodeDelegateActivity extends ProcessDelegateBaseActivity {
    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (intent != null && intent.getExtras() != null) {
            this.mDelegation.mResult.putString(QRCodeScanActivityConfig.RESULT_SCAN_CODE, intent.getExtras().getString(QRCodeScanActivityConfig.RESULT_SCAN_CODE, ""));
            exit();
            return;
        }
        exit();
    }
}
