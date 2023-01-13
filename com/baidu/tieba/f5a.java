package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes4.dex */
public final class f5a {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947716503, "Lcom/baidu/tieba/f5a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947716503, "Lcom/baidu/tieba/f5a;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(l5a l5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, l5aVar) == null) {
            c5a c5aVar = l5aVar.c;
            byte[] bArr = l5aVar.d;
            int i = l5aVar.g;
            if (i <= 0) {
                c5a.k(c5aVar);
                l5aVar.a = 1;
                return;
            }
            int min = Math.min(l5aVar.Q - l5aVar.r, i);
            c5a.c(c5aVar, bArr, l5aVar.r, min);
            l5aVar.g -= min;
            int i2 = l5aVar.r + min;
            l5aVar.r = i2;
            int i3 = l5aVar.Q;
            if (i2 == i3) {
                l5aVar.b = 5;
                l5aVar.Y = i3;
                l5aVar.X = 0;
                l5aVar.a = 12;
                return;
            }
            c5a.k(c5aVar);
            l5aVar.a = 1;
        }
    }

    public static void k(l5a l5aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, l5aVar) == null) {
            int i2 = l5aVar.P;
            long j = l5aVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + l5aVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!l5aVar.h && i2 < 16384 && l5aVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = l5aVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = l5aVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = l5aVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = l5aVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(l5aVar.S, i, bArr, 0, i5);
                    l5aVar.r = i5;
                    l5aVar.T = i5;
                }
            }
            l5aVar.d = bArr;
            l5aVar.Q = i2;
        }
    }

    public static boolean u(l5a l5aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, l5aVar)) == null) {
            int i = l5aVar.T;
            if (i != 0) {
                l5aVar.X += i;
                l5aVar.T = 0;
            }
            int min = Math.min(l5aVar.V - l5aVar.W, l5aVar.Y - l5aVar.X);
            if (min != 0) {
                System.arraycopy(l5aVar.d, l5aVar.X, l5aVar.Z, l5aVar.U + l5aVar.W, min);
                l5aVar.W += min;
                l5aVar.X += min;
            }
            if (l5aVar.W >= l5aVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(l5a l5aVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, l5aVar, i) == null) {
            c5a c5aVar = l5aVar.c;
            int[] iArr = l5aVar.p;
            int i3 = i * 2;
            c5a.d(c5aVar);
            int i4 = i * 1080;
            int r = r(l5aVar.e, i4, c5aVar);
            l5aVar.n[i] = m(l5aVar.f, i4, c5aVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = l5aVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(l5a l5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, l5aVar) == null) {
            b(l5aVar, 1);
            l5aVar.F = l5aVar.l.c[l5aVar.p[3]];
        }
    }

    public static void e(l5a l5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, l5aVar) == null) {
            b(l5aVar, 2);
            l5aVar.C = l5aVar.p[5] << 2;
        }
    }

    public static int h(c5a c5aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, c5aVar)) == null) {
            if (c5a.i(c5aVar, 1) != 0) {
                int i = c5a.i(c5aVar, 3);
                if (i == 0) {
                    return 1;
                }
                return c5a.i(c5aVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, c5a c5aVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, c5aVar)) == null) {
            c5a.j(c5aVar);
            int h = h(c5aVar) + 1;
            if (h == 1) {
                n5a.a(bArr, 0, i);
                return h;
            }
            if (c5a.i(c5aVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = c5a.i(c5aVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, c5aVar);
            int i3 = 0;
            while (i3 < i) {
                c5a.j(c5aVar);
                c5a.d(c5aVar);
                int r = r(iArr, 0, c5aVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + c5a.i(c5aVar, r); i4 != 0; i4--) {
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
            if (c5a.i(c5aVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(l5a l5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, l5aVar) == null) {
            b(l5aVar, 0);
            int i = l5aVar.p[1];
            int i2 = i << 6;
            l5aVar.B = i2;
            int i3 = l5aVar.A[i2] & 255;
            l5aVar.v = i3;
            l5aVar.w = l5aVar.k.c[i3];
            byte b2 = l5aVar.z[i];
            int[] iArr = e5a.b;
            l5aVar.D = iArr[b2];
            l5aVar.E = iArr[b2 + 1];
        }
    }

    public static void g(c5a c5aVar, l5a l5aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, c5aVar, l5aVar) == null) {
            boolean z2 = true;
            if (c5a.i(c5aVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            l5aVar.h = z;
            l5aVar.g = 0;
            l5aVar.i = false;
            l5aVar.j = false;
            if (z && c5a.i(c5aVar, 1) != 0) {
                return;
            }
            int i = c5a.i(c5aVar, 2) + 4;
            if (i == 7) {
                l5aVar.j = true;
                if (c5a.i(c5aVar, 1) == 0) {
                    int i2 = c5a.i(c5aVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = c5a.i(c5aVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        l5aVar.g = (i4 << (i3 * 8)) | l5aVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = c5a.i(c5aVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    l5aVar.g = (i6 << (i5 * 4)) | l5aVar.g;
                }
            }
            l5aVar.g++;
            if (!l5aVar.h) {
                if (c5a.i(c5aVar, 1) != 1) {
                    z2 = false;
                }
                l5aVar.i = z2;
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
    public static void i(l5a l5aVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, l5aVar) == null) {
            int i8 = l5aVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    c5a c5aVar = l5aVar.c;
                    int i9 = l5aVar.Q - 1;
                    byte[] bArr = l5aVar.d;
                    while (true) {
                        int i10 = l5aVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (l5aVar.g >= 0) {
                                            q(l5aVar);
                                            i9 = l5aVar.Q - 1;
                                            bArr = l5aVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(l5aVar);
                                        l5aVar.a = 3;
                                        if (l5aVar.g > 0) {
                                            l5aVar.a = 1;
                                            break;
                                        } else {
                                            c5a.j(c5aVar);
                                            if (l5aVar.n[1] == 0) {
                                                c(l5aVar);
                                            }
                                            int[] iArr = l5aVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            c5a.d(c5aVar);
                                            int r = r(l5aVar.l.b, l5aVar.F, c5aVar);
                                            int i12 = r >>> 6;
                                            l5aVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                l5aVar.G = -1;
                                            }
                                            int i13 = k5a.g[i12] + ((r >>> 3) & 7);
                                            int i14 = k5a.h[i12] + (r & 7);
                                            l5aVar.y = k5a.c[i13] + c5a.i(c5aVar, k5a.d[i13]);
                                            l5aVar.M = k5a.e[i14] + c5a.i(c5aVar, k5a.f[i14]);
                                            l5aVar.x = 0;
                                            l5aVar.a = 6;
                                            if (l5aVar.u) {
                                                int i15 = l5aVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (l5aVar.x < l5aVar.y) {
                                                        c5a.j(c5aVar);
                                                        if (l5aVar.n[0] == 0) {
                                                            f(l5aVar);
                                                        }
                                                        byte[] bArr2 = l5aVar.A;
                                                        int i18 = l5aVar.B;
                                                        int[] iArr2 = e5a.a;
                                                        int i19 = iArr2[l5aVar.D + i16];
                                                        int[] iArr3 = l5aVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        c5a.d(c5aVar);
                                                        i5a i5aVar = l5aVar.k;
                                                        int r2 = r(i5aVar.b, i5aVar.c[bArr2[i18 + (iArr2[l5aVar.E + i17] | i19)] & 255], c5aVar);
                                                        int i20 = l5aVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        l5aVar.x++;
                                                        l5aVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            l5aVar.b = 6;
                                                            l5aVar.Y = l5aVar.Q;
                                                            l5aVar.X = 0;
                                                            l5aVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (l5aVar.x < l5aVar.y) {
                                                        c5a.j(c5aVar);
                                                        if (l5aVar.n[0] == 0) {
                                                            f(l5aVar);
                                                        }
                                                        int[] iArr4 = l5aVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        c5a.d(c5aVar);
                                                        bArr[l5aVar.r] = (byte) r(l5aVar.k.b, l5aVar.w, c5aVar);
                                                        l5aVar.x++;
                                                        int i22 = l5aVar.r;
                                                        l5aVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            l5aVar.b = 6;
                                                            l5aVar.Y = l5aVar.Q;
                                                            l5aVar.X = 0;
                                                            l5aVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (l5aVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = l5aVar.g - l5aVar.y;
                                                l5aVar.g = i23;
                                                if (i23 <= 0) {
                                                    l5aVar.a = 3;
                                                    break;
                                                } else {
                                                    if (l5aVar.G < 0) {
                                                        c5a.j(c5aVar);
                                                        if (l5aVar.n[2] == 0) {
                                                            e(l5aVar);
                                                        }
                                                        int[] iArr5 = l5aVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        c5a.d(c5aVar);
                                                        i5a i5aVar2 = l5aVar.m;
                                                        int[] iArr6 = i5aVar2.b;
                                                        int[] iArr7 = i5aVar2.c;
                                                        byte[] bArr3 = l5aVar.H;
                                                        int i24 = l5aVar.C;
                                                        int i25 = l5aVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], c5aVar);
                                                        l5aVar.G = r3;
                                                        int i26 = l5aVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            l5aVar.G = i27;
                                                            int i28 = l5aVar.J & i27;
                                                            int i29 = i27 >>> l5aVar.K;
                                                            l5aVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            l5aVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + c5a.i(c5aVar, i30)) << l5aVar.K);
                                                        }
                                                    }
                                                    int t = t(l5aVar.G, l5aVar.q, l5aVar.t);
                                                    l5aVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = l5aVar.s;
                                                        int i32 = l5aVar.O;
                                                        if (i31 != i32 && (i6 = l5aVar.r) < i32) {
                                                            l5aVar.s = i6;
                                                        } else {
                                                            l5aVar.s = l5aVar.O;
                                                        }
                                                        l5aVar.N = l5aVar.r;
                                                        int i33 = l5aVar.L;
                                                        if (i33 > l5aVar.s) {
                                                            l5aVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (l5aVar.G > 0) {
                                                                int[] iArr8 = l5aVar.q;
                                                                int i34 = l5aVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                l5aVar.t = i34 + 1;
                                                            }
                                                            if (l5aVar.M <= l5aVar.g) {
                                                                l5aVar.x = 0;
                                                                l5aVar.a = 7;
                                                                int i35 = l5aVar.r;
                                                                i = (i35 - l5aVar.L) & i9;
                                                                i2 = l5aVar.M - l5aVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    l5aVar.x += i2;
                                                                    l5aVar.g -= i2;
                                                                    l5aVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = l5aVar.x;
                                                                        if (i3 >= l5aVar.M) {
                                                                            i4 = l5aVar.r;
                                                                            bArr[i4] = bArr[(i4 - l5aVar.L) & i9];
                                                                            l5aVar.g--;
                                                                            l5aVar.x = i3 + 1;
                                                                            l5aVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    l5aVar.b = 7;
                                                                    l5aVar.Y = l5aVar.Q;
                                                                    l5aVar.X = 0;
                                                                    l5aVar.a = 12;
                                                                    if (l5aVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        l5aVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (l5aVar.a != i5) {
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
                                        if (l5aVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (l5aVar.g > 0) {
                                            c5a.j(c5aVar);
                                            c5a.i(c5aVar, 8);
                                            l5aVar.g--;
                                        }
                                        l5aVar.a = 1;
                                        break;
                                    case 5:
                                        a(l5aVar);
                                        break;
                                    case 6:
                                        if (l5aVar.u) {
                                        }
                                        if (l5aVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = l5aVar.r;
                                        i = (i352 - l5aVar.L) & i9;
                                        i2 = l5aVar.M - l5aVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = l5aVar.x;
                                            if (i3 >= l5aVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        l5aVar.b = 7;
                                        l5aVar.Y = l5aVar.Q;
                                        l5aVar.X = 0;
                                        l5aVar.a = 12;
                                        if (l5aVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = l5aVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, l5aVar.N - i36);
                                        l5aVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = l5aVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = g5a.a[i37];
                                            int i39 = (l5aVar.L - l5aVar.s) - 1;
                                            int i40 = g5a.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < m5a.d.length) {
                                                int b2 = m5a.b(bArr, l5aVar.N, g5a.a(), i43, l5aVar.M, m5a.d[i42]);
                                                int i44 = l5aVar.N + b2;
                                                l5aVar.N = i44;
                                                l5aVar.r += b2;
                                                l5aVar.g -= b2;
                                                int i45 = l5aVar.Q;
                                                if (i44 >= i45) {
                                                    l5aVar.b = 8;
                                                    l5aVar.Y = i45;
                                                    l5aVar.X = 0;
                                                    l5aVar.a = 12;
                                                    break;
                                                } else {
                                                    l5aVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + l5aVar.a);
                                }
                            } else if (!u(l5aVar)) {
                                return;
                            } else {
                                int i46 = l5aVar.r;
                                int i47 = l5aVar.O;
                                if (i46 >= i47) {
                                    l5aVar.s = i47;
                                }
                                l5aVar.r &= i9;
                                l5aVar.a = l5aVar.b;
                            }
                        } else if (i10 == 10) {
                            if (l5aVar.g >= 0) {
                                c5a.g(c5aVar);
                                c5a.a(l5aVar.c, true);
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

    public static void s(l5a l5aVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, l5aVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            l5aVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, c5a c5aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, c5aVar)) == null) {
            c5a.d(c5aVar);
            int r = r(iArr, i, c5aVar);
            return k5a.a[r] + c5a.i(c5aVar, k5a.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, c5a c5aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), c5aVar}) == null) {
            c5a.j(c5aVar);
            int[] iArr2 = new int[i];
            int i3 = c5a.i(c5aVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = c5a.i(c5aVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = c5a.i(c5aVar, i6) % i;
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
                            if (c5a.i(c5aVar, 1) == 1) {
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
                    h5a.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                c5a.d(c5aVar);
                long j = c5aVar.f;
                int i11 = c5aVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                c5aVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, c5aVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.n5a.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, c5a c5aVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, c5aVar) == null) {
            int[] iArr3 = new int[32];
            h5a.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    c5a.j(c5aVar);
                    c5a.d(c5aVar);
                    long j = c5aVar.f;
                    int i9 = c5aVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    c5aVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + c5a.i(c5aVar, i13) + 3;
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

    public static void p(l5a l5aVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, l5aVar) == null) {
            c5a c5aVar = l5aVar.c;
            for (int i = 0; i < 3; i++) {
                l5aVar.o[i] = h(c5aVar) + 1;
                l5aVar.n[i] = 268435456;
                int[] iArr2 = l5aVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, l5aVar.e, i2, c5aVar);
                    n(26, l5aVar.f, i2, c5aVar);
                    l5aVar.n[i] = m(l5aVar.f, i2, c5aVar);
                }
            }
            c5a.j(c5aVar);
            l5aVar.K = c5a.i(c5aVar, 2);
            int i3 = c5a.i(c5aVar, 4);
            int i4 = l5aVar.K;
            int i5 = (i3 << i4) + 16;
            l5aVar.I = i5;
            l5aVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            l5aVar.z = new byte[l5aVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = l5aVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    l5aVar.z[i7] = (byte) (c5a.i(c5aVar, 2) << 1);
                    i7++;
                }
                c5a.j(c5aVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            l5aVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, c5aVar);
            l5aVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (l5aVar.o[0] << 6)) {
                    break;
                } else if (l5aVar.A[i8] != (i8 >> 6)) {
                    l5aVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = l5aVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            l5aVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, c5aVar);
            i5a.b(l5aVar.k, 256, d2);
            i5a.b(l5aVar.l, 704, l5aVar.o[1]);
            i5a.b(l5aVar.m, i6, d3);
            i5a.a(l5aVar.k, c5aVar);
            i5a.a(l5aVar.l, c5aVar);
            i5a.a(l5aVar.m, c5aVar);
            l5aVar.B = 0;
            l5aVar.C = 0;
            int[] iArr4 = e5a.b;
            byte[] bArr3 = l5aVar.z;
            l5aVar.D = iArr4[bArr3[0]];
            l5aVar.E = iArr4[bArr3[0] + 1];
            l5aVar.v = 0;
            l5aVar.w = l5aVar.k.c[0];
            l5aVar.F = l5aVar.l.c[0];
            int[] iArr5 = l5aVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(l5a l5aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, l5aVar) == null) {
            c5a c5aVar = l5aVar.c;
            if (l5aVar.h) {
                l5aVar.b = 10;
                l5aVar.Y = l5aVar.r;
                l5aVar.X = 0;
                l5aVar.a = 12;
                return;
            }
            i5a i5aVar = l5aVar.k;
            i5aVar.b = null;
            i5aVar.c = null;
            i5a i5aVar2 = l5aVar.l;
            i5aVar2.b = null;
            i5aVar2.c = null;
            i5a i5aVar3 = l5aVar.m;
            i5aVar3.b = null;
            i5aVar3.c = null;
            c5a.j(c5aVar);
            g(c5aVar, l5aVar);
            if (l5aVar.g == 0 && !l5aVar.j) {
                return;
            }
            if (!l5aVar.i && !l5aVar.j) {
                l5aVar.a = 2;
            } else {
                c5a.g(c5aVar);
                if (l5aVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                l5aVar.a = i;
            }
            if (l5aVar.j) {
                return;
            }
            l5aVar.R += l5aVar.g;
            if (l5aVar.Q < l5aVar.P) {
                k(l5aVar);
            }
        }
    }

    public static int r(int[] iArr, int i, c5a c5aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, c5aVar)) == null) {
            long j = c5aVar.f;
            int i2 = c5aVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                c5aVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            c5aVar.g = i2 + (iArr[i7] >> 16) + 8;
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
