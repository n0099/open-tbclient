package com.baidu.tieba;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.SurfaceHolder;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes5.dex */
public final class e2 extends d2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends GLSurfaceView20 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e2 e2Var, Context context, s2 s2Var) {
            super(context, s2Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2Var, context, s2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (s2) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = e2Var;
        }

        @Override // android.view.SurfaceView
        public SurfaceHolder getHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e.x();
            }
            return (SurfaceHolder) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2(g2 g2Var, v1 v1Var, s2 s2Var) {
        super(g2Var, v1Var, s2Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g2Var, v1Var, s2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((u1) objArr2[0], (v1) objArr2[1], (s2) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.d2
    public GLSurfaceView20 h(u1 u1Var, s2 s2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, u1Var, s2Var)) == null) {
            if (f()) {
                GLSurfaceView.EGLConfigChooser k = k();
                a aVar = new a(this, u1Var.getContext(), s2Var);
                if (k != null) {
                    aVar.setEGLConfigChooser(k);
                } else {
                    v1 v1Var = this.r;
                    aVar.setEGLConfigChooser(v1Var.a, v1Var.b, v1Var.c, v1Var.d, v1Var.e, v1Var.f);
                }
                aVar.setRenderer(this);
                return aVar;
            }
            throw new GdxRuntimeException("Libgdx requires OpenGL ES 2.0");
        }
        return (GLSurfaceView20) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.d2
    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && AndroidLiveWallpaperService.DEBUG) {
            super.n();
        }
    }

    public SurfaceHolder x() {
        InterceptResult invokeV;
        SurfaceHolder surfaceHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (((g2) this.d).a.sync) {
                surfaceHolder = ((g2) this.d).a.getSurfaceHolder();
            }
            return surfaceHolder;
        }
        return (SurfaceHolder) invokeV.objValue;
    }

    public void y() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (gLSurfaceView20 = this.a) != null) {
            try {
                gLSurfaceView20.onDetachedFromWindow();
                if (AndroidLiveWallpaperService.DEBUG) {
                    Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onDestroy() stopped GLThread managed by GLSurfaceView");
                }
            } catch (Throwable th) {
                Log.e(AndroidLiveWallpaperService.TAG, "failed to destroy GLSurfaceView's thread! GLSurfaceView.onDetachedFromWindow impl changed since API lvl 16!");
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.d2, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gl10) == null) {
            long nanoTime = System.nanoTime();
            boolean z5 = this.p;
            this.i = nanoTime;
            synchronized (this.u) {
                z = this.n;
                z2 = this.o;
                z3 = this.q;
                z4 = this.p;
                if (this.p) {
                    this.p = false;
                    this.u.notifyAll();
                }
                if (this.o) {
                    this.o = false;
                    this.u.notifyAll();
                }
                if (this.q) {
                    this.q = false;
                    this.u.notifyAll();
                }
            }
            if (z4) {
                this.d.getApplicationListener().resume();
                o1.a.log("AndroidGraphics", "resumed");
            }
            if (z) {
                synchronized (this.d.getRunnables()) {
                    this.d.getExecutedRunnables().clear();
                    this.d.getExecutedRunnables().b(this.d.getRunnables());
                    this.d.getRunnables().clear();
                    for (int i = 0; i < this.d.getExecutedRunnables().b; i++) {
                        this.d.getExecutedRunnables().get(i).run();
                    }
                }
                this.d.mo7getInput().I1();
                this.k++;
                this.d.getApplicationListener().render();
            }
            if (z2) {
                this.d.getApplicationListener().pause();
                o1.a.log("AndroidGraphics", "paused");
            }
            if (z3) {
                this.d.getApplicationListener().dispose();
                o1.a.log("AndroidGraphics", "destroyed");
            }
            if (nanoTime - this.j > 1000000000) {
                this.l = 0;
                this.j = nanoTime;
            }
            this.l++;
        }
    }

    @Override // com.baidu.tieba.d2
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.u) {
                this.n = true;
                this.p = true;
                while (this.p) {
                    try {
                        c();
                        this.u.wait();
                    } catch (InterruptedException unused) {
                        o1.a.log("AndroidGraphics", "waiting for resume synchronization failed!");
                    }
                }
            }
        }
    }
}
