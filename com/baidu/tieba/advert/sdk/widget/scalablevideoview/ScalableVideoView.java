package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.t.a.k.a.a;
import d.a.s0.t.a.k.a.b;
import java.io.IOException;
/* loaded from: classes5.dex */
public class ScalableVideoView extends TextureView implements TextureView.SurfaceTextureListener, MediaPlayer.OnVideoSizeChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ScalableType f13876e;

    /* renamed from: f  reason: collision with root package name */
    public MediaPlayer f13877f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScalableVideoView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f13877f == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.f13877f = mediaPlayer;
                mediaPlayer.setOnVideoSizeChangedListener(this);
                setSurfaceTextureListener(this);
                return;
            }
            e();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13877f.isPlaying() : invokeV.booleanValue;
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onPreparedListener) == null) {
            this.f13877f.setOnPreparedListener(onPreparedListener);
            this.f13877f.prepareAsync();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e();
            MediaPlayer mediaPlayer = this.f13877f;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            this.f13877f = null;
        }
    }

    public void e() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (mediaPlayer = this.f13877f) == null) {
            return;
        }
        mediaPlayer.reset();
    }

    public final void f(int i2, int i3) {
        Matrix m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) || i2 == 0 || i3 == 0 || (m = new a(new b(getWidth(), getHeight()), new b(i2, i3)).m(this.f13876e)) == null) {
            return;
        }
        setTransform(m);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f13877f.start();
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f13877f.getCurrentPosition() : invokeV.intValue;
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f13877f.getDuration() : invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            MediaPlayer mediaPlayer = this.f13877f;
            if (mediaPlayer == null) {
                return 0;
            }
            return mediaPlayer.getVideoHeight();
        }
        return invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            MediaPlayer mediaPlayer = this.f13877f;
            if (mediaPlayer == null) {
                return 0;
            }
            return mediaPlayer.getVideoWidth();
        }
        return invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f13877f.stop();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            if (this.f13877f == null) {
                return;
            }
            if (b()) {
                h();
            }
            d();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048589, this, surfaceTexture, i2, i3) == null) {
            Surface surface = new Surface(surfaceTexture);
            MediaPlayer mediaPlayer = this.f13877f;
            if (mediaPlayer != null) {
                mediaPlayer.setSurface(surface);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, surfaceTexture)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, surfaceTexture, i2, i3) == null) {
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, surfaceTexture) == null) {
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, mediaPlayer, i2, i3) == null) {
            f(i2, i3);
        }
    }

    public void setDataSource(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            a();
            this.f13877f.setDataSource(str);
        }
    }

    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f13877f.setLooping(z);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onCompletionListener) == null) {
            this.f13877f.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onErrorListener) == null) {
            this.f13877f.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onInfoListener) == null) {
            this.f13877f.setOnInfoListener(onInfoListener);
        }
    }

    public void setScalableType(ScalableType scalableType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, scalableType) == null) {
            this.f13876e = scalableType;
            f(getVideoWidth(), getVideoHeight());
        }
    }

    public void setVolume(float f2, float f3) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (mediaPlayer = this.f13877f) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScalableVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f13876e = ScalableType.NONE;
        if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.scaleStyle, 0, 0)) == null) {
            return;
        }
        int i5 = obtainStyledAttributes.getInt(R$styleable.scaleStyle_scalableType, ScalableType.NONE.ordinal());
        obtainStyledAttributes.recycle();
        this.f13876e = ScalableType.values()[i5];
    }

    public void setDataSource(Context context, Uri uri) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, uri) == null) {
            a();
            this.f13877f.setDataSource(context, uri);
        }
    }
}
