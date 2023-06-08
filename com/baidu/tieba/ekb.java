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
public final class ekb {
    public static /* synthetic */ Interceptable $ic;
    public static final ekb[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int b;
    public final byte[] c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947738637, "Lcom/baidu/tieba/ekb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947738637, "Lcom/baidu/tieba/ekb;");
                return;
            }
        }
        d = new ekb[]{new ekb("", 0, ""), new ekb("", 0, " "), new ekb(" ", 0, " "), new ekb("", 12, ""), new ekb("", 10, " "), new ekb("", 0, " the "), new ekb(" ", 0, ""), new ekb("s ", 0, " "), new ekb("", 0, " of "), new ekb("", 10, ""), new ekb("", 0, " and "), new ekb("", 13, ""), new ekb("", 1, ""), new ekb(StringUtil.ARRAY_ELEMENT_SEPARATOR, 0, " "), new ekb("", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ekb(" ", 10, " "), new ekb("", 0, " in "), new ekb("", 0, " to "), new ekb("e ", 0, " "), new ekb("", 0, "\""), new ekb("", 0, "."), new ekb("", 0, "\">"), new ekb("", 0, "\n"), new ekb("", 3, ""), new ekb("", 0, PreferencesUtil.RIGHT_MOUNT), new ekb("", 0, " for "), new ekb("", 14, ""), new ekb("", 2, ""), new ekb("", 0, " a "), new ekb("", 0, " that "), new ekb(" ", 10, ""), new ekb("", 0, ". "), new ekb(".", 0, ""), new ekb(" ", 0, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ekb("", 15, ""), new ekb("", 0, " with "), new ekb("", 0, "'"), new ekb("", 0, " from "), new ekb("", 0, " by "), new ekb("", 16, ""), new ekb("", 17, ""), new ekb(" the ", 0, ""), new ekb("", 4, ""), new ekb("", 0, ". The "), new ekb("", 11, ""), new ekb("", 0, " on "), new ekb("", 0, " as "), new ekb("", 0, " is "), new ekb("", 7, ""), new ekb("", 1, "ing "), new ekb("", 0, "\n\t"), new ekb("", 0, ":"), new ekb(" ", 0, ". "), new ekb("", 0, "ed "), new ekb("", 20, ""), new ekb("", 18, ""), new ekb("", 6, ""), new ekb("", 0, "("), new ekb("", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ekb("", 8, ""), new ekb("", 0, " at "), new ekb("", 0, "ly "), new ekb(" the ", 0, " of "), new ekb("", 5, ""), new ekb("", 9, ""), new ekb(" ", 10, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ekb("", 10, "\""), new ekb(".", 0, "("), new ekb("", 11, " "), new ekb("", 10, "\">"), new ekb("", 0, "=\""), new ekb(" ", 0, "."), new ekb(".com/", 0, ""), new ekb(" the ", 0, " of the "), new ekb("", 10, "'"), new ekb("", 0, ". This "), new ekb("", 0, ","), new ekb(".", 0, " "), new ekb("", 10, "("), new ekb("", 10, "."), new ekb("", 0, " not "), new ekb(" ", 0, "=\""), new ekb("", 0, "er "), new ekb(" ", 11, " "), new ekb("", 0, "al "), new ekb(" ", 11, ""), new ekb("", 0, "='"), new ekb("", 11, "\""), new ekb("", 10, ". "), new ekb(" ", 0, "("), new ekb("", 0, "ful "), new ekb(" ", 10, ". "), new ekb("", 0, "ive "), new ekb("", 0, "less "), new ekb("", 11, "'"), new ekb("", 0, "est "), new ekb(" ", 10, "."), new ekb("", 11, "\">"), new ekb(" ", 0, "='"), new ekb("", 10, ","), new ekb("", 0, "ize "), new ekb("", 11, "."), new ekb("Â ", 0, ""), new ekb(" ", 0, ","), new ekb("", 10, "=\""), new ekb("", 11, "=\""), new ekb("", 0, "ous "), new ekb("", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ekb("", 10, "='"), new ekb(" ", 10, ","), new ekb(" ", 11, "=\""), new ekb(" ", 11, StringUtil.ARRAY_ELEMENT_SEPARATOR), new ekb("", 11, ","), new ekb("", 11, "("), new ekb("", 11, ". "), new ekb(" ", 11, "."), new ekb("", 11, "='"), new ekb(" ", 11, ". "), new ekb(" ", 10, "=\""), new ekb(" ", 11, "='"), new ekb(" ", 10, "='")};
    }

    public ekb(String str, int i, String str2) {
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

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3, ekb ekbVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3), ekbVar})) == null) {
            int i4 = i;
            for (byte b : ekbVar.a) {
                bArr[i4] = b;
                i4++;
            }
            int i5 = ekbVar.b;
            int a = gkb.a(i5);
            if (a > i3) {
                a = i3;
            }
            int i6 = i2 + a;
            int b2 = (i3 - a) - gkb.b(i5);
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
            for (byte b3 : ekbVar.c) {
                bArr[i4] = b3;
                i4++;
            }
            return i4 - i;
        }
        return invokeCommon.intValue;
    }
}
