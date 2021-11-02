package com.baidu.tieba;

import android.os.Bundle;
import b.a.q0.q0.l;
import b.a.r0.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tieba.base.LogoBaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class NewLogoActivity extends LogoBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean firstLoad = true;
    public transient /* synthetic */ FieldHolder $fh;
    public i delegate;
    public long logoCreateTime;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1070153167, "Lcom/baidu/tieba/NewLogoActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1070153167, "Lcom/baidu/tieba/NewLogoActivity;");
        }
    }

    public NewLogoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.logoCreateTime = -1L;
    }

    @Override // com.baidu.tieba.base.LogoBaseActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_CREATE_START_STAMP_KEY);
            this.logoCreateTime = System.currentTimeMillis();
            super.onCreate(bundle);
            i iVar = new i(this);
            this.delegate = iVar;
            iVar.f(firstLoad);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_CREATE_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.tieba.base.LogoBaseActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            firstLoad = false;
            this.delegate.d();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            if (!LogoActivityConfig.isFirst || this.logoCreateTime < 0) {
                return;
            }
            l.b().w(System.currentTimeMillis() - this.logoCreateTime);
        }
    }
}
