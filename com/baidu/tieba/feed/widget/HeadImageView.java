package com.baidu.tieba.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.a87;
import com.baidu.tieba.h37;
import com.baidu.tieba.q97;
import com.baidu.tieba.vi;
import com.baidu.tieba.z97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010&\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010(\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010*J\u0010\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010*J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020/J\u0010\u00102\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u00010*J\u000e\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u000206R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/baidu/tieba/feed/widget/HeadImageView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bgLottieView", "Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;", "bgLottieViewStateListener", "com/baidu/tieba/feed/widget/HeadImageView$bgLottieViewStateListener$1", "Lcom/baidu/tieba/feed/widget/HeadImageView$bgLottieViewStateListener$1;", "cornerViewProxy", "Lcom/baidu/tieba/feed/widget/FeedImageViewProxy;", "imageShapeLayout", "Lcom/baidu/tieba/feed/widget/EllipseOrCircleFrameLayout;", "imageViewProxy", "pendantViewProxy", "initBgLottie", "", "initCornerView", "initImageView", "initPendantView", "initViewSize", "onChangeSkin", "setBgLottieSize", "size", "", "setCornerViewSize", "setImageDefaultResource", "defaultId", "setImagePlaceHolder", "type", "setImageScaleType", "scaleType", "Landroid/widget/ImageView$ScaleType;", "setImageViewSize", "setPendantViewSize", "setViewSize", "showCornerView", "cornerUrl", "", "showImageView", "imageUrl", "showLivingLottie", "show", "", "showOvalImage", "showOval", "showPendantView", "pendantUrl", "updateImageConfig", "config", "Lcom/baidu/tieba/feed/compat/WidgetResolver$NetImageViewConfig;", "lib-components_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HeadImageView extends RelativeLayout implements a87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBLottieAnimationView a;
    public EllipseOrCircleFrameLayout b;
    public z97 c;
    public z97 d;
    public z97 e;
    public final a f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HeadImageView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes5.dex */
    public static final class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeadImageView a;

        public a(HeadImageView headImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = headImageView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                TBLottieAnimationView tBLottieAnimationView = this.a.a;
                if (tBLottieAnimationView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                    tBLottieAnimationView = null;
                }
                tBLottieAnimationView.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                TBLottieAnimationView tBLottieAnimationView = this.a.a;
                if (tBLottieAnimationView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                    tBLottieAnimationView = null;
                }
                tBLottieAnimationView.cancelAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HeadImageView(Context context, AttributeSet attributeSet) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.f = new a(this);
        g();
        c();
        e();
        f();
        d();
    }

    public /* synthetic */ HeadImageView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            EllipseOrCircleFrameLayout ellipseOrCircleFrameLayout = this.b;
            if (ellipseOrCircleFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageShapeLayout");
                ellipseOrCircleFrameLayout = null;
            }
            ellipseOrCircleFrameLayout.e(z);
        }
    }

    public final void m(h37.c config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            z97 z97Var = this.c;
            if (z97Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                z97Var = null;
            }
            z97Var.g(config);
        }
    }

    public final void setImageDefaultResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            z97 z97Var = this.c;
            if (z97Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                z97Var = null;
            }
            z97Var.d(i);
        }
    }

    public final void setImagePlaceHolder(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            z97 z97Var = this.c;
            if (z97Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                z97Var = null;
            }
            z97Var.e(i);
        }
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, scaleType) == null) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            z97 z97Var = this.c;
            if (z97Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                z97Var = null;
            }
            z97Var.f(scaleType);
        }
    }

    public final void setViewSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.a87
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.a;
            if (tBLottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                tBLottieAnimationView = null;
            }
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int g = vi.g(getContext(), R.dimen.tbds148);
            setLayoutParams(new ViewGroup.LayoutParams(g, g));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(getContext());
            this.a = tBLottieAnimationView;
            View view2 = null;
            if (tBLottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                tBLottieAnimationView = null;
            }
            tBLottieAnimationView.setVisibility(8);
            TBLottieAnimationView tBLottieAnimationView2 = this.a;
            if (tBLottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                tBLottieAnimationView2 = null;
            }
            tBLottieAnimationView2.setSpeed(0.8f);
            TBLottieAnimationView tBLottieAnimationView3 = this.a;
            if (tBLottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                tBLottieAnimationView3 = null;
            }
            tBLottieAnimationView3.loop(true);
            int g = vi.g(getContext(), R.dimen.tbds148);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            layoutParams.addRule(13);
            View view3 = this.a;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
            } else {
                view2 = view3;
            }
            addView(view2, layoutParams);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            z97 z97Var = new z97(context);
            this.d = z97Var;
            z97 z97Var2 = null;
            if (z97Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
                z97Var = null;
            }
            z97Var.h().setVisibility(8);
            int g = vi.g(getContext(), R.dimen.tbds124);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            layoutParams.addRule(13);
            z97 z97Var3 = this.d;
            if (z97Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
            } else {
                z97Var2 = z97Var3;
            }
            addView(z97Var2.h(), layoutParams);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            z97 z97Var = new z97(context);
            this.e = z97Var;
            z97 z97Var2 = null;
            if (z97Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                z97Var = null;
            }
            z97Var.h().setVisibility(8);
            z97 z97Var3 = this.e;
            if (z97Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                z97Var3 = null;
            }
            z97Var3.c(R.color.transparent);
            z97 z97Var4 = this.e;
            if (z97Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                z97Var4 = null;
            }
            z97Var4.d(R.color.transparent);
            int g = vi.g(getContext(), R.dimen.tbds42);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0905d0);
            layoutParams.addRule(7, R.id.obfuscated_res_0x7f0905d0);
            z97 z97Var5 = this.e;
            if (z97Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
            } else {
                z97Var2 = z97Var5;
            }
            addView(z97Var2.h(), layoutParams);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            View view2 = null;
            EllipseOrCircleFrameLayout ellipseOrCircleFrameLayout = new EllipseOrCircleFrameLayout(context, null, 2, null);
            this.b = ellipseOrCircleFrameLayout;
            if (ellipseOrCircleFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageShapeLayout");
                ellipseOrCircleFrameLayout = null;
            }
            ellipseOrCircleFrameLayout.setId(R.id.obfuscated_res_0x7f0905d0);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            this.c = new z97(context2);
            EllipseOrCircleFrameLayout ellipseOrCircleFrameLayout2 = this.b;
            if (ellipseOrCircleFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageShapeLayout");
                ellipseOrCircleFrameLayout2 = null;
            }
            z97 z97Var = this.c;
            if (z97Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                z97Var = null;
            }
            ellipseOrCircleFrameLayout2.addView(z97Var.h(), new FrameLayout.LayoutParams(-1, -1));
            int g = vi.g(getContext(), R.dimen.tbds94);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            layoutParams.addRule(13);
            View view3 = this.b;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageShapeLayout");
            } else {
                view2 = view3;
            }
            addView(view2, layoutParams);
        }
    }

    public final void h(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            z97 z97Var = null;
            if (z) {
                z97 z97Var2 = this.e;
                if (z97Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                } else {
                    z97Var = z97Var2;
                }
                z97Var.h().setVisibility(8);
                return;
            }
            z97 z97Var3 = this.e;
            if (z97Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                z97Var3 = null;
            }
            z97Var3.h().setVisibility(0);
            z97 z97Var4 = this.e;
            if (z97Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
            } else {
                z97Var = z97Var4;
            }
            q97.a(z97Var.h(), str);
        }
    }

    public final void i(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            z97 z97Var = null;
            if (z) {
                z97 z97Var2 = this.c;
                if (z97Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                } else {
                    z97Var = z97Var2;
                }
                z97Var.h().setVisibility(4);
                return;
            }
            z97 z97Var3 = this.c;
            if (z97Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                z97Var3 = null;
            }
            z97Var3.h().setVisibility(0);
            z97 z97Var4 = this.c;
            if (z97Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
            } else {
                z97Var = z97Var4;
            }
            z97Var.a(str);
        }
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            TBLottieAnimationView tBLottieAnimationView = null;
            if (z) {
                TBLottieAnimationView tBLottieAnimationView2 = this.a;
                if (tBLottieAnimationView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                    tBLottieAnimationView2 = null;
                }
                tBLottieAnimationView2.setVisibility(0);
                TBLottieAnimationView tBLottieAnimationView3 = this.a;
                if (tBLottieAnimationView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                    tBLottieAnimationView3 = null;
                }
                SkinManager.setLottieAnimation(tBLottieAnimationView3, R.raw.card_live_header_bg);
                TBLottieAnimationView tBLottieAnimationView4 = this.a;
                if (tBLottieAnimationView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                } else {
                    tBLottieAnimationView = tBLottieAnimationView4;
                }
                tBLottieAnimationView.addOnAttachStateChangeListener(this.f);
                return;
            }
            TBLottieAnimationView tBLottieAnimationView5 = this.a;
            if (tBLottieAnimationView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                tBLottieAnimationView5 = null;
            }
            tBLottieAnimationView5.cancelAnimation();
            TBLottieAnimationView tBLottieAnimationView6 = this.a;
            if (tBLottieAnimationView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                tBLottieAnimationView6 = null;
            }
            tBLottieAnimationView6.removeOnAttachStateChangeListener(this.f);
            TBLottieAnimationView tBLottieAnimationView7 = this.a;
            if (tBLottieAnimationView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
            } else {
                tBLottieAnimationView = tBLottieAnimationView7;
            }
            tBLottieAnimationView.setVisibility(8);
        }
    }

    public final void l(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            z97 z97Var = null;
            if (z) {
                z97 z97Var2 = this.d;
                if (z97Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
                } else {
                    z97Var = z97Var2;
                }
                z97Var.h().setVisibility(8);
                return;
            }
            z97 z97Var3 = this.d;
            if (z97Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
                z97Var3 = null;
            }
            z97Var3.h().setVisibility(0);
            z97 z97Var4 = this.d;
            if (z97Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
            } else {
                z97Var = z97Var4;
            }
            z97Var.b(str);
        }
    }

    public final void setBgLottieSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.a;
            TBLottieAnimationView tBLottieAnimationView2 = null;
            if (tBLottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                tBLottieAnimationView = null;
            }
            ViewGroup.LayoutParams layoutParams = tBLottieAnimationView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            TBLottieAnimationView tBLottieAnimationView3 = this.a;
            if (tBLottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
            } else {
                tBLottieAnimationView2 = tBLottieAnimationView3;
            }
            tBLottieAnimationView2.setLayoutParams(layoutParams);
        }
    }

    public final void setCornerViewSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            z97 z97Var = this.e;
            z97 z97Var2 = null;
            if (z97Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                z97Var = null;
            }
            ViewGroup.LayoutParams layoutParams = z97Var.h().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            z97 z97Var3 = this.e;
            if (z97Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
            } else {
                z97Var2 = z97Var3;
            }
            z97Var2.h().setLayoutParams(layoutParams);
        }
    }

    public final void setImageViewSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            EllipseOrCircleFrameLayout ellipseOrCircleFrameLayout = this.b;
            EllipseOrCircleFrameLayout ellipseOrCircleFrameLayout2 = null;
            if (ellipseOrCircleFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageShapeLayout");
                ellipseOrCircleFrameLayout = null;
            }
            ViewGroup.LayoutParams layoutParams = ellipseOrCircleFrameLayout.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            EllipseOrCircleFrameLayout ellipseOrCircleFrameLayout3 = this.b;
            if (ellipseOrCircleFrameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageShapeLayout");
            } else {
                ellipseOrCircleFrameLayout2 = ellipseOrCircleFrameLayout3;
            }
            ellipseOrCircleFrameLayout2.setLayoutParams(layoutParams);
        }
    }

    public final void setPendantViewSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            z97 z97Var = this.d;
            z97 z97Var2 = null;
            if (z97Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
                z97Var = null;
            }
            ViewGroup.LayoutParams layoutParams = z97Var.h().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            z97 z97Var3 = this.d;
            if (z97Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
            } else {
                z97Var2 = z97Var3;
            }
            z97Var2.h().setLayoutParams(layoutParams);
        }
    }
}
