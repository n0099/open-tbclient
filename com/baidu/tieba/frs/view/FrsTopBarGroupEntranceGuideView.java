package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.FrsTopBarGroupEntranceGuideView;
import com.baidu.tieba.p75;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/frs/view/FrsTopBarGroupEntranceGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowIcon", "Landroid/widget/ImageView;", "arrowLp", "Landroid/widget/RelativeLayout$LayoutParams;", "dismissRunnable", "Ljava/lang/Runnable;", "targetViewCenterX", "tipTextLp", "tipTextView", "Landroid/widget/TextView;", "dismiss", "", "initView", "onSkinChanged", "setTargetViewCenterX", "centerX", "showTipAndAutoDismiss", "tip", "", "Companion", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FrsTopBarGroupEntranceGuideView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public RelativeLayout.LayoutParams b;
    public TextView c;
    public RelativeLayout.LayoutParams d;
    public int e;
    public final Runnable f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-869056034, "Lcom/baidu/tieba/frs/view/FrsTopBarGroupEntranceGuideView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-869056034, "Lcom/baidu/tieba/frs/view/FrsTopBarGroupEntranceGuideView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsTopBarGroupEntranceGuideView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsTopBarGroupEntranceGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsTopBarGroupEntranceGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        c();
        this.f = new Runnable() { // from class: com.baidu.tieba.hs7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    FrsTopBarGroupEntranceGuideView.b(FrsTopBarGroupEntranceGuideView.this);
                }
            }
        };
    }

    public /* synthetic */ FrsTopBarGroupEntranceGuideView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void b(FrsTopBarGroupEntranceGuideView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setVisibility(8);
        }
    }

    public final void setTargetViewCenterX(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.e = i;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && getVisibility() == 0) {
            removeCallbacks(this.f);
            post(this.f);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setClipToPadding(false);
            setClipChildren(false);
            ImageView imageView = new ImageView(getContext());
            this.a = imageView;
            RelativeLayout.LayoutParams layoutParams = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
                imageView = null;
            }
            imageView.setId(R.id.arrow_icon);
            this.b = new RelativeLayout.LayoutParams(wi.g(getContext(), R.dimen.tbds42), wi.g(getContext(), R.dimen.tbds13));
            ImageView imageView2 = this.a;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
                imageView2 = null;
            }
            RelativeLayout.LayoutParams layoutParams2 = this.b;
            if (layoutParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowLp");
                layoutParams2 = null;
            }
            addView(imageView2, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            this.d = layoutParams3;
            if (layoutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextLp");
                layoutParams3 = null;
            }
            layoutParams3.addRule(3, R.id.arrow_icon);
            RelativeLayout.LayoutParams layoutParams4 = this.d;
            if (layoutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextLp");
                layoutParams4 = null;
            }
            layoutParams4.addRule(11);
            RelativeLayout.LayoutParams layoutParams5 = this.d;
            if (layoutParams5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextLp");
                layoutParams5 = null;
            }
            layoutParams5.rightMargin = wi.g(getContext(), R.dimen.M_H_X007);
            TextView textView = new TextView(getContext());
            this.c = textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
                textView = null;
            }
            textView.setIncludeFontPadding(false);
            TextView textView2 = this.c;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
                textView2 = null;
            }
            textView2.setPadding(wi.g(getContext(), R.dimen.M_W_X005), wi.g(getContext(), R.dimen.M_H_X004), wi.g(getContext(), R.dimen.M_W_X005), wi.g(getContext(), R.dimen.M_H_X004));
            TextView textView3 = this.c;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
                textView3 = null;
            }
            RelativeLayout.LayoutParams layoutParams6 = this.d;
            if (layoutParams6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextLp");
            } else {
                layoutParams = layoutParams6;
            }
            addView(textView3, layoutParams);
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ImageView imageView = this.a;
            TextView textView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
                imageView = null;
            }
            imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.pic_tip_purple_arrow_up));
            TextView textView2 = this.c;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
                textView2 = null;
            }
            textView2.setBackground(SkinManager.getDrawable(R.drawable.pic_tip_purple_bg));
            TextView textView3 = this.c;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
            } else {
                textView = textView3;
            }
            p75 d = p75.d(textView);
            d.x(R.color.CAM_X0101);
            d.C(R.dimen.T_X09);
            d.D(R.string.F_X01);
        }
    }

    public final void e(String tip) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tip) == null) {
            Intrinsics.checkNotNullParameter(tip, "tip");
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = null;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                RelativeLayout.LayoutParams layoutParams3 = this.b;
                if (layoutParams3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("arrowLp");
                    layoutParams3 = null;
                }
                marginLayoutParams.topMargin = (-layoutParams3.height) * 2;
            }
            TextView textView = this.c;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTextView");
                textView = null;
            }
            textView.setText(tip);
            setVisibility(0);
            RelativeLayout.LayoutParams layoutParams4 = this.b;
            if (layoutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowLp");
                layoutParams4 = null;
            }
            int i = this.e;
            RelativeLayout.LayoutParams layoutParams5 = this.b;
            if (layoutParams5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowLp");
                layoutParams5 = null;
            }
            layoutParams4.leftMargin = i - (layoutParams5.width / 2);
            ImageView imageView = this.a;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowIcon");
                imageView = null;
            }
            RelativeLayout.LayoutParams layoutParams6 = this.b;
            if (layoutParams6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowLp");
            } else {
                layoutParams2 = layoutParams6;
            }
            imageView.setLayoutParams(layoutParams2);
            removeCallbacks(this.f);
            postDelayed(this.f, 5000L);
        }
    }
}
