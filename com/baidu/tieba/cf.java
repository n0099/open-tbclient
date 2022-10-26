package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class cf implements jf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final df b;

    public abstract ff i(String str);

    public abstract void j(ff ffVar);

    public abstract void l(String str);

    public abstract void m(String str);

    public cf(df dfVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dfVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = dfVar;
        this.a = z;
    }

    @Override // com.baidu.tieba.jf
    public Object a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            ff k = k(str, str2);
            if (k == null) {
                return null;
            }
            return k.b;
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.jf
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            l(h(str, str2));
        }
    }

    @Override // com.baidu.tieba.jf
    public kf.b e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            ff k = k(str, str2);
            if (k == null) {
                return null;
            }
            kf.b bVar = new kf.b();
            bVar.a = str2;
            bVar.b = k.b;
            long j = k.f;
            bVar.c = k.d;
            return bVar;
        }
        return (kf.b) invokeLL.objValue;
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

    @Override // com.baidu.tieba.jf
    public df c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (df) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jf
    public void f(String str, String str2, Object obj, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, obj, Long.valueOf(j)}) == null) {
            ff ffVar = new ff();
            ffVar.a = h(str, str2);
            ffVar.c = str;
            ffVar.f = j;
            ffVar.b = obj;
            ffVar.e = System.currentTimeMillis();
            ffVar.d = System.currentTimeMillis();
            j(ffVar);
        }
    }

    public ff k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String h = h(str, str2);
            ff i = i(h);
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
        return (ff) invokeLL.objValue;
    }
}
