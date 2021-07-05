package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.w.z.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f13042e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f13043f;

    /* renamed from: g  reason: collision with root package name */
    public int f13044g;

    /* renamed from: h  reason: collision with root package name */
    public CommonViewPagerAdapter f13045h;

    /* renamed from: i  reason: collision with root package name */
    public int f13046i;
    public final AdapterView.OnItemClickListener j;
    public c k;

    /* loaded from: classes4.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<View> f13047a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonTabContentView f13048b;

        public CommonViewPagerAdapter(CommonTabContentView commonTabContentView, ArrayList<View> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabContentView, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13048b = commonTabContentView;
            this.f13047a = new ArrayList<>();
            this.f13047a = arrayList;
        }

        public int a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f13047a == null) {
                    return -1;
                }
                for (int i2 = 0; i2 < this.f13047a.size(); i2++) {
                    if (this.f13047a.get(i2) == view) {
                        return i2;
                    }
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, obj) == null) {
                viewGroup.removeView(this.f13047a.get(i2));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13047a.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
                View view = this.f13047a.get(i2);
                viewGroup.addView(view);
                return view;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommonTabContentView f13049e;

        public a(CommonTabContentView commonTabContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13049e = commonTabContentView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f13049e.k == null || this.f13049e.f13045h == null) {
                return;
            }
            if (this.f13049e.f13045h.a(adapterView) != 0) {
                i2 = -1;
            }
            this.f13049e.k.a(view, i2, j);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f13050e;

        /* renamed from: f  reason: collision with root package name */
        public final int f13051f;

        /* renamed from: g  reason: collision with root package name */
        public a.InterfaceC1289a f13052g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CommonTabContentView f13053h;

        public b(CommonTabContentView commonTabContentView, Context context, int i2, int i3, a.InterfaceC1289a interfaceC1289a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabContentView, context, Integer.valueOf(i2), Integer.valueOf(i3), interfaceC1289a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13053h = commonTabContentView;
            this.f13050e = i2;
            this.f13051f = i3;
            this.f13052g = interfaceC1289a;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13050e : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? Integer.valueOf(i2) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) ? this.f13052g.getView(this.f13051f + i2, view, viewGroup) : (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view, int i2, long j);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabContentView(Context context, AttributeSet attributeSet) {
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
        this.f13044g = 0;
        this.f13046i = 0;
        this.j = new a(this);
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.common_tab_content, (ViewGroup) this, true);
            ViewPager viewPager = (ViewPager) findViewById(R.id.privilege_tab_viewpager);
            this.f13042e = viewPager;
            viewPager.setFadingEdgeLength(0);
            this.f13042e.setOnPageChangeListener(this);
            this.f13043f = (IndicatorView) findViewById(R.id.privilege_tab_indicator);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            for (int i3 = 0; i3 < this.f13042e.getChildCount(); i3++) {
                View childAt = this.f13042e.getChildAt(i3);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
            }
        }
    }

    public void e(d.a.r0.w.z.a aVar) {
        GridView gridView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        int f2 = aVar.f();
        if (this.f13042e.getChildCount() > 0 && this.f13044g == f2) {
            for (int i3 = 0; i3 < this.f13042e.getChildCount(); i3++) {
                View childAt = this.f13042e.getChildAt(i3);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
            }
            return;
        }
        this.f13042e.setAdapter(null);
        this.f13044g = f2;
        int c2 = aVar.c();
        int n = aVar.n();
        if (f2 == 0 || c2 == 0 || n == 0) {
            return;
        }
        int i4 = n * c2;
        this.f13046i = i4;
        int i5 = f2 / i4;
        if (f2 % i4 != 0) {
            i5++;
        }
        int i6 = i5;
        if (i6 > 1) {
            this.f13043f.setVisibility(0);
            this.f13043f.setCount(i6);
            this.f13043f.setPosition(0.0f);
        } else {
            this.f13043f.setVisibility(4);
        }
        this.k = aVar.j();
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < i6; i7++) {
            if (aVar.g() == 0) {
                gridView = new GridView(getContext());
                gridView.setVerticalSpacing(aVar.o());
                gridView.setGravity(17);
                gridView.setHorizontalSpacing(aVar.h());
                if (aVar.l() != 0 || aVar.m() != 0) {
                    gridView.setPadding(aVar.l(), 0, aVar.m(), 0);
                }
                gridView.setSelector(R.color.common_color_10022);
                gridView.setSelection(-1);
            } else {
                gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.g(), (ViewGroup) null);
            }
            GridView gridView2 = gridView;
            if (this.k != null) {
                gridView2.setOnItemClickListener(this.j);
            }
            gridView2.setNumColumns(c2);
            int i8 = i6 - 1;
            if (i7 < i8) {
                i2 = this.f13046i;
            } else {
                i2 = f2 - (this.f13046i * i8);
            }
            gridView2.setAdapter((ListAdapter) new b(this, getContext(), i2, i7 * this.f13046i, aVar.p()));
            arrayList.add(gridView2);
        }
        CommonViewPagerAdapter commonViewPagerAdapter = new CommonViewPagerAdapter(this, arrayList);
        this.f13045h = commonViewPagerAdapter;
        this.f13042e.setAdapter(commonViewPagerAdapter);
    }

    public IndicatorView getIndicatorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13043f : (IndicatorView) invokeV.objValue;
    }

    public ViewPager getViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13042e : (ViewPager) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || (indicatorView = this.f13043f) == null) {
            return;
        }
        indicatorView.setPosition(i2 + f2);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabContentView(Context context) {
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
        this.f13044g = 0;
        this.f13046i = 0;
        this.j = new a(this);
        c(context);
    }
}
