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
public final class c8c {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947630075, "Lcom/baidu/tieba/c8c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947630075, "Lcom/baidu/tieba/c8c;");
                return;
            }
        }
        a = new int[]{1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        b = new int[]{3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};
        c = new int[]{0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};
        d = new int[]{131072, 131076, 131075, 196610, 131072, 131076, 131075, V8Engine.SET_NET_REQUEST_ERROR_REGISTER_NA_REQUEST_FAILED_CAN_NOT_FIND_SWAN_NATIVE, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    }

    public static void a(i8c i8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, i8cVar) == null) {
            z7c z7cVar = i8cVar.c;
            byte[] bArr = i8cVar.d;
            int i = i8cVar.g;
            if (i <= 0) {
                z7c.k(z7cVar);
                i8cVar.a = 1;
                return;
            }
            int min = Math.min(i8cVar.Q - i8cVar.r, i);
            z7c.c(z7cVar, bArr, i8cVar.r, min);
            i8cVar.g -= min;
            int i2 = i8cVar.r + min;
            i8cVar.r = i2;
            int i3 = i8cVar.Q;
            if (i2 == i3) {
                i8cVar.b = 5;
                i8cVar.Y = i3;
                i8cVar.X = 0;
                i8cVar.a = 12;
                return;
            }
            z7c.k(z7cVar);
            i8cVar.a = 1;
        }
    }

    public static void k(i8c i8cVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, i8cVar) == null) {
            int i2 = i8cVar.P;
            long j = i8cVar.R;
            if (i2 > j) {
                while (true) {
                    int i3 = i2 >> 1;
                    if (i3 <= ((int) j) + i8cVar.S.length) {
                        break;
                    }
                    i2 = i3;
                }
                if (!i8cVar.h && i2 < 16384 && i8cVar.P >= 16384) {
                    i2 = 16384;
                }
            }
            int i4 = i8cVar.Q;
            if (i2 <= i4) {
                return;
            }
            byte[] bArr = new byte[i2 + 37];
            byte[] bArr2 = i8cVar.d;
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr, 0, i4);
            } else {
                byte[] bArr3 = i8cVar.S;
                if (bArr3.length != 0) {
                    int length = bArr3.length;
                    int i5 = i8cVar.O;
                    if (length > i5) {
                        i = length - i5;
                    } else {
                        i5 = length;
                        i = 0;
                    }
                    System.arraycopy(i8cVar.S, i, bArr, 0, i5);
                    i8cVar.r = i5;
                    i8cVar.f1114T = i5;
                }
            }
            i8cVar.d = bArr;
            i8cVar.Q = i2;
        }
    }

    public static boolean u(i8c i8cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, i8cVar)) == null) {
            int i = i8cVar.f1114T;
            if (i != 0) {
                i8cVar.X += i;
                i8cVar.f1114T = 0;
            }
            int min = Math.min(i8cVar.V - i8cVar.W, i8cVar.Y - i8cVar.X);
            if (min != 0) {
                System.arraycopy(i8cVar.d, i8cVar.X, i8cVar.Z, i8cVar.U + i8cVar.W, min);
                i8cVar.W += min;
                i8cVar.X += min;
            }
            if (i8cVar.W >= i8cVar.V) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(i8c i8cVar, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, i8cVar, i) == null) {
            z7c z7cVar = i8cVar.c;
            int[] iArr = i8cVar.p;
            int i3 = i * 2;
            z7c.d(z7cVar);
            int i4 = i * 1080;
            int r = r(i8cVar.e, i4, z7cVar);
            i8cVar.n[i] = m(i8cVar.f, i4, z7cVar);
            if (r == 1) {
                i2 = iArr[i3 + 1] + 1;
            } else if (r == 0) {
                i2 = iArr[i3];
            } else {
                i2 = r - 2;
            }
            int[] iArr2 = i8cVar.o;
            if (i2 >= iArr2[i]) {
                i2 -= iArr2[i];
            }
            int i5 = i3 + 1;
            iArr[i3] = iArr[i5];
            iArr[i5] = i2;
        }
    }

    public static void c(i8c i8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, i8cVar) == null) {
            b(i8cVar, 1);
            i8cVar.F = i8cVar.l.c[i8cVar.p[3]];
        }
    }

    public static void e(i8c i8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, i8cVar) == null) {
            b(i8cVar, 2);
            i8cVar.C = i8cVar.p[5] << 2;
        }
    }

    public static int h(z7c z7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, z7cVar)) == null) {
            if (z7c.i(z7cVar, 1) != 0) {
                int i = z7c.i(z7cVar, 3);
                if (i == 0) {
                    return 1;
                }
                return z7c.i(z7cVar, i) + (1 << i);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int d(int i, byte[] bArr, z7c z7cVar) {
        InterceptResult invokeILL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, bArr, z7cVar)) == null) {
            z7c.j(z7cVar);
            int h = h(z7cVar) + 1;
            if (h == 1) {
                k8c.a(bArr, 0, i);
                return h;
            }
            if (z7c.i(z7cVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = z7c.i(z7cVar, 4) + 1;
            } else {
                i2 = 0;
            }
            int[] iArr = new int[1080];
            n(h + i2, iArr, 0, z7cVar);
            int i3 = 0;
            while (i3 < i) {
                z7c.j(z7cVar);
                z7c.d(z7cVar);
                int r = r(iArr, 0, z7cVar);
                if (r == 0) {
                    bArr[i3] = 0;
                } else if (r <= i2) {
                    for (int i4 = (1 << r) + z7c.i(z7cVar, r); i4 != 0; i4--) {
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
            if (z7c.i(z7cVar, 1) == 1) {
                j(bArr, i);
            }
            return h;
        }
        return invokeILL.intValue;
    }

    public static void f(i8c i8cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, i8cVar) == null) {
            b(i8cVar, 0);
            int i = i8cVar.p[1];
            int i2 = i << 6;
            i8cVar.B = i2;
            int i3 = i8cVar.A[i2] & 255;
            i8cVar.v = i3;
            i8cVar.w = i8cVar.k.c[i3];
            byte b2 = i8cVar.z[i];
            int[] iArr = b8c.b;
            i8cVar.D = iArr[b2];
            i8cVar.E = iArr[b2 + 1];
        }
    }

    public static void g(z7c z7cVar, i8c i8cVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, z7cVar, i8cVar) == null) {
            boolean z2 = true;
            if (z7c.i(z7cVar, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            i8cVar.h = z;
            i8cVar.g = 0;
            i8cVar.i = false;
            i8cVar.j = false;
            if (z && z7c.i(z7cVar, 1) != 0) {
                return;
            }
            int i = z7c.i(z7cVar, 2) + 4;
            if (i == 7) {
                i8cVar.j = true;
                if (z7c.i(z7cVar, 1) == 0) {
                    int i2 = z7c.i(z7cVar, 2);
                    if (i2 == 0) {
                        return;
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        int i4 = z7c.i(z7cVar, 8);
                        if (i4 == 0 && i3 + 1 == i2 && i2 > 1) {
                            throw new BrotliRuntimeException("Exuberant nibble");
                        }
                        i8cVar.g = (i4 << (i3 * 8)) | i8cVar.g;
                    }
                } else {
                    throw new BrotliRuntimeException("Corrupted reserved bit");
                }
            } else {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = z7c.i(z7cVar, 4);
                    if (i6 == 0 && i5 + 1 == i && i > 4) {
                        throw new BrotliRuntimeException("Exuberant nibble");
                    }
                    i8cVar.g = (i6 << (i5 * 4)) | i8cVar.g;
                }
            }
            i8cVar.g++;
            if (!i8cVar.h) {
                if (z7c.i(z7cVar, 1) != 1) {
                    z2 = false;
                }
                i8cVar.i = z2;
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
    public static void i(i8c i8cVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, i8cVar) == null) {
            int i8 = i8cVar.a;
            if (i8 != 0) {
                if (i8 != 11) {
                    z7c z7cVar = i8cVar.c;
                    int i9 = i8cVar.Q - 1;
                    byte[] bArr = i8cVar.d;
                    while (true) {
                        int i10 = i8cVar.a;
                        if (i10 != 10) {
                            if (i10 != 12) {
                                int i11 = 0;
                                switch (i10) {
                                    case 1:
                                        if (i8cVar.g >= 0) {
                                            q(i8cVar);
                                            i9 = i8cVar.Q - 1;
                                            bArr = i8cVar.d;
                                            break;
                                        } else {
                                            throw new BrotliRuntimeException("Invalid metablock length");
                                        }
                                    case 2:
                                        p(i8cVar);
                                        i8cVar.a = 3;
                                        if (i8cVar.g > 0) {
                                            i8cVar.a = 1;
                                            break;
                                        } else {
                                            z7c.j(z7cVar);
                                            if (i8cVar.n[1] == 0) {
                                                c(i8cVar);
                                            }
                                            int[] iArr = i8cVar.n;
                                            iArr[1] = iArr[1] - 1;
                                            z7c.d(z7cVar);
                                            int r = r(i8cVar.l.b, i8cVar.F, z7cVar);
                                            int i12 = r >>> 6;
                                            i8cVar.G = 0;
                                            if (i12 >= 2) {
                                                i12 -= 2;
                                                i8cVar.G = -1;
                                            }
                                            int i13 = h8c.g[i12] + ((r >>> 3) & 7);
                                            int i14 = h8c.h[i12] + (r & 7);
                                            i8cVar.y = h8c.c[i13] + z7c.i(z7cVar, h8c.d[i13]);
                                            i8cVar.M = h8c.e[i14] + z7c.i(z7cVar, h8c.f[i14]);
                                            i8cVar.x = 0;
                                            i8cVar.a = 6;
                                            if (i8cVar.u) {
                                                int i15 = i8cVar.r;
                                                int i16 = bArr[(i15 - 1) & i9] & 255;
                                                int i17 = bArr[(i15 - 2) & i9] & 255;
                                                while (true) {
                                                    if (i8cVar.x < i8cVar.y) {
                                                        z7c.j(z7cVar);
                                                        if (i8cVar.n[0] == 0) {
                                                            f(i8cVar);
                                                        }
                                                        byte[] bArr2 = i8cVar.A;
                                                        int i18 = i8cVar.B;
                                                        int[] iArr2 = b8c.a;
                                                        int i19 = iArr2[i8cVar.D + i16];
                                                        int[] iArr3 = i8cVar.n;
                                                        iArr3[0] = iArr3[0] - 1;
                                                        z7c.d(z7cVar);
                                                        f8c f8cVar = i8cVar.k;
                                                        int r2 = r(f8cVar.b, f8cVar.c[bArr2[i18 + (iArr2[i8cVar.E + i17] | i19)] & 255], z7cVar);
                                                        int i20 = i8cVar.r;
                                                        bArr[i20] = (byte) r2;
                                                        i8cVar.x++;
                                                        i8cVar.r = i20 + 1;
                                                        if (i20 == i9) {
                                                            i8cVar.b = 6;
                                                            i8cVar.Y = i8cVar.Q;
                                                            i8cVar.X = 0;
                                                            i8cVar.a = 12;
                                                        } else {
                                                            int i21 = i16;
                                                            i16 = r2;
                                                            i17 = i21;
                                                        }
                                                    }
                                                }
                                            } else {
                                                while (true) {
                                                    if (i8cVar.x < i8cVar.y) {
                                                        z7c.j(z7cVar);
                                                        if (i8cVar.n[0] == 0) {
                                                            f(i8cVar);
                                                        }
                                                        int[] iArr4 = i8cVar.n;
                                                        iArr4[0] = iArr4[0] - 1;
                                                        z7c.d(z7cVar);
                                                        bArr[i8cVar.r] = (byte) r(i8cVar.k.b, i8cVar.w, z7cVar);
                                                        i8cVar.x++;
                                                        int i22 = i8cVar.r;
                                                        i8cVar.r = i22 + 1;
                                                        if (i22 == i9) {
                                                            i8cVar.b = 6;
                                                            i8cVar.Y = i8cVar.Q;
                                                            i8cVar.X = 0;
                                                            i8cVar.a = 12;
                                                        }
                                                    }
                                                }
                                            }
                                            if (i8cVar.a == 6) {
                                                continue;
                                            } else {
                                                int i23 = i8cVar.g - i8cVar.y;
                                                i8cVar.g = i23;
                                                if (i23 <= 0) {
                                                    i8cVar.a = 3;
                                                    break;
                                                } else {
                                                    if (i8cVar.G < 0) {
                                                        z7c.j(z7cVar);
                                                        if (i8cVar.n[2] == 0) {
                                                            e(i8cVar);
                                                        }
                                                        int[] iArr5 = i8cVar.n;
                                                        iArr5[2] = iArr5[2] - 1;
                                                        z7c.d(z7cVar);
                                                        f8c f8cVar2 = i8cVar.m;
                                                        int[] iArr6 = f8cVar2.b;
                                                        int[] iArr7 = f8cVar2.c;
                                                        byte[] bArr3 = i8cVar.H;
                                                        int i24 = i8cVar.C;
                                                        int i25 = i8cVar.M;
                                                        if (i25 > 4) {
                                                            i7 = 3;
                                                        } else {
                                                            i7 = i25 - 2;
                                                        }
                                                        int r3 = r(iArr6, iArr7[bArr3[i24 + i7] & 255], z7cVar);
                                                        i8cVar.G = r3;
                                                        int i26 = i8cVar.I;
                                                        if (r3 >= i26) {
                                                            int i27 = r3 - i26;
                                                            i8cVar.G = i27;
                                                            int i28 = i8cVar.J & i27;
                                                            int i29 = i27 >>> i8cVar.K;
                                                            i8cVar.G = i29;
                                                            int i30 = (i29 >>> 1) + 1;
                                                            i8cVar.G = i26 + i28 + ((((((i29 & 1) + 2) << i30) - 4) + z7c.i(z7cVar, i30)) << i8cVar.K);
                                                        }
                                                    }
                                                    int t = t(i8cVar.G, i8cVar.q, i8cVar.t);
                                                    i8cVar.L = t;
                                                    if (t >= 0) {
                                                        int i31 = i8cVar.s;
                                                        int i32 = i8cVar.O;
                                                        if (i31 != i32 && (i6 = i8cVar.r) < i32) {
                                                            i8cVar.s = i6;
                                                        } else {
                                                            i8cVar.s = i8cVar.O;
                                                        }
                                                        i8cVar.N = i8cVar.r;
                                                        int i33 = i8cVar.L;
                                                        if (i33 > i8cVar.s) {
                                                            i8cVar.a = 9;
                                                            break;
                                                        } else {
                                                            if (i8cVar.G > 0) {
                                                                int[] iArr8 = i8cVar.q;
                                                                int i34 = i8cVar.t;
                                                                iArr8[i34 & 3] = i33;
                                                                i8cVar.t = i34 + 1;
                                                            }
                                                            if (i8cVar.M <= i8cVar.g) {
                                                                i8cVar.x = 0;
                                                                i8cVar.a = 7;
                                                                int i35 = i8cVar.r;
                                                                i = (i35 - i8cVar.L) & i9;
                                                                i2 = i8cVar.M - i8cVar.x;
                                                                if (i + i2 >= i9 && i35 + i2 < i9) {
                                                                    while (i11 < i2) {
                                                                        bArr[i35] = bArr[i];
                                                                        i11++;
                                                                        i35++;
                                                                        i++;
                                                                    }
                                                                    i8cVar.x += i2;
                                                                    i8cVar.g -= i2;
                                                                    i8cVar.r += i2;
                                                                } else {
                                                                    do {
                                                                        i3 = i8cVar.x;
                                                                        if (i3 >= i8cVar.M) {
                                                                            i4 = i8cVar.r;
                                                                            bArr[i4] = bArr[(i4 - i8cVar.L) & i9];
                                                                            i8cVar.g--;
                                                                            i8cVar.x = i3 + 1;
                                                                            i8cVar.r = i4 + 1;
                                                                        }
                                                                    } while (i4 != i9);
                                                                    i5 = 7;
                                                                    i8cVar.b = 7;
                                                                    i8cVar.Y = i8cVar.Q;
                                                                    i8cVar.X = 0;
                                                                    i8cVar.a = 12;
                                                                    if (i8cVar.a != i5) {
                                                                        break;
                                                                    } else {
                                                                        i8cVar.a = 3;
                                                                        break;
                                                                    }
                                                                }
                                                                i5 = 7;
                                                                if (i8cVar.a != i5) {
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
                                        if (i8cVar.g > 0) {
                                        }
                                        break;
                                    case 4:
                                        while (i8cVar.g > 0) {
                                            z7c.j(z7cVar);
                                            z7c.i(z7cVar, 8);
                                            i8cVar.g--;
                                        }
                                        i8cVar.a = 1;
                                        break;
                                    case 5:
                                        a(i8cVar);
                                        break;
                                    case 6:
                                        if (i8cVar.u) {
                                        }
                                        if (i8cVar.a == 6) {
                                        }
                                        break;
                                    case 7:
                                        int i352 = i8cVar.r;
                                        i = (i352 - i8cVar.L) & i9;
                                        i2 = i8cVar.M - i8cVar.x;
                                        if (i + i2 >= i9) {
                                            break;
                                        }
                                        do {
                                            i3 = i8cVar.x;
                                            if (i3 >= i8cVar.M) {
                                            }
                                        } while (i4 != i9);
                                        i5 = 7;
                                        i8cVar.b = 7;
                                        i8cVar.Y = i8cVar.Q;
                                        i8cVar.X = 0;
                                        i8cVar.a = 12;
                                        if (i8cVar.a != i5) {
                                        }
                                        break;
                                    case 8:
                                        int i36 = i8cVar.Q;
                                        System.arraycopy(bArr, i36, bArr, 0, i8cVar.N - i36);
                                        i8cVar.a = 3;
                                        break;
                                    case 9:
                                        int i37 = i8cVar.M;
                                        if (i37 >= 4 && i37 <= 24) {
                                            int i38 = d8c.a[i37];
                                            int i39 = (i8cVar.L - i8cVar.s) - 1;
                                            int i40 = d8c.b[i37];
                                            int i41 = ((1 << i40) - 1) & i39;
                                            int i42 = i39 >>> i40;
                                            int i43 = i38 + (i41 * i37);
                                            if (i42 < j8c.d.length) {
                                                int b2 = j8c.b(bArr, i8cVar.N, d8c.a(), i43, i8cVar.M, j8c.d[i42]);
                                                int i44 = i8cVar.N + b2;
                                                i8cVar.N = i44;
                                                i8cVar.r += b2;
                                                i8cVar.g -= b2;
                                                int i45 = i8cVar.Q;
                                                if (i44 >= i45) {
                                                    i8cVar.b = 8;
                                                    i8cVar.Y = i45;
                                                    i8cVar.X = 0;
                                                    i8cVar.a = 12;
                                                    break;
                                                } else {
                                                    i8cVar.a = 3;
                                                    break;
                                                }
                                            } else {
                                                throw new BrotliRuntimeException("Invalid backward reference");
                                            }
                                        }
                                        break;
                                    default:
                                        throw new BrotliRuntimeException("Unexpected state " + i8cVar.a);
                                }
                            } else if (!u(i8cVar)) {
                                return;
                            } else {
                                int i46 = i8cVar.r;
                                int i47 = i8cVar.O;
                                if (i46 >= i47) {
                                    i8cVar.s = i47;
                                }
                                i8cVar.r &= i9;
                                i8cVar.a = i8cVar.b;
                            }
                        } else if (i10 == 10) {
                            if (i8cVar.g >= 0) {
                                z7c.g(z7cVar);
                                z7c.a(i8cVar.c, true);
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

    public static void s(i8c i8cVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, i8cVar, bArr) == null) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            i8cVar.S = bArr;
        }
    }

    public static int m(int[] iArr, int i, z7c z7cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, iArr, i, z7cVar)) == null) {
            z7c.d(z7cVar);
            int r = r(iArr, i, z7cVar);
            return h8c.a[r] + z7c.i(z7cVar, h8c.b[r]);
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(int i, int[] iArr, int i2, z7c z7cVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), iArr, Integer.valueOf(i2), z7cVar}) == null) {
            z7c.j(z7cVar);
            int[] iArr2 = new int[i];
            int i3 = z7c.i(z7cVar, 2);
            boolean z2 = false;
            boolean z3 = true;
            if (i3 == 1) {
                int i4 = i - 1;
                int[] iArr3 = new int[4];
                int i5 = z7c.i(z7cVar, 2) + 1;
                int i6 = 0;
                while (i4 != 0) {
                    i4 >>= 1;
                    i6++;
                }
                for (int i7 = 0; i7 < i5; i7++) {
                    iArr3[i7] = z7c.i(z7cVar, i6) % i;
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
                            if (z7c.i(z7cVar, 1) == 1) {
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
                    e8c.a(iArr, i2, 8, iArr2, i);
                    return;
                }
                throw new BrotliRuntimeException("Can't readHuffmanCode");
            }
            int[] iArr4 = new int[18];
            int i8 = 32;
            int i9 = 0;
            while (i3 < 18 && i8 > 0) {
                int i10 = a[i3];
                z7c.d(z7cVar);
                long j = z7cVar.f;
                int i11 = z7cVar.g;
                int i12 = ((int) (j >>> i11)) & 15;
                int[] iArr5 = d;
                z7cVar.g = i11 + (iArr5[i12] >> 16);
                int i13 = iArr5[i12] & 65535;
                iArr4[i10] = i13;
                if (i13 != 0) {
                    i8 -= 32 >> i13;
                    i9++;
                }
                i3++;
            }
            z2 = (i9 == 1 || i8 == 0) ? true : true;
            o(iArr4, i, iArr2, z7cVar);
            z3 = z2;
            if (!z3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        if (r4 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        com.baidu.tieba.k8c.b(r13, r3, r12 - r3);
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
    public static void o(int[] iArr, int i, int[] iArr2, z7c z7cVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, iArr, i, iArr2, z7cVar) == null) {
            int[] iArr3 = new int[32];
            e8c.a(iArr3, 0, 5, iArr, 18);
            int i4 = 8;
            int i5 = 0;
            int i6 = 32768;
            int i7 = 0;
            loop0: while (true) {
                int i8 = 0;
                while (i5 < i && i6 > 0) {
                    z7c.j(z7cVar);
                    z7c.d(z7cVar);
                    long j = z7cVar.f;
                    int i9 = z7cVar.g;
                    int i10 = ((int) (j >>> i9)) & 31;
                    z7cVar.g = i9 + (iArr3[i10] >> 16);
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
                        int i14 = i3 + z7c.i(z7cVar, i13) + 3;
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

    public static void p(i8c i8cVar) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, i8cVar) == null) {
            z7c z7cVar = i8cVar.c;
            for (int i = 0; i < 3; i++) {
                i8cVar.o[i] = h(z7cVar) + 1;
                i8cVar.n[i] = 268435456;
                int[] iArr2 = i8cVar.o;
                if (iArr2[i] > 1) {
                    int i2 = i * 1080;
                    n(iArr2[i] + 2, i8cVar.e, i2, z7cVar);
                    n(26, i8cVar.f, i2, z7cVar);
                    i8cVar.n[i] = m(i8cVar.f, i2, z7cVar);
                }
            }
            z7c.j(z7cVar);
            i8cVar.K = z7c.i(z7cVar, 2);
            int i3 = z7c.i(z7cVar, 4);
            int i4 = i8cVar.K;
            int i5 = (i3 << i4) + 16;
            i8cVar.I = i5;
            i8cVar.J = (1 << i4) - 1;
            int i6 = i5 + (48 << i4);
            i8cVar.z = new byte[i8cVar.o[0]];
            int i7 = 0;
            while (true) {
                iArr = i8cVar.o;
                if (i7 >= iArr[0]) {
                    break;
                }
                int min = Math.min(i7 + 96, iArr[0]);
                while (i7 < min) {
                    i8cVar.z[i7] = (byte) (z7c.i(z7cVar, 2) << 1);
                    i7++;
                }
                z7c.j(z7cVar);
            }
            byte[] bArr = new byte[iArr[0] << 6];
            i8cVar.A = bArr;
            int d2 = d(iArr[0] << 6, bArr, z7cVar);
            i8cVar.u = true;
            int i8 = 0;
            while (true) {
                if (i8 >= (i8cVar.o[0] << 6)) {
                    break;
                } else if (i8cVar.A[i8] != (i8 >> 6)) {
                    i8cVar.u = false;
                    break;
                } else {
                    i8++;
                }
            }
            int[] iArr3 = i8cVar.o;
            byte[] bArr2 = new byte[iArr3[2] << 2];
            i8cVar.H = bArr2;
            int d3 = d(iArr3[2] << 2, bArr2, z7cVar);
            f8c.b(i8cVar.k, 256, d2);
            f8c.b(i8cVar.l, 704, i8cVar.o[1]);
            f8c.b(i8cVar.m, i6, d3);
            f8c.a(i8cVar.k, z7cVar);
            f8c.a(i8cVar.l, z7cVar);
            f8c.a(i8cVar.m, z7cVar);
            i8cVar.B = 0;
            i8cVar.C = 0;
            int[] iArr4 = b8c.b;
            byte[] bArr3 = i8cVar.z;
            i8cVar.D = iArr4[bArr3[0]];
            i8cVar.E = iArr4[bArr3[0] + 1];
            i8cVar.v = 0;
            i8cVar.w = i8cVar.k.c[0];
            i8cVar.F = i8cVar.l.c[0];
            int[] iArr5 = i8cVar.p;
            iArr5[4] = 1;
            iArr5[2] = 1;
            iArr5[0] = 1;
            iArr5[5] = 0;
            iArr5[3] = 0;
            iArr5[1] = 0;
        }
    }

    public static void q(i8c i8cVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, i8cVar) == null) {
            z7c z7cVar = i8cVar.c;
            if (i8cVar.h) {
                i8cVar.b = 10;
                i8cVar.Y = i8cVar.r;
                i8cVar.X = 0;
                i8cVar.a = 12;
                return;
            }
            f8c f8cVar = i8cVar.k;
            f8cVar.b = null;
            f8cVar.c = null;
            f8c f8cVar2 = i8cVar.l;
            f8cVar2.b = null;
            f8cVar2.c = null;
            f8c f8cVar3 = i8cVar.m;
            f8cVar3.b = null;
            f8cVar3.c = null;
            z7c.j(z7cVar);
            g(z7cVar, i8cVar);
            if (i8cVar.g == 0 && !i8cVar.j) {
                return;
            }
            if (!i8cVar.i && !i8cVar.j) {
                i8cVar.a = 2;
            } else {
                z7c.g(z7cVar);
                if (i8cVar.j) {
                    i = 4;
                } else {
                    i = 5;
                }
                i8cVar.a = i;
            }
            if (i8cVar.j) {
                return;
            }
            i8cVar.R += i8cVar.g;
            if (i8cVar.Q < i8cVar.P) {
                k(i8cVar);
            }
        }
    }

    public static int r(int[] iArr, int i, z7c z7cVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65554, null, iArr, i, z7cVar)) == null) {
            long j = z7cVar.f;
            int i2 = z7cVar.g;
            int i3 = (int) (j >>> i2);
            int i4 = i + (i3 & 255);
            int i5 = iArr[i4] >> 16;
            int i6 = iArr[i4] & 65535;
            if (i5 <= 8) {
                z7cVar.g = i2 + i5;
                return i6;
            }
            int i7 = i4 + i6 + ((((1 << i5) - 1) & i3) >>> 8);
            z7cVar.g = i2 + (iArr[i7] >> 16) + 8;
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
