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
import com.baidu.tbadk.core.util.ListUtils;
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
/* loaded from: classes7.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_TAB_TEXT_LENGTH = 8;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f52795e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f52796f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f52797g;

    /* renamed from: h  reason: collision with root package name */
    public int f52798h;

    /* renamed from: i  reason: collision with root package name */
    public final SlidingTabStrip f52799i;

    /* renamed from: j  reason: collision with root package name */
    public c f52800j;
    public List<TabItemView> k;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f52801e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SlidingTabLayout f52802f;

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
            this.f52802f = slidingTabLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f52801e = i2;
                if (this.f52802f.f52797g != null) {
                    this.f52802f.f52797g.onPageScrollStateChanged(i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            int childCount;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || f2 < 0.0f || (childCount = this.f52802f.f52799i.getChildCount()) == 0 || i2 < 0 || i2 >= childCount) {
                return;
            }
            this.f52802f.f52799i.drawScrollRect(i2, f2);
            View childAt = this.f52802f.f52799i.getChildAt(i2);
            this.f52802f.j(i2, childAt != null ? (int) (childAt.getWidth() * f2) : 0);
            if (this.f52802f.f52797g != null) {
                this.f52802f.f52797g.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                int i3 = this.f52802f.f52798h;
                this.f52802f.f52799i.updateTextViewColor(i2, this.f52802f.f52798h);
                this.f52802f.f52798h = i2;
                if (this.f52801e == 0) {
                    this.f52802f.k(i3, i2);
                }
                if (this.f52802f.f52797g != null) {
                    this.f52802f.f52797g.onPageSelected(i2);
                }
            }
        }

        public /* synthetic */ b(SlidingTabLayout slidingTabLayout, a aVar) {
            this(slidingTabLayout);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f52803e;

        /* renamed from: f  reason: collision with root package name */
        public int f52804f;

        /* renamed from: g  reason: collision with root package name */
        public int f52805g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SlidingTabLayout f52806h;

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
            this.f52806h = slidingTabLayout;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f52803e = i2;
                this.f52804f = i3;
            }
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                super.applyTransformation(f2, transformation);
                int i2 = this.f52804f;
                int i3 = this.f52803e;
                this.f52806h.scrollTo((int) (i3 + ((i2 - i3) * f2)), 0);
                if (this.f52806h.f52799i != null) {
                    this.f52806h.f52799i.performTranslate(this.f52805g, f2);
                }
            }
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f52805g = i2;
            }
        }

        public /* synthetic */ c(SlidingTabLayout slidingTabLayout, a aVar) {
            this(slidingTabLayout);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SlidingTabLayout f52807e;

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
            this.f52807e = slidingTabLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52807e.f52799i == null) {
                return;
            }
            for (int i2 = 0; i2 < this.f52807e.f52799i.getChildCount(); i2++) {
                if (view == this.f52807e.f52799i.getChildAt(i2)) {
                    this.f52807e.f52796f.setCurrentItem(i2, false);
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

    public TabItemView createDefaultTabView(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i2)) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds16);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds14);
            TabItemView tabItemView = new TabItemView(context);
            tabItemView.onChangeSkinType();
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

    public final int h(int i2, int i3) {
        InterceptResult invokeII;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            int childCount = this.f52799i.getChildCount();
            if (childCount == 0 || i2 < 0 || i2 >= childCount || (childAt = this.f52799i.getChildAt(i2)) == null) {
                return 0;
            }
            int left = childAt.getLeft() + i3;
            return (i2 > 0 || i3 > 0) ? left - this.f52795e : left;
        }
        return invokeII.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PagerAdapter adapter = this.f52796f.getAdapter();
            d dVar = new d(this, null);
            this.k.clear();
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                TabItemView createDefaultTabView = createDefaultTabView(getContext(), i2);
                this.k.add(createDefaultTabView);
                TextView textView = createDefaultTabView.getTextView();
                textView.setText(StringHelper.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i2)) + "", 8, (String) null));
                createDefaultTabView.setOnClickListener(dVar);
                this.f52799i.addView(createDefaultTabView);
            }
        }
    }

    public final void j(int i2, int i3) {
        int h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) || (h2 = h(i2, i3)) < 0) {
            return;
        }
        scrollTo(h2, 0);
    }

    public final void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            clearAnimation();
            if (this.f52800j == null) {
                c cVar = new c(this, null);
                this.f52800j = cVar;
                cVar.setDuration(300L);
            }
            int h2 = h(i3, 0);
            this.f52800j.c(i2);
            this.f52800j.a(getScrollX(), h2);
            startAnimation(this.f52800j);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            ViewPager viewPager = this.f52796f;
            if (viewPager != null) {
                j(viewPager.getCurrentItem(), 0);
            }
        }
    }

    public void onChangeSkinType(int i2) {
        SlidingTabStrip slidingTabStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (slidingTabStrip = this.f52799i) == null) {
            return;
        }
        slidingTabStrip.onChangeSkinType(i2);
    }

    public void setDrawBottomLine(boolean z) {
        SlidingTabStrip slidingTabStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (slidingTabStrip = this.f52799i) == null) {
            return;
        }
        slidingTabStrip.setDrawBottomLine(z);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPageChangeListener) == null) {
            this.f52797g = onPageChangeListener;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewPager) == null) {
            this.f52799i.removeAllViews();
            this.f52796f = viewPager;
            if (viewPager != null) {
                viewPager.setOnPageChangeListener(new b(this, null));
                i();
            }
        }
    }

    public void showRedTips(int i2, int i3) {
        TabItemView tabItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) || ListUtils.isEmpty(this.k) || (tabItemView = (TabItemView) ListUtils.getItem(this.k, i2)) == null) {
            return;
        }
        if (i3 > 0) {
            tabItemView.getRedTipView().setVisibility(0);
        } else {
            tabItemView.getRedTipView().setVisibility(8);
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
        this.f52798h = 0;
        this.k = new ArrayList();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f52795e = (int) (getResources().getDisplayMetrics().density * 24.0f);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.f52799i = slidingTabStrip;
        addView(slidingTabStrip, -1, -2);
    }
}
