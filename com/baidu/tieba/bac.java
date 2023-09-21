package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class bac {
    public static /* synthetic */ Interceptable $ic;
    public static final bac[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947639685, "Lcom/baidu/tieba/bac;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947639685, "Lcom/baidu/tieba/bac;");
                return;
            }
        }
        d = new bac[]{new bac("", 0, ""), new bac("", 0, " "), new bac(" ", 0, " "), new bac("", 12, ""), new bac("", 10, " "), new bac("", 0, " the "), new bac(" ", 0, ""), new bac("s ", 0, " "), new bac("", 0, " of "), new bac("", 10, ""), new bac("", 0, " and "), new bac("", 13, ""), new bac("", 1, ""), new bac(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new bac("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new bac(" ", 10, " "), new bac("", 0, " in "), new bac("", 0, " to "), new bac("e ", 0, " "), new bac("", 0, "\""), new bac("", 0, "."), new bac("", 0, "\">"), new bac("", 0, "\n"), new bac("", 3, ""), new bac("", 0, PreferencesUtil.RIGHT_MOUNT), new bac("", 0, " for "), new bac("", 14, ""), new bac("", 2, ""), new bac("", 0, " a "), new bac("", 0, " that "), new bac(" ", 10, ""), new bac("", 0, ". "), new bac(".", 0, ""), new bac(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new bac("", 15, ""), new bac("", 0, " with "), new bac("", 0, "'"), new bac("", 0, " from "), new bac("", 0, " by "), new bac("", 16, ""), new bac("", 17, ""), new bac(" the ", 0, ""), new bac("", 4, ""), new bac("", 0, ". The "), new bac("", 11, ""), new bac("", 0, " on "), new bac("", 0, " as "), new bac("", 0, " is "), new bac("", 7, ""), new bac("", 1, "ing "), new bac("", 0, "\n\t"), new bac("", 0, ":"), new bac(" ", 0, ". "), new bac("", 0, "ed "), new bac("", 20, ""), new bac("", 18, ""), new bac("", 6, ""), new bac("", 0, "("), new bac("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new bac("", 8, ""), new bac("", 0, " at "), new bac("", 0, "ly "), new bac(" the ", 0, " of "), new bac("", 5, ""), new bac("", 9, ""), new bac(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new bac("", 10, "\""), new bac(".", 0, "("), new bac("", 11, " "), new bac("", 10, "\">"), new bac("", 0, "=\""), new bac(" ", 0, "."), new bac(".com/", 0, ""), new bac(" the ", 0, " of the "), new bac("", 10, "'"), new bac("", 0, ". This "), new bac("", 0, ","), new bac(".", 0, " "), new bac("", 10, "("), new bac("", 10, "."), new bac("", 0, " not "), new bac(" ", 0, "=\""), new bac("", 0, "er "), new bac(" ", 11, " "), new bac("", 0, "al "), new bac(" ", 11, ""), new bac("", 0, "='"), new bac("", 11, "\""), new bac("", 10, ". "), new bac(" ", 0, "("), new bac("", 0, "ful "), new bac(" ", 10, ". "), new bac("", 0, "ive "), new bac("", 0, "less "), new bac("", 11, "'"), new bac("", 0, "est "), new bac(" ", 10, "."), new bac("", 11, "\">"), new bac(" ", 0, "='"), new bac("", 10, ","), new bac("", 0, "ize "), new bac("", 11, "."), new bac("Â ", 0, ""), new bac(" ", 0, ","), new bac("", 10, "=\""), new bac("", 11, "=\""), new bac("", 0, "ous "), new bac("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new bac("", 10, "='"), new bac(" ", 10, ","), new bac(" ", 11, "=\""), new bac(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new bac("", 11, ","), new bac("", 11, "("), new bac("", 11, ". "), new bac(" ", 11, "."), new bac("", 11, "='"), new bac(" ", 11, ". "), new bac(" ", 10, "=\""), new bac(" ", 11, "='"), new bac(" ", 10, "='")};
    }

    public bac(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = a(str);
        this.b = i;
        this.c = a(str2);
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int length = str.length();
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) str.charAt(i);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, bac bacVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), bacVar})) == null) {
            int i4 = i;
            for (byte b : bacVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = bacVar.b;
            int a = dac.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - dac.b(i5);
            int i7 = b2;
            while (i7 > 0) {
                bArr[i4] = bArr2[i6];
                i7--;
                i4++;
                i6++;
            }
            if (i5 == 11 || i5 == 10) {
                int i8 = i4 - b2;
                if (i5 == 10) {
                    b2 = 1;
                }
                while (b2 > 0) {
                    int i9 = bArr[i8] & 255;
                    if (i9 < 192) {
                        if (i9 >= 97 && i9 <= 122) {
                            bArr[i8] = (byte) (bArr[i8] ^ 32);
                        }
                        i8++;
                        b2--;
                    } else if (i9 < 224) {
                        int i10 = i8 + 1;
                        bArr[i10] = (byte) (bArr[i10] ^ 32);
                        i8 += 2;
                        b2 -= 2;
                    } else {
                        int i11 = i8 + 2;
                        bArr[i11] = (byte) (bArr[i11] ^ 5);
                        i8 += 3;
                        b2 -= 3;
                    }
                }
            }
            for (byte b3 : bacVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
