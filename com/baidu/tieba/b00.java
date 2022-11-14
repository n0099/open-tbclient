package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidKeyException;
/* loaded from: classes3.dex */
public abstract class b00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xz a;
    public final int b;
    public byte[] c;

    public b00(xz xzVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xzVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xzVar;
        this.b = xzVar.a();
    }

    public abstract void a(boolean z, String str, byte[] bArr, byte[] bArr2) throws InvalidKeyException;

    public abstract void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public void c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            b(bArr, i, i2, bArr2, i3);
        }
    }

    public abstract void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public void e(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            d(bArr, i, i2, bArr2, i3);
        }
    }

    public abstract void f();

    public abstract void g();

    public abstract void h();
}
