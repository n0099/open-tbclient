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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.c.e.l.c;
import d.a.c.e.m.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<d.a.c.k.d.a> A;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int q;
    public String r;
    public String s;
    public BdUniqueId t;
    public ImageView u;
    public TextView v;
    public int w;
    public int x;
    public boolean y;
    public HashMap<String, TbFragmentTabIndicator.a> z;

    /* loaded from: classes3.dex */
    public class a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FragmentTabIndicator f13105a;

        public a(FragmentTabIndicator fragmentTabIndicator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentTabIndicator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13105a = fragmentTabIndicator;
        }

        @Override // d.a.c.e.m.d
        public void a(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f13105a.p = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c<d.a.c.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FragmentTabIndicator f13106a;

        public b(FragmentTabIndicator fragmentTabIndicator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragmentTabIndicator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13106a = fragmentTabIndicator;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (this.f13106a.u == null || aVar == null || !aVar.w()) {
                    this.f13106a.l();
                    return;
                }
                this.f13106a.u.setBackgroundResource(0);
                this.f13106a.u.setImageDrawable(null);
                aVar.h(this.f13106a.u);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.o = 0;
        this.p = true;
        this.y = true;
        this.z = new HashMap<>();
        this.A = new b(this);
        j();
    }

    private BdUniqueId getBdUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            BdUniqueId bdUniqueId = this.t;
            if (bdUniqueId != null) {
                return bdUniqueId;
            }
            f<?> a2 = j.a(getContext());
            if (a2 != null) {
                this.t = a2.getUniqueId();
            }
            return this.t;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void a(String str, TbFragmentTabIndicator.a aVar) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || (view = aVar.f13115a) == null) {
            return;
        }
        addView(view);
        this.z.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.o > 0 && this.p) {
            try {
                this.p = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.u.getContext(), this.o);
                loadAnimation.setAnimationListener(new a(this));
                this.u.startAnimation(loadAnimation);
            } catch (Exception unused) {
                this.p = true;
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.z.get(str) : (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (this.y) {
                SkinManager.setViewTextColor(this.v, this.l, 1);
            } else {
                SkinManager.setViewTextColor(this.v, this.l, 1, 0);
            }
            if (this.v != null) {
                this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, this.m), SkinManager.getSkinDrawable(null, this.n), (Drawable) null);
            }
            k();
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.z.entrySet()) {
                entry.getValue().b(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.f(z);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.v : (View) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.w = getResources().getDimensionPixelSize(R.dimen.ds2);
            this.x = getResources().getDimensionPixelSize(R.dimen.ds12);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_indicator_item, this);
            this.u = (ImageView) inflate.findViewById(R.id.view_bottom_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.view_bottom_text);
            this.v = textView;
            textView.setDuplicateParentStateEnabled(true);
            l();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.m > 0 || this.n > 0) {
            return;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.s)) {
            d.a.c.e.l.d.h().m(this.s, 10, this.A, getBdUniqueId());
        } else if (!TextUtils.isEmpty(this.r)) {
            d.a.c.e.l.d.h().m(this.r, 10, this.A, getBdUniqueId());
        } else {
            l();
        }
    }

    public final void l() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (i2 = this.q) <= 0) {
            return;
        }
        SkinManager.setImageResource(this.u, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.z.entrySet().iterator();
            while (it.hasNext() && this.v.getText() != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                int measuredWidth2 = value.f13115a.getMeasuredWidth();
                int measuredHeight2 = value.f13115a.getMeasuredHeight();
                int measureText = (int) this.v.getPaint().measureText(this.v.getText().toString());
                if (value.f13116b) {
                    measuredWidth = (getMeasuredWidth() / 2) + value.f13117c + (measureText / 2);
                } else {
                    measuredWidth = ((getMeasuredWidth() / 2) - value.f13117c) - (measureText / 2);
                }
                if (this.k == 1) {
                    measuredWidth -= this.x;
                    measuredHeight = this.w;
                } else {
                    measuredHeight = (getMeasuredHeight() / 2) - (value.f13115a.getMeasuredHeight() / 2);
                }
                value.f13115a.layout(measuredWidth, measuredHeight, measuredWidth2 + measuredWidth, measuredHeight2 + measuredHeight);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.z.entrySet()) {
                TbFragmentTabIndicator.a value = entry.getValue();
                ViewGroup.LayoutParams layoutParams = value.f13115a.getLayoutParams();
                int i4 = layoutParams.width;
                if (i4 == -2) {
                    value.f13115a.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                } else {
                    if (i4 > size) {
                        i4 = size;
                    }
                    int i5 = layoutParams.height;
                    if (i5 > size2) {
                        i5 = size2;
                    }
                    value.f13115a.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.o = i2;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            String charSequence = this.v.getText().toString();
            if (z) {
                charSequence = getContext().getString(R.string.talk_checked_tip) + charSequence;
            }
            this.v.setContentDescription(charSequence);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.v.setCompoundDrawablePadding(i2);
        }
    }

    public void setCompoundDrawablesRightResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.n = i2;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.m = i2;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentDefaultTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            super.setContentDefaultTextColor(i2);
            this.v.setTextColor(i2);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i2) == null) && (this.v.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
            layoutParams.topMargin = i2;
            this.v.setLayoutParams(layoutParams);
        }
    }

    public void setContentWidthWrapContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.width = -2;
            this.v.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.q = i2;
            l();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            this.v.setVisibility(0);
            this.u.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(14, -1);
            this.v.setLayoutParams(layoutParams);
            if (i2 > 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                layoutParams2.bottomMargin = i3;
                layoutParams2.addRule(2, this.u.getId());
                layoutParams2.addRule(14, -1);
                this.u.setLayoutParams(layoutParams2);
            }
            k();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            setClipToPadding(false);
            setClipChildren(false);
            this.v.setVisibility(8);
            this.u.setVisibility(0);
            if (i2 > 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.width = i2;
                layoutParams.height = i2;
                layoutParams.bottomMargin = i3;
                layoutParams.addRule(12, -1);
                layoutParams.addRule(14, -1);
                this.u.setLayoutParams(layoutParams);
            }
            k();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIsContentSelectBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f13110e = z;
        }
    }

    public void setIsSupportNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            if (!z) {
                SkinManager.setViewTextColor(this.v, this.l, 1, 0);
            }
            this.y = z;
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.setSelected(z);
            if (this.f13110e) {
                this.v.getPaint().setFakeBoldText(z);
            }
            if (z) {
                float f2 = this.f13111f;
                if (f2 != 0.0f) {
                    this.v.setTextSize(0, f2);
                }
                ThemeColorInfo themeColorInfo = this.j;
                if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 4) {
                        this.v.setTextColor(d.a.p0.h3.c.c(this.j.dark.font_color));
                        return;
                    } else if (skinType == 1) {
                        this.v.setTextColor(d.a.p0.h3.c.c(this.j.night.font_color));
                        return;
                    } else {
                        this.v.setTextColor(d.a.p0.h3.c.c(this.j.day.font_color));
                        return;
                    }
                }
                int i2 = this.f13113h;
                if (i2 != 0) {
                    SkinManager.setViewTextColor(this.v, i2);
                    return;
                }
                return;
            }
            float f3 = this.f13112g;
            if (f3 != 0.0f) {
                this.v.setTextSize(0, f3);
            }
            int i3 = this.f13114i;
            if (i3 != 0) {
                SkinManager.setViewTextColor(this.v, i3);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.v.setText(i2);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.l = i2;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048605, this, f2) == null) {
            this.v.setTextSize(f2);
        }
    }

    public void setTextSpan(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, spannableString) == null) {
            this.v.setText(spannableString);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setTipTopMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, -2);
            layoutParams.addRule(13, -1);
            this.v.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.v.setText(str);
            this.v.setContentDescription(str);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.v.setTextSize(i2, f2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.o = 0;
        this.p = true;
        this.y = true;
        this.z = new HashMap<>();
        this.A = new b(this);
        j();
    }
}
