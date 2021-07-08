package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.u0.r1.a.d.a;
import d.a.p0.u0.r1.a.d.c;
import d.a.p0.u0.r1.a.d.e;
/* loaded from: classes4.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrsGameStrategyItemListView[] f15669a;

    /* renamed from: b  reason: collision with root package name */
    public int f15670b;

    /* renamed from: c  reason: collision with root package name */
    public Context f15671c;

    /* renamed from: d  reason: collision with root package name */
    public a f15672d;

    /* renamed from: e  reason: collision with root package name */
    public c f15673e;

    /* renamed from: f  reason: collision with root package name */
    public FrsGameStrategyItemListView f15674f;

    /* renamed from: g  reason: collision with root package name */
    public int f15675g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f15676h;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15669a = new FrsGameStrategyItemListView[4];
        this.f15670b = 0;
        this.f15675g = -1;
        this.f15671c = context;
        this.f15672d = aVar;
        this.f15673e = cVar;
    }

    public FrsGameStrategyItemListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15674f : (FrsGameStrategyItemListView) invokeV.objValue;
    }

    public FrsGameStrategyItemListView c(int i2, int i3) {
        InterceptResult invokeII;
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            if (i2 == 0 && i3 == 0) {
                return this.f15669a[0];
            }
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15669a) {
                if (frsGameStrategyItemListView != null && i2 == frsGameStrategyItemListView.getTabId() && i3 == frsGameStrategyItemListView.getLabelId()) {
                    return frsGameStrategyItemListView;
                }
            }
            return null;
        }
        return (FrsGameStrategyItemListView) invokeII.objValue;
    }

    public final FrsGameStrategyItemListView d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f15669a;
            if (i2 >= frsGameStrategyItemListViewArr.length) {
                return null;
            }
            return frsGameStrategyItemListViewArr[i2];
        }
        return (FrsGameStrategyItemListView) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
        }
    }

    public void e(int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15669a) {
                if (frsGameStrategyItemListView != null) {
                    frsGameStrategyItemListView.p(i2);
                }
            }
        }
    }

    public void f() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.f15669a) {
                if (frsGameStrategyItemListView != null) {
                    frsGameStrategyItemListView.q();
                }
            }
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            this.f15670b = i2;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f15670b : invokeV.intValue;
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.f15676h = bdUniqueId;
        }
    }

    public final void i(int i2, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, frsGameStrategyItemListView) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.f15669a;
            if (i2 >= frsGameStrategyItemListViewArr.length) {
                return;
            }
            frsGameStrategyItemListViewArr[i2] = frsGameStrategyItemListView;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i2)) == null) {
            int i3 = i2 % 3;
            FrsGameStrategyItemListView d2 = d(i3);
            if (d2 == null) {
                d2 = new FrsGameStrategyItemListView(this.f15671c, this.f15676h);
                d2.setFrsGameTabDataLoadListener(this.f15672d);
                i(i3, d2);
            } else if (d2 == b()) {
                d2 = d(3);
                if (d2 == null) {
                    d2 = new FrsGameStrategyItemListView(this.f15671c, this.f15676h);
                    d2.setFrsGameTabDataLoadListener(this.f15672d);
                    i(3, d2);
                } else if (d2.getParent() != null) {
                    viewGroup.removeView(d2);
                }
            } else if (d2.getParent() != null) {
                viewGroup.removeView(d2);
            }
            viewGroup.addView(d2);
            c cVar = this.f15673e;
            if (cVar != null && (a2 = cVar.a(i2)) != null) {
                Object obj = a2.f63720c;
                if (obj instanceof LabelDataList) {
                    d2.o(a2.f63718a, ((LabelDataList) obj).getSelectedLabelId());
                }
            }
            return d2;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view, obj)) == null) ? (obj instanceof FrsGameStrategyItemListView) && obj == view : invokeLL.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048588, this, viewGroup, i2, obj) == null) && (obj instanceof FrsGameStrategyItemListView) && this.f15675g != i2) {
            this.f15675g = i2;
            FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
            this.f15674f = frsGameStrategyItemListView;
            frsGameStrategyItemListView.r();
        }
    }
}
