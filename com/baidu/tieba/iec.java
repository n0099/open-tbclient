package com.baidu.tieba;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.yy.transvod.player.common.AVframe;
import com.yy.transvod.player.log.TLog;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes6.dex */
public final class iec {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            if (i == 22 || i == 53) {
                return true;
            }
            switch (i) {
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                    return true;
                default:
                    return false;
            }
        }
        return invokeI.booleanValue;
    }

    public static long j(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j2 - 1;
            return (j + j3) & (~j3);
        }
        return invokeCommon.longValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947852066, "Lcom/baidu/tieba/iec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947852066, "Lcom/baidu/tieba/iec;");
                return;
            }
        }
        a = new byte[]{0, 0, 0, 1};
    }

    public static MediaFormat a(AVframe aVframe) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVframe)) == null) {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", aVframe.g, aVframe.h);
            createAudioFormat.setInteger("channel-layout", (int) aVframe.i);
            createAudioFormat.setInteger("channel-count", aVframe.h);
            byte[] bArr = aVframe.o;
            if (bArr != null) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
                allocateDirect.put(aVframe.o);
                allocateDirect.flip();
                createAudioFormat.setByteBuffer("csd-0", allocateDirect);
            }
            return createAudioFormat;
        }
        return (MediaFormat) invokeL.objValue;
    }

    public static MediaFormat b(int i, int i2, ByteBuffer byteBuffer, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), byteBuffer, Boolean.valueOf(z)})) == null) {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
            if (byteBuffer != null) {
                createVideoFormat.setByteBuffer("csd-0", g(byteBuffer));
                createVideoFormat.setByteBuffer("csd-1", f(byteBuffer));
            }
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("createAVCFormat width=");
                sb.append(i);
                sb.append(" height=");
                sb.append(i2);
                sb.append(" buffer=null? ");
                if (byteBuffer == null) {
                    str = "y";
                } else {
                    str = "n";
                }
                sb.append(str);
                TLog.h("[transvod]", sb.toString());
            }
            return createVideoFormat;
        }
        return (MediaFormat) invokeCommon.objValue;
    }

    public static MediaFormat c(int i, int i2, ByteBuffer byteBuffer, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), byteBuffer, Boolean.valueOf(z)})) == null) {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H265, i, i2);
            if (byteBuffer != null) {
                byteBuffer = h(byteBuffer);
                createVideoFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("createHevcFormat width=");
                sb.append(i);
                sb.append(" height=");
                sb.append(i2);
                sb.append(" buffer=null?");
                if (byteBuffer == null) {
                    str = "y";
                } else {
                    str = "n";
                }
                sb.append(str);
                TLog.h("[transvod]", sb.toString());
            }
            return createVideoFormat;
        }
        return (MediaFormat) invokeCommon.objValue;
    }

    public static int d(byte[] bArr, ByteBuffer byteBuffer) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, byteBuffer)) == null) {
            byteBuffer.limit();
            if (bArr == null || bArr.length <= 0) {
                return 0;
            }
            int length = bArr.length - 1;
            int i2 = 0;
            while (true) {
                if (i2 <= bArr.length - 4) {
                    byte b = bArr[i2 + 0];
                    byte[] bArr2 = a;
                    if (b == bArr2[0] && bArr[i2 + 1] == bArr2[1] && bArr[i2 + 2] == bArr2[2] && bArr[i2 + 3] == bArr2[3]) {
                        i2 += 4;
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    i = -1;
                    break;
                }
            }
            while (true) {
                if (i2 > bArr.length - 4) {
                    break;
                }
                byte b2 = bArr[i2 + 0];
                byte[] bArr3 = a;
                if (b2 == bArr3[0] && bArr[i2 + 1] == bArr3[1] && bArr[i2 + 2] == bArr3[2] && bArr[i2 + 3] == bArr3[3]) {
                    length = i2 - 1;
                    break;
                }
                i2++;
            }
            byteBuffer.putInt(bArr.length + 3);
            byteBuffer.put((byte) 1);
            byteBuffer.put(bArr[i + 1]);
            byteBuffer.put(bArr[i + 2]);
            byteBuffer.put(bArr[i + 3]);
            byteBuffer.put((byte) -1);
            byteBuffer.put(ExifInterface.MARKER_APP1);
            int i3 = (length - i) + 1;
            byteBuffer.putShort((short) i3);
            byteBuffer.put(bArr, i, i3);
            byteBuffer.put((byte) 1);
            byteBuffer.putShort((short) ((bArr.length - length) - 5));
            byteBuffer.put(bArr, length + 5, (bArr.length - length) - 5);
            return bArr.length + 7;
        }
        return invokeLL.intValue;
    }

    public static ByteBuffer e(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        boolean z2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, bArr, i, i2)) == null) {
            if (bArr != null) {
                if (bArr.length < 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (bArr.length < i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!(z | z2)) {
                    int length = bArr.length - 1;
                    int i4 = 0;
                    while (true) {
                        if (i <= bArr.length - 4) {
                            byte b = bArr[i + 0];
                            byte[] bArr2 = a;
                            if (b == bArr2[0] && bArr[i + 1] == bArr2[1] && bArr[i + 2] == bArr2[2] && bArr[i + 3] == bArr2[3]) {
                                i4++;
                                if (i4 == i2) {
                                    i += 4;
                                    i3 = i;
                                    break;
                                }
                                i += 4;
                            } else {
                                i++;
                            }
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                    while (true) {
                        if (i > bArr.length - 4) {
                            break;
                        }
                        byte b2 = bArr[i + 0];
                        byte[] bArr3 = a;
                        if (b2 == bArr3[0] && bArr[i + 1] == bArr3[1] && bArr[i + 2] == bArr3[2] && bArr[i + 3] == bArr3[3]) {
                            length = i - 1;
                            break;
                        }
                        i++;
                    }
                    if (length >= i3 && i3 != -1) {
                        int i5 = (length - i3) + 1;
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(a.length + i5);
                        allocateDirect.put(a);
                        allocateDirect.put(bArr, i3, i5);
                        return (ByteBuffer) allocateDirect.flip();
                    }
                }
            }
            return null;
        }
        return (ByteBuffer) invokeLII.objValue;
    }

    public static ByteBuffer f(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, byteBuffer)) == null) {
            if (byteBuffer.hasArray()) {
                return e(byteBuffer.array(), byteBuffer.arrayOffset(), 2);
            }
            return null;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static ByteBuffer g(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, byteBuffer)) == null) {
            if (byteBuffer.hasArray()) {
                return e(byteBuffer.array(), byteBuffer.arrayOffset(), 1);
            }
            return null;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static ByteBuffer h(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, byteBuffer)) == null) {
            int limit = byteBuffer.mark().limit();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
            allocateDirect.put(byteBuffer);
            byteBuffer.reset().limit(limit);
            return allocateDirect;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static int k(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, byteBuffer, byteBuffer2, z)) == null) {
            int limit = byteBuffer.mark().limit();
            int i = 0;
            while (byteBuffer.position() < limit) {
                int i2 = byteBuffer.getInt();
                try {
                    byteBuffer.limit(byteBuffer.position() + i2);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                byteBuffer2.put(a).put(byteBuffer);
                byteBuffer.limit(limit);
                i += i2 + a.length;
            }
            byteBuffer.reset().limit(limit);
            return i;
        }
        return invokeLLZ.intValue;
    }
}
