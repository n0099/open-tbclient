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
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.hi;
import com.baidu.tieba.zs6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010&\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010(\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010*J\u0010\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010*J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020/J\u0010\u00102\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u00010*J\u000e\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u000206R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/baidu/tieba/feed/widget/HeadImageView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bgLottieView", "Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;", "bgLottieViewStateListener", "com/baidu/tieba/feed/widget/HeadImageView$bgLottieViewStateListener$1", "Lcom/baidu/tieba/feed/widget/HeadImageView$bgLottieViewStateListener$1;", "cornerViewProxy", "Lcom/baidu/tieba/feed/widget/FeedImageViewProxy;", "imageShapeLayout", "Lcom/baidu/tieba/feed/widget/EllipseOrCircleFrameLayout;", "imageViewProxy", "pendantViewProxy", "initBgLottie", "", "initCornerView", "initImageView", "initPendantView", "initViewSize", "onChangeSkin", "setBgLottieSize", "size", "", "setCornerViewSize", "setImageDefaultResource", "defaultId", "setImagePlaceHolder", "type", "setImageScaleType", "scaleType", "Landroid/widget/ImageView$ScaleType;", "setImageViewSize", "setPendantViewSize", "setViewSize", "showCornerView", "cornerUrl", "", "showImageView", "imageUrl", "showLivingLottie", "show", "", "showOvalImage", "showOval", "showPendantView", "pendantUrl", "updateImageConfig", "config", "Lcom/baidu/tieba/feed/compat/WidgetResolver$NetImageViewConfig;", "lib-components_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HeadImageView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBLottieAnimationView a;
    public EllipseOrCircleFrameLayout b;
    public zs6 c;
    public zs6 d;
    public zs6 e;

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
        e();
        a();
        c();
        d();
        b();
    }

    public /* synthetic */ HeadImageView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            int g = hi.g(getContext(), R.dimen.tbds148);
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

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            zs6 zs6Var = new zs6(context);
            this.d = zs6Var;
            zs6 zs6Var2 = null;
            if (zs6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
                zs6Var = null;
            }
            zs6Var.f().setVisibility(8);
            int g = hi.g(getContext(), R.dimen.tbds124);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            layoutParams.addRule(13);
            zs6 zs6Var3 = this.d;
            if (zs6Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
            } else {
                zs6Var2 = zs6Var3;
            }
            addView(zs6Var2.f(), layoutParams);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            zs6 zs6Var = new zs6(context);
            this.e = zs6Var;
            zs6 zs6Var2 = null;
            if (zs6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                zs6Var = null;
            }
            zs6Var.f().setVisibility(8);
            zs6 zs6Var3 = this.e;
            if (zs6Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                zs6Var3 = null;
            }
            zs6Var3.b(R.color.transparent);
            zs6 zs6Var4 = this.e;
            if (zs6Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                zs6Var4 = null;
            }
            zs6Var4.c(R.color.transparent);
            int g = hi.g(getContext(), R.dimen.tbds42);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g, g);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0905aa);
            layoutParams.addRule(7, R.id.obfuscated_res_0x7f0905aa);
            zs6 zs6Var5 = this.e;
            if (zs6Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
            } else {
                zs6Var2 = zs6Var5;
            }
            addView(zs6Var2.f(), layoutParams);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            View view2 = null;
            EllipseOrCircleFrameLayout ellipseOrCircleFrameLayout = new EllipseOrCircleFrameLayout(context, null, 2, null);
            this.b = ellipseOrCircleFrameLayout;
            if (ellipseOrCircleFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageShapeLayout");
                ellipseOrCircleFrameLayout = null;
            }
            ellipseOrCircleFrameLayout.setId(R.id.obfuscated_res_0x7f0905aa);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            this.c = new zs6(context2);
            EllipseOrCircleFrameLayout ellipseOrCircleFrameLayout2 = this.b;
            if (ellipseOrCircleFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageShapeLayout");
                ellipseOrCircleFrameLayout2 = null;
            }
            zs6 zs6Var = this.c;
            if (zs6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                zs6Var = null;
            }
            ellipseOrCircleFrameLayout2.addView(zs6Var.f(), new FrameLayout.LayoutParams(-1, -1));
            int g = hi.g(getContext(), R.dimen.tbds94);
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

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int g = hi.g(getContext(), R.dimen.tbds148);
            setLayoutParams(new ViewGroup.LayoutParams(g, g));
        }
    }

    public final void setBgLottieSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            zs6 zs6Var = this.e;
            zs6 zs6Var2 = null;
            if (zs6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                zs6Var = null;
            }
            ViewGroup.LayoutParams layoutParams = zs6Var.f().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            zs6 zs6Var3 = this.e;
            if (zs6Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
            } else {
                zs6Var2 = zs6Var3;
            }
            zs6Var2.f().setLayoutParams(layoutParams);
        }
    }

    public final void setImageViewSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            zs6 zs6Var = this.d;
            zs6 zs6Var2 = null;
            if (zs6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
                zs6Var = null;
            }
            ViewGroup.LayoutParams layoutParams = zs6Var.f().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            zs6 zs6Var3 = this.d;
            if (zs6Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
            } else {
                zs6Var2 = zs6Var3;
            }
            zs6Var2.f().setLayoutParams(layoutParams);
        }
    }

    public final void setImageDefaultResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            zs6 zs6Var = this.c;
            if (zs6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                zs6Var = null;
            }
            zs6Var.c(i);
        }
    }

    public final void setImagePlaceHolder(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            zs6 zs6Var = this.c;
            if (zs6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                zs6Var = null;
            }
            zs6Var.d(i);
        }
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, scaleType) == null) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            zs6 zs6Var = this.c;
            if (zs6Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                zs6Var = null;
            }
            zs6Var.e(scaleType);
        }
    }

    public final void setViewSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            setLayoutParams(layoutParams);
        }
    }
}
