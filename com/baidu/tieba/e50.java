package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes4.dex */
public final class e50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public g50 c;
    public byte[] d;
    public int e;
    public c50 f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947685193, "Lcom/baidu/tieba/e50;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947685193, "Lcom/baidu/tieba/e50;");
        }
    }

    public e50() {
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
        this.b = 2;
    }

    private void update(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65538, this, bArr, i, i2) == null) && i2 != 0 && bArr != null) {
            int i3 = this.e;
            int i4 = i3 + i2;
            byte[] bArr2 = this.d;
            if (i4 > bArr2.length) {
                this.e = bArr2.length + 1;
                return;
            }
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.e += i2;
        }
    }

    public byte[] b(byte[] bArr, int i, int i2) throws BadPaddingException, IllegalBlockSizeException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i, i2)) == null) {
            update(bArr, i, i2);
            return a();
        }
        return (byte[]) invokeLII.objValue;
    }

    public final byte[] a() throws BadPaddingException, IllegalBlockSizeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.e;
            byte[] bArr = this.d;
            if (i <= bArr.length) {
                try {
                    int i2 = this.a;
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 == 4) {
                                    return this.c.c(d50.e(d50.a(bArr, 0, i), this.f));
                                }
                                throw new AssertionError("Internal error");
                            }
                            throw new UnsupportedOperationException("only verify supported");
                        }
                        throw new UnsupportedOperationException("only verify supported");
                    }
                    throw new UnsupportedOperationException("only verify supported");
                } finally {
                    this.e = 0;
                }
            }
            throw new IllegalBlockSizeException("Data must not be longer than " + this.d.length + " bytes");
        }
        return (byte[]) invokeV.objValue;
    }

    public void c(int i, c50 c50Var) throws InvalidKeyException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, c50Var) == null) {
            try {
                e(i, c50Var, null);
            } catch (InvalidAlgorithmParameterException e) {
                InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
                invalidKeyException.initCause(e);
                throw invalidKeyException;
            }
        }
    }

    public void d(int i) throws NoSuchPaddingException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 1) {
                this.b = 1;
            } else if (i == 2) {
                this.b = 2;
            } else {
                throw new NoSuchPaddingException("Padding " + i + " not supported");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(int i, c50 c50Var, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, c50Var, algorithmParameterSpec) == null) {
            int i2 = 4;
            int i3 = 2;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new InvalidKeyException("Unknown mode: " + i);
                        }
                    }
                }
                z = false;
                if (!(c50Var instanceof c50)) {
                    if (z) {
                        i2 = 1;
                    }
                    this.a = i2;
                    this.f = c50Var;
                    int c = d50.c(c50Var.b());
                    this.e = 0;
                    int i4 = this.b;
                    if (i4 == 1) {
                        if (algorithmParameterSpec == null) {
                            this.c = g50.a(3, c);
                            this.d = new byte[c];
                            return;
                        }
                        throw new InvalidAlgorithmParameterException("Parameters not supported");
                    } else if (i4 == 2) {
                        if (algorithmParameterSpec == null) {
                            if (this.a > 2) {
                                i3 = 1;
                            }
                            g50 a = g50.a(i3, c);
                            this.c = a;
                            if (z) {
                                this.d = new byte[a.b()];
                                return;
                            } else {
                                this.d = new byte[c];
                                return;
                            }
                        }
                        throw new InvalidAlgorithmParameterException("Parameters not supported");
                    } else {
                        throw new InvalidKeyException("PEAO not supported");
                    }
                }
                throw new InvalidKeyException("only support helios key");
            }
            z = true;
            if (!(c50Var instanceof c50)) {
            }
        }
    }
}
