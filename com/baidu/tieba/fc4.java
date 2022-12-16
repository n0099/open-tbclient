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
/* loaded from: classes4.dex */
public class fc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Class<?>, ec4> a;
    public ConcurrentHashMap<Class<?>, Uri> b;

    public fc4() {
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

    public <T> ec4<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            return this.a.get(cls);
        }
        return (ec4) invokeL.objValue;
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
            this.a.put(dd4.class, new ic4());
            this.a.put(ed4.class, new jc4());
            this.a.put(bd4.class, new hc4());
            this.a.put(zc4.class, new gc4());
            this.a.put(PMSAppInfo.class, new dc4());
            this.a.put(fd4.class, new kc4());
            this.a.put(gd4.class, new lc4());
            this.b.put(dd4.class, vc4.f);
            this.b.put(ed4.class, vc4.g);
            this.b.put(bd4.class, vc4.d);
            this.b.put(zc4.class, vc4.h);
            this.b.put(PMSAppInfo.class, vc4.e);
            this.b.put(fd4.class, vc4.i);
            this.b.put(gd4.class, vc4.j);
        }
    }
}
