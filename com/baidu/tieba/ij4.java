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
/* loaded from: classes6.dex */
public class ij4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Class<?>, hj4> a;
    public ConcurrentHashMap<Class<?>, Uri> b;

    public ij4() {
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

    public <T> hj4<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            return this.a.get(cls);
        }
        return (hj4) invokeL.objValue;
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
            this.a.put(gk4.class, new lj4());
            this.a.put(hk4.class, new mj4());
            this.a.put(ek4.class, new kj4());
            this.a.put(ck4.class, new jj4());
            this.a.put(PMSAppInfo.class, new gj4());
            this.a.put(ik4.class, new nj4());
            this.a.put(jk4.class, new oj4());
            this.b.put(gk4.class, yj4.f);
            this.b.put(hk4.class, yj4.g);
            this.b.put(ek4.class, yj4.d);
            this.b.put(ck4.class, yj4.h);
            this.b.put(PMSAppInfo.class, yj4.e);
            this.b.put(ik4.class, yj4.i);
            this.b.put(jk4.class, yj4.j);
        }
    }
}
