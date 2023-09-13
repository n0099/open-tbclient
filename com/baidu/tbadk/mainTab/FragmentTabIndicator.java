package com.baidu.tbadk.mainTab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.ig;
import com.baidu.tieba.m9;
import com.baidu.tieba.zfa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public String h;
    public BdUniqueId i;
    public ImageView j;
    public TextView k;
    public int l;
    public int m;
    public boolean n;
    public HashMap<String, TbFragmentTabIndicator.FragmentTapTip> o;
    public final BdResourceCallback<BdImage> p;

    /* loaded from: classes4.dex */
    public class a extends ig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FragmentTabIndicator a;

        public a(FragmentTabIndicator fragmentTabIndicator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentTabIndicator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fragmentTabIndicator;
        }

        @Override // com.baidu.tieba.ig
        public void a(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.f = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FragmentTabIndicator a;

        public b(FragmentTabIndicator fragmentTabIndicator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentTabIndicator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fragmentTabIndicator;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((b) bdImage, str, i);
                if (this.a.j != null && bdImage != null && bdImage.isValidNow()) {
                    this.a.j.setBackgroundResource(0);
                    this.a.j.setImageDrawable(null);
                    bdImage.drawImageTo(this.a.j);
                    return;
                }
                this.a.f();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentTabIndicator(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.e = 0;
        this.f = true;
        this.n = true;
        this.o = new HashMap<>();
        this.p = new b(this);
        d();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onChangeSkin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (this.n) {
                SkinManager.setViewTextColor(this.k, this.b, 1);
            } else {
                SkinManager.setViewTextColor(this.k, this.b, 1, 0);
            }
            if (this.k != null) {
                this.k.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, this.c), SkinManager.getSkinDrawable(null, this.d), (Drawable) null);
            }
            e();
            for (Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip> entry : this.o.entrySet()) {
                entry.getValue().onChangeSkin(i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentTabIndicator(Context context, AttributeSet attributeSet) {
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
        this.a = 0;
        this.e = 0;
        this.f = true;
        this.n = true;
        this.o = new HashMap<>();
        this.p = new b(this);
        d();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            this.k.setVisibility(0);
            this.j.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(14, -1);
            this.k.setLayoutParams(layoutParams);
            if (i > 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.width = i;
                layoutParams2.height = i;
                layoutParams2.bottomMargin = i2;
                layoutParams2.addRule(2, this.j.getId());
                layoutParams2.addRule(14, -1);
                this.j.setLayoutParams(layoutParams2);
            }
            e();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void addTip(String str, TbFragmentTabIndicator.FragmentTapTip fragmentTapTip) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, fragmentTapTip) == null) && (view2 = fragmentTapTip.f1082view) != null) {
            addView(view2);
            this.o.put(str, fragmentTapTip);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void refreshIconUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.h = str;
            e();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            this.k.setTextSize(i, f);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.FragmentTapTip getTip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return this.o.get(str);
        }
        return (TbFragmentTabIndicator.FragmentTapTip) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.onTabSelected(z);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.e = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.k.setCompoundDrawablePadding(i);
        }
    }

    public void setCompoundDrawablesRightResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.c = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentDefaultTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            super.setContentDefaultTextColor(i);
            this.k.setTextColor(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i) == null) && (this.k.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.topMargin = i;
            this.k.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.g = i;
            f();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.mIsContentSelectBold = z;
        }
    }

    public void setIsSupportNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (!z) {
                SkinManager.setViewTextColor(this.k, this.b, 1, 0);
            }
            this.n = z;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.k.setText(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.b = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048607, this, f) == null) {
            this.k.setTextSize(f);
        }
    }

    public void setTextSpan(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, spannableString) == null) {
            this.k.setText(spannableString);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.a = i;
        }
    }

    public void setTipTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.l = i;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
            layoutParams.addRule(13, -1);
            this.k.setLayoutParams(layoutParams);
        }
    }

    private BdUniqueId getBdUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                return bdUniqueId;
            }
            BdPageContext<?> a2 = m9.a(getContext());
            if (a2 != null) {
                this.i = a2.getUniqueId();
            }
            return this.i;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void f() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (i = this.g) > 0) {
            SkinManager.setImageResource(this.j, i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.k;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setContentWidthWrapContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            layoutParams.width = -2;
            this.k.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void checkAndStartAnimation() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.e > 0 && this.f) {
            try {
                this.f = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.j.getContext(), this.e);
                loadAnimation.setAnimationListener(new a(this));
                this.j.startAnimation(loadAnimation);
            } catch (Exception unused) {
                this.f = true;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.c <= 0 && this.d <= 0) {
            if (!TextUtils.isEmpty(this.h)) {
                BdResourceLoader.getInstance().loadResource(this.h, 10, this.p, getBdUniqueId());
            } else {
                f();
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4);
            this.m = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070367);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_indicator_item, this);
            this.j = (ImageView) inflate.findViewById(R.id.view_bottom_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.view_bottom_text);
            this.k = textView;
            textView.setDuplicateParentStateEnabled(true);
            f();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            Iterator<Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip>> it = this.o.entrySet().iterator();
            while (it.hasNext() && this.k.getText() != null) {
                TbFragmentTabIndicator.FragmentTapTip value = it.next().getValue();
                int measuredWidth2 = value.f1082view.getMeasuredWidth();
                int measuredHeight2 = value.f1082view.getMeasuredHeight();
                int measureText = (int) this.k.getPaint().measureText(this.k.getText().toString());
                if (value.isRight) {
                    measuredWidth = (getMeasuredWidth() / 2) + value.offsetX + (measureText / 2);
                } else {
                    measuredWidth = ((getMeasuredWidth() / 2) - value.offsetX) - (measureText / 2);
                }
                if (this.a == 1) {
                    measuredWidth -= this.m;
                    measuredHeight = this.l;
                } else {
                    measuredHeight = (getMeasuredHeight() / 2) - (value.f1082view.getMeasuredHeight() / 2);
                }
                value.f1082view.layout(measuredWidth, measuredHeight, measuredWidth2 + measuredWidth, measuredHeight2 + measuredHeight);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            for (Map.Entry<String, TbFragmentTabIndicator.FragmentTapTip> entry : this.o.entrySet()) {
                TbFragmentTabIndicator.FragmentTapTip value = entry.getValue();
                ViewGroup.LayoutParams layoutParams = value.f1082view.getLayoutParams();
                int i3 = layoutParams.width;
                if (i3 == -2) {
                    value.f1082view.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                } else {
                    if (i3 > size) {
                        i3 = size;
                    }
                    int i4 = layoutParams.height;
                    if (i4 > size2) {
                        i4 = size2;
                    }
                    value.f1082view.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.FragmentTapTip removeTip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (this.o.containsKey(str)) {
                removeView(this.o.get(str).f1082view);
                return this.o.remove(str);
            }
            return null;
        }
        return (TbFragmentTabIndicator.FragmentTapTip) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            String charSequence = this.k.getText().toString();
            if (z) {
                charSequence = getContext().getString(R.string.talk_checked_tip) + charSequence;
            }
            this.k.setContentDescription(charSequence);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) {
            setClipToPadding(false);
            setClipChildren(false);
            this.k.setVisibility(8);
            this.j.setVisibility(0);
            if (i > 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.width = i;
                layoutParams.height = i;
                layoutParams.bottomMargin = i2;
                layoutParams.addRule(12, -1);
                layoutParams.addRule(14, -1);
                this.j.setLayoutParams(layoutParams);
            }
            e();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            super.setSelected(z);
            if (this.mIsContentSelectBold) {
                this.k.getPaint().setFakeBoldText(z);
            }
            if (z) {
                float f = this.mContentSelectTextSize;
                if (f != 0.0f) {
                    this.k.setTextSize(0, f);
                }
                ThemeColorInfo themeColorInfo = this.mThemeColorInfo;
                if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                        this.k.setTextColor(zfa.f(this.mThemeColorInfo.dark.font_color));
                        return;
                    } else {
                        this.k.setTextColor(zfa.f(this.mThemeColorInfo.day.font_color));
                        return;
                    }
                }
                int i = this.mContentSelectTextColor;
                if (i != 0) {
                    SkinManager.setViewTextColor(this.k, i);
                    return;
                }
                return;
            }
            float f2 = this.mContentDefaultTextSize;
            if (f2 != 0.0f) {
                this.k.setTextSize(0, f2);
            }
            int i2 = this.mContentDefaultTextColor;
            if (i2 != 0) {
                SkinManager.setViewTextColor(this.k, i2);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.k.setText(str);
            this.k.setContentDescription(str);
        }
    }
}
