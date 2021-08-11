package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ScrollHorizontalTabView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.p0.v0.r1.a.d.e> f50890e;

    /* renamed from: f  reason: collision with root package name */
    public final List<TextView> f50891f;

    /* renamed from: g  reason: collision with root package name */
    public final int f50892g;

    /* renamed from: h  reason: collision with root package name */
    public final int f50893h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50894i;

    /* renamed from: j  reason: collision with root package name */
    public int f50895j;
    public int k;
    public float l;
    public int m;
    public int n;
    public LinearLayout o;
    public Paint p;
    public ViewPager q;
    public final e r;
    public f s;
    public View.OnClickListener t;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollHorizontalTabView f50896e;

        public a(ScrollHorizontalTabView scrollHorizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollHorizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50896e = scrollHorizontalTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int size = this.f50896e.f50891f.size();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (view == this.f50896e.f50891f.get(i3)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                this.f50896e.f50894i = true;
                if (this.f50896e.q != null) {
                    this.f50896e.q.setCurrentItem(i2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollHorizontalTabView f50897e;

        public b(ScrollHorizontalTabView scrollHorizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollHorizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50897e = scrollHorizontalTabView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50897e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ScrollHorizontalTabView scrollHorizontalTabView = this.f50897e;
                scrollHorizontalTabView.f50895j = scrollHorizontalTabView.q.getCurrentItem();
                ScrollHorizontalTabView scrollHorizontalTabView2 = this.f50897e;
                scrollHorizontalTabView2.scrollToChild(scrollHorizontalTabView2.f50895j, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f50898e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ScrollHorizontalTabView f50899f;

        public c(ScrollHorizontalTabView scrollHorizontalTabView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollHorizontalTabView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50899f = scrollHorizontalTabView;
            this.f50898e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50899f.scrollBy(0 - this.f50898e, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollHorizontalTabView f50900e;

        public d(ScrollHorizontalTabView scrollHorizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollHorizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50900e = scrollHorizontalTabView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ScrollHorizontalTabView scrollHorizontalTabView = this.f50900e;
                scrollHorizontalTabView.scrollBy(scrollHorizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ScrollHorizontalTabView f50901e;

        public e(ScrollHorizontalTabView scrollHorizontalTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollHorizontalTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50901e = scrollHorizontalTabView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f50901e.o.getChildCount() == 0 || this.f50901e.q == null || i2 != 0) {
                return;
            }
            this.f50901e.l = 0.0f;
            this.f50901e.f50894i = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f50901e.o.getChildCount() == 0 || this.f50901e.f50894i) {
                return;
            }
            if (this.f50901e.f50895j != i2) {
                int unused = this.f50901e.f50895j;
            }
            this.f50901e.f50895j = i2;
            this.f50901e.l = f2;
            ScrollHorizontalTabView scrollHorizontalTabView = this.f50901e;
            scrollHorizontalTabView.scrollToChild(i2, (int) (f2 * scrollHorizontalTabView.o.getChildAt(i2).getWidth()));
            this.f50901e.updateTabStyles();
            this.f50901e.invalidate();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                c.a.p0.v0.r1.a.d.e eVar = (c.a.p0.v0.r1.a.d.e) ListUtils.getItem(this.f50901e.f50890e, i2);
                if (this.f50901e.s == null || this.f50901e.s.a(i2, eVar)) {
                    if (this.f50901e.s != null) {
                        this.f50901e.s.b(i2, eVar);
                    }
                    if (this.f50901e.f50894i) {
                        if (this.f50901e.f50895j != i2) {
                            int unused = this.f50901e.f50895j;
                        }
                        this.f50901e.f50895j = i2;
                        ScrollHorizontalTabView scrollHorizontalTabView = this.f50901e;
                        scrollHorizontalTabView.scrollToChild(i2, (int) (scrollHorizontalTabView.l * this.f50901e.o.getChildAt(i2).getWidth()));
                        this.f50901e.updateTabStyles();
                        this.f50901e.invalidate();
                    }
                }
            }
        }

        public /* synthetic */ e(ScrollHorizontalTabView scrollHorizontalTabView, a aVar) {
            this(scrollHorizontalTabView);
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        boolean a(int i2, c.a.p0.v0.r1.a.d.e eVar);

        void b(int i2, c.a.p0.v0.r1.a.d.e eVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHorizontalTabView(Context context) {
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
        this.f50890e = new ArrayList();
        this.f50891f = new ArrayList();
        this.f50892g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.f50893h = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds84);
        this.f50894i = false;
        this.f50895j = 0;
        this.k = SkinManager.getColor(R.color.CAM_X0106);
        this.l = 0.0f;
        this.m = 52;
        this.n = 0;
        this.r = new e(this, null);
        this.t = new a(this);
        init();
    }

    public final void fillTabData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int size = this.f50890e.size();
            int size2 = this.f50891f.size();
            for (int i2 = 0; i2 < size && i2 < size2; i2++) {
                c.a.p0.v0.r1.a.d.e eVar = this.f50890e.get(i2);
                TextView textView = this.f50891f.get(i2);
                if (eVar != null && textView != null) {
                    textView.setText(eVar.f26730b);
                }
            }
        }
    }

    public int getCurrentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50895j : invokeV.intValue;
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setHorizontalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.o = linearLayout;
            linearLayout.setGravity(16);
            this.o.setOrientation(0);
            this.o.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.o);
            Paint paint = new Paint();
            this.p = paint;
            paint.setAntiAlias(true);
            this.p.setStyle(Paint.Style.FILL);
            this.m = (int) TypedValue.applyDimension(1, this.m, getResources().getDisplayMetrics());
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.k = SkinManager.getColor(R.color.CAM_X0106);
            updateTabStyles();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.f50891f.isEmpty()) {
                return;
            }
            int height = getHeight();
            this.p.setColor(this.k);
            View childAt = this.o.getChildAt(this.f50895j);
            int width = (childAt.getWidth() - childAt.getPaddingLeft()) - childAt.getPaddingRight();
            int left = this.o.getLeft() + childAt.getLeft() + childAt.getPaddingLeft();
            int i2 = this.f50893h;
            float f2 = left + ((width - i2) / 2);
            float f3 = i2 + f2;
            if (this.l > 0.0f && this.f50895j < this.o.getChildCount() - 1) {
                View childAt2 = this.o.getChildAt(this.f50895j + 1);
                int width2 = (childAt2.getWidth() - childAt2.getPaddingRight()) - childAt2.getPaddingLeft();
                int left2 = childAt2.getLeft() + childAt2.getPaddingLeft() + this.o.getLeft();
                int i3 = this.f50893h;
                float f4 = left2 + ((width2 - i3) / 2);
                float f5 = this.l;
                f2 = (f4 * f5) + ((1.0f - f5) * f2);
                f3 = ((i3 + f4) * f5) + ((1.0f - f5) * f3);
            }
            canvas.drawRect(f2, height - this.f50892g, f3, height, this.p);
        }
    }

    public final void scrollToChild(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) || this.f50891f.isEmpty()) {
            return;
        }
        int left = this.f50891f.get(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.m;
        }
        if (left != this.n) {
            this.n = left;
            scrollTo(left, 0);
        }
    }

    public void setCurrentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            setCurrentIndex(i2, true);
        }
    }

    public void setData(List<c.a.p0.v0.r1.a.d.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f50890e.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f50890e.addAll(list);
            }
            setupTabItems();
            fillTabData();
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
        }
    }

    public void setScrollTabPageListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.s = fVar;
        }
    }

    public final void setTabStatus(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, textView, z) == null) || textView == null) {
            return;
        }
        if (z) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewPager) == null) {
            this.q = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.r);
        }
    }

    public final void setupTabItems() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int size = this.f50890e.size();
            int size2 = this.f50891f.size();
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds4);
            int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            if (size > size2) {
                while (size2 < size) {
                    TextView textView = new TextView(getContext());
                    textView.setOnClickListener(this.t);
                    textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
                    textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                    textView.setGravity(17);
                    this.f50891f.add(textView);
                    size2++;
                }
            } else if (size < size2) {
                for (int i2 = size2 - 1; i2 >= size; i2--) {
                    this.f50891f.remove(i2);
                }
            }
            this.o.removeAllViews();
            int size3 = this.f50891f.size();
            for (int i3 = 0; i3 < size3; i3++) {
                this.o.addView(this.f50891f.get(i3));
            }
        }
    }

    public final void updateTabStyles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int size = this.f50891f.size();
            for (int i2 = 0; i2 < size; i2++) {
                TextView textView = this.f50891f.get(i2);
                if (textView instanceof TextView) {
                    TextView textView2 = textView;
                    if (i2 == this.f50895j) {
                        setTabStatus(textView2, true);
                    } else {
                        setTabStatus(textView2, false);
                    }
                }
            }
        }
    }

    public void setCurrentIndex(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                int[] iArr = new int[2];
                ((View) ListUtils.getItem(this.f50891f, i2)).getLocationOnScreen(iArr);
                int k = l.k(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
                if (iArr[0] < 0) {
                    post(new c(this, dimensionPixelSize));
                } else if (k < dimensionPixelSize) {
                    post(new d(this));
                }
            }
            ViewPager viewPager = this.q;
            if (viewPager != null) {
                viewPager.setCurrentItem(i2);
            }
            updateTabStyles();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet) {
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
        this.f50890e = new ArrayList();
        this.f50891f = new ArrayList();
        this.f50892g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.f50893h = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds84);
        this.f50894i = false;
        this.f50895j = 0;
        this.k = SkinManager.getColor(R.color.CAM_X0106);
        this.l = 0.0f;
        this.m = 52;
        this.n = 0;
        this.r = new e(this, null);
        this.t = new a(this);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f50890e = new ArrayList();
        this.f50891f = new ArrayList();
        this.f50892g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.f50893h = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds84);
        this.f50894i = false;
        this.f50895j = 0;
        this.k = SkinManager.getColor(R.color.CAM_X0106);
        this.l = 0.0f;
        this.m = 52;
        this.n = 0;
        this.r = new e(this, null);
        this.t = new a(this);
        init();
    }
}
