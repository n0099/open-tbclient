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
import b.a.e.a.f;
import b.a.e.a.j;
import b.a.e.e.l.c;
import b.a.e.e.m.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tbclient.ThemeColorInfo;
/* loaded from: classes8.dex */
public class FragmentTabIndicator extends TbFragmentTabIndicator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TIP_POS_TYPE_CENTER = 0;
    public static final int TIP_POS_TYPE_TOP = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int dayTextColorResId;

    /* renamed from: e  reason: collision with root package name */
    public int f45958e;

    /* renamed from: f  reason: collision with root package name */
    public int f45959f;

    /* renamed from: g  reason: collision with root package name */
    public int f45960g;

    /* renamed from: h  reason: collision with root package name */
    public int f45961h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45962i;
    public int j;
    public String k;
    public String l;
    public BdUniqueId m;
    public ImageView n;
    public TextView o;
    public int p;
    public int q;
    public boolean r;
    public HashMap<String, TbFragmentTabIndicator.a> s;
    public final c<b.a.e.l.d.a> t;

    /* loaded from: classes8.dex */
    public class a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FragmentTabIndicator f45963a;

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
            this.f45963a = fragmentTabIndicator;
        }

        @Override // b.a.e.e.m.d
        public void a(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f45963a.f45962i = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends c<b.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FragmentTabIndicator f45964a;

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
            this.f45964a = fragmentTabIndicator;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.l.c
        public void onLoaded(b.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((b) aVar, str, i2);
                if (this.f45964a.n == null || aVar == null || !aVar.w()) {
                    this.f45964a.f();
                    return;
                }
                this.f45964a.n.setBackgroundResource(0);
                this.f45964a.n.setImageDrawable(null);
                aVar.h(this.f45964a.n);
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
        this.f45958e = 0;
        this.f45961h = 0;
        this.f45962i = true;
        this.r = true;
        this.s = new HashMap<>();
        this.t = new b(this);
        d();
    }

    private BdUniqueId getBdUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                return bdUniqueId;
            }
            f<?> a2 = j.a(getContext());
            if (a2 != null) {
                this.m = a2.getUniqueId();
            }
            return this.m;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void addTip(String str, TbFragmentTabIndicator.a aVar) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || (view = aVar.f45973a) == null) {
            return;
        }
        addView(view);
        this.s.put(str, aVar);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void checkAndStartAnimation() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f45961h > 0 && this.f45962i) {
            try {
                this.f45962i = false;
                Animation loadAnimation = AnimationUtils.loadAnimation(this.n.getContext(), this.f45961h);
                loadAnimation.setAnimationListener(new a(this));
                this.n.startAnimation(loadAnimation);
            } catch (Exception unused) {
                this.f45962i = true;
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.p = getResources().getDimensionPixelSize(R.dimen.ds2);
            this.q = getResources().getDimensionPixelSize(R.dimen.ds12);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_indicator_item, this);
            this.n = (ImageView) inflate.findViewById(R.id.view_bottom_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.view_bottom_text);
            this.o = textView;
            textView.setDuplicateParentStateEnabled(true);
            f();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f45959f > 0 || this.f45960g > 0) {
            return;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(this.l)) {
            b.a.e.e.l.d.h().m(this.l, 10, this.t, getBdUniqueId());
        } else if (!TextUtils.isEmpty(this.k)) {
            b.a.e.e.l.d.h().m(this.k, 10, this.t, getBdUniqueId());
        } else {
            f();
        }
    }

    public final void f() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (i2 = this.j) <= 0) {
            return;
        }
        SkinManager.setImageResource(this.n, i2);
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public View getContentTv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a getTip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.s.get(str) : (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (this.r) {
                SkinManager.setViewTextColor(this.o, this.dayTextColorResId, 1);
            } else {
                SkinManager.setViewTextColor(this.o, this.dayTextColorResId, 1, 0);
            }
            if (this.o != null) {
                this.o.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getSkinDrawable(null, this.f45959f), SkinManager.getSkinDrawable(null, this.f45960g), (Drawable) null);
            }
            e();
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.s.entrySet()) {
                entry.getValue().b(i2);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            Iterator<Map.Entry<String, TbFragmentTabIndicator.a>> it = this.s.entrySet().iterator();
            while (it.hasNext() && this.o.getText() != null) {
                TbFragmentTabIndicator.a value = it.next().getValue();
                int measuredWidth2 = value.f45973a.getMeasuredWidth();
                int measuredHeight2 = value.f45973a.getMeasuredHeight();
                int measureText = (int) this.o.getPaint().measureText(this.o.getText().toString());
                if (value.f45974b) {
                    measuredWidth = (getMeasuredWidth() / 2) + value.f45975c + (measureText / 2);
                } else {
                    measuredWidth = ((getMeasuredWidth() / 2) - value.f45975c) - (measureText / 2);
                }
                if (this.f45958e == 1) {
                    measuredWidth -= this.q;
                    measuredHeight = this.p;
                } else {
                    measuredHeight = (getMeasuredHeight() / 2) - (value.f45973a.getMeasuredHeight() / 2);
                }
                value.f45973a.layout(measuredWidth, measuredHeight, measuredWidth2 + measuredWidth, measuredHeight2 + measuredHeight);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            for (Map.Entry<String, TbFragmentTabIndicator.a> entry : this.s.entrySet()) {
                TbFragmentTabIndicator.a value = entry.getValue();
                ViewGroup.LayoutParams layoutParams = value.f45973a.getLayoutParams();
                int i4 = layoutParams.width;
                if (i4 == -2) {
                    value.f45973a.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                } else {
                    if (i4 > size) {
                        i4 = size;
                    }
                    int i5 = layoutParams.height;
                    if (i5 > size2) {
                        i5 = size2;
                    }
                    value.f45973a.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void onTabSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.onTabSelected(z);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void refreshIconUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            this.k = str;
            this.l = str2;
            e();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public TbFragmentTabIndicator.a removeTip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (this.s.containsKey(str)) {
                removeView(this.s.get(str).f45973a);
                return this.s.remove(str);
            }
            return null;
        }
        return (TbFragmentTabIndicator.a) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setAnimationResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f45961h = i2;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCheckDescriptionText(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            String charSequence = this.o.getText().toString();
            if (z) {
                charSequence = getContext().getString(R.string.talk_checked_tip) + charSequence;
            }
            this.o.setContentDescription(charSequence);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablePadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.o.setCompoundDrawablePadding(i2);
        }
    }

    public void setCompoundDrawablesRightResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f45960g = i2;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setCompoundDrawablesTopResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f45959f = i2;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentDefaultTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.setContentDefaultTextColor(i2);
            this.o.setTextColor(i2);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setContentTvTopMargin(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i2) == null) && (this.o.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.topMargin = i2;
            this.o.setLayoutParams(layoutParams);
        }
    }

    public void setContentWidthWrapContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
            layoutParams.width = -2;
            this.o.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.j = i2;
            f();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithText(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            this.o.setVisibility(0);
            this.n.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12, -1);
            layoutParams.addRule(14, -1);
            this.o.setLayoutParams(layoutParams);
            if (i2 > 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.width = i2;
                layoutParams2.height = i2;
                layoutParams2.bottomMargin = i3;
                layoutParams2.addRule(2, this.n.getId());
                layoutParams2.addRule(14, -1);
                this.n.setLayoutParams(layoutParams2);
            }
            e();
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setIconViewWithoutText(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            setClipToPadding(false);
            setClipChildren(false);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            if (i2 > 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.width = i2;
                layoutParams.height = i2;
                layoutParams.bottomMargin = i3;
                layoutParams.addRule(12, -1);
                layoutParams.addRule(14, -1);
                this.n.setLayoutParams(layoutParams);
            }
            e();
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
                SkinManager.setViewTextColor(this.o, this.dayTextColorResId, 1, 0);
            }
            this.r = z;
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            super.setSelected(z);
            if (this.mIsContentSelectBold) {
                this.o.getPaint().setFakeBoldText(z);
            }
            if (z) {
                float f2 = this.mContentSelectTextSize;
                if (f2 != 0.0f) {
                    this.o.setTextSize(0, f2);
                }
                ThemeColorInfo themeColorInfo = this.mThemeColorInfo;
                if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 4) {
                        this.o.setTextColor(b.a.r0.l3.c.c(this.mThemeColorInfo.dark.font_color));
                        return;
                    } else if (skinType == 1) {
                        this.o.setTextColor(b.a.r0.l3.c.c(this.mThemeColorInfo.night.font_color));
                        return;
                    } else {
                        this.o.setTextColor(b.a.r0.l3.c.c(this.mThemeColorInfo.day.font_color));
                        return;
                    }
                }
                int i2 = this.mContentSelectTextColor;
                if (i2 != 0) {
                    SkinManager.setViewTextColor(this.o, i2);
                    return;
                }
                return;
            }
            float f3 = this.mContentDefaultTextSize;
            if (f3 != 0.0f) {
                this.o.setTextSize(0, f3);
            }
            int i3 = this.mContentDefaultTextColor;
            if (i3 != 0) {
                SkinManager.setViewTextColor(this.o, i3);
            }
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.o.setText(i2);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.dayTextColorResId = i2;
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048607, this, f2) == null) {
            this.o.setTextSize(f2);
        }
    }

    public void setTextSpan(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, spannableString) == null) {
            this.o.setText(spannableString);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTipPosType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.f45958e = i2;
        }
    }

    public void setTipTopMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, -2);
            layoutParams.addRule(13, -1);
            this.o.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.o.setText(str);
            this.o.setContentDescription(str);
        }
    }

    @Override // com.baidu.tbadk.mainTab.TbFragmentTabIndicator
    public void setTextSize(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.o.setTextSize(i2, f2);
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
        this.f45958e = 0;
        this.f45961h = 0;
        this.f45962i = true;
        this.r = true;
        this.s = new HashMap<>();
        this.t = new b(this);
        d();
    }
}
