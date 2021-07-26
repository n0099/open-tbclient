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
/* loaded from: classes3.dex */
public class ScaleVideoView extends VideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f13316e;

    /* renamed from: f  reason: collision with root package name */
    public int f13317f;

    /* renamed from: g  reason: collision with root package name */
    public int f13318g;

    /* renamed from: h  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f13319h;

    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScaleVideoView f13320e;

        public a(ScaleVideoView scaleVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scaleVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13320e = scaleVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3) == null) {
                this.f13320e.f13317f = mediaPlayer.getVideoWidth();
                this.f13320e.f13318g = mediaPlayer.getVideoHeight();
                if (this.f13320e.f13317f == 0 || this.f13320e.f13318g == 0) {
                    return;
                }
                this.f13320e.getHolder().setFixedSize(this.f13320e.f13317f, this.f13320e.f13318g);
                this.f13320e.requestLayout();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13319h = new a(this);
        e();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13317f = 0;
            this.f13318g = 0;
        }
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            int defaultSize = VideoView.getDefaultSize(this.f13317f, i2);
            int defaultSize2 = VideoView.getDefaultSize(this.f13318g, i3);
            if (this.f13317f > 0 && this.f13318g > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                int size2 = View.MeasureSpec.getSize(i3);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    int i4 = this.f13317f;
                    int i5 = i4 * size2;
                    int i6 = this.f13318g;
                    if (i5 < size * i6) {
                        defaultSize2 = (i6 * size) / i4;
                        defaultSize = size;
                    } else {
                        defaultSize = i4 * size2 > size * i6 ? (i4 * size2) / i6 : size;
                        defaultSize2 = size2;
                    }
                } else {
                    if (mode == 1073741824) {
                        defaultSize2 = (this.f13318g * size) / this.f13317f;
                    } else if (mode2 == 1073741824) {
                        defaultSize = (this.f13317f * size2) / this.f13318g;
                        defaultSize2 = size2;
                    } else {
                        int i7 = this.f13317f;
                        int i8 = this.f13318g;
                        if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                            defaultSize2 = i8;
                        } else {
                            i7 = (i7 * size2) / i8;
                            defaultSize2 = size2;
                        }
                        if (mode != Integer.MIN_VALUE || i7 <= size) {
                            defaultSize = i7;
                        } else {
                            defaultSize2 = (this.f13318g * size) / this.f13317f;
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
        this.f13316e = mediaPlayer;
        this.f13317f = mediaPlayer.getVideoWidth();
        this.f13318g = mediaPlayer.getVideoHeight();
        this.f13316e.setOnVideoSizeChangedListener(this.f13319h);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13319h = new a(this);
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
        this.f13319h = new a(this);
        e();
    }
}
