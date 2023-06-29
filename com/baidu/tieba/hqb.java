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
public final class hqb {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947833776, "Lcom/baidu/tieba/hqb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947833776, "Lcom/baidu/tieba/hqb;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(nqb nqbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, nqbVar) == null) {
            eqb eqbVar = nqbVar.c;
            byte[] bArr = nqbVar.d;
            int i = nqbVar.g;
            if (i <= 0) {
                eqb.k(eqbVar);
                nqbVar.a = 1;
                return;
            }
            int min = Math.min(nqbVar.Q - nqbVar.r, i);
            eqb.c(eqbVar, bArr, nqbVar.r, min);
            nqbVar.g -= min;
            int i2 = nqbVar.r + min;
            nqbVar.r = i2;
            int i3 = nqbVar.Q;
            if (i2 == i3) {
                nqbVar.b = 5;
                nqbVar.Y = i3;
                nqbVar.X = 0;
                nqbVar.a = 12;
                return;
            }
            eqb.k(eqbVar);
            nqbVar.a = 1;
        }
    }

    public static void k(nqb nqbVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, nqbVar) == null) {
            int i2 = nqbVar.P;
            long j = nqbVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + nqbVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!nqbVar.h && i2 < 16384 && nqbVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = nqbVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = nqbVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = nqbVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = nqbVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(nqbVar.S, i, bArr, 0, i5);
                    nqbVar.r = i5;
                    nqbVar.f1138T = i5;
                }
            }
            nqbVar.d = bArr;
            nqbVar.Q = i2;
        }
    }

    public static boolean u(nqb nqbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, nqbVar)) == null) {
            int i = nqbVar.f1138T;
            if (i != 0) {
                nqbVar.X += i;
                nqbVar.f1138T = 0;
            }
            int min = Math.min(nqbVar.V - nqbVar.W, nqbVar.Y - nqbVar.X);
            if (min != 0) {
                System.arraycopy(nqbVar.d, nqbVar.X, nqbVar.Z, nqbVar.U + nqbVar.W, min);
                nqbVar.W += min;
                nqbVar.X += min;
            }
            if (nqbVar.W >= nqbVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(nqb nqbVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, nqbVar, i) == null) {
            eqb eqbVar = nqbVar.c;
            int[] iArr = nqbVar.p;
            int i3 = i * 2;
            eqb.d(eqbVar);
            int i4 = i * 1080;
            int r = r(nqbVar.e, i4, eqbVar);
            nqbVar.n[i] = m(nqbVar.f, i4, eqbVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = nqbVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(nqb nqbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, nqbVar) == null) {
            b(nqbVar, 1);
            nqbVar.F = nqbVar.l.c[nqbVar.p[3]];
        }
    }

    public static void e(nqb nqbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, nqbVar) == null) {
            b(nqbVar, 2);
            nqbVar.C = nqbVar.p[5] << 2;
        }
    }

    public static int h(eqb eqbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, eqbVar)) == null) {
            if (eqb.i(eqbVar, 1) != 0) {
                int i = eqb.i(eqbVar, 3);
                if (i == 0) {
                    return 1;
                }
                return eqb.i(eqbVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, eqb eqbVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, eqbVar)) == null) {
            eqb.j(eqbVar);
            int h = h(eqbVar) + 1;
            if (h == 1) {
                pqb.a(bArr, 0, i);
                return h;
            }
            if (eqb.i(eqbVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = eqb.i(eqbVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, eqbVar);
            int i3 = 0;
            while (i3 < i) {
                eqb.j(eqbVar);
                eqb.d(eqbVar);
                int r = r(iArr, 0, eqbVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + eqb.i(eqbVar, r); i4 != 0; i4--) {
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
            if (eqb.i(eqbVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(nqb nqbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, nqbVar) == null) {
            b(nqbVar, 0);
            int i = nqbVar.p[1];
            int i2 = i << 6;
            nqbVar.B = i2;
            int i3 = nqbVar.A[i2] & 255;
            nqbVar.v = i3;
            nqbVar.w = nqbVar.k.c[i3];
            byte b2 = nqbVar.z[i];
            int[] iArr = gqb.b;
            nqbVar.D = iArr[b2];
            nqbVar.E = iArr[b2 + 1];
        }
    }

    public static void g(eqb eqbVar, nqb nqbVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, eqbVar, nqbVar) == null) {
            boolean z2 = true;
            if (eqb.i(eqbVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            nqbVar.h = z;
            nqbVar.g = 0;
            nqbVar.i = false;
            nqbVar.j = false;
            if (z && eqb.i(eqbVar, 1) != 0) {
                return;
            }
            int i = eqb.i(eqbVar, 2) + 4;
            if (i == 7) {
                nqbVar.j = true;
                if (eqb.i(eqbVar, 1) == 0) {
                    int i2 = eqb.i(eqbVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = eqb.i(eqbVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        nqbVar.g = (i4 << (i3 * 8)) | nqbVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = eqb.i(eqbVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    nqbVar.g = (i6 << (i5 * 4)) | nqbVar.g;
                }
            }
            nqbVar.g++;
            if (!nqbVar.h) {
                if (eqb.i(eqbVar, 1) != 1) {
                    z2 = false;
                }
                nqbVar.i = z2;
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
    public static void i(nqb nqbVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, nqbVar) == null) {
            int i8 = nqbVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    eqb eqbVar = nqbVar.c;
                    int i9 = nqbVar.Q - 1;
                    byte[] bArr = nqbVar.d;
                    while (true) {
                        int i10 = nqbVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (nqbVar.g >= 0) {
                                            q(nqbVar);
                                            i9 = nqbVar.Q - 1;
                                            bArr = nqbVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(nqbVar);
                                        nqbVar.a = 3;
                                        if (nqbVar.g > 0) {
                                            nqbVar.a = 1;
                                            break;
                                        } else {
                                            eqb.j(eqbVar);
                                            if (nqbVar.n[1] == 0) {
                                                c(nqbVar);
                                            }
                                            int[] iArr = nqbVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            eqb.d(eqbVar);
                                            int r = r(nqbVar.l.b, nqbVar.F, eqbVar);
                                            int i12 = r >>> 6;
                                            nqbVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                nqbVar.G = -1;
                                            }
                                            int i13 = mqb.g[i12] + ((r >>> 3) & 7);
                                            int i14 = mqb.h[i12] + (r & 7);
                                            nqbVar.y = mqb.c[i13] + eqb.i(eqbVar, mqb.d[i13]);
                                            nqbVar.M = mqb.e[i14] + eqb.i(eqbVar, mqb.f[i14]);
                                            nqbVar.x = 0;
                                            nqbVar.a = 6;
                                            if (nqbVar.u) {
                                                int i15 = nqbVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (nqbVar.x < nqbVar.y) {
                                                        eqb.j(eqbVar);
                                                        if (nqbVar.n[0] == 0) {
                                                            f(nqbVar);
                                                        }
                                                        byte[] bArr2 = nqbVar.A;
                                                        int i18 = nqbVar.B;
                                                        int[] iArr2 = gqb.a;
                                                        int i19 = iArr2[nqbVar.D + i16];
                                                        int[] iArr3 = nqbVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        eqb.d(eqbVar);
                                                        kqb kqbVar = nqbVar.k;
                                                        int r2 = r(kqbVar.b, kqbVar.c[bArr2[i18 + (iArr2[nqbVar.E + i17] | i19)] & 255], eqbVar);
                                                        int i20 = nqbVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        nqbVar.x++;
                                                        nqbVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            nqbVar.b = 6;
                                                            nqbVar.Y = nqbVar.Q;
                                                            nqbVar.X = 0;
                                                            nqbVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (nqbVar.x < nqbVar.y) {
                                                        eqb.j(eqbVar);
                                                        if (nqbVar.n[0] == 0) {
                                                            f(nqbVar);
                                                        }
                                                        int[] iArr4 = nqbVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        eqb.d(eqbVar);
                                                        bArr[nqbVar.r] = (byte) r(nqbVar.k.b, nqbVar.w, eqbVar);
                                                        nqbVar.x++;
                                                        int i22 = nqbVar.r;
                                                        nqbVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            nqbVar.b = 6;
                                                            nqbVar.Y = nqbVar.Q;
                                                            nqbVar.X = 0;
                                                            nqbVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (nqbVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = nqbVar.g - nqbVar.y;
                                                nqbVar.g = i23;
                                                if (i23 <= 0) {
                                                    nqbVar.a = 3;
                                                    break;
                                                } else {
                                                    if (nqbVar.G < 0) {
                                                        eqb.j(eqbVar);
                                                        if (nqbVar.n[2] == 0) {
                                                            e(nqbVar);
                                                        }
                                                        int[] iArr5 = nqbVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        eqb.d(eqbVar);
                                                        kqb kqbVar2 = nqbVar.m;
                                                        int[] iArr6 = kqbVar2.b;
                                                        int[] iArr7 = kqbVar2.c;
                                                        byte[] bArr3 = nqbVar.H;
                                                        int i24 = nqbVar.C;
                                                        int i25 = nqbVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], eqbVar);
                                                        nqbVar.G = r3;
                                                        int i26 = nqbVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            nqbVar.G = i27;
                                                            int i28 = nqbVar.J & i27;
                                                            int i29 = i27 >>> nqbVar.K;
                                                            nqbVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            nqbVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + eqb.i(eqbVar, i30)) << nqbVar.K);
                                                        }
                                                    }
                                                    int t = t(nqbVar.G, nqbVar.q, nqbVar.t);
                                                    nqbVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = nqbVar.s;
                                                        int i32 = nqbVar.O;
                                                        if (i31 != i32 && (i6 = nqbVar.r) < i32) {
                                                            nqbVar.s = i6;
                                                        } else {
                                                            nqbVar.s = nqbVar.O;
                                                        }
                                                        nqbVar.N = nqbVar.r;
                                                        int i33 = nqbVar.L;
                                                        if (i33 > nqbVar.s) {
                                                            nqbVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (nqbVar.G > 0) {
                                                                int[] iArr8 = nqbVar.q;
                                                                int i34 = nqbVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                nqbVar.t = i34 + 1;
                                                            }
                                                            if (nqbVar.M <= nqbVar.g) {
                                                                nqbVar.x = 0;
                                                                nqbVar.a = 7;
                                                                int i35 = nqbVar.r;
                                                                i = (i35 - nqbVar.L) & i9;
                                                                i2 = nqbVar.M - nqbVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    nqbVar.x += i2;
                                                                    nqbVar.g -= i2;
                                                                    nqbVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = nqbVar.x;
                                                                        if (i3 >= nqbVar.M) {
                                                                            i4 = nqbVar.r;
                                                                            bArr[i4] = bArr[(i4 - nqbVar.L) & i9];
                                                                            nqbVar.g--;
                                                                            nqbVar.x = i3 + 1;
                                                                            nqbVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    nqbVar.b = 7;
                                                                    nqbVar.Y = nqbVar.Q;
                                                                    nqbVar.X = 0;
                                                                    nqbVar.a = 12;
                                                                    if (nqbVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        nqbVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (nqbVar.a != i5) {
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
                                        if (nqbVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (nqbVar.g > 0) {
                                            eqb.j(eqbVar);
                                            eqb.i(eqbVar, 8);
                                            nqbVar.g--;
                                        }
                                        nqbVar.a = 1;
                                        break;
                                    case 5:
                                        a(nqbVar);
                                        break;
                                    case 6:
                                        if (nqbVar.u) {
                                        }
                                        if (nqbVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = nqbVar.r;
                                        i = (i352 - nqbVar.L) & i9;
                                        i2 = nqbVar.M - nqbVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = nqbVar.x;
                                            if (i3 >= nqbVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        nqbVar.b = 7;
                                        nqbVar.Y = nqbVar.Q;
                                        nqbVar.X = 0;
                                        nqbVar.a = 12;
                                        if (nqbVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = nqbVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, nqbVar.N - i36);
                                        nqbVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = nqbVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = iqb.a[i37];
                                            int i39 = (nqbVar.L - nqbVar.s) - 1;
                                            int i40 = iqb.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < oqb.d.length) {
                                                int b2 = oqb.b(bArr, nqbVar.N, iqb.a(), i43, nqbVar.M, oqb.d[i42]);
                                                int i44 = nqbVar.N + b2;
                                                nqbVar.N = i44;
                                                nqbVar.r += b2;
                                                nqbVar.g -= b2;
                                                int i45 = nqbVar.Q;
                                                if (i44 >= i45) {
                                                    nqbVar.b = 8;
                                                    nqbVar.Y = i45;
                                                    nqbVar.X = 0;
                                                    nqbVar.a = 12;
                                                    break;
                                                } else {
                                                    nqbVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + nqbVar.a);
                                }
                            } else if (!u(nqbVar)) {
                                return;
                            } else {
                                int i46 = nqbVar.r;
                                int i47 = nqbVar.O;
                                if (i46 >= i47) {
                                    nqbVar.s = i47;
                                }
                                nqbVar.r &= i9;
                                nqbVar.a = nqbVar.b;
                            }
                        } else if (i10 == 10) {
                            if (nqbVar.g >= 0) {
                                eqb.g(eqbVar);
                                eqb.a(nqbVar.c, true);
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

    public static void s(nqb nqbVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, nqbVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            nqbVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, eqb eqbVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, eqbVar)) == null) {
            eqb.d(eqbVar);
            int r = r(iArr, i, eqbVar);
            return mqb.a[r] + eqb.i(eqbVar, mqb.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, eqb eqbVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), eqbVar}) == null) {
            eqb.j(eqbVar);
            int[] iArr2 = new int[i];
            int i3 = eqb.i(eqbVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = eqb.i(eqbVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = eqb.i(eqbVar, i6) % i;
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
                            if (eqb.i(eqbVar, 1) == 1) {
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
                    jqb.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                eqb.d(eqbVar);
                long j = eqbVar.f;
                int i11 = eqbVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                eqbVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, eqbVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.pqb.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, eqb eqbVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, eqbVar) == null) {
            int[] iArr3 = new int[32];
            jqb.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    eqb.j(eqbVar);
                    eqb.d(eqbVar);
                    long j = eqbVar.f;
                    int i9 = eqbVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    eqbVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + eqb.i(eqbVar, i13) + 3;
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

    public static void p(nqb nqbVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, nqbVar) == null) {
            eqb eqbVar = nqbVar.c;
            for (int i = 0; i < 3; i++) {
                nqbVar.o[i] = h(eqbVar) + 1;
                nqbVar.n[i] = 268435456;
                int[] iArr2 = nqbVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, nqbVar.e, i2, eqbVar);
                    n(26, nqbVar.f, i2, eqbVar);
                    nqbVar.n[i] = m(nqbVar.f, i2, eqbVar);
                }
            }
            eqb.j(eqbVar);
            nqbVar.K = eqb.i(eqbVar, 2);
            int i3 = eqb.i(eqbVar, 4);
            int i4 = nqbVar.K;
            int i5 = (i3 << i4) + 16;
            nqbVar.I = i5;
            nqbVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            nqbVar.z = new byte[nqbVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = nqbVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    nqbVar.z[i7] = (byte) (eqb.i(eqbVar, 2) << 1);
                    i7++;
                }
                eqb.j(eqbVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            nqbVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, eqbVar);
            nqbVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (nqbVar.o[0] << 6)) {
                    break;
                } else if (nqbVar.A[i8] != (i8 >> 6)) {
                    nqbVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = nqbVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            nqbVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, eqbVar);
            kqb.b(nqbVar.k, 256, d2);
            kqb.b(nqbVar.l, 704, nqbVar.o[1]);
            kqb.b(nqbVar.m, i6, d3);
            kqb.a(nqbVar.k, eqbVar);
            kqb.a(nqbVar.l, eqbVar);
            kqb.a(nqbVar.m, eqbVar);
            nqbVar.B = 0;
            nqbVar.C = 0;
            int[] iArr4 = gqb.b;
            byte[] bArr3 = nqbVar.z;
            nqbVar.D = iArr4[bArr3[0]];
            nqbVar.E = iArr4[bArr3[0] + 1];
            nqbVar.v = 0;
            nqbVar.w = nqbVar.k.c[0];
            nqbVar.F = nqbVar.l.c[0];
            int[] iArr5 = nqbVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(nqb nqbVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, nqbVar) == null) {
            eqb eqbVar = nqbVar.c;
            if (nqbVar.h) {
                nqbVar.b = 10;
                nqbVar.Y = nqbVar.r;
                nqbVar.X = 0;
                nqbVar.a = 12;
                return;
            }
            kqb kqbVar = nqbVar.k;
            kqbVar.b = null;
            kqbVar.c = null;
            kqb kqbVar2 = nqbVar.l;
            kqbVar2.b = null;
            kqbVar2.c = null;
            kqb kqbVar3 = nqbVar.m;
            kqbVar3.b = null;
            kqbVar3.c = null;
            eqb.j(eqbVar);
            g(eqbVar, nqbVar);
            if (nqbVar.g == 0 && !nqbVar.j) {
                return;
            }
            if (!nqbVar.i && !nqbVar.j) {
                nqbVar.a = 2;
            } else {
                eqb.g(eqbVar);
                if (nqbVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                nqbVar.a = i;
            }
            if (nqbVar.j) {
                return;
            }
            nqbVar.R += nqbVar.g;
            if (nqbVar.Q < nqbVar.P) {
                k(nqbVar);
            }
        }
    }

    public static int r(int[] iArr, int i, eqb eqbVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, eqbVar)) == null) {
            long j = eqbVar.f;
            int i2 = eqbVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                eqbVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            eqbVar.g = i2 + (iArr[i7] >> 16) + 8;
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
