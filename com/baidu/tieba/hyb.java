package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes6.dex */
public final class hyb {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947841464, "Lcom/baidu/tieba/hyb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947841464, "Lcom/baidu/tieba/hyb;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(nyb nybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, nybVar) == null) {
            eyb eybVar = nybVar.c;
            byte[] bArr = nybVar.d;
            int i = nybVar.g;
            if (i <= 0) {
                eyb.k(eybVar);
                nybVar.a = 1;
                return;
            }
            int min = Math.min(nybVar.Q - nybVar.r, i);
            eyb.c(eybVar, bArr, nybVar.r, min);
            nybVar.g -= min;
            int i2 = nybVar.r + min;
            nybVar.r = i2;
            int i3 = nybVar.Q;
            if (i2 == i3) {
                nybVar.b = 5;
                nybVar.Y = i3;
                nybVar.X = 0;
                nybVar.a = 12;
                return;
            }
            eyb.k(eybVar);
            nybVar.a = 1;
        }
    }

    public static void k(nyb nybVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, nybVar) == null) {
            int i2 = nybVar.P;
            long j = nybVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + nybVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!nybVar.h && i2 < 16384 && nybVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = nybVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = nybVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = nybVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = nybVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(nybVar.S, i, bArr, 0, i5);
                    nybVar.r = i5;
                    nybVar.f1137T = i5;
                }
            }
            nybVar.d = bArr;
            nybVar.Q = i2;
        }
    }

    public static boolean u(nyb nybVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, nybVar)) == null) {
            int i = nybVar.f1137T;
            if (i != 0) {
                nybVar.X += i;
                nybVar.f1137T = 0;
            }
            int min = Math.min(nybVar.V - nybVar.W, nybVar.Y - nybVar.X);
            if (min != 0) {
                System.arraycopy(nybVar.d, nybVar.X, nybVar.Z, nybVar.U + nybVar.W, min);
                nybVar.W += min;
                nybVar.X += min;
            }
            if (nybVar.W >= nybVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(nyb nybVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, nybVar, i) == null) {
            eyb eybVar = nybVar.c;
            int[] iArr = nybVar.p;
            int i3 = i * 2;
            eyb.d(eybVar);
            int i4 = i * 1080;
            int r = r(nybVar.e, i4, eybVar);
            nybVar.n[i] = m(nybVar.f, i4, eybVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = nybVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(nyb nybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, nybVar) == null) {
            b(nybVar, 1);
            nybVar.F = nybVar.l.c[nybVar.p[3]];
        }
    }

    public static void e(nyb nybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, nybVar) == null) {
            b(nybVar, 2);
            nybVar.C = nybVar.p[5] << 2;
        }
    }

    public static int h(eyb eybVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, eybVar)) == null) {
            if (eyb.i(eybVar, 1) != 0) {
                int i = eyb.i(eybVar, 3);
                if (i == 0) {
                    return 1;
                }
                return eyb.i(eybVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, eyb eybVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, eybVar)) == null) {
            eyb.j(eybVar);
            int h = h(eybVar) + 1;
            if (h == 1) {
                pyb.a(bArr, 0, i);
                return h;
            }
            if (eyb.i(eybVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = eyb.i(eybVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, eybVar);
            int i3 = 0;
            while (i3 < i) {
                eyb.j(eybVar);
                eyb.d(eybVar);
                int r = r(iArr, 0, eybVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + eyb.i(eybVar, r); i4 != 0; i4--) {
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
            if (eyb.i(eybVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(nyb nybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, nybVar) == null) {
            b(nybVar, 0);
            int i = nybVar.p[1];
            int i2 = i << 6;
            nybVar.B = i2;
            int i3 = nybVar.A[i2] & 255;
            nybVar.v = i3;
            nybVar.w = nybVar.k.c[i3];
            byte b2 = nybVar.z[i];
            int[] iArr = gyb.b;
            nybVar.D = iArr[b2];
            nybVar.E = iArr[b2 + 1];
        }
    }

    public static void g(eyb eybVar, nyb nybVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, eybVar, nybVar) == null) {
            boolean z2 = true;
            if (eyb.i(eybVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            nybVar.h = z;
            nybVar.g = 0;
            nybVar.i = false;
            nybVar.j = false;
            if (z && eyb.i(eybVar, 1) != 0) {
                return;
            }
            int i = eyb.i(eybVar, 2) + 4;
            if (i == 7) {
                nybVar.j = true;
                if (eyb.i(eybVar, 1) == 0) {
                    int i2 = eyb.i(eybVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = eyb.i(eybVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        nybVar.g = (i4 << (i3 * 8)) | nybVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = eyb.i(eybVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    nybVar.g = (i6 << (i5 * 4)) | nybVar.g;
                }
            }
            nybVar.g++;
            if (!nybVar.h) {
                if (eyb.i(eybVar, 1) != 1) {
                    z2 = false;
                }
                nybVar.i = z2;
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
    public static void i(nyb nybVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, nybVar) == null) {
            int i8 = nybVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    eyb eybVar = nybVar.c;
                    int i9 = nybVar.Q - 1;
                    byte[] bArr = nybVar.d;
                    while (true) {
                        int i10 = nybVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (nybVar.g >= 0) {
                                            q(nybVar);
                                            i9 = nybVar.Q - 1;
                                            bArr = nybVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(nybVar);
                                        nybVar.a = 3;
                                        if (nybVar.g > 0) {
                                            nybVar.a = 1;
                                            break;
                                        } else {
                                            eyb.j(eybVar);
                                            if (nybVar.n[1] == 0) {
                                                c(nybVar);
                                            }
                                            int[] iArr = nybVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            eyb.d(eybVar);
                                            int r = r(nybVar.l.b, nybVar.F, eybVar);
                                            int i12 = r >>> 6;
                                            nybVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                nybVar.G = -1;
                                            }
                                            int i13 = myb.g[i12] + ((r >>> 3) & 7);
                                            int i14 = myb.h[i12] + (r & 7);
                                            nybVar.y = myb.c[i13] + eyb.i(eybVar, myb.d[i13]);
                                            nybVar.M = myb.e[i14] + eyb.i(eybVar, myb.f[i14]);
                                            nybVar.x = 0;
                                            nybVar.a = 6;
                                            if (nybVar.u) {
                                                int i15 = nybVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (nybVar.x < nybVar.y) {
                                                        eyb.j(eybVar);
                                                        if (nybVar.n[0] == 0) {
                                                            f(nybVar);
                                                        }
                                                        byte[] bArr2 = nybVar.A;
                                                        int i18 = nybVar.B;
                                                        int[] iArr2 = gyb.a;
                                                        int i19 = iArr2[nybVar.D + i16];
                                                        int[] iArr3 = nybVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        eyb.d(eybVar);
                                                        kyb kybVar = nybVar.k;
                                                        int r2 = r(kybVar.b, kybVar.c[bArr2[i18 + (iArr2[nybVar.E + i17] | i19)] & 255], eybVar);
                                                        int i20 = nybVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        nybVar.x++;
                                                        nybVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            nybVar.b = 6;
                                                            nybVar.Y = nybVar.Q;
                                                            nybVar.X = 0;
                                                            nybVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (nybVar.x < nybVar.y) {
                                                        eyb.j(eybVar);
                                                        if (nybVar.n[0] == 0) {
                                                            f(nybVar);
                                                        }
                                                        int[] iArr4 = nybVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        eyb.d(eybVar);
                                                        bArr[nybVar.r] = (byte) r(nybVar.k.b, nybVar.w, eybVar);
                                                        nybVar.x++;
                                                        int i22 = nybVar.r;
                                                        nybVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            nybVar.b = 6;
                                                            nybVar.Y = nybVar.Q;
                                                            nybVar.X = 0;
                                                            nybVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (nybVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = nybVar.g - nybVar.y;
                                                nybVar.g = i23;
                                                if (i23 <= 0) {
                                                    nybVar.a = 3;
                                                    break;
                                                } else {
                                                    if (nybVar.G < 0) {
                                                        eyb.j(eybVar);
                                                        if (nybVar.n[2] == 0) {
                                                            e(nybVar);
                                                        }
                                                        int[] iArr5 = nybVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        eyb.d(eybVar);
                                                        kyb kybVar2 = nybVar.m;
                                                        int[] iArr6 = kybVar2.b;
                                                        int[] iArr7 = kybVar2.c;
                                                        byte[] bArr3 = nybVar.H;
                                                        int i24 = nybVar.C;
                                                        int i25 = nybVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], eybVar);
                                                        nybVar.G = r3;
                                                        int i26 = nybVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            nybVar.G = i27;
                                                            int i28 = nybVar.J & i27;
                                                            int i29 = i27 >>> nybVar.K;
                                                            nybVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            nybVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + eyb.i(eybVar, i30)) << nybVar.K);
                                                        }
                                                    }
                                                    int t = t(nybVar.G, nybVar.q, nybVar.t);
                                                    nybVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = nybVar.s;
                                                        int i32 = nybVar.O;
                                                        if (i31 != i32 && (i6 = nybVar.r) < i32) {
                                                            nybVar.s = i6;
                                                        } else {
                                                            nybVar.s = nybVar.O;
                                                        }
                                                        nybVar.N = nybVar.r;
                                                        int i33 = nybVar.L;
                                                        if (i33 > nybVar.s) {
                                                            nybVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (nybVar.G > 0) {
                                                                int[] iArr8 = nybVar.q;
                                                                int i34 = nybVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                nybVar.t = i34 + 1;
                                                            }
                                                            if (nybVar.M <= nybVar.g) {
                                                                nybVar.x = 0;
                                                                nybVar.a = 7;
                                                                int i35 = nybVar.r;
                                                                i = (i35 - nybVar.L) & i9;
                                                                i2 = nybVar.M - nybVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    nybVar.x += i2;
                                                                    nybVar.g -= i2;
                                                                    nybVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = nybVar.x;
                                                                        if (i3 >= nybVar.M) {
                                                                            i4 = nybVar.r;
                                                                            bArr[i4] = bArr[(i4 - nybVar.L) & i9];
                                                                            nybVar.g--;
                                                                            nybVar.x = i3 + 1;
                                                                            nybVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    nybVar.b = 7;
                                                                    nybVar.Y = nybVar.Q;
                                                                    nybVar.X = 0;
                                                                    nybVar.a = 12;
                                                                    if (nybVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        nybVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (nybVar.a != i5) {
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
                                        if (nybVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (nybVar.g > 0) {
                                            eyb.j(eybVar);
                                            eyb.i(eybVar, 8);
                                            nybVar.g--;
                                        }
                                        nybVar.a = 1;
                                        break;
                                    case 5:
                                        a(nybVar);
                                        break;
                                    case 6:
                                        if (nybVar.u) {
                                        }
                                        if (nybVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = nybVar.r;
                                        i = (i352 - nybVar.L) & i9;
                                        i2 = nybVar.M - nybVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = nybVar.x;
                                            if (i3 >= nybVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        nybVar.b = 7;
                                        nybVar.Y = nybVar.Q;
                                        nybVar.X = 0;
                                        nybVar.a = 12;
                                        if (nybVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = nybVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, nybVar.N - i36);
                                        nybVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = nybVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = iyb.a[i37];
                                            int i39 = (nybVar.L - nybVar.s) - 1;
                                            int i40 = iyb.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < oyb.d.length) {
                                                int b2 = oyb.b(bArr, nybVar.N, iyb.a(), i43, nybVar.M, oyb.d[i42]);
                                                int i44 = nybVar.N + b2;
                                                nybVar.N = i44;
                                                nybVar.r += b2;
                                                nybVar.g -= b2;
                                                int i45 = nybVar.Q;
                                                if (i44 >= i45) {
                                                    nybVar.b = 8;
                                                    nybVar.Y = i45;
                                                    nybVar.X = 0;
                                                    nybVar.a = 12;
                                                    break;
                                                } else {
                                                    nybVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + nybVar.a);
                                }
                            } else if (!u(nybVar)) {
                                return;
                            } else {
                                int i46 = nybVar.r;
                                int i47 = nybVar.O;
                                if (i46 >= i47) {
                                    nybVar.s = i47;
                                }
                                nybVar.r &= i9;
                                nybVar.a = nybVar.b;
                            }
                        } else if (i10 == 10) {
                            if (nybVar.g >= 0) {
                                eyb.g(eybVar);
                                eyb.a(nybVar.c, true);
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

    public static void s(nyb nybVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, nybVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            nybVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, eyb eybVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, eybVar)) == null) {
            eyb.d(eybVar);
            int r = r(iArr, i, eybVar);
            return myb.a[r] + eyb.i(eybVar, myb.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, eyb eybVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), eybVar}) == null) {
            eyb.j(eybVar);
            int[] iArr2 = new int[i];
            int i3 = eyb.i(eybVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = eyb.i(eybVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = eyb.i(eybVar, i6) % i;
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
                            if (eyb.i(eybVar, 1) == 1) {
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
                    jyb.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                eyb.d(eybVar);
                long j = eybVar.f;
                int i11 = eybVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                eybVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, eybVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.pyb.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, eyb eybVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, eybVar) == null) {
            int[] iArr3 = new int[32];
            jyb.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    eyb.j(eybVar);
                    eyb.d(eybVar);
                    long j = eybVar.f;
                    int i9 = eybVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    eybVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + eyb.i(eybVar, i13) + 3;
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

    public static void p(nyb nybVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, nybVar) == null) {
            eyb eybVar = nybVar.c;
            for (int i = 0; i < 3; i++) {
                nybVar.o[i] = h(eybVar) + 1;
                nybVar.n[i] = 268435456;
                int[] iArr2 = nybVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, nybVar.e, i2, eybVar);
                    n(26, nybVar.f, i2, eybVar);
                    nybVar.n[i] = m(nybVar.f, i2, eybVar);
                }
            }
            eyb.j(eybVar);
            nybVar.K = eyb.i(eybVar, 2);
            int i3 = eyb.i(eybVar, 4);
            int i4 = nybVar.K;
            int i5 = (i3 << i4) + 16;
            nybVar.I = i5;
            nybVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            nybVar.z = new byte[nybVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = nybVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    nybVar.z[i7] = (byte) (eyb.i(eybVar, 2) << 1);
                    i7++;
                }
                eyb.j(eybVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            nybVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, eybVar);
            nybVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (nybVar.o[0] << 6)) {
                    break;
                } else if (nybVar.A[i8] != (i8 >> 6)) {
                    nybVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = nybVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            nybVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, eybVar);
            kyb.b(nybVar.k, 256, d2);
            kyb.b(nybVar.l, 704, nybVar.o[1]);
            kyb.b(nybVar.m, i6, d3);
            kyb.a(nybVar.k, eybVar);
            kyb.a(nybVar.l, eybVar);
            kyb.a(nybVar.m, eybVar);
            nybVar.B = 0;
            nybVar.C = 0;
            int[] iArr4 = gyb.b;
            byte[] bArr3 = nybVar.z;
            nybVar.D = iArr4[bArr3[0]];
            nybVar.E = iArr4[bArr3[0] + 1];
            nybVar.v = 0;
            nybVar.w = nybVar.k.c[0];
            nybVar.F = nybVar.l.c[0];
            int[] iArr5 = nybVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(nyb nybVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, nybVar) == null) {
            eyb eybVar = nybVar.c;
            if (nybVar.h) {
                nybVar.b = 10;
                nybVar.Y = nybVar.r;
                nybVar.X = 0;
                nybVar.a = 12;
                return;
            }
            kyb kybVar = nybVar.k;
            kybVar.b = null;
            kybVar.c = null;
            kyb kybVar2 = nybVar.l;
            kybVar2.b = null;
            kybVar2.c = null;
            kyb kybVar3 = nybVar.m;
            kybVar3.b = null;
            kybVar3.c = null;
            eyb.j(eybVar);
            g(eybVar, nybVar);
            if (nybVar.g == 0 && !nybVar.j) {
                return;
            }
            if (!nybVar.i && !nybVar.j) {
                nybVar.a = 2;
            } else {
                eyb.g(eybVar);
                if (nybVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                nybVar.a = i;
            }
            if (nybVar.j) {
                return;
            }
            nybVar.R += nybVar.g;
            if (nybVar.Q < nybVar.P) {
                k(nybVar);
            }
        }
    }

    public static int r(int[] iArr, int i, eyb eybVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, eybVar)) == null) {
            long j = eybVar.f;
            int i2 = eybVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                eybVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            eybVar.g = i2 + (iArr[i7] >> 16) + 8;
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
