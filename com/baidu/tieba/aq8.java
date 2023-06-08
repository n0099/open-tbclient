package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class aq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListViewPager a;
    public IndicatorView b;
    public ip8 c;
    public TextView d;
    public BdBaseViewPagerAdapter e;
    public rb5 f;
    public boolean g;
    public boolean h;
    public int i;
    public Context j;
    public List<vn> k;
    public ViewPager.OnPageChangeListener l;
    public long m;
    public final Handler.Callback n;
    public final Handler o;
    public ViewPager.OnPageChangeListener p;

    /* loaded from: classes5.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq8 a;

        public a(aq8 aq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq8Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 1 || !this.a.k()) {
                    return false;
                }
                this.a.i();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq8 a;

        public b(aq8 aq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq8Var;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.l != null) {
                    this.a.l.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    this.a.s();
                } else if (i != 0 || (count = this.a.e.getCount()) < 2) {
                } else {
                    int currentItem = this.a.a.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        this.a.a.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        this.a.a.setCurrentItem(1, false);
                    }
                    this.a.r();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && this.a.l != null) {
                this.a.l.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a.f != null && this.a.f.a(i) == i) {
                if (this.a.b != null) {
                    this.a.b.setPosition(this.a.f.c(i));
                    if (this.a.c != null) {
                        this.a.b.setVisibility(8);
                        this.a.c.b(this.a.f.c(i));
                    }
                }
                if (this.a.l != null) {
                    this.a.l.onPageSelected(this.a.f.c(i));
                }
            }
        }
    }

    public aq8(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, listViewPager, indicatorView, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = true;
        this.i = 2;
        this.k = new ArrayList();
        this.m = 5000L;
        this.n = new a(this);
        this.o = new Handler(this.n);
        this.p = new b(this);
        j(context, listViewPager, indicatorView, textView);
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.m = j;
        }
    }

    public void o(ip8 ip8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ip8Var) == null) {
            if (ip8Var != null) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
            }
            this.c = ip8Var;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i = i;
            rb5 rb5Var = this.f;
            if (rb5Var != null) {
                rb5Var.h(i);
            }
        }
    }

    public void q(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPageChangeListener) == null) {
            this.l = onPageChangeListener;
        }
    }

    public final void i() {
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null && this.e != null) {
            p9 c = q9.c(this.j);
            if ((c != null && c.isScroll()) || (count = this.e.getCount()) < 2) {
                return;
            }
            int currentItem = this.a.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.a.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.a.setCurrentItem(1, false);
            } else {
                this.a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, listViewPager, indicatorView, textView) == null) {
            this.a = listViewPager;
            this.b = indicatorView;
            this.d = textView;
            this.j = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.e = bdBaseViewPagerAdapter;
            ListViewPager listViewPager2 = this.a;
            if (listViewPager2 != null) {
                listViewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.a.setOnPageChangeListener(this.p);
            }
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ListViewPager listViewPager = this.a;
            if (listViewPager == null) {
                return false;
            }
            int[] iArr = new int[2];
            listViewPager.getLocationOnScreen(iArr);
            int measuredHeight = iArr[1] + (this.a.getMeasuredHeight() / 2);
            if (measuredHeight <= 0 || measuredHeight >= vi.j(this.j)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void l(Context context, qb5<?, ?> qb5Var) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, context, qb5Var) == null) && (bdBaseViewPagerAdapter = this.e) != null) {
            bdBaseViewPagerAdapter.g(context, qb5Var);
        }
    }

    public void n(List<vn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, list) != null) || ListUtils.getCount(list) == 0) {
            return;
        }
        this.k = list;
        rb5 rb5Var = new rb5(list, this.g, this.i);
        this.f = rb5Var;
        rb5Var.i(2);
        boolean z = true;
        this.f.g(1);
        this.e.h(this.f.e());
        this.e.notifyDataSetChanged();
        this.a.setCurrentItem(this.f.d(), false);
        if (this.f.b() <= 0) {
            return;
        }
        if (this.f.b() > this.i) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setVisibility(0);
                this.d.setOnClickListener(null);
                IndicatorView indicatorView = this.b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.b != null && this.d == null && this.g) {
                z = false;
            }
            if (!z) {
                this.b.setVisibility(8);
                int count = this.b.getCount();
                int i = this.i;
                if (count != i) {
                    this.b.setCount(i);
                }
            }
            r();
        }
        if (this.f.b() >= 2 && this.f.b() <= this.i) {
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.b.getCount() != this.f.b()) {
                    this.b.setCount(this.f.b());
                    ip8 ip8Var = this.c;
                    if (ip8Var != null) {
                        ip8Var.a(this.f.b());
                        this.b.setVisibility(8);
                    }
                } else {
                    ip8 ip8Var2 = this.c;
                    if (ip8Var2 != null) {
                        ip8Var2.a(this.f.b());
                        this.b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f.b() < 2) {
            TextView textView3 = this.d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.b;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(8);
            }
            s();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.h) {
                this.o.removeMessages(1);
                this.o.sendEmptyMessageDelayed(1, this.m);
                return;
            }
            this.o.removeMessages(1);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.removeMessages(1);
        }
    }
}
