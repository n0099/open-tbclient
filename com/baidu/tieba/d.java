package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public volatile int b;
    public volatile int c;
    public volatile int d;
    public int e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d() {
        this(4194304);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.b = 0;
                this.c = 0;
                this.d = 0;
            }
        }
    }

    public d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.e = i;
        this.a = new byte[i];
    }

    public synchronized boolean b(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length >= i && i <= this.b) {
                        if (this.c + i <= this.e) {
                            System.arraycopy(this.a, this.c, bArr, 0, i);
                            this.c += i;
                            this.b -= i;
                            return true;
                        }
                        System.arraycopy(this.a, this.c, bArr, 0, this.e - this.c);
                        System.arraycopy(this.a, 0, bArr, this.e - this.c, (this.c + i) - this.e);
                        this.c = (i - this.e) + this.c;
                        this.b -= i;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public synchronized boolean c(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i)) == null) {
            synchronized (this) {
                if (bArr != null) {
                    if (bArr.length >= i && this.b + i <= this.e) {
                        if (this.d + i <= this.e) {
                            System.arraycopy(bArr, 0, this.a, this.d, i);
                            this.d += i;
                            this.b += i;
                            return true;
                        }
                        System.arraycopy(bArr, 0, this.a, this.d, this.e - this.d);
                        System.arraycopy(bArr, this.e - this.d, this.a, 0, (this.d + i) - this.e);
                        this.d = (i - this.e) + this.d;
                        this.b += i;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLI.booleanValue;
    }
}
