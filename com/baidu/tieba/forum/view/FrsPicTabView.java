package com.baidu.tieba.forum.view;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.aqa;
import com.baidu.tieba.c1b;
import com.baidu.tieba.forum.data.ForumTabPic;
import com.baidu.tieba.forum.view.FrsPicTabView;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.im7;
import com.baidu.tieba.ow5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThemeColorInfo;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00192\b\b\u0001\u0010!\u001a\u00020\bJ\u0010\u0010\"\u001a\u00020\u00192\b\b\u0001\u0010#\u001a\u00020\bJ\u0010\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0016J\u0010\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\bJ\u0016\u0010*\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/baidu/tieba/forum/view/FrsPicTabView;", "Landroid/widget/RelativeLayout;", "Lcom/baidu/tieba/forum/view/IFrsTabView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curIndicatorColorInt", "darkPic", "Lcom/baidu/tieba/forum/data/ForumTabPic;", "indicatorColorInt", "indicatorColorRex", "lottieView", "Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;", "mTabHeight", "normalPic", "selectImageView", "Lcom/baidu/tbadk/widget/image/TbImage;", "themeColorInfo", "Ltbclient/ThemeColorInfo;", "unSelectImageView", "changeIndicatorColor", "", "getPicWidth", "width", "height", "onChangeSkinType", "onSelect", "onUnSelect", "setIndicatorColor", "colorInt", "setIndicatorColorRes", "colorRes", "setIntelligentColorInfo", AiBotChatDispatcher.AI_SINGLE_THEME_COLOR, "setSelectColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setTabHeight", "updateData", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsPicTabView extends RelativeLayout implements im7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbImage a;
    public final TbImage b;
    public final TBLottieAnimationView c;
    public int d;
    public int e;
    public int f;
    public int g;
    public ForumTabPic h;
    public ForumTabPic i;
    public ThemeColorInfo j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrsPicTabView(Context context) {
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
    public FrsPicTabView(Context context, AttributeSet attributeSet) {
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
    public FrsPicTabView(Context context, AttributeSet attributeSet, int i) {
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
        new LinkedHashMap();
        this.d = UtilHelper.getDimenPixelSize(R.dimen.tbds47);
        this.c = new TBLottieAnimationView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(context, R.dimen.tbds104), BdUtilHelper.getDimens(context, R.dimen.tbds36));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X003);
        addView(this.c, layoutParams);
        SkinManager.setLottieAnimation(this.c, R.raw.obfuscated_res_0x7f110040);
        this.a = new TbImage(context, null, 0, 6, null);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X013) / 2;
        layoutParams2.rightMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X013) / 2;
        layoutParams2.addRule(13);
        this.a.setLayoutParams(layoutParams2);
        this.a.setVisibility(4);
        this.a.setPlaceHolderDrawable(ow5.a.a());
        addView(this.a);
        this.b = new TbImage(context, null, 0, 6, null);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X013) / 2;
        layoutParams3.rightMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X013) / 2;
        layoutParams3.addRule(13);
        this.b.setPlaceHolderDrawable(ow5.a.a());
        this.b.setLayoutParams(layoutParams3);
        addView(this.b);
        f();
    }

    public /* synthetic */ FrsPicTabView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void d(FrsPicTabView this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SimpleColorFilter simpleColorFilter = new SimpleColorFilter(this$0.f);
            this$0.c.addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (LottieValueCallback<KeyPath>) new LottieValueCallback(simpleColorFilter));
        }
    }

    @Override // com.baidu.tieba.im7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.c.getVisibility() != 0) {
                c();
                this.b.setVisibility(4);
                this.a.setVisibility(0);
                this.c.setVisibility(0);
                this.c.playAnimation();
            }
            f();
        }
    }

    @Override // com.baidu.tieba.im7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.c.getVisibility() != 8) {
                this.a.setVisibility(4);
                this.b.setVisibility(0);
                this.c.setVisibility(8);
                this.c.cancelAnimation();
                this.c.setFrame(0);
            }
            f();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f != this.g) {
            this.c.post(new Runnable() { // from class: com.baidu.tieba.gm7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FrsPicTabView.d(FrsPicTabView.this);
                    }
                }
            });
            this.g = this.f;
        }
    }

    public final int e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            return (int) (((this.d * 1.0f) * i) / i2);
        }
        return invokeII.intValue;
    }

    public final void g(ForumTabPic normalPic, ForumTabPic darkPic) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, normalPic, darkPic) == null) {
            Intrinsics.checkNotNullParameter(normalPic, "normalPic");
            Intrinsics.checkNotNullParameter(darkPic, "darkPic");
            this.h = normalPic;
            this.i = darkPic;
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ThemeColorInfo themeColorInfo = this.j;
            if (themeColorInfo != null) {
                int f = aqa.f(c1b.e(themeColorInfo));
                if (aqa.e(f)) {
                    f = SkinManager.getColor(R.color.plugin_button_shadow_red);
                }
                setSelectColorFilter(new PorterDuffColorFilter(f, PorterDuff.Mode.SRC_IN));
            }
            int i = this.e;
            if (i != 0) {
                setIndicatorColor(SkinManager.getColor(i));
            }
            this.a.getLayoutParams().height = this.d;
            this.b.getLayoutParams().height = this.d;
            ForumTabPic forumTabPic = this.h;
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                forumTabPic = this.i;
            }
            if (forumTabPic != null) {
                this.a.getLayoutParams().width = e(forumTabPic.getPicWidth(), forumTabPic.getPicHeight());
                this.b.getLayoutParams().width = e(forumTabPic.getPicWidth(), forumTabPic.getPicHeight());
                if (!Intrinsics.areEqual(forumTabPic.getUnSelectedPicUrl(), this.b.getTag())) {
                    this.b.l(forumTabPic.getUnSelectedPicUrl());
                    this.b.setTag(forumTabPic.getUnSelectedPicUrl());
                }
                if (!Intrinsics.areEqual(forumTabPic.getSelectedPicUrl(), this.a.getTag())) {
                    this.a.l(forumTabPic.getSelectedPicUrl());
                    this.a.setTag(forumTabPic.getSelectedPicUrl());
                }
            }
        }
    }

    public final void setIndicatorColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f = i;
        }
    }

    public final void setIndicatorColorRes(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.e = i;
            setIndicatorColor(SkinManager.getColor(i));
        }
    }

    public final void setIntelligentColorInfo(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, themeColorInfo) == null) {
            this.j = themeColorInfo;
        }
    }

    public final void setSelectColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, colorFilter) == null) {
            this.a.setCustomColorFilter(colorFilter);
            this.b.setCustomColorFilter(colorFilter);
        }
    }

    public final void setTabHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.d = i;
        }
    }
}
