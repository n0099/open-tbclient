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
public class ct3 implements fs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ct3() {
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

    @Override // com.baidu.tieba.fs1
    public fj4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return bt3.b().a();
        }
        return (fj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fs1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !bt3.b().c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fs1
    public void b(kc2 kc2Var, ic2 ic2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kc2Var, ic2Var) != null) || ic2Var == null) {
            return;
        }
        if (kc2Var != null && !TextUtils.isEmpty(kc2Var.a)) {
            String str = kc2Var.a;
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
                    ic2Var.onFail();
                    return;
                } else {
                    bt3.b().b(true, ic2Var);
                    return;
                }
            } else if (kc2Var.b) {
                bt3.b().b(false, ic2Var);
                return;
            } else {
                bt3.b().b(true, ic2Var);
                return;
            }
        }
        ic2Var.onFail();
    }

    @Override // com.baidu.tieba.fs1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!d() && !vf2.d.w() && (!vf2.d.k(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) || !ad2.V().t0())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
