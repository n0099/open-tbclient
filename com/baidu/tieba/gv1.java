package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.net.NetRedirectInfo;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.net.NetRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gv1 implements NetRequest.RedirectInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gv1() {
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

    @Override // com.baidu.searchbox.v8engine.net.NetRequest.RedirectInterceptor
    public boolean shouldInterceptRedirect(NetRequestParam netRequestParam, NetRedirectInfo netRedirectInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, netRequestParam, netRedirectInfo)) == null) {
            if (netRedirectInfo == null) {
                return false;
            }
            String newUrl = netRedirectInfo.getNewUrl();
            if (!TextUtils.isEmpty(newUrl) && g63.c("request", newUrl, null) == 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
