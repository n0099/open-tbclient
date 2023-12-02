package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ac2 implements bc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final vb2 a;
    public final int b;

    @Override // com.baidu.tieba.bc2
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947610297, "Lcom/baidu/tieba/ac2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947610297, "Lcom/baidu/tieba/ac2;");
                return;
            }
        }
        c = vm1.a;
    }

    public ac2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new xb2();
        this.b = 30;
    }

    @Override // com.baidu.tieba.bc2
    public vb2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (vb2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bc2
    public boolean c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3)) == null) {
            if (c) {
                Log.d("GlobalRecorderStrategy", "prefetchId - " + str);
                Log.d("GlobalRecorderStrategy", "appId - " + str2);
                Log.d("GlobalRecorderStrategy", "url - " + str3);
            }
            wb2 wb2Var = this.a.get(str2, str3);
            boolean z = true;
            if (wb2Var == null) {
                if (c) {
                    Log.d("GlobalRecorderStrategy", "has no record, need prelink");
                }
                return true;
            } else if (!TextUtils.isEmpty(str)) {
                if (c) {
                    Log.d("GlobalRecorderStrategy", "in preload stage, has record, not real prelink ");
                }
                return false;
            } else {
                String curProcessName = ProcessUtils.getCurProcessName();
                if (!TextUtils.equals(curProcessName, wb2Var.a)) {
                    if (c) {
                        Log.d("GlobalRecorderStrategy", "process not match, current - " + curProcessName + ", record - " + wb2Var.a);
                    }
                    return true;
                }
                if (System.currentTimeMillis() - wb2Var.b < this.b * 1000) {
                    z = false;
                }
                if (c) {
                    Log.d("GlobalRecorderStrategy", "url in recorder, time is out - " + z);
                }
                return z;
            }
        }
        return invokeLLL.booleanValue;
    }
}
