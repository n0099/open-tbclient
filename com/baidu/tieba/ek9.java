package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
/* loaded from: classes4.dex */
public class ek9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public boolean b;
    public boolean c;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return i != 5 ? -1 : 0;
                        }
                        return 1;
                    }
                    return 3;
                }
                return 4;
            }
            return 6;
        }
        return invokeI.intValue;
    }

    public ek9(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = z;
        this.c = z2;
    }

    public String b(byte[] bArr) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i2 = 0; i2 < (bArr.length + 4) / 5; i2++) {
                short[] sArr = new short[5];
                int[] iArr = new int[8];
                int i3 = 5;
                for (int i4 = 0; i4 < 5; i4++) {
                    int i5 = (i2 * 5) + i4;
                    if (i5 < bArr.length) {
                        sArr[i4] = (short) (bArr[i5] & 255);
                    } else {
                        sArr[i4] = 0;
                        i3--;
                    }
                }
                int a = a(i3);
                iArr[0] = (byte) ((sArr[0] >> 3) & 31);
                iArr[1] = (byte) (((sArr[0] & 7) << 2) | ((sArr[1] >> 6) & 3));
                iArr[2] = (byte) ((sArr[1] >> 1) & 31);
                iArr[3] = (byte) (((sArr[1] & 1) << 4) | ((sArr[2] >> 4) & 15));
                iArr[4] = (byte) (((sArr[2] & 15) << 1) | ((sArr[3] >> 7) & 1));
                iArr[5] = (byte) ((sArr[3] >> 2) & 31);
                iArr[6] = (byte) (((sArr[4] >> 5) & 7) | ((sArr[3] & 3) << 3));
                iArr[7] = (byte) (sArr[4] & 31);
                int i6 = 0;
                while (true) {
                    i = 8 - a;
                    if (i6 >= i) {
                        break;
                    }
                    char charAt = this.a.charAt(iArr[i6]);
                    if (this.c) {
                        charAt = Character.toLowerCase(charAt);
                    }
                    byteArrayOutputStream.write(charAt);
                    i6++;
                }
                if (this.b) {
                    while (i < 8) {
                        byteArrayOutputStream.write(61);
                        i++;
                    }
                }
            }
            return new String(byteArrayOutputStream.toByteArray());
        }
        return (String) invokeL.objValue;
    }
}
