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
import com.baidu.tieba.pk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class CommonTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewPager a;
    public IndicatorView b;
    public int c;
    public CommonViewPagerAdapter d;
    public int e;
    public final AdapterView.OnItemClickListener f;
    public c g;

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view2, int i, long j);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class CommonViewPagerAdapter extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<View> a;
        public final /* synthetic */ CommonTabContentView b;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }

        public CommonViewPagerAdapter(CommonTabContentView commonTabContentView, ArrayList<View> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabContentView, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = commonTabContentView;
            this.a = new ArrayList<>();
            this.a = arrayList;
        }

        public int b(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a == null) {
                    return -1;
                }
                for (int i = 0; i < this.a.size(); i++) {
                    if (this.a.get(i) == view2) {
                        return i;
                    }
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i, obj) == null) {
                viewGroup.removeView(this.a.get(i));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
                View view2 = this.a.get(i);
                viewGroup.addView(view2);
                return view2;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonTabContentView a;

        public a(CommonTabContentView commonTabContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonTabContentView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.g != null && this.a.d != null) {
                if (this.a.d.b(adapterView) != 0) {
                    i = -1;
                }
                this.a.g.a(view2, i, j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final int b;
        public pk5.a c;
        public final /* synthetic */ CommonTabContentView d;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.longValue;
        }

        public b(CommonTabContentView commonTabContentView, Context context, int i, int i2, pk5.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabContentView, context, Integer.valueOf(i), Integer.valueOf(i2), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = commonTabContentView;
            this.a = i;
            this.b = i2;
            this.c = aVar;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return Integer.valueOf(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
                return this.c.getView(this.b + i, view2, viewGroup);
            }
            return (View) invokeILL.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.e = 0;
        this.f = new a(this);
        c(context);
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.common_tab_content, (ViewGroup) this, true);
            ViewPager viewPager = (ViewPager) findViewById(R.id.privilege_tab_viewpager);
            this.a = viewPager;
            viewPager.setFadingEdgeLength(0);
            this.a.setOnPageChangeListener(this);
            this.b = (IndicatorView) findViewById(R.id.privilege_tab_indicator);
        }
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
        this.c = 0;
        this.e = 0;
        this.f = new a(this);
        c(context);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                View childAt = this.a.getChildAt(i2);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
            }
        }
    }

    public void e(pk5 pk5Var) {
        GridView gridView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pk5Var) != null) || pk5Var == null) {
            return;
        }
        int c2 = pk5Var.c();
        if (this.a.getChildCount() > 0 && this.c == c2) {
            for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                View childAt = this.a.getChildAt(i2);
                if (childAt instanceof GridView) {
                    ((BaseAdapter) ((GridView) childAt).getAdapter()).notifyDataSetChanged();
                }
            }
            return;
        }
        this.a.setAdapter(null);
        this.c = c2;
        int b2 = pk5Var.b();
        int k = pk5Var.k();
        if (c2 != 0 && b2 != 0 && k != 0) {
            int i3 = k * b2;
            this.e = i3;
            int i4 = c2 / i3;
            if (c2 % i3 != 0) {
                i4++;
            }
            int i5 = i4;
            if (i5 > 1) {
                this.b.setVisibility(0);
                this.b.setCount(i5);
                this.b.setPosition(0.0f);
            } else {
                this.b.setVisibility(4);
            }
            this.g = pk5Var.g();
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < i5; i6++) {
                if (pk5Var.d() == 0) {
                    gridView = new GridView(getContext());
                    gridView.setVerticalSpacing(pk5Var.l());
                    gridView.setGravity(17);
                    gridView.setHorizontalSpacing(pk5Var.e());
                    if (pk5Var.i() != 0 || pk5Var.j() != 0) {
                        gridView.setPadding(pk5Var.i(), 0, pk5Var.j(), 0);
                    }
                    gridView.setSelector(R.color.common_color_10022);
                    gridView.setSelection(-1);
                } else {
                    gridView = (GridView) LayoutInflater.from(getContext()).inflate(pk5Var.d(), (ViewGroup) null);
                }
                GridView gridView2 = gridView;
                if (this.g != null) {
                    gridView2.setOnItemClickListener(this.f);
                }
                gridView2.setNumColumns(b2);
                int i7 = i5 - 1;
                if (i6 < i7) {
                    i = this.e;
                } else {
                    i = c2 - (this.e * i7);
                }
                gridView2.setAdapter((ListAdapter) new b(this, getContext(), i, i6 * this.e, pk5Var.m()));
                arrayList.add(gridView2);
            }
            CommonViewPagerAdapter commonViewPagerAdapter = new CommonViewPagerAdapter(this, arrayList);
            this.d = commonViewPagerAdapter;
            this.a.setAdapter(commonViewPagerAdapter);
        }
    }

    public IndicatorView getIndicatorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (IndicatorView) invokeV.objValue;
    }

    public ViewPager getViewPager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (ViewPager) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && (indicatorView = this.b) != null) {
            indicatorView.setPosition(i + f);
        }
    }
}
