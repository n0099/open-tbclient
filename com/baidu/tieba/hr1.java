package com.baidu.tieba;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sso.r.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hr1 implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fr1 a;

    public hr1(fr1 fr1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fr1Var;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            this.a.a = a.AbstractBinderC0193a.a(iBinder);
            cr1 cr1Var = this.a.e;
            if (cr1Var != null) {
                cr1Var.a();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            fr1 fr1Var = this.a;
            fr1Var.a = null;
            cr1 cr1Var = fr1Var.e;
            if (cr1Var != null) {
                cr1Var.a();
            }
        }
    }
}
