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
public final class eqb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final lqb c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public eqb() {
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
        this.c = new lqb();
        this.i = 0;
    }

    public static void a(eqb eqbVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, eqbVar, z) != null) || !eqbVar.e) {
            return;
        }
        int i = ((eqbVar.h << 2) + ((eqbVar.g + 7) >> 3)) - 8;
        int i2 = eqbVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(eqb eqbVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eqbVar, inputStream) == null) {
            if (eqbVar.d == null) {
                lqb.b(eqbVar.c, eqbVar.a, eqbVar.b);
                eqbVar.d = inputStream;
                eqbVar.f = 0L;
                eqbVar.g = 64;
                eqbVar.h = 1024;
                eqbVar.e = false;
                h(eqbVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(eqb eqbVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, eqbVar) == null) {
            InputStream inputStream = eqbVar.d;
            eqbVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(eqb eqbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, eqbVar) == null) && (i = eqbVar.g) >= 32) {
            int[] iArr = eqbVar.b;
            int i2 = eqbVar.h;
            eqbVar.h = i2 + 1;
            eqbVar.f = (iArr[i2] << 32) | (eqbVar.f >>> 32);
            eqbVar.g = i - 32;
        }
    }

    public static int f(eqb eqbVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, eqbVar)) == null) {
            if (eqbVar.e) {
                i = (eqbVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - eqbVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(eqb eqbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, eqbVar) == null) && (i = (64 - eqbVar.g) & 7) != 0 && i(eqbVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(eqb eqbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, eqbVar) == null) {
            j(eqbVar);
            a(eqbVar, false);
            d(eqbVar);
            d(eqbVar);
        }
    }

    public static void k(eqb eqbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, eqbVar) == null) && eqbVar.g == 64) {
            h(eqbVar);
        }
    }

    public static void c(eqb eqbVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, eqbVar, bArr, i, i2) == null) {
            if ((eqbVar.g & 7) == 0) {
                while (true) {
                    int i3 = eqbVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (eqbVar.f >>> i3);
                    eqbVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(eqbVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(eqbVar.a, eqbVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    eqbVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(eqbVar) > 0) {
                    d(eqbVar);
                    while (i2 != 0) {
                        long j = eqbVar.f;
                        int i5 = eqbVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        eqbVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(eqbVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = eqbVar.d.read(bArr, i, i2);
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

    public static int i(eqb eqbVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, eqbVar, i)) == null) {
            d(eqbVar);
            long j = eqbVar.f;
            int i2 = eqbVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            eqbVar.g = i2 + i;
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
    public static void j(eqb eqbVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, eqbVar) != null) || (i = eqbVar.h) <= 1015) {
            return;
        }
        if (eqbVar.e) {
            if (f(eqbVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = eqbVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        eqbVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = eqbVar.d.read(eqbVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        lqb.a(eqbVar.c, i3 >> 2);
    }
}
