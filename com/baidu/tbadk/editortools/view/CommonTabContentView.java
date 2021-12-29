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
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c.a.s0.x.b0.a;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f42472e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f42473f;

    /* renamed from: g  reason: collision with root package name */
    public int f42474g;

    /* renamed from: h  reason: collision with root package name */
    public CommonViewPagerAdapter f42475h;

    /* renamed from: i  reason: collision with root package name */
    public int f42476i;

    /* renamed from: j  reason: collision with root package name */
    public final AdapterView.OnItemClickListener f42477j;

    /* renamed from: k  reason: collision with root package name */
    public c f42478k;

    /* loaded from: classes11.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<View> a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonTabContentView f42479b;

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
            this.f42479b = commonTabContentView;
            this.a = new ArrayList<>();
            this.a = arrayList;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
                viewGroup.removeView(this.a.get(i2));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.size() : invokeV.intValue;
        }

        public int getIndexByView(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
                if (this.a == null) {
                    return -1;
                }
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    if (this.a.get(i2) == view) {
                        return i2;
                    }
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
                View view = this.a.get(i2);
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

    /* loaded from: classes11.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommonTabContentView f42480e;

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
            this.f42480e = commonTabContentView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f42480e.f42478k == null || this.f42480e.f42475h == null) {
                return;
            }
            if (this.f42480e.f42475h.getIndexByView(adapterView) != 0) {
                i2 = -1;
            }
            this.f42480e.f42478k.a(view, i2, j2);
        }
    }

    /* loaded from: classes11.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f42481e;

        /* renamed from: f  reason: collision with root package name */
        public final int f42482f;

        /* renamed from: g  reason: collision with root package name */
        public a.InterfaceC0893a f42483g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CommonTabContentView f42484h;

        public b(CommonTabContentView commonTabContentView, Context context, int i2, int i3, a.InterfaceC0893a interfaceC0893a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabContentView, context, Integer.valueOf(i2), Integer.valueOf(i3), interfaceC0893a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42484h = commonTabContentView;
            this.f42481e = i2;
            this.f42482f = i3;
            this.f42483g = interfaceC0893a;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42481e : invokeV.intValue;
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
            return (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) ? this.f42483g.getView(this.f42482f + i2, view, viewGroup) : (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        void a(View view, int i2, long j2);
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
        this.f42474g = 0;
        this.f42476i = 0;
        this.f42477j = new a(this);
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.common_tab_content, (ViewGroup) this, true);
            ViewPager viewPager = (ViewPager) findViewById(R.id.privilege_tab_viewpager);
            this.f42472e = viewPager;
            viewPager.setFadingEdgeLength(0);
            this.f42472e.setOnPageChangeListener(this);
            this.f42473f = (IndicatorView) findViewById(R.id.privilege_tab_indicator);
        }
    }

    public IndicatorView getIndicatorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42473f : (IndicatorView) invokeV.objValue;
    }

    public ViewPager getViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42472e : (ViewPager) invokeV.objValue;
    }

    public void jumpToItem(int i2, c.a.s0.x.b0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, aVar) == null) || aVar == null || this.f42472e == null) {
            return;
        }
        this.f42472e.setCurrentItem(i2 / (aVar.b() * aVar.k()));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            for (int i3 = 0; i3 < this.f42472e.getChildCount(); i3++) {
                View childAt = this.f42472e.getChildAt(i3);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
            }
        }
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
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || (indicatorView = this.f42473f) == null) {
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

    public void showContent(c.a.s0.x.b0.a aVar) {
        GridView gridView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar == null) {
            return;
        }
        int c2 = aVar.c();
        if (this.f42472e.getChildCount() > 0 && this.f42474g == c2) {
            for (int i3 = 0; i3 < this.f42472e.getChildCount(); i3++) {
                View childAt = this.f42472e.getChildAt(i3);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
            }
            return;
        }
        this.f42472e.setAdapter(null);
        this.f42474g = c2;
        int b2 = aVar.b();
        int k2 = aVar.k();
        if (c2 == 0 || b2 == 0 || k2 == 0) {
            return;
        }
        int i4 = k2 * b2;
        this.f42476i = i4;
        int i5 = c2 / i4;
        if (c2 % i4 != 0) {
            i5++;
        }
        int i6 = i5;
        if (i6 > 1) {
            this.f42473f.setVisibility(0);
            this.f42473f.setCount(i6);
            this.f42473f.setPosition(0.0f);
        } else {
            this.f42473f.setVisibility(4);
        }
        this.f42478k = aVar.g();
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < i6; i7++) {
            if (aVar.d() == 0) {
                gridView = new GridView(getContext());
                gridView.setVerticalSpacing(aVar.l());
                gridView.setGravity(17);
                gridView.setHorizontalSpacing(aVar.e());
                if (aVar.i() != 0 || aVar.j() != 0) {
                    gridView.setPadding(aVar.i(), 0, aVar.j(), 0);
                }
                gridView.setSelector(R.color.common_color_10022);
                gridView.setSelection(-1);
            } else {
                gridView = (GridView) LayoutInflater.from(getContext()).inflate(aVar.d(), (ViewGroup) null);
            }
            GridView gridView2 = gridView;
            if (this.f42478k != null) {
                gridView2.setOnItemClickListener(this.f42477j);
            }
            gridView2.setNumColumns(b2);
            int i8 = i6 - 1;
            if (i7 < i8) {
                i2 = this.f42476i;
            } else {
                i2 = c2 - (this.f42476i * i8);
            }
            gridView2.setAdapter((ListAdapter) new b(this, getContext(), i2, i7 * this.f42476i, aVar.m()));
            arrayList.add(gridView2);
        }
        CommonViewPagerAdapter commonViewPagerAdapter = new CommonViewPagerAdapter(this, arrayList);
        this.f42475h = commonViewPagerAdapter;
        this.f42472e.setAdapter(commonViewPagerAdapter);
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
        this.f42474g = 0;
        this.f42476i = 0;
        this.f42477j = new a(this);
        c(context);
    }
}
