package com.baidu.tieba.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.feed.widget.roundcorners.RoundFrameLayout;
import com.baidu.tieba.feed.widget.roundcorners.RoundLinearLayout;
import com.baidu.tieba.hd7;
import com.baidu.tieba.uc7;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0017\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/feed/widget/VirtualImageView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cornerView", "Lcom/baidu/tieba/feed/widget/FeedImageViewProxy;", "imageBgView", "imageView", "doImageAnim", "", "resetAnim", "setImageBgColorInt", "color", "", "setImageBgUrl", "url", "", "setImageUrl", "showCornerView", "cornerUrl", "startAnim", "Companion", "lib-components_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VirtualImageView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hd7 a;
    public hd7 b;
    public hd7 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1070158878, "Lcom/baidu/tieba/feed/widget/VirtualImageView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1070158878, "Lcom/baidu/tieba/feed/widget/VirtualImageView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VirtualImageView(Context context) {
        this(context, null, 2, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VirtualImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds94);
        float f = dimens;
        int i3 = (int) (1.2f * f);
        RoundFrameLayout roundFrameLayout = new RoundFrameLayout(context);
        roundFrameLayout.setId(R.id.obfuscated_res_0x7f090614);
        hd7 hd7Var = new hd7(context);
        this.a = hd7Var;
        roundFrameLayout.addView(hd7Var.h(), new FrameLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimens, dimens);
        roundFrameLayout.setRadius(f);
        layoutParams.addRule(13);
        addView(roundFrameLayout, layoutParams);
        this.a.c(R.color.transparent);
        RoundLinearLayout roundLinearLayout = new RoundLinearLayout(context);
        roundLinearLayout.setOrientation(0);
        roundLinearLayout.setGravity(80);
        roundLinearLayout.setId(R.id.obfuscated_res_0x7f090610);
        this.b = new hd7(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams2.leftMargin = (-(i3 - dimens)) / 2;
        roundLinearLayout.addView(this.b.h(), layoutParams2);
        roundLinearLayout.setRadius(0.0f, 0.0f, f, f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dimens, -1);
        layoutParams3.addRule(8, R.id.obfuscated_res_0x7f090614);
        layoutParams3.addRule(10);
        layoutParams3.addRule(14);
        addView(roundLinearLayout, layoutParams3);
        this.c = new hd7(context);
        int dimens2 = BdUtilHelper.getDimens(context, R.dimen.tbds42);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(dimens2, dimens2);
        layoutParams4.addRule(8, R.id.obfuscated_res_0x7f090610);
        layoutParams4.addRule(7, R.id.obfuscated_res_0x7f090610);
        addView(this.c.h(), layoutParams4);
        this.c.c(R.color.transparent);
    }

    public /* synthetic */ VirtualImageView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.h().setPivotY(this.b.h().getHeight());
            this.b.h().setPivotX(this.b.h().getWidth() / 2.0f);
            ViewPropertyAnimator animate = this.b.h().animate();
            animate.scaleX(1.2f);
            animate.scaleY(1.2f);
            animate.setDuration(400L);
            animate.start();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.h().animate().cancel();
            View h = this.b.h();
            h.setPivotY(this.b.h().getHeight());
            h.setPivotX(this.b.h().getWidth() / 2.0f);
            h.setScaleY(1.0f);
            h.setScaleX(1.0f);
        }
    }

    public final void c(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.c.h().setVisibility(8);
                return;
            }
            this.c.h().setVisibility(0);
            uc7.b(this.c.h(), str);
        }
    }

    public final void setImageBgUrl(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.a.h().setVisibility(4);
                return;
            }
            this.a.h().setVisibility(0);
            this.a.b(str);
        }
    }

    public final void setImageUrl(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.b.h().setVisibility(4);
                return;
            }
            this.b.h().setVisibility(0);
            this.b.b(str);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b.h().getScaleX() < 1.2f) {
            a();
        }
    }

    public final void setImageBgColorInt(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.h().setVisibility(0);
            this.a.h().setBackgroundColor(i);
        }
    }
}
