package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ika implements oka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public byte[] b;
    public boolean c;

    public ika() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.oka
    public int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            float f = this.a;
            if (f != 1.0d) {
                if (bArr != null) {
                    this.b = c(bArr, f);
                }
                return i;
            }
            this.b = bArr;
            this.c = true;
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.oka
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            float f = this.a;
            return f >= 0.0f && f <= 1.0f;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.oka
    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            return false;
        }
        return invokeIIII.booleanValue;
    }

    @Override // com.baidu.tieba.oka
    public byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (this.c) {
                this.c = false;
                return this.b;
            }
            return null;
        }
        return (byte[]) invokeI.objValue;
    }

    public void b(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.a = f;
        }
    }

    @Override // com.baidu.tieba.oka
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.oka
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c = false;
            this.b = null;
        }
    }

    public final byte[] c(byte[] bArr, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, bArr, f)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            int length = bArr.length / 2;
            short[] sArr = new short[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                sArr[i] = (short) (((short) (((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255))) * f);
            }
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i3 * 2;
                bArr[i4] = (byte) (sArr[i3] & 255);
                bArr[i4 + 1] = (byte) ((sArr[i3] & 65280) >> 8);
            }
            return bArr;
        }
        return (byte[]) invokeLF.objValue;
    }

    @Override // com.baidu.tieba.oka
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c = false;
            this.b = null;
        }
    }

    @Override // com.baidu.tieba.oka
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }
}
