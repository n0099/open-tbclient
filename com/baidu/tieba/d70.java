package com.baidu.tieba;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;
/* loaded from: classes5.dex */
public abstract class d70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, byteBuffer, i)) == null) ? byteBuffer.getShort(i) & UShort.MAX_VALUE : invokeLI.intValue;
    }

    public static long b(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, byteBuffer)) == null) {
            k(byteBuffer);
            return i(byteBuffer, byteBuffer.position() + 16);
        }
        return invokeL.longValue;
    }

    public static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, randomAccessFile)) == null) {
            if (randomAccessFile.length() < 22) {
                return null;
            }
            Pair<ByteBuffer, Long> d = d(randomAccessFile, 0);
            return d != null ? d : d(randomAccessFile, 65535);
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, randomAccessFile, i)) == null) {
            if (i < 0 || i > 65535) {
                throw new IllegalArgumentException("maxCommentSize: " + i);
            }
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i, length - 22)) + 22);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            long capacity = length - allocate.capacity();
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            int j = j(allocate);
            if (j == -1) {
                return null;
            }
            allocate.position(j);
            ByteBuffer slice = allocate.slice();
            slice.order(ByteOrder.LITTLE_ENDIAN);
            return Pair.create(slice, Long.valueOf(capacity + j));
        }
        return (Pair) invokeLI.objValue;
    }

    public static void e(ByteBuffer byteBuffer, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (j >= 0 && j <= 4294967295L) {
                byteBuffer.putInt(byteBuffer.position() + i, (int) j);
                return;
            }
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
    }

    public static void f(ByteBuffer byteBuffer, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65541, null, byteBuffer, j) == null) {
            k(byteBuffer);
            e(byteBuffer, byteBuffer.position() + 16, j);
        }
    }

    public static final boolean g(RandomAccessFile randomAccessFile, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, randomAccessFile, j)) == null) {
            long j2 = j - 20;
            if (j2 < 0) {
                return false;
            }
            randomAccessFile.seek(j2);
            return randomAccessFile.readInt() == 1347094023;
        }
        return invokeLJ.booleanValue;
    }

    public static long h(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, byteBuffer)) == null) {
            k(byteBuffer);
            return i(byteBuffer, byteBuffer.position() + 12);
        }
        return invokeL.longValue;
    }

    public static long i(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, byteBuffer, i)) == null) ? byteBuffer.getInt(i) & 4294967295L : invokeLI.longValue;
    }

    public static int j(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, byteBuffer)) == null) {
            k(byteBuffer);
            int capacity = byteBuffer.capacity();
            if (capacity < 22) {
                return -1;
            }
            int i = capacity - 22;
            int min = Math.min(i, 65535);
            for (int i2 = 0; i2 < min; i2++) {
                int i3 = i - i2;
                if (byteBuffer.getInt(i3) == 101010256 && a(byteBuffer, i3 + 20) == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void k(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, byteBuffer) == null) && byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
