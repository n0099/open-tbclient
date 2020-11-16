package com.baidu.tieba.aiapps.apps.barcode;

import android.content.Intent;
import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
/* loaded from: classes24.dex */
public class ScanCodeDelegateActivity extends ProcessDelegateBaseActivity {
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null || intent.getExtras() == null) {
            exit();
            return;
        }
        this.mDelegation.mResult.putString(QRCodeScanActivityConfig.RESULT_SCAN_CODE, intent.getExtras().getString(QRCodeScanActivityConfig.RESULT_SCAN_CODE, ""));
        exit();
    }
}
