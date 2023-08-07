package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class cd4 {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<zc4> a;
    public static ArrayList<Integer> b;
    public static final cd4 c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947670902, "Lcom/baidu/tieba/cd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947670902, "Lcom/baidu/tieba/cd4;");
                return;
            }
        }
        c = new cd4();
        a = new ArrayList<>();
        b = new ArrayList<>();
    }

    public cd4() {
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

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Iterator<zc4> it = a.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || b.contains(Integer.valueOf(i))) {
            return;
        }
        b.add(Integer.valueOf(i));
    }

    public final zc4 b(JSRuntime jsRuntime) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsRuntime)) == null) {
            Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
            zc4 zc4Var = new zc4(jsRuntime);
            a.add(zc4Var);
            return zc4Var;
        }
        return (zc4) invokeL.objValue;
    }

    public final boolean c(zc4 socket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, socket)) == null) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            if (a.contains(socket)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return b.contains(Integer.valueOf(i));
        }
        return invokeI.booleanValue;
    }

    public final void e(zc4 socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, socket) == null) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            if (a.contains(socket)) {
                g(socket.z());
                a.remove(socket);
            }
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            b.remove(Integer.valueOf(i));
        }
    }
}
