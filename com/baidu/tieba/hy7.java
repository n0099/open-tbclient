package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hy7 {
    public static /* synthetic */ Interceptable $ic;
    public static hy7 c;
    public transient /* synthetic */ FieldHolder $fh;
    public kf a;
    public kf b;

    public hy7() {
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
        this.a = null;
        this.b = null;
        c();
    }

    public static synchronized hy7 b() {
        InterceptResult invokeV;
        hy7 hy7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (hy7.class) {
                if (c == null) {
                    c = new hy7();
                }
                hy7Var = c;
            }
            return hy7Var;
        }
        return (hy7) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.a == null) {
                ou4.f();
                this.a = ou4.d("tb.pb_mark");
            }
            if (this.b == null) {
                ou4.f();
                this.b = ou4.d("tb.pb_normal");
            }
        }
    }

    public byte[] a(String str, boolean z) {
        InterceptResult invokeLZ;
        kf.b h;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                kf kfVar = this.a;
                if (kfVar != null && str != null) {
                    h = kfVar.h(str);
                }
                h = null;
            } else {
                kf kfVar2 = this.b;
                if (kfVar2 != null && str != null) {
                    h = kfVar2.h(str);
                }
                h = null;
            }
            if (h == null || (obj = h.b) == null) {
                return null;
            }
            return (byte[]) obj;
        }
        return (byte[]) invokeLZ.objValue;
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (z) {
                kf kfVar = this.a;
                if (kfVar != null && str != null) {
                    kfVar.i(str, new byte[0], 0L);
                    return;
                }
                return;
            }
            kf kfVar2 = this.b;
            if (kfVar2 != null && str != null) {
                kfVar2.i(str, new byte[0], 0L);
            }
        }
    }

    public void f(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, bArr) == null) && bArr != null && str != null) {
            c();
            this.a.e(str, bArr, 86400000L);
        }
    }

    public void e(String str, boolean z, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), bArr}) == null) && str != null) {
            c();
            if (z) {
                this.a.e(str, bArr, 86400000L);
            } else {
                this.b.e(str, bArr, 86400000L);
            }
        }
    }
}
