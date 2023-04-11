package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ga2 extends w92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947787121, "Lcom/baidu/tieba/ga2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947787121, "Lcom/baidu/tieba/ga2;");
                return;
            }
        }
        l = eo1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga2(boolean z, boolean z2) {
        super(z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (l) {
            Log.d("PreloadMasterManager", "PreloadMasterManagerSingle created");
        }
    }

    @Override // com.baidu.tieba.w92
    public boolean k(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, pMSAppInfo)) == null) {
            PMSAppInfo g = g();
            if (g == null) {
                return false;
            }
            if (!TextUtils.equals(pMSAppInfo.appId, g.appId)) {
                if (l) {
                    Log.e("PreloadMasterManager", "one master can only prefetch one appId");
                }
                return true;
            } else if (!w(pMSAppInfo, cVar)) {
                return false;
            } else {
                if (l) {
                    Log.w("PreloadMasterManager", "prefetch app is not the same !!!!");
                    Log.w("PreloadMasterManager", "bind app info - " + g());
                    Log.w("PreloadMasterManager", "prefetch app info - " + pMSAppInfo);
                }
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean w(PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo, cVar)) == null) {
            PMSAppInfo g = g();
            if (this.c == null) {
                return false;
            }
            if (pMSAppInfo.versionCode == g.versionCode && TextUtils.equals(pMSAppInfo.appId, g.appId) && !m(cVar, this.d)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
