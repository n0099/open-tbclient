package com.baidu.tieba;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class dy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaCodec a;
    public ByteBuffer[] b;
    public ByteBuffer[] c;
    public MediaCodec.BufferInfo d;
    public ByteArrayOutputStream e;
    public long f;
    public int g;
    public int h;
    public String i;

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            switch (i) {
                case 7350:
                    return 12;
                case 11025:
                    return 10;
                case 12000:
                    return 9;
                case 16000:
                    return 8;
                case 22050:
                    return 7;
                case 24000:
                    return 6;
                case 32000:
                    return 5;
                case 44100:
                    return 4;
                case 48000:
                    return 3;
                case 64000:
                    return 2;
                case 88200:
                    return 1;
                case 96000:
                    return 0;
                default:
                    return 11;
            }
        }
        return invokeI.intValue;
    }

    public final byte[] g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) ? bArr : (byte[]) invokeL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947720812, "Lcom/baidu/tieba/dy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947720812, "Lcom/baidu/tieba/dy2;");
                return;
            }
        }
        j = wp1.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064 A[Catch: IOException -> 0x00b6, TryCatch #0 {IOException -> 0x00b6, blocks: (B:8:0x002c, B:27:0x0064, B:29:0x0068, B:30:0x006f, B:32:0x008b, B:15:0x0045, B:18:0x004f, B:21:0x0059), top: B:41:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public dy2(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = 0L;
        char c = 0;
        this.g = 0;
        this.h = 0;
        this.i = "aac";
        this.g = i2;
        this.h = i;
        this.e = new ByteArrayOutputStream();
        if (TextUtils.isEmpty(str)) {
            this.i = "aac";
        } else {
            this.i = str;
        }
        try {
            String str2 = this.i;
            int hashCode = str2.hashCode();
            if (hashCode != 96323) {
                if (hashCode != 108272) {
                    if (hashCode == 110810 && str2.equals("pcm")) {
                        c = 2;
                        if (c != 0) {
                            if (j) {
                                Log.d("AudioRecorderManager", "aac format init");
                            }
                            MediaCodecInfo d = d("audio/mp4a-latm");
                            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i2, i);
                            createAudioFormat.setInteger("bitrate", i3);
                            createAudioFormat.setInteger("aac-profile", 2);
                            createAudioFormat.setInteger("max-input-size", 102400);
                            if (d != null) {
                                MediaCodec createByCodecName = MediaCodec.createByCodecName(d.getName());
                                this.a = createByCodecName;
                                createByCodecName.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
                                this.a.start();
                                this.b = this.a.getInputBuffers();
                                this.c = this.a.getOutputBuffers();
                                this.d = new MediaCodec.BufferInfo();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                } else {
                    if (str2.equals("mp3")) {
                        c = 1;
                        if (c != 0) {
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                }
            } else {
                if (str2.equals("aac")) {
                    if (c != 0) {
                    }
                }
                c = 65535;
                if (c != 0) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        e.printStackTrace();
    }

    public final long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            int i = this.g;
            if (i == 0) {
                return 0L;
            }
            return (((j2 * 1000) * 90) * 1024) / i;
        }
        return invokeJ.longValue;
    }

    public final byte[] c(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            int i5 = i + 7;
            byte[] bArr = new byte[i5];
            int a = a(i3);
            bArr[0] = -1;
            bArr[1] = -15;
            bArr[2] = (byte) (((i2 - 1) << 6) + (a << 2) + (i4 >> 2));
            bArr[3] = (byte) (((i4 & 3) << 6) + (i5 >> 11));
            bArr[4] = (byte) ((i5 & 2047) >> 3);
            bArr[5] = (byte) (((i5 & 7) << 5) + 31);
            bArr[6] = -4;
            return bArr;
        }
        return (byte[]) invokeIIII.objValue;
    }

    public final MediaCodecInfo d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                if (codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            return codecInfoAt;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    public final byte[] e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            if (this.a != null && bArr != null) {
                if (j) {
                    Log.d("AudioRecorderManager", "start AAC encode");
                }
                int dequeueInputBuffer = this.a.dequeueInputBuffer(-1L);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer = this.b[dequeueInputBuffer];
                    byteBuffer.clear();
                    try {
                        byteBuffer.put(bArr);
                        byteBuffer.limit(bArr.length);
                        this.a.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, b(this.f), 0);
                        this.f++;
                    } catch (IllegalArgumentException | BufferOverflowException e) {
                        if (j) {
                            e.printStackTrace();
                        }
                        return bArr;
                    }
                }
                int dequeueOutputBuffer = this.a.dequeueOutputBuffer(this.d, 0L);
                while (dequeueOutputBuffer >= 0) {
                    MediaCodec.BufferInfo bufferInfo = this.d;
                    int i = bufferInfo.size;
                    ByteBuffer byteBuffer2 = this.c[dequeueOutputBuffer];
                    try {
                        byteBuffer2.position(bufferInfo.offset);
                        byteBuffer2.limit(this.d.offset + i);
                        byte[] c = c(i, 2, this.g, this.h);
                        try {
                            byteBuffer2.get(c, 7, i);
                            byteBuffer2.position(this.d.offset);
                            this.e.write(c);
                            this.a.releaseOutputBuffer(dequeueOutputBuffer, false);
                            dequeueOutputBuffer = this.a.dequeueOutputBuffer(this.d, 0L);
                        } catch (IOException | IllegalArgumentException | BufferUnderflowException e2) {
                            if (j) {
                                e2.printStackTrace();
                            }
                            return bArr;
                        }
                    } catch (IllegalArgumentException e3) {
                        if (j) {
                            e3.printStackTrace();
                        }
                        return bArr;
                    }
                }
                bArr = this.e.toByteArray();
                try {
                    this.e.flush();
                } catch (IOException e4) {
                    if (j) {
                        e4.printStackTrace();
                    }
                }
                this.e.reset();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) {
            if (this.a != null && bArr != null) {
                String str = this.i;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 96323) {
                    if (hashCode != 108272) {
                        if (hashCode == 110810 && str.equals("pcm")) {
                            c = 2;
                        }
                    } else if (str.equals("mp3")) {
                        c = 1;
                    }
                } else if (str.equals("aac")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c != 1) {
                        return bArr;
                    }
                    g(bArr);
                    return bArr;
                }
                return e(bArr);
            }
            if (j) {
                Log.d("AudioRecorderManager", "wrong input or mediaCodec");
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
