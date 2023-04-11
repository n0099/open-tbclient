package com.baidu.tieba.core.widget.recommendcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.q25;
import com.baidu.tieba.tbadkcore.databinding.RecommendCardViewBinding;
import com.baidu.tieba.wk6;
import com.baidu.tieba.xk6;
import com.baidu.tieba.yk6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J0\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0019H\u0002J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020\u0010H\u0002J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0019H\u0002J \u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0019H\u0002J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020\u0010H\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u0010H\u0002J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00100\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\b\u00101\u001a\u00020\u0010H\u0002J\u0018\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u0002042\u0006\u0010\"\u001a\u00020\u0019H\u0002J@\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020$H\u0002J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0019H\u0002J\u0018\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0002J\u0018\u0010>\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010?\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010@\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0016H\u0002J\u0010\u0010A\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010B\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0016H\u0002J\u0010\u0010C\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010D\u001a\u00020\u0010H\u0002J\u000e\u0010E\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010F\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\u000e\u0010G\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0007H\u0002J\u0010\u0010J\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010K\u001a\u00020\u0010H\u0002J\u0010\u0010L\u001a\u00020\u00102\u0006\u0010M\u001a\u00020NH\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006O"}, d2 = {"Lcom/baidu/tieba/core/widget/recommendcard/RecommendCardView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/baidu/tieba/tbadkcore/databinding/RecommendCardViewBinding;", "getBinding", "()Lcom/baidu/tieba/tbadkcore/databinding/RecommendCardViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "displayRecommendationItem", "", "item", "Lcom/baidu/tieba/core/widget/recommendcard/RecommendCardItemBuilder;", "setBackgroundImageStyle", "setBackgroundImageUrl", "imageUrl", "", "setBottomGroup", "bottomLeftIconImage", "Lcom/baidu/tieba/core/widget/recommendcard/TbPatternImage;", "bottomLeftIconText", "bottomRightStartIconImage", "bottomRightIconText", "bottomRightEndIconImage", "setBottomGroupOnClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setBottomLeftGroup", "image", "text", "", "setBottomLeftIconImage", "setBottomLeftIconText", "setBottomLeftIconTextStyle", "setBottomRightEndIconImage", "setBottomRightGroup", "startImage", "endImage", "setBottomRightIconText", "setBottomRightIconTextStyle", "setBottomRightStartIconImage", "setDescriptionOneLineText", "setDescriptionText", "setDescriptionTextStyle", "setImage", "imageView", "Lcom/baidu/tbadk/widget/TbImageView;", "setLeftGroup", "backGroundColorString", "topMargin", "textColorString", "subTextColorString", "subText", "setLeftIconImage", "setLeftIconStyle", "colorString", "setLeftIconSub", "setLeftIconSubText", "setLeftIconSubTextStyle", "setLeftIconText", "setLeftIconTextStyle", "setMainImage", "setMainImageStyle", "setRightButtonOnClickListener", "setRightButtonText", "setRootOnClickListener", "setRootStyle", "colorResId", "setSubtitleText", "setSubtitleTextStyle", "setTitleTags", "titleTagsItem", "Lcom/baidu/tieba/core/widget/titletags/TitleTagsItem;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecommendCardView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendCardView(Context context) {
        this(context, null, 0, 6, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendCardView(final Context context, AttributeSet attributeSet, int i) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<RecommendCardViewBinding>(context, this) { // from class: com.baidu.tieba.core.widget.recommendcard.RecommendCardView$binding$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RecommendCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context, this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecommendCardViewBinding invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    RecommendCardViewBinding c = RecommendCardViewBinding.c(LayoutInflater.from(this.$context), this.this$0, true);
                    Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.from(context), this, true)");
                    return c;
                }
                return (RecommendCardViewBinding) invokeV.objValue;
            }
        });
    }

    public /* synthetic */ RecommendCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final RecommendCardViewBinding getBinding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return (RecommendCardViewBinding) this.a.getValue();
        }
        return (RecommendCardViewBinding) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q25.d(getBinding().i).w(R.color.CAM_X0107);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            q25.d(getBinding().j).w(R.color.CAM_X0110);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q25.d(getBinding().l).w(R.color.CAM_X0109);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            q25.d(getBinding().m).w(R.color.CAM_X0108);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            q25.d(getBinding().s).w(R.color.CAM_X0108);
        }
    }

    private final void setBackgroundImageUrl(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getBinding().b.setVisibility(8);
                return;
            }
            getBinding().b.setVisibility(0);
            b();
            getBinding().b.I(str);
        }
    }

    private final void setBottomLeftIconImage(xk6 xk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, xk6Var) == null) {
            if (xk6Var.d()) {
                getBinding().d.setVisibility(8);
                return;
            }
            getBinding().d.setVisibility(0);
            TbImageView tbImageView = getBinding().d;
            Intrinsics.checkNotNullExpressionValue(tbImageView, "binding.bottomIconLeft");
            j(tbImageView, xk6Var);
        }
    }

    private final void setBottomLeftIconText(CharSequence charSequence) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, charSequence) == null) {
            if (charSequence.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getBinding().i.setVisibility(8);
                return;
            }
            getBinding().i.setVisibility(0);
            e();
            getBinding().i.setText(charSequence);
        }
    }

    private final void setBottomRightEndIconImage(xk6 xk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, xk6Var) == null) {
            if (xk6Var.d()) {
                getBinding().e.setVisibility(8);
                return;
            }
            getBinding().e.setVisibility(0);
            TbImageView tbImageView = getBinding().e;
            Intrinsics.checkNotNullExpressionValue(tbImageView, "binding.bottomIconRightEnd");
            j(tbImageView, xk6Var);
        }
    }

    private final void setBottomRightIconText(CharSequence charSequence) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, charSequence) == null) {
            if (charSequence.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getBinding().j.setVisibility(8);
                return;
            }
            getBinding().j.setVisibility(0);
            g();
            getBinding().j.setText(charSequence);
        }
    }

    private final void setBottomRightStartIconImage(xk6 xk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, xk6Var) == null) {
            if (xk6Var.d()) {
                getBinding().f.setVisibility(8);
                return;
            }
            getBinding().f.setVisibility(0);
            TbImageView tbImageView = getBinding().f;
            Intrinsics.checkNotNullExpressionValue(tbImageView, "binding.bottomIconRightStart");
            j(tbImageView, xk6Var);
        }
    }

    private final void setDescriptionOneLineText(CharSequence charSequence) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, charSequence) == null) {
            if (charSequence.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getBinding().l.setVisibility(8);
                return;
            }
            getBinding().l.setVisibility(0);
            h();
            getBinding().l.setText(charSequence);
        }
    }

    private final void setDescriptionText(CharSequence charSequence) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, charSequence) == null) {
            if (charSequence.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getBinding().m.setVisibility(8);
                return;
            }
            getBinding().m.setVisibility(0);
            i();
            getBinding().m.setText(charSequence);
        }
    }

    private final void setLeftIconImage(xk6 xk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, xk6Var) == null) {
            if (xk6Var.d()) {
                getBinding().n.setVisibility(8);
                return;
            }
            getBinding().n.setVisibility(0);
            TbImageView tbImageView = getBinding().n;
            Intrinsics.checkNotNullExpressionValue(tbImageView, "binding.iconLeft");
            j(tbImageView, xk6Var);
        }
    }

    private final void setLeftIconText(CharSequence charSequence) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, charSequence) == null) {
            if (charSequence.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getBinding().q.setVisibility(8);
                return;
            }
            getBinding().q.setVisibility(0);
            getBinding().q.setText(charSequence);
        }
    }

    private final void setMainImage(xk6 xk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, xk6Var) == null) {
            if (xk6Var.d()) {
                getBinding().r.setVisibility(8);
                return;
            }
            getBinding().r.setVisibility(0);
            n();
            TbImageView tbImageView = getBinding().r;
            Intrinsics.checkNotNullExpressionValue(tbImageView, "binding.mainImage");
            j(tbImageView, xk6Var);
        }
    }

    private final void setSubtitleText(CharSequence charSequence) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, charSequence) == null) {
            if (charSequence.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getBinding().s.setVisibility(8);
                return;
            }
            getBinding().s.setVisibility(0);
            o();
            getBinding().s.setText(charSequence);
        }
    }

    private final void setLeftIconSubText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, charSequence) == null) {
            getBinding().o.setText(charSequence);
        }
    }

    private final void setLeftIconSubTextStyle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, str) == null) {
            q25.d(getBinding().o).x(str);
        }
    }

    private final void setLeftIconTextStyle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, str) == null) {
            q25.d(getBinding().q).x(str);
        }
    }

    private final void setRootStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65556, this, i) == null) {
            q25 d = q25.d(getBinding().k);
            d.o(R.string.J_X05);
            d.f(i);
        }
    }

    private final void setTitleTags(yk6 yk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, yk6Var) == null) {
            getBinding().u.c(yk6Var);
        }
    }

    public final void setBottomGroupOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
            getBinding().c.setOnClickListener(onClickListener);
        }
    }

    public final void setRightButtonOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
            getBinding().t.setOnClickListener(onClickListener);
        }
    }

    public final void setRootOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
            getBinding().k.setOnClickListener(onClickListener);
        }
    }

    private final void setRightButtonText(CharSequence charSequence) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, charSequence) == null) {
            if (charSequence.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getBinding().t.setVisibility(8);
                return;
            }
            getBinding().t.setVisibility(0);
            q25 d = q25.d(getBinding().t);
            d.w(R.color.CAM_X0101);
            d.o(R.string.J_X01);
            d.f(R.color.CAM_X0302);
            getBinding().t.setText(charSequence);
        }
    }

    public final void a(wk6 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            setRootStyle(item.y());
            setBackgroundImageUrl(item.h());
            setMainImage(item.w());
            setTitleTags(item.A());
            setSubtitleText(item.z());
            setDescriptionText(item.o());
            k(item.p(), item.v(), item.q(), item.u(), item.t(), item.s(), item.r());
            setRightButtonText(item.x());
            setDescriptionOneLineText(item.n());
            c(item.i(), item.j(), item.m(), item.l(), item.k());
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getBinding().b.setScaleType(ImageView.ScaleType.FIT_XY);
            getBinding().b.setDrawCorner(true);
            getBinding().b.setRadiusById(R.string.J_X05);
            getBinding().b.setPlaceHolder(2);
            getBinding().b.setConrers(15);
        }
    }

    public final void c(xk6 xk6Var, String str, xk6 xk6Var2, String str2, xk6 xk6Var3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, xk6Var, str, xk6Var2, str2, xk6Var3) == null) {
            if (xk6Var.d()) {
                boolean z2 = true;
                if (str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && xk6Var2.d()) {
                    if (str2.length() != 0) {
                        z2 = false;
                    }
                    if (z2 && xk6Var3.d()) {
                        getBinding().c.setVisibility(8);
                        return;
                    }
                }
            }
            getBinding().c.setVisibility(0);
            d(xk6Var, str);
            f(xk6Var2, str2, xk6Var3);
        }
    }

    public final void d(xk6 xk6Var, CharSequence charSequence) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, xk6Var, charSequence) == null) {
            if (xk6Var.d()) {
                if (charSequence.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    getBinding().g.setVisibility(8);
                    return;
                }
            }
            getBinding().g.setVisibility(0);
            setBottomLeftIconImage(xk6Var);
            setBottomLeftIconText(charSequence);
        }
    }

    public final void l(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, str, i) == null) {
            ViewGroup.LayoutParams layoutParams = getBinding().p.getLayoutParams();
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) layoutParams)).topMargin = i;
                q25 d = q25.d(getBinding().p);
                d.o(R.string.J_X01);
                d.g(str);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public final void m(String str, CharSequence charSequence) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, charSequence) == null) {
            if (charSequence.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                getBinding().o.setVisibility(8);
                return;
            }
            getBinding().o.setVisibility(0);
            setLeftIconSubTextStyle(str);
            setLeftIconSubText(charSequence);
        }
    }

    public final void f(xk6 xk6Var, CharSequence charSequence, xk6 xk6Var2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, xk6Var, charSequence, xk6Var2) == null) {
            if (xk6Var.d()) {
                if (charSequence.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && xk6Var2.d()) {
                    getBinding().h.setVisibility(8);
                    return;
                }
            }
            getBinding().h.setVisibility(0);
            setBottomRightStartIconImage(xk6Var);
            setBottomRightIconText(charSequence);
            setBottomRightEndIconImage(xk6Var2);
        }
    }

    public final void j(TbImageView tbImageView, xk6 xk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, tbImageView, xk6Var) == null) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.width = xk6Var.c();
            layoutParams.height = xk6Var.a();
            tbImageView.I(xk6Var.b());
        }
    }

    public final void k(String str, int i, xk6 xk6Var, String str2, CharSequence charSequence, String str3, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i), xk6Var, str2, charSequence, str3, charSequence2}) == null) {
            if (xk6Var.d()) {
                getBinding().p.setVisibility(8);
                return;
            }
            getBinding().p.setVisibility(0);
            l(str, i);
            setLeftIconImage(xk6Var);
            setLeftIconTextStyle(str2);
            setLeftIconText(charSequence);
            m(str3, charSequence2);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            getBinding().r.setDrawBorder(true);
            getBinding().r.setBorderWidth(getResources().getDimensionPixelSize(R.dimen.tbds1));
            getBinding().r.setBorderColor(SkinManager.getColor(R.color.black_alpha8));
            getBinding().r.setDrawBorder(true);
            getBinding().r.setAutoChangeStyle(true);
            getBinding().r.setDrawCorner(true);
            getBinding().r.setRadiusById(R.string.J_X04);
            getBinding().r.setConrers(15);
        }
    }
}
