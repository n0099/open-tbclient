package com.baidu.tieba;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ag6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dg6 implements cg6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dg6 b;
    public transient /* synthetic */ FieldHolder $fh;
    public cg6 a;

    public dg6() {
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

    public static dg6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (dg6.class) {
                    if (b == null) {
                        b = new dg6();
                    }
                }
            }
            return b;
        }
        return (dg6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cg6
    public WebResourceResponse a(String str, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, webResourceRequest)) == null) {
            cg6 cg6Var = this.a;
            if (cg6Var == null) {
                return null;
            }
            return cg6Var.a(str, webResourceRequest);
        }
        return (WebResourceResponse) invokeLL.objValue;
    }

    public void c(ag6.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && aVar != null) {
            this.a = aVar.b();
        }
    }
}
