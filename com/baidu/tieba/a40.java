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
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.BadPaddingException;
/* loaded from: classes3.dex */
public final class a40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public final int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947565068, "Lcom/baidu/tieba/a40;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947565068, "Lcom/baidu/tieba/a40;");
                return;
            }
        }
        Collections.synchronizedMap(new HashMap());
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public a40(int i, int i2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = i2;
        if (i2 >= 64) {
            if (i != 1 && i != 2) {
                if (i == 3) {
                    this.c = i2;
                    return;
                }
                throw new InvalidKeyException("Invalid padding: " + i);
            }
            this.c = i2 - 11;
            return;
        }
        throw new InvalidKeyException("Padded size must be at least 64");
    }

    public static a40 a(int i, int i2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
            return new a40(i, i2);
        }
        return (a40) invokeII.objValue;
    }

    public byte[] c(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            if (bArr.length == this.b) {
                int i = this.a;
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        return bArr;
                    }
                    throw new AssertionError();
                }
                return d(bArr);
            }
            throw new BadPaddingException("Padded length must be " + this.b);
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] d(byte[] bArr) throws BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            if (bArr[0] == 0) {
                int i = 2;
                if (bArr[1] != this.a) {
                    throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
                }
                while (true) {
                    int i2 = i + 1;
                    int i3 = bArr[i] & 255;
                    if (i3 == 0) {
                        int length = bArr.length - i2;
                        if (length <= this.c) {
                            byte[] bArr2 = new byte[length];
                            System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                            return bArr2;
                        }
                        throw new BadPaddingException("Padding string too short");
                    } else if (i2 != bArr.length) {
                        if (this.a == 1 && i3 != 255) {
                            throw new BadPaddingException("Padding byte not 0xff: " + i3);
                        }
                        i = i2;
                    } else {
                        throw new BadPaddingException("Padding string not terminated");
                    }
                }
            } else {
                throw new BadPaddingException("Data must start with zero");
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }
}
