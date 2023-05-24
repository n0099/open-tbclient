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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.cn;
import com.baidu.tieba.g9;
import com.baidu.tieba.kg;
import com.baidu.tieba.lg;
import com.baidu.tieba.m9;
import com.baidu.tieba.rg;
import com.baidu.tieba.xp9;
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
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public int m;
    public String n;
    public BdUniqueId o;
    public ImageView p;
    public TextView q;
    public int r;
    public int s;
    public boolean t;
    public HashMap<String, TbFragmentTabIndicator.a> u;
    public final kg<cn> v;

    /* loaded from: classes4.dex */
    public class a extends rg {
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

        @Override // com.baidu.tieba.rg
        public void a(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.l = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends kg<cn> {
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
        @Override // com.baidu.tieba.kg
        public void onLoaded(cn cnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, cnVar, str, i) == null) {
                super.onLoaded((b) cnVar, str, i);
                if (this.a.p != null && cnVar != null && cnVar.w()) {
                    this.a.p.setBackgroundResource(0);
                    this.a.p.setImageDrawable(null);
                    cnVar.h(this.a.p);
                    return;
                }
                this.a.l();
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
        this.g = 0;
        this.k = 0;
        this.l = true;
        this.t = true;
        this.u = new HashMap<>();
        this.v = new b(this);
        j();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.t) {
                SkinManager.setViewTextColor(this.q, this.h, 1);
            } else {
                SkinManager.setViewTextColor(this.q, this.h, 1, 0);
            }
            if (this.q != null) {
                this.q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, this.i), SkinManager.getSkinDrawable(null, this.j), (Drawable) null);
            }
            k();
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.u.entrySet()) {
                entry.getValue().b(i);
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
        this.g = 0;
        this.k = 0;
        this.l = true;
        this.t = true;
        this.u = new HashMap<>();
        this.v = new b(this);
        j();
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) {
            this.q.setVisibility(0);
            this.p.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(14, -1);
            this.q.setLayoutParams(layoutParams);
            if (i > 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.width = i;
                layoutParams2.height = i;
                layoutParams2.bottomMargin = i2;
                layoutParams2.addRule(2, this.p.getId());
                layoutParams2.addRule(14, -1);
                this.p.setLayoutParams(layoutParams2);
            }
            k();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) && (view2 = aVar.a) != null) {
            addView(view2);
            this.u.put(str, aVar);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            this.q.setTextSize(i, f);
        }
    }

    private BdUniqueId getBdUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            BdUniqueId bdUniqueId = this.o;
            if (bdUniqueId != null) {
                return bdUniqueId;
            }
            g9<?> a2 = m9.a(getContext());
            if (a2 != null) {
                this.o = a2.getUniqueId();
            }
            return this.o;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return (View) invokeV.objValue;
    }

    public final void l() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (i = this.m) > 0) {
            SkinManager.setImageResource(this.p, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void setContentWidthWrapContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
            layoutParams.width = -2;
            this.q.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.u.get(str);
        }
        return (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.f(z);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.k = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.q.setCompoundDrawablePadding(i);
        }
    }

    public void setCompoundDrawablesRightResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.j = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.i = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentDefaultTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            super.setContentDefaultTextColor(i);
            this.q.setTextColor(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && (this.q.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.topMargin = i;
            this.q.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.m = i;
            l();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.a = z;
        }
    }

    public void setIsSupportNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (!z) {
                SkinManager.setViewTextColor(this.q, this.h, 1, 0);
            }
            this.t = z;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.q.setText(i);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.h = i;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f) == null) {
            this.q.setTextSize(f);
        }
    }

    public void setTextSpan(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, spannableString) == null) {
            this.q.setText(spannableString);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.g = i;
        }
    }

    public void setTipTopMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.r = i;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
            layoutParams.addRule(13, -1);
            this.q.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.k > 0 && this.l) {
            try {
                this.l = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.p.getContext(), this.k);
                loadAnimation.setAnimationListener(new a(this));
                this.p.startAnimation(loadAnimation);
            } catch (Exception unused) {
                this.l = true;
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.i <= 0 && this.j <= 0) {
            if (!TextUtils.isEmpty(this.n)) {
                lg.h().m(this.n, 10, this.v, getBdUniqueId());
            } else {
                l();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.r = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4);
            this.s = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070352);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_indicator_item, this);
            this.p = (ImageView) inflate.findViewById(R.id.view_bottom_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.view_bottom_text);
            this.q = textView;
            textView.setDuplicateParentStateEnabled(true);
            l();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.u.entrySet().iterator();
            while (it.hasNext() && this.q.getText() != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                int measuredWidth2 = value.a.getMeasuredWidth();
                int measuredHeight2 = value.a.getMeasuredHeight();
                int measureText = (int) this.q.getPaint().measureText(this.q.getText().toString());
                if (value.b) {
                    measuredWidth = (getMeasuredWidth() / 2) + value.c + (measureText / 2);
                } else {
                    measuredWidth = ((getMeasuredWidth() / 2) - value.c) - (measureText / 2);
                }
                if (this.g == 1) {
                    measuredWidth -= this.s;
                    measuredHeight = this.r;
                } else {
                    measuredHeight = (getMeasuredHeight() / 2) - (value.a.getMeasuredHeight() / 2);
                }
                value.a.layout(measuredWidth, measuredHeight, measuredWidth2 + measuredWidth, measuredHeight2 + measuredHeight);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.u.entrySet()) {
                TbFragmentTabIndicator.a value = entry.getValue();
                ViewGroup.LayoutParams layoutParams = value.a.getLayoutParams();
                int i3 = layoutParams.width;
                if (i3 == -2) {
                    value.a.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                } else {
                    if (i3 > size) {
                        i3 = size;
                    }
                    int i4 = layoutParams.height;
                    if (i4 > size2) {
                        i4 = size2;
                    }
                    value.a.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            String charSequence = this.q.getText().toString();
            if (z) {
                charSequence = getContext().getString(R.string.talk_checked_tip) + charSequence;
            }
            this.q.setContentDescription(charSequence);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i, i2) == null) {
            setClipToPadding(false);
            setClipChildren(false);
            this.q.setVisibility(8);
            this.p.setVisibility(0);
            if (i > 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.width = i;
                layoutParams.height = i;
                layoutParams.bottomMargin = i2;
                layoutParams.addRule(12, -1);
                layoutParams.addRule(14, -1);
                this.p.setLayoutParams(layoutParams);
            }
            k();
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.setSelected(z);
            if (this.a) {
                this.q.getPaint().setFakeBoldText(z);
            }
            if (z) {
                float f = this.b;
                if (f != 0.0f) {
                    this.q.setTextSize(0, f);
                }
                ThemeColorInfo themeColorInfo = this.f;
                if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                        this.q.setTextColor(xp9.f(this.f.dark.font_color));
                        return;
                    } else {
                        this.q.setTextColor(xp9.f(this.f.day.font_color));
                        return;
                    }
                }
                int i = this.d;
                if (i != 0) {
                    SkinManager.setViewTextColor(this.q, i);
                    return;
                }
                return;
            }
            float f2 = this.c;
            if (f2 != 0.0f) {
                this.q.setTextSize(0, f2);
            }
            int i2 = this.e;
            if (i2 != 0) {
                SkinManager.setViewTextColor(this.q, i2);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.q.setText(str);
            this.q.setContentDescription(str);
        }
    }
}
