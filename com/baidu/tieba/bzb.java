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
/* loaded from: classes5.dex */
public final class bzb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final izb c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public bzb() {
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
        this.c = new izb();
        this.i = 0;
    }

    public static void a(bzb bzbVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, bzbVar, z) != null) || !bzbVar.e) {
            return;
        }
        int i = ((bzbVar.h << 2) + ((bzbVar.g + 7) >> 3)) - 8;
        int i2 = bzbVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(bzb bzbVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, bzbVar, inputStream) == null) {
            if (bzbVar.d == null) {
                izb.b(bzbVar.c, bzbVar.a, bzbVar.b);
                bzbVar.d = inputStream;
                bzbVar.f = 0L;
                bzbVar.g = 64;
                bzbVar.h = 1024;
                bzbVar.e = false;
                h(bzbVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(bzb bzbVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bzbVar) == null) {
            InputStream inputStream = bzbVar.d;
            bzbVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(bzb bzbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bzbVar) == null) && (i = bzbVar.g) >= 32) {
            int[] iArr = bzbVar.b;
            int i2 = bzbVar.h;
            bzbVar.h = i2 + 1;
            bzbVar.f = (iArr[i2] << 32) | (bzbVar.f >>> 32);
            bzbVar.g = i - 32;
        }
    }

    public static int f(bzb bzbVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bzbVar)) == null) {
            if (bzbVar.e) {
                i = (bzbVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - bzbVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(bzb bzbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, bzbVar) == null) && (i = (64 - bzbVar.g) & 7) != 0 && i(bzbVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(bzb bzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bzbVar) == null) {
            j(bzbVar);
            a(bzbVar, false);
            d(bzbVar);
            d(bzbVar);
        }
    }

    public static void k(bzb bzbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, bzbVar) == null) && bzbVar.g == 64) {
            h(bzbVar);
        }
    }

    public static void c(bzb bzbVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, bzbVar, bArr, i, i2) == null) {
            if ((bzbVar.g & 7) == 0) {
                while (true) {
                    int i3 = bzbVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (bzbVar.f >>> i3);
                    bzbVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(bzbVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(bzbVar.a, bzbVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    bzbVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(bzbVar) > 0) {
                    d(bzbVar);
                    while (i2 != 0) {
                        long j = bzbVar.f;
                        int i5 = bzbVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        bzbVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(bzbVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = bzbVar.d.read(bArr, i, i2);
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

    public static int i(bzb bzbVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, bzbVar, i)) == null) {
            d(bzbVar);
            long j = bzbVar.f;
            int i2 = bzbVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            bzbVar.g = i2 + i;
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
    public static void j(bzb bzbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, bzbVar) != null) || (i = bzbVar.h) <= 1015) {
            return;
        }
        if (bzbVar.e) {
            if (f(bzbVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = bzbVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        bzbVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = bzbVar.d.read(bzbVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        izb.a(bzbVar.c, i3 >> 2);
    }
}
