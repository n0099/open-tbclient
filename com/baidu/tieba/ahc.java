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
public final class ahc {
    public static /* synthetic */ Interceptable $ic;
    public static final ahc[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947616621, "Lcom/baidu/tieba/ahc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947616621, "Lcom/baidu/tieba/ahc;");
                return;
            }
        }
        d = new ahc[]{new ahc("", 0, ""), new ahc("", 0, " "), new ahc(" ", 0, " "), new ahc("", 12, ""), new ahc("", 10, " "), new ahc("", 0, " the "), new ahc(" ", 0, ""), new ahc("s ", 0, " "), new ahc("", 0, " of "), new ahc("", 10, ""), new ahc("", 0, " and "), new ahc("", 13, ""), new ahc("", 1, ""), new ahc(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new ahc("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ahc(" ", 10, " "), new ahc("", 0, " in "), new ahc("", 0, " to "), new ahc("e ", 0, " "), new ahc("", 0, "\""), new ahc("", 0, "."), new ahc("", 0, "\">"), new ahc("", 0, "\n"), new ahc("", 3, ""), new ahc("", 0, PreferencesUtil.RIGHT_MOUNT), new ahc("", 0, " for "), new ahc("", 14, ""), new ahc("", 2, ""), new ahc("", 0, " a "), new ahc("", 0, " that "), new ahc(" ", 10, ""), new ahc("", 0, ". "), new ahc(".", 0, ""), new ahc(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ahc("", 15, ""), new ahc("", 0, " with "), new ahc("", 0, "'"), new ahc("", 0, " from "), new ahc("", 0, " by "), new ahc("", 16, ""), new ahc("", 17, ""), new ahc(" the ", 0, ""), new ahc("", 4, ""), new ahc("", 0, ". The "), new ahc("", 11, ""), new ahc("", 0, " on "), new ahc("", 0, " as "), new ahc("", 0, " is "), new ahc("", 7, ""), new ahc("", 1, "ing "), new ahc("", 0, "\n\t"), new ahc("", 0, ":"), new ahc(" ", 0, ". "), new ahc("", 0, "ed "), new ahc("", 20, ""), new ahc("", 18, ""), new ahc("", 6, ""), new ahc("", 0, "("), new ahc("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ahc("", 8, ""), new ahc("", 0, " at "), new ahc("", 0, "ly "), new ahc(" the ", 0, " of "), new ahc("", 5, ""), new ahc("", 9, ""), new ahc(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ahc("", 10, "\""), new ahc(".", 0, "("), new ahc("", 11, " "), new ahc("", 10, "\">"), new ahc("", 0, "=\""), new ahc(" ", 0, "."), new ahc(".com/", 0, ""), new ahc(" the ", 0, " of the "), new ahc("", 10, "'"), new ahc("", 0, ". This "), new ahc("", 0, ","), new ahc(".", 0, " "), new ahc("", 10, "("), new ahc("", 10, "."), new ahc("", 0, " not "), new ahc(" ", 0, "=\""), new ahc("", 0, "er "), new ahc(" ", 11, " "), new ahc("", 0, "al "), new ahc(" ", 11, ""), new ahc("", 0, "='"), new ahc("", 11, "\""), new ahc("", 10, ". "), new ahc(" ", 0, "("), new ahc("", 0, "ful "), new ahc(" ", 10, ". "), new ahc("", 0, "ive "), new ahc("", 0, "less "), new ahc("", 11, "'"), new ahc("", 0, "est "), new ahc(" ", 10, "."), new ahc("", 11, "\">"), new ahc(" ", 0, "='"), new ahc("", 10, ","), new ahc("", 0, "ize "), new ahc("", 11, "."), new ahc("Â ", 0, ""), new ahc(" ", 0, ","), new ahc("", 10, "=\""), new ahc("", 11, "=\""), new ahc("", 0, "ous "), new ahc("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ahc("", 10, "='"), new ahc(" ", 10, ","), new ahc(" ", 11, "=\""), new ahc(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ahc("", 11, ","), new ahc("", 11, "("), new ahc("", 11, ". "), new ahc(" ", 11, "."), new ahc("", 11, "='"), new ahc(" ", 11, ". "), new ahc(" ", 10, "=\""), new ahc(" ", 11, "='"), new ahc(" ", 10, "='")};
    }

    public ahc(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, ahc ahcVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), ahcVar})) == null) {
            int i4 = i;
            for (byte b : ahcVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = ahcVar.b;
            int a = chc.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - chc.b(i5);
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
            for (byte b3 : ahcVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
