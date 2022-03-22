package com.baidu.tbadk.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ScaleVideoView extends VideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer a;

    /* renamed from: b  reason: collision with root package name */
    public int f30724b;

    /* renamed from: c  reason: collision with root package name */
    public int f30725c;

    /* renamed from: d  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f30726d;

    /* loaded from: classes5.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScaleVideoView a;

        public a(ScaleVideoView scaleVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scaleVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scaleVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i, i2) == null) {
                this.a.f30724b = mediaPlayer.getVideoWidth();
                this.a.f30725c = mediaPlayer.getVideoHeight();
                if (this.a.f30724b == 0 || this.a.f30725c == 0) {
                    return;
                }
                this.a.getHolder().setFixedSize(this.a.f30724b, this.a.f30725c);
                this.a.requestLayout();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30726d = new a(this);
        g();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f30724b = 0;
            this.f30725c = 0;
        }
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            int defaultSize = VideoView.getDefaultSize(this.f30724b, i);
            int defaultSize2 = VideoView.getDefaultSize(this.f30725c, i2);
            if (this.f30724b > 0 && this.f30725c > 0) {
                int mode = View.MeasureSpec.getMode(i);
                int size = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                int size2 = View.MeasureSpec.getSize(i2);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    int i3 = this.f30724b;
                    int i4 = i3 * size2;
                    int i5 = this.f30725c;
                    if (i4 < size * i5) {
                        defaultSize2 = (i5 * size) / i3;
                        defaultSize = size;
                    } else {
                        defaultSize = i3 * size2 > size * i5 ? (i3 * size2) / i5 : size;
                        defaultSize2 = size2;
                    }
                } else {
                    if (mode == 1073741824) {
                        defaultSize2 = (this.f30725c * size) / this.f30724b;
                    } else if (mode2 == 1073741824) {
                        defaultSize = (this.f30724b * size2) / this.f30725c;
                        defaultSize2 = size2;
                    } else {
                        int i6 = this.f30724b;
                        int i7 = this.f30725c;
                        if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                            defaultSize2 = i7;
                        } else {
                            i6 = (i6 * size2) / i7;
                            defaultSize2 = size2;
                        }
                        if (mode != Integer.MIN_VALUE || i6 <= size) {
                            defaultSize = i6;
                        } else {
                            defaultSize2 = (this.f30725c * size) / this.f30724b;
                        }
                    }
                    defaultSize = size;
                }
            }
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mediaPlayer) == null) || mediaPlayer == null) {
            return;
        }
        this.a = mediaPlayer;
        this.f30724b = mediaPlayer.getVideoWidth();
        this.f30725c = mediaPlayer.getVideoHeight();
        this.a.setOnVideoSizeChangedListener(this.f30726d);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30726d = new a(this);
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f30726d = new a(this);
        g();
    }
}
