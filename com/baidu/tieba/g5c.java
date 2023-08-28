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
/* loaded from: classes6.dex */
public final class g5c {
    public static /* synthetic */ Interceptable $ic;
    public static final g5c[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746356, "Lcom/baidu/tieba/g5c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746356, "Lcom/baidu/tieba/g5c;");
                return;
            }
        }
        d = new g5c[]{new g5c("", 0, ""), new g5c("", 0, " "), new g5c(" ", 0, " "), new g5c("", 12, ""), new g5c("", 10, " "), new g5c("", 0, " the "), new g5c(" ", 0, ""), new g5c("s ", 0, " "), new g5c("", 0, " of "), new g5c("", 10, ""), new g5c("", 0, " and "), new g5c("", 13, ""), new g5c("", 1, ""), new g5c(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new g5c("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new g5c(" ", 10, " "), new g5c("", 0, " in "), new g5c("", 0, " to "), new g5c("e ", 0, " "), new g5c("", 0, "\""), new g5c("", 0, "."), new g5c("", 0, "\">"), new g5c("", 0, "\n"), new g5c("", 3, ""), new g5c("", 0, PreferencesUtil.RIGHT_MOUNT), new g5c("", 0, " for "), new g5c("", 14, ""), new g5c("", 2, ""), new g5c("", 0, " a "), new g5c("", 0, " that "), new g5c(" ", 10, ""), new g5c("", 0, ". "), new g5c(".", 0, ""), new g5c(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new g5c("", 15, ""), new g5c("", 0, " with "), new g5c("", 0, "'"), new g5c("", 0, " from "), new g5c("", 0, " by "), new g5c("", 16, ""), new g5c("", 17, ""), new g5c(" the ", 0, ""), new g5c("", 4, ""), new g5c("", 0, ". The "), new g5c("", 11, ""), new g5c("", 0, " on "), new g5c("", 0, " as "), new g5c("", 0, " is "), new g5c("", 7, ""), new g5c("", 1, "ing "), new g5c("", 0, "\n\t"), new g5c("", 0, ":"), new g5c(" ", 0, ". "), new g5c("", 0, "ed "), new g5c("", 20, ""), new g5c("", 18, ""), new g5c("", 6, ""), new g5c("", 0, "("), new g5c("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new g5c("", 8, ""), new g5c("", 0, " at "), new g5c("", 0, "ly "), new g5c(" the ", 0, " of "), new g5c("", 5, ""), new g5c("", 9, ""), new g5c(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new g5c("", 10, "\""), new g5c(".", 0, "("), new g5c("", 11, " "), new g5c("", 10, "\">"), new g5c("", 0, "=\""), new g5c(" ", 0, "."), new g5c(".com/", 0, ""), new g5c(" the ", 0, " of the "), new g5c("", 10, "'"), new g5c("", 0, ". This "), new g5c("", 0, ","), new g5c(".", 0, " "), new g5c("", 10, "("), new g5c("", 10, "."), new g5c("", 0, " not "), new g5c(" ", 0, "=\""), new g5c("", 0, "er "), new g5c(" ", 11, " "), new g5c("", 0, "al "), new g5c(" ", 11, ""), new g5c("", 0, "='"), new g5c("", 11, "\""), new g5c("", 10, ". "), new g5c(" ", 0, "("), new g5c("", 0, "ful "), new g5c(" ", 10, ". "), new g5c("", 0, "ive "), new g5c("", 0, "less "), new g5c("", 11, "'"), new g5c("", 0, "est "), new g5c(" ", 10, "."), new g5c("", 11, "\">"), new g5c(" ", 0, "='"), new g5c("", 10, ","), new g5c("", 0, "ize "), new g5c("", 11, "."), new g5c("Â ", 0, ""), new g5c(" ", 0, ","), new g5c("", 10, "=\""), new g5c("", 11, "=\""), new g5c("", 0, "ous "), new g5c("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new g5c("", 10, "='"), new g5c(" ", 10, ","), new g5c(" ", 11, "=\""), new g5c(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new g5c("", 11, ","), new g5c("", 11, "("), new g5c("", 11, ". "), new g5c(" ", 11, "."), new g5c("", 11, "='"), new g5c(" ", 11, ". "), new g5c(" ", 10, "=\""), new g5c(" ", 11, "='"), new g5c(" ", 10, "='")};
    }

    public g5c(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, g5c g5cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), g5cVar})) == null) {
            int i4 = i;
            for (byte b : g5cVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = g5cVar.b;
            int a = i5c.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - i5c.b(i5);
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
            for (byte b3 : g5cVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
