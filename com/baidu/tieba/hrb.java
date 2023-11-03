package com.baidu.tieba;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.EglCore;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.faceunity.gles.WindowSurface;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.faceunity.encoder.TextureMovieEncoder;
import com.faceunity.gles.GeneratedTexture;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import kotlinx.coroutines.CoroutineContextKt;
@TargetApi(18)
/* loaded from: classes6.dex */
public class hrb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public orb B;
    public boolean C;
    public boolean D;
    public fob E;
    public boolean F;
    public f G;
    public d H;
    public final Object I;
    public boolean J;
    public final Object K;
    public boolean L;
    public String M;
    public boolean N;
    public volatile boolean O;
    public long P;
    public long Q;
    public volatile long R;
    public WindowSurface a;
    public EglCore b;
    public FullFrameRect c;
    public int d;
    public lrb e;
    public irb f;
    public krb g;
    public volatile g h;
    public Object i;
    public boolean j;
    public boolean k;
    public int l;
    public b m;
    public e n;
    public volatile long o;
    public volatile long p;
    public volatile long q;
    public volatile long r;
    public int s;
    public int t;
    public int u;
    public volatile boolean v;
    public float w;
    public float x;
    public long y;
    public long z;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onError(int i, String str);

        void onProgress(long j);

        void onStartSuccess();

        @WorkerThread
        void onStopSuccess();
    }

    /* loaded from: classes6.dex */
    public class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hrb a;

        public c(hrb hrbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hrbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hrbVar;
        }

        public /* synthetic */ c(hrb hrbVar, a aVar) {
            this(hrbVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            irb irbVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(-19);
                int i = RecordConstants.MOVIE_ENCODE_SAMPLE_RATE;
                job jobVar = (job) msb.a("com.baidu.ugc.audioedit.AudioSpeedOperator");
                if (jobVar != null) {
                    jobVar.init(i, 1);
                    jobVar.setSpeed(this.a.w);
                }
                synchronized (this.a.I) {
                    while (!this.a.J) {
                        try {
                            this.a.I.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    jrb jrbVar = new jrb(this.a.A);
                    if (jrbVar.d() != null) {
                        this.a.v = true;
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(jrb.d);
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(10240);
                        jrbVar.c();
                        if (jrbVar.e() != 3) {
                            hrb hrbVar = this.a;
                            hrbVar.e(1114, "音频开始录制失败 " + jrbVar.e());
                            jrbVar.b();
                            this.a.f.d();
                            return;
                        }
                        this.a.l = 1;
                        while (!this.a.O) {
                            try {
                                allocateDirect.clear();
                                allocateDirect2.clear();
                                int a = jrbVar.a(allocateDirect, jrb.d);
                                if (this.a.C && this.a.B != null) {
                                    double a2 = qrb.a(allocateDirect, a);
                                    if (a2 > 0.0d) {
                                        this.a.B.a(a2);
                                    }
                                }
                                if (a > 0) {
                                    if (jobVar == null) {
                                        allocateDirect.position(a);
                                        allocateDirect.flip();
                                        this.a.f.b(allocateDirect, 0, a, this.a.G());
                                        irbVar = this.a.f;
                                    } else {
                                        byte[] bArr = new byte[a];
                                        allocateDirect.get(bArr);
                                        jobVar.putBytes(bArr, a);
                                        allocateDirect.position(a);
                                        allocateDirect.flip();
                                        int availableBytes = jobVar.availableBytes();
                                        if (availableBytes > 0) {
                                            byte[] bArr2 = new byte[availableBytes];
                                            jobVar.receiveBytes(bArr2, availableBytes);
                                            if (this.a.D) {
                                                byte[] k = mqb.k(bArr2, 4.0d);
                                                if (k != null) {
                                                    availableBytes = k.length;
                                                }
                                                allocateDirect2.put(k);
                                            } else {
                                                allocateDirect2.put(bArr2);
                                            }
                                            int i2 = availableBytes;
                                            allocateDirect2.position(i2);
                                            allocateDirect2.flip();
                                            this.a.f.b(allocateDirect2, 0, i2, this.a.G());
                                            irbVar = this.a.f;
                                        }
                                    }
                                    irbVar.c();
                                }
                            } finally {
                                jrbVar.b();
                            }
                        }
                        this.a.f.b(null, 0, 0, this.a.G());
                        this.a.f.c();
                        jrbVar.b();
                        this.a.f.d();
                    } else {
                        wrb.e(TextureMovieEncoder.TAG, "failed to initialize AudioRecord");
                    }
                } catch (Exception e2) {
                    wrb.f(TextureMovieEncoder.TAG, "AudioThread#run", e2);
                    wrb.g(e2);
                    if (this.a.l != 6) {
                        this.a.l = 6;
                        String message = e2.getMessage();
                        hrb hrbVar2 = this.a;
                        hrbVar2.e(1115, "结束音频编码错误" + message);
                    }
                }
                synchronized (this.a.K) {
                    this.a.L = true;
                    this.a.K.notifyAll();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final File a;
        public final int b;
        public final int c;
        public final int d;
        public final EGLContext e;
        public final long f;
        public int g;

        public d(File file, int i, int i2, int i3, int i4, EGLContext eGLContext, long j, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eGLContext, Long.valueOf(j), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = 10000;
            this.a = file;
            this.b = i;
            this.c = i2;
            this.d = i3;
            if (eGLContext != null) {
                this.e = eGLContext;
            } else {
                this.e = EGL14.eglGetCurrentContext();
            }
            this.f = j;
            this.g = i5;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "EncoderConfig: " + this.b + "x" + this.c + CoroutineContextKt.DEBUG_THREAD_NAME_SEPARATOR + this.d + " to '" + this.a.toString() + "' ctxt=" + this.e;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(long j);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes6.dex */
    public static class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<hrb> a;

        public g(hrb hrbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hrbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(hrbVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                Object obj = message.obj;
                hrb hrbVar = this.a.get();
                if (hrbVar == null) {
                    wrb.l(TextureMovieEncoder.TAG, "VideoEncoderHandler.handleMessage: encoder is null");
                } else if (i == 0) {
                    hrbVar.C((d) obj);
                } else if (i == 1) {
                    hrbVar.P();
                } else if (i == 2) {
                    if (hrbVar.N) {
                        hrbVar.t((float[]) obj, (message.arg1 << 32) | (message.arg2 & 4294967295L));
                    }
                } else if (i == 3) {
                    if (hrbVar.N) {
                        hrbVar.H(message.arg1);
                    }
                } else if (i == 4) {
                    if (hrbVar.N) {
                        hrbVar.g((EGLContext) message.obj);
                    }
                } else if (i == 5) {
                    Looper.myLooper().quit();
                } else {
                    throw new RuntimeException("Unhandled msg what=" + i);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hrb a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(hrb hrbVar, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hrbVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hrbVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                synchronized (this.a.i) {
                    this.a.h = new g(this.a);
                    this.a.j = true;
                    this.a.i.notifyAll();
                }
                Looper.loop();
                wrb.c(TextureMovieEncoder.TAG, "Encoder thread exiting");
                synchronized (this.a.i) {
                    hrb hrbVar = this.a;
                    this.a.k = false;
                    hrbVar.j = false;
                    this.a.h = null;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947834737, "Lcom/baidu/tieba/hrb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947834737, "Lcom/baidu/tieba/hrb;");
        }
    }

    public hrb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new Object();
        this.l = 4;
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.v = false;
        this.w = 1.0f;
        this.x = 0.0f;
        this.y = -1L;
        this.z = 0L;
        this.A = -100;
        this.E = null;
        this.H = null;
        this.I = new Object();
        this.J = false;
        this.K = new Object();
        this.L = false;
        this.M = null;
        this.N = false;
        this.O = false;
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        this.l = 2;
    }

    public void A(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.x = f2;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.A = i;
        }
    }

    public final void C(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            wrb.c(TextureMovieEncoder.TAG, "handleStartRecording " + dVar);
            this.H = dVar;
            sqb sqbVar = new sqb();
            if (w(dVar.e, dVar.b, dVar.c, dVar.d, dVar.a, sqbVar)) {
                this.O = false;
                b bVar = this.m;
                if (bVar != null) {
                    bVar.onStartSuccess();
                }
            } else if (this.l != 6) {
                this.l = 6;
                String str = sqbVar.e;
                e(1111, "开始录制编码错误" + dVar.toString() + " , 错误信息：" + str);
            }
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.C = z;
        }
    }

    public long G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.w == 1.0f) {
                return M();
            }
            long nanoTime = System.nanoTime();
            if (this.o != 0) {
                if (this.r == 0) {
                    this.r = nanoTime;
                }
                nanoTime = (((float) (nanoTime - this.r)) / this.w) + this.o;
            }
            long j = nanoTime / 1000;
            long j2 = this.Q;
            if (j < j2) {
                j = 100 + j2;
            }
            this.Q = j;
            return j;
        }
        return invokeV.longValue;
    }

    public final void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d = i;
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.D = z;
        }
    }

    public long M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long nanoTime = System.nanoTime();
            if (this.o != 0) {
                if (this.p == 0) {
                    this.p = nanoTime;
                }
                nanoTime = (((float) (nanoTime - this.p)) / this.w) + this.o;
            }
            long j = nanoTime / 1000;
            if (j < this.R) {
                j = this.R + 100;
            }
            this.R = j;
            return j;
        }
        return invokeV.longValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            wrb.c(TextureMovieEncoder.TAG, "handleStopRecording");
            this.O = true;
            try {
                this.e.c(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Q();
            wrb.e(TextureMovieEncoder.TAG, "handleStopRecording before stop success");
            while (!this.L && this.v) {
                synchronized (this.K) {
                    try {
                        this.K.wait();
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            long a2 = uqb.a(this.M);
            e eVar = this.n;
            if (eVar != null) {
                eVar.a(a2);
            }
            this.L = false;
            b bVar = this.m;
            if (bVar != null) {
                bVar.onStopSuccess();
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                this.e.d();
                if (this.a != null) {
                    this.a.release();
                    this.a = null;
                }
                if (this.c != null) {
                    this.c.release(false);
                    this.c = null;
                }
                if (this.b != null) {
                    this.b.release();
                    this.b = null;
                }
            } catch (Exception e2) {
                wrb.g(e2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.i) {
                while (!this.j) {
                    try {
                        this.i.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
            this.s = 0;
            krb krbVar = this.g;
            if (krbVar == null || !krbVar.e()) {
                this.O = true;
                lrb lrbVar = this.e;
                if (lrbVar != null) {
                    lrbVar.e();
                }
                irb irbVar = this.f;
                if (irbVar != null) {
                    irbVar.a();
                }
            }
            this.l = 4;
            this.h.sendMessage(this.h.obtainMessage(1));
            this.h.sendMessage(this.h.obtainMessage(5));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r5 < 0.33333334f) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048587, this, f2) == null) || f2 == this.w) {
            return;
        }
        float f3 = f2 <= 3.0f ? 0.33333334f : 3.0f;
        this.w = f3;
        this.w = f2;
    }

    public final void e(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, str) == null) {
            c();
            b bVar = this.m;
            if (bVar != null) {
                bVar.onError(i, str);
            }
        }
    }

    public void f(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceTexture) == null) {
            synchronized (this.i) {
                if (this.j) {
                    synchronized (this.I) {
                        if (!this.J && this.N) {
                            this.J = true;
                            this.I.notifyAll();
                            this.l = 1;
                            if (this.G != null) {
                                this.G.a();
                            }
                        }
                    }
                    if (this.J) {
                        float[] fArr = new float[16];
                        Matrix.setIdentityM(fArr, 0);
                        long timestamp = surfaceTexture.getTimestamp();
                        if (timestamp == 0) {
                            wrb.l(TextureMovieEncoder.TAG, "HEY: got SurfaceTexture with timestamp of zero");
                        } else {
                            this.h.sendMessage(this.h.obtainMessage(2, (int) (timestamp >> 32), (int) timestamp, fArr));
                        }
                    }
                }
            }
        }
    }

    public final void g(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eGLContext) == null) {
            wrb.c(TextureMovieEncoder.TAG, "handleUpdatedSharedContext " + eGLContext);
            WindowSurface windowSurface = this.a;
            if (windowSurface != null) {
                windowSurface.releaseEglSurface();
            }
            this.c.release(false);
            EglCore eglCore = this.b;
            if (eglCore != null) {
                eglCore.release();
            }
            EglCore eglCore2 = new EglCore(eGLContext, 2);
            this.b = eglCore2;
            WindowSurface windowSurface2 = this.a;
            if (windowSurface2 != null) {
                windowSurface2.recreate(eglCore2);
                this.a.makeCurrent();
            }
            this.c = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
        }
    }

    public void h(FullFrameRect fullFrameRect, int i, float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048591, this, fullFrameRect, i, fArr) == null) || this.s == 0) {
            return;
        }
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        int[] iArr2 = new int[1];
        GLES20.glGenFramebuffers(1, iArr2, 0);
        GLES20.glBindFramebuffer(36160, iArr2[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.s, 0);
        GLES20.glViewport(0, 0, this.t, this.u);
        if (fullFrameRect != null) {
            try {
                fullFrameRect.drawFrame(i, fArr);
            } catch (Exception e2) {
                e(1112, "setTextureId错误fuTex:" + i + "---" + e2.toString());
            }
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, iArr2, 0);
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        synchronized (this.i) {
            if (this.j) {
                this.h.sendMessage(this.h.obtainMessage(3, this.s, 0, null));
            }
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.m = bVar;
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.t = dVar.b;
            this.u = dVar.c;
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i = iArr[0];
            this.s = i;
            GLES20.glBindTexture(3553, i);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.t, this.u, 0, GeneratedTexture.FORMAT, 5121, null);
            GLES20.glBindTexture(3553, 0);
            this.l = 5;
            this.o = dVar.f;
            this.p = System.nanoTime();
            this.q = 0L;
            this.r = 0L;
            synchronized (this.i) {
                if (this.k) {
                    wrb.l(TextureMovieEncoder.TAG, "Encoder thread already running");
                    if (this.l != 6) {
                        this.l = 6;
                        e(1113, "录制编码调起错误" + dVar.toString());
                    }
                    return;
                }
                this.k = true;
                new h(this, "TextureMovieVideoEncoder").start();
                new c(this, null).start();
                while (!this.j) {
                    try {
                        this.i.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                this.y = -1L;
                this.h.sendMessage(this.h.obtainMessage(0, dVar));
            }
        }
    }

    public void k(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            this.G = fVar;
        }
    }

    public void r(orb orbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, orbVar) == null) {
            this.B = orbVar;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.F = z;
        }
    }

    public final void t(float[] fArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, fArr, j) == null) {
            fob fobVar = this.E;
            if (fobVar != null) {
                fobVar.b();
            }
            if (this.s != 0) {
                try {
                    this.e.c(false);
                } catch (Exception e2) {
                    wrb.g(e2);
                    if (this.l != 6) {
                        this.l = 6;
                        String message = e2.getMessage();
                        e(FeatureCodes.SPLIT_FILTER, "录制编码错误transform:" + fArr + "timestampNanos:" + j + " , Exception : " + message);
                    }
                }
                d dVar = this.H;
                GLES20.glViewport(0, 0, dVar.b, dVar.c);
                synchronized (hrb.class) {
                    if (this.x != 0.0f) {
                        this.c.setAngle(this.x);
                    }
                    this.c.drawFrame(this.d, fArr);
                }
                if (this.a != null) {
                    long z = z();
                    if (this.y == -1) {
                        this.y = z;
                        this.z = 0L;
                    }
                    this.a.setPresentationTime(z * 1000);
                    this.a.swapBuffers();
                    long j2 = z - this.y;
                    this.z = j2;
                    e eVar = this.n;
                    if (eVar != null) {
                        eVar.a(j2 / 1000);
                    }
                }
            }
        }
    }

    public boolean u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) ? this.l == i : invokeI.booleanValue;
    }

    public final boolean v(int i, int i2, String str) {
        InterceptResult invokeIIL;
        String str2;
        File file;
        MediaMuxer mediaMuxer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048600, this, i, i2, str)) == null) {
            MediaMuxer mediaMuxer2 = null;
            try {
                if (gsb.m(MimeTypes.VIDEO_H265) != null) {
                    str2 = str + File.separator + System.currentTimeMillis() + "_checkHevc.mp4";
                    try {
                        try {
                            mediaMuxer = new MediaMuxer(str2, 0);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        mediaMuxer.addTrack(MediaFormat.createVideoFormat(MimeTypes.VIDEO_H265, i, i2));
                        mediaMuxer2 = mediaMuxer;
                    } catch (Exception e3) {
                        e = e3;
                        mediaMuxer2 = mediaMuxer;
                        e.printStackTrace();
                        this.F = false;
                        if (mediaMuxer2 != null) {
                            try {
                                mediaMuxer2.release();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            file = new File(str2);
                            vb0.d(file);
                        }
                        return this.F;
                    } catch (Throwable th2) {
                        th = th2;
                        mediaMuxer2 = mediaMuxer;
                        if (mediaMuxer2 != null) {
                            try {
                                mediaMuxer2.release();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            vb0.d(new File(str2));
                        }
                        throw th;
                    }
                } else {
                    str2 = null;
                }
                if (mediaMuxer2 != null) {
                    try {
                        mediaMuxer2.release();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            } catch (Exception e7) {
                e = e7;
                str2 = null;
            } catch (Throwable th3) {
                th = th3;
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                file = new File(str2);
                vb0.d(file);
            }
            return this.F;
        }
        return invokeIIL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0093 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.IllegalStateException] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final boolean w(EGLContext eGLContext, int i, int i2, int i3, File file, sqb sqbVar) {
        InterceptResult invokeCommon;
        String message;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{eGLContext, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), file, sqbVar})) == null) {
            try {
                if (this.D) {
                    RecordConstants.MOVIE_ENCODE_SAMPLE_RATE = 16000;
                    jrb.c = 16000;
                    RecordConstants.AUDIO_ENCODE_SAMPLE_RATE = 16000;
                } else {
                    RecordConstants.MOVIE_ENCODE_SAMPLE_RATE = 44100;
                    RecordConstants.AUDIO_ENCODE_SAMPLE_RATE = 44100;
                    jrb.c = 44100;
                }
                this.M = file.toString();
                this.g = new krb(file.toString());
                if (this.F && Build.VERSION.SDK_INT <= 23) {
                    this.F = v(i, i2, new File(file.toString()).getParent());
                }
                lrb lrbVar = new lrb(i, i2, i3, this.F, this.g);
                this.e = lrbVar;
                lrbVar.b(this.H.g);
                this.f = new irb(this.g);
                this.N = true;
                EglCore eglCore = new EglCore(eGLContext, 2);
                this.b = eglCore;
                WindowSurface windowSurface = new WindowSurface(eglCore, this.e.a(), true);
                this.a = windowSurface;
                windowSurface.makeCurrent();
                this.c = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                return true;
            } catch (IOException e2) {
                if (sqbVar != null && !TextUtils.isEmpty(e2.getMessage())) {
                    sqbVar.e = e2.getMessage();
                }
                wrb.g(e2);
                return false;
            } catch (IllegalStateException e3) {
                e = e3;
                if (sqbVar != null && !TextUtils.isEmpty(e.getMessage())) {
                    message = e.getMessage();
                    e = e;
                    sqbVar.e = message;
                }
                wrb.g(e);
                this.N = false;
                return false;
            } catch (RuntimeException e4) {
                e = e4;
                if (sqbVar != null && !TextUtils.isEmpty(e.getMessage())) {
                    message = e.getMessage();
                    e = e;
                    sqbVar.e = message;
                }
                wrb.g(e);
                this.N = false;
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.w == 1.0f) {
                return M();
            }
            long nanoTime = System.nanoTime();
            if (this.o != 0) {
                if (this.q == 0) {
                    this.q = nanoTime;
                }
                nanoTime = (((float) (nanoTime - this.q)) / this.w) + this.o;
            }
            long j = nanoTime / 1000;
            long j2 = this.P;
            if (j < j2) {
                j = 100 + j2;
            }
            this.P = j;
            return j;
        }
        return invokeV.longValue;
    }
}
