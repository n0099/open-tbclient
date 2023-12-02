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
/* loaded from: classes6.dex */
public class gt3 implements js1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public gt3() {
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

    @Override // com.baidu.tieba.js1
    public jj4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ft3.b().a();
        }
        return (jj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.js1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !ft3.b().c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.js1
    public void b(oc2 oc2Var, mc2 mc2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oc2Var, mc2Var) != null) || mc2Var == null) {
            return;
        }
        if (oc2Var != null && !TextUtils.isEmpty(oc2Var.a)) {
            String str = oc2Var.a;
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
                    mc2Var.onFail();
                    return;
                } else {
                    ft3.b().b(true, mc2Var);
                    return;
                }
            } else if (oc2Var.b) {
                ft3.b().b(false, mc2Var);
                return;
            } else {
                ft3.b().b(true, mc2Var);
                return;
            }
        }
        mc2Var.onFail();
    }

    @Override // com.baidu.tieba.js1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!d() && !zf2.d.w() && (!zf2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) || !ed2.V().t0())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
