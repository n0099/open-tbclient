package com.baidu.tieba;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.player.IPlayer;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.source.IDataSourceView;
import com.faceunity.gles.GeneratedTexture;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class bb9 extends ab9 implements IDataSourceView.IPlayerDataSourceView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public SurfaceTexture m;
    public float[] n;
    public FullFrameRect o;
    public int p;
    public int q;
    public a r;
    public boolean s;
    public int t;
    public int[] u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public interface a {
        void a(GL10 gl10, int i, int i2);

        void b(SurfaceTexture surfaceTexture);
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i3 = this.f;
            int i4 = this.g;
            int i5 = (this.z ? this.h : this.j) + i3;
            if (this.z) {
                i = this.g;
                i2 = this.i;
            } else {
                i = this.g;
                i2 = this.k;
            }
            return (x <= ((float) i3) || x >= ((float) i5) || y <= ((float) i4) || y >= ((float) (i + i2))) ? !this.z : this.z;
        }
        return invokeL.booleanValue;
    }

    public boolean e(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? !d(motionEvent) : invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.t == 0) {
            this.t = this.mFullScreen2D.createTexture2DObject();
            GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.p, this.q, 0, GeneratedTexture.FORMAT, 5121, null);
            GLES20.glBindTexture(3553, 0);
            GLES20.glGenFramebuffers(1, this.u, 0);
            this.v = this.u[0];
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SurfaceTexture surfaceTexture = this.m;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.m = null;
            }
            int i = this.l;
            if (i != 0) {
                GLES20.glDeleteTextures(1, new int[]{i}, 0);
                this.l = 0;
            }
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.t == 0) {
            return;
        }
        GLES20.glDeleteFramebuffers(1, this.u, 0);
        GLES20.glDeleteTextures(1, new int[]{this.t}, 0);
        this.t = 0;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onCompletion(IPlayer iPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iPlayer) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ab9, com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onDestroyInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroyInGlThread();
            g();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onError(IPlayer iPlayer, int i, int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{iPlayer, Integer.valueOf(i), Integer.valueOf(i2), exc}) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onGLLocation(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gLViewPortLocation) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onInfo(IPlayer iPlayer, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, iPlayer, i, i2) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ab9, com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onPauseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPauseInGlThread();
            g();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onPlayStateListener(IPlayer iPlayer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, iPlayer, i) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onPrepared(IPlayer iPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iPlayer) == null) {
            iPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, gl10, i, i2) == null) {
            super.onSurfaceChanged(gl10, i, i2);
            a aVar = this.r;
            if (aVar != null) {
                aVar.a(gl10, i, i2);
            }
            if (i != this.p || i2 != this.q) {
                h();
            }
            this.p = i;
            this.q = i2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, fullFrameRect, fullFrameRect2) == null) {
            super.onSurfaceCreate(fullFrameRect, fullFrameRect2);
            this.o = fullFrameRect;
            if (fullFrameRect != null) {
                this.l = fullFrameRect.createTextureObject();
            }
            if (this.y) {
                try {
                    new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_FOLLOW));
                } catch (Exception e) {
                    yb9.d(e.getMessage());
                }
            }
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.l);
            this.m = surfaceTexture;
            a aVar = this.r;
            if (aVar != null) {
                aVar.b(surfaceTexture);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onVideoSizeChanged(int i, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) || i == 0 || i2 == 0) {
            return;
        }
        int i5 = this.e;
        if (i5 == 90 || i5 == 270) {
            i2 = i;
            i = i2;
        }
        if (this.j == 0 && this.k == 0) {
            this.j = this.h;
            this.k = this.i;
        }
        if (this.A == 0) {
            if (this.h == 0 || (i4 = this.i) == 0) {
                return;
            }
            if (i > i2) {
                this.j = i4;
            }
            i3 = (int) (((this.j * i2) * 1.0f) / i);
        } else if (this.h == 0 || this.i == 0) {
            return;
        } else {
            this.o.setAngle(270.0f);
            if (i2 > i) {
                this.j = this.i;
            }
            i3 = (int) (((this.j * i) * 1.0f) / i2);
        }
        this.k = i3;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.s = z;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setScaleAndTranslate(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setTextureMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
        }
    }
}
