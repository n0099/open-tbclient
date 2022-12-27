package com.baidu.tieba;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.VideoEncoderCore;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes4.dex */
public class cm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface a;
    public bm9 b;
    public MediaCodec c;
    public MediaCodec.BufferInfo d;
    public int e;
    public boolean f;
    public Bundle g;
    public long h;
    public int i;

    @TargetApi(18)
    public cm9(int i, int i2, int i3, boolean z, bm9 bm9Var) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), bm9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new Bundle();
        this.h = 0L;
        this.i = 10000;
        String str = MimeTypes.VIDEO_H265;
        str = (!z || xm9.m(MimeTypes.VIDEO_H265) == null) ? "video/avc" : "video/avc";
        this.d = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i3);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("i-frame-interval", 5);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        this.c = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.a = this.c.createInputSurface();
        this.c.start();
        this.g.putInt("request-sync", 0);
        if (Build.VERSION.SDK_INT >= 19) {
            this.c.setParameters(this.g);
        }
        this.e = -1;
        this.f = false;
        this.b = bm9Var;
    }

    public Surface a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Surface) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.i = i;
        }
    }

    @RequiresApi(api = 18)
    public void c(boolean z) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) != null) {
            return;
        }
        if (z) {
            this.c.signalEndOfInputStream();
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.c.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.c.dequeueOutputBuffer(this.d, this.i);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.c.getOutputFormat();
                    nm9.c(VideoEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.e = this.b.a(outputFormat);
                    if (!this.b.c()) {
                        synchronized (this.b) {
                            while (!this.b.e()) {
                                try {
                                    this.b.wait(100L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f = true;
                } else if (dequeueOutputBuffer < 0) {
                    nm9.l(VideoEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.d;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.d;
                    if (bufferInfo2.size != 0) {
                        if (!this.f) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        byteBuffer.position(bufferInfo2.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.d;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.b.b(this.e, byteBuffer, this.d);
                    }
                    this.c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.h >= 500) {
                        this.c.setParameters(this.g);
                        this.h = System.currentTimeMillis();
                    }
                    if ((this.d.flags & 4) != 0) {
                        if (z) {
                            return;
                        }
                        nm9.l(VideoEncoderCore.TAG, "reached end of stream unexpectedly");
                        return;
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaCodec mediaCodec = this.c;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.c.release();
                this.c = null;
            }
            bm9 bm9Var = this.b;
            if (bm9Var != null) {
                try {
                    bm9Var.d();
                } catch (IllegalStateException e) {
                    nm9.g(e);
                }
                this.b = null;
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
            }
        }
    }
}
