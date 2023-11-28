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
public class dt3 implements gs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dt3() {
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

    @Override // com.baidu.tieba.gs1
    public gj4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ct3.b().a();
        }
        return (gj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gs1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !ct3.b().c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.gs1
    public void b(lc2 lc2Var, jc2 jc2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lc2Var, jc2Var) != null) || jc2Var == null) {
            return;
        }
        if (lc2Var != null && !TextUtils.isEmpty(lc2Var.a)) {
            String str = lc2Var.a;
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
                    jc2Var.onFail();
                    return;
                } else {
                    ct3.b().b(true, jc2Var);
                    return;
                }
            } else if (lc2Var.b) {
                ct3.b().b(false, jc2Var);
                return;
            } else {
                ct3.b().b(true, jc2Var);
                return;
            }
        }
        jc2Var.onFail();
    }

    @Override // com.baidu.tieba.gs1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!d() && !wf2.d.w() && (!wf2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) || !bd2.V().t0())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
