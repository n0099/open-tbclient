package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
/* loaded from: classes4.dex */
public final class f00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public int b;
    public int c;
    public int d;
    public int e;
    public j00 f;
    public g00 g;
    public int h;
    public boolean i;

    public f00(c00 c00Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c00Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = 1;
        this.i = false;
        this.b = i;
        this.c = i;
        this.e = i;
        this.a = new byte[i * 2];
        this.g = new e00(c00Var);
        this.f = new i00(this.b);
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i2 = this.d + i;
            j00 j00Var = this.f;
            if (j00Var == null || this.i) {
                return i2;
            }
            int i3 = this.c;
            int i4 = this.b;
            if (i3 != i4) {
                int i5 = this.e;
                return i2 < i5 ? i5 : (i2 + i4) - ((i2 - i5) % i4);
            }
            return i2 + j00Var.a(i2);
        }
        return invokeI.intValue;
    }

    public int b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, ShortBufferException, BadPaddingException {
        InterceptResult invokeCommon;
        int a;
        byte[] bArr3;
        int i4;
        j00 j00Var;
        int c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3)})) == null) {
            int i5 = this.d + i2;
            int i6 = this.c;
            int i7 = this.b;
            if (i6 != i7) {
                int i8 = this.e;
                a = i5 < i8 ? i8 - i5 : i7 - ((i5 - i8) % i7);
            } else {
                j00 j00Var2 = this.f;
                a = j00Var2 != null ? j00Var2.a(i5) : 0;
            }
            if (a > 0 && a != this.b && this.f != null && this.i) {
                throw new IllegalBlockSizeException("Input length must be multiple of " + this.b + " when decrypting with padded cipher");
            }
            int i9 = (this.i || this.f == null) ? i5 : i5 + a;
            if (bArr2 != null) {
                int length = bArr2.length - i3;
                if (((!this.i || this.f == null) && length < i9) || (this.i && length < i9 - this.b)) {
                    throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i9 + " bytes needed");
                }
                if (this.d == 0 && (this.i || this.f == null)) {
                    bArr3 = bArr;
                    i4 = i;
                } else {
                    byte[] bArr4 = new byte[i9];
                    int i10 = this.d;
                    if (i10 != 0) {
                        System.arraycopy(this.a, 0, bArr4, 0, i10);
                    }
                    if (i2 != 0) {
                        System.arraycopy(bArr, i, bArr4, this.d, i2);
                    }
                    if (!this.i && (j00Var = this.f) != null) {
                        j00Var.b(bArr4, i5, a);
                    }
                    bArr3 = bArr4;
                    i4 = 0;
                }
                if (this.i) {
                    if (length < i9) {
                        this.g.h();
                    }
                    byte[] bArr5 = new byte[i5];
                    c = c(bArr3, i4, bArr5, 0, i5);
                    j00 j00Var3 = this.f;
                    if (j00Var3 != null && (c = j00Var3.a(bArr5, 0, c)) < 0) {
                        throw new BadPaddingException("Given final block not properly padded");
                    }
                    if (bArr2.length - i3 < c) {
                        this.g.g();
                        throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i3) + " bytes given, " + c + " bytes needed");
                    }
                    for (int i11 = 0; i11 < c; i11++) {
                        bArr2[i3 + i11] = bArr5[i11];
                    }
                } else {
                    c = c(bArr3, i4, bArr2, i3, i9);
                }
                this.d = 0;
                this.e = this.b;
                if (this.h != 0) {
                    this.g.f();
                }
                return c;
            }
            throw new ShortBufferException("Output buffer is null");
        }
        return invokeCommon.intValue;
    }

    public final int c(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws IllegalBlockSizeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (bArr == null || i3 == 0) {
                return 0;
            }
            int i4 = this.h;
            if (i4 == 2 || i4 == 3 || i3 % this.c == 0 || i4 == 6) {
                if (this.i) {
                    this.g.c(bArr, i, i3, bArr2, i2);
                } else {
                    this.g.e(bArr, i, i3, bArr2, i2);
                }
                return i3;
            } else if (this.f != null) {
                throw new IllegalBlockSizeException("Input length (with padding) not multiple of " + this.c + " bytes");
            } else {
                throw new IllegalBlockSizeException("Input length not multiple of " + this.c + " bytes");
            }
        }
        return invokeCommon.intValue;
    }

    public void d(int i, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), bArr, bArr2, secureRandom}) == null) {
            boolean z = i == 2 || i == 4;
            this.i = z;
            if (this.h == 0) {
                if (bArr2 != null) {
                    throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
                }
            } else if (bArr2 == null) {
                if (z) {
                    throw new InvalidAlgorithmParameterException("Parameters missing");
                }
                if (secureRandom == null) {
                    secureRandom = d00.b;
                }
                bArr2 = new byte[this.b];
                secureRandom.nextBytes(bArr2);
            }
            this.d = 0;
            this.e = this.b;
            this.g.a(this.i, "", bArr, bArr2);
        }
    }

    public byte[] e(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i, i2)) == null) {
            try {
                int a = a(i2);
                byte[] bArr2 = new byte[a];
                int b = b(bArr, i, i2, bArr2, 0);
                if (b < a) {
                    byte[] bArr3 = new byte[b];
                    if (b != 0) {
                        try {
                            System.arraycopy(bArr2, 0, bArr3, 0, b);
                        } catch (ShortBufferException unused) {
                        }
                    }
                    return bArr3;
                }
                return bArr2;
            } catch (ShortBufferException unused2) {
                return null;
            }
        }
        return (byte[]) invokeLII.objValue;
    }
}
