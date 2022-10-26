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
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
/* loaded from: classes3.dex */
public class c00 {
    public static /* synthetic */ Interceptable $ic;
    public static final SecureRandom b;
    public transient /* synthetic */ FieldHolder $fh;
    public e00 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947620806, "Lcom/baidu/tieba/c00;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947620806, "Lcom/baidu/tieba/c00;");
                return;
            }
        }
        b = new SecureRandom();
    }

    public c00() {
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
        this.a = null;
        this.a = new e00(new b00(), 16);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bArr, bArr2, bArr3)) == null) {
            c00 c00Var = new c00();
            c00Var.a(2, bArr, bArr2);
            return c00Var.b(bArr3);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, bArr, bArr2, bArr3)) == null) {
            c00 c00Var = new c00();
            c00Var.a(1, bArr, bArr2);
            return c00Var.b(bArr3);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public void a(int i, byte[] bArr, byte[] bArr2) throws InvalidAlgorithmParameterException, InvalidKeyException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, bArr, bArr2) == null) {
            this.a.d(i, bArr, bArr2, b);
        }
    }

    public final byte[] b(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            if (bArr != null) {
                return this.a.e(bArr, 0, bArr.length);
            }
            throw new IllegalArgumentException("Null input buffer");
        }
        return (byte[]) invokeL.objValue;
    }
}
