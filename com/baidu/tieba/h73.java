package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class h73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle a;
    public int b;
    public String c;
    public Bundle d;

    public abstract void b(@NonNull Bundle bundle);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947776581, "Lcom/baidu/tieba/h73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947776581, "Lcom/baidu/tieba/h73;");
                return;
            }
        }
        e = rr1.a;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d(this.d);
        }
    }

    public h73() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Bundle();
        this.c = "";
        this.d = new Bundle();
    }

    public void d(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            if (e) {
                Log.d("MDelegate-Delegation", "messenger delegation finish");
            }
            if (!p73.a(this.c)) {
                if (e) {
                    Log.d("MDelegate-Delegation", "messenger delegation finish with send result to client: " + this.b + " observer: " + this.c);
                }
                i73.c(this.b, this.c, bundle);
            }
        }
    }
}
