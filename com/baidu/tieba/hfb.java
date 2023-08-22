package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tieba.jfb;
import com.baidu.tieba.rfb;
import com.baidu.tieba.tfb;
import com.baidu.tieba.yeb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.IMediaLifeCycle;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.processor.AEffectProcessor;
import com.baidu.ugc.editvideo.record.processor.IEffectProcessor;
import com.baidu.ugc.editvideo.record.renderer.IMediaRenderer;
import com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer;
import com.baidu.ugc.editvideo.record.renderer.ResolutionRenderer;
import com.baidu.ugc.editvideo.record.transition.VideoFollowData;
import com.faceunity.gles.GeneratedTexture;
import com.google.android.exoplayer2.extractor.ogg.OpusReader;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hfb implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, IMediaLifeCycle, MediaGLRenderer.OnDrawFrameFrequencyListener, MediaGLRenderer.OnMediaGLRendererStatusListener, yeb.f {
    public static /* synthetic */ Interceptable $ic;
    public static final tfb x0;
    public transient /* synthetic */ FieldHolder $fh;
    public afb A;
    public ffb B;
    public rfb C;
    public DuMixCallback D;
    public int E;
    public SurfaceTexture F;
    public float[] G;
    public yeb.c H;
    public float I;
    public gfb J;
    public VideoFollowData K;
    public float L;
    public dfb M;
    public int N;
    public String O;
    public boolean P;
    public boolean Q;
    public o R;
    public boolean S;

    /* renamed from: T  reason: collision with root package name */
    public ifb f1114T;
    public int U;
    public hcb V;
    public hcb W;
    public float[] X;
    public float Y;
    public float Z;
    public Context a;
    public float a0;
    public yeb.e b;
    public float b0;
    public yeb.d c;
    public int c0;
    public SurfaceTexture.OnFrameAvailableListener d;
    public int d0;
    public GLSurfaceView e;
    public volatile ofb e0;
    public int f;
    public int f0;
    public int g;
    public int g0;
    public int h;
    public ufb h0;
    public int i;
    public boolean i0;
    public int j;
    public zeb j0;
    public boolean k;
    public String l;
    public String m;
    public yeb.b n;
    public boolean o;
    public Handler p;
    public boolean q;
    public int r;
    public boolean r0;
    public int s;
    public float s0;
    public boolean t;
    public boolean t0;
    public boolean u;
    public boolean u0;
    public MediaGLRenderer v;
    public final icb v0;
    public List<IEffectProcessor> w;
    public qfb w0;
    public List<IMediaRenderer> x;
    public SurfaceTexture y;
    public int z;

    /* loaded from: classes6.dex */
    public class a implements rfb.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        /* renamed from: com.baidu.tieba.hfb$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0323a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public RunnableC0323a(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.b == null) {
                    return;
                }
                this.b.a.b.d(this.a);
            }
        }

        public a(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        @Override // com.baidu.tieba.rfb.l
        public void a(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) {
            }
        }

        @Override // com.baidu.tieba.rfb.l
        public void b(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iCaptureResult) == null) || this.a.b == null) {
                return;
            }
            this.a.b.b(iCaptureResult);
        }

        @Override // com.baidu.tieba.rfb.l
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.c();
        }

        @Override // com.baidu.tieba.rfb.l
        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.a.p.post(new RunnableC0323a(this, i));
            }
        }

        @Override // com.baidu.tieba.rfb.l
        public void e(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) || this.a.n == null) {
                return;
            }
            if ((this.a.n.f() || this.a.h0()) && this.a.n.a()) {
                this.a.n.t(i, i2, i3, i4);
            }
        }

        @Override // com.baidu.tieba.rfb.l
        public void f(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || i == this.a.n.o()) {
                return;
            }
            this.a.X();
        }

        @Override // com.baidu.tieba.rfb.l
        public void onBeautyEnableChanged(mf0 mf0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, mf0Var) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onBeautyEnableChanged(mf0Var);
        }

        @Override // com.baidu.tieba.rfb.l
        public void onChangeGender(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.a.u = z;
                if (this.a.c != null) {
                    this.a.c.onChangeGender(z);
                }
            }
        }

        @Override // com.baidu.tieba.rfb.l
        public void onInputSurfaceTextureAttach(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, surfaceTexture) == null) {
            }
        }

        @Override // com.baidu.tieba.rfb.l
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, hashMap) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onLuaMessage(hashMap);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        public b(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) ? (this.a.U(motionEvent) || this.a.C == null || !this.a.C.s(this.a.e, motionEvent)) ? false : true : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ hfb b;

        public c(hfb hfbVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hfbVar;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.v.setWaitingDrawFrame(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ hfb b;

        public d(hfb hfbVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hfbVar;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.b == null) {
                return;
            }
            this.b.b.g(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        public e(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.f(this.a.i, this.a.j);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements jfb.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.b == null) {
                    return;
                }
                this.a.a.b.onStartSuccess();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.b == null) {
                    return;
                }
                this.a.a.b.onStopSuccess();
            }
        }

        public f(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        @Override // com.baidu.tieba.jfb.b
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.a.t(i, str);
            }
        }

        @Override // com.baidu.tieba.jfb.b
        public void onProgress(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onProgress(j);
        }

        @Override // com.baidu.tieba.jfb.b
        public void onStartSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.J != null) {
                    this.a.J.e(7);
                }
                this.a.p.post(new a(this));
            }
        }

        @Override // com.baidu.tieba.jfb.b
        public void onStopSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.p.post(new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        public g(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) {
                this.a.e.requestRender();
                if (this.a.d != null) {
                    this.a.d.onFrameAvailable(surfaceTexture);
                }
                if (this.a.v0 != null) {
                    this.a.v0.n();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements jfb.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ h b;

            public a(h hVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = hVar;
                this.a = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.b == null) {
                    return;
                }
                this.b.a.b.onProgress(this.a);
            }
        }

        public h(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        @Override // com.baidu.tieba.jfb.e
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.p.post(new a(this, j));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements qfb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        public i(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        @Override // com.baidu.tieba.qfb
        public void a(double d) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)}) == null) || this.a.C == null) {
                return;
            }
            this.a.C.r(fgb.e(d));
        }

        @Override // com.baidu.tieba.qfb
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hfb c;

        public j(hfb hfbVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hfbVar;
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.b == null) {
                return;
            }
            this.c.b.onError(this.a, this.b);
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hfb c;

        public k(hfb hfbVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hfbVar;
            this.a = i;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.b == null) {
                return;
            }
            this.c.b.onError(this.a, this.b);
        }
    }

    /* loaded from: classes6.dex */
    public class l implements qfb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        public l(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        @Override // com.baidu.tieba.qfb
        public void a(double d) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)}) == null) || this.a.C == null) {
                return;
            }
            this.a.C.r(fgb.e(d));
        }

        @Override // com.baidu.tieba.qfb
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements ARRenderFpsCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        public m(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public int listenType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void onRenderFinished() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.v0 == null) {
                return;
            }
            this.a.v0.o();
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void onRenderStarted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.v0 == null) {
                return;
            }
            this.a.v0.p();
        }

        @Override // com.baidu.ar.arrender.ARRenderFpsCallback
        public void renderFps(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements DuMixCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        public n(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) || this.a.D == null) {
                return;
            }
            this.a.D.onCaseCreate(z, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseDestroy() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.D == null) {
                return;
            }
            this.a.D.onCaseDestroy();
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, duMixErrorType, str, str2) == null) || this.a.D == null) {
                return;
            }
            this.a.D.onError(duMixErrorType, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.D == null) {
                return;
            }
            this.a.D.onRelease();
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) || this.a.D == null) {
                return;
            }
            this.a.D.onSetup(z, duMixInput, duMixOutput);
        }
    }

    /* loaded from: classes6.dex */
    public class o implements tfb.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hfb a;

        public o(hfb hfbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hfbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hfbVar;
        }

        public void a() {
            tfb tfbVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = 1;
                if (hfb.x0.a() != 1) {
                    tfbVar = hfb.x0;
                } else {
                    tfbVar = hfb.x0;
                    i = 4;
                }
                tfbVar.b(i);
            }
        }

        @Override // com.baidu.tieba.tfb.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (i != 1) {
                    if (i == 2) {
                        this.a.k();
                        return;
                    } else if (i == 3) {
                        this.a.l();
                        hfb.x0.c(null);
                        return;
                    } else if (i != 4) {
                        return;
                    }
                }
                this.a.j();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                hfb.x0.b(2);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                hfb.x0.b(3);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947823205, "Lcom/baidu/tieba/hfb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947823205, "Lcom/baidu/tieba/hfb;");
                return;
            }
        }
        x0 = new tfb();
    }

    public hfb(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.g = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.h = 720;
        this.p = new Handler(Looper.getMainLooper());
        this.t = false;
        this.x = new CopyOnWriteArrayList();
        this.G = new float[16];
        this.I = 1.0f;
        this.L = 0.0f;
        this.M = new dfb();
        this.P = false;
        this.Q = false;
        this.S = false;
        this.U = -100;
        this.V = null;
        this.W = null;
        this.Y = 0.0f;
        this.Z = 0.0f;
        this.a0 = 0.0f;
        this.b0 = 0.0f;
        this.r0 = false;
        this.t0 = true;
        this.w0 = new l(this);
        this.a = context;
        this.v0 = new icb();
        f();
        this.f1114T = new ifb(this.a);
    }

    public static Bitmap N(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i2, i3)) == null) {
            int i4 = i2 * i3 * 4;
            try {
                int[] iArr = new int[i4];
                IntBuffer allocate = IntBuffer.allocate(i4);
                GLES20.glReadPixels(0, 0, i2, i3, GeneratedTexture.FORMAT, 5121, allocate);
                int[] array = allocate.array();
                for (int i5 = 0; i5 < i3; i5++) {
                    for (int i6 = 0; i6 < i2; i6++) {
                        iArr[(((i3 - i5) - 1) * i2) + i6] = array[(i5 * i2) + i6];
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(IntBuffer.wrap(iArr));
                return createBitmap;
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return (Bitmap) invokeII.objValue;
    }

    public void A(yeb.b bVar, int i2, int i3, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str}) == null) {
            this.q = false;
            if (!Q(str)) {
                t(1101, "设置输出路径错误outputDir:" + str);
                return;
            }
            this.r = i3;
            this.s = i2;
            this.n = bVar;
            bVar.g(this.f, this.g, i2, z);
            if (!(this.A instanceof bfb)) {
                this.A = new afb();
            }
            g();
            this.x.add(new ResolutionRenderer());
            F(this.x);
            ArrayList arrayList = new ArrayList();
            try {
                rfb rfbVar = new rfb(this.e.getContext().getApplicationContext(), new g(this));
                this.C = rfbVar;
                rfbVar.j(new m(this));
                this.C.i(new n(this));
                this.C.f(this.n.o() ? 1 : 0);
                this.C.p(new a(this));
                arrayList.add(this.C);
                arrayList.add(new AEffectProcessor());
            } catch (Exception unused) {
            }
            L(arrayList);
            this.t = true;
            yeb.e eVar = this.b;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public void B(yeb.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.H = cVar;
        }
    }

    public void C(yeb.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.c = dVar;
        }
    }

    public void D(yeb.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.b = eVar;
        }
    }

    public void F(List<IMediaRenderer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.x = list;
            this.v.setMediaRenderer(list);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.u0 = z;
        }
    }

    public boolean H(Sticker sticker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sticker, str)) == null) {
            rfb rfbVar = this.C;
            if (rfbVar != null) {
                rfbVar.o(sticker);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void K(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.c0 = i2;
            this.d0 = i3;
        }
    }

    public void L(List<IEffectProcessor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.w = list;
            this.v.setEffectProcessor(list);
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            yeb.b bVar = this.n;
            if (bVar != null) {
                return bVar.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.e.queueEvent(new c(this, z));
        }
    }

    public boolean Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            this.m = str;
            File file = new File(this.m);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        }
        return invokeL.booleanValue;
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.S = z;
        }
    }

    public boolean U(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            afb afbVar = this.A;
            return (afbVar instanceof efb) && ((efb) afbVar).j(motionEvent) && !b();
        }
        return invokeL.booleanValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && r0()) {
            this.o = true;
            this.n.i(true ^ M());
            v(this.y, this.z);
            if (this.w != null) {
                boolean M = M();
                for (IEffectProcessor iEffectProcessor : this.w) {
                    if (iEffectProcessor instanceof rfb) {
                        ((rfb) iEffectProcessor).f(M ? 1 : 0);
                    }
                }
            }
            P(false);
        }
    }

    public void Y(boolean z) {
        rfb rfbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (rfbVar = this.C) == null) {
            return;
        }
        rfbVar.J(z);
    }

    @Override // com.baidu.tieba.yeb.f
    public void a(byte[] bArr, int i2) {
        ffb ffbVar;
        ffb ffbVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, bArr, i2) == null) || i2 == 2 || bArr == null) {
            return;
        }
        hcb hcbVar = this.V;
        if (hcbVar != null) {
            hcbVar.b();
        }
        if (this.P && (ffbVar2 = this.B) != null && ffbVar2.r() && this.M.e()) {
            this.M.c(bArr);
        }
        if (this.S && (ffbVar = this.B) != null && ffbVar.r()) {
            this.f1114T.h(bArr);
        }
        yeb.b bVar = this.n;
        if (bVar != null) {
            bVar.d(bArr);
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            icb icbVar = this.v0;
            if (icbVar != null) {
                icbVar.r();
            }
            if (this.B == null) {
                ffb ffbVar = new ffb();
                this.B = ffbVar;
                if (this.t0) {
                    ffbVar.l(this.r * 2);
                    this.B.o(60);
                    this.B.q(0);
                } else {
                    ffbVar.l(this.r);
                }
                this.B.k(this.u0);
                this.B.b(this.L);
                this.B.f(new f(this));
                this.B.g(new h(this));
                this.B.i(new i(this));
            }
            this.B.e(this.y);
            this.B.c(this.h);
            VideoFollowData videoFollowData = this.K;
            if (videoFollowData != null && VideoFollowData.isLeftRightFollowType(videoFollowData.getFollowType()) && this.K.getOritation() == 0) {
                this.B.d(this.i, this.j / 2);
            } else {
                int i2 = (int) (this.i * this.s0);
                if (i2 == 0) {
                    i2 = this.j;
                }
                int i3 = i2 % 16;
                if (i3 != 0) {
                    i2 += 16 - i3;
                }
                this.B.d(this.i, i2);
            }
            this.B.t(this.I);
            this.B.h(this.A);
            this.B.s(this.U);
            this.B.m(this.i0);
            this.B.p(this.r0);
            o();
            long currentTimeMillis = System.currentTimeMillis();
            String str = this.m + "part_" + currentTimeMillis + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
            this.l = str;
            this.B.j(str);
            if (this.P) {
                this.N = this.n.b();
                String str2 = this.m + "origin_part_" + currentTimeMillis + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
                this.O = str2;
                if (this.M.f(this.i, this.j, this.N, this.r, OpusReader.SAMPLE_RATE, 1, str2)) {
                    this.M.b(M());
                }
            }
            if (this.S) {
                this.f1114T.e(this.i, this.j, this.N, this.m, M());
                this.f1114T.l();
            }
            gfb gfbVar = this.J;
            if (gfbVar != null) {
                gfbVar.e(6);
            }
            return (this.B == null || this.b == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            afb afbVar = this.A;
            if (afbVar instanceof efb) {
                return ((efb) afbVar).k();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        rfb rfbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (rfbVar = this.C) == null) {
            return;
        }
        rfbVar.b0();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c0() {
        InterceptResult invokeV;
        boolean z;
        gfb gfbVar;
        icb icbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.B.r()) {
                try {
                    this.B.a();
                    if (this.P) {
                        this.M.j();
                    }
                    z = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                gfbVar = this.J;
                if (gfbVar != null) {
                    gfbVar.e(10);
                }
                n();
                icbVar = this.v0;
                if (icbVar != null) {
                    icbVar.s();
                }
                return z;
            }
            z = false;
            gfbVar = this.J;
            if (gfbVar != null) {
            }
            n();
            icbVar = this.v0;
            if (icbVar != null) {
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        rfb rfbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (rfbVar = this.C) == null) {
            return;
        }
        rfbVar.e0();
    }

    public void e0() {
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("loc", "recordMng.loadData");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            gcb.b("aps_RecordMng_load", jSONObject.toString());
            yeb.b bVar = this.n;
            if (bVar != null && !bVar.f() && (surfaceTexture = this.y) != null) {
                v(surfaceTexture, this.z);
            }
            m0(true);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            o oVar = new o(this);
            this.R = oVar;
            x0.c(oVar);
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.i0 = z;
            n();
            if (this.i0) {
                return;
            }
            o();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.x.clear();
            this.x.add(this.A);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cameraW", this.i);
                jSONObject.put("cameraH", this.j);
                jSONObject.put("glSfW", this.e.getMeasuredWidth());
                jSONObject.put("glSfH", this.e.getMeasuredHeight());
                jSONObject.put("sW", rgb.e());
                jSONObject.put("sH", rgb.d());
                jSONObject.put("vW:", this.e.getWidth());
                jSONObject.put("vH:", this.e.getHeight());
                if (this.n.e() != null) {
                    jSONObject.put("preSizes", this.n.e());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            gcb.b("camera_view_size", jSONObject.toString());
        }
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ffb ffbVar = this.B;
            if (ffbVar == null) {
                return false;
            }
            return ffbVar.r();
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            yeb.b bVar = this.n;
            return bVar != null && bVar.f();
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.n == null || (i() && !this.o)) {
                return false;
            }
            this.o = false;
            yeb.e eVar = this.b;
            if (eVar != null) {
                eVar.e();
            }
            boolean k2 = this.n.k(this.C.g0(), this);
            this.p.post(new d(this, k2));
            if (!k2) {
                t(1108, "camera预览失败2.cameraTextureId:1width:" + this.n.v() + "height:" + this.n.r());
                return k2;
            }
            this.C.f(this.n.o() ? 1 : 0);
            this.j = this.n.r();
            int v = this.n.v();
            this.i = v;
            K(v, this.j);
            List<IEffectProcessor> list = this.w;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    if (iEffectProcessor instanceof rfb) {
                        ((rfb) iEffectProcessor).g(this.i, this.j);
                    }
                }
            }
            this.p.post(new e(this));
            return k2;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        yeb.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (bVar = this.n) == null) {
            return;
        }
        bVar.q();
    }

    public void k0() {
        rfb rfbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (rfbVar = this.C) == null) {
            return;
        }
        rfbVar.z();
    }

    public final void l() {
        yeb.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (bVar = this.n) == null) {
            return;
        }
        bVar.release();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.e0 == null) {
            return;
        }
        this.v.setWaitingDrawFrame(true);
        Bitmap N = N(this.f0, this.g0);
        int i2 = this.c0;
        int i3 = this.d0;
        float f2 = this.s0;
        if (f2 != 0.0f && N != null) {
            int i4 = this.g0;
            int i5 = this.f0;
            N = zfb.d(N, 0, (int) ((((i4 - ((int) (i5 * f2))) / 2) * 0.466f) / 0.5f), i5, (int) (i5 * f2), true);
            i3 = (int) (i2 * this.s0);
        }
        this.e0.a(zfb.g(N, i2, i3, true));
        this.e0 = null;
    }

    public final void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("loc", "recordMng.onLoad");
                jSONObject.put("success", "success");
                if (dg0.h != null) {
                    jSONObject.put("assets", dg0.h);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            gcb.b(z ? "aps_RecordMng_onLoad_succ" : "aps_RecordMng_onLoad_fail", jSONObject.toString());
            yeb.c cVar = this.H;
            if (cVar != null) {
                cVar.a(z);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.i0 && !h0()) {
            if (this.j0 == null) {
                zeb zebVar = new zeb();
                this.j0 = zebVar;
                zebVar.d(this.w0);
            }
            if (this.j0.h()) {
                return;
            }
            this.j0.c();
        }
    }

    public final void o() {
        zeb zebVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (zebVar = this.j0) == null) {
            return;
        }
        zebVar.e();
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            gfb gfbVar = this.J;
            if (gfbVar != null) {
                gfbVar.f();
            }
            this.v.onDestroy();
            SurfaceTexture surfaceTexture = this.F;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.F = null;
            }
            int i2 = this.E;
            if (i2 != 0) {
                GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                this.E = 0;
            }
            List<IEffectProcessor> list = this.w;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    iEffectProcessor.onDestroy();
                }
            }
            List<IMediaRenderer> list2 = this.x;
            if (list2 != null) {
                for (IMediaRenderer iMediaRenderer : list2) {
                    iMediaRenderer.onDestroy();
                }
            }
            o oVar = this.R;
            if (oVar != null) {
                oVar.c();
                this.R = null;
            }
            icb icbVar = this.v0;
            if (icbVar != null) {
                icbVar.m();
            }
            this.a = null;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, gl10) == null) {
            this.F.updateTexImage();
            this.F.getTransformMatrix(this.G);
            this.v.setUpdateTexture(this.E, this.G, 0);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnDrawFrameFrequencyListener
    public void onDrawFrameFrequency(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, gLViewPortLocation) == null) {
            hcb hcbVar = this.W;
            if (hcbVar != null) {
                hcbVar.b();
            }
            z(gLViewPortLocation);
            m();
            ffb ffbVar = this.B;
            if (ffbVar != null) {
                ffbVar.n();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaGLRenderer.OnMediaGLRendererStatusListener
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048616, this, i2, str) == null) || this.b == null) {
            return;
        }
        this.p.post(new k(this, i2, str));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, surfaceTexture) == null) && this.k) {
            System.nanoTime();
            this.k = false;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            hcb hcbVar = this.V;
            if (hcbVar != null) {
                hcbVar.a();
                this.V = null;
            }
            hcb hcbVar2 = this.W;
            if (hcbVar2 != null) {
                hcbVar2.a();
                this.W = null;
            }
            if (this.t) {
                h();
                List<IEffectProcessor> list = this.w;
                if (list != null) {
                    for (IEffectProcessor iEffectProcessor : list) {
                        iEffectProcessor.onPause();
                    }
                }
                o oVar = this.R;
                if (oVar != null) {
                    oVar.b();
                }
                o();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.t) {
            System.nanoTime();
            this.k = true;
            SurfaceTexture g0 = this.C.g0();
            this.y = g0;
            v(g0, this.z);
            this.C.B(this.i, this.j);
            this.e.onResume();
            this.v.onResume();
            List<IEffectProcessor> list = this.w;
            if (list != null) {
                for (IEffectProcessor iEffectProcessor : list) {
                    iEffectProcessor.onResume();
                }
            }
            List<IMediaRenderer> list2 = this.x;
            if (list2 != null) {
                for (IMediaRenderer iMediaRenderer : list2) {
                    iMediaRenderer.onResume();
                }
            }
            gfb gfbVar = this.J;
            if (gfbVar != null) {
                gfbVar.c();
            }
            this.e.requestRender();
            n();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048620, this, gl10, i2, i3) == null) {
            this.f0 = i2;
            this.g0 = i3;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048621, this, gl10, eGLConfig) == null) || this.v.getFullScreenEXT() == null) {
            return;
        }
        this.E = this.v.getFullScreenEXT().createTextureObject();
        this.F = new SurfaceTexture(this.E);
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.Q : invokeV.booleanValue;
    }

    public void q(float f2) {
        List<IMediaRenderer> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048623, this, f2) == null) || (list = this.x) == null) {
            return;
        }
        this.s0 = f2;
        for (IMediaRenderer iMediaRenderer : list) {
            iMediaRenderer.setResolutionRatio(f2);
        }
    }

    public String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public void r(int i2) {
        rfb rfbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || (rfbVar = this.C) == null) {
            return;
        }
        rfbVar.A(i2);
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            yeb.b bVar = this.n;
            return bVar != null && bVar.f();
        }
        return invokeV.booleanValue;
    }

    public void s(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048627, this, i2, i3) == null) {
            this.f = i2;
            this.g = i3;
        }
    }

    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048628, this, f2) == null) {
            this.I = f2;
            ffb ffbVar = this.B;
            if (ffbVar != null) {
                ffbVar.t(f2);
            }
            gfb gfbVar = this.J;
            if (gfbVar != null) {
                gfbVar.d(f2);
            }
        }
    }

    public final void t(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048629, this, i2, str) == null) || this.q) {
            return;
        }
        this.q = true;
        if (this.b != null) {
            this.p.post(new j(this, i2, str));
        }
    }

    public void u(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onFrameAvailableListener) == null) {
            this.d = onFrameAvailableListener;
        }
    }

    public synchronized void v(SurfaceTexture surfaceTexture, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048631, this, surfaceTexture, i2) == null) {
            synchronized (this) {
                this.z = i2;
                this.y = this.C.g0();
                if (surfaceTexture != null && this.t && this.R != null) {
                    this.R.a();
                }
            }
        }
    }

    public void w(GLSurfaceView gLSurfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, gLSurfaceView) == null) {
            this.e = gLSurfaceView;
            MediaGLRenderer mediaGLRenderer = new MediaGLRenderer();
            this.v = mediaGLRenderer;
            mediaGLRenderer.setRendererListener(this);
            this.v.setOnDrawFrameFrequencyListener(this);
            this.v.setOnMediaGLRendererStatusListener(this);
            this.v.setTextureReader(this.h0);
            this.v.setGlClearColor(0.102f, 0.102f, 0.102f, 0.0f);
            this.e.setRenderer(this.v);
            this.e.setOnTouchListener(new b(this));
        }
    }

    public void x(DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, duMixCallback) == null) {
            this.D = duMixCallback;
        }
    }

    public void y(Filter filter) {
        rfb rfbVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, filter) == null) || (rfbVar = this.C) == null) {
            return;
        }
        rfbVar.n(filter);
    }

    public final void z(GLViewPortLocation gLViewPortLocation) {
        float[] fArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, gLViewPortLocation) == null) || (fArr = this.X) == null) {
            return;
        }
        float f2 = fArr[0];
        float f3 = 1.0f - fArr[3];
        float f4 = fArr[2];
        float f5 = 1.0f - fArr[1];
        if (f2 < 0.0f || f3 < 0.0f || f4 > 1.0f || f5 > 1.0f || f4 <= f2 || f5 <= f3) {
            return;
        }
        GLES20.glEnable(3089);
        GLES20.glScissor(0, 0, gLViewPortLocation.width, (int) (gLViewPortLocation.height * f3));
        GLES20.glClearColor(this.Y, this.Z, this.a0, this.b0);
        GLES20.glClear(16640);
        int i2 = gLViewPortLocation.height;
        GLES20.glScissor(0, (int) (i2 * f5), gLViewPortLocation.width, i2);
        GLES20.glClearColor(this.Y, this.Z, this.a0, this.b0);
        GLES20.glClear(16640);
        int i3 = gLViewPortLocation.height;
        float f6 = f5 - f3;
        GLES20.glScissor(0, (int) (i3 * f3), (int) (gLViewPortLocation.width * f2), (int) (i3 * f6));
        GLES20.glClearColor(this.Y, this.Z, this.a0, this.b0);
        GLES20.glClear(16640);
        int i4 = gLViewPortLocation.width;
        int i5 = gLViewPortLocation.height;
        GLES20.glScissor((int) (i4 * f4), (int) (i5 * f3), (int) (i4 * (1.0f - f4)), (int) (i5 * f6));
        GLES20.glClearColor(this.Y, this.Z, this.a0, this.b0);
        GLES20.glClear(16640);
        GLES20.glDisable(3089);
    }
}
