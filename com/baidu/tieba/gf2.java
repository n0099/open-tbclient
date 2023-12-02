package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class gf2 extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947791926, "Lcom/baidu/tieba/gf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947791926, "Lcom/baidu/tieba/gf2;");
                return;
            }
        }
        rp2.g0().getSwitch("swan_recovery_enable", true);
        a = true;
    }

    public gf2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void c(qf2 qf2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, qf2Var) != null) || !a || qf2Var == null) {
            return;
        }
        if (ProcessUtils.isMainProcess()) {
            hf2.a(qf2Var).b();
            pf2.b().a(qf2Var.a);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("recovery_level", qf2Var.a);
        bundle.putStringArrayList("recovery_app_list", qf2Var.b);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), gf2.class, bundle);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            if (!a) {
                return null;
            }
            int i = bundle.getInt("recovery_level", -1);
            ArrayList<String> stringArrayList = bundle.getStringArrayList("recovery_app_list");
            qf2 qf2Var = new qf2();
            qf2Var.a = i;
            if (stringArrayList != null) {
                qf2Var.b = stringArrayList;
            }
            hf2.a(qf2Var).b();
            pf2.b().a(qf2Var.a);
            return null;
        }
        return (Bundle) invokeL.objValue;
    }
}
