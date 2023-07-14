package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes5.dex */
public final class ezb {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947753052, "Lcom/baidu/tieba/ezb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947753052, "Lcom/baidu/tieba/ezb;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(kzb kzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, kzbVar) == null) {
            bzb bzbVar = kzbVar.c;
            byte[] bArr = kzbVar.d;
            int i = kzbVar.g;
            if (i <= 0) {
                bzb.k(bzbVar);
                kzbVar.a = 1;
                return;
            }
            int min = Math.min(kzbVar.Q - kzbVar.r, i);
            bzb.c(bzbVar, bArr, kzbVar.r, min);
            kzbVar.g -= min;
            int i2 = kzbVar.r + min;
            kzbVar.r = i2;
            int i3 = kzbVar.Q;
            if (i2 == i3) {
                kzbVar.b = 5;
                kzbVar.Y = i3;
                kzbVar.X = 0;
                kzbVar.a = 12;
                return;
            }
            bzb.k(bzbVar);
            kzbVar.a = 1;
        }
    }

    public static void k(kzb kzbVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, kzbVar) == null) {
            int i2 = kzbVar.P;
            long j = kzbVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + kzbVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!kzbVar.h && i2 < 16384 && kzbVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = kzbVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = kzbVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = kzbVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = kzbVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(kzbVar.S, i, bArr, 0, i5);
                    kzbVar.r = i5;
                    kzbVar.f1136T = i5;
                }
            }
            kzbVar.d = bArr;
            kzbVar.Q = i2;
        }
    }

    public static boolean u(kzb kzbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, kzbVar)) == null) {
            int i = kzbVar.f1136T;
            if (i != 0) {
                kzbVar.X += i;
                kzbVar.f1136T = 0;
            }
            int min = Math.min(kzbVar.V - kzbVar.W, kzbVar.Y - kzbVar.X);
            if (min != 0) {
                System.arraycopy(kzbVar.d, kzbVar.X, kzbVar.Z, kzbVar.U + kzbVar.W, min);
                kzbVar.W += min;
                kzbVar.X += min;
            }
            if (kzbVar.W >= kzbVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(kzb kzbVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, kzbVar, i) == null) {
            bzb bzbVar = kzbVar.c;
            int[] iArr = kzbVar.p;
            int i3 = i * 2;
            bzb.d(bzbVar);
            int i4 = i * 1080;
            int r = r(kzbVar.e, i4, bzbVar);
            kzbVar.n[i] = m(kzbVar.f, i4, bzbVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = kzbVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(kzb kzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, kzbVar) == null) {
            b(kzbVar, 1);
            kzbVar.F = kzbVar.l.c[kzbVar.p[3]];
        }
    }

    public static void e(kzb kzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, kzbVar) == null) {
            b(kzbVar, 2);
            kzbVar.C = kzbVar.p[5] << 2;
        }
    }

    public static int h(bzb bzbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bzbVar)) == null) {
            if (bzb.i(bzbVar, 1) != 0) {
                int i = bzb.i(bzbVar, 3);
                if (i == 0) {
                    return 1;
                }
                return bzb.i(bzbVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, bzb bzbVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, bzbVar)) == null) {
            bzb.j(bzbVar);
            int h = h(bzbVar) + 1;
            if (h == 1) {
                mzb.a(bArr, 0, i);
                return h;
            }
            if (bzb.i(bzbVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = bzb.i(bzbVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, bzbVar);
            int i3 = 0;
            while (i3 < i) {
                bzb.j(bzbVar);
                bzb.d(bzbVar);
                int r = r(iArr, 0, bzbVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + bzb.i(bzbVar, r); i4 != 0; i4--) {
                        if (i3 < i) {
                            bArr[i3] = 0;
                            i3++;
                        } else {
                            throw new BrotliRuntimeException("Corrupted context map");
                        }
                    }
                    continue;
                } else {
                    bArr[i3] = (byte) (r - i2);
                }
                i3++;
            }
            if (bzb.i(bzbVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(kzb kzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, kzbVar) == null) {
            b(kzbVar, 0);
            int i = kzbVar.p[1];
            int i2 = i << 6;
            kzbVar.B = i2;
            int i3 = kzbVar.A[i2] & 255;
            kzbVar.v = i3;
            kzbVar.w = kzbVar.k.c[i3];
            byte b2 = kzbVar.z[i];
            int[] iArr = dzb.b;
            kzbVar.D = iArr[b2];
            kzbVar.E = iArr[b2 + 1];
        }
    }

    public static void g(bzb bzbVar, kzb kzbVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, bzbVar, kzbVar) == null) {
            boolean z2 = true;
            if (bzb.i(bzbVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            kzbVar.h = z;
            kzbVar.g = 0;
            kzbVar.i = false;
            kzbVar.j = false;
            if (z && bzb.i(bzbVar, 1) != 0) {
                return;
            }
            int i = bzb.i(bzbVar, 2) + 4;
            if (i == 7) {
                kzbVar.j = true;
                if (bzb.i(bzbVar, 1) == 0) {
                    int i2 = bzb.i(bzbVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = bzb.i(bzbVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        kzbVar.g = (i4 << (i3 * 8)) | kzbVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = bzb.i(bzbVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    kzbVar.g = (i6 << (i5 * 4)) | kzbVar.g;
                }
            }
            kzbVar.g++;
            if (!kzbVar.h) {
                if (bzb.i(bzbVar, 1) != 1) {
                    z2 = false;
                }
                kzbVar.i = z2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
        throw new org.brotli.dec.BrotliRuntimeException("Invalid backward reference");
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0315 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0310 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142 A[LOOP:2: B:50:0x0142->B:56:0x0178, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(kzb kzbVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, kzbVar) == null) {
            int i8 = kzbVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    bzb bzbVar = kzbVar.c;
                    int i9 = kzbVar.Q - 1;
                    byte[] bArr = kzbVar.d;
                    while (true) {
                        int i10 = kzbVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (kzbVar.g >= 0) {
                                            q(kzbVar);
                                            i9 = kzbVar.Q - 1;
                                            bArr = kzbVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(kzbVar);
                                        kzbVar.a = 3;
                                        if (kzbVar.g > 0) {
                                            kzbVar.a = 1;
                                            break;
                                        } else {
                                            bzb.j(bzbVar);
                                            if (kzbVar.n[1] == 0) {
                                                c(kzbVar);
                                            }
                                            int[] iArr = kzbVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            bzb.d(bzbVar);
                                            int r = r(kzbVar.l.b, kzbVar.F, bzbVar);
                                            int i12 = r >>> 6;
                                            kzbVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                kzbVar.G = -1;
                                            }
                                            int i13 = jzb.g[i12] + ((r >>> 3) & 7);
                                            int i14 = jzb.h[i12] + (r & 7);
                                            kzbVar.y = jzb.c[i13] + bzb.i(bzbVar, jzb.d[i13]);
                                            kzbVar.M = jzb.e[i14] + bzb.i(bzbVar, jzb.f[i14]);
                                            kzbVar.x = 0;
                                            kzbVar.a = 6;
                                            if (kzbVar.u) {
                                                int i15 = kzbVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (kzbVar.x < kzbVar.y) {
                                                        bzb.j(bzbVar);
                                                        if (kzbVar.n[0] == 0) {
                                                            f(kzbVar);
                                                        }
                                                        byte[] bArr2 = kzbVar.A;
                                                        int i18 = kzbVar.B;
                                                        int[] iArr2 = dzb.a;
                                                        int i19 = iArr2[kzbVar.D + i16];
                                                        int[] iArr3 = kzbVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        bzb.d(bzbVar);
                                                        hzb hzbVar = kzbVar.k;
                                                        int r2 = r(hzbVar.b, hzbVar.c[bArr2[i18 + (iArr2[kzbVar.E + i17] | i19)] & 255], bzbVar);
                                                        int i20 = kzbVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        kzbVar.x++;
                                                        kzbVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            kzbVar.b = 6;
                                                            kzbVar.Y = kzbVar.Q;
                                                            kzbVar.X = 0;
                                                            kzbVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (kzbVar.x < kzbVar.y) {
                                                        bzb.j(bzbVar);
                                                        if (kzbVar.n[0] == 0) {
                                                            f(kzbVar);
                                                        }
                                                        int[] iArr4 = kzbVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        bzb.d(bzbVar);
                                                        bArr[kzbVar.r] = (byte) r(kzbVar.k.b, kzbVar.w, bzbVar);
                                                        kzbVar.x++;
                                                        int i22 = kzbVar.r;
                                                        kzbVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            kzbVar.b = 6;
                                                            kzbVar.Y = kzbVar.Q;
                                                            kzbVar.X = 0;
                                                            kzbVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (kzbVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = kzbVar.g - kzbVar.y;
                                                kzbVar.g = i23;
                                                if (i23 <= 0) {
                                                    kzbVar.a = 3;
                                                    break;
                                                } else {
                                                    if (kzbVar.G < 0) {
                                                        bzb.j(bzbVar);
                                                        if (kzbVar.n[2] == 0) {
                                                            e(kzbVar);
                                                        }
                                                        int[] iArr5 = kzbVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        bzb.d(bzbVar);
                                                        hzb hzbVar2 = kzbVar.m;
                                                        int[] iArr6 = hzbVar2.b;
                                                        int[] iArr7 = hzbVar2.c;
                                                        byte[] bArr3 = kzbVar.H;
                                                        int i24 = kzbVar.C;
                                                        int i25 = kzbVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], bzbVar);
                                                        kzbVar.G = r3;
                                                        int i26 = kzbVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            kzbVar.G = i27;
                                                            int i28 = kzbVar.J & i27;
                                                            int i29 = i27 >>> kzbVar.K;
                                                            kzbVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            kzbVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + bzb.i(bzbVar, i30)) << kzbVar.K);
                                                        }
                                                    }
                                                    int t = t(kzbVar.G, kzbVar.q, kzbVar.t);
                                                    kzbVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = kzbVar.s;
                                                        int i32 = kzbVar.O;
                                                        if (i31 != i32 && (i6 = kzbVar.r) < i32) {
                                                            kzbVar.s = i6;
                                                        } else {
                                                            kzbVar.s = kzbVar.O;
                                                        }
                                                        kzbVar.N = kzbVar.r;
                                                        int i33 = kzbVar.L;
                                                        if (i33 > kzbVar.s) {
                                                            kzbVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (kzbVar.G > 0) {
                                                                int[] iArr8 = kzbVar.q;
                                                                int i34 = kzbVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                kzbVar.t = i34 + 1;
                                                            }
                                                            if (kzbVar.M <= kzbVar.g) {
                                                                kzbVar.x = 0;
                                                                kzbVar.a = 7;
                                                                int i35 = kzbVar.r;
                                                                i = (i35 - kzbVar.L) & i9;
                                                                i2 = kzbVar.M - kzbVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    kzbVar.x += i2;
                                                                    kzbVar.g -= i2;
                                                                    kzbVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = kzbVar.x;
                                                                        if (i3 >= kzbVar.M) {
                                                                            i4 = kzbVar.r;
                                                                            bArr[i4] = bArr[(i4 - kzbVar.L) & i9];
                                                                            kzbVar.g--;
                                                                            kzbVar.x = i3 + 1;
                                                                            kzbVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    kzbVar.b = 7;
                                                                    kzbVar.Y = kzbVar.Q;
                                                                    kzbVar.X = 0;
                                                                    kzbVar.a = 12;
                                                                    if (kzbVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        kzbVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (kzbVar.a != i5) {
                                                                }
                                                            } else {
                                                                throw new BrotliRuntimeException("Invalid backward reference");
                                                            }
                                                        }
                                                    } else {
                                                        throw new BrotliRuntimeException("Negative distance");
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        if (kzbVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (kzbVar.g > 0) {
                                            bzb.j(bzbVar);
                                            bzb.i(bzbVar, 8);
                                            kzbVar.g--;
                                        }
                                        kzbVar.a = 1;
                                        break;
                                    case 5:
                                        a(kzbVar);
                                        break;
                                    case 6:
                                        if (kzbVar.u) {
                                        }
                                        if (kzbVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = kzbVar.r;
                                        i = (i352 - kzbVar.L) & i9;
                                        i2 = kzbVar.M - kzbVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = kzbVar.x;
                                            if (i3 >= kzbVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        kzbVar.b = 7;
                                        kzbVar.Y = kzbVar.Q;
                                        kzbVar.X = 0;
                                        kzbVar.a = 12;
                                        if (kzbVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = kzbVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, kzbVar.N - i36);
                                        kzbVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = kzbVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = fzb.a[i37];
                                            int i39 = (kzbVar.L - kzbVar.s) - 1;
                                            int i40 = fzb.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < lzb.d.length) {
                                                int b2 = lzb.b(bArr, kzbVar.N, fzb.a(), i43, kzbVar.M, lzb.d[i42]);
                                                int i44 = kzbVar.N + b2;
                                                kzbVar.N = i44;
                                                kzbVar.r += b2;
                                                kzbVar.g -= b2;
                                                int i45 = kzbVar.Q;
                                                if (i44 >= i45) {
                                                    kzbVar.b = 8;
                                                    kzbVar.Y = i45;
                                                    kzbVar.X = 0;
                                                    kzbVar.a = 12;
                                                    break;
                                                } else {
                                                    kzbVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + kzbVar.a);
                                }
                            } else if (!u(kzbVar)) {
                                return;
                            } else {
                                int i46 = kzbVar.r;
                                int i47 = kzbVar.O;
                                if (i46 >= i47) {
                                    kzbVar.s = i47;
                                }
                                kzbVar.r &= i9;
                                kzbVar.a = kzbVar.b;
                            }
                        } else if (i10 == 10) {
                            if (kzbVar.g >= 0) {
                                bzb.g(bzbVar);
                                bzb.a(kzbVar.c, true);
                                return;
                            }
                            throw new BrotliRuntimeException("Invalid metablock length");
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new IllegalStateException("Can't decompress after close");
                }
            } else {
                throw new IllegalStateException("Can't decompress until initialized");
            }
        }
    }

    public static void j(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, bArr, i) == null) {
            int[] iArr = new int[256];
            for (int i2 = 0; i2 < 256; i2++) {
                iArr[i2] = i2;
            }
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = bArr[i3] & 255;
                bArr[i3] = (byte) iArr[i4];
                if (i4 != 0) {
                    l(iArr, i4);
                }
            }
        }
    }

    public static void l(int[] iArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, iArr, i) == null) {
            int i2 = iArr[i];
            while (i > 0) {
                iArr[i] = iArr[i - 1];
                i--;
            }
            iArr[0] = i2;
        }
    }

    public static void s(kzb kzbVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, kzbVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            kzbVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, bzb bzbVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, bzbVar)) == null) {
            bzb.d(bzbVar);
            int r = r(iArr, i, bzbVar);
            return jzb.a[r] + bzb.i(bzbVar, jzb.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, bzb bzbVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), bzbVar}) == null) {
            bzb.j(bzbVar);
            int[] iArr2 = new int[i];
            int i3 = bzb.i(bzbVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = bzb.i(bzbVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = bzb.i(bzbVar, i6) % i;
                    iArr2[iArr3[i7]] = 2;
                }
                iArr2[iArr3[0]] = 1;
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (iArr3[0] != iArr3[1] && iArr3[0] != iArr3[2] && iArr3[0] != iArr3[3] && iArr3[1] != iArr3[2] && iArr3[1] != iArr3[3] && iArr3[2] != iArr3[3]) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (bzb.i(bzbVar, 1) == 1) {
                                iArr2[iArr3[2]] = 3;
                                iArr2[iArr3[3]] = 3;
                            } else {
                                iArr2[iArr3[0]] = 2;
                            }
                            z3 = z;
                        } else if (iArr3[0] != iArr3[1] && iArr3[0] != iArr3[2] && iArr3[1] != iArr3[2]) {
                            z2 = true;
                        }
                    } else {
                        if (iArr3[0] != iArr3[1]) {
                            z2 = true;
                        }
                        iArr2[iArr3[1]] = 1;
                    }
                }
                if (!z3) {
                    gzb.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                bzb.d(bzbVar);
                long j = bzbVar.f;
                int i11 = bzbVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                bzbVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, bzbVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.mzb.b(r13, r3, r12 - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0092, code lost:
        throw new org.brotli.dec.BrotliRuntimeException("Unused space");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void o(int[] iArr, int i, int[] iArr2, bzb bzbVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, bzbVar) == null) {
            int[] iArr3 = new int[32];
            gzb.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    bzb.j(bzbVar);
                    bzb.d(bzbVar);
                    long j = bzbVar.f;
                    int i9 = bzbVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    bzbVar.g = i9 + (iArr3[i10] >> 16);
                    int i11 = iArr3[i10] & 65535;
                    if (i11 < 16) {
                        int i12 = i5 + 1;
                        iArr2[i5] = i11;
                        if (i11 != 0) {
                            i6 -= 32768 >> i11;
                            i5 = i12;
                            i4 = i11;
                        } else {
                            i5 = i12;
                        }
                    } else {
                        int i13 = i11 - 14;
                        if (i11 == 16) {
                            i2 = i4;
                        } else {
                            i2 = 0;
                        }
                        if (i7 != i2) {
                            i7 = i2;
                            i8 = 0;
                        }
                        if (i8 > 0) {
                            i3 = (i8 - 2) << i13;
                        } else {
                            i3 = i8;
                        }
                        int i14 = i3 + bzb.i(bzbVar, i13) + 3;
                        int i15 = i14 - i8;
                        if (i5 + i15 <= i) {
                            int i16 = 0;
                            while (i16 < i15) {
                                iArr2[i5] = i7;
                                i16++;
                                i5++;
                            }
                            if (i7 != 0) {
                                i6 -= i15 << (15 - i7);
                            }
                            i8 = i14;
                        } else {
                            throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                        }
                    }
                }
            }
        }
    }

    public static void p(kzb kzbVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, kzbVar) == null) {
            bzb bzbVar = kzbVar.c;
            for (int i = 0; i < 3; i++) {
                kzbVar.o[i] = h(bzbVar) + 1;
                kzbVar.n[i] = 268435456;
                int[] iArr2 = kzbVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, kzbVar.e, i2, bzbVar);
                    n(26, kzbVar.f, i2, bzbVar);
                    kzbVar.n[i] = m(kzbVar.f, i2, bzbVar);
                }
            }
            bzb.j(bzbVar);
            kzbVar.K = bzb.i(bzbVar, 2);
            int i3 = bzb.i(bzbVar, 4);
            int i4 = kzbVar.K;
            int i5 = (i3 << i4) + 16;
            kzbVar.I = i5;
            kzbVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            kzbVar.z = new byte[kzbVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = kzbVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    kzbVar.z[i7] = (byte) (bzb.i(bzbVar, 2) << 1);
                    i7++;
                }
                bzb.j(bzbVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            kzbVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, bzbVar);
            kzbVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (kzbVar.o[0] << 6)) {
                    break;
                } else if (kzbVar.A[i8] != (i8 >> 6)) {
                    kzbVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = kzbVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            kzbVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, bzbVar);
            hzb.b(kzbVar.k, 256, d2);
            hzb.b(kzbVar.l, 704, kzbVar.o[1]);
            hzb.b(kzbVar.m, i6, d3);
            hzb.a(kzbVar.k, bzbVar);
            hzb.a(kzbVar.l, bzbVar);
            hzb.a(kzbVar.m, bzbVar);
            kzbVar.B = 0;
            kzbVar.C = 0;
            int[] iArr4 = dzb.b;
            byte[] bArr3 = kzbVar.z;
            kzbVar.D = iArr4[bArr3[0]];
            kzbVar.E = iArr4[bArr3[0] + 1];
            kzbVar.v = 0;
            kzbVar.w = kzbVar.k.c[0];
            kzbVar.F = kzbVar.l.c[0];
            int[] iArr5 = kzbVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(kzb kzbVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, kzbVar) == null) {
            bzb bzbVar = kzbVar.c;
            if (kzbVar.h) {
                kzbVar.b = 10;
                kzbVar.Y = kzbVar.r;
                kzbVar.X = 0;
                kzbVar.a = 12;
                return;
            }
            hzb hzbVar = kzbVar.k;
            hzbVar.b = null;
            hzbVar.c = null;
            hzb hzbVar2 = kzbVar.l;
            hzbVar2.b = null;
            hzbVar2.c = null;
            hzb hzbVar3 = kzbVar.m;
            hzbVar3.b = null;
            hzbVar3.c = null;
            bzb.j(bzbVar);
            g(bzbVar, kzbVar);
            if (kzbVar.g == 0 && !kzbVar.j) {
                return;
            }
            if (!kzbVar.i && !kzbVar.j) {
                kzbVar.a = 2;
            } else {
                bzb.g(bzbVar);
                if (kzbVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                kzbVar.a = i;
            }
            if (kzbVar.j) {
                return;
            }
            kzbVar.R += kzbVar.g;
            if (kzbVar.Q < kzbVar.P) {
                k(kzbVar);
            }
        }
    }

    public static int r(int[] iArr, int i, bzb bzbVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, bzbVar)) == null) {
            long j = bzbVar.f;
            int i2 = bzbVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                bzbVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            bzbVar.g = i2 + (iArr[i7] >> 16) + 8;
            return iArr[i7] & 65535;
        }
        return invokeLIL.intValue;
    }

    public static int t(int i, int[] iArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2)})) == null) {
            if (i < 16) {
                return iArr[(i2 + b[i]) & 3] + c[i];
            }
            return (i - 16) + 1;
        }
        return invokeCommon.intValue;
    }
}
