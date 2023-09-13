package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] a;
    public int b;
    public Object[] c;
    public int d;
    public int e;
    public final int[] f;
    public final int[] g;

    public static int l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            int i2 = 0;
            while (i >= 32) {
                i2 |= i & 1;
                i >>= 1;
            }
            return i + i2;
        }
        return invokeI.intValue;
    }

    public a7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 7;
        this.e = 0;
        this.c = new Object[256];
        this.f = new int[40];
        this.g = new int[40];
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        while (true) {
            int i = this.e;
            if (i > 1) {
                int i2 = i - 2;
                if (i2 > 0) {
                    int[] iArr = this.g;
                    int i3 = i2 - 1;
                    int i4 = i2 + 1;
                    if (iArr[i3] <= iArr[i2] + iArr[i4]) {
                        if (iArr[i3] < iArr[i4]) {
                            i2--;
                        }
                        g(i2);
                    }
                }
                int[] iArr2 = this.g;
                if (iArr2[i2] <= iArr2[i2 + 1]) {
                    g(i2);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:21:0x003f -> B:5:0x0006 */
    public static void a(Object[] objArr, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65537, null, objArr, i, i2, i3) == null) {
            if (i3 == i) {
                i3++;
            }
            while (i3 < i2) {
                Comparable comparable = (Comparable) objArr[i3];
                int i4 = i;
                int i5 = i3;
                while (i4 < i5) {
                    int i6 = (i4 + i5) >>> 1;
                    if (comparable.compareTo(objArr[i6]) < 0) {
                        i5 = i6;
                    } else {
                        i4 = i6 + 1;
                    }
                }
                int i7 = i3 - i4;
                if (i7 != 1) {
                    if (i7 != 2) {
                        System.arraycopy(objArr, i4, objArr, i4 + 1, i7);
                        objArr[i4] = comparable;
                        i3++;
                    } else {
                        objArr[i4 + 2] = objArr[i4 + 1];
                    }
                }
                objArr[i4 + 1] = objArr[i4];
                objArr[i4] = comparable;
                i3++;
            }
        }
    }

    public static int b(Object[] objArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, objArr, i, i2)) == null) {
            int i3 = i + 1;
            if (i3 == i2) {
                return 1;
            }
            int i4 = i3 + 1;
            if (((Comparable) objArr[i3]).compareTo(objArr[i]) < 0) {
                while (i4 < i2 && ((Comparable) objArr[i4]).compareTo(objArr[i4 - 1]) < 0) {
                    i4++;
                }
                o(objArr, i, i4);
            } else {
                while (i4 < i2 && ((Comparable) objArr[i4]).compareTo(objArr[i4 - 1]) >= 0) {
                    i4++;
                }
            }
            return i4 - i;
        }
        return invokeLII.intValue;
    }

    public static void n(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65542, null, i, i2, i3) == null) {
            if (i2 <= i3) {
                if (i2 >= 0) {
                    if (i3 <= i) {
                        return;
                    }
                    throw new ArrayIndexOutOfBoundsException(i3);
                }
                throw new ArrayIndexOutOfBoundsException(i2);
            }
            throw new IllegalArgumentException("fromIndex(" + i2 + ") > toIndex(" + i3 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void c(Object[] objArr, int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, objArr, i, i2) == null) {
            this.e = 0;
            n(objArr.length, i, i2);
            int i4 = i2 - i;
            if (i4 < 2) {
                return;
            }
            if (i4 < 32) {
                a(objArr, i, i2, b(objArr, i, i2) + i);
                return;
            }
            this.a = objArr;
            this.d = 0;
            int l = l(i4);
            do {
                int b = b(objArr, i, i2);
                if (b < l) {
                    if (i4 <= l) {
                        i3 = i4;
                    } else {
                        i3 = l;
                    }
                    a(objArr, i, i + i3, b + i);
                    b = i3;
                }
                m(i, b);
                h();
                i += b;
                i4 -= b;
            } while (i4 != 0);
            i();
            this.a = null;
            Object[] objArr2 = this.c;
            int i5 = this.d;
            for (int i6 = 0; i6 < i5; i6++) {
                objArr2[i6] = null;
            }
        }
    }

    public static int e(Comparable<Object> comparable, Object[] objArr, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{comparable, objArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int i6 = i + i3;
            if (comparable.compareTo(objArr[i6]) > 0) {
                int i7 = i2 - i3;
                int i8 = 0;
                int i9 = 1;
                while (i9 < i7 && comparable.compareTo(objArr[i6 + i9]) > 0) {
                    int i10 = (i9 << 1) + 1;
                    if (i10 <= 0) {
                        i8 = i9;
                        i9 = i7;
                    } else {
                        int i11 = i9;
                        i9 = i10;
                        i8 = i11;
                    }
                }
                if (i9 <= i7) {
                    i7 = i9;
                }
                i4 = i8 + i3;
                i5 = i7 + i3;
            } else {
                int i12 = i3 + 1;
                int i13 = 0;
                int i14 = 1;
                while (i14 < i12 && comparable.compareTo(objArr[i6 - i14]) <= 0) {
                    int i15 = (i14 << 1) + 1;
                    if (i15 <= 0) {
                        i13 = i14;
                        i14 = i12;
                    } else {
                        int i16 = i14;
                        i14 = i15;
                        i13 = i16;
                    }
                }
                if (i14 <= i12) {
                    i12 = i14;
                }
                int i17 = i3 - i12;
                int i18 = i3 - i13;
                i4 = i17;
                i5 = i18;
            }
            int i19 = i4 + 1;
            while (i19 < i5) {
                int i20 = ((i5 - i19) >>> 1) + i19;
                if (comparable.compareTo(objArr[i + i20]) > 0) {
                    i19 = i20 + 1;
                } else {
                    i5 = i20;
                }
            }
            return i5;
        }
        return invokeCommon.intValue;
    }

    public static int f(Comparable<Object> comparable, Object[] objArr, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{comparable, objArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int i6 = i + i3;
            if (comparable.compareTo(objArr[i6]) < 0) {
                int i7 = i3 + 1;
                int i8 = 0;
                int i9 = 1;
                while (i9 < i7 && comparable.compareTo(objArr[i6 - i9]) < 0) {
                    int i10 = (i9 << 1) + 1;
                    if (i10 <= 0) {
                        i8 = i9;
                        i9 = i7;
                    } else {
                        int i11 = i9;
                        i9 = i10;
                        i8 = i11;
                    }
                }
                if (i9 <= i7) {
                    i7 = i9;
                }
                i5 = i3 - i7;
                i4 = i3 - i8;
            } else {
                int i12 = i2 - i3;
                int i13 = 0;
                int i14 = 1;
                while (i14 < i12 && comparable.compareTo(objArr[i6 + i14]) >= 0) {
                    int i15 = (i14 << 1) + 1;
                    if (i15 <= 0) {
                        i13 = i14;
                        i14 = i12;
                    } else {
                        int i16 = i14;
                        i14 = i15;
                        i13 = i16;
                    }
                }
                if (i14 <= i12) {
                    i12 = i14;
                }
                int i17 = i13 + i3;
                i4 = i3 + i12;
                i5 = i17;
            }
            int i18 = i5 + 1;
            while (i18 < i4) {
                int i19 = ((i4 - i18) >>> 1) + i18;
                if (comparable.compareTo(objArr[i + i19]) < 0) {
                    i4 = i19;
                } else {
                    i18 = i19 + 1;
                }
            }
            return i4;
        }
        return invokeCommon.intValue;
    }

    public static void o(Object[] objArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65543, null, objArr, i, i2) == null) {
            int i3 = i2 - 1;
            while (i < i3) {
                Object obj = objArr[i];
                objArr[i] = objArr[i3];
                objArr[i3] = obj;
                i3--;
                i++;
            }
        }
    }

    public final Object[] d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.d = Math.max(this.d, i);
            if (this.c.length < i) {
                int i2 = (i >> 1) | i;
                int i3 = i2 | (i2 >> 2);
                int i4 = i3 | (i3 >> 4);
                int i5 = i4 | (i4 >> 8);
                int i6 = (i5 | (i5 >> 16)) + 1;
                if (i6 >= 0) {
                    i = Math.min(i6, this.a.length >>> 1);
                }
                this.c = new Object[i];
            }
            return this.c;
        }
        return (Object[]) invokeI.objValue;
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            int[] iArr = this.f;
            int i2 = iArr[i];
            int[] iArr2 = this.g;
            int i3 = iArr2[i];
            int i4 = i + 1;
            int i5 = iArr[i4];
            int i6 = iArr2[i4];
            iArr2[i] = i3 + i6;
            if (i == this.e - 3) {
                int i7 = i + 2;
                iArr[i4] = iArr[i7];
                iArr2[i4] = iArr2[i7];
            }
            this.e--;
            Object[] objArr = this.a;
            int f = f((Comparable) objArr[i5], objArr, i2, i3, 0);
            int i8 = i2 + f;
            int i9 = i3 - f;
            if (i9 == 0) {
                return;
            }
            Object[] objArr2 = this.a;
            int e = e((Comparable) objArr2[(i8 + i9) - 1], objArr2, i5, i6, i6 - 1);
            if (e == 0) {
                return;
            }
            if (i9 <= e) {
                k(i8, i9, i5, e);
            } else {
                j(i8, i9, i5, e);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
            return;
        }
        while (true) {
            int i = this.e;
            if (i > 1) {
                int i2 = i - 2;
                if (i2 > 0) {
                    int[] iArr = this.g;
                    if (iArr[i2 - 1] < iArr[i2 + 1]) {
                        i2--;
                    }
                }
                g(i2);
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
        r3 = r8;
        r5 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
        r3 = r13 - f((java.lang.Comparable) r1[r5], r0, r12, r13, r13 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        if (r3 == 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
        r6 = r6 - r3;
        r7 = r7 - r3;
        r13 = r13 - r3;
        java.lang.System.arraycopy(r0, r7 + 1, r0, r6 + 1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (r13 != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008c, code lost:
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
        r8 = r6 - 1;
        r9 = r5 - 1;
        r0[r6] = r1[r5];
        r15 = r15 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
        if (r15 != 1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
        r5 = r15 - e((java.lang.Comparable) r0[r7], r1, 0, r15, r15 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a7, code lost:
        if (r5 == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a9, code lost:
        r6 = r8 - r5;
        r8 = r9 - r5;
        r15 = r15 - r5;
        java.lang.System.arraycopy(r1, r8 + 1, r0, r6 + 1, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b5, code lost:
        if (r15 > 1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b7, code lost:
        r3 = r6;
        r5 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ba, code lost:
        r6 = r8;
        r8 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bc, code lost:
        r9 = r6 - 1;
        r10 = r7 - 1;
        r0[r6] = r0[r7];
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c6, code lost:
        if (r13 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c8, code lost:
        r5 = r8;
        r3 = r9;
        r7 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f0, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f3, code lost:
        if (r3 < 7) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f7, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f8, code lost:
        if (r5 < 7) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fa, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00fc, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fe, code lost:
        if ((r3 | r5) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0100, code lost:
        if (r14 >= 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0102, code lost:
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010a, code lost:
        r5 = r8;
        r6 = r9;
        r7 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            Object[] objArr = this.a;
            Object[] d = d(i4);
            System.arraycopy(objArr, i3, d, 0, i4);
            int i9 = (i + i2) - 1;
            int i10 = i4 - 1;
            int i11 = (i3 + i4) - 1;
            int i12 = i11 - 1;
            int i13 = i9 - 1;
            objArr[i11] = objArr[i9];
            int i14 = i2 - 1;
            if (i14 == 0) {
                System.arraycopy(d, 0, objArr, i12 - i10, i4);
            } else if (i4 == 1) {
                int i15 = i12 - i14;
                System.arraycopy(objArr, (i13 - i14) + 1, objArr, i15 + 1, i14);
                objArr[i15] = d[i10];
            } else {
                int i16 = this.b;
                loop0: while (true) {
                    int i17 = 0;
                    int i18 = 0;
                    while (true) {
                        if (((Comparable) d[i10]).compareTo(objArr[i13]) < 0) {
                            i5 = i12 - 1;
                            int i19 = i13 - 1;
                            objArr[i12] = objArr[i13];
                            i18++;
                            i14--;
                            if (i14 == 0) {
                                i13 = i19;
                                break loop0;
                            }
                            i12 = i5;
                            i13 = i19;
                            i17 = 0;
                        } else {
                            int i20 = i12 - 1;
                            int i21 = i10 - 1;
                            objArr[i12] = d[i10];
                            i17++;
                            i4--;
                            if (i4 == 1) {
                                break loop0;
                            }
                            i12 = i20;
                            i10 = i21;
                            i18 = 0;
                        }
                        if ((i18 | i17) >= i16) {
                            break;
                        }
                    }
                    i16 += 2;
                    i10 = i6;
                    i12 = i7;
                    i13 = i8;
                }
                if (i16 < 1) {
                    i16 = 1;
                }
                this.b = i16;
                if (i4 == 1) {
                    int i22 = i5 - i14;
                    System.arraycopy(objArr, (i13 - i14) + 1, objArr, i22 + 1, i14);
                    objArr[i22] = d[i10];
                } else if (i4 != 0) {
                    System.arraycopy(d, 0, objArr, i5 - (i4 - 1), i4);
                } else {
                    throw new IllegalArgumentException("Comparison method violates its general contract!");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        r6 = f((java.lang.Comparable) r0[r4], r1, r5, r13, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
        if (r6 == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
        java.lang.System.arraycopy(r1, r5, r0, r3, r6);
        r3 = r3 + r6;
        r5 = r5 + r6;
        r13 = r13 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
        if (r13 > 1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
        r7 = r3 + 1;
        r8 = r4 + 1;
        r0[r3] = r0[r4];
        r15 = r15 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
        if (r15 != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
        r3 = e((java.lang.Comparable) r1[r5], r0, r8, r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
        if (r3 == 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
        java.lang.System.arraycopy(r0, r8, r0, r7, r3);
        r4 = r7 + r3;
        r7 = r8 + r3;
        r15 = r15 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
        if (r15 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009c, code lost:
        r6 = r4;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009f, code lost:
        r7 = r4;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a3, code lost:
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
        r8 = r7 + 1;
        r9 = r5 + 1;
        r0[r7] = r1[r5];
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ae, code lost:
        if (r13 != 1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b0, code lost:
        r6 = r8;
        r5 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d0, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d3, code lost:
        if (r6 < 7) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d5, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d7, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d8, code lost:
        if (r3 < 7) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00da, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00dc, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00de, code lost:
        if ((r3 | r6) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e0, code lost:
        if (r14 >= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e2, code lost:
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e9, code lost:
        r3 = r8;
        r5 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i, i2, i3, i4) == null) {
            Object[] objArr = this.a;
            Object[] d = d(i2);
            System.arraycopy(objArr, i, d, 0, i2);
            int i8 = i + 1;
            int i9 = i3 + 1;
            objArr[i] = objArr[i3];
            int i10 = i4 - 1;
            if (i10 == 0) {
                System.arraycopy(d, 0, objArr, i8, i2);
            } else if (i2 == 1) {
                System.arraycopy(objArr, i9, objArr, i8, i10);
                objArr[i8 + i10] = d[0];
            } else {
                int i11 = this.b;
                int i12 = 0;
                loop0: while (true) {
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        if (((Comparable) objArr[i9]).compareTo(d[i12]) < 0) {
                            i5 = i8 + 1;
                            int i15 = i9 + 1;
                            objArr[i8] = objArr[i9];
                            i14++;
                            i10--;
                            if (i10 == 0) {
                                break loop0;
                            }
                            i8 = i5;
                            i9 = i15;
                            i13 = 0;
                        } else {
                            int i16 = i8 + 1;
                            int i17 = i12 + 1;
                            objArr[i8] = d[i12];
                            i13++;
                            i2--;
                            if (i2 == 1) {
                                i5 = i16;
                                i12 = i17;
                                break loop0;
                            }
                            i8 = i16;
                            i12 = i17;
                            i14 = 0;
                        }
                        if ((i13 | i14) >= i11) {
                            break;
                        }
                    }
                    i11 += 2;
                    i8 = i6;
                    i12 = i7;
                }
                if (i11 < 1) {
                    i11 = 1;
                }
                this.b = i11;
                if (i2 == 1) {
                    System.arraycopy(objArr, i9, objArr, i5, i10);
                    objArr[i5 + i10] = d[i12];
                } else if (i2 != 0) {
                    System.arraycopy(d, i12, objArr, i5, i2);
                } else {
                    throw new IllegalArgumentException("Comparison method violates its general contract!");
                }
            }
        }
    }

    public final void m(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            int[] iArr = this.f;
            int i3 = this.e;
            iArr[i3] = i;
            this.g[i3] = i2;
            this.e = i3 + 1;
        }
    }
}
