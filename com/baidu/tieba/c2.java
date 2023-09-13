package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c2 implements w0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.w0
    public void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, th) == null) {
            Log.i(str, str2, th);
        }
    }

    @Override // com.baidu.tieba.w0
    public void b(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, th) == null) {
            Log.d(str, str2, th);
        }
    }

    @Override // com.baidu.tieba.w0
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, th) == null) {
            Log.e(str, str2, th);
        }
    }

    @Override // com.baidu.tieba.w0
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            Log.d(str, str2);
        }
    }

    @Override // com.baidu.tieba.w0
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            Log.e(str, str2);
        }
    }

    @Override // com.baidu.tieba.w0
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            Log.i(str, str2);
        }
    }
}
