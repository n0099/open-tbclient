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
/* loaded from: classes3.dex */
public final class c0b {
    public static /* synthetic */ Interceptable $ic;
    public static final c0b[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947622356, "Lcom/baidu/tieba/c0b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947622356, "Lcom/baidu/tieba/c0b;");
                return;
            }
        }
        d = new c0b[]{new c0b("", 0, ""), new c0b("", 0, " "), new c0b(" ", 0, " "), new c0b("", 12, ""), new c0b("", 10, " "), new c0b("", 0, " the "), new c0b(" ", 0, ""), new c0b("s ", 0, " "), new c0b("", 0, " of "), new c0b("", 10, ""), new c0b("", 0, " and "), new c0b("", 13, ""), new c0b("", 1, ""), new c0b(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new c0b("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new c0b(" ", 10, " "), new c0b("", 0, " in "), new c0b("", 0, " to "), new c0b("e ", 0, " "), new c0b("", 0, "\""), new c0b("", 0, "."), new c0b("", 0, "\">"), new c0b("", 0, "\n"), new c0b("", 3, ""), new c0b("", 0, PreferencesUtil.RIGHT_MOUNT), new c0b("", 0, " for "), new c0b("", 14, ""), new c0b("", 2, ""), new c0b("", 0, " a "), new c0b("", 0, " that "), new c0b(" ", 10, ""), new c0b("", 0, ". "), new c0b(".", 0, ""), new c0b(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new c0b("", 15, ""), new c0b("", 0, " with "), new c0b("", 0, "'"), new c0b("", 0, " from "), new c0b("", 0, " by "), new c0b("", 16, ""), new c0b("", 17, ""), new c0b(" the ", 0, ""), new c0b("", 4, ""), new c0b("", 0, ". The "), new c0b("", 11, ""), new c0b("", 0, " on "), new c0b("", 0, " as "), new c0b("", 0, " is "), new c0b("", 7, ""), new c0b("", 1, "ing "), new c0b("", 0, "\n\t"), new c0b("", 0, ":"), new c0b(" ", 0, ". "), new c0b("", 0, "ed "), new c0b("", 20, ""), new c0b("", 18, ""), new c0b("", 6, ""), new c0b("", 0, "("), new c0b("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new c0b("", 8, ""), new c0b("", 0, " at "), new c0b("", 0, "ly "), new c0b(" the ", 0, " of "), new c0b("", 5, ""), new c0b("", 9, ""), new c0b(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new c0b("", 10, "\""), new c0b(".", 0, "("), new c0b("", 11, " "), new c0b("", 10, "\">"), new c0b("", 0, "=\""), new c0b(" ", 0, "."), new c0b(".com/", 0, ""), new c0b(" the ", 0, " of the "), new c0b("", 10, "'"), new c0b("", 0, ". This "), new c0b("", 0, ","), new c0b(".", 0, " "), new c0b("", 10, "("), new c0b("", 10, "."), new c0b("", 0, " not "), new c0b(" ", 0, "=\""), new c0b("", 0, "er "), new c0b(" ", 11, " "), new c0b("", 0, "al "), new c0b(" ", 11, ""), new c0b("", 0, "='"), new c0b("", 11, "\""), new c0b("", 10, ". "), new c0b(" ", 0, "("), new c0b("", 0, "ful "), new c0b(" ", 10, ". "), new c0b("", 0, "ive "), new c0b("", 0, "less "), new c0b("", 11, "'"), new c0b("", 0, "est "), new c0b(" ", 10, "."), new c0b("", 11, "\">"), new c0b(" ", 0, "='"), new c0b("", 10, ","), new c0b("", 0, "ize "), new c0b("", 11, "."), new c0b("Â ", 0, ""), new c0b(" ", 0, ","), new c0b("", 10, "=\""), new c0b("", 11, "=\""), new c0b("", 0, "ous "), new c0b("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new c0b("", 10, "='"), new c0b(" ", 10, ","), new c0b(" ", 11, "=\""), new c0b(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new c0b("", 11, ","), new c0b("", 11, "("), new c0b("", 11, ". "), new c0b(" ", 11, "."), new c0b("", 11, "='"), new c0b(" ", 11, ". "), new c0b(" ", 10, "=\""), new c0b(" ", 11, "='"), new c0b(" ", 10, "='")};
    }

    public c0b(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, c0b c0bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), c0bVar})) == null) {
            int i4 = i;
            for (byte b : c0bVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = c0bVar.b;
            int a = e0b.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - e0b.b(i5);
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
            for (byte b3 : c0bVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
