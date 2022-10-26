package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;
/* loaded from: classes3.dex */
public class b50 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] b;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    public static int k(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) ? (i >>> (-i2)) | (i << i2) : invokeII.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 12;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947595820, "Lcom/baidu/tieba/b50;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947595820, "Lcom/baidu/tieba/b50;");
                return;
            }
        }
        b = n(new byte[]{Constants.SHORT_PING_CMD_TYPE, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, Constants.SHORT_PING_CMD_TYPE, 32, 107});
    }

    public b50(int i) {
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
        this.a = i;
    }

    public byte[] c(ByteBuffer byteBuffer) throws GeneralSecurityException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) {
            if (byteBuffer.remaining() >= h()) {
                byte[] bArr = new byte[h()];
                byteBuffer.get(bArr);
                ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
                i(bArr, d50.a(), allocate, byteBuffer);
                return allocate.array();
            }
            throw new GeneralSecurityException("data too short");
        }
        return (byte[]) invokeL.objValue;
    }

    public static void j(int[] iArr, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{iArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            iArr[i] = iArr[i] + iArr[i2];
            iArr[i4] = k(iArr[i4] ^ iArr[i], 16);
            iArr[i3] = iArr[i3] + iArr[i4];
            iArr[i2] = k(iArr[i2] ^ iArr[i3], 12);
            iArr[i] = iArr[i] + iArr[i2];
            iArr[i4] = k(iArr[i] ^ iArr[i4], 8);
            iArr[i3] = iArr[i3] + iArr[i4];
            iArr[i2] = k(iArr[i2] ^ iArr[i3], 7);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr, iArr2) == null) {
            int[] iArr3 = b;
            System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
            System.arraycopy(iArr2, 0, iArr, b.length, 8);
        }
    }

    public static void m(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, iArr) == null) {
            for (int i = 0; i < 10; i++) {
                j(iArr, 0, 4, 8, 12);
                j(iArr, 1, 5, 9, 13);
                j(iArr, 2, 6, 10, 14);
                j(iArr, 3, 7, 11, 15);
                j(iArr, 0, 5, 10, 15);
                j(iArr, 1, 6, 11, 12);
                j(iArr, 2, 7, 8, 13);
                j(iArr, 3, 4, 9, 14);
            }
        }
    }

    public static int[] n(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
            int[] iArr = new int[asIntBuffer.remaining()];
            asIntBuffer.get(iArr);
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public byte[] d(byte[] bArr) throws GeneralSecurityException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            return c(ByteBuffer.wrap(bArr));
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] f(byte[] bArr) throws GeneralSecurityException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) {
            return g(bArr, null);
        }
        return (byte[]) invokeL.objValue;
    }

    public ByteBuffer a(byte[] bArr, byte[] bArr2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, bArr, bArr2, i)) == null) {
            int[] b2 = b(n(bArr), n(bArr2), i);
            int[] iArr = (int[]) b2.clone();
            m(iArr);
            for (int i2 = 0; i2 < b2.length; i2++) {
                b2[i2] = b2[i2] + iArr[i2];
            }
            ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
            order.asIntBuffer().put(b2, 0, 16);
            return order;
        }
        return (ByteBuffer) invokeLLI.objValue;
    }

    public int[] b(int[] iArr, int[] iArr2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr, iArr2, i)) == null) {
            if (iArr.length == h() / 4) {
                int[] iArr3 = new int[16];
                l(iArr3, iArr2);
                iArr3[12] = i;
                System.arraycopy(iArr, 0, iArr3, 13, iArr.length);
                return iArr3;
            }
            throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", Integer.valueOf(iArr.length * 32)));
        }
        return (int[]) invokeLLI.objValue;
    }

    public void e(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, byteBuffer, bArr, bArr2) == null) {
            if (byteBuffer.remaining() - h() >= bArr.length) {
                if (bArr2 == null) {
                    bArr2 = new byte[h()];
                    new Random().nextBytes(bArr2);
                }
                byteBuffer.put(bArr2);
                i(bArr2, d50.b(), byteBuffer, ByteBuffer.wrap(bArr));
                return;
            }
            throw new IllegalArgumentException("data output is too small");
        }
    }

    public byte[] g(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bArr, bArr2)) == null) {
            if (bArr.length <= Integer.MAX_VALUE - h()) {
                ByteBuffer allocate = ByteBuffer.allocate(h() + bArr.length);
                e(allocate, bArr, bArr2);
                return allocate.array();
            }
            throw new GeneralSecurityException("data too long");
        }
        return (byte[]) invokeLL.objValue;
    }

    public final void i(byte[] bArr, byte[] bArr2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, bArr2, byteBuffer, byteBuffer2) == null) {
            int remaining = byteBuffer2.remaining();
            int i = (remaining / 64) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                ByteBuffer a = a(bArr, bArr2, this.a + i2);
                if (i2 == i - 1) {
                    a50.a(byteBuffer, byteBuffer2, a, remaining % 64);
                } else {
                    a50.a(byteBuffer, byteBuffer2, a, 64);
                }
            }
        }
    }
}
