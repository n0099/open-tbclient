package com.baidu.tieba.aiapps.apps.share;

import android.content.Intent;
import com.alipay.sdk.util.e;
import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AiAppsShareDelegateActivity extends ProcessDelegateBaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AiAppsShareDelegateActivity() {
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
                    this.mDelegation.mResult.putString("info", e.f2000a);
                }
                exit();
                return;
            }
            exit();
        }
    }
}
