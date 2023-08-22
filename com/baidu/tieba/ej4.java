package com.baidu.tieba;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class ej4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Class<?>, dj4> a;
    public ConcurrentHashMap<Class<?>, Uri> b;

    public ej4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public <T> dj4<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            return this.a.get(cls);
        }
        return (dj4) invokeL.objValue;
    }

    public <T> Uri b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            return this.b.get(cls);
        }
        return (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = new ConcurrentHashMap<>();
            this.b = new ConcurrentHashMap<>();
            this.a.put(ck4.class, new hj4());
            this.a.put(dk4.class, new ij4());
            this.a.put(ak4.class, new gj4());
            this.a.put(yj4.class, new fj4());
            this.a.put(PMSAppInfo.class, new cj4());
            this.a.put(ek4.class, new jj4());
            this.a.put(fk4.class, new kj4());
            this.b.put(ck4.class, uj4.f);
            this.b.put(dk4.class, uj4.g);
            this.b.put(ak4.class, uj4.d);
            this.b.put(yj4.class, uj4.h);
            this.b.put(PMSAppInfo.class, uj4.e);
            this.b.put(ek4.class, uj4.i);
            this.b.put(fk4.class, uj4.j);
        }
    }
}
