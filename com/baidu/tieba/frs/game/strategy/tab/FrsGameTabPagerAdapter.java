package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.p0.f1.u1.a.d.a;
import c.a.p0.f1.u1.a.d.c;
import c.a.p0.f1.u1.a.d.e;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsGameStrategyItemListView[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f32527b;

    /* renamed from: c  reason: collision with root package name */
    public Context f32528c;

    /* renamed from: d  reason: collision with root package name */
    public a f32529d;

    /* renamed from: e  reason: collision with root package name */
    public c f32530e;

    /* renamed from: f  reason: collision with root package name */
    public FrsGameStrategyItemListView f32531f;

    /* renamed from: g  reason: collision with root package name */
    public int f32532g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f32533h;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new FrsGameStrategyItemListView[4];
        this.f32527b = 0;
        this.f32532g = -1;
        this.f32528c = context;
        this.f32529d = aVar;
        this.f32530e = cVar;
    }

    public FrsGameStrategyItemListView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32531f : (FrsGameStrategyItemListView) invokeV.objValue;
    }

    public FrsGameStrategyItemListView c(int i, int i2) {
        InterceptResult invokeII;
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            if (i == 0 && i2 == 0) {
                return this.a[0];
            }
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.a) {
                if (frsGameStrategyItemListView != null && i == frsGameStrategyItemListView.getTabId() && i2 == frsGameStrategyItemListView.getLabelId()) {
                    return frsGameStrategyItemListView;
                }
            }
            return null;
        }
        return (FrsGameStrategyItemListView) invokeII.objValue;
    }

    public final FrsGameStrategyItemListView d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.a;
            if (i >= frsGameStrategyItemListViewArr.length) {
                return null;
            }
            return frsGameStrategyItemListViewArr[i];
        }
        return (FrsGameStrategyItemListView) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i, obj) == null) {
        }
    }

    public void e(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.a) {
                if (frsGameStrategyItemListView != null) {
                    frsGameStrategyItemListView.p(i);
                }
            }
        }
    }

    public void f() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.a) {
                if (frsGameStrategyItemListView != null) {
                    frsGameStrategyItemListView.q();
                }
            }
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            this.f32527b = i;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f32527b : invokeV.intValue;
    }

    public void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.f32533h = bdUniqueId;
        }
    }

    public final void i(int i, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, frsGameStrategyItemListView) == null) {
            FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr = this.a;
            if (i >= frsGameStrategyItemListViewArr.length) {
                return;
            }
            frsGameStrategyItemListViewArr[i] = frsGameStrategyItemListView;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        e a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i)) == null) {
            int i2 = i % 3;
            FrsGameStrategyItemListView d2 = d(i2);
            if (d2 == null) {
                d2 = new FrsGameStrategyItemListView(this.f32528c, this.f32533h);
                d2.setFrsGameTabDataLoadListener(this.f32529d);
                i(i2, d2);
            } else if (d2 == b()) {
                d2 = d(3);
                if (d2 == null) {
                    d2 = new FrsGameStrategyItemListView(this.f32528c, this.f32533h);
                    d2.setFrsGameTabDataLoadListener(this.f32529d);
                    i(3, d2);
                } else if (d2.getParent() != null) {
                    viewGroup.removeView(d2);
                }
            } else if (d2.getParent() != null) {
                viewGroup.removeView(d2);
            }
            viewGroup.addView(d2);
            c cVar = this.f32530e;
            if (cVar != null && (a = cVar.a(i)) != null) {
                Object obj = a.f14714c;
                if (obj instanceof LabelDataList) {
                    d2.o(a.a, ((LabelDataList) obj).getSelectedLabelId());
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
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048588, this, viewGroup, i, obj) == null) && (obj instanceof FrsGameStrategyItemListView) && this.f32532g != i) {
            this.f32532g = i;
            FrsGameStrategyItemListView frsGameStrategyItemListView = (FrsGameStrategyItemListView) obj;
            this.f32531f = frsGameStrategyItemListView;
            frsGameStrategyItemListView.r();
        }
    }
}
