package com.baidu.tieba.forum.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.forum.databinding.AutoCarouselContainerViewBinding;
import com.baidu.tieba.forum.view.FrsAutoCarouselImageContainer;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002*\u0001\n\u0018\u0000 %2\u00020\u0001:\u0001%B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0$R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/tieba/forum/view/FrsAutoCarouselImageContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "com/baidu/tieba/forum/view/FrsAutoCarouselImageContainer$adapter$1", "Lcom/baidu/tieba/forum/view/FrsAutoCarouselImageContainer$adapter$1;", "binding", "Lcom/baidu/tieba/forum/databinding/AutoCarouselContainerViewBinding;", "gradientEndColor", "gradientStartColor", "imageViewHeight", "imageViewWidth", "maxVisibleImage", "onChangeSkin", "", "setBackgroundGradientColor", "startColor", "endColor", "setHeadImageParams", "headView", "Lcom/baidu/tbadk/core/view/HeadImageView;", "setMaxVisibleImage", "imageCount", "setMaxWidth", "containerMaxWidth", "setTipText", "text", "", "showCarouselImages", "images", "", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsAutoCarouselImageContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final int b;
    public final int c;
    public final AutoCarouselContainerViewBinding d;
    public int e;
    public int f;
    public final a g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1309657459, "Lcom/baidu/tieba/forum/view/FrsAutoCarouselImageContainer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1309657459, "Lcom/baidu/tieba/forum/view/FrsAutoCarouselImageContainer;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsAutoCarouselImageContainer(Context context) {
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
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsAutoCarouselImageContainer(Context context, AttributeSet attributeSet) {
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
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes6.dex */
    public static final class a implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<String> a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ FrsAutoCarouselImageContainer c;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public a(Context context, FrsAutoCarouselImageContainer frsAutoCarouselImageContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, frsAutoCarouselImageContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = context;
            this.c = frsAutoCarouselImageContainer;
            this.a = new ArrayList();
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void a(View view2, int i) {
            HeadImageView headImageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && view2 != null) {
                if (view2 instanceof HeadImageView) {
                    headImageView = (HeadImageView) view2;
                } else {
                    headImageView = null;
                }
                if (headImageView != null) {
                    headImageView.startLoad(this.a.get(i), 25, false);
                }
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.b);
                this.c.setHeadImageParams(headImageView);
                return headImageView;
            }
            return (View) invokeV.objValue;
        }

        public final List<String> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.size();
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsAutoCarouselImageContainer(Context context, AttributeSet attributeSet, int i) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.a = 2;
        this.b = BdUtilHelper.getDimens(context, R.dimen.tbds52);
        this.c = BdUtilHelper.getDimens(context, R.dimen.tbds52);
        this.g = new a(context, this);
        AutoCarouselContainerViewBinding c = AutoCarouselContainerViewBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.from(context), this, true)");
        this.d = c;
        b();
    }

    public /* synthetic */ FrsAutoCarouselImageContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void c(int i, FrsAutoCarouselImageContainer this$0) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65542, null, i, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int width = this$0.d.c.getWidth();
            FrameLayout frameLayout = this$0.d.c;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.guideImage");
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            int i7 = 0;
            if (marginLayoutParams2 != null) {
                i2 = marginLayoutParams2.leftMargin;
            } else {
                i2 = 0;
            }
            int i8 = width + i2;
            FrameLayout frameLayout2 = this$0.d.c;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.guideImage");
            ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
            if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams2 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (marginLayoutParams3 != null) {
                i3 = marginLayoutParams3.rightMargin;
            } else {
                i3 = 0;
            }
            int width2 = i8 + i3 + this$0.d.b.getWidth();
            FrameLayout frameLayout3 = this$0.d.c;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.guideImage");
            ViewGroup.LayoutParams layoutParams3 = frameLayout3.getLayoutParams();
            if (!(layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams3 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams3;
            if (marginLayoutParams4 != null) {
                i4 = marginLayoutParams4.leftMargin;
            } else {
                i4 = 0;
            }
            int i9 = width2 + i4;
            FrameLayout frameLayout4 = this$0.d.c;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.guideImage");
            ViewGroup.LayoutParams layoutParams4 = frameLayout4.getLayoutParams();
            if (!(layoutParams4 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams4 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams4;
            if (marginLayoutParams5 != null) {
                i5 = marginLayoutParams5.rightMargin;
            } else {
                i5 = 0;
            }
            int paddingLeft = i9 + i5 + this$0.getPaddingLeft() + this$0.getPaddingRight();
            ViewGroup.LayoutParams layoutParams5 = this$0.getLayoutParams();
            if (!(layoutParams5 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams5 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams5;
            if (marginLayoutParams6 != null) {
                i6 = marginLayoutParams6.leftMargin;
            } else {
                i6 = 0;
            }
            int i10 = paddingLeft + i6;
            ViewGroup.LayoutParams layoutParams6 = this$0.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = layoutParams6;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams7 = marginLayoutParams;
            if (marginLayoutParams7 != null) {
                i7 = marginLayoutParams7.rightMargin;
            }
            int i11 = i - (i10 + i7);
            if (i11 > 0) {
                this$0.d.d.setMaxWidth(i11);
                return;
            }
            DefaultLog.getInstance().i("FrsAutoCarouselImageContainer", "text maxWidth error,containerMaxWidth : " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHeadImageParams(HeadImageView headImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, headImageView) == null) {
            headImageView.setLayoutParams(new FrameLayout.LayoutParams(this.b, this.c));
            headImageView.setBorderWidth(BdUtilHelper.getDimens(getContext(), R.dimen.L_X02));
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0101));
            headImageView.setIsRound(true);
            headImageView.setDrawBorder(true);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setPlaceHolder(1);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.e != 0 && this.f != 0) {
                EMManager.from(this.d.getRoot()).setCorner(R.string.J_X01).setGradientColor(new int[]{this.e, this.f}, Direction.LEFT_TOP);
            } else {
                EMManager.from(this.d.getRoot()).setCorner(R.string.J_X01).setBackGroundColor(R.color.black_alpha20);
            }
            this.d.f.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
            this.d.e.s();
            EMManager.from(this.d.d).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d.b, R.drawable.obfuscated_res_0x7f080b75, R.color.CAM_X0101, null);
        }
    }

    public final void d(List<String> images) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, images) == null) {
            Intrinsics.checkNotNullParameter(images, "images");
            ViewGroup.LayoutParams layoutParams = this.d.d.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                Context context = getContext();
                if (images.isEmpty()) {
                    i = R.dimen.tbds21;
                } else {
                    i = R.dimen.tbds3;
                }
                marginLayoutParams.setMargins(BdUtilHelper.getDimens(context, i), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                this.d.d.setLayoutParams(marginLayoutParams);
            }
            if (images.isEmpty()) {
                return;
            }
            if (images.size() == 1) {
                this.d.e.setVisibility(8);
                this.d.f.setVisibility(0);
                HeadImageView headImageView = this.d.f;
                Intrinsics.checkNotNullExpressionValue(headImageView, "binding.singleHeadImage");
                setHeadImageParams(headImageView);
                this.d.f.startLoad(images.get(0), 25, false);
            } else {
                this.d.e.setVisibility(0);
                this.d.f.setVisibility(8);
                this.d.e.l(this.a, this.b, this.c, BdUtilHelper.getDimens(getContext(), R.dimen.tbds23));
                this.d.e.setAnimationDuration(500);
                this.d.e.setCarouselDelayPeriod(2000);
                this.d.e.setCarouselPeriod(2000);
                this.d.e.setAdapter(this.g);
                this.g.d().clear();
                this.g.d().addAll(images);
                this.d.e.q();
            }
            b();
        }
    }

    public final void setBackgroundGradientColor(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.e = i;
            this.f = i2;
            EMManager.from(this.d.getRoot()).setCorner(R.string.J_X01).setGradientColor(new int[]{i, i2}, Direction.LEFT_TOP);
        }
    }

    public final void setMaxVisibleImage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a = i;
        }
    }

    public final void setMaxWidth(final int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            post(new Runnable() { // from class: com.baidu.tieba.no7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FrsAutoCarouselImageContainer.c(i, this);
                    }
                }
            });
        }
    }

    public final void setTipText(String text) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, text) == null) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.d.d.setText(text);
        }
    }
}
