package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes4.dex */
public final class c5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final j5a c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public c5a() {
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
        this.a = new byte[4160];
        this.b = new int[1040];
        this.c = new j5a();
        this.i = 0;
    }

    public static void a(c5a c5aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, c5aVar, z) != null) || !c5aVar.e) {
            return;
        }
        int i = ((c5aVar.h << 2) + ((c5aVar.g + 7) >> 3)) - 8;
        int i2 = c5aVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(c5a c5aVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, c5aVar, inputStream) == null) {
            if (c5aVar.d == null) {
                j5a.b(c5aVar.c, c5aVar.a, c5aVar.b);
                c5aVar.d = inputStream;
                c5aVar.f = 0L;
                c5aVar.g = 64;
                c5aVar.h = 1024;
                c5aVar.e = false;
                h(c5aVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(c5a c5aVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, c5aVar) == null) {
            InputStream inputStream = c5aVar.d;
            c5aVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(c5a c5aVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c5aVar) == null) && (i = c5aVar.g) >= 32) {
            int[] iArr = c5aVar.b;
            int i2 = c5aVar.h;
            c5aVar.h = i2 + 1;
            c5aVar.f = (iArr[i2] << 32) | (c5aVar.f >>> 32);
            c5aVar.g = i - 32;
        }
    }

    public static int f(c5a c5aVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, c5aVar)) == null) {
            if (c5aVar.e) {
                i = (c5aVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - c5aVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(c5a c5aVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, c5aVar) == null) && (i = (64 - c5aVar.g) & 7) != 0 && i(c5aVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(c5a c5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, c5aVar) == null) {
            j(c5aVar);
            a(c5aVar, false);
            d(c5aVar);
            d(c5aVar);
        }
    }

    public static void k(c5a c5aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, c5aVar) == null) && c5aVar.g == 64) {
            h(c5aVar);
        }
    }

    public static void c(c5a c5aVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, c5aVar, bArr, i, i2) == null) {
            if ((c5aVar.g & 7) == 0) {
                while (true) {
                    int i3 = c5aVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (c5aVar.f >>> i3);
                    c5aVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(c5aVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(c5aVar.a, c5aVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    c5aVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(c5aVar) > 0) {
                    d(c5aVar);
                    while (i2 != 0) {
                        long j = c5aVar.f;
                        int i5 = c5aVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        c5aVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(c5aVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = c5aVar.d.read(bArr, i, i2);
                        if (read != -1) {
                            i += read;
                            i2 -= read;
                        } else {
                            throw new BrotliRuntimeException("Unexpected end of input");
                        }
                    } catch (IOException e) {
                        throw new BrotliRuntimeException("Failed to read input", e);
                    }
                }
                return;
            }
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
    }

    public static int i(c5a c5aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, c5aVar, i)) == null) {
            d(c5aVar);
            long j = c5aVar.f;
            int i2 = c5aVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            c5aVar.g = i2 + i;
            return i3;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        r4.e = true;
        r4.i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(c5a c5aVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, c5aVar) != null) || (i = c5aVar.h) <= 1015) {
            return;
        }
        if (c5aVar.e) {
            if (f(c5aVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = c5aVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        c5aVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = c5aVar.d.read(c5aVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        j5a.a(c5aVar.c, i3 >> 2);
    }
}
