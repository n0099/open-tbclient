package com.baidu.tieba.aiapps.apps.barcode;

import android.content.Intent;
import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ScanCodeDelegateActivity extends ProcessDelegateBaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ScanCodeDelegateActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (intent != null && intent.getExtras() != null) {
                this.mDelegation.mResult.putString(QRCodeScanActivityConfig.RESULT_SCAN_CODE, intent.getExtras().getString(QRCodeScanActivityConfig.RESULT_SCAN_CODE, ""));
                exit();
                return;
            }
            exit();
        }
    }
}
