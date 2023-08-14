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
/* loaded from: classes6.dex */
public final class fyb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;
    public final int[] b;
    public final myb c;
    public InputStream d;
    public boolean e;
    public long f;
    public int g;
    public int h;
    public int i;

    public fyb() {
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
        this.c = new myb();
        this.i = 0;
    }

    public static void a(fyb fybVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65537, null, fybVar, z) != null) || !fybVar.e) {
            return;
        }
        int i = ((fybVar.h << 2) + ((fybVar.g + 7) >> 3)) - 8;
        int i2 = fybVar.i;
        if (i <= i2) {
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
            return;
        }
        throw new BrotliRuntimeException("Read after end");
    }

    public static void e(fyb fybVar, InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, fybVar, inputStream) == null) {
            if (fybVar.d == null) {
                myb.b(fybVar.c, fybVar.a, fybVar.b);
                fybVar.d = inputStream;
                fybVar.f = 0L;
                fybVar.g = 64;
                fybVar.h = 1024;
                fybVar.e = false;
                h(fybVar);
                return;
            }
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
    }

    public static void b(fyb fybVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fybVar) == null) {
            InputStream inputStream = fybVar.d;
            fybVar.d = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void d(fyb fybVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fybVar) == null) && (i = fybVar.g) >= 32) {
            int[] iArr = fybVar.b;
            int i2 = fybVar.h;
            fybVar.h = i2 + 1;
            fybVar.f = (iArr[i2] << 32) | (fybVar.f >>> 32);
            fybVar.g = i - 32;
        }
    }

    public static int f(fyb fybVar) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, fybVar)) == null) {
            if (fybVar.e) {
                i = (fybVar.i + 3) >> 2;
            } else {
                i = 1024;
            }
            return i - fybVar.h;
        }
        return invokeL.intValue;
    }

    public static void g(fyb fybVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, fybVar) == null) && (i = (64 - fybVar.g) & 7) != 0 && i(fybVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(fyb fybVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, fybVar) == null) {
            j(fybVar);
            a(fybVar, false);
            d(fybVar);
            d(fybVar);
        }
    }

    public static void k(fyb fybVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, fybVar) == null) && fybVar.g == 64) {
            h(fybVar);
        }
    }

    public static void c(fyb fybVar, byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, fybVar, bArr, i, i2) == null) {
            if ((fybVar.g & 7) == 0) {
                while (true) {
                    int i3 = fybVar.g;
                    if (i3 == 64 || i2 == 0) {
                        break;
                    }
                    bArr[i] = (byte) (fybVar.f >>> i3);
                    fybVar.g = i3 + 8;
                    i2--;
                    i++;
                }
                if (i2 == 0) {
                    return;
                }
                int min = Math.min(f(fybVar), i2 >> 2);
                if (min > 0) {
                    int i4 = min << 2;
                    System.arraycopy(fybVar.a, fybVar.h << 2, bArr, i, i4);
                    i += i4;
                    i2 -= i4;
                    fybVar.h += min;
                }
                if (i2 == 0) {
                    return;
                }
                if (f(fybVar) > 0) {
                    d(fybVar);
                    while (i2 != 0) {
                        long j = fybVar.f;
                        int i5 = fybVar.g;
                        bArr[i] = (byte) (j >>> i5);
                        fybVar.g = i5 + 8;
                        i2--;
                        i++;
                    }
                    a(fybVar, false);
                    return;
                }
                while (i2 > 0) {
                    try {
                        int read = fybVar.d.read(bArr, i, i2);
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

    public static int i(fyb fybVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, fybVar, i)) == null) {
            d(fybVar);
            long j = fybVar.f;
            int i2 = fybVar.g;
            int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
            fybVar.g = i2 + i;
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
    public static void j(fyb fybVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, fybVar) != null) || (i = fybVar.h) <= 1015) {
            return;
        }
        if (fybVar.e) {
            if (f(fybVar) >= -2) {
                return;
            }
            throw new BrotliRuntimeException("No more input");
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = fybVar.a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        fybVar.h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = fybVar.d.read(fybVar.a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        myb.a(fybVar.c, i3 >> 2);
    }
}
