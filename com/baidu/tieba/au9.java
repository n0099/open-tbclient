package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes3.dex */
public final class au9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947627812, "Lcom/baidu/tieba/au9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947627812, "Lcom/baidu/tieba/au9;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(gu9 gu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, gu9Var) == null) {
            xt9 xt9Var = gu9Var.c;
            byte[] bArr = gu9Var.d;
            int i = gu9Var.g;
            if (i <= 0) {
                xt9.k(xt9Var);
                gu9Var.a = 1;
                return;
            }
            int min = Math.min(gu9Var.Q - gu9Var.r, i);
            xt9.c(xt9Var, bArr, gu9Var.r, min);
            gu9Var.g -= min;
            int i2 = gu9Var.r + min;
            gu9Var.r = i2;
            int i3 = gu9Var.Q;
            if (i2 == i3) {
                gu9Var.b = 5;
                gu9Var.Y = i3;
                gu9Var.X = 0;
                gu9Var.a = 12;
                return;
            }
            xt9.k(xt9Var);
            gu9Var.a = 1;
        }
    }

    public static void b(gu9 gu9Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, gu9Var, i) == null) {
            xt9 xt9Var = gu9Var.c;
            int[] iArr = gu9Var.p;
            int i3 = i * 2;
            xt9.d(xt9Var);
            int i4 = i * 1080;
            int r = r(gu9Var.e, i4, xt9Var);
            gu9Var.n[i] = m(gu9Var.f, i4, xt9Var);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else {
                i2 = r == 0 ? iArr[i3] : r - 2;
            }
            int[] iArr2 = gu9Var.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(gu9 gu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gu9Var) == null) {
            b(gu9Var, 1);
            gu9Var.F = gu9Var.l.c[gu9Var.p[3]];
        }
    }

    public static int d(int i, byte[] bArr, xt9 xt9Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, xt9Var)) == null) {
            xt9.j(xt9Var);
            int h = h(xt9Var) + 1;
            if (h == 1) {
                iu9.a(bArr, 0, i);
                return h;
            }
            int i2 = xt9.i(xt9Var, 1) == 1 ? xt9.i(xt9Var, 4) + 1 : 0;
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, xt9Var);
            int i3 = 0;
            while (i3 < i) {
                xt9.j(xt9Var);
                xt9.d(xt9Var);
                int r = r(iArr, 0, xt9Var);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + xt9.i(xt9Var, r); i4 != 0; i4--) {
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
            if (xt9.i(xt9Var, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void e(gu9 gu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, gu9Var) == null) {
            b(gu9Var, 2);
            gu9Var.C = gu9Var.p[5] << 2;
        }
    }

    public static void f(gu9 gu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, gu9Var) == null) {
            b(gu9Var, 0);
            int i = gu9Var.p[1];
            int i2 = i << 6;
            gu9Var.B = i2;
            int i3 = gu9Var.A[i2] & 255;
            gu9Var.v = i3;
            gu9Var.w = gu9Var.k.c[i3];
            byte b2 = gu9Var.z[i];
            int[] iArr = zt9.b;
            gu9Var.D = iArr[b2];
            gu9Var.E = iArr[b2 + 1];
        }
    }

    public static void g(xt9 xt9Var, gu9 gu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, xt9Var, gu9Var) == null) {
            boolean z = xt9.i(xt9Var, 1) == 1;
            gu9Var.h = z;
            gu9Var.g = 0;
            gu9Var.i = false;
            gu9Var.j = false;
            if (!z || xt9.i(xt9Var, 1) == 0) {
                int i = xt9.i(xt9Var, 2) + 4;
                if (i == 7) {
                    gu9Var.j = true;
                    if (xt9.i(xt9Var, 1) == 0) {
                        int i2 = xt9.i(xt9Var, 2);
                        if (i2 == 0) {
                            return;
                        }
                        for (int i3 = 0; i3 < i2; i3++) {
                            int i4 = xt9.i(xt9Var, 8);
                            if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                                throw new BrotliRuntimeException("Exuberant nibble");
                            }
                            gu9Var.g = (i4 << (i3 * 8)) | gu9Var.g;
                        }
                    } else {
                        throw new BrotliRuntimeException("Corrupted reserved bit");
                    }
                } else {
                    for (int i5 = 0; i5 < i; i5++) {
                        int i6 = xt9.i(xt9Var, 4);
                        if (i6 == 0 && i5 + 1 == i && i > 4) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        gu9Var.g = (i6 << (i5 * 4)) | gu9Var.g;
                    }
                }
                gu9Var.g++;
                if (gu9Var.h) {
                    return;
                }
                gu9Var.i = xt9.i(xt9Var, 1) == 1;
            }
        }
    }

    public static int h(xt9 xt9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, xt9Var)) == null) {
            if (xt9.i(xt9Var, 1) != 0) {
                int i = xt9.i(xt9Var, 3);
                if (i == 0) {
                    return 1;
                }
                return xt9.i(xt9Var, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
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
    public static void i(gu9 gu9Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65545, null, gu9Var) != null) {
            return;
        }
        int i7 = gu9Var.a;
        if (i7 == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (i7 != 11) {
            xt9 xt9Var = gu9Var.c;
            int i8 = gu9Var.Q - 1;
            byte[] bArr = gu9Var.d;
            while (true) {
                int i9 = gu9Var.a;
                if (i9 == 10) {
                    if (i9 == 10) {
                        if (gu9Var.g >= 0) {
                            xt9.g(xt9Var);
                            xt9.a(gu9Var.c, true);
                            return;
                        }
                        throw new BrotliRuntimeException("Invalid metablock length");
                    }
                    return;
                } else if (i9 != 12) {
                    int i10 = 0;
                    switch (i9) {
                        case 1:
                            if (gu9Var.g >= 0) {
                                q(gu9Var);
                                i8 = gu9Var.Q - 1;
                                bArr = gu9Var.d;
                                break;
                            } else {
                                throw new BrotliRuntimeException("Invalid metablock length");
                            }
                        case 2:
                            p(gu9Var);
                            gu9Var.a = 3;
                            if (gu9Var.g > 0) {
                                gu9Var.a = 1;
                                break;
                            } else {
                                xt9.j(xt9Var);
                                if (gu9Var.n[1] == 0) {
                                    c(gu9Var);
                                }
                                int[] iArr = gu9Var.n;
                                iArr[1] = iArr[1] - 1;
                                xt9.d(xt9Var);
                                int r = r(gu9Var.l.b, gu9Var.F, xt9Var);
                                int i11 = r >>> 6;
                                gu9Var.G = 0;
                                if (i11 >= 2) {
                                    i11 -= 2;
                                    gu9Var.G = -1;
                                }
                                int i12 = fu9.g[i11] + ((r >>> 3) & 7);
                                int i13 = fu9.h[i11] + (r & 7);
                                gu9Var.y = fu9.c[i12] + xt9.i(xt9Var, fu9.d[i12]);
                                gu9Var.M = fu9.e[i13] + xt9.i(xt9Var, fu9.f[i13]);
                                gu9Var.x = 0;
                                gu9Var.a = 6;
                                if (gu9Var.u) {
                                    int i14 = gu9Var.r;
                                    int i15 = bArr[(i14 - 1) & i8] & 255;
                                    int i16 = bArr[(i14 - 2) & i8] & 255;
                                    while (true) {
                                        if (gu9Var.x < gu9Var.y) {
                                            xt9.j(xt9Var);
                                            if (gu9Var.n[0] == 0) {
                                                f(gu9Var);
                                            }
                                            byte[] bArr2 = gu9Var.A;
                                            int i17 = gu9Var.B;
                                            int[] iArr2 = zt9.a;
                                            int i18 = iArr2[gu9Var.D + i15];
                                            int[] iArr3 = gu9Var.n;
                                            iArr3[0] = iArr3[0] - 1;
                                            xt9.d(xt9Var);
                                            du9 du9Var = gu9Var.k;
                                            int r2 = r(du9Var.b, du9Var.c[bArr2[i17 + (iArr2[gu9Var.E + i16] | i18)] & 255], xt9Var);
                                            int i19 = gu9Var.r;
                                            bArr[i19] = (byte) r2;
                                            gu9Var.x++;
                                            gu9Var.r = i19 + 1;
                                            if (i19 == i8) {
                                                gu9Var.b = 6;
                                                gu9Var.Y = gu9Var.Q;
                                                gu9Var.X = 0;
                                                gu9Var.a = 12;
                                            } else {
                                                int i20 = i15;
                                                i15 = r2;
                                                i16 = i20;
                                            }
                                        }
                                    }
                                } else {
                                    while (true) {
                                        if (gu9Var.x < gu9Var.y) {
                                            xt9.j(xt9Var);
                                            if (gu9Var.n[0] == 0) {
                                                f(gu9Var);
                                            }
                                            int[] iArr4 = gu9Var.n;
                                            iArr4[0] = iArr4[0] - 1;
                                            xt9.d(xt9Var);
                                            bArr[gu9Var.r] = (byte) r(gu9Var.k.b, gu9Var.w, xt9Var);
                                            gu9Var.x++;
                                            int i21 = gu9Var.r;
                                            gu9Var.r = i21 + 1;
                                            if (i21 == i8) {
                                                gu9Var.b = 6;
                                                gu9Var.Y = gu9Var.Q;
                                                gu9Var.X = 0;
                                                gu9Var.a = 12;
                                            }
                                        }
                                    }
                                }
                                if (gu9Var.a == 6) {
                                    continue;
                                } else {
                                    int i22 = gu9Var.g - gu9Var.y;
                                    gu9Var.g = i22;
                                    if (i22 <= 0) {
                                        gu9Var.a = 3;
                                        break;
                                    } else {
                                        if (gu9Var.G < 0) {
                                            xt9.j(xt9Var);
                                            if (gu9Var.n[2] == 0) {
                                                e(gu9Var);
                                            }
                                            int[] iArr5 = gu9Var.n;
                                            iArr5[2] = iArr5[2] - 1;
                                            xt9.d(xt9Var);
                                            du9 du9Var2 = gu9Var.m;
                                            int[] iArr6 = du9Var2.b;
                                            int[] iArr7 = du9Var2.c;
                                            byte[] bArr3 = gu9Var.H;
                                            int i23 = gu9Var.C;
                                            int i24 = gu9Var.M;
                                            int r3 = r(iArr6, iArr7[bArr3[i23 + (i24 > 4 ? 3 : i24 - 2)] & 255], xt9Var);
                                            gu9Var.G = r3;
                                            int i25 = gu9Var.I;
                                            if (r3 >= i25) {
                                                int i26 = r3 - i25;
                                                gu9Var.G = i26;
                                                int i27 = gu9Var.J & i26;
                                                int i28 = i26 >>> gu9Var.K;
                                                gu9Var.G = i28;
                                                int i29 = (i28 >>> 1) + 1;
                                                gu9Var.G = i25 + i27 + ((((((i28 & 1) + 2) << i29) - 4) + xt9.i(xt9Var, i29)) << gu9Var.K);
                                            }
                                        }
                                        int t = t(gu9Var.G, gu9Var.q, gu9Var.t);
                                        gu9Var.L = t;
                                        if (t >= 0) {
                                            int i30 = gu9Var.s;
                                            int i31 = gu9Var.O;
                                            if (i30 != i31 && (i6 = gu9Var.r) < i31) {
                                                gu9Var.s = i6;
                                            } else {
                                                gu9Var.s = gu9Var.O;
                                            }
                                            gu9Var.N = gu9Var.r;
                                            int i32 = gu9Var.L;
                                            if (i32 > gu9Var.s) {
                                                gu9Var.a = 9;
                                                break;
                                            } else {
                                                if (gu9Var.G > 0) {
                                                    int[] iArr8 = gu9Var.q;
                                                    int i33 = gu9Var.t;
                                                    iArr8[i33 & 3] = i32;
                                                    gu9Var.t = i33 + 1;
                                                }
                                                if (gu9Var.M <= gu9Var.g) {
                                                    gu9Var.x = 0;
                                                    gu9Var.a = 7;
                                                    int i34 = gu9Var.r;
                                                    i = (i34 - gu9Var.L) & i8;
                                                    i2 = gu9Var.M - gu9Var.x;
                                                    if (i + i2 >= i8 && i34 + i2 < i8) {
                                                        while (i10 < i2) {
                                                            bArr[i34] = bArr[i];
                                                            i10++;
                                                            i34++;
                                                            i++;
                                                        }
                                                        gu9Var.x += i2;
                                                        gu9Var.g -= i2;
                                                        gu9Var.r += i2;
                                                    } else {
                                                        do {
                                                            i3 = gu9Var.x;
                                                            if (i3 >= gu9Var.M) {
                                                                i4 = gu9Var.r;
                                                                bArr[i4] = bArr[(i4 - gu9Var.L) & i8];
                                                                gu9Var.g--;
                                                                gu9Var.x = i3 + 1;
                                                                gu9Var.r = i4 + 1;
                                                            }
                                                        } while (i4 != i8);
                                                        i5 = 7;
                                                        gu9Var.b = 7;
                                                        gu9Var.Y = gu9Var.Q;
                                                        gu9Var.X = 0;
                                                        gu9Var.a = 12;
                                                        if (gu9Var.a != i5) {
                                                            break;
                                                        } else {
                                                            gu9Var.a = 3;
                                                            break;
                                                        }
                                                    }
                                                    i5 = 7;
                                                    if (gu9Var.a != i5) {
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
                            if (gu9Var.g > 0) {
                            }
                            break;
                        case 4:
                            while (gu9Var.g > 0) {
                                xt9.j(xt9Var);
                                xt9.i(xt9Var, 8);
                                gu9Var.g--;
                            }
                            gu9Var.a = 1;
                            break;
                        case 5:
                            a(gu9Var);
                            break;
                        case 6:
                            if (gu9Var.u) {
                            }
                            if (gu9Var.a == 6) {
                            }
                            break;
                        case 7:
                            int i342 = gu9Var.r;
                            i = (i342 - gu9Var.L) & i8;
                            i2 = gu9Var.M - gu9Var.x;
                            if (i + i2 >= i8) {
                                break;
                            }
                            do {
                                i3 = gu9Var.x;
                                if (i3 >= gu9Var.M) {
                                }
                            } while (i4 != i8);
                            i5 = 7;
                            gu9Var.b = 7;
                            gu9Var.Y = gu9Var.Q;
                            gu9Var.X = 0;
                            gu9Var.a = 12;
                            if (gu9Var.a != i5) {
                            }
                            break;
                        case 8:
                            int i35 = gu9Var.Q;
                            System.arraycopy(bArr, i35, bArr, 0, gu9Var.N - i35);
                            gu9Var.a = 3;
                            break;
                        case 9:
                            int i36 = gu9Var.M;
                            if (i36 >= 4 && i36 <= 24) {
                                int i37 = bu9.a[i36];
                                int i38 = (gu9Var.L - gu9Var.s) - 1;
                                int i39 = bu9.b[i36];
                                int i40 = ((1 << i39) - 1) & i38;
                                int i41 = i38 >>> i39;
                                int i42 = i37 + (i40 * i36);
                                if (i41 < hu9.d.length) {
                                    int b2 = hu9.b(bArr, gu9Var.N, bu9.a(), i42, gu9Var.M, hu9.d[i41]);
                                    int i43 = gu9Var.N + b2;
                                    gu9Var.N = i43;
                                    gu9Var.r += b2;
                                    gu9Var.g -= b2;
                                    int i44 = gu9Var.Q;
                                    if (i43 >= i44) {
                                        gu9Var.b = 8;
                                        gu9Var.Y = i44;
                                        gu9Var.X = 0;
                                        gu9Var.a = 12;
                                        break;
                                    } else {
                                        gu9Var.a = 3;
                                        break;
                                    }
                                } else {
                                    throw new BrotliRuntimeException("Invalid backward reference");
                                }
                            }
                            break;
                        default:
                            throw new BrotliRuntimeException("Unexpected state " + gu9Var.a);
                    }
                } else if (!u(gu9Var)) {
                    return;
                } else {
                    int i45 = gu9Var.r;
                    int i46 = gu9Var.O;
                    if (i45 >= i46) {
                        gu9Var.s = i46;
                    }
                    gu9Var.r &= i8;
                    gu9Var.a = gu9Var.b;
                }
            }
        } else {
            throw new IllegalStateException("Can't decompress after close");
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

    public static void k(gu9 gu9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, gu9Var) == null) {
            int i2 = gu9Var.P;
            long j = gu9Var.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + gu9Var.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!gu9Var.h && i2 < 16384 && gu9Var.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = gu9Var.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = gu9Var.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = gu9Var.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = gu9Var.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(gu9Var.S, i, bArr, 0, i5);
                    gu9Var.r = i5;
                    gu9Var.T = i5;
                }
            }
            gu9Var.d = bArr;
            gu9Var.Q = i2;
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

    public static int m(int[] iArr, int i, xt9 xt9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, xt9Var)) == null) {
            xt9.d(xt9Var);
            int r = r(iArr, i, xt9Var);
            return fu9.a[r] + xt9.i(xt9Var, fu9.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, xt9 xt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), xt9Var}) != null) {
            return;
        }
        xt9.j(xt9Var);
        int[] iArr2 = new int[i];
        int i3 = xt9.i(xt9Var, 2);
        boolean z = true;
        if (i3 == 1) {
            int i4 = i - 1;
            int[] iArr3 = new int[4];
            int i5 = xt9.i(xt9Var, 2) + 1;
            int i6 = 0;
            while (i4 != 0) {
                i4 >>= 1;
                i6++;
            }
            for (int i7 = 0; i7 < i5; i7++) {
                iArr3[i7] = xt9.i(xt9Var, i6) % i;
                iArr2[iArr3[i7]] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (i5 != 1) {
                if (i5 == 2) {
                    r5 = iArr3[0] != iArr3[1];
                    iArr2[iArr3[1]] = 1;
                } else if (i5 != 3) {
                    boolean z2 = (iArr3[0] == iArr3[1] || iArr3[0] == iArr3[2] || iArr3[0] == iArr3[3] || iArr3[1] == iArr3[2] || iArr3[1] == iArr3[3] || iArr3[2] == iArr3[3]) ? false : true;
                    if (xt9.i(xt9Var, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                    } else {
                        iArr2[iArr3[0]] = 2;
                    }
                    z = z2;
                } else if (iArr3[0] != iArr3[1] && iArr3[0] != iArr3[2] && iArr3[1] != iArr3[2]) {
                    r5 = true;
                }
            }
            if (!z) {
                cu9.a(iArr, i2, 8, iArr2, i);
                return;
            }
            throw new BrotliRuntimeException("Can't readHuffmanCode");
        }
        int[] iArr4 = new int[18];
        int i8 = 32;
        int i9 = 0;
        while (i3 < 18 && i8 > 0) {
            int i10 = a[i3];
            xt9.d(xt9Var);
            long j = xt9Var.f;
            int i11 = xt9Var.g;
            int i12 = ((int) (j >>> i11)) & 15;
            int[] iArr5 = d;
            xt9Var.g = i11 + (iArr5[i12] >> 16);
            int i13 = iArr5[i12] & 65535;
            iArr4[i10] = i13;
            if (i13 != 0) {
                i8 -= 32 >> i13;
                i9++;
            }
            i3++;
        }
        r5 = (i9 == 1 || i8 == 0) ? true : true;
        o(iArr4, i, iArr2, xt9Var);
        z = r5;
        if (!z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.iu9.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, xt9 xt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLILL(65551, null, iArr, i, iArr2, xt9Var) != null) {
            return;
        }
        int[] iArr3 = new int[32];
        cu9.a(iArr3, 0, 5, iArr, 18);
        int i2 = 8;
        int i3 = 0;
        int i4 = 32768;
        int i5 = 0;
        loop0: while (true) {
            int i6 = 0;
            while (i3 < i && i4 > 0) {
                xt9.j(xt9Var);
                xt9.d(xt9Var);
                long j = xt9Var.f;
                int i7 = xt9Var.g;
                int i8 = ((int) (j >>> i7)) & 31;
                xt9Var.g = i7 + (iArr3[i8] >> 16);
                int i9 = iArr3[i8] & 65535;
                if (i9 < 16) {
                    int i10 = i3 + 1;
                    iArr2[i3] = i9;
                    if (i9 != 0) {
                        i4 -= 32768 >> i9;
                        i3 = i10;
                        i2 = i9;
                    } else {
                        i3 = i10;
                    }
                } else {
                    int i11 = i9 - 14;
                    int i12 = i9 == 16 ? i2 : 0;
                    if (i5 != i12) {
                        i5 = i12;
                        i6 = 0;
                    }
                    int i13 = (i6 > 0 ? (i6 - 2) << i11 : i6) + xt9.i(xt9Var, i11) + 3;
                    int i14 = i13 - i6;
                    if (i3 + i14 > i) {
                        throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                    }
                    int i15 = 0;
                    while (i15 < i14) {
                        iArr2[i3] = i5;
                        i15++;
                        i3++;
                    }
                    if (i5 != 0) {
                        i4 -= i14 << (15 - i5);
                    }
                    i6 = i13;
                }
            }
        }
    }

    public static void p(gu9 gu9Var) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, gu9Var) == null) {
            xt9 xt9Var = gu9Var.c;
            for (int i = 0; i < 3; i++) {
                gu9Var.o[i] = h(xt9Var) + 1;
                gu9Var.n[i] = 268435456;
                int[] iArr2 = gu9Var.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, gu9Var.e, i2, xt9Var);
                    n(26, gu9Var.f, i2, xt9Var);
                    gu9Var.n[i] = m(gu9Var.f, i2, xt9Var);
                }
            }
            xt9.j(xt9Var);
            gu9Var.K = xt9.i(xt9Var, 2);
            int i3 = xt9.i(xt9Var, 4);
            int i4 = gu9Var.K;
            int i5 = (i3 << i4) + 16;
            gu9Var.I = i5;
            gu9Var.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            gu9Var.z = new byte[gu9Var.o[0]];
            int i7 = 0;
            while (true) {
                iArr = gu9Var.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    gu9Var.z[i7] = (byte) (xt9.i(xt9Var, 2) << 1);
                    i7++;
                }
                xt9.j(xt9Var);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            gu9Var.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, xt9Var);
            gu9Var.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (gu9Var.o[0] << 6)) {
                    break;
                } else if (gu9Var.A[i8] != (i8 >> 6)) {
                    gu9Var.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = gu9Var.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            gu9Var.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, xt9Var);
            du9.b(gu9Var.k, 256, d2);
            du9.b(gu9Var.l, 704, gu9Var.o[1]);
            du9.b(gu9Var.m, i6, d3);
            du9.a(gu9Var.k, xt9Var);
            du9.a(gu9Var.l, xt9Var);
            du9.a(gu9Var.m, xt9Var);
            gu9Var.B = 0;
            gu9Var.C = 0;
            int[] iArr4 = zt9.b;
            byte[] bArr3 = gu9Var.z;
            gu9Var.D = iArr4[bArr3[0]];
            gu9Var.E = iArr4[bArr3[0] + 1];
            gu9Var.v = 0;
            gu9Var.w = gu9Var.k.c[0];
            gu9Var.F = gu9Var.l.c[0];
            int[] iArr5 = gu9Var.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(gu9 gu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, gu9Var) == null) {
            xt9 xt9Var = gu9Var.c;
            if (gu9Var.h) {
                gu9Var.b = 10;
                gu9Var.Y = gu9Var.r;
                gu9Var.X = 0;
                gu9Var.a = 12;
                return;
            }
            du9 du9Var = gu9Var.k;
            du9Var.b = null;
            du9Var.c = null;
            du9 du9Var2 = gu9Var.l;
            du9Var2.b = null;
            du9Var2.c = null;
            du9 du9Var3 = gu9Var.m;
            du9Var3.b = null;
            du9Var3.c = null;
            xt9.j(xt9Var);
            g(xt9Var, gu9Var);
            if (gu9Var.g != 0 || gu9Var.j) {
                if (!gu9Var.i && !gu9Var.j) {
                    gu9Var.a = 2;
                } else {
                    xt9.g(xt9Var);
                    gu9Var.a = gu9Var.j ? 4 : 5;
                }
                if (gu9Var.j) {
                    return;
                }
                gu9Var.R += gu9Var.g;
                if (gu9Var.Q < gu9Var.P) {
                    k(gu9Var);
                }
            }
        }
    }

    public static int r(int[] iArr, int i, xt9 xt9Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, xt9Var)) == null) {
            long j = xt9Var.f;
            int i2 = xt9Var.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                xt9Var.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            xt9Var.g = i2 + (iArr[i7] >> 16) + 8;
            return iArr[i7] & 65535;
        }
        return invokeLIL.intValue;
    }

    public static void s(gu9 gu9Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, gu9Var, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            gu9Var.S = bArr;
        }
    }

    public static int t(int i, int[] iArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2)})) == null) ? i < 16 ? iArr[(i2 + b[i]) & 3] + c[i] : (i - 16) + 1 : invokeCommon.intValue;
    }

    public static boolean u(gu9 gu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, gu9Var)) == null) {
            int i = gu9Var.T;
            if (i != 0) {
                gu9Var.X += i;
                gu9Var.T = 0;
            }
            int min = Math.min(gu9Var.V - gu9Var.W, gu9Var.Y - gu9Var.X);
            if (min != 0) {
                System.arraycopy(gu9Var.d, gu9Var.X, gu9Var.Z, gu9Var.U + gu9Var.W, min);
                gu9Var.W += min;
                gu9Var.X += min;
            }
            return gu9Var.W < gu9Var.V;
        }
        return invokeL.booleanValue;
    }
}
