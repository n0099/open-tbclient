package com.baidu.tieba.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.kb7;
import com.baidu.tieba.l37;
import com.baidu.tieba.o97;
import com.baidu.tieba.wb7;
import com.baidu.tieba.xb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001fJ\u000e\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010)\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010*\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010+\u001a\u00020\u00162\b\u0010,\u001a\u0004\u0018\u00010-J\u0010\u0010.\u001a\u00020\u00162\b\u0010/\u001a\u0004\u0018\u00010-J\u0016\u00100\u001a\u00020\u00162\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020-\u0018\u000102J\u000e\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u000205J\u0010\u00108\u001a\u00020\u00162\b\u00109\u001a\u0004\u0018\u00010-J\u000e\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020<R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/baidu/tieba/feed/widget/HeadImageView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bgLottieView", "Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;", "bgLottieViewStateListener", "com/baidu/tieba/feed/widget/HeadImageView$bgLottieViewStateListener$1", "Lcom/baidu/tieba/feed/widget/HeadImageView$bgLottieViewStateListener$1;", "cornerViewProxy", "Lcom/baidu/tieba/feed/widget/FeedImageViewProxy;", "imageShapeLayout", "Lcom/baidu/tieba/feed/widget/EllipseOrCircleFrameLayout;", "imageViewProxy", "layerImageViewProxy", "Lcom/baidu/tieba/feed/widget/LayerImageViewProxy;", "pendantViewProxy", "initBgLottie", "", "initCornerView", "initImageView", "initLayerImageView", "initPendantView", "initViewSize", "onChangeSkin", "setBgLottieSize", "size", "", "setCornerViewSize", "setImageDefaultResource", "defaultId", "setImagePlaceHolder", "type", "setImageScaleType", "scaleType", "Landroid/widget/ImageView$ScaleType;", "setImageViewSize", "setPendantViewSize", "setViewSize", "showCornerView", "cornerUrl", "", "showImageView", "imageUrl", "showLayerImageView", "urls", "", "showLivingLottie", "show", "", "showOvalImage", "showOval", "showPendantView", "pendantUrl", "updateImageConfig", "config", "Lcom/baidu/tieba/feed/compat/WidgetResolver$NetImageViewConfig;", "lib-components_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HeadImageView extends RelativeLayout implements o97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBLottieAnimationView a;
    public EllipseOrCircleFrameLayout b;
    public wb7 c;
    public wb7 d;
    public xb7 e;
    public wb7 f;
    public final a g;

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
        this.g = new a(this);
        h();
        b();
        e();
        g();
        f();
        d();
    }

    public /* synthetic */ HeadImageView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            EllipseOrCircleFrameLayout ellipseOrCircleFrameLayout = this.b;
            if (ellipseOrCircleFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageShapeLayout");
                ellipseOrCircleFrameLayout = null;
            }
            ellipseOrCircleFrameLayout.e(z);
        }
    }

    public final void o(l37.d config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            wb7 wb7Var = this.c;
            if (wb7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                wb7Var = null;
            }
            wb7Var.g(config);
        }
    }

    public final void setImageDefaultResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            wb7 wb7Var = this.c;
            if (wb7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                wb7Var = null;
            }
            wb7Var.d(i);
        }
    }

    public final void setImagePlaceHolder(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            wb7 wb7Var = this.c;
            if (wb7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                wb7Var = null;
            }
            wb7Var.e(i);
        }
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, scaleType) == null) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            wb7 wb7Var = this.c;
            if (wb7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                wb7Var = null;
            }
            wb7Var.f(scaleType);
        }
    }

    public final void setViewSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            setLayoutParams(layoutParams);
        }
    }

    public final void b() {
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
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds148);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
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
            xb7 xb7Var = new xb7(context);
            this.e = xb7Var;
            xb7 xb7Var2 = null;
            if (xb7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layerImageViewProxy");
                xb7Var = null;
            }
            xb7Var.b().setVisibility(8);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds124);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams.addRule(13);
            xb7 xb7Var3 = this.e;
            if (xb7Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layerImageViewProxy");
            } else {
                xb7Var2 = xb7Var3;
            }
            addView(xb7Var2.b(), layoutParams);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            wb7 wb7Var = new wb7(context);
            this.d = wb7Var;
            wb7 wb7Var2 = null;
            if (wb7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
                wb7Var = null;
            }
            wb7Var.h().setVisibility(8);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds124);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams.addRule(13);
            wb7 wb7Var3 = this.d;
            if (wb7Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
            } else {
                wb7Var2 = wb7Var3;
            }
            addView(wb7Var2.h(), layoutParams);
        }
    }

    @Override // com.baidu.tieba.o97
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.a;
            if (tBLottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
                tBLottieAnimationView = null;
            }
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds148);
            setLayoutParams(new ViewGroup.LayoutParams(dimens, dimens));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            wb7 wb7Var = new wb7(context);
            this.f = wb7Var;
            wb7 wb7Var2 = null;
            if (wb7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                wb7Var = null;
            }
            wb7Var.h().setVisibility(8);
            wb7 wb7Var3 = this.f;
            if (wb7Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                wb7Var3 = null;
            }
            wb7Var3.c(R.color.transparent);
            wb7 wb7Var4 = this.f;
            if (wb7Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                wb7Var4 = null;
            }
            wb7Var4.d(R.color.transparent);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds42);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0905de);
            layoutParams.addRule(7, R.id.obfuscated_res_0x7f0905de);
            wb7 wb7Var5 = this.f;
            if (wb7Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
            } else {
                wb7Var2 = wb7Var5;
            }
            addView(wb7Var2.h(), layoutParams);
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
            ellipseOrCircleFrameLayout.setId(R.id.obfuscated_res_0x7f0905de);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            wb7 wb7Var = new wb7(context2);
            this.c = wb7Var;
            if (wb7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                wb7Var = null;
            }
            l37.d dVar = new l37.d();
            dVar.e = 1;
            wb7Var.g(dVar);
            EllipseOrCircleFrameLayout ellipseOrCircleFrameLayout2 = this.b;
            if (ellipseOrCircleFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageShapeLayout");
                ellipseOrCircleFrameLayout2 = null;
            }
            wb7 wb7Var2 = this.c;
            if (wb7Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                wb7Var2 = null;
            }
            ellipseOrCircleFrameLayout2.addView(wb7Var2.h(), new FrameLayout.LayoutParams(-1, -1));
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds94);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
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

    public final void i(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            wb7 wb7Var = null;
            if (z) {
                wb7 wb7Var2 = this.f;
                if (wb7Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                } else {
                    wb7Var = wb7Var2;
                }
                wb7Var.h().setVisibility(8);
                return;
            }
            wb7 wb7Var3 = this.f;
            if (wb7Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                wb7Var3 = null;
            }
            wb7Var3.h().setVisibility(0);
            wb7 wb7Var4 = this.f;
            if (wb7Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
            } else {
                wb7Var = wb7Var4;
            }
            kb7.a(wb7Var.h(), str);
        }
    }

    public final void j(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            wb7 wb7Var = null;
            if (z) {
                wb7 wb7Var2 = this.c;
                if (wb7Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                } else {
                    wb7Var = wb7Var2;
                }
                wb7Var.h().setVisibility(4);
                return;
            }
            wb7 wb7Var3 = this.c;
            if (wb7Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
                wb7Var3 = null;
            }
            wb7Var3.h().setVisibility(0);
            wb7 wb7Var4 = this.c;
            if (wb7Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageViewProxy");
            } else {
                wb7Var = wb7Var4;
            }
            wb7Var.a(str);
        }
    }

    public final void k(List<String> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list != null) {
                z = list.isEmpty();
            } else {
                z = true;
            }
            xb7 xb7Var = null;
            if (z) {
                xb7 xb7Var2 = this.e;
                if (xb7Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layerImageViewProxy");
                } else {
                    xb7Var = xb7Var2;
                }
                xb7Var.b().setVisibility(8);
                return;
            }
            xb7 xb7Var3 = this.e;
            if (xb7Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layerImageViewProxy");
                xb7Var3 = null;
            }
            xb7Var3.b().setVisibility(0);
            xb7 xb7Var4 = this.e;
            if (xb7Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layerImageViewProxy");
            } else {
                xb7Var = xb7Var4;
            }
            xb7Var.a(list);
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
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
                tBLottieAnimationView.addOnAttachStateChangeListener(this.g);
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
            tBLottieAnimationView6.removeOnAttachStateChangeListener(this.g);
            TBLottieAnimationView tBLottieAnimationView7 = this.a;
            if (tBLottieAnimationView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgLottieView");
            } else {
                tBLottieAnimationView = tBLottieAnimationView7;
            }
            tBLottieAnimationView.setVisibility(8);
        }
    }

    public final void n(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            wb7 wb7Var = null;
            if (z) {
                wb7 wb7Var2 = this.d;
                if (wb7Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
                } else {
                    wb7Var = wb7Var2;
                }
                wb7Var.h().setVisibility(8);
                return;
            }
            wb7 wb7Var3 = this.d;
            if (wb7Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
                wb7Var3 = null;
            }
            wb7Var3.h().setVisibility(0);
            wb7 wb7Var4 = this.d;
            if (wb7Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
            } else {
                wb7Var = wb7Var4;
            }
            wb7Var.b(str);
        }
    }

    public final void setBgLottieSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            wb7 wb7Var = this.f;
            wb7 wb7Var2 = null;
            if (wb7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
                wb7Var = null;
            }
            ViewGroup.LayoutParams layoutParams = wb7Var.h().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            wb7 wb7Var3 = this.f;
            if (wb7Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cornerViewProxy");
            } else {
                wb7Var2 = wb7Var3;
            }
            wb7Var2.h().setLayoutParams(layoutParams);
        }
    }

    public final void setImageViewSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            wb7 wb7Var = this.d;
            wb7 wb7Var2 = null;
            if (wb7Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
                wb7Var = null;
            }
            ViewGroup.LayoutParams layoutParams = wb7Var.h().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(i, i);
            }
            layoutParams.width = i;
            layoutParams.height = i;
            wb7 wb7Var3 = this.d;
            if (wb7Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pendantViewProxy");
            } else {
                wb7Var2 = wb7Var3;
            }
            wb7Var2.h().setLayoutParams(layoutParams);
        }
    }
}
