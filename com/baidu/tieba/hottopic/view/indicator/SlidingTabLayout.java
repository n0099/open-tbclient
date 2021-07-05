package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f17196e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f17197f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f17198g;

    /* renamed from: h  reason: collision with root package name */
    public int f17199h;

    /* renamed from: i  reason: collision with root package name */
    public final SlidingTabStrip f17200i;
    public c j;
    public List<TabItemView> k;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f17201e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SlidingTabLayout f17202f;

        public b(SlidingTabLayout slidingTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17202f = slidingTabLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f17201e = i2;
                if (this.f17202f.f17198g != null) {
                    this.f17202f.f17198g.onPageScrollStateChanged(i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            int childCount;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || f2 < 0.0f || (childCount = this.f17202f.f17200i.getChildCount()) == 0 || i2 < 0 || i2 >= childCount) {
                return;
            }
            this.f17202f.f17200i.b(i2, f2);
            View childAt = this.f17202f.f17200i.getChildAt(i2);
            this.f17202f.l(i2, childAt != null ? (int) (childAt.getWidth() * f2) : 0);
            if (this.f17202f.f17198g != null) {
                this.f17202f.f17198g.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                int i3 = this.f17202f.f17199h;
                this.f17202f.f17200i.f(i2, this.f17202f.f17199h);
                this.f17202f.f17199h = i2;
                if (this.f17201e == 0) {
                    this.f17202f.m(i3, i2);
                }
                if (this.f17202f.f17198g != null) {
                    this.f17202f.f17198g.onPageSelected(i2);
                }
            }
        }

        public /* synthetic */ b(SlidingTabLayout slidingTabLayout, a aVar) {
            this(slidingTabLayout);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f17203e;

        /* renamed from: f  reason: collision with root package name */
        public int f17204f;

        /* renamed from: g  reason: collision with root package name */
        public int f17205g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SlidingTabLayout f17206h;

        public c(SlidingTabLayout slidingTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17206h = slidingTabLayout;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f17203e = i2;
                this.f17204f = i3;
            }
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                super.applyTransformation(f2, transformation);
                int i2 = this.f17204f;
                int i3 = this.f17203e;
                this.f17206h.scrollTo((int) (i3 + ((i2 - i3) * f2)), 0);
                if (this.f17206h.f17200i != null) {
                    this.f17206h.f17200i.e(this.f17205g, f2);
                }
            }
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f17205g = i2;
            }
        }

        public /* synthetic */ c(SlidingTabLayout slidingTabLayout, a aVar) {
            this(slidingTabLayout);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SlidingTabLayout f17207e;

        public d(SlidingTabLayout slidingTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17207e = slidingTabLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f17207e.f17200i == null) {
                return;
            }
            for (int i2 = 0; i2 < this.f17207e.f17200i.getChildCount(); i2++) {
                if (view == this.f17207e.f17200i.getChildAt(i2)) {
                    this.f17207e.f17197f.setCurrentItem(i2, false);
                    return;
                }
            }
        }

        public /* synthetic */ d(SlidingTabLayout slidingTabLayout, a aVar) {
            this(slidingTabLayout);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingTabLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public TabItemView h(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i2)) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds16);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
            TabItemView tabItemView = new TabItemView(context);
            tabItemView.a();
            if (i2 == 0) {
                SkinManager.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0105, 1);
                tabItemView.getTextView().setPadding(0, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            } else {
                SkinManager.setViewTextColor(tabItemView.getTextView(), R.color.CAM_X0107, 1);
                tabItemView.getTextView().setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            }
            return tabItemView;
        }
        return (TabItemView) invokeLI.objValue;
    }

    public final int i(int i2, int i3) {
        InterceptResult invokeII;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            int childCount = this.f17200i.getChildCount();
            if (childCount == 0 || i2 < 0 || i2 >= childCount || (childAt = this.f17200i.getChildAt(i2)) == null) {
                return 0;
            }
            int left = childAt.getLeft() + i3;
            return (i2 > 0 || i3 > 0) ? left - this.f17196e : left;
        }
        return invokeII.intValue;
    }

    public void j(int i2) {
        SlidingTabStrip slidingTabStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (slidingTabStrip = this.f17200i) == null) {
            return;
        }
        slidingTabStrip.d(i2);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PagerAdapter adapter = this.f17197f.getAdapter();
            d dVar = new d(this, null);
            this.k.clear();
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                TabItemView h2 = h(getContext(), i2);
                this.k.add(h2);
                TextView textView = h2.getTextView();
                textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i2)) + "", 8, null));
                h2.setOnClickListener(dVar);
                this.f17200i.addView(h2);
            }
        }
    }

    public final void l(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || (i4 = i(i2, i3)) < 0) {
            return;
        }
        scrollTo(i4, 0);
    }

    public final void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            clearAnimation();
            if (this.j == null) {
                c cVar = new c(this, null);
                this.j = cVar;
                cVar.setDuration(300L);
            }
            int i4 = i(i3, 0);
            this.j.b(i2);
            this.j.a(getScrollX(), i4);
            startAnimation(this.j);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            ViewPager viewPager = this.f17197f;
            if (viewPager != null) {
                l(viewPager.getCurrentItem(), 0);
            }
        }
    }

    public void setDrawBottomLine(boolean z) {
        SlidingTabStrip slidingTabStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (slidingTabStrip = this.f17200i) == null) {
            return;
        }
        slidingTabStrip.setDrawBottomLine(z);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPageChangeListener) == null) {
            this.f17198g = onPageChangeListener;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewPager) == null) {
            this.f17200i.removeAllViews();
            this.f17197f = viewPager;
            if (viewPager != null) {
                viewPager.setOnPageChangeListener(new b(this, null));
                k();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f17199h = 0;
        this.k = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f17196e = (int) (getResources().getDisplayMetrics().density * 24.0f);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.f17200i = slidingTabStrip;
        addView(slidingTabStrip, -1, -2);
    }
}
