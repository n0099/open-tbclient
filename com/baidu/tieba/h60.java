package com.baidu.tieba;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;
/* loaded from: classes4.dex */
public abstract class h60 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65536, null, byteBuffer) != null) || byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            return;
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, randomAccessFile)) == null) {
            if (randomAccessFile.length() < 22) {
                return null;
            }
            Pair<ByteBuffer, Long> d = d(randomAccessFile, 0);
            if (d != null) {
                return d;
            }
            return d(randomAccessFile, 65535);
        }
        return (Pair) invokeL.objValue;
    }

    public static long g(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, byteBuffer)) == null) {
            a(byteBuffer);
            return f(byteBuffer, byteBuffer.position() + 16);
        }
        return invokeL.longValue;
    }

    public static long h(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, byteBuffer)) == null) {
            a(byteBuffer);
            return f(byteBuffer, byteBuffer.position() + 12);
        }
        return invokeL.longValue;
    }

    public static int b(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, byteBuffer)) == null) {
            a(byteBuffer);
            int capacity = byteBuffer.capacity();
            if (capacity < 22) {
                return -1;
            }
            int i = capacity - 22;
            int min = Math.min(i, 65535);
            for (int i2 = 0; i2 < min; i2++) {
                int i3 = i - i2;
                if (byteBuffer.getInt(i3) == 101010256 && e(byteBuffer, i3 + 20) == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, randomAccessFile, i)) == null) {
            if (i >= 0 && i <= 65535) {
                long length = randomAccessFile.length();
                if (length < 22) {
                    return null;
                }
                ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i, length - 22)) + 22);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                long capacity = length - allocate.capacity();
                randomAccessFile.seek(capacity);
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                int b = b(allocate);
                if (b == -1) {
                    return null;
                }
                allocate.position(b);
                ByteBuffer slice = allocate.slice();
                slice.order(ByteOrder.LITTLE_ENDIAN);
                return Pair.create(slice, Long.valueOf(capacity + b));
            }
            throw new IllegalArgumentException("maxCommentSize: " + i);
        }
        return (Pair) invokeLI.objValue;
    }

    public static int e(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer, i)) == null) {
            return byteBuffer.getShort(i) & UShort.MAX_VALUE;
        }
        return invokeLI.intValue;
    }

    public static long f(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, byteBuffer, i)) == null) {
            return byteBuffer.getInt(i) & 4294967295L;
        }
        return invokeLI.longValue;
    }

    public static final boolean i(RandomAccessFile randomAccessFile, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65544, null, randomAccessFile, j)) == null) {
            long j2 = j - 20;
            if (j2 < 0) {
                return false;
            }
            randomAccessFile.seek(j2);
            if (randomAccessFile.readInt() != 1347094023) {
                return false;
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public static void k(ByteBuffer byteBuffer, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65546, null, byteBuffer, j) == null) {
            a(byteBuffer);
            j(byteBuffer, byteBuffer.position() + 16, j);
        }
    }

    public static void j(ByteBuffer byteBuffer, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (j >= 0 && j <= 4294967295L) {
                byteBuffer.putInt(byteBuffer.position() + i, (int) j);
                return;
            }
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
    }
}
