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
/* loaded from: classes3.dex */
public class ar3 implements cq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ar3() {
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

    @Override // com.baidu.tieba.cq1
    public dh4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return zq3.b().a();
        }
        return (dh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cq1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !zq3.b().c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cq1
    public void b(ia2 ia2Var, ga2 ga2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ia2Var, ga2Var) != null) || ga2Var == null) {
            return;
        }
        if (ia2Var != null && !TextUtils.isEmpty(ia2Var.a)) {
            String str = ia2Var.a;
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
                    ga2Var.onFail();
                    return;
                } else {
                    zq3.b().b(true, ga2Var);
                    return;
                }
            } else if (ia2Var.b) {
                zq3.b().b(false, ga2Var);
                return;
            } else {
                zq3.b().b(true, ga2Var);
                return;
            }
        }
        ga2Var.onFail();
    }

    @Override // com.baidu.tieba.cq1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!d() && !td2.d.w() && (!td2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) || !ya2.U().s0())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
