package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class eg1 extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public byte[] B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public int G;
    public int H;
    public short[] I;
    public byte[] J;
    public byte[] K;
    public byte[] L;
    public fg1 M;
    public int N;
    public dg1 O;
    public byte[] P;
    public InputStream a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public int[] g;
    public int[] h;
    public int[] i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public Bitmap x;
    public Bitmap y;
    public fg1 z;

    public eg1(byte[] bArr, dg1 dg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, dg1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = null;
        this.A = false;
        this.B = new byte[256];
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.G = 0;
        this.O = null;
        this.P = null;
        this.P = bArr;
        this.O = dg1Var;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x00c4 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v25, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        short s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i6 = this.r * this.s;
            byte[] bArr = this.L;
            if (bArr == null || bArr.length < i6) {
                this.L = new byte[i6];
            }
            if (this.I == null) {
                this.I = new short[4096];
            }
            if (this.J == null) {
                this.J = new byte[4096];
            }
            if (this.K == null) {
                this.K = new byte[4097];
            }
            int j = j();
            int i7 = 1 << j;
            int i8 = i7 + 1;
            int i9 = i7 + 2;
            int i10 = j + 1;
            int i11 = (1 << i10) - 1;
            for (int i12 = 0; i12 < i7; i12++) {
                this.I[i12] = 0;
                this.J[i12] = (byte) i12;
            }
            int i13 = i10;
            int i14 = i9;
            int i15 = i11;
            int i16 = -1;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i17 < i6) {
                if (i18 != 0) {
                    i = i10;
                    i2 = i8;
                    int i25 = i23;
                    i3 = i7;
                    i4 = i25;
                } else if (i19 >= i13) {
                    int i26 = i20 & i15;
                    i20 >>= i13;
                    i19 -= i13;
                    if (i26 > i14 || i26 == i8) {
                        break;
                    } else if (i26 == i7) {
                        i13 = i10;
                        i14 = i9;
                        i15 = i11;
                        i16 = -1;
                    } else if (i16 == -1) {
                        this.K[i18] = this.J[i26];
                        i16 = i26;
                        i23 = i16;
                        i18++;
                        i10 = i10;
                    } else {
                        i = i10;
                        if (i26 == i14) {
                            i5 = i26;
                            this.K[i18] = (byte) i23;
                            s = i16;
                            i18++;
                        } else {
                            i5 = i26;
                            s = i5;
                        }
                        while (s > i7) {
                            this.K[i18] = this.J[s];
                            s = this.I[s];
                            i18++;
                            i7 = i7;
                        }
                        i3 = i7;
                        byte[] bArr2 = this.J;
                        i4 = bArr2[s] & 255;
                        if (i14 >= 4096) {
                            break;
                        }
                        int i27 = i18 + 1;
                        i2 = i8;
                        byte b = (byte) i4;
                        this.K[i18] = b;
                        this.I[i14] = (short) i16;
                        bArr2[i14] = b;
                        i14++;
                        if ((i14 & i15) == 0 && i14 < 4096) {
                            i13++;
                            i15 += i14;
                        }
                        i18 = i27;
                        i16 = i5;
                    }
                } else {
                    if (i21 == 0) {
                        i21 = k();
                        if (i21 <= 0) {
                            break;
                        }
                        i22 = 0;
                    }
                    i20 += (this.B[i22] & 255) << i19;
                    i19 += 8;
                    i22++;
                    i21--;
                }
                i18--;
                this.L[i24] = this.K[i18];
                i17++;
                i24++;
                i7 = i3;
                i8 = i2;
                i23 = i4;
                i10 = i;
            }
            for (int i28 = i24; i28 < i6; i28++) {
                this.L[i28] = 0;
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b != 0 : invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fg1 fg1Var = this.M;
            while (fg1Var != null) {
                fg1Var.a = null;
                fg1Var = this.M.c;
                this.M = fg1Var;
            }
            InputStream inputStream = this.a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
                this.a = null;
            }
            this.P = null;
        }
    }

    public fg1 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            fg1 fg1Var = this.M;
            int i2 = 0;
            while (fg1Var != null) {
                if (i2 == i) {
                    return fg1Var;
                }
                fg1Var = fg1Var.c;
                i2++;
            }
            return null;
        }
        return (fg1) invokeI.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.N : invokeV.intValue;
    }

    public Bitmap f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            fg1 d = d(i);
            if (d == null) {
                return null;
            }
            return d.a;
        }
        return (Bitmap) invokeI.objValue;
    }

    public Bitmap g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f(0) : (Bitmap) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b = 0;
            this.N = 0;
            this.M = null;
            this.g = null;
            this.h = null;
        }
    }

    public fg1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.A) {
                this.A = true;
                return this.M;
            }
            if (this.b == 0) {
                fg1 fg1Var = this.z.c;
                if (fg1Var != null) {
                    this.z = fg1Var;
                }
            } else {
                fg1 fg1Var2 = this.z.c;
                this.z = fg1Var2;
                if (fg1Var2 == null) {
                    this.z = this.M;
                }
            }
            return this.z;
        }
        return (fg1) invokeV.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                return this.a.read();
            } catch (Exception unused) {
                this.b = 1;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int j = j();
            this.C = j;
            int i = 0;
            if (j > 0) {
                while (i < this.C) {
                    try {
                        int read = this.a.read(this.B, i, this.C - i);
                        if (read == -1) {
                            break;
                        }
                        i += read;
                    } catch (Exception unused) {
                    }
                }
                if (i < this.C) {
                    this.b = 1;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.a = new ByteArrayInputStream(this.P);
            this.P = null;
            return u();
        }
        return invokeV.intValue;
    }

    public final int[] m(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            int i3 = i * 3;
            byte[] bArr = new byte[i3];
            try {
                i2 = this.a.read(bArr);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 < i3) {
                this.b = 1;
                return null;
            }
            int[] iArr = new int[256];
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                iArr[i5] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
                i4 = i7 + 1;
            }
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            boolean z = false;
            while (!z && !b()) {
                int j = j();
                if (j != 0) {
                    if (j == 33) {
                        int j2 = j();
                        if (j2 == 249) {
                            o();
                        } else if (j2 != 255) {
                            x();
                        } else {
                            k();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.B[i]);
                            }
                            if ("NETSCAPE2.0".equals(str)) {
                                s();
                            } else {
                                x();
                            }
                        }
                    } else if (j == 44) {
                        q();
                    } else if (j != 59) {
                        this.b = 1;
                    } else {
                        z = true;
                    }
                }
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            j();
            int j = j();
            int i = (j & 28) >> 2;
            this.D = i;
            if (i == 0) {
                this.D = 1;
            }
            this.F = (j & 1) != 0;
            this.G = t() * 10;
            this.H = j();
            j();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String str = "";
            for (int i = 0; i < 6; i++) {
                str = str + ((char) j());
            }
            if (!str.startsWith("GIF")) {
                this.b = 1;
                return;
            }
            r();
            if (!this.e || b()) {
                return;
            }
            int[] m = m(this.f);
            this.g = m;
            this.k = m[this.j];
        }
    }

    public final void q() {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.p = t();
            this.q = t();
            this.r = t();
            this.s = t();
            int j = j();
            int i = 0;
            this.m = (j & 128) != 0;
            this.n = (j & 64) != 0;
            int i2 = 2 << (j & 7);
            this.o = i2;
            if (this.m) {
                int[] m = m(i2);
                this.h = m;
                this.i = m;
            } else {
                this.i = this.g;
                if (this.j == this.H) {
                    this.k = 0;
                }
            }
            if (this.F) {
                int[] iArr2 = this.i;
                int i3 = this.H;
                int i4 = iArr2[i3];
                iArr2[i3] = 0;
                i = i4;
            }
            if (this.i == null) {
                this.b = 1;
            }
            if (b()) {
                return;
            }
            a();
            x();
            if (b()) {
                return;
            }
            this.N++;
            this.x = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_4444);
            w();
            fg1 fg1Var = this.M;
            if (fg1Var == null) {
                fg1 fg1Var2 = new fg1(this.x, this.G);
                this.M = fg1Var2;
                this.z = fg1Var2;
            } else {
                while (true) {
                    fg1 fg1Var3 = fg1Var.c;
                    if (fg1Var3 == null) {
                        break;
                    }
                    fg1Var = fg1Var3;
                }
                fg1Var.c = new fg1(this.x, this.G);
            }
            if (this.F && (iArr = this.i) != null) {
                iArr[this.H] = i;
            }
            v();
            this.O.a(true, this.N);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c = t();
            this.d = t();
            int j = j();
            this.e = (j & 128) != 0;
            this.f = 2 << (j & 7);
            this.j = j();
            j();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                if (this.a != null) {
                    u();
                } else if (this.P != null) {
                    l();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            do {
                k();
                byte[] bArr = this.B;
                if (bArr[0] == 1) {
                    byte b = bArr[1];
                    byte b2 = bArr[2];
                }
                if (this.C <= 0) {
                    return;
                }
            } while (!b());
        }
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? j() | (j() << 8) : invokeV.intValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            h();
            if (this.a != null) {
                p();
                if (!b()) {
                    n();
                    if (this.N < 0) {
                        this.b = 1;
                        this.O.a(false, -1);
                    } else {
                        this.b = -1;
                        this.O.a(true, -1);
                    }
                }
                try {
                    this.a.close();
                } catch (Exception unused) {
                }
            } else {
                this.b = 2;
                this.O.a(false, -1);
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.E = this.D;
            this.t = this.p;
            this.u = this.q;
            this.v = this.r;
            this.w = this.s;
            this.y = this.x;
            this.l = this.k;
            this.D = 0;
            this.F = false;
            this.G = 0;
            this.h = null;
        }
    }

    public final void w() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048599, this) != null) {
            return;
        }
        int[] iArr = new int[this.c * this.d];
        int i2 = this.E;
        int i3 = 0;
        if (i2 > 0) {
            if (i2 == 3) {
                int i4 = this.N - 2;
                if (i4 > 0) {
                    this.y = f(i4 - 1);
                } else {
                    this.y = null;
                }
            }
            Bitmap bitmap = this.y;
            if (bitmap != null) {
                int i5 = this.c;
                bitmap.getPixels(iArr, 0, i5, 0, 0, i5, this.d);
                if (this.E == 2) {
                    int i6 = !this.F ? this.l : 0;
                    for (int i7 = 0; i7 < this.w; i7++) {
                        int i8 = ((this.u + i7) * this.c) + this.t;
                        int i9 = this.v + i8;
                        while (i8 < i9) {
                            iArr[i8] = i6;
                            i8++;
                        }
                    }
                }
            }
        }
        int i10 = 8;
        int i11 = 0;
        int i12 = 1;
        while (true) {
            int i13 = this.s;
            if (i3 < i13) {
                if (this.n) {
                    if (i11 >= i13) {
                        i12++;
                        if (i12 == 2) {
                            i11 = 4;
                        } else if (i12 == 3) {
                            i10 = 4;
                            i11 = 2;
                        } else if (i12 == 4) {
                            i10 = 2;
                            i11 = 1;
                        }
                    }
                    i = i11 + i10;
                } else {
                    i = i11;
                    i11 = i3;
                }
                int i14 = i11 + this.q;
                if (i14 < this.d) {
                    int i15 = this.c;
                    int i16 = i14 * i15;
                    int i17 = this.p + i16;
                    int i18 = this.r + i17;
                    if (i16 + i15 < i18) {
                        i18 = i16 + i15;
                    }
                    int i19 = this.r * i3;
                    while (i17 < i18) {
                        int i20 = i19 + 1;
                        int i21 = this.i[this.L[i19] & 255];
                        if (i21 != 0) {
                            iArr[i17] = i21;
                        }
                        i17++;
                        i19 = i20;
                    }
                }
                i3++;
                i11 = i;
            } else {
                try {
                    this.x = Bitmap.createBitmap(iArr, this.c, this.d, Bitmap.Config.ARGB_4444);
                    return;
                } catch (OutOfMemoryError unused) {
                    return;
                }
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            do {
                k();
                if (this.C <= 0) {
                    return;
                }
            } while (!b());
        }
    }

    public eg1(InputStream inputStream, dg1 dg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, dg1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = null;
        this.A = false;
        this.B = new byte[256];
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.G = 0;
        this.O = null;
        this.P = null;
        this.a = inputStream;
        this.O = dg1Var;
    }
}
