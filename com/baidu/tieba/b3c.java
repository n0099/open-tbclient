package com.baidu.tieba;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Message;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import com.yy.transvod.player.mediafilter.MediaCodecFilter;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
@TargetApi(16)
/* loaded from: classes5.dex */
public final class b3c extends MediaCodecFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int P;
    public int Q;
    public int R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1092T;

    public b3c(p3c p3cVar, boolean z, boolean z2, z1c z1cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p3cVar, Boolean.valueOf(z), Boolean.valueOf(z2), z1cVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = false;
        this.f1092T = false;
        h1c h1cVar = this.l;
        if (h1cVar != null) {
            h1cVar.d(-10);
        }
        this.H = new WeakReference<>(p3cVar);
        this.O = z;
        this.S = z2;
        this.w = true;
        this.s = new WeakReference<>(z1cVar);
        this.b = i;
        this.o = 1;
        TLog.g(this, "videoHwDecoder decodeOutputToBuffer : " + this.O);
    }

    @Override // com.yy.transvod.player.mediafilter.MediaCodecFilter
    public int N(long j) {
        int i;
        int i2;
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            try {
                if (this.B == null) {
                    return -1;
                }
                if (!this.f1092T && this.L > 2) {
                    j = 10000;
                }
                int dequeueOutputBuffer = this.B.dequeueOutputBuffer(this.C, j);
                if (dequeueOutputBuffer >= 0) {
                    if (!this.f1092T) {
                        TLog.l(this, "mediaCodec got first decoded frame, decode cost: " + (System.currentTimeMillis() - this.M) + " mCodecDequeueCount:" + this.L);
                        this.f1092T = true;
                    }
                    ByteBuffer byteBuffer = this.E[dequeueOutputBuffer];
                    if (byteBuffer != null && byteBuffer.remaining() != this.C.size) {
                        byteBuffer.position(this.C.offset).limit(this.C.offset + this.C.size);
                    }
                    MediaSample c = this.r.c();
                    if (c != null && c.g != null && c.i != null && MediaInfo.g(this.q)) {
                        c.i.c(this.q);
                        this.u++;
                        d2c.c(c, 6);
                        n(c);
                        z1c z1cVar = this.s.get();
                        if (z1cVar != null && c.g != null) {
                            z1cVar.t((int) c.g.l);
                        }
                        if (this.F == null) {
                            c.i.k = byteBuffer;
                            synchronized (this.k) {
                                if (this.d != null) {
                                    this.d.f(c);
                                }
                            }
                            this.B.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else {
                            c.i.k = null;
                            c.h = this.G.get();
                            synchronized (this.k) {
                                if (this.d != null) {
                                    this.d.f(c);
                                }
                            }
                            this.B.releaseOutputBuffer(dequeueOutputBuffer, true);
                        }
                    }
                    return -1;
                } else if (dequeueOutputBuffer == -3) {
                    this.E = this.B.getOutputBuffers();
                    TLog.g(this, "mediaCodec output buffers have been changed.");
                    this.l.f(2004);
                } else if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.B.getOutputFormat();
                    TLog.g(this, "mediaCodec output format has been changed from " + this.p + " to " + outputFormat);
                    this.p = outputFormat;
                    if (this.F != null) {
                        this.q.a = 8;
                    } else {
                        int integer = outputFormat.getInteger("color-format");
                        if (integer != 21 && integer != 2135033992) {
                            if (integer == 19) {
                                this.q.a = 2;
                            } else {
                                this.q.a = 3;
                            }
                        }
                        this.q.a = 3;
                    }
                    if (this.p.containsKey("stride")) {
                        i = this.p.getInteger("stride");
                    } else {
                        i = 0;
                    }
                    if (this.p.containsKey("slice-height")) {
                        i2 = this.p.getInteger("slice-height");
                    } else {
                        i2 = 0;
                    }
                    this.q.d = this.p.getInteger("width");
                    this.q.e = this.p.getInteger("height");
                    if ((i > 0 || i2 > 0) && this.q.a != 8) {
                        MediaInfo mediaInfo = this.q;
                        if (this.q.d > i) {
                            i = this.q.d;
                        }
                        mediaInfo.d = i;
                        MediaInfo mediaInfo2 = this.q;
                        if (this.q.e > i2) {
                            i2 = this.q.e;
                        }
                        mediaInfo2.e = i2;
                    }
                    int i3 = this.q.b;
                    int i4 = this.q.c;
                    if (this.p.containsKey(MediaCodecVideoRenderer.KEY_CROP_LEFT) && this.p.containsKey(MediaCodecVideoRenderer.KEY_CROP_TOP) && this.p.containsKey(MediaCodecVideoRenderer.KEY_CROP_RIGHT) && this.p.containsKey(MediaCodecVideoRenderer.KEY_CROP_BOTTOM)) {
                        this.q.b = (this.p.getInteger(MediaCodecVideoRenderer.KEY_CROP_RIGHT) + 1) - this.p.getInteger(MediaCodecVideoRenderer.KEY_CROP_LEFT);
                        this.q.c = (this.p.getInteger(MediaCodecVideoRenderer.KEY_CROP_BOTTOM) + 1) - this.p.getInteger(MediaCodecVideoRenderer.KEY_CROP_TOP);
                    } else {
                        this.q.b = this.q.d;
                        this.q.c = this.q.e;
                    }
                    if (!this.O && (this.q.d >= this.q.b + 16 || this.q.e >= this.q.c + 16)) {
                        this.q.d = (int) m2c.j(this.q.b, 16L);
                        this.q.e = (int) m2c.j(this.q.c, 16L);
                    }
                    if (!this.O && this.S) {
                        this.q.e = this.q.c;
                        this.q.d = this.q.b;
                        TLog.g(this, "force not crop  planeHeight = height");
                    }
                    this.q.i = this.q.d * this.q.e;
                    if (this.G != null && this.G.get() != null) {
                        this.G.get().setDefaultBufferSize(this.q.d, this.q.e);
                    }
                    j(i3, i4, this.q);
                    this.l.f(2004);
                } else if (dequeueOutputBuffer == -1) {
                    if (!this.f1092T && this.L > 2 && this.Q < 10) {
                        this.Q++;
                        this.l.a(2004, 5L);
                    }
                    if (this.R < 5) {
                        TLog.g(this, "mediaCodec decode again output:" + dequeueOutputBuffer + " mInputCnt=" + this.L + " drainMsgCnt= " + this.Q);
                        this.R = this.R + 1;
                    }
                } else {
                    TLog.g(this, "mediaCodec decode output:" + dequeueOutputBuffer + " mInputCnt=" + this.L);
                }
                if (dequeueOutputBuffer < 0) {
                    return 0;
                }
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                TLog.c(this, "mediaCodec decode error.");
                throw e;
            }
        }
        return invokeJ.intValue;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TLog.g(this, "VideoHwDecodeFilter.releaseSurface enter.");
            super.onStop();
            Surface surface = this.F;
            if (surface != null) {
                surface.release();
                this.F = null;
            }
            this.G = null;
            TLog.g(this, "VideoHwDecodeFilter.releaseSurface leave.");
        }
    }

    @Override // com.yy.transvod.player.mediafilter.MediaCodecFilter, com.baidu.tieba.q2c, com.baidu.tieba.z2c, com.baidu.tieba.h1c.a
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            int i = message.what;
            if (i != 1002) {
                if (i == 2004) {
                    TLog.g(this, "VideoHwDecodeFilter.CODEC_FILTER_DRAIN_OUTPUT.");
                    if (!this.f1092T) {
                        try {
                            N(0L);
                        } catch (Exception e) {
                            TLog.c(this, "mediaCodec decode error::get first frame" + e.toString());
                        }
                    }
                }
            } else {
                P();
            }
            super.handleMessage(message);
        }
    }

    @Override // com.baidu.tieba.q2c
    public void z(MediaFormat mediaFormat, int i) {
        boolean z;
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, mediaFormat, i) == null) {
            if (this.P % 20 == 0) {
                z = true;
            } else {
                z = false;
            }
            this.P++;
            p3c p3cVar = this.H.get();
            if (!this.z.get() && (p3cVar == null || p3cVar.y() == null)) {
                try {
                    Thread.sleep(30L);
                } catch (Exception unused) {
                    TLog.g(this, "videoHwDecoder sleep exception");
                }
                Message obtain = Message.obtain();
                obtain.what = 2001;
                obtain.obj = mediaFormat;
                obtain.arg1 = i;
                this.l.g(2001);
                this.l.sendMessage(obtain);
                if (z) {
                    TLog.g(this, "handleCreateDecoder try again ");
                }
            } else {
                this.x = System.currentTimeMillis();
                TLog.g(this, "VideoHwDecoder do create codec. taskId " + i);
                MediaCodec mediaCodec = this.B;
                try {
                    if (mediaCodec != null) {
                        try {
                            mediaCodec.stop();
                            this.B.release();
                            TLog.l(this, "VideoHwDecodeFilter stop old codec when create decoder");
                        } catch (Exception e) {
                            e.printStackTrace();
                            TLog.c(this, "VideoHwDecodeFilter mediaCodec stop error");
                        }
                        this.B.release();
                        this.B = null;
                    }
                    if (this.O) {
                        MediaCodec J = J(null, mediaFormat);
                        this.B = J;
                        this.a = i;
                        this.L = 0;
                        if (J == null) {
                            A();
                        }
                    } else {
                        if (p3cVar != null) {
                            surfaceTexture = p3cVar.y();
                        } else {
                            surfaceTexture = null;
                        }
                        WeakReference<SurfaceTexture> weakReference = new WeakReference<>(surfaceTexture);
                        this.G = weakReference;
                        if (weakReference.get() != null) {
                            Surface surface = this.F;
                            if (surface != null) {
                                surface.release();
                                this.F = null;
                            }
                            TLog.g(this, "mSurfaceTexture " + this.G.get());
                            Surface surface2 = new Surface(this.G.get());
                            this.F = surface2;
                            MediaCodec J2 = J(surface2, mediaFormat);
                            this.B = J2;
                            this.a = i;
                            this.L = 0;
                            if (J2 == null) {
                                A();
                            }
                        }
                    }
                    this.f1092T = false;
                    this.Q = 0;
                    this.R = 0;
                    this.P = 0;
                    this.y = System.currentTimeMillis();
                    TLog.l(this, "VideoHwDecodeFilter.handleCreateDecoder suceess, cost= " + (this.y - this.x));
                } catch (Throwable th) {
                    this.B.release();
                    throw th;
                }
            }
            if (z) {
                TLog.g(this, "VideoHwDecodeFilter.handleCreateDecoder leave ");
            }
        }
    }
}
