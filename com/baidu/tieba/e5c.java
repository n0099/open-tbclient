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
public final class e5c {
    public static /* synthetic */ Interceptable $ic;
    public static final e5c[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947686774, "Lcom/baidu/tieba/e5c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947686774, "Lcom/baidu/tieba/e5c;");
                return;
            }
        }
        d = new e5c[]{new e5c("", 0, ""), new e5c("", 0, " "), new e5c(" ", 0, " "), new e5c("", 12, ""), new e5c("", 10, " "), new e5c("", 0, " the "), new e5c(" ", 0, ""), new e5c("s ", 0, " "), new e5c("", 0, " of "), new e5c("", 10, ""), new e5c("", 0, " and "), new e5c("", 13, ""), new e5c("", 1, ""), new e5c(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new e5c("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new e5c(" ", 10, " "), new e5c("", 0, " in "), new e5c("", 0, " to "), new e5c("e ", 0, " "), new e5c("", 0, "\""), new e5c("", 0, "."), new e5c("", 0, "\">"), new e5c("", 0, "\n"), new e5c("", 3, ""), new e5c("", 0, PreferencesUtil.RIGHT_MOUNT), new e5c("", 0, " for "), new e5c("", 14, ""), new e5c("", 2, ""), new e5c("", 0, " a "), new e5c("", 0, " that "), new e5c(" ", 10, ""), new e5c("", 0, ". "), new e5c(".", 0, ""), new e5c(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new e5c("", 15, ""), new e5c("", 0, " with "), new e5c("", 0, "'"), new e5c("", 0, " from "), new e5c("", 0, " by "), new e5c("", 16, ""), new e5c("", 17, ""), new e5c(" the ", 0, ""), new e5c("", 4, ""), new e5c("", 0, ". The "), new e5c("", 11, ""), new e5c("", 0, " on "), new e5c("", 0, " as "), new e5c("", 0, " is "), new e5c("", 7, ""), new e5c("", 1, "ing "), new e5c("", 0, "\n\t"), new e5c("", 0, ":"), new e5c(" ", 0, ". "), new e5c("", 0, "ed "), new e5c("", 20, ""), new e5c("", 18, ""), new e5c("", 6, ""), new e5c("", 0, "("), new e5c("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new e5c("", 8, ""), new e5c("", 0, " at "), new e5c("", 0, "ly "), new e5c(" the ", 0, " of "), new e5c("", 5, ""), new e5c("", 9, ""), new e5c(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new e5c("", 10, "\""), new e5c(".", 0, "("), new e5c("", 11, " "), new e5c("", 10, "\">"), new e5c("", 0, "=\""), new e5c(" ", 0, "."), new e5c(".com/", 0, ""), new e5c(" the ", 0, " of the "), new e5c("", 10, "'"), new e5c("", 0, ". This "), new e5c("", 0, ","), new e5c(".", 0, " "), new e5c("", 10, "("), new e5c("", 10, "."), new e5c("", 0, " not "), new e5c(" ", 0, "=\""), new e5c("", 0, "er "), new e5c(" ", 11, " "), new e5c("", 0, "al "), new e5c(" ", 11, ""), new e5c("", 0, "='"), new e5c("", 11, "\""), new e5c("", 10, ". "), new e5c(" ", 0, "("), new e5c("", 0, "ful "), new e5c(" ", 10, ". "), new e5c("", 0, "ive "), new e5c("", 0, "less "), new e5c("", 11, "'"), new e5c("", 0, "est "), new e5c(" ", 10, "."), new e5c("", 11, "\">"), new e5c(" ", 0, "='"), new e5c("", 10, ","), new e5c("", 0, "ize "), new e5c("", 11, "."), new e5c("Â ", 0, ""), new e5c(" ", 0, ","), new e5c("", 10, "=\""), new e5c("", 11, "=\""), new e5c("", 0, "ous "), new e5c("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new e5c("", 10, "='"), new e5c(" ", 10, ","), new e5c(" ", 11, "=\""), new e5c(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new e5c("", 11, ","), new e5c("", 11, "("), new e5c("", 11, ". "), new e5c(" ", 11, "."), new e5c("", 11, "='"), new e5c(" ", 11, ". "), new e5c(" ", 10, "=\""), new e5c(" ", 11, "='"), new e5c(" ", 10, "='")};
    }

    public e5c(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, e5c e5cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), e5cVar})) == null) {
            int i4 = i;
            for (byte b : e5cVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = e5cVar.b;
            int a = g5c.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - g5c.b(i5);
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
            for (byte b3 : e5cVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
