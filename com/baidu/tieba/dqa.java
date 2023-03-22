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
/* loaded from: classes4.dex */
public final class dqa {
    public static /* synthetic */ Interceptable $ic;
    public static final dqa[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947714581, "Lcom/baidu/tieba/dqa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947714581, "Lcom/baidu/tieba/dqa;");
                return;
            }
        }
        d = new dqa[]{new dqa("", 0, ""), new dqa("", 0, " "), new dqa(" ", 0, " "), new dqa("", 12, ""), new dqa("", 10, " "), new dqa("", 0, " the "), new dqa(" ", 0, ""), new dqa("s ", 0, " "), new dqa("", 0, " of "), new dqa("", 10, ""), new dqa("", 0, " and "), new dqa("", 13, ""), new dqa("", 1, ""), new dqa(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new dqa("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new dqa(" ", 10, " "), new dqa("", 0, " in "), new dqa("", 0, " to "), new dqa("e ", 0, " "), new dqa("", 0, "\""), new dqa("", 0, "."), new dqa("", 0, "\">"), new dqa("", 0, "\n"), new dqa("", 3, ""), new dqa("", 0, PreferencesUtil.RIGHT_MOUNT), new dqa("", 0, " for "), new dqa("", 14, ""), new dqa("", 2, ""), new dqa("", 0, " a "), new dqa("", 0, " that "), new dqa(" ", 10, ""), new dqa("", 0, ". "), new dqa(".", 0, ""), new dqa(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new dqa("", 15, ""), new dqa("", 0, " with "), new dqa("", 0, "'"), new dqa("", 0, " from "), new dqa("", 0, " by "), new dqa("", 16, ""), new dqa("", 17, ""), new dqa(" the ", 0, ""), new dqa("", 4, ""), new dqa("", 0, ". The "), new dqa("", 11, ""), new dqa("", 0, " on "), new dqa("", 0, " as "), new dqa("", 0, " is "), new dqa("", 7, ""), new dqa("", 1, "ing "), new dqa("", 0, "\n\t"), new dqa("", 0, ":"), new dqa(" ", 0, ". "), new dqa("", 0, "ed "), new dqa("", 20, ""), new dqa("", 18, ""), new dqa("", 6, ""), new dqa("", 0, "("), new dqa("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new dqa("", 8, ""), new dqa("", 0, " at "), new dqa("", 0, "ly "), new dqa(" the ", 0, " of "), new dqa("", 5, ""), new dqa("", 9, ""), new dqa(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new dqa("", 10, "\""), new dqa(".", 0, "("), new dqa("", 11, " "), new dqa("", 10, "\">"), new dqa("", 0, "=\""), new dqa(" ", 0, "."), new dqa(".com/", 0, ""), new dqa(" the ", 0, " of the "), new dqa("", 10, "'"), new dqa("", 0, ". This "), new dqa("", 0, ","), new dqa(".", 0, " "), new dqa("", 10, "("), new dqa("", 10, "."), new dqa("", 0, " not "), new dqa(" ", 0, "=\""), new dqa("", 0, "er "), new dqa(" ", 11, " "), new dqa("", 0, "al "), new dqa(" ", 11, ""), new dqa("", 0, "='"), new dqa("", 11, "\""), new dqa("", 10, ". "), new dqa(" ", 0, "("), new dqa("", 0, "ful "), new dqa(" ", 10, ". "), new dqa("", 0, "ive "), new dqa("", 0, "less "), new dqa("", 11, "'"), new dqa("", 0, "est "), new dqa(" ", 10, "."), new dqa("", 11, "\">"), new dqa(" ", 0, "='"), new dqa("", 10, ","), new dqa("", 0, "ize "), new dqa("", 11, "."), new dqa("Â ", 0, ""), new dqa(" ", 0, ","), new dqa("", 10, "=\""), new dqa("", 11, "=\""), new dqa("", 0, "ous "), new dqa("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new dqa("", 10, "='"), new dqa(" ", 10, ","), new dqa(" ", 11, "=\""), new dqa(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new dqa("", 11, ","), new dqa("", 11, "("), new dqa("", 11, ". "), new dqa(" ", 11, "."), new dqa("", 11, "='"), new dqa(" ", 11, ". "), new dqa(" ", 10, "=\""), new dqa(" ", 11, "='"), new dqa(" ", 10, "='")};
    }

    public dqa(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, dqa dqaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), dqaVar})) == null) {
            int i4 = i;
            for (byte b : dqaVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = dqaVar.b;
            int a = fqa.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - fqa.b(i5);
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
            for (byte b3 : dqaVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
