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
public final class eyb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final lyb c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public eyb() {
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
        this.c = new lyb();
        this.i = 0;
    }

    public static void a(eyb eybVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, eybVar, z) != null) || !eybVar.e) {
            return;
        }
        int i = ((eybVar.h << 2) + ((eybVar.g + 7) >> 3)) - 8;
        int i2 = eybVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(eyb eybVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eybVar, inputStream) == null) {
            if (eybVar.d == null) {
                lyb.b(eybVar.c, eybVar.a, eybVar.b);
                eybVar.d = inputStream;
                eybVar.f = 0L;
                eybVar.g = 64;
                eybVar.h = 1024;
                eybVar.e = false;
                h(eybVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(eyb eybVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, eybVar) == null) {
            InputStream inputStream = eybVar.d;
            eybVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(eyb eybVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, eybVar) == null) && (i = eybVar.g) >= 32) {
            int[] iArr = eybVar.b;
            int i2 = eybVar.h;
            eybVar.h = i2 + 1;
            eybVar.f = (iArr[i2] << 32) | (eybVar.f >>> 32);
            eybVar.g = i - 32;
        }
    }

    public static int f(eyb eybVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, eybVar)) == null) {
            if (eybVar.e) {
                i = (eybVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - eybVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(eyb eybVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, eybVar) == null) && (i = (64 - eybVar.g) & 7) != 0 && i(eybVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(eyb eybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, eybVar) == null) {
            j(eybVar);
            a(eybVar, false);
            d(eybVar);
            d(eybVar);
        }
    }

    public static void k(eyb eybVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, eybVar) == null) && eybVar.g == 64) {
            h(eybVar);
        }
    }

    public static void c(eyb eybVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, eybVar, bArr, i, i2) == null) {
            if ((eybVar.g & 7) == 0) {
                while (true) {
                    int i3 = eybVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (eybVar.f >>> i3);
                    eybVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(eybVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(eybVar.a, eybVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    eybVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(eybVar) > 0) {
                    d(eybVar);
                    while (i2 != 0) {
                        long j = eybVar.f;
                        int i5 = eybVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        eybVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(eybVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = eybVar.d.read(bArr, i, i2);
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

    public static int i(eyb eybVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, eybVar, i)) == null) {
            d(eybVar);
            long j = eybVar.f;
            int i2 = eybVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            eybVar.g = i2 + i;
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
    public static void j(eyb eybVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, eybVar) != null) || (i = eybVar.h) <= 1015) {
            return;
        }
        if (eybVar.e) {
            if (f(eybVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = eybVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        eybVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = eybVar.d.read(eybVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        lyb.a(eybVar.c, i3 >> 2);
    }
}
