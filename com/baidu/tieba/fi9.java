package com.baidu.tieba;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer;
import com.faceunity.gles.GeneratedTexture;
/* loaded from: classes4.dex */
public class fi9 extends MediaBaseRenderer implements ui9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int c;
    public float d;

    public fi9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new int[1];
    }

    @Override // com.baidu.tieba.ui9
    public void a(oi9 oi9Var, SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, oi9Var, surfaceTexture) == null) {
            int i = this.mSurfaceViewHeight;
            int i2 = this.mSurfaceViewWidth;
            float f = this.mRatio;
            int i3 = i - ((int) (i2 * f));
            if (f != 0.0f && f != (i * 1.0f) / i2 && i3 > 0) {
                b();
                GLES20.glBindFramebuffer(36160, this.c);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.a, 0);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, (i3 * (-1.0680001f)) / this.mSurfaceViewHeight);
                this.mFullScreen2D.drawFrame(this.mTextureId, this.mMtx);
                this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
                GLES20.glBindFramebuffer(36160, 0);
                oi9Var.h(this.mFullScreen2D, this.a, GlUtil.IDENTITY_MATRIX);
            } else if (this.mTextureMode == 1) {
                oi9Var.h(this.mFullScreen2D, this.mTextureId, this.mMtx);
            } else {
                oi9Var.h(this.mFullScreenEXT, this.mTextureId, this.mMtx);
            }
            oi9Var.f(surfaceTexture);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.d != this.mRatio) {
                c();
            }
            if (this.a == 0) {
                this.a = this.mFullScreen2D.createTexture2DObject();
                int i = this.mSurfaceViewWidth;
                GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, i, (int) (i * this.mRatio), 0, GeneratedTexture.FORMAT, 5121, null);
                GLES20.glBindTexture(3553, 0);
                GLES20.glGenFramebuffers(1, this.b, 0);
                this.c = this.b[0];
                this.d = this.mRatio;
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == 0) {
            return;
        }
        GLES20.glDeleteFramebuffers(1, this.b, 0);
        GLES20.glDeleteTextures(1, new int[]{this.a}, 0);
        this.a = 0;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onDestroyInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroyInGlThread();
            c();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onPauseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPauseInGlThread();
            c();
        }
    }
}
