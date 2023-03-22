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
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
/* loaded from: classes3.dex */
public final class a00 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, byte[]> h;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public SecureRandom c;
    public final int d;
    public MessageDigest e;
    public MessageDigest f;
    public byte[] g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947561224, "Lcom/baidu/tieba/a00;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947561224, "Lcom/baidu/tieba/a00;");
                return;
            }
        }
        h = Collections.synchronizedMap(new HashMap());
    }

    public a00(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), secureRandom, oAEPParameterSpec};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = i2;
        this.c = secureRandom;
        if (i2 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        if (i == 1 || i == 2) {
            i2 -= 11;
        } else if (i != 3) {
            if (i != 4) {
                throw new InvalidKeyException("Invalid padding: " + i);
            }
            byte[] bArr = null;
            String str2 = "SHA-1";
            if (oAEPParameterSpec != null) {
                try {
                    str2 = oAEPParameterSpec.getDigestAlgorithm();
                    String mGFAlgorithm = oAEPParameterSpec.getMGFAlgorithm();
                    if (!mGFAlgorithm.equalsIgnoreCase("MGF1")) {
                        throw new InvalidAlgorithmParameterException("Unsupported MGF algo: " + mGFAlgorithm);
                    }
                    String digestAlgorithm = ((MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters()).getDigestAlgorithm();
                    PSource pSource = oAEPParameterSpec.getPSource();
                    String algorithm = pSource.getAlgorithm();
                    if (!algorithm.equalsIgnoreCase("PSpecified")) {
                        throw new InvalidAlgorithmParameterException("Unsupported pSource algo: " + algorithm);
                    }
                    byte[] value = ((PSource.PSpecified) pSource).getValue();
                    str = digestAlgorithm;
                    bArr = value;
                } catch (NoSuchAlgorithmException e) {
                    throw new InvalidKeyException("Digest SHA-1 not available", e);
                }
            } else {
                str = "SHA-1";
            }
            this.e = MessageDigest.getInstance(str2);
            this.f = MessageDigest.getInstance(str);
            byte[] e2 = e(this.e, bArr);
            this.g = e2;
            int length = (i2 - 2) - (e2.length * 2);
            this.d = length;
            if (length > 0) {
                return;
            }
            throw new InvalidKeyException("Key is too short for encryption using OAEPPadding with " + str2 + " and MGF1" + str);
        }
        this.d = i2;
    }

    public static a00 b(int i, int i2, SecureRandom secureRandom) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i, i2, secureRandom)) == null) ? new a00(i, i2, secureRandom, null) : (a00) invokeIIL.objValue;
    }

    public static a00 c(int i, int i2, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), secureRandom, oAEPParameterSpec})) == null) ? new a00(i, i2, secureRandom, oAEPParameterSpec) : (a00) invokeCommon.objValue;
    }

    public static byte[] e(MessageDigest messageDigest, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, messageDigest, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                String algorithm = messageDigest.getAlgorithm();
                byte[] bArr2 = h.get(algorithm);
                if (bArr2 == null) {
                    byte[] digest = messageDigest.digest();
                    h.put(algorithm, digest);
                    return digest;
                }
                return bArr2;
            }
            return messageDigest.digest(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : invokeV.intValue;
    }

    public final void d(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            byte[] bArr3 = new byte[4];
            byte[] bArr4 = new byte[20];
            while (i4 > 0) {
                this.f.update(bArr, i, i2);
                this.f.update(bArr3);
                try {
                    this.f.digest(bArr4, 0, 20);
                    for (int i6 = 0; i6 < 20 && i4 > 0; i6++) {
                        bArr2[i3] = (byte) (bArr4[i6] ^ bArr2[i3]);
                        i4--;
                        i3++;
                    }
                    if (i4 > 0) {
                        while (true) {
                            byte b = (byte) (bArr3[i5] + 1);
                            bArr3[i5] = b;
                            i5 = (b == 0 && i5 > 0) ? i5 - 1 : 3;
                        }
                    }
                } catch (DigestException e) {
                    throw new BadPaddingException(e.toString());
                }
            }
        }
    }

    public byte[] f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            if (bArr.length > this.d) {
                throw new BadPaddingException("Data must be shorter than " + (this.d + 1) + " bytes");
            }
            int i = this.a;
            if (i == 1 || i == 2) {
                return i(bArr);
            }
            if (i != 3) {
                if (i == 4) {
                    return k(bArr);
                }
                throw new AssertionError();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] g(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) ? f(wz.d(bArr, i, i2)) : (byte[]) invokeLII.objValue;
    }

    public byte[] h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            if (bArr.length != this.b) {
                throw new BadPaddingException("Padded length must be " + this.b);
            }
            int i = this.a;
            if (i == 1 || i == 2) {
                return j(bArr);
            }
            if (i != 3) {
                if (i == 4) {
                    return l(bArr);
                }
                throw new AssertionError();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] i(byte[] bArr) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) {
            int i3 = this.b;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, i3 - bArr.length, bArr.length);
            int length = (this.b - 3) - bArr.length;
            bArr2[0] = 0;
            int i4 = this.a;
            bArr2[1] = (byte) i4;
            int i5 = -1;
            int i6 = 2;
            if (i4 != 1) {
                if (this.c == null) {
                    this.c = wz.a;
                }
                byte[] bArr3 = new byte[64];
                while (true) {
                    int i7 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    while (true) {
                        if (i5 < 0) {
                            this.c.nextBytes(bArr3);
                            i5 = 63;
                        }
                        i = i5 - 1;
                        i2 = bArr3[i5] & 255;
                        if (i2 != 0) {
                            break;
                        }
                        i5 = i;
                    }
                    bArr2[i6] = (byte) i2;
                    i5 = i;
                    length = i7;
                    i6++;
                }
            } else {
                while (true) {
                    int i8 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    bArr2[i6] = -1;
                    i6++;
                    length = i8;
                }
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] j(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048582, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i = 2;
        if (bArr[1] != this.a) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        while (true) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i3 == 0) {
                int length = bArr.length - i2;
                if (length <= this.d) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string too short");
            } else if (i2 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            } else {
                if (this.a == 1 && i3 != 255) {
                    throw new BadPaddingException("Padding byte not 0xff: " + i3);
                }
                i = i2;
            }
        }
    }

    public final byte[] k(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) {
            if (this.c == null) {
                this.c = wz.a;
            }
            int length = this.g.length;
            byte[] bArr2 = new byte[length];
            this.c.nextBytes(bArr2);
            int i = this.b;
            byte[] bArr3 = new byte[i];
            System.arraycopy(bArr2, 0, bArr3, 1, length);
            int i2 = length + 1;
            int i3 = i - i2;
            int length2 = this.b - bArr.length;
            System.arraycopy(this.g, 0, bArr3, i2, length);
            bArr3[length2 - 1] = 1;
            System.arraycopy(bArr, 0, bArr3, length2, bArr.length);
            d(bArr3, 1, length, bArr3, i2, i3);
            d(bArr3, i2, i3, bArr3, 1, length);
            return bArr3;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] l(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr)) == null) {
            int length = this.g.length;
            if (bArr[0] == 0) {
                int i = length + 1;
                int length2 = bArr.length - i;
                d(bArr, i, length2, bArr, 1, length);
                d(bArr, 1, length, bArr, i, length2);
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.g[i2] != bArr[i + i2]) {
                        throw new BadPaddingException("lHash mismatch");
                    }
                }
                int i3 = i + length;
                while (bArr[i3] == 0) {
                    i3++;
                    if (i3 >= bArr.length) {
                        throw new BadPaddingException("Padding string not terminated");
                    }
                }
                int i4 = i3 + 1;
                if (bArr[i3] == 1) {
                    int length3 = bArr.length - i4;
                    byte[] bArr2 = new byte[length3];
                    System.arraycopy(bArr, i4, bArr2, 0, length3);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string not terminated by 0x01 byte");
            }
            throw new BadPaddingException("Data must start with zero");
        }
        return (byte[]) invokeL.objValue;
    }
}
