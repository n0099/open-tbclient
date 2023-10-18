package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.m9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class e9<T> implements l9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final f9 b;

    public abstract h9<T> i(String str);

    public abstract void j(h9<T> h9Var);

    public abstract void l(String str);

    public abstract void m(String str);

    public e9(f9 f9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = f9Var;
        this.a = z;
    }

    @Override // com.baidu.tieba.l9
    public T a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            h9<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            return k.b;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.l9
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            l(h(str, str2));
        }
    }

    @Override // com.baidu.tieba.l9
    public m9.b<T> e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            h9<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            m9.b<T> bVar = new m9.b<>();
            bVar.a = str2;
            bVar.b = k.b;
            long j = k.f;
            bVar.c = k.d;
            return bVar;
        }
        return (m9.b) invokeLL.objValue;
    }

    public String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (this.a) {
                return str + "@" + str2;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.l9
    public f9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (f9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l9
    public void f(String str, String str2, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, t, Long.valueOf(j)}) == null) {
            h9<T> h9Var = new h9<>();
            h9Var.a = h(str, str2);
            h9Var.c = str;
            h9Var.f = j;
            h9Var.b = t;
            h9Var.e = System.currentTimeMillis();
            h9Var.d = System.currentTimeMillis();
            j(h9Var);
        }
    }

    public h9<T> k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String h = h(str, str2);
            h9<T> i = i(h);
            if (i == null) {
                BdLog.isDebugMode();
                return null;
            } else if (i.f < System.currentTimeMillis()) {
                m(h);
                BdLog.isDebugMode();
                return null;
            } else {
                if (this.b.a()) {
                    i.e = System.currentTimeMillis();
                    j(i);
                }
                BdLog.isDebugMode();
                return i;
            }
        }
        return (h9) invokeLL.objValue;
    }
}
