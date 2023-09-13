package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
@Service
/* loaded from: classes5.dex */
public class dy3 implements fx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dy3() {
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

    @Override // com.baidu.tieba.fx1
    public go4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return cy3.b().a();
        }
        return (go4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fx1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !cy3.b().c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fx1
    public void b(lh2 lh2Var, jh2 jh2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lh2Var, jh2Var) != null) || jh2Var == null) {
            return;
        }
        if (lh2Var != null && !TextUtils.isEmpty(lh2Var.a)) {
            String str = lh2Var.a;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 1195918653) {
                if (hashCode == 1825003424 && str.equals("by_click")) {
                    c = 0;
                }
            } else if (str.equals("by_silent")) {
                c = 1;
            }
            if (c != 0) {
                if (c != 1) {
                    jh2Var.onFail();
                    return;
                } else {
                    cy3.b().b(true, jh2Var);
                    return;
                }
            } else if (lh2Var.b) {
                cy3.b().b(false, jh2Var);
                return;
            } else {
                cy3.b().b(true, jh2Var);
                return;
            }
        }
        jh2Var.onFail();
    }

    @Override // com.baidu.tieba.fx1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!d() && !wk2.d.w() && (!wk2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) || !bi2.U().s0())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
