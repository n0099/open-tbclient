package com.baidu.tbadk.module.voiceFloat;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.a.s0.s.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.module.voiceFloat.TiebaAudioFloatView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tbadk/module/voiceFloat/TiebaAudioFloatView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioAvatar", "closeBtn", "Landroid/widget/ImageView;", "floatLottie", "Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;", "listener", "Lcom/baidu/tbadk/module/voiceFloat/TiebaAudioFloatView$OnItemClickListener;", "userAvatar", "dp2px", "dpVal", "", "initListener", "", "initView", "onClick", "v", "Landroid/view/View;", "setListener", "OnItemClickListener", "tbadkcore_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class TiebaAudioFloatView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f42540e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f42541f;

    /* renamed from: g  reason: collision with root package name */
    public TBLottieAnimationView f42542g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f42543h;

    /* renamed from: i  reason: collision with root package name */
    public a f42544i;

    /* loaded from: classes11.dex */
    public interface a {
        void closeFloatView();

        void switchToFrontRoom();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiebaAudioFloatView(Context context) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.liveaudio_tieba_audio_float_view, (ViewGroup) this, true);
        c();
        b();
    }

    public static final void d(TiebaAudioFloatView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ImageView imageView = this$0.f42543h;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public final int a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (int) TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics()) : invokeF.intValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RelativeLayout relativeLayout = this.f42541f;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(this);
            }
            ImageView imageView = this.f42543h;
            if (imageView == null) {
                return;
            }
            imageView.setOnClickListener(this);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-2, a(50.0f)));
            this.f42540e = (ImageView) findViewById(R.id.user_avatar);
            this.f42541f = (RelativeLayout) findViewById(R.id.audio_avatar);
            this.f42542g = (TBLottieAnimationView) findViewById(R.id.float_lottie);
            ImageView imageView = (ImageView) findViewById(R.id.close_btn);
            this.f42543h = imageView;
            if (imageView != null) {
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_voiceroom_close20, SkinManager.getColor(0, R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            ImageView imageView2 = this.f42540e;
            if (imageView2 != null) {
                imageView2.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_voiceroom_floatingball, false));
            }
            SkinManager.setLottieAnimation(this.f42542g, R.raw.lottie_video_window_min);
            TBLottieAnimationView tBLottieAnimationView = this.f42542g;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.setRepeatCount(Integer.MAX_VALUE);
            }
            TBLottieAnimationView tBLottieAnimationView2 = this.f42542g;
            if (tBLottieAnimationView2 != null) {
                tBLottieAnimationView2.setRepeatMode(1);
            }
            TBLottieAnimationView tBLottieAnimationView3 = this.f42542g;
            if (tBLottieAnimationView3 != null) {
                tBLottieAnimationView3.playAnimation();
            }
            c d2 = c.d(this);
            d2.n(R.string.J_X01);
            d2.g(SkinManager.getColor(0, R.color.CAM_X0201));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (Intrinsics.areEqual(view, this.f42543h)) {
                a aVar = this.f42544i;
                if (aVar == null) {
                    return;
                }
                aVar.closeFloatView();
            } else if (Intrinsics.areEqual(view, this.f42541f)) {
                ImageView imageView = this.f42543h;
                if (imageView != null && imageView.getVisibility() == 8) {
                    ImageView imageView2 = this.f42543h;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                    ImageView imageView3 = this.f42543h;
                    if (imageView3 == null) {
                        return;
                    }
                    imageView3.postDelayed(new Runnable() { // from class: c.a.s0.j0.g.a
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                TiebaAudioFloatView.d(TiebaAudioFloatView.this);
                            }
                        }
                    }, 2000L);
                    return;
                }
                ImageView imageView4 = this.f42543h;
                if (imageView4 != null) {
                    imageView4.setVisibility(8);
                }
                a aVar2 = this.f42544i;
                if (aVar2 == null) {
                    return;
                }
                aVar2.switchToFrontRoom();
            }
        }
    }

    public final void setListener(a listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f42544i = listener;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiebaAudioFloatView(Context context, AttributeSet attributeSet) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        LayoutInflater.from(getContext()).inflate(R.layout.liveaudio_tieba_audio_float_view, (ViewGroup) this, true);
        c();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiebaAudioFloatView(Context context, AttributeSet attributeSet, int i2) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        LayoutInflater.from(getContext()).inflate(R.layout.liveaudio_tieba_audio_float_view, (ViewGroup) this, true);
        c();
        b();
    }
}
